import static prePostInit.Recipemaps.*
import globals.Carbons

import static gregtech.api.GTValues.*
import gregtech.api.unification.material.properties.*
import gregtech.api.GregTechAPI
import gregtech.api.unification.material.Material
import gregtech.api.unification.OreDictUnifier
import gregtech.api.unification.ore.OrePrefix
import static gregtech.api.unification.material.Materials.*

//PYROMETALLUGRICAL METHODS (75%)

for (combustible in Carbons.combustibles()) {
    ERF.recipeBuilder()
        .inputs(ore('dustPyrolusite'))
        .inputs(ore(combustible.name) * combustible.equivalent(2))
        .inputs(ore('dustTinyCalcite'))
        .chancedOutput(metaitem('dustManganese'), 7500, 0)
        .fluidOutputs(fluid('carbon_dioxide') * 1000)
        .blastFurnaceTemp(1200)
        .duration(120)
        .EUt(VA[MV])
        .buildAndRegister()
}

ROASTER.recipeBuilder()
    .inputs(ore('dustRhodochrosite'))
    .outputs(metaitem('dustManganeseIiOxide') * 2)
    .fluidOutputs(fluid('carbon_dioxide') * 1000)
    .duration(120)
    .EUt(VA[LV])
    .buildAndRegister()

for (highPurityCombustible in Carbons.highPurityCombustibles()) {
    ROASTER.recipeBuilder()
        .inputs(ore('dustCrudeManganeseIiOxide') * 2)
        .inputs(ore(highPurityCombustible.name) * highPurityCombustible.equivalent(1))
        .chancedOutput(metaitem('dustManganese'), 8500, 0)
        .chancedOutput(metaitem(highPurityCombustible.byproduct), 1000, 0)
        .fluidOutputs(fluid('carbon_monoxide') * 1000)
        .duration(120 * highPurityCombustible.duration)
        .EUt(VA[LV])
        .buildAndRegister()
}

//PARTIAL REDUCTION OF PYROLUSITE FOR SULFURIC ACID LEACH
// Should replace inner classes with closures if possible
record ReductantManganese(
    String name,
    String byproduct,
    int amount_required,
    int byproduct_amount) {}

def hydrocarbonReductants = [
    new ReductantManganese('heavy_gas_oil', 'carbon_dioxide', 67, 288),
    new ReductantManganese('natural_gas', 'carbon_dioxide', 167, 234)
]

def reductants = [
    new ReductantManganese('carbon_monoxide', 'carbon_dioxide', 1000, 1000),
    new ReductantManganese('hydrogen', 'dense_steam', 2000, 1000)
]

/*
FUEL OIL: 11.4 mol H, 4.6 mol C, 29.8 mol e-
NATURAL GAS: 5.4 mol H, 1.65 mol C, 12 mol e-
*/

for (reductant in hydrocarbonReductants) {
    REACTION_FURNACE.recipeBuilder()
        .inputs(ore('dustPyrolusite'))
        .fluidInputs(fluid(reductant.name) * reductant.amount_required)
        .outputs(metaitem('dustCrudeManganeseIiOxide') * 2)
        .fluidOutputs(fluid(reductant.byproduct) * reductant.byproduct_amount)
        .fluidOutputs(fluid('dense_steam') * (1000 - reductant.byproduct_amount))
        .duration(120)
        .EUt(VA[HV])
        .buildAndRegister()
}

for (reductant in reductants) {
    REACTION_FURNACE.recipeBuilder()
        .inputs(ore('dustPyrolusite'))
        .fluidInputs(fluid(reductant.name) * reductant.amount_required)
        .outputs(metaitem('dustCrudeManganeseIiOxide') * 2)
        .fluidOutputs(fluid(reductant.byproduct) * reductant.byproduct_amount)
        .duration(120)
        .EUt(VA[HV])
        .buildAndRegister()
}

//HYDROMETALLURGICAL MANGANESE PROCESSING
BR.recipeBuilder()
    .inputs(ore('dustCrudeManganeseIiOxide') * 2)
    .fluidInputs(fluid('sulfuric_acid') * 1000)
    .fluidOutputs(fluid('crude_manganese_ii_sulfate_solution') * 1000)
    .duration(120)
    .EUt(VA[MV])
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustTinySodiumHydroxide') * 2)
    .fluidInputs(fluid('crude_manganese_ii_sulfate_solution') * 4000)
    .chancedOutput(metaitem('dustIronIiiHydroxide') * 7, 500, 0)
    .fluidOutputs(fluid('manganese_ii_sulfate_solution') * 4000)
    .duration(200)
    .EUt(VA[MV])
    .buildAndRegister()

ELECTROLYTIC_CELL.recipeBuilder()
    .fluidInputs(fluid('manganese_ii_sulfate_solution') * 1000)
    .notConsumable(metaitem('stickManganese'))
    .notConsumable(metaitem('graphite_electrode'))
    .outputs(metaitem('dustManganese'))
    .fluidOutputs(fluid('sulfuric_acid') * 1000)
    .duration(480)
    .EUt(VA[MV])
    .buildAndRegister()

// MnSO4

BR.recipeBuilder()
    .inputs(ore('dustManganeseIiOxide') * 2)
    .fluidInputs(fluid('sulfuric_acid') * 1000)
    .fluidOutputs(fluid('manganese_ii_sulfate_solution') * 1000)
    .duration(80)
    .EUt(VA[LV])
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('manganese_ii_sulfate_solution') * 1000)
    .fluidOutputs(fluid('water') * 1000)
    .outputs(metaitem('dustManganeseIiSulfate') * 6)
    .duration(80)
    .EUt(VA[LV])
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustManganeseIiSulfate') * 6)
    .fluidInputs(fluid('water') * 1000)
    .fluidOutputs(fluid('manganese_ii_sulfate_solution') * 1000)
    .duration(80)
    .EUt(VA[LV])
    .buildAndRegister()

// MnCl2

BR.recipeBuilder()
    .inputs(ore('dustManganeseIiOxide') * 2)
    .fluidInputs(fluid('hydrochloric_acid') * 2000)
    .fluidOutputs(fluid('manganese_ii_chloride_solution') * 3000)
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('manganese_ii_chloride_solution') * 3000)
    .outputs(metaitem('dustManganeseIiChloride') * 3)
    .fluidOutputs(fluid('water') * 3000)
    .duration(20)
    .EUt(VA[LV])
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustManganeseDioxide') * 3)
    .fluidInputs(fluid('hydrochloric_acid') * 4000)
    .fluidOutputs(fluid('diluted_manganese_ii_chloride_solution') * 6000)
    .fluidOutputs(fluid('chlorine') * 2000)
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('diluted_manganese_ii_chloride_solution') * 6000)
    .outputs(metaitem('dustManganeseIiChloride') * 3)
    .fluidOutputs(fluid('water') * 6000)
    .duration(20)
    .EUt(VA[LV])
    .buildAndRegister()

// Manganese Nitrate process developed by IG Farbenindustrie
// doi:10.1002/14356007.a16_123

BR.recipeBuilder()
    .inputs(ore('dustPyrolusite') * 3)
    .fluidInputs(fluid('nitrogen_dioxide') * 2000)
    .fluidInputs(fluid('water') * 1000)
    .fluidOutputs(fluid('crude_manganese_ii_nitrate_solution') * 1000)
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister()

ROASTER.recipeBuilder()
    .fluidInputs(fluid('crude_manganese_ii_nitrate_solution') * 1000)
    .outputs(metaitem('dustManganeseDioxide') * 3)
    .fluidOutputs(fluid('nitrogen_dioxide') * 2000)
    .fluidOutputs(fluid('dense_steam') * 1000)
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister()

// MnO2 & Mn(NO3)2

BR.recipeBuilder()
    .inputs(ore('dustManganeseDioxide') * 3)
    .fluidInputs(fluid('nitrogen_dioxide') * 2000)
    .outputs(metaitem('dustManganeseIiNitrate') * 9)
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustManganeseIiNitrate') * 9)
    .fluidOutputs(fluid('nitrogen_dioxide') * 2000)
    .outputs(metaitem('dustManganeseDioxide') * 3)
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister()

ROASTER.recipeBuilder()
    .circuitMeta(2)
    .inputs(ore('dustManganese') * 1)
    .fluidInputs(fluid('oxygen') * 2000)
    .outputs(metaitem('dustManganeseDioxide') * 3)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

// MnO

ROASTER.recipeBuilder()
    .inputs(ore('dustManganeseIiHydroxide') * 5)
    .fluidOutputs(fluid('dense_steam') * 1000)
    .outputs(metaitem('dustManganeseIiOxide') * 2)
    .duration(200)
    .EUt(VA[LV])
    .buildAndRegister()

ROASTER.recipeBuilder()
    .circuitMeta(1)
    .inputs(ore('dustManganese') * 1)
    .fluidInputs(fluid('oxygen') * 1000)
    .outputs(metaitem('dustManganeseIiOxide') * 2)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .inputs(ore('dustManganeseDioxide') * 3)
    .fluidInputs(fluid('hydrogen') * 2000)
    .outputs(metaitem('dustManganeseIiOxide') * 2)
    .fluidOutputs(fluid('dense_steam') * 1000)
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .inputs(ore('dustManganeseDioxide') * 3)
    .fluidInputs(fluid('carbon_monoxide') * 1000)
    .outputs(metaitem('dustManganeseIiOxide') * 2)
    .fluidOutputs(fluid('carbon_dioxide') * 1000)
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister()

// MnO & Mn(NO3)2

BR.recipeBuilder()
    .inputs(ore('dustManganeseIiOxide') * 2)
    .fluidInputs(fluid('nitric_acid') * 2000)
    .fluidOutputs(fluid('manganese_ii_nitrate_solution') * 1000)
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('manganese_ii_nitrate_solution') * 1000)
    .fluidOutputs(fluid('water') * 1000)
    .outputs(metaitem('dustManganeseIiNitrate') * 9)
    .duration(80)
    .EUt(VA[LV])
    .buildAndRegister()

// Potassium permanganate

ROASTER.recipeBuilder()
    .inputs(ore('dustManganeseDioxide') * 3)
    .fluidInputs(fluid('potassium_hydroxide') * 864)
    .fluidInputs(fluid('oxygen') * 1000)
    .outputs(metaitem('dustPotassiumManganate') * 7)
    .fluidOutputs(fluid('dense_steam') * 1000)
    .duration(200)
    .EUt(VA[LV])
    .buildAndRegister()

ELECTROLYTIC_CELL.recipeBuilder()
    .notConsumable(ore('plateNickel') * 4)
    .notConsumable(ore('plateIron') * 4)
    .inputs(ore('dustPotassiumManganate') * 7)
    .fluidInputs(fluid('distilled_water') * 2000)
    .fluidOutputs(fluid('oxidized_manganate_solution') * 1000)
    .fluidOutputs(fluid('hydrogen') * 1000)
    .duration(200)
    .EUt(VA[MV])
    .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
    .fluidInputs(fluid('oxidized_manganate_solution') * 1000)
    .outputs(metaitem('dustPotassiumPermanganate') * 6)
    .fluidOutputs(fluid('potassium_hydroxide_solution') * 1000)
    .duration(200)
    .EUt(VA[LV])
    .buildAndRegister()

// Manganese carbonate

BR.recipeBuilder()
    .inputs(ore('dustSodaAsh') * 5)
    .fluidInputs(fluid('manganese_ii_nitrate_solution') * 1000)
    .fluidInputs(fluid('distilled_water') * 1000)
    .outputs(metaitem('dustManganeseIiCarbonate') * 5)
    .fluidOutputs(fluid('sodium_nitrate_solution') * 2000)
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister()
