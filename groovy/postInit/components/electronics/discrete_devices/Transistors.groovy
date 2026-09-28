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


// Trench VDMOS
// Sources: https://patents.google.com/patent/US4767722A/en
//          https://patents.google.com/patent/US4516143A/en
//          https://patents.google.com/patent/US4466172A/en
//          https://patents.google.com/patent/US4733289A/en
//          https://patents.google.com/patent/US4517226A/en

Deposition.generateChemicalVaporDepositionRecipe('wafer.small.silicon.heavily_n_doped', 'wafer.vdmos.step_one', 2.0, 'n_doped_silicon')
Deposition.generateSiliconDioxideGrowthRecipe('wafer.vdmos.step_one', 'wafer.vdmos.step_two', 400, false)
Lithography.generatePhotolithographyRecipes('wafer.vdmos.step_two', 'wafer.vdmos.step_three', 'novolac_resist', 'mask_set.vdmos', true)
Doping.generateIonImplantationRecipes('wafer.vdmos.step_three', 'wafer.vdmos.step_four.implanted', 400, 'boron_trifluoride')
Lithography.generateResistStrippingRecipes('wafer.vdmos.step_four.implanted', 'wafer.vdmos.step_four.stripped', 1, true)
Doping.generateDriveInRecipe('wafer.vdmos.step_four.stripped', 'wafer.vdmos.step_four', 400)
Lithography.generatePhotolithographyRecipes('wafer.vdmos.step_four', 'wafer.vdmos.step_four.source_patterned', 'novolac_resist', 'mask_set.vdmos', true)
Etching.generateWetEtchingRecipe('wafer.vdmos.step_four.source_patterned', 'wafer.vdmos.step_five', 'silicon_dioxide', 400, false)
['arsine', 'phosphine'].each { source ->
    Doping.generateIonImplantationRecipes('wafer.vdmos.step_five', 'wafer.vdmos.step_six.implanted', 400, source
    )}
Lithography.generateResistStrippingRecipes('wafer.vdmos.step_six.implanted', 'wafer.vdmos.step_six.stripped', 1, true)
TUBE_FURNACE.recipeBuilder()
    .inputs(metaitem('wafer.vdmos.step_six.stripped'))
    .fluidInputs(fluid('oxygen') * 100)
    .fluidInputs(fluid('nitrogen') * 100)
    .outputs(metaitem('wafer.vdmos.step_six'))
    .duration(400)
    .cleanroom(CleanroomType.CLEANROOM)
    .EUt(VA[HV])
    .buildAndRegister()
Lithography.generatePhotolithographyRecipes('wafer.vdmos.step_six', 'wafer.vdmos.step_six.gate_patterned', 'novolac_resist', 'mask_set.vdmos', true)
Etching.generateWetEtchingRecipe('wafer.vdmos.step_six.gate_patterned', 'wafer.vdmos.step_seven', 'silicon_dioxide', 400, false)
Etching.generateReactiveIonEtchingRecipe('wafer.vdmos.step_seven', 'wafer.vdmos.step_eight.etched', 'silicon', 400)
Lithography.generateResistStrippingRecipes('wafer.vdmos.step_eight.etched', 'wafer.vdmos.step_eight', 1, true)
Deposition.generateSiliconDioxideGrowthRecipe('wafer.vdmos.step_eight', 'wafer.vdmos.step_nine', 400, true)
Deposition.generateChemicalVaporDepositionRecipe('wafer.vdmos.step_nine', 'wafer.vdmos.step_ten', 3.0, 'silicon')
Doping.generatePhosphorusDiffusionDopingRecipes('wafer.vdmos.step_ten', 'wafer.vdmos.step_eleven.doped', 400)
Etching.generateReactiveIonEtchingRecipe('wafer.vdmos.step_eleven.doped', 'wafer.vdmos.step_eleven', 'silicon', 100)
Deposition.generateSiliconDioxideGrowthRecipe('wafer.vdmos.step_eleven', 'wafer.vdmos.step_twelve', 400, false)
Lithography.generatePhotolithographyRecipes('wafer.vdmos.step_twelve', 'wafer.vdmos.step_thirteen', 'novolac_resist', 'mask_set.vdmos', true)
Etching.generateWetEtchingRecipe('wafer.vdmos.step_thirteen', 'wafer.vdmos.step_fourteen', 'silicon_dioxide', 400, false)
Lithography.generateResistStrippingRecipes('wafer.vdmos.step_fourteen', 'wafer.vdmos.step_fifteen', 1, false, true)
Deposition.generateEvaporationRecipe('wafer.vdmos.step_fifteen', 'wafer.vdmos.step_sixteen', 400, 'aluminium', true)
Lithography.generatePhotolithographyRecipes('wafer.vdmos.step_sixteen', 'wafer.vdmos.step_seventeen.patterned', 'novolac_resist', 'mask_set.vdmos', false)
Etching.generateWetEtchingRecipe('wafer.vdmos.step_seventeen.patterned', 'wafer.vdmos.step_seventeen.etched', 'aluminium', 100, false)
Lithography.generateResistStrippingRecipes('wafer.vdmos.step_seventeen.etched', 'wafer.vdmos.step_seventeen', 1, false, true)
Deposition.generateChemicalVaporDepositionRecipe('wafer.vdmos.step_seventeen', 'wafer.vdmos.step_eighteen', 1.0, 'phosphosilicate_glass')
CVD.recipeBuilder()
    .inputs(metaitem('wafer.vdmos.step_eighteen'))
    .fluidInputs(fluid('silane') * 15)
    .fluidInputs(fluid('ammonia') * 20)
    .fluidInputs(fluid('nitrogen') * 100)
    .fluidOutputs(fluid('hydrogen') * 60)
    .fluidOutputs(fluid('nitrogen') * 100)
    .outputs(metaitem('wafer.vdmos.step_nineteen'))
    .cleanroom(CleanroomType.CLEANROOM)
    .duration(4545)
    .EUt(VA[HV])
    .buildAndRegister()
Lithography.generatePhotolithographyRecipes('wafer.vdmos.step_nineteen', 'wafer.vdmos.step_twenty', 'novolac_resist', 'mask_set.vdmos', true)
Etching.generateReactiveIonEtchingRecipe('wafer.vdmos.step_twenty', 'wafer.vdmos.step_twenty_one.nitride_etched', 'silicon_nitride', 100)
Etching.generateReactiveIonEtchingRecipe('wafer.vdmos.step_twenty_one.nitride_etched', 'wafer.vdmos.step_twenty_one.etched', 'silicon_dioxide', 100)
Lithography.generateResistStrippingRecipes('wafer.vdmos.step_twenty_one.etched', 'wafer.vdmos.step_twenty_one', 1, true, true)
Mechanicals.generateBackgrindingRecipe('wafer.vdmos.step_twenty_one', 'wafer.vdmos.step_twenty_one.background', 400, HV)
EVAPORATION.recipeBuilder()
    .inputs(metaitem('wafer.vdmos.step_twenty_one.background'))
    .inputs(ore('nuggetGold'))
    .outputs(metaitem('wafer.vdmos.step_twenty_two'))
    .cleanroom(CleanroomType.CLEANROOM)
    .duration(400)
    .EUt(VA[MV])
    .buildAndRegister()
Deposition.generateEvaporationRecipe('wafer.vdmos.step_twenty_two', 'wafer.vdmos.step_twenty_three', 400, 'aluminium', true)
RESISTANCE_FURNACE.recipeBuilder()
    .notConsumable(ore('springCupronickel'))
    .inputs(metaitem('wafer.vdmos.step_twenty_three'))
    .outputs(metaitem('wafer.vdmos.step_twenty_four'))
    .cleanroom(CleanroomType.CLEANROOM)
    .duration(400)
    .EUt(VA[HV])
    .buildAndRegister()
Packaging.generateDicingRecipe('wafer.vdmos.step_twenty_four', 'die.vdmos', 4, 400, HV)
Packaging.generateWireBondingRecipe('die.vdmos', 'component.transistor.vdmos.bonded', 'aluminium', 50, HV)
ASSEMBLER.recipeBuilder()
    .inputs(metaitem('component.transistor.vdmos.bonded'))
    .fluidInputs(fluid('epoxy_molding_compound') * 288)
    .outputs(metaitem('component.transistor.vdmos'))
    .cleanroom(CleanroomType.CLEANROOM)
    .duration(200)
    .EUt(VA[HV])
    .buildAndRegister()


// Signal MOSFET
// Sources: https://patents.google.com/patent/US4319396A/en
//          https://patents.google.com/patent/US4299024A/en

Deposition.generateSiliconDioxideGrowthRecipe('wafer.silicon.p_doped', 'wafer.signal_mosfet.step_one', 400, true)
Lithography.generatePhotolithographyRecipes('wafer.signal_mosfet.step_one', 'wafer.signal_mosfet.step_two.patterned', 'novolac_resist', 'mask_set.signal_mosfet', true)
Etching.generateWetEtchingRecipe('wafer.signal_mosfet.step_two.patterned', 'wafer.signal_mosfet.step_two.etched', 'silicon_dioxide', 400, false)
Lithography.generateResistStrippingRecipes('wafer.signal_mosfet.step_two.etched', 'wafer.signal_mosfet.step_two', 1, false, true)
Deposition.generateSiliconDioxideGrowthRecipe('wafer.signal_mosfet.step_two', 'wafer.signal_mosfet.step_three', 400, false)
Deposition.generateChemicalVaporDepositionRecipe('wafer.signal_mosfet.step_three', 'wafer.signal_mosfet.step_four', 2.0, 'n_doped_silicon')
Lithography.generatePhotolithographyRecipes('wafer.signal_mosfet.step_four', 'wafer.signal_mosfet.step_five.patterned', 'novolac_resist', 'mask_set.signal_mosfet', true)
Etching.generateReactiveIonEtchingRecipe('wafer.signal_mosfet.step_five.patterned', 'wafer.signal_mosfet.step_five.etched', 'silicon', 100)
Lithography.generateResistStrippingRecipes('wafer.signal_mosfet.step_five.etched', 'wafer.signal_mosfet.step_five', 1, true)
Lithography.generatePhotolithographyRecipes('wafer.signal_mosfet.step_five', 'wafer.signal_mosfet.step_six.patterned', 'novolac_resist', 'mask_set.signal_mosfet', true)
Doping.generateIonImplantationRecipes('wafer.signal_mosfet.step_six.patterned', 'wafer.signal_mosfet.step_six.implanted', 400, 'phosphine')
Lithography.generateResistStrippingRecipes('wafer.signal_mosfet.step_six.implanted', 'wafer.signal_mosfet.step_six', 1, true)
Lithography.generatePhotolithographyRecipes('wafer.signal_mosfet.step_six', 'wafer.signal_mosfet.step_seven.patterned', 'novolac_resist', 'mask_set.signal_mosfet', true)
Doping.generateIonImplantationRecipes('wafer.signal_mosfet.step_seven.patterned', 'wafer.signal_mosfet.step_seven.implanted', 400, 'boron_trifluoride')
Lithography.generateResistStrippingRecipes('wafer.signal_mosfet.step_seven.implanted', 'wafer.signal_mosfet.step_seven', 1, true)
Doping.generateDriveInRecipe('wafer.signal_mosfet.step_seven', 'wafer.signal_mosfet.step_eight', 400)
Deposition.generateChemicalVaporDepositionRecipe('wafer.signal_mosfet.step_eight', 'wafer.signal_mosfet.step_nine', 1.0, 'phosphosilicate_glass')
Lithography.generatePhotolithographyRecipes('wafer.signal_mosfet.step_nine', 'wafer.signal_mosfet.step_ten.patterned', 'novolac_resist', 'mask_set.signal_mosfet', true)
Etching.generateWetEtchingRecipe('wafer.signal_mosfet.step_ten.patterned', 'wafer.signal_mosfet.step_ten.etched', 'silicon_dioxide', 100, false)
Lithography.generateResistStrippingRecipes('wafer.signal_mosfet.step_ten.etched', 'wafer.signal_mosfet.step_ten', 1, false, true)
Deposition.generateEvaporationRecipe('wafer.signal_mosfet.step_ten', 'wafer.signal_mosfet.step_eleven', 400, 'aluminium', true)
Lithography.generatePhotolithographyRecipes('wafer.signal_mosfet.step_eleven', 'wafer.signal_mosfet.step_twelve.patterned', 'novolac_resist', 'mask_set.signal_mosfet', false)
Etching.generateWetEtchingRecipe('wafer.signal_mosfet.step_twelve.patterned', 'wafer.signal_mosfet.step_twelve.etched', 'aluminium', 100, false)
Lithography.generateResistStrippingRecipes('wafer.signal_mosfet.step_twelve.etched', 'wafer.signal_mosfet.step_twelve', 1, false, true)
Deposition.generateSinteringRecipe('wafer.signal_mosfet.step_twelve', 'wafer.signal_mosfet.step_thirteen', 400, HV)
Deposition.generateChemicalVaporDepositionRecipe('wafer.signal_mosfet.step_thirteen', 'wafer.signal_mosfet.step_fourteen', 2.0, 'silicon_nitride.silane')
Lithography.generatePhotolithographyRecipes('wafer.signal_mosfet.step_fourteen', 'wafer.signal_mosfet.step_fifteen.patterned', 'novolac_resist', 'mask_set.signal_mosfet', true)
Etching.generateReactiveIonEtchingRecipe('wafer.signal_mosfet.step_fifteen.patterned', 'wafer.signal_mosfet.step_fifteen.etched', 'silicon_nitride', 100)
Lithography.generateResistStrippingRecipes('wafer.signal_mosfet.step_fifteen.etched', 'wafer.signal_mosfet.step_fifteen', 1, true, true)
Mechanicals.generateBackgrindingRecipe('wafer.signal_mosfet.step_fifteen', 'wafer.signal_mosfet.step_sixteen', 400, HV)
Packaging.generateDicingRecipe('wafer.signal_mosfet.step_sixteen', 'die.signal_mosfet', 4, 400, HV)
Packaging.generateWireBondingRecipe('die.signal_mosfet', 'die.signal_mosfet.bonded', 'aluminium', 50, HV)
ASSEMBLER.recipeBuilder()
    .inputs(metaitem('die.signal_mosfet.bonded'))
    .fluidInputs(fluid('epoxy_molding_compound') * 288)
    .outputs(metaitem('component.transistor.signal_mosfet'))
    .duration(100)
    .EUt(VA[HV])
    .cleanroom(CleanroomType.CLEANROOM)
    .buildAndRegister()
