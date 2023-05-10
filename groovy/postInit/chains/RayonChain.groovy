import static globals.Globals.*

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;

def POLYMERIZATION = recipemap('polymerization_tank');
def CHEMICAL_BATH = recipemap('chemical_bath');
def COMPRESSOR = recipemap('compressor');

CHEMICAL_BATH.recipeBuilder()
        .fluidInputs(fluid('sodium_hydroxide_solution') * 3000)
        .inputs(metaitem('dustWood') * 4)
        .fluidOutputs(fluid('water') * 2000)
        .outputs(metaitem('dustAlkaliCellulose') * 4)
        .duration(200)
        .EUt(240)
        .buildAndRegister()

CHEMICAL_BATH.recipeBuilder()
        .fluidInputs(fluid('carbon_disulfide') * 1000)
        .inputs(metaitem('dustAlkaliCellulose') * 4)
        .outputs(metaitem('dustSodiumCelluloseXanthate') * 4)
        .duration(200)
        .EUt(240)
        .buildAndRegister()

POLYMERIZATION.recipeBuilder()
        .fluidInputs(fluid('sulfuric_acid') * 1000)
        .inputs(metaitem('dustSodiumCelluloseXanthate') * 8)
        .notConsumable(metaitem('shape.extruder.rod'))
        .fluidOutputs(fluid('carbon_disulfide') * 2000)
        .outputs(metaitem('wireFineRayon') * 8)
        .duration(200)
        .EUt(240)
        .buildAndRegister()

POLYMERIZATION.recipeBuilder()
        .inputs(metaitem('wireFineRayon') * 8)
        .outputs(item('minecraft:wool'))
        .duration(100)
        .EUt(30)
        .buildAndRegister()