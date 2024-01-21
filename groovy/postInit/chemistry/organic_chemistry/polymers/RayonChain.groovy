import globals.Globals

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;

def POLYMERIZATION = recipemap('polymerization_tank');
def CHEMICAL_BATH = recipemap('chemical_bath');
def COMPRESSOR = recipemap('compressor');
def LCR = recipemap('large_chemical_reactor')
def MIXER = recipemap('mixer')

CHEMICAL_BATH.recipeBuilder()
        .inputs(ore('dustCellulose') * 4)
        .fluidInputs(fluid('manganese_ii_sulfate_solution') * 50)
        .fluidInputs(fluid('sodium_hydroxide_solution') * 3000)
        .fluidOutputs(fluid('wastewater') * 2000)
        .outputs(metaitem('dustAlkaliCellulose') * 4)
        .duration(200)
        .EUt(240)
        .buildAndRegister()

LCR.recipeBuilder()
        .fluidInputs(fluid('carbon_disulfide') * 1000)
        .inputs(ore('dustAlkaliCellulose'))
        .outputs(metaitem('dustSodiumCelluloseXanthate'))
        .duration(200)
        .EUt(240)
        .buildAndRegister()

MIXER.recipeBuilder()
        .inputs(ore('dustSodiumCelluloseXanthate'))
        .fluidInputs(fluid('sodium_hydroxide_solution') * 1000)
        .fluidOutputs(fluid('sodium_cellulose_xanthate_solution') * 1000)
        .duration(200)
        .EUt(240)
        .buildAndRegister()

CHEMICAL_BATH.recipeBuilder()
        .notConsumable(metaitem('spinneret'))
        .fluidInputs(fluid('sodium_cellulose_xanthate_solution') * 2000)
        .fluidInputs(fluid('diluted_sulfuric_acid') * 3000)
        .fluidInputs(fluid('air') * 1000)
        .fluidOutputs(fluid('carbon_disulfide') * 2000)
        .fluidOutputs(fluid('sodium_sulfate_solution') * 1500)
        .fluidOutputs(fluid('wastewater') * 500)
        .outputs(metaitem('fiberWetRayon') * 8)
        .duration(200)
        .EUt(240)
        .buildAndRegister()

COMPRESSOR.recipeBuilder()
        .inputs(ore('threadRayon') * 8)
        .outputs(item('minecraft:wool'))
        .duration(100)
        .EUt(30)
        .buildAndRegister()