import globals.Globals

SIEVE_DT = recipemap('sieve_distillation')
ION_EXCHANGE = recipemap('ion_exchange_column')
ELECTROLYZER = recipemap('electrolyzer')
ELECTROLYTIC_CELL = recipemap('electrolytic_cell')
BR = recipemap('batch_reactor')

ION_EXCHANGE.recipeBuilder()
    .notConsumable(metaitem('beads.strong_acidic_cation_exchange'))
    .fluidInputs(fluid('sea_water') * 12800)
    .fluidInputs(fluid('diluted_sulfuric_acid') * 20)
    .fluidOutputs(fluid('partially_deionized_sea_water') * 12800)
    .EUt(480)
    .duration(20)
    .buildAndRegister()

ION_EXCHANGE.recipeBuilder()
    .notConsumable(metaitem('beads.strong_basic_anion_exchange'))
    .fluidInputs(fluid('partially_deionized_sea_water') * 12800)
    .fluidInputs(fluid('diluted_sodium_hydroxide_solution') * 20)
    .fluidOutputs(fluid('deionized_sea_water') * 12800)
    .EUt(480)
    .duration(20)
    .buildAndRegister()

// Stage 1: 8x enrichment of deuterium from sea water, D = 0.015625% -> 0.125%

    // Cold tower stage 1
    SIEVE_DT.recipeBuilder()
        .circuitMeta(1)
        .fluidInputs(fluid('deionized_sea_water') * 128000)
        .fluidInputs(fluid('hydrogen_sulfide') * 112000)
        .fluidOutputs(fluid('lightly_enriched_water') * 128000)
        .fluidOutputs(fluid('depleted_hydrogen_sulfide') * 112000)
        .EUt(480)
        .duration(200)
        .buildAndRegister()

    // Hot tower stage 1
    SIEVE_DT.recipeBuilder() 
        .circuitMeta(1)
        .fluidInputs(fluid('lightly_enriched_water') * 112000)
        .fluidInputs(fluid('depleted_hydrogen_sulfide') * 112000)
        .fluidOutputs(fluid('water') * 112000)
        .fluidOutputs(fluid('hydrogen_sulfide') * 112000)
        .EUt(480)
        .duration(200)
        .buildAndRegister()

// Stage 2, further 8x enrichment of deuterium, D = 0.125% -> 1%

    // Stage 2 bootstrap
    SIEVE_DT.recipeBuilder()
        .circuitMeta(2)
        .fluidInputs(fluid('lightly_enriched_water') * 16000)
        .fluidInputs(fluid('hydrogen_sulfide') * 14000)
        .fluidOutputs(fluid('water') * 16000)
        .fluidOutputs(fluid('lightly_enriched_hydrogen_sulfide') * 14000)
        .EUt(480)
        .duration(2000)
        .buildAndRegister()

    // Cold tower stage 2
    SIEVE_DT.recipeBuilder() 
        .circuitMeta(2)
        .fluidInputs(fluid('lightly_enriched_water') * 16000)
        .fluidInputs(fluid('lightly_enriched_hydrogen_sulfide') * 14000)
        .fluidOutputs(fluid('medium_enriched_water') * 16000)
        .fluidOutputs(fluid('hydrogen_sulfide') * 14000)
        .EUt(480).duration(200)
        .buildAndRegister()

    // Hot tower stage 2
    SIEVE_DT.recipeBuilder() 
        .circuitMeta(2)
        .fluidInputs(fluid('medium_enriched_water') * 14000)
        .fluidInputs(fluid('hydrogen_sulfide') * 14000)
        .fluidOutputs(fluid('water') * 14000)
        .fluidOutputs(fluid('lightly_enriched_hydrogen_sulfide') * 14000)
        .EUt(480).duration(200)
        .buildAndRegister()

// Stage 3, final 20x enrichment of deuterium, D = 1% -> 20%

    // Stage 3 bootstrap
    SIEVE_DT.recipeBuilder()
        .circuitMeta(3)
        .fluidInputs(fluid('medium_enriched_water') * 2000)
        .fluidInputs(fluid('lightly_enriched_hydrogen_sulfide') * 1900)
        .fluidOutputs(fluid('water') * 2000)
        .fluidOutputs(fluid('medium_enriched_hydrogen_sulfide') * 1900)
        .EUt(480)
        .duration(2000)
        .buildAndRegister()

    // Cold tower stage 3
    SIEVE_DT.recipeBuilder() 
        .circuitMeta(3)
        .fluidInputs(fluid('medium_enriched_water') * 2000)
        .fluidInputs(fluid('medium_enriched_hydrogen_sulfide') * 1900)
        .fluidOutputs(fluid('highly_enriched_water') * 2000)
        .fluidOutputs(fluid('lightly_enriched_hydrogen_sulfide') * 1900)
        .EUt(480)
        .duration(200)
        .buildAndRegister()

    // Hot tower stage 3
    SIEVE_DT.recipeBuilder() 
        .circuitMeta(3)
        .fluidInputs(fluid('highly_enriched_water') * 1900)
        .fluidInputs(fluid('lightly_enriched_hydrogen_sulfide') * 1900)
        .fluidOutputs(fluid('water') * 1900)
        .fluidOutputs(fluid('medium_enriched_hydrogen_sulfide') * 1900)
        .EUt(480)
        .duration(200)
        .buildAndRegister()

SIEVE_DT.recipeBuilder() // Final purification
    .circuitMeta(1)
    .fluidInputs(fluid('highly_enriched_water') * 100)
    .fluidOutputs(fluid('heavy_water') * 20)
    .fluidOutputs(fluid('water') * 80)
    .EUt(480)
    .duration(200)
    .buildAndRegister()

ELECTROLYZER.recipeBuilder()
    .notConsumable(metaitem('stickNickel'))
    .notConsumable(metaitem('stickIron'))
    .fluidInputs(fluid('heavy_water') * 1000)
    .fluidOutputs(fluid('deuterium') * 2000)
    .fluidOutputs(fluid('oxygen') * 1000)
    .EUt(30)
    .duration(1500)
    .buildAndRegister()

ELECTROLYTIC_CELL.recipeBuilder()
    .notConsumable(metaitem('stickNickel'))
    .notConsumable(metaitem('stickIron'))
    .notConsumable(fluid('sodium_hydroxide_solution') * 50)
    .fluidInputs(fluid('heavy_water') * 1000)
    .fluidOutputs(fluid('deuterium') * 2000)
    .fluidOutputs(fluid('oxygen') * 1000)
    .EUt(30)
    .duration(200)
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('deuterium') * 2000)
    .fluidInputs(fluid('oxygen') * 1000)
    .fluidOutputs(fluid('heavy_water') * 1000)
    .duration(10)
    .EUt(7)
    .buildAndRegister()