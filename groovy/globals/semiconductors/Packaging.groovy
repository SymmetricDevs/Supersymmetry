package globals.semiconductors
import globals.Globals

import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

import gregtech.api.metatileentity.multiblock.CleanroomType 

class Packaging {

    static void generateDicingRecipe(String input, String product, int outputMultiplier, int duration, int voltageTier) {
        CUTTER.recipeBuilder()
            .inputs(metaitem(input))
            .fluidInputs(fluid('ultrapure_water') * 100)
            .outputs(metaitem(product) * outputMultiplier)
            .cleanroom(CleanroomType.CLEANROOM)
            .duration(duration)
            .EUt(VA[voltageTier])
            .buildAndRegister();
    }

    static void generateWireBondingRecipe(String input, String product, String wireMaterial, int duration, int voltageTier) {
        def builder = WIRE_BONDING.recipeBuilder()
            .inputs(metaitem(input))
            .inputs(metaitem("wireFine" + wireMaterial.substring(0,1).toUpperCase() + wireMaterial.substring(1))) // ok i guess
        if (wireMaterial != "gold") {
            builder.fluidInputs(fluid('nitrogen') * 50)
        }
        builder.outputs(metaitem(product))
            .duration(duration)
            .EUt(VA[voltageTier])
            .buildAndRegister();
    }

    static void generateBackgrindingRecipe(String input, String product, int duration, int voltageTier) {
        POLISHING_MACHINE.recipeBuilder()
            .inputs(metaitem(input))
            .fluidInputs(fluid('ultrapure_water') * 100)
            .outputs(metaitem(product))
            .fluidOutputs(fluid('basic_cmp_slurry') * 100)
            .duration(duration)
            .EUt(VA[voltageTier])
            .buildAndRegister()
    }
}
