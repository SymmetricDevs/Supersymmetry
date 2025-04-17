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
    map.getGroovyScriptRecipeMap()
            .streamRecipes()
            .removeIf {
                it.getRecipeCategory().getName().endsWith('_recycling')
            }
}

// Reloads every recycling recipes
MaterialRegistryManager.getInstance().getRegisteredMaterials().each { mat ->
    if (mat.hasProperty(PropertyKey.DUST) && !mat.hasFlag('no_unification')) {
        OrePrefix.values().each { ore ->
            if (!OreDictUnifier.get(ore, mat).isEmpty()) {
                RecyclingRecipeHandler.processCrushing(ore, mat, mat.getProperty(PropertyKey.DUST))
            }
        }
    }
}

RecyclingRecipes.init()