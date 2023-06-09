ROASTER = recipemap('roaster')
EBF = recipemap('electric_blast_furnace')
BR = recipemap('batch_reactor')
DISTILLERY = recipemap('distillery')

//TODO: ADD ELECTROLYSIS OF MOLTEN SODIUM HYDROXIDE

ROASTER.recipeBuilder()
        .inputs(metaitem('dustTrona') * 28)
        .outputs(metaitem('dustSodaAsh') * 18)
        .fluidOutputs(fluid('steam') * 5000)
        .fluidOutputs(fluid('carbon_dioxide') * 1000)
        .EUt(30)
        .duration(120)
        .buildAndRegister()

ROASTER.recipeBuilder()
        .inputs(metaitem('dustSodaAsh') * 6)
        .inputs(metaitem('dustCarbon') * 2)
        .outputs(metaitem('dustSodium') * 2)
        .fluidOutputs(fluid('carbon_monoxide') * 3000)
        .EUt(30)
        .duration(120)
        .buildAndRegister()