package globals

import net.minecraftforge.fluids.FluidStack;

import gregtech.integration.groovy.VirtualizedRecipeMap;
import gregtech.api.recipes.ingredients.GTRecipeInput;

class GroovyUtils {
    
    public static void removeRecipesContainingFluid(VirtualizedRecipeMap recipemap, FluidStack fs) {
        recipemap.streamRecipes().filter({ recipe -> {
            for (GTRecipeInput input : recipe.getFluidInputs()) {
                    if (input.getInputFluidStack().getFluid() == fs.getFluid()) return true
            }

            return false
        }}).removeAll()
    }
}