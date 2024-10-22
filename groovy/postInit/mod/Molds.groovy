import globals.RecyclingHelper

def FORMINGPRESS = recipemap('forming_press')

//ROD MOLD
crafting.addShaped("mold_rod", metaitem('shape.mold.rod'), [
    [metaitem('shape.empty'), item('gregtech:hammer'), null],
    [null, null, null],
    [null, null, null]
])

RecyclingHelper.handleRecycling(metaitem('shape.mold.rod'), [
		metaitem('shape.empty')
])

FORMINGPRESS.recipeBuilder()
	.inputs(metaitem('shape.empty'))
	.notConsumable(metaitem('shape.mold.rod'))
    .outputs(metaitem('shape.mold.rod'))
	.duration(120)
	.EUt(22)
	.buildAndRegister()	

//CRUCIBLE MOLD
crafting.addShaped("mold_crucible", metaitem('shape.mold.crucible'), [
    [metaitem('shape.empty'), null, null],
    [null, null, null],
    [null, null, item('gregtech:hammer')]
])

RecyclingHelper.handleRecycling(metaitem('shape.mold.crucible'), [
		metaitem('shape.empty')
])

FORMINGPRESS.recipeBuilder()
	.inputs(metaitem('shape.empty'))
	.notConsumable(metaitem('shape.mold.crucible'))
    .outputs(metaitem('shape.mold.crucible'))
	.duration(120)
	.EUt(22)
		.buildAndRegister()

// LONG ROD MOLD
crafting.addShaped("mold_long_rod", metaitem('shape.mold.long_rod'), [
		[metaitem('shape.empty'), null, null],
		[item('gregtech:hammer'), null, null],
		[null, null, null]
])

RecyclingHelper.handleRecycling(metaitem('shape.mold.long_rod'), [
		metaitem('shape.empty')
])

FORMINGPRESS.recipeBuilder()
		.inputs(metaitem('shape.empty'))
		.notConsumable(metaitem('shape.mold.long_rod'))
		.outputs(metaitem('shape.mold.long_rod'))
		.duration(120)
		.EUt(22)
		.buildAndRegister()

// RING MOLD
crafting.addShaped("mold_ring", metaitem('shape.mold.ring'), [
		[metaitem('shape.empty'), null, null],
		[null, item('gregtech:hammer'), null],
		[null, null, null]
])

RecyclingHelper.handleRecycling(metaitem('shape.mold.ring'), [
		metaitem('shape.empty')
])

FORMINGPRESS.recipeBuilder()
		.inputs(metaitem('shape.empty'))
		.notConsumable(metaitem('shape.mold.ring'))
		.outputs(metaitem('shape.mold.ring'))
		.duration(120)
		.EUt(22)
		.buildAndRegister()