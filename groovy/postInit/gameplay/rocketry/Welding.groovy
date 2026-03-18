import static gregtech.api.GTValues.*
import static prePostInit.Recipemaps.*

MIXER.recipeBuilder()
    .inputs(ore('dustTungsten') * 11)
    .inputs(ore('dustTinyThoriumDioxide') * 2)
    .inputs(ore('dustTinyRhenium'))
    .outputs(metaitem('dustThoriatedTungstenMixture') * 12)
    .EUt(VA[EV])
    .duration(20)
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .inputs(ore('dustThoriatedTungstenMixture') * 2)
    .fluidInputs(fluid('hydrogen') * 16000)
    .outputs(metaitem('dustThoriatedTungsten') * 2)
    .EUt(VA[EV])
    .duration(80)
    .buildAndRegister()

HOT_ISOSTATIC_PRESS.recipeBuilder()
    .notConsumable(metaitem('shape.mold.ingot'))
    .inputs(ore('dustThoriatedTungsten'))
    .outputs(metaitem('ingotThoriatedTungsten'))
    .EUt(VA[EV])
    .duration(15)
    .buildAndRegister()

SINTERING_OVEN.recipeBuilder() // represents DC sintering and rotary forging
    .notConsumable(metaitem('shape.mold.rod'))
    .inputs(ore('ingotThoriatedTungsten'))
    .outputs(metaitem('stickThoriatedTungsten'))
    .EUt(VA[EV])
    .duration(50)
    .buildAndRegister()

ELECTROLYZER.recipeBuilder() // electroplating
    .notConsumable(ore('stickStainlessSteel'))
    .inputs(ore('stickThoriatedTungsten'))
    .fluidInputs(fluid('diluted_sodium_hydroxide_solution') * 1000)
    .outputs(item('susy:meta_item', 12))
    .EUt(VA[LV])
    .duration(10)
    .buildAndRegister()

