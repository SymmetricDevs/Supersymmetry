import globals.Globals

CSTR = recipemap('continuous_stirred_tank_reactor')
CRYSTALLIZER = recipemap('crystallizer')
BR = recipemap('batch_reactor')
DISTILLERY = recipemap('distillery')
LCR = recipemap('large_chemical_reactor')
MIXER = recipemap('mixer')
POLYMERIZATION_TANK = recipemap('polymerization_tank')
DT = recipemap('distillation_tower')
SOLIDIFIER = recipemap('fluid_solidifier')
EXTRACTOR = recipemap('extractor')
PHASE_SEPARATOR = recipemap('phase_separator')

// Ultem

BR.recipeBuilder()
    .inputs(ore('dustPhthalicAnhydride') * 15)
    .fluidInputs(fluid('ammonia') * 2000)
    .outputs(metaitem('dustPhthalimide') * 16)
    .fluidOutputs(fluid('ammonia_solution') * 1000)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister();

BR.recipeBuilder()
    .inputs(ore('dustPhthalimide'))
    .inputs(ore('dustPotassiumHydroxide') * 3)
    .fluidInputs(fluid('ethanol') * 1000)
    .fluidOutputs(fluid('potassium_phthalimide_solution') * 1000)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister();

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('potassium_phthalimide_solution') * 1000)
    .outputs(metaitem('dustPotassiumPhthalimide') * 16)
    .fluidOutputs(fluid('ethanol') * 1000)
    .duration(20)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister();

BR.recipeBuilder()
    .inputs(ore('dustPotassiumPhthalimide') * 16)
    .fluidInputs(fluid('chloromethane') * 1000)
    .fluidInputs(fluid('dimethylformamide') * 1000)
    .fluidOutputs(fluid('n_methyl_phthalimide_solution') * 1000)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister();

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('n_methyl_phthalimide_solution') * 1000)
    .outputs(metaitem('dustNMethylPhthalimide') * 19)
    .fluidOutputs(fluid('dimethylformamide') * 1000)
    .duration(20)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister();

BR.recipeBuilder()
    .inputs(ore('dustNMethylPhthalimide') * 19)
    .fluidInputs(fluid('nitration_mixture') * 2000)
    .fluidOutputs(fluid('four_nitro_n_methyl_phthalimide_solution') * 2000)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister();

PHASE_SEPARATOR.recipeBuilder()
    .fluidInputs(fluid('four_nitro_n_methyl_phthalimide_solution') * 2000)
    .outputs(metaitem('dustFourNitroNMethylPhthalimide') * 21)
    .fluidOutputs(fluid('diluted_sulfuric_acid') * 2000)
    .duration(40)
    .buildAndRegister();

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('sodium_bisphenolate_solution') * 2000)
    .outputs(metaitem('dustSodiumBisphenolate') * 33)
    .fluidOutputs(fluid('water') * 2000)
    .duration(60)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister();

BR.recipeBuilder()
    .inputs(ore('dustFourNitroNMethylPhthalimide') * 42)
    .inputs(ore('dustSodiumBisphenolate') * 33)
    .fluidInputs(fluid('n_methyl_two_pyrrolidone') * 1000)
    .fluidOutputs(fluid('bisphenol_a_diimide_solution') * 1000)
    .duration(200)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister();

BR.recipeBuilder()
    .inputs(ore('dustPhthalicAnhydride') * 30)
    .fluidInputs(fluid('bisphenol_a_diimide_solution') * 1000)
    .fluidOutputs(fluid('bisphenol_a_dianhydride_solution') * 1000)
    .duration(200)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister();

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('bisphenol_a_dianhydride_solution') * 1000)
    .outputs(metaitem('dustImpureBisphenolADianhydride') * 3)
    .fluidOutputs(fluid('n_methyl_two_pyrrolidone') * 1000)
    .duration(120)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister();

CRYSTALLIZER.recipeBuilder()
    .fluidInputs(fluid('impure_bisphenol_a_dianhydride') * 432)
    .outputs(metaitem('dustBisphenolADianhydride'))
    .fluidOutputs(fluid('phthalimide') * 288)
    .duration(160)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister();

POLYMERIZATION_TANK.recipeBuilder()
    .notConsumable(fluid('nitrogen') * 8000)
    .fluidInputs(fluid('bisphenol_a_dianhydride') * 144)
    .fluidInputs(fluid('meta_phenylenediamine') * 144)
    .outputs(metaitem('dustUltem'))
    .fluidOutputs(fluid('dense_steam') * 2000)
    .duration(300)
    .EUt(1920)
    .buildAndRegister();

// Pyromellitic Dianhydride

BR.recipeBuilder()
    .notConsumable(ore('dustAluminiumChloride'))
    .fluidInputs(fluid('para_xylene') * 1000)
    .fluidInputs(fluid('chloromethane') * 2000)
    .outputs(metaitem('dustDurene') * 24)
    .fluidOutputs(fluid('hydrogen_chloride') * 2000)
    .duration(300)
    .EUt(30)
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustDurene') * 4)
    .fluidInputs(fluid('oxygen') * 2000)
    .outputs(metaitem('dustPyromelliticDianhydride') * 3)
    .fluidOutputs(fluid('dense_steam') * 1000)
    .duration(200)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister();

// Kapton K

POLYMERIZATION.recipeBuilder()
    .inputs(ore('dustPyromelliticDianhydride'))
    .inputs(ore('dustFourFourOxydianiline'))
    .fluidInputs(fluid('acetone') * 2000)
    .fluidOutputs(fluid('impure_kapton_k') * 2000)
    .duration(400) 
    .EUt(Globals.voltAmps[3] * 2)
    .buildAndRegister();

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('impure_kapton_k') * 1000)
    .fluidOutputs(fluid('acetone') * 1000)
    .outputs(metaitem('dustKaptonK'))
    .duration(200)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister();

// Kapton E

MIXER.recipeBuilder()
    .inputs(ore('dustPyromelliticDianhydride'))
    .inputs(ore('dustFourFourOxydianiline'))
    .inputs(ore('dustBiphenylTetracarboxylicAcidDianhydride'))
    .inputs(ore('dustParaPhenylenediamine'))
    .fluidInputs(fluid('acetone') * 4000)
    .fluidOutputs(fluid('kapton_e_preparation') * 4000)
    .duration(800)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister();

POLYMERIZATION.recipeBuilder()
    .fluidInputs(fluid('kapton_e_preparation') * 1000)
    .fluidOutputs(fluid('impure_kapton_e') * 1000)
    .duration(200)
    .EUt(Globals.voltAmps[2] * 2)
    .buildAndRegister();

DRYER.recipeBuilder()
    .fluidInputs(fluid('impure_kapton_e') * 1000)
    .fluidOutputs(fluid('acetone') * 1000)
    .outputs(metaitem('dustKaptonE'))
    .duration(200)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister();