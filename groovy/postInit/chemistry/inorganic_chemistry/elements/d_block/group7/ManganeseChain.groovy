import gregtech.api.unification.material.properties.*;
import gregtech.api.GregTechAPI;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.ore.OrePrefix;

import static gregtech.api.unification.material.Materials.*;
import globals.Globals
import static globals.CarbonGlobals.*

EBF = recipemap('electric_blast_furnace')
ROASTER = recipemap('roaster')
BATCH_REACTOR = recipemap('batch_reactor')
REACTION_FURNACE = recipemap('reaction_furnace')
ELECTROLYTIC_CELL = recipemap('electrolytic_cell')

//PYROMETALLUGRICAL METHODS (75%)

for (combustible in CarbonGlobals.combustibles()) {
    EBF.recipeBuilder()
        .inputs(ore('dustPyrolusite'))
        .inputs(ore(combustible.name) * combustible.equivalent(2))
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

for (highPurityCombustible in CarbonGlobals.highPurityCombustibles()) {
    ROASTER.recipeBuilder()
        .inputs(ore('dustManganeseIiOxide') * 2)
        .inputs(ore(highPurityCombustible.name) * highPurityCombustible.equivalent(1))
        .chancedOutput(metaitem('dustManganese'), 8500, 0)
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
    .fluidInputs(fluid('sulfuric_acid') * 1000)
    .fluidOutputs(fluid('crude_manganese_ii_sulfate_solution') * 1000)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

BATCH_REACTOR.recipeBuilder()
    .inputs(ore('dustTinySodiumHydroxide') * 2)
    .fluidInputs(fluid('crude_manganese_ii_sulfate_solution') * 4000)
    .chancedOutput(metaitem('dustIronIiiHydroxide') * 7, 500, 0)
    .fluidOutputs(fluid('manganese_ii_sulfate_solution') * 4000)
    .duration(200)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

ELECTROLYTIC_CELL.recipeBuilder()
    .fluidInputs(fluid('manganese_ii_sulfate_solution') * 1000)
    .notConsumable(metaitem('stickManganese'))
    .notConsumable(metaitem('graphite_electrode'))
    .outputs(metaitem('dustManganese'))
    .fluidOutputs(fluid('sulfuric_acid') * 1000)
    .duration(480)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

// MnCl2

BR.recipeBuilder()
    .inputs(ore('dustAnyPurityManganese'))
    .fluidInputs(fluid('chlorine') * 2000)
    .outputs(metaitem('dustManganeseIiChloride') * 3)
    .duration(100)
    .EUt(120)
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustManganeseIiOxide') * 2)
    .fluidInputs(fluid('hydrochloric_acid') * 2000)
    .fluidOutputs(fluid('manganese_ii_chloride_solution') * 3000)
    .duration(100)
    .EUt(120)
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('manganese_ii_chloride_solution') * 3000)
    .outputs(metaitem('dustManganeseIiChloride') * 3)
    .fluidOutputs(fluid('water') * 3000)
    .duration(20)
    .EUt(30)
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustManganeseDioxide') * 3)
    .fluidInputs(fluid('hydrochloric_acid') * 4000)
    .fluidOutputs(fluid('diluted_manganese_ii_chloride_solution') * 6000)
    .fluidOutputs(fluid('chlorine') * 2000)
    .duration(100)
    .EUt(120)
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('diluted_manganese_ii_chloride_solution') * 3000)
    .outputs(metaitem('dustManganeseIiChloride') * 3)
    .fluidOutputs(fluid('water') * 6000)
    .duration(20)
    .EUt(30)
    .buildAndRegister()

// MnO2

BR.recipeBuilder()
    .inputs(ore('dustPyrolusite') * 3)
    .fluidInputs(fluid('nitrogen_dioxide') * 2000)
    .outputs(metaitem('dustManganeseIiNitrate') * 9)
    .duration(100)
    .EUt(120)
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustManganeseIiNitrate') * 9)
    .fluidOutputs(fluid('nitrogen_dioxide') * 2000)
    .outputs(metaitem('dustManganeseDioxide') * 3)
    .duration(100)
    .EUt(120)
    .buildAndRegister()

// Manganese hydroxide calcination

ROASTER.recipeBuilder()
    .inputs(ore('dustManganeseIiHydroxide') * 5)
    .fluidOutputs(fluid('steam') * 1000)
    .outputs(metaitem('dustManganeseIiOxide') * 2)
    .duration(200)
    .EUt(30)
    .buildAndRegister()