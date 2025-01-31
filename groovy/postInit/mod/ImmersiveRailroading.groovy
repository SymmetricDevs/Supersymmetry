
import cam72cam.immersiverailroading.IRItems
import cam72cam.mod.serialization.TagCompound
import globals.Globals
import supersymmetry.api.recipes.SuSyRecipeMaps
import trackapi.lib.Gauges

log.infoMC("Running ImmersiveRailroading.groovy...")

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
		.buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
		.fluidInputs(fluid('concrete') * 144)
		.inputs(ore('stickSteel') * 8)
		.inputs(ore('plateSteel') * 2)
		.outputs(item('susy:meta_item', 5) * 2)
		.duration(200)
		.EUt(30)
		.buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
		.fluidInputs(fluid('concrete') * 144)
		.inputs(ore('stickAluminium') * 8)
		.inputs(ore('plateAluminium') * 2)
		.outputs(item('susy:meta_item', 5) * 4)
		.duration(200)
		.EUt(120)
		.buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
		.fluidInputs(fluid('concrete') * 144)
		.inputs(ore('stickStainlessSteel') * 8)
		.inputs(ore('plateStainlessSteel') * 2)
		.outputs(item('susy:meta_item', 5) * 8)
		.duration(200)
		.EUt(480)
		.buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
		.inputs(metaitem('component.grinder.diamond') * 4)
		.inputs(ore('gearSteel') * 4)
		.inputs(ore('plateDoubleSteel') * 16)
		.outputs(metaitem('tunnelbore.drillhead'))
		.duration(200)
		.EUt(120)
		.buildAndRegister()

mods.gregtech.forge_hammer.recipeBuilder()
		.inputs(ore('stickLongSteel') * 16)
		.outputs(metaitem('tunnelbore.axle'))
		.duration(200)
		.EUt(120)
		.buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
		.inputs(metaitem('electric.motor.mv') * 8)
		.inputs(ore('wireFineCopper') * 64)
		.inputs(ore('gearAluminium') * 4)
		.inputs(ore('gearSmallAluminium') * 4)
		.inputs(ore('plateSteel') * 8)
		.fluidInputs(fluid('lubricant') * 8000)
		.outputs(metaitem('tunnelbore.engine'))
		.duration(200)
		.EUt(120)
		.buildAndRegister()
		
Globals.solders.each { key, val ->

	TagCompound tag = new TagCompound();

	tag.setString("defID", "rolling_stock/locomotives/monorail_engine.json");
	tag.setFloat("gauge", (float) Gauges.STANDARD);

	cam72cam.mod.item.ItemStack is = new cam72cam.mod.item.ItemStack(IRItems.ITEM_ROLLING_STOCK, 1);
	is.setTagCompound(tag);

	SuSyRecipeMaps.RAILROAD_ENGINEERING_STATION_RECIPES.recipeBuilder()
			.circuitMeta(1)
			.inputs(item('gregtech:boiler_casing', 1) * 2)
			.inputs(ore('gearSmallSteel') * 12)
			.inputs(metaitem('minecart_wheels.steel') * 4)
			.inputs(metaitem('electric.motor.lv') * 4)
			.inputs(metaitem('electric.piston.lv') * 4)
			.inputs(item('gregtech:boiler_firebox_casing', 1) * 2)
			.inputs(ore('blockGlass') * 4)
			.inputs(ore('plateSteel') * 16)
			.inputs(ore('stickLongSteel') * 8)
			.fluidInputs(fluid(key) * (val * 10))
			.outputs(is.internal)
			.EUt(30)
			.duration(400)
			.buildAndRegister();

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
			.inputs(ore('blockGlass') * 4)
			.fluidInputs(fluid(key) * (val * 10))
			.outputs(is3.internal)
			.EUt(30)
			.duration(400)
			.buildAndRegister();

	TagCompound tag4 = new TagCompound();

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

	TagCompound tag5 = new TagCompound();

	tag5.setString("defID", "rolling_stock/tunnel_bore/black_mesa_tunnel_bore.json");
	tag5.setFloat("gauge", (float) Gauges.STANDARD);

	cam72cam.mod.item.ItemStack is5 = new cam72cam.mod.item.ItemStack(IRItems.ITEM_ROLLING_STOCK, 1);
	is5.setTagCompound(tag5);

	SuSyRecipeMaps.RAILROAD_ENGINEERING_STATION_RECIPES.recipeBuilder()
		.circuitMeta(5)
		.inputs(ore('gearSmallSteel') * 12)
		.inputs(metaitem('minecart_wheels.steel') * 4)
		.inputs(metaitem('electric.motor.lv') * 4)
		.inputs(metaitem('electric.piston.lv') * 4)
		.inputs(metaitem('battery_buffer.lv.4'))
		.inputs(metaitem('conveyor.module.lv') * 8)
		.inputs(metaitem('crate.steel'))
		.inputs(ore('plateSteel') * 16)
		.inputs(ore('stickLongSteel') * 8)
		.inputs(metaitem('tunnelbore.axle'))
		.inputs(metaitem('tunnelbore.drillhead'))
		.inputs(metaitem('tunnelbore.engine'))
		.fluidInputs(fluid(key) * (val * 10))
		.outputs(is5.internal)
		.EUt(30)
		.duration(400)
		.buildAndRegister();

}