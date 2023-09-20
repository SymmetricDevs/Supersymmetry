import static globals.Globals.*

BR = recipemap('batch_reactor')
ROASTER = recipemap('roaster')

BR.recipeBuilder()
    .fluidInputs(fluid('antimony_dross') * 720)
    .fluidInputs(fluid('chlorine') * 6000)
    .outputs(metaitem('dustAntimony') * 2)
    .outputs(metaitem('dustMagnesiumChloride') * 6)
    .outputs(metaitem('dustCalciumChloride') * 3)
    .EUt(Globals.voltAmps[2])
    .duration(200)
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustAntimonyIiiSulfide') * 5)
    .inputs(ore('dustCarbon') * 3)
    .fluidInputs(fluid('oxygen') * 6000)
    .outputs(metaitem('dustAntimony') * 2)
    .fluidOutputs(fluid('carbon_monoxide') * 3000)
    .fluidOutputs(fluid('sulfur_dioxide') * 3000)
    .EUt(Globals.voltAmps[2])
    .duration(200)
    .buildAndRegister()