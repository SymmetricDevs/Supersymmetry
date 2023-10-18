import static globals.Globals.*

POLYMERIZATION = recipemap('polymerization_tank')

POLYMERIZATION.recipeBuilder()
    .fluidInputs(fluid('ethylene_glycol') * 1000)
    .fluidInputs(fluid('terephthalic_acid') * 2592)
    .fluidOutputs(fluid('water') * 2000)
    .EUt(Globals.voltAmps[3])
    .duration(80)
    .buildAndRegister()