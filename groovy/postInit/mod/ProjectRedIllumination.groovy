ASSEMBLER = recipemap('assembler')
CHEMICAL_BATH = recipemap('chemical_bath')

def dye_colors = [
    'white',
    'orange',
    'magenta',
    'light_blue',
    'yellow',
    'lime',
    'pink',
    'gray',
    'light_gray',
    'cyan',
    'purple',
    'blue',
    'brown',
    'green',
    'red',
    'black'
]

for (color in dye_colors){
	def color_name_removals = [
		  "lamp/${color}_lamp",
		  "lamp/${color}_lamp_inverted",
		  "button/${color}_button",
		  "lantern/${color}_lantern",
		  "lantern/${color}_lantern_inverted",
		  "fixture/${color}_fixture",
		  "fixture/${color}_fixture_inverted",
		  "fallout/${color}_fallout",
		  "fallout/${color}_fallout_inverted",
		  "cage/${color}_cage",
		  "cage/${color}_cage_inverted",
	];
	
	for (name in color_name_removals) {
  		crafting.remove('projectred-illumination:' + name)
	}
	
}

def colored_lights = [
	'lamp',
	'light_button',
	'lantern',
	'inverted_lantern',
	'fixture_light',
	'inverted_fixture_light',
	'fallout_lamp',
	'inverted_fallout_lamp',
	'cage_lamp',
	'inverted_cage_lamp'
]

for (i = 1; i < 16; i++) {
	for(light in colored_lights){
		CHEMICAL_BATH.recipeBuilder()
			.inputs(item('projectred-illumination:' + light))
			.fluidInputs(fluid('dye_' + dye_colors[i]) * 18)
			.outputs(item('projectred-illumination:' + light, i))
			.duration(20)
			.EUt(7)
			.buildAndRegister();
	}
	
	//inverted block lamps
	CHEMICAL_BATH.recipeBuilder()
		.inputs(item('projectred-illumination:lamp',16))
		.fluidInputs(fluid('dye_' + dye_colors[i]) * 18)
		.outputs(item('projectred-illumination:lamp', 16 + i))
		.duration(20)
		.EUt(7)
		.buildAndRegister();	
			
}

ASSEMBLER.recipeBuilder()
	.inputs(ore('springSteel') * 2)
	.inputs(ore('dustRedstone') * 2)
	.inputs(ore('gtLight'))
	.inputs(ore('plateGlass') * 3)
	.outputs(item('projectred-illumination:light_button') * 3)
	.duration(40)
	.EUt(7)
	.buildAndRegister();
	
ASSEMBLER.recipeBuilder()
	.inputs(ore('frameGtSteel'))
	.inputs(ore('dustRedstone') * 2)
	.inputs(ore('gtLight'))
	.inputs(ore('plateGlass') * 6)
	.outputs(item('projectred-illumination:lamp') * 3)
	.circuitMeta(2)
	.duration(40)
	.EUt(7)
	.buildAndRegister();

ASSEMBLER.recipeBuilder()
	.inputs(ore('frameGtSteel'))
	.inputs(item('minecraft:redstone_torch') * 2)
	.inputs(ore('gtLight'))
	.inputs(ore('plateGlass') * 6)
	.outputs(item('projectred-illumination:lamp', 16) * 3)
	.circuitMeta(3)
	.duration(40)
	.EUt(7)
	.buildAndRegister();

crafting.addShaped("projectred-illumination:lantern", item('projectred-illumination:lantern'), [
    [item('projectred-core:resource_item'), ore('nuggetGold'), item('projectred-core:resource_item')],
    [ore('paneGlass'), ore('gtLight'), ore('paneGlass')],
    [item('projectred-core:resource_item'), ore('dustRedstone'), item('projectred-core:resource_item')]
])

crafting.addShaped("projectred-illumination:inverted_lantern", item('projectred-illumination:inverted_lantern'), [
    [item('projectred-core:resource_item'), ore('nuggetGold'), item('projectred-core:resource_item')],
    [ore('paneGlass'), ore('gtLight'), ore('paneGlass')],
    [item('projectred-core:resource_item'), item('minecraft:redstone_torch'), item('projectred-core:resource_item')]
])

crafting.addShaped("projectred-illumination:fixture_light", item('projectred-illumination:fixture_light'), [
    [ore('paneGlass'), ore('paneGlass'), ore('paneGlass')],
    [ore('paneGlass'), ore('gtLight'), ore('paneGlass')],
    [item('projectred-core:resource_item'), item('projectred-core:resource_item',1), item('projectred-core:resource_item')]
])

crafting.addShaped("projectred-illumination:inverted_fixture_light", item('projectred-illumination:inverted_fixture_light'), [
    [ore('paneGlass'), ore('paneGlass'), ore('paneGlass')],
    [ore('paneGlass'), ore('gtLight'), ore('paneGlass')],
    [item('projectred-core:resource_item'), item('projectred-core:resource_item',11), item('projectred-core:resource_item')]
])

crafting.addShaped("projectred-illumination:fallout_lamp", item('projectred-illumination:fallout_lamp'), [
    [ore('barsIron'), ore('barsIron'), ore('barsIron')],
    [ore('barsIron'), ore('gtLight'), ore('barsIron')],
    [ore('nuggetGold'), item('projectred-core:resource_item',1), ore('nuggetGold')]
])

crafting.addShaped("projectred-illumination:inverted_fallout_lamp", item('projectred-illumination:inverted_fallout_lamp'), [
    [ore('barsIron'), ore('barsIron'), ore('barsIron')],
    [ore('barsIron'), ore('gtLight'), ore('barsIron')],
    [ore('nuggetGold'), item('projectred-core:resource_item',11), ore('nuggetGold')]
])

crafting.addShaped("projectred-illumination:cage_lamp", item('projectred-illumination:cage_lamp'), [
    [null, ore('barsIron'), null],
    [ore('barsIron'), ore('gtLight'), ore('barsIron')],
    [item('projectred-core:resource_item',1), item('projectred-core:resource_item',1), item('projectred-core:resource_item',1)]
])

crafting.addShaped("projectred-illumination:inverted_cage_lamp", item('projectred-illumination:inverted_cage_lamp'), [
    [null, ore('barsIron'), null],
    [ore('barsIron'), ore('gtLight'), ore('barsIron')],
    [item('projectred-core:resource_item',1), item('projectred-core:resource_item',11), item('projectred-core:resource_item',1)]
])
