#norun
import mods.gregtech.recipe.RecipeMap;
import mods.gregtech.recipe.RecipeMaps;
import mods.gregtech.recipe.FuelRecipe;
import mods.gtadditions.recipe.Utils;
import mods.gtadditions.recipe.LargeRecipeMap;
import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.oredict.IOreDictEntry;
import crafttweaker.liquid.ILiquidStack;

var id = 16000 as int;

val machine = <gregtech:machine>.definition;

var tier as int = 0;

tier = 1;
for i in id to (id + 9) {
	recipes.addShaped("fdc_" + tier, machine.makeStack(i), [
		[pistons[tier], pumps[tier], pistons[tier]],
		[circuits[tier], hulls[tier], circuits[tier]],
		[pistons[tier], pumps[tier], pistons[tier]]
	]);
	tier+=1;
}

id = 16009;

tier = 1;
for i in id to (id + 9) {
	recipes.addShaped("weapons_factory_" + tier, machine.makeStack(i), [
		[robotArms[tier], conveyors[tier], robotArms[tier]],
		[circuits[tier], hulls[tier], circuits[tier]],
		[robotArms[tier], conveyors[tier], robotArms[tier]]
	]);
	tier+=1;
}