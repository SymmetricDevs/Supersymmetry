import static prePostInit.Recipemaps.*
import classes.*
import static gregtech.api.GTValues.*
import gregtech.api.metatileentity.multiblock.CleanroomType

import globals.Globals
import globals.semiconductors.Lithography
import globals.semiconductors.Etching
import globals.semiconductors.Deposition
import globals.semiconductors.Packaging
import globals.semiconductors.Doping
import globals.semiconductors.Mechanicals

def generateMonoSolarPanelFabrication(String componentName, int circ) {
    Packaging.generateDicingRecipe('wafer.silicon.p_doped', 'wafer.' + componentName + '.step_one', 1, 80, MV)
    Doping.generateIonImplantationRecipes('wafer.' + componentName + '.step_one', 'wafer.' + componentName + '.step_two', 40, 'arsine')
    Doping.generateIonImplantationRecipes('wafer.' + componentName + '.step_two', 'wafer.' + componentName + '.step_three', 40, 'boron_trifluoride')
    Deposition.generateChemicalVaporDepositionRecipe('wafer.' + componentName + '.step_three', 'wafer.' + componentName + '.step_four', 1.0, 'silicon_nitride.silane')
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_four', 'wafer.' + componentName + '.step_five',
            'novolac_resist', 'mask_set.' + componentName, true)
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_five', 'wafer.' + componentName + '.step_six', 0.1, false)
    Deposition.generateSputteringRecipe('wafer.' + componentName + '.step_six', 'wafer.' + componentName + '.step_seven', ['aluminium' : 30, 'titanium' : 30])
    Doping.generateDriveInRecipe('wafer.' + componentName + '.step_seven', 'wafer.' + componentName + '.step_eight', 60)

    ASSEMBLER.recipeBuilder()
        .inputs(metaitem('wafer.' + componentName + '.step_eight'))
        .inputs(metaitem('plateGlass'))
        .inputs(metaitem('foilAluminium'))
        .inputs(metaitem('foilPlastic'))
        .outputs(metaitem('wafer.' + componentName + '.step_nine'))
        .duration(45)
        .EUt(480)
        .buildAndRegister()
}
generateMonoSolarPanelFabrication('monosilicon_solar_panel', 1)