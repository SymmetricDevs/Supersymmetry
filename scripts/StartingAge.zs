import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.liquid.ILiquidStack;
import crafttweaker.oredict.IOreDictEntry;

import crafttweaker.block.IBlock;
import crafttweaker.block.IBlockDefinition;

import mods.appliedenergistics2.Grinder;

import mods.immersiveengineering.AlloySmelter;
import mods.immersiveengineering.BlastFurnace;

import mods.gregtech.recipe.PBFRecipeBuilder;

val name_removals = [
	"immersiveengineering:stone_decoration/cokebrick",
	"immersiveengineering:stone_decoration/blastbrick",
	"gregtech:iron_magnetic_stick",
	"immersiveengineering:stone_decoration/blastbrick_reinforced",
	"immersiveengineering:wooden_devices/crate",
	"immersiveengineering:wooden_devices/barrel",
	"appliedenergistics2:misc/grindstone_woodengear",
	"machinemod:woodengear",
	"gtadditions:clay_brick",
	"gtadditions:eight_clay_brick",
	"notreepunching:misc/clay_tool_clay_brick",
	"notreepunching:misc/clay_tool_clay_brick_2",
	"immersiveengineering:metal_decoration/coil_copper",
	"immersiveengineering:metal_decoration/coil_electrum",
	"immersiveengineering:metal_decoration/coil_hv",
	"immersiveengineering:wirecoils/wirecoil_lv",
	"immersiveengineering:wirecoils/wirecoil_mv",
	"immersiveengineering:wirecoils/wirecoil_hv",
	"immersiveengineering:wirecoils/wirecoil_hv2",
	"immersiveengineering:material/stick_treated",
	"gtadditions:ga_primitive_blast_furnace",
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
	[<minecraft:brick>, <metaitem:compressed.clay>]
] as IIngredient[][];

for item in smelting_removals_binary {
	furnace.remove(item[0], item[1]);
}

furnace.remove(<minecraft:brick>, <minecraft:clay_ball>);

//Vanilla Brick Crafting
recipes.addShaped("brick_x1", <notreepunching:clay_brick>*1, [
	[<ore:ingotClay>, <ore:formWood>, null],
	[null, null, null],
	[null, null, null],
]);
recipes.addShaped("brick_x8", <notreepunching:clay_brick>*8, [
	[<ore:ingotClay>, <ore:ingotClay>, <ore:ingotClay>],
	[<ore:ingotClay>, <ore:formWood>, <ore:ingotClay>],
	[<ore:ingotClay>, <ore:ingotClay>, <ore:ingotClay>],
]);

//IE Crate Crafting
recipes.addShaped("ie_wooden_storage_crate", <immersiveengineering:wooden_device0>, [
	[<ore:screwIron>, <ore:plankTreatedWood>, <ore:screwIron>],
	[<ore:plankTreatedWood>, <ore:gregSaws>, <ore:plankTreatedWood>],
	[<ore:screwIron>, <ore:plankTreatedWood>, <ore:screwIron>]
]);

//IE Wooden Barrel
recipes.addShaped("ie_wooden_barrel", <immersiveengineering:wooden_device0:1>, [
	[<ore:gregSoftHammers>, <ore:slimeball>, <ore:gregSaws>],
	[<ore:plankTreatedWood>, <ore:stickLongIron>, <ore:plankTreatedWood>],
	[<ore:plankTreatedWood>, <ore:stickLongIron>, <ore:plankTreatedWood>]
]);

//Wooden Gear Crafting
recipes.addShaped("woodgear", <metaitem:gearWood>, [
	[<ore:stickWood>, <ore:plankWood>, <ore:stickWood>],
	[<ore:plankWood>, <ore:gregScrewDrivers>, <ore:plankWood>],
	[<ore:stickWood>, <ore:plankWood>, <ore:stickWood>]
]);

//AE2 Grindstone Crafting
recipes.addShaped("ae2_grindstone", <appliedenergistics2:grindstone>, [
	[<ore:stone>, <ore:gearWood>, <ore:stone>],
	[<ore:gemFlint>, <ore:stone>, <ore:gemFlint>],
	[<ore:cobblestone>, <ore:gemFlint>, <ore:cobblestone>]
]);

//Hot Iron Rod Crafting
recipes.addShaped("hot_iron_rod", <contenttweaker:hot_iron_rod>, [
	[<ore:gregFiles>, null, null],
	[null, <metaitem:hot_iron_ingot>, null],
	[null, null, null]
]);

recipes.addShaped("ie_treated_stick", <immersiveengineering:material>*2, [
	[null, null, null],
	[<ore:gregSaws>, <ore:plankTreatedWood>, null],
	[null, null, null]
]);

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
recipes.addShaped("ga_pbf", <meta_tile_entity:primitive_blast_furnace.bronze>, [
	[<ore:gregHardHammers>, <ore:stickBronze>, <ore:screwBronze>],
	[<ore:plateBronze>, <gregtech:metal_casing:1>, <ore:stickBronze>],
	[<ore:gregScrewDrivers>, <ore:stickBronze>, <ore:screwBronze>]
]);

//Coke Oven
recipes.addShaped("gt_co", <meta_tile_entity:coke_oven>, [
	[<gregtech:metal_casing:8>, <ore:plateBronze>, <gregtech:metal_casing:8>],
	[<ore:plateBronze>, <ore:gregWrenches>, <ore:plateBronze>],
	[<gregtech:metal_casing:8>, <ore:plateBronze>, <gregtech:metal_casing:8>]
]);

//IE Blast Bricks
recipes.addShaped("ie_blast_bricks", <immersiveengineering:stone_decoration:1>*4, [
	[<metaitem:brick.fireclay>, <metaitem:brick.coke>, null],
	[<metaitem:brick.coke>, <metaitem:brick.fireclay>, null],
	[null, null, null]
]);

//Voltaic Pile Crafting
recipes.addShapeless("voltaic_pile", <contenttweaker:voltaic_pile>, [<ore:plateCopper>, <ore:plateSilver>, <contenttweaker:electrolyte_paper>]);
recipes.addShapeless("voltaic_pile_1", <contenttweaker:voltaic_pile>, [<ore:plateCopper>, <ore:plateZinc>, <contenttweaker:electrolyte_paper>]);

//Magnetic Rod Crafting
recipes.addShapeless("magnetic_iron_stick", <ore:stickIronMagnetic>.firstItem, [<contenttweaker:hot_iron_rod>, <contenttweaker:voltaic_pile>, <ore:wireFineCopper>]);
recipes.addShapeless("magnetic_iron_stick_1", <ore:stickIronMagnetic>.firstItem, [<contenttweaker:hot_iron_rod>, <contenttweaker:magnetite_chunk>]);
recipes.addShapeless("magnetic_iron_stick_2", <ore:stickIronMagnetic>.firstItem * 2, [<contenttweaker:hot_iron_rod>, <ore:stickIronMagnetic>]);

val gt_wires as IOreDictEntry[] = [
	<ore:wireGtSingleCopper>,
	<ore:wireGtSingleElectrum>,
	<ore:wireGtSingleSteel>
];

val coils as IItemStack[] = [
	<immersiveengineering:wirecoil:0>,
	<immersiveengineering:wirecoil:1>,
	<immersiveengineering:wirecoil:2>
];

val coil_blocks as IItemStack[] = [
	<immersiveengineering:metal_decoration0:0>,
	<immersiveengineering:metal_decoration0:1>,
	<immersiveengineering:metal_decoration0:2>
];

val coil_blocks_recipes_names as string[] = [
	"ie_lv_coil_block",
	"ie_mv_coil_block",
	"ie_hv_coil_block",
];

val coil_recipes_names as string[] = [
	"ie_lv_coil",
	"ie_mv_coil",
	"ie_hv_coil",
];

for i in 0 to 3 {
	recipes.addShaped(coil_blocks_recipes_names[i], coil_blocks[i], [
		[coils[i], coils[i], coils[i]],
		[coils[i], <ore:stickIron>, coils[i]],
		[coils[i], coils[i], coils[i]]
	]);
	
	recipes.addShaped(coil_recipes_names[i], coils[i]*4, [
		[gt_wires[i], gt_wires[i], gt_wires[i]],
		[gt_wires[i], <ore:stickTreatedWood>, gt_wires[i]],
		[gt_wires[i], gt_wires[i], gt_wires[i]]
	]);
	
}

recipes.addShaped("wood_stick", <minecraft:stick>*2, [
	[null, null, null],
	[<ore:gregSaws>, <ore:plankWood>, null],
	[null, null, null]
]);

recipes.addShaped("interdimensional_pipe", <dimstack:dim_pipe>, [
	[<ore:frameGtSteel>, <ore:gemNetherQuartz>, <ore:frameGtSteel>],
	[<ore:frameGtSteel>, <meta_tile_entity:gtadditions:crate.wood>, <ore:frameGtSteel>],
	[<ore:frameGtSteel>, <ore:gemNetherQuartz>, <ore:frameGtSteel>]
]);

//----------Recipes using IE machines----------

mods.immersiveengineering.AlloySmelter.removeRecipe(<ore:ingotConstantan>.firstItem);
mods.immersiveengineering.AlloySmelter.addRecipe(<ore:ingotCupronickel>.firstItem*2, <ore:dustCopper>, <ore:dustNickel>, 200);

//mods.immersiveengineering.BlastFurnace.addRecipe(<minecraft:iron_ingot>, <ore:dustIron>, 1000, <immersiveengineering:material:7>);
//mods.immersiveengineering.BlastFurnace.addRecipe(<ore:ingotNickel>.firstItem, <ore:dustNickel>, 1000, <immersiveengineering:material:7>);

//----------Recipes using GT machines----------
PBFRecipeBuilder.start()
    .input(<ore:dustIron> * 1)
    .output(<minecraft:iron_ingot>)
    .duration(1000)
    .fuelAmount(1)
    .buildAndRegister();
	
PBFRecipeBuilder.start()
    .input(<ore:dustMagnetite> * 7)
    .output(<minecraft:iron_ingot> * 3)
    .duration(1000)
    .fuelAmount(1)
    .buildAndRegister();
	
PBFRecipeBuilder.start()
    .input(<ore:dustVanadiumMagnetite> * 8)
    .output(<minecraft:iron_ingot> * 3)
    .duration(1000)
    .fuelAmount(1)
    .buildAndRegister();
	
PBFRecipeBuilder.start()
    .input(<ore:dustBandedIron> * 5)
    .output(<minecraft:iron_ingot> * 2)
    .duration(1000)
    .fuelAmount(1)
    .buildAndRegister();
	
PBFRecipeBuilder.start()
    .input(<ore:dustBrownLimonite> * 4)
    .output(<minecraft:iron_ingot> * 1)
    .duration(1000)
    .fuelAmount(1)
    .buildAndRegister();
	
PBFRecipeBuilder.start()
    .input(<ore:dustYellowLimonite> * 4)
    .output(<minecraft:iron_ingot> * 1)
    .duration(1000)
    .fuelAmount(1)
    .buildAndRegister();
	
PBFRecipeBuilder.start()
    .input(<ore:dustPyrite> * 2)
    .output(<minecraft:iron_ingot> * 1)
    .duration(1000)
    .fuelAmount(1)
    .buildAndRegister();
	
PBFRecipeBuilder.start()
    .input(<ore:dustNickel> * 1)
    .output(<ore:ingotNickel>.firstItem * 1)
    .duration(1000)
    .fuelAmount(1)
    .buildAndRegister();
	
PBFRecipeBuilder.start()
    .input(<ore:dustGarnierite> * 2)
    .output(<ore:ingotNickel>.firstItem * 1)
    .duration(1000)
    .fuelAmount(1)
    .buildAndRegister();
	
PBFRecipeBuilder.start()
    .input(<ore:dustPentlandite> * 17)
    .output(<ore:ingotNickel>.firstItem * 9)
    .duration(1000)
    .fuelAmount(1)
    .buildAndRegister();
	
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
	<ore:oreBandedIron> : <ore:dustBandedIron>.firstItem*4,
	<ore:oreBrownLimonite> : <ore:dustBrownLimonite>.firstItem*4,
	<ore:oreYellowLimonite> : <ore:dustYellowLimonite>.firstItem*4,
	<ore:oreTenorite> : <ore:dustTenorite>.firstItem*4,
	<ore:oreTetrahedrite> : <ore:dustTetrahedrite>.firstItem*4,
	<ore:oreBornite> : <ore:dustBornite>.firstItem*4,
	<ore:oreChalcopyrite> : <ore:dustChalcopyrite>.firstItem*4,
	<ore:oreMalachite> : <ore:dustMalachite>.firstItem*4,
	<ore:oreEnargite> : <ore:dustEnargite>.firstItem*4,
	<ore:oreCassiterite> : <ore:dustCassiterite>.firstItem*4,
	<ore:oreGalena> : <ore:dustGalena>.firstItem*4,
	<ore:orePyrite> : <ore:dustPyrite>.firstItem*4,

	<ore:orePoorIron> : <ore:dustIron>.firstItem*1,
	<ore:orePoorGold> : <ore:dustGold>.firstItem*1,
	<ore:orePoorCopper> : <ore:dustCopper>.firstItem*1,
	<ore:orePoorTin> : <ore:dustTin>.firstItem*1,
	<ore:orePoorSilver> : <ore:dustSilver>.firstItem*1,
	<ore:orePoorLead> : <ore:dustLead>.firstItem*1,
	<ore:orePoorZinc> : <ore:dustZinc>.firstItem*1,
	<ore:orePoorSphalerite> : <ore:dustSphalerite>.firstItem*2,
	<ore:orePoorMagnetite> : <ore:dustMagnetite>.firstItem*2,
	<ore:orePoorVanadiumMagnetite> : <ore:dustVanadiumMagnetite>.firstItem*2,
	<ore:orePoorBandedIron> : <ore:dustBandedIron>.firstItem*2,
	<ore:orePoorBrownLimonite> : <ore:dustBrownLimonite>.firstItem*2,
	<ore:orePoorYellowLimonite> : <ore:dustYellowLimonite>.firstItem*2,
	<ore:orePoorTenorite> : <ore:dustTenorite>.firstItem*2,
	<ore:orePoorTetrahedrite> : <ore:dustTetrahedrite>.firstItem*2,
	<ore:orePoorBornite> : <ore:dustBornite>.firstItem*2,
	<ore:orePoorChalcopyrite> : <ore:dustChalcopyrite>.firstItem*2,
	<ore:orePoorMalachite> : <ore:dustMalachite>.firstItem*2,
	<ore:orePoorEnargite> : <ore:dustEnargite>.firstItem*2,
	<ore:orePoorCassiterite> : <ore:dustCassiterite>.firstItem*2,
	<ore:orePoorGalena> : <ore:dustGalena>.firstItem*2,
	<ore:orePoorPyrite> : <ore:dustPyrite>.firstItem*2,

	<ore:oreRichIron> : <ore:dustIron>.firstItem*3,
	<ore:oreRichGold> : <ore:dustGold>.firstItem*3,
	<ore:oreRichCopper> : <ore:dustCopper>.firstItem*3,
	<ore:oreRichTin> : <ore:dustTin>.firstItem*3,
	<ore:oreRichSilver> : <ore:dustSilver>.firstItem*3,
	<ore:oreRichLead> : <ore:dustLead>.firstItem*3,
	<ore:oreRichZinc> : <ore:dustZinc>.firstItem*3,
	<ore:oreRichSphalerite> : <ore:dustSphalerite>.firstItem*6,
	<ore:oreRichMagnetite> : <ore:dustMagnetite>.firstItem*6,
	<ore:oreRichVanadiumMagnetite> : <ore:dustVanadiumMagnetite>.firstItem*6,
	<ore:oreRichBandedIron> : <ore:dustBandedIron>.firstItem*6,
	<ore:oreRichBrownLimonite> : <ore:dustBrownLimonite>.firstItem*6,
	<ore:oreRichYellowLimonite> : <ore:dustYellowLimonite>.firstItem*6,
	<ore:oreRichTenorite> : <ore:dustTenorite>.firstItem*6,
	<ore:oreRichTetrahedrite> : <ore:dustTetrahedrite>.firstItem*6,
	<ore:oreRichBornite> : <ore:dustBornite>.firstItem*6,
	<ore:oreRichChalcopyrite> : <ore:dustChalcopyrite>.firstItem*6,
	<ore:oreRichMalachite> : <ore:dustMalachite>.firstItem*6,
	<ore:oreRichEnargite> : <ore:dustEnargite>.firstItem*6,
	<ore:oreRichCassiterite> : <ore:dustCassiterite>.firstItem*6,
	<ore:oreRichGalena> : <ore:dustGalena>.firstItem*6,
	<ore:oreRichPyrite> : <ore:dustPyrite>.firstItem*6,

	<ore:orePureIron> : <ore:dustIron>.firstItem*4,
	<ore:orePureGold> : <ore:dustGold>.firstItem*4,
	<ore:orePureCopper> : <ore:dustCopper>.firstItem*4,
	<ore:orePureTin> : <ore:dustTin>.firstItem*4,
	<ore:orePureSilver> : <ore:dustSilver>.firstItem*4,
	<ore:orePureLead> : <ore:dustLead>.firstItem*4,
	<ore:orePureZinc> : <ore:dustZinc>.firstItem*4,
	<ore:orePureSphalerite> : <ore:dustSphalerite>.firstItem*8,
	<ore:orePureMagnetite> : <ore:dustMagnetite>.firstItem*8,
	<ore:orePureVanadiumMagnetite> : <ore:dustVanadiumMagnetite>.firstItem*8,
	<ore:orePureBandedIron> : <ore:dustBandedIron>.firstItem*8,
	<ore:orePureBrownLimonite> : <ore:dustBrownLimonite>.firstItem*8,
	<ore:orePureYellowLimonite> : <ore:dustYellowLimonite>.firstItem*8,
	<ore:orePureTenorite> : <ore:dustTenorite>.firstItem*8,
	<ore:orePureTetrahedrite> : <ore:dustTetrahedrite>.firstItem*8,
	<ore:orePureBornite> : <ore:dustBornite>.firstItem*8,
	<ore:orePureChalcopyrite> : <ore:dustChalcopyrite>.firstItem*8,
	<ore:orePureMalachite> : <ore:dustMalachite>.firstItem*8,
	<ore:orePureEnargite> : <ore:dustEnargite>.firstItem*8,
	<ore:orePureCassiterite> : <ore:dustCassiterite>.firstItem*8,
	<ore:orePureGalena> : <ore:dustGalena>.firstItem*8,
	<ore:orePurePyrite> : <ore:dustPyrite>.firstItem*8,

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