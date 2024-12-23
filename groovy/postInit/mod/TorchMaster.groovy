crafting.replaceShaped('torchmaster:feral_flare_lantern', item('torchmaster:feral_flare_lantern')  * 16 , [
        [metaitem('plateSteel'), ore('craftingLensGlass'), metaitem('plateSteel')],
        [ore('craftingLensGlass'), ore('gtLight'), ore('craftingLensGlass')],
        [metaitem('plateSteel'), ore('craftingLensGlass'), metaitem('plateSteel')]
])

crafting.replaceShaped('torchmaster:dread_lamp', item('torchmaster:dread_lamp'), [
        [item('minecraft:obsidian'), item('minecraft:obsidian'), item('minecraft:obsidian')],
        [ore('blockGlass'), item('torchmaster:feral_flare_lantern'), ore('blockGlass')],
        [item('minecraft:obsidian'), item('minecraft:obsidian'), item('minecraft:obsidian')]
])

crafting.replaceShaped('torchmaster:mega_torch', item('torchmaster:mega_torch'), [
        [null, null, null],
        [null, item('torchmaster:feral_flare_lantern'), null],
        [null, metaitem('stickTreatedWood'), null]
])

crafting.replaceShaped('torchmaster:terrain_lighter', item('torchmaster:terrain_lighter'), [
        [metaitem('robot.arm.lv'), metaitem('plateStone'), metaitem('robot.arm.lv')],
        [metaitem('plateStone'), item('minecraft:chest'), metaitem('plateStone')],
        [ore('plankWood'), metaitem('plateStone'), ore('plankWood')]
])