import globals.Globals
import static globals.CarbonGlobals.*

AUTOCLAVE = recipemap('autoclave')
CHEMICAL_BATH = recipemap('chemical_bath')
ROTARY_KILN = recipemap('rotary_kiln')
DT = recipemap('distillation_tower')
BR = recipemap('batch_reactor')
TUBE_FURNACE = recipemap('tube_furnace')
ZONE_REFINER = recipemap('zone_refiner')

// Tannic acid for Ge precipitation

CHEMICAL_BATH.recipeBuilder()
    .inputs(ore('logWood'))
    .fluidInputs(fluid('distilled_water') * 100)
    .fluidOutputs(fluid('tannic_acid_solution') * 100)
    .duration(200)
    .EUt(30)
    .buildAndRegister()

// Zinc hydrometallurgy route (primitive)

for (highPurityCombustible in CarbonGlobals.highPurityCombustibles()) {
    for (fuel in rotary_kiln_fuels) {
        for (comburent in rotary_kiln_comburents) {
            ROTARY_KILN.recipeBuilder()
                .inputs(ore('dustZincLeachResidue') * 8)
                .inputs(ore(highPurityCombustible.name) * highPurityCombustible.equivalent(1))
                .outputs(metaitem('dustGermaniumRichOxide') )
                .outputs(metaitem('dustWaelzSlag'))
                .fluidInputs(fluid(fuel.name) * fuel.amountRequired)
                .fluidInputs(fluid(comburent.name) * comburent.amountRequired)
                .fluidOutputs(fluid(fuel.byproduct) * fuel.byproductAmount)
                .duration(fuel.duration + comburent.duration)
                .EUt(120)
                .buildAndRegister()
        }
    }
}

AUTOCLAVE.recipeBuilder()
    .inputs(ore('dustGermaniumRichOxide'))
    .fluidInputs(fluid('sulfuric_acid') * 1000)
    .fluidOutputs(fluid('germanium_leach') * 1000)
    .duration(200)
    .EUt(30)
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('tannic_acid_solution') * 100)
    .fluidInputs(fluid('germanium_leach') * 1000)
    .chancedOutput(metaitem('dustGermaniumConcentrate'), 8000, 0)
    .fluidOutputs(fluid('zinc_leach') * 1000)
    .duration(200)
    .EUt(30)
    .buildAndRegister()

// Concentrate purification

BR.recipeBuilder()
    .notConsumable(ore('springCupronickel'))
    .inputs(ore('dustGermaniumConcentrate'))
    .fluidInputs(fluid('hydrochloric_acid') * 400)
    .fluidInputs(fluid('chlorine') * 50)
    .fluidOutputs(fluid('impure_germanium_tetrachloride') * 100)
    .fluidOutputs(fluid('wastewater') * 600)
    .duration(200)
    .EUt(30)
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('impure_germanium_tetrachloride') * 1000)
    .fluidOutputs(fluid('arsenic_trichloride') * 100)
    .fluidOutputs(fluid('germanium_tetrachloride') * 900)
    .duration(200)
    .EUt(30)
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('germanium_tetrachloride') * 1000)
    .fluidInputs(fluid('ultrapure_water') * 6000)
    .outputs(metaitem('dustGermaniumDioxide') * 3)
    .fluidOutputs(fluid('hydrochloric_acid') * 4000)
    .duration(200)
    .EUt(30)
    .buildAndRegister()

TUBE_FURNACE.recipeBuilder()
    .inputs(ore('dustGermaniumDioxide') * 3)
    .fluidInputs(fluid('hydrogen') * 4000)
    .outputs(metaitem('dustGermanium'))
    .fluidOutputs(fluid('water') * 2000)
    .duration(200)
    .EUt(30)
    .buildAndRegister()

ZONE_REFINER.recipeBuilder()
    .inputs(ore('ingotGermanium'))
    .outputs(metaitem('ingotHighPurityGermanium'))
    .duration(200)
    .EUt(30)
    .buildAndRegister()