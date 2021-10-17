import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.liquid.ILiquidStack;
import crafttweaker.oredict.IOreDictEntry;

val name_removals as string[] = [
	"regeneration:fob_watch",
	"regeneration:fob_watch_2",
	"regeneration:arch",
	"regeneration:hand_jar",
	"regeneration:lindos_vial"
];

for item in name_removals {
	recipes.removeByRecipeName(item);
}