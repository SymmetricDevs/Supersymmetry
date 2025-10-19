import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

ROASTER.recipeBuilder()
    .inputs(ore('dustEuropiumIiSulfate') * 12)
    .fluidInputs(fluid('oxygen') * 1000)
    .outputs(metaitem('dustEuropiumIiiOxide') * 5)
    .fluidOutputs(fluid('sulfur_trioxide') * 2000)
    .duration(80)
    .EUt(VA[MV])
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .notConsumable(metaitem('crucible.tantalum'))
    .inputs(ore('dustEuropiumIiiOxide') * 5)
    .inputs(ore('dustLanthanum') * 2)
    .outputs(metaitem('dustEuropium') * 2)
    .outputs(metaitem('dustLanthanumOxide') * 5)
    .duration(200)
    .EUt(VA[HV])
    .buildAndRegister()
