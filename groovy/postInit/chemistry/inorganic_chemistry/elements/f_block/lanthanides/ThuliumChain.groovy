import globals.Globals

REACTION_FURNACE = recipemap('reaction_furnace')

REACTION_FURNACE.recipeBuilder()
    .notConsumable(metaitem('crucible.tantalum'))
    .inputs(ore('dustThuliumFluoride') * 8)
    .inputs(ore('dustHighPurityCalcium') * 3)
    .fluidInputs(fluid('helium') * 50)
    .outputs(metaitem('dustThulium') * 2)
    .outputs(metaitem('dustFluorite') * 9)
    .duration(200)
    .EUt(Globals.voltAmps[3] * 2)
    .buildAndRegister()