import static globals.Globals.*

ROASTER = recipemap('roaster')

def combustibles = Globals.combustibles

for (combustible in combustibles) {
    ROASTER.recipeBuilder()
        .inputs(ore('dustCobaltOxide') * 2)
        .inputs(ore(combustible.name) * (combustible.amount_required))
        .outputs(metaitem('dustCobalt'))
        .fluidOutputs(fluid('carbon_monoxide') * 1000)
        .duration(120)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()
}