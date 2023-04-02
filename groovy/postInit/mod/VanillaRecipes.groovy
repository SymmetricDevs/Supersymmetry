def circuit(x) {
    return metaitem('circuit.integrated').withNbt([Configuration: x])
}

def recipesToRemove = [
    'minecraft:dispenser',
    'gregtech:piston_bronze',
    'gregtech:piston_steel',
    'gregtech:piston_aluminium',
    'gregtech:piston_titanium',
    'quark:hopper',
    'quark:gravisand',
    'quark:ender_watcher',
    'quark:redstone_inductor',
    'quark:redstone_randomizer',
    'minecraft:fermented_spider_eye',
    'minecraft:speckled_melon',
    'minecraft:magma_cream',
    'minecraft:brewing_stand',
    'minecraft:golden_carrot',
    'quark:golden_frog_leg',
    'minecraft:white_bed',
	'minecraft:orange_bed',
	'minecraft:magenta_bed',
	'minecraft:light_blue_bed',
	'minecraft:yellow_bed',
	'minecraft:lime_bed',
	'minecraft:pink_bed',
	'minecraft:gray_bed',
	'minecraft:light_gray_bed',
	'minecraft:cyan_bed',
	'minecraft:purple_bed',
	'minecraft:blue_bed',
	'minecraft:brown_bed',
	'minecraft:green_bed',
	'minecraft:red_bed',
	'minecraft:black_bed',
    'minecraft:enchanting_table',
    'minecraft:ender_chest',
    'minecraft:end_rod',
    'minecraft:end_crystal',
    'quark:glass',
    'quark:stained_glass',
    'quark:stained_glass_1',
    'quark:stained_glass_2',
    'quark:stained_glass_3',
    'quark:stained_glass_4',
    'quark:stained_glass_5',
    'quark:stained_glass_6',
    'quark:stained_glass_7',
    'quark:stained_glass_8',
    'quark:stained_glass_9',
    'quark:stained_glass_10',
    'quark:stained_glass_11',
    'quark:stained_glass_12',
    'quark:stained_glass_13',
    'quark:stained_glass_14',
    'quark:stained_glass_15',
    'rsgauges:misc/switchlinkperl_to_enderpearl',
    'minecraft:ender_eye',
    'minecraft:fire_charge',
    'minecraft:writable_book',
    'agricraft:combine_nugget_diamond',
    'agricraft:combine_nugget_emerald',
    'agricraft:combine_nugget_quartz',
    'minecraft:purple_shulker_box',
    'quark:purple_shulker_box',
	'agricraft:combine_nugget_iron',
	'chisel:uncraft_blockiron',
	'chisel:diamond',
	'chisel:uncraft_blockgold',
	'appliedenergistics2:decorative/quartz_block_pure'
]

for(name in recipesToRemove) {
    crafting.remove(name)
}

def pressurePlateOreMap = [
        'minecraft:stone_pressure_plate':'stone',
        'minecraft:light_weighted_pressure_plate':'plateGold',
        'minecraft:heavy_weighted_pressure_plate':'plateIron',
        'quark:obsidian_pressure_plate':'obsidian'
    ]

def pressurePlateItemMap = [
    'minecraft:wooden_pressure_plate':'minecraft:planks:0',
    'quark:spruce_pressure_plate':'minecraft:planks:1',
    'quark:birch_pressure_plate':'minecraft:planks:2',
    'quark:jungle_pressure_plate':'minecraft:planks:3',
    'quark:acacia_pressure_plate':'minecraft:planks:4',
    'quark:dark_oak_pressure_plate':'minecraft:planks:5'
    ]

def buttonOreMap = [
        'minecraft:stone_button':'stone',
        'quark:iron_button':'plateIron',
        'quark:gold_button':'plateGold'
    ]

def buttonItemMap = [
    'minecraft:wooden_button':'minecraft:planks:0',
    'quark:spruce_button':'minecraft:planks:1',
    'quark:birch_button':'minecraft:planks:2',
    'quark:jungle_button':'minecraft:planks:3',
    'quark:acacia_button':'minecraft:planks:4',
    'quark:dark_oak_button':'minecraft:planks:5'
]

for (entry in pressurePlateItemMap) {
    crafting.replaceShaped(entry.key, item(entry.key), [
        [item(entry.value), item(entry.value), null],
        [ore('springSteel'), ore('springSteel'), null],
        [ore('dustRedstone'), ore('dustRedstone'), null]
    ])
}

for (entry in pressurePlateOreMap) {
    crafting.replaceShaped(entry.key, item(entry.key), [
        [ore(entry.value), ore(entry.value), null],
        [ore('springSteel'), ore('springSteel'), null],
        [ore('dustRedstone'), ore('dustRedstone'), null]
    ])
}

for (entry in buttonOreMap) {
    crafting.replaceShaped(entry.key, item(entry.key), [
        [ore(entry.value), null, null],
        [ore('springSmallSteel'), null, null],
        [ore('dustRedstone'), null, null]
    ])
}

for (entry in buttonItemMap) {
    crafting.replaceShaped(entry.key, item(entry.key), [
        [item(entry.value), null, null],
        [ore('springSmallSteel'), null, null],
        [ore('dustRedstone'), null, null]
    ])
}

crafting.replaceShaped('minecraft:dispenser', item('minecraft:dispenser'), [
	[ore('cobblestone'), ore('gearIron'), ore('cobblestone')],
	[ore('string'), ore('springSteel'), metaitem('electric.motor.lv')],//metaitem('electric.motor.lv')
	[ore('cobblestone'), ore('wireFineRedAlloy'), ore('cobblestone')]
])

crafting.replaceShaped('minecraft:noteblock', item('minecraft:noteblock'), [
    [ore('plankWood'), ore('leather'), ore('plankWood')],
    [ore('wireFineRedAlloy'), ore('stickIronMagnetic'), ore('wireFineRedAlloy')],
    [ore('plankWood'), ore('leather'), ore('plankWood')]
])

crafting.replaceShaped('minecraft:piston', item('minecraft:piston'),  [
    [ore('plankWood'), ore('plankWood'), ore('plankWood')],
    [ore('cobblestone'), metaitem('electric.piston.lv'), ore('cobblestone')],
    [ore('cobblestone'), ore('wireFineRedAlloy'), ore('cobblestone')]
])

crafting.replaceShaped('minecraft:lever', item('minecraft:lever'), [
    [null, ore('stickWood'), ore('craftingToolHardHammer')],
    [ore('ringIron'), ore('cobblestone'), ore('screwIron')],
    [null, ore('dustRedstone'), ore('craftingToolScrewdriver')]
])

crafting.replaceShaped('minecraft:tripwire_hook', item('minecraft:tripwire_hook') * 2, [
    [null, ore('ringIron'), null],
    [ore('springSmallIron'), ore('stickWood'), null],
    [ore('dustRedstone'), ore('cobblestone'), null]
])

crafting.replaceShaped('quark:iron_rod', item('quark:iron_rod'), [
    [null, ore('stickIron'), null],
    [null, ore('stickIron'), null],
    [null, ore('stickIron'), null]
])

crafting.replaceShaped('minecraft:redstone_lamp', item('minecraft:redstone_lamp'), [
    [null, ore('plateRedstone'), null],
    [ore('plateRedstone'), ore('blockGlowstone'), ore('plateRedstone')],
    [null, ore('plateRedstone'), null]
])

crafting.replaceShaped('minecraft:dropper', item('minecraft:dropper'), [
	[ore('cobblestone'), ore('cobblestone'), ore('cobblestone')],
	[ore('cobblestone'), metaitem('electric.piston.lv'), null],
	[ore('cobblestone'), ore('wireFineRedAlloy'), ore('cobblestone')]
])

crafting.replaceShaped('minecraft:repeater', item('minecraft:repeater'), [
    [item('minecraft:redstone_torch'), ore('wireFineRedAlloy'), item('minecraft:redstone_torch')],
    [ore('plateStone'), ore('plateStone'), ore('plateStone')]
])

crafting.replaceShaped('minecraft:comparator', item('minecraft:comparator'), [
    [null, item('minecraft:redstone_torch'), null],
    [item('minecraft:redstone_torch'), ore('wireFineRedAlloy'), item('minecraft:redstone_torch')],
    [ore('plateStone'), ore('plateNetherQuartz'), ore('plateStone')]
])

crafting.replaceShaped('appliedenergistics2:misc/vanilla_comparator', item('minecraft:comparator'), [
    [null, item('minecraft:redstone_torch'), null],
    [item('minecraft:redstone_torch'), ore('wireFineRedAlloy'), item('minecraft:redstone_torch')],
    [ore('plateStone'), ore('plateCertusQuartz'), ore('plateStone')]
])

crafting.replaceShaped('gregtech:comparator_quartzite', item('minecraft:comparator'), [
    [null, item('minecraft:redstone_torch'), null],
    [item('minecraft:redstone_torch'), ore('wireFineRedAlloy'), item('minecraft:redstone_torch')],
    [ore('plateStone'), ore('plateQuartzite'), ore('plateStone')]
])

crafting.replaceShaped('minecraft:daylight_detector', item('minecraft:daylight_detector'), [
    [ore('plateNetherQuartz'), ore('plateNetherQuartz'), ore('plateNetherQuartz')],
    [ore('wireFineRedAlloy'), ore('wireFineRedAlloy'), ore('wireFineRedAlloy')],
    [ore('plankWood'), ore('plankWood'), ore('plankWood')]
])

crafting.replaceShaped('appliedenergistics2:misc/vanilla_daylight_detector', item('minecraft:daylight_detector'), [
    [ore('plateCertusQuartz'), ore('plateCertusQuartz'), ore('plateCertusQuartz')],
    [ore('wireFineRedAlloy'), ore('wireFineRedAlloy'), ore('wireFineRedAlloy')],
    [ore('plankWood'), ore('plankWood'), ore('plankWood')]
])

crafting.replaceShaped('gregtech:daylight_detector_quartzite', item('minecraft:daylight_detector'), [
    [ore('plateQuartzite'), ore('plateQuartzite'), ore('plateQuartzite')],
    [ore('wireFineRedAlloy'), ore('wireFineRedAlloy'), ore('wireFineRedAlloy')],
    [ore('plankWood'), ore('plankWood'), ore('plankWood')]
])

crafting.replaceShaped('minecraft:observer', item('minecraft:observer'), [
    [ore('cobblestone'), ore('cobblestone'), ore('cobblestone')],
    [ore('wireFineRedAlloy'), ore('wireFineRedAlloy'), ore('plateNetherQuartz')],
    [ore('cobblestone'), ore('cobblestone'), ore('cobblestone')]
])

crafting.replaceShaped('quark:rain_detector', item('quark:rain_detector'), [
    [ore('wireFineRedAlloy'), ore('wireFineRedAlloy'), ore('wireFineRedAlloy')],
    [ore('plateNetherQuartz'), ore('plateNetherQuartz'), ore('plateNetherQuartz')],
    [ore('cobblestone'), ore('cobblestone'), ore('cobblestone')]
])

crafting.replaceShaped('quark:iron_ladder', item('quark:iron_ladder') * 16, [
    [ore('stickIron'), ore('craftingToolHardHammer'), ore('stickIron')],
    [ore('stickIron'), ore('stickIron'), ore('stickIron')],
    [ore('stickIron'), ore('craftingToolFile'), ore('stickIron')]
])

crafting.replaceShaped('quark:paper_lantern', item('quark:paper_lantern'), [
    [ore('paper'), ore('stickWood'), ore('paper')],
    [ore('paper'), item('minecraft:torch'), ore('paper')],
    [ore('paper'), ore('stickWood'), ore('paper')]
])

crafting.replaceShaped('quark:framed_glass', item('quark:framed_glass') * 4, [
    [ore('blockGlassColorless'), ore('stickIron'), ore('blockGlassColorless')],
    [ore('stickIron'), ore('blockGlassColorless'), ore('stickIron')],
    [ore('blockGlassColorless'), ore('stickIron'), ore('blockGlassColorless')]
])

crafting.replaceShaped('minecraft:golden_rail', item('minecraft:golden_rail') * 6, [
    [ore('stickGold'), ore('stickSteelMagnetic'), ore('stickGold')],
    [ore('stickGold'), ore('stickWood'), ore('stickGold')],
    [ore('stickGold'), ore('wireFineRedAlloy'), ore('stickGold')]
])

crafting.replaceShaped('minecraft:detector_rail', item('minecraft:detector_rail') * 6, [
    [ore('stickSteel'), null, ore('stickSteel')],
    [ore('stickSteel'), item('minecraft:stone_pressure_plate'), ore('stickSteel')],
    [ore('stickSteel'), null, ore('stickSteel')]
])

crafting.replaceShaped('minecraft:rail', item('minecraft:rail') * 16, [
    [ore('stickSteel'), null, ore('stickSteel')],
    [ore('stickSteel'), ore('stickWood'), ore('stickSteel')],
    [ore('stickSteel'), null, ore('stickSteel')]
])

crafting.replaceShaped('minecraft:activator_rail', item('minecraft:activator_rail') * 6, [
    [ore('stickSteel'), ore('stickWood'), ore('stickSteel')],
    [ore('stickSteel'), item('minecraft:redstone_torch'), ore('stickSteel')],
    [ore('stickSteel'), ore('stickWood'), ore('stickSteel')]
])

crafting.replaceShaped('quark:chain', item('quark:chain') * 3, [
    [ore('ringIron'), null, null],
    [null, ore('ringIron'), null],
    [null, null, ore('ringIron')]
])

/*
crafting.replaceShaped('minecraft:compass', item('minecraft:compass'), [
    [null, ore('plateIron'), null],
    [ore('plateIron'), ore('stickIronMagnetic'), ore('plateIron')],
    [null, ore('plateIron'), null]
])
*/

//GT Machines recipes
//Assembler

// Redstone Repeater * 1
mods.gregtech.assembler.removeByInput(10, [item('minecraft:redstone_torch') * 2, item('minecraft:redstone')], [fluid('concrete') * 144])
mods.gregtech.assembler.recipeBuilder()
    .inputs(ore('wireFineRedAlloy'))
    .inputs(ore('plateStone'))
    .inputs(item('minecraft:redstone_torch') * 2)
    .outputs(item('minecraft:repeater'))
    .duration(20)
    .EUt(16)
    .buildAndRegister()

// Piston
mods.gregtech.assembler.removeByInput(16, [metaitem('plateIron'), item('minecraft:planks') * 3, item('minecraft:cobblestone') * 4, item('minecraft:redstone')], null)
mods.gregtech.assembler.removeByInput(16, [metaitem('plateSteel'), item('minecraft:planks') * 3, item('minecraft:cobblestone') * 4, item('minecraft:redstone')], null)
mods.gregtech.assembler.removeByInput(16, [metaitem('plateAluminium'), item('minecraft:planks') * 3, item('minecraft:cobblestone') * 4, item('minecraft:redstone')], null)
mods.gregtech.assembler.removeByInput(16, [metaitem('plateBronze'), item('minecraft:planks') * 3, item('minecraft:cobblestone') * 4, item('minecraft:redstone')], null)
mods.gregtech.assembler.removeByInput(16, [metaitem('plateTitanium'), item('minecraft:planks') * 3, item('minecraft:cobblestone') * 4, item('minecraft:redstone')], null)
mods.gregtech.assembler.recipeBuilder()
    .inputs(ore('cobblestone') * 4)
    .inputs(ore('plankWood') * 3)
    .inputs(ore('wireFineRedAlloy'))
    .inputs(metaitem('electric.piston.lv'))
    .outputs(item('minecraft:piston'))
    .duration(20)
    .EUt(16)
    .buildAndRegister()

// Dispenser * 1
mods.gregtech.assembler.removeByInput(30, [item('minecraft:cobblestone') * 7, item('minecraft:bow'), item('minecraft:redstone'), circuit(1)], null)
mods.gregtech.assembler.recipeBuilder()
    .inputs(ore('cobblestone'))
    .inputs(ore('springSteel'))
    .inputs(ore('string'))
    .inputs(ore('wireFineRedAlloy'))
    .inputs(metaitem('electric.motor.lv'))
    .outputs(item('minecraft:dispenser'))
    .duration(20)
    .EUt(16)
    .buildAndRegister()

// Dropper * 1
mods.gregtech.assembler.removeByInput(30, [item('minecraft:cobblestone') * 7, item('minecraft:redstone'), circuit(2)], null)
mods.gregtech.assembler.recipeBuilder()
    .inputs(ore('cobblestone'))
    .inputs(ore('wireFineRedAlloy'))
    .inputs(metaitem('electric.piston.lv'))
    .outputs(item('minecraft:dropper'))
    .duration(20)
    .EUt(16)
    .buildAndRegister()

// Enchantment Table * 1
mods.gregtech.assembler.removeByInput(7, [item('minecraft:obsidian') * 4, item('minecraft:diamond') * 2, item('minecraft:book')], null)
// Ender Chest * 1
mods.gregtech.assembler.removeByInput(4, [item('minecraft:obsidian') * 8, item('minecraft:ender_eye')], null)
// End Rod * 4
mods.gregtech.assembler.removeByInput(4, [item('minecraft:chorus_fruit_popped'), item('minecraft:blaze_rod')], null)
// End Crystal * 1
mods.gregtech.assembler.removeByInput(16, [item('minecraft:ghast_tear'), item('minecraft:ender_eye')], [fluid('glass') * 1008])
// Purple Shulker Box * 1
mods.gregtech.assembler.removeByInput(7, [item('minecraft:chest'), item('minecraft:shulker_shell') * 2], null)
// Powered Rail * 12
mods.gregtech.assembler.removeByInput(30, [metaitem('stickGold') * 12, item('minecraft:stick'), item('minecraft:redstone'), circuit(1)], null)
// Detector Rail * 12
mods.gregtech.assembler.removeByInput(30, [metaitem('stickIron') * 12, item('minecraft:stick'), item('minecraft:redstone'), circuit(4)], null)
// Rail * 32
mods.gregtech.assembler.removeByInput(30, [metaitem('stickIron') * 12, item('minecraft:stick'), circuit(1)], null)
mods.gregtech.assembler.recipeBuilder()
    .inputs(ore('stickWood'))
    .fluidInputs(fluid('steel') * 144)
    .outputs(item('minecraft:rail') * 16)
    .duration(20)
    .EUt(10)
    .buildAndRegister()
// Activator Rail * 12
mods.gregtech.assembler.removeByInput(30, [metaitem('stickIron') * 12, item('minecraft:stick') * 2, item('minecraft:redstone_torch'), circuit(4)], null)


//Centrifuge
// Blaze Powder * 1
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:magma_cream')], null)

//Chemical bath
// Eye of Ender * 1
mods.gregtech.chemical_bath.removeByInput(480, [item('minecraft:ender_pearl')], [fluid('blaze') * 144])

//Chemical reactor
// Blaze Powder * 1
mods.gregtech.chemical_reactor.removeByInput(480, [metaitem('dustCarbon'), metaitem('dustSulfur')], null)
// Blaze Powder * 1
mods.gregtech.large_chemical_reactor.removeByInput(480, [metaitem('dustCarbon'), metaitem('dustSulfur')], null)
// Magma Cream * 1
mods.gregtech.chemical_reactor.removeByInput(30, [item('minecraft:blaze_powder'), item('minecraft:slime_ball')], null)
// Magma Cream * 1
mods.gregtech.large_chemical_reactor.removeByInput(30, [item('minecraft:blaze_powder'), item('minecraft:slime_ball')], null)

//Extractor
mods.gregtech.extractor.recipeBuilder()
    .inputs(item('quark:glass_shards:0'))
    .fluidOutputs(fluid('glass') * 36)
    .duration(20)
    .EUt(8)
    .buildAndRegister()

//Mixer
// Fermented Spider Eye * 1
mods.gregtech.mixer.removeByInput(7, [item('minecraft:sugar'), item('minecraft:red_mushroom'), item('minecraft:spider_eye')], null)
// Fermented Spider Eye * 1
mods.gregtech.mixer.removeByInput(7, [item('minecraft:sugar'), item('minecraft:brown_mushroom'), item('minecraft:spider_eye')], null)
// Fire Charge * 3
mods.gregtech.mixer.removeByInput(30, [metaitem('dustCoal'), item('minecraft:gunpowder'), item('minecraft:blaze_powder')], null)
mods.gregtech.mixer.recipeBuilder()
    .inputs(ore('dustCoal'))
    .inputs(ore('dustGunpowder'))
    .inputs(ore('dustMagnesium'))
    .outputs(item('minecraft:fire_charge') * 3)
    .duration(20)
    .EUt(8)
    .buildAndRegister()