import static globals.Globals.*

ROASTER = recipemap('roaster')
BR = recipemap('batch_reactor')
DISTILLERY = recipemap('distillery')
MIXER = recipemap('mixer')
CRYSTALLIZER = recipemap('crystallizer')
EBF = recipemap('electric_blast_furnace')

ROASTER.recipeBuilder()
        .inputs(ore('dustBismuthinite') * 5)
        .fluidInputs(fluid('oxygen') * 9000)
        .outputs(metaitem('dustBismuthIiiOxide') * 5)
        .fluidOutputs(fluid('sulfur_dioxide') * 3000)
        .EUt(120)
        .duration(120)
        .buildAndRegister()

for (highPurityCombustible in Globals.highPurityCombustibles) {
        ROASTER.recipeBuiler()
        .inputs(metaitem('dustBismuthIiiOxide') * 5)
        .inputs(ore(highPurityCombustible.name) * 3)
        .outputs(metaitem('dustBismuth') * 2)
        .fluidOutputs(fluid('carbon_monoxide') * 3000)
        .EUt(120)
        .duration(120)
        .buildAndRegister()
}