import globals.Globals

BR = recipemap('batch_reactor')
REACTION_FURNACE = recipemap('reaction_furnace')
CENTRIFUGE = recipemap('centrifuge')
DISTILLERY = recipemap('distillery')

// Tier 1

// PrO2 + 4HF -> Pr4+ + 2H2O + 4F-
// Pr4+ + 1/2H2O -> Pr3+ + H+ + 1/2O
// PrO2 + 3HF -> PrF3 + 3/2H2O + 1/2O

BR.recipeBuilder()
    .inputs(ore('dustPraseodymiumIvOxide') * 6)
    .fluidInputs(fluid('hydrofluoric_acid') * 6000)
    .outputs(metaitem('dustPraseodymiumIiiFluoride') * 8)
    .fluidOutputs(fluid('water') * 3000)
    .fluidOutputs(fluid('oxygen') * 1000)
    .duration(80)
    .EUt(120)
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .notConsumable(metaitem('crucible.tantalum'))
    .inputs(ore('dustPraseodymiumIiiFluoride') * 8)
    .inputs(ore('dustCalcium') * 3)
    .fluidInputs(fluid('argon') * 50)
    .outputs(metaitem('dustPraseodymium') * 2)
    .outputs(metaitem('dustFluorite') * 9)
    .duration(200)
    .EUt(960)
    .buildAndRegister()

// Tier 2
CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('distilled_water') * 1000)
    .fluidInputs(fluid('praseodymium_extract') * 10000)
    .fluidOutputs(fluid('praseodymium_iii_nitrate_solution') * 1000)
    .fluidOutputs(fluid('aliquat_336_extraction_mixture') * 10000)
    .duration(80)
    .EUt(120)
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('praseodymium_iii_nitrate_solution') * 1000)
    .outputs(metaitem('dustPraseodymiumIiiNitrate') * 13)
    .fluidOutputs(fluid('water') * 1000)
    .duration(20)
    .EUt(30)
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(metaitem('dustPraseodymiumIiiNitrate') * 13)
    .fluidInputs(fluid('hydrofluoric_acid') * 3000)
    .outputs(metaitem('dustPraseodymiumIiiFluoride') * 4)
    .fluidOutputs(fluid('diluted_nitric_acid') * 6000)
    .duration(80)
    .EUt(30)
    .buildAndRegister()