//For mods with so few recipes they don't need a dedicated file

def name_removals = [
        "scannable:scanner",
        "regeneration:fob_watch",
        "regeneration:fob_watch_2",
        "regeneration:arch",
        "regeneration:hand_jar",
        "regeneration:lindos_vial",
        "tardis:tardis_coral",
        "sync:sync_core",
        "sync:shell_constructor",
        "sync:shell_storage",
        "sync:treadmill",
        "weeping-angels:timey_wimey_dectecterino",
        "weeping-angels:chronodyne_generator"
]

for (name in name_removals) {
    crafting.remove(name)
}

crafting.replaceShaped('cd4017be_lib:dimstack/dim_pipe', item('dimstack:dim_pipe'), [
        [ore('frameGtSteel'), ore('gemQuartzite'), ore('frameGtSteel')],
        [ore('frameGtSteel'), metaitem('crate.wood'), ore('frameGtSteel')],
        [ore('frameGtSteel'), ore('gemQuartzite'), ore('frameGtSteel')]
])

crafting.replaceShaped('naturescompass:natures_compass', item('naturescompass:naturescompass'), [
        [null, metaitem('sensor.hv'), null],
        [metaitem('plateTreatedWood'), item('minecraft:compass'), metaitem('plateTreatedWood')],
        [null, ore('circuitHv'), null]
])

crafting.replaceShaped('travelersbackpack:travelers_backpack_standard', item('travelersbackpack:travelers_backpack'), [
        [item('minecraft:leather'), metaitem('workbench'), item('minecraft:leather')],
        [metaitem('large_fluid_cell.steel'), item('minecraft:chest'), metaitem('large_fluid_cell.steel')],
        [item('minecraft:leather'), item('minecraft:bed'), item('minecraft:leather')]
])

crafting.addShaped('quark:redstone_randomizer', item('quark:redstone_randomizer'), [
        [null, metaitem('wireFineRedAlloy'), null],
        [null, ore('circuitLv'), null],
        [null, item('minecraft:comparator'), null]
])