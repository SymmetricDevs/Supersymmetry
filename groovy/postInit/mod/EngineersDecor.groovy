def name_removals = [
		"engineersdecor:alternative/small_electrical_furnace_recipe_standalone",
		"engineersdecor:alternative/small_lab_furnace_recipe_standalone",
		"engineersdecor:alternative/labeled_crate_recipe_standalone",
		"engineersdecor:alternative/factory_hopper_recipe_standalone",
		"engineersdecor:alternative/factory_dropper_recipe_standalone",
		"engineersdecor:alternative/factory_placer_recipe_standalone",
		"engineersdecor:alternative/small_block_breaker_recipe_standalone",
		"engineersdecor:alternative/small_tree_cutter_recipe_standalone",
		"engineersdecor:alternative/small_waste_incinerator_recipe_standalone",
		"engineersdecor:alternative/small_solar_panel_standalone",
		"engineersdecor:alternative/small_mineral_smelter_recipe_standalone",
		"engineersdecor:alternative/straight_pipe_valve_recipe_standalone",
		"engineersdecor:alternative/straight_pipe_valve_redstone_recipe_standalone",
		"engineersdecor:alternative/straight_pipe_valve_redstone_recipe_backcycle",
		"engineersdecor:alternative/straight_pipe_valve_redstone_analog_recipe",
		"engineersdecor:alternative/small_fluid_funnel_recipe_standalone",
		"engineersdecor:alternative/passive_fluid_accumulator_recipe_standalone",
		"engineersdecor:alternative/small_milking_machine_recipe_standalone",
		"engineersdecor:alternative/rebar_concrete_block_recipe_standalone",
		"engineersdecor:alternative/gas_concrete_block_recipe_standalone"
]

for (item in name_removals) {
    crafting.remove(item)
}

def oreRod = [
		'stickSteel',
		'stickIron',
		'stickWroughtIron'
]

crafting.replaceShaped('engineersdecor:independent/clinker_brick_block_recipe', item('engineersdecor:clinker_brick_block') * 2, [
    [ore('ingotBrick'), metaitem('cement.clinker'), ore('ingotBrick')],
    [metaitem('cement.clinker'), ore('ingotBrick'), metaitem('cement.clinker')],
    [ore('ingotBrick'), metaitem('cement.clinker'), ore('ingotBrick')]
])

crafting.replaceShaped('engineersdecor:independent/slag_brick_block_recipe', item('engineersdecor:slag_brick_block') * 9, [
    [ore('ingotBrick'), ore('dustTinyAsh'), ore('ingotBrick')],
    [ore('dustTinyAsh'), ore('blockGlass'), ore('dustTinyAsh')],
    [ore('ingotBrick'), ore('dustTinyAsh'), ore('ingotBrick')]
])

crafting.replaceShaped('engineersdecor:alternative/panzerglass_block_recipe_standalone', item('engineersdecor:panzerglass_block') * 9, [
    [ore('blockGlass'), ore('screwSteel'), ore('blockGlass')],
    [ore('screwSteel'), ore('blockGlass'), ore('screwSteel')],
    [ore('blockGlass'), ore('screwSteel'), ore('blockGlass')]
])

crafting.replaceShaped('engineersdecor:alternative/steel_framed_window_recipe_standalone', item('engineersdecor:steel_framed_window') * 9, [
    [ore('paneGlass'), ore('screwSteel'), ore('paneGlass')],
    [ore('screwSteel'), ore('paneGlass'), ore('screwSteel')],
    [ore('paneGlass'), ore('screwSteel'), ore('paneGlass')]
])

crafting.replaceShaped('engineersdecor:alternative/thin_steel_pole_recipe_standalone', item('engineersdecor:thin_steel_pole') * 9, [
    [null, ore('stickSteel'), null],
    [null, ore('stickSteel'), null],
    [null, ore('stickSteel'), null]
])

crafting.replaceShaped('engineersdecor:independent/clinker_brick_stairs_recipe', item('engineersdecor:clinker_brick_stairs') * 8, [
    [item('engineersdecor:clinker_brick_block'), null, null],
    [item('engineersdecor:clinker_brick_block'), item('engineersdecor:clinker_brick_block'), null],
    [item('engineersdecor:clinker_brick_block'), item('engineersdecor:clinker_brick_block'), item('engineersdecor:clinker_brick_block')]
])

crafting.replaceShaped('engineersdecor:independent/clinker_brick_stained_stairs_recipe', item('engineersdecor:clinker_brick_stained_stairs') * 8, [
    [item('engineersdecor:clinker_brick_stained_block'), null, null],
    [item('engineersdecor:clinker_brick_stained_block'), item('engineersdecor:clinker_brick_stained_block'), null],
    [item('engineersdecor:clinker_brick_stained_block'), item('engineersdecor:clinker_brick_stained_block'), item('engineersdecor:clinker_brick_stained_block')]
])

crafting.replaceShaped('engineersdecor:independent/slag_brick_stairs_recipe', item('engineersdecor:slag_brick_stairs') * 8, [
    [item('engineersdecor:slag_brick_block'), null, null],
    [item('engineersdecor:slag_brick_block'), item('engineersdecor:slag_brick_block'), null],
    [item('engineersdecor:slag_brick_block'), item('engineersdecor:slag_brick_block'), item('engineersdecor:slag_brick_block')]
])

crafting.replaceShaped('engineersdecor:independent/rebar_concrete_stairs_recipe', item('engineersdecor:rebar_concrete_stairs') * 8, [
    [item('engineersdecor:rebar_concrete'), null, null],
    [item('engineersdecor:rebar_concrete'), item('engineersdecor:rebar_concrete'), null],
    [item('engineersdecor:rebar_concrete'), item('engineersdecor:rebar_concrete'), item('engineersdecor:rebar_concrete')]
])

crafting.replaceShaped('engineersdecor:independent/rebar_concrete_tile_stairs_recipe', item('engineersdecor:rebar_concrete_tile_stairs') * 8, [
    [item('engineersdecor:rebar_concrete_tile'), null, null],
    [item('engineersdecor:rebar_concrete_tile'), item('engineersdecor:rebar_concrete_tile'), null],
    [item('engineersdecor:rebar_concrete_tile'), item('engineersdecor:rebar_concrete_tile'), item('engineersdecor:rebar_concrete_tile')]
])

crafting.replaceShaped('engineersdecor:independent/gas_concrete_stairs_recipe', item('engineersdecor:gas_concrete_stairs') * 8, [
    [item('engineersdecor:gas_concrete'), null, null],
    [item('engineersdecor:gas_concrete'), item('engineersdecor:gas_concrete'), null],
    [item('engineersdecor:gas_concrete'), item('engineersdecor:gas_concrete'), item('engineersdecor:gas_concrete')]
])

crafting.replaceShaped('engineersdecor:independent/gas_concrete_stairs_recipe', item('engineersdecor:gas_concrete_stairs') * 8, [
	[item('engineersdecor:gas_concrete'), null, null],
	[item('engineersdecor:gas_concrete'), item('engineersdecor:gas_concrete'), null],
	[item('engineersdecor:gas_concrete'), item('engineersdecor:gas_concrete'), item('engineersdecor:gas_concrete')]
])

// Concrete

mods.gregtech.cutter.recipeBuilder()
		.inputs(item('engineersdecor:rebar_concrete'))
		.outputs(item('engineersdecor:rebar_concrete_slab') * 2)
		.duration(25)
		.EUt(7)
		.buildAndRegister();

mods.gregtech.cutter.recipeBuilder()
		.inputs(item('engineersdecor:rebar_concrete_slab'))
		.outputs(item('engineersdecor:halfslab_rebar_concrete') * 4)
		.duration(25)
		.EUt(7)
		.buildAndRegister();

mods.gregtech.cutter.recipeBuilder()
		.inputs(item('engineersdecor:rebar_concrete_tile'))
		.outputs(item('engineersdecor:rebar_concrete_tile_slab') * 2)
		.duration(25)
		.EUt(7)
		.buildAndRegister();

mods.gregtech.cutter.recipeBuilder()
		.inputs(item('engineersdecor:gas_concrete'))
		.outputs(item('engineersdecor:gas_concrete_slab') * 2)
		.duration(25)
		.EUt(7)
		.buildAndRegister();

mods.gregtech.cutter.recipeBuilder()
		.inputs(item('engineersdecor:gas_concrete_slab'))
		.outputs(item('engineersdecor:halfslab_gas_concrete') * 4)
		.duration(25)
		.EUt(7)
		.buildAndRegister();

for (name in oreRod) {
	mods.gregtech.assembler.recipeBuilder()
			.circuitMeta(2)
			.fluidInputs(fluid('concrete') * 144)
			.inputs(ore('dustPolypropylene'))
			.inputs(ore(name) * 4)
			.outputs(item('engineersdecor:rebar_concrete') * 2)
			.duration(40)
			.EUt(120)
			.buildAndRegister();
}

mods.gregtech.autoclave.recipeBuilder()
		.fluidInputs(fluid('concrete') * 144)
		.inputs(ore('dustQuartzite'))
		.inputs(ore('dustTinyAluminium'))
		.outputs(item('engineersdecor:gas_concrete') * 8)
		.duration(80)
		.EUt(120)
		.buildAndRegister();
