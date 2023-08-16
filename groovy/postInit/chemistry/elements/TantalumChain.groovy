import static globals.Globals.*

FF = recipemap('froth_flotation')

// Beneficiation

// Tantalite

GRAVITY_SEPARATOR.recipeBuilder() // Sifted Tantalite
    .inputs(ore('dustTantalite'))
    .outputs(metaitem('dustSiftedTantalite'))
    .chancedOutput(metaitem('dustPegmatiteTailings'), 2500, 0)
    .chancedOutput(metaitem('dustNetherQuartz') * 2500, 0)
    .EUt(Globals.voltAmps[1])
    .duration(40)
    .buildAndRegister()

ELECTROMAGNETIC_SEPARATOR.recipeBuilder() // Tantalite Concentrate
    .inputs(ore('dustSiftedTantalite'))
    .outputs(metaitem('dustTantaliteConcentrate'))
    .chancedOutput(metaitem('dustPegmatiteTailings'), 2500, 0)
    .chancedOutput(metaitem('dustNetherQuartz') * 2500, 0)
    .EUt(Globals.voltAmps[1])
    .duration(20)
    .buildAndRegister()

MIXER.recipeBuilder() // Impure Tantalite Slurry
    .inputs(ore('dustTantaliteConcentrate') * 8)
    .fluidInputs(fluid('distilled_water') * 2000)
    .fluidOutputs(fluid('impure_tantalite_slurry') * 2000)
    .EUt(Globals.voltAmps[3])
    .duration(80)
    .buildAndRegister()

FF.recipeBuilder() // Tantalite Slurry
    .notConsumable(ore('dustSodiumFluorosilicate'))
    .fluidInputs(fluid('impure_tantalite_slurry') * 2000)
    .notConsumable(fluid('one_amidoethyl_two_alkyl_imidazoline') * 1000)
    .notConsumable(fluid('methyl_isobutyl_carbinol') * 100)
    .notConsumable(fluid('hydrochloric_acid') * 100)
    .fluidOutputs(fluid('tantalite_slurry') * 1000)
    .fluidOutputs(fluid('pegmatite_tailing_slurry') * 1000)
    .EUt(Globals.voltAmps[3])
    .duration(80)
    .buildAndRegister()

CLARIFIER.recipeBuilder() // Flotated Tantalite
    .fluidInputs(fluid('tantalite_slurry') * 1000)
    .outputs(metaitem('dustFlotatedtantalite') * 16)
    .fluidOutputs(fluid('wastewater') * 1000)
    .duration(20)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

AUTOCLAVE.recipeBuilder() // Impure Fluorotantalic Acid Solution
    .inputs(ore('dustFlotatedTantalite') * 1)
    .fluidInputs(fluid('hydrofluoric_acid') * 14000)
    .fluidInputs(fluid('sulfuric_acid') * 1000)
    .fluidOutputs(fluid('impure_fluorotantalic_acid_solution') * 20000)
    .duration(80)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

CENTRIFUGE.recipeBuilder() // Tantalum-rich Extract
    .fluidInputs(fluid('impure_fluorotantalic_acid_solution') * 20000)
    .fluidInputs(fluid('methyl_isobutyl_ketone') * 8000)
    .fluidOutputs(fluid('tantalum_rich_extract') * 8000)
    .fluidOutputs(fluid('metal_sulfate_waste') * 20000)
    .duration(80)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

CENTRIFUGE.recipeBuilder() // Scrubbed Tantalum-rich Extract
    .fluidInputs(fluid('tantalum_rich_extract') * 500)
    .notConsumable(fluid('sulfuric_acid') * 500)
    .fluidOutputs(fluid('scrubbed_tantalum_rich_extract') * 500)
    .duration(5)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

CENTRIFUGE.recipeBuilder() // Tantalum Extract
    .fluidInputs(fluid('scrubbed_tantalum_rich_extract') * 9000)
    .fluidInputs(fluid('distilled_water') * 1000)
    .fluidOutputs(fluid('tantalum_extract') * 9000)
    .fluidOutputs(fluid('purified_fluoroniobic_acid_solution') * 1000)
    .duration(90)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

MIXER.recipeBuilder()
    .fluidInputs(fluid('ammonia_solution') * 1000)
    .fluidInputs(fluid('water') * 1000)
    .fluidOutputs(fluid('diluted_ammonia_solution') * 1000)
    .duration(20)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

CENTRIFUGE.recipeBuilder() // Fluorotantalic Acid Solution
    .fluidInputs(fluid('tantalum_extract') * 8000)
    .fluidInputs(fluid('diluted_ammonia_solution') * 2000)
    .fluidOutputs(fluid('methyl_isobutyl_ketone') * 8000)
    .fluidOutputs(fluid('fluorotantalic_acid_solution') * 2000) // 9/5 mol Ta
    .duration(80)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

BR.recipeBuilder() // Potassium Heptafluorotantalate
    .inputs(ore('dustPotassiumFluoride') * 9)
    .fluidInputs(fluid('fluorotantalic_acid_solution') * 2500)
    .outputs(metaitem('dustPotassiumHeptafluorotantalate') * 20)
    .chancedOutput(metaitem('dustPotassiumHeptafluorotantalate') * 10, 2500, 0)
    .duration(90)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder() // Tantalum
    .inputs(ore('dustPotassiumHeptafluorotantalate') * 10)
    .inputs(ore('dustSodium') * 5)
    .outputs(metaitem('dustTantalum'))
    .outputs(metaitem('dustSodiumFluoride') * 10)
    .outputs(metaitem('dustPotassiumFluoride') * 4)
    .duration(40)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

// From columbite
CENTRIFUGE.recipeBuilder() // Fluorotantalic Acid Solution
    .fluidInputs(fluid('diluted_tantalum_extract') * 4500)
    .fluidInputs(fluid('diluted_ammonia_solution') * 250)
    .fluidOutputs(fluid('dilute_tantalum_extract') * 4500)
    .fluidOutputs(fluid('fluorotantalic_acid_solution') * 250) //0.2 mol of Ta per 8000L of dil. Ta ext.
    .duration(80)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()