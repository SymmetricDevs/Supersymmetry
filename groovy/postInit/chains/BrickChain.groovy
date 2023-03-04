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
    crafting.addShapeless(metaitem(compressed_brick), [metaitem('wooden_form.brick'), metaitem(brick_mix)]) 
    crafting.addShaped(metaitem(compressed_brick) * 8, [
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
crafting.addShapeless(metaitem('sand.dust') * 4, [item('minecraft:sand')]) 

crafting.addShapeless(metaitem('slaked_lime'), [item('minecraft:water_bucket'), item('gregtech:meta_dust', 360)]) 

crafting.addShapeless(metaitem('dustFireclay') * 2, fireclay_ingredients) 

CompressBrickRecipes('dustFireclay', 'compressed.fireclay')

//Adobe Premiere bricks

def mudbrick_mix_ingredients = [
    item('biomesoplenty:mudball'),
    metaitem("sand.dust"),
    metaitem('straw'),
    item('minecraft:clay_ball')
]

crafting.addShapeless(metaitem('mudbrick_mix') * 2, mudbrick_mix_ingredients) 

CompressBrickRecipes('mudbrick_mix', 'brick.adobe')
