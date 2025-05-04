import gregtech.api.recipes.ingredients.nbtmatch.*



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
        "openmodularturrets:intermediate_tiered_14_vanilla",
        "openmodularturrets:ammo_meta_1_vanilla",
        "openmodularturrets:ammo_meta_3_vanilla",
        "openmodularturrets:ammo_meta_4_vanilla",
        "openmodularturrets:turret_base_1_vanilla",
        "openmodularturrets:turret_base_2_vanilla",
        "openmodularturrets:turret_base_3_vanilla",
        "openmodularturrets:turret_base_4_vanilla",
        "openmodularturrets:intermediate_tiered_5_vanilla",
        "openmodularturrets:intermediate_tiered_6_vanilla",
        "openmodularturrets:intermediate_tiered_7_vanilla",
        "openmodularturrets:intermediate_tiered_8_vanilla",
        "openmodularturrets:intermediate_tiered_9_vanilla",
        "openmodularturrets:intermediate_tiered_10_vanilla",
        "openmodularturrets:addon_meta_0_vanilla",
        "openmodularturrets:addon_meta_1_vanilla",
        "openmodularturrets:addon_meta_3_vanilla",
        "openmodularturrets:addon_meta_4_vanilla",
        "openmodularturrets:addon_meta_6_vanilla",
        "openmodularturrets:addon_meta_7_vanilla",
        "openmodularturrets:upgrade_meta_1_vanilla",
        "openmodularturrets:upgrade_meta_4_vanilla",
        "openmodularturrets:base_addon_meta_0_vanilla"
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
            .EUt(30)
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
            .EUt(120)
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
            .EUt(480)
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
            ])
            .inputNBT(item('techguns:pistol').getItem(), NBTMatcher.ANY, NBTCondition.ANY)
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
                    ore('plateLead'),
                    ore('plateIron')
            ])
            .fluidInputs(solder)
            .outputs(item('openmodularturrets:intermediate_regular:0'))
            .duration(200)
            .EUt(20)
            .buildAndRegister();

    recipemap('weapons_factory').recipeBuilder()
            .inputs([
                    ore('plateSteel')*10,
                    ore('wireFineRedAlloy'),
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
            .circuitMeta(1)
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
            .circuitMeta(1)
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
            .circuitMeta(1)
            .fluidInputs(solder)
            .outputs(item('openmodularturrets:intermediate_tiered:13'))
            .duration(200)
            .EUt(300)
            .buildAndRegister();
}

recipemap('mixer').recipeBuilder()
        .inputs(ore('dustClay'))
        .fluidInputs(liquid('gasoline')*1000)
        .outputs(item('openmodularturrets:ammo_meta:0')*32)
        .duration(20)
        .EUt(30)
        .buildAndRegister();

crafting.replaceShaped("openmodularturrets:addon_meta_5_vanilla", item('openmodularturrets:addon_meta', 5), [
        [null, ore('circuitMv'), null],
        [item('openmodularturrets:intermediate_regular'), metaitem('plateSteel'), item('openmodularturrets:intermediate_regular')],
        [null, item('opencomputers:component', 4), null]
])

crafting.replaceShaped("openmodularturrets:upgrade_meta_0_vanilla", item('openmodularturrets:upgrade_meta'), [
        [null, ore('craftingLensGlass'), null],
        [ore('craftingLensGlass'), ore('circuitMv'), ore('craftingLensGlass')],
        [null, item('openmodularturrets:intermediate_regular'), null]
])

crafting.replaceShaped("openmodularturrets:upgrade_meta_2_vanilla", item('openmodularturrets:upgrade_meta', 2), [
        [null, item('techguns:itemshared', 39), null],
        [item('techguns:itemshared', 39), metaitem('electric.motor.mv'), item('techguns:itemshared', 39)],
        [null, item('openmodularturrets:intermediate_regular'), null]
])

crafting.replaceShaped("openmodularturrets:upgrade_meta_3_vanilla", item('openmodularturrets:upgrade_meta', 3), [
        [null, item('techguns:itemshared', 39), null],
        [metaitem('electric.piston.mv'), item('techguns:itemshared', 39), metaitem('electric.piston.mv')],
        [null, item('openmodularturrets:intermediate_regular'), null]
])

crafting.replaceShaped("openmodularturrets:expander_0_vanilla", item('openmodularturrets:expander'), [
        [null, metaitem('plateLead'), null],
        [item('openmodularturrets:intermediate_regular'), item('minecraft:chest'), item('openmodularturrets:intermediate_regular')],
        [null, metaitem('plateLead'), null]
])

crafting.replaceShaped("openmodularturrets:expander_1_vanilla", item('openmodularturrets:expander', 1), [
        [null, metaitem('plateSteel'), null],
        [item('openmodularturrets:intermediate_regular'), metaitem('crate.steel'), item('openmodularturrets:intermediate_regular')],
        [null, metaitem('plateSteel'), null]
])

crafting.replaceShaped("openmodularturrets:expander_2_vanilla", item('openmodularturrets:expander', 2), [
        [null, metaitem('plateAluminium'), null],
        [item('openmodularturrets:intermediate_regular'), metaitem('crate.aluminium'), item('openmodularturrets:intermediate_regular')],
        [null, metaitem('plateAluminium'), null]
])

crafting.replaceShaped("openmodularturrets:expander_3_vanilla", item('openmodularturrets:expander', 3), [
        [null, metaitem('plateStainlessSteel'), null],
        [item('openmodularturrets:intermediate_regular'), metaitem('crate.stainless_steel'), item('openmodularturrets:intermediate_regular')],
        [null, metaitem('plateStainlessSteel'), null]
])

crafting.replaceShaped("openmodularturrets:expander_4_vanilla", item('openmodularturrets:expander', 4), [
        [null, metaitem('plateTitanium'), null],
        [item('openmodularturrets:intermediate_regular'), metaitem('crate.titanium'), item('openmodularturrets:intermediate_regular')],
        [null, metaitem('plateTitanium'), null]
])

crafting.replaceShaped("openmodularturrets:expander_5_vanilla", item('openmodularturrets:expander', 5), [
        [null, metaitem('plateLead'), null],
        [item('openmodularturrets:intermediate_regular'), metaitem('energy_hatch.input.ulv'), item('openmodularturrets:intermediate_regular')],
        [null, metaitem('plateLead'), null]
])

crafting.replaceShaped("openmodularturrets:expander_6_vanilla", item('openmodularturrets:expander', 6), [
        [null, metaitem('plateSteel'), null],
        [item('openmodularturrets:intermediate_regular'), metaitem('energy_hatch.input.lv'), item('openmodularturrets:intermediate_regular')],
        [null, metaitem('plateSteel'), null]
])

crafting.replaceShaped("openmodularturrets:expander_7_vanilla", item('openmodularturrets:expander', 7), [
        [null, metaitem('plateAluminium'), null],
        [item('openmodularturrets:intermediate_regular'), metaitem('energy_hatch.input.mv'), item('openmodularturrets:intermediate_regular')],
        [null, metaitem('plateAluminium'), null]
])

crafting.replaceShaped("openmodularturrets:expander_8_vanilla", item('openmodularturrets:expander', 8), [
        [null, metaitem('plateStainlessSteel'), null],
        [item('openmodularturrets:intermediate_regular'), metaitem('energy_hatch.input.hv'), item('openmodularturrets:intermediate_regular')],
        [null, metaitem('plateStainlessSteel'), null]
])

crafting.replaceShaped("openmodularturrets:expander_9_vanilla", item('openmodularturrets:expander', 9), [
        [null, metaitem('plateTitanium'), null],
        [item('openmodularturrets:intermediate_regular'), metaitem('energy_hatch.input.ev'), item('openmodularturrets:intermediate_regular')],
        [null, metaitem('plateTitanium'), null]
])

crafting.replaceShaped("openmodularturrets:intermediate_tiered_0_vanilla", item('openmodularturrets:intermediate_tiered'), [
        [null, metaitem('plateSteel'), null],
        [item('openmodularturrets:intermediate_regular'), metaitem('sensor.lv'), item('openmodularturrets:intermediate_regular')],
        [null, metaitem('plateSteel'), null]
])

crafting.replaceShaped("openmodularturrets:intermediate_tiered_1_vanilla", item('openmodularturrets:intermediate_tiered', 1), [
        [null, metaitem('plateAluminium'), null],
        [item('openmodularturrets:intermediate_regular'), metaitem('sensor.mv'), item('openmodularturrets:intermediate_regular')],
        [null, metaitem('plateAluminium'), null]
])

crafting.replaceShaped("openmodularturrets:intermediate_tiered_2_vanilla", item('openmodularturrets:intermediate_tiered', 2), [
        [null, metaitem('plateStainlessSteel'), null],
        [item('openmodularturrets:intermediate_regular'), metaitem('sensor.hv'), item('openmodularturrets:intermediate_regular')],
        [null, metaitem('plateStainlessSteel'), null]
])

crafting.replaceShaped("openmodularturrets:intermediate_tiered_3_vanilla", item('openmodularturrets:intermediate_tiered', 3), [
        [null, metaitem('plateTitanium'), null],
        [item('openmodularturrets:intermediate_regular'), metaitem('sensor.ev'), item('openmodularturrets:intermediate_regular')],
        [null, metaitem('plateTitanium'), null]
])

crafting.replaceShaped("openmodularturrets:intermediate_tiered_4_vanilla", item('openmodularturrets:intermediate_tiered', 4), [
        [null, metaitem('plateTungstenSteel'), null],
        [item('openmodularturrets:intermediate_regular'), metaitem('sensor.iv'), item('openmodularturrets:intermediate_regular')],
        [null, metaitem('plateTungstenSteel'), null]
])