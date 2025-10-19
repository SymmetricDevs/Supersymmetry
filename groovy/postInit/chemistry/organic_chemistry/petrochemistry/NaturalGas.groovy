import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Water removal 

MIXER.recipeBuilder()
.fluidInputs(fluid('crude_natural_gas') * 1000)
.fluidInputs(fluid('triethylene_glycol') * 1000)
.fluidOutputs(fluid('sulfuric_natural_gas') * 1000)
.fluidOutputs(fluid('hydrated_triethylene_glycol') * 1000)
.duration(10)
.EUt(VA[LV])
.buildAndRegister()

FLUID_HEATER.recipeBuilder()
.fluidInputs(fluid('hydrated_triethylene_glycol') * 1000)
.fluidOutputs(fluid('triethylene_glycol') * 1000)
.duration(10)
.EUt(VA[LV])
.buildAndRegister()

// Acid gas removal (H2S, CO2)

BCR.recipeBuilder()
.fluidInputs(fluid('sulfuric_natural_gas') * 10000)
.fluidInputs(fluid('ethanolamine_mix') * 1000)
.fluidOutputs(fluid('natural_gas') * 8000)
.fluidOutputs(fluid('acidic_rich_amine') * 1000)
.duration(40)
.EUt(VA[MV])
.buildAndRegister()

DT.recipeBuilder()
.fluidInputs(fluid('acidic_rich_amine') * 1000)
.fluidOutputs(fluid('ethanolamine_mix') * 1000)
.fluidOutputs(fluid('carbon_dioxide') * 1000)
.fluidOutputs(fluid('hydrogen_sulfide') * 1000)
.duration(10)
.EUt(VA[MV])
.buildAndRegister()

// Natural Gas Distillation

DT.recipeBuilder()
.fluidInputs(fluid('natural_gas') * 1000)
.fluidOutputs(fluid('butane') * 50)
.fluidOutputs(fluid('propane') * 100)
.fluidOutputs(fluid('ethane') * 100)
.fluidOutputs(fluid('methane') * 750)
.duration(400)
.EUt(VA[LV] * 2)
.buildAndRegister()

HIGH_PRESSURE_CRYO_DT.recipeBuilder()
.fluidInputs(fluid('liquid_natural_gas') * 20)
.fluidOutputs(fluid('butane') * 64)
.fluidOutputs(fluid('propane') * 128)
.fluidOutputs(fluid('ethane') * 128)
.fluidOutputs(fluid('methane') * 960)
.fluidOutputs(fluid('helium') * 24)
.duration(100)
.EUt(VA[MV] * 2)
.buildAndRegister()
