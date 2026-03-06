import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Novolac-based photoresists

    // Diazonaphthoquinone

    FIXED_BR.recipeBuilder()
        .notConsumable(ore('catalystBedChromiumTrioxide'))
        .fluidInputs(fluid('tetralin') * 50)
        .fluidInputs(fluid('oxygen') * 100)
        .fluidOutputs(fluid('one_tetralone') * 50)
        .fluidOutputs(fluid('water') * 50)
        .duration(2)
        .EUt(VA[MV])
        .buildAndRegister();

    FIXED_BR.recipeBuilder()
        .notConsumable(ore('catalystBedSupportedPalladium'))
        .fluidInputs(fluid('one_tetralone') * 1000)
        .outputs(metaitem('dustOneNaphthol'))
        .fluidOutputs(fluid('hydrogen') * 2000)
        .duration(100)
        .EUt(VA[MV])
        .buildAndRegister();

    BR.recipeBuilder()
        .fluidInputs(fluid('nitration_mixture') * 2000)
        .inputs(metaitem('dustOneNaphthol'))
        .outputs(metaitem('dustTwoNitroOneNaphthol'))
        .fluidOutputs(fluid('sulfuric_acid') * 1000)
        .duration(80)
        .EUt(VA[MV])
        .buildAndRegister();

    FIXED_BR.recipeBuilder()
        .notConsumable(ore('catalystBedSupportedPalladium'))
        .inputs(ore('dustTwoNitroOneNaphthol'))
        .fluidInputs(fluid('hydrogen') * 6000)
        .outputs(metaitem('dustTwoAminoOneNaphthol'))
        .fluidOutputs(fluid('dense_steam') * 2000)
        .duration(160)
        .EUt(VA[MV])
        .buildAndRegister();

    BR.recipeBuilder()
        .inputs(ore('dustSodiumNitrite') * 4)
        .inputs(ore('dustTwoAminoOneNaphthol'))
        .fluidInputs(fluid('hydrochloric_acid') * 2000)
        .fluidOutputs(fluid('one_naphthol_two_diazonium_chloride_solution') * 4000) // 4 H2O, 1 Diazonium Chloride, 1 NaCl
        .duration(80)
        .EUt(VA[MV])
        .buildAndRegister();

    BR.recipeBuilder()
        .inputs(ore('dustSodiumHydroxide') * 3)
        .fluidInputs(fluid('one_naphthol_two_diazonium_chloride_solution') * 4000)
        .outputs(metaitem('dustDiazonaphthoquinone'))
        .fluidOutputs(fluid('wastewater') * 5000)
        .duration(80)
        .EUt(VA[MV])
        .buildAndRegister();