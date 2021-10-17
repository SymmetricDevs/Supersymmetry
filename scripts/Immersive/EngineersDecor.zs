import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.liquid.ILiquidStack;
import crafttweaker.oredict.IOreDictEntry;

val name_removals as string[] = [
	"engineersdecor:dependent/small_block_breaker_recipe",
	"engineersdecor:dependent/small_tree_cutter_recipe",
	"engineersdecor:dependent/small_solar_panel_recipe",
	"engineersdecor:dependent/panzerglass_block_recipe",
	"engineersdecor:dependent/thin_steel_pole_recipe",
	"engineersdecor:dependent/steel_mesh_fence_recipe"
];

for item in name_removals {
	recipes.removeByRecipeName(item);
}

recipes.addShaped("ed_mesh_fence", <engineersdecor:steel_mesh_fence>*6, [
	[null, null, null],
	[<engineersdecor:thin_steel_pole>, <ore:ringSteel>, <engineersdecor:thin_steel_pole>],
	[<engineersdecor:thin_steel_pole>, <ore:ringSteel>, <engineersdecor:thin_steel_pole>]
]);

recipes.addShaped("ed_thin_pole", <engineersdecor:thin_steel_pole>*12, [
	[null, null, <ore:stickSteel>],
	[null, <ore:stickSteel>, null],
	[<ore:stickSteel>, null, null]
]);

recipes.addShaped("ed_tree_cutter", <engineersdecor:small_tree_cutter>, [
	[<ore:plateIron>, <ore:plateIron>, <ore:plateIron>],
	[<ore:plateIron>, <ore:toolHeadBuzzSawSteel>, <minecraft:observer>],
	[<immersiveengineering:material:8>, <ore:wireFineRedAlloy>, <immersiveengineering:material:8>]
]);

recipes.addShaped("ed_block_breaker", <engineersdecor:small_block_breaker>, [
	[<ore:plateIron>, <ore:plateIron>, <ore:plateIron>],
	[<ore:plateIron>, <ore:toolHeadPickaxeSteel>, <minecraft:observer>],
	[<immersiveengineering:material:8>, <ore:wireFineRedAlloy>, <immersiveengineering:material:8>]
]);