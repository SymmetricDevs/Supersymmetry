#loader gregtech
#priority 2000

import mods.gregtech.material.MaterialBuilder;
import mods.gregtech.material.Material;
import mods.gregtech.material.MaterialRegistry;
import mods.gregtech.material.Elements;
import mods.gregtech.recipe.Utils;

//MATERIALS 8000-10000 RESERVED FOR NUCLEAR-RELATED ITEMS
//MATERIALS 10000-20000 RESERVED FOR FLUIDS
//MATERIALS 20000-30000 RESERVED FOR SOLIDS
//MATERIALS 30000-31000 RESERVED FOR ORES
//MATERIALS 31000-32000 RESERVED FOR ISOTOPES
//MATERIALS 32000+ RESERVED FOR ELEMENTS

//----------------------------------ELEMENTS---------------------------------

MaterialBuilder(32000, "mystery")
.dust()
.color(0x141414)
.build();

<material:mystery>.setFormula("?", false);

MaterialBuilder(32001, "iodine")
.element("Iodine")
.dust()
.color(0x390b6e)
.build();

MaterialBuilder(32002, "hafnium")
.element("Hafnium")
.dust()
.ingot()
.color(0x1c1b18)
.build();

MaterialBuilder(32003, "chromium")
.element("Chromium")
.dust()
.ingot()
.color(0xccb8c7)
.build();

MaterialBuilder(32004, "strontium")
.element("Strontium")
.dust()
.ingot()
.color(0xdbdaab)
.build();

//-------------------------------------------------ORES--------------------------------------------------

MaterialBuilder(30000, "enargite")
.ore()
.addOreByproducts([<material:pyrite>, <material:sphalerite>])
.components([<material:copper> * 3, <material:arsenic> * 1, <material:sulfur> * 4])
.colorAverage()
.build();

MaterialBuilder(30002, "tenorite")
.ore()
.addOreByproducts([<material:malachite>, <material:manganese>])
.components([<material:copper> * 1, <material:oxygen> * 1])
.colorAverage()
.build();

MaterialBuilder(30003, "dolomite")
.ore()
.components([<material:calcium> * 1, <material:magnesium> * 1, <material:carbon> * 3, <material:oxygen> * 6])
.colorAverage()
.build();

MaterialBuilder(30004, "fluorapatite")
.ore()
.addOreByproducts([<material:tricalcium_phosphate>])
.components([<material:calcium> * 5, <material:phosphorus> * 3, <material:oxygen> * 12, <material:fluorine> * 1])
.colorAverage()
.build();

MaterialBuilder(30005, "precious_metal")
.ore()
.color(0xdbd821)
.build();

MaterialBuilder(30006, "kaolinite")
.ore()
.components([<material:aluminium> * 2, <material:silicon> * 2, <material:oxygen> * 9, <material:hydrogen> * 4])
.colorAverage()
.build();

MaterialBuilder(30008, "cuprite")
.ore()
.components([<material:copper> * 2, <material:oxygen> * 1])
.colorAverage()
.build();

//-----------------------------------SOLIDS (INGOTS, DUSTS, GEARS, ETC)-----------------------------------

MaterialBuilder(20000, "zirconmoldbase")
.dust()
.color(0xbaa56a).iconSet("dull")
.build();

MaterialBuilder(20001, "zircon")
.dust()
.components([<material:zirconium> * 1, <material:silicon> * 1, <material:oxygen> * 4])
.flags(["disable_decomposition"])
.iconSet("shiny")
.build();

MaterialBuilder(20002, "nanosilicon")
.dust()
.components([<material:silicon> * 1])
.flags(["disable_decomposition"])
.color(0x1c1c1c)
.iconSet("shiny")
.build();

MaterialBuilder(20003, "refinedsilicon")
.dust()
.components([<material:silicon> * 1])
.flags(["disable_decomposition"])
.color(0x0f0f0f)
.iconSet("shiny")
.build();

MaterialBuilder(20004, "petcoke")
.dust()
.components([<material:carbon> * 1])
.flags(["disable_decomposition"])
.color(0x21201e)
.build();

MaterialBuilder(20005, "asphalt")
.dust()
.color(0x000000)
.build();

MaterialBuilder(20006, "sodium_silicate")
.dust()
.components([<material:sodium> * 2, <material:silicon> * 1, <material:oxygen> * 2])
.build();

MaterialBuilder(20007, "sodium_aluminate")
.dust()
.components([<material:sodium> * 1, <material:aluminium> * 1, <material:oxygen> * 2])
.build();

MaterialBuilder(20008, "small_molecular_sieve_wet")
.dust()
.color(0x4f5559)
.iconSet("shiny")
.build();

MaterialBuilder(20009, "medium_molecular_sieve_wet")
.dust()
.color(0x45494d)
.iconSet("shiny")
.build();

MaterialBuilder(20010, "large_molecular_sieve_wet")
.dust()
.color(0x323638)
.iconSet("shiny")
.build();

MaterialBuilder(20011, "small_molecular_sieve")
.dust()
.color(0x6a6a6a)
.iconSet("shiny")
.build();

MaterialBuilder(20012, "medium_molecular_sieve")
.dust()
.color(0x5c5c5c)
.iconSet("shiny")
.build();

MaterialBuilder(20013, "large_molecular_sieve")
.dust()
.color(0x4a4a4a)
.iconSet("shiny")
.build();

MaterialBuilder(20014, "sodium_oxide")
.dust()
.components([<material:sodium> * 2, <material:oxygen> * 1])
.build();

MaterialBuilder(20015, "activated_carbon")
.dust()
.flags(["disable_decomposition"])
.components([<material:carbon> * 7, <material:sulfur> * 1])
.colorAverage()
.build();

MaterialBuilder(20016, "mercury_carbon")
.dust()
.flags(["disable_decomposition"])
.components([<material:carbon> * 7, <material:sulfur> * 1, <material:mercury> * 1])
.colorAverage()
.build();

MaterialBuilder(20017, "bscco")
.dust()
.components([<material:copper> * 3, <material:bismuth> * 2, <material:strontium> * 2, <material:calcium> * 2, <material:oxygen> * 11])
.colorAverage()
.build();

MaterialBuilder(20018, "copper_oxide")
.dust()
.components([<material:copper> * 1, <material:oxygen> * 1])
.colorAverage()
.build();

MaterialBuilder(20019, "hafnium_oxide")
.dust()
.components([<material:hafnium> * 1, <material:oxygen> * 2])
.colorAverage()
.build();

MaterialBuilder(20020, "strontium_chloride")
.dust()
.components([<material:strontium> * 1, <material:chlorine> * 2])
.colorAverage()
.build();

MaterialBuilder(20021, "dilithium")
.gem()
.components([<material:lithium> * 2])
.flags(["disable_decomposition"])
.colorAverage()
.iconSet("shiny")
.build();

MaterialBuilder(20022, "witherite")
.dust()
.components([<material:barium> * 1, <material:carbon> * 1, <material:oxygen> * 3])
.colorAverage()
.build();

MaterialBuilder(20023, "barium_nitrate")
.dust()
.components([<material:barium> * 1, <material:nitrogen> * 2, <material:oxygen> * 6])
.colorAverage()
.build();

MaterialBuilder(20024, "barium_oxide")
.dust()
.components([<material:barium> * 1, <material:oxygen> * 1])
.colorAverage()
.build();

MaterialBuilder(20025, "vacuumsteel")
.ingot()
.color(0xC8C8DC)
.iconSet("shiny")
.flags(["generate_plate", "generate_gear", "generate_small_gear", "generate_rod", "generate_long_rod", "generate_bolt_screw", "generate_frame", "exclude_block_crafting_recipes", "exclude_plate_compressor_recipe", "exclude_block_crafting_by_hand_recipes"])
.build();

MaterialBuilder(20026, "titanium_aluminide")
.ingot()
.components([<material:titanium> * 1, <material:aluminium> * 1])
.colorAverage()
.iconSet("shiny")
.flags(["generate_plate", "generate_gear", "generate_rod", "generate_foil"])
.build();

MaterialBuilder(20027, "titanium_iridium")
.ingot()
.components([<material:titanium> * 1, <material:iridium> * 1])
.colorAverage()
.iconSet("shiny")
.flags(["generate_plate", "generate_gear", "generate_rod", "generate_foil"])
.build();

MaterialBuilder(20028, "lithium_6_deuteride")
.ingot()
.components([<material:lithium_6> * 1, <material:deuterium> * 1])
.colorAverage()
.build();

MaterialBuilder(20029, "zirconium_molybdenum")
.ingot()
.iconSet("shiny")
.components([<material:zirconium> * 1, <material:molybdenum> * 1])
.colorAverage()
.build();

MaterialBuilder(20030, "niobium_tin")
.ingot()
.components([<material:niobium> * 3, <material:tin> * 1])
.colorAverage()
.build();

MaterialBuilder(20031, "super_alloy")
.ingot()
.components([<material:nichrome> * 2, <material:niobium_titanium> * 1])
.colorAverage()
.build();

MaterialBuilder(20032, "hafnium_carbide")
.dust()
.flags("generate_plate", "generate_rod", "generate_frame")
.components([<material:hafnium> * 1, <material:carbon> * 1])
.colorAverage()
.build();

MaterialBuilder(20033, "zircaloy")
.dust()
.fluid()
.ingot()
.iconSet("shiny")
.flags("generate_plate", "generate_rod", "generate_frame")
.components([<material:zirconium> * 16, <material:niobium> * 1, <material:tin> * 1, <material:chrome> * 1, <material:nickel> * 1])
.colorAverage()
.build();

MaterialBuilder(20034, "manganese_oxide")
.dust()
.ingot()
.components([<material:manganese> * 1, <material:oxygen> * 1])
.colorAverage()
.build();

MaterialBuilder(20035, "manganese_dioxide")
.dust()
.ingot()
.components([<material:manganese> * 1, <material:oxygen> * 2])
.colorAverage()
.build();

MaterialBuilder(20036, "ferroboron")
.ingot()
.components([<material:steel> * 1, <material:boron> * 1])
.colorAverage()
.build();

MaterialBuilder(20037, "tough")
.ingot()
.components([<material:ferroboron> * 1, <material:lithium> * 1])
.colorAverage()
.build();

MaterialBuilder(20038, "hard_carbon")
.ingot()
.components([<material:carbon> * 1])
.colorAverage()
.build();

MaterialBuilder(20039, "lithium_manganese_dioxide")
.ingot()
.components([<material:lithium> * 1, <material:manganese> * 1, <material:oxygen> * 2])
.colorAverage()
.build();

MaterialBuilder(20040, "shibuichi")
.ingot()
.components([<material:copper> * 3, <material:silver> * 1])
.colorAverage()
.build();

MaterialBuilder(20041, "tin_silver")
.ingot()
.components([<material:tin> * 3, <material:silver> * 1])
.colorAverage()
.build();

MaterialBuilder(20042, "lead_platinum")
.ingot()
.components([<material:lead> * 3, <material:platinum> * 1])
.colorAverage()
.build();

MaterialBuilder(20043, "thermoconducting")
.ingot()
.components([<material:boron> * 1, <material:arsenic> * 1])
.colorAverage()
.build();

MaterialBuilder(20044, "calcium_sieve")
.dust()
.color(0xc9c9c9)
.build();

MaterialBuilder(20045, "carbon_manganese")
.dust()
.components([<material:carbon> * 1, <material:manganese> * 1])
.colorAverage()
.build();

MaterialBuilder(20046, "alugentum")
.dust()
.components([<material:aluminium> * 4, <material:silver> * 1])
.colorAverage()
.build();

MaterialBuilder(20048, "calcium_sulfate")
.dust()
.flags(["disable_decomposition"])
.components([<material:calcium> * 1, <material:sulfur> * 1, <material:oxygen> * 4])
.colorAverage()
.build();

MaterialBuilder(20049, "energetic")
.dust()
.components([<material:redstone> * 1, <material:glowstone> * 1])
.colorAverage()
.build();

MaterialBuilder(20050, "sodium_fluoride")
.dust()
.components([<material:sodium> * 1, <material:fluorine> * 1])
.colorAverage()
.build();

MaterialBuilder(20051, "potassium_fluoride")
.dust()
.components([<material:potassium> * 1, <material:fluorine> * 1])
.colorAverage()
.build();

MaterialBuilder(20052, "dimensional")
.dust()
.components([<material:obsidian> * 4, <material:endstone> * 1])
.colorAverage()
.build();

MaterialBuilder(20053, "extreme")
.dust()
.fluid()
.ingot()
.fluidTemp(4120)
.iconSet("shiny")
.flags("generate_plate", "generate_rod", "generate_frame", "generate_long_rod", "generate_ring", "generate_round", "generate_screw")
.components([<material:hafnium_carbide> * 4, <material:rhenium> * 1, <material:tantalum_carbide> * 4, <material:hastelloy_x> * 16])
.colorAverage()
.build();

//-----------------------------------FLUIDS-----------------------------------

function generateHighPressureGases(material as string, id as int){
    var color = Utils.material(material).materialRGB;

    MaterialBuilder(id, "hot_hp_" + material)
    .fluid("gas")
    .fluidTemp(323)
    .color(color)
    .components([Utils.material(material) * 1])
    .flags(["disable_decomposition"])
    .build();

    MaterialBuilder(id + 1, "hp_" + material)
    .fluid("gas")
    .color(color)
    .components([Utils.material(material) * 1])
    .flags(["disable_decomposition"])
    .build();

    MaterialBuilder(id + 2, "cold_hp_" + material)
    .fluid("gas")
    .fluidTemp(223)
    .color(color)
    .components([Utils.material(material) * 1])
    .flags(["disable_decomposition"])
    .build();

    MaterialBuilder(id + 3, "hot_" + material)
    .fluid()
    .fluidTemp(323)
    .color(color)
    .components([Utils.material(material) * 1])
    .flags(["disable_decomposition"])
    .build();
}

generateHighPressureGases("hydrogen", 10000);

generateHighPressureGases("oxygen", 10004);

generateHighPressureGases("helium", 10008);

generateHighPressureGases("neon", 10012);

generateHighPressureGases("argon", 10016);

generateHighPressureGases("krypton", 10020);

generateHighPressureGases("xenon", 10024);

generateHighPressureGases("air", 10028);

generateHighPressureGases("nitrogen", 10032);

generateHighPressureGases("nether_air", 10036);

generateHighPressureGases("ender_air", 10040);

function generateLiquidFromGas(material as string, id as int, boilingTemperature as int, useGtPrefix as bool){
    var color = Utils.material(material).materialRGB;
    var prefix = "liquid_";

    if (useGtPrefix) {
        prefix = "liquid_gt_";
        //Used in case there is conflicting liquid names with other mods
    }

    MaterialBuilder(id, prefix + material)
    .fluid()
    .fluidTemp(boilingTemperature)
    .color(color)
    .components([Utils.material(material) * 1])
    .flags(["disable_decomposition"])
    .build();
}

generateLiquidFromGas("hydrogen", 10100, 21, true);

generateLiquidFromGas("helium", 10101, 5, true);

generateLiquidFromGas("neon", 10102, 27, true);

generateLiquidFromGas("argon", 10103, 88, true);

generateLiquidFromGas("krypton", 10104, 120, false);

generateLiquidFromGas("xenon", 10105, 165, false);

generateLiquidFromGas("nitrogen", 10106, 77, true);

//Thermo Refrigerants

function generateThermoRefrigerant(material as string, id as int){
    var color = Utils.material(material).materialRGB;

    MaterialBuilder(id, "hot_compressed_" + material)
    .fluid("gas")
    .fluidTemp(323)
    .color(color)
    .components([Utils.material(material) * 1])
    .flags(["disable_decomposition"])
    .build();

    MaterialBuilder(id + 1, "compressed_" + material)
    .fluid("gas")
    .color(color)
    .components([Utils.material(material) * 1])
    .flags(["disable_decomposition"])
    .build();

    MaterialBuilder(id + 2, "cold_compressed_" + material)
    .fluid("gas")
    .fluidTemp(223)
    .color(color)
    .components([Utils.material(material) * 1])
    .flags(["disable_decomposition"])
    .build();

    MaterialBuilder(id + 3, "cold_" + material)
    .fluid("gas")
    .fluidTemp(223)
    .color(color)
    .components([Utils.material(material) * 1])
    .flags(["disable_decomposition"])
    .build();
}

generateThermoRefrigerant("ammonia", 10300);

generateThermoRefrigerant("propane", 10304);

generateThermoRefrigerant("carbon_dioxide", 10308);

//Coolants

function generateCoolant(material as string, id as int){
    var color = Utils.material(material).materialRGB;

    MaterialBuilder(id, "warm_" + material)
    .fluid()
    .fluidTemp(303)
    .color(color)
    .components([Utils.material(material) * 1])
    .flags(["disable_decomposition"])
    .build();
}

generateCoolant("water", 10400);

generateCoolant("ethylene_glycol", 10405);

generateCoolant("brine", 10410);

//Sulfurous water
MaterialBuilder(11000, "sulfurous_water")
.fluid()
.color(0x592893)
.build();

//Oxide water
MaterialBuilder(11001, "oxide_water")
.fluid()
.color(0x538020)
.build();

//Mineralized water
MaterialBuilder(11002, "mineralized_water")
.fluid()
.color(0x129077)
.build();

//Silicate water
MaterialBuilder(11003, "silicate_water")
.fluid()
.color(0x651526)
.build();

//Graphite water
MaterialBuilder(11004, "graphite_water")
.fluid()
.color(0x793000)
.build();

//Phosphate water
MaterialBuilder(11005, "phosphate_water")
.fluid()
.color(0x540032)
.build();

//Precious water
MaterialBuilder(11006, "precious_runoff")
.fluid()
.color(0x129077)
.build();

//Radioactive water
MaterialBuilder(11007, "radioactive_runoff")
.fluid()
.color(0x129077)
.build();

//Silicon solution
MaterialBuilder(11008, "silicon_solution")
.fluid()
.color(0x1f1c1c)
.build();

//Novolacs
MaterialBuilder(11009, "novolacs")
.fluid()
.color(0x54240c)
.build();

//Copper Sulfate
MaterialBuilder(11010, "copper_sulfate")
.fluid()
.components([<material:copper> * 1, <material:sulfur> * 1, <material:oxygen> * 4])
.colorAverage()
.build();

//Desalted Light Oil
MaterialBuilder(11011, "desalted_light_oil")
.fluid()
.color(0x000000)
.build();

//Desalted Oil
MaterialBuilder(11012, "desalted_oil")
.fluid()
.color(0x000000)
.build();

//Desalted Heavy Oil
MaterialBuilder(11013, "desalted_heavy_oil")
.fluid()
.color(0x000000)
.build();

//Desalted Raw Oil
MaterialBuilder(11014, "desalted_medium_oil")
.fluid()
.color(0x000000)
.build();

//Light Sulfuric Naphtha
MaterialBuilder(11015, "sulfuric_light_naphtha")
.fluid()
.color(0xe3c576)
.build();

//Light Naphtha
MaterialBuilder(11016, "light_naphtha")
.fluid()
.color(0xf5db95)
.build();

//Sulfuric Lubricant
MaterialBuilder(11017, "sulfuric_lubricant")
.fluid()
.color(0xc4b489)
.build();

//Oil Residue
MaterialBuilder(11018, "oil_residue")
.fluid()
.color(0x000000)
.build();

//Gold Chloride
MaterialBuilder(11019, "gold_chloride")
.fluid()
.components([<material:gold> * 2, <material:chlorine> * 6])
.colorAverage()
.build();

//Silicon Tetrachloride
MaterialBuilder(11020, "silicon_tetrachloride")
.fluid()
.components([<material:silicon> * 1, <material:chlorine> * 4])
.colorAverage()
.build();

//Trichlorosilane
MaterialBuilder(11021, "trichlorosilane")
.fluid()
.components([<material:hydrogen> * 1, <material:silicon> * 1, <material:chlorine> * 3])
.colorAverage()
.build();

//Dichlorosilane
MaterialBuilder(11022, "dichlorosilane")
.fluid("gas")
.components([<material:silicon> * 1, <material:hydrogen> * 2, <material:chlorine> * 2])
.colorAverage()
.build();

//Silane
MaterialBuilder(11023, "silane")
.fluid("gas")
.components([<material:silicon> * 1, <material:hydrogen> * 4])
.colorAverage()
.build();

//Trichlorosilane Solution
MaterialBuilder(11024, "trichlorosilane_solution")
.fluid()
.flags(["disable_decomposition"])
.components([<material:silicon_tetrachloride> * 1, <material:trichlorosilane> * 8])
.colorAverage()
.build();

//Chlorosilane
MaterialBuilder(11025, "chlorosilane")
.fluid("gas")
.components([<material:silicon> * 1, <material:hydrogen> * 3, <material:chlorine> * 1])
.colorAverage()
.build();

MaterialBuilder(11030, "filtered_air")
.fluid()
.color(0x7ab5c4)
.build();

generateLiquidFromGas("filtered_air", 10107, 77, false);
generateHighPressureGases("filtered_air", 10044);

MaterialBuilder(11031, "separated_natural_gas")
.fluid("gas")
.color(0xc9c9c9)
.build();

MaterialBuilder(11034, "treated_natural_gas")
.fluid("gas")
.color(0xdbdbdb)
.build();

MaterialBuilder(11035, "purified_natural_gas")
.fluid("gas")
.color(0xffffff)
.build();

MaterialBuilder(11036, "lightly_hydrocracked_light_naphtha")
.fluid()
.color(0xf5db95)
.build();

MaterialBuilder(11037, "severely_hydrocracked_light_naphtha")
.fluid()
.color(0xf5db95)
.build();

MaterialBuilder(11038, "lightly_steamcracked_light_naphtha")
.fluid()
.color(0xf5db95)
.build();

MaterialBuilder(11039, "severely_steamcracked_light_naphtha")
.fluid()
.color(0xf5db95)
.build();

MaterialBuilder(11040, "naphtha_mix")
.fluid()
.color(0xcca61d)
.build();

MaterialBuilder(11041, "mesityl_oxide")
.fluid()
.components([<material:carbon> * 6, <material:hydrogen> * 10, <material:oxygen> * 1])
.colorAverage()
.build();

MaterialBuilder(11042, "methyl_isobutyl_ketone")
.fluid()
.components([<material:carbon> * 6, <material:hydrogen> * 12, <material:oxygen> * 1])
.colorAverage()
.build();

MaterialBuilder(11043, "tributyl_phosphate")
.fluid()
.components([<material:carbon> * 12, <material:hydrogen> * 27, <material:oxygen> * 4, <material:phosphorus> * 1])
.colorAverage()
.build();

MaterialBuilder(11044, "flibe_gt")
.fluid()
.dust()
.components([<material:fluorine> * 3, <material:lithium> * 1, <material:beryllium> * 1])
.colorAverage()
.build();

MaterialBuilder(11045, "fluorite")
.dust()
.fluid()
.components([<material:calcium> * 1, <material:fluorine> * 2])
.colorAverage()
.build();

MaterialBuilder(11046, "villiaumite")
.dust()
.fluid()
.components([<material:sodium> * 1, <material:fluorine> * 1])
.colorAverage()
.build();

MaterialBuilder(11047, "carobbiite")
.dust()
.fluid()
.components([<material:potassium> * 1, <material:fluorine> * 1])
.colorAverage()
.build();

MaterialBuilder(11048, "sea_water")
.fluid()
.color(0x5b9acf)
.build();

MaterialBuilder(11049, "acidic_brine")
.fluid()
.color(0xeb7134)
.build();

MaterialBuilder(11050, "iodine_solution")
.fluid()
.color(0xeb4c34)
.build();

MaterialBuilder(11051, "evaporated_iodine")
.fluid("gas")
.color(0x961139)
.build();

MaterialBuilder(11052, "hydrogen_iodide")
.fluid("gas")
.flags("disable_decomposition")
.components([<material:hydrogen> * 1, <material:iodine> * 1])
.colorAverage()
.build();

MaterialBuilder(11053, "bischloroethyl")
.fluid()
.components([<material:carbon> * 4, <material:hydrogen> * 8, <material:chlorine> * 2, <material:oxygen> * 1])
.colorAverage()
.build();

MaterialBuilder(11054, "dibenzocrown")
.fluid()
.components([<material:carbon> * 20, <material:hydrogen> * 24, <material:oxygen> * 6])
.colorAverage()
.build();

MaterialBuilder(11055, "flue_gas")
.fluid("gas")
.fluidTemp(1366)
.color(0x3e3f40)
.build();

MaterialBuilder(11056, "smoke_bomb_mix")
.fluid()
.color(0xbfbfbf)
.build();

MaterialBuilder(11057, "exhauststeam")
.fluid("gas")
.fluidTemp(523)
.color(0x7a7a7a)
.build();

MaterialBuilder(11058, "calcium_carbonate_solution")
.fluid()
.color(0x8c8981)
.build();

MaterialBuilder(11059, "bentonite_clay_solution")
.fluid()
.color(0xa2bdb5)
.build();

//----------------------------------ISOTOPES---------------------------------

Elements.add(43, 55, -1, null, "Technetium-99", "Tc-99", true);

MaterialBuilder(31000, "technetium_99")
.element("Technetium-99")
.dust()
.color(0xa6a39a)
.iconSet("shiny")
.build();

Elements.add(84, 126, -1, null, "Polonium-210", "Po-210", true);

MaterialBuilder(31010, "polonium_210")
.element("Polonium-210")
.dust()
.color(0xe68a8a)
.build();

Elements.add(85, 124, -1, null, "Astatine-209", "At-209", true);

MaterialBuilder(31020, "astatine_209")
.element("Astatine-209")
.dust()
.color(0x91cca0)
.build();

Elements.add(85, 125, -1, null, "Astatine-210", "At-210", true);

MaterialBuilder(31021, "astatine_210")
.element("Astatine-210")
.dust()
.color(0x81b58e)
.build();

Elements.add(85, 126, -1, null, "Astatine-211", "At-211", true);

MaterialBuilder(31022, "astatine_211")
.element("Astatine-211")
.dust()
.color(0x6c9677)
.build();

Elements.add(87, 125, -1, null, "Francium-212", "Fr-212", true);

MaterialBuilder(31030, "francium_212")
.element("Francium-212")
.dust()
.color(0xbfbf97)
.build();

Elements.add(87, 134, -1, null, "Francium-221", "Fr-221", true);

MaterialBuilder(31031, "francium_221")
.element("Francium-221")
.dust()
.color(0xa3a381)
.build();

Elements.add(87, 135, -1, null, "Francium-222", "Fr-222", true);

MaterialBuilder(31032, "francium_222")
.element("Francium-222")
.dust()
.color(0x8a8a6d)
.build();

Elements.add(87, 136, -1, null, "Francium-223", "Fr-223", true);

MaterialBuilder(31033, "francium_223")
.element("Francium-223")
.dust()
.color(0x707058)
.build();

Elements.add(88, 135, -1, null, "Radium-223", "Ra-223", true);

MaterialBuilder(31040, "radium_223")
.element("Radium-223")
.dust()
.color(0x96a37c)
.build();

Elements.add(88, 136, -1, null, "Radium-224", "Ra-224", true);

MaterialBuilder(31041, "radium_224")
.element("Radium-224")
.dust()
.color(0x7f8a69)
.build();

Elements.add(88, 137, -1, null, "Radium-225", "Ra-225", true);

MaterialBuilder(31042, "radium_225")
.element("Radium-225")
.dust()
.color(0x677055)
.build();

Elements.add(88, 138, -1, null, "Radium-226", "Ra-226", true);

MaterialBuilder(31043, "radium_226")
.element("Radium-226")
.dust()
.color(0x545c46)
.build();

Elements.add(88, 140, -1, null, "Radium-228", "Ra-228", true);

MaterialBuilder(31044, "radium_228")
.element("Radium-228")
.dust()
.color(0x414736)
.build();

Elements.add(89, 136, -1, null, "Actinium-225", "Ac-225", true);

MaterialBuilder(31050, "actinium_225")
.element("Actinium-225")
.dust()
.color(0x87a8a1)
.build();

Elements.add(89, 137, -1, null, "Actinium-226", "Ac-226", true);

MaterialBuilder(31051, "actinium_226")
.element("Actinium-226")
.dust()
.color(0x74918b)
.build();

Elements.add(89, 138, -1, null, "Actinium-227", "Ac-227", true);

MaterialBuilder(31052, "actinium_227")
.element("Actinium-227")
.dust()
.color(0x627a75)
.build();

Elements.add(91, 140, -1, null, "Protactinium-231", "Pa-231", true);

MaterialBuilder(31060, "protactinium_231")
.element("Protactinium-231")
.dust()
.color(0x62727a)
.build();

Elements.add(91, 142, -1, null, "Protactinium-233", "Pa-233", true);

MaterialBuilder(31061, "protactinium_233")
.element("Protactinium-233")
.dust()
.color(0x525f66)
.build();

function addNuclearFuelMaterials (materialName as string, startingInt as int) {
    MaterialBuilder(startingInt + 1, materialName + "_carbide")
    .ingot()
    .components([Utils.material(materialName) * 1, <material:carbon> * 1])
    .colorAverage()
    .build();

    MaterialBuilder(startingInt + 2, materialName + "_oxide")
    .ingot()
    .components([Utils.material(materialName) * 1, <material:oxygen> * 2])
    .colorAverage()
    .build();

    MaterialBuilder(startingInt + 3, materialName + "_nitride")
    .ingot()
    .components([Utils.material(materialName) * 1, <material:nitrogen> * 1])
    .colorAverage()
    .build();

    MaterialBuilder(startingInt + 4, materialName + "_z_a")
    .ingot()
    .flags(["disable_decomposition"])
    .components([Utils.material(materialName) * 1, <material:zirconium> * 1])
    .colorAverage()
    .build();
}

Elements.add(92, 141, -1, null, "Uranium-233", "U-233", true);

MaterialBuilder(31070, "uranium_233")
.element("Uranium-233")
.fluid()
.fluidTemp(1405)
.ingot()
.color(0x167514)
.build();

addNuclearFuelMaterials("uranium_233", 31070);

addNuclearFuelMaterials("uranium_235", 31080);

addNuclearFuelMaterials("uranium", 31090);

Elements.add(93, 143, -1, null, "Neptunium-236", "Np-236", true);

MaterialBuilder(31100, "neptunium_236")
.element("Neptunium-236")
.fluid()
.fluidTemp(917)
.ingot()
.color(0x567699)
.build();

addNuclearFuelMaterials("neptunium_236", 31100);

Elements.add(93, 144, -1, null, "Neptunium-237", "Np-237", true);

MaterialBuilder(31110, "neptunium_237")
.element("Neptunium-237")
.fluid()
.fluidTemp(917)
.ingot()
.color(0x476280)
.build();

addNuclearFuelMaterials("neptunium_237", 31110);

Elements.add(94, 144, -1, null, "Plutonium-238", "Pu-238", true);

MaterialBuilder(31120, "plutonium_238")
.element("Plutonium-238")
.fluid()
.fluidTemp(913)
.ingot()
.color(0xd42f2f)
.build();

addNuclearFuelMaterials("plutonium_238", 31120);

Elements.add(94, 148, -1, null, "Plutonium-242", "Pu-242", true);

MaterialBuilder(31130, "plutonium_242")
.element("Plutonium-242")
.fluid()
.fluidTemp(913)
.ingot()
.color(0xa81111)
.build();

addNuclearFuelMaterials("plutonium_242", 31130);

addNuclearFuelMaterials("plutonium", 31290);

addNuclearFuelMaterials("plutonium_241", 31300);

Elements.add(95, 146, -1, null, "Americium-241", "Am-241", true);

MaterialBuilder(31140, "americium_241")
.element("Americium-241")
.fluid()
.fluidTemp(1449)
.ingot()
.color(0x0e474a)
.build();

addNuclearFuelMaterials("americium_241", 31140);

Elements.add(95, 147, -1, null, "Americium-242", "Am-242", true);

MaterialBuilder(31150, "americium_242")
.element("Americium-242")
.fluid()
.fluidTemp(1449)
.ingot()
.color(0x0a3336)
.build();

addNuclearFuelMaterials("americium_242", 31150);

Elements.add(95, 148, -1, null, "Americium-243", "Am-243", true);

MaterialBuilder(31160, "americium_243")
.element("Americium-243")
.fluid()
.fluidTemp(1449)
.ingot()
.color(0x092729)
.build();

addNuclearFuelMaterials("americium_243", 31160);

Elements.add(96, 147, -1, null, "Curium-243", "Cm-243", true);

MaterialBuilder(31170, "curium_243")
.element("Curium-243")
.fluid()
.fluidTemp(1613)
.ingot()
.color(0x4b0f73)
.build();

addNuclearFuelMaterials("curium_243", 31170);

Elements.add(96, 149, -1, null, "Curium-245", "Cm-245", true);

MaterialBuilder(31180, "curium_245")
.element("Curium-245")
.fluid()
.fluidTemp(1613)
.ingot()
.color(0x400f61)
.build();

addNuclearFuelMaterials("curium_245", 31180);

Elements.add(96, 150, -1, null, "Curium-246", "Cm-246", true);

MaterialBuilder(31190, "curium_246")
.element("Curium-246")
.fluid()
.fluidTemp(1613)
.ingot()
.color(0x360e52)
.build();

addNuclearFuelMaterials("curium_246", 31190);

Elements.add(96, 151, -1, null, "Curium-247", "Cm-247", true);

MaterialBuilder(31200, "curium_247")
.element("Curium-247")
.fluid()
.fluidTemp(1613)
.ingot()
.color(0x2c0d42)
.build();

addNuclearFuelMaterials("curium_247", 31200);

Elements.add(97, 150, -1, null, "Berkelium-247", "Bk-247", true);

MaterialBuilder(31210, "berkelium_247")
.element("Berkelium-247")
.fluid()
.fluidTemp(1257)
.ingot()
.color(0x63280f)
.build();

addNuclearFuelMaterials("berkelium_247", 31210);

Elements.add(97, 151, -1, null, "Berkelium-248", "Bk-248", true);

MaterialBuilder(31220, "berkelium_248")
.element("Berkelium-248")
.fluid()
.fluidTemp(1257)
.ingot()
.color(0x52230f)
.build();

addNuclearFuelMaterials("berkelium_248", 31220);

Elements.add(98, 151, -1, null, "Californium-249", "Cf-249", true);

MaterialBuilder(31230, "californium_249")
.element("Californium-249")
.fluid()
.fluidTemp(1171)
.ingot()
.color(0x631212)
.build();

addNuclearFuelMaterials("californium_249", 31230);

Elements.add(98, 152, -1, null, "Californium-250", "Cf-250", true);

MaterialBuilder(31240, "californium_250")
.element("Californium-250")
.fluid()
.fluidTemp(1171)
.ingot()
.color(0x521010)
.build();

addNuclearFuelMaterials("californium_250", 31240);

Elements.add(98, 153, -1, null, "Californium-251", "Cf-251", true);

MaterialBuilder(31250, "californium_251")
.element("Californium-251")
.fluid()
.fluidTemp(1171)
.ingot()
.color(0x451010)
.build();

addNuclearFuelMaterials("californium_251", 31250);

Elements.add(98, 154, -1, null, "Californium-252", "Cf-252", true);

MaterialBuilder(31260, "californium_252")
.element("Californium-252")
.fluid()
.fluidTemp(1171)
.ingot()
.color(0x401111)
.build();

addNuclearFuelMaterials("californium_252", 31260);

Elements.add(5, 5, -1, null, "Boron-10", "B-10", true);

MaterialBuilder(31270, "boron_10")
.element("Boron-10")
.ingot()
.color(0x9c9c9c)
.build();

Elements.add(5, 6, -1, null, "Boron-11", "B-11", true);

MaterialBuilder(31271, "boron_11")
.element("Boron-11")
.ingot()
.color(0x7a7a7a)
.build();

Elements.add(11, 11, -1, null, "Sodium-22", "Na-22", true);

MaterialBuilder(31272, "sodium_22")
.element("Sodium-22")
.ingot()
.color(0xb87f7f)
.build();

Elements.add(12, 12, -1, null, "Magnesium-24", "Mg-24", true);

MaterialBuilder(31273, "magnesium_24")
.element("Magnesium-24")
.ingot()
.color(0xd6a1d4)
.build();

Elements.add(12, 14, -1, null, "Magnesium-26", "Mg-26", true);

MaterialBuilder(31274, "magnesium_26")
.element("Magnesium-26")
.ingot()
.color(0xc49bc3)
.build();

Elements.add(92, 142, -1, null, "Uranium-234", "U-234", true);

MaterialBuilder(31275, "uranium_234")
.element("Uranium-234")
.ingot()
.color(0x10610f)
.build();

Elements.add(27, 33, -1, null, "Cobalt-60", "Co-60", true);

MaterialBuilder(31276, "cobalt_60")
.element("Cobalt-60")
.ingot()
.color(0x326799)
.build();

Elements.add(77, 115, -1, null, "Iridium-192", "Ir-192", true);

MaterialBuilder(31277, "iridium_192")
.element("Iridium-192")
.ingot()
.color(0xb293ba)
.build();

Elements.add(20, 28, -1, null, "Calcium-48", "Ca-48", true);

MaterialBuilder(31278, "calcium_48")
.element("Calcium-48")
.dust()
.ingot()
.color(0xb8bd91)
.build();

Elements.add(38, 52, -1, null, "Strontium-90", "Sr-90", true);

MaterialBuilder(31280, "strontium_90")
.element("Strontium-90")
.ingot()
.color(0xa8a887)
.build();

Elements.add(44, 62, -1, null, "Ruthenium-106", "Ru-106", true);

MaterialBuilder(31281, "ruthenium_106")
.element("Ruthenium-106")
.ingot()
.color(0xdbdbcc)
.build();

Elements.add(55, 82, -1, null, "Caesium-137", "Cs-137", true);

MaterialBuilder(31282, "caesium_137")
.element("Caesium-137")
.ingot()
.color(0xc2c2be)
.build();

Elements.add(61, 86, -1, null, "Promethium-147", "Pm-147", true);

MaterialBuilder(31283, "promethium_147")
.element("Promethium-147")
.ingot()
.color(0xabdbb5)
.build();

Elements.add(63, 92, -1, null, "Europium-155", "Eu-155", true);

MaterialBuilder(31284, "europium_155")
.element("Europium-155")
.ingot()
.color(0x403a24)
.build();

Elements.add(90, 142, -1, null, "Thorium-232", "Th-232", true);

MaterialBuilder(31285, "thorium_232")
.element("Thorium-232")
.ingot()
.color(0x151c17)
.build();

addNuclearFuelMaterials("thorium_232", 31330);

Elements.add(112, 179, -1, null, "Copernicium-291", "Cn-291", true);

MaterialBuilder(31310, "copernicium_291")
.element("Copernicium-291")
.ingot()
.color(0xe0c653)
.build();

addNuclearFuelMaterials("copernicium_291", 31310);

Elements.add(79, 119, -1, null, "Gold-198", "Au-198", true);

MaterialBuilder(31321, "gold_198")
.element("Gold-198")
.ingot()
.color(0xa8a432)
.build();

//-------------------------------------NUCLEAR MATERIALS----------------------------------------

function addNuclearFuels (prefixOne as string, prefixTwo as string, fuelNumber as string, materialOne as string, materialTwo as string, startingInt as int) {
    var a = MaterialBuilder(startingInt, prefixOne + "_" + fuelNumber)
    .ingot()
    .fluid()
    .flags(["disable_decomposition"])
    .components([Utils.material(materialOne) * 8, Utils.material(materialTwo) * 1])
    .colorAverage()
    .build();

    MaterialBuilder(startingInt + 1, prefixOne + "_" + fuelNumber + "_oxide")
    .ingot()
    .flags(["disable_decomposition"])
    .components([Utils.material(materialOne + "_oxide") * 8, Utils.material(materialTwo + "_oxide") * 1])
    .colorAverage()
    .build();

    MaterialBuilder(startingInt + 2, prefixOne + "_" + fuelNumber + "_nitride")
    .ingot()
    .flags(["disable_decomposition"])
    .components([Utils.material(materialOne + "_nitride") * 8, Utils.material(materialTwo + "_nitride") * 1])
    .colorAverage()
    .build();

    MaterialBuilder(startingInt + 3, prefixOne + "_" + fuelNumber + "_z_a")
    .ingot()
    .flags(["disable_decomposition"])
    .components([Utils.material(materialOne + "_z_a") * 8, Utils.material(materialTwo + "_z_a") * 1])
    .colorAverage()
    .build();

    MaterialBuilder(startingInt + 4, prefixOne + "_" + fuelNumber + "_t_r_i_s_o")
    .ingot()
    .flags(["disable_decomposition"])
    .components([Utils.material(materialOne) * 8, Utils.material(materialTwo) * 1, <material:carbon> * 3, <material:silicon_carbide> * 1])
    .colorAverage()
    .build();

    MaterialBuilder(startingInt + 5, "depleted_" + prefixOne + "_" + fuelNumber + "_oxide")
    .ingot()
    .flags(["disable_decomposition"])
    .components([<material:mystery> * 1, a * 1, <material:oxygen> * 1])
    .colorAverage()
    .build();

    MaterialBuilder(startingInt + 6, "depleted_" + prefixOne + "_" + fuelNumber + "_nitride")
    .ingot()
    .flags(["disable_decomposition"])
    .components([<material:mystery> * 1, a * 1, <material:nitrogen> * 1])
    .colorAverage()
    .build();

    MaterialBuilder(startingInt + 7, "depleted_" + prefixOne + "_" + fuelNumber + "_z_a")
    .ingot()
    .flags(["disable_decomposition"])
    .components([<material:mystery> * 1, a * 1, <material:zirconium> * 1])
    .colorAverage()
    .build();

    MaterialBuilder(startingInt + 8, "depleted_" + prefixOne + "_" + fuelNumber + "_t_r_i_s_o")
    .ingot()
    .flags(["disable_decomposition"])
    .components([<material:mystery> * 1, a * 1, <material:carbon> * 3, <material:silicon_carbide> * 1])
    .colorAverage()
    .build();

    var b = MaterialBuilder(startingInt + 9, prefixTwo + "_" + fuelNumber)
    .ingot()
    .flags(["disable_decomposition"])
    .components([Utils.material(materialOne) * 6, Utils.material(materialTwo) * 3])
    .colorAverage()
    .build();

    MaterialBuilder(startingInt + 10, prefixTwo + "_" + fuelNumber + "_oxide")
    .ingot()
    .flags(["disable_decomposition"])
    .components([Utils.material(materialOne + "_oxide") * 6, Utils.material(materialTwo + "_oxide") * 3])
    .colorAverage()
    .build();

    MaterialBuilder(startingInt + 11, prefixTwo + "_" + fuelNumber + "_nitride")
    .ingot()
    .flags(["disable_decomposition"])
    .components([Utils.material(materialOne + "_nitride") * 6, Utils.material(materialTwo + "_nitride") * 3])
    .colorAverage()
    .build();

    MaterialBuilder(startingInt + 12, prefixTwo + "_" + fuelNumber + "_z_a")
    .ingot()
    .flags(["disable_decomposition"])
    .components([Utils.material(materialOne + "_z_a") * 6, Utils.material(materialTwo + "_z_a") * 3])
    .colorAverage()
    .build();

    MaterialBuilder(startingInt + 13, prefixTwo + "_" + fuelNumber + "_t_r_i_s_o")
    .ingot()
    .flags(["disable_decomposition"])
    .components([Utils.material(materialOne) * 6, Utils.material(materialTwo) * 3, <material:carbon> * 3, <material:silicon_carbide> * 1])
    .colorAverage()
    .build();

    MaterialBuilder(startingInt + 14, "depleted_" + prefixTwo + "_" + fuelNumber + "_oxide")
    .ingot()
    .flags(["disable_decomposition"])
    .components([<material:mystery> * 1, b * 1, <material:oxygen> * 1])
    .colorAverage()
    .build();

    MaterialBuilder(startingInt + 15, "depleted_" + prefixTwo + "_" + fuelNumber + "_nitride")
    .ingot()
    .flags(["disable_decomposition"])
    .components([<material:mystery> * 1, b * 1, <material:nitrogen> * 1])
    .colorAverage()
    .build();

    MaterialBuilder(startingInt + 16, "depleted_" + prefixTwo + "_" + fuelNumber + "_z_a")
    .ingot()
    .flags(["disable_decomposition"])
    .components([<material:mystery> * 1, b * 1, <material:zirconium> * 1])
    .colorAverage()
    .build();

    MaterialBuilder(startingInt + 17, "depleted_" + prefixTwo + "_" + fuelNumber + "_t_r_i_s_o")
    .ingot()
    .flags(["disable_decomposition"])
    .components([<material:mystery> * 1, b * 1, <material:carbon> * 3, <material:silicon_carbide> * 1])
    .colorAverage()
    .build();

    MaterialBuilder(startingInt + 18, prefixOne + "_" + fuelNumber + "_carbide")
    .ingot()
    .flags(["disable_decomposition"])
    .components([Utils.material(materialOne + "_carbide") * 8, Utils.material(materialTwo + "_carbide") * 1])
    .colorAverage()
    .build();

    MaterialBuilder(startingInt + 19, prefixTwo + "_" + fuelNumber + "_carbide")
    .ingot()
    .flags(["disable_decomposition"])
    .components([Utils.material(materialOne + "_carbide") * 6, Utils.material(materialTwo + "_carbide") * 3])
    .colorAverage()
    .build();

    var c = MaterialBuilder(startingInt + 22, prefixOne + "_" + fuelNumber + "_fluoride")
    .fluidTemp(1700)
    .flags(["disable_decomposition"])
    .components([a * 1, <material:fluorine> * 1])
    .colorAverage()
    .build();

    var d = MaterialBuilder(startingInt + 23, prefixTwo + "_" + fuelNumber + "_fluoride")
    .fluidTemp(1700)
    .flags(["disable_decomposition"])
    .components([b * 1, <material:fluorine> * 1])
    .colorAverage()
    .build();

    MaterialBuilder(startingInt + 24, prefixOne + "_" + fuelNumber + "_fluoride_flibe")
    .fluidTemp(1700)
    .flags(["disable_decomposition"])
    .components([c * 1, <material:flibe_gt> * 1])
    .colorAverage()
    .build();

    MaterialBuilder(startingInt + 25, prefixTwo + "_" + fuelNumber + "_fluoride_flibe")
    .fluidTemp(1700)
    .flags(["disable_decomposition"])
    .components([d * 1, <material:flibe_gt> * 1])
    .colorAverage()
    .build();

    var g = MaterialBuilder(startingInt + 26, "depleted_" + prefixOne + "_" + fuelNumber)
    .fluidTemp(1700)
    .components([a * 1, <material:mystery> * 1])
    .flags(["disable_decomposition"])
    .colorAverage()
    .build();

    var h = MaterialBuilder(startingInt + 27, "depleted_" + prefixTwo + "_" + fuelNumber)
    .fluidTemp(1700)
    .components([b * 1, <material:mystery> * 1])
    .flags(["disable_decomposition"])
    .colorAverage()
    .build();

    var i = MaterialBuilder(startingInt + 28, "depleted_" + prefixOne + "_" + fuelNumber + "_fluoride")
    .fluidTemp(1700)
    .components([g * 1, <material:fluorine> * 1])
    .colorAverage()
    .build();

    var j = MaterialBuilder(startingInt + 29, "depleted_" + prefixTwo + "_" + fuelNumber + "_fluoride")
    .fluidTemp(1700)
    .components([h * 1, <material:fluorine> * 1])
    .colorAverage()
    .build();

    MaterialBuilder(startingInt + 30, "depleted_" + prefixOne + "_" + fuelNumber + "_fluoride_flibe")
    .fluidTemp(1700)
    .components([i * 1, <material:flibe_gt> * 1])
    .colorAverage()
    .build();

    MaterialBuilder(startingInt + 31, "depleted_" + prefixTwo + "_" + fuelNumber + "_fluoride_flibe")
    .fluidTemp(1700)
    .components([j * 1, <material:flibe_gt> * 1])
    .colorAverage()
    .build();
}

addNuclearFuels ("l_e_u", "h_e_u", "233", "uranium", "uranium_233", 8000);
addNuclearFuels ("l_e_u", "h_e_u", "235", "uranium", "uranium_235", 8040);
addNuclearFuels ("l_e_n", "h_e_n", "236", "neptunium_237", "neptunium_236", 8080);
addNuclearFuels ("l_e_p", "h_e_p", "239", "plutonium_242", "plutonium", 8120);
addNuclearFuels ("l_e_p", "h_e_p", "241", "plutonium_242", "plutonium_241", 8160);
addNuclearFuels ("l_e_a", "h_e_a", "242", "americium_243", "americium_242", 8200);
addNuclearFuels ("l_e_cm", "h_e_cm", "243", "curium_246", "curium_243", 8240);
addNuclearFuels ("l_e_cm", "h_e_cm", "245", "curium_246", "curium_245", 8280);
addNuclearFuels ("l_e_cm", "h_e_cm", "247", "curium_246", "curium_247", 8320);
addNuclearFuels ("l_e_b", "h_e_b", "248", "berkelium_247", "berkelium_248", 8360);
addNuclearFuels ("l_e_cf", "h_e_cf", "249", "californium_252", "californium_249", 8400);
addNuclearFuels ("l_e_cf", "h_e_cf", "251", "californium_252", "californium_251", 8440);

function addSingleFuels (prefixOne as string, fuelNumber as string, materialOne as string, materialTwo as string, startingInt as int) {
    var a = MaterialBuilder(startingInt, prefixOne + "_" + fuelNumber)
    .ingot()
    .fluid()
    .fluidTemp(1700)
    .flags(["disable_decomposition"])
    .components([Utils.material(materialOne) * 8, Utils.material(materialTwo) * 1])
    .colorAverage()
    .build();

    MaterialBuilder(startingInt + 1, prefixOne + "_" + fuelNumber + "_carbide")
    .ingot()
    .flags(["disable_decomposition"])
    .components([Utils.material(materialOne + "_carbide") * 8, Utils.material(materialTwo + "_carbide") * 1])
    .colorAverage()
    .build();

    MaterialBuilder(startingInt + 2, prefixOne + "_" + fuelNumber + "_oxide")
    .ingot()
    .flags(["disable_decomposition"])
    .components([Utils.material(materialOne + "_oxide") * 8, Utils.material(materialTwo + "_oxide") * 1])
    .colorAverage()
    .build();

    MaterialBuilder(startingInt + 3, "depleted_" + prefixOne + "_" + fuelNumber + "_oxide")
    .ingot()
    .flags(["disable_decomposition"])
    .components([<material:mystery> * 1, a * 1, <material:oxygen> * 1])
    .colorAverage()
    .build();

    MaterialBuilder(startingInt + 4, prefixOne + "_" + fuelNumber + "_z_a")
    .ingot()
    .flags(["disable_decomposition"])
    .components([Utils.material(materialOne + "_z_a") * 8, Utils.material(materialTwo + "_z_a") * 1])
    .colorAverage()
    .build();

    MaterialBuilder(startingInt + 5, "depleted_" + prefixOne + "_" + fuelNumber + "_z_a")
    .ingot()
    .flags(["disable_decomposition"])
    .components([<material:mystery> * 1, a * 1, <material:zirconium> * 1])
    .colorAverage()
    .build();

    MaterialBuilder(startingInt + 6, prefixOne + "_" + fuelNumber + "_nitride")
    .ingot()
    .flags(["disable_decomposition"])
    .components([Utils.material(materialOne + "_nitride") * 8, Utils.material(materialTwo + "_nitride") * 1])
    .colorAverage()
    .build();

    MaterialBuilder(startingInt + 7, "depleted_" + prefixOne + "_" + fuelNumber + "_nitride")
    .ingot()
    .flags(["disable_decomposition"])
    .components([<material:mystery> * 1, a * 1, <material:nitrogen> * 1])
    .colorAverage()
    .build();

    MaterialBuilder(startingInt + 8, prefixOne + "_" + fuelNumber + "_t_r_i_s_o")
    .ingot()
    .flags(["disable_decomposition"])
    .components([Utils.material(materialOne) * 8, Utils.material(materialTwo) * 8, <material:carbon> * 3, <material:silicon_carbide> * 1])
    .colorAverage()
    .build();

    MaterialBuilder(startingInt + 9, "depleted_" + prefixOne + "_" + fuelNumber + "_t_r_i_s_o")
    .ingot()
    .flags(["disable_decomposition"])
    .components([<material:mystery> * 1, a * 1, <material:carbon> * 3, <material:silicon_carbide> * 1])
    .colorAverage()
    .build();

    var b = MaterialBuilder(startingInt + 11, prefixOne + "_" + fuelNumber + "_fluoride")
    .fluid()
    .fluidTemp(1700)
    .flags(["disable_decomposition"])
    .components([a * 1, <material:fluorine> * 1])
    .colorAverage()
    .build();

    MaterialBuilder(startingInt + 12, prefixOne + "_" + fuelNumber + "_fluoride_flibe")
    .fluid()
    .fluidTemp(1700)
    .flags(["disable_decomposition"])
    .components([b * 1, <material:flibe_gt> * 1])
    .colorAverage()
    .build();

    var d = MaterialBuilder(startingInt + 13, "depleted_" + prefixOne + "_" + fuelNumber)
    .fluid()
    .fluidTemp(1700)
    .flags(["disable_decomposition"])
    .components([<material:mystery> * 1, a * 1])
    .colorAverage()
    .build();

    var e = MaterialBuilder(startingInt + 14, "depleted_" + prefixOne + "_" + fuelNumber + "_fluoride")
    .fluid()
    .fluidTemp(1700)
    .components([d * 1, <material:fluorine> * 1])
    .colorAverage()
    .build();

    MaterialBuilder(startingInt + 15, "depleted_" + prefixOne + "_" + fuelNumber + "_fluoride_flibe")
    .fluid()
    .fluidTemp(1700)
    .components([e * 1, <material:flibe_gt> * 1])
    .colorAverage()
    .build();
}

addSingleFuels ("m_i_x", "239", "uranium", "plutonium", 8800);
addSingleFuels ("m_i_x", "241", "uranium", "plutonium_241", 8820);
addSingleFuels ("m_i_x", "291", "uranium", "copernicium_291", 8840);

MaterialBuilder(8900, "t_b_u")
.ingot()
.flags(["disable_decomposition"])
.components([<material:thorium_232> * 9])
.colorAverage()
.build();

MaterialBuilder(8901, "t_b_u_oxide")
.ingot()
.flags(["disable_decomposition"])
.components([<material:thorium_232_oxide> * 9])
.colorAverage()
.build();

MaterialBuilder(8902, "t_b_u_nitride")
.ingot()
.flags(["disable_decomposition"])
.components([<material:thorium_232_nitride> * 9])
.colorAverage()
.build();

MaterialBuilder(8903, "t_b_u_z_a")
.ingot()
.flags(["disable_decomposition"])
.components([<material:thorium_232_z_a> * 9])
.colorAverage()
.build();

MaterialBuilder(8904, "t_b_u_t_r_i_s_o")
.ingot()
.flags(["disable_decomposition"])
.components([<material:thorium_232> * 9, <material:carbon> * 3, <material:silicon_carbide> * 1])
.colorAverage()
.build();

MaterialBuilder(8905, "depleted_t_b_u")
.ingot()
.flags(["disable_decomposition"])
.components([<material:mystery> * 1])
.colorAverage()
.build();

MaterialBuilder(8906, "depleted_t_b_u_oxide")
.ingot()
.flags(["disable_decomposition"])
.components([<material:mystery> * 1, <material:oxygen> * 1])
.colorAverage()
.build();

MaterialBuilder(8907, "depleted_t_b_u_nitride")
.ingot()
.flags(["disable_decomposition"])
.components([<material:mystery> * 1, <material:nitrogen> * 1])
.colorAverage()
.build();

MaterialBuilder(8908, "depleted_t_b_u_z_a")
.ingot()
.flags(["disable_decomposition"])
.components([<material:mystery> * 1, <material:zirconium> * 1])
.colorAverage()
.build();

MaterialBuilder(8909, "depleted_t_b_u_t_r_i_s_o")
.ingot()
.flags(["disable_decomposition"])
.components([<material:mystery> * 1, <material:carbon> * 3, <material:silicon_carbide> * 1])
.colorAverage()
.build();

MaterialBuilder(8910, "t_b_u_carbide")
.ingot()
.flags(["disable_decomposition"])
.components([<material:thorium_232_carbide> * 9])
.colorAverage()
.build();

//---------------------------------CHANGES TO EXISTING MATERIALS-----------------------------------

<material:steel>.addFlags(["generate_spring", "generate_spring_small"]);
<material:titanium>.addFlags(["generate_spring", "generate_spring_small"]);
<material:lead>.addFlags(["generate_round"]);
<material:aluminium>.addFlags(["generate_round"]);
<material:refinedsilicon>.addFlags(["generate_gem", "GENERATE_BOULE"]);