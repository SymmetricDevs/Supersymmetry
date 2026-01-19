import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Wastewater treatment

FLUID_HEATER.recipeBuilder()
    .fluidInputs(fluid('wastewater') * 1000)
    .fluidOutputs(fluid('heated_wastewater') * 1000)
    .duration(80)
    .EUt(VA[LV])
    .buildAndRegister()

MIXER.recipeBuilder()
    .fluidInputs(fluid('heated_wastewater') * 1000)
    .inputs(ore('dustFlocculant'))
    .fluidOutputs(fluid('flocculated_wastewater') * 1000)
    .duration(80)
    .EUt(VA[LV])
    .buildAndRegister()

CLARIFIER.recipeBuilder()
    .fluidInputs(fluid('flocculated_wastewater') * 8000)
    .outputs(metaitem('dustAluminiumSulfate'))
    .fluidOutputs(fluid('wastewater_sludge') * 2000)
    .fluidOutputs(fluid('water') * 6000)
    .duration(600)
    .EUt(VA[LV])
    .buildAndRegister()

// Acidic wastewater

BR.recipeBuilder()
    .fluidInputs(fluid('acidic_wastewater') * 1000)
    .inputs(ore('dustSodaAsh'))
    .fluidOutputs(fluid('wastewater') * 1000)
    .fluidOutputs(fluid('carbon_dioxide') * 1000)
    .duration(200)
    .EUt(VA[LV])
    .buildAndRegister()

// Gaseous effluents

ROASTER.recipeBuilder()
    .fluidInputs(fluid('corrosive_gas') * 1000)
    .fluidOutputs(fluid('burned_gas') * 1000)
    .duration(80)
    .EUt(VA[LV])
    .buildAndRegister()

BCR.recipeBuilder()
    .fluidInputs(fluid('burned_gas') * 1000)
    .fluidInputs(fluid('diluted_sodium_hydroxide_solution') * 2000)
    .fluidOutputs(fluid('wastewater') * 2000)
    .duration(80)
    .EUt(VA[LV])
    .buildAndRegister()