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
    crafting.remove(item);
}

Globals.solders.each { key, val ->
    recipemap('weapons_factory').recipeBuilder()
            .inputs([
                    ore('ringRubber')*4,
                    ore('platePlastic'),
                    ore('plateSteel')
            ])
            .fluidInputs(fluid(key) * val)
            .outputs(item('gaspunk:diffuser'))
            .duration(200)
            .EUt(60)
            .buildAndRegister();

    recipemap('weapons_factory').recipeBuilder()
            .inputs([
                    ore('ringRubber')*4,
                    metaitem('component.glass.tube'),
                    ore('plateSteel')
            ])
            .fluidInputs(fluid(key) * val)
            .outputs(item('gp_inhaler:empty_inhaler'))
            .duration(200)
            .EUt(60)
            .buildAndRegister();
}

//TODO: ADD METHOD TO CREATE WHITE PHOSPHORUS
/*
mods.gregtech.mixer.recipeBuilder()
        .inputs([metaitem('dustWhitePhosphorus')])
        .fluidInputs([liquid('oxygen') * 1000])
        .fluidInputs([liquid('smoke_bomb_mix') * 1000])
        .duration(200)
        .EUt(60)
        .buildAndRegister();

*/

//TODO: UNCOMMENT THESE AFTER THE CHEMISTRY OVERHAUL^3
def GasMapMV = [
    'fluorine': "gaspunk:fluorine",
    'carbon_monoxide': "gaspunk:carbon_monoxide",
    'chlorine': "gaspunk:chlorine",
    //'diborane': "gaspunk:diborane",
    'gtfo_hydrogen_cyanide': "gaspunk:hydrogen_cyanide",
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
