import globals.Globals
import globals.SinteringGlobals

ABS = recipemap('alloy_blast_smelter')
FORMING_PRESS = recipemap("forming_press")

//NEODYMIUM MAGNETS

mods.gregtech.mixer.recipeBuilder()
        .inputs(ore('dustNeodymium') * 2)
        .inputs(ore('dustIron') * 14)
        .inputs(ore('dustBoron') * 1)
        .outputs(metaitem('dustNeodymiumAlloy') * 17)
        .duration(400)
        .EUt(256)
        .buildAndRegister();

mods.gregtech.electrolyzer.recipeBuilder()
        .fluidInputs(fluid('sulfuric_acid') * 100)
        .inputs(ore('ingotNeodymiumAlloy'))
        .inputs(ore('dustSmallNickel') * 1)
        .inputs(ore('dustTinyBoricAcid') * 1)
        .outputs(metaitem('ingotTreatedNeodymiumAlloy'))
        .duration(120)
        .EUt(256)
        .buildAndRegister();

mods.gregtech.electrolyzer.recipeBuilder()
        .fluidInputs(fluid('sulfuric_acid') * 100)
        .inputs(ore('plateNeodymiumAlloy'))
        .inputs(ore('dustSmallNickel') * 1)
        .inputs(ore('dustTinyBoricAcid') * 1)
        .outputs(metaitem('plateTreatedNeodymiumAlloy'))
        .duration(120)
        .EUt(256)
        .buildAndRegister();

mods.gregtech.electrolyzer.recipeBuilder()
        .fluidInputs(fluid('sulfuric_acid') * 100)
        .inputs(ore('stickNeodymiumAlloy'))
        .inputs(ore('dustSmallNickel') * 1)
        .inputs(ore('dustTinyBoricAcid') * 1)
        .outputs(metaitem('stickTreatedNeodymiumAlloy'))
        .duration(120)
        .EUt(256)
        .buildAndRegister();

mods.gregtech.electrolyzer.recipeBuilder()
        .fluidInputs(fluid('sulfuric_acid') * 100)
        .inputs(ore('stickLongNeodymiumAlloy'))
        .inputs(ore('dustSmallNickel') * 1)
        .inputs(ore('dustTinyBoricAcid') * 1)
        .outputs(metaitem('stickLongTreatedNeodymiumAlloy'))
        .duration(120)
        .EUt(256)
        .buildAndRegister();

mods.gregtech.electrolyzer.recipeBuilder()
        .fluidInputs(fluid('sulfuric_acid') * 100)
        .inputs(ore('ringNeodymiumAlloy'))
        .inputs(ore('dustSmallNickel') * 1)
        .inputs(ore('dustTinyBoricAcid') * 1)
        .outputs(metaitem('ringTreatedNeodymiumAlloy'))
        .duration(120)
        .EUt(256)
        .buildAndRegister();

//SAMARIUM MAGNETS

ABS.recipeBuilder()
        .inputs(ore('dustSamarium'))
        .inputs(ore('dustCobalt') * 5)
        .fluidInputs(fluid('argon') * 300)
        .fluidOutputs(fluid('samarium_alloy') * 864)
        .blastFurnaceTemp(1800)
        .duration(300)
        .EUt(1920)
        .buildAndRegister();

FORMING_PRESS.recipeBuilder()
        .notConsumable(metaitem('shape.mold.long_rod'))
        .inputs(ore('dustSamariumAlloy'))
        .outputs(metaitem('stickLongSamariumAlloy'))
        .duration(200)
        .EUt(240)
        .buildAndRegister()

FORMING_PRESS.recipeBuilder()
        .notConsumable(metaitem('shape.mold.ring'))
        .inputs(ore('dustSamariumAlloy'))
        .outputs(metaitem('ringSamariumAlloy') * 4)
        .duration(200)
        .EUt(240)
        .buildAndRegister()

FORMING_PRESS.recipeBuilder()
        .notConsumable(metaitem('shape.mold.rod'))
        .inputs(ore('dustSamariumAlloy'))
        .outputs(metaitem('stickSamariumAlloy') * 2)
        .duration(200)
        .EUt(240)
        .buildAndRegister()

FORMING_PRESS.recipeBuilder()
        .notConsumable(metaitem('shape.mold.plate'))
        .inputs(ore('dustSamariumAlloy'))
        .outputs(metaitem('plateSamariumAlloy'))
        .duration(200)
        .EUt(240)
        .buildAndRegister()

FORMING_PRESS.recipeBuilder()
        .notConsumable(metaitem('shape.mold.ingot'))
        .inputs(ore('dustSamariumAlloy'))
        .outputs(metaitem('ingotSamariumAlloy'))
        .duration(200)
        .EUt(240)
        .buildAndRegister()

mods.gregtech.electrolyzer.recipeBuilder()
        .fluidInputs(fluid('sulfuric_acid') * 100)
        .inputs(ore('ingotSamariumAlloy'))
        .inputs(ore('dustSmallNickel') * 1)
        .inputs(ore('dustTinyBoricAcid') * 1)
        .outputs(metaitem('ingotTreatedSamariumAlloy'))
        .duration(120)
        .EUt(256)
        .buildAndRegister();

mods.gregtech.electrolyzer.recipeBuilder()
        .fluidInputs(fluid('sulfuric_acid') * 100)
        .inputs(ore('plateSamariumAlloy'))
        .inputs(ore('dustSmallNickel') * 1)
        .inputs(ore('dustTinyBoricAcid') * 1)
        .outputs(metaitem('plateTreatedSamariumAlloy'))
        .duration(120)
        .EUt(256)
        .buildAndRegister();

mods.gregtech.electrolyzer.recipeBuilder()
        .fluidInputs(fluid('sulfuric_acid') * 100)
        .inputs(ore('stickSamariumAlloy'))
        .inputs(ore('dustSmallNickel') * 1)
        .inputs(ore('dustTinyBoricAcid') * 1)
        .outputs(metaitem('stickTreatedSamariumAlloy'))
        .duration(120)
        .EUt(256)
        .buildAndRegister();

mods.gregtech.electrolyzer.recipeBuilder()
        .fluidInputs(fluid('sulfuric_acid') * 100)
        .inputs(ore('stickLongSamariumAlloy'))
        .inputs(ore('dustSmallNickel') * 1)
        .inputs(ore('dustTinyBoricAcid') * 1)
        .outputs(metaitem('stickLongTreatedSamariumAlloy'))
        .duration(120)
        .EUt(256)
        .buildAndRegister();

mods.gregtech.electrolyzer.recipeBuilder()
        .fluidInputs(fluid('sulfuric_acid') * 100)
        .inputs(ore('ringSamariumAlloy'))
        .inputs(ore('dustSmallNickel') * 1)
        .inputs(ore('dustTinyBoricAcid') * 1)
        .outputs(metaitem('ringTreatedSamariumAlloy'))
        .duration(120)
        .EUt(256)
        .buildAndRegister();

//REPLACE MAGNETIC STUFF IN RECIPES

// IV Electric Motor * 1
mods.gregtech.assembler.removeByInput(30, [metaitem('cableGtDoubleTungsten') * 2, metaitem('stickTungstenSteel') * 2, metaitem('stickNeodymiumMagnetic'), metaitem('wireGtDoubleGraphene') * 4], null)
// EV Electric Motor * 1
mods.gregtech.assembler.removeByInput(30, [metaitem('cableGtDoubleAluminium') * 2, metaitem('stickTitanium') * 2, metaitem('stickNeodymiumMagnetic'), metaitem('wireGtDoubleKanthal') * 4], null)
// Extreme Voltage Coil * 1
mods.gregtech.assembler.removeByInput(1920, [metaitem('stickNeodymiumMagnetic'), metaitem('wireFineTungstenSteel') * 16, metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)
// Insane Voltage Coil * 1
mods.gregtech.assembler.removeByInput(7680, [metaitem('stickNeodymiumMagnetic'), metaitem('wireFineIridium') * 16, metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)
// Ludicrous Voltage Coil * 1
mods.gregtech.assembler.removeByInput(30720, [metaitem('stickSamariumMagnetic'), metaitem('wireFineOsmiridium') * 16, metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)
// Zero Point Module Voltage Coil * 1
mods.gregtech.assembler.removeByInput(122880, [metaitem('stickSamariumMagnetic'), metaitem('wireFineEuropium') * 16, metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)
// Ultimate Voltage Coil * 1
mods.gregtech.assembler.removeByInput(491520, [metaitem('stickSamariumMagnetic'), metaitem('wireFineTritanium') * 16, metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)
// LuV Electric Motor * 1
mods.gregtech.assembly_line.removeByInput(6000, [metaitem('stickLongSamariumMagnetic'), metaitem('stickLongHsss') * 2, metaitem('ringHsss') * 2, metaitem('roundHsss') * 4, metaitem('wireFineRuridit') * 64, metaitem('cableGtSingleNiobiumTitanium') * 2], [fluid('soldering_alloy') * 144, fluid('lubricant') * 250])
// ZPM Electric Motor * 1
mods.gregtech.assembly_line.removeByInput(24000, [metaitem('stickLongSamariumMagnetic'), metaitem('stickLongOsmiridium') * 4, metaitem('ringOsmiridium') * 4, metaitem('roundOsmiridium') * 8, metaitem('wireFineEuropium') * 64, metaitem('wireFineEuropium') * 32, metaitem('cableGtSingleVanadiumGallium') * 2], [fluid('soldering_alloy') * 288, fluid('lubricant') * 500])
// UV Electric Motor * 1
mods.gregtech.assembly_line.removeByInput(100000, [metaitem('stickLongSamariumMagnetic'), metaitem('stickLongTritanium') * 4, metaitem('ringTritanium') * 4, metaitem('roundTritanium') * 8, metaitem('wireFineAmericium') * 64, metaitem('wireFineAmericium') * 64, metaitem('cableGtSingleYttriumBariumCuprate') * 2], [fluid('soldering_alloy') * 576, fluid('lubricant') * 1000, fluid('naquadria') * 576])

crafting.replaceShaped('gregtech:electric_motor_ev', metaitem('electric.motor.ev'), [
        [metaitem('cableGtDoubleAluminium'), metaitem('wireGtDoubleKanthal'), metaitem('stickTitanium')],
        [metaitem('wireGtDoubleKanthal'), metaitem('stickSteelMagnetic'), metaitem('wireGtDoubleKanthal')],
        [metaitem('stickTitanium'), metaitem('wireGtDoubleKanthal'), metaitem('cableGtDoubleAluminium')]
])

crafting.replaceShaped('gregtech:electric_motor_iv', metaitem('electric.motor.iv'), [
        [metaitem('cableGtDoubleTungsten'), metaitem('wireGtDoubleGraphene'), metaitem('stickTungstenSteel')],
        [metaitem('wireGtDoubleGraphene'), metaitem('stickNeodymiumAlloyMagnetic'), metaitem('wireGtDoubleGraphene')],
        [metaitem('stickTungstenSteel'), metaitem('wireGtDoubleGraphene'), metaitem('cableGtDoubleTungsten')]
])

crafting.replaceShaped('gregtech:magnet_hv_battery.re.hv.sodium', metaitem('item_magnet.hv'), [
        [metaitem('stickNeodymiumAlloyMagnetic'), ore('toolWrench'), metaitem('stickNeodymiumAlloyMagnetic')],
        [metaitem('stickNeodymiumAlloyMagnetic'), metaitem('battery.re.hv.sodium'), metaitem('stickNeodymiumAlloyMagnetic')],
        [metaitem('wireGtSingleGold'), metaitem('plateStainlessSteel'), metaitem('wireGtSingleGold')]
])

crafting.replaceShaped('gregtech:magnet_hv_battery.re.hv.lithium', metaitem('item_magnet.hv'), [
        [metaitem('stickNeodymiumAlloyMagnetic'), ore('toolWrench'), metaitem('stickNeodymiumAlloyMagnetic')],
        [metaitem('stickNeodymiumAlloyMagnetic'), metaitem('battery.re.hv.lithium'), metaitem('stickNeodymiumAlloyMagnetic')],
        [metaitem('wireGtSingleGold'), metaitem('plateStainlessSteel'), metaitem('wireGtSingleGold')]
])

crafting.replaceShaped('gregtech:magnet_hv_battery.re.hv.cadmium', metaitem('item_magnet.hv'), [
        [metaitem('stickNeodymiumAlloyMagnetic'), ore('toolWrench'), metaitem('stickNeodymiumAlloyMagnetic')],
        [metaitem('stickNeodymiumAlloyMagnetic'), metaitem('battery.re.hv.cadmium'), metaitem('stickNeodymiumAlloyMagnetic')],
        [metaitem('wireGtSingleGold'), metaitem('plateStainlessSteel'), metaitem('wireGtSingleGold')]
])

crafting.replaceShaped('gregtech:magnet_hv_energy_crystal', metaitem('item_magnet.hv'), [
        [metaitem('stickNeodymiumAlloyMagnetic'), ore('toolWrench'), metaitem('stickNeodymiumAlloyMagnetic')],
        [metaitem('stickNeodymiumAlloyMagnetic'), metaitem('energy_crystal'), metaitem('stickNeodymiumAlloyMagnetic')],
        [metaitem('wireGtSingleGold'), metaitem('plateStainlessSteel'), metaitem('wireGtSingleGold')]
])

crafting.replaceShaped('gregtech:gregtech.machine.electromagnetic_separator.ev', metaitem('electromagnetic_separator.ev'), [
        [metaitem('conveyor.module.ev'), metaitem('cableGtSingleAluminium'), metaitem('wireGtQuadrupleNichrome')],
        [metaitem('cableGtSingleAluminium'), metaitem('hull.ev'), metaitem('stickSteelMagnetic')],
        [ore('circuitEv'), metaitem('cableGtSingleAluminium'), metaitem('wireGtQuadrupleNichrome')]
])

crafting.replaceShaped('gregtech:gregtech.machine.electromagnetic_separator.iv', metaitem('electromagnetic_separator.iv'), [
        [metaitem('conveyor.module.iv'), metaitem('cableGtSinglePlatinum'), metaitem('wireGtQuadrupleTungstenSteel')],
        [metaitem('cableGtSinglePlatinum'), metaitem('hull.iv'), metaitem('stickNeodymiumAlloyMagnetic')],
        [ore('circuitIv'), metaitem('cableGtSinglePlatinum'), metaitem('wireGtQuadrupleTungstenSteel')]
])

crafting.replaceShaped('gregtech:gregtech.machine.polarizer.ev', metaitem('polarizer.ev'), [
        [metaitem('wireGtQuadrupleNichrome'), metaitem('stickSteelMagnetic'), metaitem('wireGtQuadrupleNichrome')],
        [metaitem('cableGtSingleAluminium'), metaitem('hull.ev'), metaitem('cableGtSingleAluminium')],
        [metaitem('wireGtQuadrupleNichrome'), metaitem('stickSteelMagnetic'), metaitem('wireGtQuadrupleNichrome')]
])

crafting.replaceShaped('gregtech:gregtech.machine.polarizer.iv', metaitem('polarizer.iv'), [
        [metaitem('wireGtQuadrupleTungstenSteel'), metaitem('stickNeodymiumAlloyMagnetic'), metaitem('wireGtQuadrupleTungstenSteel')],
        [metaitem('cableGtSinglePlatinum'), metaitem('hull.iv'), metaitem('cableGtSinglePlatinum')],
        [metaitem('wireGtQuadrupleTungstenSteel'), metaitem('stickNeodymiumAlloyMagnetic'), metaitem('wireGtQuadrupleTungstenSteel')]
])

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('cableGtDoubleAluminium') * 2)
        .inputs(ore('stickTitanium') * 2)
        .inputs(ore('stickSteelMagnetic') * 1)
        .inputs(ore('wireGtDoubleKanthal') * 4)
        .outputs(metaitem('electric.motor.ev'))
        .duration(100)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('cableGtDoubleTungsten') * 2)
        .inputs(ore('stickTungstenSteel') * 2)
        .inputs(ore('stickNeodymiumAlloyMagnetic') * 1)
        .inputs(ore('wireGtDoubleGraphene') * 4)
        .outputs(metaitem('electric.motor.iv'))
        .duration(100)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('stickSteelMagnetic') * 1)
        .inputs(ore('wireFineTungstenSteel') * 16)
        .outputs(metaitem('voltage_coil.ev'))
        .duration(200)
        .EUt(1920)
        .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('stickNeodymiumAlloyMagnetic') * 1)
        .inputs(ore('wireFineIridium') * 16)
        .outputs(metaitem('voltage_coil.iv'))
        .duration(200)
        .EUt(7680)
        .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('stickSamariumAlloyMagnetic') * 1)
        .inputs(ore('wireFineOsmiridium') * 16)
        .outputs(metaitem('voltage_coil.luv'))
        .duration(200)
        .EUt(30720)
        .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('stickSamariumAlloyMagnetic') * 1)
        .inputs(ore('wireFineEuropium') * 16)
        .outputs(metaitem('voltage_coil.zpm'))
        .duration(200)
        .EUt(122880)
        .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('stickSamariumAlloyMagnetic') * 1)
        .inputs(ore('wireFineTritanium') * 16)
        .outputs(metaitem('voltage_coil.uv'))
        .duration(200)
        .EUt(491520)
        .buildAndRegister();

mods.gregtech.assembly_line.recipeBuilder()
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

mods.gregtech.assembly_line.recipeBuilder()
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

mods.gregtech.assembly_line.recipeBuilder()
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

mods.gregtech.polarizer.recipeBuilder()
        .inputs(ore('stickLongTreatedSamariumAlloy'))
        .outputs(metaitem('stickLongSamariumAlloyMagnetic'))
        .duration(150)
        .EUt(240)
        .buildAndRegister();

mods.gregtech.polarizer.recipeBuilder()
        .inputs(ore('stickTreatedSamariumAlloy'))
        .outputs(metaitem('stickSamariumAlloyMagnetic'))
        .duration(75)
        .EUt(240)
        .buildAndRegister();

mods.gregtech.polarizer.recipeBuilder()
        .inputs(ore('ringTreatedSamariumAlloy'))
        .outputs(metaitem('ringSamariumAlloyMagnetic'))
        .duration(40)
        .EUt(240)
        .buildAndRegister();

mods.gregtech.polarizer.recipeBuilder()
        .inputs(ore('ingotTreatedSamariumAlloy'))
        .outputs(metaitem('ingotSamariumAlloyMagnetic'))
        .duration(150)
        .EUt(240)
        .buildAndRegister();

mods.gregtech.polarizer.recipeBuilder()
        .inputs(ore('plateTreatedSamariumAlloy'))
        .outputs(metaitem('plateSamariumAlloyMagnetic'))
        .duration(150)
        .EUt(240)
        .buildAndRegister();

mods.gregtech.polarizer.recipeBuilder()
        .inputs(ore('stickLongTreatedNeodymiumAlloy'))
        .outputs(metaitem('stickLongNeodymiumAlloyMagnetic'))
        .duration(150)
        .EUt(240)
        .buildAndRegister();

mods.gregtech.polarizer.recipeBuilder()
        .inputs(ore('stickTreatedNeodymiumAlloy'))
        .outputs(metaitem('stickNeodymiumAlloyMagnetic'))
        .duration(75)
        .EUt(240)
        .buildAndRegister();

mods.gregtech.polarizer.recipeBuilder()
        .inputs(ore('ringTreatedNeodymiumAlloy'))
        .outputs(metaitem('ringNeodymiumAlloyMagnetic'))
        .duration(40)
        .EUt(240)
        .buildAndRegister();

mods.gregtech.polarizer.recipeBuilder()
        .inputs(ore('ingotTreatedNeodymiumAlloy'))
        .outputs(metaitem('ingotNeodymiumAlloyMagnetic'))
        .duration(150)
        .EUt(240)
        .buildAndRegister();

mods.gregtech.polarizer.recipeBuilder()
        .inputs(ore('plateTreatedNeodymiumAlloy'))
        .outputs(metaitem('plateNeodymiumAlloyMagnetic'))
        .duration(150)
        .EUt(240)
        .buildAndRegister();
