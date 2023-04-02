import classes.*;

/*
println("Running OreSorting.groovy...")

int fluid_amount = 100;

def circuit(x) {
    return metaitem('circuit.integrated').withNbt([Configuration: x])
}

//FORMAT: ORE NAME : CHANCE (out of 10000)

def sulfur_tier_1 = [
    'gregtech:ore_Sulfur_0' : 10000,
    'gregtech:ore_Bornite_0' : 10000,
    'gregtech:ore_Chalcocite_0' : 10000,
    'gregtech:ore_Enargite_0' : 10000,
    'gregtech:ore_Pyrite_0' : 10000,
    'gregtech:ore_Chalcopyrite_0' : 10000,
    'gregtech:ore_Cinnabar_0' : 10000,
    'gregtech:ore_Sphalerite_0' : 10000,
    'gregtech:ore_Gypsum_0' : 10000,
    'gregtech:ore_Alunite_0' : 10000,
    'gregtech:ore_Tetrahedrite_0' : 10000
];

def sulfur_tier_2 = [
    'gregtech:ore_Sulfur_0' : 10000,
    'gregtech:ore_Bornite_0' : 10000,
    'gregtech:ore_Chalcocite_0' : 10000,
    'gregtech:ore_Enargite_0' : 10000,
    'gregtech:ore_Pyrite_0' : 10000,
    'gregtech:ore_Chalcopyrite_0' : 10000,
    'gregtech:ore_Cinnabar_0' : 10000,
    'gregtech:ore_Sphalerite_0' : 10000,
    'gregtech:ore_Gypsum_0' : 10000,
    'gregtech:ore_Alunite_0' : 10000,
    'gregtech:ore_Tetrahedrite_0' : 10000,

    'gregtech:ore_Galena_0' : 10000,
    'gregtech:ore_Silver_0' : 10000,
    'gregtech:ore_Gold_0' : 10000,
    'gregtech:ore_Lazurite_0' : 10000,
    'gregtech:ore_Cobaltite_0' : 10000
];

def oxide_tier_1 = [
    'gregtech:ore_Cassiterite_0' : 10000,
    'gregtech:ore_Magnetite_0' : 10000,
    'gregtech:ore_Yellow_Limonite_0' : 10000,
    'gregtech:ore_Brown_Limonite_0' : 10000,
    'gregtech:ore_Hematite_0' : 10000,
    'gregtech:ore_Ruby_0' : 10000,
    'gregtech:ore_Tenorite_0' : 10000,
    'gregtech:ore_Cuprite_0' : 10000
];

def oxide_tier_2 = [
    'gregtech:ore_Cassiterite_0' : 10000,
    'gregtech:ore_Magnetite_0' : 10000,
    'gregtech:ore_Yellow_Limonite_0' : 10000,
    'gregtech:ore_Brown_Limonite_0' : 10000,
    'gregtech:ore_Hematite_0' : 10000,
    'gregtech:ore_Ruby_0' : 10000,
    'gregtech:ore_Tenorite_0' : 10000,
    'gregtech:ore_Cuprite_0' : 10000,

    'gregtech:ore_Tantalite_0' : 10000,
    'gregtech:ore_Pyrolusite_0' : 10000,
    'gregtech:ore_Garnierite_0' : 10000,
    'gregtech:ore_Sapphire_0' : 10000,
    'gregtech:ore_Bastnasite_0' : 10000
];

def sedimentary_tier_1 = [
    'gregtech:ore_Diatomite_0' : 10000,
    'gregtech:ore_Trona_0' : 10000,
    'gregtech:ore_Salt_0' : 10000,
    'gregtech:ore_Rock_Salt_0' : 10000,
    'gregtech:ore_Saltpeter_0' : 10000
];

def silicate_tier_1 = [
    'gregtech:ore_Asbestos_0' : 10000,
    'gregtech:ore_Garnet_Sand_0' : 10000,
    'gregtech:ore_Garnet_Yellow_0' : 10000,
    'gregtech:ore_Garnet_Red_0' : 10000,
    'gregtech:ore_Mica_0' : 10000,
    'gregtech:ore_Redstone_0' : 10000,
    'gregtech:ore_Lepidolite_0' : 10000,
    'gregtech:ore_Spodumene_0' : 10000
];

def silicate_tier_2 = [
    'gregtech:ore_Asbestos_0' : 10000,
    'gregtech:ore_Garnet_Sand_0' : 10000,
    'gregtech:ore_Garnet_Yellow_0' : 10000,
    'gregtech:ore_Garnet_Red_0' : 10000,
    'gregtech:ore_Mica_0' : 10000,
    'gregtech:ore_Redstone_0' : 10000,
    'gregtech:ore_Lepidolite_0' : 10000,
    'gregtech:ore_Spodumene_0' : 10000,

    'gregtech:ore_Almandine_0' : 10000,
    'gregtech:ore_Pyrope_0' : 10000,
    'gregtech:ore_Beryllium_0' : 10000,
    'minecraft:emerald_ore' : 10000,
    'gregtech:ore_Spessartine_0' : 10000,
    'gregtech:ore_Grossular_0' : 10000,
    'gregtech:ore_Zeolite_0' : 10000,
    'gregtech:ore_Glauconite_Sand_0' : 10000,
    'gregtech:ore_Sodalite_0' : 10000,
    'gregtech:ore_Olivine_0' : 10000,
    'gregtech:ore_Quartzite_0' : 10000,
    'gregtech:ore_Topaz_0' : 10000
];

def carbonate_tier_1 = [
    'gregtech:ore_Dolomite_0' : 10000,
    'gregtech:ore_Malachite_0' : 10000,
    'gregtech:ore_Calcite_0' : 10000
];

def clay_tier_1 = [
    'gregtech:ore_Kaolinite_0' : 10000,
    'gregtech:ore_Soapstone_0' : 10000,
    'gregtech:ore_Talc_0' : 10000,
    'gregtech:ore_Fullers_Earth_0' : 10000,
    'gregtech:ore_Bentonite_0' : 10000
];

def carbon_tier_1 = [
    'gregtech:ore_Graphite_0' : 10000,
    'gregtech:ore_Diamond_0' : 500
];

def phosphate_tier_1 = [
    'gregtech:ore_Apatite_0' : 10000,
    'gregtech:ore_Fluorapatite_0' : 10000,
    'gregtech:ore_Tricalcium_Phosphate_0' : 10000
];

def precious_tier_1 = [
    'gregtech:ore_Precious_Metal_0' : 5000,
    'gregtech:ore_Gold_0' : 10000,
    'gregtech:ore_Silver_0' : 10000
];

def radioactive_tier_1 = [
    'gregtech:ore_Pitchblende_0' : 10000,
    'gregtech:ore_Uraninite_0' : 10000,
    'gregtech:ore_Monazite_0' : 10000
];


//FORMAT: BASE ROCK, WASHING FLUID, WASTE FLUID, ORE OUTPUT LISTS, STARTING VOLTAGE TIER

def rock_sulfur = new IOreRock('rock.sulfur', 'water', 'sulfurous_water', [sulfur_tier_1, sulfur_tier_2], 1);
def rock_oxide = new IOreRock('rock.oxide', 'water', 'oxide_water', [oxide_tier_1, oxide_tier_2], 1);
def rock_sedimentary = new IOreRock('rock.sedimentary', 'water', 'mineralized_water', [sedimentary_tier_1], 1);
def rock_silicate = new IOreRock('rock.silicate', 'water', 'silicate_water', [silicate_tier_1, silicate_tier_2], 1);
def rock_carbonate = new IOreRock('rock.carbonate', 'water', 'calcium_carbonate_solution', [carbonate_tier_1], 1);
def rock_clay = new IOreRock('rock.clay', 'water', 'bentonite_clay_solution', [clay_tier_1], 1);
def rock_carbon = new  IOreRock('rock.carbon', 'water', 'graphite_water', [carbon_tier_1], 2);
def rock_phosphate = new IOreRock('rock.phosphate', 'water', 'phosphate_water', [phosphate_tier_1], 2);
def rock_precious = new IOreRock('rock.precious', 'water', 'precious_runoff', [precious_tier_1], 3);
def rock_radioactive = new IOreRock('rock.radioactive', 'water', 'radioactive_runoff', [radioactive_tier_1], 3);

def rocks = [
        rock_sulfur,
        rock_oxide,
        rock_sedimentary,
        rock_silicate,
        rock_carbonate,
        rock_clay,
        rock_carbon,
        rock_phosphate,
        rock_precious,
        rock_radioactive
];

for (rock in rocks) {
    int a = 0;
    for (oreList in rock.oreLists) {
        def recipe = recipemap('ore_sorter').recipeBuilder();
        recipe.notConsumable(circuit(a));
        recipe.inputs(metaitem(rock.input_rock) * (oreList.size()));
        for (ore in oreList) {
            recipe.chancedOutput(item(ore.getKey()), oreList[ore.getKey()], 0);
        }
        recipe.fluidInputs(liquid(rock.input_fluid) * (fluid_amount * oreList.size()));
        recipe.fluidOutputs(liquid(rock.output_fluid) * (fluid_amount * oreList.size()));
        recipe.duration(20);
        recipe.EUt(Globals.voltageTiersInt[rock.starting_tier + a]);
        recipe.buildAndRegister();
        a += 1;
    }
}

*/