import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*
import postInit.utils.RecyclingHelper

//yeet

mods.jei.ingredient.yeet(item('gregtech:machine', 1597))
mods.jei.ingredient.yeet(item('gregtech:machine', 1599))

// monel400 recipe

INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('nickel') * 2268)  //are 15,75 ingot or is 63/4
    .inputs(ore('dustCopper') * 8)
    .inputs(ore('dustTinyIron') * 3)
    .inputs(ore('dustTinyManganese') * 2)
    .inputs(ore('dustSmallSilicon') * 2)
    .fluidOutputs(fluid('monel_400') * 3600)
    .EUt(VA[MV])
    .duration(960)
    .buildAndRegister()

SOLIDIFIER.recipeBuilder()
    .fluidInputs(fluid('monel_400') * 144)
    .outputs(metaitem('ingotMonel400'))
    .duration(20)
    .EUt(2)
    .buildAndRegister()

// Monel 400 casing
ASSEMBLER.recipeBuilder()
    .inputs(metaitem('plateMonel400') * 6)
    .inputs(ore('frameGtMonel400'))
    .outputs(item('susy:susy_multiblock_casing2', 1) * 2)
    .EUt(VA[LV])
    .duration(100)
    .buildAndRegister()

RecyclingHelper.addShaped("susy:monel_400_casing", item('susy:susy_multiblock_casing2', 1) * 2, [
    [ore('plateMonel400'), ore('toolHammer'), ore('plateMonel400')],
    [ore('plateMonel400'), ore('frameGtMonel400'), ore('plateMonel400')],
    [ore('plateMonel400'), ore('toolWrench'), ore('plateMonel400')]
])

// controller recipe

crafting.addShaped("wood_tank_controller", metaitem('susy:tank.wood'), [
    [null, ore('ringLead'), null],
    [ore('craftingToolSoftHammer'), item('gregtech:steam_casing', 5), ore('toolSaw')],
    [null, ore('ringLead'), null]
])

crafting.addShaped("steel_tank_controller", metaitem('susy:tank.steel'), [
    [null, ore('ringSteel'), null],
    [ore('craftingToolHardHammer'), item('gregtech:metal_casing', 4), ore('toolWrench')],
    [null, ore('ringSteel'), null]
])

crafting.addShaped("monel_tank_controller", metaitem('susy:tank.monel_400'), [
    [null, ore('ringMonel400'), null],
    [ore('craftingToolHardHammer'), item('susy:susy_multiblock_casing2', 1), ore('toolWrench')],
    [null, ore('ringMonel400'), null] //need to be changed to Monel 400 rotor
])

crafting.addShaped("stainless_steel_tank_controller", metaitem('susy:tank.stainless_steel'), [
    [null, ore('ringStainlessSteel'), null],
    [ore('craftingToolHardHammer'), item('gregtech:metal_casing', 5), ore('toolWrench')],
    [null, ore('ringStainlessSteel'), null]
])

crafting.addShaped("titanium_tank_controller", metaitem('susy:tank.titanium'), [
    [null, ore('ringTitanium'), null],
    [ore('craftingToolHardHammer'), item('gregtech:metal_casing', 6), ore('toolWrench')],
    [null, ore('ringTitanium'), null]
])

crafting.addShaped("tungsten_steel_tank_controller", metaitem('susy:tank.tungsten_steel'), [
    [null, ore('ringTungstenSteel'), null],
    [ore('craftingToolHardHammer'), item('gregtech:metal_casing', 7), ore('toolWrench')],
    [null, ore('ringTungstenSteel'), null]
])

ASSEMBLER.recipeBuilder()
        .inputs(ore('ringLead') * 2)
        .inputs(item('gregtech:steam_casing', 5))
        .outputs(metaitem('susy:tank.wood'))
        .circuitMeta(1)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister()

ASSEMBLER.recipeBuilder()
        .inputs(ore('ringSteel') * 2)
        .inputs(item('gregtech:metal_casing', 4))
        .outputs(metaitem('susy:tank.steel'))
        .circuitMeta(1)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister()

ASSEMBLER.recipeBuilder()
        .inputs(ore('ringMonel400') * 2)
        .inputs(item('susy:susy_multiblock_casing2', 1))
        .outputs(metaitem('susy:tank.monel_400'))
        .circuitMeta(1)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister()

ASSEMBLER.recipeBuilder()
        .inputs(ore('ringStainlessSteel') * 2)
        .inputs(item('gregtech:metal_casing', 5))
        .outputs(metaitem('susy:tank.stainless_steel'))
        .circuitMeta(1)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister()

ASSEMBLER.recipeBuilder()
        .inputs(ore('ringTitanium') * 2)
        .inputs(item('gregtech:metal_casing', 6))
        .outputs(metaitem('susy:tank.titanium'))
        .circuitMeta(1)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister()

ASSEMBLER.recipeBuilder()
        .inputs(ore('ringTungstenSteel') * 2)
        .inputs(item('gregtech:metal_casing', 7))
        .outputs(metaitem('susy:tank.tungsten_steel'))
        .circuitMeta(1)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister()

// valve recipe

crafting.addShaped("monel_tank_valve", metaitem('susy:tank_valve.monel_400'), [
    [null, ore('ringMonel400'), null],
    [ore('craftingToolHardHammer'), item('susy:susy_multiblock_casing2', 1), ore('toolWrench')],
    [null, ore('rotorMonel400'), null]
])

crafting.addShaped("stainless_steel_tank_valve", metaitem('susy:tank_valve.stainless_steel'), [
    [null, ore('ringStainlessSteel'), null],
    [ore('craftingToolHardHammer'), item('gregtech:metal_casing', 5), ore('toolWrench')],
    [null, ore('rotorStainlessSteel'), null]
])

crafting.addShaped("titanium_tank_valve", metaitem('susy:tank_valve.titanium'), [
    [null, ore('ringTitanium'), null],
    [ore('craftingToolHardHammer'), item('gregtech:metal_casing', 6), ore('toolWrench')],
    [null, ore('rotorTitanium'), null]
])

crafting.addShaped("tungsten_steel_tank_valve", metaitem('susy:tank_valve.tungsten_steel'), [
    [null, ore('ringTungstenSteel'), null],
    [ore('craftingToolHardHammer'), item('gregtech:metal_casing', 7), ore('toolWrench')],
    [null, ore('rotorTungstenSteel'), null]
])

ASSEMBLER.recipeBuilder()
        .inputs(ore('ringMonel400'))
        .inputs(ore('rotorMonel400'))
        .inputs(item('susy:susy_multiblock_casing2', 1))
        .outputs(metaitem('susy:tank_valve.monel_400'))
        .circuitMeta(1)
        .duration(50)
        .EUt(VA[LV])
        .buildAndRegister()

ASSEMBLER.recipeBuilder()
        .inputs(ore('ringStainlessSteel'))
        .inputs(ore('rotorStainlessSteel'))
        .inputs(item('gregtech:metal_casing', 5))
        .outputs(metaitem('susy:tank_valve.stainless_steel'))
        .circuitMeta(1)
        .duration(50)
        .EUt(VA[LV])
        .buildAndRegister()

ASSEMBLER.recipeBuilder()
        .inputs(ore('ringTitanium'))
        .inputs(ore('rotorTitanium'))
        .inputs(item('gregtech:metal_casing', 6))
        .outputs(metaitem('susy:tank_valve.titanium'))
        .circuitMeta(1)
        .duration(50)
        .EUt(VA[LV])
        .buildAndRegister()

ASSEMBLER.recipeBuilder()
        .inputs(ore('ringTungstenSteel'))
        .inputs(ore('rotorTungstenSteel'))
        .inputs(item('gregtech:metal_casing', 7))
        .outputs(metaitem('susy:tank_valve.tungsten_steel'))
        .circuitMeta(1)
        .duration(50)
        .EUt(VA[LV])
        .buildAndRegister()