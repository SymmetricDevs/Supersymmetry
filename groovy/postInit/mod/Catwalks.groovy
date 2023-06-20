crafting.replaceShaped('catwalks:blowtorch', item('catwalks:blowtorch'), [
        [null, null, item('minecraft:flint_and_steel')],
        [null, metaitem('stickSteel'), null],
        [metaitem('stickSteel'), metaitem('pipeTinyFluidSteel'), null]
])

crafting.replaceShaped('catwalks:catwalks/glass_catwalk', item('catwalks:catwalk').withNbt(["material": "glass"]) * 16, [
        [ore('paneGlass'), ore('paneGlass'), ore('paneGlass')],
        [metaitem('stickSteel'), null, metaitem('stickSteel')],
        [metaitem('stickSteel'), ore('paneGlass'), metaitem('stickSteel')]
])

crafting.replaceShaped('catwalks:catwalks/classic_catwalk', item('catwalks:catwalk').withNbt(["material": "classic"]) * 16, [
        [metaitem('stickIron'), metaitem('stickIron'), metaitem('stickIron')],
        [item('minecraft:iron_bars'), null, item('minecraft:iron_bars')],
        [item('minecraft:iron_bars'), metaitem('stickIron'), item('minecraft:iron_bars')]
])

crafting.replaceShaped('catwalks:catwalks/steel_catwalk', item('catwalks:catwalk').withNbt(["material": "magneticraft_steel"]) * 16, [
        [metaitem('stickSteel'), metaitem('stickSteel'), metaitem('stickSteel')],
        [item('minecraft:iron_bars'), null, item('minecraft:iron_bars')],
        [item('minecraft:iron_bars'), metaitem('stickSteel'), item('minecraft:iron_bars')]
])

crafting.replaceShaped('catwalks:catwalks/custom_catwalk', item('catwalks:catwalk').withNbt(["material": "custom_0"]) * 16, [
        [item('minecraft:stick'), item('minecraft:stick'), item('minecraft:stick')],
        [metaitem('stickSteel'), null, metaitem('stickSteel')],
        [metaitem('stickSteel'), item('minecraft:planks'), metaitem('stickSteel')]
])

crafting.addShaped('catwalks:catwalks/treated_catwalk', item('catwalks:catwalk').withNbt(["material": "treated_wood"]) * 16, [
        [metaitem('stickTreatedWood'), metaitem('stickTreatedWood'), metaitem('stickTreatedWood')],
        [metaitem('stickSteel'), null, metaitem('stickSteel')],
        [metaitem('stickSteel'), item('gregtech:planks', 1), metaitem('stickSteel')]
])

crafting.replaceShaped('catwalks:classic_ladder', item('catwalks:ladder') * 8, [
        [metaitem('stickSteel'), null, metaitem('stickSteel')],
        [metaitem('stickSteel'), item('minecraft:ladder'), metaitem('stickSteel')],
        [metaitem('stickSteel'), null, metaitem('stickSteel')]
])