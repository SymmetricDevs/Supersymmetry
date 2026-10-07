import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*
import gregtech.api.metatileentity.multiblock.CleanroomType
import globals.semiconductors.Deposition
import globals.semiconductors.Packaging
import globals.semiconductors.Doping
import globals.semiconductors.Lithography
import globals.semiconductors.Etching
import globals.semiconductors.Mechanicals

// Alloy-junction bipolar transistor (MV)

Packaging.generateDicingRecipe('wafer.germanium.n_doped', 'die.alloy_junction_transistor.step_one', 4, 400, LV, false)

RESISTANCE_FURNACE.recipeBuilder()
    .notConsumable(ore('springCupronickel'))
    .inputs(ore('nuggetHighPurityIndium') * 2)
    .inputs(metaitem('die.alloy_junction_transistor.step_one'))
    .outputs(metaitem('die.alloy_junction_transistor.step_two'))
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister();

// Backside (collector) metallization for ohmic contact
Deposition.generateEvaporationRecipe('die.alloy_junction_transistor.step_two', 'die.alloy_junction_transistor.step_three', 100, 'gold_antimony', false)

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('die.alloy_junction_transistor.step_three'))
    .inputs(ore('wireFineDumet') * 3)
    .inputs(ore('boltKovar'))
    .fluidInputs(fluid('high_temperature_solder') * 18)
    .outputs(metaitem('component.transistor.alloy_junction.core'))
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('component.transistor.alloy_junction.core'))
    .inputs(ore('wireFineNickel') * 3)
    .fluidInputs(fluid('glass') * 72)
    .fluidInputs(fluid('high_temperature_solder') * 72)
    .fluidInputs(fluid('nitrogen') * 50)
    .outputs(metaitem('component.transistor.alloy_junction'))
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister();

// Signal MOSFET (HV, SMD)
// Sources: https://patents.google.com/patent/US4319396A/en
//          https://patents.google.com/patent/US4299024A/en

// Passivation oxide formation
Deposition.generateSiliconDioxideGrowthRecipe('wafer.silicon.p_doped', 'wafer.signal_mosfet.step_one', 400, true, 2)
Lithography.generatePhotolithographyRecipes('wafer.signal_mosfet.step_one', 'wafer.signal_mosfet.step_two', 'novolac_resist', 'mask_set.signal_mosfet', true)
Etching.generateWetEtchingRecipe('wafer.signal_mosfet.step_two', 'wafer.signal_mosfet.step_three', 'silicon_dioxide', 400, false)

// Gate oxide formation and gate polysilicon deposition
Lithography.generateResistStrippingRecipes('wafer.signal_mosfet.step_three', 'wafer.signal_mosfet.step_four', 1, false, true)
Deposition.generateSiliconDioxideGrowthRecipe('wafer.signal_mosfet.step_four', 'wafer.signal_mosfet.step_five', 400, false)
Deposition.generateChemicalVaporDepositionRecipe('wafer.signal_mosfet.step_five', 'wafer.signal_mosfet.step_six', 2.0, 'n_doped_silicon')
Lithography.generatePhotolithographyRecipes('wafer.signal_mosfet.step_six', 'wafer.signal_mosfet.step_seven', 'novolac_resist', 'mask_set.signal_mosfet', true)
Etching.generateWetEtchingRecipe('wafer.signal_mosfet.step_seven', 'wafer.signal_mosfet.step_eight', 'silicon', 100, false)
Lithography.generateResistStrippingRecipes('wafer.signal_mosfet.step_eight', 'wafer.signal_mosfet.step_nine', 1, true)

// Source and drain formation
Lithography.generatePhotolithographyRecipes('wafer.signal_mosfet.step_nine', 'wafer.signal_mosfet.step_ten', 'novolac_resist', 'mask_set.signal_mosfet', true)
Doping.generateIonImplantationRecipes('wafer.signal_mosfet.step_ten', 'wafer.signal_mosfet.step_eleven', 400, 'phosphine')
Lithography.generateResistStrippingRecipes('wafer.signal_mosfet.step_eleven', 'wafer.signal_mosfet.step_twelve', 1, true)
Lithography.generatePhotolithographyRecipes('wafer.signal_mosfet.step_twelve', 'wafer.signal_mosfet.step_thirteen', 'novolac_resist', 'mask_set.signal_mosfet', true)
Doping.generateIonImplantationRecipes('wafer.signal_mosfet.step_thirteen', 'wafer.signal_mosfet.step_fourteen', 400, 'boron_trifluoride')
Lithography.generateResistStrippingRecipes('wafer.signal_mosfet.step_fourteen', 'wafer.signal_mosfet.step_fifteen', 1, true)
Doping.generateDriveInRecipe('wafer.signal_mosfet.step_fifteen', 'wafer.signal_mosfet.step_sixteen', 400)

// Passivation layer deposition
Deposition.generateChemicalVaporDepositionRecipe('wafer.signal_mosfet.step_sixteen', 'wafer.signal_mosfet.step_seventeen', 1.0, 'borophosphosilicate_glass')
Lithography.generatePhotolithographyRecipes('wafer.signal_mosfet.step_seventeen', 'wafer.signal_mosfet.step_eighteen', 'novolac_resist', 'mask_set.signal_mosfet', true)
Etching.generateWetEtchingRecipe('wafer.signal_mosfet.step_eighteen', 'wafer.signal_mosfet.step_nineteen', 'silicon_dioxide', 100, false)
Lithography.generateResistStrippingRecipes('wafer.signal_mosfet.step_nineteen', 'wafer.signal_mosfet.step_twenty', 1, false, true)

// Metalization
Deposition.generateSputteringRecipe('wafer.signal_mosfet.step_twenty', 'wafer.signal_mosfet.step_twenty_one', [ 'aluminium' : 396, 'silicon' : 4 ])
Lithography.generatePhotolithographyRecipes('wafer.signal_mosfet.step_twenty_one', 'wafer.signal_mosfet.step_twenty_two', 'novolac_resist', 'mask_set.signal_mosfet', false)
Etching.generateWetEtchingRecipe('wafer.signal_mosfet.step_twenty_two', 'wafer.signal_mosfet.step_twenty_three', 'aluminium', 100, false)
Lithography.generateResistStrippingRecipes('wafer.signal_mosfet.step_twenty_three', 'wafer.signal_mosfet.step_twenty_four', 1, false, true)
Deposition.generateSinteringRecipe('wafer.signal_mosfet.step_twenty_four', 'wafer.signal_mosfet.step_twenty_five', 400, HV)

// Protection and packaging
Deposition.generateChemicalVaporDepositionRecipe('wafer.signal_mosfet.step_twenty_five', 'wafer.signal_mosfet.step_twenty_six', 2.0, 'silicon_nitride.silane')
Lithography.generatePhotolithographyRecipes('wafer.signal_mosfet.step_twenty_six', 'wafer.signal_mosfet.step_twenty_seven', 'novolac_resist', 'mask_set.signal_mosfet', true)
Etching.generateWetEtchingRecipe('wafer.signal_mosfet.step_twenty_seven', 'wafer.signal_mosfet.step_twenty_eight', 'silicon_nitride', 100, false)
Lithography.generateResistStrippingRecipes('wafer.signal_mosfet.step_twenty_eight', 'wafer.signal_mosfet.step_twenty_nine', 1, true, true)
Mechanicals.generateBackgrindingRecipe('wafer.signal_mosfet.step_twenty_nine', 'wafer.signal_mosfet.step_thirty', 400, HV)
Packaging.generateDicingRecipe('wafer.signal_mosfet.step_thirty', 'die.signal_mosfet', 4, 400, HV)
Packaging.generateWireBondingRecipe('die.signal_mosfet', 'die.signal_mosfet.bonded', 'aluminium', 50, HV)

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('die.signal_mosfet.bonded'))
    .fluidInputs(fluid('epoxy_molding_compound') * 36)
    .outputs(metaitem('component.transistor.signal_mosfet'))
    .duration(100)
    .EUt(VA[HV])
    .cleanroom(CleanroomType.CLEANROOM)
    .buildAndRegister()


// Trench VDMOS (EV)
// Sources: https://patents.google.com/patent/US4767722A/en
//          https://patents.google.com/patent/US4516143A/en
//          https://patents.google.com/patent/US4466172A/en
//          https://patents.google.com/patent/US4733289A/en
//          https://patents.google.com/patent/US4517226A/en

// Power SMD Si-MOSFET (Trench VDMOS)

// N-doped epi layer (drift region) on top of p-doped substrate/drain
Deposition.generateChemicalVaporDepositionRecipe('wafer.small.silicon.heavily_n_doped', 'wafer.vdmos.step_one', 2.0, 'n_doped_silicon')

// P-base formation and patterning
Deposition.generateSiliconDioxideGrowthRecipe('wafer.vdmos.step_one', 'wafer.vdmos.step_two', 400, false)
Lithography.generatePhotolithographyRecipes('wafer.vdmos.step_two', 'wafer.vdmos.step_three', 'novolac_resist', 'mask_set.vdmos', true)
Doping.generateIonImplantationRecipes('wafer.vdmos.step_three', 'wafer.vdmos.step_four', 400, 'boron_trifluoride')
Lithography.generateResistStrippingRecipes('wafer.vdmos.step_four', 'wafer.vdmos.step_five', 1, true)
Doping.generateDriveInRecipe('wafer.vdmos.step_five', 'wafer.vdmos.step_six', 400)

// Opening windows for source and gate contacts
Lithography.generatePhotolithographyRecipes('wafer.vdmos.step_six', 'wafer.vdmos.step_seven', 'novolac_resist', 'mask_set.vdmos', true)
Etching.generateWetEtchingRecipe('wafer.vdmos.step_seven', 'wafer.vdmos.step_eight', 'silicon_dioxide', 400, false)

// Source formation and patterning
Doping.generateIonImplantationRecipes('wafer.vdmos.step_eight', 'wafer.vdmos.step_nine', 400, 'arsine')
Lithography.generateResistStrippingRecipes('wafer.vdmos.step_nine', 'wafer.vdmos.step_ten', 1, true)

// Digging gate trenches
Lithography.generatePhotolithographyRecipes('wafer.vdmos.step_ten', 'wafer.vdmos.step_eleven', 'novolac_resist', 'mask_set.vdmos', true)
Etching.generateWetEtchingRecipe('wafer.vdmos.step_eleven', 'wafer.vdmos.step_twelve', 'silicon_dioxide', 400, false)
Etching.generateReactiveIonEtchingRecipe('wafer.vdmos.step_twelve', 'wafer.vdmos.step_thirteen', 'silicon', 400)
Lithography.generateResistStrippingRecipes('wafer.vdmos.step_thirteen', 'wafer.vdmos.step_fourteen', 1, true)

// Grow gate oxide and deposit gate polysilicon
Deposition.generateSiliconDioxideGrowthRecipe('wafer.vdmos.step_fourteen', 'wafer.vdmos.step_fifteen', 400, true)
Deposition.generateChemicalVaporDepositionRecipe('wafer.vdmos.step_fifteen', 'wafer.vdmos.step_sixteen', 3.0, 'n_doped_silicon')
Etching.generateReactiveIonEtchingRecipe('wafer.vdmos.step_sixteen', 'wafer.vdmos.step_seventeen', 'silicon', 100)
Deposition.generateSiliconDioxideGrowthRecipe('wafer.vdmos.step_seventeen', 'wafer.vdmos.step_eighteen', 400, false)

// Gate contact formation and patterning
Lithography.generatePhotolithographyRecipes('wafer.vdmos.step_eighteen', 'wafer.vdmos.step_nineteen', 'novolac_resist', 'mask_set.vdmos', true)
Etching.generateWetEtchingRecipe('wafer.vdmos.step_nineteen', 'wafer.vdmos.step_twenty', 'silicon_dioxide', 400, false)
Lithography.generateResistStrippingRecipes('wafer.vdmos.step_twenty', 'wafer.vdmos.step_twenty_one', 1, false, true)
Deposition.generateSputteringRecipe('wafer.vdmos.step_twenty_one', 'wafer.vdmos.step_twenty_two', [ 'aluminium' : 396, 'silicon' : 4 ])
Lithography.generatePhotolithographyRecipes('wafer.vdmos.step_twenty_two', 'wafer.vdmos.step_twenty_three', 'novolac_resist', 'mask_set.vdmos', false)
Etching.generateWetEtchingRecipe('wafer.vdmos.step_twenty_three', 'wafer.vdmos.step_twenty_four', 'aluminium', 100, false)
Lithography.generateResistStrippingRecipes('wafer.vdmos.step_twenty_four', 'wafer.vdmos.step_twenty_five', 1, false, true)

// Passivation layer deposition
Deposition.generateChemicalVaporDepositionRecipe('wafer.vdmos.step_twenty_five', 'wafer.vdmos.step_twenty_six', 1.0, 'borophosphosilicate_glass')
Deposition.generateChemicalVaporDepositionRecipe('wafer.vdmos.step_twenty_six', 'wafer.vdmos.step_twenty_seven', 1.0, 'silicon_nitride.silane')
Lithography.generatePhotolithographyRecipes('wafer.vdmos.step_twenty_seven', 'wafer.vdmos.step_twenty_eight', 'novolac_resist', 'mask_set.vdmos', true)
Etching.generateReactiveIonEtchingRecipe('wafer.vdmos.step_twenty_eight', 'wafer.vdmos.step_twenty_nine', 'silicon_nitride', 100)
Etching.generateReactiveIonEtchingRecipe('wafer.vdmos.step_twenty_nine', 'wafer.vdmos.step_thirty', 'silicon_dioxide', 100)
Lithography.generateResistStrippingRecipes('wafer.vdmos.step_thirty', 'wafer.vdmos.step_thirty_one', 1, true, true)

// Backgrinding and metallization
Mechanicals.generateBackgrindingRecipe('wafer.vdmos.step_thirty_one', 'wafer.vdmos.step_thirty_two', 400, HV)
Deposition.generateEvaporationRecipe('wafer.vdmos.step_thirty_two', 'wafer.vdmos.step_thirty_three', 400, 'gold_antimony', true) // Drain contact
Deposition.generateEvaporationRecipe('wafer.vdmos.step_thirty_three', 'wafer.vdmos.step_thirty_four', 400, 'aluminium', true) // Source contact
Deposition.generateSinteringRecipe('wafer.vdmos.step_thirty_four', 'wafer.vdmos.step_thirty_five', 400, HV)
Packaging.generateDicingRecipe('wafer.vdmos.step_thirty_five', 'die.vdmos', 4, 400, HV)
Packaging.generateWireBondingRecipe('die.vdmos', 'component.transistor.vdmos.bonded', 'aluminium', 50, HV)

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('component.transistor.vdmos.bonded'))
    .fluidInputs(fluid('epoxy_molding_compound') * 48)
    .outputs(metaitem('component.transistor.vdmos'))
    .cleanroom(CleanroomType.CLEANROOM)
    .duration(200)
    .EUt(VA[HV])
    .buildAndRegister()

// Power SiC-MOSFET (IV)

// RF/HF SMD Si-LDMOS (IV)

// IGBT (LuV)
