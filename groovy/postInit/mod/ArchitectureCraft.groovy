def name_removals = [
    'architecturecraft:item.architecturecraft.sawblade1'
]

crafting.replaceShaped('architecturecraft:tile.architecturecraft.sawbench0', item('architecturecraft:sawbench'), [
    [ore('plateIron'), metaitem('toolHeadBuzzSawIron'), ore('plateIron')],
    [ore('stickWood'), item('architecturecraft:largepulley'), ore('stickWood')],
    [ore('stickWood'), metaitem('gearWood'), ore('stickWood')]
])

crafting.replaceShaped('architecturecraft:item.architecturecraft.largepulley2', item('architecturecraft:largepulley'), [
        [null, metaitem('ringIron'), null],
        [item('minecraft:string'), null, item('minecraft:string')],
        [null, metaitem('ringIron'), null]
])

crafting.replaceShaped('architecturecraft:item.architecturecraft.chisel3', item('architecturecraft:chisel'), [
        [metaitem('plateIron'), null, null],
        [null, metaitem('plateIron'), null],
        [null, null, item('minecraft:stick')]
])

crafting.replaceShaped('architecturecraft:item.architecturecraft.hammer4', item('architecturecraft:hammer'), [
        [null, null, null],
        [ore('plateIron'), ore('plateIron'), ore('plateIron')],
        [ore('craftingToolFile'), item('minecraft:stick'), ore('craftingToolHardHammer')]
])
