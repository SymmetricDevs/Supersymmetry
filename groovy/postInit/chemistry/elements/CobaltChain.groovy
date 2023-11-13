import static globals.Globals.*
import static globals.CarbonGlobals.*

ROASTER = recipemap('roaster')

for (combustible in CarbonGlobals.combustibles()) {
    ROASTER.recipeBuilder()
        .inputs(ore('dustCobaltOxide') * 2)
        .inputs(ore(combustible.name) * (combustible.amount))
        .outputs(metaitem('dustCobalt'))
        .fluidOutputs(fluid('carbon_monoxide') * 1000)
        .duration(120)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()
}