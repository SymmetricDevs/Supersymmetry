import static prePostInit.Recipemaps.*
import classes.*
import static gregtech.api.GTValues.*

import globals.semiconductors.Lithography
import globals.semiconductors.Etching
import globals.semiconductors.Deposition
import globals.semiconductors.Packaging
import globals.semiconductors.Doping
import globals.semiconductors.Mechanicals

// mono-Si
Doping.generateIonImplantationRecipes('wafer.silicon.p_doped', 'wafer.monosilicon_photovoltaic.step_one', 100, 'arsine')
Doping.generateIonImplantationRecipes('wafer.monosilicon_photovoltaic.step_one', 'wafer.monosilicon_photovoltaic.step_two', 100, 'boron_trifluoride')
Doping.generateDriveInRecipe('wafer.monosilicon_photovoltaic.step_two', 'wafer.monosilicon_photovoltaic.step_three', 200)
Deposition.generateChemicalVaporDepositionRecipe('wafer.monosilicon_photovoltaic.step_three', 'wafer.monosilicon_photovoltaic.step_four', 1.0, 'silicon_nitride.silane')
Lithography.generatePhotolithographyRecipes('wafer.monosilicon_photovoltaic.step_four', 'wafer.monosilicon_photovoltaic.step_five', 'novolac_resist', 'mask.monosilicon_photovoltaic', true)
Lithography.generateResistStrippingRecipes('wafer.monosilicon_photovoltaic.step_five', 'wafer.monosilicon_photovoltaic.step_six', 1, false)
Deposition.generateSputteringRecipe('wafer.monosilicon_photovoltaic.step_six', 'wafer.monosilicon_photovoltaic.step_seven', ['aluminium' : 30, 'titanium' : 30])
Deposition.generateSinteringRecipe('wafer.monosilicon_photovoltaic.step_seven', 'wafer.monosilicon_photovoltaic.step_eight', 200, MV)
Packaging.generateDicingRecipe('wafer.monosilicon_photovoltaic.step_eight', 'cell.monosilicon_photovoltaic', 1, 80, MV)

// multijunction Ge/GaAs/InGaP
// source: https://patents.google.com/patent/CN101859814B/en
// transition layer from Si substrate to Ge cell, the Ge content is gradually increased
Deposition.generateChemicalVaporDepositionRecipe('wafer.silicon', 'wafer.multijunction_photovoltaic.step_one', 3.0, 'silicon_germanium')
// 2 um thin film layer
Deposition.generateChemicalVaporDepositionRecipe('wafer.multijunction_photovoltaic.step_one', 'wafer.multijunction_photovoltaic.step_two', 0.5, 'germanium')
// p-Ge base layer
Deposition.generateChemicalVaporDepositionRecipe('wafer.multijunction_photovoltaic.step_two', 'wafer.multijunction_photovoltaic.step_three', 1.5, 'germanium')
Doping.generateIonImplantationRecipes('wafer.multijunction_photovoltaic.step_three', 'wafer.multijunction_photovoltaic.step_four', 100, 'boron_trifluoride')
Doping.generateDriveInRecipe('wafer.multijunction_photovoltaic.step_four', 'wafer.multijunction_photovoltaic.step_five', 200)
// n-Ge emitter layer
Deposition.generateChemicalVaporDepositionRecipe('wafer.multijunction_photovoltaic.step_five', 'wafer.multijunction_photovoltaic.step_six', 1.0, 'germanium')
Doping.generateIonImplantationRecipes('wafer.multijunction_photovoltaic.step_six', 'wafer.multijunction_photovoltaic.step_seven', 100, 'phosphine')
Doping.generateDriveInRecipe('wafer.multijunction_photovoltaic.step_seven', 'wafer.multijunction_photovoltaic.step_eight', 200)
// InGaP window layer
Deposition.generateChemicalVaporDepositionRecipe('wafer.multijunction_photovoltaic.step_eight', 'wafer.multijunction_photovoltaic.step_nine', 0.5, 'indium_gallium_phosphide')
// Back field layer (maybe can be combined with previous?)
Deposition.generateChemicalVaporDepositionRecipe('wafer.multijunction_photovoltaic.step_nine', 'wafer.multijunction_photovoltaic.step_ten', 1.0, 'indium_gallium_phosphide')
// p-GaAs base layer
Deposition.generateChemicalVaporDepositionRecipe('wafer.multijunction_photovoltaic.step_ten', 'wafer.multijunction_photovoltaic.step_eleven', 1.5, 'gallium_arsenide.be_doped')
// n-GaAs emitter layer
Deposition.generateChemicalVaporDepositionRecipe('wafer.multijunction_photovoltaic.step_eleven', 'wafer.multijunction_photovoltaic.step_twelve', 1.0, 'gallium_arsenide')
Doping.generateIonImplantationRecipes('wafer.multijunction_photovoltaic.step_twelve', 'wafer.multijunction_photovoltaic.step_thirteen', 100, 'silane')
Doping.generateDriveInRecipe('wafer.multijunction_photovoltaic.step_thirteen', 'wafer.multijunction_photovoltaic.step_fourteen', 200)
// InGaP window layer
Deposition.generateChemicalVaporDepositionRecipe('wafer.multijunction_photovoltaic.step_fourteen', 'wafer.multijunction_photovoltaic.step_fifteen', 0.5, 'indium_gallium_phosphide')
// Back field layer
Deposition.generateChemicalVaporDepositionRecipe('wafer.multijunction_photovoltaic.step_fifteen', 'wafer.multijunction_photovoltaic.step_sixteen', 1.0, 'indium_gallium_phosphide')
// p-InGaP base layer
Deposition.generateChemicalVaporDepositionRecipe('wafer.multijunction_photovoltaic.step_sixteen', 'wafer.multijunction_photovoltaic.step_seventeen', 1.5, 'indium_gallium_phosphide.be_doped')
// n-InGaP emitter layer
Deposition.generateChemicalVaporDepositionRecipe('wafer.multijunction_photovoltaic.step_seventeen', 'wafer.multijunction_photovoltaic.step_eighteen', 1.0, 'indium_gallium_phosphide')
Doping.generateIonImplantationRecipes('wafer.multijunction_photovoltaic.step_eighteen', 'wafer.multijunction_photovoltaic.step_nineteen', 100, 'silane')
Doping.generateDriveInRecipe('wafer.multijunction_photovoltaic.step_nineteen', 'wafer.multijunction_photovoltaic.step_twenty', 200)
// AlInP window layer
Deposition.generateChemicalVaporDepositionRecipe('wafer.multijunction_photovoltaic.step_twenty', 'wafer.multijunction_photovoltaic.step_twenty_one', 0.5, 'indium_aluminium_phosphide')
// the patent doesn't have info after this so it's copied from mono-Si
Lithography.generatePhotolithographyRecipes('wafer.multijunction_photovoltaic.step_twenty_one', 'wafer.multijunction_photovoltaic.step_twenty_two', 'novolac_resist', 'mask.multijunction_photovoltaic', true)
Lithography.generateResistStrippingRecipes('wafer.multijunction_photovoltaic.step_twenty_two', 'wafer.multijunction_photovoltaic.step_twenty_three', 1, false)
Deposition.generateSputteringRecipe('wafer.multijunction_photovoltaic.step_twenty_three', 'wafer.multijunction_photovoltaic.step_twenty_four', ['aluminium' : 30, 'titanium' : 30])
Deposition.generateSinteringRecipe('wafer.multijunction_photovoltaic.step_twenty_four', 'wafer.multijunction_photovoltaic.step_twenty_five', 200, MV)
Packaging.generateDicingRecipe('wafer.multijunction_photovoltaic.step_twenty_five', 'cell.multijunction_photovoltaic', 1, 80, MV)