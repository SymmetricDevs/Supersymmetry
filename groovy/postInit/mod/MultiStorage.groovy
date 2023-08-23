def name_removals = [
        'multistorage:vault-bucket-gray',
        'multistorage:vault-bucket-cyan',
        'multistorage:vault-bucket-pink',
        'multistorage:vault-bucket-black',
        'multistorage:vault-bucket-light_blue',
        'multistorage:vault-bucket-silver',
        'multistorage:vault-bucket-purple',
        'multistorage:vault-bucket-blue',
        'multistorage:vault-bucket-magenta',
        'multistorage:vault-bucket-green',
        'multistorage:vault-bucket-yellow',
        'multistorage:vault-bucket-lime',
        'multistorage:vault-bucket-red',
        'multistorage:vault-bucket-orange',
        'multistorage:vault-bucket-white',
        'multistorage:vault-bucket-brown',
        'multistorage:enderbag_gray',
        'multistorage:enderbag_cyan',
        'multistorage:enderbag_pink',
        'multistorage:enderbag_black',
        'multistorage:enderbag_light_blue',
        'multistorage:enderbag_silver',
        'multistorage:enderbag_purple',
        'multistorage:enderbag_blue',
        'multistorage:enderbag_magenta',
        'multistorage:enderbag_green',
        'multistorage:enderbag_yellow',
        'multistorage:enderbag_lime',
        'multistorage:enderbag_red',
        'multistorage:enderbag_orange',
        'multistorage:enderbag_white',
        'multistorage:enderbag_brown',
        'multistorage:enderchest_gray',
        'multistorage:enderchest_cyan',
        'multistorage:enderchest_pink',
        'multistorage:enderchest_black',
        'multistorage:enderchest_light_blue',
        'multistorage:enderchest_silver',
        'multistorage:enderchest_purple',
        'multistorage:enderchest_blue',
        'multistorage:enderchest_magenta',
        'multistorage:enderchest_green',
        'multistorage:enderchest_yellow',
        'multistorage:enderchest_lime',
        'multistorage:enderchest_red',
        'multistorage:enderchest_orange',
        'multistorage:enderchest_white',
        'multistorage:enderchest_brown',
        'multistorage:vault-door',
        'multistorage:vault-corer_alt3',
        'multistorage:vault-corer_alt2',
        'multistorage:vault-corer_alt',
        'multistorage:vault-corer',
        'multistorage:stone-upgrade',
        'multistorage:stone-stacking',
        'multistorage:stone-stacking_dense',
        'multistorage:stone-chameleon',
        'multistorage:stone-chameleon_dense',
        'multistorage:stone-junkbox',
        'multistorage:stone-junkbox_dense',
        'multistorage:stone-queue',
        'multistorage:stone-queue_dense',
        'multistorage:enderbag'
]

for (name in name_removals) {
    crafting.remove(name)
}

def cvalues = [10329495, 16351261, 8439583, 15961002, 11546150, 16383998, 3847130, 16701501, 8606770, 3949738, 4673362, 1481884, 6192150, 13061821, 1908001, 8991416]
def vaultcolors = ["silver", "orange", "lime", "pink", "red", "white", "light_blue", "yellow", "brown", "blue", "gray", "cyan", "green", "magenta", "black", "purple"]
def dyes = ["light_gray", "orange", "lime", "pink", "red", "white", "light_blue", "yellow", "brown", "blue", "gray", "cyan", "green", "magenta", "black", "purple"]

recipemap('assembler').recipeBuilder()
        .inputs(item('gregtech:stone_smooth', 4) * 4)
        .inputs(metaitem('electric.motor.lv') * 2)
        .inputs(ore('stickSteel') * 8)
        .inputs(ore('plateSteel') * 8)
        .inputs(ore('screwSteel') * 8)
        .outputs(item('multistorage:vault'))
        .duration(200)
        .EUt(30)
        .buildAndRegister()

recipemap('assembler').recipeBuilder()
        .circuitMeta(12)
        .fluidInputs(fluid('concrete') * 144)
        .inputs(metaitem('frameSteel'))
        .inputs(ore('plateSteel') * 6)
        .outputs(item('multistorage:vault', 1).withNbt(["color": "silver", "cvalue": 10329495]) * 2)
        .duration(200)
        .EUt(30)
        .buildAndRegister()

recipemap('assembler').recipeBuilder()
        .circuitMeta(12)
        .inputs(item('gregtech:transparent_casing'))
        .inputs(metaitem('frameSteel'))
        .inputs(ore('stickSteel') * 6)
        .outputs(item('multistorage:vault', 13).withNbt(["color": "silver", "cvalue": 10329495]) * 2)
        .duration(200)
        .EUt(30)
        .buildAndRegister()

recipemap('assembler').recipeBuilder()
        .circuitMeta(13)
        .fluidInputs(fluid('concrete') * 144)
        .inputs(item('minecraft:chest'))
        .inputs(metaitem('frameSteel'))
        .inputs(ore('plateSteel') * 4)
        .outputs(item('multistorage:vault', 2).withNbt(["color": "silver", "cvalue": 10329495]))
        .duration(200)
        .EUt(30)
        .buildAndRegister()

recipemap('assembler').recipeBuilder()
        .circuitMeta(14)
        .fluidInputs(fluid('concrete') * 144)
        .inputs(ore('wireGtSingleRedAlloy') * 2)
        .inputs(metaitem('frameSteel'))
        .inputs(ore('plateSteel') * 4)
        .outputs(item('multistorage:vault', 3).withNbt(["color": "silver", "cvalue": 10329495]))
        .duration(200)
        .EUt(30)
        .buildAndRegister()

recipemap('assembler').recipeBuilder()
        .circuitMeta(15)
        .fluidInputs(fluid('concrete') * 144)
        .inputs(ore('pipeSmallFluidSteel'))
        .inputs(metaitem('frameSteel'))
        .inputs(ore('plateSteel') * 4)
        .outputs(item('multistorage:vault', 4).withNbt(["color": "silver", "cvalue": 10329495]))
        .duration(200)
        .EUt(30)
        .buildAndRegister()

recipemap('assembler').recipeBuilder()
        .circuitMeta(16)
        .fluidInputs(fluid('concrete') * 144)
        .inputs(ore('cableGtSingleTin') * 2)
        .inputs(metaitem('frameSteel'))
        .inputs(ore('plateSteel') * 4)
        .outputs(item('multistorage:vault', 5).withNbt(["color": "silver", "cvalue": 10329495]))
        .duration(200)
        .EUt(30)
        .buildAndRegister()

for (int i = 1; i < 16; i++) {
    recipemap('chemical_bath').recipeBuilder()
            .fluidInputs(fluid('dye_' + dyes[i]) * 18)
            .inputs(item('multistorage:vault', 1).withNbt(["color": "silver", "cvalue": 10329495]))
            .outputs(item('multistorage:vault', 1).withNbt(["color": vaultcolors[i], "cvalue": cvalues[i]]))
            .duration(20)
            .EUt(7)
            .buildAndRegister()
}

for (int i = 1; i < 16; i++) {
    recipemap('chemical_bath').recipeBuilder()
            .fluidInputs(fluid('dye_' + dyes[i]) * 18)
            .inputs(item('multistorage:vault', 2).withNbt(["color": "silver", "cvalue": 10329495]))
            .outputs(item('multistorage:vault', 2).withNbt(["color": vaultcolors[i], "cvalue": cvalues[i]]))
            .duration(20)
            .EUt(7)
            .buildAndRegister()
}

for (int i = 1; i < 16; i++) {
    recipemap('chemical_bath').recipeBuilder()
            .fluidInputs(fluid('dye_' + dyes[i]) * 18)
            .inputs(item('multistorage:vault', 3).withNbt(["color": "silver", "cvalue": 10329495]))
            .outputs(item('multistorage:vault', 3).withNbt(["color": vaultcolors[i], "cvalue": cvalues[i]]))
            .duration(20)
            .EUt(7)
            .buildAndRegister()
}

for (int i = 1; i < 16; i++) {
    recipemap('chemical_bath').recipeBuilder()
            .fluidInputs(fluid('dye_' + dyes[i]) * 18)
            .inputs(item('multistorage:vault', 4).withNbt(["color": "silver", "cvalue": 10329495]))
            .outputs(item('multistorage:vault', 4).withNbt(["color": vaultcolors[i], "cvalue": cvalues[i]]))
            .duration(20)
            .EUt(7)
            .buildAndRegister()
}

for (int i = 1; i < 16; i++) {
    recipemap('chemical_bath').recipeBuilder()
            .fluidInputs(fluid('dye_' + dyes[i]) * 18)
            .inputs(item('multistorage:vault', 5).withNbt(["color": "silver", "cvalue": 10329495]))
            .outputs(item('multistorage:vault', 5).withNbt(["color": vaultcolors[i], "cvalue": cvalues[i]]))
            .duration(20)
            .EUt(7)
            .buildAndRegister()
}

for (int i = 1; i < 16; i++) {
    recipemap('chemical_bath').recipeBuilder()
            .fluidInputs(fluid('dye_' + dyes[i]) * 18)
            .inputs(item('multistorage:vault', 13).withNbt(["color": "silver", "cvalue": 10329495]))
            .outputs(item('multistorage:vault', 13).withNbt(["color": vaultcolors[i], "cvalue": cvalues[i]]))
            .duration(20)
            .EUt(7)
            .buildAndRegister()
}