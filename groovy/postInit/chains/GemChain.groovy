import static globals.Globals.*

CVD = recipemap('cvd')
CUTTER = recipemap('cutter')

CVD.recipeBuilder()
        .notConsumable(metaitem('wafer.silicon'))
        .fluidInputs(fluid('methane') * 100)
        .fluidInputs(fluid('hydrogen') * 9900)
        .outputs(metaitem('raw_diamond'))
        .duration(200)
        .EUt(120)
        .buildAndRegister()

CUTTER.recipeBuilder()
        .inputs(metaitem('raw_diamond'))
        .chancedOutput(item('minecraft:diamond'), 7500, 500)
        .chancedOutput(metaitem('gemExquisiteDiamond'), 500, 250)
        .duration(200)
        .EUt(120)
        .buildAndRegister()
