import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

ALLOY_SMELTER.recipeBuilder()
    .inputs(ore('dustInvar') * 3)
    .inputs(ore('ingotCobaltMatte') * 1)
    .outputs(metaitem('ingotKovar') * 2)
    .duration(400)
    .EUt(VA[LV])
    .buildAndRegister()

ALLOY_SMELTER.recipeBuilder()
    .inputs(ore('ingotInvar') * 3)
    .inputs(ore('ingotCobaltMatte') * 1)
    .outputs(metaitem('ingotKovar') * 2)
    .duration(400)
    .EUt(VA[LV])
    .buildAndRegister()
