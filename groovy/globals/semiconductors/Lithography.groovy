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
        boolean liftoff
        String topcoat
        String barc

        Resist(String resistName, String solventName, String developerName, int voltageTier, String exposureRecipeMap, int timeUsed, boolean liftoff = false, String topcoat = null, String barc = null) {
            this.resistName = resistName
            this.solventName = solventName
            this.developerName = developerName
            this.voltageTier = voltageTier
            this.exposureRecipeMap = exposureRecipeMap
            this.timeUsed = timeUsed
            this.liftoff = liftoff
            this.topcoat = topcoat
            this.barc = barc
        }

        def generateCoatingRecipe(String input, boolean hmds, Integer circuit = null) {
            def solvent_amount = 100 + (this.topcoat ? 20 : 0) + (this.barc ? 50 : 0)
            
            def coatingRecipe = RESIST_PROCESSOR.recipeBuilder()
                .inputs(metaitem(input))
                .fluidInputs(fluid(this.resistName) * 50)
                .fluidInputs(fluid(this.solventName) * solvent_amount)
                .outputs(metaitem(input + ".coated"))
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(this.timeUsed)
                .EUt(VA[this.voltageTier])

            if (circuit != null) {coatingRecipe.circuitMeta(circuit)}
            if (hmds) {coatingRecipe.fluidInputs(fluid('hexamethyldisilazane') * 10)}
            if (this.topcoat) {coatingRecipe.fluidInputs(fluid(this.topcoat) * 10)}
            if (this.barc) {coatingRecipe.fluidInputs(fluid(this.barc) * 25)}
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
            exposureRecipe.buildAndRegister();
        }

        def generateDevelopmentRecipe(String input, String product) {
            if (!liftoff) {
                RESIST_PROCESSOR.recipeBuilder()
                    .inputs(metaitem(input + ".exposed"))
                    .fluidInputs(fluid(this.developerName) * 100)
                    .outputs(metaitem(product))
                    .cleanroom(CleanroomType.CLEANROOM)
                    .duration(this.timeUsed)
                    .EUt(VA[this.voltageTier])
                    .buildAndRegister()
            } else {
                RESIST_PROCESSOR.recipeBuilder()
                    .inputs(metaitem(input + ".deposited"))
                    .fluidInputs(fluid(this.developerName) * 100)
                    .outputs(metaitem(product))
                    .cleanroom(CleanroomType.CLEANROOM)
                    .duration(this.timeUsed)
                    .EUt(VA[this.voltageTier])
                    .buildAndRegister()
            }
        }
    }

    public static final photoresists = [
        new Resist("novolac_resist", "ebr_solvent", "tetramethylammonium_hydroxide_solution", HV, "uv_light_box", 300),
        new Resist("novolac_liftoff_resist", "ebr_solvent", "tetramethylammonium_hydroxide_solution", HV, "uv_light_box", 300, true),
        new Resist("su_eight", "propylene_glycol_methyl_ether_acetate", "propylene_glycol_methyl_ether_acetate", EV, "uv_light_box", 200),
        new Resist("polyhydroxystyrene_resist", "ebr_solvent", "tetramethylammonium_hydroxide_solution", EV, "laser_engraver", 200, false, null, "krf_barc"),
        new Resist("methacrylate_resist", "ebr_solvent", "tetramethylammonium_hydroxide_solution", EV, "laser_engraver", 300, false, "arf_topcoat", "arf_barc")
    ]

    public static final electronBeamResists = [
        new Resist("hydrogen_silsesquioxane_photoresist", "tetramethylammonium_hydroxide_solution", "n_methyl_pyrrolidone", EV, "electron_beam_lithography", 1000)
    ]

    static void generatePhotolithographyRecipes(String input, String product, String photoresistNeeded, String nonConsumable, boolean hmds, boolean ibarc = false) {
        for (photoresist in photoresists) {
            if (photoresist.resistName == photoresistNeeded) {
                if (ibarc) {
                    Deposition.generateChemicalVaporDepositionRecipe(input, input + ".ibarc", 0.25, "silicon_oxynitride")
                    input = input + ".ibarc"
                }

                photoresist.generateCoatingRecipe(input, hmds)
                photoresist.generateExposureRecipe(input, nonConsumable)
                photoresist.generateDevelopmentRecipe(input, product)
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

    static void generateCoatingRecipe(String input, String photoresistNeeded, boolean hmds, boolean ibarc = false) {
        for (photoresist in photoresists) {
            if (photoresist.resistName == photoresistNeeded) {
                if (ibarc) {
                    Deposition.generateChemicalVaporDepositionRecipe(input, input + ".ibarc", 0.25, "silicon_oxynitride")
                    input = input + ".ibarc"
                }

                photoresist.generateCoatingRecipe(input, hmds)
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

    static void generateResistStrippingRecipes(String input, String product, int timeMultiplier, boolean rie, boolean solvent = false) {
        if (solvent) {
            RESIST_PROCESSOR.recipeBuilder()
                .inputs(metaitem(input))
                .fluidInputs(fluid('n_methyl_two_pyrrolidone') * 100)
                .outputs(metaitem(product))
                .duration(400 * timeMultiplier)
                .EUt(VA[HV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister()
        }

        def ashed = "";
        def tmp_builder = PLASMA_ASHER.recipeBuilder()
            .inputs(metaitem(input))
            .fluidInputs(fluid('oxygen') * 100)
        if (rie) {
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

        if (rie && !solvent) {
            RESIST_PROCESSOR.recipeBuilder()
                .inputs(metaitem(ashed))
                .fluidInputs(fluid('ultrapure_water') * 100)
                .outputs(metaitem(product))
                .duration(400 * timeMultiplier)
                .EUt(VA[HV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister()
        }
    }
}
