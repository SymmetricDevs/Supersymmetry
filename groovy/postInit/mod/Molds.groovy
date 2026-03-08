import static prePostInit.Recipemaps.*
import postInit.utils.RecyclingHelper

// Rod mold
crafting.addShaped("mold_rod", metaitem('shape.mold.rod'), [
    [metaitem('shape.empty'), item('gregtech:hammer'), null],
    [null, null, null],
    [null, null, null]
])

RecyclingHelper.handleRecycling(metaitem('shape.mold.rod'), [
	metaitem('shape.empty')
])

FORMING_PRESS.recipeBuilder()
	.inputs(metaitem('shape.empty'))
	.notConsumable(metaitem('shape.mold.rod'))
    .outputs(metaitem('shape.mold.rod'))
	.duration(120)
	.EUt(22)
	.buildAndRegister()

// Pin mold

crafting.addShaped("mold_pin", metaitem('shape.mold.pin'), [
    [metaitem('shape.empty'), null, null],
    [null, null, null],
    [null, null, ore('craftingToolWireCutter')]
])

RecyclingHelper.handleRecycling(metaitem('shape.mold.pin'), [
	metaitem('shape.empty')
])

FORMING_PRESS.recipeBuilder()
	.inputs(metaitem('shape.empty'))
	.notConsumable(metaitem('shape.mold.pin'))
	.outputs(metaitem('shape.mold.pin'))
	.duration(120)
	.EUt(22)
	.buildAndRegister()

// Leadframe mold

crafting.addShaped("mold_pin", metaitem('shape.mold.leadframe'), [
    [null, null, metaitem('shape.empty')],
    [null, null, null],
    [null, null, ore('craftingToolWireCutter')]
])

RecyclingHelper.handleRecycling(metaitem('shape.mold.leadframe'), [
	metaitem('shape.empty')
])

FORMING_PRESS.recipeBuilder()
	.inputs(metaitem('shape.empty'))
	.notConsumable(metaitem('shape.mold.leadframe'))
	.outputs(metaitem('shape.mold.leadframe'))
	.duration(120)
	.EUt(22)
	.buildAndRegister()

// Crucible mold
crafting.addShaped("mold_crucible", metaitem('shape.mold.crucible'), [
    [metaitem('shape.empty'), null, null],
    [null, null, null],
    [null, null, item('gregtech:hammer')]
])

RecyclingHelper.handleRecycling(metaitem('shape.mold.crucible'), [
	metaitem('shape.empty')
])

FORMING_PRESS.recipeBuilder()
	.inputs(metaitem('shape.empty'))
	.notConsumable(metaitem('shape.mold.crucible'))
    .outputs(metaitem('shape.mold.crucible'))
	.duration(120)
	.EUt(22)
	.buildAndRegister()

// Long rod mold
crafting.addShaped("mold_long_rod", metaitem('shape.mold.long_rod'), [
	[metaitem('shape.empty'), null, null],
	[item('gregtech:hammer'), null, null],
	[null, null, null]
])

RecyclingHelper.handleRecycling(metaitem('shape.mold.long_rod'), [
	metaitem('shape.empty')
])

FORMING_PRESS.recipeBuilder()
	.inputs(metaitem('shape.empty'))
	.notConsumable(metaitem('shape.mold.long_rod'))
	.outputs(metaitem('shape.mold.long_rod'))
	.duration(120)
	.EUt(22)
	.buildAndRegister()

// Ring mold
crafting.addShaped("mold_ring", metaitem('shape.mold.ring'), [
	[metaitem('shape.empty'), null, null],
	[null, item('gregtech:hammer'), null],
	[null, null, null]
])

RecyclingHelper.handleRecycling(metaitem('shape.mold.ring'), [
	metaitem('shape.empty')
])

FORMING_PRESS.recipeBuilder()
	.inputs(metaitem('shape.empty'))
	.notConsumable(metaitem('shape.mold.ring'))
	.outputs(metaitem('shape.mold.ring'))
	.duration(120)
	.EUt(22)
	.buildAndRegister()
