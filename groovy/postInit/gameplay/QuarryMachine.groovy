import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*
import gregtech.api.recipes.RecipeBuilder
import globals.Globals

crafting.addShaped("susy:quarry_controller", metaitem('susy:quarry'), [
    [ore('plateSteel'), metaitem('electric.motor.lv'), ore('plateSteel')],
    [ore('circuitLv'), metaitem('hull.lv'), ore('circuitLv')],
    [ore('cableGtSingleTin'), metaitem('component.grinder.diamond'), ore('cableGtSingleTin')]
])

def overworld_ores = [
    item('minecraft:stone'),
    item('minecraft:cobblestone'), //Coblestone
    item('minecraft:stone', 1), //Granite
    item('pyrotech:cobblestone', 2), //Cobbled Granite
    item('minecraft:stone', 3), //Diorite
    item('pyrotech:cobblestone', 1), //Cobbled Diorite
    item('minecraft:stone', 5), //Andesite
    item('pyrotech:cobblestone'), //Cobbled Andesite
    item('susy:susy_stone_smooth'), //Gabbro
    item('susy:susy_stone_cobble'), //Gabbro Cobblestone
    item('susy:susy_stone_smooth', 2), //Limestone
    item('susy:susy_stone_cobble', 2), //Limestone Cobblestone
    item('susy:susy_stone_smooth', 5), //Shale
    item('susy:susy_stone_cobble', 5) //Shale Cobblestone
]
def beneath_ores = [
    item('susy:susy_stone_smooth', 1), //Gneiss
    item('susy:susy_stone_cobble', 1), //Gneiss Cobblestone
    item('susy:susy_stone_smooth', 3), //Phyllite
    item('susy:susy_stone_cobble', 3), //Phyllite Cobblestone
    item('susy:susy_stone_smooth', 6), //Slate
    item('susy:susy_stone_cobble', 6) //Slate Cobblestone
]

//overworld rocks:
for (entry in overworld_ores) {
    QUARRY.recipeBuilder()
        .notConsumable(entry)
        .outputs(entry)
        .dimension(Globals.dimensions["Overworld"])
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister();
}

QUARRY.recipeBuilder()
    .notConsumable(item('minecraft:sand'))
    .outputs(item('minecraft:sand'))
    .chancedOutput(item('gregtech:meta_dust', 2023), 1000, 500)
    .dimension(Globals.dimensions["Overworld"])
    .duration(200)
    .EUt(VA[MV])
    .buildAndRegister();

QUARRY.recipeBuilder()
    .notConsumable(ore('dustMica'))
    .chancedOutput(metaitem('dustMica'), 1000, 500)
    .dimension(Globals.dimensions["Beneath"])
    .duration(240)
    .EUt(VA[MV])
    .buildAndRegister();

QUARRY.recipeBuilder()
    .circuitMeta(1)
    .chancedOutput(item('minecraft:stone'), 1667, 500)
    .chancedOutput(item('minecraft:stone', 1), 1667, 500)
    .chancedOutput(item('minecraft:stone', 3), 1667, 500)
    .chancedOutput(item('minecraft:stone', 5), 1667, 500)
    .chancedOutput(item('susy:susy_stone_smooth', 0), 1667, 500)
    .chancedOutput(item('susy:susy_stone_smooth', 5), 1667, 500)
    .dimension(Globals.dimensions["Overworld"])
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister();

QUARRY.recipeBuilder()
    .circuitMeta(2)
    .chancedOutput(item('minecraft:cobblestone'), 1667, 500)
    .chancedOutput(item('pyrotech:cobblestone'), 1667, 500)
    .chancedOutput(item('pyrotech:cobblestone', 1), 1667, 500)
    .chancedOutput(item('pyrotech:cobblestone', 2), 1667, 500)
    .chancedOutput(item('susy:susy_stone_cobble', 0), 1667, 500)
    .chancedOutput(item('susy:susy_stone_cobble', 5), 1667, 500)
    .dimension(Globals.dimensions["Overworld"])
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister();

//beneath rocks:
for (entry in beneath_ores) {
    QUARRY.recipeBuilder()
        .notConsumable(entry)
        .outputs(entry)
        .dimension(Globals.dimensions["Beneath"])
        .duration(100)
        .EUt(VA[MV])
        .buildAndRegister();
}

QUARRY.recipeBuilder()
    .circuitMeta(3)
    .chancedOutput(item('susy:susy_stone_smooth', 1), 3333, 500)
    .chancedOutput(item('susy:susy_stone_smooth', 3), 3333, 500)
    .chancedOutput(item('susy:susy_stone_smooth', 6), 3333, 500)
    .dimension(Globals.dimensions["Beneath"])
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister();

QUARRY.recipeBuilder()
    .circuitMeta(4)
    .chancedOutput(item('susy:susy_stone_cobble', 1), 3333, 500)
    .chancedOutput(item('susy:susy_stone_cobble', 3), 3333, 500)
    .chancedOutput(item('susy:susy_stone_cobble', 6), 3333, 500)
    .dimension(Globals.dimensions["Beneath"])
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister();
