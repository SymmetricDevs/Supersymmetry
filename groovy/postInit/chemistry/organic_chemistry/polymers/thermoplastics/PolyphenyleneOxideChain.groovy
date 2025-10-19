import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

MIXER.recipeBuilder()
    .fluidInputs(fluid('two_six_xylenol') * 1000)
    .fluidInputs(fluid('toluene') * 1000)
    .fluidOutputs(fluid('xylenol_solution') * 2000)
    .duration(60)
    .EUt(VA[LV])
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
    .EUt(VA[HV])
    .buildAndRegister();

MIXER.recipeBuilder()
    .circuitMeta(2)
    .fluidInputs(fluid('ethylenediamine') * 1000)
    .fluidInputs(fluid('water') * 1000)
    .fluidOutputs(fluid('ethylenediamine_solution') * 2000)
    .duration(80)
    .EUt(VA[LV])
    .buildAndRegister();

CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('ethylenediamine_solution') * 50)
    .fluidInputs(fluid('impure_ppo_solution') * 1000)
    .fluidOutputs(fluid('ppo_solution') * 1000)
    .fluidOutputs(fluid('wastewater') * 50)
    .duration(120)
    .EUt(VA[MV])
    .buildAndRegister();

BR.recipeBuilder()
    .inputs(ore('dustPolystyrene'))
    .fluidInputs(fluid('methanol') * 1000)
    .fluidInputs(fluid('ppo_solution') * 1000)
    .outputs(metaitem('dustPolyphenyleneOxide') * 2)
    .fluidOutputs(fluid('ppo_waste') * 2000)
    .duration(120)
    .EUt(VA[MV])
    .buildAndRegister();

SIEVE_DT.recipeBuilder()
    .notConsumable(fluid('distilled_water') * 1000)
    .fluidInputs(fluid('ppo_waste') * 2000)
    .fluidOutputs(fluid('toluene') * 1000)
    .fluidOutputs(fluid('methanol') * 1000)
    .duration(40)
    .EUt(VA[MV])
    .buildAndRegister();
