import static globals.Globals.*

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;

def PYROLYSE_OVEN = recipemap('pyrolyse_oven');
def DISTILLATION_TOWER = recipemap('distillation_tower');
def CENTRIFUGE = recipemap('centrifuge');
def MIXER = recipemap('mixer');
def CSTR = recipemap('continuous_stirred_tank_reactor');
def DISTILLERY = recipemap('distillery');

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
        .inputs(metaitem('gemAnthracite') * 16)
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
        .chancedOutput(metaitem('bitumen'), 5000, 0)
        .fluidInputs(fluid('coal_tar') * 1000)
        .fluidOutputs(fluid('light_oil') * 350)
        .fluidOutputs(fluid('creosote') * 450)
        .fluidOutputs(fluid('naphthalene_oil') * 100)
        .fluidOutputs(fluid('anthracene_oil') * 100)
        .duration(200)
        .EUt(48)
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('naphthalene_oil') * 1000)
        .fluidInputs(fluid('sodium_hydroxide_solution') * 100)
        .fluidOutputs(fluid('creosote') * 100)
        .fluidOutputs(fluid('alkaline_naphthalene_oil') * 1000)
        .duration(120)
        .EUt(30)
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('alkaline_naphthalene_oil') * 1000)
        .fluidInputs(fluid('sulfuric_acid') * 100)
        .fluidOutputs(fluid('sodium_sulfate_solution') * 100)
        .fluidOutputs(fluid('purified_naphthalene_oil') * 1000)
        .duration(120)
        .EUt(30)
        .buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
        .fluidInputs(fluid('purified_naphthalene_oil') * 1000)
        .fluidOutputs(fluid('naphthalene') * 800)
        .fluidOutputs(fluid('light_oil') * 100)
        .fluidOutputs(fluid('anthracene_oil') * 100)
        .duration(200)
        .EUt(48)
        .buildAndRegister()

MIXER.recipeBuilder()
        .fluidInputs(fluid('light_oil') * 1000)
        .fluidInputs(fluid('sulfuric_acid') * 100)
        .fluidOutputs(fluid('acidic_light_oil') * 1000)
        .duration(120)
        .EUt(30)
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('acidic_light_oil') * 1000)
        .fluidInputs(fluid('furfural') * 75)
        .fluidOutputs(fluid('btex_extract') * 750)
        .fluidOutputs(fluid('crude_pyridinium_sulfate') * 250)
        .duration(120)
        .EUt(30)
        .buildAndRegister()

CSTR.recipeBuilder()
        .fluidInputs(fluid('crude_pyridinium_sulfate') * 50)
        .fluidInputs(fluid('ammonia') * 100)
        .fluidOutputs(fluid('impure_pyridine') * 50)
        .duration(1)
        .EUt(30)
        .buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
        .fluidInputs(fluid('impure_pyridine') * 1000)
        .outputs(metaitem('dustAmmoniumSulfate') * 15)
        .fluidOutputs(fluid('pyridine') * 750)
        .fluidOutputs(fluid('gtfo_aniline') * 250)
        .duration(200)
        .EUt(48)
        .buildAndRegister()

MIXER.recipeBuilder()
        .fluidInputs(fluid('anthracene_oil') * 1000)
        .fluidInputs(fluid('sulfuric_acid') * 100)
        .fluidOutputs(fluid('acidic_anthracene_oil') * 1000)
        .duration(120)
        .EUt(30)
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('acidic_anthracene_oil') * 1000)
        .fluidInputs(fluid('ethylene_glycol') * 75)
        .fluidOutputs(fluid('anthracene_extract') * 750)
        .fluidOutputs(fluid('crude_quinolinium_sulfate') * 250)
        .duration(120)
        .EUt(30)
        .buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
        .fluidInputs(fluid('anthracene_extract') * 1000)
        .fluidOutputs(fluid('ethylene_glycol') * 100)
        .fluidOutputs(fluid('anthracene') * 800)
        .fluidOutputs(fluid('light_oil') * 200)
        .duration(200)
        .EUt(48)
        .buildAndRegister()

CSTR.recipeBuilder()
        .fluidInputs(fluid('crude_quinolinium_sulfate') * 50)
        .fluidInputs(fluid('ammonia') * 100)
        .fluidOutputs(fluid('impure_quinoline') * 50)
        .duration(1)
        .EUt(30)
        .buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
        .fluidInputs(fluid('impure_quinoline') * 1000)
        .outputs(metaitem('dustAmmoniumSulfate') * 15)
        .fluidOutputs(fluid('quinoline') * 800)
        .fluidOutputs(fluid('naphthalene_oil') * 200)
        .duration(200)
        .EUt(48)
        .buildAndRegister()