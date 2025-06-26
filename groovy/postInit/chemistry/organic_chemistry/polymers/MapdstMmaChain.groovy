import globals.Globals

// MAPDST-MMA Copolymer Chain (for EUV Photoresist)

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

// TOC
/// A Preparation
/// B 4-(methylthio)phenyl Methacrylate
/// C Ruthenium Catalyst (for MAPDST)
/// D MAPDST
/// E MAPDST-MMA Copolymer

/// A Preparation
// 2 Methanol + 2 Hydrogen Sulfide + (NC) Al2O3 = 1 Dimethyl Sulfide + 2 Water
BR.recipeBuilder()
    .fluidInputs(fluid('methanol') * 2000)
    .fluidInputs(fluid('hydrogen_sulfide') * 2000)
    .notConsumable(ore('dustAlumina') * 5)
    .fluidOutputs(fluid('dimethyl_sulfide') * 1000)
    .fluidOutputs(fluid('water') * 2000)
    .EUt(Globals.voltAmps[3])
    .duration(100)
    .buildAndRegister()

// 1 Methacrylic Acid + 1 Thionyl Chloride + (NC) LiCl = 1 Chlorosulfanic acid + 1 Methacryloyl Chloride [CSTR]
CSTR.recipeBuilder()
    .fluidInputs(fluid('methacrylic_acid') * 1000)
    .fluidInputs(fluid('thionyl_chloride') * 1000)
    .notConsumable(ore('dustLithiumChloride') * 2)
    .fluidOutputs(fluid('chlorosulfanic_acid') * 1000)
    .fluidOutputs(fluid('methacryloyl_chloride') * 1000)
    .EUt(Globals.voltAmps[3])
    .duration(200)
    .buildAndRegister()

// 1 Dimethyl Sulfide + 1 Phenol + (NC) Aluminum Phenoxide = 1 2/4-(Methylthio)phenol Mixture [BR]
// Aluminium phenoxide is aluminium phenolate
BR.recipeBuilder()
    .fluidInputs(fluid('dimethyl_sulfide') * 1000)
    .fluidInputs(fluid('phenol') * 1000)
    .notConsumable(ore('dustAluminiumPhenolate'))
    .fluidOutputs(fluid('two_four_methylthio_phenol_mixture') * 1000)
    .EUt(Globals.voltAmps[3])
    .duration(100)
    .buildAndRegister()

// 1 2/4-(Methylthio)phenol Mixture = 0.6 4-(Methylthio)phenol + 0.4 2-(Methylthio)phenol [distill]
DT.recipeBuilder()
    .fluidInputs(fluid('two_four_methylthio_phenol_mixture') * 1000)
    .fluidOutputs(fluid('two_methylthio_phenol') * 400)
    .fluidOutputs(fluid('four_methylthio_phenol') * 600)
    .EUt(Globals.voltAmps[4])
    .duration(200)
    .buildAndRegister()

// from wikipedia, need more info
// 1 Chlorosulfuric Acid + 1 Ethanol = 1 Ethyl Sulfate + 1 HCl 
BR.recipeBuilder()
    .fluidInputs(fluid('chlorosulfuric_acid') * 1000)
    .fluidInputs(fluid('ethanol') * 1000)
    .fluidOutputs(fluid('ethyl_sulfate') * 1000)
    .fluidOutputs(fluid('hydrochloric_acid') * 1000)
    .EUt(Globals.voltAmps[3])
    .duration(150)
    .buildAndRegister()

// from wikipedia, need more info
// 2 Ethyl Sulfate + 1 Sodium Sulfate = 1 Diethyl Sulfate + 2 Sodium Bisulfate
BR.recipeBuilder()
    .fluidInputs(fluid('ethyl_sulfate') * 2000)
    .inputs(ore('dustSodiumSulfate') * 7)
    .fluidOutputs(fluid('diethyl_sulfate') * 1000)
    .outputs(ore('dustSodiumBisulfate').first() * 14)
    .EUt(Globals.voltAmps[3])
    .duration(200)
    .buildAndRegister()
    
// 1 Diisopropylamine + 1 Diethyl Sulfate = 1 DIPEA (N,N-Diisopropylethylamine) + 1 Ethyl Sulfate [BR]
BR.recipeBuilder()
    .fluidInputs(fluid('diisopropylamine') * 1000)
    .fluidInputs(fluid('diethyl_sulfate') * 1000)
    .fluidOutputs(fluid('diisopropylethylamine') * 1000)
    .fluidOutputs(fluid('ethyl_sulfate') * 1000)
    .EUt(Globals.voltAmps[3])
    .duration(100)
    .buildAndRegister()
    
// 1 Methanesulfonic Acid + 4 Hydrogen Fluoride = 1 Trifluoromethanesulfonic Acid + 1 Water + 3 Hydrogen [eletrolysis (electrofluorination)]
ELECTROLYTIC_CELL.recipeBuilder()
    .fluidInputs(fluid('methanesulfonic_acid') * 1000)
    .fluidInputs(fluid('hydrogen_fluoride') * 4000)
    .fluidOutputs(fluid('trifluoromethanesulfonic_acid') * 1000)
    .fluidOutputs(fluid('water') * 1000)
    .fluidOutputs(fluid('hydrogen') * 3000)
    .EUt(Globals.voltAmps[3])
    .duration(100)
    .buildAndRegister()

// 2 Trifluoromethanesulfonic Acid + 1 Silver (I) Oxide = 2 Silver Trifluoromethanesulfonate Solution
// Divided by 4 for CSTR recipe
CSTR.recipeBuilder()
    .fluidInputs(fluid('trifluoromethanesulfonic_acid') * 500)
    .fluidInputs(fluid('water') * 500)
    .inputs(ore('dustSmallSilverOxide') * 3)
    .fluidOutputs(fluid('silver_trifluoromethanesulfonate_solution') * 2000)
    .EUt(Globals.voltAmps[3])
    .duration(20)
    .buildAndRegister()

// 1 Silver Trifluoromethanesulfonate Solution = 1 Silver Trifluoromethanesulfonate + 1 Water [distillation]
DT.recipeBuilder()
    .fluidInputs(fluid('silver_trifluoromethanesulfonate_solution') * 1000)
    .outputs(ore('dustSilverTrifluoromethanesulfonate').first() * 9)
    .fluidOutputs(fluid('water') * 1000)
    .EUt(Globals.voltAmps[4])
    .duration(100)
    .buildAndRegister()
    
/// B 4-(methylthio)phenyl Methacrylate

// 1 Methacryloyl Chloride + 3 Dichloromethane = 4 Methacryloyl Chloride Dichloromethane [mixer]
MIXER.recipeBuilder()
    .fluidInputs(fluid('methacryloyl_chloride') * 1000)
    .fluidInputs(fluid('dichloromethane') * 3000)
    .fluidOutputs(fluid('methacryloyl_chloride_dichloromethane') * 4000)
    .EUt(Globals.voltAmps[2])
    .duration(100)
    .buildAndRegister()

// 1 4-(Methylthio)phenol + 1 DIPEA (N,N-Diisopropylethylamine) + 2 Dichloromethane = 3 4-(Methylthio)phenol DIPEA Dichloromethane [mixer]
MIXER.recipeBuilder()
    .fluidInputs(fluid('four_methylthio_phenol') * 1000)
    .fluidInputs(fluid('diisopropylethylamine') * 1000)
    .fluidInputs(fluid('dichloromethane') * 2000)
    .fluidOutputs(fluid('four_methylthio_phenol_diisopropylethylamine_dichloromethane') * 3000)
    .EUt(Globals.voltAmps[3])
    .duration(100)
    .buildAndRegister()

// 4 Methacryloyl Chloride Dichloromethane + 3 4-(Methylthio)phenol DIPEA Dichloromethane = 7 4-(methylthio)phenyl Methacrylate Reaction Mixture [CSTR]
// Divided by 50 for CSTR
CSTR.recipeBuilder()
    .fluidInputs(fluid('methacryloyl_chloride_dichloromethane') * 80)
    .fluidInputs(fluid('four_methylthio_phenol_diisopropylethylamine_dichloromethane') * 60)
    .fluidOutputs(fluid('four_methylthio_phenol_methacrylate_reaction_mixture') * 140)
    .EUt(Globals.voltAmps[3])
    .duration(4)
    .buildAndRegister()

// 7 4-(methylthio)phenyl Methacrylate Reaction Mixture = 1 Impure 4-(methylthio)phenyl Methacrylate + 5 Dichloromethane [vaccum or rotary evaporation]
VACUUM_CHAMBER.recipeBuilder()
    .fluidInputs(fluid('four_methylthio_phenol_methacrylate_reaction_mixture') * 7000)
    .outputs(ore('dustImpureFourMethylthioPhenylMethacrylate').first() * 26)
    .fluidOutputs(fluid('dichloromethane') * 4500) // intended lossy
    .EUt(Globals.voltAmps[3])
    .duration(100)
    .buildAndRegister()

// 1 Impure 4-(methylthio)phenyl Methacrylate + 5 Tetrahydrofuran = 1 Crude 4-(methylthio)phenyl Methacrylate Tetrahydrofuran + 1 DIPEA Hydrochloride [filtering]
VACUUM_CHAMBER.recipeBuilder()
    .inputs(ore('dustImpureFourMethylthioPhenylMethacrylate') * 26)
    .notConsumable(metaitem('item_filter'))
    .fluidInputs(fluid('tetrahydrofuran') * 5000)
    .outputs(ore('dustDiisopropylethylamineHydrochloride').first() * 26)
    .fluidOutputs(fluid('crude_four_methylthio_phenyl_methacrylate_tetrahydrofuran') * 5000)
    .EUt(Globals.voltAmps[4])
    .duration(100)
    .buildAndRegister()

// 1 Crude 4-(methylthio)phenyl Methacrylate Tetrahydrofuran = 1 kmol Crude 4-(methylthio)phenyl Methacrylate + 5000L Tetrahydrofuran [vaccum or rotary evaporation]
VACUUM_CHAMBER.recipeBuilder()
    .fluidInputs(fluid('crude_four_methylthio_phenyl_methacrylate_tetrahydrofuran') * 5000)
    .outputs(ore('dustCrudeFourMethylthioPhenylMethacrylate').first() * 26)
    .fluidOutputs(fluid('tetrahydrofuran') * 4800) // intended lossy
    .EUt(Globals.voltAmps[4])
    .duration(100)
    .buildAndRegister()

// 1 kmol Crude 4-(methylthio)phenyl Methacrylate + 2500L Dichloromethane = 2500L Crude 4-(methylthio)phenyl Methacrylate Dichloromethane Solution [mixer]
MIXER.recipeBuilder()
    .inputs(ore('dustCrudeFourMethylthioPhenylMethacrylate') * 26)
    .fluidInputs(fluid('dichloromethane') * 2500)
    .fluidOutputs(fluid('crude_four_methylthio_phenyl_methacrylate_dichloromethane') * 2500)
    .EUt(Globals.voltAmps[2])
    .duration(100)
    .buildAndRegister()

// 1 Crude 4-(methylthio)phenyl Methacrylate Dichloromethane + 1 HCl = 1 HCl Washed 4-(methylthio)phenyl Methacrylate Dichloromethane + ???
PHASE_SEPARATOR.recipeBuilder()
    .fluidInputs(fluid('crude_four_methylthio_phenyl_methacrylate_dichloromethane') * 2500)
    .fluidInputs(fluid('hydrochloric_acid') * 1000)
    .fluidOutputs(fluid('acid_washed_crude_four_methylthio_phenyl_methacrylate_dichloromethane') * 2500)
    .fluidOutputs(fluid('diluted_hydrochloric_acid') * 1000)
    .EUt(Globals.voltAmps[3])
    .duration(100)
    .buildAndRegister()

// HCl Washed 4-(methylthio)phenyl Methacrylate Dichloromethane + 1 H2O = Water Washed 4-(methylthio)phenyl Methacrylate Dichloromethane + ??? [isolation]
PHASE_SEPARATOR.recipeBuilder()
    .fluidInputs(fluid('acid_washed_crude_four_methylthio_phenyl_methacrylate_dichloromethane') * 2500)
    .fluidInputs(fluid('distilled_water') * 1000)
    .fluidOutputs(fluid('water_washed_crude_four_methylthio_phenyl_methacrylate_dichloromethane') * 2500)
    .fluidOutputs(fluid('acidic_wastewater') * 1000)
    .EUt(Globals.voltAmps[3])
    .duration(100)
    .buildAndRegister()

// MgSO4 Drying skipped
// Water Washed 4-(methylthio)phenyl Methacrylate Dichloromethane = 4-(methylthio)phenyl Methacrylate + 2500L Dichloromethane [vaccum or rotary evaporation]
VACUUM_CHAMBER.recipeBuilder()
    .fluidInputs(fluid('water_washed_crude_four_methylthio_phenyl_methacrylate_dichloromethane') * 2500)
    .fluidOutputs(fluid('dichloromethane') * 2400) // intended lossy
    .chancedOutput(ore('dustFourMethylthioPhenylMethacrylate').first() * 26, 9000, 0)
    .EUt(Globals.voltAmps[5])
    .duration(100)
    .buildAndRegister()

/// C Ruthenium Catalyst (for MAPDST)
// 1 Ruthenium + 3 Chlorine = 1 Ruthenium (III) Chloride
BR.recipeBuilder()
    .inputs(ore('dustAnyPurityRuthenium') * 1)
    .fluidInputs(fluid('chlorine') * 3000)
    .fluidOutputs(fluid('dichloromethane') * 2400) 
    .outputs(ore('dustRutheniumIiiChloride').first() * 4)
    .EUt(Globals.voltAmps[1])
    .duration(100)
    .buildAndRegister()

// 1 Ruthenium (III) Chloride + 20 Alumina + 1 Distilled Water = 1 Ruthenium Chloride Alumina Slurry [mixer]
MIXER.recipeBuilder()
    .inputs(ore('dustAnyPurityRuthenium') * 4)
    .inputs(ore('dustAlumina') * 100)
    .fluidInputs(fluid('distilled_water') * 1000)
    .fluidOutputs(fluid('ruthenium_chloride_alumina_slurry') * 1000) 
    .EUt(Globals.voltAmps[4])
    .duration(2000)
    .buildAndRegister()

// 1 Ruthenium Chloride-Alumina Slurry + 1 Sodium Hydroxide Solution = Ruthenium Oxide-Alumina Catalyst Solution [mixer]
MIXER.recipeBuilder()
    .fluidInputs(fluid('ruthenium_chloride_alumina_slurry') * 1000)
    .fluidInputs(fluid('sodium_hydroxide_solution') * 1000)
    .fluidOutputs(fluid('ruthenium_oxide_alumina_catalyst_solution') * 2000) 
    .EUt(Globals.voltAmps[4])
    .duration(100)
    .buildAndRegister()

// Ruthenium Oxide-Alumina Catalyst Solution = 1 Wet Ruthenium Oxide-Alumina Catalyst + 2 Waste Water [filteration]
COMPRESSOR.recipeBuilder()
    .notConsumable(metaitem('item_filter'))
    .fluidInputs(fluid('ruthenium_oxide_alumina_catalyst_solution') * 2000)
    .outputs(ore('dustWetRutheniumOxideAluminaCatalyst').first() * 102)
    .fluidOutputs(fluid('wastewater') * 2000)
    .EUt(Globals.voltAmps[4])
    .duration(1000)
    .buildAndRegister()
    
// 1 Wet Ruthenium Oxide-Alumina Catalyst = 1 Ruthenium Oxide-Alumina Catalyst [dryer]
DRYER.recipeBuilder()
    .inputs(ore('dustWetRutheniumOxideAluminaCatalyst') * 6)
    .outputs(ore('dustRutheniumOxideAluminaCatalyst').first() * 6)
    .EUt(Globals.voltAmps[1])
    .duration(100)
    .buildAndRegister()

/// D MAPDST
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
    .EUt(Globals.voltAmps[2])
    .duration(10)
    .buildAndRegister();

// 200L Iodomethane + 1000L Acetonitrile = 1000L Iodomethane Acetonitrile Solution [mixer]
MIXER.recipeBuilder()
    .fluidInputs(fluid('iodomethane') * 200)
    .fluidInputs(fluid('acetonitrile') * 1000)
    .fluidOutputs(fluid('iodomethane_acetonitrile_solution') * 1000)
    .EUt(Globals.voltAmps[2])
    .duration(100)
    .buildAndRegister();

// 1 4-(methylthio)phenyl Methacrylate + 1 Silver Trifluoromethanesulfonate + 5 Acetonitrile = 5kL 4-(methylthio)phenyl Methacrylate Silver Trifluoromethanesulfonate Acetonitrile Solution
// 1 Iodomethane Acetonitrile Solution + 5000L 4-(methylthio)phenyl Methacrylate Silver Trifluoromethanesulfonate Solution + 2kL Acetonitrile = 1 AgI + 8kL Crude MAPDST Acetonitrile Solution
LCR.recipeBuilder()
    .inputs(ore('dustFourMethylthioPhenylMethacrylate') * 26)
    .inputs(ore('dustSilverTrifluoromethanesulfonate') * 9)
    .fluidInputs(fluid('iodomethane_acetonitrile_solution') * 1000)
    .fluidInputs(fluid('acetonitrile') * 7000)
    .outputs(ore('dustSilverIodide').first() * 2)
    .fluidOutputs(fluid('crude_mapdst_acetonitrile_solution') * 8000)
    .EUt(Globals.voltAmps[5])
    .duration(100)
    .buildAndRegister();

// 8kL Crude MAPDST Acetonitrile Solution = 1 Crude MAPDST + 8kL Acetonitrile [vaccum or rotary evaporation]
VACUUM_CHAMBER.recipeBuilder()
    .fluidInputs(fluid('crude_mapdst_acetonitrile_solution') * 8000)
    .outputs(ore('dustCrudeMapdst').first() * 38)
    .fluidOutputs(fluid('acetonitrile') * 7500) // lossy
    .EUt(Globals.voltAmps[3])
    .duration(100)
    .buildAndRegister();

// 1 kmol Crude MAPDST + 1000L (NC) Hot Tetrahydrofuran = 1 kmol MAPDST [crystalizer]
// Normal tetrahydrofuran is used instead, no need for fluid bloat
CRYSTALLIZER.recipeBuilder()
    .inputs(ore('dustCrudeMapdst') * 38)
    .notConsumable(fluid('tetrahydrofuran') * 1000)
    .outputs(ore('dustMapdst').first() * 38)
    .EUt(Globals.voltAmps[5])
    .duration(400)
    .buildAndRegister();

/// E MAPDST-MMA Copolymer

// 1 MAPDST (Dimethyl-(4-methacryloyloxy)phenylsulfonium Triflate) + 1 Methyl Methacrylate + 1 Azobisisobutyronitrile (AIBN) + 2 Tetrahydrofuran + 1 Acetonitrile = Rough MAPDST-MMA Copolymer Solution [polymerization tank]
POLYMERIZATION.recipeBuilder()
    .inputs(ore('dustMapdst') * 38)
    .inputs(ore('dustAzobisisobutyronitrile') * 1)
    .fluidInputs(fluid('methyl_methacrylate') * 1000)
    .fluidInputs(fluid('tetrahydrofuran') * 2000)
    .fluidInputs(fluid('acetonitrile') * 1000)
    .fluidOutputs(fluid('rough_mapdst_mma_copolymer_solution') * 5000)
    .EUt(Globals.voltAmps[5])
    .duration(1000)
    .buildAndRegister();

// Rough MAPDST-MMA Copolymer Solution + 1 Diethyl Ether = 1 Rough MAPDST-MMA Copolymer + 6 MAPDST-MMA Copolymerization Waste [phase separation]
VACUUM_CHAMBER.recipeBuilder()
    .fluidInputs(fluid('rough_mapdst_mma_copolymer_solution') * 5000)
    .fluidInputs(fluid('diethyl_ether') * 1000)
    .outputs(ore('dustRoughMapdstMmaCopolymer').first() * 1)
    .fluidOutputs(fluid('mapdst_mma_copolymer_waste') * 6000)
    .EUt(Globals.voltAmps[4])
    .duration(500)
    .buildAndRegister();

// 1 Rough MAPDST-MMA Copolymer + 1000L Dichloromethane (NC) = 1 Crude MAPDST-MMA Copolymer
CHEMICAL_BATH.recipeBuilder()
    .inputs(ore('dustRoughMapdstMmaCopolymer') * 1)
    .fluidInputs(fluid('dichloromethane') * 100)
    .outputs(ore('dustCrudeMapdstMmaCopolymer').first() * 1)
    .EUt(Globals.voltAmps[2])
    .duration(100)
    .buildAndRegister();

// 1 Crude MAPDST-MMA Copolymer + 1000L Methanol = 1000L Crude MAPDST-MMA Copolymer Solution [mixer]
MIXER.recipeBuilder()
    .inputs(ore('dustCrudeMapdstMmaCopolymer') * 1)
    .fluidInputs(fluid('methanol') * 1000)
    .fluidOutputs(fluid('crude_mapdst_mma_copolymer_solution') * 1000)
    .EUt(Globals.voltAmps[2])
    .duration(100)
    .buildAndRegister();

// 1000L Crude MAPDST-MMA Copolymer Solution + 1000L Diethyl Ether = 1 kmol Wet MAPDST-MMA Copolymer + 2000L Diethyl Ether Methanol Mix 
VACUUM_CHAMBER.recipeBuilder()
    .fluidInputs(fluid('crude_mapdst_mma_copolymer_solution') * 1000)
    .fluidInputs(fluid('diethyl_ether') * 1000)
    .chancedOutput(ore('dustWetMapdstMmaCopolymer').first() * 1, 8000, 0)
    .fluidOutputs(fluid('diethyl_ether_methanol_mix') * 2000)
    .EUt(Globals.voltAmps[4])
    .duration(500)
    .buildAndRegister();

// Diethyl Ether Methanol Mix = 1 Diethyl Ether + 1 Methanol [distillation]
DT.recipeBuilder()
    .fluidInputs(fluid('diethyl_ether_methanol_mix') * 1000)
    .fluidOutputs(fluid('diethyl_ether') * 1000)
    .fluidOutputs(fluid('methanol') * 1000)
    .EUt(Globals.voltAmps[3])
    .duration(400)
    .buildAndRegister();

//  Wet MAPDST-MMA Copolymer = MAPDST-MMA Copolymer [dryer]
DRYER.recipeBuilder()
    .inputs(ore('dustWetMapdstMmaCopolymer') * 1)
    .outputs(ore('dustMapdstMmaCopolymer').first() * 1)
    .EUt(Globals.voltAmps[1])
    .duration(100)
    .buildAndRegister();

MIXER.recipeBuilder()
    .inputs(ore('dustMapdstMmaCopolymer') * 1)
    .fluidInputs(fluid('methanol') * 8000)
    .fluidOutputs(fluid('mapdst_mma_photoresist') * 8000)
    .EUt(Globals.voltAmps[3])
    .duration(1000)
    .buildAndRegister();