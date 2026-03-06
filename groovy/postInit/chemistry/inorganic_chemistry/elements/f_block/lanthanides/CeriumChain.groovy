import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Cerium reductive stripping
// 2Ce(NO3)4 + H2O2 -> 2Ce(NO3)3 + O2 + 2HNO3
MIXER_SETTLER.recipeBuilder()
    .fluidInputs(fluid('cerium_extract') * 20000)
    .fluidInputs(fluid('hydrogen_peroxide_solution') * 500)
    .fluidOutputs(fluid('cerium_iii_nitrate_solution') * 1500)
    .fluidOutputs(fluid('tributyl_phosphate_extraction_mixture') * 20000)
    .fluidOutputs(fluid('oxygen') * 1000)
    .duration(80)
    .EUt(VA[MV])
    .requiredCells(2)
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('cerium_iii_nitrate_solution') * 1500)
    .fluidInputs(fluid('hydrofluoric_acid') * 3000)
    .fluidInputs(fluid('distilled_water') * 500)
    .outputs(metaitem('dustCeriumIiiFluoride') * 4)
    .fluidOutputs(fluid('diluted_nitric_acid') * 8000)
    .duration(80)
    .EUt(VA[LV])
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .notConsumable(metaitem('crucible.tantalum'))
    .inputs(ore('dustCeriumIiiFluoride') * 8)
    .inputs(ore('dustHighPurityCalcium') * 3)
    .fluidInputs(fluid('argon') * 50)
    .outputs(metaitem('dustCerium') * 2)
    .outputs(metaitem('dustFluorite') * 9)
    .duration(200)
    .EUt(960)
    .buildAndRegister()

// From Xenotime
// Ce(IV) + Cl- -> Ce(III) + 1/2Cl2
BR.recipeBuilder()
    .inputs(ore('dustCeriumIvHydroxide') * 9)
    .fluidInputs(fluid('hydrochloric_acid') * 4000)
    .fluidOutputs(fluid('cerium_iii_chloride_solution') * 8000)
    .fluidOutputs(fluid('chlorine') * 1000)
    .duration(80)
    .EUt(VA[LV])
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('cerium_iii_chloride_solution') * 8000)
    .outputs(metaitem('dustCeriumIiiChloride') * 4)
    .fluidOutputs(fluid('water') * 8000)
    .duration(20)
    .EUt(VA[LV])
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustCeriumIiiChloride') * 4)
    .fluidInputs(fluid('hydrofluoric_acid') * 3000)
    .outputs(metaitem('dustCeriumIiiFluoride') * 4)
    .fluidOutputs(fluid('hydrochloric_acid') * 3000)
    .duration(80)
    .EUt(VA[LV])
    .buildAndRegister()

// Cerium carbonate

BR.recipeBuilder()
    .inputs(ore('dustCeriumIiiChloride') * 8)
    .inputs(ore('dustSodaAsh') * 18)
    .fluidInputs(fluid('deionized_water') * 6000)
    .outputs(metaitem('dustCeriumIiiCarbonate') * 14)
    .fluidOutputs(fluid('salt_water') * 6000)
    .duration(80)
    .EUt(VA[LV])
    .buildAndRegister()

//Cerium chloride (pre-IV)

ROASTER.recipeBuilder()
    .inputs(ore('dustCerium'))
    .fluidInputs(fluid('chlorine') * 3000)
    .outputs(metaitem('dustCeriumIiiChloride') * 4)
    .duration(80)
    .EUt(VA[EV])
    .buildAndRegister()

//Cerium IV oxide

ROASTER.recipeBuilder()
    .fluidInputs(fluid('oxygen') * 2000)
    .inputs(metaitem('dustCerium'))
    .outputs(metaitem('dustCeriumIvOxide') * 3)
    .duration(20)
    .EUt(VA[LV])
    .buildAndRegister();