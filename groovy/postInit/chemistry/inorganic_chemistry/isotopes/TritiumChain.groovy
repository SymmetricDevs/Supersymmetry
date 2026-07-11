import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

PHASE_SEPARATOR.recipeBuilder()
    .fluidInputs(fluid('tritiated_heavy_water') * 7680)
    .fluidOutputs(fluid('tritiated_steam'))
    .fluidOutputs(fluid('pressurized_heavy_water') * 7679)
    .duration(10)
    .buildAndRegister()

FIXED_BR.recipeBuilder()
    .notConsumable(metaitem('catalystBedSupportedPlatinum'))
    .fluidInputs(fluid('hydrogen') * 2)
    .fluidInputs(fluid('tritiated_steam'))
    .fluidOutputs(fluid('deuterium_tritium_mixture') * 2)
    .fluidOutputs(fluid('dense_steam'))
    .EUt(VA[HV])
    .duration(100)
    .buildAndRegister()

SINGLE_COLUMN_CRYO_DT.recipeBuilder()
    .fluidInputs(fluid('deuterium_tritium_mixture') * 100)
    .fluidOutputs(fluid('tritium') * 1)
    .fluidOutputs(fluid('deuterium') * 99)
    .EUt(VA[HV])
    .duration(100)
    .buildAndRegister()
