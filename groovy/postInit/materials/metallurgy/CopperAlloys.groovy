import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Bronze
RESISTANCE_FURNACE.recipeBuilder()
        .fluidInputs(fluid('copper') * 2016)
        .inputs(metaitem('ingotTin'))
        .notConsumable(metaitem('susy:clay_graphite_crucible'))
        .temperature(1263)
        .fluidOutputs(fluid('bronze') * 2160)
        .EUt(VA[LV])
        .duration(595)
        .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
        .fluidInputs(fluid('copper') * 2016)
        .inputs(metaitem('ingotTin'))
        .fluidOutputs(fluid('bronze') * 2160)
        .EUt(VA[LV])
        .duration(147)
        .buildAndRegister()

// Brass
RESISTANCE_FURNACE.recipeBuilder()
        .fluidInputs(fluid('copper') * 720)
        .inputs(metaitem('ingotZinc') * 2)
        .notConsumable(metaitem('susy:clay_graphite_crucible'))
        .temperature(1263)
        .fluidOutputs(fluid('brass') * 1008)
        .EUt(VA[LV])
        .duration(595)
        .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
        .fluidInputs(fluid('copper') * 720)
        .inputs(metaitem('ingotZinc') * 2)
        .fluidOutputs(fluid('brass') * 1008)
        .EUt(VA[LV])
        .duration(53)
        .buildAndRegister()

// Cupronickel
INDUCTION_FURNACE.recipeBuilder()
        .fluidInputs(fluid('copper') * 1152)
        .inputs(metaitem('ingotNickel'))
        .fluidOutputs(fluid('cupronickel') * 1296)
        .EUt(VA[LV])
        .duration(84)
        .buildAndRegister()




