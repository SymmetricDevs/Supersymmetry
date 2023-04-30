def soldering_alloys = [
        liquid('tin') * 144,
        liquid('soldering_alloy') * 72
]

def name_removals = [
        "openmodularturrets:disposable_item_turret_vanilla",
        "openmodularturrets:potato_cannon_turret_vanilla",
        "openmodularturrets:turret_base_0_vanilla",
        "openmodularturrets:ammo_meta_0_vanilla",
        "openmodularturrets:ammo_meta_2_vanilla",
        "openmodularturrets:intermediate_regular_0_vanilla",
        "openmodularturrets:machine_gun_turret_vanilla",
        "openmodularturrets:incendiary_turret_vanilla",
        "openmodularturrets:grenade_turret_vanilla",
        "openmodularturrets:rocket_turret_vanilla",
        "openmodularturrets:relativistic_turret_vanilla",
        "openmodularturrets:teleporter_turret_vanilla",
        "openmodularturrets:laser_turret_vanilla",
        "openmodularturrets:rail_gun_turret_vanilla",
        "openmodularturrets:intermediate_tiered_11_vanilla",
        "openmodularturrets:intermediate_tiered_12_vanilla",
        "openmodularturrets:intermediate_tiered_13_vanilla",
        "openmodularturrets:ammo_meta_1_vanilla",
        "openmodularturrets:ammo_meta_3_vanilla",
        "openmodularturrets:ammo_meta_4_vanilla",
        "openmodularturrets:turret_base_1_vanilla",
        "openmodularturrets:turret_base_2_vanilla",
        "openmodularturrets:turret_base_3_vanilla",
        "openmodularturrets:turret_base_4_vanilla",
        "openmodularturrets:intermediate_tiered_7_vanilla",
        "openmodularturrets:intermediate_tiered_8_vanilla",
        "openmodularturrets:intermediate_tiered_9_vanilla"
]

for (item in name_removals) {
    crafting.remove(item);
}

for (solder in soldering_alloys) {

    recipemap('weapons_factory').recipeBuilder()
            .inputs([
                    ore('plateSteel')*4,
                    metaitem('hull.lv'),
                    ore('circuitLv'),
                    item('openmodularturrets:intermediate_regular:0')*2
            ])
            .fluidInputs(solder)
            .outputs(item('openmodularturrets:turret_base:1'))
            .duration(200)
            .EUt(32)
            .buildAndRegister();

    recipemap('weapons_factory').recipeBuilder()
            .inputs([
                    ore('plateAluminium')*4,
                    metaitem('hull.mv'),
                    ore('circuitMv'),
                    item('openmodularturrets:intermediate_regular:0')*2
            ])
            .fluidInputs(solder)
            .outputs(item('openmodularturrets:turret_base:2'))
            .duration(200)
            .EUt(128)
            .buildAndRegister();

    recipemap('weapons_factory').recipeBuilder()
            .inputs([
                    ore('plateStainlessSteel')*4,
                    metaitem('hull.hv'),
                    ore('circuitHv'),
                    item('openmodularturrets:intermediate_regular:0')*2
            ])
            .fluidInputs(solder)
            .outputs(item('openmodularturrets:turret_base:3'))
            .duration(200)
            .EUt(512)
            .buildAndRegister();

    recipemap('weapons_factory').recipeBuilder()
            .inputs([
                    ore('plateTritanium')*4,
                    metaitem('hull.uv'),
                    ore('circuitUv'),
                    item('openmodularturrets:intermediate_regular:0')*2
            ])
            .fluidInputs(solder)
            .outputs(item('openmodularturrets:turret_base:4'))
            .duration(200)
            .EUt(500000)
            .buildAndRegister();

    recipemap('weapons_factory').recipeBuilder()
            .inputs([
                    item('openmodularturrets:intermediate_tiered:6'),
                    item('openmodularturrets:intermediate_tiered:11'),
                    item('openmodularturrets:intermediate_regular:0'),
                    ore('circuitLv'),
                    metaitem('electric.motor.lv') * 2,
                    item('techguns:pistol')
            ])
            .fluidInputs(solder)
            .outputs(item('openmodularturrets:machine_gun_turret'))
            .duration(200)
            .EUt(20)
            .buildAndRegister();

    recipemap('weapons_factory').recipeBuilder()
            .inputs([
                    item('openmodularturrets:intermediate_tiered:6'),
                    item('openmodularturrets:intermediate_tiered:11'),
                    item('openmodularturrets:intermediate_regular:0'),
                    ore('circuitLv'),
                    metaitem('electric.motor.lv') * 2,
                    metaitem('electric.pump.lv') * 2
            ])
            .fluidInputs(solder)
            .outputs(item('openmodularturrets:incendiary_turret'))
            .duration(200)
            .EUt(20)
            .buildAndRegister();

    recipemap('weapons_factory').recipeBuilder()
            .inputs([
                    item('openmodularturrets:intermediate_tiered:7'),
                    item('openmodularturrets:intermediate_tiered:12'),
                    item('openmodularturrets:intermediate_regular:0'),
                    ore('plateAluminium')*4,
                    ore('circuitMv'),
                    metaitem('electric.motor.mv') * 2,
            ])
            .fluidInputs(solder)
            .outputs(item('openmodularturrets:grenade_turret'))
            .duration(200)
            .EUt(60)
            .buildAndRegister();

    recipemap('weapons_factory').recipeBuilder()
            .inputs([
                    item('openmodularturrets:intermediate_tiered:8'),
                    item('openmodularturrets:intermediate_tiered:13'),
                    item('openmodularturrets:intermediate_regular:0'),
                    ore('plateStainlessSteel')*4,
                    ore('circuitHv'),
                    metaitem('electric.motor.hv') * 2,
            ])
            .fluidInputs(solder)
            .outputs(item('openmodularturrets:rocket_turret'))
            .duration(200)
            .EUt(300)
            .buildAndRegister();

    recipemap('weapons_factory').recipeBuilder()
            .inputs([
                    ore('plateSteel'),
                    ore('dustGunpowder'),
                    ore('roundLead')
            ])
            .fluidInputs(solder)
            .outputs(item('openmodularturrets:ammo_meta:1')*8)
            .duration(10)
            .EUt(16)
            .buildAndRegister();

    recipemap('weapons_factory').recipeBuilder()
            .inputs([
                    ore('roundAluminium')*4,
                    ore('plateSteel'),
                    ore('dustGunpowder')
            ])
            .fluidInputs(solder)
            .outputs(item('openmodularturrets:ammo_meta:3'))
            .duration(10)
            .EUt(60)
            .buildAndRegister();

    recipemap('weapons_factory').recipeBuilder()
            .inputs([
                    ore('wireFineRedAlloy'),
                    metaitem('conveyor.module.lv'),
                    ore('plateGold'),
                    ore('plateIron')
            ])
            .fluidInputs(solder)
            .outputs(item('openmodularturrets:intermediate_regular:0'))
            .duration(200)
            .EUt(20)
            .buildAndRegister();

    recipemap('weapons_factory').recipeBuilder()
            .inputs([
                    ore('plateDenseSteel'),
                    ore('wireFineRedAlloy'),
                    ore('plateSteel'),
                    ore('springSteel'),
                    ore('gearSteel')
            ])
            .fluidInputs(solder)
            .outputs(item('openmodularturrets:intermediate_tiered:6'))
            .duration(200)
            .EUt(20)
            .buildAndRegister();

    recipemap('weapons_factory').recipeBuilder()
            .inputs([
                    ore('plateAluminium')*10,
                    ore('wireFineRedAlloy'),
                    ore('springSteel'),
                    ore('gearAluminium')
            ])
            .fluidInputs(solder)
            .outputs(item('openmodularturrets:intermediate_tiered:7'))
            .duration(200)
            .EUt(60)
            .buildAndRegister();

    recipemap('weapons_factory').recipeBuilder()
            .inputs([
                    ore('plateStainlessSteel')*10,
                    ore('wireFineRedAlloy'),
                    ore('springSteel'),
                    ore('gearStainlessSteel')
            ])
            .fluidInputs(solder)
            .outputs(item('openmodularturrets:intermediate_tiered:8'))
            .duration(200)
            .EUt(300)
            .buildAndRegister();

    recipemap('weapons_factory').recipeBuilder()
            .inputs([
                    ore('plateTritanium')*10,
                    ore('wireFineRedAlloy'),
                    ore('springSteel'),
                    ore('gearTritanium')
            ])
            .fluidInputs(solder)
            .outputs(item('openmodularturrets:intermediate_tiered:9'))
            .duration(200)
            .EUt(500000)
            .buildAndRegister();

    recipemap('weapons_factory').recipeBuilder()
            .inputs([
                    ore('plateSteel')*6,
                    item('techguns:itemshared:39')
            ])
            .fluidInputs(solder)
            .outputs(item('openmodularturrets:intermediate_tiered:11'))
            .duration(200)
            .EUt(20)
            .buildAndRegister();

    recipemap('weapons_factory').recipeBuilder()
            .inputs([
                    ore('plateAluminium')*6,
                    item('techguns:itemshared:39')
            ])
            .fluidInputs(solder)
            .outputs(item('openmodularturrets:intermediate_tiered:12'))
            .duration(200)
            .EUt(60)
            .buildAndRegister();

    recipemap('weapons_factory').recipeBuilder()
            .inputs([
                    ore('plateStainlessSteel')*6,
                    item('techguns:itemshared:39')
            ])
            .fluidInputs(solder)
            .outputs(item('openmodularturrets:intermediate_tiered:13'))
            .duration(200)
            .EUt(300)
            .buildAndRegister();
}

recipemap('mixer').recipeBuilder()
        .inputs([
                ore('dustClay')
        ])
        .fluidInputs(liquid('gasoline')*1000)
        .outputs(item('openmodularturrets:ammo_meta:0')*32)
        .duration(20)
        .EUt(30)
        .buildAndRegister();