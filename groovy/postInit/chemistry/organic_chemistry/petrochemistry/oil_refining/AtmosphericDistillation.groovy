import static globals.Petrochemistry.*

DT = recipemap('sieve_distillation')
PHASE_SEPARATOR = recipemap('phase_separator')

// Atmospheric distillation

DT.recipeBuilder()
    .fluidInputs(fluid('dense_steam') * 10000)
    .fluidInputs(oils.oil.getHeated(10000))
    .fluidOutputs(fluid('atmospheric_oil_residue') * 2000)
    .fluidOutputs(fractions.heavy_gas_oil.getCrude(500))
    .fluidOutputs(fractions.light_gas_oil.getCrude(1250))
    .fluidOutputs(fractions.kerosene.getCrude(1250))
    .fluidOutputs(fluid('atmospheric_overheads') * 5000)
    .duration(200)
    .EUt(30)
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('dense_steam') * 10000)
    .fluidInputs(oils.oil_heavy.getHeated(10000))
    .fluidOutputs(fluid('atmospheric_oil_residue') * 3500)
    .fluidOutputs(fractions.heavy_gas_oil.getCrude(1250))
    .fluidOutputs(fractions.light_gas_oil.getCrude(1250))
    .fluidOutputs(fractions.kerosene.getCrude(500))
    .fluidOutputs(fluid('heavy_atmospheric_overheads') * 3500)
    .duration(200)
    .EUt(30)
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('dense_steam') * 10000)
    .fluidInputs(oils.oil_light.getHeated(10000))
    .fluidOutputs(fluid('atmospheric_oil_residue') * 1000)
    .fluidOutputs(fractions.heavy_gas_oil.getCrude(250))
    .fluidOutputs(fractions.light_gas_oil.getCrude(1000))
    .fluidOutputs(fractions.kerosene.getCrude(1750))
    .fluidOutputs(fluid('light_atmospheric_overheads') * 6000)
    .duration(200)
    .EUt(30)
    .buildAndRegister()

// Stripping of contaminants using steam

fractions.each { _, fraction ->
    if (fraction.strippable) {
        DT.recipeBuilder()
        .fluidInputs(fraction.getCrude(1000))
        .fluidInputs(fluid('dense_steam') * 1000)
        .fluidOutputs(fraction.getSulfuric(1000))
        .fluidOutputs(fluid('sour_water') * 1000)
        .duration(20)
        .EUt(30)
        .buildAndRegister()
    }
}

// Overheads processing

PHASE_SEPARATOR.recipeBuilder()
    .fluidInputs(fluid('atmospheric_overheads') * 2500)
    .fluidOutputs(fractions.naphtha.getCrude(2500))
    .fluidOutputs(fluid('sour_water') * 5000)
    .duration(200)
    .buildAndRegister()

PHASE_SEPARATOR.recipeBuilder()
    .fluidInputs(fluid('heavy_atmospheric_overheads') * 1750)
    .fluidOutputs(fractions.naphtha.getCrude(1750))
    .fluidOutputs(fluid('sour_water') * 5000)
    .duration(200)
    .buildAndRegister()

PHASE_SEPARATOR.recipeBuilder()
    .fluidInputs(fluid('light_atmospheric_overheads') * 3000)
    .fluidOutputs(fractions.naphtha.getCrude(3000))
    .fluidOutputs(fluid('sour_water') * 5000)
    .duration(200)
    .buildAndRegister()

// Sour water stripping

BCR.recipeBuilder()
    .fluidInputs(fluid('sour_water') * 10000)
    .fluidInputs(fluid('dense_steam') * 1000)
    .fluidOutputs(fluid('hydrogen_sulfide') * 200)
    .fluidOutputs(fluid('wastewater') * 11000)
    .duration(100)
    .EUt(7)
    .buildAndRegister()