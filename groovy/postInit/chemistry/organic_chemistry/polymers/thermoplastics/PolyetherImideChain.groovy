import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Ultem

BR.recipeBuilder()
    .inputs(ore('dustPhthalicAnhydride') * 15)
    .fluidInputs(fluid('ammonia') * 2000)
    .outputs(metaitem('dustPhthalimide') * 16)
    .fluidOutputs(fluid('ammonia_solution') * 1000)
    .duration(120)
    .EUt(VA[MV])
    .buildAndRegister();

BR.recipeBuilder()
    .inputs(ore('dustPhthalimide'))
    .inputs(ore('dustPotassiumHydroxide') * 3)
    .fluidInputs(fluid('ethanol') * 1000)
    .fluidOutputs(fluid('potassium_phthalimide_solution') * 1000)
    .duration(120)
    .EUt(VA[MV])
    .buildAndRegister();

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('potassium_phthalimide_solution') * 1000)
    .outputs(metaitem('dustPotassiumPhthalimide') * 16)
    .fluidOutputs(fluid('ethanol') * 1000)
    .duration(20)
    .EUt(VA[LV])
    .buildAndRegister();

BR.recipeBuilder()
    .inputs(ore('dustPotassiumPhthalimide') * 16)
    .fluidInputs(fluid('chloromethane') * 1000)
    .fluidInputs(fluid('dimethylformamide') * 1000)
    .fluidOutputs(fluid('n_methyl_phthalimide_solution') * 1000)
    .duration(120)
    .EUt(VA[MV])
    .buildAndRegister();

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('n_methyl_phthalimide_solution') * 1000)
    .outputs(metaitem('dustNMethylPhthalimide') * 19)
    .fluidOutputs(fluid('dimethylformamide') * 1000)
    .duration(20)
    .EUt(VA[LV])
    .buildAndRegister();

BR.recipeBuilder()
    .inputs(ore('dustNMethylPhthalimide') * 19)
    .fluidInputs(fluid('nitration_mixture') * 2000)
    .fluidOutputs(fluid('four_nitro_n_methyl_phthalimide_solution') * 2000)
    .duration(120)
    .EUt(VA[MV])
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
    .EUt(VA[LV])
    .buildAndRegister();

BR.recipeBuilder()
    .inputs(ore('dustFourNitroNMethylPhthalimide') * 42)
    .inputs(ore('dustSodiumBisphenolate') * 33)
    .fluidInputs(fluid('n_methyl_two_pyrrolidone') * 1000)
    .fluidOutputs(fluid('bisphenol_a_diimide_solution') * 1000)
    .duration(200)
    .EUt(VA[HV])
    .buildAndRegister();

BR.recipeBuilder()
    .inputs(ore('dustPhthalicAnhydride') * 30)
    .fluidInputs(fluid('bisphenol_a_diimide_solution') * 1000)
    .fluidOutputs(fluid('bisphenol_a_dianhydride_solution') * 1000)
    .duration(200)
    .EUt(VA[HV])
    .buildAndRegister();

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('bisphenol_a_dianhydride_solution') * 1000)
    .outputs(metaitem('dustImpureBisphenolADianhydride') * 3)
    .fluidOutputs(fluid('n_methyl_two_pyrrolidone') * 1000)
    .duration(120)
    .EUt(VA[LV])
    .buildAndRegister();

CRYSTALLIZER.recipeBuilder()
    .fluidInputs(fluid('impure_bisphenol_a_dianhydride') * 432)
    .outputs(metaitem('dustBisphenolADianhydride'))
    .fluidOutputs(fluid('phthalimide') * 288)
    .duration(160)
    .EUt(VA[MV])
    .buildAndRegister();

POLYMERIZATION_TANK.recipeBuilder()
    .notConsumable(fluid('nitrogen') * 8000)
    .fluidInputs(fluid('bisphenol_a_dianhydride') * 144)
    .fluidInputs(fluid('meta_phenylenediamine') * 144)
    .outputs(metaitem('dustUltem'))
    .fluidOutputs(fluid('dense_steam') * 2000)
    .duration(300)
    .EUt(VA[EV])
    .buildAndRegister();

// Pyromellitic Dianhydride

BR.recipeBuilder()
    .notConsumable(ore('dustAluminiumChloride'))
    .fluidInputs(fluid('para_xylene') * 1000)
    .fluidInputs(fluid('chloromethane') * 2000)
    .outputs(metaitem('dustDurene') * 24)
    .fluidOutputs(fluid('hydrogen_chloride') * 2000)
    .duration(300)
    .EUt(VA[LV])
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustDurene') * 4)
    .fluidInputs(fluid('oxygen') * 2000)
    .outputs(metaitem('dustPyromelliticDianhydride') * 3)
    .fluidOutputs(fluid('dense_steam') * 1000)
    .duration(200)
    .EUt(VA[LV])
    .buildAndRegister();

// Kapton K

POLYMERIZATION_TANK.recipeBuilder()
    .inputs(ore('dustPyromelliticDianhydride'))
    .inputs(ore('dustFourFourOxydianiline'))
    .fluidInputs(fluid('acetone') * 2000)
    .fluidOutputs(fluid('impure_kapton_k') * 2000)
    .duration(400) 
    .EUt(VA[HV] * 2)
    .buildAndRegister();

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('impure_kapton_k') * 1000)
    .fluidOutputs(fluid('acetone') * 1000)
    .outputs(metaitem('dustKaptonK'))
    .duration(200)
    .EUt(VA[MV])
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
    .EUt(VA[LV])
    .buildAndRegister();

POLYMERIZATION_TANK.recipeBuilder()
    .fluidInputs(fluid('kapton_e_preparation') * 1000)
    .fluidOutputs(fluid('impure_kapton_e') * 1000)
    .duration(200)
    .EUt(VA[MV] * 2)
    .buildAndRegister();

DRYER.recipeBuilder()
    .fluidInputs(fluid('impure_kapton_e') * 1000)
    .fluidOutputs(fluid('acetone') * 1000)
    .outputs(metaitem('dustKaptonE'))
    .duration(200)
    .EUt(VA[LV])
    .buildAndRegister();
