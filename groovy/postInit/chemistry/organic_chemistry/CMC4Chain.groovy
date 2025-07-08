import globals.Globals

// CMC4 (p-Chloromethyl-Methoxy-Calix[4]arene) Chain (for EUV Photoresist)

BLENDER = recipemap('blender')
BR = recipemap('batch_reactor')
DT = recipemap('distillation_tower')
FLUID_HEATER = recipemap('fluid_heater')
LCR = recipemap('large_chemical_reactor')
POLYMERIZATION = recipemap('polymerization_tank')
VACUUM_CHAMBER = recipemap('vacuum_chamber')
VACUUM_DT = recipemap('vacuum_distillation')

// Table of Contents
/// A Calix[4]arene
/// B 25,26,27,28-Tetramethoxycalix[4]arene
/// C CMC4
/// D Photoresist Preparation
/// References

/// A Calix[4]arene
// Based on [1], unless otherwise stated

// 1 Formaldehyde + 1000L (NC) Sodium Hydroxide Solution = 1 Paraformaldehyde
// from wikipedia
POLYMERIZATION.recipeBuilder()
    .fluidInputs(fluid('formaldehyde') * 1000)
    .notConsumable(fluid('sodium_hydroxide_solution') * 1000)
    .fluidOutputs(fluid('paraformaldehyde') * 1000)
    .EUt(Globals.voltAmps[3])
    .duration(200)
    .buildAndRegister();

// 1 tert-Butyl Alcohol + 1 Potassium = 1 Potassium tert-Butoxide + 1 Hydrogen
// from wikipedia
BR.recipeBuilder()
    .inputs(ore('dustPotassium') * 1)
    .fluidInputs(fluid('tert_butyl_alcohol') * 1000)
    .fluidOutputs(fluid('potassium_tert_butylate') * 1000)
    .fluidOutputs(fluid('hydrogen') * 1000)
    .EUt(Globals.voltAmps[1])
    .duration(100)
    .buildAndRegister();

// 4 Phenol + 4 Paraformaldehyde =[Potassium tert-Butoxide in Tetralin]=> 8kL Calix[4]arene Precipitated Tetralin Solution [LCR]
LCR.recipeBuilder()
    .fluidInputs(fluid('phenol') * 4000)
    .fluidInputs(fluid('paraformaldehyde') * 4000)
    .fluidInputs(fluid('potassium_tert_butylate') * 1000)
    .fluidInputs(fluid('tetralin') * 8000)
    .fluidOutputs(fluid('potassium_hydroxide_solution') * 1000)
    .fluidOutputs(fluid('water') * 2000)
    .fluidOutputs(fluid('calix_four_arene_precipitated_solution') * 8000)
    .EUt(Globals.voltAmps[4])
    .duration(800)
    .buildAndRegister();

// 8kL Calix[4]arene Precipitated Tetralin Solution = 1 Crude Calix[4]arene + 8kL Calix[4]arene Reaction Waste [suction filtration]
VACUUM_CHAMBER.recipeBuilder()
    .fluidInputs(fluid('calix_four_arene_precipitated_solution') * 8000)
    .outputs(ore('dustCrudeCalixFourArene').first() * 56)
    .fluidOutputs(fluid('calix_four_arene_waste') * 8000)
    .EUt(Globals.voltAmps[3])
    .duration(1000)
    .buildAndRegister();

// 1 Crude Calix[4]arene + 1kL Pyridine = 1kL Filtered Calix[4]arene Pyridine Solution [filter]
MIXER.recipeBuilder()
    .inputs(ore('dustCrudeCalixFourArene') * 56)
    .notConsumable(metaitem('item_filter') * 1)
    .fluidInputs(fluid('pyridine') * 1000)
    .fluidOutputs(fluid('filtered_calix_four_arene_solution') * 1000)
    .EUt(Globals.voltAmps[3])
    .duration(200)
    .buildAndRegister();

// 1kL Filtered Calix[4]arene Pyridine Solution + 1 Hydrochloric Acid + 1kL Distilled Water = 1 Calix[4]arene  1 Pyridinium Chloride + 2kL Water
VACUUM_CHAMBER.recipeBuilder()
    .fluidInputs(fluid('filtered_calix_four_arene_solution') * 1000)
    .fluidInputs(fluid('diluted_hydrochloric_acid') * 2000)
    .chancedOutput(ore('dustCalixFourArene').first() * 56, 9000, 0)
    .outputs(ore('dustPyridiniumChloride').first() * 13)
    .fluidOutputs(fluid('acidic_wastewater') * 2000)
    .EUt(Globals.voltAmps[3])
    .duration(1000)
    .buildAndRegister();

// recycle
DT.recipeBuilder()
    .fluidInputs(fluid('calix_four_arene_waste') * 1000)
    .fluidOutputs(fluid('tetralin') * 900) // 1000L, lossy
    .fluidOutputs(fluid('tert_butyl_alcohol') * 125) // 1kL per 8kL
    .EUt(Globals.voltAmps[3])
    .duration(200)
    .buildAndRegister();


/// B 25,26,27,28-Tetramethoxycalix[4]arene
// Based on [2]

// 1 Calix[4]arene + 8kL Tetrahydrofuran + 2 Dimethylformamide + 4 NaH + 6kL Iodomethane = 16kL 25,26,27,28-Tetramethoxycalix[4]arene Reaction Mixture [LCR/furnace]
LCR.recipeBuilder()
    .inputs(ore('dustCalixFourArene') * 56)
    .inputs(ore('dustSodiumHydride') * 8)
    .fluidInputs(fluid('dimethylformamide') * 2000)
    .fluidInputs(fluid('iodomethane') * 4000)
    .fluidInputs(fluid('tetrahydrofuran') * 8000)
    .outputs(ore('dustCrudeTetramethoxycalixFourArene').first() * 68)
    .outputs(ore('dustSodiumIodide').first() * 8)
    .fluidOutputs(fluid('hydrogen') * 8000)
    .fluidOutputs(fluid('dmf_thf_mix') * 9000)
    .EUt(Globals.voltAmps[5])
    .duration(800)
    .buildAndRegister();

// DMF/THF mix recycle
VACUUM_DT.recipeBuilder()
    .fluidInputs(fluid('dmf_thf_mix') * 1000)
    .fluidOutputs(fluid('dimethylformamide') * 200)
    .fluidOutputs(fluid('tetrahydrofuran') * 800)
    .EUt(Globals.voltAmps[3])
    .duration(100)
    .buildAndRegister();

// 1 Rough 25,26,27,28-Tetramethoxycalix[4]arene + 1kL Chloromethane + 1kL Distilled Water = 1kL Wastewater + 1kL 25,26,27,28-Tetramethoxycalix[4]arene Cholormethane Extract [phase sep]
// should be mixer settler
MIXER.recipeBuilder()
    .inputs(ore('dustCrudeTetramethoxycalixFourArene') * 68)
    .fluidInputs(fluid('chloromethane') * 1000)
    .fluidInputs(fluid('distilled_water') * 1000)
    .fluidOutputs(fluid('wastewater') * 1000)
    .fluidOutputs(fluid('tetramethoxycalix_four_arene_extract') * 1000)
    .EUt(Globals.voltAmps[4])
    .duration(500)
    .buildAndRegister();

// 1kL 25,26,27,28-Tetramethoxycalix[4]arene Cholormethane Extract = 1 Crude 25,26,27,28-Tetramethoxycalix[4]arene [vacuum]
VACUUM_CHAMBER.recipeBuilder()
    .fluidInputs(fluid('tetramethoxycalix_four_arene_extract') * 1000)
    .chancedOutput(ore('dustTetramethoxycalixFourArene').first() * 68, 9000, 0)
    .fluidOutputs(fluid('chloromethane') * 900)
    .EUt(Globals.voltAmps[3])
    .duration(200)
    .buildAndRegister();

// n-Butanol recrystalize skipped

/// C CMC4
// Based on [3], unless otherwise specified

// 2 Ethylene glycol + 1000L Sulfuric Acid = 1 Dioxane + 1000L Diluted Surfuric Acid [BR]
// From wikipedia
BR.recipeBuilder()
    .fluidInputs(fluid('ethylene_glycol') * 2000)
    .fluidInputs(fluid('sulfuric_acid') * 1000)
    .fluidOutputs(fluid('dioxane') * 1000)
    .fluidOutputs(fluid('diluted_sulfuric_acid') * 1000)
    .EUt(Globals.voltAmps[2])
    .duration(100)
    .buildAndRegister();

// Rebalanced to ideal situation
// 4 Hydrochloric Acid + 4 Paraformaldehyde + 1 25,26,27,28-tetramethoxycalix[4]arene =[Dioxane with Acetic Acid and Phosphoric Acid]=> CMC4
BLENDER.recipeBuilder()
    .inputs(ore('dustTetramethoxycalixFourArene') * 68)
    .fluidInputs(fluid('paraformaldehyde') * 4000)
    .fluidInputs(fluid('hydrochloric_acid') * 4000)
    .fluidInputs(fluid('acetic_acid') * 1000)
    .fluidInputs(fluid('phosphoric_acid') * 1000)
    .fluidInputs(fluid('dioxane') * 8000)
    .fluidOutputs(fluid('cmc_four_reaction_mix') * 10000)
    .EUt(Globals.voltAmps[5])
    .duration(800)
    .buildAndRegister();

// Heating CMC4 Reaction Mixture [fluid heater]
FLUID_HEATER.recipeBuilder()
    .fluidInputs(fluid('cmc_four_reaction_mix') * 1000)
    .fluidOutputs(fluid('heated_cmc_four_reaction_mix') * 1000)
    .EUt(Globals.voltAmps[1])
    .duration(100)
    .buildAndRegister();

// Heated CMC4 Reaction Mixture = 1 Crude CMC4 + Reaction Waste [filter/phase-sep]
VACUUM_CHAMBER.recipeBuilder()
    .fluidInputs(fluid('heated_cmc_four_reaction_mix') * 10000)
    .outputs(ore('dustCrudeCmcFour').first() * 80)
    .fluidOutputs(fluid('cmc_four_waste') * 9000)
    .EUt(Globals.voltAmps[3])
    .duration(100)
    .buildAndRegister();

// recycle
DT.recipeBuilder()
    .fluidInputs(fluid('cmc_four_waste') * 1000)
    .fluidOutputs(fluid('dioxane') * 800)
    .fluidOutputs(fluid('acidic_wastewater') * 200)
    .EUt(Globals.voltAmps[1])
    .duration(100)
    .buildAndRegister();

// 1 kmol Crude CMC4 phase separate with chloroform and water = Crude CMC4 Chloroform Solution + Acidic Waste Water
// Later switch to mixer settler
MIXER.recipeBuilder()
    .inputs(ore('dustCrudeCmcFour') * 80)
    .fluidInputs(fluid('chloromethane') * 1000)
    .fluidInputs(fluid('distilled_water') * 4000)
    .fluidOutputs(fluid('acidic_wastewater') * 4000)
    .fluidOutputs(fluid('cmc_four_extract') * 1000)
    .EUt(Globals.voltAmps[4])
    .duration(400)
    .buildAndRegister();

// Crude CMC4 Chloroform Solution ==[Magnesium Sulfate]=> CMC4 Chloroform Solution
// CMC4 Chloroform Solution = 1 CMC4 + Chloroform [vacuum-extract]
VACUUM_CHAMBER.recipeBuilder()
    .fluidInputs(fluid('cmc_four_extract') * 1000)
    .notConsumable(ore('dustMagnesiumSulfate'))
    .fluidOutputs(fluid('chloromethane') * 900)
    .chancedOutput(ore('dustCmcFour').first() * 80, 6000, 500)
    .EUt(Globals.voltAmps[1])
    .duration(1000)
    .buildAndRegister();

/// D Photoresist Preparation
// Production of PAGMA is from [4],
// Photoresist composition is from [5], would be nice if we know composition of TEBN-1 
// 1 Titanium Dioxide + 1 Sulfuric Acid = 1 Sulfated Titania + 1 H2
BR.recipeBuilder()
    .inputs(ore('dustTitaniumDioxide') * 3)
    .fluidInputs(fluid('sulfuric_acid') * 1000)
    .outputs(ore('dustSulfatedTitania').first() * 7)
    .fluidOutputs(fluid('hydrogen') * 2000)
    .EUt(Globals.voltAmps[3])
    .duration(200)
    .buildAndRegister();

// 1 Propylene Oxide + 1 Methanol ==[Sodium Methoxide]=> 1 1-Methoxy-2-propanol [BR]
BR.recipeBuilder()
    .fluidInputs(fluid('propylene_oxide') * 1000)
    .fluidInputs(fluid('methanol') * 1000)
    .notConsumable(ore('dustSodiumMethoxide') * 6)
    .fluidOutputs(fluid('propylene_glycol_methyl_ether') * 1000)
    .EUt(Globals.voltAmps[3])
    .duration(200)
    .buildAndRegister();

// 1 1-Methoxy-2-Propanol + 1 Acetic Acid + ==[Sulfated Titania]=> 1kL 1-Methoxy-2-Propanol Acetate
LCR.recipeBuilder()
    .inputs(ore('dustSulfatedTitania') * 7)
    .fluidInputs(fluid('propylene_glycol_methyl_ether') * 1000)
    .fluidInputs(fluid('acetic_acid') * 1000)
    .fluidOutputs(fluid('pgmea_catalytic_solution') * 2000)
    .EUt(Globals.voltAmps[4])
    .duration(200)
    .buildAndRegister();

// distill products
DT.recipeBuilder()
    .fluidInputs(fluid('pgmea_catalytic_solution') * 1000)
    .outputs(ore('dustSulfatedTitania').first() * 7)
    .fluidOutputs(fluid('water') * 1000)
    .fluidOutputs(fluid('pgmea') * 1000)
    .EUt(Globals.voltAmps[4])
    .duration(500)
    .buildAndRegister();

MIXER.recipeBuilder()
    .inputs(ore('dustCmcFour') * 80)
    .fluidInputs(fluid('pgmea') * 8000)
    .fluidOutputs(fluid('cmc_four_photoresist') * 8000)
    .EUt(Globals.voltAmps[3])
    .duration(500)
    .buildAndRegister();

/*
References:
[1] T. B. Patrick and P. A. Egan, "An improved preparation of phenolic [1.1.1.1]metacyclophanes," J. Org. Chem., vol. 42, no. 2, pp. 382, 1977.
[2] C. D. Gutsche, B. Dhawan, J. A. Levine, K. H. No, and L. J. Bauer, "Calixarenes 9: Conformational isomers of the ethers and esters of calix[4]arenes," Tetrahedron, vol. 39, no. 3, pp. 409–426, 1983.
[3] T. Nagasaki, K. Sisido, and T. Arimura, “Novel conformational isomerism of water-soluble calix[4]arenes,” Tetrahedron, vol. 59, no. 7, pp. 409-426, 2003. doi:10.1016/S0040‑4020(01)88184‑9
[4] Y. R. Son, J. K. Park, E. W. Shin, S. P. Moon, and H. E. Park, “Synthesis of propylene glycol methyl ether acetate: Reaction kinetics and process simulation using heterogeneous catalyst,” Processes, vol. 12, no. 5, p. 865, 2024. doi:10.3390/pr12050865
https://www.mdpi.com/2227-9717/12/5/865
[5] M. Ishida, J. Fujita, T. Ogura, Y. Ochiai, E. Ohshima, and J. Momoda, “Sub-10-nm-scale lithography using p-Chloromethyl-Methoxy-Calix[4]arene resist,” Jpn. J. Appl. Phys., vol. 42, no. 6S, pp. 3913–3916, 2003. doi:10.1143/JJAP.42.3913
*/