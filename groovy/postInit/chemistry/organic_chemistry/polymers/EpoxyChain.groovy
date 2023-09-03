import static globals.Globals.*

ION_EXCHANGE = recipemap('ion_exchange_column')
FLUID_EXTRACTOR = recipemap('fluid_extractor')

//BPA

ION_EXCHANGE.recipeBuilder()
    .fluidInputs(fluid('phenol') * 2000)
    .fluidInputs(fluid('acetone') * 1000)
    .notConsumable(metaitem('beads.ag_fifty_w_x_eight'))
    .fluidOutputs(fluid('water') * 1000)
    .outputs(metaitem('dustBisphenolA'))
    .EUt(480)
    .duration(100)
    .buildAndRegister()

FLUID_EXTRACTOR.recipeBuilder()
    .inputs(ore('dustBisphenolA'))
    .fluidOutputs(fluid('bisphenol_a') * 1000)
    .EUt(30)
    .duration(100)
    .buildAndRegister()

    