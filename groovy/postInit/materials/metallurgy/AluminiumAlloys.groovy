import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// 6061 Aluminium Alloy
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('aluminium') * 10144)
    .inputs(metaitem('dustTinyMagnesium') * 8)
    .inputs(metaitem('dustTinySilicon') * 4)
    .inputs(metaitem('dustTinyCopper') * 1)
    .inputs(metaitem('dustTinyChrome') * 1)
    .fluidOutputs(fluid('aluminium_alloy_6061') * 10368)
    .material("Alumina")
    .EUt(VA[MV])
    .buildAndRegister()

// 7075 Aluminium Alloy
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('aluminium') * 10848)
    .inputs(metaitem('dustTinyZinc') * 17)
    .inputs(metaitem('dustTinyMagnesium') * 20)
    .inputs(metaitem('dustTinyCopper') * 4)
    .inputs(metaitem('dustTinyChrome') * 1)
    .fluidOutputs(fluid('aluminium_alloy_7075') * 11520)
    .material("Alumina")
    .EUt(VA[MV])
    .buildAndRegister()

// Magnalium
INDUCTION_FURNACE.recipeBuilder()
    .inputs(metaitem('ingotAluminium') * 19)
    .inputs(metaitem('ingotMagnesium'))
    .fluidOutputs(fluid('magnalium') * 2880)
    .material("Alumina")
    .EUt(VA[LV])
    .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('aluminium') * 2736)
    .inputs(metaitem('ingotMagnesium'))
    .fluidOutputs(fluid('magnalium') * 2880)
    .material("Alumina")
    .EUt(VA[LV])
    .buildAndRegister()
    .EUt(VA[LV])
    .buildAndRegister();


