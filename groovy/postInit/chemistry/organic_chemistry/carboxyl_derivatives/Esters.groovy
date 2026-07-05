import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Acetate esters

    // Methyl acetate

    CSTR.recipeBuilder()
        .fluidInputs(fluid('sulfuric_acid') * 50)
        .fluidInputs(fluid('diluted_acetic_acid') * 100)
        .fluidInputs(fluid('methanol') * 50)
        .fluidOutputs(fluid('acidic_methyl_acetate_water_mixture') * 200)
        .duration(2)
        .EUt(VA[LV])
        .buildAndRegister()

    CSTR.recipeBuilder()
        .fluidInputs(fluid('sulfuric_acid') * 50)
        .fluidInputs(fluid('acetic_acid') * 50)
        .fluidInputs(fluid('water') * 50)
        .fluidInputs(fluid('methanol') * 50)
        .fluidOutputs(fluid('acidic_methyl_acetate_water_mixture') * 200)
        .duration(2)
        .EUt(VA[LV])
        .buildAndRegister()

    DT.recipeBuilder()
        .fluidInputs(fluid('acidic_methyl_acetate_water_mixture') * 4000)
        .fluidOutputs(fluid('sulfuric_acid') * 1000)
        .fluidOutputs(fluid('water') * 2000)
        .fluidOutputs(fluid('methyl_acetate') * 1000)
        .duration(160)
        .EUt(VA[LV])
        .buildAndRegister()

    // Hydrolysis

    CSTR.recipeBuilder()
        .fluidInputs(fluid('sulfuric_acid') * 50)
        .fluidInputs(fluid('methyl_acetate') * 50)
        .fluidInputs(fluid('water') * 250)
        .fluidOutputs(fluid('acetic_acid_methanol_mixture') * 350)
        .duration(20)
        .EUt(VA[LV])
        .buildAndRegister()

    DT.recipeBuilder()
        .fluidInputs(fluid('acetic_acid_methanol_mixture') * 7000)
        .fluidOutputs(fluid('sulfuric_acid') * 1000)
        .fluidOutputs(fluid('acetic_acid') * 1000)
        .fluidOutputs(fluid('water') * 4000)
        .fluidOutputs(fluid('methanol') * 1000)
        .duration(160)
        .EUt(VA[LV])
        .buildAndRegister()

    // Ethyl acetate

        // Tishchenko Reaction

        BR.recipeBuilder()
            .notConsumable(ore('dustAluminiumIsopropoxide'))
            .fluidInputs(fluid('gtfo_acetaldehyde') * 2000)
            .fluidOutputs(fluid('ethyl_acetate') * 1000)
            .duration(80)
            .EUt(VA[MV])
            .buildAndRegister()

        // Fischer Esterification

        CSTR.recipeBuilder()
            .fluidInputs(fluid('sulfuric_acid') * 50)
            .fluidInputs(fluid('diluted_acetic_acid') * 100)
            .fluidInputs(fluid('ethanol') * 50)
            .fluidOutputs(fluid('acidic_ethyl_acetate_water_mixture') * 200)
            .duration(2)
            .EUt(VA[LV])
            .buildAndRegister()

        CSTR.recipeBuilder()
            .fluidInputs(fluid('sulfuric_acid') * 50)
            .fluidInputs(fluid('acetic_acid') * 50)
            .fluidInputs(fluid('water') * 50)
            .fluidInputs(fluid('ethanol') * 50)
            .fluidOutputs(fluid('acidic_ethyl_acetate_water_mixture') * 200)
            .duration(2)
            .EUt(VA[LV])
            .buildAndRegister()

        DT.recipeBuilder()
            .fluidInputs(fluid('acidic_ethyl_acetate_water_mixture') * 4000)
            .fluidOutputs(fluid('sulfuric_acid') * 1000)
            .fluidOutputs(fluid('water') * 2000)
            .fluidOutputs(fluid('ethyl_acetate') * 1000)
            .duration(160)
            .EUt(VA[LV])
            .buildAndRegister()

        // Hydrolysis

        CSTR.recipeBuilder()
            .fluidInputs(fluid('sulfuric_acid') * 50)
            .fluidInputs(fluid('ethyl_acetate') * 50)
            .fluidInputs(fluid('water') * 250)
            .fluidOutputs(fluid('acetic_acid_ethanol_mixture') * 350)
            .duration(20)
            .EUt(VA[LV])
            .buildAndRegister()

        DT.recipeBuilder()
            .fluidInputs(fluid('acetic_acid_ethanol_mixture') * 7000)
            .fluidOutputs(fluid('sulfuric_acid') * 1000)
            .fluidOutputs(fluid('acetic_acid') * 1000)
            .fluidOutputs(fluid('water') * 4000)
            .fluidOutputs(fluid('ethanol') * 1000)
            .duration(160)
            .EUt(VA[LV])
            .buildAndRegister()