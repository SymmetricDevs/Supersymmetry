import globals.Globals
import globals.SinteringGlobals

HOT_ISOSTATIC_PRESS = recipemap('hot_isostatic_press')
MIXER = recipemap('mixer')
ELECTROLYZER = recipemap('electrolyzer')
ASSEMBLER = recipemap('assembler')
ASSEMBLY_LINE = recipemap('assembly_line')
POLARIZER = recipemap('polarizer')

// Iron & steel magnets (LV-MV)

def voltaic_pile_ingredients = [
    [null, metaitem('electrolyte_paper'), null],
    [null, metaitem('plateZinc'), null],
    [null, metaitem('plateCopper'), null]
]

def magnetic_rod_ingredients = [
    [metaitem('voltaic_pile').reuse(), metaitem('wireGtSingleCopper').reuse(), metaitem('springCopper').reuse()],
    [null, null, metaitem('hot_iron_rod')],
    [null, null, null]
]

def magnetic_plate_ingredients = [
    [metaitem('voltaic_pile').reuse(), metaitem('wireGtSingleCopper').reuse(), metaitem('springCopper').reuse()],
    [null, null, metaitem('hot_steel_plate')],
    [null, null, null]
]

oreDict.add('electrolyteFruit', metaitem('gregtechfoodoption:food.lime'))
oreDict.add('electrolyteFruit', metaitem('gregtechfoodoption:food.lemon'))
oreDict.add('electrolyteFruit', metaitem('gregtechfoodoption:food.orange'))

crafting.removeByOutput(metaitem('stickIronMagnetic')) 
furnace.add(metaitem('stickIron'), metaitem('hot_iron_rod'))
furnace.add(metaitem('plateSteel'), metaitem('hot_steel_plate'))

crafting.addShapeless('ElectrolytePaperSalt',metaitem('electrolyte_paper'), [
    item('forge:bucketfilled').withNbt([FluidName: "salt_water", Amount: 1000]),
    item('minecraft:paper')
]) 

crafting.addShapeless('ElectrolytePaperFruit',metaitem('electrolyte_paper'), [
    ore('electrolyteFruit'),
    item('minecraft:paper'),
    ore('craftingToolMortar')
]) 

crafting.addShapeless('MagneticIronDuplication',metaitem('stickIronMagnetic') * 2, [
    metaitem('hot_iron_rod'), 
    metaitem('stickIronMagnetic')
])

crafting.addShapeless('SteelPlateDuplication',metaitem('plateSteelMagnetic') * 2, [
    metaitem('hot_steel_plate'),
    metaitem('plateSteelMagnetic')
])

crafting.addShapeless('MagneticIronMagnetite',metaitem('stickIronMagnetic'), [
    metaitem('hot_iron_rod'), 
    metaitem('chunk.magnetite')
])

crafting.addShapeless('MagneticSteelMagnetite',metaitem('plateSteelMagnetic'), [
    metaitem('hot_steel_plate'),
    metaitem('chunk.magnetite')
])

crafting.addShaped('MagneticRodVoltaic',metaitem('stickIronMagnetic'), magnetic_rod_ingredients)
crafting.addShaped('MagneticPlateVoltaic',metaitem('plateSteelMagnetic'), magnetic_plate_ingredients)
crafting.addShaped('VoltaicPileCrafting',metaitem('voltaic_pile'), voltaic_pile_ingredients)

// Alnico (HV-EV)

MIXER.recipeBuilder()
    .inputs(ore('dustAluminium') * 5)
    .inputs(ore('dustNickel') * 4)
    .inputs(ore('dustCobalt') * 3)
    .inputs(ore('dustCopper'))
    .inputs(ore('dustIron') * 11)
    .outputs(metaitem('dustAlnico') * 24)
    .duration(400)
    .EUt(120)
    .buildAndRegister();

// Neodymium magnets (IV)

MIXER.recipeBuilder()
    .inputs(ore('dustNeodymium') * 2)
    .inputs(ore('dustIron') * 14)
    .inputs(ore('dustBoron') * 1)
    .outputs(metaitem('dustNeodymiumAlloy') * 17)
    .duration(400)
    .EUt(256)
    .buildAndRegister();

ELECTROLYZER.recipeBuilder()
    .fluidInputs(fluid('sulfuric_acid') * 100)
    .inputs(ore('ingotNeodymiumAlloy'))
    .inputs(ore('dustSmallNickel') * 1)
    .inputs(ore('dustTinyBoricAcid') * 1)
    .outputs(metaitem('ingotTreatedNeodymiumAlloy'))
    .duration(120)
    .EUt(256)
    .buildAndRegister();

ELECTROLYZER.recipeBuilder()
    .fluidInputs(fluid('sulfuric_acid') * 100)
    .inputs(ore('plateNeodymiumAlloy'))
    .inputs(ore('dustSmallNickel') * 1)
    .inputs(ore('dustTinyBoricAcid') * 1)
    .outputs(metaitem('plateTreatedNeodymiumAlloy'))
    .duration(120)
    .EUt(256)
    .buildAndRegister();

ELECTROLYZER.recipeBuilder()
    .fluidInputs(fluid('sulfuric_acid') * 100)
    .inputs(ore('stickNeodymiumAlloy') * 2)
    .inputs(ore('dustSmallNickel') * 1)
    .inputs(ore('dustTinyBoricAcid') * 1)
    .outputs(metaitem('stickTreatedNeodymiumAlloy') * 2)
    .duration(120)
    .EUt(256)
    .buildAndRegister();

ELECTROLYZER.recipeBuilder()
    .fluidInputs(fluid('sulfuric_acid') * 100)
    .inputs(ore('stickLongNeodymiumAlloy'))
    .inputs(ore('dustSmallNickel') * 1)
    .inputs(ore('dustTinyBoricAcid') * 1)
    .outputs(metaitem('stickLongTreatedNeodymiumAlloy'))
    .duration(120)
    .EUt(256)
    .buildAndRegister();

ELECTROLYZER.recipeBuilder()
    .fluidInputs(fluid('sulfuric_acid') * 100)
    .inputs(ore('ringNeodymiumAlloy') * 4)
    .inputs(ore('dustSmallNickel') * 1)
    .inputs(ore('dustTinyBoricAcid') * 1)
    .outputs(metaitem('ringTreatedNeodymiumAlloy') * 4)
    .duration(120)
    .EUt(256)
    .buildAndRegister();

// Samarium-cobalt magnets (LuV)

HOT_ISOSTATIC_PRESS.recipeBuilder()
    .notConsumable(metaitem('shape.mold.long_rod'))
    .inputs(ore('dustSamariumAlloy'))
    .outputs(metaitem('stickLongSamariumAlloy'))
    .duration(200)
    .EUt(240)
    .buildAndRegister()

HOT_ISOSTATIC_PRESS.recipeBuilder()
    .notConsumable(metaitem('shape.mold.ring'))
    .inputs(ore('dustSamariumAlloy'))
    .outputs(metaitem('ringSamariumAlloy') * 4)
    .duration(200)
    .EUt(240)
    .buildAndRegister()

HOT_ISOSTATIC_PRESS.recipeBuilder()
    .notConsumable(metaitem('shape.mold.rod'))
    .inputs(ore('dustSamariumAlloy'))
    .outputs(metaitem('stickSamariumAlloy') * 2)
    .duration(200)
    .EUt(240)
    .buildAndRegister()

HOT_ISOSTATIC_PRESS.recipeBuilder()
    .notConsumable(metaitem('shape.mold.plate'))
    .inputs(ore('dustSamariumAlloy'))
    .outputs(metaitem('plateSamariumAlloy'))
    .duration(200)
    .EUt(240)
    .buildAndRegister()

HOT_ISOSTATIC_PRESS.recipeBuilder()
    .notConsumable(metaitem('shape.mold.ingot'))
    .inputs(ore('dustSamariumAlloy'))
    .outputs(metaitem('ingotSamariumAlloy'))
    .duration(200)
    .EUt(240)
    .buildAndRegister()

ELECTROLYZER.recipeBuilder()
    .fluidInputs(fluid('sulfuric_acid') * 100)
    .inputs(ore('ingotSamariumAlloy'))
    .inputs(ore('dustSmallNickel') * 1)
    .inputs(ore('dustTinyBoricAcid') * 1)
    .outputs(metaitem('ingotTreatedSamariumAlloy'))
    .duration(120)
    .EUt(256)
    .buildAndRegister();

ELECTROLYZER.recipeBuilder()
    .fluidInputs(fluid('sulfuric_acid') * 100)
    .inputs(ore('plateSamariumAlloy'))
    .inputs(ore('dustSmallNickel') * 1)
    .inputs(ore('dustTinyBoricAcid') * 1)
    .outputs(metaitem('plateTreatedSamariumAlloy'))
    .duration(120)
    .EUt(256)
    .buildAndRegister();

ELECTROLYZER.recipeBuilder()
    .fluidInputs(fluid('sulfuric_acid') * 100)
    .inputs(ore('stickSamariumAlloy') * 2)
    .inputs(ore('dustSmallNickel') * 1)
    .inputs(ore('dustTinyBoricAcid') * 1)
    .outputs(metaitem('stickTreatedSamariumAlloy') * 2)
    .duration(120)
    .EUt(256)
    .buildAndRegister();

ELECTROLYZER.recipeBuilder()
    .fluidInputs(fluid('sulfuric_acid') * 100)
    .inputs(ore('stickLongSamariumAlloy'))
    .inputs(ore('dustSmallNickel') * 1)
    .inputs(ore('dustTinyBoricAcid') * 1)
    .outputs(metaitem('stickLongTreatedSamariumAlloy'))
    .duration(120)
    .EUt(256)
    .buildAndRegister();

ELECTROLYZER.recipeBuilder()
    .fluidInputs(fluid('sulfuric_acid') * 100)
    .inputs(ore('ringSamariumAlloy') * 4)
    .inputs(ore('dustSmallNickel') * 1)
    .inputs(ore('dustTinyBoricAcid') * 1)
    .outputs(metaitem('ringTreatedSamariumAlloy') * 4)
    .duration(120)
    .EUt(256)
    .buildAndRegister();

// Replace magnetic component recipes

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
    [metaitem('cableGtSingleAluminium'), metaitem('hull.ev'), metaitem('stickAlnicoMagnetic')],
    [ore('circuitEv'), metaitem('cableGtSingleAluminium'), metaitem('wireGtQuadrupleNichrome')]
])

crafting.replaceShaped('gregtech:gregtech.machine.electromagnetic_separator.iv', metaitem('electromagnetic_separator.iv'), [
    [metaitem('conveyor.module.iv'), metaitem('cableGtSinglePlatinum'), metaitem('wireGtQuadrupleTungstenSteel')],
    [metaitem('cableGtSinglePlatinum'), metaitem('hull.iv'), metaitem('stickNeodymiumAlloyMagnetic')],
    [ore('circuitIv'), metaitem('cableGtSinglePlatinum'), metaitem('wireGtQuadrupleTungstenSteel')]
])

crafting.replaceShaped('gregtech:gregtech.machine.polarizer.ev', metaitem('polarizer.ev'), [
    [metaitem('wireGtQuadrupleNichrome'), metaitem('stickAlnicoMagnetic'), metaitem('wireGtQuadrupleNichrome')],
    [metaitem('cableGtSingleAluminium'), metaitem('hull.ev'), metaitem('cableGtSingleAluminium')],
    [metaitem('wireGtQuadrupleNichrome'), metaitem('stickAlnicoMagnetic'), metaitem('wireGtQuadrupleNichrome')]
])

crafting.replaceShaped('gregtech:gregtech.machine.polarizer.iv', metaitem('polarizer.iv'), [
    [metaitem('wireGtQuadrupleTungstenSteel'), metaitem('stickNeodymiumAlloyMagnetic'), metaitem('wireGtQuadrupleTungstenSteel')],
    [metaitem('cableGtSinglePlatinum'), metaitem('hull.iv'), metaitem('cableGtSinglePlatinum')],
    [metaitem('wireGtQuadrupleTungstenSteel'), metaitem('stickNeodymiumAlloyMagnetic'), metaitem('wireGtQuadrupleTungstenSteel')]
])

ASSEMBLER.recipeBuilder()
    .inputs(ore('stickAlnicoMagnetic') * 1)
    .inputs(ore('wireFineTungstenSteel') * 16)
    .outputs(metaitem('voltage_coil.ev'))
    .duration(200)
    .EUt(1920)
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('stickNeodymiumAlloyMagnetic') * 1)
    .inputs(ore('wireFineIridium') * 16)
    .outputs(metaitem('voltage_coil.iv'))
    .duration(200)
    .EUt(7680)
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('stickSamariumAlloyMagnetic') * 1)
    .inputs(ore('wireFineOsmiridium') * 16)
    .outputs(metaitem('voltage_coil.luv'))
    .duration(200)
    .EUt(30720)
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('stickSamariumAlloyMagnetic') * 1)
    .inputs(ore('wireFineEuropium') * 16)
    .outputs(metaitem('voltage_coil.zpm'))
    .duration(200)
    .EUt(122880)
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('stickSamariumAlloyMagnetic') * 1)
    .inputs(ore('wireFineTritanium') * 16)
    .outputs(metaitem('voltage_coil.uv'))
    .duration(200)
    .EUt(491520)
    .buildAndRegister();

// Magnetization

POLARIZER.recipeBuilder()
    .inputs(ore('stickLongAlnico'))
    .outputs(metaitem('stickLongAlnicoMagnetic'))
    .duration(150)
    .EUt(240)
    .buildAndRegister();

POLARIZER.recipeBuilder()
    .inputs(ore('stickAlnico'))
    .outputs(metaitem('stickAlnicoMagnetic'))
    .duration(75)
    .EUt(240)
    .buildAndRegister();

POLARIZER.recipeBuilder()
    .inputs(ore('ringAlnico'))
    .outputs(metaitem('ringAlnicoMagnetic'))
    .duration(40)
    .EUt(240)
    .buildAndRegister();

POLARIZER.recipeBuilder()
    .inputs(ore('ingotAlnico'))
    .outputs(metaitem('ingotAlnicoMagnetic'))
    .duration(150)
    .EUt(240)
    .buildAndRegister();

POLARIZER.recipeBuilder()
    .inputs(ore('plateAlnico'))
    .outputs(metaitem('plateAlnicoMagnetic'))
    .duration(150)
    .EUt(240)
    .buildAndRegister();

POLARIZER.recipeBuilder()
    .inputs(ore('stickLongTreatedNeodymiumAlloy'))
    .outputs(metaitem('stickLongNeodymiumAlloyMagnetic'))
    .duration(150)
    .EUt(960)
    .buildAndRegister();

POLARIZER.recipeBuilder()
    .inputs(ore('stickTreatedNeodymiumAlloy'))
    .outputs(metaitem('stickNeodymiumAlloyMagnetic'))
    .duration(75)
    .EUt(960)
    .buildAndRegister();

POLARIZER.recipeBuilder()
    .inputs(ore('ringTreatedNeodymiumAlloy'))
    .outputs(metaitem('ringNeodymiumAlloyMagnetic'))
    .duration(40)
    .EUt(960)
    .buildAndRegister();

POLARIZER.recipeBuilder()
    .inputs(ore('ingotTreatedNeodymiumAlloy'))
    .outputs(metaitem('ingotNeodymiumAlloyMagnetic'))
    .duration(150)
    .EUt(960)
    .buildAndRegister();

POLARIZER.recipeBuilder()
    .inputs(ore('plateTreatedNeodymiumAlloy'))
    .outputs(metaitem('plateNeodymiumAlloyMagnetic'))
    .duration(150)
    .EUt(960)
    .buildAndRegister();

POLARIZER.recipeBuilder()
    .inputs(ore('stickLongTreatedSamariumAlloy'))
    .outputs(metaitem('stickLongSamariumAlloyMagnetic'))
    .duration(150)
    .EUt(3840)
    .buildAndRegister();

POLARIZER.recipeBuilder()
    .inputs(ore('stickTreatedSamariumAlloy'))
    .outputs(metaitem('stickSamariumAlloyMagnetic'))
    .duration(75)
    .EUt(3840)
    .buildAndRegister();

POLARIZER.recipeBuilder()
    .inputs(ore('ringTreatedSamariumAlloy'))
    .outputs(metaitem('ringSamariumAlloyMagnetic'))
    .duration(40)
    .EUt(3840)
    .buildAndRegister();

POLARIZER.recipeBuilder()
    .inputs(ore('ingotTreatedSamariumAlloy'))
    .outputs(metaitem('ingotSamariumAlloyMagnetic'))
    .duration(150)
    .EUt(3840)
    .buildAndRegister();

POLARIZER.recipeBuilder()
    .inputs(ore('plateTreatedSamariumAlloy'))
    .outputs(metaitem('plateSamariumAlloyMagnetic'))
    .duration(150)
    .EUt(3840)
    .buildAndRegister();