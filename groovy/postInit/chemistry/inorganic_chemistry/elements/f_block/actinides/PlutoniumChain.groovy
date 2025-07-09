MIXER_SETTLER = recipemap('mixer_settler')
BR = recipemap('batch_reactor')
MIXER = recipemap('mixer')
DT = recipemap('distillation_tower')
ROTARY_KILN = recipemap('rotary_kiln')
REACTION_FURNACE = recipemap('reaction_furnace')

// Purification
MIXER_SETTLER.recipeBuilder()
    .fluidInputs(fluid('actinide_separation_mixture') * 2000)
    .fluidInputs(fluid('plutonium_concentrate') * 240)
    .fluidOutputs(fluid('impure_reprocessed_uranium_extract') * 2000)
    .fluidOutputs(fluid('purified_plutonium_concentrate') * 240) // 0.03 mol Pu(III), 0.09 mol Fe(II), 0.03 mol Fe(III), 0.12 mol NH2SO3-, 0.24 mol NO3-, 0.12 mol H+, 0.12 mol H2O
    .requiredCells(4)
    .duration(120)
    .EUt(480)
    .buildAndRegister();

// Reoxidation
// NH2SO3- + NO2- → SO4- + N2 + H2O
// X(O) + NO2- + 2H+ → X(O+1) + NO + H2O, X is Pu/Fe
BR.recipeBuilder()
    .fluidInputs(fluid('sodium_nitrite_solution') * 240)
    .fluidInputs(fluid('purified_plutonium_concentrate') * 240)
    .fluidOutputs(fluid('oxidized_plutonium_concentrate') * 720)
    .fluidOutputs(fluid('nitrogen') * 240)
    .fluidOutputs(fluid('nitric_oxide') * 120)
    .duration(120)
    .EUt(480)
    .buildAndRegister();

// Reextraction
MIXER_SETTLER.recipeBuilder()
    .fluidInputs(fluid('oxidized_plutonium_concentrate') * 18000)
    .fluidInputs(fluid('actinide_separation_mixture') * 5000)
    .fluidOutputs(fluid('radioactive_wastewater') * 18000)
    .fluidOutputs(fluid('plutonium_extract') * 5000)
    .requiredCells(4)
    .duration(120)
    .EUt(480)
    .buildAndRegister();

// Reduction
MIXER.recipeBuilder()
    .fluidInputs(fluid('hydroxylamine') * 1000)
    .fluidInputs(fluid('diluted_nitric_acid') * 2000)
    .fluidOutputs(fluid('hydroxylammonium_nitrate_solution') * 1000)
    .duration(20)
    .EUt(30)
    .buildAndRegister();

MIXER_SETTLER.recipeBuilder()
    .fluidInputs(fluid('plutonium_extract') * 20000)
    .fluidInputs(fluid('hydroxylammonium_nitrate_solution') * 3000)
    .fluidOutputs(fluid('radiolyzed_actinide_separation_mixture') * 20000)
    .fluidOutputs(fluid('plutonium_iii_nitrate_solution') * 9000)
    .requiredCells(4)
    .duration(120)
    .EUt(480)
    .buildAndRegister();

DT.recipeBuilder()
    .fluidInputs(fluid('plutonium_iii_nitrate_solution') * 3000)
    .outputs(metaitem('dustReactorGradePlutoniumIiiNitrate') * 13)
    .fluidOutputs(fluid('nitric_acid') * 1000)
    .fluidOutputs(fluid('water') * 2000)
    .duration(120)
    .EUt(480)
    .buildAndRegister();

ROTARY_KILN.recipeBuilder()
    .inputs(metaitem('dustReactorGradePlutoniumIiiNitrate') * 13)
    .outputs(metaitem('dustReactorGradePlutoniumDioxide') * 3)
    .fluidOutputs(fluid('nitrogen_dioxide') * 3000)
    .fluidOutputs(fluid('oxygen') * 1000)
    .duration(120)
    .EUt(480)
    .buildAndRegister();

// Metal production

REACTION_FURNACE.recipeBuilder()
    .notConsumable(fluid('calcium_chloride') * 576)
    .inputs(metaitem('dustReactorGradePlutoniumDioxide') * 3)
    .inputs(ore('dustCalcium') * 2)
    .outputs(metaitem('dustReactorGradePlutonium'))
    .outputs(metaitem('dustQuicklime') * 4)
    .duration(120)
    .EUt(480)
    .buildAndRegister();

// MOX

BLENDER.recipeBuilder()
    .inputs(metaitem('dustReactorGradePlutoniumDioxide'))
    .inputs(metaitem('dustUraniumDioxide') * 19)
    .outputs(metaitem('dustMixedOxideFuel') * 20)
    .duration(200)
    .EUt(1920)
    .buildAndRegister();