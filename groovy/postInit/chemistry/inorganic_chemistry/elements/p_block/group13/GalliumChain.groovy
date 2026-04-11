import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*
import gregtech.api.recipes.chance.output.ChancedOutputLogic;

//FROM BAUXITE
ELECTROLYZER.recipeBuilder()
.fluidInputs(fluid('impure_soda_ash_solution') * 1000)
.notConsumable(ore('stickSteel'))
.notConsumable(metaitem('graphite_electrode'))
.fluidOutputs(fluid('soda_ash_solution') * 1000)
.chancedOutput(metaitem('dustGallium'), 500, 0)
.duration(300)
.EUt(VA[LV])
.buildAndRegister()

ELECTROLYZER.recipeBuilder()
.fluidInputs(fluid('impure_sodium_hydroxide_solution') * 1000)
.notConsumable(ore('stickSteel'))
.notConsumable(metaitem('graphite_electrode'))
.fluidOutputs(fluid('sodium_hydroxide_solution') * 1000)
.chancedOutput(metaitem('dustGallium'), 500, 0)
.duration(300)
.EUt(VA[LV])
.buildAndRegister()

//FROM SPHALERITE (WILL ADD LATER)

//FROM COAL FLY ASH (WILL ADD LATER)

//HIGH PURITY GALLIUM
    ROASTER.recipeBuilder()
    .inputs(ore('dustGallium'))
    .fluidInputs(fluid('chlorine') * 3500)
    .outputs(metaitem('dustCrudeGalliumTrichloride') * 3)
    .duration(120)
    .EUt(VA[LV])
    .buildAndRegister()

//CHLORIDE ROUTE (75%)
DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('crude_gallium_trichloride') * 432)
    .fluidOutputs(fluid('gallium_trichloride') * 750)
    .duration(120)
    .EUt(VA[LV])
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('crude_gallium_trichloride') * 432)
    .fluidOutputs(fluid('gallium_trichloride') * 1000)
    .duration(120)
    .EUt(VA[MV])
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('gallium_trichloride') * 1000)
    .fluidInputs(fluid('hydrogen') * 3000)
    .outputs(metaitem('dustHighPurityGallium'))
    .fluidOutputs(fluid('hydrogen_chloride') * 3000)
    .duration(120)
    .EUt(VA[MV])
    .buildAndRegister()

ELECTROLYZER.recipeBuilder()
    .notConsumable(metaitem('stickIron'))
    .notConsumable(metaitem('graphite_electrode'))
    .notConsumable(fluid('water') * 1000)
    .inputs(ore('dustMercuryIiChloride') * 3)
    .fluidOutputs(fluid('chlorine') * 2000)
    .fluidOutputs(fluid('mercury') * 1000)
    .duration(120)
    .EUt(VA[MV])
    .buildAndRegister()

// Purification via vacuum

VACUUM_DT.recipeBuilder()
    .inputs(ore('dustGallium'))
    .chancedOutput(metaitem('dustGallium'), 4000, 0)
    .chancedOutput(metaitem('dustHighPurityGallium'), 10000, 0)
    .chancedOutputLogic(ChancedOutputLogic.XOR)
    .duration(500)
    .EUt(VHA[HV])
    .buildAndRegister()
