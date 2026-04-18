import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Induction melting

INDUCTION_FURNACE.recipeBuilder()
    .inputs(ore('dustSteel'))
    .fluidOutputs(fluid('molten.steel') * 144)
    .EUt(VA[MV])
    .duration(20)
    .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
    .inputs(ore('dustIron'))
    .fluidOutputs(fluid('molten.iron') * 144)
    .EUt(VA[MV])
    .duration(20)
    .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
    .inputs(ore('dustCobalt'))
    .fluidOutputs(fluid('molten.cobalt') * 144)
    .EUt(VA[MV])
    .duration(20)
    .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
    .inputs(metaitem('dustAluminium'))
    .fluidOutputs(fluid('molten.aluminium') * 144)
    .EUt(VA[MV])
    .duration(10)
    .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
    .inputs(metaitem('dustCopper'))
    .fluidOutputs(fluid('molten.copper') * 144)
    .EUt(VA[MV])
    .duration(10)
    .buildAndRegister()