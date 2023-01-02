def name_removals = [
        'appliedenergistics2:misc/grindstone_woodengear'
]

for (name in name_removals) {
    crafting.remove(name)
}

crafting.replaceShaped('appliedenergistics2:misc/grindstone_new', item('appliedenergistics2:grindstone'), [
        [ore('stone'), ore('gearWood'), ore('stone')],
        [ore('gemFlint'), ore('stone'), ore('gemFlint')],
        [ore('cobblestone'), ore('gemFlint'), ore('cobblestone')]
])