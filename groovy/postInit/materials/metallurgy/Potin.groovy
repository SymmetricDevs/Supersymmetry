import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

ALLOY_SMELTER.recipeBuilder()
    .inputs(ore('dustBronze') * 8)
    .inputs(ore('dustLead') * 1)
    .outputs(metaitem('ingotPotin') * 9)
    .duration(450)
    .EUt(VA[LV])
    .buildAndRegister()

ALLOY_SMELTER.recipeBuilder()
    .inputs(ore('ingotBronze') * 8)
    .inputs(ore('dustLead') * 1)
    .outputs(metaitem('ingotPotin') * 9)
    .duration(450)
    .EUt(VA[LV])
    .buildAndRegister()

ALLOY_SMELTER.recipeBuilder()
    .inputs(ore('dustBronze') * 8)
    .inputs(ore('ingotLead') * 1)
    .outputs(metaitem('ingotPotin') * 9)
    .duration(450)
    .EUt(VA[LV])
    .buildAndRegister()

ALLOY_SMELTER.recipeBuilder()
    .inputs(ore('ingotBronze') * 8)
    .inputs(ore('ingotLead') * 1)
    .outputs(metaitem('ingotPotin') * 9)
    .duration(450)
    .EUt(VA[LV])
    .buildAndRegister()
