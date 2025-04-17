import com.cleanroommc.groovyscript.api.IIngredient
import gregtech.api.recipes.RecyclingHandler
import gregtech.api.unification.OreDictUnifier

class RecyclingHelper {

    static def addShaped(String name = null, ItemStack output, List<List<IIngredient>> recipe) {
        name == null ? crafting.addShaped(output, recipe) : crafting.addShaped(name, output, recipe)
        handleRecycling(output.copy(), recipe)
    }

    static def replaceShaped(String name, ItemStack output, List<List<IIngredient>> recipe) {
        crafting.replaceShaped(name, output, recipe)
        handleRecycling(output.copy(), recipe)
    }

    static def addShapeless(String name = null, ItemStack output, List<IIngredient> recipe) {
        name == null ? crafting.addShapeless(output, recipe) : crafting.addShapeless(name, output, recipe)
        handleRecycling(output.copy(), recipe)
    }

    static def replaceShapeless(String name, ItemStack output, List<IIngredient> recipe) {
        crafting.replaceShapeless(name, output, recipe)
        handleRecycling(output.copy(), recipe)
    }

    static def removeByOutput(ItemStack output) {
        crafting.removeByOutput(output)
        removeRecyclingRecipes(output)
    }

    static def handleRecycling(ItemStack output, List<List<IIngredient>> recipe) {
        OreDictUnifier.registerOre(output, RecyclingHandler.getRecyclingIngredients(recipe.trim(), output.getCount()))
    }

    static def removeRecyclingRecipes(ItemStack output) {
        handleRecycling(output.copy(), [])
    }

}
