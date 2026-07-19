def name_removals = [
    'storagedrawers:compacting_drawer',
    'storagedrawers:controller',
    'storagedrawers:controller_slave',
    'storagedrawers:upgrade_storage_gold',
    'storagedrawers:upgrade_storage_diamond',
    'storagedrawers:upgrade_storage_emerald',
    'storagedrawers:upgrade_void',
    'storagedrawers:upgrade_conversion',
    'storagedrawers:basicdrawers_halfdrawers2_oak',
    'storagedrawers:basicdrawers_halfdrawers4_oak',
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

// allow storage drawers to be crafted using modded wood

//old recipe removal
def drawer_removal = [
    'oak',
    'spruce',
    'birch',
    'jungle',
    'acacia',
    'dark_oak'
]

drawer_removal.each { wood ->
    crafting.remove('storagedrawers:basicdrawers_fulldrawers1_' + wood)
    crafting.remove('storagedrawers:basicdrawers_fulldrawers2_' + wood)
    crafting.remove('storagedrawers:basicdrawers_fulldrawers4_' + wood)
}

//oak drawers
allowedPlanks = item('minecraft:planks') | item('gregtech:planks') | item('biomesoplenty:planks_0', 32767) | item('chisel:planks-oak', 32767) | item('quark:stained_planks', 32767) | item('quark:vertical_stained_planks', 32767) | item('quark:vertical_planks') | item('gregtechfoodoption:gtfo_planks_0', 32767)

crafting.addShaped('storagedrawers:oak_fulldrawer', item('storagedrawers:basicdrawers').withNbt(['material': 'oak']), [
    [allowedPlanks, allowedPlanks, allowedPlanks],
    [null, ore('chestWood'), null],
    [allowedPlanks, allowedPlanks, allowedPlanks]])

crafting.addShaped('storagedrawers:oak_fulldrawer2', item('storagedrawers:basicdrawers', 1).withNbt(['material': 'oak']) * 2, [
    [allowedPlanks, ore('chestWood'), allowedPlanks],
    [allowedPlanks, allowedPlanks, allowedPlanks],
    [allowedPlanks, ore('chestWood'), allowedPlanks]])
    
crafting.addShaped('storagedrawers:oak_fulldrawer4', item('storagedrawers:basicdrawers', 2).withNbt(['material': 'oak']) * 4, [
    [ore('chestWood'), allowedPlanks, ore('chestWood')],
    [allowedPlanks, allowedPlanks, allowedPlanks],
    [ore('chestWood'), allowedPlanks, ore('chestWood')]])

def colors = [
    'white',
    'orange',
    'magenta',
    'light_blue',
    'yellow',
    'lime',
    'pink',
    'gray',
    'silver',
    'cyan',
    'purple',
    'blue',
    'brown',
    'green',
    'red',
    'black'
]

allowedSlabs = item('minecraft:wooden_slab') | item('gregtech:wood_slab') | item('biomesoplenty:wood_slab_0', 32767) | item('biomesoplenty:wood_slab_1', 32767)
colors.each { color ->
    allowedSlabs |= item('quark:stained_planks_' + color + '_slab');
}

crafting.addShaped('storagedrawers:oak_halfdrawer2', item('storagedrawers:basicdrawers', 3).withNbt(['material': 'oak']) * 2, [
    [allowedSlabs, ore('chestWood'), allowedSlabs],
    [allowedSlabs, allowedSlabs, allowedSlabs],
    [allowedSlabs, ore('chestWood'), allowedSlabs]])

crafting.addShaped('storagedrawers:oak_halfdrawer4', item('storagedrawers:basicdrawers', 4).withNbt(['material': 'oak']) * 4, [
    [ore('chestWood'), allowedSlabs, ore('chestWood')],
    [allowedSlabs, allowedSlabs, allowedSlabs],
    [ore('chestWood'), allowedSlabs, ore('chestWood')]])

//other drawers
def drawerVariants = [
    [wood: 'spruce', name: 'storagedrawers:spruce_fulldrawer',    vanilla: item('minecraft:planks', 1), chisel: item('chisel:planks-spruce', 32767),   vertical: item('quark:vertical_planks', 1)],
    [wood: 'birch', name: 'storagedrawers:birch_fulldrawer',  vanilla: item('minecraft:planks', 2), chisel: item('chisel:planks-birch', 32767),    vertical: item('quark:vertical_planks', 2)],
    [wood: 'jungle', name: 'qustoragedrawersark:jungle_fulldrawer',  vanilla: item('minecraft:planks', 4), chisel: item('chisel:planks-jungle', 32767),   vertical: item('quark:vertical_planks', 4)],
    [wood: 'acacia', name: 'storagedrawers:acacia_fulldrawer',  vanilla: item('minecraft:planks', 3), chisel: item('chisel:planks-acacia', 32767),   vertical: item('quark:vertical_planks', 3)],
    [wood: 'dark_oak', name: 'storagedrawers:dark_oak_fulldrawer',  vanilla: item('minecraft:planks', 5), chisel: item('chisel:planks-dark-oak', 32767), vertical: item('quark:vertical_planks', 5)],
]

drawerVariants.each { drawer ->
    planks = drawer.vanilla | drawer.chisel | drawer.vertical

    crafting.addShaped(drawer.name, item('storagedrawers:basicdrawers').withNbt(['material': drawer.wood]), [
        [planks, planks, planks],
        [null, ore('chestWood'), null],
        [planks, planks, planks]])

    crafting.addShaped(drawer.name + '2', item('storagedrawers:basicdrawers', 1).withNbt(['material': drawer.wood]) * 2, [
        [planks, ore('chestWood'), planks],
        [planks, planks, planks],
        [planks, ore('chestWood'), planks]])
    
        crafting.addShaped(drawer.name + '4', item('storagedrawers:basicdrawers', 2).withNbt(['material': drawer.wood]) * 4, [
        [ore('chestWood'), planks, ore('chestWood')],
        [planks, planks, planks],
        [ore('chestWood'), planks, ore('chestWood')]])
}
