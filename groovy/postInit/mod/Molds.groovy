def FORMINGPRESS = recipemap('forming_press')

//ROD MOLD
crafting.addShaped("mold_rod", metaitem('shape.mold.rod'), [
    [metaitem('shape.empty'), item('gregtech:hammer'), null],
    [null, null, null],
    [null, null, null]
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

FORMINGPRESS.recipeBuilder()
	.inputs(metaitem('shape.empty'))
	.notConsumable(metaitem('shape.mold.crucible'))
    .outputs(metaitem('shape.mold.crucible'))
	.duration(120)
	.EUt(22)
	.buildAndRegister()	