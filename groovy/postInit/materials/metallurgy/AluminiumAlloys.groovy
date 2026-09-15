import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// 6061 Aluminium Alloy
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('aluminium') * 10144)
    .inputs(ore('dustTinyMagnesium') * 8)
    .inputs(ore('dustTinySilicon') * 4)
    .inputs(ore('dustTinyCopper') * 1)
    .inputs(ore('dustTinyChrome') * 1)
    .fluidOutputs(fluid('aluminium_alloy_6061') * 10368)
    .EUt(VA[MV])
    .buildAndRegister()

// 7075 Aluminium Alloy
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('aluminium') * 10848)
    .inputs(ore('dustTinyZinc') * 17)
    .inputs(ore('dustTinyMagnesium') * 20)
    .inputs(ore('dustTinyCopper') * 4)
    .inputs(ore('dustTinyChrome') * 1)
    .fluidOutputs(fluid('aluminium_alloy_7075') * 11520)
    .EUt(VA[MV])
    .buildAndRegister()

// Magnalium
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('aluminium') * 2736)
    .inputs(ore('ingotMagnesium'))
    .fluidOutputs(fluid('magnalium') * 2880)
    .EUt(VA[LV])
    .buildAndRegister();


