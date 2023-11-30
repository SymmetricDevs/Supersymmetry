// N-phenyl-1-naphthylamine

BR.recipeBuilder()
    .fluidInputs(fluid('naphthalene') * 1000)
    .fluidInputs(fluid('nitration_mixture') * 2000)
    .outputs(metaitem('dustCrudeOneNitronaphthalene'))
    .fluidOutputs(fluid('diluted_sulfuric_acid') * 2000)
    .duration(200)
    .EUt(120)
    .buildAndRegister()

VACUUM_DT.recipeBuilder()
    .inputs(ore('dustCrudeOneNitronaphthalene'))
    .outputs(metaitem('dustOneNitronaphthalene'))
    .duration(200)
    .EUt(120)
    .buildAndRegister()

FBR.recipeBuilder()
    .inputs(ore('dustOneNitronaphthalene'))
    .notConsumable(ore('catalystBedNickel'))
    .fluidInputs(fluid('hydrogen') * 6000)
    .outputs(metaitem('dustOneNaphthylamine'))
    .fluidOutputs(fluid('water') * 2000)
    .duration(200)
    .EUt(120)
    .buildAndRegister()

ROASTER.recipeBuilder()
    .fluidInputs(fluid('one_naphthylamine') * 144)
    .fluidInputs(fluid('aniline') * 1000)
    .outputs(metaitem('dustNPhenylOneNaphthylamine'))
    .duration(200)
    .EUt(120)
    .buildAndRegister()
    
// Calcium salicylate

BR.recipeBuilder()
    .inputs(ore('dustCalciumHydroxide') * 5)
    .fluidInputs(fluid('phenol') * 2000)
    .fluidInputs(fluid('carbon_dioxide') * 2000)
    .fluidInputs(fluid('diethylene_glycol') * 1000)
    .notConsumable(fluid('hp_nitrogen') * 6400)
    .fluidOutputs(fluid('calcium_salicylate_solution') * 1000)
    .duration(200)
    .EUt(120)
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('calcium_salicylate_solution') * 1000)
    .outputs(metaitem('dustCalciumSalicylate'))
    .fluidOutputs(fluid('diethylene_glycol') * 1000)
    .duration(20)
    .EUt(30)
    .buildAndRegister()




