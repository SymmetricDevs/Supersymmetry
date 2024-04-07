println("Running ImmersiveRailroading.groovy...")

import globals.Globals
import supersymmetry.api.recipes.SuSyRecipeMaps;
import cam72cam.immersiverailroading.IRItems;
import cam72cam.mod.serialization.TagCompound;
import trackapi.lib.Gauges;

ArrayList<String> name_removals = [
		"immersiverailroading:item_manual",
		"immersiverailroading:item_conductor_whistle",
		"immersiverailroading:item_paint_brush",
		"immersiverailroading:item_golden_spike",
		"immersiverailroading:item_radio_control_card",
		"immersiverailroading:item_switch_key",
		"immersiverailroading:item_track_exchanger",
		"immersiverailroading:item_large_wrench"
];

for (item in name_removals) {
	crafting.remove(item);
}

crafting.addShaped("ir_conductor_whistle", item('immersiverailroading:item_conductor_whistle'), [
		[ore('foilGold'), ore('foilGold'), null],
		[ore('foilGold'), ore('foilGold'), null],
		[ore('foilGold'), ore('foilGold'), null]
]);

crafting.addShaped("ir_paint_brush", item('immersiverailroading:item_paint_brush'), [
		[null, ore('wool'), null],
		[null, ore('plateSteel'), null],
		[null, ore('stickWood'), null]
]);

crafting.addShaped("ir_large_wrench", item('immersiverailroading:item_large_wrench'), [
		[null, ore('plateSteel'), null],
		[ore('plateSteel'), ore('plateSteel'), ore('plateSteel')],
		[ore('plateSteel'), ore('craftingToolHardHammer'), ore('plateSteel')]
]);

crafting.addShaped("ir_gold_spike", item('immersiverailroading:item_golden_spike'), [
		[ore('plateGold'), ore('plateGold'), null],
		[ore('stickGold'), null, null],
		[ore('stickGold'), null, null]
]);

crafting.addShaped("ir_switch_key", item('immersiverailroading:item_switch_key'), [
		[null, ore('stickSteel'), null],
		[ore('craftingToolFile'), ore('stickSteel'), null],
		[null, ore('ringSteel'), null]
]);

crafting.addShaped("ir_track_exchanger", item('immersiverailroading:item_track_exchanger'), [
		[ore('paneGlass'), ore('paneGlass'), ore('paneGlass')],
		[item('immersiverailroading:item_large_wrench'), ore('plateSteel'), item('immersiverailroading:item_rail')],
		[ore('paneGlass'), ore('wireFineRedAlloy'), ore('paneGlass')]
]);

crafting.addShaped("ir_item_hook", item('immersiverailroading:item_hook'), [
		[null, null, metaitem('ringSteel')],
		[null, metaitem('stickSteel'), null],
		[metaitem('stickSteel'), null, null]
]);

crafting.replaceShaped("immersiverailroading:item_rail", item('immersiverailroading:item_rail'), [
		[metaitem('screwSteel'), ore('dyeBlack'), metaitem('screwSteel')],
		[metaitem('stickSteel'), item('minecraft:paper'), metaitem('stickSteel')],
		[metaitem('screwSteel'), metaitem('stickSteel'), metaitem('screwSteel')]
]);

crafting.replaceShaped("immersiverailroading:item_radio_control_card", item('immersiverailroading:item_radio_control_card'), [
		[null, item('opencomputers:component', 3), null],
		[metaitem('sensor.lv'), metaitem('plateSteel'), metaitem('emitter.lv')],
		[null, ore('circuitLv'), null]
]);

crafting.addShaped("ir_coupler", item('immersiverailroading:item_augment').withNbt(["gauge": 1.435D, "augment": 8]), [
		[null, metaitem('robot.arm.lv'), null],
		[metaitem('stickSteel'), metaitem('plateSteel'), metaitem('stickSteel')],
		[null, null, null]
]);

crafting.addShaped("ir_fluid_loader", item('immersiverailroading:item_augment').withNbt(["gauge": 1.435D, "augment": 5]), [
		[null, metaitem('electric.pump.lv'), null],
		[metaitem('stickSteel'), metaitem('plateSteel'), metaitem('stickSteel')],
		[null, null, null]
]);

crafting.addShaped("ir_item_loader", item('immersiverailroading:item_augment').withNbt(["gauge": 1.435D, "augment": 3]), [
		[null, metaitem('conveyor.module.lv'), null],
		[metaitem('stickSteel'), metaitem('plateSteel'), metaitem('stickSteel')],
		[null, null, null]
]);

crafting.addShaped("ir_detector", item('immersiverailroading:item_augment').withNbt(["gauge": 1.435D, "augment": 7]), [
		[null, metaitem('sensor.lv'), null],
		[metaitem('stickSteel'), metaitem('plateSteel'), metaitem('stickSteel')],
		[null, metaitem('wireFineRedAlloy'), null]
]);

crafting.addShaped("ir_fluid_unloader", item('immersiverailroading:item_augment').withNbt(["gauge": 1.435D, "augment": 6]), [
		[null, null, null],
		[metaitem('stickSteel'), metaitem('plateSteel'), metaitem('stickSteel')],
		[null, metaitem('electric.pump.lv'), null]
]);

crafting.addShaped("ir_locomotive_control", item('immersiverailroading:item_augment').withNbt(["gauge": 1.435D, "augment": 2]), [
		[null, metaitem('emitter.lv'), null],
		[metaitem('stickSteel'), metaitem('plateSteel'), metaitem('stickSteel')],
		[null, metaitem('wireFineRedAlloy'), null]
]);

crafting.addShaped("ir_item_unloader", item('immersiverailroading:item_augment').withNbt(["gauge": 1.435D, "augment": 4]), [
		[null, null, null],
		[metaitem('stickSteel'), metaitem('plateSteel'), metaitem('stickSteel')],
		[null, metaitem('conveyor.module.lv'), null]
]);

crafting.addShaped("ir_speed_retarder", item('immersiverailroading:item_augment').withNbt(["gauge": 1.435D, "augment": 0]), [
		[metaitem('stickSteel'), item('minecraft:redstone_torch'), metaitem('stickSteel')],
		[metaitem('stickSteel'), metaitem('plateSteel'), metaitem('stickSteel')],
		[null, null, null]
]);

mods.gregtech.bender.recipeBuilder()
		.circuitMeta(3)
		.inputs(ore('plateSteel'))
		.outputs(item('immersiverailroading:item_rail_part') * 10)
		.duration(200)
		.EUt(30)
		.buildAndRegister();

// supersymmetry train parts
log.infoMC("Adding Train Wheels");

//Train wheel steps:
/*
 * - Use the forge hammer on 4 double steel sheets to make the unshaped train wheel
 * Creating a small wheel:
   a. use the lathe to cut it into 4 small wheels
   b. use the hammer, saw, and file to work it into 2 small wheels
 * Creating the large drive wheel:
   a. use the lathe to cut it into 2 drive wheels
   b. use the hammer, saw, and file to cut it into 1 drive wheel
*/
mods.gregtech.forge_hammer.recipeBuilder()
	.inputs(ore('plateDoubleSteel') * 4)
	.outputs(metaitem('train_unshaped_wheel'))
	.duration(200)
	.EUt(Globals.voltAmps[1])
	.buildAndRegister();

mods.gregtech.lathe.recipeBuilder()
	.circuitMeta(1)
	.inputs(metaitem('train_unshaped_wheel'))
	.outputs(metaitem('train_small_wheel') * 4)
	.duration(200)
	.EUt(Globals.voltAmps[1])
	.buildAndRegister();

mods.gregtech.lathe.recipeBuilder()
	.circuitMeta(2)
	.inputs(metaitem('train_unshaped_wheel'))
	.outputs(metaitem('train_drive_wheel') * 2)
	.duration(200)
	.EUt(Globals.voltAmps[1])
	.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
	.inputs(metaitem('train_small_wheel') * 4)
	.inputs(metaitem('stickLongSteel') * 2)
	.inputs(metaitem('plateSteel') * 2)
	.inputs(metaitem('springSteel') * 1)
	.outputs(metaitem('train_bogie'))
	.duration(200)
	.EUt(Globals.voltAmps[1])
	.buildAndRegister();

crafting.addShaped("handcraft_train_bogie", metaitem('train_bogie'), [
	[metaitem('train_small_wheel'), ore('plateSteel'), metaitem('train_small_wheel')],
	[ore('stickLongSteel'), ore('springSteel'), ore('stickLongSteel')],
	[metaitem('train_small_wheel'), ore('plateSteel'), metaitem('train_small_wheel')],
]);

mods.gregtech.assembler.recipeBuilder()
	.inputs(item('gregtech:machine', 2) * 1) // high pressure solid fuel boiler
	.inputs(item('gregtech:boiler_casing', 1) * 4)
	.inputs(item('gregtech:boiler_firebox_casing', 1) * 4)
	.inputs(metaitem('steam.piston') * 2)
	.inputs(metaitem('drum.steel'))
	.outputs(metaitem('train_steam_boiler'))
	.duration(200)
	.EUt(Globals.voltAmps[1])
	.buildAndRegister();

// steam trains
// small(er) steam locomotive
TagCompound tag = new TagCompound();

tag.setString("defID", "rolling_stock/locomotives/rodgers_460.json");
tag.setFloat("gauge", (float) Gauges.STANDARD);

cam72cam.mod.item.ItemStack is = new cam72cam.mod.item.ItemStack(IRItems.ITEM_ROLLING_STOCK, 1);
is.setTagCompound(tag);

// 4-6-0 wheel config
SuSyRecipeMaps.RAILROAD_ENGINEERING_STATION_RECIPES.recipeBuilder()
		.circuitMeta(1)
		.inputs(metaitem('train_steam_boiler'))
		.inputs(metaitem('train_bogie'))
		.inputs(metaitem('train_drive_wheel') * 6)
		.inputs(ore('plateSteel') * 24)
		.inputs(ore('stickLongSteel') * 6)
		.inputs(item('minecraft:glass') * 2)
		.inputs(ore('boltSteel') * 48)
		.outputs(is.internal)
		.EUt(30)
		.duration(200)
		.buildAndRegister();

// large steam locomotive
tag = new TagCompound();

tag.setString("defID", "rolling_stock/locomotives/k4_pacific.json");
tag.setFloat("gauge", (float) Gauges.STANDARD);

is = new cam72cam.mod.item.ItemStack(IRItems.ITEM_ROLLING_STOCK, 1);
is.setTagCompound(tag);

// 4-6-2 wheel config
SuSyRecipeMaps.RAILROAD_ENGINEERING_STATION_RECIPES.recipeBuilder()
		.circuitMeta(1)
		.inputs(metaitem('train_steam_boiler') * 2)
		.inputs(metaitem('train_bogie'))
		.inputs(metaitem('train_drive_wheel') * 6)
		.inputs(metaitem('train_small_wheel') * 2)
		.inputs(ore('plateSteel') * 32)
		.inputs(ore('stickLongSteel') * 7)
		.inputs(item('minecraft:glass') * 2)
		.inputs(ore('boltSteel') * 64)
		.outputs(is.internal)
		.EUt(30)
		.duration(200)
		.buildAndRegister();

// steam freight car
tag = new TagCompound();

tag.setString("defID", "rolling_stock/freight/usra_boxcar_classrr40.json");
tag.setFloat("gauge", (float) Gauges.STANDARD);

is = new cam72cam.mod.item.ItemStack(IRItems.ITEM_ROLLING_STOCK, 1);
is.setTagCompound(tag);

SuSyRecipeMaps.RAILROAD_ENGINEERING_STATION_RECIPES.recipeBuilder()
		.circuitMeta(1)
		.inputs(metaitem('train_bogie') * 2)
		.inputs(ore('plateSteel') * 16)
		.inputs(ore('boltSteel') * 32)
		.outputs(is.internal)
		.EUt(30)
		.duration(200)
		.buildAndRegister();

// monorail trains (soldered)
Globals.solders.each { key, val ->
	// monorail locomotive
	tag = new TagCompound();

	tag.setString("defID", "rolling_stock/locomotives/monorail_engine.json");
	tag.setFloat("gauge", (float) Gauges.STANDARD);

	is = new cam72cam.mod.item.ItemStack(IRItems.ITEM_ROLLING_STOCK, 1);
	is.setTagCompound(tag);

	SuSyRecipeMaps.RAILROAD_ENGINEERING_STATION_RECIPES.recipeBuilder()
			.circuitMeta(1)
			.inputs(item('gregtech:boiler_casing', 1) * 2)
			.inputs(ore('gearSmallSteel') * 12)
			.inputs(metaitem('minecart_wheels.steel') * 4)
			.inputs(metaitem('electric.motor.lv') * 4)
			.inputs(metaitem('electric.piston.lv') * 4)
			.inputs(item('gregtech:boiler_firebox_casing', 1) * 2)
			.inputs(item('minecraft:glass') * 4)
			.inputs(ore('plateSteel') * 16)
			.inputs(ore('stickLongSteel') * 8)
			.fluidInputs(fluid(key) * (val * 10))
			.outputs(is.internal)
			.EUt(30)
			.duration(400)
			.buildAndRegister();

	// monorail freight car
	TagCompound tag2 = new TagCompound();

	tag2.setString("defID", "rolling_stock/freight/monorail_item.json");
	tag2.setFloat("gauge", (float) Gauges.STANDARD);

	cam72cam.mod.item.ItemStack is2 = new cam72cam.mod.item.ItemStack(IRItems.ITEM_ROLLING_STOCK, 1);
	is2.setTagCompound(tag2);

	SuSyRecipeMaps.RAILROAD_ENGINEERING_STATION_RECIPES.recipeBuilder()
			.circuitMeta(2)
			.inputs(ore('gearSmallSteel') * 12)
			.inputs(metaitem('minecart_wheels.steel') * 4)
			.inputs(ore('plateSteel') * 16)
			.inputs(ore('stickLongSteel') * 8)
			.fluidInputs(fluid(key) * (val * 10))
			.outputs(is2.internal)
			.EUt(30)
			.duration(400)
			.buildAndRegister();

	TagCompound tag3 = new TagCompound();

	// monorail passenger car
	tag3.setString("defID", "rolling_stock/passenger/monorail_passenger.json");
	tag3.setFloat("gauge", (float) Gauges.STANDARD);

	cam72cam.mod.item.ItemStack is3 = new cam72cam.mod.item.ItemStack(IRItems.ITEM_ROLLING_STOCK, 1);
	is3.setTagCompound(tag3);

	SuSyRecipeMaps.RAILROAD_ENGINEERING_STATION_RECIPES.recipeBuilder()
			.circuitMeta(3)
			.inputs(ore('gearSmallSteel') * 12)
			.inputs(metaitem('minecart_wheels.steel') * 4)
			.inputs(ore('plateSteel') * 20)
			.inputs(ore('stickLongSteel') * 6)
			.inputs(item('minecraft:glass') * 4)
			.fluidInputs(fluid(key) * (val * 10))
			.outputs(is3.internal)
			.EUt(30)
			.duration(400)
			.buildAndRegister();

	TagCompound tag4 = new TagCompound();

	// monorail fluid car
	tag4.setString("defID", "rolling_stock/tank/monorail_fluid.json");
	tag4.setFloat("gauge", (float) Gauges.STANDARD);

	cam72cam.mod.item.ItemStack is4 = new cam72cam.mod.item.ItemStack(IRItems.ITEM_ROLLING_STOCK, 1);
	is4.setTagCompound(tag4);

	SuSyRecipeMaps.RAILROAD_ENGINEERING_STATION_RECIPES.recipeBuilder()
			.circuitMeta(4)
			.inputs(ore('gearSmallSteel') * 12)
			.inputs(metaitem('minecart_wheels.steel') * 4)
			.inputs(ore('plateSteel') * 16)
			.inputs(ore('stickLongSteel') * 8)
			.inputs(metaitem('electric.pump.lv') * 2)
			.fluidInputs(fluid(key) * (val * 10))
			.outputs(is4.internal)
			.EUt(30)
			.duration(400)
			.buildAndRegister();
}