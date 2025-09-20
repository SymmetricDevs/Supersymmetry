crafting.remove('jecalculation:math_calculator')

crafting.replaceShaped('jecalculation:item_calculator', item('jecalculation:item_calculator'), [
    [metaitem('wireFineRedAlloy'), metaitem('plateGlass'), metaitem('wireFineRedAlloy')],
    [item('opencomputers:material', 14), ore('circuitLv'), item('opencomputers:material', 16)],
    [metaitem('wireFineRedAlloy'), ore('plateSteel'), metaitem('wireFineRedAlloy')]
])
