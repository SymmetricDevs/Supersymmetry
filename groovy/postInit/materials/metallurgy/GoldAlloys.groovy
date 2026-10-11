import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('gold') * 144)
    .fluidInputs(fluid('silver') * 144)
    .fluidOutputs(fluid('electrum') * 288)
    .EUt(VA[MV])
    .duration(10)
    .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('nitrogen') * 1000)
    .fluidInputs(fluid('gold') * 2736)
    .inputs(ore('dustAntimony'))
    .fluidOutputs(fluid('gold_antimony') * 2880)
    .EUt(VA[MV])
    .duration(10)
    .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
    .notConsumable(fluid('argon') * 1000)
    .fluidInputs(fluid('gold') * 2736)
    .inputs(ore('dustAntimony'))
    .fluidOutputs(fluid('gold_antimony') * 2880)
    .EUt(VA[MV])
    .duration(10)
    .buildAndRegister()