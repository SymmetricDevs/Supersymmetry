import globals.Globals
import static globals.CarbonGlobals.*

ROASTER = recipemap('roaster')

ROASTER.recipeBuilder()
    .inputs(ore('dustCopper'))
    .fluidInputs(fluid('air') * 5000)
    .outputs(metaitem('dustCupricOxide') * 2)
    .fluidOutputs(fluid('nitrogen') * 7454)
    .EUt(30)
    .duration(160)
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustZinc'))
    .fluidInputs(fluid('air') * 5000)
    .outputs(metaitem('dustZincOxide') * 2)
    .fluidOutputs(fluid('nitrogen') * 7454)
    .EUt(30)
    .duration(160)
    .buildAndRegister()
