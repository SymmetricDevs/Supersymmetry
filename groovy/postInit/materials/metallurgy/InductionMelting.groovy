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
    .fluidOutputs(fluid('iron') * 144)
    .EUt(VA[MV])
    .duration(20)
    .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
    .inputs(ore('dustCobalt'))
    .fluidOutputs(fluid('cobalt') * 144)
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
    .fluidOutputs(fluid('copper') * 144)
    .EUt(VA[MV])
    .duration(10)
    .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
    .inputs(metaitem('dustGold'))
    .fluidOutputs(fluid('gold') * 144)
    .EUt(VA[MV])
    .duration(20)
    .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
    .inputs(metaitem('dustSilver'))
    .fluidOutputs(fluid('silver') * 144)
    .EUt(VA[MV])
    .duration(20)
    .buildAndRegister()