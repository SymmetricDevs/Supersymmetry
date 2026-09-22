import static prePostInit.Recipemaps.*
import classes.*
import static gregtech.api.GTValues.*

import globals.semiconductors.Lithography
import globals.semiconductors.Etching
import globals.semiconductors.Deposition
import globals.semiconductors.Packaging
import globals.semiconductors.Doping
import globals.semiconductors.Mechanicals

Doping.generateIonImplantationRecipes('wafer.silicon.p_doped', 'wafer.monosilicon_photovoltaic.step_one', 100, 'arsine')
Doping.generateIonImplantationRecipes('wafer.monosilicon_photovoltaic.step_one', 'wafer.monosilicon_photovoltaic.step_two', 100, 'boron_trifluoride')
Doping.generateDriveInRecipe('wafer.monosilicon_photovoltaic.step_two', 'wafer.monosilicon_photovoltaic.step_three', 200)
Deposition.generateChemicalVaporDepositionRecipe('wafer.monosilicon_photovoltaic.step_three', 'wafer.monosilicon_photovoltaic.step_four', 1.0, 'silicon_nitride.silane')
Lithography.generatePhotolithographyRecipes('wafer.monosilicon_photovoltaic.step_four', 'wafer.monosilicon_photovoltaic.step_five', 'novolac_resist', 'mask.monosilicon_photovoltaic', true)
Lithography.generateResistStrippingRecipes('wafer.monosilicon_photovoltaic.step_five', 'wafer.monosilicon_photovoltaic.step_six', 1, false)
Deposition.generateSputteringRecipe('wafer.monosilicon_photovoltaic.step_six', 'wafer.monosilicon_photovoltaic.step_seven', ['aluminium' : 30, 'titanium' : 30])
Deposition.generateSinteringRecipe('wafer.monosilicon_photovoltaic.step_seven', 'wafer.monosilicon_photovoltaic.step_eight', 200, MV)
Packaging.generateDicingRecipe('wafer.monosilicon_photovoltaic.step_eight', 'cell.monosilicon_photovoltaic', 1, 80, MV)