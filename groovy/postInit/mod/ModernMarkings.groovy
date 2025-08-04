MIXER = recipemap('mixer')

mods.chisel.carving.addGroup("markings_basic")
mods.chisel.carving.addGroup("markings_symbolic")
mods.chisel.carving.addGroup("markings_symbolic_yellow")
mods.chisel.carving.addGroup("markings_electric")
mods.chisel.carving.addGroup("markings_black")
mods.chisel.carving.addGroup("markings_blue")
mods.chisel.carving.addGroup("markings_green")
mods.chisel.carving.addGroup("markings_orange")
mods.chisel.carving.addGroup("markings_red")
mods.chisel.carving.addGroup("markings_yellow")

def basic = [
    'ags_modernmarkings:floor_marking_white_singleline',
    'ags_modernmarkings:floor_marking_white_lane',
    'ags_modernmarkings:floor_marking_white_lane_cross',
    'ags_modernmarkings:floor_marking_white_square',
    'ags_modernmarkings:floor_marking_whiteblack_hazardline',
    'ags_modernmarkings:floor_marking_white_corner',
    'ags_modernmarkings:floor_marking_red_hazardline',
    'ags_modernmarkings:floor_marking_white_arrow',
    'ags_modernmarkings:wall_marking_arrowleft',
    'ags_modernmarkings:wall_marking_arrowright'
]

def black = [
    'ags_modernmarkings:floor_marking_black_corner',
    'ags_modernmarkings:floor_marking_black_singleline'
]

def blue = [
    'ags_modernmarkings:floor_marking_blue_corner',
    'ags_modernmarkings:floor_marking_blue_singleline'
]

def green = [
    'ags_modernmarkings:floor_marking_green_corner',
    'ags_modernmarkings:floor_marking_green_singleline'
]

def orange = [
    'ags_modernmarkings:floor_marking_orange_corner',
    'ags_modernmarkings:floor_marking_orange_singleline'
]

def red = [
    'ags_modernmarkings:floor_marking_red_corner',
    'ags_modernmarkings:floor_marking_red_singleline',
    'ags_modernmarkings:floor_marking_danger_red',
    'ags_modernmarkings:floor_marking_redx'
]

def yellow = [
    'ags_modernmarkings:floor_marking_yellow_corner',
    'ags_modernmarkings:floor_marking_yellow_hazardline',
    'ags_modernmarkings:floor_marking_yellow_lane',
    'ags_modernmarkings:floor_marking_yellow_sideline',
    'ags_modernmarkings:floor_marking_yellow_singleline',
    'ags_modernmarkings:floor_marking_yellow_square',
    'ags_modernmarkings:floor_marking_yellow_stripes',
    'ags_modernmarkings:floor_marking_danger_yellow',
    'ags_modernmarkings:wall_marking_warning_danger',
    'ags_modernmarkings:wall_marking_hazardline_left',
    'ags_modernmarkings:wall_marking_hazardline_right',
    'ags_modernmarkings:floor_marking_yellow_arrow'
]

for (anItem in basic) {
    crafting.remove(anItem) // Should all be the same name
    mods.chisel.carving.addVariation("markings_basic", item(anItem))
}

for (anItem in black) {
    crafting.remove(anItem) // Should all be the same name
    mods.chisel.carving.addVariation("markings_black", item(anItem))
}

for (anItem in blue) {
    crafting.remove(anItem) // Should all be the same name
    mods.chisel.carving.addVariation("markings_blue", item(anItem))
}

for (anItem in green) {
    crafting.remove(anItem) // Should all be the same name
    mods.chisel.carving.addVariation("markings_green", item(anItem))
}

for (anItem in orange) {
    crafting.remove(anItem) // Should all be the same name
    mods.chisel.carving.addVariation("markings_orange", item(anItem))
}

for (anItem in red) {
    crafting.remove(anItem) // Should all be the same name
    mods.chisel.carving.addVariation("markings_red", item(anItem))
}

for (anItem in yellow) {
    crafting.remove(anItem) // Should all be the same name
    mods.chisel.carving.addVariation("markings_yellow", item(anItem))
}


MIXER.recipeBuilder()
    .inputs(ore('dyeWhite') * 1)
    .fluidInputs(fluid('gtfo_raw_soybean_oil') * 25)
    .circuitMeta(1)
    .outputs(item('ags_modernmarkings:floor_marking_white_singleline') * 8)
    .EUt(8)
    .duration(30)
    .buildAndRegister()

MIXER.recipeBuilder()
    .circuitMeta(1)
    .inputs(ore('dyeBlack') * 1)
    .fluidInputs(fluid('gtfo_raw_soybean_oil') * 25)
    .circuitMeta(1)
    .outputs(item('ags_modernmarkings:floor_marking_black_singleline') * 8)
    .EUt(8)
    .duration(30)
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dyeBlue') * 1)
    .fluidInputs(fluid('gtfo_raw_soybean_oil') * 25)
    .circuitMeta(1)
    .outputs(item('ags_modernmarkings:floor_marking_blue_singleline') * 8)
    .EUt(8)
    .duration(30)
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dyeGreen') * 1)
    .fluidInputs(fluid('gtfo_raw_soybean_oil') * 25)
    .circuitMeta(1)
    .outputs(item('ags_modernmarkings:floor_marking_green_singleline') * 8)
    .EUt(8)
    .duration(30)
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dyeOrange') * 1)
    .fluidInputs(fluid('gtfo_raw_soybean_oil') * 25)
    .circuitMeta(1)
    .outputs(item('ags_modernmarkings:floor_marking_orange_singleline') * 8)
    .EUt(8)
    .duration(30)
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dyeRed') * 1)
    .fluidInputs(fluid('gtfo_raw_soybean_oil') * 25)
    .circuitMeta(1)
    .outputs(item('ags_modernmarkings:floor_marking_red_singleline') * 8)
    .EUt(8)
    .duration(30)
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dyeYellow') * 1)
    .fluidInputs(fluid('gtfo_raw_soybean_oil') * 25)
    .circuitMeta(1)
    .outputs(item('ags_modernmarkings:floor_marking_yellow_singleline') * 8)
    .EUt(8)
    .duration(30)
    .buildAndRegister()


def symbolic = [
    'ags_modernmarkings:wall_marking_number_0',
    'ags_modernmarkings:wall_marking_symbol_frost',
    'ags_modernmarkings:wall_marking_symbol_gears',
    'ags_modernmarkings:wall_marking_symbol_laser',
    'ags_modernmarkings:wall_marking_symbol_magic',
    'ags_modernmarkings:wall_marking_symbol_mob',
    'ags_modernmarkings:wall_marking_symbol_pinch',
    'ags_modernmarkings:wall_marking_symbol_production',
    'ags_modernmarkings:wall_marking_symbol_radiation',
    'ags_modernmarkings:wall_marking_symbol_storage',
    'ags_modernmarkings:floor_marking_exit',
    'ags_modernmarkings:floor_marking_noentry',
    'ags_modernmarkings:floor_marking_nostep',
    'ags_modernmarkings:wall_marking_number_1',
    'ags_modernmarkings:wall_marking_number_2',
    'ags_modernmarkings:wall_marking_number_3',
    'ags_modernmarkings:wall_marking_number_4',
    'ags_modernmarkings:wall_marking_number_5',
    'ags_modernmarkings:wall_marking_number_6',
    'ags_modernmarkings:wall_marking_number_7',
    'ags_modernmarkings:wall_marking_number_8',
    'ags_modernmarkings:wall_marking_number_9',
    'ags_modernmarkings:wall_marking_number_no',
    'ags_modernmarkings:wall_marking_number_numero',
    'ags_modernmarkings:wall_marking_number_dash',
    'ags_modernmarkings:wall_marking_number_comma',
    'ags_modernmarkings:wall_marking_number_period',
    'ags_modernmarkings:wall_marking_symbol_chemical',
    'ags_modernmarkings:wall_marking_symbol_electric',
    'ags_modernmarkings:wall_marking_symbol_fire',
    'ags_modernmarkings:wall_marking_symbol_fluid',
    'ags_modernmarkings:wall_marking_symbol_jeo',
    'ags_modernmarkings:wall_marking_hazard_diamond',
    'ags_modernmarkings:wall_marking_exclamation_mark',
    'ags_modernmarkings:wall_marking_question_mark',
    'ags_modernmarkings:wall_marking_exit'
]

for (anItem in symbolic) {
    crafting.remove(anItem) // Should all be the same name
    mods.chisel.carving.addVariation("markings_symbolic", item(anItem))
}

MIXER.recipeBuilder()
    .inputs(ore('dyeWhite') * 2)
    .fluidInputs(fluid('gtfo_raw_soybean_oil') * 50)
    .circuitMeta(2)
    .outputs(item('ags_modernmarkings:wall_marking_number_0') * 8)
    .EUt(8)
    .duration(30)
    .buildAndRegister()

def electric = [
    'ags_modernmarkings:wall_marking_voltage_eu',
    'ags_modernmarkings:wall_marking_voltage_fe',
    'ags_modernmarkings:wall_marking_voltage_rf',
    'ags_modernmarkings:wall_marking_voltage_pert',
    'ags_modernmarkings:wall_marking_voltage_steam',
    'ags_modernmarkings:wall_marking_voltage_ulv',
    'ags_modernmarkings:wall_marking_voltage_lv',
    'ags_modernmarkings:wall_marking_voltage_mv',
    'ags_modernmarkings:wall_marking_voltage_hv',
    'ags_modernmarkings:wall_marking_voltage_ev',
    'ags_modernmarkings:wall_marking_voltage_iv',
    'ags_modernmarkings:wall_marking_voltage_luv',
    'ags_modernmarkings:wall_marking_voltage_zpm',
    'ags_modernmarkings:wall_marking_voltage_uv',
    'ags_modernmarkings:wall_marking_voltage_uhv',
    'ags_modernmarkings:wall_marking_voltage_uev',
    'ags_modernmarkings:wall_marking_voltage_uiv',
    'ags_modernmarkings:wall_marking_voltage_umv',
    'ags_modernmarkings:wall_marking_voltage_uxv',
    'ags_modernmarkings:wall_marking_voltage_max'
]

for (anItem in electric) {
    crafting.remove(anItem) // Should all be the same name
    mods.chisel.carving.addVariation("markings_electric", item(anItem))
}

MIXER.recipeBuilder()
    .inputs(ore('dyeWhite') * 2)
    .fluidInputs(fluid('gtfo_raw_soybean_oil') * 50)
    .circuitMeta(3)
    .outputs(item('ags_modernmarkings:wall_marking_voltage_eu') * 8)
    .EUt(8)
    .duration(30)
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dyeYellow') * 2)
    .fluidInputs(fluid('gtfo_raw_soybean_oil') * 50)
    .circuitMeta(2)
    .outputs(item('ags_modernmarkings:wall_marking_symbol_yellow_electric') * 8)
    .EUt(8)
    .duration(30)
    .buildAndRegister()

def yellow_symbolic = [
    'ags_modernmarkings:wall_marking_symbol_yellow_electric',
    'ags_modernmarkings:wall_marking_symbol_yellow_frost',
    'ags_modernmarkings:wall_marking_symbol_yellow_gears',
    'ags_modernmarkings:wall_marking_symbol_yellow_laser',
    'ags_modernmarkings:wall_marking_symbol_yellow_magic',
    'ags_modernmarkings:wall_marking_symbol_yellow_mob',
    'ags_modernmarkings:wall_marking_symbol_yellow_pinch',
    'ags_modernmarkings:wall_marking_symbol_yellow_production',
    'ags_modernmarkings:wall_marking_symbol_yellow_radiation',
    'ags_modernmarkings:wall_marking_symbol_yellow_storage',
    'ags_modernmarkings:wall_marking_symbol_yellow_chemical',
    'ags_modernmarkings:wall_marking_symbol_yellow_fire',
    'ags_modernmarkings:wall_marking_symbol_yellow_fluid'
]


for (anItem in yellow_symbolic) {
    crafting.remove(anItem) // Should all be the same name
    mods.chisel.carving.addVariation("markings_symbolic_yellow", item(anItem))
}

crafting.remove('ags_modernmarkings:floor_marking_yelow_corner') // Except for this one, which is misspelled as of 0.4.1

crafting.remove('ags_modernmarkings:floor_marking_danger_red_from_yellow')
crafting.remove('ags_modernmarkings:floor_marking_danger_yellow_from_red')
crafting.remove('ags_modernmarkings:wall_marking_voltage_fe_from_rf')
