import globals.Globals

BR = recipemap('batch_reactor')
ROASTER = recipemap('roaster')
BCR = recipemap('bubble_column_reactor')
MIXER = recipemap('mixer')
POLYMERIZATION_TANK = recipemap('polymerization_tank')
DRYER = recipemap('dryer')
PYROLYSE_OVEN = recipemap('pyrolyse_oven')

// Lithium Perfluorooctanoate Surfactant

BR.recipeBuilder()
    .inputs(ore('dustPerfluorooctanoicAcid') * 13)
    .fluidInputs(fluid('lithium_hydroxide_solution') * 1000)
    .fluidOutputs(fluid('vinylidene_fluoride_surfactant_mixture') * 2000)
    .duration(200)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister();

// Vinylidene Fluoride

BCR.recipeBuilder()
    .notConsumable(metaitem('dustIronIiiChloride'))
    .fluidInputs(fluid('vinyl_chloride') * 50)
    .fluidInputs(fluid('hydrogen_chloride') * 50)
    .fluidOutputs(fluid('one_one_dichloroethane') * 50)
    .duration(2)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

BCR.recipeBuilder()
    .notConsumable(metaitem('emitter.lv'))
    .fluidInputs(fluid('one_one_dichloroethane') * 50)
    .fluidInputs(fluid('hydrogen_chloride') * 50)
    .fluidOutputs(fluid('one_one_one_trichloroethane') * 50)
    .fluidOutputs(fluid('hydrogen') * 100)
    .duration(4)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister();

ROASTER.recipeBuilder()
    .notConsumable(ore('dustMolybdenum'))
    .fluidInputs(fluid('one_one_one_trichloroethane') * 1000)
    .fluidInputs(fluid('hydrofluoric_acid') * 2000)
    .fluidOutputs(fluid('one_chloro_two_two_difluoroethane') * 1000)
    .fluidOutputs(fluid('hydrochloric_acid') * 2000)
    .duration(200)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister();

PYROLYSE_OVEN.recipeBuilder()
    //.fluidInputs(fluid('dense_steam') * 1000)
    .fluidInputs(fluid('one_chloro_two_two_difluoroethane') * 1000)
    .fluidOutputs(fluid('vinylidene_fluoride') * 1000)
    .fluidOutputs(fluid('hydrochloric_acid') * 1000)
    .duration(200)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister();

// Polymerization

POLYMERIZATION_TANK.recipeBuilder()
    .fluidInputs(fluid('di_tert_butyl_peroxide') * 50)
    .fluidInputs(fluid('vinylidene_fluoride') * 1000)
    .fluidInputs(fluid('vinylidene_fluoride_surfactant_mixture') * 500)
    .fluidOutputs(fluid('polyvinylidene_fluoride_solution') * 500)
    .duration(300)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister();

DRYER.recipeBuilder()
    .fluidInputs(fluid('polyvinylidene_fluoride_solution') * 500)
    .outputs(metaitem('dustPolyvinylideneFluoride'))
    .fluidOutputs(fluid('vinylidene_fluoride_surfactant_mixture') * 500)
    .duration(300)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister();

// FKM/Viton production

PYROLYSE_OVEN.recipeBuilder()
    .notConsumable(fluid('dense_steam') * 1000)
    .fluidInputs(fluid('tetrafluoroethylene') * 1500)
    .fluidOutputs(fluid('hexafluoropropylene') * 1000)
    .duration(200)
    .EUt(120)
    .buildAndRegister();

POLYMERIZATION_TANK.recipeBuilder()
    .inputs(ore('dustTinyAmmoniumPersulfate'))
    .fluidInputs(fluid('vinylidene_fluoride') * 1000)
    .fluidInputs(fluid('hexafluoropropylene') * 1000)
    .fluidInputs(fluid('vinylidene_fluoride_surfactant_mixture') * 500)
    .fluidOutputs(fluid('viton_solution') * 500)
    .duration(200)
    .EUt(480)
    .buildAndRegister();

DRYER.recipeBuilder()
    .fluidInputs(fluid('viton_solution') * 500)
    .outputs(metaitem('dustViton'))
    .fluidOutputs(fluid('vinylidene_fluoride_surfactant_mixture') * 500)
    .duration(300)
    .EUt(480)
    .buildAndRegister();