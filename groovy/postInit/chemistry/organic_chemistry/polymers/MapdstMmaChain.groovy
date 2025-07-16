import globals.Globals

// MAPDST-MMA Copolymer Chain (for EUV Photoresist)

BLENDER = recipemap('blender')
BR = recipemap('batch_reactor')
CRYSTALLIZER = recipemap('crystallizer')
COMPRESSOR = recipemap('compressor')
CHEMICAL_BATH = recipemap('chemical_bath')
CSTR = recipemap('continuous_stirred_tank_reactor')
DT = recipemap('distillation_tower')
DRYER = recipemap('dryer')
ELECTROLYTIC_CELL = recipemap('electrolytic_cell')
LCR = recipemap('large_chemical_reactor')
MIXER = recipemap('mixer')
PHASE_SEPARATOR = recipemap('phase_separator')
POLYMERIZATION = recipemap('polymerization_tank')
VACUUM_CHAMBER = recipemap('vacuum_chamber')

// Table of Contents
/// A Preparation
/// B 4-(methylthio)phenyl Methacrylate
/// C Ruthenium Catalyst (for MAPDST)
/// D MAPDST
/// E MAPDST-MMA Copolymer
/// References

/// A Preparation
// 2 Methanol + 2 Hydrogen Sulfide + (NC) Al2O3 = 1 Dimethyl Sulfide + 2 Water
// From wikipedia, source [1]
BR.recipeBuilder()
    .fluidInputs(fluid('methanol') * 2000)
    .fluidInputs(fluid('hydrogen_sulfide') * 2000)
    .notConsumable(ore('dustAlumina') * 5)
    .fluidOutputs(fluid('dimethyl_sulfide') * 1000)
    .fluidOutputs(fluid('water') * 2000)
    .EUt(Globals.voltAmps[2])
    .duration(80)
    .buildAndRegister()

// 1 Methacrylic Acid + 1 Thionyl Chloride + (NC) LiCl = 1 Chlorosulfanic acid + 1 Methacryloyl Chloride [CSTR]
// Based on [2]
CSTR.recipeBuilder()
    .fluidInputs(fluid('methacrylic_acid') * 1000)
    .fluidInputs(fluid('thionyl_chloride') * 1000)
    .notConsumable(ore('dustLithiumChloride') * 2)
    .fluidOutputs(fluid('chlorosulfanic_acid') * 1000)
    .fluidOutputs(fluid('methacryloyl_chloride') * 1000)
    .EUt(Globals.voltAmps[2])
    .duration(80)
    .buildAndRegister()

// Chlorosulfanic acid can be oxided [7] to chlorosulfuric for recycle,
// but H2O2 decomposes into water, resulting hydrolysis of chlorosulfuric acid, which is later distilled.
LCR.recipeBuilder()
    .fluidInputs(fluid('chlorosulfanic_acid') * 1000)
    .fluidInputs(fluid('hydrogen_peroxide') * 1000)
    .fluidOutputs(fluid('hydrolyzed_chlorosulfuric_acid') * 2000)
    .EUt(Globals.voltAmps[3])
    .duration(80)
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('hydrolyzed_chlorosulfuric_acid') * 200)
    .fluidOutputs(fluid('sulfuric_acid') * 100)
    .fluidOutputs(fluid('hydrochloric_acid') * 100)
    .EUt(Globals.voltAmps[2])
    .duration(10)
    .buildAndRegister()

// 1 Dimethyl Sulfide + 1 Phenol + (NC) Aluminum Phenoxide = 1 2/4-(Methylthio)phenol Mixture [BR]
// Recipe based on [3]
BR.recipeBuilder()
    .fluidInputs(fluid('dimethyl_sulfide') * 1000)
    .fluidInputs(fluid('phenol') * 1000)
    .notConsumable(ore('dustAluminiumPhenolate')) // = aluminium phenoxide
    .fluidOutputs(fluid('two_four_methylthio_phenol_mixture') * 1000)
    .EUt(Globals.voltAmps[2])
    .duration(80)
    .buildAndRegister()

// 1 2/4-(Methylthio)phenol Mixture = 0.4 4-(Methylthio)phenol + 0.6 2-(Methylthio)phenol [distill]
// [3] suggests that it is 17:7:3:1 for 2-(Methylthio)phenol : 4-(Methylthio)phenol : two other bis(Methylthio)phenol
DT.recipeBuilder()
    .fluidInputs(fluid('two_four_methylthio_phenol_mixture') * 1000)
    .fluidOutputs(fluid('two_methylthio_phenol') * 600)
    .fluidOutputs(fluid('four_methylthio_phenol') * 400) // should be 250 IRL 
    .EUt(Globals.voltAmps[3])
    .duration(100)
    .buildAndRegister()

// 2-(Methylthio)phenol for pesticide, not used in the chain 
// Recipe in GreenhouseChain.groovy

// All following recipes follows wikipedia (which has the citation)
// 1 Chlorosulfuric Acid + 1 Ethanol = 1 Ethyl Sulfate + 1 HCl 
BR.recipeBuilder()
    .fluidInputs(fluid('chlorosulfuric_acid') * 1000)
    .fluidInputs(fluid('ethanol') * 1000)
    .fluidOutputs(fluid('acidic_ethyl_sulfate') * 1000)
    .EUt(Globals.voltAmps[3])
    .duration(20)
    .buildAndRegister()

// Ethyl Sulfate + HCl separation
DT.recipeBuilder()
    .fluidInputs(fluid('acidic_ethyl_sulfate') * 1000)
    .fluidOutputs(fluid('ethyl_sulfate') * 1000)
    .fluidOutputs(fluid('hydrogen_chloride') * 1000)
    .EUt(Globals.voltAmps[2])
    .duration(40)
    .buildAndRegister()

// 2 Ethyl Sulfate + 1 Sodium Sulfate = 1 Diethyl Sulfate + 2 Sodium Bisulfate
BR.recipeBuilder()
    .fluidInputs(fluid('ethyl_sulfate') * 2000)
    .inputs(ore('dustSodiumSulfate') * 7)
    .fluidOutputs(fluid('diethyl_sulfate') * 1000)
    .outputs(ore('dustSodiumBisulfate').first() * 14)
    .EUt(Globals.voltAmps[2])
    .duration(60)
    .buildAndRegister()
    
// 1 Diisopropylamine + 1 Diethyl Sulfate = 1 DIPEA (N,N-Diisopropylethylamine) + 1 Ethyl Sulfate [BR]
BR.recipeBuilder()
    .fluidInputs(fluid('diisopropylamine') * 1000)
    .fluidInputs(fluid('diethyl_sulfate') * 1000)
    .fluidOutputs(fluid('diisopropylethylamine') * 1000)
    .fluidOutputs(fluid('ethyl_sulfate') * 1000)
    .EUt(Globals.voltAmps[2])
    .duration(60)
    .buildAndRegister()
    
// 1 Methanesulfonic Acid + 4 Hydrogen Fluoride = 1 Trifluoromethanesulfonic Acid + 1 Water + 3 Hydrogen [eletrolysis (electrofluorination)]
ELECTROLYTIC_CELL.recipeBuilder()
    .fluidInputs(fluid('methanesulfonic_acid') * 1000)
    .fluidInputs(fluid('hydrogen_fluoride') * 4000)
    .fluidOutputs(fluid('trifluoromethanesulfonic_acid') * 1000)
    .fluidOutputs(fluid('water') * 1000)
    .fluidOutputs(fluid('hydrogen') * 3000)
    .EUt(Globals.voltAmps[3])
    .duration(80)
    .buildAndRegister()

// 2 Trifluoromethanesulfonic Acid + 1 Silver (I) Oxide = 2 Silver Trifluoromethanesulfonate Solution
BR.recipeBuilder()
    .fluidInputs(fluid('trifluoromethanesulfonic_acid') * 2000)
    .fluidInputs(fluid('water') * 2000)
    .inputs(ore('dustSilverOxide') * 3)
    .fluidOutputs(fluid('silver_trifluoromethanesulfonate_solution') * 2000)
    .EUt(Globals.voltAmps[3])
    .duration(20)
    .buildAndRegister()

// 1 Silver Trifluoromethanesulfonate Solution = 1 Silver Trifluoromethanesulfonate + 1 Water [distillation]
DT.recipeBuilder()
    .fluidInputs(fluid('silver_trifluoromethanesulfonate_solution') * 1000)
    .outputs(ore('dustSilverTrifluoromethanesulfonate').first() * 9)
    .fluidOutputs(fluid('water') * 1000)
    .EUt(Globals.voltAmps[3])
    .duration(40)
    .buildAndRegister()
    
/// B 4-(methylthio)phenyl Methacrylate
// [4], see 4-(methylthio)phenyl methacrylate

// 1 Methacryloyl Chloride + 4-(Methylthio)phenol + 1 DIPEA (N,N-Diisopropylethylamine) + 5 Dichloromethane = 4-(methylthio)phenyl Methacrylate Reaction Mixture
BLENDER.recipeBuilder()
    .fluidInputs(fluid('methacryloyl_chloride') * 1000)
    .fluidInputs(fluid('four_methylthio_phenol') * 1000)
    .fluidInputs(fluid('diisopropylethylamine') * 1000)
    .fluidInputs(fluid('dichloromethane') * 5000)
    .fluidOutputs(fluid('four_methylthio_phenol_methacrylate_reaction_mixture') * 4000)
    .EUt(Globals.voltAmps[1])
    .duration(400)
    .buildAndRegister()

// 7 4-(methylthio)phenyl Methacrylate Reaction Mixture = 1 Impure 4-(methylthio)phenyl Methacrylate + 5 Dichloromethane [vaccum or rotary evaporation]
VACUUM_CHAMBER.recipeBuilder()
    .fluidInputs(fluid('four_methylthio_phenol_methacrylate_reaction_mixture') * 7000)
    .outputs(ore('dustCrudeFourMethylthioPhenylMethacrylate').first() * 52)
    .fluidOutputs(fluid('dichloromethane') * 4500) // intended lossy
    .EUt(Globals.voltAmps[1])
    .duration(200)
    .buildAndRegister()

// 1 Impure 4-(methylthio)phenyl Methacrylate + 5 Tetrahydrofuran = 1 Crude 4-(methylthio)phenyl Methacrylate Tetrahydrofuran + 1 DIPEA Hydrochloride [filtering]
// 1 Crude 4-(methylthio)phenyl Methacrylate Tetrahydrofuran = 1 kmol Crude 4-(methylthio)phenyl Methacrylate + 5kL Tetrahydrofuran [vaccum or rotary evaporation]
VACUUM_CHAMBER.recipeBuilder()
    .inputs(ore('dustCrudeFourMethylthioPhenylMethacrylate') * 52)
    .notConsumable(metaitem('item_filter'))
    .fluidInputs(fluid('tetrahydrofuran') * 5000)
    .chancedOutput(ore('dustFourMethylthioPhenylMethacrylate').first() * 26, 9000, 0)
    .outputs(ore('dustDiisopropylethylamineHydrochloride').first() * 26)
    .fluidOutputs(fluid('tetrahydrofuran') * 4500) // intended lossy
    .EUt(Globals.voltAmps[3])
    .duration(100)
    .buildAndRegister()


// 1kL HCl Washing skipped
// 1kL Water Washing skipped
// MgSO4 Drying skipped

/// C Ruthenium Catalyst (for MAPDST)
// See [5] 
// 1 Ruthenium + 3 Chlorine = 1 Ruthenium (III) Chloride
BR.recipeBuilder()
    .inputs(ore('dustAnyPurityRuthenium') * 1)
    .fluidInputs(fluid('chlorine') * 3000)
    .outputs(ore('dustRutheniumIiiChloride').first() * 4)
    .EUt(Globals.voltAmps[1])
    .duration(100)
    .buildAndRegister()

// 1 Ruthenium (III) Chloride + 20 Alumina + 1 Distilled Water = 1 Ruthenium Chloride Alumina Slurry [mixer]
BLENDER.recipeBuilder()
    .inputs(ore('dustAnyPurityRuthenium') * 4)
    .inputs(ore('dustAlumina') * 100)
    .fluidInputs(fluid('distilled_water') * 1000)
    .fluidInputs(fluid('sodium_hydroxide_solution') * 1000)
    .fluidOutputs(fluid('ruthenium_oxide_alumina_catalyst_solution') * 2000)
    .EUt(Globals.voltAmps[1])
    .duration(1000)
    .buildAndRegister()

// Ruthenium Oxide-Alumina Catalyst Solution = 1 Wet Ruthenium Oxide-Alumina Catalyst + 2 Waste Water [filteration]
VACUUM_CHAMBER.recipeBuilder()
    .notConsumable(metaitem('item_filter'))
    .fluidInputs(fluid('ruthenium_oxide_alumina_catalyst_solution') * 2000)
    .outputs(ore('dustRutheniumOxideAluminaCatalyst').first() * 102)
    .fluidOutputs(fluid('wastewater') * 2000)
    .EUt(Globals.voltAmps[1])
    .duration(500)
    .buildAndRegister()

/// D MAPDST
// [4], see Synthesis of dimethyl-(4-methacryloyloxy)phenylsulfonium triflate (PAGMA) 

//  1 Methanol + 1 Hydrogen Iodide = 1 Iodomethane + 1 Water
BR.recipeBuilder()
    .fluidInputs(fluid('methanol') * 1000)
    .fluidInputs(fluid('hydrogen_iodide') * 1000)
    .fluidOutputs(fluid('iodomethane') * 1000)
    .fluidOutputs(fluid('water') * 1000)
    .EUt(Globals.voltAmps[1])
    .duration(200)
    .buildAndRegister();

// 1 Ethylamine + 1 Oxygen + (NC) Ruthenium Oxide-Alumina Catalyst = 1 Acetonitrile + 1 Water [CSTR?]
// Divided by 20 for CSTR
CSTR.recipeBuilder()
    .fluidInputs(fluid('ethylamine') * 50)
    .fluidInputs(fluid('oxygen') * 50)
    .notConsumable(ore('dustRutheniumOxideAluminaCatalyst') * 6)
    .fluidOutputs(fluid('acetonitrile') * 50)
    .fluidOutputs(fluid('water') * 50)
    .EUt(Globals.voltAmps[1])
    .duration(4)
    .buildAndRegister();

// 1 Iodomethane + 1kL Acetonitrile = 1kL Iodomethane Acetonitrile 
// 1 4-(methylthio)phenyl Methacrylate + 1 Silver Trifluoromethanesulfonate + 5 Acetonitrile = 5kL 4-(methylthio)phenyl Methacrylate Silver Trifluoromethanesulfonate Acetonitrile Solution
// 1 Iodomethane Acetonitrile Solution + 5kL 4-(methylthio)phenyl Methacrylate Silver Trifluoromethanesulfonate Solution + 2kL Acetonitrile = 1 AgI + 8kL Crude MAPDST Acetonitrile Solution
LCR.recipeBuilder()
    .inputs(ore('dustFourMethylthioPhenylMethacrylate') * 26)
    .inputs(ore('dustSilverTrifluoromethanesulfonate') * 9)
    .fluidInputs(fluid('iodomethane') * 1000)
    .fluidInputs(fluid('acetonitrile') * 8000)
    .outputs(ore('dustSilverIodide').first() * 2)
    .fluidOutputs(fluid('crude_mapdst_acetonitrile_solution') * 8000)
    .EUt(Globals.voltAmps[4])
    .duration(100)
    .buildAndRegister();

// 8kL Crude MAPDST Acetonitrile Solution = 1 Crude MAPDST + 8kL Acetonitrile [vaccum or rotary evaporation]
VACUUM_CHAMBER.recipeBuilder()
    .fluidInputs(fluid('crude_mapdst_acetonitrile_solution') * 8000)
    .outputs(ore('dustCrudeMapdst').first() * 38)
    .fluidOutputs(fluid('acetonitrile') * 7200) // lossy
    .EUt(Globals.voltAmps[1])
    .duration(200)
    .buildAndRegister();

// 1 kmol Crude MAPDST + 1000L (NC) Hot Tetrahydrofuran = 1 kmol MAPDST [crystalizer]
// Normal tetrahydrofuran is used instead, no need for fluid bloat
CRYSTALLIZER.recipeBuilder()
    .inputs(ore('dustCrudeMapdst') * 38)
    .notConsumable(fluid('tetrahydrofuran') * 1000)
    .outputs(ore('dustMapdst').first() * 38)
    .EUt(Globals.voltAmps[2])
    .duration(50)
    .buildAndRegister();

/// E MAPDST-MMA Copolymer
// [6], See Procedure for the Synthesis of MAPDST-MMA Copolymer (VIa)

// 1 MAPDST (Dimethyl-(4-methacryloyloxy)phenylsulfonium Triflate) + 1 Methyl Methacrylate + 1 Azobisisobutyronitrile (AIBN) + 2 Tetrahydrofuran + 1 Acetonitrile = Rough MAPDST-MMA Copolymer Solution [polymerization tank]
POLYMERIZATION.recipeBuilder()
    .inputs(ore('dustMapdst') * 38)
    .inputs(ore('dustAzobisisobutyronitrile') * 1)
    .fluidInputs(fluid('methyl_methacrylate') * 1000)
    .fluidInputs(fluid('tetrahydrofuran') * 2000)
    .fluidInputs(fluid('acetonitrile') * 1000)
    .fluidOutputs(fluid('crude_mapdst_mma_copolymer_solution') * 5000)
    .EUt(Globals.voltAmps[5])
    .duration(1000) // this is meant to be the bottleneck of all, but even with this duration it is still 320L/s production rate.
    .buildAndRegister();

// Rough MAPDST-MMA Copolymer Solution + 1 Diethyl Ether = 1 Rough MAPDST-MMA Copolymer + 6 MAPDST-MMA Copolymerization Waste [phase separation]
VACUUM_CHAMBER.recipeBuilder()
    .fluidInputs(fluid('crude_mapdst_mma_copolymer_solution') * 5000)
    .fluidInputs(fluid('diethyl_ether') * 1000)
    .outputs(ore('dustCrudeMapdstMmaCopolymer').first() * 1)
    .fluidOutputs(fluid('mapdst_mma_copolymer_waste') * 6000)
    .EUt(Globals.voltAmps[2])
    .duration(100)
    .buildAndRegister();

// dichloromethane washing skipped

// 1 Crude MAPDST-MMA Copolymer + 1kL Methanol = 1kL Crude MAPDST-MMA Copolymer Solution [mixer]
// 1kL Crude MAPDST-MMA Copolymer Solution + 1kL Diethyl Ether = 1 MAPDST-MMA Copolymer + 2000L Diethyl Ether Methanol Mix 
VACUUM_CHAMBER.recipeBuilder()
    .inputs(ore('dustCrudeMapdstMmaCopolymer') * 1)
    .fluidInputs(fluid('methanol') * 1000)
    .fluidInputs(fluid('diethyl_ether') * 1000)
    .chancedOutput(ore('dustMapdstMmaCopolymer').first() * 1, 8000, 0)
    .fluidOutputs(fluid('diethyl_ether_methanol_mix') * 1800) // lossy
    .EUt(Globals.voltAmps[1])
    .duration(80)
    .buildAndRegister();

// Diethyl Ether Methanol Mix = 1 Diethyl Ether + 1 Methanol [distillation]
DT.recipeBuilder()
    .fluidInputs(fluid('diethyl_ether_methanol_mix') * 200)
    .fluidOutputs(fluid('diethyl_ether') * 100)
    .fluidOutputs(fluid('methanol') * 100)
    .EUt(Globals.voltAmps[2])
    .duration(10)
    .buildAndRegister();

MIXER.recipeBuilder()
    .inputs(ore('dustMapdstMmaCopolymer') * 1)
    .fluidInputs(fluid('methanol') * 16000)
    .fluidOutputs(fluid('mapdst_mma_photoresist') * 16000)
    .EUt(Globals.voltAmps[1])
    .duration(100)
    .buildAndRegister();

/* 
References
[1] Roy, K.-M. (15 June 2000). "Thiols and Organic Sulfides". Ullmann's Encyclopedia of Industrial Chemistry. p. 8.
[2] S. Kim, “How do I synthesize methacryloyl chloride?”, ResearchGate, 26-Jun-2017. [Online]. Available: https://www.researchgate.net/post/How-do-i-synthesize-methacryloyl-chloride. [Accessed: 26-Jun-2025].
[3] Paul F. Ranken, B. Gary Mckinnie, Alkylthiolation of Phenols, Available: https://www.thieme-connect.de/products/ejournals/abstract/10.1055/s-1984-30744. [Accessed: 26-Jun-2025].
[4] Andrew A. Brown, Omar Azzaroni, Luis M. Fidalgoa and Wilhelm T. S. Huck, Polymer brush resist for responsive wettability, Soft Matter, Available: https://pubs.rsc.org/en/content/articlelanding/2009/sm/b902179e. [Accessed: 26-Jun-2025].
[5] Emily C. Corker, Uffe V. Mentzel, Jerrik Mielby, Anders Riisagera and Rasmus Fehrmann, An alternative pathway for production of acetonitrile: ruthenium catalysed aerobic dehydrogenation of ethylamine, Green Chemistry, Available: https://pubs.rsc.org/en/content/articlelanding/2013/gc/c3gc36513a. [Accessed: 26-Jun-2025].
[6] V. S. V. Satyanarayana, Felipe Kessler, Vikram Singh, Francine R. Scheffer, Daniel E. Weibel, Subrata Ghosh, Kenneth E. Gonsalves, "Radiation-Sensitive Novel Polymeric Resist Materials: Iterative Synthesis and Their EUV Fragmentation Studies", ACS Applied Materials & Interfaces, 27-Feb-2014, Available: https://pubs.acs.org/doi/10.1021/am405905p. [Accessed: 26-Jun-2025].
[7] Chauvin, J.-P. R., & Pratt, D. A. (2016). On the Reactions of Thiols, Sulfenic Acids, and Sulfinic Acids with Hydrogen Peroxide. Angewandte Chemie, 129(22), 6351–6355. doi:10.1002/ange.201610402
*/