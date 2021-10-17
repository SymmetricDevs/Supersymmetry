import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.liquid.ILiquidStack;
import crafttweaker.oredict.IOreDictEntry;
import mods.gregtech.recipe.RecipeMap;
import mods.gtadditions.recipe.Utils;
import mods.gtadditions.recipe.LargeRecipeMap;
import mods.gtadditions.recipe.GARecipeMaps;

blast_furnace.recipeBuilder()
	.inputs([
		<ore:dustManganese>,
		<ore:dustPhosphorus>
	])
	.outputs(<ore:dustManganesePhosphide>.firstItem*2)
	.property("temperature", 1200)
	.duration(400)
	.EUt(120)
	.buildAndRegister();