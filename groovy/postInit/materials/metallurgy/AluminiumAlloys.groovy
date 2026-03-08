import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

INDUCTION_FURNACE.recipeBuilder()
        .inputs(metaitem('dustAluminium'))
        .fluidOutputs(fluid('molten.aluminium') * 144)
        .EUt(VA[MV])
        .duration(10)
        .buildAndRegister()

// 97.6% Al 1.1% Mg 0.64% Si 0.36% Cu 0.30% Cr
INDUCTION_FURNACE.recipeBuilder()
        .fluidInputs(fluid('molten.aluminium') * 10144)
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
        .fluidInputs(fluid('molten.aluminium') * 10848)
        .inputs(ore('dustTinyZinc') * 17)
        .inputs(ore('dustTinyMagnesium') * 20)
        .inputs(ore('dustTinyCopper') * 4)
        .inputs(ore('dustTinyChrome') * 1)
        .fluidOutputs(fluid('aluminium_alloy_7075') * 11520)
        .EUt(VA[MV])
        .duration(9600)
        .buildAndRegister()

// 92.8 % Al 6 % Cu 0.3 % Fe 0.3 % Mn 0.2 % Si 0.2 % Zn 0.1 % V 0.1 % Ti
INDUCTION_FURNACE.recipeBuilder()
        .fluidInputs(fluid('molten.aluminium') * 14832)
        .inputs(ore('dustTinyCopper') * 60)
        .inputs(ore('dustTinyIron') * 3)
        .inputs(ore('dustTinyManganese') * 3)
        .inputs(ore('dustTinySilicon') * 2)
        .inputs(ore('dustTinyZinc') * 2)
        .inputs(ore('dustTinyVanadium') * 1)
        .inputs(ore('dustTinyTitanium') * 1)
        .fluidOutputs(fluid('aluminium_alloy_2219') * 15984)