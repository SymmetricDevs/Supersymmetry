import static globals.Globals.*

def name_removals = [
	"industrialrenewal:prospecting_pan",
	"industrialrenewal:ingot_steel",
	"industrialrenewal:steel_saw",
	"industrialrenewal:lathe",
	"industrialrenewal:sensor_rain",
	"industrialrenewal:brace",
	"industrialrenewal:small_slabs",
	"industrialrenewal:coil_hv",
	"industrialrenewal:energy_cable_lv",
	"industrialrenewal:energy_cable",
	"industrialrenewal:energy_cable2",
	"industrialrenewal:energy_cable_hv",
	"industrialrenewal:energy_cable_hv2",
	"industrialrenewal:fluid_pipe",
	"industrialrenewal:cable_tray",
	"industrialrenewal:isolator_hv",
	"industrialrenewal:alarm",
	"industrialrenewal:entity_detector",
	"industrialrenewal:transformer_hv",
	"industrialrenewal:trash",
	"industrialrenewal:electric_pump",
	"industrialrenewal:record_royal_entrance",
	"industrialrenewal:motor",
	"industrialrenewal:dam_turbine",
	"industrialrenewal:dam_axis",
	"industrialrenewal:dam_generator",
	"industrialrenewal:high_pressure_pipe",
	"industrialrenewal:fluid_tank",
	"industrialrenewal:fire_extinguisher",
	"industrialrenewal:conveyor_bulk"
]

for (name in name_removals) {
	crafting.remove(name)
}

crafting.replaceShaped("industrialrenewal:screwdrive", item('industrialrenewal:screwdrive'), [
	[ore('screwSteel'), ore('stickSteel'), metaitem('electric.motor.lv')],
	[null, item('minecraft:stone_button'), ore('plateSteel')],
	[ore('craftingToolScrewdriver'), ore('craftingToolWrench'), ore('batteryLv')]
])

crafting.replaceShaped("industrialrenewal:catwalk_pillar_steel", item('industrialrenewal:catwalk_steel_pillar') * 32, [
	[ore('stickLongSteel'), ore('plateSteel'), ore('stickLongSteel')],
	[ore('stickLongSteel'), ore('plateSteel'), ore('stickLongSteel')],
	[ore('stickLongSteel'), ore('plateSteel'), ore('stickLongSteel')]
])

crafting.replaceShaped("industrialrenewal:catwalk_column_steel", item('industrialrenewal:catwalk_column_steel'), [
	[item('industrialrenewal:catwalk_steel_pillar'), null, null],
	[null, null, null],
	[null, null, null]
])

crafting.replaceShaped("industrialrenewal:brace_steel", item('industrialrenewal:brace_steel') * 32, [
	[ore('plateSteel'), ore('stickSteel'), null],
	[ore('stickSteel'), ore('plateSteel'), ore('stickSteel')],
	[null, ore('stickSteel'), ore('plateSteel')]
])

crafting.replaceShaped("industrialrenewal:catwalk_pillar", item('industrialrenewal:catwalk_pillar') * 32, [
	[ore('stickLongSteel'), ore('stickSteel'), ore('stickLongSteel')],
	[ore('stickLongSteel'), ore('stickSteel'), ore('stickLongSteel')],
	[ore('stickLongSteel'), ore('stickSteel'), ore('stickLongSteel')]
])

crafting.replaceShaped("industrialrenewal:catwalk_column", item('industrialrenewal:catwalk_column') * 32, [
	[ore('plateSteel'), ore('plateSteel'), ore('plateSteel')],
	[ore('stickSteel'), ore('stickSteel'), ore('stickSteel')],
	[ore('plateSteel'), ore('plateSteel'), ore('plateSteel')]
])

crafting.replaceShaped("industrialrenewal:electric_fence", item('industrialrenewal:electric_fence') * 16, [
	[null, null, null],
	[ore('wireGtSingleSteel'), ore('stickSteel'), ore('wireGtSingleSteel')],
	[ore('wireGtSingleSteel'), ore('stickSteel'), ore('wireGtSingleSteel')]
])

crafting.replaceShaped("industrialrenewal:electric_gate", item('industrialrenewal:electric_gate') * 4, [
	[null, null, null],
	[ore('stickSteel'), ore('wireGtSingleSteel'), ore('stickSteel')],
	[ore('stickSteel'), ore('wireGtSingleSteel'), ore('stickSteel')]
])

crafting.replaceShaped("industrialrenewal:bunkbed", item('industrialrenewal:bunkbed'), [
	[null, null, null],
	[ore('frameGtSteel'), item('minecraft:bed', 14), ore('frameGtSteel')],
	[null, null, null]
])

crafting.replaceShaped("industrialrenewal:record_player", item('industrialrenewal:record_player'), [
	[ore('plateGlass'), ore('plateGlass'), ore('plateGlass')],
	[ore('plateGlass'), ore('stickIron'), ore('plateGlass')],
	[ore('plateWood'), item('minecraft:jukebox'), ore('plateWood')]
])

crafting.replaceShaped("industrialrenewal:locker", item('industrialrenewal:locker'), [
	[ore('plateSteel'), ore('plateSteel'), ore('boltSteel')],
	[ore('plateSteel'), ore('chestWood'), ore('stickSteel')],
	[ore('plateSteel'), ore('plateSteel'), ore('boltSteel')]
])

crafting.replaceShaped("industrialrenewal:hazard_block", item('industrialrenewal:block_hazard') * 32, [
	[ore('plateIron'), ore('plateIron'), ore('plateIron')],
	[ore('dyeYellow'), null, ore('dyeBlack')],
	[ore('plateIron'), ore('plateIron'), ore('plateIron')]
])

crafting.replaceShaped("industrialrenewal:aisle_hazard", item('industrialrenewal:aisle_hazard') * 32, [
	[ore('plateIron'), ore('plateIron'), ore('plateIron')],
	[ore('dyeBlack'), null, ore('dyeWhite')],
	[ore('plateIron'), ore('plateIron'), ore('plateIron')]
])

crafting.replaceShaped("industrialrenewal:caution_hazard", item('industrialrenewal:caution_hazard') * 32, [
	[ore('plateIron'), ore('plateIron'), ore('plateIron')],
	[ore('dyeOrange'), null, ore('dyeWhite')],
	[ore('plateIron'), ore('plateIron'), ore('plateIron')]
])

crafting.replaceShaped("industrialrenewal:defective_hazard", item('industrialrenewal:defective_hazard') * 32, [
	[ore('plateIron'), ore('plateIron'), ore('plateIron')],
	[ore('dyeBlue'), null, ore('dyeWhite')],
	[ore('plateIron'), ore('plateIron'), ore('plateIron')]
])

crafting.replaceShaped("industrialrenewal:fire_hazard", item('industrialrenewal:fire_hazard') * 32, [
	[ore('plateIron'), ore('plateIron'), ore('plateIron')],
	[ore('dyeRed'), null, ore('dyeWhite')],
	[ore('plateIron'), ore('plateIron'), ore('plateIron')]
])

crafting.replaceShaped("industrialrenewal:radiation_hazard", item('industrialrenewal:radiation_hazard') * 32, [
	[ore('plateIron'), ore('plateIron'), ore('plateIron')],
	[ore('dyeMagenta'), null, ore('dyeYellow')],
	[ore('plateIron'), ore('plateIron'), ore('plateIron')]
])

crafting.replaceShaped("industrialrenewal:safety_hazard", item('industrialrenewal:safety_hazard') * 32, [
	[ore('plateIron'), ore('plateIron'), ore('plateIron')],
	[ore('dyeLime'), null, ore('dyeWhite')],
	[ore('plateIron'), ore('plateIron'), ore('plateIron')]
])

crafting.replaceShaped("industrialrenewal:fuse_box", item('industrialrenewal:fuse_box'), [
	[ore('plateSteel'), ore('wireFineRedAlloy'), ore('plateSteel')],
	[ore('plateSteel'), ore('chest'), item('minecraft:lever')],
	[ore('plateSteel'), ore('wireFineRedAlloy'), ore('plateSteel')]
])

crafting.replaceShaped("industrialrenewal:flame_detector", item('industrialrenewal:flame_detector'), [
	[null, ore('plateSteel'), null],
	[ore('stickSteel'), ore('frameGtSteel'), null],
	[null, item('minecraft:daylight_detector'), null]
])

crafting.replaceShaped("industrialrenewal:bunker_hatch", item('industrialrenewal:bunker_hatch'), [
	[item('minecraft:stone_slab'), item('minecraft:stone_slab'), item('minecraft:stone_slab')],
	[item('techguns:item_bunkerdoor'), null, item('techguns:item_bunkerdoor')],
	[item('minecraft:stone_slab'), item('minecraft:stone_slab'), item('minecraft:stone_slab')]
])

crafting.replaceShaped("industrialrenewal:sign_hv", item('industrialrenewal:sign_hv') * 5, [
	[null, item('minecraft:sign'), null],
	[null, ore('stickSteel'), null],
	[ore('plateSteel'), ore('stickSteel'), ore('plateSteel')]
])

crafting.replaceShaped("industrialrenewal:fence_big_column", item('industrialrenewal:fence_big_column')*16, [
		[ore('stickSteel'), ore('wireGtSingleSteel'), ore('stickSteel')],
		[ore('stickSteel'), ore('wireGtSingleSteel'), ore('stickSteel')],
		[ore('stickSteel'), ore('wireGtSingleSteel'), ore('stickSteel')]
])

crafting.replaceShaped("industrialrenewal:fence_big_wire", item('industrialrenewal:fence_big_wire')*16, [
		[null, ore('wireGtSingleSteel'), null],
		[null, ore('wireGtSingleSteel'), null],
		[ore('wireGtSingleSteel'), ore('stickSteel'), ore('wireGtSingleSteel')]
])

crafting.replaceShaped("industrialrenewal:razor_wire", item('industrialrenewal:razor_wire') * 4, [
	[null, null, null],
	[ore('wireFineSteel'), ore('wireFineSteel'), ore('wireFineSteel')],
	[ore('stickSteel'), null, ore('stickSteel')]
])

crafting.replaceShaped("industrialrenewal:barrel_item", item('industrialrenewal:barrel_item'), [
	[null, ore('craftingToolWrench'), null],
	[ore('plateSteel'), ore('stickLongSteel'), ore('plateSteel')],
	[ore('plateSteel'), ore('stickLongSteel'), ore('plateSteel')]
])

crafting.replaceShaped("industrialrenewal:small_wind_turbine", item('industrialrenewal:small_wind_turbine'), [
	[ore('plateAluminium'), ore('plateAluminium'), ore('craftingToolHardHammer')],
	[ore('plateAluminium'), metaitem('electric.motor.mv'), ore('boltAluminium')],
	[ore('plateAluminium'), ore('plateAluminium'), ore('craftingToolWrench')]
])

crafting.replaceShaped("industrialrenewal:small_wind_turbine_pillar", item('industrialrenewal:small_wind_turbine_pillar') * 6, [
	[ore('plateAluminium'), ore('stickLongAluminium'), ore('craftingToolHardHammer')],
	[ore('plateAluminium'), ore('stickLongAluminium'), item('industrialrenewal:energy_level')],
	[ore('plateAluminium'), ore('stickLongAluminium'), ore('craftingToolWrench')]
])

crafting.replaceShaped("industrialrenewal:small_wind_blade", item('industrialrenewal:small_wind_blade'), [
	[null, ore('turbineBladeAluminium'), null],
	[ore('turbineBladeAluminium'), ore('gearAluminium'), ore('turbineBladeAluminium')],
	[null, ore('turbineBladeAluminium'), null]
])

crafting.replaceShaped("industrialrenewal:wall_concrete", item('industrialrenewal:wall_concrete') * 8, [
	[null, null, null],
	[ore('blockConcrete'), ore('blockConcrete'), ore('blockConcrete')],
	[ore('blockConcrete'), ore('blockConcrete'), ore('blockConcrete')]
])

crafting.replaceShaped("industrialrenewal:cartridge_plus", item('industrialrenewal:cartridge_plus') * 6, [
	[null, ore('stickIron'), null],
	[ore('wireFineRedAlloy'), ore('plateIron'), ore('wireFineRedAlloy')],
	[null, ore('stickIron'), null]
])

crafting.replaceShaped("industrialrenewal:dam_intake", item('industrialrenewal:dam_intake'), [
	[ore('blockConcrete'), ore('blockConcrete'), ore('blockConcrete')],
	[ore('barsIron'), null, null],
	[ore('blockConcrete'), ore('blockConcrete'), ore('blockConcrete')]
])

crafting.replaceShaped("industrialrenewal:dam_outflow", item('industrialrenewal:dam_outflow'), [
	[ore('blockConcrete'), ore('blockConcrete'), ore('blockConcrete')],
	[null, null, ore('barsIron')],
	[ore('blockConcrete'), ore('blockConcrete'), ore('blockConcrete')]
])

crafting.replaceShaped("industrialrenewal:catwalk_ladder", item('industrialrenewal:catwalk_ladder') * 6, [
	[ore('stickSteel'), item('techguns:ladder0', 8), ore('stickSteel')],
	[ore('dyeYellow'), item('techguns:ladder0', 8), ore('dyeBlack')],
	[ore('stickSteel'), item('techguns:ladder0', 8), ore('stickSteel')]
])

crafting.replaceShaped("industrialrenewal:catwalk_ladder_steel", item('industrialrenewal:catwalk_ladder_steel') * 6, [
	[ore('stickSteel'), item('techguns:ladder0', 8), ore('stickSteel')],
	[ore('stickSteel'), item('techguns:ladder0', 8), ore('stickSteel')],
	[ore('stickSteel'), item('techguns:ladder0', 8), ore('stickSteel')]
])

crafting.replaceShaped("industrialrenewal:catwalk_hatch", item('industrialrenewal:catwalk_hatch'), [
	[ore('boltSteel'), ore('plateSteel'), ore('boltSteel')],
	[ore('stickSteel'), item('techguns:ladder0', 8), ore('stickSteel')],
	[ore('stickSteel'), ore('stickSteel'), ore('stickSteel')]
])

crafting.replaceShaped("industrialrenewal:safety_helmet", item('industrialrenewal:safety_helmet'), [
	[null, ore('dyeYellow'), null],
	[ore('plateSteel'), ore('plateSteel'), ore('plateSteel')],
	[ore('plateSteel'), item('minecraft:leather_helmet'), ore('plateSteel')]
])

crafting.replaceShaped("industrialrenewal:gutter", item('industrialrenewal:gutter') * 6, [
	[null, null, null],
	[ore('plateStainlessSteel'), ore('plateStainlessSteel'), ore('plateStainlessSteel')],
	[ore('pipeTinyFluidStainlessSteel'), ore('pipeTinyFluidStainlessSteel'), ore('pipeTinyFluidStainlessSteel')]
])

crafting.replaceShaped("industrialrenewal:firebox_solid", item('industrialrenewal:firebox_solid'), [
	[null, ore('wireFineRedAlloy'), null],
	[ore('chest'), ore('pipeSmallItemTin'), metaitem('steam_boiler_coal_steel')],
	[null, ore('wireFineRedAlloy'), null]
])

crafting.replaceShaped("industrialrenewal:firebox_fluid", item('industrialrenewal:firebox_fluid'), [
	[null, ore('wireFineRedAlloy'), null],
	[metaitem('drum.steel'), metaitem('pipeSmallFluidSteel'), metaitem('steam_boiler_lava_steel')],
	[null, ore('wireFineRedAlloy'), null]
])

crafting.replaceShaped("industrialrenewal:roof", item('industrialrenewal:roof') * 6, [
	[ore('plateStainlessSteel'), ore('plateStainlessSteel'), null],
	[null, ore('plateStainlessSteel'), ore('plateStainlessSteel')],
	[ore('stickStainlessSteel'), ore('stickStainlessSteel'), ore('stickStainlessSteel')]
])

crafting.replaceShaped("industrialrenewal:frame", item('industrialrenewal:frame') * 6, [
	[ore('stickSteel'), ore('stickSteel'), ore('stickSteel')],
	[null, ore('frameGtSteel'), null],
	[ore('stickSteel'), ore('stickSteel'), ore('stickSteel')]
])

crafting.replaceShaped("industrialrenewal:conduit_connector", item('industrialrenewal:conduit_connector'), [
	[null, ore('stickSteel'), null],
	[null, ore('wireFineRedAlloy'), null],
	[ore('stickSteel'), ore('wireFineRedAlloy'), ore('stickSteel')]
])

crafting.replaceShaped("industrialrenewal:conduit_extension", item('industrialrenewal:conduit_extension') * 6, [
	[null, ore('stickSteel'), null],
	[null, ore('wireFineRedAlloy'), null],
	[null, ore('stickSteel'), null]
])

crafting.replaceShaped("industrialrenewal:button_red", item('industrialrenewal:button_red'), [
	[null, ore('dyeRed'), null],
	[null, item('minecraft:stone_button'), null],
	[ore('dyeYellow'), ore('plateSteel'), ore('dyeYellow')]
])

crafting.addShaped("industrialrenewal:brace_greg", item('industrialrenewal:brace') * 32, [
	[ore('stickSteel'), ore('stickLongSteel'), null],
	[ore('stickLongSteel'), ore('stickSteel'), ore('stickLongSteel')],
	[null, ore('stickLongSteel'), ore('stickSteel')]
])

crafting.addShaped("industrialrenewal:column_to_pillar", item('industrialrenewal:catwalk_steel_pillar'), [
	[item('industrialrenewal:catwalk_column_steel'), null, null],
	[null, null, null],
	[null, null, null]
])

crafting.addShaped("industrialrenewal:alarm_custom", item('industrialrenewal:alarm'), [
	[null, ore('stickSteel'), null],
	[ore('stickSteel'), item('industrialrenewal:alarm'), ore('stickSteel')],
	[null, ore('stickSteel'), null]
])

mods.gregtech.assembler.recipeBuilder()
	.inputs(metaitem('large_fluid_cell.steel'))
	.inputs(metaitem('electric.pump.lv'))
	.inputs(ore('ringRubber'))
	.fluidInputs(fluid('compressed_carbon_dioxide') * 8000)
	.outputs(item('industrialrenewal:item_fire_extinguisher'))
	.duration(20)
	.EUt(Globals.voltAmps[1])
	.buildAndRegister()

Globals.solders.each { key, val ->
	mods.gregtech.assembler.recipeBuilder()
		.inputs(metaitem('sensor.lv'))
		.inputs(ore('wireFineRedAlloy')*4)
		.inputs(ore('stickSteel') * 2)
		.fluidInputs(fluid(key) * val)
		.outputs(item('industrialrenewal:entity_detector'))
		.duration(20)
		.EUt(Globals.voltAmps[1])
		.buildAndRegister()

	mods.gregtech.assembler.recipeBuilder()
		.inputs(item('gregtech:turbine_casing', 5) * 8)
		.inputs(ore('stickLongSteel') * 4)
		.inputs(item('industrialrenewal:high_pressure_pipe') * 2)
		.inputs(ore('plateSteel') * 6)
		.inputs(ore('turbineBladeSteel') * 8)
		.fluidInputs(fluid(key) * val)
		.outputs(item('industrialrenewal:dam_turbine'))
		.duration(400)
		.EUt(Globals.voltAmps[2])
		.buildAndRegister()

	mods.gregtech.assembler.recipeBuilder()
		.inputs(item('gregtech:turbine_casing', 5) * 8)
		.inputs(ore('stickLongSteel') * 4)
		.inputs(ore('circuitHv') * 2)
		.inputs(ore('plateSteel') * 6)
		.inputs(metaitem('electric.motor.hv'))
		.fluidInputs(fluid(key) * val)
		.outputs(item('industrialrenewal:dam_generator'))
		.duration(400)
		.EUt(Globals.voltAmps[2])
		.buildAndRegister()

	mods.gregtech.assembler.recipeBuilder()
		.inputs(ore('stickLongMagnalium') * 6)
		.inputs(ore('ringSteel'))
		.fluidInputs(fluid(key) * val)
		.outputs(item('industrialrenewal:dam_axis'))
		.duration(200)
		.EUt(Globals.voltAmps[2])
		.buildAndRegister()

	mods.gregtech.assembler.recipeBuilder()
		.inputs(ore('pipeLargeFluidStainlessSteel'))
		.inputs(ore('boltSteel') * 8)
		.inputs(ore('ringSteel'))
		.fluidInputs(fluid(key) * val)
		.outputs(item('industrialrenewal:high_pressure_pipe'))
		.duration(100)
		.EUt(Globals.voltAmps[1])
		.buildAndRegister()

	mods.gregtech.assembler.recipeBuilder()
		.inputs(metaitem('drum.steel') * 8)
		.inputs(ore('plateSteel') * 6)
		.inputs(item('industrialrenewal:catwalk_pillar') * 4)
		.inputs(item('industrialrenewal:fluid_gauge'))
		.fluidInputs(fluid(key) * val)
		.outputs(item('industrialrenewal:fluid_tank'))
		.duration(100)
		.EUt(Globals.voltAmps[1])
		.buildAndRegister()
}

/*

ArrayList<String> name_removals = [
		"industrialrenewal:prospecting_pan",
		"industrialrenewal:screwdrive",
		"industrialrenewal:steel_saw",
		"industrialrenewal:cargo_container",
		"industrialrenewal:cart_hopper",
		"industrialrenewal:fluid_container",
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