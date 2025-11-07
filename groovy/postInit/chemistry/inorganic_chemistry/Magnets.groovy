import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*
import postInit.utils.RecyclingHelper

// Iron & steel magnets (LV-MV)

def voltaic_pile_ingredients = [
    [null, metaitem('electrolyte_paper'), null],
    [null, metaitem('plateZinc'), null],
    [null, metaitem('plateCopper'), null]
]

def iron_magnetic_rod_ingredients = [
    [metaitem('voltaic_pile').reuse(), metaitem('wireGtSingleCopper').reuse(), metaitem('springCopper').reuse()],
    [null, null, metaitem('hot_iron_rod')],
    [null, null, null]
]

def magnetic_plate_ingredients = [
    [metaitem('voltaic_pile').reuse(), metaitem('wireGtSingleCopper').reuse(), metaitem('springCopper').reuse()],
    [null, null, metaitem('hot_steel_plate')],
    [null, null, null]
]

def steel_magnetic_rod_ingredients = [
    [metaitem('voltaic_pile').reuse(), metaitem('wireGtSingleCopper').reuse(), metaitem('springCopper').reuse()],
    [null, null, metaitem('hot_steel_rod')],
    [null, null, null]
]

oreDict.add('electrolyteFruit', metaitem('gregtechfoodoption:food.lime'))
oreDict.add('electrolyteFruit', metaitem('gregtechfoodoption:food.lemon'))
oreDict.add('electrolyteFruit', metaitem('gregtechfoodoption:food.orange'))

crafting.removeByOutput(metaitem('stickIronMagnetic')) 
furnace.add(metaitem('stickIron'), metaitem('hot_iron_rod'))
furnace.add(metaitem('plateSteel'), metaitem('hot_steel_plate'))
furnace.add(metaitem('stickSteel'), metaitem('hot_steel_rod'))

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

crafting.addShapeless('MagneticSteelDuplication',metaitem('stickSteelMagnetic') * 2, [
    metaitem('hot_steel_rod'), 
    metaitem('stickSteelMagnetic')
])

crafting.addShapeless('SteelPlateDuplication',metaitem('plateSteelMagnetic') * 2, [
    metaitem('hot_steel_plate'),
    metaitem('plateSteelMagnetic')
])

crafting.addShapeless('MagneticIronMagnetite',metaitem('stickIronMagnetic'), [
    metaitem('hot_iron_rod'), 
    metaitem('chunk.magnetite')
])

crafting.addShapeless('MagneticSteelMagnetite',metaitem('stickSteelMagnetic'), [
    metaitem('hot_steel_rod'), 
    metaitem('chunk.magnetite')
])

crafting.addShapeless('SteelPlateMagnetite',metaitem('plateSteelMagnetic'), [
    metaitem('hot_steel_plate'),
    metaitem('chunk.magnetite')
])

crafting.addShaped('MagneticIronRodVoltaic',metaitem('stickIronMagnetic'), iron_magnetic_rod_ingredients)
crafting.addShaped('MagneticPlateVoltaic',metaitem('plateSteelMagnetic'), magnetic_plate_ingredients)
crafting.addShaped('MagneticSteelRodVoltaic',metaitem('stickSteelMagnetic'), steel_magnetic_rod_ingredients)
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
    .EUt(VA[MV])
    .buildAndRegister();

// Neodymium magnets (IV)

MIXER.recipeBuilder()
    .inputs(ore('dustNeodymium') * 2)
    .inputs(ore('dustIron') * 14)
    .inputs(ore('dustBoron') * 1)
    .outputs(metaitem('dustNeodymiumAlloy') * 17)
    .duration(400)
    .EUt(VA[EV])
    .buildAndRegister();

// Samarium magnets (LuV)

MIXER.recipeBuilder()
    .inputs(ore('dustSamarium'))
    .inputs(ore('dustCobalt') * 5)
    .outputs(metaitem('dustSamariumAlloy') * 6)
    .duration(400)
    .EUt(VA[IV])
    .buildAndRegister();

def materials = [
    'ingot',
    'plate',
    'stickLong',
    'stick',
    'ring'
]

for (material in materials) {
    ELECTROLYTIC_CELL.recipeBuilder()
        .fluidInputs(fluid('sulfuric_acid') * 800)
        .inputs(ore(material + 'NeodymiumAlloy') * 8)
        .inputs(ore('dustNickel') * 2)
        .inputs(ore('dustBoricAcid'))
        .outputs(metaitem(material + 'TreatedNeodymiumAlloy') * 8)
        .duration(960)
        .EUt(VA[EV])
        .buildAndRegister();

    ELECTROLYTIC_CELL.recipeBuilder()
        .fluidInputs(fluid('sulfuric_acid') * 800)
        .inputs(ore(material + 'SamariumAlloy') * 8)
        .inputs(ore('dustNickel') * 2)
        .inputs(ore('dustBoricAcid'))
        .outputs(metaitem(material + 'TreatedSamariumAlloy') * 8)
        .duration(960)
        .EUt(VA[IV])
        .buildAndRegister();
    
    // Magnetization

    POLARIZER.recipeBuilder() 
        .inputs(ore(material + 'Alnico'))
        .outputs(metaitem(material + 'AlnicoMagnetic'))
        .duration(80)
        .EUt(VA[MV])
        .buildAndRegister();

    POLARIZER.recipeBuilder()
        .inputs(ore(material + 'TreatedNeodymiumAlloy'))
        .outputs(metaitem(material + 'NeodymiumAlloyMagnetic'))
        .duration(80)
        .EUt(VA[EV])
        .buildAndRegister();

    POLARIZER.recipeBuilder()
        .inputs(ore(material + 'TreatedSamariumAlloy'))
        .outputs(metaitem(material + 'SamariumAlloyMagnetic'))
        .duration(80)
        .EUt(VA[IV])
        .buildAndRegister();
}

// Samarium-cobalt magnets (LuV)

HOT_ISOSTATIC_PRESS.recipeBuilder()
    .notConsumable(metaitem('shape.mold.ingot'))
    .inputs(ore('dustSamariumAlloy'))
    .outputs(metaitem('ingotSamariumAlloy'))
    .duration(200)
    .EUt(VA[IV])
    .buildAndRegister()

HOT_ISOSTATIC_PRESS.recipeBuilder()
    .notConsumable(metaitem('shape.mold.plate'))
    .inputs(ore('dustSamariumAlloy'))
    .outputs(metaitem('plateSamariumAlloy'))
    .duration(200)
    .EUt(VA[IV])
    .buildAndRegister()

HOT_ISOSTATIC_PRESS.recipeBuilder()
    .notConsumable(metaitem('shape.mold.long_rod'))
    .inputs(ore('dustSamariumAlloy'))
    .outputs(metaitem('stickLongSamariumAlloy'))
    .duration(200)
    .EUt(VA[IV])
    .buildAndRegister()

HOT_ISOSTATIC_PRESS.recipeBuilder()
    .notConsumable(metaitem('shape.mold.rod'))
    .inputs(ore('dustSamariumAlloy'))
    .outputs(metaitem('stickSamariumAlloy') * 2)
    .duration(200)
    .EUt(VA[IV])
    .buildAndRegister()

HOT_ISOSTATIC_PRESS.recipeBuilder()
    .notConsumable(metaitem('shape.mold.ring'))
    .inputs(ore('dustSamariumAlloy'))
    .outputs(metaitem('ringSamariumAlloy') * 4)
    .duration(200)
    .EUt(VA[IV])
    .buildAndRegister()

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
// Magnetic Samarium Rod * 1
mods.gregtech.polarizer.removeByInput(4096, [metaitem('stickSamarium')], null)
// Long Magnetic Samarium Rod * 1
mods.gregtech.polarizer.removeByInput(4096, [metaitem('stickLongSamarium')], null)
// Magnetic Neodymium Rod * 1
mods.gregtech.polarizer.removeByInput(256, [metaitem('stickNeodymium')], null)
// Magnetic Neodymium Ingot * 1
mods.gregtech.polarizer.removeByInput(256, [metaitem('ingotNeodymium')], null)
// Magnetic Samarium Ingot * 1
mods.gregtech.polarizer.removeByInput(4096, [metaitem('ingotSamarium')], null)
// Magnetic Iron Screw * 1
mods.gregtech.polarizer.removeByInput(16, [metaitem('screwIron')], null)

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

// Coils

ASSEMBLER.recipeBuilder()
    .inputs(ore('stickAlnicoMagnetic') * 1)
    .inputs(ore('wireFinePlatinum') * 16)
    .outputs(metaitem('voltage_coil.ev'))
    .duration(200)
    .EUt(VA[EV])
    .buildAndRegister();

RecyclingHelper.removeRecyclingRecipes(metaitem('voltage_coil.ev'))
RecyclingHelper.handleRecycling(metaitem('voltage_coil.ev'), [ore('stickAlnicoMagnetic'), ore('wireFinePlatinum') * 16])
RecyclingHelper.removeRecyclingRecipes(metaitem('energy_hatch.input.ev'))
RecyclingHelper.handleRecycling(metaitem('energy_hatch.input.ev'), [metaitem('hull.ev'), ore('cableGtSingleAluminium') * 2, ore('stickAlnicoMagnetic'), ore('wireFinePlatinum') * 16])
RecyclingHelper.removeRecyclingRecipes(metaitem('energy_hatch.output.ev'))
RecyclingHelper.handleRecycling(metaitem('energy_hatch.output.ev'), [metaitem('hull.ev'), ore('springAluminium') * 2, ore('stickAlnicoMagnetic'), ore('wireFinePlatinum') * 16])

ASSEMBLER.recipeBuilder()
    .inputs(ore('stickNeodymiumAlloyMagnetic') * 1)
    .inputs(ore('wireFineIridium') * 16)
    .outputs(metaitem('voltage_coil.iv'))
    .duration(200)
    .EUt(VA[IV])
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('stickSamariumAlloyMagnetic') * 1)
    .inputs(ore('wireFineOsmiridium') * 16)
    .outputs(metaitem('voltage_coil.luv'))
    .duration(200)
    .EUt(VA[LuV])
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('stickSamariumAlloyMagnetic') * 1)
    .inputs(ore('wireFineEuropium') * 16)
    .outputs(metaitem('voltage_coil.zpm'))
    .duration(200)
    .EUt(VA[ZPM])
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('stickSamariumAlloyMagnetic') * 1)
    .inputs(ore('wireFineTritanium') * 16)
    .outputs(metaitem('voltage_coil.uv'))
    .duration(200)
    .EUt(VA[UV])
    .buildAndRegister();
