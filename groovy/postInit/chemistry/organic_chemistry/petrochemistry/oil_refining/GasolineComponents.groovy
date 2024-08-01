import petrochemistry.Petrochemistry

REACTION_FURNACE = recipemap('reaction_furnace')
FBR = recipemap('fixed_bed_reactor')

/* Isomerization
    REACTION_FURNACE.recipeBuilder()
        .fluidInputs(fluid('light_naphtha') * 1000)
        .fluidInputs(fluid('hydrogen'))
        .fluidOutputs(fluid('isomerization_mixture'))
        .duration(100)
        .buildAndRegister()

    FBR.recipeBuilder()
        .notConsumable(ore('catalystBedChloridedAlumina'))
        .fluidInputs(fluid('isomerization_mixture'))
        .fluidOutputs(fluid('isomerate'))
        .fluidOutputs(fluid('hydrogen'))
        .duration(200)
        .buildAndRegister()

    FBR.recipeBuilder()
        .notConsumable(ore('catalystBedSulfatedMetalOxide'))
        .fluidInputs(fluid('isomerization_mixture'))
        .fluidOutputs(fluid('isomerate'))
        .fluidOutputs(fluid('hydrogen'))
        .duration(100)
        .buildAndRegister()
*/