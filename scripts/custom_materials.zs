#loader gregtech
#priority 1000

import mods.gregtech.material.MaterialBuilder;
import mods.gregtech.material.Material;
import mods.gregtech.material.Elements;
import mods.gregtech.recipe.Utils;

//----------------------------------ELEMENTS---------------------------------




//-----------------------------------DUSTS-----------------------------------

MaterialBuilder(1200, "zirconmoldbase")
.dust()
.color(0xbaa56a).iconSet("dull")
.build();

MaterialBuilder(1201, "zircon")
.dust()
.components([<material:zirconium> * 1, <material:silicon> * 1, <material:oxygen> * 4])
.flags(["disable_decomposition"])
.iconSet("shiny")
.build();

//-----------------------------------INGOTS-----------------------------------

MaterialBuilder(600, "vacuumsteel")
.ingot()
.color(0xC8C8DC).iconSet("shiny")
.flags(["generate_plate", "generate_gear", "generate_small_gear", "generate_rod", "generate_long_rod", "generate_bolt_screw", "generate_frame", "exclude_block_crafting_recipes", "exclude_plate_compressor_recipe", "exclude_block_crafting_by_hand_recipes"])
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
}

generateHighPressureGases("hydrogen", 10000);

generateHighPressureGases("oxygen", 10003);

generateHighPressureGases("helium", 10006);

generateHighPressureGases("neon", 10009);

generateHighPressureGases("argon", 10012);

generateHighPressureGases("krypton", 10015);

generateHighPressureGases("xenon", 10018);

generateHighPressureGases("air", 10021);

generateHighPressureGases("nitrogen", 10024);

function generateLiquidFromGas(material as string, id as int, boilingTemperature as int){
    var color = Utils.material(material).materialRGB;

    MaterialBuilder(id, "liquid_" + material)
    .fluid()
    .fluidTemp(boilingTemperature)
    .color(color)
    .components([Utils.material(material) * 1])
    .flags(["disable_decomposition"])
    .build();
}

generateLiquidFromGas("hydrogen", 11000, 21);

generateLiquidFromGas("helium", 11001, 5);

generateLiquidFromGas("neon", 11002, 27);

generateLiquidFromGas("argon", 11003, 88);

generateLiquidFromGas("krypton", 11004, 120);

generateLiquidFromGas("xenon", 11005, 165);

generateLiquidFromGas("nitrogen", 11006, 77);

function generateHotLiquid(material as string, id as int){
    var color = Utils.material(material).materialRGB;

    MaterialBuilder(id, "hot_" + material)
    .fluid()
    .fluidTemp(323)
    .color(color)
    .components([Utils.material(material) * 1])
    .flags(["disable_decomposition"])
    .build();
}

generateHotLiquid("air", 12000);

generateHotLiquid("brine", 12001);

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

    MaterialBuilder(id + 2, "cold_" + material)
    .fluid("gas")
    .fluidTemp(223)
    .color(color)
    .components([Utils.material(material) * 1])
    .flags(["disable_decomposition"])
    .build();
}

generateThermoRefrigerant("ammonia", 13000);

generateThermoRefrigerant("propane", 13003);

generateThermoRefrigerant("carbon_dioxide", 13006);

//Sulfurous water
MaterialBuilder(14000, "sulfurous_water")
.fluid()
.color(0x592893)
.build();

//Oxide water
MaterialBuilder(14001, "oxide_water")
.fluid()
.color(0x538020)
.build();

//Mineralized water
MaterialBuilder(14002, "mineralized_water")
.fluid()
.color(0x129077)
.build();

//Silicate water
MaterialBuilder(14003, "silicate_water")
.fluid()
.color(0x651526)
.build();

//Graphite water
MaterialBuilder(14004, "graphite_water")
.fluid()
.color(0x793000)
.build();

//Phosphate water
MaterialBuilder(14005, "phosphate_water")
.fluid()
.color(0x540032)
.build();

//Precious water
MaterialBuilder(14006, "precious_runoff")
.fluid()
.color(0x129077)
.build();

//Radioactive water
MaterialBuilder(14007, "radioactive_runoff")
.fluid()
.color(0x129077)
.build();

//-----------------------------------OTHER TWEAKS-----------------------------------

<material:steel>.addFlags(["generate_spring", "generate_spring_small"]);
<material:titanium>.addFlags(["generate_spring", "generate_spring_small"]);
<material:lead>.addFlags(["generate_round"]);
