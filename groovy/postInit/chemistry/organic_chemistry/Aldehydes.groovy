import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Acetaldehyde
// Source: Acetaldehyde Chapter in Ullmann's Encyclopedia of Industrial Chemistry https://doi.org/10.1002/14356007.a01_031

// Dehydrogenation of Ethanol

FIXED_BR.recipeBuilder()
    .notConsumable(ore('catalystBedCopper'))
    .fluidInputs(fluid('ethanol') * 50)
    .fluidOutputs(fluid('gtfo_acetaldehyde') * 50)
    .fluidOutputs(fluid('hydrogen') * 100)
    .duration(5)
    .EUt(VA[MV])
    .buildAndRegister()

// Partial Oxidation of Ethanol

FIXED_BR.recipeBuilder()
    .notConsumable(ore('catalystBedSilver'))
    .fluidInputs(fluid('ethanol') * 50)
    .fluidInputs(fluid('oxygen') * 50)
    .fluidOutputs(fluid('acetaldehyde_solution') * 50)
    .duration(10)
    .EUt(VA[LV])
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('acetaldehyde_solution') * 1000)
    .fluidOutputs(fluid('water') * 1000)
    .fluidOutputs(fluid('gtfo_acetaldehyde') * 1000)
    .duration(80)
    .EUt(VA[LV])
    .buildAndRegister()

FLUIDIZED_BR.recipeBuilder()
    .notConsumable(ore('catalystBedSilver'))
    .fluidInputs(fluid('ethanol') * 500)    
    .fluidInputs(fluid('oxygen') * 500)
    .fluidOutputs(fluid('acetaldehyde_solution') * 500)
    .duration(50)
    .EUt(VA[LV])
    .buildAndRegister()

// Oxidation of Acetylene

BR.recipeBuilder() // Source: Mercury, Mercury Alloys, and Mercury Compounds Chapter in Ullmann's Encyclopedia of Industrial Chemistry https://doi.org/10.1002/14356007.a16_269
    .inputs(ore('dustMercuryIiOxide') * 2)
    .fluidInputs(fluid('sulfuric_acid') * 1000)
    .fluidOutputs(fluid('mercury_ii_sulfate_solution') * 1000)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

BCR.recipeBuilder()
    .notConsumable(ore('springCupronickel'))
    .notConsumable(fluid('mercury_ii_sulfate_solution') * 1000)
    .fluidInputs(fluid('acetylene') * 50)
    .fluidInputs(fluid('water') * 50)
    .fluidOutputs(fluid('gtfo_acetaldehyde') * 50)
    .duration(5)
    .EUt(VA[MV])
    .buildAndRegister()

// Wacker Process

BR.recipeBuilder() // Source: Platinum Group Metals and Compounds Chapter in Ullmann's Encyclopedia of Industrial Chemistry https://doi.org/10.1002/14356007.a21_075
    .inputs(ore('dustAnyPurityPalladium'))
    .fluidInputs(fluid('chlorine') * 2000)
    .fluidInputs(fluid('hydrochloric_acid') * 2000)
    .fluidInputs(fluid('distilled_water') * 6000)
    .fluidOutputs(fluid('tetrachloropalladic_ii_acid_solution') * 8000)
    .duration(160)
    .EUt(VA[MV])
    .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
    .notConsumable(ore('springCupronickel'))
    .fluidInputs(fluid('tetrachloropalladic_ii_acid_solution') * 8000)
    .fluidInputs(fluid('diluted_hydrochloric_acid') * 2000)
    .outputs(metaitem('dustPalladiumChlorideDihydrate') * 5)
    .fluidOutputs(fluid('diluted_hydrochloric_acid') * 8000)
    .fluidOutputs(fluid('dense_steam') * 2000)
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustCupricOxide') * 2)
    .fluidInputs(fluid('hydrochloric_acid') * 2000)
    .fluidOutputs(fluid('copper_ii_chloride_solution') * 2000)
    .EUt(VA[MV])
    .duration(200)
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('copper_ii_chloride_solution') * 2000)
    .outputs(metaitem('dustCopperIiChloride') * 3)
    .fluidOutputs(fluid('water') * 2000)
    .EUt(VA[LV])
    .duration(200)
    .buildAndRegister()

MIXER.recipeBuilder()
    .fluidInputs(fluid('water') * 1000)
    .inputs(ore('dustPalladiumChlorideDihydrate') * 3)
    .inputs(ore('dustCopperIiChloride') * 3)
    .fluidOutputs(fluid('wacker_catalyst_solution') * 1000)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

BCR.recipeBuilder()
    .notConsumable(fluid('wacker_catalyst_solution') * 1000)
    .fluidInputs(fluid('ethylene') * 50)
    .fluidInputs(fluid('oxygen') * 50)
    .fluidOutputs(fluid('gtfo_acetaldehyde') * 50)
    .duration(1)
    .EUt(VA[EV])
    .buildAndRegister()

// Butyraldehyde

    // Crotonaldehyde route

    BR.recipeBuilder()
        .notConsumable(ore('springCupronickel'))
        .fluidInputs(fluid('gtfo_acetaldehyde') * 2000)
        .fluidInputs(fluid('sodium_hydroxide_solution') * 1000)
        .fluidOutputs(fluid('crotonaldehyde_mixture') * 1000)
        .fluidOutputs(fluid('dense_steam') * 2000)
        .duration(400)
        .EUt(VA[MV])
        .buildAndRegister()

    DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('crotonaldehyde_mixture') * 1000)
        .outputs(metaitem('dustSodiumHydroxide') * 3)
        .fluidOutputs(fluid('crotonaldehyde') * 1000)
        .duration(20)
        .EUt(VA[LV])
        .buildAndRegister()

    FIXED_BR.recipeBuilder()
        .notConsumable(ore('catalystBedCopper'))
        .fluidInputs(fluid('crotonaldehyde') * 50)
        .fluidInputs(fluid('hydrogen') * 100)
        .fluidOutputs(fluid('butyraldehyde') * 50)
        .duration(20)
        .EUt(VA[MV])
        .buildAndRegister()

    // Direct carbonylation

    REACTION_FURNACE.recipeBuilder()
        .inputs(ore('dustDicobaltOctacarbonyl') * 18)
        .fluidInputs(fluid('propene') * 1000)
        .fluidInputs(fluid('carbon_monoxide') * 1000)
        .fluidInputs(fluid('hot_hp_hydrogen') * 2000)
        .fluidOutputs(fluid('butyraldehyde_mixture') * 1000)
        .duration(100)
        .EUt(240)
        .buildAndRegister()

    DT.recipeBuilder()
        .fluidInputs(fluid('butyraldehyde_mixture') * 1000)
        .outputs(metaitem('dustDicobaltOctacarbonyl') * 18)
        .fluidOutputs(fluid('butyraldehyde') * 800)
        .fluidOutputs(fluid('isobutyraldehyde') * 200)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister()