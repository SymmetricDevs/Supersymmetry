// Stone Wand
crafting.addShaped('betterbuilderswands:wandstone', item('betterbuilderswands:wandstone'), [
    [null, null, ore('cobblestone')],
    [null, ore('stickWood'), null],
    [ore('stickWood'), null, null]
])

// Iron Wand
crafting.addShaped('betterbuilderswands:wandiron', item('betterbuilderswands:wandiron'), [
    [null, null, ore('plateIron')],
    [null, ore('stickIron'), null],
    [ore('stickIron'), null, null]
])

// Diamond Wand
crafting.addShaped('betterbuilderswands:wanddiamond', item('betterbuilderswands:wanddiamond'), [
    [null, null, ore('plateDiamond')],
    [null, ore('stickSteel'), null],
    [ore('stickSteel'), null, null]
])

// Unbreakable Wand
crafting.replaceShaped('betterbuilderswands:wandunbreakable', item('betterbuilderswands:wandunbreakable'), [
    [null, null, ore('blockObsidian')],
    [null, ore('stickSteel'), null],
    [ore('stickSteel'), null, null]
])
