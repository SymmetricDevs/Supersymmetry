def name_removals = [
    'architecturecraft:item.architecturecraft.sawblade1'
]

crafting.replaceShaped('architecturecraft:tile.architecturecraft.sawbench0', item('architecturecraft:sawbench'), [
    [ore('plateIron'), metaitem('toolHeadBuzzSawIron'), ore('plateIron')],
    [ore('stickWood'), item('architecturecraft:largepulley'), ore('stickWood')],
    [ore('stickWood'), metaitem('gearWood'), ore('stickWood')]
])