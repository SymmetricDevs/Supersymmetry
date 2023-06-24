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
    [ore('plateIron'), metaitem('toolHeadDrillSteel'), ore('plateIron')]
])
