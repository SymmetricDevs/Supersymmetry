import static globals.Globals.*

def name_removals = [
    'gregtech:fireclay_dust',
    'gregtechfoodoption:mud_bricks1',
    'gregtechfoodoption:mud_bricks2',
    'gregtechfoodoption:mud_bricks3',
    'gregtechfoodoption:mud_bricks4',

]

for (name in name_removals) {
    crafting.remove(name)
}

// Creates Compressed brick recipes
def CompressBrickRecipes(brick_mix, compressed_brick) {
    crafting.addShapeless('Compress' + brick_mix + '_1',metaitem(compressed_brick), [metaitem('wooden_form.brick'), metaitem(brick_mix)]) 
    crafting.addShaped('Compress' + brick_mix + '_8',metaitem(compressed_brick) * 8, [
        [metaitem(brick_mix),metaitem(brick_mix),metaitem(brick_mix)],
        [metaitem(brick_mix),metaitem('wooden_form.brick'), metaitem(brick_mix)],
        [metaitem(brick_mix),metaitem(brick_mix),metaitem(brick_mix)]
    ])
}

//Fireclay bricks

def fireclay_ingredients = [
    metaitem('slaked_lime'),
    metaitem("sand.dust"),
    metaitem('dustFlint'),
    metaitem('dustClay')
]

def compressed_fireclay_ingredients = [
    [metaitem('dustFireclay'),metaitem('dustFireclay'),metaitem('dustFireclay')],
    [metaitem('dustFireclay'),metaitem('wooden_form.brick'), metaitem('dustFireclay')],
    [metaitem('dustFireclay'),metaitem('dustFireclay'),metaitem('dustFireclay')]
]

furnace.add(ore('stoneLimestone'), item('gregtech:meta_dust', 360))
crafting.addShapeless('ManualFineSandPile',metaitem('sand.dust') * 4, [item('minecraft:sand')]) 
crafting.addShapeless('ManualSlakedLime',metaitem('slaked_lime'), [fluid('minecraft:water'), item('gregtech:meta_dust', 360)]) 
crafting.addShapeless('ManualFireclay',metaitem('dustFireclay') * 2, fireclay_ingredients) 

CompressBrickRecipes('dustFireclay', 'compressed.fireclay')

//Adobe Premiere bricks

def mudbrick_mix_ingredients = [
    item('biomesoplenty:mudball'),
    metaitem("sand.dust"),
    metaitem('straw'),
    item('minecraft:clay_ball')
]

crafting.addShapeless('ManualMudbrickMix',metaitem('mudbrick_mix') * 2, mudbrick_mix_ingredients) 
crafting.addShapeless('StrawCutting',metaitem('straw') * 2, [ore('craftingToolKnife'), item('notreepunching:grass_fiber')]) 

CompressBrickRecipes('mudbrick_mix', 'brick.adobe')
