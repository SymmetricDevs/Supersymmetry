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
    .fluidOutputs(fluid('Monel_400') * 3600)
    .EUt(VA[MV])
    .duration(960)
    .buildAndRegister()

SOLIDIFIER.recipeBuilder()
    .fluidInputs(fluid('Monel_400') * 144)
    .outputs(metaitem('ingotMonel_400'))
    .duration(20)
    .EUt(2)
    .buildAndRegister()

// controller recipe

crafting.addShaped("wood_tank_controller", metaitem('susy:tank.wood'), [
    [null, ore('ringLead'), null],
    [ore('craftingToolSoftHammer'), item('gregtech:steam_casing', 5), ore('toolSaw')],
    [null, ore('ringLead'), null]
])

crafting.addShaped("steel_tank_controller", metaitem('susy:tank.steel'), [
    [null, ore('ringSteel'), null],
    [ore('craftingToolHardHammer'), item('gregtech:metal_casing', 4), ore('toolSaw')],
    [null, ore('ringSteel'), null]
])

crafting.addShaped("monel_tank_controller", metaitem('susy:tank.monel_400'), [
    [null, ore('ringMonel400'), null],
    [ore('craftingToolHardHammer'), item('susy:susy_multiblock_casing2', 1), ore('toolSaw')],
    [null, ore('ringSteel'), null] //need to be changed to Monel 400 rotor
])

crafting.addShaped("stainless_steel_tank_controller", metaitem('susy:tank.stainless_steel'), [
    [null, ore('ringStainlessSteel'), null],
    [ore('craftingToolHardHammer'), item('gregtech:metal_casing', 5), ore('toolSaw')],
    [null, ore('ringStainlessSteel'), null]
])

crafting.addShaped("titanium_tank_controller", metaitem('susy:tank.titanium'), [
    [null, ore('ringTitanium'), null],
    [ore('craftingToolHardHammer'), item('gregtech:metal_casing', 6), ore('toolSaw')],
    [null, ore('ringTitanium'), null]
])

crafting.addShaped("tungsten_steel_tank_controller", metaitem('susy:tank.tungsten_steel'), [
    [null, ore('ringTungstenSteel'), null],
    [ore('craftingToolHardHammer'), item('gregtech:metal_casing', 7), ore('toolSaw')],
    [null, ore('ringTungstenSteel'), null]
])


// valve recipe

crafting.addShaped("monel_tank_valve", metaitem('susy:tank_valve.monel_400'), [
    [null, ore('ringMonel400'), null],
    [ore('craftingToolHardHammer'), item('susy:susy_multiblock_casing2', 1), ore('toolSaw')],
    [null, ore('rotorMonel400'), null]
])

crafting.addShaped("stainless_steel_tank_valve", metaitem('susy:tank_valve.stainless_steel'), [
    [null, ore('ringStainlessSteel'), null],
    [ore('craftingToolHardHammer'), item('gregtech:metal_casing', 5), ore('toolSaw')],
    [null, ore('rotorStainlessSteel'), null]
])

crafting.addShaped("titanium_tank_valve", metaitem('susy:tank_valve.titanium'), [
    [null, ore('ringTitanium'), null],
    [ore('craftingToolHardHammer'), item('gregtech:metal_casing', 6), ore('toolSaw')],
    [null, ore('rotorTitanium'), null]
])

crafting.addShaped("tungsten_steel_tank_valve", metaitem('susy:tank_valve.tungsten_steel'), [
    [null, ore('ringTungstenSteel'), null],
    [ore('craftingToolHardHammer'), item('gregtech:metal_casing', 7), ore('toolSaw')],
    [null, ore('rotorTungstenSteel'), null]
])