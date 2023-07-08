/*

def name_removals = [
        'armourers_workshop:item.soap',
        'armourers_workshop:tile.skin-cube-glass-glowing-2'
]

for (name in name_removals) {
    crafting.remove(name)
}

crafting.replaceShaped('armourers_workshop:tile.skin-cube', item('armourers_workshop:tile.skin-cube') * 8, [
        [ore('wool'), ore('wool'), ore('wool')],
        [ore('wool'), null, ore('wool')],
        [ore('wool'), ore('wool'), ore('wool')]
])

crafting.replaceShaped('armourers_workshop:tile.skin-cube-glass', item('armourers_workshop:tile.skin-cube-glass') * 8, [
        [ore('blockGlass'), ore('blockGlass'), ore('blockGlass')],
        [ore('blockGlass'), null, ore('blockGlass')],
        [ore('blockGlass'), ore('blockGlass'), ore('blockGlass')]
])

crafting.replaceShaped('armourers_workshop:tile.skin-cube-glowing', item('armourers_workshop:tile.skin-cube-glowing') * 8, [
        [ore('wool'), ore('wool'), ore('wool')],
        [ore('wool'), item('minecraft:glowstone_dust'), ore('wool')],
        [ore('wool'), ore('wool'), ore('wool')]
])

crafting.replaceShaped('armourers_workshop:tile.skin-cube-glass-glowing-1', item('armourers_workshop:tile.skin-cube-glass-glowing') * 8, [
        [ore('blockGlass'), ore('blockGlass'), ore('blockGlass')],
        [ore('blockGlass'), item('minecraft:glowstone_dust'), ore('blockGlass')],
        [ore('blockGlass'), ore('blockGlass'), ore('blockGlass')]
])

crafting.replaceShaped('armourers_workshop:item.paintbrush', item('armourers_workshop:item.paintbrush'), [
        [null, null, item('armourers_workshop:tile.skin-cube')],
        [null, metaitem('plateIron'), null],
        [ore('stick'), null, null]
])

crafting.replaceShaped('armourers_workshop:item.paint-roller', item('armourers_workshop:item.paint-roller'), [
        [null, item('armourers_workshop:tile.skin-cube'), metaitem('stickIron')],
        [null, metaitem('stickIron'), item('armourers_workshop:tile.skin-cube')],
        [ore('stick'), null, null]
])

crafting.replaceShaped('armourers_workshop:item.colour-picker', item('armourers_workshop:item.colour-picker'), [
        [null, null, metaitem('plateGlass')],
        [item('armourers_workshop:tile.skin-cube'), metaitem('plateGlass'), null],
        [metaitem('plateRubber'), item('armourers_workshop:tile.skin-cube'), null]
])

crafting.replaceShaped('armourers_workshop:item.burn-tool', item('armourers_workshop:item.burn-tool'), [
        [null, item('armourers_workshop:tile.skin-cube'), item('minecraft:flint_and_steel')],
        [null, metaitem('plateIron'), item('armourers_workshop:tile.skin-cube')],
        [ore('stick'), null, null]
])

crafting.replaceShaped('armourers_workshop:item.dodge-tool', item('armourers_workshop:item.dodge-tool'), [
        [null, item('armourers_workshop:tile.skin-cube'), ore('dyeWhite')],
        [null, metaitem('plateIron'), item('armourers_workshop:tile.skin-cube')],
        [ore('stick'), null, null]
])

crafting.replaceShaped('armourers_workshop:item.colour-noise-tool', item('armourers_workshop:item.colour-noise-tool'), [
        [item('armourers_workshop:tile.skin-cube'), ore('dyeRed'), ore('dyeGreen')],
        [null, metaitem('plateIron'), ore('dyeBlue')],
        [ore('stick'), null, item('armourers_workshop:tile.skin-cube')]
])

crafting.replaceShaped('armourers_workshop:item.shade-noise-tool', item('armourers_workshop:item.shade-noise-tool'), [
        [item('armourers_workshop:tile.skin-cube'), ore('dyeWhite'), ore('dyeGray')],
        [null, metaitem('plateIron'), ore('dyeBlack')],
        [ore('stick'), null, item('armourers_workshop:tile.skin-cube')]
])

crafting.replaceShaped('armourers_workshop:item.hue-tool', item('armourers_workshop:item.hue-tool'), [
        [null, item('armourers_workshop:tile.skin-cube'), ore('dyeGray')],
        [null, metaitem('plateIron'), item('armourers_workshop:tile.skin-cube')],
        [ore('stick'), null, null]
])

crafting.replaceShaped('armourers_workshop:item.block-marker', item('armourers_workshop:item.block-marker'), [
        [null, ore('dyeBlack'), item('armourers_workshop:tile.skin-cube')],
        [null, metaitem('plateIron'), ore('dyeWhite')],
        [ore('stick'), null, null]
])

crafting.replaceShaped('armourers_workshop:item.blending-tool', item('armourers_workshop:item.blending-tool'), [
        [null, item('armourers_workshop:tile.skin-cube'), item('armourers_workshop:tile.skin-cube')],
        [null, item('armourers_workshop:tile.skin-cube'), item('armourers_workshop:tile.skin-cube')],
        [ore('stick'), null, null]
])

crafting.replaceShaped('armourers_workshop:item.mannequin-tool', item('armourers_workshop:item.mannequin-tool'), [
        [null, item('armourers_workshop:tile.skin-cube'), ore('plankWood')],
        [null, metaitem('plateIron'), item('armourers_workshop:tile.skin-cube')],
        [ore('stick'), null, null]
])

crafting.replaceShaped('armourers_workshop:item.dye-bottle', item('armourers_workshop:item.dye-bottle'), [
        [null, item('armourers_workshop:tile.skin-cube'), null],
        [null, metaitem('fluid_cell.glass_vial'), null],
        [null, null, null]
])

crafting.replaceShaped('armourers_workshop:item.wand-of-style', item('armourers_workshop:item.wand-of-style'), [
        [null, item('armourers_workshop:item.dye-bottle'), item('armourers_workshop:tile.skin-cube')],
        [null, metaitem('plateIron'), item('armourers_workshop:item.skin-template')],
        [ore('stick'), null, null]
])

crafting.replaceShaped('armourers_workshop:item.armourers-hammer', item('armourers_workshop:item.armourers-hammer'), [
        [null, item('minecraft:iron_ingot'), item('armourers_workshop:item.dye-bottle')],
        [null, ore('stick'), metaitem('plateIron')],
        [ore('stick'), null, null]
])

crafting.replaceShaped('armourers_workshop:item.skin-unlock-head', item('armourers_workshop:item.skin-unlock'), [
        [item('armourers_workshop:item.skin-template'), item('minecraft:iron_helmet'), null],
        [null, null, null],
        [null, null, null]
])

crafting.replaceShaped('armourers_workshop:item.skin-unlock-chest', item('armourers_workshop:item.skin-unlock', 1), [
        [item('armourers_workshop:item.skin-template'), item('minecraft:iron_chestplate'), null],
        [null, null, null],
        [null, null, null]
])

crafting.replaceShaped('armourers_workshop:item.skin-unlock-legs', item('armourers_workshop:item.skin-unlock', 2), [
        [item('armourers_workshop:item.skin-template'), item('minecraft:iron_leggings'), null],
        [null, null, null],
        [null, null, null]
])

crafting.replaceShaped('armourers_workshop:item.skin-unlock-feet', item('armourers_workshop:item.skin-unlock', 3), [
        [item('armourers_workshop:item.skin-template'), item('minecraft:iron_boots'), null],
        [null, null, null],
        [null, null, null]
])

crafting.replaceShaped('armourers_workshop:item.wand-of-style', item('armourers_workshop:item.wand-of-style'), [
        [null, metaitem('plateIron'), item('armourers_workshop:tile.skin-cube')],
        [null, item('minecraft:chest'), metaitem('plateIron')],
        [ore('stick'), null, null]
])

crafting.replaceShaped('armourers_workshop:item.mannequin', item('armourers_workshop:item.mannequin'), [
        [item('minecraft:rotten_flesh'), item('minecraft:rotten_flesh'), item('minecraft:rotten_flesh')],
        [item('minecraft:rotten_flesh'), item('minecraft:armor_stand'), item('minecraft:rotten_flesh')],
        [item('minecraft:rotten_flesh'), item('minecraft:rotten_flesh'), item('minecraft:rotten_flesh')]
])

crafting.replaceShaped('armourers_workshop:tile.global-skin-library', item('armourers_workshop:tile.global-skin-library'), [
        [ore('stone'), metaitem('sensor.lv'), ore('stone')],
        [ore('bookshelf'), item('armourers_workshop:tile.skin-cube'), ore('bookshelf')],
        [ore('stone'), ore('stone'), ore('stone')]
])

crafting.replaceShaped('armourers_workshop:tile.skin-library', item('armourers_workshop:tile.skin-library'), [
        [ore('stone'), item('minecraft:book'), ore('stone')],
        [ore('bookshelf'), item('armourers_workshop:tile.skin-cube'), ore('bookshelf')],
        [ore('stone'), ore('stone'), ore('stone')]
])

crafting.addShaped('armourers_workshop:tile.armourer', item('armourers_workshop:tile.armourer'), [
        [metaitem('electric.piston.lv'), metaitem('sensor.lv'), metaitem('electric.piston.lv')],
        [metaitem('plateIron'), item('armourers_workshop:tile.skin-cube'), metaitem('plateIron')],
        [ore('stone'), ore('stone'), ore('stone')]
])

crafting.replaceShaped('armourers_workshop:tile.hologram-projector', item('armourers_workshop:tile.hologram-projector'), [
        [metaitem('plateIron'), metaitem('emitter.lv'), metaitem('plateIron')],
        [metaitem('plateIron'), item('armourers_workshop:tile.skin-cube'), metaitem('plateIron')],
        [metaitem('plateIron'), metaitem('plateIron'), metaitem('plateIron')]
])

crafting.replaceShaped('armourers_workshop:tile.outfit-maker', item('armourers_workshop:tile.outfit-maker'), [
        [metaitem('plateIron'), metaitem('plateIron'), metaitem('plateIron')],
        [ore('plankWood'), ore('plankWood'), ore('plankWood')],
        [ore('plankWood'), item('armourers_workshop:tile.skin-cube'), ore('plankWood')]
])

recipemap('fluid_solidifier').recipeBuilder()
        .fluidInputs(fluid('gtfo_sodium_stearate') * 100)
        .notConsumable(metaitem('shape.mold.ball'))
        .outputs(item('armourers_workshop:item.soap'))
        .duration(80)
        .EUt(16)
        .buildAndRegister()
        */