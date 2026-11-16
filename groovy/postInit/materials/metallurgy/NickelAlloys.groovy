import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Nichrome

INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('nickel') * 1008)
    .inputs(metaitem('ingotChrome') * 2)
    .fluidOutputs(fluid('nichrome') * 1296)
    .EUt(VA[MV])
    .material("Alumina")
    .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
    .inputs(metaitem('ingotNickel')  * 7)
    .inputs(metaitem('ingotChrome') * 2)
    .fluidOutputs(fluid('nichrome') * 1296)
    .EUt(VA[MV])
    .material("Alumina")
    .buildAndRegister()

// Monel 400

INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('nickel') * 2268)
    .inputs(ore('dustCopper') * 8)
    .inputs(ore('dustTinyIron') * 3)
    .inputs(ore('dustTinyManganese') * 2)
    .inputs(ore('dustSmallSilicon') * 2)
    .fluidOutputs(fluid('monel_400') * 3600)
    .EUt(VA[LV])
    .duration(960)
    .buildAndRegister()
// Monel K-500

INDUCTION_FURNACE.recipeBuilder()
    .circuitMeta(2)
    .fluidInputs(fluid('nickel') * 3312)
    .inputs(metaitem('dustManganese') * 2)
    .inputs(metaitem('dustCopper') * 10)
    .inputs(metaitem('dustAluminium') * 4)
    .inputs(metaitem('dustTitanium'))
    .fluidOutputs(fluid('monel_500') * 5760)
    .EUt(VA[MV])
    .material("Alumina")
    .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
    .circuitMeta(2)
    .inputs(metaitem('dustNickel') * 23)
    .inputs(metaitem('dustManganese') * 2)
    .inputs(metaitem('dustCopper') * 10)
    .inputs(metaitem('dustAluminium') * 4)
    .inputs(metaitem('dustTitanium'))
    .fluidOutputs(fluid('monel_500') * 5760)
    .EUt(VA[MV])
    .material("Alumina")
    .buildAndRegister()