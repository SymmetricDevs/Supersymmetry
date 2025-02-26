crafting.addShaped('susy:gabbro_bricks', item('susy:susy_stone_bricks') * 4, [
        [ore('stoneGabbro'), ore('stoneGabbro')],
        [ore('stoneGabbro'), ore('stoneGabbro')]
])

crafting.addShaped('susy:gneiss_bricks', item('susy:susy_stone_bricks', 1) * 4, [
        [ore('stoneGneiss'), ore('stoneGneiss')],
        [ore('stoneGneiss'), ore('stoneGneiss')]
])

crafting.addShaped('susy:limestone_bricks', item('susy:susy_stone_bricks', 2) * 4, [
        [ore('stoneLimestone'), ore('stoneLimestone')],
        [ore('stoneLimestone'), ore('stoneLimestone')]
])

crafting.addShaped('susy:phyllite_bricks', item('susy:susy_stone_bricks', 3) * 4, [
        [ore('stonePhyllite'), ore('stonePhyllite')],
        [ore('stonePhyllite'), ore('stonePhyllite')]
])

crafting.addShaped('susy:quartzite_bricks', item('susy:susy_stone_bricks', 4) * 4, [
        [ore('stoneQuartzite'), ore('stoneQuartzite')],
        [ore('stoneQuartzite'), ore('stoneQuartzite')]
])

crafting.addShaped('susy:shale_bricks', item('susy:susy_stone_bricks', 5) * 4, [
        [ore('stoneShale'), ore('stoneShale')],
        [ore('stoneShale'), ore('stoneShale')]
])

crafting.addShaped('susy:slate_bricks', item('susy:susy_stone_bricks', 6) * 4, [
        [ore('stoneSlate'), ore('stoneSlate')],
        [ore('stoneSlate'), ore('stoneSlate')]
])

crafting.addShaped('susy:soapstone_bricks', item('susy:susy_stone_bricks', 7) * 4, [
        [ore('stoneSoapstone'), ore('stoneSoapstone')],
        [ore('stoneSoapstone'), ore('stoneSoapstone')]
])

crafting.addShaped('susy:kimberlite_bricks', item('susy:susy_stone_bricks', 8) * 4, [
        [ore('stoneKimberlite'), ore('stoneKimberlite')],
        [ore('stoneKimberlite'), ore('stoneKimberlite')]
])

crafting.addShaped('susy:industrial_concrete_bricks', item('susy:susy_stone_bricks', 9) * 4, [
        [item('susy:susy_stone_smooth', 9), item('susy:susy_stone_smooth', 9)],
        [item('susy:susy_stone_smooth', 9), item('susy:susy_stone_smooth', 9)]
])

crafting.addShapeless('marble_conversion', item('gregtech:stone_smooth', 2), [item('chisel:marble2', 7)])

// Structural Block
mods.gregtech.extruder.recipeBuilder()
	.inputs(metaitem('frameSteel'))
	.notConsumable(metaitem('shape.extruder.block'))
	.fluidInputs(fluid('concrete') * 576)
	.outputs(item('susy:structural_block') * 32)
	.duration(200)
        .EUt(30)
        .buildAndRegister();

//add variants to chisel group
mods.chisel.carving.addGroup("susy_structural_blocks")
for(int i = 0; i<16;i++){ 
	mods.chisel.carving.addVariation("susy_structural_blocks", item('susy:structural_block', i))
}
for(int i = 0; i<10;i++){ 
	mods.chisel.carving.addVariation("susy_structural_blocks", item('susy:structural_block_1', i))
}

//add custom sheets to chisel group
mods.chisel.carving.addVariation("gt_metal_sheet", item('susy:custom_sheets', 0))
mods.chisel.carving.addVariation("gt_metal_sheet", item('susy:custom_sheets', 1))
