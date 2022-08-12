#priority 2000

import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.liquid.ILiquidStack;
import crafttweaker.oredict.IOreDictEntry;

val smelting_removals = [
	<ore:ingotIron>,
	<ore:chunkIron>,
	<ore:nuggetIron>,
	<ore:ingotNickel>,
	<ore:chunkNickel>,
	<ore:nuggetNickel>,
	<ore:ingotAluminium>,
	<ore:chunkAluminium>,
	<ore:nuggetAluminium>,
	<ore:ingotAluminum>,
	<ore:nuggetAluminum>,
	<ore:ingotConstantan>,
	<ore:nuggetConstantan>,
	<ore:ingotSteel>,
	<ore:chunkSteel>,
	<ore:nuggetSteel>,
	<ore:ingotPlatinum>,
	<ore:chunkPlatinum>,
	<ore:nuggetPlatinum>,
	<ore:ingotIronMagnetic>,
	<ore:gemCharcoal>,
	<ore:ingotTitanium>
] as IIngredient[];

for entry in smelting_removals {
	for item in entry.items {
		furnace.remove(item);
	}
}

val item_removals = [
	<minecraft:bread>
] as IItemStack[];

for item in item_removals {
	furnace.remove(item);
}