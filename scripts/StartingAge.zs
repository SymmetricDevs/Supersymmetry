import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.liquid.ILiquidStack;
import crafttweaker.oredict.IOreDictEntry;

import mods.gregtech.recipe.RecipeMap;
import mods.gregtech.recipe.RecipeMaps;

import crafttweaker.block.IBlock;
import crafttweaker.block.IBlockDefinition;

import mods.appliedenergistics2.Grinder;

val name_removals = [
	"gregtech:iron_magnetic_stick",
	"appliedenergistics2:misc/grindstone_woodengear",
	"machinemod:woodengear",
	"notreepunching:misc/clay_tool_clay_brick",
	"notreepunching:misc/clay_tool_clay_brick_2",
	"gregtech:bronze_primitive_blast_furnace",
	"gregtech:coke_oven",
	"appliedenergistics2:misc/grindstone",
	"notreepunching:tools/iron_saw",
	"notreepunching:tools/gold_saw",
	"notreepunching:tools/diamond_saw",
	"minecraft:oak_planks",
	"minecraft:spruce_planks",
	"minecraft:birch_planks",
	"minecraft:jungle_planks",
	"minecraft:acacia_planks",
	"minecraft:dark_oak_planks",
	"biomesoplenty:sacred_oak_planks",
	"biomesoplenty:cherry_planks",
	"biomesoplenty:umbran_planks",
	"biomesoplenty:fir_planks",
	"biomesoplenty:ethereal_planks",
	"biomesoplenty:magic_planks",
	"biomesoplenty:mangrove_planks",
	"biomesoplenty:palm_planks",
	"biomesoplenty:redwood_planks",
	"biomesoplenty:willow_planks",
	"biomesoplenty:pine_planks",
	"biomesoplenty:hellbark_planks",
	"biomesoplenty:jacaranda_planks",
	"biomesoplenty:mahogany_planks",
	"biomesoplenty:ebony_planks",
	"biomesoplenty:eucalyptus_planks",
	"minecraft:stick",
	"notreepunching:misc/saw_plank_sticks",
	"notreepunching:misc/saw_log_sticks",
	"notreepunching:saw_planks_1",
	"notreepunching:saw_planks_2",
	"notreepunching:saw_planks_3",
	"notreepunching:saw_planks_4",
	"notreepunching:saw_planks_5",
	"notreepunching:saw_planks_6",
	"notreepunching:saw_planks_7",
	"notreepunching:saw_planks_8",
	"notreepunching:saw_planks_9",
	"notreepunching:saw_planks_10",
	"notreepunching:saw_planks_11",
	"notreepunching:saw_planks_12",
	"notreepunching:saw_planks_13",
	"notreepunching:saw_planks_14",
	"notreepunching:saw_planks_15",
	"notreepunching:saw_planks_16",
	"notreepunching:saw_planks_17",
	"notreepunching:saw_planks_18",
	"notreepunching:saw_planks_19",
	"notreepunching:saw_planks_20",
	"notreepunching:saw_planks_21",
	"notreepunching:saw_planks_22",
	"notreepunching:saw_planks_23",
	"notreepunching:saw_planks_24",
	"cd4017be_lib:dimstack/dim_pipe"
] as string[];

for item in name_removals {
    recipes.removeByRecipeName(item);
}


val smelting_removals_binary = [
	[<minecraft:brick>, <metaitem:compressed.clay>],
	[<minecraft:brick>, <minecraft:clay_ball>]
] as IIngredient[][];

for item in smelting_removals_binary {
	furnace.remove(item[0], item[1]);
}

//AE2 Grindstone Crafting
recipes.addShaped("ae2_grindstone", <appliedenergistics2:grindstone>, [
	[<ore:stone>, <ore:gearWood>, <ore:stone>],
	[<ore:gemFlint>, <ore:stone>, <ore:gemFlint>],
	[<ore:cobblestone>, <ore:gemFlint>, <ore:cobblestone>]
]);

/*Hot Iron Rod Crafting
recipes.addShaped("hot_iron_rod", <contenttweaker:hot_iron_rod>, [
	[<ore:gregFiles>, null, null],
	[null, <metaitem:hot_iron_ingot>, null],
	[null, null, null]
]);
*/

//Magnetite Chunk Crafting
recipes.addShapeless("magnetite_chunk", <contenttweaker:magnetite_chunk>, [<ore:oreMagnetite>]);
recipes.addShapeless("magnetite_chunk_1", <contenttweaker:magnetite_chunk>, [<ore:oreVanadiumMagnetite>]);

//Electrolyte Paper Crafting
recipes.addShaped("electrolyte_paper", <contenttweaker:electrolyte_paper>, [
	[null, <ore:paperEmpty>, null],
	[null, <metaitem:food.lime>, null],
	[null, <ore:gregMortars>, null]
]);
recipes.addShaped("electrolyte_paper_1", <contenttweaker:electrolyte_paper>, [
	[null, <ore:paperEmpty>, null],
	[null, <metaitem:food.lemon>, null],
	[null, <ore:gregMortars>, null]
]);

//Primitive Blast Furnace
recipes.addShaped("ga_pbf", <metaitem:primitive_blast_furnace.bronze>, [
	[<ore:gregHardHammers>, <ore:stickBronze>, <ore:screwBronze>],
	[<ore:plateBronze>, <gregtech:metal_casing:1>, <ore:stickBronze>],
	[<ore:gregScrewDrivers>, <ore:stickBronze>, <ore:screwBronze>]
]);

macerator.findRecipe(2, [<metaitem:primitive_blast_furnace.bronze>], null).remove();
macerator.recipeBuilder()
	.inputs(<metaitem:primitive_blast_furnace.bronze>)
	.outputs(<metaitem:dustTinyBronze> * 24)
	.duration(6).EUt(2).buildAndRegister();
arc_furnace.findRecipe(30, [<metaitem:primitive_blast_furnace.bronze>], [<liquid:oxygen> * 6]).remove();
arc_furnace.recipeBuilder()
	.inputs(<metaitem:primitive_blast_furnace.bronze>)
	.fluidInputs([<liquid:oxygen> * 6])
	.outputs(<metaitem:nuggetBronze> * 24)
	.duration(6).EUt(30).buildAndRegister();

//Coke Oven
recipes.addShaped("gt_coke_oven", <metaitem:coke_oven>, [
	[<gregtech:metal_casing:8>, <ore:plateBronze>, <gregtech:metal_casing:8>],
	[<ore:plateBronze>, <ore:gregWrenches>, <ore:plateBronze>],
	[<gregtech:metal_casing:8>, <ore:plateBronze>, <gregtech:metal_casing:8>]
]);

<recipemap:macerator>.findRecipe(2, [<metaitem:coke_oven>], null).remove();
macerator.recipeBuilder()
	.inputs(<metaitem:primitive_blast_furnace.bronze>)
	.outputs(<metaitem:dustBronze> * 4)
	.duration(56).EUt(2).buildAndRegister();

<recipemap:arc_furnace>.findRecipe(30, [<metaitem:coke_oven>], [<liquid:oxygen> * 56]).remove();
arc_furnace.recipeBuilder()
	.inputs(<metaitem:primitive_blast_furnace.bronze>)
	.fluidInputs([<liquid:oxygen> * 56])
	.outputs(<metaitem:ingotBronze> * 4)
	.duration(56).EUt(30).buildAndRegister();

//Voltaic Pile Crafting
recipes.addShapeless("voltaic_pile", <contenttweaker:voltaic_pile>, [<ore:plateCopper>, <ore:plateSilver>, <contenttweaker:electrolyte_paper>]);
recipes.addShapeless("voltaic_pile_1", <contenttweaker:voltaic_pile>, [<ore:plateCopper>, <ore:plateZinc>, <contenttweaker:electrolyte_paper>]);

//Magnetic Rod Crafting
recipes.addShapeless("magnetic_iron_stick", <metaitem:stickIronMagnetic>, [<contenttweaker:hot_iron_rod>, <contenttweaker:voltaic_pile>, <ore:wireFineCopper>]);
recipes.addShapeless("magnetic_iron_stick_1", <metaitem:stickIronMagnetic>, [<contenttweaker:hot_iron_rod>, <contenttweaker:magnetite_chunk>]);
recipes.addShapeless("magnetic_iron_stick_2", <metaitem:stickIronMagnetic> * 2, [<contenttweaker:hot_iron_rod>, <ore:stickIronMagnetic>]);

recipes.addShaped("wood_stick", <minecraft:stick>*2, [
	[null, null, null],
	[<ore:gregSaws>, <ore:plankWood>, null],
	[null, null, null]
]);

recipes.addShaped("interdimensional_pipe", <dimstack:dim_pipe>, [
	[<ore:frameGtSteel>, <ore:gemNetherQuartz>, <ore:frameGtSteel>],
	[<ore:frameGtSteel>, <metaitem:crate.wood>, <ore:frameGtSteel>],
	[<ore:frameGtSteel>, <ore:gemNetherQuartz>, <ore:frameGtSteel>]
]);

val fuels as IOreDictEntry[] = [
	<ore:coal>
];

//----------Recipes using GT machines----------

for fuel in fuels{

primitive_blast_furnace.recipeBuilder()
    .inputs(<ore:dustIron>)
    .outputs(<minecraft:iron_ingot>)
    .duration(1000)
    .inputs(fuel)
    .buildAndRegister();
	
primitive_blast_furnace.recipeBuilder()
    .inputs(<ore:dustMagnetite> * 7)
    .outputs(<minecraft:iron_ingot> * 3)
    .duration(1000)
    .inputs(fuel)
    .buildAndRegister();
	
primitive_blast_furnace.recipeBuilder()
    .inputs(<ore:dustVanadiumMagnetite> * 8)
    .outputs(<minecraft:iron_ingot> * 3)
    .duration(1000)
    .inputs(fuel)
    .buildAndRegister();
	
primitive_blast_furnace.recipeBuilder()
    .inputs(<ore:dustHematite> * 5)
    .outputs(<minecraft:iron_ingot> * 2)
    .duration(1000)
    .inputs(fuel)
    .buildAndRegister();
	
primitive_blast_furnace.recipeBuilder()
    .inputs(<ore:dustBrownLimonite> * 4)
    .outputs(<minecraft:iron_ingot>)
    .duration(1000)
    .inputs(fuel)
    .buildAndRegister();
	
primitive_blast_furnace.recipeBuilder()
    .inputs(<ore:dustYellowLimonite> * 4)
    .outputs(<minecraft:iron_ingot>)
    .duration(1000)
    .inputs(fuel)
    .buildAndRegister();
	
primitive_blast_furnace.recipeBuilder()
    .inputs(<ore:dustPyrite> * 2)
    .outputs(<minecraft:iron_ingot>)
    .duration(1000)
    .inputs(fuel)
    .buildAndRegister();
	
primitive_blast_furnace.recipeBuilder()
    .inputs(<ore:dustNickel>)
    .outputs(<ore:ingotNickel>.firstItem)
    .duration(1000)
    .inputs(fuel)
    .buildAndRegister();
	
primitive_blast_furnace.recipeBuilder()
    .inputs(<ore:dustGarnierite> * 2)
    .outputs(<ore:ingotNickel>.firstItem)
    .duration(1000)
    .inputs(fuel)
    .buildAndRegister();
	
primitive_blast_furnace.recipeBuilder()
    .inputs(<ore:dustPentlandite>7)
    .outputs(<ore:ingotNickel>.firstItem * 9)
    .duration(1000)
    .inputs(fuel)
    .buildAndRegister();
	
}

//-----Quartz Grindstone ores -----
val OreMap = {
	<ore:oreIron> : <ore:dustIron>.firstItem*2,
	<ore:oreGold> : <ore:dustGold>.firstItem*2,
	<ore:oreCopper> : <ore:dustCopper>.firstItem*2,
	<ore:oreTin> : <ore:dustTin>.firstItem*2,
	<ore:oreSilver> : <ore:dustSilver>.firstItem*2,
	<ore:oreLead> : <ore:dustLead>.firstItem*2,
	<ore:oreZinc> : <ore:dustZinc>.firstItem*2,
	<ore:oreSphalerite> : <ore:dustSphalerite>.firstItem*4,
	<ore:oreMagnetite> : <ore:dustMagnetite>.firstItem*4,
	<ore:oreVanadiumMagnetite> : <ore:dustVanadiumMagnetite>.firstItem*4,
	<ore:oreHematite> : <ore:dustHematite>.firstItem*4,
	<ore:oreBrownLimonite> : <ore:dustBrownLimonite>.firstItem*4,
	<ore:oreYellowLimonite> : <ore:dustYellowLimonite>.firstItem*4,
	<ore:oreTetrahedrite> : <ore:dustTetrahedrite>.firstItem*4,
	<ore:oreBornite> : <ore:dustBornite>.firstItem*4,
	<ore:oreChalcopyrite> : <ore:dustChalcopyrite>.firstItem*4,
	<ore:oreMalachite> : <ore:dustMalachite>.firstItem*4,
	<ore:oreEnargite> : <ore:dustEnargite>.firstItem*4,
	<ore:oreCassiterite> : <ore:dustCassiterite>.firstItem*4,
	<ore:oreGalena> : <ore:dustGalena>.firstItem*4,
	<ore:orePyrite> : <ore:dustPyrite>.firstItem*4,

	<ore:ingotTin> : <ore:dustTin>.firstItem,
	<ore:ingotCopper> : <ore:dustCopper>.firstItem,
	<ore:ingotBronze> : <ore:dustBronze>.firstItem,
	<ore:ingotIron> : <ore:dustIron>.firstItem,
	<ore:ingotLead> : <ore:dustLead>.firstItem,
	<ore:ingotZinc> : <ore:dustZinc>.firstItem,
	<ore:ingotBrass> : <ore:dustBrass>.firstItem,
	<ore:ingotNickel> : <ore:dustNickel>.firstItem,

	<ore:nuggetTin> : <ore:dustTinyTin>.firstItem,
	<ore:nuggetCopper> : <ore:dustTinyCopper>.firstItem,
	<ore:nuggetBronze> : <ore:dustTinyBronze>.firstItem,
	<ore:nuggetIron> : <ore:dustTinyIron>.firstItem,
	<ore:nuggetLead> : <ore:dustTinyLead>.firstItem,
	<ore:nuggetZinc> : <ore:dustTinyZinc>.firstItem,
	<ore:nuggetBrass> : <ore:dustTinyBrass>.firstItem,
	<ore:nuggetNickel> : <ore:dustTinyNickel>.firstItem,

} as IItemStack[IOreDictEntry];

for key in OreMap {
	Grinder.addRecipe(OreMap[key], key, 1);
}

//NoTreePunching tool stats tweak

<notreepunching:pickaxe/flint>.maxDamage = 200;
<notreepunching:axe/flint>.maxDamage = 200;
<notreepunching:shovel/flint>.maxDamage = 200;
<notreepunching:hoe/flint>.maxDamage = 200;
<notreepunching:knife/flint>.maxDamage = 200;

val WoodMap = {
	<minecraft:log:0> : <minecraft:planks:0>,
	<minecraft:log:1> : <minecraft:planks:1>,
	<minecraft:log:2> : <minecraft:planks:2>,
	<minecraft:log:3> : <minecraft:planks:3>,
	<minecraft:log2:0> : <minecraft:planks:4>,
	<minecraft:log2:1> : <minecraft:planks:5>,
	<biomesoplenty:log_0:4> : <biomesoplenty:planks_0:0>,
	<biomesoplenty:log_0:5> : <biomesoplenty:planks_0:1>,
	<biomesoplenty:log_0:6> : <biomesoplenty:planks_0:2>,
	<biomesoplenty:log_0:7> : <biomesoplenty:planks_0:3>,
	<biomesoplenty:log_1:4> : <biomesoplenty:planks_0:4>,
	<biomesoplenty:log_1:5> : <biomesoplenty:planks_0:5>,
	<biomesoplenty:log_1:6> : <biomesoplenty:planks_0:6>,
	<biomesoplenty:log_1:7> : <biomesoplenty:planks_0:7>,
	<biomesoplenty:log_2:4> : <biomesoplenty:planks_0:8>,
	<biomesoplenty:log_2:5> : <biomesoplenty:planks_0:9>,
	<biomesoplenty:log_2:6> : <biomesoplenty:planks_0:10>,
	<biomesoplenty:log_2:7> : <biomesoplenty:planks_0:11>,
	<biomesoplenty:log_3:4> : <biomesoplenty:planks_0:12>,
	<biomesoplenty:log_3:5> : <biomesoplenty:planks_0:13>,
	<biomesoplenty:log_3:6> : <biomesoplenty:planks_0:14>,
	<biomesoplenty:log_3:7> : <biomesoplenty:planks_0:15>
} as IItemStack[IItemStack];

var i = 0 as int;

for log in WoodMap {
	recipes.addShaped("wood_" + i, WoodMap[log]*4, [
		[null, <ore:gregSaws>, null],
		[null, log, null],
		[null, null, null]
	]);
	i+=1;
}

//Furnace Recipes

furnace.addRecipe(<contenttweaker:hot_iron_rod>, <ore:stickIron>);