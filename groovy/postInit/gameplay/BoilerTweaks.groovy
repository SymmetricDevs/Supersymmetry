import globals.Globals
import postInit.utils.RecyclingHelper

RecyclingHelper.addShaped('susy:large_steel_boiler', metaitem('susy:large_boiler.steel'), [
    [ore('cableGtSingleCopper'), ore('circuitMv'), ore('cableGtSingleCopper')],
    [ore('circuitMv'), item('gregtech:boiler_firebox_casing', 1), ore('circuitMv')],
    [ore('cableGtSingleCopper'), ore('circuitMv'), ore('cableGtSingleCopper')]
])

RecyclingHelper.addShaped('susy:large_bronze_boiler', metaitem('susy:large_boiler.bronze'), [
    [ore('cableGtSingleTin'), ore('circuitLv'), ore('cableGtSingleTin')],
    [ore('circuitLv'), item('gregtech:boiler_firebox_casing', 0), ore('circuitLv')],
    [ore('cableGtSingleTin'), ore('circuitLv'), ore('cableGtSingleTin')]
])

RecyclingHelper.addShaped('susy:steam_boiler_coal_bronze', metaitem('susy:steam_boiler_coal.bronze'), [
        [ore('plateBronze'), ore('plateBronze'), ore('plateBronze')], 
        [ore('plateBronze'), ore('toolWrench'), ore('plateBronze')],
        [item('minecraft:brick_block'), ore('craftingFurnace'), item('minecraft:brick_block')]
])

RecyclingHelper.addShaped('susy:steam_boiler_coal_steel', metaitem('susy:steam_boiler_coal.steel'), [
        [ore('plateSteel'), ore('plateSteel'), ore('plateSteel')], 
        [ore('plateSteel'), ore('toolWrench'), ore('plateSteel')],
        [item('minecraft:brick_block'), ore('craftingFurnace'), item('minecraft:brick_block')]
])

RecyclingHelper.addShaped('susy:steam_boiler_liquid_bronze', metaitem('susy:steam_boiler_liquid.bronze'), [
    [ore('plateBronze'), ore('plateBronze'), ore('plateBronze')],
    [ore('plateBronze'), ore('blockGlass'), ore('plateBronze')],
    [ore('plateBronze'), item('gregtech:steam_casing', 1), ore('plateBronze')]
])

RecyclingHelper.addShaped('susy:steam_boiler_liquid_steel', metaitem('susy:steam_boiler_liquid.steel'), [
    [ore('plateSteel'), ore('plateSteel'), ore('plateSteel')],
    [ore('plateSteel'), ore('blockGlass'), ore('plateSteel')],
    [ore('plateSteel'), item('gregtech:steam_casing', 3), ore('plateSteel')]
])

// Convert from old boilers to new boilers

crafting.addShapeless('susy:large_bronze_convert', metaitem('susy:large_boiler.bronze'), [
    metaitem('large_boiler.bronze')
])

crafting.addShapeless('susy:large_steel_convert', metaitem('susy:large_boiler.steel'), [
    metaitem('large_boiler.steel')
])

crafting.addShapeless('susy:steam_boiler_coal_bronze_convert', metaitem('susy:steam_boiler_coal.bronze'), [
    metaitem('steam_boiler_coal_bronze')
])

crafting.addShapeless('susy:steam_boiler_coal_steel_convert', metaitem('susy:steam_boiler_coal.steel'), [
    metaitem('steam_boiler_coal_steel')
])

crafting.addShapeless('susy:steam_boiler_liquid_bronze_convert', metaitem('susy:steam_boiler_liquid.bronze'), [
    metaitem('steam_boiler_lava_bronze')
])

crafting.addShapeless('susy:steam_boiler_liquid_steel_convert', metaitem('susy:steam_boiler_liquid.steel'), [
    metaitem('steam_boiler_lava_steel')
])

// Add recipes for the new boilers to run
LIQUID_FUELS = recipemap('semi_fluid_generator')
SOLID_FUELS = recipemap('boiler')

// To get these numbers, I used the SUSY power generation spreadsheet:
// https://docs.google.com/spreadsheets/d/1ly1k0JBe7JWEnP6MNbDnroIvlduYVqt3JH3zbmC43I0/edit?usp=sharing
// I normalized each input to GTValues.M of a material.
// Then, I multiply each duration by 20 (to convert to ticks) and by 16 (to go from the LBB value of 512 EU/t to 32 EU/t for LV).
// Essentially, I multiplied all durations by 320.
SOLID_FUELS.recipeBuilder()
        .inputs(ore('dustWood'))
        .duration(80)
        .EUt(-32)
        .buildAndRegister()
SOLID_FUELS.recipeBuilder()
        .inputs(ore('dustCharcoal'))
        .duration(800)
        .EUt(-32)
        .buildAndRegister()
SOLID_FUELS.recipeBuilder()
        .inputs(ore('dustCoal'))
        .duration(992)
        .EUt(-32)
        .buildAndRegister()
SOLID_FUELS.recipeBuilder()
        .inputs(ore('dustLignite'))
        .duration(496)
        .EUt(-32)
        .buildAndRegister()
SOLID_FUELS.recipeBuilder()
        .inputs(ore('dustCoke'))
        .duration(1328)
        .EUt(-32)
        .buildAndRegister()
SOLID_FUELS.recipeBuilder()
        .inputs(ore('dustLigniteCoke'))
        .duration(992)
        .EUt(-32)
        .buildAndRegister()
SOLID_FUELS.recipeBuilder()
        .inputs(ore('dustAnthracite'))
        .duration(2000)
        .EUt(-32)
        .buildAndRegister()

// Liquid recipes. I divide by 4 to reduce the amounts.
LIQUID_FUELS.recipeBuilder()
        .fluidInputs(fluid('creosote') * 250)
        .duration(240)
        .EUt(-32)
        .buildAndRegister()
LIQUID_FUELS.recipeBuilder()
        .fluidInputs(fluid('coal_gas') * 250)
        .duration(160)
        .EUt(-32)
        .buildAndRegister()
LIQUID_FUELS.recipeBuilder()
        .fluidInputs(fluid('wood_gas') * 250)
        .duration(120)
        .EUt(-32)
        .buildAndRegister()