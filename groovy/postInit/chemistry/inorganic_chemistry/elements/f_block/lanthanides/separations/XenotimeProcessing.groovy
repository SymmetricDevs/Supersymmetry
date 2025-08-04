import globals.Globals
import static globals.SinteringGlobals.*

GRAVITY_SEPARATOR = recipemap('gravity_separator')
MIXER = recipemap('mixer')
FROTH_FLOTATION = recipemap('froth_flotation')
CLARIFIER = recipemap('clarifier')
ROASTER = recipemap('roaster')
ROTARY_KILN = recipemap('rotary_kiln')
BR = recipemap('batch_reactor')
BLENDER = recipemap('blender')
FLUIDIZED_BED_REACTOR = recipemap('fluidized_bed_reactor')
ION_EXCHANGE = recipemap('ion_exchange_column')
LCR = recipemap('large_chemical_reactor')
ELECTROLYTIC_CELL = recipemap('electrolytic_cell')
SIFTER = recipemap('sifter')
VACUUM_CHAMBER = recipemap('vacuum_chamber')
CRYSTALLIZER = recipemap('crystallizer')
MACERATOR = recipemap('macerator')
MIXER_SETTLER = recipemap('mixer_settler')

/* REE Data (%mol)
La: 0.5
Ce: 5
Pr: 0.7
Nd: 2.2
Sm: 1.9
Eu: 0.2
Gd: 4
Tb: 1
Dy: 8.7
Ho: 2.1
Er: 5.4
Tm: 0.9
Yb: 6.2
Lu: 0.4
Y: 60.8

6.7% LREEs
4.6% MREEs
88.7% HREEs
*/

/*MACERATOR.recipeBuilder()
    .inputs(item('susy:resource_block', 9))
    .outputs(metaitem('dustXenotime') * 4)
    .duration(240)
    .EUt(7)
    .buildAndRegister()*/

// Xenotime beneficiation

ELECTROMAGNETIC_SEPARATOR.recipeBuilder()
    .inputs(ore('dustXenotime'))
    .outputs(metaitem('dustConcentrateXenotime'))
    .chancedOutput(metaitem('dustMonazite'), 1500, 0)
    .chancedOutput(metaitem('dustIlmenite'), 1600, 0)
    .chancedOutput(metaitem('dustZircon'), 100, 0)
    .duration(40)
    .EUt(30)
    .buildAndRegister()

// 2 (REE)PO4 + 3 Na2CO3 -> 2 Na3PO4 + (REE)2O3 + 3 CO2
for (fuel in sintering_fuels) {
    if (!fuel.isPlasma) {
        ROTARY_KILN.recipeBuilder()
            .inputs(ore('dustSodaAsh') * 18)
            .inputs(ore('dustConcentrateXenotime') * 2)
            .fluidInputs(fluid(fuel.name) * fuel.amountRequired)
            .fluidInputs(fluid('oxygen') * 50)
            .outputs(metaitem('dustRoastedXenotime'))
            .fluidOutputs(fluid('carbon_dioxide') * 3000)
            .duration(160)
            .EUt(Globals.voltAmps[2])
            .buildAndRegister()
    }
}

MIXER.recipeBuilder()
    .inputs(ore('dustRoastedXenotime'))
    .fluidInputs(fluid('distilled_water') * 5000)
    .outputs(metaitem('dustXenoReHydroxides') * 2)
    .fluidOutputs(fluid('sodium_phosphate_solution') * 2000)
    .duration(160)
    .EUt(30)
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustXenoReHydroxides'))
    .fluidInputs(fluid('nitric_acid') * 3000)
    .fluidOutputs(fluid('xeno_re_nitrates_solution') * 3000)
    .duration(80)
    .EUt(30)
    .buildAndRegister()

// Xenotime Concentrate Processing

MIXER_SETTLER.recipeBuilder()
    .fluidInputs(fluid('xeno_re_nitrates_solution') * 3000)
    .fluidInputs(fluid('aliquat_336_extraction_mixture') * 67)
    .fluidOutputs(fluid('xeno_lree_free_concentrate') * 3000)
    .fluidOutputs(fluid('xeno_lree_extract') * 67)
    .duration(80)
    .EUt(120)
    .requiredCells(8)
    .buildAndRegister()

MIXER_SETTLER.recipeBuilder()
    .fluidInputs(fluid('distilled_water') * 67)
    .fluidInputs(fluid('xeno_lree_extract') * 67)
    .fluidOutputs(fluid('xeno_lree_concentrate') * 67)
    .fluidOutputs(fluid('aliquat_336_extraction_mixture') * 67)
    .duration(80)
    .EUt(120)
    .requiredCells(2)
    .buildAndRegister()

MIXER_SETTLER.recipeBuilder()
    .fluidInputs(fluid('xeno_lree_free_concentrate') * 3000)
    .fluidInputs(fluid('p_five_zero_seven_p_two_two_nine_extraction_mixture') * 22175)
    .fluidOutputs(fluid('xeno_mree_concentrate') * 3000)
    .fluidOutputs(fluid('xeno_hree_extract') * 22175)
    .duration(80)
    .EUt(120)
    .requiredCells(8)
    .buildAndRegister()

MIXER_SETTLER.recipeBuilder()
    .fluidInputs(fluid('xeno_mree_concentrate') * 3000)
    .fluidInputs(fluid('aliquat_336_extraction_mixture') * 46)
    .fluidOutputs(fluid('acidic_wastewater') * 3000)
    .fluidOutputs(fluid('xeno_mree_extract') * 46)
    .duration(80)
    .EUt(120)
    .requiredCells(4)
    .buildAndRegister()

MIXER_SETTLER.recipeBuilder()
    .fluidInputs(fluid('distilled_water') * 1000)
    .fluidInputs(fluid('xeno_mree_extract') * 460)
    .fluidOutputs(fluid('xeno_enriched_mree_concentrate') * 1000)
    .fluidOutputs(fluid('aliquat_336_extraction_mixture') * 460)
    .duration(80)
    .EUt(120)
    .requiredCells(2)
    .buildAndRegister()

// Xenotime Element Extraction (IV)

// LREE separation
    // La: 0.005
    // Ce: 0.05
    // Pr: 0.007
    // Nd: 0.022

    // Cerium oxidation & precipitation
    // Ce(III) + 0.5(NH4)2S2O8 -> Ce(IV) + (NH4)SO4-
    // Ce(IV) + 2(NH4)2CO3 + 2H2O -> Ce(OH)4 + 4NH4+ + 2CO2
    // Ce(NO3)3 + 0.5(NH4)2S2O8 + 2(NH4)2CO3 + 2H2O -> Ce(OH)4 + 3NH4NO3 + 2CO2 + (NH4)2SO4
    BR.recipeBuilder()
        .inputs(ore('dustAmmoniumPersulfate') * 10)
        .inputs(ore('dustAmmoniumCarbonate') * 28)
        .fluidInputs(fluid('xeno_lree_concentrate') * 1340)
        .outputs(metaitem('dustCeriumIvHydroxide') * 9)
        .fluidOutputs(fluid('xeno_ce_free_concentrate') * 1340)
        .fluidOutputs(fluid('carbon_dioxide') * 2000)
        .duration(80)
        .EUt(30)
        .buildAndRegister()

    // Lanthanum separation
    MIXER_SETTLER.recipeBuilder()
        .inputs(ore('dustPenteticAcid'))
        .fluidInputs(fluid('xeno_ce_free_concentrate') * 1340)
        .fluidInputs(fluid('aliquat_336_extraction_mixture') * 100)
        .fluidOutputs(fluid('xeno_didymium_concentrate') * 1340)
        .fluidOutputs(fluid('lanthanum_extract') * 100)
        .duration(80)
        .EUt(120)
        .requiredCells(6)
        .buildAndRegister()

    // Didymium separation
    MIXER_SETTLER.recipeBuilder()
        .inputs(ore('dustPenteticAcid'))
        .fluidInputs(fluid('xeno_didymium_concentrate') * 1340)
        .fluidInputs(fluid('aliquat_336_extraction_mixture') * 140)
        .fluidOutputs(fluid('xeno_nd_concentrate') * 1340)
        .fluidOutputs(fluid('praseodymium_extract') * 140)
        .duration(80)
        .EUt(120)
        .requiredCells(8)
        .buildAndRegister()

    // Neodymium preciptation
    BR.recipeBuilder()
        .fluidInputs(fluid('hydrofluoric_acid') * 660)
        .fluidInputs(fluid('xeno_nd_concentrate') * 1340)
        .chancedOutput(metaitem('dustNeodymiumFluoride'), 8800, 0)
        .fluidOutputs(fluid('wastewater') * 2000)
        .duration(80)
        .EUt(30)
        .buildAndRegister()

// MREE separation
    // Sm: 0.19
    // Eu: 0.02
    // Gd: 0.4

    // Europium separation
    BR.recipeBuilder()
        .inputs(ore('dustZinc'))
        .fluidInputs(fluid('xeno_enriched_mree_concentrate') * 1000)
        .chancedOutput(metaitem('dustZinc'), 9900, 0)
        .fluidOutputs(fluid('xeno_reduced_mree_concentrate') * 1000)
        .duration(8)
        .EUt(30)
        .buildAndRegister()

    BR.recipeBuilder()
        .fluidInputs(fluid('xeno_reduced_mree_concentrate') * 1000)
        .fluidInputs(fluid('sulfuric_acid') * 20)
        .chancedOutput(metaitem('dustEuropiumIiSulfate'), 1200, 0)
        .fluidOutputs(fluid('xeno_sm_gd_concentrate') * 1000)
        .duration(8)
        .EUt(30)
        .buildAndRegister()

    // Gadolinium separation
    MIXER_SETTLER.recipeBuilder()
        .fluidInputs(fluid('xeno_sm_gd_concentrate') * 1000)
        .fluidInputs(fluid('p_five_zero_seven_extraction_mixture') * 10000)
        .fluidOutputs(fluid('xeno_sm_concentrate') * 1000)
        .fluidOutputs(fluid('gadolinium_extract') * 10000)
        .duration(8)
        .EUt(120)
        .requiredCells(6)
        .buildAndRegister()

    // Samarium separation
    BR.recipeBuilder()
        .inputs(ore('dustSodiumHydroxide') * 6)
        .fluidInputs(fluid('xeno_sm_concentrate') * 1000)
        .chancedOutput(metaitem('dustSamariumHydroxide') * 7, 1900, 0)
        .fluidOutputs(fluid('wastewater') * 1124)
        .duration(80)
        .EUt(30)
        .buildAndRegister()

// HREE separation
    // Tb: 0.01
    // Dy: 0.087
    // Ho: 0.021
    // Er: 0.054
    // Tm: 0.009
    // Yb: 0.062
    // Lu: 0.004
    // Y: 0.608

    // Primary purification
    MIXER_SETTLER.recipeBuilder()
        .fluidInputs(fluid('xeno_hree_extract') * 22175)
        .fluidInputs(fluid('distilled_water') * 22000)
        .fluidInputs(fluid('nitric_acid') * 600)
        .fluidOutputs(fluid('xeno_scrubbed_hree_extract') * 22175)
        .fluidOutputs(fluid('acidic_wastewater') * 22000)
        .duration(80)
        .EUt(120)
        .requiredCells(2)
        .buildAndRegister()

    // Separate Tb-Dy-Ho-Er-Y (0.78 mol)
    MIXER_SETTLER.recipeBuilder()
        .fluidInputs(fluid('nitric_acid') * 2340)
        .fluidInputs(fluid('distilled_water') * 1000)
        .fluidInputs(fluid('xeno_scrubbed_hree_extract') * 22175)
        .fluidOutputs(fluid('xeno_yttrium_rich_concentrate') * 1000)
        .fluidOutputs(fluid('xeno_thulium_group_extract') * 22175)
        .duration(80)
        .EUt(120)
        .requiredCells(2)
        .buildAndRegister()

    // Yttrium separation & precipitation
    MIXER_SETTLER.recipeBuilder()
        .inputs(ore('dustAmmoniumThiocyanate'))
        .inputs(ore('dustPenteticAcid') * 2)
        .fluidInputs(fluid('xeno_yttrium_rich_concentrate') * 1000)
        .fluidInputs(fluid('aliquat_336_extraction_mixture') * 172)
        .fluidOutputs(fluid('xeno_y_concentrate') * 1000)
        .fluidOutputs(fluid('xeno_terbium_group_extract') * 172)
        .duration(80)
        .EUt(120)
        .requiredCells(6)
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustSodiumHydroxide') * 6)
        .fluidInputs(fluid('xeno_y_concentrate') * 1000)
        .chancedOutput(metaitem('dustYttriumHydroxide') * 7, 6080, 0)
        .fluidOutputs(fluid('wastewater') * 1000)
        .duration(80)
        .EUt(30)
        .buildAndRegister()

    // Terbium group separation
    MIXER_SETTLER.recipeBuilder()
        .fluidInputs(fluid('xeno_terbium_group_extract') * 172)
        .fluidInputs(fluid('distilled_water') * 172)
        .fluidOutputs(fluid('aliquat_336_extraction_mixture') * 172)
        .fluidOutputs(fluid('xeno_terbium_group_concentrate') * 172)
        .duration(80)
        .EUt(120)
        .requiredCells(2)
        .buildAndRegister()

    MIXER_SETTLER.recipeBuilder()
        .fluidInputs(fluid('xeno_terbium_group_concentrate') * 172)
        .fluidInputs(fluid('p_five_zero_seven_p_two_two_nine_extraction_mixture') * 4300)
        .fluidOutputs(fluid('acidic_wastewater') * 172)
        .fluidOutputs(fluid('xeno_purified_terbium_group_extract') * 4300)
        .duration(80)
        .EUt(120)
        .requiredCells(4)
        .buildAndRegister()

    MIXER_SETTLER.recipeBuilder()
        .fluidInputs(fluid('xeno_purified_terbium_group_extract') * 4300)
        .fluidInputs(fluid('hydrochloric_acid') * 138)
        .fluidOutputs(fluid('xeno_tb_free_extract') * 4300)
        .fluidOutputs(fluid('xeno_tb_concentrate') * 138)
        .duration(80)
        .EUt(120)
        .requiredCells(2)
        .buildAndRegister()

    BR.recipeBuilder()
        .fluidInputs(fluid('xeno_tb_concentrate') * 6900)
        .fluidInputs(fluid('hydrofluoric_acid') * 1500)
        .outputs(metaitem('dustTerbiumFluoride') * 2)
        .fluidOutputs(fluid('acidic_wastewater') * 8400)
        .duration(80)
        .EUt(30)
        .buildAndRegister()

    MIXER_SETTLER.recipeBuilder()
        .fluidInputs(fluid('diluted_hydrochloric_acid') * 522)
        .fluidInputs(fluid('xeno_tb_free_extract') * 4300)
        .fluidOutputs(fluid('dysprosium_chloride_solution') * 522)
        .fluidOutputs(fluid('xeno_ho_er_extract') * 4300)
        .duration(80)
        .EUt(120)
        .requiredCells(2)
        .buildAndRegister()

    MIXER_SETTLER.recipeBuilder()
        .fluidInputs(fluid('xeno_ho_er_extract') * 4300)
        .fluidInputs(fluid('hydrochloric_acid') * 63)
        .fluidOutputs(fluid('xeno_er_extract') * 4300)
        .fluidOutputs(fluid('holmium_chloride_solution') * 63)
        .duration(80)
        .EUt(120)
        .requiredCells(2)
        .buildAndRegister()

    MIXER_SETTLER.recipeBuilder()
        .fluidInputs(fluid('xeno_er_extract') * 4300)
        .fluidInputs(fluid('diluted_sulfuric_acid') * 81)
        .fluidOutputs(fluid('spent_p_five_zero_seven_p_two_two_nine_extraction_mixture') * 4300)
        .fluidOutputs(fluid('erbium_sulfate_solution') * 81)
        .duration(80)
        .EUt(120)
        .requiredCells(2)
        .buildAndRegister()

    MIXER_SETTLER.recipeBuilder()
        .fluidInputs(fluid('xeno_thulium_group_extract') * 22175)
        .fluidInputs(fluid('hydrochloric_acid') * 225)
        .fluidOutputs(fluid('spent_p_five_zero_seven_p_two_two_nine_extraction_mixture') * 22175)
        .fluidOutputs(fluid('xeno_thulium_group_concentrate') * 225)
        .duration(80)
        .EUt(120)
        .requiredCells(2)
        .buildAndRegister()

    LCR.recipeBuilder()
        .fluidInputs(fluid('xeno_thulium_group_concentrate') * 225)
        .fluidInputs(fluid('sodium_amalgam') * 62)
        .fluidOutputs(fluid('ytterbium_amalgam') * 62)
        .fluidOutputs(fluid('xeno_tm_lu_concentrate') * 225)
        .duration(80)
        .EUt(480)
        .buildAndRegister()

    ION_EXCHANGE.recipeBuilder()
        .inputs(metaitem('beads.rare_earth_cation_exchange') * 4)
        .inputs(ore('dustNHydroxyethylEthylenediaminetriaceticAcid') * 4)
        .fluidInputs(fluid('xeno_tm_lu_concentrate') * 225)
        .fluidOutputs(fluid('xeno_tm_concentrate') * 225)
        .outputs(metaitem('beads.loaded_lutetium_cation_exchange') * 4)
        .duration(80)
        .EUt(30)
        .buildAndRegister()

    BR.recipeBuilder()
        .fluidInputs(fluid('hydrofluoric_acid') * 600)
        .fluidInputs(fluid('xeno_tm_concentrate') * 5000)
        .chancedOutput(metaitem('dustThuliumFluoride'), 8000, 0)
        .fluidOutputs(fluid('acidic_wastewater') * 5600)
        .duration(80)
        .EUt(30)
        .buildAndRegister()