import gregtech.api.GTValues
import gregtech.api.recipes.Recipe
import gregtech.api.recipes.RecipeMaps
import gregtech.api.recipes.builders.BlastRecipeBuilder
import gregtech.api.recipes.recipeproperties.TemperatureProperty
import gregtech.api.unification.OreDictUnifier
import gregtech.api.unification.material.Materials

def temperatureRanges = [
        [1, 1800, 800],
        [1801, 2700, 1400],
        [2701, 3600, 1700],
        [3601, 4500, 2100],
        [4501, 5400, 3000]
]

new ArrayList<>(RecipeMaps.BLAST_RECIPES.getRecipeList()).each { Recipe recipe ->
    int oldTemp = recipe.getProperty(TemperatureProperty.getInstance(), 0)
    if (!oldTemp) return

    def materials = recipe.getOutputs().collect { OreDictUnifier.getMaterial(it)?.material }
    def range = temperatureRanges.find { oldTemp >= it[0] && oldTemp <= it[1] }

    int newTemp = materials.contains(Materials.Kanthal) ? 1400 :
            materials.contains(Materials.Nichrome) ? 800 :
                    range ? range[2] : oldTemp

    int newEUt = materials.contains(Materials.Kanthal) ? GTValues.VA[GTValues.EV] :
            materials.contains(Materials.Nichrome) ? GTValues.VA[GTValues.HV] :
                    recipe.getEUt()

    if (oldTemp == newTemp && recipe.getEUt() == newEUt) return

    def builder = new BlastRecipeBuilder(recipe, RecipeMaps.BLAST_RECIPES)
    builder.applyProperty(TemperatureProperty.getInstance(), null)
    builder.blastFurnaceTemp(newTemp)
    builder.EUt(newEUt)
    RecipeMaps.BLAST_RECIPES.removeRecipe(recipe)
    builder.buildAndRegister()
}

