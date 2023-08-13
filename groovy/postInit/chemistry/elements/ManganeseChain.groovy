import gregtech.api.unification.material.properties.*;
import gregtech.api.GregTechAPI;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.ore.OrePrefix;

import static gregtech.api.unification.material.Materials.*;
import static globals.Globals.*

EBF = recipemap('electric_blast_furnace')
ROASTER = recipemap('roaster')
BATCH_REACTOR = recipemap('batch_reactor')
REACTION_FURNACE = recipemap('reaction_furnace')
ELECTROLYTIC_CELL = recipemap('electrolytic_cell')

//PYROMETALLUGRICAL METHODS (75%)

for (combustible in Globals.combustibles) {
    EBF.recipeBuilder()
        .inputs(ore('dustPyrolusite'))
        .inputs(ore(combustible.name) * combustible.amount_required * 2)
        .inputs(ore('dustTinyCalcite'))
        .chancedOutput(metaitem('dustManganese'), 7500, 0)
        .fluidOutputs(fluid('carbon_dioxide') * 1000)
        .blastFurnaceTemp(1200)
        .duration(120)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()
}

ROASTER.recipeBuilder()
    .inputs(ore('dustRhodochrosite'))
    .outputs(metaitem('dustManganeseIiOxide') * 2)
    .fluidOutputs(fluid('carbon_dioxide') * 1000)
    .duration(120)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

for (highPurityCombustible in Globals.highPurityCombustibles) {
    ROASTER.recipeBuilder()
        .inputs(ore('dustManganeseIiOxide') * 2)
        .inputs(ore(highPurityCombustible.name) * 1)
        .chancedOutput(metaitem('dustManganese'), 7500, 0)
        .chancedOutput(metaitem(highPurityCombustible.byproduct), 1000, 0)
        .fluidOutputs(fluid('carbon_monoxide') * 1000)
        .duration(120 * highPurityCombustible.duration)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()
}

//PARTIAL REDUCTION OF PYROLUSITE FOR SULFURIC ACID LEACH
class Reductant {
    String name
    String byproduct
    int amount_required
    int byproduct_amount

    Reductant(name, byproduct, amount_required, byproduct_amount) {
        this.name = name
        this.byproduct = byproduct
        this.amount_required = amount_required
        this.byproduct_amount = byproduct_amount
    }
}

def hydrocarbonReductants = [
    new Reductant('fuel_oil', 'carbon_dioxide', 67, 288),
    new Reductant('natural_gas', 'carbon_dioxide', 167, 234)
]

def reductants = [
    new Reductant('carbon_monoxide', 'carbon_dioxide', 1000, 1000),
    new Reductant('hydrogen', 'steam', 2000, 1000)
]

/*
FUEL OIL: 11.4 mol H, 4.6 mol C, 29.8 mol e-
NATURAL GAS: 5.4 mol H, 1.65 mol C, 12 mol e-
*/

for (reductant in hydrocarbonReductants) {
    REACTION_FURNACE.recipeBuilder()
        .inputs(ore('dustPyrolusite'))
        .fluidInputs(fluid(reductant.name) * reductant.amount_required)
        .outputs(metaitem('dustManganeseIiOxide') * 2)
        .fluidOutputs(fluid(reductant.byproduct) * reductant.byproduct_amount)
        .fluidOutputs(fluid('steam') * (1000 - reductant.byproduct_amount))
        .duration(120)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()
}

for (reductant in reductants) {
    REACTION_FURNACE.recipeBuilder()
        .inputs(ore('dustPyrolusite'))
        .fluidInputs(fluid(reductant.name) * reductant.amount_required)
        .outputs(metaitem('dustManganeseIiOxide') * 2)
        .fluidOutputs(fluid(reductant.byproduct) * reductant.byproduct_amount)
        .duration(120)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()
}

//HYDROMETALLURGICAL MANGANESE PROCESSING
BATCH_REACTOR.recipeBuilder()
    .inputs(ore('dustManganeseIiOxide'))
    .fluidInputs(fluid('sulfuric_acid') * 1375)
    .fluidOutputs(fluid('crude_manganese_ii_sulfate_solution') * 1000)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

BATCH_REACTOR.recipeBuilder()
    .inputs(ore('dustSodiumHydroxide') * 3)
    .fluidInputs(fluid('crude_manganese_ii_sulfate_solution') * 4000)
    .outputs(metaitem('dustIronIiiHydroxide'))
    .fluidOutputs(fluid('manganese_ii_sulfate_solution') * 4000)
    .duration(200)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

ELECTROLYTIC_CELL.recipeBuilder()
    .fluidInputs(fluid('manganese_ii_sulfate_solution') * 1000)
    .notConsumable(metaitem('stickManganese'))
    .notConsumable(metaitem('graphite_electrode'))
    .outputs(metaitem('dustManganese'))
    .fluidOutputs(fluid('sodium_sulfate_solution') * 375)
    .fluidOutputs(fluid('sulfuric_acid') * 1000)
    .duration(480)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()






    
    