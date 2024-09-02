import globals.Globals

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;

def name_removals = [
    'gregtech:fireclay_dust',
    'gregtechfoodoption:mud_bricks1',
    'gregtechfoodoption:mud_bricks2',
    'gregtechfoodoption:mud_bricks3',
    'gregtechfoodoption:mud_bricks4',
    'gregtech:casing_primitive_bricks'
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
    metaitem('dustCalciumHydroxide'),
    metaitem("sand.dust"),
    metaitem('dustFlint'),
    metaitem('dustClay')
]

def compressed_fireclay_ingredients = [
    [metaitem('dustFireclay'),metaitem('dustFireclay'),metaitem('dustFireclay')],
    [metaitem('dustFireclay'),metaitem('wooden_form.brick'), metaitem('dustFireclay')],
    [metaitem('dustFireclay'),metaitem('dustFireclay'),metaitem('dustFireclay')]
]

furnace.add(ore('dustLimestone'), item('gregtech:meta_dust', 360))
crafting.addShapeless('ManualFineSandPile',metaitem('sand.dust') * 4, [item('minecraft:sand')]) 
crafting.addShaped('ManualSandBlock', item('minecraft:sand'), [
    [metaitem('sand.dust'),metaitem('sand.dust')],
    [metaitem('sand.dust'),metaitem('sand.dust')]
])

crafting.addShapeless('ManualFireclay',metaitem('dustFireclay') * 2, fireclay_ingredients) 

crafting.addShaped('pfb_casing_firebricks', item('gregtech:metal_casing', 1), [
    [metaitem('brick.fireclay'),metaitem('brick.fireclay')],
    [metaitem('brick.fireclay'),metaitem('brick.fireclay')]
])

crafting.addShaped('slaked_lime_manual', metaitem('dustCalciumHydroxide') * 8, [
    [metaitem('dustQuicklime'),metaitem('dustQuicklime'),metaitem('dustQuicklime')],
    [metaitem('dustQuicklime'),fluid('water') * 1000, metaitem('dustQuicklime')],
    [metaitem('dustQuicklime'),metaitem('dustQuicklime'),metaitem('dustQuicklime')]])

CompressBrickRecipes('dustFireclay', 'compressed.fireclay')

//Adobe Premiere bricks

def mudbrick_mix_ingredients = [
    item('biomesoplenty:mudball'),
    metaitem("sand.dust"),
    item('pyrotech:material', 2),
    item('minecraft:clay_ball')
]

crafting.addShapeless('ManualMudbrickMix',metaitem('mudbrick_mix') * 2, mudbrick_mix_ingredients)

def damage = { 
    stack -> 
        stack.setItemDamage(stack.getItemDamage() + 1)
        if (stack.getItemDamage() <= stack.getMaxDamage()) {
            stack.copy()
        }
}

CompressBrickRecipes('mudbrick_mix', 'gregtechfoodoption:brick.adobe')
