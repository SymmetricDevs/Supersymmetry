package globals.semiconductors
import globals.Globals

import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

import gregtech.api.metatileentity.multiblock.CleanroomType

class Lithography {

    public static class Resist {
        String resistName
        String solventName
        String developerName
        int voltageTier
        String exposureRecipeMap
        int timeUsed
        Map additionalFluids
        boolean liftoff
        boolean ibarc

        Resist(String resistName, String solventName, String developerName, int voltageTier, String exposureRecipeMap, int timeUsed, Map additionalFluids = [:], boolean liftoff = false, boolean ibarc = false) {
            this.resistName = resistName
            this.solventName = solventName
            this.developerName = developerName
            this.voltageTier = voltageTier
            this.exposureRecipeMap = exposureRecipeMap
            this.timeUsed = timeUsed
            this.liftoff = liftoff
            this.additionalFluids = additionalFluids
            this.ibarc = ibarc
        }

        def generateCoatingRecipe(String input, boolean hmds, Integer circuit = null, String overrideInput = null) {
            def solvent_amount = 100
            if (additionalFluids.size() != 0) { solvent_amount += ((this.additionalFluids.values().sum()) * 2) }
            
            def coatingRecipe = RESIST_PROCESSOR.recipeBuilder()
                .inputs(metaitem(overrideInput ?: input))
                .fluidInputs(fluid(this.resistName) * 50)
                .fluidInputs(fluid(this.solventName) * solvent_amount)
                .outputs(metaitem(input + ".coated"))
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(this.timeUsed)
                .EUt(VA[this.voltageTier])

            if (circuit != null) {coatingRecipe.circuitMeta(circuit)}
            if (hmds) {coatingRecipe.fluidInputs(fluid('hexamethyldisilazane') * 10)}
            for (entry : this.additionalFluids.entrySet()) {
                coatingRecipe.fluidInputs(fluid(entry.getKey()) * entry.getValue())
            }
            coatingRecipe.buildAndRegister()
        }
        
        def generateExposureRecipe(String input, String nonConsumable = null) {
            def exposureRecipe = recipemap(exposureRecipeMap).recipeBuilder()
                .inputs(metaitem(input + ".coated"))
                .outputs(metaitem(input + ".exposed"))
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(this.timeUsed)
                .EUt(VA[this.voltageTier])

            if (nonConsumable != null) {exposureRecipe.notConsumable(metaitem(nonConsumable))}
            if (this.resistName.contains("methacrylate")) {exposureRecipe.fluidInputs(fluid('ultrapure_water') * 5)}
            exposureRecipe.buildAndRegister();
        }

        def generateDevelopmentRecipe(String input, String product, String overrideProduct = null) {
            RESIST_PROCESSOR.recipeBuilder()
            .inputs(metaitem(input + (liftoff ? ".deposited" : ".exposed")))
            .fluidInputs(fluid(this.developerName) * 100)
            .outputs(metaitem(overrideProduct ?: product))
            .cleanroom(CleanroomType.CLEANROOM)
            .duration(this.timeUsed)
            .EUt(VA[this.voltageTier])
            .buildAndRegister()
        }
    }

    public static final photoresists = [
        new Resist("novolac_resist", "ebr_solvent", "tetramethylammonium_hydroxide_solution", HV, "uv_light_box", 300),
        new Resist("novolac_liftoff_resist", "ebr_solvent", "tetramethylammonium_hydroxide_solution", HV, "uv_light_box", 300, [:], true),
        new Resist("su_eight", "propylene_glycol_methyl_ether_acetate", "propylene_glycol_methyl_ether_acetate", EV, "uv_light_box", 200),
        new Resist("polyhydroxystyrene_resist", "ebr_solvent", "tetramethylammonium_hydroxide_solution", EV, "laser_engraver", 200, ["krf_barc" : 25]),
        new Resist("polyhydroxystyrene_resist_trilayer", "ebr_solvent", "tetramethylammonium_hydroxide_solution", EV, "laser_engraver", 200, [:], false, true),
        new Resist("methacrylate_resist", "ebr_solvent", "tetramethylammonium_hydroxide_solution", EV, "laser_engraver", 300, ["arf_topcoat" : 10, "arf_barc" : 25]),
        new Resist("methacrylate_resist_trilayer", "ebr_solvent", "tetramethylammonium_hydroxide_solution", EV, "laser_engraver", 300, ["arf_topcoat" : 10], false, true)
        // Trilayers should be used for highly reflective substrates, i.e. metal as organic BARCs will no longer be sufficient to minimize internal reflection of patterning light,
        // which cause poor resolution. It is also useful for very high aspect ratio patterning where the addition of a SOC hardmask allows good etching selectivity.
        // The hardmask also is useful for patterning on substrates with severe topography and critical dimension uniformity.
    ]

    public static final electronBeamResists = [
        new Resist("hydrogen_silsesquioxane_photoresist", "tetramethylammonium_hydroxide_solution", "n_methyl_two_pyrrolidone", EV, "electron_beam_lithography", 1000)
    ]

    static void generatePhotolithographyRecipes(String input, String product, String photoresistNeeded, String nonConsumable, boolean hmds, boolean mandrel = false) {
        def overrideInput = null
        for (photoresist in photoresists) {
            if (photoresist.resistName == photoresistNeeded) {
                if (photoresist.ibarc) {
                    RESIST_PROCESSOR.recipeBuilder()
                        .inputs(metaitem(input))
                        .fluidInputs(fluid("spin_on_carbon") * 100)
                        .fluidInputs(fluid("ebr_solvent") * 200)
                        .outputs(metaitem(input + ".hardmasked"))
                        .cleanroom(CleanroomType.CLEANROOM)
                        .duration(photoresist.timeUsed)
                        .EUt(VA[photoresist.voltageTier])
                        .buildAndRegister()

                    Deposition.generateChemicalVaporDepositionRecipe(input + ".hardmasked", input + ".ibarc", 0.25, "silicon_oxynitride")
                    Etching.generateReactiveIonEtchingRecipe(input + ".developed", input + ".etched", "silicon_oxynitride", 100)
                    Etching.generateReactiveIonEtchingRecipe(input + ".etched", product, "spin_on_carbon", 200)

                    if (mandrel) {
                        Deposition.generateChemicalVaporDepositionRecipe(input + ".ibarc", input + ".mandrel", 0.25, "silicon")
                    }

                    overrideInput = mandrel ? input + ".mandrel" : input + ".ibarc"
                }

                if (photoresist.ibarc) hmds = true; // SiON surfaces are hydrophilic, so HMDS is needed for photoresist adherence.

                // HMDS should be used for application of positive tone resists to hydrophilic surfaces, particularly with exposed silanols,
                // i.e. SiO2, Si3N4, bare Si, surfaces after CMP. HMDS is not used on metals, over organic BARCs, negative tone resists, SiOCH.
                photoresist.generateCoatingRecipe(input, hmds, null, overrideInput)
                photoresist.generateExposureRecipe(input, nonConsumable)
                photoresist.generateDevelopmentRecipe(input, product, (photoresist.ibarc ? input + ".developed" : null))
            }
        }
    }

    static void generateSplitPhotolithographyRecipes(String input, String intermediate, String product, String photoresistNeeded, String nonConsumable, boolean hmds) {
        for (photoresist in photoresists) {
            if (photoresist.resistName == photoresistNeeded) {
                def exposureRecipe = recipemap(photoresist.exposureRecipeMap).recipeBuilder()
                .inputs(metaitem(input + ".coated"))
                .outputs(metaitem(intermediate + ".exposed"))
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(photoresist.timeUsed)
                .EUt(VA[photoresist.voltageTier])

                if (nonConsumable != null) {exposureRecipe.notConsumable(metaitem(nonConsumable))}
                exposureRecipe.buildAndRegister();

                photoresist.generateDevelopmentRecipe(intermediate, product)
            }
        }
    }

    static void generateCoatingRecipe(String input, String photoresistNeeded, boolean hmds, boolean mandrel = false) {
        def overrideInput = null
        for (photoresist in photoresists) {
            if (photoresist.resistName == photoresistNeeded) {
                if (photoresist.ibarc) {
                    RESIST_PROCESSOR.recipeBuilder()
                        .inputs(metaitem(input))
                        .fluidInputs(fluid("spin_on_carbon") * 100)
                        .fluidInputs(fluid("ebr_solvent") * 200)
                        .outputs(metaitem(input + ".hardmasked"))
                        .cleanroom(CleanroomType.CLEANROOM)
                        .duration(photoresist.timeUsed)
                        .EUt(VA[photoresist.voltageTier])
                        .buildAndRegister()

                    Deposition.generateChemicalVaporDepositionRecipe(input + ".hardmasked", input + ".ibarc", 0.25, "silicon_oxynitride")

                    if (mandrel) {
                        Deposition.generateChemicalVaporDepositionRecipe(input + ".ibarc", input + ".mandrel", 0.25, "silicon")
                    }

                    overrideInput = mandrel ? input + ".mandrel" : input + ".ibarc"

                }

                if (photoresist.ibarc) hmds = true; // SiON surfaces are hydrophilic, so HMDS is needed for photoresist adherence.

                photoresist.generateCoatingRecipe(input, hmds, null, overrideInput)
            }
        }
    }

    static void generateElectronBeamLithographyRecipes(String input, String product, String resistNeeded, Integer circ = null) {
        for (resist in electronBeamResists) {
            if (resist.resistName == resistNeeded) {
                resist.generateCoatingRecipe(input, false, circ)
                resist.generateExposureRecipe(input)
                resist.generateDevelopmentRecipe(input, product)
            }
        }
    }

    static void generateResistStrippingRecipes(String input, String product, int timeMultiplier, boolean bombarded, boolean solvent = false) {
        if (solvent && !bombarded) {
            RESIST_PROCESSOR.recipeBuilder()
                .inputs(metaitem(input))
                .fluidInputs(fluid('n_methyl_two_pyrrolidone') * 100)
                .outputs(metaitem(product))
                .duration((int) (400 * timeMultiplier))
                .EUt(VA[HV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister()
        }

        def ashed = "";
        def tmp_builder = PLASMA_ASHER.recipeBuilder()
            .inputs(metaitem(input))
            .fluidInputs(fluid('oxygen') * 100)
        if (bombarded) {
            tmp_builder = tmp_builder.fluidInputs(fluid('carbon_tetrafluoride') * 25);
            ashed = input + '.ashed'
        } else {
            ashed = product
        }

        tmp_builder.outputs(metaitem(ashed))
            .duration(200 * timeMultiplier)
            .EUt(VA[HV])
            .cleanroom(CleanroomType.CLEANROOM)
            .buildAndRegister()

        if (bombarded && !solvent) {
            RESIST_PROCESSOR.recipeBuilder()
                .inputs(metaitem(ashed))
                .fluidInputs(fluid('ultrapure_water') * 100)
                .outputs(metaitem(product))
                .duration(400 * timeMultiplier)
                .EUt(VA[HV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister()
        } else if (bombarded && solvent) {
            RESIST_PROCESSOR.recipeBuilder()
                .inputs(metaitem(ashed))
                .fluidInputs(fluid('n_methyl_two_pyrrolidone') * 100)
                .outputs(metaitem(product))
                .duration(400 * timeMultiplier)
                .EUt(VA[HV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister()
        }
    }

    static void generateSOCStrippingRecipes(String input, String product, int timeMultiplier, boolean wetClear = false) {
        // Forming-gas (reducing) ash strips the spin-on-carbon hardmask without the carbon depletion an O2 ash
        // would inflict on carbon-doped low-k dielectric.
        PLASMA_ASHER.recipeBuilder()
            .inputs(metaitem(input))
            .fluidInputs(fluid('forming_gas') * 100)
            .outputs(metaitem(input + ".ashed"))
            .duration(200 * timeMultiplier)
            .EUt(VA[HV])
            .cleanroom(CleanroomType.CLEANROOM)
            .buildAndRegister()

        if (wetClear) {
            // Wet HF clears the SiON interlayer but also etches SiOCH, so it is only safe over non-low-k
            // substrates (e.g. FEOL over silicon dioxide).
            RESIST_PROCESSOR.recipeBuilder()
                .inputs(metaitem(input + ".ashed"))
                .fluidInputs(fluid('ultrapure_hydrofluoric_acid') * 5)
                .fluidInputs(fluid('ultrapure_water') * 95)
                .outputs(metaitem(product))
                .duration(400 * timeMultiplier)
                .EUt(VA[HV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister()
        } else {
            // Over low-k, take the SiON off with an anisotropic dry etch instead: it removes the cap with far
            // less attack on the exposed SiOCH sidewalls than an isotropic HF bath would.
            Etching.generateReactiveIonEtchingRecipe(input + ".ashed", product, 'silicon_oxynitride', 100 * timeMultiplier)
        }
    }
}