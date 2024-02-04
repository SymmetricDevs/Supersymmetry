import globals.Globals
import static globals.SinteringGlobals.*

class CoolantGases {
    String name
    String byproduct
    int amount
    int duration

    CoolantGases(name, byproduct, amount, duration) {
        this.name = name
        this.byproduct = byproduct
        this.amount = amount
        this.duration = duration
    }
}


def SINTERING_RECIPES = recipemap("sintering_oven")
for (fuel in sintering_fuels) {

    if (fuel.isPlasma) {
        SINTERING_RECIPES.recipeBuilder()
        .inputs(ore('dustClay'))
        .inputs(ore('dustLimestone'))
        .circuitMeta(1)
        .fluidInputs(fluid(fuel.name) * fuel.amountRequired)
        .outputs(metaitem('hot.cement.clinker'))
        .fluidOutputs(fluid(fuel.byproduct) * fuel.byproductAmount)
        .duration(fuel.duration)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()

        SINTERING_RECIPES.recipeBuilder()
        .inputs(ore('dustClay'))
        .inputs(ore('dustLimestone'))
        .inputs(ore('dustTinyGypsum'))
        .circuitMeta(2)
        .fluidInputs(fluid(fuel.name) * fuel.amountRequired)
        .outputs(metaitem('hot.cement.clinker'))
        .chancedOutput(metaitem('hot.cement.clinker'), 5000, 0)
        .fluidOutputs(fluid(fuel.byproduct) * fuel.byproductAmount)
        .duration(fuel.duration)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()

    } else {
        for (comburent in sintering_comburents) {
            SINTERING_RECIPES.recipeBuilder()
            .inputs(ore('dustClay'))
            .inputs(ore('dustLimestone'))
            .circuitMeta(1)
            .fluidInputs(fluid(fuel.name) * fuel.amountRequired)
            .fluidInputs(fluid(comburent.name) * comburent.amountRequired)
            .outputs(metaitem('hot.cement.clinker'))
            .fluidOutputs(fluid(fuel.byproduct) * fuel.byproductAmount)
            .duration(fuel.duration + comburent.duration)
            .EUt(Globals.voltAmps[0])
            .buildAndRegister()

            SINTERING_RECIPES.recipeBuilder()
            .inputs(ore('dustClay'))
            .inputs(ore('dustLimestone'))
            .inputs(ore('dustTinyGypsum'))
            .circuitMeta(2)
            .fluidInputs(fluid(fuel.name) * fuel.amountRequired)
            .fluidInputs(fluid(comburent.name) * comburent.amountRequired)
            .outputs(metaitem('hot.cement.clinker'))
            .chancedOutput(metaitem('hot.cement.clinker'), 5000, 0)
            .fluidOutputs(fluid(fuel.byproduct) * fuel.byproductAmount)
            .duration(fuel.duration + comburent.duration)
            .EUt(Globals.voltAmps[0])
            .buildAndRegister()
        }
    }

}

def gases = [
    new CoolantGases('air', 'hot_air', 100, 40)
]

for (gas in gases) {
    mods.gregtech.mixer.recipeBuilder()
        .inputs(metaitem('hot.cement.clinker'))
        .fluidInputs(fluid(gas.name) * gas.amount)
        .outputs(metaitem('cement.clinker'))
        .fluidOutputs(fluid(gas.byproduct) * gas.amount)
        .duration(gas.duration)
        .EUt(Globals.voltAmps[0])
        .buildAndRegister()
}

mods.gregtech.macerator.recipeBuilder()
    .inputs(metaitem('cement.clinker'))
    .outputs(metaitem('cement.dust') * 16)
    .duration(20)
    .EUt(Globals.voltAmps[0])
    .buildAndRegister()

def stones = [
    'dustStone',
    'dustMarble',
    'gravel',
    'sand'
]

for (stone in stones) {
    mods.gregtech.mixer.recipeBuilder()
        .inputs(ore(stone))
        .inputs(ore('dustCement'))
        .fluidInputs(fluid('water') * 500)
        .fluidOutputs(fluid('concrete') * 576)
        .duration(20)
        .EUt(Globals.voltAmps[0])
        .buildAndRegister()
}

def dyes = [
    'dye_white',
    'dye_orange',
    'dye_magenta',
    'dye_light_blue',
    'dye_yellow',
    'dye_lime',
    'dye_pink',
    'dye_gray',
    'dye_light_gray',
    'dye_cyan',
    'dye_purple',
    'dye_blue',
    'dye_brown',
    'dye_green',
    'dye_red',
    'dye_black'
]

for (int i = 0; i < 16; i++) {
    mods.gregtech.mixer.recipeBuilder()
        .inputs(ore('dustConcrete'))
        .fluidInputs(fluid(dyes[i]) * 18)
        .outputs(item('minecraft:concrete_powder', i))
        .duration(20)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

    mods.gregtech.chemical_bath.recipeBuilder()
        .inputs(ore('blockConcrete'))
        .fluidInputs(fluid(dyes[i]) * 18)
        .outputs(item('minecraft:concrete', i))
        .duration(20)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()
}

//REMOVALS OF DEFAULT RECIPES
// Concrete * 576
mods.gregtech.mixer.removeByInput(16, [metaitem('dustClay'), metaitem('dustStone') * 3], [fluid('water') * 500])
mods.gregtech.blender.removeByInput(16, [metaitem('dustClay'), metaitem('dustStone') * 3], [fluid('water') * 500])
// Concrete * 1152
mods.gregtech.mixer.removeByInput(16, [metaitem('dustStone') * 2, metaitem('dustCalcite'), metaitem('dustGypsum')], [fluid('water') * 1000])
mods.gregtech.blender.removeByInput(16, [metaitem('dustStone') * 2, metaitem('dustCalcite'), metaitem('dustGypsum')], [fluid('water') * 1000])
// Concrete * 1152
mods.gregtech.mixer.removeByInput(16, [metaitem('dustStone') * 2, metaitem('dustMarble'), metaitem('dustGypsum')], [fluid('water') * 1000])
mods.gregtech.blender.removeByInput(16, [metaitem('dustStone') * 2, metaitem('dustMarble'), metaitem('dustGypsum')], [fluid('water') * 1000])

def name_removals = [
    'minecraft:white_concrete_powder',
    'minecraft:orange_concrete_powder',
    'minecraft:magenta_concrete_powder',
    'minecraft:light_blue_concrete_powder',
    'minecraft:yellow_concrete_powder',
    'minecraft:lime_concrete_powder',
    'minecraft:pink_concrete_powder',
    'minecraft:gray_concrete_powder',
    'minecraft:light_gray_concrete_powder',
    'minecraft:cyan_concrete_powder',
    'minecraft:purple_concrete_powder',
    'minecraft:blue_concrete_powder',
    'minecraft:brown_concrete_powder',
    'minecraft:green_concrete_powder',
    'minecraft:red_concrete_powder',
    'minecraft:black_concrete_powder',
    'gregtech:bucket_of_concrete'
]

for (name in name_removals) {
    crafting.remove(name)
}

for (dye in dyes) {
    // Concrete Powder * 8
    mods.gregtech.mixer.removeByInput(7, [item('minecraft:sand') * 4, item('minecraft:gravel') * 4], [fluid(dye) * 144])
    mods.gregtech.blender.removeByInput(7, [item('minecraft:sand') * 4, item('minecraft:gravel') * 4], [fluid(dye) * 144])
}

for (int i = 0; i < 16; i++) {
    // Colour Concrete * 1
    mods.gregtech.chemical_bath.removeByInput(7, [item('minecraft:concrete_powder', i)], [fluid('water') * 1000])
}
