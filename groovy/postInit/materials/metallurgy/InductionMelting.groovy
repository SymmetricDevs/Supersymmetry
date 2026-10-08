import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Induction melting

INDUCTION_FURNACE.recipeBuilder()
    .inputs(ore('dustSteel'))
    .circuitMeta(32)
    .fluidOutputs(fluid('molten.steel') * 144)
    .EUt(VA[MV])
    .duration(20)
    .buildAndRegister()
