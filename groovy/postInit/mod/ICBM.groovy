import classes.*;
import static globals.Globals.*

def name_removals = [
        "icbmclassic:missile/vanilla/missile.module",
        "icbmclassic:launcher/base/base.tier.1",
        "icbmclassic:launcher/base/base.tier.2",
        "icbmclassic:launcher/base/base.tier.3",
        "icbmclassic:launcher/support/support.tier.1",
        "icbmclassic:launcher/support/support.tier.2",
        "icbmclassic:launcher/support/support.tier.3",
        "icbmclassic:launcher/screen/screen.tier.1",
        "icbmclassic:launcher/screen/screen.tier.2",
        "icbmclassic:launcher/screen/screen.tier.3",
        "icbmclassic:missile/ex/missile.anvil",
        "icbmclassic:missile/ex/missile.replusive", //This mispelling is intentional since the ICBM creator mispelled it
        "icbmclassic:missile/ex/missile.attractive",
        "icbmclassic:missile/ex/missile.deblitationl", //This mispelling is intentional since the ICBM creator mispelled it
        "icbmclassic:missile/ex/missile.sonic",
        "icbmclassic:missile/ex/missile.antimatter",
        "icbmclassic:missile/ex/missile.incendiary",
        "icbmclassic:missile/ex/missile.redmatter",
        "icbmclassic:missile/ex/missile.fragmentation",
        "icbmclassic:missile/ex/missile.breaching",
        "icbmclassic:missile/ex/missile.thermobaric",
        "icbmclassic:missile/ex/missile.exothermic",
        "icbmclassic:missile/ex/missile.shrapnel",
        "icbmclassic:missile/ex/missile.ender",
        "icbmclassic:missile/ex/missile.emp",
        "icbmclassic:missile/ex/missile.endothermic",
        "icbmclassic:missile/ex/missile.contagious",
        "icbmclassic:missile/ex/missile.debilitation",
        "icbmclassic:missile/ex/missile.nuclear",
        "icbmclassic:missile/ex/missile.conventional",
        "icbmclassic:missile/ex/missile.anti_grav",
        "icbmclassic:missile/ex/missile.chemical",
        "icbmclassic:missile/ex/missile.hypersonic",
        "icbmclassic:tools/defuser",
        "icbmclassic:tools/radargun",
        "icbmclassic:tools/rpg",
        "icbmclassic:tools/tracker",
        "icbmclassic:tools/remote",
        "icbmclassic:tools/laser",
        "icbmclassic:machine/cruiselauncher",
        "icbmclassic:explosives/condensed",
        "icbmclassic:explosives/shrapnel",
        "icbmclassic:explosives/incendiary",
        "icbmclassic:explosives/attractive",
        "icbmclassic:explosives/repulsive",
        "icbmclassic:explosives/anvil",
        "icbmclassic:explosives/fragmentation",
        "icbmclassic:explosives/nuclear",
        "icbmclassic:explosives/antimatter",
        "icbmclassic:explosives/debilitation",
        "icbmclassic:explosives/chemical",
        "icbmclassic:explosives/contagious",
        "icbmclassic:explosives/sonic",
        "icbmclassic:explosives/breaching",
        "icbmclassic:explosives/thermobaric",
        "icbmclassic:explosives/exothermic",
        "icbmclassic:explosives/endothermic",
        "icbmclassic:explosives/anti_grav",
        "icbmclassic:explosives/ender",
        "icbmclassic:explosives/hypersonic",
        "icbmclassic:grenades/grenade",
        "icbmclassic:grenades/grenade.1",
        "icbmclassic:grenades/grenade.2",
        "icbmclassic:grenades/grenade.3",
        "icbmclassic:grenades/grenade.4",
        "icbmclassic:grenades/grenade.5",
        "icbmclassic:grenades/grenade.6",
        "icbmclassic:grenades/grenade.7",
        "icbmclassic:antidote"
]

for (item in name_removals) {
    crafting.remove(item);
}

for (var i = 0; i < 8; i++) {
    recipemap('weapons_factory').recipeBuilder()
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
        liquid('naphtha')*1000,
        liquid('gasoline')*500
];

for (liquid in flammable_liquids) {
    recipemap('weapons_factory').recipeBuilder()
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

recipemap('weapons_factory').recipeBuilder()
        .inputs([
                item('icbmclassic:explosives:0'),
                metaitem('fluid_cell')
        ])
        .fluidInputs(liquid('sulfur_dioxide')*1000)
        .outputs(item('icbmclassic:explosives:3'))
        .duration(20)
        .EUt(16)
        .buildAndRegister();

def poisons = [
        liquid('hydrogen_sulfide')*1000,
        liquid('chlorine')*1000,
        liquid('fluorine')*1000,
        liquid('carbon_monoxide')*1000,
        liquid('phosgene')*500
];

for (poison in poisons) {
    recipemap('weapons_factory').recipeBuilder()
            .inputs([
                    item('icbmclassic:explosives:0'),
                    metaitem('fluid_cell')
            ])
            .fluidInputs(poison)
            .outputs(item('icbmclassic:explosives:4'))
            .duration(20)
            .EUt(16)
            .buildAndRegister();

    recipemap('weapons_factory').recipeBuilder()
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
}

//Explosives tier 2
Globals.solders.each { key, val ->
    recipemap('weapons_factory').recipeBuilder()
            .inputs([
                    item('icbmclassic:explosives:0'),
                    metaitem('plateSteel') * 16
            ])
            .fluidInputs(fluid(key) * val)
            .outputs(item('icbmclassic:explosives:11'))
            .duration(400)
            .EUt(60)
            .buildAndRegister();
}

def thermobaric_fuels = [
        liquid('ethylene_oxide') * 8000
];

for (fuel in thermobaric_fuels) {
    recipemap('weapons_factory').recipeBuilder()
            .inputs([
                    metaitem('fluid_cell')*8,
                    item('icbmclassic:explosives:6'),
                    ore('plateAluminium')*4
            ])
            .fluidInputs(fuel)
            .outputs(item('icbmclassic:explosives:13'))
            .duration(400)
            .EUt(60)
            .buildAndRegister();
}

/*recipemap('weapons_factory').recipeBuilder()
            .inputs([
                    item('icbmclassic:explosives:1'),
                    ore('plateSteel')*8
            ])
            .outputs(item('icbmclassic:explosives:8'))
            .duration(400)
            .EUt(60)
            .buildAndRegister();*/

/*recipemap('weapons_factory').recipeBuilder()
        .inputs([
                metaitem('fluid_cell')*8,
                item('icbmclassic:explosives:6'),
                ore('plateAluminium')*4,
                item('minecraft:rotten_flesh')*8
        ])
        .fluidInputs(liquid('biomass')*8000)
        .outputs(item('icbmclassic:explosives:9'))
        .duration(400)
        .EUt(60)
        .buildAndRegister();*/

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
        'liquid_refinery_gas': 80,
        'liquid_natural_gas': 80
];

Globals.solders.each { key, val ->
        cryoLiquids.each { liquid, temp ->
                if(HV_SC_CriticalTemp > temp) {
                        //EMP
                        recipemap('weapons_factory').recipeBuilder()
                                .inputs([
                                        ore('plateStainlessSteel')*4,
                                        metaitem('wireGtSingleMercuryBariumCalciumCuprate')*8,
                                        metaitem('fluid_cell')*2
                                ])
                                .fluidInputs(fluid(key) * val)
                                .fluidInputs(fluid(liquid) * 2)
                                .outputs(item('icbmclassic:explosives:16'))
                                .duration(200)
                                .EUt(300)
                                .buildAndRegister();
                }
                //Endothermic
                recipemap('weapons_factory').recipeBuilder()
                        .inputs([
                                metaitem('fluid_cell')*8,
                                item('icbmclassic:explosives:6')*8,
                                ore('plateStainlessSteel')*4
                        ])
                        .fluidInputs(fluid(key) * val)
                        .fluidInputs(fluid(liquid) * 32)
                        .outputs(item('icbmclassic:explosives:18'))
                        .duration(60)
                        .EUt(300)
                        .buildAndRegister();
        }
                for (fuel in thermobaric_fuels) {
                        recipemap('large_weapons_factory').recipeBuilder()
                                .inputs([
                                        metaitem('fluid_cell')*8,
                                        item('icbmclassic:explosives:6')*8,
                                        ore('plateStainlessSteel')*4
                                ])
                                .fluidInputs(fluid(key) * val)
                                .fluidInputs(fuel)
                                .outputs(item('icbmclassic:explosives:17'))
                                .duration(60)
                                .EUt(300)
                                .buildAndRegister();
        }
}

//Launchers
Globals.solders.each { key, val ->
    mods.gregtech.assembler.recipeBuilder()
            .inputs([
                    ore('plateSteel')*3,
                    ore('frameGtSteel')*2,
                    ore('stickLongSteel')*2,
                    ore('circuitMv')
            ])
            .fluidInputs(fluid(key) * val)
            .outputs(item('icbmclassic:launcherbase:0'))
            .duration(400)
            .EUt(30)
            .buildAndRegister();

    mods.gregtech.assembler.recipeBuilder()
            .inputs([
                    ore('plateSteel')*2,
                    ore('stickSteel')*2,
                    ore('paneGlassColorless'),
                    ore('circuitMv')
            ])
            .fluidInputs(fluid(key) * val)
            .outputs(item('icbmclassic:launcherscreen:0'))
            .duration(400)
            .EUt(30)
            .buildAndRegister();

    mods.gregtech.assembler.recipeBuilder()
            .inputs([
                    ore('plateAluminium')*3,
                    ore('frameGtAluminium')*2,
                    ore('stickLongAluminium')*2,
                    ore('circuitHv')
            ])
            .fluidInputs(fluid(key) * val)
            .outputs(item('icbmclassic:launcherbase:1'))
            .duration(400)
            .EUt(60)
            .buildAndRegister();

    mods.gregtech.assembler.recipeBuilder()
            .inputs([
                    ore('plateAluminium')*2,
                    ore('stickAluminium')*2,
                    ore('paneGlassColorless'),
                    ore('circuitHv')
            ])
            .fluidInputs(fluid(key) * val)
            .outputs(item('icbmclassic:launcherscreen:1'))
            .duration(400)
            .EUt(60)
            .buildAndRegister();

    mods.gregtech.assembler.recipeBuilder()
            .inputs([
                    ore('plateStainlessSteel')*3,
                    ore('frameGtStainlessSteel')*2,
                    ore('stickLongStainlessSteel')*2,
                    ore('circuitEv')
            ])
            .fluidInputs(fluid(key) * val)
            .outputs(item('icbmclassic:launcherbase:2'))
            .duration(400)
            .EUt(260)
            .buildAndRegister();

    mods.gregtech.assembler.recipeBuilder()
            .inputs([
                    ore('plateStainlessSteel')*2,
                    ore('stickStainlessSteel')*2,
                    ore('paneGlassColorless'),
                    ore('circuitEv')
            ])
            .fluidInputs(fluid(key) * val)
            .outputs(item('icbmclassic:launcherscreen:2'))
            .duration(400)
            .EUt(260)
            .buildAndRegister();

    mods.gregtech.assembler.recipeBuilder()
            .inputs([
                    ore('frameGtSteel')*3,
                    ore('stickLongSteel')*3,
                    metaitem('sensor.lv')
            ])
            .fluidInputs(fluid(key) * val)
            .outputs(item('icbmclassic:launcherframe:0'))
            .duration(400)
            .EUt(30)
            .buildAndRegister();

    mods.gregtech.assembler.recipeBuilder()
            .inputs([
                    ore('frameGtAluminium')*3,
                    ore('stickLongAluminium')*3,
                    metaitem('sensor.mv')
            ])
            .fluidInputs(fluid(key) * val)
            .outputs(item('icbmclassic:launcherframe:1'))
            .duration(400)
            .EUt(60)
            .buildAndRegister();

    mods.gregtech.assembler.recipeBuilder()
            .inputs([
                    ore('frameGtStainlessSteel')*3,
                    ore('stickLongStainlessSteel')*3,
                    metaitem('sensor.hv')
            ])
            .fluidInputs(fluid(key) * val)
            .outputs(item('icbmclassic:launcherframe:2'))
            .duration(400)
            .EUt(260)
            .buildAndRegister();
}

//Missiles
def solidfuels = [
        ore('dustSugar'),
        ore('dustGunpowder'),
        ore('dustAluminium'),
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
                recipemap('large_weapons_factory').recipeBuilder()
                        .inputs([ore('stickAluminium')*4,
                                 ore('ringAluminium')*2,
                                 ore('plateAluminium')*2,
                                 ore('foilAluminium')*16,
                                 s_oxy*16,
                                 s_fuel*16,
                                 item('icbmclassic:explosives:' + i)
                        ])
                        .fluidInputs(fluid(key) * val)
                        .outputs(item('icbmclassic:missile:' + i))
                        .duration(200)
                        .EUt(30)
                        .buildAndRegister();
            }

            recipemap('weapons_factory').recipeBuilder()
                    .inputs([
                            ore('plateStainlessSteel') * 2,
                            s_oxy,
                            s_fuel,
                            ore('wireFineRedAlloy')
                    ])
                    .circuitMeta(1)
                    .fluidInputs(fluid(key) * val)
                    .outputs(item('openmodularturrets:ammo_meta:4')*8)
                    .duration(20)
                    .EUt(200)
                    .buildAndRegister();

            recipemap('weapons_factory').recipeBuilder()
                    .inputs([
                            ore('plateStainlessSteel') * 2,
                            s_oxy,
                            s_fuel,
                            ore('wireFineRedAlloy')
                    ])
                    .circuitMeta(2)
                    .fluidInputs(fluid(key) * val)
                    .outputs(item('techguns:itemshared', 7)*8)
                    .duration(20)
                    .EUt(200)
                    .buildAndRegister();

            recipemap('weapons_factory').recipeBuilder()
                    .inputs([
                            ore('plateStainlessSteel') * 2,
                            s_oxy * 2,
                            s_fuel * 2,
                            ore('wireFineRedAlloy')
                    ])
                    .circuitMeta(3)
                    .fluidInputs(fluid(key) * val)
                    .outputs(item('techguns:itemshared', 145)*8)
                    .duration(20)
                    .EUt(200)
                    .buildAndRegister();

            recipemap('weapons_factory').recipeBuilder()
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
                recipemap('large_weapons_factory').recipeBuilder()
                        .inputs([ore('stickStainlessSteel')*4,
                                 ore('ringStainlessSteel')*2,
                                 ore('plateStainlessSteel')*2,
                                 ore('foilStainlessSteel')*16,
                                 s_fuel*16,
                                 item('icbmclassic:explosives:' + j)
                        ])
                        .fluidInputs(fluid(key) * val)
                        .fluidInputs(l_oxy*2000)
                        .outputs(item('icbmclassic:missile:' + j))
                        .duration(200)
                        .EUt(120)
                        .buildAndRegister();
            }
        }
    }
    for (h_fuel in hypergolicfuels) {
        for (h_oxy_1 in hypergolicoxys) {
            for (var k = 15; k < 24; k++) {
                recipemap('large_weapons_factory').recipeBuilder()
                        .inputs([ore('stickTitanium')*4,
                                 ore('ringTitanium')*2,
                                 ore('plateTitanium')*2,
                                 ore('foilTitanium')*16,
                                 item('icbmclassic:explosives:' + k)
                        ])
                        .fluidInputs(fluid(key) * val)
                        .fluidInputs(h_oxy_1*4000)
                        .fluidInputs(h_fuel*2000)
                        .outputs(item('icbmclassic:missile:' + k))
                        .duration(200)
                        .EUt(500)
                        .buildAndRegister();
            }
        }
    }
}