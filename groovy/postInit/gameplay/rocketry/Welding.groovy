import globals.Globals

import gregtech.api.recipes.recipeproperties.RecipeProperty;
import gregtech.api.recipes.RecipeBuilder;
import static gregtech.api.recipes.RecipeMaps.*;
import gregtech.api.unification.material.Materials.*;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;

MIXER.recipeBuilder()
    .inputs(ore('dustTungsten') * 11)
    .inputs(ore('dustTinyThoriumDioxide') * 2)
    .inputs(ore('dustTinyRhenium'))
    .outputs(ore('dustThoriatedTungstenMixture') * 12)
    .EUt(1920)
    .duration(20)
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .inputs(ore('dustThoriatedTungstenMixture') * 2)
    .inputs(fluid('hydrogen') * 16000)
    .outputs('dustThoriatedTungsten' * 2)
    .EUt(1920)
    .duration(80)
    .buildAndRegister()

ISOSTATIC_PRESS.recipeBuilder()
    .notConsumable(metaitem('shape.mold.ingot'))
    .inputs(ore('dustThoriatedTungsten'))
    .outputs(ore('ingotThoriatedTungsten'))
    .EUt(1920)
    .duration(15)
    .buildAndRegister()

SINTERING_OVEN.recipeBuilder() // represents DC sintering and rotary forging
    .notConsumable('shape.mold.rod')
    .inputs(ore('ingotThoriatedTungsten'))
    .outputs(ore('rodThoriatedTungsten'))
    .EUt(1920)
    .duration(50)
    .buildAndRegister()

ELECTROLYZER.recipeBuilder() // electroplating
    .notConsumable('rodStainlessSteel')
    .inputs(ore('rodThoriatedTungsten'))
    .inputs(fluid('diluted_sodium_hydroxide_solution') * 1000)
    .outputs(item('susy.tig_electrode'))
    .EUt(30)
    .duration(10)
    .buildAndRegister()

