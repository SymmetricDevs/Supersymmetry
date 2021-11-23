import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.liquid.ILiquidStack;
import crafttweaker.oredict.IOreDictEntry;

val name_removals as string[] = [
	"quark:hopper",
	"minecraft:dispenser",
	"minecraft:golden_rail",
	"minecraft:detector_rail",
	"minecraft:sticky_piston",
	"minecraft:piston",
	"gregtech:piston_bronze",
	"gregtech:piston_aluminium",
	"gregtech:piston_steel",
	"gregtech:piston_titanium",
	"minecraft:ladder",
	"minecraft:rail",
	"minecraft:lever",
	"minecraft:stone_pressure_plate",
	"minecraft:wooden_pressure_plate",
	"minecraft:stone_button",
	"minecraft:jukebox",
	"minecraft:trapdoor",
	"quark:trapdoor",
	"quark:spruce_trapdoor",
	"quark:birch_trapdoor",
	"quark:jungle_trapdoor",
	"quark:acacia_trapdoor",
	"quark:dark_oak_trapdoor",
	"minecraft:wooden_door",
	"minecraft:spruce_door",
	"minecraft:birch_door",
	"minecraft:jungle_door",
	"minecraft:acacia_door",
	"minecraft:dark_oak_door",
	"minecraft:boat",
	"minecraft:spruce_boat",
	"minecraft:birch_boat",
	"minecraft:jungle_boat",
	"minecraft:acacia_boat",
	"minecraft:dark_oak_boat",
	"minecraft:enchanting_table",
	"minecraft:redstone_lamp",
	"minecraft:ender_chest",
	"minecraft:tripwire_hook",
	"minecraft:wooden_button",
	"minecraft:anvil",
	"minecraft:daylight_detector",
	"minecraft:dropper",
	"minecraft:observer",
	"minecraft:painting",
	"minecraft:minecart",
	"minecraft:boat",
	"minecraft:spruce_boat",
	"minecraft:birch_boat",
	"minecraft:jungle_boat",
	"minecraft:acacia_boat",
	"minecraft:dark_oak_boat",
	"minecraft:white_bed",
	"minecraft:orange_bed",
	"minecraft:magenta_bed",
	"minecraft:light_blue_bed",
	"minecraft:yellow_bed",
	"minecraft:lime_bed",
	"minecraft:pink_bed",
	"minecraft:gray_bed",
	"minecraft:light_gray_bed",
	"minecraft:cyan_bed",
	"minecraft:purple_bed",
	"minecraft:blue_bed",
	"minecraft:brown_bed",
	"minecraft:green_bed",
	"minecraft:red_bed",
	"minecraft:black_bed",
	"quark:obsidian_pressure_plate",
	"quark:chain",
	"quark:iron_ladder",
	"quark:spruce_pressure_plate",
	"quark:birch_pressure_plate",
	"quark:jungle_pressure_plate",
	"quark:acacia_pressure_plate",
	"quark:dark_oak_pressure_plate",
	"quark:spruce_button",
	"quark:birch_button",
	"quark:jungle_button",
	"quark:acacia_button",
	"quark:dark_oak_button",
	"minecraft:activator_rail",
	"minecraft:brewing_stand",
	"biomesoplenty:boat_sacred_oak",
	"biomesoplenty:boat_cherry",
	"biomesoplenty:boat_umbran",
	"biomesoplenty:boat_fir",
	"biomesoplenty:boat_ethereal",
	"biomesoplenty:boat_magic",
	"biomesoplenty:boat_mangrove",
	"biomesoplenty:boat_palm",
	"biomesoplenty:boat_redwood",
	"biomesoplenty:boat_willow",
	"biomesoplenty:boat_pine",
	"biomesoplenty:boat_hellbark",
	"biomesoplenty:boat_jacaranda",
	"biomesoplenty:boat_mahogany",
	"biomesoplenty:boat_ebony",
	"biomesoplenty:boat_eucalyptus"
];

for item in name_removals {
	recipes.removeByRecipeName(item);
}

recipes.addShapeless("gravel_to_flint", <minecraft:flint>*2, [<ore:gravel>, <ore:gravel>, <ore:gravel>]);

recipes.addShaped("mc_dispenser", <minecraft:dispenser>, [
	[<ore:cobblestone>, <ore:cobblestone>, <ore:cobblestone>],
	[<ore:cobblestone>, <ore:springSteel>, <ore:cobblestone>],
	[<ore:cobblestone>, <ore:wireFineRedAlloy>, <ore:cobblestone>]
]);

chemical_bath.recipeBuilder()
	.inputs(<minecraft:piston>)
	.fluidInputs(<liquid:glue> * 100)
	.outputs(<minecraft:sticky_piston>)
	.duration(20)
	.EUt(8)
	.buildAndRegister();

recipes.addShaped("mc_piston", <minecraft:piston>, [
	[<ore:plankWood>, <ore:plankWood>, <ore:plankWood>],
	[<ore:cobblestone>, <ore:gearBronze>, <ore:cobblestone>],
	[<ore:cobblestone>, <ore:wireFineRedAlloy> ,<ore:cobblestone>]
]);

recipes.addShaped("mc_ladder", <minecraft:ladder>*7, [
	[<ore:stickWood>, <ore:string>, <ore:stickWood>],
	[<ore:stickWood>, <ore:stickWood>, <ore:stickWood>],
	[<ore:stickWood>, <ore:string>, <ore:stickWood>]
]);

recipes.addShaped("mc_lever", <minecraft:lever>, [
	[null, <ore:stickWood>, null],
	[null, <ore:cobblestone>, null],
	[null, <ore:dustRedstone>, null]
]);

recipes.addShaped("mc_stone_pressure", <minecraft:stone_pressure_plate>, [
	[null, null, null],
	[<ore:stone>, <ore:stone>, null],
	[<ore:dustRedstone>, <ore:dustRedstone>]
]);

recipes.addShaped("mc_stone_button", <minecraft:stone_button>, [
	[null, null, null],
	[null, <ore:cobblestone>, null],
	[null, <ore:dustRedstone>, null]
]);

recipes.addShaped("mc_jukebox", <minecraft:jukebox>, [
	[<ore:plankWood>, <minecraft:noteblock>, <ore:plankWood>],
	[<ore:plankWood>, <ore:boltDiamond>, <ore:plankWood>],
	[<ore:plankWood>, motors[1], <ore:plankWood>]
]);

val TrapDoorMap = {
	<minecraft:planks:0> : <minecraft:trapdoor>,
	<minecraft:planks:1> : <quark:spruce_trapdoor>,
	<minecraft:planks:2> : <quark:birch_trapdoor>,
	<minecraft:planks:3> : <quark:jungle_trapdoor>,
	<minecraft:planks:4> : <quark:acacia_trapdoor>,
	<minecraft:planks:5> : <quark:dark_oak_trapdoor>,
} as IItemStack[IItemStack];


var i = 0 as int;
for key in TrapDoorMap {
	recipes.addShaped("mc_trapdoor_" + i, TrapDoorMap[key]*6, [
		[<ore:screwIron>, <ore:boltIron>, <ore:screwIron>],
		[key, key, key],
		[key, key, key]
	]);
	i+=1;
}

val DoorMap = {
	<minecraft:planks:0> : <minecraft:wooden_door>,
	<minecraft:planks:1> : <minecraft:spruce_door>,
	<minecraft:planks:2> : <minecraft:birch_door>,
	<minecraft:planks:3> : <minecraft:jungle_door>,
	<minecraft:planks:4> : <minecraft:acacia_door>,
	<minecraft:planks:5> : <minecraft:dark_oak_door>,
	<biomesoplenty:planks_0:0> : <biomesoplenty:sacred_oak_door>,
	<biomesoplenty:planks_0:1> : <biomesoplenty:cherry_door>,
	<biomesoplenty:planks_0:2> : <biomesoplenty:umbran_door>,
	<biomesoplenty:planks_0:3> : <biomesoplenty:fir_door>,
	<biomesoplenty:planks_0:4> : <biomesoplenty:ethereal_door>,
	<biomesoplenty:planks_0:5> : <biomesoplenty:magic_door>,
	<biomesoplenty:planks_0:6> : <biomesoplenty:mangrove_door>,
	<biomesoplenty:planks_0:7> : <biomesoplenty:palm_door>,
	<biomesoplenty:planks_0:8> : <biomesoplenty:redwood_door>,
	<biomesoplenty:planks_0:9> : <biomesoplenty:willow_door>,
	<biomesoplenty:planks_0:10> : <biomesoplenty:pine_door>,
	<biomesoplenty:planks_0:11> : <biomesoplenty:hellbark_door>,
	<biomesoplenty:planks_0:12> : <biomesoplenty:jacaranda_door>,
	<biomesoplenty:planks_0:13> : <biomesoplenty:mahogany_door>,
	<biomesoplenty:planks_0:14> : <biomesoplenty:ebony_door>,
	<biomesoplenty:planks_0:15> : <biomesoplenty:eucalyptus_door>
} as IItemStack[IItemStack];


i = 0;
for key in DoorMap {
	recipes.addShaped("mc_door_" + i + "_iron", DoorMap[key]*3, [
		[key, key, <ore:screwIron>],
		[key, key, <ore:boltIron>],
		[key, key, <ore:screwIron>]
	]);
	recipes.addShaped("mc_door_" + i + "_bronze", DoorMap[key]*1, [
		[key, key, <ore:screwBronze>],
		[key, key, <ore:boltBronze>],
		[key, key, <ore:screwBronze>]
	]);
	i+=1;
}

recipes.addShaped("mc_lamp", <minecraft:redstone_lamp>, [
	[<ore:dustRedstone>, <ore:blockGlassColorless>, <ore:dustRedstone>],
	[<ore:blockGlassColorless>, <ore:glowstone>, <ore:blockGlassColorless>],
	[<ore:dustRedstone>, <ore:blockGlassColorless>, <ore:dustRedstone>]
]);

recipes.addShaped("mc_hook", <minecraft:tripwire_hook>*2, [
	[null, <ore:ringIron>, null],
	[null, <ore:springSteel>, null],
	[<ore:dustRedstone>, <ore:plankWood>, <ore:dustRedstone>]
]);

val ButtonMap = {
	<minecraft:planks:0> : <minecraft:wooden_button>,
	<minecraft:planks:1> : <quark:spruce_button>,
	<minecraft:planks:2> : <quark:birch_button>,
	<minecraft:planks:3> : <quark:jungle_button>,
	<minecraft:planks:4> : <quark:acacia_button>,
	<minecraft:planks:5> : <quark:dark_oak_button>
} as IItemStack[IItemStack];


i = 0;
for key in ButtonMap {
	recipes.addShaped("mc_button_" + i, ButtonMap[key]*3, [
		[null, null, null],
		[null, key, null],
		[null, <ore:dustRedstone>, null]
	]);
	i+=1;
}

recipes.addShaped("mc_anvil", <minecraft:anvil>, [
	[<ore:blockIron>, <ore:blockIron>, <ore:blockIron>],
	[null, <ore:plateIron>, null],
	[<ore:plateIron>, <ore:plateIron>, <ore:plateIron>]
]);

recipes.addShaped("mc_dropper", <minecraft:dropper>, [
	[<ore:cobblestone>, <ore:cobblestone>, <ore:cobblestone>],
	[<ore:cobblestone>, pistons[1], <ore:cobblestone>],
	[<ore:cobblestone>, <ore:wireFineRedAlloy>, <ore:cobblestone>]
]);

recipes.addShaped("mc_observer", <minecraft:observer>, [
	[<ore:cobblestone>, <ore:cobblestone>, <ore:cobblestone>],
	[<ore:wireFineRedAlloy>, <ore:wireFineRedAlloy>, <ore:gemQuartz>],
	[<ore:cobblestone>, <ore:cobblestone>, <ore:cobblestone>]
]);

recipes.addShaped("mc_painting", <minecraft:painting>, [
	[<ore:stickWood>, <ore:stickWood>, <ore:stickWood>],
	[<ore:stickWood>, <ore:fabricHemp>, <ore:stickWood>],
	[<ore:stickWood>, <ore:stickWood>, <ore:stickWood>]
]);

val BoatMap = {
	<minecraft:planks:0> : <minecraft:boat>,
	<minecraft:planks:1> : <minecraft:spruce_boat>,
	<minecraft:planks:2> : <minecraft:birch_boat>,
	<minecraft:planks:3> : <minecraft:jungle_boat>,
	<minecraft:planks:4> : <minecraft:acacia_boat>,
	<minecraft:planks:5> : <minecraft:dark_oak_boat>,
	<biomesoplenty:planks_0:0> : <biomesoplenty:boat_sacred_oak>,
	<biomesoplenty:planks_0:1> : <biomesoplenty:boat_cherry>,
	<biomesoplenty:planks_0:2> : <biomesoplenty:boat_umbran>,
	<biomesoplenty:planks_0:3> : <biomesoplenty:boat_fir>,
	<biomesoplenty:planks_0:4> : <biomesoplenty:boat_ethereal>,
	<biomesoplenty:planks_0:5> : <biomesoplenty:boat_magic>,
	<biomesoplenty:planks_0:6> : <biomesoplenty:boat_mangrove>,
	<biomesoplenty:planks_0:7> : <biomesoplenty:boat_palm>,
	<biomesoplenty:planks_0:8> : <biomesoplenty:boat_redwood>,
	<biomesoplenty:planks_0:9> : <biomesoplenty:boat_willow>,
	<biomesoplenty:planks_0:10> : <biomesoplenty:boat_pine>,
	<biomesoplenty:planks_0:11> : <biomesoplenty:boat_hellbark>,
	<biomesoplenty:planks_0:12> : <biomesoplenty:boat_jacaranda>,
	<biomesoplenty:planks_0:13> : <biomesoplenty:boat_mahogany>,
	<biomesoplenty:planks_0:14> : <biomesoplenty:boat_ebony>,
	<biomesoplenty:planks_0:15> : <biomesoplenty:boat_eucalyptus>
} as IItemStack[IItemStack];


i = 0;
for key in BoatMap {
	recipes.addShaped("boat_" + i, BoatMap[key]*3, [
		[null, <ore:gregSaws>, null],
		[key, <ore:stickWood>, key],
		[key, key, key]
	]);
	i+=1;
}

recipes.addShaped("mc_obsidian_plate", <quark:obsidian_pressure_plate>, [
	[null, null, null],
	[<ore:obsidian>, <ore:obsidian>, null],
	[<ore:dustRedstone>, <ore:dustRedstone>, null]
]);

recipes.addShaped("mc_chain", <quark:chain>*3, [
	[<ore:ringIron>, null, <ore:gregHardHammers>],
	[null, <ore:ringIron>, null],
	[null, null, <ore:ringIron>]
]);

recipes.addShaped("mc_iron_ladder", <quark:iron_ladder>*16, [
	[<ore:stickIron>, <ore:gregHardHammers>, <ore:stickIron>],
	[<ore:stickIron>, <ore:stickIron>, <ore:stickIron>],
	[<ore:stickIron>, null, <ore:stickIron>]
]);

val PressureMap = {
	<minecraft:planks:0> : <minecraft:wooden_pressure_plate>,
	<minecraft:planks:1> : <quark:spruce_pressure_plate>,
	<minecraft:planks:2> : <quark:birch_pressure_plate>,
	<minecraft:planks:3> : <quark:jungle_pressure_plate>,
	<minecraft:planks:4> : <quark:acacia_pressure_plate>,
	<minecraft:planks:5> : <quark:dark_oak_pressure_plate>
} as IItemStack[IItemStack];

i = 0;
for key in PressureMap {
	recipes.addShaped("mc_pressure_" + i, PressureMap[key]*3, [
		[null, null, null],
		[key, key, null],
		[<ore:dustRedstone>, <ore:dustRedstone>, null]
	]);
	i+=1;
}

val furnace_materials = [
	<ore:stoneAndesite>,
	<ore:stoneDiorite>,
	<ore:stoneGranite>
] as IOreDictEntry[];

i=0;
for stone in furnace_materials {
	recipes.addShaped("furnace_" + i, <minecraft:furnace>, [
		[stone, stone, stone],
		[stone, null, stone],
		[stone, stone, stone]
	]);
	i+=1;
}

//Max stack size changes
<minecraft:potion>.maxStackSize = 8;

//Gregtech machine only recipes

for solder in soldering_alloys {
	assembler.recipeBuilder()
		.inputs([
			<ore:stickTitanium>*2,
			<ore:boltTitanium>*2,
			<ore:plateTitanium>,
			<ore:platePolycaprolactam>*4,
			<ore:foilPolytetrafluoroethylene>*2
		])
		.fluidInputs(solder*72)
		.outputs(<minecraft:elytra>)
		.duration(200)
		.EUt(300)
		.buildAndRegister();
}