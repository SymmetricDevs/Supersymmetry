import static globals.Globals.*

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;

def PYROLYSE_OVEN = recipemap('pyrolyse_oven');
def DISTILLERY = recipemap('distillery');
def MIXER = recipemap('mixer');

def DISTILLATION_TOWER = recipemap('distillation_tower');
def AUTOCLAVE = recipemap('autoclave');
def FERMENTER = recipemap('vat_fermentation');

//GENERIC BIOMASS CHAIN
PYROLYSE_OVEN.recipeBuilder()
        .inputs(metaitem('bio_chaff') * 16)
        .fluidInputs(fluid('water') * 4000)
        .fluidOutputs(fluid('biomass') * 4000)
        .duration(320)
        .EUt(64)
        .buildAndRegister()

MIXER.recipeBuilder()
        .inputs(metaitem('bio_chaff') * 2)
        .fluidInputs(fluid('water') * 1000)
        .fluidOutputs(fluid('biomass') * 1000)
        .duration(80)
        .EUt(30)
        .buildAndRegister()

FERMENTER.recipeBuilder()
        .fluidInputs(fluid('biomass') * 16000)
        .fluidOutputs(fluid('fermented_biomass') * 16000)
        .fluidOutputs(fluid('methane') * 10000)
        .duration(2400)
        .EUt(16)
        .buildAndRegister()

//ETHANOL CHAIN

AUTOCLAVE.recipeBuilder()
        .inputs(item('minecraft:wheat_seeds') * 4)
        .fluidInputs(fluid('water') * 1000)
        .outputs(metaitem('malted_grain') * 4)
        .duration(200)
        .EUt(30)
        .buildAndRegister()

AUTOCLAVE.recipeBuilder()
        .inputs(metaitem('malted_grain') * 2)
        .inputs(metaitem('dustWheat') * 2)
        .fluidInputs(fluid('water') * 1000)
        .fluidOutputs(fluid('mash') * 1000)
        .duration(100)
        .EUt(30)
        .buildAndRegister()

MIXER.recipeBuilder()
        .inputs(metaitem('dustWheat') * 2)
        .fluidInputs(fluid('water') * 1000)
        .fluidOutputs(fluid('grain_solution') * 1000)
        .circuitMeta(3)
        .duration(100)
        .EUt(30)
        .buildAndRegister()

FERMENTER.recipeBuilder()
        .fluidInputs(fluid('grain_solution') * 16000)
        .fluidOutputs(fluid('yeast_solution') * 16000)
        .circuitMeta(1)
        .duration(2400)
        .EUt(16)
        .buildAndRegister()

FERMENTER.recipeBuilder()
        .fluidInputs(fluid('mash') * 16000)
        .fluidInputs(fluid('grain_solution') * 1000)
        .fluidOutputs(fluid('impure_ethanol') * 16000)
        .circuitMeta(2)
        .duration(2400)
        .EUt(16)
        .buildAndRegister()

FERMENTER.recipeBuilder()
        .inputs(item('minecraft:sugar') * 24)
        .fluidInputs(fluid('water') * 16000)
        .fluidInputs(fluid('grain_solution') * 1000)
        .fluidOutputs(fluid('impure_ethanol') * 16000)
        .circuitMeta(3)
        .duration(2400)
        .EUt(16)
        .buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
        .fluidInputs(fluid('impure_ethanol') * 2000)
        .outputs(metaitem('dustWood'))
        .fluidOutputs(fluid('ethanol') * 640)
        .fluidOutputs(fluid('water') * 1360)
        .duration(50)
        .EUt(30)
        .buildAndRegister()

//GTFO STUFF

FERMENTER.recipeBuilder()
        .fluidInputs(fluid('gtfo_red_grapes_must') * 16000)
        .fluidOutputs(fluid('gtfo_fermented_red_grapes_must') * 16000)
        .duration(2400)
        .EUt(16)
        .buildAndRegister()

DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('gtfo_alcoholic_red_grape_juice') * 1000)
        .fluidOutputs(fluid('gtfo_red_wine') * 800)
        .duration(100)
        .EUt(30)
        .buildAndRegister()