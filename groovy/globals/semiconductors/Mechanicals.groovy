package globals.semiconductors
import globals.Globals

import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

import gregtech.api.metatileentity.multiblock.CleanroomType 

class Mechanicals {

    // Assumes Si substrate, FIXME: If other substrates are used, the CMP slurry may need to be customizable.
    static void generateBackgrindingRecipe(String input, String product, int duration, int voltageTier) {
        POLISHING_MACHINE.recipeBuilder()
            .inputs(metaitem(input))
            .fluidOutputs(fluid('basic_cmp_slurry') * 100)
            .outputs(metaitem(product))
            .cleanroom(CleanroomType.CLEANROOM)
            .duration(duration)
            .EUt(VA[voltageTier])
            .buildAndRegister();
    }

    static void generateChemicalMechanicalPolishingRecipe(String input, String product, String slurry, int duration, int voltageTier) {
        POLISHING_MACHINE.recipeBuilder()
            .inputs(metaitem(input))
            .fluidInputs(fluid(slurry) * 200)
            .outputs(metaitem(product))
            .fluidOutputs(fluid('wastewater') * 200)
            .cleanroom(CleanroomType.CLEANROOM)
            .duration(duration)
            .EUt(VA[voltageTier])
            .buildAndRegister();
    }

}    
