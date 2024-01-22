import gregtech.api.recipes.RecipeBuilder
import globals.Globals

def DRONE_PAD = recipemap('drone_pad');

crafting.addShaped("susy:drone_pad_controller", metaitem('drone_pad'), [
    [ore('plateSteel'), metaitem('emitter.lv'), ore('plateSteel')],
    [item('susy:susy_multiblock_casing', 4), item('gregtech:metal_casing', 4), item('susy:susy_multiblock_casing', 4)],
    [ore('plateSteel'), item('susy:susy_multiblock_casing', 4), ore('plateSteel')]
])

crafting.addShaped("susy:drone_pad_block", item('susy:susy_multiblock_casing', 4) * 3, [
    [null, null, null],
    [ore('plateSteel'), ore('plateSteel'), ore('plateSteel')],
    [ore('blockConcrete'), ore('blockConcrete'), ore('blockConcrete')]
])

crafting.addShaped("susy:drone_pad_block_alt", item('susy:susy_multiblock_casing', 4) * 3, [
    [null, null, null],
    [ore('plateSteel'), ore('plateSteel'), ore('plateSteel')],
    [ore('stonePolished'), ore('stonePolished'), ore('stonePolished')]
])

mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem('electric.motor.lv') * 4)
    .inputs(ore('rotorSteel') * 4)
    .inputs(ore('stickSteel') * 4)
    .inputs(ore('plateTin') * 2)
    .inputs(ore('chest') * 1)
    .inputs(ore('craftingToolButcheryKnife') * 1)
    .inputs(metaitem('robot.arm.lv') * 1)
    .inputs(ore('batteryLv'))
    .fluidInputs(fluid('soldering_alloy') * 72)
    .outputs(metaitem('drone.lv').withNbt(["Charge": 0L]))
    .EUt(Globals.voltAmps[1])
    .duration(80)
    .buildAndRegister()

DRONE_PAD.recipeBuilder()
    .inputs(metaitem('drone.lv').withNbt(["Charge": 10000L]))
    .circuitMeta(5)
    .outputs(metaitem('drone.lv').withNbt(["Charge": 0L]))
    .chancedOutput(item('minecraft:bone') * 8, 8000, 400)
    .chancedOutput(item('minecraft:rotten_flesh') * 8, 8000, 400)
    .EUt(4)
    .duration(800)
    .dimension(0)
    .buildAndRegister()

DRONE_PAD.recipeBuilder()
    .inputs(metaitem('drone.lv').withNbt(["Charge": 10000L]))
    .circuitMeta(1)
    .outputs(metaitem('drone.lv').withNbt(["Charge": 0L]))
    .chancedOutput(item('minecraft:porkchop') * 8, 8000, 400)
    .chancedOutput(item('minecraft:beef') * 8, 8000, 400)
    .chancedOutput(item('minecraft:chicken') * 8, 8000, 400)
    .EUt(4)
    .duration(800)
    .dimension(0)
    .buildAndRegister()

DRONE_PAD.recipeBuilder()
    .inputs(metaitem('drone.lv').withNbt(["Charge": 10000L]))
    .circuitMeta(2)
    .outputs(metaitem('drone.lv').withNbt(["Charge": 0L]))
    .chancedOutput(item('minecraft:rabbit') * 8, 8000, 400)
    .chancedOutput(item('minecraft:mutton') * 8, 8000, 400)
    .EUt(4)
    .duration(800)
    .dimension(0)
    .buildAndRegister()

DRONE_PAD.recipeBuilder()
    .inputs(metaitem('drone.lv').withNbt(["Charge": 10000L]))
    .circuitMeta(3)
    .outputs(metaitem('drone.lv').withNbt(["Charge": 0L]))
    .chancedOutput(item('minecraft:fish') * 8, 8000, 400)
    .chancedOutput(item('minecraft:fish', 1) * 8, 8000, 400)
    .chancedOutput(item('minecraft:dye') * 8, 8000, 400)
    .EUt(4)
    .duration(800)
    .dimension(0)
    .buildAndRegister()

DRONE_PAD.recipeBuilder()
    .inputs(metaitem('drone.lv').withNbt(["Charge": 10000L]))
    .circuitMeta(4)
    .outputs(metaitem('drone.lv').withNbt(["Charge": 0L]))
    .chancedOutput(item('minecraft:leather') * 8, 8000, 400)
    .chancedOutput(item('minecraft:wool') * 8, 8000, 400)
    .EUt(4)
    .duration(800)
    .dimension(0)
    .buildAndRegister()