import petrochemistry.Petrochemistry

DT = recipemap('distillation_tower')
BCR = recipemap('bubble_column_reactor')

// Debutanization
DT.recipeBuilder()
    .fluidInputs(fractions.naphtha.getCrude(10000))
    .fluidOutputs(fluid('sulfuric_debutanized_naphtha') * 8000)
    .fluidOutputs(fluid('sulfuric_fuel_gas') * 2000)
    .duration(400)
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fractions.naphtha.get(10000))
    .fluidOutputs(fluid('debutanized_naphtha') * 8000)
    .fluidOutputs(fluid('fuel_gas') * 2000)
    .duration(400)
    .buildAndRegister()

// Naphtha hydrotreatment/splitting
DT.recipeBuilder()
    .fluidInputs(fluid('sulfuric_debutanized_naphtha') * 10000)
    .fluidOutputs(fluid('sulfuric_heavy_naphtha') * 4000)
    .fluidOutputs(fluid('sulfuric_light_naphtha') * 6000)
    .duration(400)
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('naphtha') * 10000)
    .fluidOutputs(fluid('heavy_naphtha') * 4000)
    .fluidOutputs(fluid('light_naphtha') * 6000)
    .duration(400)
    .buildAndRegister()

// Depropanization
DT.recipeBuilder()
    .fluidInputs(fluid('sulfuric_fuel_gas') * 1000)
    .fluidOutputs(fluid('sulfuric_butane_fuel_gas') * 600)
    .fluidOutputs(fluid('sulfuric_propane_fuel_gas') * 400)
    .duration(40)
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('fuel_gas') * 1000)
    .fluidOutputs(fluid('butane_fuel_gas') * 600)
    .fluidOutputs(fluid('propane_fuel_gas') * 400)
    .duration(40)
    .buildAndRegister()
    
// Deethanization
DT.recipeBuilder()
    .fluidInputs(fluid('propane_fuel_gas') * 1000)
    .fluidOutputs(fluid('propane') * 900)
    .fluidOutputs(fluid('ethane') * 100)
    .duration(40)
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
    .buildAndRegister()