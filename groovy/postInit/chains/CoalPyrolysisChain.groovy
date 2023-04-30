import static globals.Globals.*

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;

def PYROLYSE_OVEN = recipemap('pyrolyse_oven');
def DISTILLATION_TOWER = recipemap('distillation_tower');
def CENTRIFUGE = recipemap('centrifuge');

//TODO: UNCOMMENT WHEN SUSYCORE 0.0.8 IS OUT
/*
PYROLYSE_OVEN.recipeBuilder()
        .inputs(item('minecraft:coal', 1) * 16)
        .outputs(metaitem('gemCoke') * 12)
        .fluidOutputs(fluid('coal_gas') * 2500)
        .fluidOutputs(fluid('coal_tar') * 2500)
        .duration(320)
        .EUt(64)
        .buildAndRegister()

PYROLYSE_OVEN.recipeBuilder()
        .inputs(item('minecraft:coal') * 16)
        .outputs(metaitem('gemCoke') * 12)
        .fluidOutputs(fluid('coal_gas') * 2500)
        .fluidOutputs(fluid('coal_tar') * 2500)
        .duration(320)
        .EUt(64)
        .buildAndRegister()
        
PYROLYSE_OVEN.recipeBuilder()
        .inputs(metaitem('gemAnthracite')) * 16)
        .outputs(metaitem('gemCoke') * 14)
        .fluidOutputs(fluid('coal_gas') * 3200)
        .fluidOutputs(fluid('coal_tar') * 3200)
        .duration(320)
        .EUt(64)
        .buildAndRegister()

PYROLYSE_OVEN.recipeBuilder()
        .inputs(metaitem('gemCoke') * 16)
        .outputs(metaitem('dustCarbon') * 12)
        .fluidInputs(fluid('air') * 15000)
        .fluidOutputs(fluid('syngas') * 12000)
        .duration(320)
        .EUt(64)
        .buildAndRegister()

PYROLYSE_OVEN.recipeBuilder()
        .inputs(metaitem('gemCoke') * 16)
        .outputs(metaitem('dustCarbon') * 12)
        .fluidInputs(fluid('oxygen') * 8000)
        .fluidOutputs(fluid('syngas') * 12000)
        .duration(320)
        .EUt(64)
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('coal_gas') * 10000)
        .fluidInputs(fluid('water') * 1000)
        .fluidOutputs(fluid('syngas') * 10000)
        .fluidOutputs(fluid('ammonia_solution') * 1000)
        .duration(120)
        .EUt(30)
        .buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
        .fluidInputs(fluid('ammonia_solution') * 1000)
        .fluidOutputs(fluid('ammonia') * 1000)
        .fluidOutputs(fluid('water') * 1000)
        .duration(100)
        .EUt(30)
        .buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
        .fluidInputs(fluid('coal_tar') * 1000)
        .outputs(metaitem('bitumen'))
        .fluidOutputs(fluid('benzene') * 160)
        .fluidOutputs(fluid('toluene') * 140)
        .fluidOutputs(fluid('ethylbenzene') * 160)
        .fluidOutputs(fluid('xylene') * 140)
        .fluidOutputs(fluid('creosote') * 320)
        .fluidOutputs(fluid('naphthalene') * 60)
        .fluidOutputs(fluid('anthracene') * 20)
        .duration(320)
        .EUt(48)
        .buildAndRegister()

 */
