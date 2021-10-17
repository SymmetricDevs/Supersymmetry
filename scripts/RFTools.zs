import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.liquid.ILiquidStack;
import crafttweaker.oredict.IOreDictEntry;

val name_removals as string[] = [
	"rftools:machine_frame",
	"rftools:machine_base",
	"rftools:crafter1",
	"rftools:crafter2",
	"rftools:crafter3",
	"rftools:modular_storage",
	"rftools:remote_storage",
	"rftools:matter_transmitter",
	"rftools:matter_receiver",
	"rftools:dialing_device",
	"rftools:destination_analyzer",
	"rftools:screen",
	"rftools:screen_controller"
];

for item in name_removals {
	recipes.removeByRecipeName(item);
}

recipes.addShaped("rftools_crafter_1", <rftools:crafter1>*2, [
	[robotArms[1], <ore:circuitBasic>, robotArms[1]],
	[<ore:workbench>, hulls[1], <ore:workbench>],
	[robotArms[1], <ore:circuitBasic>, robotArms[1]]
]);

recipes.addShaped("rftools_crafter_2", <rftools:crafter2>*2, [
	[robotArms[1], <ore:plateSteel>, robotArms[1]],
	[<rftools:crafter1>, hulls[1], <rftools:crafter1>],
	[robotArms[1], <ore:plateSteel>, robotArms[1]]
]);

recipes.addShaped("rftools_crafter_3", <rftools:crafter3>*2, [
	[robotArms[1], <ore:plateSteel>, robotArms[1]],
	[<rftools:crafter2>, hulls[1], <rftools:crafter2>],
	[robotArms[1], <ore:plateSteel>, robotArms[1]]
]);

recipes.addShaped("rftools_modular_storage", <rftools:modular_storage>, [
	[robotArms[1], <ore:circuitBasic>, robotArms[1]],
	[<meta_tile_entity:gregtech:steel_chest>, hulls[1], <meta_tile_entity:gregtech:steel_chest>],
	[robotArms[1], <ore:circuitBasic>, robotArms[1]]
]);