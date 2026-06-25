//For mods with so few recipes they don't need a dedicated file

def name_removals = [
        "scannable:scanner",
        "regeneration:fob_watch",
        "regeneration:fob_watch_2",
        "regeneration:arch",
        "regeneration:hand_jar",
        "regeneration:lindos_vial",
        "tardis:tardis_coral",
	    "tardis:bessie",
        "sync:sync_core",
        "sync:shell_constructor",
        "sync:shell_storage",
        "sync:treadmill",
        "weeping-angels:timey_wimey_dectecterino",
        "weeping-angels:chronodyne_generator",
        'quark:redstone_randomizer',
        "gravitygun:gravitygun",
        "gravitygun:supercharged_gravitygun",
        "portalgun:portalgun",
        'weeping-angels:angel_painting',
        'jecalculation:math_calculator',
        'cyberware:blueprint_archive',
        'cyberware:component_box',
        'cyberware:surgery_chamber',
        'cyberware:charger',
        'cyberware:engineering_table',
        'cyberware:scanner',
        'cyberware:scanner_1',
        'cyberware:beacon',
        'cyberware:radio_post',
        'biomesoplenty:mud_from_dirt',
        'biomesoplenty:terrestrial_artifact',
        'biomesoplenty:biome_finder',
        'biomesoplenty:ruby_block',
        'biomesoplenty:malachite_block',
        'biomesoplenty:sapphire_block',
]

for (name in name_removals) {
    crafting.remove(name)
}

mods.jei.ingredient.yeet(
        item('travelersbackpack:backpack_tank'),
        item('travelersbackpack:sleeping_bag_bottom'),
        item('travelersbackpack:hose_nozzle'),
        item('travelersbackpack:hose'),
        fluid('potion'),
        item('biomesoplenty:biome_block'),
        item('scalinghealth:crystalore'),
        item('tardis:cinnabar_ore'),
        item('rftools:dimensional_shard_ore'),
        item('rftools:dimensional_shard_ore', 1),
        item('rftools:dimensional_shard_ore', 2),
        item('weeping-angels:kontron_ore'),
)

for (i in 0..7) {
    mods.jei.ingredient.yeet(
        item('biomesoplenty:gem_ore', i),
        item('srparasites:infestedore', i)
    )
}

//Easter egg BOP gem blocks
mods.chisel.carving.addGroup("ruby_blocks")
mods.chisel.carving.addVariation("ruby_blocks", item('gregtech:meta_block_compressed_19', 7))
mods.chisel.carving.addVariation("ruby_blocks", item('biomesoplenty:gem_block', 1))

mods.chisel.carving.addGroup("malachite_blocks")
mods.chisel.carving.addVariation("malachite_blocks", item('gregtech:meta_block_compressed_24', 1))
mods.chisel.carving.addVariation("malachite_blocks", item('biomesoplenty:gem_block', 5))

mods.chisel.carving.addGroup("sapphire_blocks")
mods.chisel.carving.addVariation("sapphire_blocks", item('gregtech:meta_block_compressed_19', 10))
mods.chisel.carving.addVariation("sapphire_blocks", item('biomesoplenty:gem_block', 6))

crafting.replaceShaped('cd4017be_lib:dimstack/dim_pipe', item('dimstack:dim_pipe') * 2, [
        [ore('frameGtSteel'), ore('gemQuartzite'), ore('frameGtSteel')],
        [ore('frameGtSteel'), metaitem('crate.wood'), ore('frameGtSteel')],
        [ore('frameGtSteel'), ore('gemQuartzite'), ore('frameGtSteel')]
])

crafting.replaceShaped('naturescompass:natures_compass', item('naturescompass:naturescompass'), [
        [null, metaitem('sensor.hv'), null],
        [metaitem('plateTreatedWood'), item('minecraft:compass'), metaitem('plateTreatedWood')],
        [null, ore('circuitHv'), null]
])

crafting.addShaped('quark:redstone_randomizer', item('quark:redstone_randomizer'), [
        [null, metaitem('wireFineRedAlloy'), null],
        [null, ore('circuitLv'), null],
        [null, item('minecraft:comparator'), null]
])

crafting.replaceShaped('toolbelt:pouch', item('toolbelt:pouch'), [
        [metaitem('boltGold'), null, metaitem('boltGold')],
        [metaitem('bound_leather'), null, metaitem('bound_leather')],
        [item('minecraft:string'), metaitem('bound_leather'), item('minecraft:string')]
]) 

crafting.replaceShaped('toolbelt:belt', item('toolbelt:belt'), [
        [item('minecraft:string'), metaitem('bound_leather'), item('minecraft:string')],
        [metaitem('bound_leather'), null, metaitem('bound_leather')],
        [item('toolbelt:pouch'), metaitem('ringSteel'), item('toolbelt:pouch')]
])

crafting.replaceShaped('travelersbackpack:travelers_backpack_standard', item('travelersbackpack:travelers_backpack'), [
        [item('techguns:itemshared', 77), metaitem('workbench'), item('techguns:itemshared', 77)],
        [metaitem('large_fluid_cell.steel').or(item('gregtech:machine', 1612)), item('minecraft:chest'), metaitem('large_fluid_cell.steel').or(item('gregtech:machine', 1612))],
        [item('techguns:itemshared', 77), ore('wool'), item('techguns:itemshared', 77)]
])

crafting.replaceShaped('jecalculation:item_calculator', item('jecalculation:item_calculator'), [
        [metaitem('wireFineRedAlloy'), metaitem('plateGlass'), metaitem('wireFineRedAlloy')],
        [item('opencomputers:material', 14), ore('circuitLv'), item('opencomputers:material', 16)],
        [metaitem('wireFineRedAlloy'), ore('plateSteel'), metaitem('wireFineRedAlloy')]
])

crafting.addShapeless("gregtech:mud_block_to_ball", item('biomesoplenty:mudball') * 4, [
        item('biomesoplenty:mud')
])

crafting.addShapeless("gregtech:mud_from_dirt", item('biomesoplenty:mud'), [
        fluid('water') * 1000,
        ore('dirt')
])

item('biomesoplenty:mudball').Item.setMaxStackSize(64)
