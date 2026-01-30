import static prePostInit.Recipemaps.*
import postInit.utils.RecyclingHelper
import static gregtech.api.GTValues.*

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

crafting.addShapeless('susy:commutator', metaitem('component.commutator'), [
    metaitem('plateCopper'), metaitem('plateStone'), metaitem('rubber_drop'), ore('toolWireCutter')
])

crafting.addShapeless('susy:brush.unfired', metaitem('component.brush.unfired'), [
    metaitem('dustGraphite'), metaitem('rubber_drop'), ore('toolHammer')
])

furnace.add(metaitem('component.brush.unfired'), metaitem('component.brush'))

crafting.addShaped('susy:electric_motor_lv', metaitem('electric.motor.lv'), [
    [metaitem('plateSteelMagnetic'), metaitem('wireGtFineCopper'), metaitem('cableGtSingleTin')],
    [metaitem('component.brush'), metaitem('stickSteel'), metaitem('wireGtFineCopper')],
    [metaitem('component.commutator'), metaitem('component.brush'), metaitem('plateSteelMagnetic')]
])

ASSEMBLER.recipeBuilder()
    .inputs(ore('plateCopper'))
    .inputs(ore('plateMica'))
    .fluidInputs(fluid('glue') * 100)
    .outputs(metaitem('component.commutator') * 4)
    .duration(120)
    .EUt(VA[LV])
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('dustGraphite'))
    .fluidInputs(fluid('glue') * 100)
    .outputs(metaitem('component.brush.unfired') * 2)
    .duration(80)
    .EUt(VA[LV])
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('dustMica'))
    .fluidInputs(fluid('glue') * 100)
    .outputs(metaitem('plateMica'))
    .duration(80)
    .EUt(VA[LV])
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('cableGtSingleTin'))
    .inputs(ore('stickSteel'))
    .inputs(ore('plateSteelMagnetic') * 2)
    .inputs(ore('wireFineAnnealedCopper') * 4)
    .inputs(metaitem('component.commutator'))
    .inputs(metaitem('component.brush') * 2)
    .outputs(metaitem('electric.motor.lv'))
    .duration(80)
    .EUt(VA[LV])
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('cableGtSingleCopper') * 2)
    .inputs(ore('stickAluminium'))
    .inputs(ore('plateSteelMagnetic') * 2)
    .inputs(ore('wireFineAnnealedCopper') * 4)
    .inputs(metaitem('component.commutator'))
    .inputs(metaitem('component.brush') * 2)
    .outputs(metaitem('electric.motor.mv'))
    .duration(80)
    .EUt(VA[MV])
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('wireFineAnnealedCopper') * 16)
    .fluidInputs(fluid('polyethylene_terephthalate') * 36)
    .outputs(metaitem('wireFineEnamelledCopper') * 16)
    .duration(80)
    .EUt(VA[MV])
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('cableGtDoubleSilver') * 2)
    .inputs(ore('stickStainlessSteel'))
    .inputs(ore('plateAlnicoMagnetic') * 2)
    .inputs(ore('wireFineEnameledCopper') * 8)
    .inputs(metaitem('component.commutator'))
    .inputs(metaitem('component.brush') * 2)
    .outputs(metaitem('electric.motor.hv'))
    .duration(80)
    .EUt(VA[HV])
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('wireFineGold') * 16)
    .fluidInputs(fluid('polyethylene_terephthalate') * 36)
    .outputs(metaitem('wireFineEnamelledGold') * 16)
    .duration(80)
    .EUt(VA[MV])
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('cableGtDoubleAluminium') * 2)
    .inputs(ore('stickTitanium'))
    .inputs(ore('plateAlnicoMagnetic') * 2)
    .inputs(ore('wireFineEnamelledGold') * 16)
    .inputs(metaitem('component.commutator'))
    .inputs(metaitem('component.brush') * 2)
    .outputs(metaitem('electric.motor.ev'))
    .duration(80)
    .EUt(VA[HV])
    .buildAndRegister();

// Brushless DC Motors

ASSEMBLER.recipeBuilder()
    .inputs(ore('cableGtSingleTin') * 2)
    .inputs(ore('stickLongSteel'))
    .inputs(ore('plateSteelMagnetic') * 3)
    .inputs(ore('wireFineCopper') * 4)
    .inputs(metaitem('component.transistor.alloy_junction') * 3)
    .inputs(ore('circuitLv'))
    .inputs(metaitem('circuit_board.basic'))
    .outputs(metaitem('electric.motor.lv') * 6)
    .info('recipe.motor.brushless')
    .duration(160)
    .EUt(VA[LV])
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('cableGtSingleCopper') * 2)
    .inputs(ore('stickLongAluminium'))
    .inputs(ore('plateSteelMagnetic') * 3)
    .inputs(ore('wireFineAnnealedCopper') * 8)
    .inputs(metaitem('plate.ultra_low_power_integrated_circuit'))
    .inputs(ore('circuitMv'))
    .inputs(metaitem('circuit_board.good'))
    .outputs(metaitem('electric.motor.mv') * 6)
    .duration(160)
    .EUt(VA[MV])
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('cableGtDoubleSilver') * 2)
    .inputs(ore('stickLongStainlessSteel'))
    .inputs(ore('plateAlnicoMagnetic') * 3)
    .inputs(ore('wireFineEnamelledCopper') * 16)
    .inputs(metaitem('plate.low_power_integrated_circuit'))
    .inputs(ore('circuitHv'))
    .inputs(metaitem('circuit_board.plastic'))
    .outputs(metaitem('electric.motor.hv') * 6)
    .duration(160)
    .EUt(VA[HV])
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('cableGtDoubleAluminium') * 2)
    .inputs(ore('stickLongTitanium'))
    .inputs(ore('plateAlnicoMagnetic') * 3)
    .inputs(ore('wireFineEnamelledGold') * 32)
    .inputs(metaitem('plate.power_integrated_circuit'))
    .inputs(ore('circuitEv'))
    .inputs(metaitem('circuit_board.advanced'))
    .outputs(metaitem('electric.motor.ev') * 6)
    .duration(160)
    .EUt(VA[EV])
    .buildAndRegister();

CVD.recipeBuilder()
    .inputs(ore('wireFineGold') * 64)
    .fluidInputs(fluid('methane') * 1000)
    .outputs(ore('wireFineGrapheneCoatedGold') * 64)
    .duration(200)
    .EUt(VA[EV])
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('wireFineGrapheneCoatedGold') * 16)
    .fluidInputs(fluid('polyethylene_terephthalate') * 36)
    .outputs(metaitem('wireFineEnamelledGrapheneCoatedGold') * 16)
    .duration(80)
    .EUt(VA[MV])
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('cableGtDoublePlatinum') * 2)
    .inputs(ore('stickLongTungstenSteel'))
    .inputs(ore('plateNeodymiumAlloyMagnetic') * 3)
    .inputs(ore('wireFineEnamelledGrapheneCoatedGold') * 64)
    .inputs(metaitem('plate.high_power_integrated_circuit'))
    .inputs(ore('circuitIv'))
    .inputs(metaitem('circuit_board.extreme'))
    .outputs(metaitem('electric.motor.iv') * 3)
    .duration(80)
    .EUt(VA[EV])
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
