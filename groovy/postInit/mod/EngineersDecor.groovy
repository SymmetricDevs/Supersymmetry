def name_removals = [
        "engineersdecor:small_electrical_furnace",
		"engineersdecor:small_waste_incinerator",
		"engineersdecor:small_solar_panel",
		"engineersdecor:small_mineral_smelter",
		"engineersdecor:small_fluid_funnel",
		"engineersdecor:small_milking_machine",
		"engineersdecor:passive_fluid_accumulator"
];

for (item in name_removals) {
    crafting.remove(item);
};

crafting.replaceShaped('engineersdecor:independent/clinker_brick_block_recipe', item('engineersdecor:clinker_brick_block') * 2, [
    [ore('ingotBrick'), metaitem('cement.clinker'), ore('ingotBrick')],
    [metaitem('cement.clinker'), ore('ingotBrick'), metaitem('cement.clinker')],
    [ore('ingotBrick'), metaitem('cement.clinker'), ore('ingotBrick')]
])

crafting.replaceShaped('engineersdecor:alternative/rebar_concrete_block_recipe_standalone', item('engineersdecor:rebar_concrete') * 9, [
    [ore('blockConcrete'), ore('stickSteel'), ore('blockConcrete')],
    [ore('stickSteel'), ore('blockConcrete'), ore('stickSteel')],
    [ore('blockConcrete'), ore('stickSteel'), ore('blockConcrete')]
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
