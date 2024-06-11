import globals.Globals

BR = recipemap('batch_reactor')
ROASTER = recipemap('roaster')

// BENEFICIATION

    // LIQUIDATION (1.5x)

    ROASTER.recipeBuilder()
        .inputs(ore('dustImpureStibnite') * 2)
        .notConsumable(fluid('nitrogen') * 8000)
        .outputs(metaitem('dustStibnite') * 3)
        .outputs(metaitem('dustPegmatiteTailings'))
        .EUt(Globals.voltAmps[2])
        .duration(200)
        .buildAndRegister()

    // FLOTATION (2x)

    MIXER.recipeBuilder()
        .inputs(ore('dustImpureStibnite') * 8)
        .fluidInputs(fluid('distilled_water') * 2000)
        .fluidOutputs(fluid('impure_stibnite_slurry') * 2000)
        .EUt(Globals.voltAmps[3])
        .duration(80)
        .buildAndRegister()

    FLOTATION.recipeBuilder()
        .fluidInputs(fluid('impure_galena_slurry') * 2000)
        .notConsumable(metaitem('dustSodiumIsobutylXanthate'))
        .notConsumable(metaitem('dustLeadNitrate'))
        .notConsumable(fluid('sodium_cyanide_solution') * 100)
        .fluidOutputs(fluid('stibnite_slurry') * 1000)
        .fluidOutputs(fluid('pegmatite_tailing_slurry') * 1000)
        .EUt(Globals.voltAmps[3])
        .duration(80)
        .buildAndRegister()

    CLARIFIER.recipeBuilder()
        .fluidInputs(fluid('stibnite_slurry') * 1000)
        .outputs(metaitem('dustStibnite') * 16)
        .fluidOutputs(fluid('wastewater') * 1000)
        .EUt(Globals.voltAmps[1])
        .duration(20)
        .buildAndRegister()

// PROCESSING

ROASTER.recipeBuilder()
    .inputs(ore('dustAntimonyIiiSulfide') * 5)
    .fluidInputs(fluid('oxygen') * 9000)
    .outputs(metaitem('dustAntimonyIiiOxide') * 5)
    .fluidOutputs(fluid('sulfur_dioxide') * 3000)
    .EUt(Globals.voltAmps[2])
    .duration(200)
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustStibnite'))
    .fluidInputs(fluid('oxygen') * 9000)
    .outputs(metaitem('dustAntimonyIiiOxide') * 5)
    .fluidOutputs(fluid('sulfur_dioxide') * 3000)
    .EUt(Globals.voltAmps[2])
    .duration(200)
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustAntimonyIiiOxide') * 5)
    .inputs(ore('dustAnyPurityCarbon') * 3)
    .outputs(metaitem('dustAntimony') * 2)
    .fluidOutputs(fluid('carbon_monoxide') * 3000)
    .EUt(Globals.voltAmps[2])
    .duration(200)
    .buildAndRegister()

// FROM LEAD (KROLL-BETTERTON PROCESS)

BR.recipeBuilder()
    .fluidInputs(fluid('antimony_dross') * 720)
    .fluidInputs(fluid('chlorine') * 6000)
    .outputs(metaitem('dustAntimony') * 2)
    .outputs(metaitem('dustMagnesiumChloride') * 6)
    .outputs(metaitem('dustCalciumChloride') * 3)
    .EUt(Globals.voltAmps[2])
    .duration(200)
    .buildAndRegister()

// FROM LEAD (ANODE SLIME)

ROASTER.recipeBuilder()
    .inputs(ore('dustAntimonyArsenicFlue') * 5)
    .inputs(ore('dustSodiumHydroxide') * 54)
    .outputs(metaitem('dustAntimony') * 4)
    .outputs(metaitem('dustSodiumArsenate') * 48)
    .fluidOutputs(fluid('steam') * 9000)
    .EUt(Globals.voltAmps[2])
    .duration(200)
    .buildAndRegister()