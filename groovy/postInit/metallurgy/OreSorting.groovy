import classes.*
import globals.Globals

log.infoMC("Running OreSorting.groovy...")

int fluid_amount = 100;

//FORMAT: ORE NAME : CHANCE (out of 10000)
//REBALANCING MAY BE DONE AS WE GO ON
//Divine Ray commented out unused/worthless ores 

// #TODO: #967 Tweak all OreSorting.groovy recipes to be appropriate to their utility
def orthomagmatic_tier_1 = [
    //Tier 1
    'gregtech:ore_spodumene_0' : 5000,
    'gregtech:ore_lepidolite_0' : 1000,
    'gregtech:ore_magnetite_0' : 10000,
    'gregtech:ore_chalcopyrite_0' : 7500,
    'gregtech:ore_sphalerite_0' : 1000,
    'gregtech:ore_cassiterite_0' : 8000
];

def orthomagmatic_tier_2 = [
    //Tier 1
    'gregtech:ore_spodumene_0' : 5000,
    'gregtech:ore_lepidolite_0' : 1000,
    'gregtech:ore_magnetite_0' : 10000,
    'gregtech:ore_chalcopyrite_0' : 7500,
    'gregtech:ore_sphalerite_0' : 1000,
    'gregtech:ore_cassiterite_0' : 8000,
    //Tier 2
    'gregtech:ore_chromite_0' : 5000,
    'gregtech:ore_pollucite_0' : 100
];

def orthomagmatic_tier_3 = [
    //Tier 1
    'gregtech:ore_spodumene_0' : 5000,
    'gregtech:ore_lepidolite_0' : 1000,
    'gregtech:ore_magnetite_0' : 10000,
    'gregtech:ore_chalcopyrite_0' : 7500,
    'gregtech:ore_sphalerite_0' : 1000,
    'gregtech:ore_cassiterite_0' : 8000,
    //Tier 2
    'gregtech:ore_chromite_0' : 5000,
    'gregtech:ore_pollucite_0' : 100,
    //T3
    'gregtech:ore_pentlandite_0' : 6000,
    'gregtech:ore_pyrochlore_0' : 2000,
    'gregtech:ore_molybdenite_0' : 1000,
    'gregtech:ore_tantalite_0' : 1000,
    'gregtech:ore_columbite_0' : 500,
    'gregtech:ore_perovskite_0' : 7500,
    'minecraft:soul_sand' : 100,
    'gregtech:ore_vanadiferous_titanomagnetite_0' : 7500

    //'gregtech:ore_thortveitite_0' : 10000,
];

def orthomagmatic_tier_4 = [
    //T1
    'gregtech:ore_spodumene_0' : 5000,
    'gregtech:ore_lepidolite_0' : 1000,
    'gregtech:ore_magnetite_0' : 10000,
    'gregtech:ore_chalcopyrite_0' : 7500,
    'gregtech:ore_sphalerite_0' : 1000,
    'gregtech:ore_cassiterite_0' : 8000,
    //T2
    'gregtech:ore_chromite_0' : 5000,
    'gregtech:ore_pollucite_0' : 100,
    //T3
     'gregtech:ore_pentlandite_0' : 6000,
    'gregtech:ore_pyrochlore_0' : 2000,
    'gregtech:ore_molybdenite_0' : 1000,
    'gregtech:ore_tantalite_0' : 1000,
    'gregtech:ore_columbite_0' : 500,
    'gregtech:ore_perovskite_0' : 7500,
    'minecraft:soul_sand' : 100,
    'gregtech:ore_vanadiferous_titanomagnetite_0' :7500,
    //T4
    'gregtech:ore_baddeleyite_0' : 200
    //'susy:resource_block:8' : 10000,
    //'gregtech:ore_thortveitite_0' : 10000,
];

def metamorphic_tier_1 = [
    //T1
    'gregtech:ore_arsenopyrite_0' : 7500,
    'gregtech:ore_cinnabar_0' : 2500,
    'gregtech:ore_cobaltite_0' : 1000,
    'gregtech:ore_magnetite_0' : 10000,
    'gregtech:ore_pyrargyrite_0' : 5000,
    'gregtech:ore_pyrite_0' : 10000,
    'gregtech:ore_realgar_0' : 7500,
    'gregtech:ore_redstone_0' : 7500,
    'gregtech:ore_tetrahedrite_0' : 9000
];

def metamorphic_tier_2 = [
        //T1
    'gregtech:ore_arsenopyrite_0' : 7500,
    'gregtech:ore_cinnabar_0' : 2500,
    'gregtech:ore_cobaltite_0' : 1000,
    'gregtech:ore_magnetite_0' : 10000,
    'gregtech:ore_pyrargyrite_0' : 5000,
    'gregtech:ore_pyrite_0' : 10000,
    'gregtech:ore_realgar_0' : 7500,
    'gregtech:ore_redstone_0' : 7500,
    'gregtech:ore_tetrahedrite_0' : 9000,
    //T2
    'gregtech:ore_stephanite_0' : 5000,
    'gregtech:ore_magnesite_0' : 7500
];

def metamorphic_tier_3 = [
    //T1
    'gregtech:ore_arsenopyrite_0' : 7500,
    'gregtech:ore_cinnabar_0' : 2500,
    'gregtech:ore_cobaltite_0' : 1000,
    'gregtech:ore_magnetite_0' : 10000,
    'gregtech:ore_pyrargyrite_0' : 5000,
    'gregtech:ore_pyrite_0' : 10000,
    'gregtech:ore_realgar_0' : 7500,
    'gregtech:ore_redstone_0' : 7500,
    'gregtech:ore_tetrahedrite_0' : 9000,
    //T2
    'gregtech:ore_stephanite_0' : 5000,
    'gregtech:ore_magnesite_0' : 7500,
    //T3
    'gregtech:ore_ilmenite_0' : 5000
];

def sedimentary_tier_1 = [
    //T1
    'gregtech:ore_banded_iron_0' : 7500,
    'gregtech:ore_cinnabar_0' : 2000,
    'gregtech:ore_coal_0' : 9000,
    'gregtech:ore_fluorite_0' : 2000,
    'gregtech:ore_malachite_0' : 2500,
    'gregtech:ore_pyrite_0' : 2500,
    'gregtech:ore_pyrolusite_0' : 5000,
    'gregtech:ore_saltpeter_0' : 5000,
    'susy:resource_block:0' : 7500,
    'susy:resource_block:12' : 5000
];

def sedimentary_tier_2 = [
    //T1
    'gregtech:ore_banded_iron_0' : 7500,
    'gregtech:ore_cinnabar_0' : 2000,
    'gregtech:ore_coal_0' : 9000,
    'gregtech:ore_fluorite_0' : 2000,
    'gregtech:ore_malachite_0' : 2500,
    'gregtech:ore_pyrite_0' : 2500,
    'gregtech:ore_pyrolusite_0' : 5000,
    'gregtech:ore_saltpeter_0' : 5000,
    'susy:resource_block:0' : 7500,
    'susy:resource_block:12' : 5000,
    //T2
    'gregtech:ore_magnesite_0' : 2000
];

def sedimentary_tier_3 = [
    //T1
    'gregtech:ore_banded_iron_0' : 7500,
    'gregtech:ore_cinnabar_0' : 2000,
    'gregtech:ore_coal_0' : 9000,
    'gregtech:ore_fluorite_0' : 2000,
    'gregtech:ore_malachite_0' : 2500,
    'gregtech:ore_pyrite_0' : 2500,
    'gregtech:ore_pyrolusite_0' : 5000,
    'gregtech:ore_saltpeter_0' : 5000,
    'susy:resource_block:0' : 7500,
    'susy:resource_block:12' : 5000,
    //T2
    'gregtech:ore_magnesite_0' : 2000,
    //T3
    'gregtech:ore_ilmenite_0' : 1000,
    //'susy:resource_block:1' : 10000,
    'gregtech:ore_celestine_0' : 500,
    'gregtech:ore_barite_0' : 2500,
];

def sedimentary_tier_4 = [
        //T1
    'gregtech:ore_banded_iron_0' : 7500,
    'gregtech:ore_cinnabar_0' : 2000,
    'gregtech:ore_coal_0' : 9000,
    'gregtech:ore_fluorite_0' : 2000,
    'gregtech:ore_malachite_0' : 2500,
    'gregtech:ore_pyrite_0' : 2500,
    'gregtech:ore_pyrolusite_0' : 5000,
    'gregtech:ore_saltpeter_0' : 5000,
    'susy:resource_block:0' : 7500,
    'susy:resource_block:12' : 5000,
    //T2
    'gregtech:ore_magnesite_0' : 2000,
    //T3
    'gregtech:ore_ilmenite_0' : 1000,
    //'susy:resource_block:1' : 10000,
    'gregtech:ore_celestine_0' : 500,
    'gregtech:ore_barite_0' : 2500,
    //T4
    'gregtech:ore_carnotite_0' : 100
    //'gregtech:ore_uraninite_0' : 750,
];

def magmatic_hydrothermal_tier_1 = [
    //T1
    'gregtech:ore_cassiterite_0' : 5000,
    'gregtech:ore_chalcopyrite_0' : 7500,
    'gregtech:ore_cobaltite_0' : 2500,
    'gregtech:ore_enargite_0' : 5000,
    'gregtech:ore_magnetite_0' : 7500,
    'gregtech:ore_pyrite_0' : 5000,
    'gregtech:ore_redstone_0' : 2500,
    'gregtech:ore_sphalerite_0' : 7500
];

def magmatic_hydrothermal_tier_2 = [
    //T1 but better
    'gregtech:ore_cassiterite_0' : 7500,
    'gregtech:ore_chalcopyrite_0' : 5500,
    'gregtech:ore_cobaltite_0' : 5000,
    'gregtech:ore_enargite_0' : 7500,
    'gregtech:ore_magnetite_0' : 9000,
    'gregtech:ore_pyrite_0' : 7500,
    'gregtech:ore_redstone_0' : 5000,
    'gregtech:ore_sphalerite_0' : 9000
];

def magmatic_hydrothermal_tier_3 = [
        //T1 but better
    'gregtech:ore_cassiterite_0' : 7500,
    'gregtech:ore_chalcopyrite_0' : 5500,
    'gregtech:ore_cobaltite_0' : 5000,
    'gregtech:ore_enargite_0' : 7500,
    'gregtech:ore_magnetite_0' : 9000,
    'gregtech:ore_pyrite_0' : 7500,
    'gregtech:ore_pyrochlore_0' : 1000,
    'gregtech:ore_redstone_0' : 5000,
    'gregtech:ore_sphalerite_0' : 9000,
    //T3
    'gregtech:ore_scheelite_0' : 1250,
    'gregtech:ore_wolframite_0' : 1000
];

def magmatic_hydrothermal_tier_4 = [
            //T1 but better
    'gregtech:ore_cassiterite_0' : 7500,
    'gregtech:ore_chalcopyrite_0' : 5500,
    'gregtech:ore_cobaltite_0' : 5000,
    'gregtech:ore_enargite_0' : 7500,
    'gregtech:ore_magnetite_0' : 9000,
    'gregtech:ore_pyrite_0' : 7500,
    'gregtech:ore_pyrochlore_0' : 1000,
    'gregtech:ore_redstone_0' : 5000,
    'gregtech:ore_sphalerite_0' : 9000,
    //T3
    'gregtech:ore_scheelite_0' : 1250,
    'gregtech:ore_wolframite_0' : 1000,
    //T4
    //'susy:resource_block:7' : 10000,
    'gregtech:ore_uraninite_0' : 500
];

def hydrothermal_tier_1 = [
    //T1
    'gregtech:ore_acanthite_0' : 5000,
    'gregtech:ore_arsenopyrite_0' : 1500,
    'gregtech:ore_bornite_0' : 7500,
    'gregtech:ore_cassiterite_0' : 2500,
    'gregtech:ore_cinnabar_0' : 3333,
    'gregtech:ore_cobaltite_0' : 1500,
    'gregtech:ore_fluorite_0' : 1000,
    'gregtech:ore_galena_0' : 7500,
    'gregtech:ore_proustite_0' : 7500,
    'gregtech:ore_pyrite_0' : 2500,
    'gregtech:ore_pyrolusite_0' : 1000,
    'gregtech:ore_realgar_0' : 1500,
    'gregtech:ore_stibnite_0' : 3333
];

def hydrothermal_tier_2 = [
        //T1
    'gregtech:ore_acanthite_0' : 7500,
    'gregtech:ore_arsenopyrite_0' : 1500,
    'gregtech:ore_bornite_0' : 7500,
    'gregtech:ore_cassiterite_0' : 2500,
    'gregtech:ore_cinnabar_0' : 3333,
    'gregtech:ore_cobaltite_0' : 1500,
    'gregtech:ore_fluorite_0' : 2500,
    'gregtech:ore_galena_0' : 7500,
    'gregtech:ore_proustite_0' : 9500,
    'gregtech:ore_pyrite_0' : 2500,
    'gregtech:ore_pyrolusite_0' : 1000,
    'gregtech:ore_realgar_0' : 1500,
    'gregtech:ore_stibnite_0' : 3333,
    //T2
    'gregtech:ore_vanadinite_0' : 5000
];

def hydrothermal_tier_3 = [
        //T1
    'gregtech:ore_acanthite_0' : 7500,
    'gregtech:ore_arsenopyrite_0' : 1500,
    'gregtech:ore_bornite_0' : 7500,
    'gregtech:ore_cassiterite_0' : 2500,
    'gregtech:ore_cinnabar_0' : 3333,
    'gregtech:ore_cobaltite_0' : 1500,
    'gregtech:ore_fluorite_0' : 2500,
    'gregtech:ore_galena_0' : 7500,
    'gregtech:ore_proustite_0' : 9500,
    'gregtech:ore_pyrite_0' : 2500,
    'gregtech:ore_pyrolusite_0' : 1000,
    'gregtech:ore_realgar_0' : 1500,
    'gregtech:ore_stibnite_0' : 3333,
    //T2
    'gregtech:ore_vanadinite_0' : 5000,
    //T3
    'gregtech:ore_witherite_0' : 2500,
    'gregtech:ore_bismuthinite_0' : 7500
    //'gregtech:ore_strontianite_0' : 10000 TODO: Fix #971
];

def hydrothermal_tier_4 = [
        //T1
    'gregtech:ore_acanthite_0' : 7500,
    'gregtech:ore_arsenopyrite_0' : 1500,
    'gregtech:ore_bornite_0' : 7500,
    'gregtech:ore_cassiterite_0' : 2500,
    'gregtech:ore_cinnabar_0' : 3333,
    'gregtech:ore_cobaltite_0' : 1500,
    'gregtech:ore_fluorite_0' : 2500,
    'gregtech:ore_galena_0' : 7500,
    'gregtech:ore_proustite_0' : 9500,
    'gregtech:ore_pyrite_0' : 2500,
    'gregtech:ore_pyrolusite_0' : 1000,
    'gregtech:ore_realgar_0' : 1500,
    'gregtech:ore_stibnite_0' : 3333,
    //T2
    'gregtech:ore_vanadinite_0' : 5000,
    //T3
    'gregtech:ore_witherite_0' : 2500,
    'gregtech:ore_bismuthinite_0' : 7500
    //'gregtech:ore_strontianite_0' : 10000 TODO: Fix #971
    //T4
    //'susy:resource_block:9' : 10000,
];

def alluvial_tier_1 = [
    //T1
    'gregtech:ore_cassiterite_0' : 9500,
    'susy:resource_block:10' : 100,
    'susy:resource_block:11' : 1000
];

def alluvial_tier_2 = [
    //T1.2
    'gregtech:ore_cassiterite_0' : 10000,
    'susy:resource_block:10' : 200,
    'susy:resource_block:11' : 5000
];


def alluvial_tier_3 = [
    //T1.3
    'gregtech:ore_cassiterite_0' : 10000,
    'susy:resource_block:10' : 500,
    'susy:resource_block:11' : 7500,
    //T3
    'minecraft:soul_sand' : 100
];

def alluvial_tier_4 = [
    //T1.4
    'gregtech:ore_cassiterite_0' : 10000,
    'susy:resource_block:10' : 1000,
    'susy:resource_block:11' : 10000,
    //T4
    'minecraft:soul_sand' : 100,
    'susy:resource_block:6' : 7500
];

//FORMAT: BASE ROCK, WASHING FLUID, WASTE FLUID, ORE OUTPUT LISTS, STARTING VOLTAGE TIER

def rock_orthomagmatic = new IOreRock('rock.orthomagmatic', 'water', 'water', [orthomagmatic_tier_1, orthomagmatic_tier_2, orthomagmatic_tier_3, orthomagmatic_tier_4], 1);
def rock_sedimentary = new IOreRock('rock.sedimentary', 'water', 'water', [sedimentary_tier_1, sedimentary_tier_2, sedimentary_tier_3, sedimentary_tier_4], 1);
def rock_metamorphic = new IOreRock('rock.metamorphic', 'water', 'water', [metamorphic_tier_1, metamorphic_tier_2, metamorphic_tier_3], 1);
def rock_magmatic_hydrothermal = new IOreRock('rock.magmatic_hydrothermal', 'water', 'water', [magmatic_hydrothermal_tier_1, magmatic_hydrothermal_tier_2, magmatic_hydrothermal_tier_3, magmatic_hydrothermal_tier_4], 1);
def rock_hydrothermal = new IOreRock('rock.hydrothermal', 'water', 'water', [hydrothermal_tier_1, hydrothermal_tier_2, hydrothermal_tier_3, hydrothermal_tier_4], 1);
def rock_alluvial = new IOreRock('rock.alluvial', 'water', 'water', [alluvial_tier_1, alluvial_tier_2, alluvial_tier_3, alluvial_tier_4], 1);

def rocks = [
        rock_orthomagmatic,
        rock_metamorphic,
        rock_sedimentary,
        rock_magmatic_hydrothermal,
        rock_hydrothermal,
        rock_alluvial
];

for (rock in rocks) {
    int a = 0;
    for (oreList in rock.oreLists) {
        def recipe = recipemap('ore_sorter').recipeBuilder();
        recipe.circuitMeta(a + 1)
        recipe.inputs(metaitem(rock.input_rock) * (oreList.size()));
        for (ore in oreList) {
            if (ore.getKey() == 'gregtech:ore_coal_0') {
                recipe.chancedOutput(item(ore.getKey()) * 2, oreList[ore.getKey()], 0);
            } else {
                recipe.chancedOutput(item(ore.getKey()), oreList[ore.getKey()], 0);
            }
        }
        recipe.duration(20);
        recipe.EUt(Globals.voltAmps[rock.starting_tier + a]);
        recipe.buildAndRegister();
        a += 1;
    }
}
