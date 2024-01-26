import globals.Globals

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;

def PYROLYSE_OVEN = recipemap('pyrolyse_oven');
def DISTILLATION_TOWER = recipemap('distillation_tower');
def CENTRIFUGE = recipemap('centrifuge');

PYROLYSE_OVEN.recipeBuilder()
        .inputs(ore('logWood') * 16)
        .outputs(item('minecraft:coal', 1) * 8)
        .fluidOutputs(fluid('unscrubbed_wood_gas') * 3000)
        .fluidOutputs(fluid('wood_vinegar') * 2000)
        .fluidOutputs(fluid('creosote') * 2000)
        .duration(320)
        .EUt(64)
        .buildAndRegister()

PYROLYSE_OVEN.recipeBuilder()
        .inputs(ore('dustWood') * 24)
        .outputs(metaitem('dustWoodAsh') * 20)
        .fluidOutputs(fluid('unscrubbed_wood_gas') * 3000)
        .duration(320)
        .EUt(64)
        .buildAndRegister()

PYROLYSE_OVEN.recipeBuilder()
        .inputs(ore('treeLeaves') * 24)
        .outputs(metaitem('dustWoodAsh') * 10)
        .duration(240)
        .EUt(64)
        .buildAndRegister()

PYROLYSE_OVEN.recipeBuilder()
        .fluidInputs(fluid('fermented_biomass') * 5000)
        .outputs(metaitem('dustDarkAsh') * 8)
        .fluidOutputs(fluid('unscrubbed_wood_gas') * 3000)
        .duration(320)
        .EUt(64)
        .buildAndRegister()

PYROLYSE_OVEN.recipeBuilder()
        .fluidInputs(fluid('biomass') * 3000)
        .outputs(metaitem('dustDarkAsh') * 8)
        .fluidOutputs(fluid('unscrubbed_wood_gas') * 3000)
        .duration(320)
        .EUt(64)
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('unscrubbed_wood_gas') * 1000)
        .fluidInputs(fluid('water') * 200)
        .fluidOutputs(fluid('creosote') * 50)
        .fluidOutputs(fluid('wood_gas') * 1000)
        .duration(160)
        .EUt(30)
        .buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
        .fluidInputs(fluid('wood_vinegar') * 1000)
        .fluidOutputs(fluid('acetic_acid') * 100)
        .fluidOutputs(fluid('water') * 700)
        .fluidOutputs(fluid('methanol') * 100)
        .fluidOutputs(fluid('acetone') * 100)
        .duration(200)
        .EUt(24)
        .buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
        .chancedOutput(metaitem('bitumen'), 5000, 0)
        .fluidInputs(fluid('creosote') * 1000)
        .fluidOutputs(fluid('creosol') * 400)
        .fluidOutputs(fluid('gtfo_guaiacol') * 250)
        .fluidOutputs(fluid('xylenol') * 50)
        .fluidOutputs(fluid('cresol') * 200)
        .fluidOutputs(fluid('phenol') * 100)
        .duration(200)
        .EUt(48)
        .buildAndRegister()