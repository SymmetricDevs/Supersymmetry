import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// 4,4'-difluorobenzophenone
BR.recipeBuilder()
    .inputs(ore('dustSodiumNitrite') * 4)
    .fluidInputs(fluid('gtfo_aniline') * 1000)
    .fluidInputs(fluid('hydrofluoric_acid') * 2000)
    .fluidOutputs(fluid('benzenediazonium_fluoride_solution') * 4000)
    .duration(120)
    .EUt(VA[MV])
    .buildAndRegister();

CRYSTALLIZER.recipeBuilder()
    .notConsumable(metaitem('springNichrome'))
    .fluidInputs(fluid('benzenediazonium_fluoride_solution') * 4000)
    .outputs(metaitem('dustBenzenediazoniumFluoride') * 14)
    .fluidOutputs(fluid('sodium_fluoride_solution') * 1000)
    .fluidOutputs(fluid('dense_steam') * 3000)
    .duration(120)
    .EUt(VA[MV])
    .buildAndRegister();

ROASTER.recipeBuilder()
    .inputs(ore('dustBenzenediazoniumFluoride') * 14)
    .fluidOutputs(fluid('fluorobenzene') * 1000)
    .fluidOutputs(fluid('nitrogen') * 2000)
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister();

BR.recipeBuilder()
    .inputs(ore('dustParaNitrotoluene') * 17)
    .fluidInputs(fluid('oxygen') * 3000)
    .outputs(metaitem('dustParaNitrobenzoicAcid') * 17)
    .fluidOutputs(fluid('dense_steam') * 1000)
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister();

BR.recipeBuilder()
    .notConsumable(ore('dustPalladiumOnCarbon'))
    .inputs(ore('dustParaNitrobenzoicAcid') * 17)
    .fluidInputs(fluid('hydrogen') * 6000)
    .outputs(metaitem('dustParaAminobenzoicAcid') * 17)
    .fluidOutputs(fluid('dense_steam') * 2000)
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister();

BR.recipeBuilder()
    .notConsumable(fluid('sulfuric_acid') * 1000)
    .inputs(ore('dustParaAminobenzoicAcid') * 17)
    .fluidInputs(fluid('ethanol') * 1000)
    .outputs(metaitem('dustParaAminobenzylEthylEster') * 23)
    .fluidOutputs(fluid('dense_steam') * 1000)
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister();

BR.recipeBuilder()
    .inputs(ore('dustSodiumNitrite') * 4)
    .inputs(ore('dustParaAminobenzylEthylEster') * 23)
    .fluidInputs(fluid('hydrogen_fluoride') * 2000)
    .outputs(metaitem('dustParaDiazoniobenzylEthylEsterFluoride') * 23)
    .fluidOutputs(fluid('diluted_sodium_fluoride_solution') * 2000)
    .duration(120)
    .EUt(VA[MV])
    .buildAndRegister();

ROASTER.recipeBuilder()
    .inputs(ore('dustParaDiazoniobenzylEthylEsterFluoride') * 23)
    .outputs(metaitem('dustParaFluorobenzoicAcidEthylEster') * 21)
    .fluidOutputs(fluid('nitrogen') * 2000)
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister();

BR.recipeBuilder()
    .inputs(ore('dustParaFluorobenzoicAcidEthylEster') * 21)
    .fluidInputs(fluid('diluted_hydrochloric_acid') * 2000)
    .outputs(metaitem('dustParaFluorobenzoicAcid') * 15)
    .fluidOutputs(fluid('acidic_ethanol_solution') * 2000)
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister();

DT.recipeBuilder()
    .fluidInputs(fluid('acidic_ethanol_solution') * 4500)
    .fluidOutputs(fluid('ethanol_water_azeotrope') * 2500)
    .fluidOutputs(fluid('water') * 2000)
    .fluidOutputs(fluid('hydrogen_chloride') * 2250)
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister();

BR.recipeBuilder()
    .inputs(ore('dustParaFluorobenzoicAcid') * 15)
    .fluidInputs(fluid('thionyl_chloride') * 1000)
    .fluidOutputs(fluid('para_fluorobenzoyl_chloride') * 1000)
    .fluidOutputs(fluid('hydrochloric_acid') * 1000)
    .fluidOutputs(fluid('sulfur_dioxide') * 1000)
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister();

BR.recipeBuilder()
    .notConsumable(metaitem('catalystBedAluminiumChloride'))
    .fluidInputs(fluid('para_fluorobenzoyl_chloride') * 1000)
    .fluidInputs(fluid('fluorobenzene') * 1000)
    .fluidInputs(fluid('hexane') * 1000)
    .fluidOutputs(fluid('four_four_difluorobenzophenone_solution') * 1000)
    .fluidOutputs(fluid('hydrogen_chloride') * 1000)
    .duration(200)
    .EUt(VA[MV])
    .buildAndRegister();

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('four_four_difluorobenzophenone_solution') * 1000)
    .outputs(metaitem('dustFourFourDifluorobenzophenone'))
    .fluidOutputs(fluid('hexane') * 1000)
    .duration(60)
    .EUt(VA[MV])
    .buildAndRegister();

// Hydroquinone

BR.recipeBuilder()
    .notConsumable(fluid('sodium_hydroxide_solution') * 1000)
    .fluidInputs(fluid('air') * 20000)
    .fluidInputs(fluid('para_diisopropylbenzene') * 1000)
    .outputs(metaitem('dustParaDiisopropylbenzeneDihydroperoxide') * 34)
    .duration(10)
    .EUt(VA[LV])
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('sulfuric_acid') * 200)
    .inputs(ore('dustParaDiisopropylbenzeneDihydroperoxide') * 34)
    .fluidOutputs(fluid('cleaved_para_diisopropylbenzene_mixture') * 2200)
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister();

DT.recipeBuilder()
    .fluidInputs(fluid('cleaved_para_diisopropylbenzene_mixture') * 2200)
    .outputs(metaitem('dustHydroquinone') * 14)
    .fluidOutputs(fluid('sulfuric_acid') * 200)
    .fluidOutputs(fluid('acetone') * 2000)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister();

// Diphenyl Sulfone

CSTR.recipeBuilder()
    .fluidInputs(fluid('benzene') * 50)
    .fluidInputs(fluid('sulfuric_acid') * 50)
    .fluidOutputs(fluid('benzenesulfonic_acid') * 50)
    .fluidOutputs(fluid('water') * 50)
    .circuitMeta(2)
    .duration(5)
    .EUt(VA[MV])
    .buildAndRegister();

BR.recipeBuilder()
    .fluidInputs(fluid('benzenesulfonic_acid') * 1000)
    .fluidInputs(fluid('benzene') * 1000)
    .outputs(metaitem('dustDiphenylSulfone') * 25)
    .fluidOutputs(fluid('sulfuric_acid') * 1000)
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister();

// Polymerisation

POLYMERIZATION_TANK.recipeBuilder()
    .notConsumable(fluid('nitrogen') * 8000)
    .inputs(ore('dustSmallSodaAsh'))
    .inputs(ore('dustHydroquinone') * 14)
    .inputs(ore('dustFourFourDifluorobenzophenone'))
    .fluidInputs(fluid('diphenyl_sulfone') * 3600)
    .outputs(metaitem('dustPeekMixture') * 2)
    .fluidOutputs(fluid('carbon_dioxide') * 50)
    .duration(300)
    .EUt(VA[EV])
    .buildAndRegister();

MIXER.recipeBuilder()
    .inputs(ore('dustPeekMixture') * 2)
    .fluidInputs(fluid('acetone') * 1000)
    .outputs(metaitem('dustPolyetherEtherKetone'))
    .fluidOutputs(fluid('diphenyl_sulfone_solution') * 1000)
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister();

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('diphenyl_sulfone_solution') * 1000)
    .outputs(metaitem('dustDiphenylSulfone') * 25)
    .fluidOutputs(fluid('acetone') * 1000)
    .duration(60)
    .EUt(VA[LV])
    .buildAndRegister();
