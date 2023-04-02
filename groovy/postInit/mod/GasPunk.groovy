def soldering_alloys = [
        liquid('tin') * 144,
        liquid('soldering_alloy') * 72
]

def name_removals = [
        "gaspunk:diffuser",
        "gaspunk:grenade",
        "gaspunk:vapor_grenade",
        "gaspunk:grenade_refill",
        "gaspunk:grenade_recycling",
        "gaspunk:inhaler",
        "gp_inhaler:empty_inhaler",
        "gp_inhaler:vapor_inhaler",
        "gp_inhaler:inhaler",
        "gaspunk:vapor_inhaler"
]

for (item in name_removals) {
    //crafting.remove(item);
}


/*
//Brewing removals
brewing.remove(item('minecraft:potion').withTag({Potion: "minecraft:water"}), ore('dustSulfur').firstItem);
brewing.removeRecipe(item('gaspunk:gas_tube').withTag({"gaspunk:contained_gas": "gaspunk:smoke"}), item('minecraft:sugar'));
brewing.removeRecipe(item('gaspunk:gas_tube').withTag({"gaspunk:contained_gas": "gaspunk:smoke"}), item('gaspunk:ash'));
brewing.removeRecipe(item('gaspunk:gas_tube').withTag({"gaspunk:contained_gas": "gaspunk:smoke"}), item('minecraft:ghast_tear'));
brewing.removeRecipe(item('gaspunk:gas_tube').withTag({"gaspunk:contained_gas": "gaspunk:smoke"}), item('minecraft:fermented_spider_eye'));
brewing.removeRecipe(item('minecraft:potion').withTag({Potion: "minecraft:water"}), ore('dustSulfur').firstItem);
brewing.removeRecipe(item('minecraft:potion').withTag({Potion: "minecraft:water"}), item('minecraft:poisonous_potato'));
*/

for (solder in soldering_alloys) {
    recipemap('weapons_factory').recipeBuilder()
            .inputs([
                    ore('ringRubber')*4,
                    ore('platePlastic'),
                    ore('plateSteel')
            ])
            .fluidInputs(solder)
            .outputs(item('gaspunk:diffuser'))
            .duration(200)
            .EUt(60)
            .buildAndRegister();
}

/*
mods.gregtech.mixer.recipeBuilder()
        .inputs([metaitem('dustWhitePhosphorus')])
        .fluidInputs([liquid('oxygen') * 1000])
        .fluidInputs([liquid('smoke_bomb_mix') * 1000])
        .duration(200)
        .EUt(60)
        .buildAndRegister();

*/

def GasMapMV = [
    'fluorine': "gaspunk:fluorine",
    'carbon_monoxide': "gaspunk:carbon_monoxide",
    'chlorine': "gaspunk:chlorine",
    //'diborane': "gaspunk:diborane",
    //'hydrogen_cyanide': "gaspunk:hydrogen_cyanide",
    'radon': "gaspunk:radon",
    //'phosphine': "gaspunk:phosphine",
    'smoke_bomb_mix': "gaspunk:smoke",
    'chloroform': "gaspunk:chloroform",
    'hydrogen_sulfide': "gaspunk:hydrogen_sulfide",
    'ammonia': "gaspunk:ammonia",
    'hydrochloric_acid': "gaspunk:hydrochloric_acid",
    'hydrofluoric_acid': "gaspunk:hydrofluoric_acid"
]

for (key in GasMapMV) {
    mods.gregtech.canner.recipeBuilder()
            .inputs([item('minecraft:glass_bottle')])
            .fluidInputs(liquid(key.getKey())*100)
            .outputs(item('gaspunk:gas_tube').withNbt(["gaspunk:contained_gas": GasMapMV[key.getKey()]]))
            .duration(20)
            .EUt(60)
            .buildAndRegister();

    mods.gregtech.canner.recipeBuilder()
            .inputs([item('gaspunk:diffuser')])
            .fluidInputs(liquid(key.getKey())*100)
            .outputs(item('gaspunk:grenade').withNbt(["gaspunk:contained_gas": GasMapMV[key.getKey()]]))
            .duration(20)
            .EUt(60)
            .buildAndRegister();

    mods.gregtech.canner.recipeBuilder()
            .inputs(item('gp_inhaler:empty_inhaler'))
            .fluidInputs(liquid(key.getKey())*100)
            .outputs(item('gp_inhaler:inhaler').withNbt(["gaspunk:contained_gas": GasMapMV[key.getKey()]]))
            .duration(20)
            .EUt(60)
            .buildAndRegister();
}
