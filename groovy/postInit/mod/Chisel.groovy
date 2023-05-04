crafting.replaceShaped('chisel:chisel_iron', item('chisel:chisel_iron'), [
    [null, ore('plateIron'), null],
    [null, ore('plateIron'), null],
    [null, ore('stickWood'), null]
])

crafting.replaceShaped('chisel:chisel_diamond', item('chisel:chisel_diamond'), [
    [null, ore('plateDiamond'), null],
    [null, ore('plateDiamond'), null],
    [null, ore('stickSteel'), null]
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
    [ore('plateIron'), ore('stickSteel'), ore('plateIron')],
    [ore('plateIron'), ore('plateIron'), ore('plateIron')]
])