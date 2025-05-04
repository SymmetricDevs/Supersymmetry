def name_removals = [
    'quark:arrow_explosive',
    'minecraft:chest',
    'quark:chest_1',
    'quark:custom_chest',
    'quark:custom_chest_2',
    'quark:custom_chest_4',
    'quark:custom_chest_6',
    'quark:custom_chest_8'
]

for (name in name_removals) {
    crafting.remove(name);
}

allowedPlanks = item('minecraft:planks') | item('biomesoplenty:planks_0', 32767) | item('chisel:planks-oak', 32767) | item('quark:stained_planks', 32767) | item('quark:vertical_stained_planks', 32767) | item('quark:vertical_planks') | item('gregtech:planks') | item('gregtechfoodoption:gtfo_planks_0', 32767)

crafting.addShaped('minecraft:chest', item('minecraft:chest'), [
    [allowedPlanks, allowedPlanks, allowedPlanks],
    [allowedPlanks, null, allowedPlanks],
    [allowedPlanks, allowedPlanks, allowedPlanks]])

def chestVariants = [
    [meta: 0, name: 'quark:custom_chest',    vanilla: item('minecraft:planks', 1), chisel: item('chisel:planks-spruce', 32767),   vertical: item('quark:vertical_planks', 1)],
    [meta: 1, name: 'quark:custom_chest_2',  vanilla: item('minecraft:planks', 2), chisel: item('chisel:planks-birch', 32767),    vertical: item('quark:vertical_planks', 2)],
    [meta: 2, name: 'quark:custom_chest_4',  vanilla: item('minecraft:planks', 3), chisel: item('chisel:planks-acacia', 32767),   vertical: item('quark:vertical_planks', 3)],
    [meta: 3, name: 'quark:custom_chest_6',  vanilla: item('minecraft:planks', 4), chisel: item('chisel:planks-jungle', 32767),   vertical: item('quark:vertical_planks', 4)],
    [meta: 4, name: 'quark:custom_chest_8',  vanilla: item('minecraft:planks', 5), chisel: item('chisel:planks-dark-oak', 32767), vertical: item('quark:vertical_planks', 5)],
]

chestVariants.each { chest ->
    planks = chest.vanilla | chest.chisel | chest.vertical

    crafting.addShaped(chest.name, item('quark:custom_chest', chest.meta), [
        [planks, planks, planks],
        [planks, null, planks],
        [planks, planks, planks]])
}

def dye_colors = [
    'white',
    'orange',
    'magenta',
    'light_blue',
    'yellow',
    'lime',
    'pink',
    'gray',
    'light_gray',
    'cyan',
    'purple',
    'blue',
    'brown',
    'green',
    'red',
    'black'
]

for (i in 0..15) {
	CHEMICAL_BATH.recipeBuilder()
		.inputs(ore('plankWood') * 8)
		.fluidInputs(fluid('dye_' + dye_colors[i]) * 72)
		.outputs(item('quark:stained_planks', i))
		.duration(20)
		.EUt(7)
		.buildAndRegister();
	
}


