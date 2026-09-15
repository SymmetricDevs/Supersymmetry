import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Bronze
ALLOY_SMELTER.recipeBuilder()
    .inputs(metaitem('ingotCopper') * 14)
    .inputs(metaitem('ingotTin'))
    .outputs(metaitem('ingotBronze') * 15)
    .duration(800)
    .EUt(VA[LV])
    .buildAndRegister()

RESISTANCE_FURNACE.recipeBuilder()
    .fluidInputs(fluid('copper') * 2016)
    .inputs(metaitem('ingotTin'))
    .notConsumable(metaitem('susy:clay_graphite_crucible'))
    .temperature(505)
    .fluidOutputs(fluid('bronze') * 2160)
    .EUt(VA[LV])
    .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('copper') * 2016)
    .inputs(metaitem('ingotTin'))
    .fluidOutputs(fluid('bronze') * 2160)
    .EUt(VA[LV])
    .buildAndRegister()

// Brass
ALLOY_SMELTER.recipeBuilder()
    .inputs(metaitem('ingotCopper') * 5)
    .inputs(metaitem('ingotZinc') * 2)
    .outputs(metaitem('ingotBrass') * 7)
    .duration(400)
    .EUt(VA[LV])
    .buildAndRegister()

RESISTANCE_FURNACE.recipeBuilder()
    .fluidInputs(fluid('copper') * 720)
    .inputs(metaitem('ingotZinc') * 2)
    .notConsumable(metaitem('susy:clay_graphite_crucible'))
    .temperature(693)
    .fluidOutputs(fluid('brass') * 1008)
    .EUt(VA[LV])
    .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('copper') * 720)
    .inputs(metaitem('ingotZinc') * 2)
    .fluidOutputs(fluid('brass') * 1008)
    .EUt(VA[LV])
    .buildAndRegister()

// Cupronickel
ALLOY_SMELTER.recipeBuilder()
    .inputs(metaitem('ingotCopper') * 8)
    .inputs(metaitem('ingotNickel'))
    .outputs(metaitem('ingotCupronickel') * 9)
    .duration(400)
    .EUt(VA[LV])
    .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('copper') * 1152)
    .inputs(metaitem('ingotNickel'))
    .fluidOutputs(fluid('cupronickel') * 1296)
    .EUt(VA[LV])
    .buildAndRegister()




