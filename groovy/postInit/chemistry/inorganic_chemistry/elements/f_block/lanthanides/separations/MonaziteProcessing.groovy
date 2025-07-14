import globals.Globals
import static globals.SinteringGlobals.*

GRAVITY_SEPARATOR = recipemap('gravity_separator')
MIXER = recipemap('mixer')
FROTH_FLOTATION = recipemap('froth_flotation')
CLARIFIER = recipemap('clarifier')
ROASTER = recipemap('roaster')
ROTARY_KILN = recipemap('rotary_kiln')
BR = recipemap('batch_reactor')
FLUIDIZED_BED_REACTOR = recipemap('fluidized_bed_reactor')
ION_EXCHANGE = recipemap('ion_exchange_column')
CENTRIFUGE = recipemap('centrifuge')
LCR = recipemap('large_chemical_reactor')
ELECTROLYTIC_CELL = recipemap('electrolytic_cell')
SIFTER = recipemap('sifter')
VACUUM_CHAMBER = recipemap('vacuum_chamber')
CRYSTALLIZER = recipemap('crystallizer')
MACERATOR = recipemap('macerator')
AUTOCLAVE = recipemap('autoclave')
CENTRIFUGE = recipemap('centrifuge')
ELECTROMAGNETIC_SEPARATOR = recipemap('electromagnetic_separator')

// Monazite Dust * 1
mods.gregtech.electromagnetic_separator.removeByInput(24, [metaitem('dustPureMonazite')], null)


/* REE Data (%mol)
La: 23.4
Ce: 45.5
Pr: 4.1
Nd: 15.3
Sm: 3
Eu: 0.1
Gd: 1.9
Tb: 0.08
Dy: 0.9
Ho: 0.09
Er: 0.42
Tm: 0.42
Yb: 0.42
Lu: 0.07
Y: 4.3

88.3% LREEs
5% MREEs
6.7% HREEs

90% REEs, 8% ThO2, 0.3% UO2, 1.6% FeTiO3, 0.1% ZrO2
*/

MACERATOR.recipeBuilder()
    .inputs(item('susy:resource_block', 6))
    .outputs(metaitem('dustMonazite') * 4)
    .duration(240)
    .EUt(7)
    .buildAndRegister()

// Monazite beneficiation

ELECTROMAGNETIC_SEPARATOR.recipeBuilder()
    .inputs(ore('dustMonazite'))
    .outputs(metaitem('dustConcentrateMonazite'))
    .chancedOutput(metaitem('dustXenotime'), 1000, 0)
    .chancedOutput(metaitem('dustIlmenite'), 1600, 0)
    .chancedOutput(metaitem('dustZircon'), 100, 0)
    .duration(40)
    .EUt(30)
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustConcentrateMonazite'))
    .fluidInputs(fluid('hot_sulfuric_acid') * 1500)
    .fluidInputs(fluid('distilled_water') * 1000)
    .fluidOutputs(fluid('monazite_leach') * 1000)
    .duration(120)
    .EUt(480)
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('monazite_leach') * 1000)
    .fluidInputs(fluid('ammonia_solution') * 100)
    .outputs(metaitem('dustThoriumConcentrate')) // contains 0.08 mol Th, 0.05 mol REE
    .fluidOutputs(fluid('thorium_free_monazite_leach') * 1000)
    .duration(80)
    .EUt(120)
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustSodiumHydroxide') * 9)
    .fluidInputs(fluid('thorium_free_monazite_leach') * 1000)
    .chancedOutput(metaitem('dustMonaReHydroxides'), 8500, 0)
    .fluidOutputs(fluid('rare_earth_free_monazite_leach') * 1000)
    .duration(80)
    .EUt(120)
    .buildAndRegister()

LCR.recipeBuilder()
    .fluidInputs(fluid('rare_earth_free_monazite_leach') * 1000)
    .fluidInputs(fluid('ammonia_solution') * 3)
    .fluidInputs(fluid('oxygen') * 3)
    .chancedOutput(metaitem('dustAmmoniumDiuranate'), 285, 0)
    .fluidOutputs(fluid('acidic_wastewater') * 1003)
    .duration(20)
    .EUt(30)
    .buildAndRegister()

// Monazite REE Concentrate Processing
// RE3+ + 2.5 H2L2 (dimers) -> REL(HL2)2 + 3H+ (acidic organophosphorous extractants)

ROASTER.recipeBuilder()
    .inputs(ore('dustMonaReHydroxides'))
    .fluidInputs(fluid('air') * 1080)
    .outputs(metaitem('dustMonaOxReConcentrate'))
    .duration(80)
    .EUt(120)
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustMonaOxReConcentrate'))
    .fluidInputs(fluid('nitric_acid') * 3455)
    .fluidOutputs(fluid('mona_ox_re_nitrates_solution') * 910)
    .duration(80)
    .EUt(120)
    .buildAndRegister()

CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('mona_ox_re_nitrates_solution') * 910)
    .fluidInputs(fluid('tributyl_phosphate_extraction_mixture') * 9100)
    .fluidOutputs(fluid('mona_ce_free_solution') * 910)
    .fluidOutputs(fluid('cerium_extract') * 9100)
    .duration(80)
    .EUt(120)
    .buildAndRegister()

CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('mona_ce_free_solution') * 910)
    .fluidInputs(fluid('p_two_zero_four_extraction_mixture') * 2925)
    .fluidOutputs(fluid('mona_lree_concentrate') * 910) // contains 0.351 mol H+
    .fluidOutputs(fluid('mona_lree_free_extract') * 2925)
    .duration(40)
    .EUt(120)
    .buildAndRegister()

CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('hydrochloric_acid') * 4245)
    .fluidInputs(fluid('mona_lree_free_extract') * 29250) // MREE/HREEs enriched tenfold
    .fluidOutputs(fluid('mona_lree_free_concentrate') * 4245)
    .fluidOutputs(fluid('spent_p_two_zero_four_extraction_mixture') * 29250)
    .duration(80)
    .EUt(120)
    .buildAndRegister()

CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('mona_lree_free_concentrate') * 4245)
    .fluidInputs(fluid('p_five_zero_seven_extraction_mixture') * 16750)
    .fluidOutputs(fluid('mona_mree_concentrate') * 4245) // contains 2.01 mol H+
    .fluidOutputs(fluid('mona_hree_extract') * 16750)
    .duration(80)
    .EUt(120)
    .buildAndRegister()

CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('hydrochloric_acid') * 2430)
    .fluidInputs(fluid('mona_hree_extract') * 16750)
    .fluidOutputs(fluid('mona_hree_concentrate') * 2430)
    .fluidOutputs(fluid('spent_p_five_zero_seven_extraction_mixture') * 16750)
    .duration(80)
    .EUt(120)
    .buildAndRegister()

// Monazite Element Extraction Tier 1 (EV)

// LREE separation
    // La: 0.234
    // Pr: 0.041
    // Nd: 0.153

    CRYSTALLIZER.recipeBuilder()
        .inputs(ore('dustAmmoniumCarbonate') * 5)
        .fluidInputs(fluid('ammonia_solution') * 933)
        .fluidInputs(fluid('mona_lree_concentrate') * 910)
        .chancedOutput(metaitem('dustLanthanumCarbonate') * 14, 1170, 0)
        .outputs(metaitem('dustMonaPrNdHydroxides'))
        .fluidOutputs(fluid('wastewater') * 3351)
        .duration(2000)
        .EUt(120)
        .buildAndRegister()

    BR.recipeBuilder()
        .notConsumable(fluid('potassium_hydroxide') * 432)
        .inputs(ore('dustMonaPrNdHydroxides') * 10)
        .inputs(ore('dustTinyPotassiumChlorate'))
        .outputs(metaitem('dustMonaOxPrNdConcentrate') * 10)
        .duration(2000)
        .EUt(120)
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustMonaOxPrNdConcentrate'))
        .fluidInputs(fluid('hydrochloric_acid') * 459)
        .chancedOutput(metaitem('dustPraseodymiumIvOxide') * 3, 41, 0)
        .fluidOutputs(fluid('neodymium_chloride_solution') * 918)
        .duration(2000)
        .EUt(120)
        .buildAndRegister()

// MREE separation
    // Sm: 0.3
    // Eu: 0.01
    // Gd: 0.19

    BR.recipeBuilder()
        .inputs(ore('dustZinc'))
        .fluidInputs(fluid('mona_mree_concentrate') * 4245)
        .chancedOutput(metaitem('dustZinc'), 9950, 0)
        .fluidOutputs(fluid('mona_reduced_mree_concentrate') * 4245)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    BR.recipeBuilder()
        .fluidInputs(fluid('mona_reduced_mree_concentrate') * 4245)
        .fluidInputs(fluid('sulfuric_acid') * 10)
        .chancedOutput(metaitem('dustEuropiumIiSulfate'), 600, 0)
        .fluidOutputs(fluid('mona_sm_gd_concentrate') * 4245) // contains 2.03 mol H+
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    // Gadolinium separation
    CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('mona_sm_gd_concentrate') * 4245)
        .fluidInputs(fluid('p_five_zero_seven_extraction_mixture') * 4750)
        .fluidOutputs(fluid('mona_sm_concentrate') * 4245) // contains 2.6 mol H+
        .fluidOutputs(fluid('gadolinium_extract') * 4750)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    // Samarium precipitation
    BR.recipeBuilder()
        .inputs(ore('dustSodiumHydroxide') * 9)
        .fluidInputs(fluid('mona_sm_concentrate') * 4245)
        .chancedOutput(metaitem('dustSamariumHydroxide') * 7, 3000, 0)
        .fluidOutputs(fluid('wastewater') * 6845)
        .duration(80)
        .EUt(120)
        .buildAndRegister()


// Monazite Element Extraction Tier 2 (IV)

// LREE separation
    // La: 0.234
    // Pr: 0.041
    // Nd: 0.153

    // Lanthanum separation
    CENTRIFUGE.recipeBuilder()
        .inputs(ore('dustPenteticAcid') * 2)
        .fluidInputs(fluid('mona_lree_concentrate') * 910)
        .fluidInputs(fluid('aliquat_336_extraction_mixture') * 234)
        .fluidOutputs(fluid('mona_didymium_concentrate') * 910)
        .fluidOutputs(fluid('lanthanum_extract') * 234)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    // Didymium separation
    CENTRIFUGE.recipeBuilder()
        .inputs(ore('dustPenteticAcid'))
        .fluidInputs(fluid('mona_didymium_concentrate') * 910)
        .fluidInputs(fluid('aliquat_336_extraction_mixture') * 41)
        .fluidOutputs(fluid('mona_nd_concentrate') * 910)
        .fluidOutputs(fluid('praseodymium_extract') * 41)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    // Neodymium preciptation
    BR.recipeBuilder()
        .fluidInputs(fluid('hydrofluoric_acid') * 459)
        .fluidInputs(fluid('mona_nd_concentrate') * 910)
        .chancedOutput(metaitem('dustNeodymiumFluoride'), 6120, 0)
        .fluidOutputs(fluid('wastewater') * 1459)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

// MREE separation
    // Sm: 0.3
    // Eu: 0.01
    // Gd: 0.19

    // Separation same as tier 1

// HREE separation
    // Tb: 0.008
    // Dy: 0.09
    // Ho: 0.009
    // Er: 0.042
    // Tm: 0.042
    // Yb: 0.042
    // Lu: 0.007
    // Y: 0.43
    // Per 2430L of monazite HREE concentrate
    // Total: 0.67 moles of HREEs

    // Primary purification
    CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('mona_hree_concentrate') * 1215)
        .fluidInputs(fluid('p_five_zero_seven_p_two_two_nine_extraction_mixture') * 8375)
        .fluidOutputs(fluid('acidic_wastewater') * 1215)
        .fluidOutputs(fluid('mona_purified_hree_extract') * 8375)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('mona_purified_hree_extract') * 8375)
        .fluidInputs(fluid('distilled_water') * 8375)
        .fluidInputs(fluid('nitric_acid') * 210)
        .fluidOutputs(fluid('mona_scrubbed_hree_extract') * 8375)
        .fluidOutputs(fluid('wastewater') * 8375)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    // Separate Tb-Dy-Ho-Er-Y (0.579 mol)
    CENTRIFUGE.recipeBuilder() 
        .fluidInputs(fluid('nitric_acid') * 870)
        .fluidInputs(fluid('distilled_water') * 500)
        .fluidInputs(fluid('mona_scrubbed_hree_extract') * 8375)
        .fluidOutputs(fluid('mona_yttrium_rich_concentrate') * 500)
        .fluidOutputs(fluid('mona_thulium_group_extract') * 8375)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    // Yttrium separation & precipitation
    CENTRIFUGE.recipeBuilder()
        .inputs(ore('dustAmmoniumThiocyanate'))
        .inputs(ore('dustPenteticAcid') * 2)
        .fluidInputs(fluid('mona_yttrium_rich_concentrate') * 1000)
        .fluidInputs(fluid('aliquat_336_extraction_mixture') * 149)
        .fluidOutputs(fluid('mona_y_concentrate') * 1000)
        .fluidOutputs(fluid('mona_terbium_group_extract') * 149)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustSmallSodiumHydroxide') * 6)
        .fluidInputs(fluid('mona_y_concentrate') * 1000)
        .chancedOutput(metaitem('dustYttriumHydroxide') * 7, 4300, 0)
        .fluidOutputs(fluid('wastewater') * 1000)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    // Terbium group separation
    CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('mona_terbium_group_extract') * 149)
        .fluidInputs(fluid('distilled_water') * 149)
        .fluidOutputs(fluid('aliquat_336_extraction_mixture') * 149)
        .fluidOutputs(fluid('mona_terbium_group_concentrate') * 149)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('mona_terbium_group_concentrate') * 149)
        .fluidInputs(fluid('p_five_zero_seven_p_two_two_nine_extraction_mixture') * 3725)
        .fluidOutputs(fluid('acidic_wastewater') * 149)
        .fluidOutputs(fluid('mona_purified_terbium_group_extract') * 3725)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('mona_purified_terbium_group_extract') * 3725)
        .fluidInputs(fluid('hydrochloric_acid') * 106)
        .fluidOutputs(fluid('mona_tb_free_extract') * 3725)
        .fluidOutputs(fluid('mona_tb_concentrate') * 106)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    BR.recipeBuilder()
        .fluidInputs(fluid('mona_tb_concentrate') * 6625)
        .fluidInputs(fluid('hydrofluoric_acid') * 1500)
        .outputs(metaitem('dustTerbiumFluoride') * 2)
        .fluidOutputs(fluid('acidic_wastewater') * 8125)
        .duration(80)
        .EUt(30)
        .buildAndRegister()

    CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('diluted_hydrochloric_acid') * 540)
        .fluidInputs(fluid('mona_tb_free_extract') * 3725)
        .fluidOutputs(fluid('dysprosium_chloride_solution') * 540)
        .fluidOutputs(fluid('mona_ho_er_extract') * 3725)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('mona_ho_er_extract') * 3725)
        .fluidInputs(fluid('hydrochloric_acid') * 27)
        .fluidOutputs(fluid('mona_er_extract') * 3725)
        .fluidOutputs(fluid('holmium_chloride_solution') * 27)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('mona_er_extract') * 3725)
        .fluidInputs(fluid('diluted_sulfuric_acid') * 126)
        .fluidOutputs(fluid('spent_p_five_zero_seven_p_two_two_nine_extraction_mixture') * 3725)
        .fluidOutputs(fluid('erbium_sulfate_solution') * 126)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('mona_thulium_group_extract') * 8375)
        .fluidInputs(fluid('hydrochloric_acid') * 273)
        .fluidOutputs(fluid('spent_p_five_zero_seven_p_two_two_nine_extraction_mixture') * 8375)
        .fluidOutputs(fluid('mona_thulium_group_concentrate') * 273)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    LCR.recipeBuilder()
        .fluidInputs(fluid('mona_thulium_group_concentrate') * 273)
        .fluidInputs(fluid('sodium_amalgam') * 42)
        .fluidOutputs(fluid('ytterbium_amalgam') * 42)
        .fluidOutputs(fluid('mona_tm_lu_concentrate') * 273)
        .duration(80)
        .EUt(480)
        .buildAndRegister()

    ION_EXCHANGE.recipeBuilder()
        .fluidInputs(fluid('mona_tm_lu_concentrate') * 2730)
        .inputs(ore('dustNHydroxyethylEthylenediaminetriaceticAcid') * 7)
        .inputs(metaitem('beads.rare_earth_cation_exchange') * 7)
        .fluidOutputs(fluid('mona_tm_concentrate') * 2730)
        .outputs(metaitem('beads.loaded_lutetium_cation_exchange') * 7)
        .duration(400)
        .EUt(16)
        .buildAndRegister()

    BR.recipeBuilder()
        .fluidInputs(fluid('hydrofluoric_acid') * 3000)
        .fluidInputs(fluid('mona_tm_concentrate') * 6500)
        .outputs(metaitem('dustThuliumFluoride') * 4)
        .fluidOutputs(fluid('acidic_wastewater') * 9500)
        .duration(80)
        .EUt(120)
        .buildAndRegister()
