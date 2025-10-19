import static prePostInit.Recipemaps.*
import globals.Carbons
import static gregtech.api.GTValues.*

ROASTER.recipeBuilder()
    .inputs(ore('dustBismuthinite') * 1)
    .fluidInputs(fluid('oxygen') * 9000)
    .outputs(metaitem('dustBismuthIiiOxide') * 5)
    .fluidOutputs(fluid('sulfur_dioxide') * 3000)
    .EUt(VA[MV])
    .duration(120)
    .buildAndRegister()

for (highPurityCombustible in Carbons.highPurityCombustibles()) {
    ROASTER.recipeBuilder()
        .inputs(ore('dustBismuthIiiOxide') * 5)
        .inputs(ore(highPurityCombustible.name) * highPurityCombustible.equivalent(3))
        .outputs(metaitem('dustBismuth') * 2)
        .fluidOutputs(fluid('carbon_monoxide') * 3000)
        .EUt(VA[MV])
        .duration(120)
        .buildAndRegister()
}

// Bismuth nitrate

BR.recipeBuilder()
    .inputs(ore('dustBismuthIiiOxide') * 5)
    .fluidInputs(fluid('nitric_acid') * 6000)
    .fluidOutputs(fluid('bismuth_iii_nitrate_solution') * 3000)
    .EUt(VA[MV])
    .duration(120)
    .buildAndRegister()
