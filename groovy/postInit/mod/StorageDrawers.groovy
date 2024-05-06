def name_removals = [
    'storagedrawers:compacting_drawer',
    'storagedrawers:controller',
    'storagedrawers:controller_slave',
    'storagedrawers:upgrade_storage_gold',
    'storagedrawers:upgrade_storage_diamond',
    'storagedrawers:upgrade_storage_emerald',
    'storagedrawers:upgrade_void',
    'storagedrawers:upgrade_conversion'
]

for (name in name_removals) {
    crafting.remove(name)
}

crafting.replaceShapeless("storagedrawers:key_quantify", item('storagedrawers:quantify_key'), [item('storagedrawers:drawer_key'), item('minecraft:book')])
crafting.replaceShapeless("storagedrawers:key_concealment", item('storagedrawers:shroud_key'), [item('storagedrawers:drawer_key'), item('minecraft:carpet')])
crafting.replaceShaped("storagedrawers:key_drawer", item('storagedrawers:drawer_key'), [
        [null, ore('stickBrass'), null],
        [ore('craftingToolFile'), ore('stickBrass'), null],
        [null, ore('plateBrass'), null]
])