package globals
import globals.Globals

import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

import gregtech.api.metatileentity.multiblock.CleanroomType

class Lithography {

    public static class Resist {
        String resistName
        String solventName
        String developerName
        String voltageTier
        String exposureRecipeMap
        int timeUsed

        Resist(String resistName, String ebrName, String developerName, String solventName, String voltageTier, String exposureRecipeMap, int timeUsed, boolean liftoff = false) {
            this.resistName = resistName
            this.solventName = solventName
            this.developerName = developerName
            this.voltageTier = voltageTier
            this.exposureRecipeMap = exposureRecipeMap
            this.timeUsed = timeUsed
            this.liftoff = liftoff
        }

        def generateCoatingRecipe(String input, boolean hmds = false, int circuit = null) {
            def coatingRecipe = RESIST_PROCESSOR.recipeBuilder()
                .inputs(metaitem(input))
                .fluidInputs(fluid(this.resistName) * 50)
                .fluidInputs(fluid(this.ebrName) * 100)
                .outputs(metaitem(input + ".coated"))
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(this.timeUsed)
                .EUt(VA[this.voltageTier])

            if (circ != null) {coatingRecipe.circuitMeta(circ)}
            if (hmds) {coatingRecipe.fluidInputs(fluid('hexamethyldisilazane') * 10)}
            coatingRecipe.buildAndRegister()
        }
        
        def generateExposureRecipe(String input, String nonConsumable = null) {
            def exposureRecipe = exposureRecipeMap.recipeBuilder()
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
                    .EUt(VA[this.voltageTier]);
                    .buildAndRegister()
            }
        }
    }

    public static final photoresists = [
        new Photoresist("novolac_resist", "novolac_ebr_solvent", "tetramethylammonium_hydroxide_solution", "HV", recipemap("UV_LIGHT_BOX"), 300),
        new Photoresist("novolac_liftoff_resist", "novolac_ebr_solvent", "tetramethylammonium_hydroxide_solution", "HV", recipemap("UV_LIGHT_BOX"), 300, true),
        new Photoresist("su_eight", "propylene_glycol_methyl_ether_acetate", "propylene_glycol_methyl_ether_acetate", "EV", recipemap("LASER_ENGRAVER"), 200)
    ]

    public static final electronBeamResists = [
        new Photoresist("hydrogen_silsesquioxane_photoresist", "tetramethylammonium_hydroxide_solution", "n_methyl_pyrrolidone", "EV", recipemap("ELECTRON_BEAM_LITHOGRAPHY"), 1000)
    ]

    static void generatePhotolithographyRecipes(String input, String product, String photoresistNeeded, String nonConsumable, boolean hmds, int circ = null) {
        for (photoresist in photoresists) {
            if (photoresist.resistName == photoresistNeeded) {
                photoresist.generateCoatingRecipe(input, hmds, circ)
                photoresist.generateExposureRecipe(input, nonConsumable)
                photoresist.generateDevelopmentRecipe(input, product)
            }
        }
    }

    static void generateElectronBeamLithographyRecipes(String input, String product, String resistNeeded, int circ = null) {
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
                .outputs(metaitem(input + '.stripped'))
                .duration(400 * timeMultiplier)
                .EUt(VA[HV]);
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister()

            input = input + '.stripped'
        }

        PLASMA_ASHER.recipeBuilder()
            .inputs(metaitem(input))
            .fluidInputs(fluid('oxygen') * 100)
            if (rie) {fluidInputs(fluid('carbon_tetrafluoride') * 25); ashed = input + '.ashed'} else {ashed = product}
            .outputs(metaitem(ashed))
            .duration(200 * timeMultiplier)
            .EUt(VA[HV]);
            .cleanroom(CleanroomType.CLEANROOM)
            .buildAndRegister()

        if (rie) {
            RESIST_PROCESSOR.recipeBuilder()
                .inputs(metaitem(ashed))
                .fluidInputs(fluid('ultrapure_water') * 100)
                .outputs(metaitem(product))
                .duration(400 * timeMultiplier)
                .EUt(VA[HV]);
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister()
    }
}
