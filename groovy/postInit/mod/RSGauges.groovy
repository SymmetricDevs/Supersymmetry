def name_removals = [
        'rsgauges:industrial/bistableswitchto1',
        'rsgauges:industrial/pulseswitchto1',
        'rsgauges:industrial/contactmatto1',
        'rsgauges:industrial/trapdorswitchto1'
]

for (name in name_removals) {
    crafting.remove(name)
}

crafting.replaceShaped('rsgauges:industrial/bistableswitch1', item('rsgauges:bistableswitch1'), [
        [null, item('minecraft:redstone_torch'), null],
        [metaitem('plateSteel'), metaitem('ringSteel'), null],
        [null, metaitem('wireFineRedAlloy'), null]
])

crafting.replaceShaped('rsgauges:industrial/bistableswitch2', item('rsgauges:bistableswitch2'), [
        [null, item('minecraft:redstone_torch'), null],
        [metaitem('plateSteel'), metaitem('ringSteel'), item('minecraft:lever')],
        [null, metaitem('wireFineRedAlloy'), null]
])

crafting.replaceShaped('rsgauges:industrial/bistableswitch8', item('rsgauges:bistableswitch8'), [
        [null, item('minecraft:redstone_torch'), null],
        [metaitem('plateSteel'), item('minecraft:lever'), null],
        [null, metaitem('wireFineRedAlloy'), null]
])

crafting.replaceShaped('rsgauges:industrial/bistableswitch7', item('rsgauges:bistableswitch7'), [
        [null, item('minecraft:redstone_torch'), null],
        [metaitem('plateSteel'), metaitem('ringSteel'), item('minecraft:lever')],
        [null, metaitem('wireFineRedAlloy'), null]
])

crafting.replaceShaped('rsgauges:industrial/bistableswitch3', item('rsgauges:bistableswitch3'), [
        [null, item('minecraft:redstone_torch'), null],
        [item('minecraft:stone_button'), metaitem('plateSteel'), item('minecraft:stone_button')],
        [null, metaitem('wireFineRedAlloy'), null]
])

crafting.replaceShaped('rsgauges:industrial/bistableswitch5', item('rsgauges:bistableswitch5'), [
        [null, item('minecraft:heavy_weighted_pressure_plate'), null],
        [null, metaitem('wireFineRedAlloy'), null],
        [null, metaitem('plateSteel'), null]
])

crafting.replaceShaped('rsgauges:industrial/bistableswitch6', item('rsgauges:bistableswitch6'), [
        [metaitem('stickSteel'), metaitem('ringSteel'), null],
        [null, metaitem('plateSteel'), null],
        [metaitem('stickSteel'), metaitem('ringSteel'), null]
])

crafting.replaceShaped('rsgauges:industrial/pulseswitch1', item('rsgauges:pulseswitch1'), [
        [null, item('minecraft:stone_button'), null],
        [null, metaitem('plateSteel'), null],
        [null, null, null]
])

crafting.replaceShaped('rsgauges:industrial/pulseswitch2', item('rsgauges:pulseswitch2'), [
        [null, item('minecraft:stone_button'), null],
        [null, metaitem('ringSteel'), null],
        [null, metaitem('plateSteel'), null]
])

crafting.replaceShaped('rsgauges:industrial/pulseswitch6', item('rsgauges:pulseswitch6'), [
        [null, null, null],
        [metaitem('stickSteel'), item('minecraft:wooden_button'), metaitem('stickSteel')],
        [null, metaitem('plateSteel'), null]
])

crafting.replaceShaped('rsgauges:industrial/pulseswitch5', item('rsgauges:pulseswitch5'), [
        [null, null, null],
        [metaitem('plateSteel'), item('minecraft:wooden_button'), null],
        [metaitem('ringSteel'), metaitem('stickSteel'), null]
])

crafting.replaceShaped('rsgauges:industrial/pulseswitch3', item('rsgauges:pulseswitch3'), [
        [metaitem('plateSteel'), null, null],
        [metaitem('springSmallSteel'), metaitem('wireFineRedAlloy'), null],
        [metaitem('stickSteel'), item('minecraft:stick'), null]
])

crafting.replaceShaped('rsgauges:misc/dimmerswitch1', item('rsgauges:dimmerswitch1'), [
        [null, metaitem('plateSteel'), null],
        [metaitem('wireFineRedAlloy'), metaitem('stickSteel'), metaitem('wireFineRedAlloy')],
        [null, metaitem('plateSteel'), item('minecraft:stick')]
])

crafting.replaceShaped('rsgauges:industrial/contactmat1', item('rsgauges:contactmat1'), [
        [null, metaitem('wireFineSteel'), null],
        [null, metaitem('foilSteel'), null],
        [null, item('minecraft:heavy_weighted_pressure_plate'), null]
])

crafting.replaceShaped('rsgauges:industrial/contactmat2', item('rsgauges:contactmat2'), [
        [null, null, null],
        [null, metaitem('foilSteel'), null],
        [null, item('minecraft:heavy_weighted_pressure_plate'), null]
])

crafting.replaceShaped('rsgauges:industrial/contactmat3', item('rsgauges:contactmat3'), [
        [null, metaitem('wireFineRedAlloy'), null],
        [null, metaitem('foilSteel'), null],
        [null, item('minecraft:heavy_weighted_pressure_plate'), null]
])

crafting.replaceShaped('rsgauges:industrial/trapdorswitch1', item('rsgauges:trapdoorswitch1'), [
        [null, null, null],
        [null, metaitem('foilSteel'), null],
        [null, item('minecraft:iron_trapdoor'), null]
])

crafting.replaceShaped('rsgauges:industrial/trapdorswitch2', item('rsgauges:trapdoorswitch2'), [
        [null, metaitem('wireFineSteel'), null],
        [null, metaitem('foilSteel'), null],
        [null, item('minecraft:iron_trapdoor'), null]
])

crafting.replaceShaped('rsgauges:industrial/trapdorswitch3', item('rsgauges:trapdoorswitch3'), [
        [null, null, null],
        [metaitem('wireFineRedAlloy'), metaitem('stickSteel'), metaitem('wireFineRedAlloy')],
        [null, metaitem('sensor.lv'), null]
])

crafting.replaceShaped('rsgauges:industrial/automaticswitchdetector1', item('rsgauges:automaticswitch1'), [
        [null, metaitem('plateSteel'), null],
        [metaitem('wireFineRedAlloy'), metaitem('plateSteel'), metaitem('sensor.lv')],
        [null, metaitem('plateSteel'), null]
])

crafting.replaceShaped('rsgauges:glass/detectorswitch_glass1', item('rsgauges:detectorswitch_glass1'), [
        [null, metaitem('plateGlass'), null],
        [metaitem('wireFineRedAlloy'), metaitem('plateGlass'), metaitem('sensor.lv')],
        [null, metaitem('plateGlass'), null]
])