import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

ROASTER.recipeBuilder()
        .inputs(ore('dustGypsum') * 8)
        .outputs(metaitem('dustCalciumSulfate') * 6)
        .fluidOutputs(fluid('dense_steam') * 2000)
        .EUt(VA[LV])
        .duration(160)
        .buildAndRegister()

// 56CaSO4(H2O)2 + 40H2O -> 56CaSO4 + 152H2O
// 7, 5, 7, 19
ROASTER.recipeBuilder()
        .fluidInputs(fluid('waste_gypsum') * 19000)
        .outputs(metaitem('dustCalciumSulfate') * 42)
        .fluidOutputs(fluid('dense_steam') * 19000)
        .EUt(VA[MV])
        .duration(1600)
        .buildAndRegister()

ROASTER.recipeBuilder()
        .circuitMeta(1)
        .inputs(ore('dustCalciumSulfate') * 6)
        .outputs(metaitem('dustQuicklime') * 2)
        .fluidOutputs(fluid('sulfur_trioxide') * 1000)
        .EUt(VA[LV])
        .duration(160)
        .buildAndRegister()

VACUUM_DT.recipeBuilder()
        .inputs(ore('dustCalcium'))
        .outputs(metaitem('dustHighPurityCalcium'))
        .EUt(VA[LV])
        .duration(20)
        .buildAndRegister()

ELECTROLYZER.recipeBuilder()
        .notConsumable(metaitem('graphite_electrode'))
        .notConsumable(metaitem('stickSteel'))
        .fluidInputs(fluid('calcium_chloride') * 432)
        .fluidOutputs(fluid('chlorine') * 2000)
        .outputs(metaitem('dustCalcium'))
        .EUt(VA[LV])
        .duration(300)
        .buildAndRegister()
