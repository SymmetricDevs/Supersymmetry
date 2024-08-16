import petrochemistry.Petrochemistry

REACTION_FURNACE = recipemap('reaction_furnace')
FBR = recipemap('fixed_bed_reactor')
REFORMER = recipemap('catalytic_reformer_recipes')
PHASE_SEPARATOR = recipemap('phase_separator')

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

/* Alkylation
    
*/

/* Dimerization

*/

/* Reforming
    REFORMER.recipeBuilder()
        .fluidInputs(fluid('heavy_naphtha') * 1000)
        .fluidInputs(fluid('hydrogen') * 1000)
        .notConsumable(ore('catalystBedSupportedPlatinum'))
        .fluidOutputs(fluid('naphtha_reformate') * 4000)
        .duration(25)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()

    PHASE_SEPARATOR.recipeBuilder()
        .fluidInputs(fluid('naphtha_reformate') * 4000)
        .fluidOutputs(fluid('reforming_liquids') * 1000)
        .fluidOutputs(fluid('reforming_effluent') * 3000)
        .duration(25)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

    DT.recipeBuilder()
        .fluidInputs(fluid('reforming_liquids') * 1000)
        .fluidOutputs(fluid('reformate') * 600)
        .fluidOutputs(fluid('fuel_gas') * 200)
        .fluidOutputs(fluid('refinery_gas') * 200)
        .duration(400)
        .buildAndRegister()
*/