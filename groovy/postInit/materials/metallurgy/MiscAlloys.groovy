 import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Red Alloy
RESISTANCE_FURNACE.recipeBuilder()
         .inputs(metaitem('ingotCopper') * 1)
         .inputs(item('minecraft:redstone') * 5)
         .notConsumable(metaitem('susy:clay_graphite_crucible'))
         .fluidOutputs(fluid('red_alloy') * 144)
         .EUt(VA[LV])
         .duration(168)
         .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
        .inputs(metaitem('ingotCopper') * 1)
        .inputs(item('minecraft:redstone') * 5)
        .fluidOutputs(fluid('red_alloy') * 144)
        .EUt(VA[LV])
        .duration(42)
        .buildAndRegister()

// Invar
INDUCTION_FURNACE.recipeBuilder()
        .fluidInputs(fluid('iron') * 720) // TO DO: replace
        .inputs(metaitem('ingotNickel') * 3)
        .fluidOutputs(fluid('invar') * 1152)
        .EUt(VA[LV])
        .duration(60)
        .buildAndRegister()

// Nichrome
INDUCTION_FURNACE.recipeBuilder()
        .fluidInputs(fluid('nickel') * 1008)
        .inputs(metaitem('ingotChrome') * 2)
        .fluidOutputs(fluid('nichrome') * 1296)
        .EUt(VA[LV])
        .duration(60)
        .buildAndRegister()

// Kanthal
INDUCTION_FURNACE.recipeBuilder()
        .fluidInputs(fluid('iron') * 4032) // TO DO: replace
        .inputs(metaitem('dustFerrochromium') * 3)
        .inputs(metaitem('ingotAluminium') * 5)
        .fluidOutputs(fluid('kanthal') * 5184)
        .EUt(VA[MV])
        .duration(60)
        .buildAndRegister()

 // Kovar
ALLOY_SMELTER.recipeBuilder()
        .inputs(ore('ingotInvar') * 3)
        .inputs(ore('ingotCobaltMatte') * 1)
        .outputs(metaitem('ingotKovar') * 2)
        .duration(400)
        .EUt(VA[LV])
        .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
        .fluidInputs(fluid('iron') * 288)
        .inputs(metaitem('ingotNickel'))
        .inputs(metaitem('ingotCobalt'))
        .fluidOutputs(fluid('kovar') * 576)
        .EUt(VA[LV])
        .duration(60)
        .buildAndRegister()
