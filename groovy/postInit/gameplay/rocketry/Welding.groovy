import globals.Globals

import gregtech.api.recipes.recipeproperties.RecipeProperty;
import gregtech.api.recipes.RecipeBuilder;
import static gregtech.api.recipes.RecipeMaps.*;
import gregtech.api.unification.material.Materials.*;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;

ISOSTATIC_PRESS = recipemap('hot_isostatic_press')
REDUCTION_FURNACE = recipemap('reduction_furnace')
MIXER = recipemap('mixer')
LATHE = recipemap('lathe')

SINTERING_OVEN = recipemap('sintering_oven')

MIXER.recipeBuilder()
    .inputs(ore('dustTungsten')*11)
    .inputs(ore('dustTinyThoriumDioxide')*2)
    .inputs(ore('dustTinyRhenium'))
    .outputs(ore('dustUnprocessedThoriatedTungsten')*12)
    .EUt(1920)
    .duration(20)
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .inputs(ore('dustUnprocessedThoriatedTungsten') * 2)
    .inputs(fluid('hydrogen') * 24000)
    .outputs('dustUnsinteredThoriatedTungsten' * 2)
    .EUt(1920)
    .duration(80)
    .buildAndRegister()

ISOSTATIC_PRESS.recipeBuilder()
    .notConsumable(metaitem('shape.mold.ingot'))
    .inputs(ore('dustUnsinteredThoriatedTungsten')*2)
    .outputs(ore('ingotUnsinteredThoriatedTungsten')*2)
    .EUt(1920)
    .duration(30)
    .buildAndRegister()

SINTERING_OVEN.recipeBuilder()
    .inputs(ore('ingotUnsinteredThoriatedTungsten'))
    .outputs(ore('ingotThoriatedTungsten'))
    .EUt(1920)
    .duration(50)
    .buildAndRegister()

LATHE.recipeBuilder()
    .inputs(ore('ingotThoriatedTungsten'))
    .outputs(metaitem('tig_tungsten_electrode'))
    .EUt(1920)
    .duration(10)
    .buildAndRegister()

