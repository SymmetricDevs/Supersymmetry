#norun
import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.liquid.ILiquidStack;
import crafttweaker.oredict.IOreDictEntry;

import mods.immersivepetroleum.Distillation;

val name_removals as string[] = [
	"immersivepetroleum:metal_decoration/auto_lubricator",
	"immersivepetroleum:metal_decoration/generator",
	"immersivepetroleum:stone_decoration/asphalt",
	"immersivepetroleum:stone_decoration/asphalt2",
	"immersivepetroleum:speedboat/speedboat",
	"immersivepetroleum:speedboat/icebreaker_bow"
];

for item in name_removals {
	recipes.removeByRecipeName(item);
}

recipes.addShaped("ip_auto_lubricator", <immersivepetroleum:metal_device:0>, [
	[<ore:gregScrewDrivers>, <ore:blockGlass>, <ore:gregWrenches>],
	[<ore:blockGlass>, pumps[1], <ore:blockGlass>],
	[<ore:plankTreatedWood>, <immersiveengineering:metal_device1:6>, <ore:plankTreatedWood>]
]);

recipes.addShaped("ip_single_generator", <immersivepetroleum:metal_device:1>, [
	[<ore:plateIron>, <ore:plateIron>, <ore:plateIron>],
	[<machinemod:engine>, <immersiveengineering:metal_decoration0:6>, <immersiveengineering:metal_device0:0>],
	[<ore:plateIron>, <ore:plateIron>, <ore:plateIron>]
]);

recipes.addShaped("ip_motorboat", <immersivepetroleum:speedboat>, [
	[<ore:gregScrewDrivers>, <ore:gregSaws>, <ore:gregWrenches>],
	[<ore:plankTreatedWood>, <immersiveengineering:material:8>, <machinemod:engine>],
	[<ore:plankTreatedWood>, <ore:plankTreatedWood>, <ore:plankTreatedWood>]
]);

recipes.addShaped("ip_icebreaker", <immersivepetroleum:upgrades:1>, [
	[<ore:stickSteel>, null, <ore:plateSteel>],
	[null, <ore:stickSteel>, <ore:plateSteel>],
	[<ore:plateSteel>, <ore:plateSteel>, <ore:blockSteel>]
]);

//Distillation Recipes
mods.immersivepetroleum.Distillation.addRecipe(
	[
		<liquid:sulfuric_heavy_fuel> * 15,
		<liquid:sulfuric_light_fuel> * 50,
		<liquid:sulfuric_naphtha> * 20,
		<liquid:sulfuric_gas> * 60,
	], 
	[
		<immersivepetroleum:material>
	], 
	<liquid:oil> * 50, 1600, 20, [0.1]);
	
mods.immersivepetroleum.Distillation.addRecipe(
	[
		<liquid:sulfuric_heavy_fuel> * 250,
		<liquid:sulfuric_light_fuel> * 45,
		<liquid:sulfuric_naphtha> * 15,
		<liquid:sulfuric_gas> * 600,
	], 
	[
		<immersivepetroleum:material>
	], 
	<liquid:oil_heavy> * 150, 1600, 20, [0.1]);
	
mods.immersivepetroleum.Distillation.addRecipe(
	[
		<liquid:sulfuric_heavy_fuel> * 15,
		<liquid:sulfuric_light_fuel> * 50,
		<liquid:sulfuric_naphtha> * 20,
		<liquid:sulfuric_gas> * 60,
	], 
	[
		<immersivepetroleum:material>
	], 
	<liquid:oil_medium> * 100, 1600, 20, [0.1]);
	
mods.immersivepetroleum.Distillation.addRecipe(
	[
		<liquid:sulfuric_heavy_fuel> * 10,
		<liquid:sulfuric_light_fuel> * 20,
		<liquid:sulfuric_naphtha> * 30,
		<liquid:sulfuric_gas> * 340,
	], 
	[
		<immersivepetroleum:material>
	], 
	<liquid:oil_light> * 150, 1600, 20, [0.1]);
	
mods.immersivepetroleum.Distillation.addRecipe(
	[
		<liquid:lubricant> *12
	], 
	[
		<immersivepetroleum:material>
	], 
	<liquid:creosote> * 24, 600, 15, [0]);

