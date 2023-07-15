def name_removals = [
    'bdsandm:upgrade_void',
    'bdsandm:wood_crate'
]

for (name in name_removals) {
    crafting.remove(name)
}

crafting.replaceShaped('bdsandm:crate_key_c', item('bdsandm:crate_key'), [
    [ore('plateIron'), ore('plateIron'), null],
    [ore('plateIron'), ore('craftingToolFile'), null],
    [item('bdsandm:wood_crate'), null, null]
])

crafting.replaceShaped('bdsandm:crate_key_b', item('bdsandm:crate_key'), [
    [ore('plateIron'), ore('plateIron'), null],
    [ore('plateIron'), ore('craftingToolFile'), null],
    [item('bdsandm:wood_barrel'), null, null]
])

crafting.replaceShaped('bdsandm:shipping_c', item('bdsandm:shipping_container'), [
    [ore('plateSteel'), ore('plateSteel'), ore('plateSteel')],
    [ore('frameGtSteel'), item('bdsandm:metal_crate'), ore('frameGtSteel')],
    [ore('plateSteel'), ore('plateSteel'), ore('plateSteel')]
])

crafting.replaceShaped('bdsandm:shipping_b', item('bdsandm:shipping_container'), [
    [ore('plateSteel'), ore('plateSteel'), ore('plateSteel')],
    [ore('frameGtSteel'), item('bdsandm:metal_barrel'), ore('frameGtSteel')],
    [ore('plateSteel'), ore('plateSteel'), ore('plateSteel')]
])