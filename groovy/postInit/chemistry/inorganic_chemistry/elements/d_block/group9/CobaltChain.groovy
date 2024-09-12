import globals.Globals
import static globals.CarbonGlobals.*

ROASTER = recipemap('roaster')
PBF_RECIPES = recipemap("primitive_blast_furnace")

for (combustible in combustibles()) {
    ROASTER.recipeBuilder()
        .inputs(ore('dustCobaltOxide') * 2)
        .inputs(ore(combustible.name) * combustible.equivalent(1))
        .outputs(metaitem('dustCobalt'))
        .fluidOutputs(fluid('carbon_monoxide') * 1000)
        .duration(120)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()
}

// Primitive ways for getting impure cobalt (cobalt matte) for Kovar.
def cobalt_matte_recipes = [
        ["oreCobaltite", 1],
        ["oreNetherrackCobaltite", 2],
        ["oreEndstoneCobaltite", 2],
        ["dustCobaltite", 1],
]

cobalt_matte_recipes.forEach { recipe ->
    combustibles().forEach { combustible ->
        PBF_RECIPES.recipeBuilder()
                .inputs(ore(recipe[0]))
                .inputs(ore(combustible.name) * (combustible.equivalent(2)))
                .outputs(metaitem('ingotCobaltMatte') * recipe[1])
                .duration(80 * recipe[1])
                .buildAndRegister()
    }
}