import globals.Globals

POLYMERIZATION_TANK = recipemap('polymerization_tank')
BCR = recipemap('bubble_column_reactor')
CENTRIFUGE = recipemap('centrifuge')
MIXER = recipemap('mixer')
BR = recipemap('batch_reactor')
SIEVE_DT = recipemap('sieve_distillation')

MIXER.recipeBuilder()
    .fluidInputs(fluid('two_six_xylenol') * 1000)
    .fluidInputs(fluid('toluene') * 1000)
    .fluidOutputs(fluid('xylenol_solution') * 2000)
    .duration(60)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister();

POLYMERIZATION_TANK.recipeBuilder()
    .inputs(ore('dustSmallCopperIiChloride'))
    .inputs(ore('dustSmallPotassiumHydroxide'))
    .fluidInputs(fluid('pyridine') * 50)
    .fluidInputs(fluid('xylenol_solution') * 2000)
    .fluidInputs(fluid('oxygen') * 1000)
    .fluidOutputs(fluid('impure_ppo_solution') * 1000)
    .fluidOutputs(fluid('wastewater') * 1000)
    .duration(180)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister();

MIXER.recipeBuilder()
    .fluidInputs(fluid('ethylenediamine') * 1000)
    .fluidInputs(fluid('water') * 1000)
    .fluidOutputs(fluid('ethylenediamine_solution') * 2000)
    .duration(80)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister();

CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('ethylenediamine_solution') * 50)
    .fluidInputs(fluid('impure_ppo_solution') * 1000)
    .fluidOutputs(fluid('ppo_solution') * 1000)
    .fluidOutputs(fluid('wastewater') * 50)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister();

BR.recipeBuilder()
    .inputs(ore('dustPolystyrene'))
    .fluidInputs(fluid('methanol') * 1000)
    .fluidInputs(fluid('ppo_solution') * 1000)
    .outputs(metaitem('dustPolyphenyleneOxide') * 2)
    .fluidOutputs(fluid('ppo_waste') * 2000)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister();

SIEVE_DT.recipeBuilder()
    .notConsumable(fluid('distilled_water') * 1000)
    .fluidInputs(fluid('ppo_waste') * 2000)
    .fluidOutputs(fluid('toluene') * 1000)
    .fluidOutputs(fluid('methanol') * 1000)
    .duration(40)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister();