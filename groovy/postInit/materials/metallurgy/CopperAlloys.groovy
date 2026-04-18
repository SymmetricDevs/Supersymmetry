import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Beryllium copper

INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('nitrogen') * 1000)
    .fluidInputs(fluid('molten.copper') * 720)
    .inputs(ore('dustBeryllium'))
    .fluidOutputs(fluid('beryllium_copper') * 864)
    .EUt(VA[MV])
    .duration(10)
    .buildAndRegister()

// Phosphorized copper for copper electroplating anodes

TUBE_FURNACE.recipeBuilder()
    .notConsumable(fluid('argon') * 100)
    .inputs(ore('dustHighPurityCopper') * 3)
    .inputs(ore('dustPhosphorus'))
    .outputs(metaitem('dustCopperIPhosphide') * 4)
    .EUt(VA[MV])
    .duration(80)
    .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
    .notConsumable(fluid('argon') * 1000)
    .inputs(ore('dustTinyCopperIPhosphide'))
    .inputs(ore('dustHighPurityCopper') * 64)
    .fluidOutputs(fluid('phosphorized_copper') * 9216)
    .EUt(VA[MV])
    .duration(120)
    .buildAndRegister()

