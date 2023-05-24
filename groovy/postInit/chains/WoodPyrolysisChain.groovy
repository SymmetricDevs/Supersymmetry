import static globals.Globals.*

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;

def PYROLYSE_OVEN = recipemap('pyrolyse_oven');
def DISTILLATION_TOWER = recipemap('distillation_tower');

PYROLYSE_OVEN.recipeBuilder()
        .inputs(ore('logWood') * 16)
        .outputs(item('minecraft:coal', 1) * 8)
        .fluidOutputs(fluid('syngas') * 3000)
        .fluidOutputs(fluid('wood_vinegar') * 2000)
        .fluidOutputs(fluid('creosote') * 2000)
        .duration(320)
        .EUt(64)
        .buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
        .fluidInputs(fluid('wood_vinegar') * 1000)
        .fluidOutputs(fluid('water') * 700)
        .fluidOutputs(fluid('acetic_acid') * 100)
        .fluidOutputs(fluid('acetone') * 100)
        .fluidOutputs(fluid('methanol') * 100)
        .duration(200)
        .EUt(24)
        .buildAndRegister()