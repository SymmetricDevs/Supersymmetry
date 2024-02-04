import globals.Globals

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
        .inputs(ore('dustWheat') * 2)
        .fluidInputs(fluid('water') * 1000)
        .fluidOutputs(fluid('mash') * 2000)
        .duration(100)
        .EUt(30)
        .buildAndRegister()

AUTOCLAVE.recipeBuilder()
        .inputs(metaitem('malted_grain') * 2)
        .circuitMeta(1)
        .fluidInputs(fluid('water') * 1000)
        .fluidOutputs(fluid('mash') * 1000)
        .duration(100)
        .EUt(30)
        .buildAndRegister()

MIXER.recipeBuilder()
        .inputs(ore('dustWheat') * 2)
        .fluidInputs(fluid('water') * 1000)
        .fluidOutputs(fluid('grain_solution') * 1000)
        .circuitMeta(4)
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
        .fluidOutputs(fluid('fusel_oil') * 20)
        .fluidOutputs(fluid('water') * 1280)
        .fluidOutputs(fluid('ethanol_water_azeotrope') * 700)
        .duration(50)
        .EUt(30)
        .buildAndRegister()

//EXTRACTIVE DISTILLATION
MIXER.recipeBuilder()
        .fluidInputs(fluid('ethanol_water_azeotrope') * 700)
        .fluidInputs(fluid('toluene') * 10)
        .fluidOutputs(fluid('entrained_ethanol_water_azeotrope') * 710)
        .duration(50)
        .EUt(30)
        .buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
        .fluidInputs(fluid('entrained_ethanol_water_azeotrope') * 710)
        .fluidOutputs(fluid('toluene') * 10)
        .fluidOutputs(fluid('water') * 70)
        .fluidOutputs(fluid('ethanol') * 630)
        .duration(50)
        .EUt(30)
        .buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
        .fluidInputs(fluid('fusel_oil') * 1000)
        .fluidOutputs(fluid('isoamyl_alcohol') * 615)
        .fluidOutputs(fluid('n_butanol') * 10)
        .fluidOutputs(fluid('isobutyl_alcohol') * 155)
        .fluidOutputs(fluid('water') * 110)
        .fluidOutputs(fluid('n_propanol') * 10)
        .fluidOutputs(fluid('ethanol_water_azeotrope') * 100)
        .duration(50)
        .EUt(30)
        .buildAndRegister()

FERMENTER.recipeBuilder()
        .fluidInputs(fluid('ethanol') * 8000)
        .fluidInputs(fluid('oxygen') * 4000)
        .fluidOutputs(fluid('vinegar') * 16000)
        .duration(2400)
        .EUt(16)
        .buildAndRegister()

FERMENTER.recipeBuilder()
        .fluidInputs(fluid('ethanol') * 8000)
        .fluidInputs(fluid('air') * 12000)
        .fluidOutputs(fluid('vinegar') * 16000)
        .duration(2400)
        .EUt(16)
        .buildAndRegister()

FERMENTER.recipeBuilder()
        .fluidInputs(fluid('impure_ethanol') * 16000)
        .fluidInputs(fluid('oxygen') * 4000)
        .fluidOutputs(fluid('vinegar') * 16000)
        .duration(2400)
        .EUt(16)
        .buildAndRegister()

FERMENTER.recipeBuilder()
        .fluidInputs(fluid('impure_ethanol') * 16000)
        .fluidInputs(fluid('air') * 12000)
        .fluidOutputs(fluid('vinegar') * 16000)
        .duration(2400)
        .EUt(16)
        .buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
        .fluidInputs(fluid('vinegar') * 2000)
        .outputs(metaitem('dustWood'))
        .fluidOutputs(fluid('acetic_acid') * 400)
        .fluidOutputs(fluid('water') * 1600)
        .duration(200)
        .EUt(30)
        .buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
        .fluidInputs(fluid('gtfo_apple_cider') * 2000)
        .fluidOutputs(fluid('acetic_acid') * 400)
        .fluidOutputs(fluid('water') * 1600)
        .duration(200)
        .EUt(30)
        .buildAndRegister()