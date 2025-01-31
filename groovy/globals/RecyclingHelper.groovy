package globals

import com.cleanroommc.groovyscript.api.IIngredient
import gregtech.api.recipes.RecipeMap
import gregtech.api.recipes.ingredients.GTRecipeInput
import gregtech.api.unification.OreDictUnifier
import gregtech.api.unification.material.MarkerMaterial
import gregtech.api.unification.material.Material
import gregtech.api.unification.ore.OrePrefix
import gregtech.api.unification.stack.ItemMaterialInfo
import gregtech.api.unification.stack.MaterialStack
import gregtech.loaders.recipe.RecyclingRecipes
import it.unimi.dsi.fastutil.objects.Object2LongMap
import it.unimi.dsi.fastutil.objects.Object2LongOpenHashMap

import java.util.stream.Collectors

/**
 * An utility class that handles recycling recipes,
 * with many codes copied from CEu itself.
 * Note: This DOES NOT work with extractor,
 * which doesn't respect input stacks when output stack has a prefix
 */
class RecyclingHelper {

    private static final List recyclingRecipeMaps = [
            recipemap("macerator"),
            recipemap("arc_furnace"),
            recipemap("extractor")
    ]

    static final void removeByOutput(ItemStack output) {
        crafting.removeByOutput(output)
        removeRecyclingRecipes(output)
    }

    static final void replaceShapeless(String name, ItemStack output, List<IIngredient> inputs) {
        crafting.replaceShapeless(name, output, inputs)
        removeRecyclingRecipes(output)
        handleRecycling(output, inputs)
    }

    static final void addShapeless(String name, ItemStack output, List<IIngredient> inputs) {
        crafting.addShapeless(name, output, inputs)
        handleRecycling(output, inputs)
    }

    static final void replaceShaped(String name, ItemStack output, List<List<IIngredient>> inputs) {
        crafting.replaceShaped(name, output, inputs)
        removeRecyclingRecipes(output)
        handleRecycling(output, inputs)
    }

    static final void addShaped(String name, ItemStack output, List<List<IIngredient>> inputs) {
        crafting.addShaped(name, output, inputs)
        handleRecycling(output, inputs)
    }

    static final void removeRecyclingRecipes(ItemStack output) {
        for (RecipeMap recipeMap : recyclingRecipeMaps) {
            recipeMap.getGroovyScriptRecipeMap().streamRecipes().removeIf(recipe -> {
                for (GTRecipeInput inputStack : recipe.getInputs()) {
                    if (inputStack.acceptsStack(output)) {
                        return true;
                    }
                }
                return false;
            })
        }
    }

    static final void handleRecycling(ItemStack output, List<?> inputs) {
        RecyclingRecipes.registerRecyclingRecipes(output.withAmount(1),
                getRecyclingIngredients(output.getAmount(), inputs.flatten()),
                false, OreDictUnifier.getPrefix(output)) // See the comment at the top of this class
    }

    private static final List<MaterialStack> getRecyclingIngredients(int outputCount, List<IIngredient> inputs) {

        Object2LongMap<Material> materialStacksExploded = new Object2LongOpenHashMap<>();

        for (IIngredient input : inputs) {
            if (input == null || input.isEmpty()) continue
            addItemStackToMaterialStacks(input.withAmount(1).getMatchingStacks()[0], materialStacksExploded, input.getAmount())
        }

        return materialStacksExploded.entrySet().stream()
                .map(e -> new MaterialStack(e.getKey(), e.getValue().intdiv(outputCount)))
                .sorted(Comparator.comparingLong(m -> -m.amount))
                .collect(Collectors.toList());
    }

    private static final void addItemStackToMaterialStacks(ItemStack itemStack, Object2LongMap<Material> materialStacksExploded, int inputCount) {
        // First try to get ItemMaterialInfo
        ItemMaterialInfo info = OreDictUnifier.getMaterialInfo(itemStack);
        if (info != null) {
            for (MaterialStack ms : info.getMaterials()) {
                if (!(ms.material instanceof MarkerMaterial)) {
                    addMaterialStack(materialStacksExploded, inputCount, ms);
                }
            }
            return;
        }

        // Then try to get a single Material (UnificationEntry needs this, for example)
        MaterialStack materialStack = OreDictUnifier.getMaterial(itemStack);
        if (materialStack != null && !(materialStack.material instanceof MarkerMaterial)) {
            addMaterialStack(materialStacksExploded, inputCount, materialStack);
        }

        // Gather any secondary materials if this item has an OrePrefix
        OrePrefix prefix = OreDictUnifier.getPrefix(itemStack);
        if (prefix != null && !prefix.secondaryMaterials.isEmpty()) {
            for (MaterialStack ms : prefix.secondaryMaterials) {
                addMaterialStack(materialStacksExploded, inputCount, ms);
            }
        }
    }

    private static final void addMaterialStack(Object2LongMap<Material> materialStacksExploded, int inputCount, MaterialStack ms) {
        long amount = materialStacksExploded.getOrDefault(ms.material, 0L);
        materialStacksExploded.put(ms.material, (ms.amount * inputCount) + amount);
    }
}