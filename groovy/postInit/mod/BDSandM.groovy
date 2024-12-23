def name_removals = [
    'bdsandm:upgrade_void',
]

for (name in name_removals) {
    crafting.remove(name)
}
crafting.remove('bdsandm:color_tool_b')
crafting.replaceShaped('bdsandm:color_tool_c', item('bdsandm:color_tool'), [
    [ore('dyeRed'), ore('dyeOrange'), ore('dyeYellow')],
    [ore('dyePurple'), item('gregtech:meta_item_1', 61), ore('dyeLime')],
    [ore('dyeBlue'), ore('dyeCyan'), ore('dyeGreen')]
])

crafting.replaceShaped('bdsandm:crate_key_c', item('bdsandm:crate_key'), [
    [ore('plateIron'), ore('plateIron'), null],
    [ore('plateIron'), ore('craftingToolFile'), null],
    [item('bdsandm:wood_crate'), null, null]
])

crafting.replaceShaped('bdsandm:crate_key_b', item('bdsandm:crate_key'), [
    [ore('plateIron'), ore('plateIron'), null],
    [ore('plateIron'), ore('craftingToolFile'), null],
    [item('bdsandm:wood_barrel'), null, null]
])

crafting.replaceShapeless("bdsandm:upgrade_ore_dict", item('bdsandm:upgrade:5'), [
	item('minecraft:item_frame'),
	ore('chestWood'),
	metaitem('ore_dictionary_filter')
])

crafting.replaceShapeless("bdsandm:upgrade_uninstall", item('bdsandm:upgrade:7'), [
	item('minecraft:item_frame'),
	ore('chestWood')
])

crafting.replaceShapeless("bdsandm:upgrade_64", item('bdsandm:upgrade'), [
	item('minecraft:item_frame'),
	ore('chestWood'),
	ore('ingotIron')
])

crafting.replaceShaped('bdsandm:wood_crate', item('bdsandm:wood_crate'), [
    [ore('plateWood'), ore('plateWood'), ore('plateWood')],
    [ore('plateWood'), ore('chestWood'), ore('plateWood')],
    [ore('plateWood'), ore('plateWood'), ore('plateWood')]
])

crafting.replaceShaped('bdsandm:metal_crate', item('bdsandm:metal_crate'), [
    [ore('plateSteel'), ore('plateSteel'), ore('plateSteel')],
    [ore('plateSteel'), item('bdsandm:wood_crate'), ore('plateSteel')],
    [ore('plateSteel'), ore('plateSteel'), ore('plateSteel')]
])

crafting.replaceShaped('bdsandm:wood_barrel', item('bdsandm:wood_barrel'), [
    [ore('plateTreatedWood'), ore('plateTreatedWood'), ore('plateTreatedWood')],
    [ore('plateTreatedWood'), item('minecraft:bucket'), ore('plateTreatedWood')],
    [ore('plateTreatedWood'), ore('plateTreatedWood'), ore('plateTreatedWood')]
])

crafting.replaceShaped('bdsandm:metal_barrel', item('bdsandm:metal_barrel'), [
    [ore('plateSteel'), ore('plateSteel'), ore('plateSteel')],
    [ore('plateSteel'), item('bdsandm:wood_barrel'), ore('plateSteel')],
    [ore('plateSteel'), ore('plateSteel'), ore('plateSteel')]
])

crafting.replaceShaped('bdsandm:shipping_c', item('bdsandm:shipping_container'), [
    [ore('plateSteel'), ore('plateSteel'), ore('plateSteel')],
    [ore('frameGtSteel'), item('bdsandm:metal_crate'), ore('frameGtSteel')],
    [ore('plateSteel'), ore('plateSteel'), ore('plateSteel')]
])

crafting.replaceShaped('bdsandm:shipping_b', item('bdsandm:shipping_container'), [
    [ore('plateSteel'), ore('plateSteel'), ore('plateSteel')],
    [ore('frameGtSteel'), item('bdsandm:metal_barrel'), ore('frameGtSteel')],
    [ore('plateSteel'), ore('plateSteel'), ore('plateSteel')]
])

crafting.replaceShaped('bdsandm:shipping_b', item('bdsandm:shipping_container'), [
    [ore('plateSteel'), ore('plateSteel'), ore('plateSteel')],
    [ore('frameGtSteel'), item('bdsandm:metal_barrel'), ore('frameGtSteel')],
    [ore('plateSteel'), ore('plateSteel'), ore('plateSteel')]
])

recipemap('assembler').recipeBuilder()
	.circuitMeta(1)
	.inputs(item('minecraft:item_frame'))
	.inputs(ore('chestWood'))
	.inputs(ore('ingotIron'))
	.outputs(item('bdsandm:upgrade') * 4)
	.duration(10)
	.EUt(7)
	.buildAndRegister()

recipemap('assembler').recipeBuilder()
	.circuitMeta(2)
	.inputs(item('minecraft:item_frame'))
	.inputs(ore('chestWood'))
	.inputs(ore('ingotIron'))
	.outputs(item('bdsandm:upgrade', 1))
	.duration(20)
	.EUt(7)
	.buildAndRegister()

recipemap('assembler').recipeBuilder()
	.circuitMeta(3)
	.inputs(item('minecraft:item_frame') * 4)
	.inputs(ore('chestWood') * 4)
	.inputs(ore('ingotIron') * 4)
	.outputs(item('bdsandm:upgrade', 2))
	.duration(40)
	.EUt(7)
	.buildAndRegister()

recipemap('assembler').recipeBuilder()
	.circuitMeta(4)
	.inputs(item('minecraft:item_frame') * 16)
	.inputs(ore('chestWood') * 16)
	.inputs(ore('ingotIron') * 16)
	.outputs(item('bdsandm:upgrade', 3))
	.duration(80)
	.EUt(7)
	.buildAndRegister()