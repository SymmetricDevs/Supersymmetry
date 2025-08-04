MIXER_SETTLER = recipemap('mixer_settler')
DISTILLERY = recipemap('distillery')
DT = recipemap('distillation_tower')
ROTARY_KILN = recipemap('rotary_kiln')
CSTR = recipemap('continuous_stirred_tank_reactor')
BR = recipemap('batch_reactor')
MIXER = recipemap('mixer')
ELECTROLYTIC_CELL = recipemap('electrolytic_cell')
BLENDER = recipemap('blender')

/* Composition data
U - 98.90%
Pu - 1.00%
Np - 0.06%
Am - 0.04%
Cm - 0.005%
*/

// Preprocessing
LCR.recipeBuilder()
    .inputs(ore('fuelPelletDepletedLeu235Dioxide') * 16)
    .fluidInputs(fluid('nitric_acid') * 61600)
    .fluidOutputs(fluid('spent_fuel_suspension') * 61600)
    .fluidOutputs(fluid('nitrogen_dioxide') * 30480)
    .duration(400)
    .EUt(1920)
    .buildAndRegister();

CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('spent_fuel_suspension') * 30800)
    .fluidOutputs(fluid('spent_fuel_solution') * 30800)
    .duration(400)
    .EUt(480)
    .buildAndRegister();

// Extraction
BLENDER.recipeBuilder()
    .circuitMeta(2)
    .fluidInputs(fluid('tributyl_phosphate') * 3000)
    .fluidInputs(fluid('kerosene') * 7000)
    .fluidOutputs(fluid('actinide_separation_mixture') * 10000)
    .duration(400)
    .EUt(1920)
    .buildAndRegister();

MIXER_SETTLER.recipeBuilder()
    .fluidInputs(fluid('spent_fuel_solution') * 3080)
    .fluidInputs(fluid('actinide_separation_mixture') * 10656)
    .fluidOutputs(fluid('transuranium_solution') * 3080)
    .fluidOutputs(fluid('uranium_plutonium_extract') * 10656)
    .requiredCells(6)
    .duration(60)
    .EUt(480)
    .buildAndRegister();

// Pu reduction

    // Ferrous sulfamate
    // OC(NH2)2 + SO3 + H2SO4 → CO2 + 2 NH3SO3
    // Fe(OH)2 + 2 H3NSO3 → Fe(NH2SO3)2 + 2 H2O
    BR.recipeBuilder()
        .inputs(ore('dustUrea') * 8)
        .inputs(ore('dustIronIiHydroxide') * 5)
        .fluidInputs(fluid('oleum') * 11000)
        .fluidOutputs(fluid('ferrous_sulfamate_solution') * 11000)
        .fluidOutputs(fluid('carbon_dioxide') * 1000)
        .duration(400)
        .EUt(480)
        .buildAndRegister();

    DT.recipeBuilder()
        .fluidInputs(fluid('ferrous_sulfamate_solution') * 11000)
        .outputs(metaitem('dustFerrousSulfamate') * 15)
        .fluidOutputs(fluid('sulfuric_acid') * 9000)
        .fluidOutputs(fluid('water') * 2000)
        .duration(400)
        .EUt(480)
        .buildAndRegister();

    MIXER.recipeBuilder()
        .inputs(metaitem('dustFerrousSulfamate') * 15)
        .fluidInputs(fluid('diluted_nitric_acid') * 2000)
        .fluidOutputs(fluid('plutonium_reduction_solution') * 2000)
        .duration(400)
        .EUt(480)
        .buildAndRegister();

    // Startup
    MIXER_SETTLER.recipeBuilder() // 4:1 ratio of FeSA to Pu
        .circuitMeta(1)
        .fluidInputs(fluid('uranium_plutonium_extract') * 20000) // carries 3 moles of U/Pu.
        .fluidInputs(fluid('plutonium_reduction_solution') * 240)
        .fluidOutputs(fluid('reprocessed_uranium_extract') * 20000)
        .fluidOutputs(fluid('plutonium_concentrate') * 240)
        .requiredCells(6)
        .duration(1200)
        .EUt(480)
        .buildAndRegister();

    // Looped
    MIXER_SETTLER.recipeBuilder() // 4:1 ratio of FeSA to Pu
        .circuitMeta(2)
        .fluidInputs(fluid('uranium_plutonium_extract') * 20000) // carries 3 moles of U/Pu.
        .fluidInputs(fluid('plutonium_reduction_solution') * 240)
        .fluidInputs(fluid('impure_reprocessed_uranium_extract') * 2000)
        .fluidOutputs(fluid('reprocessed_uranium_extract') * 22000)
        .fluidOutputs(fluid('plutonium_concentrate') * 240)
        .requiredCells(6)
        .duration(120)
        .EUt(480)
        .buildAndRegister();

    MIXER_SETTLER.recipeBuilder()
        .fluidInputs(fluid('reprocessed_uranium_extract') * 22000)
        .fluidInputs(fluid('diluted_nitric_acid') * 2967)
        .fluidOutputs(fluid('radiolyzed_actinide_separation_mixture') * 22000)
        .fluidOutputs(fluid('reprocessed_uranium_concentrate') * 2967)
        .requiredCells(6)
        .duration(120)
        .EUt(480)
        .buildAndRegister();

    MIXER_SETTLER.recipeBuilder()
        .fluidInputs(fluid('radiolyzed_actinide_separation_mixture') * 22000)
        .fluidInputs(fluid('soda_ash_solution') * 1000)
        .fluidOutputs(fluid('actinide_separation_mixture') * 21780)
        .fluidOutputs(fluid('radioactive_wastewater') * 1000)
        .requiredCells(6)
        .duration(120)
        .EUt(480)
        .buildAndRegister();

// Vitrification of HLW

