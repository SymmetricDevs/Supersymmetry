import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// 97.6% Al 1.1% Mg 0.64% Si 0.36% Cu 0.30% Cr
INDUCTION_FURNACE.recipeBuilder()
        .fluidInputs(fluid('aluminium') * 10144)
        .inputs(ore('dustTinyMagnesium') * 8)
        .inputs(ore('dustTinySilicon') * 4)
        .inputs(ore('dustTinyCopper') * 1)
        .inputs(ore('dustTinyChrome') * 1)
        .fluidOutputs(fluid('aluminium_alloy_6061') * 10368)
        .EUt(VA[MV])
        .duration(9600)
        .buildAndRegister()

// 90.6% Al 5.5% Zn 2.4% Mg 1.3% Cu 0.26% Cr
INDUCTION_FURNACE.recipeBuilder()
        .fluidInputs(fluid('aluminium') * 10848)
        .inputs(ore('dustTinyZinc') * 17)
        .inputs(ore('dustTinyMagnesium') * 20)
        .inputs(ore('dustTinyCopper') * 4)
        .inputs(ore('dustTinyChrome') * 1)
        .fluidOutputs(fluid('aluminium_alloy_7075') * 11520)
        .EUt(VA[MV])
        .duration(9600)
        .buildAndRegister()


