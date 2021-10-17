import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.liquid.ILiquidStack;
import crafttweaker.oredict.IOreDictEntry;

val name_removals as string[] = [
	"weeping-angels:timey_wimey_dectecterino",
	"weeping-angels:chronodyne_generator"
];

for item in name_removals {
	recipes.removeByRecipeName(item);
}