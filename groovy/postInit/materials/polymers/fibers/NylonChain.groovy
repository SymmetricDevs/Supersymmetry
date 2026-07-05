import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Hydroxylamine for oxime formation

FIXED_BR.recipeBuilder()
    .fluidInputs(fluid('nitric_oxide') * 50)
    .fluidInputs(fluid('hydrogen') * 150)
    .notConsumable(ore('catalystBedPlatinum'))
    .fluidOutputs(fluid('hydroxylamine') * 50)
    .duration(5)    
    .EUt(VA[LV])
    .buildAndRegister()

// Cyclohexanone/cyclohexanol for caprolactam production

    // By oxidation of cyclohexane

    BR.recipeBuilder()
        .inputs(ore('dustTinyCobaltIiAcetateTetrahydrate'))
        .fluidInputs(fluid('cyclohexane') * 9000)
        .fluidInputs(fluid('oxygen') * 11000)
        .fluidOutputs(fluid('crude_ketone_alcohol_oil') * 11000) // 7 parts alcohol, 2 part ketone, 2 part water
        .duration(400) 
        .EUt(VA[LV])
        .buildAndRegister()

    CENTRIFUGE.recipeBuilder() // Removal of catalyst, organic acid side products, water
        .fluidInputs(fluid('crude_ketone_alcohol_oil') * 11000)
        .fluidInputs(fluid('soda_ash_solution') * 500)
        .fluidOutputs(fluid('ketone_alcohol_oil') * 9000)
        .fluidOutputs(fluid('wastewater') * 2500)
        .duration(100)
        .EUt(VA[ULV])
        .buildAndRegister()

    DT.recipeBuilder()
        .fluidInputs(fluid('ketone_alcohol_oil') * 9000)
        .fluidOutputs(fluid('cyclohexanol') * 7000)
        .fluidOutputs(fluid('cyclohexanone') * 2000)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister()

    // Oxidation of cyclohexanol to cyclohexanone

    FIXED_BR.recipeBuilder()
        .notConsumable(ore('catalystBedSupportedNickel'))
        .fluidInputs(fluid('cyclohexanol') * 50)
        .fluidOutputs(fluid('cyclohexanone') * 50)
        .fluidOutputs(fluid('hydrogen') * 100)
        .duration(10)
        .EUt(VA[MV])
        .buildAndRegister()

    // By hydrogenation of phenol

    FIXED_BR.recipeBuilder()
        .notConsumable(ore('catalystBedSupportedNickel'))
        .fluidInputs(fluid('phenol') * 50)
        .fluidInputs(fluid('hydrogen') * 300)
        .fluidOutputs(fluid('cyclohexanol') * 50)
        .duration(15)
        .EUt(VA[LV])
        .buildAndRegister()

    FIXED_BR.recipeBuilder()
        .notConsumable(ore('catalystBedSupportedPalladium'))
        .fluidInputs(fluid('phenol') * 50)
        .fluidInputs(fluid('hydrogen') * 200)
        .fluidOutputs(fluid('cyclohexanone') * 50)
        .duration(15)
        .EUt(VA[LV])
        .buildAndRegister()

// Final processing

BR.recipeBuilder()
    .fluidInputs(fluid('cyclohexanone') * 1000)
    .fluidInputs(fluid('hydroxylamine') * 1000)
    .fluidOutputs(fluid('water') * 1000)
    .outputs(metaitem('dustCyclohexanoneOxime') * 19)
    .duration(180)
    .EUt(VA[LV])
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustCyclohexanoneOxime') * 19)
    .fluidInputs(fluid('sulfuric_acid') * 1000)
    .fluidInputs(fluid('ammonia_solution') * 2000)
    .fluidOutputs(fluid('caprolactam_solution') * 3000)
    .duration(160)
    .EUt(VA[LV])
    .buildAndRegister()

LCR.recipeBuilder()
    .fluidInputs(fluid('cyclohexanone') * 1000)
    .fluidInputs(fluid('hydroxylamine') * 1000)
    .fluidInputs(fluid('sulfuric_acid') * 1000)
    .fluidInputs(fluid('ammonia_solution') * 2000)
    .fluidOutputs(fluid('water') * 1000)
    .fluidOutputs(fluid('caprolactam_solution') * 3000)
    .duration(160)
    .EUt(VA[HV])
    .buildAndRegister()

CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('caprolactam_solution') * 3000)
    .fluidInputs(fluid('toluene') * 1000)
    .fluidOutputs(fluid('extracted_caprolactam_solution') * 1000)
    .fluidOutputs(fluid('diluted_ammonium_sulfate_solution') * 1000)
    .duration(160)
    .EUt(VA[LV])
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('diluted_ammonium_sulfate_solution') * 1000)
    .outputs(metaitem('dustAmmoniumSulfate') * 15)
    .fluidOutputs(fluid('water') * 2000)
    .duration(160)
    .EUt(VA[LV])
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('extracted_caprolactam_solution') * 1000)
    .outputs(metaitem('dustCaprolactam'))
    .fluidOutputs(fluid('toluene') * 1000)
    .duration(160)
    .EUt(VA[LV])
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustAmmoniumSulfate') * 15)
    .fluidOutputs(fluid('ammonia') * 1000)
    .outputs(metaitem('dustAmmoniumBisulfate') * 11)
    .duration(160)
    .EUt(VA[LV])
    .buildAndRegister()

// Polycaprolactam

REACTION_FURNACE.recipeBuilder()
    .notConsumable(fluid('nitrogen') * 4000)
    .inputs(ore('dustCaprolactam'))
    .outputs(metaitem('dustPolycaprolactam'))
    .duration(120)
    .EUt(VA[MV])
    .buildAndRegister()
