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
LCR = recipemap('large_chemical_reactor')
ELECTROLYTIC_CELL = recipemap('electrolytic_cell')
SIFTER = recipemap('sifter')
VACUUM_CHAMBER = recipemap('vacuum_chamber')
CRYSTALLIZER = recipemap('crystallizer')
MACERATOR = recipemap('macerator')
AUTOCLAVE = recipemap('autoclave')
MIXER_SETTLER = recipemap('mixer_settler') 

// Bastnasite Dust * 1
mods.gregtech.electromagnetic_separator.removeByInput(24, [metaitem('dustPureBastnasite')], null)

/* Data (%mol)
La: 34
Ce: 50
Pr: 4
Nd: 10.8
Sm: 0.75
Eu: 0.1
Gd: 0.15
Tb: 0.01
Dy: 0.03
Ho: 0.004
Er: 0.004
Tm: 0.001
Yb: 0.001
Lu: 0
Y: 0.15

98.8% LREEs
1% MREEs
0.2% HREEs
*/

// Bastnasite beneficiation

GRAVITY_SEPARATOR.recipeBuilder()
    .inputs(ore('dustBastnasite'))
    .outputs(metaitem('dustSiftedBastnasite'))
    .chancedOutput(metaitem('dustLimestoneTailings'), 3000, 0)
    .chancedOutput(metaitem('dustBarite'), 500, 0)
    .chancedOutput(metaitem('dustStrontianite'), 100, 0)
    .duration(40)
    .EUt(30)
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustSiftedBastnasite') * 8)
    .fluidInputs(fluid('distilled_water') * 2000)
    .fluidOutputs(fluid('impure_bastnasite_slurry') * 2000)
    .duration(80)
    .EUt(30)
    .buildAndRegister()

FROTH_FLOTATION.recipeBuilder()
    .notConsumable(fluid('methyl_isobutyl_carbinol') * 100)
    .notConsumable(fluid('oleic_acid') * 1000)
    .notConsumable(ore('dustSodaAsh') * 5)
    .fluidInputs(fluid('impure_bastnasite_slurry') * 2000)
    .fluidOutputs(fluid('bastnasite_slurry') * 1000)
    .fluidOutputs(fluid('pegmatite_tailing_slurry') * 1000)
    .duration(80)
    .EUt(480)
    .buildAndRegister()

CLARIFIER.recipeBuilder()
    .fluidInputs(fluid('bastnasite_slurry') * 1000)
    .outputs(metaitem('dustFlotatedBastnasite') * 8)
    .fluidOutputs(fluid('wastewater') * 1000)
    .duration(20)
    .EUt(30)
    .buildAndRegister()

for (fuel in sintering_fuels) {
    if (!fuel.isPlasma) {
        ROTARY_KILN.recipeBuilder()
            .inputs(ore('dustFlotatedBastnasite') * 2)
            .fluidInputs(fluid('sulfuric_acid') * 3000)
            .fluidInputs(fluid(fuel.name) * fuel.amountRequired)
            .fluidInputs(fluid('oxygen') * 50)
            .outputs(metaitem('dustRoastedBastnasite') * 2)
            .fluidOutputs(fluid('hydrogen_fluoride') * 2000)
            .fluidOutputs(fluid('carbon_dioxide') * 2000)
            .fluidOutputs(fluid('dense_steam') * 2000)
            .duration(80)
            .EUt(480)
            .buildAndRegister()
    }
}   

AUTOCLAVE.recipeBuilder()
    .inputs(ore('dustRoastedBastnasite'))
    .inputs(ore('dustSodiumHydroxide') * 9)
    .fluidInputs(fluid('distilled_water') * 1500)
    .outputs(metaitem('dustBastReHydroxides'))
    .fluidOutputs(fluid('sodium_sulfate_solution') * 1500)
    .duration(40)
    .EUt(120)
    .buildAndRegister()

// Bastnasite REE Concentrate Processing
// RE3+ + 2.5 H2L2 (dimers) -> REL(HL2)2 + 3H+ (acidic organophosphorous extractants)

ROASTER.recipeBuilder()
    .inputs(ore('dustBastReHydroxides'))
    .fluidInputs(fluid('air') * 1200)
    .outputs(metaitem('dustBastOxReConcentrate'))
    .duration(80)
    .EUt(120)
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustBastOxReConcentrate'))
    .fluidInputs(fluid('nitric_acid') * 3500)
    .fluidOutputs(fluid('bast_ox_re_nitrates_solution') * 1000)
    .duration(80)
    .EUt(30)
    .buildAndRegister()

MIXER_SETTLER.recipeBuilder()
    .fluidInputs(fluid('bast_ox_re_nitrates_solution') * 1000)
    .fluidInputs(fluid('tributyl_phosphate_extraction_mixture') * 10000)
    .fluidOutputs(fluid('bast_ce_free_solution') * 1000)
    .fluidOutputs(fluid('cerium_extract') * 10000)
    .duration(80)
    .EUt(120)
    .requiredCells(4)
    .buildAndRegister()

MIXER_SETTLER.recipeBuilder()
    .fluidInputs(fluid('bast_ce_free_solution') * 1000)
    .fluidInputs(fluid('p_two_zero_four_extraction_mixture') * 300)
    .fluidOutputs(fluid('bast_lree_concentrate') * 1000) // contains 0.036 mol H+
    .fluidOutputs(fluid('bast_lree_free_extract') * 300)
    .duration(80)
    .EUt(120)
    .requiredCells(8)
    .buildAndRegister()

MIXER_SETTLER.recipeBuilder()
    .fluidInputs(fluid('hydrochloric_acid') * 4350)
    .fluidInputs(fluid('bast_lree_free_extract') * 30000) // MREE/HREEs enriched hundredfold
    .fluidOutputs(fluid('bast_lree_free_concentrate') * 4350)
    .fluidOutputs(fluid('spent_p_two_zero_four_extraction_mixture') * 30000)
    .duration(80)
    .EUt(120)
    .requiredCells(2)
    .buildAndRegister()

MIXER_SETTLER.recipeBuilder()
    .fluidInputs(fluid('bast_lree_free_concentrate') * 4350)
    .fluidInputs(fluid('p_five_zero_seven_extraction_mixture') * 5000)
    .fluidOutputs(fluid('bast_mree_concentrate') * 4350) // contains 0.6 mol H+
    .fluidOutputs(fluid('bast_hree_extract') * 5000)
    .duration(80)
    .EUt(120)
    .requiredCells(8)
    .buildAndRegister()

MIXER_SETTLER.recipeBuilder()
    .fluidInputs(fluid('hydrochloric_acid') * 1325)
    .fluidInputs(fluid('bast_hree_extract') * 5000)
    .fluidOutputs(fluid('bast_hree_concentrate') * 1325)
    .fluidOutputs(fluid('spent_p_five_zero_seven_extraction_mixture') * 5000)
    .duration(80)
    .EUt(120)
    .requiredCells(2)
    .buildAndRegister()

// Bastnasite Element Extraction Tier 1 (EV)

// LREE separation
    // La: 0.34
    // Pr: 0.04
    // Nd: 0.108

    LCR.recipeBuilder()
        .inputs(ore('dustAmmoniumCarbonate') * 8)
        .fluidInputs(fluid('ammonia_solution') * 544)
        .fluidInputs(fluid('bast_lree_concentrate') * 1000)
        .chancedOutput(metaitem('dustLanthanumCarbonate') * 14, 1700, 0)
        .outputs(metaitem('dustBastPrNdHydroxides'))
        .fluidOutputs(fluid('wastewater') * 1036)
        .duration(2000)
        .EUt(30)
        .buildAndRegister()

    BR.recipeBuilder()
        .notConsumable(fluid('potassium_hydroxide') * 432)
        .inputs(ore('dustBastPrNdHydroxides'))
        .inputs(ore('dustTinyPotassiumChlorate'))
        .outputs(metaitem('dustBastOxPrNdConcentrate'))
        .duration(2000)
        .EUt(30)
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustBastOxPrNdConcentrate'))
        .fluidInputs(fluid('hydrochloric_acid') * 324)
        .chancedOutput(metaitem('dustPraseodymiumIvOxide'), 1200, 0)
        .fluidOutputs(fluid('neodymium_chloride_solution') * 648)
        .duration(2000)
        .EUt(30)
        .buildAndRegister()

// MREE separation
    // Sm: 0.75
    // Eu: 0.1
    // Gd: 0.15

    BR.recipeBuilder()
        .inputs(ore('dustZinc'))
        .fluidInputs(fluid('bast_mree_concentrate') * 4350)
        .chancedOutput(metaitem('dustZinc'), 9500, 0)
        .fluidOutputs(fluid('bast_reduced_mree_concentrate') * 4350)
        .duration(80)
        .EUt(30)
        .buildAndRegister()

    BR.recipeBuilder()
        .fluidInputs(fluid('bast_reduced_mree_concentrate') * 4350)
        .fluidInputs(fluid('sulfuric_acid') * 100)
        .chancedOutput(metaitem('dustEuropiumIiSulfate'), 6000, 0)
        .fluidOutputs(fluid('bast_sm_gd_concentrate') * 4350)
        .duration(80)
        .EUt(30)
        .buildAndRegister()

    // Gadolinium separation
    MIXER_SETTLER.recipeBuilder()
        .fluidInputs(fluid('bast_sm_gd_concentrate') * 4350)
        .fluidInputs(fluid('p_five_zero_seven_extraction_mixture') * 3750)
        .fluidOutputs(fluid('bast_sm_concentrate') * 4350) // contains 2.825 mol H+
        .fluidOutputs(fluid('gadolinium_extract') * 3750)
        .duration(80)
        .EUt(120)
        .requiredCells(6)
        .buildAndRegister()

    // Samarium separation
    BR.recipeBuilder()
        .inputs(ore('dustSodiumHydroxide') * 16)
        .fluidInputs(fluid('bast_sm_concentrate') * 4350)
        .chancedOutput(metaitem('dustSamariumHydroxide') * 7, 7500, 0)
        .fluidOutputs(fluid('wastewater') * 7175)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

// Bastnasite Element Extraction Tier 2 (IV)

// LREE separation
    // La: 0.34
    // Pr: 0.04
    // Nd: 0.108
    // Per 3000L of bastnasite LREE concentrate
    // Total: 1.348 moles of LREEs

    // Lanthanum separation
    MIXER_SETTLER.recipeBuilder()
        .inputs(ore('dustPenteticAcid') * 3)
        .fluidInputs(fluid('bast_lree_concentrate') * 1000) // contains 0.34 La, 0.04 Pr, 0.108 Nd
        .fluidInputs(fluid('aliquat_336_extraction_mixture') * 340)
        .fluidOutputs(fluid('bast_didymium_concentrate') * 1000)
        .fluidOutputs(fluid('lanthanum_extract') * 340)
        .duration(80)
        .EUt(120)
        .requiredCells(6)
        .buildAndRegister()

    // Didymium separation
    MIXER_SETTLER.recipeBuilder()
        .inputs(ore('dustPenteticAcid'))
        .fluidInputs(fluid('bast_didymium_concentrate') * 1000)
        .fluidInputs(fluid('aliquat_336_extraction_mixture') * 40)
        .fluidOutputs(fluid('bast_nd_concentrate') * 1000)
        .fluidOutputs(fluid('praseodymium_extract') * 40)
        .duration(80)
        .EUt(120)
        .requiredCells(8)
        .buildAndRegister()

    // Neodymium extraction
    BR.recipeBuilder()
        .fluidInputs(fluid('hydrofluoric_acid') * 324)
        .fluidInputs(fluid('bast_nd_concentrate') * 1000)
        .chancedOutput(metaitem('dustNeodymiumFluoride'), 4320, 0)
        .fluidOutputs(fluid('wastewater') * 1324)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

// MREE separation
    // Sm: 0.75
    // Eu: 0.1
    // Gd: 0.15
    // Per 3675L of bastnasite MREE concentrate
    // Total: 0.2 moles of MREEs

    // Separation same as tier 1

// HREE separation
    // Tb: 0.01
    // Dy: 0.03
    // Ho: 0.004
    // Er: 0.004
    // Tm: 0.001
    // Yb: 0.001
    // Lu: 0
    // Y: 0.15
    // Per 1325L of bastnasite HREE concentrate
    // Total: 0.2 moles of HREEs

    // Primary purification
    MIXER_SETTLER.recipeBuilder()
        .fluidInputs(fluid('bast_hree_concentrate') * 1325)
        .fluidInputs(fluid('p_five_zero_seven_p_two_two_nine_extraction_mixture') * 5000)
        .fluidOutputs(fluid('acidic_wastewater') * 1325)
        .fluidOutputs(fluid('bast_purified_hree_extract') * 5000)
        .duration(80)
        .EUt(120)
        .requiredCells(4)
        .buildAndRegister()

    MIXER_SETTLER.recipeBuilder()
        .fluidInputs(fluid('bast_purified_hree_extract') * 5000)
        .fluidInputs(fluid('distilled_water') * 5000)
        .fluidInputs(fluid('nitric_acid') * 125)
        .fluidOutputs(fluid('bast_scrubbed_hree_extract') * 5000)
        .fluidOutputs(fluid('wastewater') * 5000)
        .duration(80)
        .EUt(120)
        .requiredCells(2)
        .buildAndRegister()

    // Separate Tb-Dy-Ho-Er-Y (0.198 mol)
    MIXER_SETTLER.recipeBuilder() 
        .fluidInputs(fluid('nitric_acid') * 594)
        .fluidInputs(fluid('distilled_water') * 1000)
        .fluidInputs(fluid('bast_scrubbed_hree_extract') * 5000)
        .fluidOutputs(fluid('bast_yttrium_rich_concentrate') * 1000)
        .fluidOutputs(fluid('bast_tm_yb_extract') * 5000)
        .duration(80)
        .EUt(120)
        .requiredCells(2)
        .buildAndRegister()

    // Yttrium separation & precipitation
    MIXER_SETTLER.recipeBuilder()
        .inputs(ore('dustAmmoniumThiocyanate'))
        .inputs(ore('dustPenteticAcid'))
        .fluidInputs(fluid('bast_yttrium_rich_concentrate') * 1000)
        .fluidInputs(fluid('aliquat_336_extraction_mixture') * 48)
        .fluidOutputs(fluid('bast_y_concentrate') * 1000)
        .fluidOutputs(fluid('bast_terbium_group_extract') * 48)
        .duration(80)
        .EUt(120)
        .requiredCells(6)
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustSodiumHydroxide') * 2)
        .fluidInputs(fluid('bast_y_concentrate') * 1000)
        .chancedOutput(metaitem('dustYttriumHydroxide') * 7, 1500, 0)
        .fluidOutputs(fluid('wastewater') * 1000)
        .duration(80)
        .EUt(30)
        .buildAndRegister()

    // Terbium group separation
    MIXER_SETTLER.recipeBuilder()
        .fluidInputs(fluid('bast_terbium_group_extract') * 48)
        .fluidInputs(fluid('distilled_water') * 48)
        .fluidOutputs(fluid('aliquat_336_extraction_mixture') * 48)
        .fluidOutputs(fluid('bast_terbium_group_concentrate') * 48)
        .duration(80)
        .EUt(120)
        .requiredCells(2)
        .buildAndRegister()

    MIXER_SETTLER.recipeBuilder()
        .fluidInputs(fluid('bast_terbium_group_concentrate') * 48)
        .fluidInputs(fluid('p_five_zero_seven_p_two_two_nine_extraction_mixture') * 1200)
        .fluidOutputs(fluid('acidic_wastewater') * 48)
        .fluidOutputs(fluid('bast_purified_terbium_group_extract') * 1200)
        .duration(80)
        .EUt(120)
        .requiredCells(4)
        .buildAndRegister()

    MIXER_SETTLER.recipeBuilder()
        .fluidInputs(fluid('bast_purified_terbium_group_extract') * 1200)
        .fluidInputs(fluid('hydrochloric_acid') * 60) // 30 to neutralize, 30 to solvate
        .fluidOutputs(fluid('bast_tb_free_extract') * 1200)
        .fluidOutputs(fluid('bast_tb_concentrate') * 60)
        .duration(80)
        .EUt(120)
        .requiredCells(2)
        .buildAndRegister()

    BR.recipeBuilder()
        .fluidInputs(fluid('bast_tb_concentrate') * 6000)
        .fluidInputs(fluid('hydrofluoric_acid') * 3000)
        .outputs(metaitem('dustTerbiumFluoride') * 4)
        .fluidOutputs(fluid('acidic_wastewater') * 9000)
        .duration(80)
        .EUt(30)
        .buildAndRegister()

    MIXER_SETTLER.recipeBuilder()
        .fluidInputs(fluid('diluted_hydrochloric_acid') * 180)
        .fluidInputs(fluid('bast_tb_free_extract') * 1200)
        .fluidOutputs(fluid('dysprosium_chloride_solution') * 180)
        .fluidOutputs(fluid('bast_ho_er_extract') * 1200)
        .duration(80)
        .EUt(120)
        .requiredCells(2)
        .buildAndRegister()

    MIXER_SETTLER.recipeBuilder()
        .fluidInputs(fluid('bast_ho_er_extract') * 1200)
        .fluidInputs(fluid('hydrochloric_acid') * 12)
        .fluidInputs(fluid('distilled_water') * 24)
        .fluidOutputs(fluid('bast_er_extract') * 1200)
        .fluidOutputs(fluid('holmium_chloride_solution') * 36)
        .duration(80)
        .EUt(120)
        .requiredCells(2)
        .buildAndRegister()

    MIXER_SETTLER.recipeBuilder()
        .fluidInputs(fluid('bast_er_extract') * 1200)
        .fluidInputs(fluid('diluted_sulfuric_acid') * 12)
        .fluidOutputs(fluid('spent_p_five_zero_seven_p_two_two_nine_extraction_mixture') * 1200)
        .fluidOutputs(fluid('erbium_sulfate_solution') * 6)
        .duration(80)
        .EUt(120)
        .requiredCells(2)
        .buildAndRegister()

    MIXER_SETTLER.recipeBuilder()
        .fluidInputs(fluid('bast_tm_yb_extract') * 5000)
        .fluidInputs(fluid('hydrochloric_acid') * 6)
        .fluidOutputs(fluid('spent_p_five_zero_seven_p_two_two_nine_extraction_mixture') * 5000)
        .fluidOutputs(fluid('bast_tm_yb_concentrate') * 6)
        .duration(80)
        .EUt(120)
        .requiredCells(2)
        .buildAndRegister()

    LCR.recipeBuilder()
        .fluidInputs(fluid('bast_tm_yb_concentrate') * 60)
        .fluidInputs(fluid('sodium_amalgam') * 10)
        .fluidOutputs(fluid('ytterbium_amalgam') * 10)
        .fluidOutputs(fluid('bast_tm_concentrate') * 60)
        .duration(80)
        .EUt(30)
        .buildAndRegister()

    BR.recipeBuilder()
        .fluidInputs(fluid('hydrofluoric_acid') * 3000)
        .fluidInputs(fluid('bast_tm_concentrate') * 6000)
        .outputs(metaitem('dustThuliumFluoride') * 4)
        .fluidOutputs(fluid('acidic_wastewater') * 9000)
        .duration(80)
        .EUt(30)
        .buildAndRegister()
