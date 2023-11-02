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

CHEMICAL_BATH.recipeBuilder()
        .fluidInputs(fluid('dye_orange') * 144)
        .inputs(ore('blockElevator'))
        .outputs(item('elevatorid:elevator_orange'))
        .duration(20)
        .EUt(7)
        .buildAndRegister();

CHEMICAL_BATH.recipeBuilder()
        .fluidInputs(fluid('dye_pink') * 144)
        .inputs(ore('blockElevator'))
        .outputs(item('elevatorid:elevator_pink'))
        .duration(20)
        .EUt(7)
        .buildAndRegister();

CHEMICAL_BATH.recipeBuilder()
        .fluidInputs(fluid('dye_light_blue') * 144)
        .inputs(ore('blockElevator'))
        .outputs(item('elevatorid:elevator_light_blue'))
        .duration(20)
        .EUt(7)
        .buildAndRegister();

CHEMICAL_BATH.recipeBuilder()
        .fluidInputs(fluid('dye_yellow') * 144)
        .inputs(ore('blockElevator'))
        .outputs(item('elevatorid:elevator_yellow'))
        .duration(20)
        .EUt(7)
        .buildAndRegister();

CHEMICAL_BATH.recipeBuilder()
        .fluidInputs(fluid('dye_lime') * 144)
        .inputs(ore('blockElevator'))
        .outputs(item('elevatorid:elevator_lime'))
        .duration(20)
        .EUt(7)
        .buildAndRegister();

CHEMICAL_BATH.recipeBuilder()
        .fluidInputs(fluid('dye_gray') * 144)
        .inputs(ore('blockElevator'))
        .outputs(item('elevatorid:elevator_gray'))
        .duration(20)
        .EUt(7)
        .buildAndRegister();

CHEMICAL_BATH.recipeBuilder()
        .fluidInputs(fluid('dye_light_gray') * 144)
        .inputs(ore('blockElevator'))
        .outputs(item('elevatorid:elevator_silver'))
        .duration(20)
        .EUt(7)
        .buildAndRegister();

CHEMICAL_BATH.recipeBuilder()
        .fluidInputs(fluid('dye_cyan') * 144)
        .inputs(ore('blockElevator'))
        .outputs(item('elevatorid:elevator_cyan'))
        .duration(20)
        .EUt(7)
        .buildAndRegister();

CHEMICAL_BATH.recipeBuilder()
        .fluidInputs(fluid('dye_purple') * 144)
        .inputs(ore('blockElevator'))
        .outputs(item('elevatorid:elevator_purple'))
        .duration(20)
        .EUt(7)
        .buildAndRegister();

CHEMICAL_BATH.recipeBuilder()
        .fluidInputs(fluid('dye_blue') * 144)
        .inputs(ore('blockElevator'))
        .outputs(item('elevatorid:elevator_blue'))
        .duration(20)
        .EUt(7)
        .buildAndRegister();

CHEMICAL_BATH.recipeBuilder()
        .fluidInputs(fluid('dye_brown') * 144)
        .inputs(ore('blockElevator'))
        .outputs(item('elevatorid:elevator_brown'))
        .duration(20)
        .EUt(7)
        .buildAndRegister();

CHEMICAL_BATH.recipeBuilder()
        .fluidInputs(fluid('dye_green') * 144)
        .inputs(ore('blockElevator'))
        .outputs(item('elevatorid:elevator_green'))
        .duration(20)
        .EUt(7)
        .buildAndRegister();

CHEMICAL_BATH.recipeBuilder()
        .fluidInputs(fluid('dye_red') * 144)
        .inputs(ore('blockElevator'))
        .outputs(item('elevatorid:elevator_red'))
        .duration(20)
        .EUt(7)
        .buildAndRegister();

CHEMICAL_BATH.recipeBuilder()
        .fluidInputs(fluid('dye_black') * 144)
        .inputs(ore('blockElevator'))
        .outputs(item('elevatorid:elevator_black'))
        .duration(20)
        .EUt(7)
        .buildAndRegister();

CHEMICAL_BATH.recipeBuilder()
        .fluidInputs(fluid('dye_white') * 144)
        .inputs(ore('blockElevator'))
        .outputs(item('elevatorid:elevator_white'))
        .duration(20)
        .EUt(7)
        .buildAndRegister();