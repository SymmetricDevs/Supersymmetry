println("Running IndustrialRenewal.groovy...")
/*

def weapons_factory = recipemap('assembler') // REPLACE WITH WEAPONS FACTORY AFTER RECIPE MAPS ARE FIXED

ArrayList<String> name_removals = [
		"industrialrenewal:prospecting_pan",
		"industrialrenewal:screwdrive",
		"industrialrenewal:steel_saw",
		"industrialrenewal:cargo_container",
		"industrialrenewal:cart_hopper",
		"industrialrenewal:fluid_container",
		"industrialrenewal:small_slabs",
		"industrialrenewal:medkit",
		"industrialrenewal:fire_extinguisher",
		"industrialrenewal:coil_hv",
		"industrialrenewal:barrel_item",
		"industrialrenewal:firebox_solid",
		"industrialrenewal:firebox_fluid",
		"industrialrenewal:battery",
		"industrialrenewal:battery_lithium",
		"industrialrenewal:motor",
		"industrialrenewal:small_wind_blade",
		"industrialrenewal:drill_steel",
		"industrialrenewal:drill_diamond",
		"industrialrenewal:drill_deep",
		"industrialrenewal:concrete",
		"industrialrenewal:frame",
		"industrialrenewal:catwalk_hatch",
		"industrialrenewal:bunker_hatch",
		"industrialrenewal:hazard_block",
		"industrialrenewal:aisle_hazard",
		"industrialrenewal:caution_hazard",
		"industrialrenewal:defective_hazard",
		"industrialrenewal:fire_hazard",
		"industrialrenewal:radiation_hazard",
		"industrialrenewal:safety_hazard",
		"industrialrenewal:handrail",
		"industrialrenewal:handrail_steel",
		"industrialrenewal:catwalk_pillar_steel",
		"industrialrenewal:catwalk_column_steel",
		"industrialrenewal:brace",
		"industrialrenewal:brace_steel",
		"industrialrenewal:lathe",
		"industrialrenewal:electric_pump",
		"industrialrenewal:fuse_box",
		"industrialrenewal:catwalk_ladder",
		"industrialrenewal:catwalk_gate",
		"industrialrenewal:catwalk_pillar",
		"industrialrenewal:catwalk_column",
		"industrialrenewal:catwalk_ladder_steel",
		"industrialrenewal:entity_detector",
		"industrialrenewal:sensor_rain",
		"industrialrenewal:signal_indicator",
		"industrialrenewal:traffic_light",
		"industrialrenewal:chimney_block",
		"industrialrenewal:electric_fence",
		"industrialrenewal:fence_big_column",
		"industrialrenewal:fence_big_wire",
		"industrialrenewal:electric_gate",
		"industrialrenewal:solar_panel"
];

for (item in name_removals) {
	crafting.remove(item);
}

def soldering_alloys = [
		liquid('tin') * 144,
		liquid('soldering_alloy') * 72
]

crafting.addShaped("irw_screwdriver", item('industrialrenewal:screwdrive'), [
		[ore('stickSteel'), ore('plateSteel'), metaitem('electric.motor.lv')],
		[null, ore('gregScrewDrivers'), ore('stickSteel')],
		[null, ore('gregWrenches'), ore('stickSteel')]
]);
/*
crafting.addShaped("irw_saw", item('industrialrenewal:steel_saw'), [
	[ore('plateIron'), ore('plateSteel'), null],
	[ore('plateIron'), ore('plateSteel'), null],
	[ore('stickWood'), ore('stickWood'), null]
]);
*/
/*
crafting.addShaped("irw_linker", item('industrialrenewal:cart_linkable'), [
		[null, ore('plateSteel'), ore('plateSteel')],
		[null, null, ore('plateSteel')],
		[null, null, ore('stickLongSteel')]
]);

crafting.addShaped("irw_container", item('industrialrenewal:cargo_container'), [
		[ore('screwSteel'), ore('gregScrewDrivers'), ore('screwSteel')],
		[ore('plateSteel'), ore('chest'), ore('plateSteel')],
		[ore('plateSteel'), item('industrialrenewal:minecart_flat'), ore('plateSteel')]
]);

crafting.addShaped("irw_hopper", item('industrialrenewal:cart_hopper'), [
		[ore('screwSteel'), ore('gregScrewDrivers'), ore('screwSteel')],
		[ore('plateSteel'), ore('blockHopper'), ore('plateSteel')],
		[ore('plateSteel'), item('industrialrenewal:minecart_flat'), ore('plateSteel')]
]);

crafting.addShaped("irw_tank_cart", item('industrialrenewal:fluid_container'), [
		[ore('screwSteel'), ore('gregScrewDrivers'), ore('screwSteel')],
		[ore('stickSteel'), item('industrialrenewal:barrel_item'), ore('stickSteel')],
		[null, item('industrialrenewal:minecart_flat'), null]
]);

crafting.addShaped("irw_small_slabs", item('industrialrenewal:small_slab')*24, [
		[ore('slabStone'), ore('slabStone'), ore('slabStone')],
		[null, null, null],
		[null, null, null]
]);

crafting.addShaped("irw_barrel", item('industrialrenewal:barrel_item')*2, [
		[ore('plateIron'), item('industrialrenewal:small_slab'), ore('plateIron')],
		[ore('plateIron'), null, ore('plateIron')],
		[ore('plateIron'), item('industrialrenewal:small_slab'), ore('plateIron')]
]);

crafting.addShaped("irw_motor", item('industrialrenewal:motor'), [
		[ore('plateSteel'), ore('plateSteel'), ore('plateSteel')],
		[ore('gearSteel'), metaitem('electric.motor.lv'), ore('wireFineCopper')],
		[ore('plateSteel'), ore('plateSteel'), ore('plateSteel')]
]);

crafting.addShaped("irw_wind_blade", item('industrialrenewal:small_wind_blade'), [
		[ore('plateIron'), ore('stickSteel'), ore('plateIron')],
		[ore('stickSteel'), ore('plateSteel'), ore('stickSteel')],
		[ore('plateIron'), ore('stickSteel'), ore('plateIron')]
]);

crafting.addShaped("irw_frame", item('industrialrenewal:frame')*6, [
		[ore('stickSteel'), ore('stickSteel'), ore('stickSteel')],
		[null, ore('stickSteel'), null],
		[ore('stickSteel'), ore('stickSteel'), ore('stickSteel')]
]);

crafting.addShaped("irw_catwalk_hatch", item('industrialrenewal:catwalk_hatch'), [
		[ore('plateSteel'), item('minecraft:iron_trapdoor'), ore('plateSteel')],
		[ore('stickSteel'), item('minecraft:ladder'), ore('stickSteel')],
		[ore('stickSteel'), ore('stickSteel'), ore('stickSteel')]
]);

crafting.addShaped("irw_bunker_hatch", item('industrialrenewal:bunker_hatch'), [
		[item('industrialrenewal:small_slab'), item('industrialrenewal:small_slab'), item('industrialrenewal:small_slab')],
		[ore('plateSteel'), ore('stickSteel'), ore('plateSteel')],
		[item('industrialrenewal:small_slab'), item('industrialrenewal:small_slab'), item('industrialrenewal:small_slab')]
]);

crafting.addShaped("irw_steel_drill", item('industrialrenewal:drill_steel'), [
		[null, ore('stickSteel'), null],
		[ore('plateSteel'), ore('plateSteel'), ore('plateSteel')],
		[ore('plateSteel'), metaitem('toolHeadDrillSteel'), ore('plateSteel')]
]);

crafting.addShaped("irw_diamond_drill", item('industrialrenewal:drill_diamond'), [
		[null, ore('stickSteel'), null],
		[ore('plateSteel'), ore('plateSteel'), ore('plateSteel')],
		[ore('plateDiamond'), metaitem('toolHeadDrillSteel'), ore('plateDiamond')]
]);

crafting.addShaped("irw_hazard_block", item('industrialrenewal:block_hazard')*32, [
		[ore('plateIron'), ore('plateIron'), ore('plateIron')],
		[ore('dyeYellow'), null, ore('dyeBlack')],
		[ore('plateIron'), ore('plateIron'), ore('plateIron')]
]);

crafting.addShaped("irw_hazard_block1", item('industrialrenewal:aisle_hazard')*32, [
		[ore('plateIron'), ore('plateIron'), ore('plateIron')],
		[ore('dyeBlack'), null, ore('dyeWhite')],
		[ore('plateIron'), ore('plateIron'), ore('plateIron')]
]);

crafting.addShaped("irw_hazard_block2", item('industrialrenewal:caution_hazard')*32, [
		[ore('plateIron'), ore('plateIron'), ore('plateIron')],
		[ore('dyeOrange'), null, ore('dyeWhite')],
		[ore('plateIron'), ore('plateIron'), ore('plateIron')]
]);

crafting.addShaped("irw_hazard_block3", item('industrialrenewal:defective_hazard')*32, [
		[ore('plateIron'), ore('plateIron'), ore('plateIron')],
		[ore('dyeBlue'), null, ore('dyeWhite')],
		[ore('plateIron'), ore('plateIron'), ore('plateIron')]
]);

crafting.addShaped("irw_hazard_block4", item('industrialrenewal:fire_hazard')*32, [
		[ore('plateIron'), ore('plateIron'), ore('plateIron')],
		[ore('dyeRed'), null, ore('dyeWhite')],
		[ore('plateIron'), ore('plateIron'), ore('plateIron')]
]);

crafting.addShaped("irw_hazard_block5", item('industrialrenewal:radiation_hazard')*32, [
		[ore('plateIron'), ore('plateIron'), ore('plateIron')],
		[ore('dyeMagenta'), null, ore('dyeYellow')],
		[ore('plateIron'), ore('plateIron'), ore('plateIron')]
]);

crafting.addShaped("irw_hazard_block6", item('industrialrenewal:safety_hazard')*32, [
		[ore('plateIron'), ore('plateIron'), ore('plateIron')],
		[ore('dyeLime'), null, ore('dyeWhite')],
		[ore('plateIron'), ore('plateIron'), ore('plateIron')]
]);

crafting.addShaped("irw_iron_handrail", item('industrialrenewal:handrail')*8, [
		[ore('stickIron'), ore('stickIron'), ore('stickIron')],
		[ore('stickIron'), null, ore('stickIron')],
		[ore('stickIron'), ore('stickLongIron'), ore('stickIron')]
]);

crafting.addShaped("irw_iron_caged_ladder", item('industrialrenewal:catwalk_ladder')*6, [
		[ore('stickIron'), item('minecraft:ladder'), ore('stickIron')],
		[ore('stickIron'), item('minecraft:ladder'), ore('stickIron')],
		[ore('stickIron'), item('minecraft:ladder'), ore('stickIron')]
]);

crafting.addShaped("irw_steel_handrail", item('industrialrenewal:handrail_steel')*8, [
		[ore('stickSteel'), ore('stickSteel'), ore('stickSteel')],
		[ore('stickSteel'), null, ore('stickSteel')],
		[ore('stickSteel'), ore('stickLongSteel'), ore('stickSteel')]
]);

crafting.addShaped("irw_steel_caged_ladder", item('industrialrenewal:catwalk_ladder_steel')*6, [
		[ore('stickSteel'), item('minecraft:ladder'), ore('stickSteel')],
		[ore('stickSteel'), item('minecraft:ladder'), ore('stickSteel')],
		[ore('stickSteel'), item('minecraft:ladder'), ore('stickSteel')]
]);

crafting.addShaped("irw_pillar", item('industrialrenewal:catwalk_steel_pillar')*24, [
		[ore('plateSteel'), null, ore('plateSteel')],
		[ore('plateSteel'), ore('plateSteel'), ore('plateSteel')],
		[ore('plateSteel'), null, ore('plateSteel')]
]);

crafting.addShaped("irw_pillar1", item('industrialrenewal:catwalk_column_steel')*24, [
		[ore('plateSteel'), ore('plateSteel'), ore('plateSteel')],
		[null, ore('plateSteel'), null],
		[ore('plateSteel'), ore('plateSteel'), ore('plateSteel')]
]);

crafting.addShaped("irw_pillar2", item('industrialrenewal:brace_steel')*24, [
		[ore('plateSteel'), ore('stickSteel'), null],
		[ore('stickSteel'), ore('plateSteel'), ore('stickSteel')],
		[null, ore('stickSteel'), ore('plateSteel')]
]);

crafting.addShaped("irw_pump", item('industrialrenewal:electric_pump'), [
		[null, ore('pipeMediumCopper'), ore('plateSteel')],
		[item('industrialrenewal:motor'), ore('stickSteel'), ore('plateSteel')],
		[null, ore('pipeMediumCopper'), ore('plateSteel')]
]);

crafting.addShaped("irw_fusebox", item('industrialrenewal:fuse_box'), [
		[ore('stickSteel'), ore('wireFineRedAlloy'), ore('stickSteel')],
		[ore('stickSteel'), ore('chest'), ore('stickSteel')],
		[ore('stickSteel'), ore('wireFineRedAlloy'), ore('stickSteel')]
]);

crafting.addShaped("irw_catwalk_gate", item('industrialrenewal:catwalk_gate')*2, [
		[ore('stickIron'), ore('stickLongIron'), ore('stickIron')],
		[ore('stickIron'), ore('stickLongIron'), ore('stickIron')],
		[ore('stickIron'), null, ore('stickIron')]
]);

crafting.addShaped("irw_pillar_iron1", item('industrialrenewal:catwalk_pillar')*24, [
		[ore('plateIron'), ore('stickIron'), ore('plateIron')],
		[ore('plateIron'), ore('stickIron'), ore('plateIron')],
		[ore('plateIron'), ore('stickIron'), ore('plateIron')]
]);

crafting.addShaped("irw_pillar_iron2", item('industrialrenewal:catwalk_pillar')*24, [
		[ore('plateIron'), ore('plateIron'), ore('plateIron')],
		[ore('stickIron'), ore('stickIron'), ore('stickIron')],
		[ore('plateIron'), ore('plateIron'), ore('plateIron')]
]);

crafting.addShaped("irw_pillar_brace", item('industrialrenewal:brace')*24, [
		[ore('stickIron'), ore('plateIron'), null],
		[ore('plateIron'), ore('stickIron'), ore('plateIron')],
		[null, ore('plateIron'), ore('stickIron')]
]);

crafting.addShaped("irw_rain_sensor", item('industrialrenewal:sensor_rain'), [
		[null, ore('plateSteel'), null],
		[ore('plateSteel'), ore('wireFineRedAlloy'), ore('plateSteel')],
		[ore('minislabStone'), ore('minislabStone'), ore('minislabStone')]
]);

crafting.addShaped("irw_signal_indicator", item('industrialrenewal:signal_indicator'), [
		[null, ore('craftingRedstoneTorch'), null],
		[null, ore('stickIron'), null],
		[null, ore('plateIron'), null]
]);

crafting.addShaped("irw_traffic_light", item('industrialrenewal:traffic_light'), [
		[ore('plateSteel'), ore('circuitUlv'), ore('dyeRed')],
		[ore('wireFineRedAlloy'), ore('circuitUlv'), ore('dyeYellow')],
		[ore('plateSteel'), ore('circuitUlv'), ore('dyeGreen')]
]);

crafting.addShaped("irw_chimney", item('industrialrenewal:block_chimney'), [
		[ore('plateSteel'), ore('pipeMediumSteel'), ore('plateSteel')],
		[ore('plateSteel'), ore('pipeMediumSteel'), ore('plateSteel')],
		[ore('plateSteel'), ore('plateSteel'), ore('plateSteel')]
]);

crafting.addShaped("irw_electric_fence", item('industrialrenewal:electric_fence')*16, [
		[ore('wireGtSingleSteel'), ore('stickSteel'), ore('wireGtSingleSteel')],
		[ore('wireGtSingleSteel'), ore('stickSteel'), ore('wireGtSingleSteel')]
]);

crafting.addShaped("irw_electric_fence_big", item('industrialrenewal:fence_big_column')*16, [
		[ore('stickSteel'), ore('wireGtSingleSteel'), ore('stickSteel')],
		[ore('stickSteel'), ore('wireGtSingleSteel'), ore('stickSteel')],
		[ore('stickSteel'), ore('wireGtSingleSteel'), ore('stickSteel')]
]);

crafting.addShaped("irw_big_wire", item('industrialrenewal:fence_big_wire')*16, [
		[null, ore('wireGtSingleSteel'), null],
		[null, ore('wireGtSingleSteel'), null],
		[ore('wireGtSingleSteel'), ore('stickSteel'), ore('wireGtSingleSteel')]
]);

crafting.addShaped("irw_electric_gate", item('industrialrenewal:electric_gate'), [
		[ore('stickSteel'), ore('wireGtSingleSteel'), ore('stickSteel')],
		[ore('stickSteel'), ore('wireGtSingleSteel'), ore('stickSteel')]
]);

mods.gregtech.canner.recipeBuilder().EUt(30).duration(20)
		.inputs(item('techguns:itemshared:24'))
		.fluidInputs(liquid('carbon_dioxide')*1000)
		.outputs(item('industrialrenewal:item_fire_extinguisher'))
		.buildAndRegister();

for (solder in soldering_alloys) {
	mods.gregtech.assembler.recipeBuilder().EUt(30).duration(20)
			.inputs(metaitem('sensor.lv'))
			.inputs(ore('wireFineRedAlloy')*4)
			.inputs(ore('stickSteel'))
			.fluidInputs(solder)
			.outputs(item('industrialrenewal:entity_detector'))
			.buildAndRegister();
}
*/