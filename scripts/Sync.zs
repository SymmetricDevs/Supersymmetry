#norun
import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.liquid.ILiquidStack;
import crafttweaker.oredict.IOreDictEntry;

val name_removals as string[] = [
	"sync:sync_core",
	"sync:shell_constructor",
	"sync:shell_storage",
	"sync:treadmill"
];

for item in name_removals {
	recipes.removeByRecipeName(item);
}