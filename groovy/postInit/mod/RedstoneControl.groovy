def name_removals = [
        'cd4017be_lib:rs_ctr/wire_anchor_b',
        'cd4017be_lib:rs_ctr/wireless_b',
        'cd4017be_lib:rs_ctr/wireless_b_b',
        'cd4017be_lib:rs_ctr/rs_port_2',
        'cd4017be_lib:rs_ctr/rs_port_3',
        'cd4017be_lib:rs_ctr/block_wire',
        'cd4017be_lib:rs_ctr/split_b',
        'cd4017be_lib:rs_ctr/block_plug',
        'cd4017be_lib:rs_ctr/comparator',
        'cd4017be_lib:rs_ctr/splitter_b',
        'cd4017be_lib:rs_ctr/delay_b',
        'cd4017be_lib:rs_ctr/multiplex_b',
        'cd4017be_lib:rs_ctr/block_reorienter',
        'cd4017be_lib:rs_ctr/block_deserializer',
        'cd4017be_lib:rs_ctr/processor2',
        'cd4017be_lib:rs_ctr/socket_b',
        'cd4017be_lib:cd4017be_lib/m_400',
        'cd4017be_lib:rs_ctr/solar_cell',
        'cd4017be_lib:cd4017be_lib/m_401',
        'cd4017be_lib:rs_ctr/item_translocator',
        'cd4017be_lib:rs_ctr/fluid_translocator',
        'cd4017be_lib:rs_ctr/block_breaker1',
        'cd4017be_lib:rs_ctr/block_breaker',
        'cd4017be_lib:rs_ctr/item_placer',
        'cd4017be_lib:rs_ctr/teleporter1',
        'cd4017be_lib:rs_ctr/frame',
        'cd4017be_lib:rs_ctr/teleporter',
        'cd4017be_lib:rs_ctr/block_selector',
        'cd4017be_lib:rs_ctr/chunk_loader',
        'cd4017be_lib:rs_ctr/cl_fuel'
]

for (name in name_removals) {
    crafting.remove(name)
}

crafting.replaceShaped('cd4017be_lib:rs_ctr/signal_probe', item('rs_ctr:signal_probe'), [
        [metaitem('stickIron'), null, metaitem('stickIron')],
        [metaitem('wireFineRedAlloy'), ore('paneGlass'), metaitem('wireFineRedAlloy')],
        [item('minecraft:stone_button'), null, item('minecraft:stone_button')]
])

crafting.replaceShaped('cd4017be_lib:rs_ctr/rs_port_0', item('rs_ctr:rs_port'), [
        [null, metaitem('wireFineRedAlloy'), null],
        [null, metaitem('plateStone'), null],
        [null, metaitem('stickIron'), null]
])

crafting.replaceShaped('cd4017be_lib:rs_ctr/rs_port_1', item('rs_ctr:rs_port', 1), [
        [null, item('minecraft:redstone_torch'), null],
        [null, metaitem('plateStone'), null],
        [null, metaitem('wireFineRedAlloy'), null]
])

crafting.replaceShaped('cd4017be_lib:rs_ctr/wire_anchor', item('rs_ctr:wire_anchor') * 4, [
        [null, metaitem('screwSteel'), null],
        [null, metaitem('wireFineSteel'), null],
        [null, null, null]
])

crafting.replaceShaped('cd4017be_lib:rs_ctr/wire', item('rs_ctr:wire') * 8, [
        [metaitem('wireFineRedAlloy'), metaitem('wireFineRedAlloy'), metaitem('wireFineRedAlloy')],
        [metaitem('wireFineRedAlloy'), null, metaitem('wireFineRedAlloy')],
        [metaitem('wireFineRedAlloy'), metaitem('wireFineRedAlloy'), metaitem('wireFineRedAlloy')]
])

crafting.replaceShaped('cd4017be_lib:rs_ctr/wireless', item('rs_ctr:wireless'), [
        [null, null, null],
        [item('rs_ctr:wire'), ore('circuitLv'), metaitem('sensor.hv')],
        [null, metaitem('plateStone'), null]
])

crafting.replaceShaped('cd4017be_lib:rs_ctr/lamp', item('rs_ctr:lamp'), [
        [null, metaitem('component.glass.tube'), null],
        [null, metaitem('wireFineSteel'), null],
        [null, item('rs_ctr:wire'), null]
])

crafting.replaceShaped('cd4017be_lib:rs_ctr/clock', item('rs_ctr:clock'), [
        [null, item('minecraft:clock'), null],
        [null, item('rs_ctr:wire'), null],
        [null, null, null]
])

crafting.replaceShaped('cd4017be_lib:rs_ctr/pulse_gen', item('rs_ctr:pulse_gen'), [
        [null, item('rs_ctr:rs_port'), null],
        [null, metaitem('wireFineRedAlloy'), null],
        [item('minecraft:redstone_torch'), item('rs_ctr:wire'), item('minecraft:repeater')]
])

crafting.replaceShaped('cd4017be_lib:rs_ctr/analog_comb', item('rs_ctr:analog_comb'), [
        [item('rs_ctr:rs_port', 1), metaitem('wireFineRedAlloy'), null],
        [item('rs_ctr:rs_port', 1), item('rs_ctr:rs_port'), null],
        [item('rs_ctr:rs_port', 1), metaitem('wireFineRedAlloy'), null]
])

crafting.replaceShaped('cd4017be_lib:rs_ctr/logic_comb', item('rs_ctr:logic_comb'), [
        [item('rs_ctr:rs_port', 1), item('minecraft:redstone_torch'), metaitem('wireFineRedAlloy')],
        [item('rs_ctr:rs_port', 1), item('minecraft:redstone_torch'), item('rs_ctr:rs_port')],
        [item('rs_ctr:rs_port', 1), item('minecraft:redstone_torch'), metaitem('wireFineRedAlloy')]
])

crafting.replaceShaped('cd4017be_lib:rs_ctr/num_comb', item('rs_ctr:num_comb'), [
        [item('rs_ctr:rs_port', 1), metaitem('plateQuartzite'), metaitem('wireFineRedAlloy')],
        [item('rs_ctr:rs_port', 1), metaitem('plateQuartzite'), item('rs_ctr:rs_port')],
        [item('rs_ctr:rs_port', 1), metaitem('plateQuartzite'), metaitem('wireFineRedAlloy')]
])

crafting.replaceShaped('cd4017be_lib:rs_ctr/bin_comb', item('rs_ctr:bin_comb'), [
        [item('rs_ctr:rs_port', 1), metaitem('plateQuartzite'), null],
        [item('rs_ctr:rs_port', 1), item('rs_ctr:rs_port'), null],
        [item('rs_ctr:rs_port', 1), metaitem('plateQuartzite'), null]
])

crafting.replaceShaped('cd4017be_lib:rs_ctr/bin_split', item('rs_ctr:bin_split'), [
        [metaitem('plateQuartzite'), item('rs_ctr:rs_port'), null],
        [item('rs_ctr:rs_port', 1), item('rs_ctr:rs_port'), null],
        [metaitem('plateQuartzite'), item('rs_ctr:rs_port'), null]
])

crafting.replaceShaped('cd4017be_lib:rs_ctr/counter', item('rs_ctr:counter'), [
        [item('rs_ctr:rs_port', 1), metaitem('plateQuartzite'), item('rs_ctr:rs_port')],
        [item('rs_ctr:rs_port', 1), item('minecraft:redstone_torch'), metaitem('wireFineRedAlloy')],
        [item('rs_ctr:rs_port', 1), metaitem('plateQuartzite'), item('rs_ctr:rs_port')]
])

crafting.replaceShaped('cd4017be_lib:rs_ctr/assembler', item('rs_ctr:assembler'), [
        [null, metaitem('wireFineRedAlloy'), null],
        [metaitem('wireFineRedAlloy'), metaitem('plateSteel'), metaitem('wireFineRedAlloy')],
        [null, metaitem('workbench'), null]
])

crafting.replaceShaped('cd4017be_lib:rs_ctr/editor', item('rs_ctr:editor'), [
        [null, ore('paneGlass'), null],
        [metaitem('circuit.electronic'), metaitem('plateSteel'), metaitem('circuit.electronic')],
        [null, metaitem('workbench'), null]
])

crafting.replaceShaped('cd4017be_lib:rs_ctr/processor3', item('rs_ctr:processor3'), [
        [null, metaitem('wireFineRedAlloy'), null],
        [item('rs_ctr:processor2'), metaitem('plateSteel'), item('rs_ctr:processor2')],
        [null, metaitem('wireFineRedAlloy'), null]
])

crafting.replaceShaped('cd4017be_lib:cd4017be_lib/m_404', item('cd4017be_lib:m', 404), [
        [item('cd4017be_lib:m', 403), item('cd4017be_lib:m', 403), item('cd4017be_lib:m', 403)],
        [item('cd4017be_lib:m', 403), item('rs_ctr:wire'), item('cd4017be_lib:m', 403)],
        [item('cd4017be_lib:m', 403), item('cd4017be_lib:m', 403), item('cd4017be_lib:m', 403)]
])

crafting.replaceShaped('cd4017be_lib:cd4017be_lib/m_403', item('cd4017be_lib:m', 403), [
        [null, null, item('rs_ctr:wire')],
        [null, metaitem('ringIron'), null],
        [item('rs_ctr:wire'), null, null]
])

crafting.replaceShaped('cd4017be_lib:rs_ctr/panel', item('rs_ctr:panel'), [
        [metaitem('screwSteel'), item('minecraft:paper'), metaitem('screwSteel')],
        [metaitem('boltSteel'), metaitem('plateStone'), metaitem('boltSteel')],
        [metaitem('screwSteel'), metaitem('boltSteel'), metaitem('screwSteel')]
])

crafting.replaceShaped('cd4017be_lib:rs_ctr/slider', item('rs_ctr:slider'), [
        [null, null, null],
        [item('minecraft:redstone_torch'), metaitem('stickSteel'), item('rs_ctr:wire')],
        [null, metaitem('circuit.electronic'), null]
])

crafting.replaceShaped('cd4017be_lib:rs_ctr/seg7_0', item('rs_ctr:seg7'), [
        [null, null, null],
        [item('rs_ctr:lamp'), item('rs_ctr:lamp'), item('rs_ctr:lamp')],
        [metaitem('plateQuartzite'), metaitem('wireFineRedAlloy'), metaitem('plateQuartzite')]
])

crafting.replaceShaped('cd4017be_lib:rs_ctr/energy_valve', item('rs_ctr:energy_valve'), [
        [null, item('rs_ctr:rs_port', 1), null],
        [item('rs_ctr:rs_port', 1), metaitem('wireGtSingleTin'), item('rs_ctr:rs_port')],
        [null, metaitem('plateStone'), null]
])

crafting.replaceShaped('cd4017be_lib:rs_ctr/oc_adapter', item('rs_ctr:oc_adapter'), [
        [metaitem('wireGtSingleTin'), null, item('rs_ctr:processor2')],
        [item('opencomputers:card', 6), item('opencomputers:component'), item('opencomputers:card', 4)],
        [metaitem('wireGtSingleTin'), item('opencomputers:component', 6), item('rs_ctr:processor2')]
])

crafting.replaceShaped('cd4017be_lib:rs_ctr/power_hub', item('rs_ctr:power_hub'), [
        [null, metaitem('wireGtSingleTin'), null],
        [metaitem('wireGtSingleTin'), metaitem('plateStone'), metaitem('wireGtSingleTin')],
        [null, metaitem('wireGtSingleTin'), null]
])