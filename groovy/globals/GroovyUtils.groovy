package globals

import net.minecraftforge.fluids.FluidStack;
import net.minecraft.item.ItemStack;

import gregtech.integration.groovy.VirtualizedRecipeMap;
import gregtech.api.capability.GregtechCapabilities;
import gregtech.api.capability.IElectricItem;
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

    public static ItemStack makeCharged(ItemStack itemStack) {
        if (itemStack != null) {
            IElectricItem electricItem = itemStack.getCapability(GregtechCapabilities.CAPABILITY_ELECTRIC_ITEM, null);
            if (electricItem == null) {
                throw new IllegalStateException("Not an electric item");
            }
            electricItem.charge(electricItem.getMaxCharge(), Integer.MAX_VALUE, true, false);
        }
        return itemStack;
    }

}