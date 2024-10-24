import globals.Globals

LARGE_FLUID_PUMP = recipemap('large_fluid_pump')

LARGE_FLUID_PUMP.recipeBuilder()
    .circuitMeta(1)
    .fluidOutputs(fluid('water') * 1000)
    .duration(20)
    .biomes("river")
    .EUt(16)
    .buildAndRegister()

LARGE_FLUID_PUMP.recipeBuilder()
    .circuitMeta(2)
    .fluidOutputs(fluid('sea_water') * 1000)
    .duration(20)
    .biomes('ocean','frozen_ocean','deep_ocean','biomesoplenty:kelp_forest','biomesoplenty:coral_reef')
    .EUt(16)
    .buildAndRegister()
	