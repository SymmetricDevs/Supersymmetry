import classes.*;
import globals.Globals

LARGE_WEAPON_FACTORY = recipemap('large_weapons_factory');
WEAPON_FACTORY = recipemap('weapons_factory');
ASSEMBLER = recipemap('assembler');

def name_removals = [
    "icbmclassic:missile/missile.module",
    "icbmclassic:parts/vanilla/saltpeter",
    "icbmclassic:launcher/base/base.tier.1",
    "icbmclassic:launcher/base/base.tier.2",
    "icbmclassic:launcher/base/base.tier.3",
    "icbmclassic:launcher/support/support.tier.1",
    "icbmclassic:launcher/support/support.tier.2",
    "icbmclassic:launcher/support/support.tier.3",
    "icbmclassic:launcher/screen/screen.tier.1",
    "icbmclassic:launcher/screen/screen.tier.2",
    "icbmclassic:launcher/screen/screen.tier.3",
    "icbmclassic:missile/ex/condensed",
    "icbmclassic:missile/ex/shrapnel",
    "icbmclassic:missile/ex/incendiary",
    "icbmclassic:missile/ex/debilitation",
    "icbmclassic:missile/ex/chemical",
    "icbmclassic:missile/ex/anvil",
    "icbmclassic:missile/ex/repulsive",
    "icbmclassic:missile/ex/attractive",
    "icbmclassic:missile/ex/fragmentation",
    "icbmclassic:missile/ex/contagious",
    "icbmclassic:missile/ex/sonic",
    "icbmclassic:missile/ex/breaching",
    "icbmclassic:missile/ex/colors",
    "icbmclassic:missile/ex/thermobaric",
    "icbmclassic:missile/ex/smoke",
    "icbmclassic:missile/ex/nuclear",
    "icbmclassic:missile/ex/emp",
    "icbmclassic:missile/ex/exothermic",
    "icbmclassic:missile/ex/endothermic",
    "icbmclassic:missile/ex/antigravitational",
    "icbmclassic:missile/ex/ender",
    "icbmclassic:missile/ex/hypersonic",
    "icbmclassic:missile/ex/antimatter",
    "icbmclassic:missile/ex/redmatter",
    "icbmclassic:missile/special/missile.anti_ballistic",
    "icbmclassic:tools/defuser",
    "icbmclassic:tools/radargun",
    "icbmclassic:tools/rpg",
    "icbmclassic:tools/tracker",
    "icbmclassic:tools/remote",
    "icbmclassic:tools/laser",
    "icbmclassic:machine/radar",
    "icbmclassic:machine/cruiselauncher",
    "icbmclassic:explosives/condensed",
    "icbmclassic:explosives/shrapnel",
    "icbmclassic:explosives/incendiary",
    "icbmclassic:explosives/debilitation",
    "icbmclassic:explosives/chemical",
    "icbmclassic:explosives/anvil",
    "icbmclassic:explosives/repulsive",
    "icbmclassic:explosives/attractive",
    "icbmclassic:explosives/fragmentation",
    "icbmclassic:explosives/contagious",
    "icbmclassic:explosives/sonic",
    "icbmclassic:explosives/breaching",
    "icbmclassic:explosives/colors",
    "icbmclassic:explosives/thermobaric",
    "icbmclassic:explosives/smoke",
    "icbmclassic:explosives/nuclear",
    "icbmclassic:explosives/emp",
    "icbmclassic:explosives/exothermic",
    "icbmclassic:explosives/endothermic",
    "icbmclassic:explosives/anti_grav",
    "icbmclassic:explosives/ender",
    "icbmclassic:explosives/hypersonic",
    "icbmclassic:explosives/antimatter",
    "icbmclassic:explosives/redmatter",
    "icbmclassic:grenades/condensed",
    "icbmclassic:grenades/shrapnel",
    "icbmclassic:grenades/incendiary",
    "icbmclassic:grenades/debilitation",
    "icbmclassic:grenades/chemical",
    "icbmclassic:grenades/anvil",
    "icbmclassic:grenades/repulsive",
    "icbmclassic:grenades/attractive",
    "icbmclassic:grenades/colors",
    "icbmclassic:grenades/smoke",
    "icbmclassic:antidote",
    "icbmclassic:concrete",
    "icbmclassic:concrete.1",
    "icbmclassic:concrete.2",
    "icbmclassic:grenade:0",
    "icbmclassic:launcher/support",
    "icbmclassic:launcher/base",
    "icbmclassic:launcher/screen",
    "icbmclassic:launcher/connector",
    "icbmclassic:bomblet/bomblet",
    "icbmclassic:bomblet/condensed",
    "icbmclassic:parachute",
    "icbmclassic:balloon",
    "icbmclassic:missile/special/missile.cluster",
    "icbmclassic:spikes",
    "icbmclassic:spikes.1",
    "icbmclassic:spikes.2",
    "icbmclassic:powder.poison",
    "icbmclassic:saltpeter_ball",
]

for (item in name_removals) {
    crafting.remove(item);
}

furnace.removeByInput(item('icbmclassic:saltpeter_ball'))

for (var i = 0; i < 8; i++) {
    WEAPON_FACTORY.recipeBuilder()
        .inputs([
            item('icbmclassic:explosives', i),
            metaitem('plateSteel'),
            metaitem('ringSteel') * 2,
            metaitem('boltSteel')
        ])
        .outputs(item('icbmclassic:grenade', i))
        .duration(80)
        .EUt(30)
        .buildAndRegister();
}

//Explosives tier 1
crafting.addShaped("icbm_exp_1_0_dynamite", item('icbmclassic:explosives:0'), [
    [metaitem('dynamite'), metaitem('dynamite'), metaitem('dynamite')],
    [metaitem('dynamite'), ore('wireFineRedAlloy'), metaitem('dynamite')],
    [metaitem('dynamite'), metaitem('dynamite'), metaitem('dynamite')]
]);

crafting.addShaped("icbm_exp_1_0_tnt", item('icbmclassic:explosives:0'), [
    [null, ore('dustTnt'), null],
    [ore('dustTnt'), ore('wireFineRedAlloy'), ore('dustTnt')],
    [null, ore('dustTnt'), null]
]);

crafting.addShaped("icbm_exp_1_0_tnp", item('icbmclassic:explosives:0'), [
    [null, ore('dustPicricAcid'), null],
    [ore('dustPicricAcid'), ore('wireFineRedAlloy'), ore('dustPicricAcid')],
    [null, ore('dustPicricAcid'), null]
]);

/*crafting.addShaped("icbm_exp_1_1", item('icbmclassic:explosives:1'), [
        [ore('roundLead'), ore('roundLead'), ore('roundLead')],
        [ore('roundLead'), item('icbmclassic:explosives:0'), ore('roundLead')],
        [ore('roundLead'), ore('roundLead'), ore('roundLead')]
]);*/

def flammable_liquids = [
    liquid('naphtha') * 1000,
    liquid('gasoline') * 500
];

for (liquid in flammable_liquids) {
    WEAPON_FACTORY.recipeBuilder()
        .inputs([
            item('icbmclassic:explosives:0'),
            metaitem('fluid_cell')
        ])
        .fluidInputs(liquid)
        .outputs(item('icbmclassic:explosives:2'))
        .duration(20)
        .EUt(16)
        .buildAndRegister();
}

WEAPON_FACTORY.recipeBuilder()
    .inputs([
        item('icbmclassic:explosives:0'),
        metaitem('fluid_cell')
    ])
    .fluidInputs(liquid('sulfur_dioxide') * 1000)
    .outputs(item('icbmclassic:explosives:3'))
    .duration(20)
    .EUt(16)
    .buildAndRegister();

def poisons = [
    liquid('hydrogen_sulfide') * 1000,
    liquid('chlorine') * 1000,
    liquid('fluorine') * 1000,
    liquid('carbon_monoxide') * 1000,
    liquid('phosgene') * 500
];

for (poison in poisons) {
    WEAPON_FACTORY.recipeBuilder()
        .inputs([
            item('icbmclassic:explosives:0'),
            metaitem('fluid_cell')
        ])
        .fluidInputs(poison)
        .outputs(item('icbmclassic:explosives:4'))
        .duration(20)
        .EUt(16)
        .buildAndRegister();
}

WEAPON_FACTORY.recipeBuilder()
    .inputs([
        item('icbmclassic:explosives:0'),
        ore('dustPicricAcid') * 7,
        metaitem('sensor.lv')
        //Rationale: air burst explosion with high explosives to create repulsive forces
    ])
    .outputs(item('icbmclassic:explosives:6'))
    .duration(20)
    .EUt(16)
    .buildAndRegister();

//Explosives tier 2
WEAPON_FACTORY.recipeBuilder()
    .inputs([
        item('icbmclassic:explosives:0'),
        metaitem('plateSteel') * 16
    ])
    .fluidInputs(fluid('soldering_alloy') * 72)
    .outputs(item('icbmclassic:explosives:11'))
    .duration(400)
    .EUt(60)
    .buildAndRegister();

def thermobaric_fuels = [
    liquid('ethylene_oxide') * 8000
];

for (fuel in thermobaric_fuels) {
    WEAPON_FACTORY.recipeBuilder()
        .inputs([
            metaitem('fluid_cell') * 8,
            item('icbmclassic:explosives:6'),
            ore('plateAluminium') * 4
        ])
        .fluidInputs(fuel)
        .outputs(item('icbmclassic:explosives:13'))
        .duration(400)
        .EUt(60)
        .buildAndRegister();
}

/* WEAPON_FACTORY.recipeBuilder()
        .inputs([
            item('icbmclassic:explosives:1'),
            ore('plateSteel') * 8
        ])
        .outputs(item('icbmclassic:explosives:8'))
        .duration(400)
        .EUt(60)
        .buildAndRegister();

WEAPON_FACTORY.recipeBuilder()
    .inputs([
        metaitem('fluid_cell') * 8,
        item('icbmclassic:explosives:6'),
        ore('plateAluminium') * 4,
        item('minecraft:rotten_flesh') * 8
    ])
    .fluidInputs(liquid('biomass') * 8000)
    .outputs(item('icbmclassic:explosives:9'))
    .duration(400)
    .EUt(60)
    .buildAndRegister(); */

//Explosives tier 3

def HV_SC_CriticalTemp = 80;

def cryoLiquids = [
        'liquid_hydrogen': 14,
        'liquid_oxygen': 90,
        'liquid_helium': 4,
        'liquid_neon': 27,
        'liquid_argon': 87,
        'liquid_krypton': 120,
        'liquid_xenon': 165,
        'liquid_nitrogen': 77,
        'liquid_natural_gas': 80
];

Globals.solders.each { key, val ->
    cryoLiquids.each { liquid, temp ->
        if(HV_SC_CriticalTemp > temp) {
            //EMP
            WEAPON_FACTORY.recipeBuilder()
                .inputs([
                    ore('plateStainlessSteel') * 4,
                    metaitem('wireGtSingleMercuryBariumCalciumCuprate') * 8,
                    metaitem('fluid_cell') * 2
                ])
                .fluidInputs(fluid(key) * val)
                .fluidInputs(fluid(liquid) * 2)
                .outputs(item('icbmclassic:explosives:16'))
                .duration(200)
                .EUt(300)
                .buildAndRegister();
        }

        //Endothermic
        WEAPON_FACTORY.recipeBuilder()
            .inputs([
                metaitem('fluid_cell') * 8,
                item('icbmclassic:explosives:6') * 8,
                ore('plateStainlessSteel') * 4
            ])
            .fluidInputs(fluid(key) * val)
            .fluidInputs(fluid(liquid) * 32)
            .outputs(item('icbmclassic:explosives:18'))
            .duration(60)
            .EUt(300)
            .buildAndRegister();
    }

    for (fuel in thermobaric_fuels) {
        LARGE_WEAPON_FACTORY.recipeBuilder()
            .inputs([
                metaitem('fluid_cell') * 8,
                item('icbmclassic:explosives:6') * 8,
                ore('plateStainlessSteel') * 4
            ])
            .fluidInputs(fluid(key) * val)
            .fluidInputs(fuel)
            .outputs(item('icbmclassic:explosives:17'))
            .duration(60)
            .EUt(300)
            .buildAndRegister();
    }
}

//Concrete
ASSEMBLER.recipeBuilder()
    .circuitMeta(1)
    .fluidInputs(fluid('water') * 500)
    .inputs(ore('dustObsidian'))
    .inputs(ore('dustCement'))
    .inputs(ore('dustStone') * 4)
    .outputs(item('icbmclassic:concrete', 0) * 4)
    .duration(160)
    .EUt(24)
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .circuitMeta(2)
    .fluidInputs(fluid('water') * 500)
    .inputs(ore('dustObsidian'))
    .inputs(ore('dustPolypropylene'))
    .inputs(ore('dustCement'))
    .inputs(ore('dustStone') * 4)
    .inputs(ore('frameGtSteel'))
    .outputs(item('icbmclassic:concrete', 1) * 4)
    .duration(160)
    .EUt(96)
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .circuitMeta(3)
    .fluidInputs(fluid('water') * 500)
    .inputs(ore('dustObsidian'))
    .inputs(ore('dustBoronNitride'))
    .inputs(ore('dustCement'))
    .inputs(ore('dustStone') * 4)
    .inputs(ore('frameGtStainlessSteel'))
    .outputs(item('icbmclassic:concrete', 2) * 4)
    .duration(160)
    .EUt(384)
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .circuitMeta(3)
    .fluidInputs(fluid('water') * 500)
    .inputs(ore('dustObsidian'))
    .inputs(ore('dustBorosilicateGlass'))
    .inputs(ore('dustCement'))
    .inputs(ore('dustStone') * 4)
    .inputs(ore('frameGtStainlessSteel'))
    .outputs(item('icbmclassic:concrete', 2) * 4)
    .duration(160)
    .EUt(384)
    .buildAndRegister();


//Launchers
ASSEMBLER.recipeBuilder()
    .inputs([
        ore('plateSteel') * 3,
        ore('frameGtSteel') * 2,
        ore('stickLongSteel') * 2,
        ore('circuitMv')
    ])
    .fluidInputs(fluid('soldering_alloy') * 72)
    .outputs(item('icbmclassic:launcherbase:0'))
    .duration(400)
    .EUt(30)
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs([
        ore('plateSteel') * 2,
        ore('stickSteel') * 2,
        ore('paneGlassColorless'),
        ore('circuitMv')
    ])
    .fluidInputs(fluid('soldering_alloy') * 72)
    .outputs(item('icbmclassic:launcherscreen:0'))
    .duration(400)
    .EUt(30)
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs([
        ore('frameGtSteel') * 3,
        ore('stickLongSteel') * 3,
        metaitem('sensor.lv')
    ])
    .fluidInputs(fluid('soldering_alloy') * 72)
    .outputs(item('icbmclassic:launcherframe:0'))
    .duration(400)
    .EUt(30)
    .buildAndRegister();

//Missiles
def solidfuels = [
    ore('dustSugar'),
    ore('dustGunpowder'),
    ore('dustAluminium'),
    ore('dustBeryllium'),
];

def solidoxys = [
    ore('dustSaltpeter'),
    ore('dustAmmoniumNitrate')
];

def liquidfuels = [
    liquid('liquid_hydrogen'),
    liquid('kerosene'),
    liquid('ethanol')
];

def liquidoxys = [
    liquid('liquid_oxygen'),
    //liquid('hydrogen_peroxide'),
];

def hypergolicfuels = [
    liquid('monomethylhydrazine'),
    liquid('dimethylhydrazine')
]

def hypergolicoxys = [
    liquid('dinitrogen_tetroxide'),
    liquid('nitric_acid')
]

Globals.solders.each { key, val ->
    for (s_fuel in solidfuels) {
        for (s_oxy in solidoxys) {
            for (var i = 0; i < 8; i++) {
                LARGE_WEAPON_FACTORY.recipeBuilder()
                    .inputs([ore('stickAluminium') * 4,
                         ore('ringAluminium') * 2,
                         ore('plateAluminium') * 2,
                         ore('foilAluminium') * 16,
                         s_oxy * 16,
                         s_fuel * 16,
                         item('icbmclassic:explosives:' + i)
                    ])
                    .fluidInputs(fluid(key) * val)
                    .outputs(item('icbmclassic:explosive_missile:' + i))
                    .duration(200)
                    .EUt(30)
                    .buildAndRegister();
            }

            WEAPON_FACTORY.recipeBuilder()
                .inputs([
                    ore('plateStainlessSteel') * 2,
                    s_oxy,
                    s_fuel,
                    ore('wireFineRedAlloy')
                ])
                .circuitMeta(1)
                .fluidInputs(fluid(key) * val)
                .outputs(item('openmodularturrets:ammo_meta:4') * 8)
                .duration(20)
                .EUt(200)
                .buildAndRegister();

            WEAPON_FACTORY.recipeBuilder()
                .inputs([
                    ore('plateStainlessSteel') * 2,
                    s_oxy,
                    s_fuel,
                    ore('wireFineRedAlloy')
                ])
                .circuitMeta(2)
                .fluidInputs(fluid(key) * val)
                .outputs(item('techguns:itemshared', 7) * 8)
                .duration(20)
                .EUt(200)
                .buildAndRegister();

            WEAPON_FACTORY.recipeBuilder()
                .inputs([
                    ore('plateStainlessSteel') * 2,
                    s_oxy * 2,
                    s_fuel * 2,
                    ore('wireFineRedAlloy')
                ])
                .circuitMeta(3)
                .fluidInputs(fluid(key) * val)
                .outputs(item('techguns:itemshared', 145) * 8)
                .duration(20)
                .EUt(200)
                .buildAndRegister();

            WEAPON_FACTORY.recipeBuilder()
                .inputs([
                    ore('plateStainlessSteel') * 2,
                    s_oxy,
                    s_fuel,
                    ore('wireFineRedAlloy')
                ])
                .circuitMeta(4)
                .fluidInputs(fluid(key) * val)
                .outputs(item('minecraft:fireworks') * 16)
                .duration(20)
                .EUt(200)
                .buildAndRegister();
        }

        for (l_oxy in liquidoxys) {
            for (var j = 8; j < 14; j++) {
                LARGE_WEAPON_FACTORY.recipeBuilder()
                    .inputs([ore('stickStainlessSteel') * 4,
                         ore('ringStainlessSteel') * 2,
                         ore('plateStainlessSteel') * 2,
                         ore('foilStainlessSteel') * 16,
                         s_fuel * 16,
                         item('icbmclassic:explosives:' + j)
                    ])
                    .fluidInputs(fluid(key) * val)
                    .fluidInputs(l_oxy * 2000)
                    .outputs(item('icbmclassic:explosive_missile:' + j))
                    .duration(200)
                    .EUt(120)
                    .buildAndRegister();
            }
        }
    }
    
    for (h_fuel in hypergolicfuels) {
        for (h_oxy_1 in hypergolicoxys) {
            for (var k = 15; k < 24; k++) {
                LARGE_WEAPON_FACTORY.recipeBuilder()
                    .inputs([ore('stickTitanium') * 4,
                         ore('ringTitanium') * 2,
                         ore('plateTitanium') * 2,
                         ore('foilTitanium') * 16,
                         item('icbmclassic:explosives:' + k)
                    ])
                    .fluidInputs(fluid(key) * val)
                    .fluidInputs(h_oxy_1 * 4000)
                    .fluidInputs(h_fuel * 2000)
                    .outputs(item('icbmclassic:explosive_missile:' + k))
                    .duration(200)
                    .EUt(500)
                    .buildAndRegister();
            }
        }
    }
}
//launcher connector
ASSEMBLER.recipeBuilder()
    .inputs([
        ore('plateSteel') * 6,
        metaitem('plateWroughtIron') * 8,
        ore('circuitLv'),
        metaitem('conveyor.module.lv'),
        metaitem('cableGtSingleCopper') * 3

    ])
    .fluidInputs(fluid('soldering_alloy') * 72)
    .outputs(item('icbmclassic:launcher_connector') * 4)
    .duration(400)
    .EUt(30)
    .buildAndRegister();



//empty bomblet
Globals.solders.each { key, val ->
    LARGE_WEAPON_FACTORY.recipeBuilder()
        .inputs([
            ore('plateSteel') * 8,
            ore('circuitLv'),
            ore('frameGtSteel') * 2
        ])
        .fluidInputs(fluid(key) * val)
        .outputs(item('icbmclassic:empty_bomblet'))
        .duration(300)
        .EUt(30)
        .buildAndRegister();
}

//filled bomblets
for (var i = 0; i < 15; i++) {
    LARGE_WEAPON_FACTORY.recipeBuilder()
        .inputs([
            item('icbmclassic:explosives', i),
            item('icbmclassic:empty_bomblet')
        ])
        .outputs(item('icbmclassic:explosive_bomblet', i))
        .duration(300)
        .EUt(30)
        .buildAndRegister();
}

//empty payload parachute
ASSEMBLER.recipeBuilder()
    .inputs([
        item('techguns:itemshared:60') * 6,
        item('minecraft:string') * 4

    ])
    .outputs(item('icbmclassic:parachute'))
    .duration(200)
    .EUt(30)
    .buildAndRegister();

//payload baloon
ASSEMBLER.recipeBuilder()
    .inputs([
        item('minecraft:carpet') * 3,
        item('minecraft:string') * 2

    ])
    .outputs(item('icbmclassic:balloon'))
    .duration(50)
    .EUt(30)
    .buildAndRegister();

//missile module (empty missile)
Globals.solders.each { key, val ->
    LARGE_WEAPON_FACTORY.recipeBuilder()
        .circuitMeta(1)
        .inputs([
            ore('stickAluminium') * 4,
            ore('ringAluminium') * 2,
            ore('plateAluminium') * 2,
            ore('foilAluminium') * 16,
        ])
        .fluidInputs(fluid(key) * val)
        .outputs(item('icbmclassic:explosive_missile:' + 24))
        .duration(300)
        .EUt(30)
        .buildAndRegister();
}
//cluster missile
Globals.solders.each { key, val ->
    LARGE_WEAPON_FACTORY.recipeBuilder()
        .inputs([
            ore('screwAluminium') * 4,
            metaitem('crate.aluminium'),
            item('icbmclassic:explosive_missile:' + 24)
        ])
        .fluidInputs(fluid(key) * val)
        .outputs(item('icbmclassic:cluster_missile'))
        .duration(400)
        .EUt(30)
        .buildAndRegister();
}
