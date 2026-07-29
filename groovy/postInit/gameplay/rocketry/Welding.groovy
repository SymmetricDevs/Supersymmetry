import static gregtech.api.GTValues.*
import static prePostInit.Recipemaps.*

MIXER.recipeBuilder()
    .inputs(ore('dustTungstenTrioxide') * 44)
    .inputs(ore('dustTinyThoriumDioxide') * 2)
    .inputs(ore('dustRheniumHeptoxide') * 1)
    .outputs(metaitem('dustThoriatedTungstenMixture') * 45)
    .EUt(VA[EV])
    .duration(20)
    .buildAndRegister()


HOT_ISOSTATIC_PRESS.recipeBuilder()
    .notConsumable(metaitem('shape.mold.rod'))
    .inputs(ore('dustSmallThoriatedTungstenMixture') * 2)
    .outputs(metaitem('stickThoriatedTungsten'))
    .EUt(VA[EV])
    .duration(80)
    .buildAndRegister()

ELECTROLYTIC_CELL.recipeBuilder() // electropolishing
    .notConsumable(ore('stickTungsten'))
    .inputs(ore('stickThoriatedTungsten'))
    .fluidInputs(fluid('diluted_sodium_hydroxide_solution') * 1000)
    .fluidOutputs(fluid('wastewater') * 1000) // contains trace WO3 et al, and I'm not bothering with figuring this out
    .outputs(item('susy:meta_item', 12))
    .EUt(VA[MV])
    .duration(60)
    .buildAndRegister()

