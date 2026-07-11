import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

ROASTER.recipeBuilder()
    .inputs(ore('dustSamariumHydroxide') * 14)
    .outputs(metaitem('dustSamariumOxide') * 5)
    .fluidOutputs(fluid('dense_steam') * 3000)
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .notConsumable(metaitem('crucible.tantalum'))
    .inputs(ore('dustSamariumOxide') * 5)
    .inputs(ore('dustLanthanum') * 2)
    .outputs(metaitem('dustSamarium') * 2)
    .outputs(metaitem('dustLanthanumOxide') * 5)
    .duration(200)
    .EUt(VA[HV])
    .buildAndRegister()
