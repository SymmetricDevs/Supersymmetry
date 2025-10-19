import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Beneficiation

    // Carnotite

    MIXER.recipeBuilder()
        .inputs(ore('dustCarnotite'))
        .fluidInputs(fluid('hot_sulfuric_acid') * 2000)
        .fluidInputs(fluid('distilled_water') * 4000)
        .fluidOutputs(fluid('crude_carnotite_leach') * 6000)
        .fluidOutputs(fluid('helium') * 5)
        .EUt(VA[MV])
        .duration(300)
        .buildAndRegister()

    VACUUM_CHAMBER.recipeBuilder()
        .notConsumable(metaitem('item_filter'))
        .fluidInputs(fluid('crude_carnotite_leach') * 6000)
        .chancedOutput(metaitem('dustGraniteTailings'), 5000, 0)
        .fluidOutputs(fluid('carnotite_leach') * 6000)
        .EUt(VA[MV])
        .duration(300)
        .buildAndRegister()

    MIXER.recipeBuilder()
        .inputs(ore('dustAnyPurityIron'))
        .inputs(ore('dustCalcite') * 3)
        .fluidInputs(fluid('carnotite_leach') * 6000)
        .fluidOutputs(fluid('reduced_carnotite_leach') * 6000)
        .EUt(VA[MV])
        .duration(300)
        .buildAndRegister()

    // Pitchblende

    // 3 UO2 + NaClO3 -> UO2/2+ + 3H2O + NaCl
    MIXER.recipeBuilder()
        .inputs(ore('dustPitchblende') * 3)
        .inputs(metaitem('gregtechfoodoption:sodium_chlorate_dust') * 4) // this is intentionally less than a mole to account for U(VI) in the ore
        .fluidInputs(fluid('diluted_sulfuric_acid') * 6000)
        .fluidOutputs(fluid('crude_pitchblende_leach') * 5400)
        .fluidOutputs(fluid('helium') * 5)
        .EUt(VA[MV])
        .duration(300)
        .buildAndRegister()

    VACUUM_CHAMBER.recipeBuilder()
        .notConsumable(metaitem('item_filter'))
        .fluidInputs(fluid('crude_pitchblende_leach') * 5400)
        .chancedOutput(metaitem('dustGraniteTailings'), 5000, 0)
        .fluidOutputs(fluid('pitchblende_leach') * 5400)
        .EUt(VA[MV])
        .duration(300)
        .buildAndRegister()

// Purification

BLENDER.recipeBuilder()
    .circuitMeta(2)
    .fluidInputs(fluid('kerosene') * 900)
    .fluidInputs(fluid('tributyl_phosphate') * 40)
    .fluidInputs(fluid('di_two_ethylhexyl_phosphoric_acid') * 60)
    .fluidOutputs(fluid('uranium_extraction_mixture') * 1000)
    .EUt(512)
    .duration(200)
    .buildAndRegister()

    // Carnotite

    MIXER_SETTLER.recipeBuilder()
        .fluidInputs(fluid('uranium_extraction_mixture') * 1000)
        .fluidInputs(fluid('reduced_carnotite_leach') * 1000)
        .fluidOutputs(fluid('uranium_vanadium_extract') * 1000)
        .fluidOutputs(fluid('wastewater') * 1000)
        .EUt(240)
        .duration(200)
        .requiredCells(6)
        .buildAndRegister()

    MIXER_SETTLER.recipeBuilder()
        .fluidInputs(fluid('uranium_vanadium_extract') * 3000)
        .fluidInputs(fluid('diluted_sulfuric_acid') * 2000)
        .fluidOutputs(fluid('uranium_extract') * 3000)
        .fluidOutputs(fluid('acidic_vanadyl_solution') * 2000)
        .EUt(240)
        .duration(200)
        .requiredCells(2)
        .buildAndRegister()

    LCR.recipeBuilder()
        .inputs(metaitem('gregtechfoodoption:sodium_chlorate_dust') * 5)
        .fluidInputs(fluid('acidic_vanadyl_solution') * 6000)
        .fluidInputs(fluid('ammonia') * 1000)
        .fluidOutputs(fluid('wastewater') * 6000)
        .outputs(metaitem('dustVanadiumPentoxide') * 7)
        .EUt(240)
        .duration(200)
        .buildAndRegister()

    MIXER_SETTLER.recipeBuilder()
        .fluidInputs(fluid('uranium_extract') * 3000)
        .fluidInputs(fluid('soda_ash_solution') * 1000)
        .fluidOutputs(fluid('uranium_extraction_mixture') * 3000)
        .fluidOutputs(fluid('impure_uranyl_carbonate_solution') * 1000)
        .EUt(720)
        .duration(160)
        .requiredCells(2)
        .buildAndRegister()

    SIFTER.recipeBuilder()
        .fluidInputs(fluid('impure_uranyl_carbonate_solution') * 6000)
        .chancedOutput(metaitem('dustAluminiumHydroxide') * 7, 1000, 1000)
        .chancedOutput(metaitem('dustIronCarbonate') * 5, 4000, 1000)
        .fluidOutputs(fluid('uranyl_carbonate_solution') * 6000)
        .EUt(240)
        .duration(200)
        .buildAndRegister()

    ROASTER.recipeBuilder()
        .inputs(ore('dustIronCarbonate') * 5)
        .outputs(metaitem('dustIronIiOxide') * 2)
        .fluidOutputs(fluid('carbon_dioxide') * 1000)
        .EUt(VA[MV])
        .duration(200)
        .buildAndRegister()

    // Pitchblende

    // UO2SO4 + 2H2SO4 -> H4[UO2(SO4)3]
    // 4RX + [UO2(SO4)3]4- -> R4[UO2(SO4)3] + 4X-
    ION_EXCHANGE.recipeBuilder()
        .inputs(metaitem('beads.strong_basic_anion_exchange'))
        .fluidInputs(fluid('pitchblende_leach') * 5400)
        .fluidInputs(fluid('sulfuric_acid') * 6000)
        .outputs(metaitem('beads.loaded_uranium_anion_exchange'))
        .fluidOutputs(fluid('acidic_wastewater') * 5400)
        .EUt(240)
        .duration(200)
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(metaitem('beads.loaded_uranium_anion_exchange'))
        .fluidInputs(fluid('sodium_sulfate_solution') * 1000)
        .outputs(metaitem('beads.strong_basic_anion_exchange'))
        .fluidOutputs(fluid('impure_uranyl_sulfate_solution') * 1000)
        .EUt(240)
        .duration(200)
        .buildAndRegister()

    MIXER_SETTLER.recipeBuilder()
        .fluidInputs(fluid('uranium_extraction_mixture') * 3000)
        .fluidInputs(fluid('impure_uranyl_sulfate_solution') * 1000)
        .fluidOutputs(fluid('uranium_extract') * 3000)
        .fluidOutputs(fluid('wastewater') * 1000)
        .EUt(240)
        .duration(200)
        .requiredCells(6)
        .buildAndRegister()

// Yellowcake production

CSTR.recipeBuilder()
    .fluidInputs(fluid('uranyl_carbonate_solution') * 50)
    .fluidInputs(fluid('sulfuric_acid') * 50)
    .fluidOutputs(fluid('uranyl_sulfate_solution') * 100)
    .fluidOutputs(fluid('carbon_dioxide') * 50)
    .EUt(240)
    .duration(5)
    .buildAndRegister()

LCR.recipeBuilder()
    .fluidInputs(fluid('uranyl_sulfate_solution') * 2000)
    .fluidInputs(fluid('ammonia') * 6000)
    .fluidInputs(fluid('distilled_water') * 1000)
    .fluidOutputs(fluid('ammonium_sulfate_solution') * 2000)
    .outputs(metaitem('dustAmmoniumDiuranate') * 19)
    .EUt(720)
    .duration(200)
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .inputs(ore('dustAmmoniumDiuranate') * 19)
    .fluidInputs(fluid('hydrogen') * 2000)
    .outputs(metaitem('dustUraniumDioxide') * 6)
    .fluidOutputs(fluid('ammonia') * 2000)
    .fluidOutputs(fluid('dense_steam') * 3000)
    .EUt(3840)
    .duration(600)
    .buildAndRegister()

ROTARY_KILN.recipeBuilder()
    .inputs(ore('dustUraniumDioxide') * 3)
    .fluidInputs(fluid('hydrogen_fluoride') * 4000)
    .outputs(metaitem('dustUraniumTetrafluoride') * 5)
    .fluidOutputs(fluid('dense_steam') * 2000)
    .EUt(VA[EV])
    .duration(80)
    .buildAndRegister()

FLUIDIZED_BR.recipeBuilder()
    .inputs(ore('dustUraniumTetrafluoride') * 5)
    .fluidInputs(fluid('fluorine') * 2000)
    .fluidOutputs(fluid('natural_uranium_hexafluoride') * 1000)
    .EUt(240)
    .duration(80)
    .buildAndRegister()

// From reprocessing

// Second PUREX cycle for purification
MIXER_SETTLER.recipeBuilder()
    .fluidInputs(fluid('reprocessed_uranium_concentrate') * 1500)
    .fluidInputs(fluid('actinide_separation_mixture') * 10000)
    .fluidOutputs(fluid('radioactive_wastewater') * 1500)
    .fluidOutputs(fluid('reextracted_reprocessed_uranium_extract') * 10000)
    .requiredCells(4)
    .duration(120)
    .EUt(VA[HV])
    .buildAndRegister();

MIXER_SETTLER.recipeBuilder()
    .fluidInputs(fluid('reextracted_reprocessed_uranium_extract') * 10000)
    .fluidInputs(fluid('plutonium_reduction_solution') * 10)
    .fluidOutputs(fluid('purified_reprocessed_uranium_extract') * 10000)
    .fluidOutputs(fluid('radioactive_wastewater') * 10)
    .requiredCells(4)
    .duration(120)
    .EUt(VA[HV])
    .buildAndRegister();

MIXER_SETTLER.recipeBuilder()
    .fluidInputs(fluid('purified_reprocessed_uranium_extract') * 10000)
    .fluidInputs(fluid('diluted_nitric_acid') * 2000)
    .fluidOutputs(fluid('radiolyzed_actinide_separation_mixture') * 10000)
    .fluidOutputs(fluid('purified_reprocessed_uranium_concentrate') * 2000)
    .requiredCells(4)
    .duration(120)
    .EUt(VA[HV])
    .buildAndRegister();

FIXED_BR.recipeBuilder()
    .notConsumable(ore('catalystBedSilicaGel'))
    .fluidInputs(fluid('purified_reprocessed_uranium_concentrate') * 2000)
    .fluidOutputs(fluid('reprocessed_uranyl_nitrate_solution') * 2000)
    .duration(60)
    .EUt(VA[HV])
    .buildAndRegister();

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('reprocessed_uranyl_nitrate_solution') * 2000)
    .outputs(metaitem('dustReprocessedUranylNitrate') * 11)
    .fluidOutputs(fluid('acidic_wastewater') * 2000)
    .duration(20)
    .EUt(VA[LV])
    .buildAndRegister(); 

ROASTER.recipeBuilder()
    .inputs(ore('dustReprocessedUranylNitrate') * 11)
    .outputs(metaitem('dustReprocessedUraniumTrioxide') * 4)
    .fluidOutputs(fluid('nitrogen_dioxide') * 2000)
    .fluidOutputs(fluid('oxygen') * 1000)
    .duration(120)
    .EUt(VA[HV])
    .buildAndRegister();

REACTION_FURNACE.recipeBuilder()
    .inputs(ore('dustReprocessedUraniumTrioxide') * 4)
    .fluidInputs(fluid('hydrogen') * 2000)
    .outputs(metaitem('dustReprocessedUraniumDioxide') * 3)
    .fluidOutputs(fluid('dense_steam') * 1000)
    .duration(120)
    .EUt(VA[HV])
    .buildAndRegister();

ROTARY_KILN.recipeBuilder()
    .inputs(ore('dustReprocessedUraniumDioxide') * 3)
    .fluidInputs(fluid('hydrogen_fluoride') * 4000)
    .outputs(metaitem('dustReprocessedUraniumTetrafluoride') * 5)
    .fluidOutputs(fluid('dense_steam') * 2000)
    .EUt(VA[EV])
    .duration(80)
    .buildAndRegister()

FLUIDIZED_BR.recipeBuilder()
    .inputs(ore('dustReprocessedUraniumTetrafluoride') * 5)
    .fluidInputs(fluid('fluorine') * 2000)
    .fluidOutputs(fluid('reprocessed_uranium_hexafluoride') * 1000)
    .EUt(240)
    .duration(80)
    .buildAndRegister()
