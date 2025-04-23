import gregtech.api.unification.OreDictUnifier
import gregtech.api.unification.material.properties.PropertyKey
import gregtech.api.unification.ore.OrePrefix
import gregtech.core.unification.material.internal.MaterialRegistryManager
import gregtech.loaders.recipe.RecyclingRecipes
import gregtech.loaders.recipe.handlers.RecyclingRecipeHandler

ARC_FURNACE = recipemap('arc_furnace')
MACERATOR = recipemap('macerator')
EXTRACTOR = recipemap('extractor')

def recyclingRecipeMaps = [
        ARC_FURNACE,
        MACERATOR,
        EXTRACTOR,
]

recyclingRecipeMaps.each { map ->
    map.groovyScriptRecipeMap.streamRecipes()
            .removeIf { it.recipeCategory.name.endsWith('_recycling') }
}

// Reload every recycling recipes
// Reload MetaPrefixItems
OrePrefix.values().each { ore ->
    if (ore.shouldRecycle()) {
        MaterialRegistryManager.instance.registeredMaterials.each { mat ->
            if (mat.hasDust() && !mat.hasFlag('no_unification') && !OreDictUnifier.get(ore, mat).empty) {
                RecyclingRecipeHandler.processCrushing(ore, mat, mat.getProperty(PropertyKey.DUST))
            }
        }
    }
}

// Reload other items
RecyclingRecipes.init()
