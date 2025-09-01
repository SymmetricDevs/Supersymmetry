import globals.Globals

POLYMERIZATION = recipemap('polymerization_tank')
DISTILLERY = recipemap('distillery')

// Polyphenylene Sulfide

POLYMERIZATION.recipeBuilder()
    .fluidInputs(fluid('n_methyl_two_pyrrolidone') * 1000)
    .inputs(ore('dustDichlorobenzene') * 12)
    .inputs(ore('dustSodiumSulfide') * 3)
    .fluidOutputs(fluid('salty_n_methyl_two_pyrrolidone') * 1000)
    .outputs(metaitem('dustPolyphenyleneSulfide') * 11)
    .duration(600)
    .EUt(240)
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('salty_n_methyl_two_pyrrolidone') * 1000)
    .fluidOutputs(fluid('n_methyl_two_pyrrolidone') * 1000)
    .outputs(metaitem('dustSalt') * 4)
    .duration(400)
    .EUt(120)
    .buildAndRegister()