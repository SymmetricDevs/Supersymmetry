def name_removals = [
        'elevatorid:redye_white',
        'elevatorid:redye_orange',
        'elevatorid:elevator_orange',
        'elevatorid:redye_magenta',
        'elevatorid:elevator_magenta',
        'elevatorid:redye_light_blue',
        'elevatorid:elevator_light_blue',
        'elevatorid:redye_yellow',
        'elevatorid:elevator_yellow',
        'elevatorid:redye_lime',
        'elevatorid:elevator_lime',
        'elevatorid:redye_pink',
        'elevatorid:elevator_pink',
        'elevatorid:redye_gray',
        'elevatorid:elevator_gray',
        'elevatorid:redye_silver',
        'elevatorid:elevator_silver',
        'elevatorid:redye_cyan',
        'elevatorid:elevator_cyan',
        'elevatorid:redye_purple',
        'elevatorid:elevator_purple',
        'elevatorid:redye_blue',
        'elevatorid:elevator_blue',
        'elevatorid:redye_brown',
        'elevatorid:elevator_brown',
        'elevatorid:redye_green',
        'elevatorid:elevator_green',
        'elevatorid:redye_red',
        'elevatorid:elevator_red',
        'elevatorid:redye_black',
        'elevatorid:elevator_black'
]

for (name in name_removals) {
    crafting.remove(name)
}

crafting.replaceShaped('elevatorid:elevator_white', item('elevatorid:elevator_white') * 2, [
        [metaitem('stickSteel'), metaitem('electric.motor.lv'), metaitem('stickSteel')],
        [metaitem('wireFineSteel'), null, metaitem('wireFineSteel')],
        [metaitem('stickSteel'), metaitem('plateSteel'), metaitem('stickSteel')]
])

def dyes = [
	'orange',
	'pink',
	'light_blue',
	'yellow',
	'lime',
	'gray',
	'cyan',
	'purple',
	'blue',
	'brown',
	'green',
	'red',
	'black',
	'white',
	'magenta'
]

for (dye in dyes) {
	CHEMICAL_BATH.recipeBuilder()
        	.fluidInputs(fluid('dye_' + dye) * 144)
        	.inputs(ore('blockElevator'))
        	.outputs(item('elevatorid:elevator_' + dye))
        	.duration(20)
        	.EUt(7)
        	.buildAndRegister();
}

CHEMICAL_BATH.recipeBuilder()
        .fluidInputs(fluid('dye_light_gray') * 144)
        .inputs(ore('blockElevator'))
        .outputs(item('elevatorid:elevator_silver'))
        .duration(20)
        .EUt(7)
        .buildAndRegister();
