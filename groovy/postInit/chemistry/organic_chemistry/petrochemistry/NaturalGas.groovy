import globals.Globals

MIXER = recipemap('mixer')
FLUID_HEATER = recipemap('fluid_heater')
BCR = recipemap('bubble_column_reactor')
DT = recipemap('distillation_tower')

// Water removal 

MIXER.recipeBuilder()
.fluidInputs(fluid('crude_natural_gas') * 1000)
.fluidInputs(fluid('triethylene_glycol') * 1000)
.fluidOutputs(fluid('sulfuric_natural_gas') * 1000)
.fluidOutputs(fluid('hydrated_triethylene_glycol') * 1000)
.duration(10)
.EUt(30)
.buildAndRegister()

FLUID_HEATER.recipeBuilder()
.fluidInputs(fluid('hydrated_triethylene_glycol') * 1000)
.fluidOutputs(fluid('triethylene_glycol') * 1000)
.duration(10)
.EUt(30)
.buildAndRegister()

// Acid gas removal (H2S, CO2)

BCR.recipeBuilder()
.fluidInputs(fluid('sulfuric_natural_gas') * 10000)
.fluidInputs(fluid('ethanolamine_mix') * 1000)
.fluidOutputs(fluid('natural_gas') * 8000)
.fluidOutputs(fluid('acidic_rich_amine') * 1000)
.duration(40)
.EUt(120)
.buildAndRegister()

DT.recipeBuilder()
.fluidInputs(fluid('acidic_rich_amine') * 1000)
.fluidOutputs(fluid('hydrogen_sulfide') * 1000)
.fluidOutputs(fluid('carbon_dioxide') * 1000)
.fluidOutputs(fluid('ethanolamine_mix') * 1000)
.duration(10)
.EUt(120)
.buildAndRegister()

// Natural Gas Distillation

DT.recipeBuilder()
.fluidInputs(fluid('natural_gas') * 1000)
.fluidOutputs(fluid('butane') * 100)
.fluidOutputs(fluid('propane') * 100)
.fluidOutputs(fluid('ethane') * 100)
.fluidOutputs(fluid('methane') * 750)
.duration(400)
.EUt(Globals.voltAmps[1] * 2)
.buildAndRegister()

DT.recipeBuilder()
.fluidInputs(fluid('liquid_natural_gas') * 20)
.fluidOutputs(fluid('butane') * 128)
.fluidOutputs(fluid('propane') * 128)
.fluidOutputs(fluid('ethane') * 128)
.fluidOutputs(fluid('methane') * 960)
.fluidOutputs(fluid('helium') * 25)
.duration(100)
.EUt(Globals.voltAmps[2] * 2)
.buildAndRegister()