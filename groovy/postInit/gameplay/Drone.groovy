import static prePostInit.Recipemaps.*
import globals.Globals
import static gregtech.api.GTValues.*
import gregtech.api.recipes.RecipeBuilder

crafting.addShaped("susy:drone_pad_controller", metaitem('susy:drone_pad'), [
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

crafting.addShaped("susy:cargo_drone_pad_controller", metaitem('susy:cargo_drone_pad'), [
        [ore('plateMagnalium'), metaitem('wireless'), ore('plateMagnalium')],
        [ore('circuitMv'), metaitem('hull.mv'), ore('circuitMv')],
        [ore('plateMagnalium'), ore('circuitMv'), ore('plateMagnalium')]
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
    .EUt(VA[LV])
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
    .dimension(Globals.dimensions["Overworld"])
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
    .dimension(Globals.dimensions["Overworld"])
    .buildAndRegister()

DRONE_PAD.recipeBuilder()
    .inputs(metaitem('drone.lv').withNbt(["Charge": 10000L]))
    .circuitMeta(2)
    .outputs(metaitem('drone.lv').withNbt(["Charge": 0L]))
    .chancedOutput(item('minecraft:rabbit') * 8, 8000, 400)
    .chancedOutput(item('minecraft:mutton') * 8, 8000, 400)
    .EUt(4)
    .duration(800)
    .dimension(Globals.dimensions["Overworld"])
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
    .dimension(Globals.dimensions["Overworld"])
    .buildAndRegister()

DRONE_PAD.recipeBuilder()
    .inputs(metaitem('drone.lv').withNbt(["Charge": 10000L]))
    .circuitMeta(4)
    .outputs(metaitem('drone.lv').withNbt(["Charge": 0L]))
    .chancedOutput(item('minecraft:leather') * 8, 8000, 400)
    .chancedOutput(item('minecraft:wool') * 8, 8000, 400)
    .EUt(4)
    .duration(800)
    .dimension(Globals.dimensions["Overworld"])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
        .inputs(metaitem('plateFiberReinforcedNylon') * 4)
        .inputs(metaitem('ringMagnalium'))
        .outputs(metaitem('rotorFiberReinforcedNylon'))
        .EUt(VA[MV])
        .duration(120)
        .buildAndRegister()

ASSEMBLER.recipeBuilder()
        .inputs(ore('stickMagnalium') * 6)
        .inputs(ore('platePlastic') * 4)
        .inputs(metaitem('electric.motor.mv') * 4)
        .inputs(metaitem('rotorFiberReinforcedNylon') * 4)
        .inputs(metaitem('wireless') * 1)
        .inputs(ore('batteryMv') * 4)
        .inputs(ore('circuitMv') * 2)
        .outputs(metaitem('susy:cargo_drone.basic').withNbt(["Charge": 0L]))
        .EUt(VA[MV])
        .duration(360)
        .buildAndRegister()

ASSEMBLER.recipeBuilder()
        .inputs(ore('stickMagnalium') * 6)
        .inputs(ore('platePlastic') * 4)
        .inputs(metaitem('electric.motor.mv') * 4)
        .inputs(metaitem('rotorFiberReinforcedNylon') * 4)
        .inputs(metaitem('wireless') * 1)
        .inputs(metaitem('battery.ni_fe') * 2)
        .inputs(ore('circuitMv') * 2)
        .outputs(metaitem('susy:cargo_drone.basic').withNbt(["Charge": 0L]))
        .EUt(VA[MV])
        .duration(300)
        .buildAndRegister()

ASSEMBLER.recipeBuilder()
        .inputs(ore('stickMagnalium') * 6)
        .inputs(ore('platePlastic') * 4)
        .inputs(metaitem('electric.motor.mv') * 4)
        .inputs(metaitem('rotorFiberReinforcedNylon') * 4)
        .inputs(metaitem('wireless') * 1)
        .inputs(metaitem('battery.ni_cd.mv') * 1)
        .inputs(ore('circuitMv') * 2)
        .outputs(metaitem('susy:cargo_drone.basic').withNbt(["Charge": 0L]))
        .EUt(VA[MV])
        .duration(200)
        .buildAndRegister()


ASSEMBLER.recipeBuilder()
        .inputs(ore('stickTitanium') * 6)
        .inputs(ore('platePolytetrafluoroethylene') * 4)
        .inputs(metaitem('electric.motor.hv') * 4)
        .inputs(metaitem('rotorFiberReinforcedNylon') * 4)
        .inputs(metaitem('wireless') * 1)
        .inputs(metaitem('battery.ni_fe.hv') * 4)
        .inputs(ore('circuitHv') * 2)
        .outputs(metaitem('susy:cargo_drone.advanced').withNbt(["Charge": 0L]))
        .EUt(VA[HV])
        .duration(360)
        .buildAndRegister()

ASSEMBLER.recipeBuilder()
        .inputs(ore('stickTitanium') * 6)
        .inputs(ore('platePolytetrafluoroethylene') * 4)
        .inputs(metaitem('electric.motor.hv') * 4)
        .inputs(metaitem('rotorFiberReinforcedNylon') * 4)
        .inputs(metaitem('wireless') * 1)
        .inputs(metaitem('battery.ni_cd.hv') * 3)
        .inputs(ore('circuitHv') * 2)
        .outputs(metaitem('susy:cargo_drone.advanced').withNbt(["Charge": 0L]))
        .EUt(VA[HV])
        .duration(300)
        .buildAndRegister()

ASSEMBLER.recipeBuilder()
        .inputs(ore('stickTitanium') * 6)
        .inputs(ore('platePolytetrafluoroethylene') * 4)
        .inputs(metaitem('electric.motor.hv') * 4)
        .inputs(metaitem('rotorFiberReinforcedNylon') * 4)
        .inputs(metaitem('wireless') * 1)
        .inputs(metaitem('battery.ni_mh.hv') * 1)
        .inputs(ore('circuitHv') * 2)
        .outputs(metaitem('susy:cargo_drone.advanced').withNbt(["Charge": 0L]))
        .EUt(VA[HV])
        .duration(150)
        .buildAndRegister()


crafting.addShaped("susy:drone_basket", metaitem('susy:drone_deposit_basket'), [
        [ore('platePlastic'), metaitem('wireless'), ore('platePlastic')],
        [ore('stickLongMagnalium'), metaitem('screwMagnalium'), ore('stickLongMagnalium')],
        [ore('platePlastic'), ore('stickLongMagnalium'), ore('platePlastic')]
])

ASSEMBLER.recipeBuilder()
        .inputs(ore('wireFineAnnealedCopper') * 8)
        .inputs(ore('platePlastic') * 3)
        .inputs(ore('circuitMv') * 2)
        .inputs(ore('circuitLv') * 4)
        .outputs(metaitem('susy:location_card'))
        .EUt(VA[MV])
        .duration(120)
        .buildAndRegister()
