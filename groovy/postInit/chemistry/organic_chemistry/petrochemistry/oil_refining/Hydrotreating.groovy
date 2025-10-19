import static prePostInit.Recipemaps.*
import static globals.Petrochemistry.*
import static gregtech.api.GTValues.*

fractions.each { _, fraction ->
    if (fraction.sulfuric) {
        FLUID_HEATER.recipeBuilder()
            .fluidInputs(fraction.getSulfuric(1000))
            .fluidOutputs(fraction.getHeated(1000))
            .duration(40)
            .EUt(VA[LV])
            .buildAndRegister()
    
        FIXED_BR.recipeBuilder()
            .fluidInputs(fraction.getHeated(1000))
            .fluidInputs(fluid('hydrogen') * 100)
            .notConsumable(metaitem('catalystBedHydrotreatingCatalyst'))
            .fluidOutputs(fraction.getTreatedSulfuric(1000))
            .duration(15)
            .EUt(VA[LV])
            .buildAndRegister()

        SIEVE_DT.recipeBuilder()
            .fluidInputs(fraction.getTreatedSulfuric(1000))
            .fluidOutputs(fraction.get(1000))
            .fluidOutputs(fluid('sour_gas') * 100)
            .duration(50)
            .EUt(VA[LV])
            .buildAndRegister()
    }
}

// Sour gas processing

BCR.recipeBuilder()
    .fluidInputs(fluid('sour_gas') * 2000)
    .fluidInputs(fluid('ethanolamine_mix') * 1000)
    .fluidOutputs(fluid('hydrogen') * 1000)
    .fluidOutputs(fluid('rich_amine') * 1000)
    .duration(40)
    .EUt(VA[MV])
    .buildAndRegister()

BCR.recipeBuilder()
    .fluidInputs(fluid('rich_amine') * 1000)
    .fluidOutputs(fluid('hydrogen_sulfide') * 500)
    .fluidOutputs(fluid('ethanolamine_mix') * 1000)
    .duration(10)
    .EUt(VA[MV])
    .buildAndRegister()

// Sulfuric overheads

BCR.recipeBuilder()
    .fluidInputs(fluid('sulfuric_catalytic_overheads') * 4000)
    .fluidInputs(fluid('ethanolamine_mix') * 1000)
    .fluidOutputs(fluid('catalytic_overheads') * 4000)
    .fluidOutputs(fluid('rich_amine') * 1000)
    .duration(40)
    .EUt(VA[MV])
    .buildAndRegister()
