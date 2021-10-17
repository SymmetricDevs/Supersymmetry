import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.liquid.ILiquidStack;
import crafttweaker.oredict.IOreDictEntry;

val name_removals as string[] = [
	"toughasnails:cooling_coil",
	"toughasnails:heating_coil",
	"toughasnails:thermometer"
];

for item in name_removals {
	recipes.removeByRecipeName(item);
}

<toughasnails:purified_water_bottle>.maxStackSize = 8;