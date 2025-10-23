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

    // Get number of items which would contatin %required% amount of
    // material if single item has %provider% amount
    // E.g. for 90 carbon this would yield 1 for dustCarbon (has 100) or
    // dustAnthracite (has 90) and 2 for dustCharcoal (has 60) or gemLigniteCoke (has 75)
    public static int numItemsByProvider(int required, int provider) {
        int result = required.intdiv(provider)
        if (required % provider > 0) {
            result += 1
        }
        return result
    }
}