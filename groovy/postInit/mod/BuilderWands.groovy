def name_removals = [
        'betterbuilderswands:recipewandunbreakable',
        'betterbuilderswands:wandunbreakable13',
        'betterbuilderswands:wandunbreakable14'
]

for (name in name_removals) {
    crafting.remove(name)
}

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
[null, ore('string'), ore('plateDiamond')],
[null, ore('stickSteel'), ore('string')],
[ore('stickSteel'), null, null]
])

// Unbreakable Wands
crafting.addShaped('betterbuilderswands:wandunbreakable', item('betterbuilderswands:wandunbreakable', 12), [
[null, metaitem('duct_tape'), ore('blockObsidian')],
[null, ore('stickTungstenSteel'), metaitem('duct_tape')],
[ore('stickTungstenSteel'), null, null]
])

crafting.addShapeless('unbreakablewand2', item('betterbuilderswands:wandunbreakable', 13),
[item('betterbuilderswands:wandunbreakable', 12), item('betterbuilderswands:wandunbreakable', 12)])

crafting.addShapeless('unbreakablewand3', item('betterbuilderswands:wandunbreakable', 14),
[item('betterbuilderswands:wandunbreakable', 13), item('betterbuilderswands:wandunbreakable', 13)])