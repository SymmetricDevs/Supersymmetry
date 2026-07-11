import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Polyphenylene Sulfide

POLYMERIZATION_TANK.recipeBuilder()
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
    .EUt(VA[MV])
    .buildAndRegister()
