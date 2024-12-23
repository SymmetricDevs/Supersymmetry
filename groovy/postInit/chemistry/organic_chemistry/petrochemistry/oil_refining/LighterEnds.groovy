import static globals.Petrochemistry.*

DT = recipemap('sieve_distillation')
BCR = recipemap('bubble_column_reactor')
SINGLE_COLUMN_CRYOGENIC_DISTILLATION_PLANT = recipemap('single_column_cryogenic_distillation')

// Debutanization

DT.recipeBuilder()
    .fluidInputs(fractions.naphtha.getCrude(10000))
    .fluidOutputs(fluid('sulfuric_debutanized_naphtha') * 8000)
    .fluidOutputs(fluid('sulfuric_fuel_gas') * 2000)
    .duration(400)
    .EUt(30)
    .buildAndRegister() 

// Naphtha hydrotreatment/splitting

DT.recipeBuilder()
    .fluidInputs(fluid('sulfuric_debutanized_naphtha') * 10000)
    .fluidOutputs(fluid('sulfuric_heavy_naphtha') * 5000)
    .fluidOutputs(fluid('sulfuric_light_naphtha') * 5000)
    .duration(400)
    .EUt(30)
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('naphtha') * 10000)
    .fluidOutputs(fluid('heavy_naphtha') * 5000)
    .fluidOutputs(fluid('light_naphtha') * 5000)
    .duration(400)
    .EUt(30)
    .buildAndRegister()

// Depropanization

DT.recipeBuilder()
    .fluidInputs(fluid('sulfuric_fuel_gas') * 1000)
    .fluidOutputs(fluid('sulfuric_butane_fuel_gas') * 600)
    .fluidOutputs(fluid('sulfuric_propane_fuel_gas') * 400)
    .duration(40)
    .EUt(30)
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('fuel_gas') * 1000)
    .fluidOutputs(fluid('butane_fuel_gas') * 600)
    .fluidOutputs(fluid('propane_fuel_gas') * 400)
    .duration(40)
    .EUt(30)
    .buildAndRegister()
    
// Deethanization

DT.recipeBuilder()
    .fluidInputs(fluid('propane_fuel_gas') * 1000)
    .fluidOutputs(fluid('propane') * 900)
    .fluidOutputs(fluid('ethane') * 100)
    .duration(40)
    .EUt(30)
    .buildAndRegister()

// Amine desulfuization

BCR.recipeBuilder()
    .fluidInputs(fluid('sulfuric_butane_fuel_gas') * 3000)
    .fluidInputs(fluid('ethanolamine_mix') * 1000)
    .fluidOutputs(fluid('butane_fuel_gas') * 3000)
    .fluidOutputs(fluid('rich_amine') * 1000)
    .duration(40)
    .EUt(120)
    .buildAndRegister()

BCR.recipeBuilder()
    .fluidInputs(fluid('sulfuric_propane_fuel_gas') * 3000)
    .fluidInputs(fluid('ethanolamine_mix') * 1000)
    .fluidOutputs(fluid('propane_fuel_gas') * 3000)
    .fluidOutputs(fluid('rich_amine') * 1000)
    .duration(40)
    .EUt(120)
    .buildAndRegister()

BCR.recipeBuilder()
    .fluidInputs(fluid('sulfuric_fuel_gas') * 3000)
    .fluidInputs(fluid('ethanolamine_mix') * 1000)
    .fluidOutputs(fluid('fuel_gas') * 3000)
    .fluidOutputs(fluid('rich_amine') * 1000)
    .duration(40)
    .EUt(120)
    .buildAndRegister()

// iC4-nC4 separation

DT.recipeBuilder()
    .fluidInputs(fluid('butane_fuel_gas') * 1000)
    .fluidOutputs(fluid('butane') * 800)
    .fluidOutputs(fluid('isobutane') * 200)
    .duration(40)
    .EUt(30)
    .buildAndRegister()

// FCC light ends treatment

DT.recipeBuilder() // Mwt: 24.533
    .fluidInputs(fluid('catalytic_overheads') * 1000)
    .fluidOutputs(fluid('catalytic_olefin_rich_mixture') * 830)
    .fluidOutputs(fluid('hydrogen') * 170)
    .duration(100)
    .EUt(30)
    .buildAndRegister()

DT.recipeBuilder() // Mwt: 29.145 
    .fluidInputs(fluid('catalytic_olefin_rich_mixture') * 830)
    .fluidOutputs(fluid('catalytic_c_four_fraction') * 30)
    .fluidOutputs(fluid('catalytic_c_three_fraction') * 70)
    .fluidOutputs(fluid('catalytic_light_gases') * 730)
    .duration(100)
    .EUt(30)
    .buildAndRegister()

SINGLE_COLUMN_CRYOGENIC_DISTILLATION_PLANT.recipeBuilder() // Mwt: 21.8698
    .fluidInputs(fluid('catalytic_light_gases') * 1000)
    .fluidOutputs(fluid('ethane') * 270)
    .fluidOutputs(fluid('ethylene') * 170)
    .fluidOutputs(fluid('methane') * 560)
    .duration(100)
    .EUt(30)
    .buildAndRegister()

DT.recipeBuilder() // Mwt: 42.585
    .fluidInputs(fluid('catalytic_c_three_fraction') * 1000)
    .fluidOutputs(fluid('propane') * 250)
    .fluidOutputs(fluid('propene') * 750)
    .duration(100)
    .EUt(30)
    .buildAndRegister()

DT.recipeBuilder() // Mwt: 57.114
    .fluidInputs(fluid('catalytic_c_four_fraction') * 1000)
    .fluidOutputs(fluid('butane') * 150)
    .fluidOutputs(fluid('catalytic_butene_mixture') * 500)
    .fluidOutputs(fluid('isobutane') * 350)
    .duration(100)
    .EUt(30)
    .buildAndRegister()

DT.recipeBuilder() // Mwt: 56.108
    .fluidInputs(fluid('catalytic_butene_mixture') * 1000)
    .fluidOutputs(fluid('two_butene') * 450)
    .fluidOutputs(fluid('one_butene') * 250)
    .fluidOutputs(fluid('isobutylene') * 300)
    .duration(100)
    .EUt(30)
    .buildAndRegister()