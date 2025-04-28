import gregtech.api.recipes.RecipeMap

// Allows direct modification of the in/output amounts of RecipeMap
// Can be used in preInit or postInit, reloadable
//
// Example usage:
// ```groovy
// RecipeMaps.ARC_FURNACE_RECIPES.modifyMaxInputs(2)
//         .modifyMaxFluidInputs(2)
//         .modifyMaxOutputs(6)
//         .modifyMaxFluidOutputs(2)
// ```
['Outputs', 'Inputs', 'FluidOutputs', 'FluidInputs'].each { field ->
    RecipeMap.metaClass."modifyMax$field" = {
        delegate.@"max$field" = it
        delegate
    }
}
