package globals.semiconductors
import globals.Globals

import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

import gregtech.api.metatileentity.multiblock.CleanroomType 

class Mechanicals {

    static void generateBackgrindingRecipe(String input, String product, int duration, int voltageTier) {
        POLISHING_MACHINE.recipeBuilder()
            .inputs(metaitem(input))
            .outputs(metaitem(product))
            .cleanroom(CleanroomType.CLEANROOM)
            .duration(duration)
            .EUt(VA[voltageTier])
            .buildAndRegister();
    }

    static void generateChemicalMechanicalPolishingRecipe(String input, String product, int duration, int voltageTier) {
        POLISHING_MACHINE.recipeBuilder()
            .inputs(metaitem(input))
            .fluidInputs(fluid('silicon_dioxide_slurry') * 200)
            .outputs(metaitem(product))
            .fluidOutputs(fluid('wastewater') * 200)
            .cleanroom(CleanroomType.CLEANROOM)
            .duration(duration)
            .EUt(VA[voltageTier])
            .buildAndRegister();
    }

}    
