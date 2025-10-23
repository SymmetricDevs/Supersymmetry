import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

SOLIDIFIER.recipeBuilder()
    .inputs(ore('wireFineSteel') * 8)
    .fluidInputs(fluid('zinc') * 18)
    .outputs(metaitem('wireFineGalvanizedSteel') * 8)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()
