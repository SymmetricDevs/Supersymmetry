crafting.replaceShaped('chisel:chisel_iron', item('chisel:chisel_iron'), [
    [null, null, ore('plateIron')],
    [null, ore('plateIron'), null],
    [ore('stickWood'), null, null]
])

crafting.replaceShaped('chisel:chisel_diamond', item('chisel:chisel_diamond'), [
    [null, null, ore('plateSteel')],
    [null, ore('plateSteel'), null],
    [ore('stickWood'), null, null]
])

crafting.replaceShaped('chisel:chisel_hitech', item('chisel:chisel_hitech'), [
    [null, ore('plateDiamond'), null],
    [ore('cableGtSingleTin'), ore('circuitUlv'), ore('cableGtSingleTin')],
    [null, ore('stickSteel'), null]
])

crafting.replaceShaped('chisel:offsettool', item('chisel:offsettool'), [
    [null, ore('plateSteel'), null],
    [ore('plateSteel'), ore('stickSteel'), ore('plateSteel')],
    [null, ore('stickSteel'), null]
])

crafting.replaceShaped('chisel:autochisel', item('chisel:auto_chisel'), [
    [ore('blockGlass'), ore('blockGlass'), ore('blockGlass')],
    [metaitem('electric.motor.lv'), metaitem('hull.lv'), metaitem('circuit.electronic')],
    [ore('plateIron'), ore('plateIron'), ore('plateIron')]
])

crafting.replaceShaped('chisel:factory', item('chisel:factory') * 32, [
        [item('minecraft:iron_ingot'), ore('stone'), item('minecraft:iron_ingot')],
        [ore('stone'), null, ore('stone')],
        [item('minecraft:iron_ingot'), ore('stone'), item('minecraft:iron_ingot')]
])

crafting.replaceShaped('chisel:tyrian', item('chisel:tyrian') * 32, [
        [ore('stone'), ore('stone'), ore('stone')],
        [ore('stone'), item('minecraft:iron_ingot'), ore('stone')],
        [ore('stone'), ore('stone'), ore('stone')]
])

crafting.replaceShaped('chisel:temple', item('chisel:temple') * 32, [
        [ore('stone'), ore('stone'), ore('stone')],
        [ore('stone'), ore('dyeCyan'), ore('stone')],
        [ore('stone'), ore('stone'), ore('stone')]
])

ASSEMBLER = recipemap('assembler')

ASSEMBLER.recipeBuilder()
        .inputs(ore('stone') * 4)
        .inputs(item('minecraft:iron_ingot') * 4)
        .outputs(item('chisel:factory') * 32)
        .circuitMeta(1)
        .duration(20)
        .EUt(7)
        .buildAndRegister();

ASSEMBLER.recipeBuilder()
        .inputs(ore('stone') * 8)
        .inputs(item('minecraft:iron_ingot'))
        .outputs(item('chisel:tyrian') * 32)
        .circuitMeta(2)
        .duration(20)
        .EUt(7)
        .buildAndRegister();

ASSEMBLER.recipeBuilder()
        .inputs(ore('stone') * 8)
        .inputs(ore('dyeCyan'))
        .outputs(item('chisel:temple') * 32)
        .circuitMeta(3)
        .duration(20)
        .EUt(7)
        .buildAndRegister();