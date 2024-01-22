import globals.Globals

import gregtech.api.recipes.recipeproperties.RecipeProperty;
import gregtech.api.recipes.RecipeBuilder;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.*

crafting.remove("gregtech:vacuum_tube")

// Vacuum Tube * 4
mods.gregtech.assembler.removeByInput(7, [metaitem('component.glass.tube'), metaitem('boltSteel') * 2, metaitem('wireGtSingleAnnealedCopper') * 2], [fluid('red_alloy') * 18])
// Vacuum Tube * 3
mods.gregtech.assembler.removeByInput(7, [metaitem('component.glass.tube'), metaitem('boltSteel') * 2, metaitem('wireGtSingleCopper') * 2], [fluid('red_alloy') * 18])
// Vacuum Tube * 2
mods.gregtech.assembler.removeByInput(7, [metaitem('component.glass.tube'), metaitem('boltSteel') * 2, metaitem('wireGtSingleCopper') * 2, metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)


crafting.addShaped("vacuum_tube_components", metaitem('vacuum_tube_components') * 4, [
    [null, metaitem('wireFineRedAlloy'), null],
    [metaitem('wireGtSingleCopper'), metaitem('ringSteel'), metaitem('wireGtSingleCopper')],
    [null, metaitem('boltSteel'), null]
])

crafting.addShaped("vacuum_tube_components_annealed", metaitem('vacuum_tube_components') * 6, [
    [null, metaitem('wireFineRedAlloy'), null],
    [metaitem('wireGtSingleAnnealedCopper'), metaitem('ringSteel'), metaitem('wireGtSingleAnnealedCopper')],
    [null, metaitem('boltSteel'), null]
])

def ASSEMBLER_RECIPES = recipemap('assembler')
def VACUUM_RECIPES = recipemap('vacuum_chamber')

VACUUM_RECIPES.recipeBuilder()
.inputs(metaitem('component.glass.tube'))
.inputs(metaitem('vacuum_tube_components'))
.inputs(ore('ringSteel'))
.outputs(metaitem('circuit.vacuum_tube'))
.EUt(7)
.duration(200)
.buildAndRegister()