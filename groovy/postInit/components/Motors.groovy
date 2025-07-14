import postInit.utils.RecyclingHelper

ASSEMBLER = recipemap('assembler')

// LV Electric Motor * 1
mods.gregtech.assembler.removeByInput(30, [metaitem('cableGtSingleTin') * 2, metaitem('stickIron') * 2, metaitem('stickIronMagnetic'), metaitem('wireGtSingleCopper') * 4], null)
// LV Electric Motor * 1
mods.gregtech.assembler.removeByInput(30, [metaitem('cableGtSingleTin') * 2, metaitem('stickSteel') * 2, metaitem('stickSteelMagnetic'), metaitem('wireGtSingleCopper') * 4], null)
// MV Electric Motor * 1
mods.gregtech.assembler.removeByInput(30, [metaitem('cableGtSingleCopper') * 2, metaitem('stickAluminium') * 2, metaitem('stickSteelMagnetic'), metaitem('wireGtDoubleCupronickel') * 4], null)
// HV Electric Motor * 1
mods.gregtech.assembler.removeByInput(30, [metaitem('cableGtDoubleSilver') * 2, metaitem('stickStainlessSteel') * 2, metaitem('stickSteelMagnetic'), metaitem('wireGtDoubleElectrum') * 4], null)
// EV Electric Motor * 1
mods.gregtech.assembler.removeByInput(30, [metaitem('cableGtDoubleAluminium') * 2, metaitem('stickTitanium') * 2, metaitem('stickNeodymiumMagnetic'), metaitem('wireGtDoubleKanthal') * 4], null)
// IV Electric Motor * 1
mods.gregtech.assembler.removeByInput(30, [metaitem('cableGtDoubleTungsten') * 2, metaitem('stickTungstenSteel') * 2, metaitem('stickNeodymiumMagnetic'), metaitem('wireGtDoubleGraphene') * 4], null)
// LuV Electric Motor * 1
mods.gregtech.assembly_line.removeByInput(6000, [metaitem('stickLongSamariumMagnetic'), metaitem('stickLongHsss') * 2, metaitem('ringHsss') * 2, metaitem('roundHsss') * 4, metaitem('wireFineRuridit') * 64, metaitem('cableGtSingleNiobiumTitanium') * 2], [fluid('soldering_alloy') * 144, fluid('lubricant') * 250])
// ZPM Electric Motor * 1
mods.gregtech.assembly_line.removeByInput(24000, [metaitem('stickLongSamariumMagnetic'), metaitem('stickLongOsmiridium') * 4, metaitem('ringOsmiridium') * 4, metaitem('roundOsmiridium') * 8, metaitem('wireFineEuropium') * 64, metaitem('wireFineEuropium') * 32, metaitem('cableGtSingleVanadiumGallium') * 2], [fluid('soldering_alloy') * 288, fluid('lubricant') * 500])
// UV Electric Motor * 1
mods.gregtech.assembly_line.removeByInput(100000, [metaitem('stickLongSamariumMagnetic'), metaitem('stickLongTritanium') * 4, metaitem('ringTritanium') * 4, metaitem('roundTritanium') * 8, metaitem('wireFineAmericium') * 64, metaitem('wireFineAmericium') * 64, metaitem('cableGtSingleYttriumBariumCuprate') * 2], [fluid('soldering_alloy') * 576, fluid('lubricant') * 1000, fluid('naquadria') * 576])

crafting.removeByOutput(metaitem('electric.motor.lv'))
crafting.removeByOutput(metaitem('electric.motor.ev'))
crafting.removeByOutput(metaitem('electric.motor.iv'))

// Brushed DC Motors (LV-EV)

crafting.addShapeless('commutator', metaitem('commutator'), [
    metaitem('plateCopper'), metaitem('plateStone'), metaitem('rubber_drop'), ore('toolWireCutter')
])

crafting.addShapeless('brush.unfired', metaitem('brush.unfired'), [
    metaitem('dustGraphite'), metaitem('rubber_drop'), ore('toolHammer')
])

furnace.add(metaitem('brush.unfired'), metaitem('brush'))

crafting.addShaped('susy:electric_motor_lv', metaitem('electric.motor.lv'), [
    [metaitem('plateSteelMagnetic'), metaitem('wireGtSingleCopper'), metaitem('cableGtSingleTin')],
    [metaitem('brush'), metaitem('stickSteel'), metaitem('wireGtSingleCopper')],
    [metaitem('commutator'), metaitem('brush'), metaitem('plateSteelMagnetic')]
])

crafting.replaceShaped('gregtech:electric_motor_mv', metaitem('electric.motor.mv'), [
    [metaitem('plateSteelMagnetic'), metaitem('wireGtDoubleCupronickel'), metaitem('cableGtSingleCopper')],
    [metaitem('brush'), metaitem('stickAluminium'), metaitem('wireGtDoubleCupronickel')],
    [metaitem('commutator'), metaitem('brush'), metaitem('plateSteelMagnetic')]
])

crafting.replaceShaped('gregtech:electric_motor_hv', metaitem('electric.motor.hv'), [
    [metaitem('plateAlnicoMagnetic'), metaitem('wireGtDoubleElectrum'), metaitem('cableGtDoubleSilver')],
    [metaitem('brush'), metaitem('stickStainlessSteel'), metaitem('wireGtDoubleElectrum')],
    [metaitem('commutator'), metaitem('brush'), metaitem('plateAlnicoMagnetic')]
])

ASSEMBLER.recipeBuilder()
    .inputs(ore('plateCopper'))
    .inputs(ore('plateMica'))
    .fluidInputs(fluid('glue') * 100)
    .outputs(metaitem('commutator') * 4)
    .duration(100)
    .EUt(30)
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('dustGraphite'))
    .fluidInputs(fluid('glue') * 100)
    .outputs(metaitem('brush.unfired') * 2)
    .duration(100)
    .EUt(30)
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('dustMica'))
    .fluidInputs(fluid('glue') * 100)
    .outputs(metaitem('plateMica'))
    .duration(100)
    .EUt(30)
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('cableGtSingleTin'))
    .inputs(ore('stickSteel'))
    .inputs(ore('plateSteelMagnetic') * 2)
    .inputs(ore('wireGtSingleCopper') * 2)
    .inputs(metaitem('commutator'))
    .inputs(metaitem('brush') * 2)
    .outputs(metaitem('electric.motor.lv'))
    .duration(100)
    .EUt(30)
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('cableGtSingleCopper'))
    .inputs(ore('stickAluminium'))
    .inputs(ore('plateSteelMagnetic') * 2)
    .inputs(ore('wireGtDoubleCupronickel') * 2)
    .inputs(metaitem('commutator'))
    .inputs(metaitem('brush') * 2)
    .outputs(metaitem('electric.motor.mv'))
    .duration(100)
    .EUt(30)
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('cableGtDoubleSilver'))
    .inputs(ore('stickStainlessSteel'))
    .inputs(ore('plateAlnicoMagnetic') * 2)
    .inputs(ore('wireGtDoubleElectrum') * 2)
    .inputs(metaitem('commutator'))
    .inputs(metaitem('brush') * 2)
    .outputs(metaitem('electric.motor.hv'))
    .duration(100)
    .EUt(30)
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('cableGtDoubleAluminium'))
    .inputs(ore('stickTitanium'))
    .inputs(ore('plateAlnicoMagnetic') * 2)
    .inputs(ore('wireGtDoubleKanthal') * 2)
    .inputs(metaitem('commutator'))
    .inputs(metaitem('brush') * 2)
    .outputs(metaitem('electric.motor.ev'))
    .duration(100)
    .EUt(30)
    .buildAndRegister();

// Brushless DC Motors

ASSEMBLER.recipeBuilder()
    .inputs(ore('cableGtSingleTin') * 2)
    .inputs(ore('stickLongSteel'))
    .inputs(ore('plateSteelMagnetic') * 3)
    .inputs(ore('wireGtSingleCopper') * 4)
    .inputs(ore('componentTransistor') * 3)
    .inputs(ore('circuitLv'))
    .inputs(metaitem('circuit_board.basic'))
    .outputs(metaitem('electric.motor.lv') * 6)
    .duration(100)
    .EUt(30)
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('cableGtSingleCopper') * 2)
    .inputs(ore('stickLongAluminium'))
    .inputs(ore('plateSteelMagnetic') * 3)
    .inputs(ore('wireGtDoubleCupronickel') * 4)
    .inputs(metaitem('plate.ultra_low_power_integrated_circuit'))
    .inputs(ore('circuitMv'))
    .inputs(metaitem('circuit_board.good'))
    .outputs(metaitem('electric.motor.mv') * 6)
    .duration(100)
    .EUt(30)
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('cableGtDoubleSilver') * 2)
    .inputs(ore('stickLongStainlessSteel'))
    .inputs(ore('plateAlnicoMagnetic') * 3)
    .inputs(ore('wireGtDoubleElectrum') * 4)
    .inputs(metaitem('plate.low_power_integrated_circuit'))
    .inputs(ore('circuitHv'))
    .inputs(metaitem('circuit_board.plastic'))
    .outputs(metaitem('electric.motor.hv') * 6)
    .duration(100)
    .EUt(30)
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('cableGtDoubleAluminium') * 2)
    .inputs(ore('stickLongTitanium'))
    .inputs(ore('plateAlnicoMagnetic') * 3)
    .inputs(ore('wireGtDoubleKanthal') * 4)
    .inputs(metaitem('plate.power_integrated_circuit'))
    .inputs(ore('circuitEv'))
    .inputs(metaitem('circuit_board.advanced'))
    .outputs(metaitem('electric.motor.ev') * 6)
    .duration(100)
    .EUt(30)
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('cableGtDoubleTungsten') * 2)
    .inputs(ore('stickLongTungstenSteel'))
    .inputs(ore('plateNeodymiumAlloyMagnetic') * 3)
    .inputs(ore('wireGtDoubleGraphene') * 4)
    .inputs(metaitem('plate.high_power_integrated_circuit'))
    .inputs(ore('circuitIv'))
    .inputs(metaitem('circuit_board.elite'))
    .outputs(metaitem('electric.motor.iv') * 3)
    .duration(100)
    .EUt(30)
    .buildAndRegister();

// TEMPORARY: TO BE MODIFIED LATER

ASSEMBLY_LINE.recipeBuilder()
    .inputs(ore('stickLongSamariumAlloyMagnetic'))
    .inputs(ore('stickLongHsss') * 2)
    .inputs(ore('ringHsss') * 2)
    .inputs(ore('roundHsss') * 4)
    .inputs(ore('wireFineRuridit') * 64)
    .inputs(ore('cableGtSingleNiobiumTitanium') * 2)
    .fluidInputs(fluid('soldering_alloy') * 144)
    .fluidInputs(fluid('lubricant') * 250)
    .outputs(metaitem('electric.motor.luv'))
    .duration(600)
    .EUt(6000)
    .buildAndRegister();

ASSEMBLY_LINE.recipeBuilder()
    .inputs(ore('stickLongSamariumAlloyMagnetic'))
    .inputs(ore('stickLongOsmiridium') * 4)
    .inputs(ore('ringOsmiridium') * 4)
    .inputs(ore('roundOsmiridium') * 8)
    .inputs(ore('wireFineEuropium') * 64)
    .inputs(ore('wireFineEuropium') * 32)
    .inputs(ore('cableGtSingleVanadiumGallium') * 2)
    .fluidInputs(fluid('soldering_alloy') * 288)
    .fluidInputs(fluid('lubricant') * 500)
    .outputs(metaitem('electric.motor.zpm'))
    .duration(600)
    .EUt(24000)
    .buildAndRegister();

ASSEMBLY_LINE.recipeBuilder()
    .inputs(ore('stickLongSamariumAlloyMagnetic'))
    .inputs(ore('stickLongTritanium') * 4)
    .inputs(ore('ringTritanium') * 4)
    .inputs(ore('roundTritanium') * 8)
    .inputs(ore('wireFineAmericium') * 64)
    .inputs(ore('wireFineAmericium') * 64)
    .inputs(ore('cableGtSingleYttriumBariumCuprate') * 2)
    .fluidInputs(fluid('soldering_alloy') * 576)
    .fluidInputs(fluid('lubricant') * 1000)
    .fluidInputs(fluid('naquadria') * 576)
    .outputs(metaitem('electric.motor.uv'))
    .duration(600)
    .EUt(100000)
    .buildAndRegister();
