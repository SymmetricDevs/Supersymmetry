import static prePostInit.Recipemaps.*
import static globals.Petrochemistry.*
import static gregtech.api.GTValues.*

fractions.each { _, fraction ->
    if (fraction.sulfuric) {
        if (fraction.naphthenic) {
            CENTRIFUGE.recipeBuilder()
                .fluidInputs(fraction.getSulfuric(1000))
                .fluidInputs(fluid('diluted_sodium_hydroxide_solution') * (fraction.naphthenic_acid_content * 2))
                .fluidOutputs(fraction.getAlkaliTreated(1000))
                .fluidOutputs(fluid('sodium_naphthenate_solution') * (fraction.naphthenic_acid_content * 2))
                .duration(60)
                .EUt(VA[LV])
                .buildAndRegister()

            FLUID_HEATER.recipeBuilder()
                .fluidInputs(fraction.getAlkaliTreated(1000))
                .fluidOutputs(fraction.getHeated(1000))
                .duration(40)
                .EUt(VA[LV])
                .buildAndRegister()
        } else {
            FLUID_HEATER.recipeBuilder()
                .fluidInputs(fraction.getSulfuric(1000))
                .fluidOutputs(fraction.getHeated(1000))
                .duration(40)
                .EUt(VA[LV])
                .buildAndRegister()
        }
    
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

// DCL light liquefaction oil hydrotreating to naphtha

FLUID_HEATER.recipeBuilder()
    .fluidInputs(fluid('light_liquefaction_oil') * 1000)
    .fluidOutputs(fluid('heated_light_liquefaction_oil') * 1000)
    .duration(40)
    .EUt(VA[LV])
    .buildAndRegister()
        
FIXED_BR.recipeBuilder()
    .fluidInputs(fluid('heated_light_liquefaction_oil') * 1000)
    .fluidInputs(fluid('hydrogen') * 200)
    .notConsumable(metaitem('catalystBedHydrotreatingCatalyst'))
    .fluidOutputs(fluid('treated_sulfuric_naphtha') * 1000)
    .duration(15)
    .EUt(VA[LV])
    .buildAndRegister()

SIEVE_DT.recipeBuilder()
    .fluidInputs(fluid('treated_sulfuric_naphtha') * 1000)
    .fluidOutputs(fluid('naphtha') * 1000)
    .fluidOutputs(fluid('sour_gas') * 200)
    .duration(50)
    .EUt(VA[LV])
    .buildAndRegister()

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

// Naphthenic acid recovery

BR.recipeBuilder()
    .fluidInputs(fluid('sodium_naphthenate_solution') * 2000)
    .fluidInputs(fluid('sulfuric_acid') * 500)
    .fluidInputs(fluid('carbon_dioxide') * 10)
    .fluidOutputs(fluid('naphthenic_acid') * 1000)
    .fluidOutputs(fluid('wastewater') * 3000)
    .duration(60)
    .EUt(VA[MV])
    .buildAndRegister()