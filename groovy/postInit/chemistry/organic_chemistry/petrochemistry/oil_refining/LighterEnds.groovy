import petrochemistry.Petrochemistry

DT = recipemap('distillation_tower')
BCR = recipemap('bubble_column_reactor')

// Debutanization
DT.recipeBuilder()
    .fluidInputs(fluid('crude_naphtha') * 10000)
    .fluidOutputs(fluid('debutanized_naphtha') * 8000)
    .fluidOutputs(fluid('sulfuric_lpg') * 2000)
    .duration(400)
    .buildAndRegister()

// Naphtha separation (light -> isomerate, heavy -> reformate)
DT.recipeBuilder()
    .fluidInputs(fluid('debutanized_naphtha') * 10000)
    .fluidOutputs(fluid('sulfuric_heavy_naphtha') * )
    .fluidOutputs(fluid('sulfuric_light_naphtha') * )
    .duration(400)
    .buildAndRegister()

// Depropanization
DT.recipeBuilder()
    .fluidInputs(fluid('sulfuric_lpg') * 1000)
    .fluidOutputs(fluid('sulfuric_butane_lpg') * 600)
    .fluidOutputs(fluid('propane_lpg') * 400)
    .duration(40)
    .buildAndRegister()
    
// Deethanization
DT.recipeBuilder()
    .fluidInputs(fluid('propane_lpg') * 1000)
    .fluidOutputs(fluid('propane') * 900)
    .fluidOutputs(fluid('ethane') * 100)
    .duration(40)
    .buildAndRegister()

// Amine desulfuization
BCR.recipeBuilder()
    .fluidInputs(fluid('sulfuric_butane_lpg') * 3000)
    .fluidInputs(fluid('ethanolamine_mix') * 1000)
    .fluidOutputs(fluid('butane_lpg') * 1000)
    .fluidOutputs(fluid('rich_amine') * 1000)
    .duration(40)
    .EUt(120)
    .buildAndRegister()

// iC4-nC4 separation
DT.recipeBuilder()
    .fluidInputs(fluid('butane_lpg') * 1000)
    .fluidOutputs(fluid('butane') * 800)
    .fluidOutputs(fluid('isobutane') * 200)
    .duration(40)
    .buildAndRegister()