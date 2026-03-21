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

    static void generateWireBondingRecipe(String input, String product, int duration, int voltageTier) {
        // smth goes here
    }

}
