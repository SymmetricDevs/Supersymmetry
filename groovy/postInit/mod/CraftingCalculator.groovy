crafting.replaceShaped('jecalculation:item_calculator', item('jecalculation:item_calculator'), [
    [metaitem('wireFineRedAlloy'), metaitem('plateGlass'), metaitem('wireFineRedAlloy')],
    [item('opencomputers:material', 14), ore('circuitLv'), item('opencomputers:material', 14)],
    [metaitem('wireFineRedAlloy'), ore('plateSteel'), metaitem('wireFineRedAlloy')]
])

crafting.replaceShaped('jecalculation:math_calculator', item('jecalculation:item_calculator', 1), [
        [null, metaitem('plateGlass'), null],
        [metaitem('wireFineRedAlloy'), ore('circuitLv'), item('opencomputers:material', 16)],
        [null, ore('plateSteel'), null]
])