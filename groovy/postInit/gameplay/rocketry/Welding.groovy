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

MIXER_RECIPES.recipeBuilder()
    .inputs(ore('dustTungsten')*11)
    .inputs(ore('dustTinyThoriumDioxide')*2)
    .outputs(ore('dustThoriatedTungsten')*12) // intended to avoid flooding storages
    .EUt(1920)
    .duration(20)
    .buildAndRegister()

ISOSTATIC_PRESS.recipeBuilder()
    .notConsumable(metaitem('shape.mold.rod'))
    .inputs(ore('dustThoriatedTungsten')*2)
    .outputs(metaitem('susy:tig_welding_electrode'))
    .EUt(1920) // because tungsten requires lots of heat
    .duration(180)
    .buildAndRegister()


