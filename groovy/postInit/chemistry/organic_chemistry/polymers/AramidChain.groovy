import static globals.Globals.*

BR = recipemap('batch_reactor')
LCR = recipemap('large_chemical_reactor')
FBR = recipemap('fixed_bed_reactor')
CSTR = recipemap('continuous_stirred_tank_reactor')
SIFTER = recipemap('sifter')
DISTILLATION_TOWER = recipemap('distillation_tower')
PHASE_SEPARATOR = recipemap('phase_separator')

// 4-nitroaniline

BR.recipeBuilder()
    .inputs(ore('dustFourChloronitrobenzene'))
    .fluidInputs(fluid('ammonia') * 2000)
    .fluidOutputs(fluid('four_nitroaniline_solution') * 1000)
    .outputs(metaitem('dustAmmoniumChloride') * 6)
    .duration(600)
    .EUt(120)
    .buildAndRegister()

// p-Phenylenediamine

BCR.recipeBuilder()
    .fluidInputs(fluid('four_nitroaniline_solution') * 50)
    .fluidInputs(fluid('hydrogen') * 300)
    .fluidOutputs(fluid('para_phenylenediamine_solution') * 150)
    .duration(200)
    .EUt(30)
    .buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
    .fluidInputs(fluid('para_phenylenediamine_solution') * 3000)
    .fluidOutputs(fluid('toluene') * 1000)
    .fluidOutputs(fluid('steam') * 2000)
    .outputs(metaitem('dustParaPhenylenediamine') * 16)
    .duration(200)
    .EUt(30)
    .buildAndRegister()

// Kevlar

CSTR.recipeBuilder()
    .fluidInputs(fluid('acetylene') * 50)
    .fluidInputs(fluid('formaldehyde') * 100)
    .fluidOutputs(fluid('butanediol') * 50)
    .EUt(120)
    .duration(4)
    .buildAndRegister()

FBR.recipeBuilder()
    .fluidInputs(fluid('butanediol') * 50)
    .notConsumable(metaitem('catalystBedCopper'))
    .fluidOutputs(fluid('gamma_butyrolactone') * 50)
    .fluidOutputs(fluid('hydrogen') * 200)
    .EUt(120)
    .duration(4)
    .buildAndRegister()

LCR.recipeBuilder()
    .notConsumable(metaitem('dustCalciumChloride') * 1)
    .inputs(ore('dustParaPhenylenediamine') * 16)
    .inputs(ore('dustTerephthaloylChloride') * 16)
    .notConsumable(fluid('n_methyl_ii_pyrrolidone') * 100)
    .fluidInputs(fluid('sulfuric_acid') * 500)
    .outputs(metaitem('dustKevlar') * 4)
    .fluidOutputs(fluid('hydrogen_chloride') * 1000)
    .EUt(1920)
    .duration(300)
    .buildAndRegister()

// m-Phenylenediamine

CSTR.recipeBuilder()
    .fluidInputs(fluid('nitrobenzene') * 50)
    .fluidInputs(fluid('nitration_mixture') * 100)
    .fluidOutputs(fluid('acidic_dinitrobenzene_mixture') * 100)
    .duration(10)
    .EUt(480)
    .buildAndRegister()

PHASE_SEPARATOR.recipeBuilder()
    .fluidInputs(fluid('acidic_dinitrobenzene_mixture') * 2000)
    .outputs(metaitem('dustDinitrobenzeneMixture'))
    .fluidOutputs(fluid('diluted_sulfuric_acid') * 2000)
    .duration(50)
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustDinitrobenzeneMixture'))
    .fluidInputs(fluid('sodium_hydroxide_solution') * 100)
    .chancedOutput(metaitem('dustOneThreeDinitrobenzene'), 8800, 0)
    .fluidOutputs(fluid('wastewater') * 100)
    .duration(200)
    .EUt(480)
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustOneThreeDinitrobenzene'))
    .fluidInputs(fluid('hydrogen') * 400)
    .notConsumable(ore('dustActivatedRaneyNickel') * 1)
    .outputs(metaitem('dustMetaPhenylenediamine') * 16)
    .duration(20)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

// Nomex

LCR.recipeBuilder()
    .inputs(ore('dustMetaPhenyleneDiamine') * 16)
    .inputs(ore('dustIsophthaloylChloride') * 16)
    .fluidInputs(fluid('dimethylacetamide') * 4000)
    .fluidOutputs(fluid('nomex_polymerization_mix') * 4000)
    .EUt(1920)
    .duration(300)
    .buildAndRegister()

SIFTER.recipeBuilder()
    .fluidInputs(fluid('nomex_polymerization_mix') * 4000)
    .outputs(metaitem('dustNomex') * 7)
    .fluidOutputs(fluid('dimethylacetamide') * 4000)
    .duration(300)
    .EUt(120)
    .buildAndRegister()