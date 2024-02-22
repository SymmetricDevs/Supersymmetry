import globals.Globals

FF = recipemap('froth_flotation')
GRAVITY_SEPARATOR = recipemap('gravity_separator')
ELECTROMAGNETIC_SEPARATOR = recipemap('electromagnetic_separator')
ROASTER = recipemap('roaster')
AUTOCLAVE = recipemap('autoclave')
CENTRIFUGE = recipemap('centrifuge')
ADVANCED_ARC_FURNACE = recipemap('advanced_arc_furnace')
FLUID_SOLIDIFIER = recipemap('fluid_solidifier')
BR = recipemap('batch_reactor')
MIXER = recipemap('mixer')
CLARIFIER = recipemap('clarifier')
CHEMICAL_BATH = recipemap('chemical_bath')
CRYSTALLIZER = recipemap('crystallizer')
REACTION_FURNACE = recipemap('reaction_furnace')

// Beneficiation

// Tantalite

GRAVITY_SEPARATOR.recipeBuilder() // Sifted Tantalite
    .inputs(ore('dustTantalite'))
    .outputs(metaitem('dustSiftedTantalite'))
    .chancedOutput(metaitem('dustPegmatiteTailings'), 2500, 0)
    .chancedOutput(metaitem('dustNetherQuartz'), 2500, 0)
    .EUt(Globals.voltAmps[1])
    .duration(40)
    .buildAndRegister()

ELECTROMAGNETIC_SEPARATOR.recipeBuilder() // Tantalite Concentrate
    .inputs(ore('dustSiftedTantalite'))
    .outputs(metaitem('dustConcentrateTantalite'))
    .chancedOutput(metaitem('dustPegmatiteTailings'), 2500, 0)
    .chancedOutput(metaitem('dustNetherQuartz'), 2500, 0)
    .EUt(Globals.voltAmps[1])
    .duration(20)
    .buildAndRegister()

MIXER.recipeBuilder() // Impure Tantalite Slurry
    .inputs(ore('dustConcentrateTantalite') * 8)
    .fluidInputs(fluid('distilled_water') * 2000)
    .fluidOutputs(fluid('impure_tantalite_slurry') * 2000)
    .EUt(Globals.voltAmps[3])
    .duration(80)
    .buildAndRegister()

FF.recipeBuilder() // Tantalite Slurry
    .notConsumable(ore('dustSodiumFluorosilicate'))
    .fluidInputs(fluid('impure_tantalite_slurry') * 2000)
    .notConsumable(fluid('one_amidoethyl_two_alkyl_two_imidazoline') * 100)
    .notConsumable(fluid('methyl_isobutyl_carbinol') * 100)
    .notConsumable(fluid('hydrochloric_acid') * 100)
    .fluidOutputs(fluid('tantalite_slurry') * 1000)
    .fluidOutputs(fluid('pegmatite_tailing_slurry') * 1000)
    .EUt(Globals.voltAmps[3])
    .duration(80)
    .buildAndRegister()

CLARIFIER.recipeBuilder() // Flotated Tantalite
    .fluidInputs(fluid('tantalite_slurry') * 1000)
    .outputs(metaitem('dustFlotatedTantalite') * 16)
    .fluidOutputs(fluid('wastewater') * 1000)
    .duration(20)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

AUTOCLAVE.recipeBuilder() // Impure Fluorotantalic Acid Solution
    .inputs(ore('dustFlotatedTantalite') * 1)
    .fluidInputs(fluid('hydrogen_fluoride') * 14000)
    .fluidInputs(fluid('diluted_sulfuric_acid') * 2000)
    .fluidOutputs(fluid('impure_fluorotantalic_acid_solution') * 1000)
    .duration(80)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

CENTRIFUGE.recipeBuilder() // Tantalum-rich Extract
    .fluidInputs(fluid('impure_fluorotantalic_acid_solution') * 1000)
    .fluidInputs(fluid('methyl_isobutyl_ketone') * 8000)
    .fluidOutputs(fluid('tantalum_rich_extract') * 8000)
    .fluidOutputs(fluid('metal_sulfate_waste') * 1000)
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

CENTRIFUGE.recipeBuilder() // Fluorotantalic Acid Solution
    .fluidInputs(fluid('tantalum_extract') * 8000)
    .fluidInputs(fluid('diluted_ammonia_solution') * 2000)
    .fluidOutputs(fluid('methyl_isobutyl_ketone') * 8000)
    .fluidOutputs(fluid('fluorotantalic_acid_solution') * 2000) // 9/5 mol Ta
    .duration(80)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

CRYSTALLIZER.recipeBuilder() // Potassium Heptafluorotantalate
    .inputs(ore('dustPotassiumFluoride') * 36)
    .fluidInputs(fluid('fluorotantalic_acid_solution') * 5000)
    .outputs(metaitem('dustPotassiumHeptafluorotantalate') * 45)
    .fluidOutputs(fluid('hydrofluoric_ammonia_mixture') * 5000)
    .duration(180)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
    .fluidInputs(fluid('hydrofluoric_ammonia_mixture') * 2500)
    .fluidOutputs(fluid('water') * 2500)
    .fluidOutputs(fluid('hydrogen_fluoride') * 9000)
    .fluidOutputs(fluid('ammonia') * 1250)
    .duration(90)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder() // Tantalum
    .inputs(ore('dustPotassiumHeptafluorotantalate') * 10)
    .inputs(ore('dustAnyPuritySodium') * 5)
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
    .fluidOutputs(fluid('methyl_isobutyl_ketone') * 4500)
    .fluidOutputs(fluid('fluorotantalic_acid_solution') * 250) //0.2 mol of Ta per 8000L of dil. Ta ext.
    .duration(80)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

// From pyrochlore
FLUID_SOLIDIFIER.recipeBuilder()
    .fluidInputs(fluid('tantalum_pentachloride') * 1000)
    .outputs(metaitem('dustTantalumPentachloride') * 6)
    .duration(100)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustTantalumPentachloride') * 6)
    .fluidInputs(fluid('hydrogen_fluoride') * 5000)
    .outputs(metaitem('dustTantalumFluoride') * 6)
    .fluidOutputs(fluid('hydrogen_chloride') * 5000)
    .duration(100)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustTantalumFluoride') * 6)
    .fluidInputs(fluid('distilled_water') * 2000)
    .fluidOutputs(fluid('tantalum_fluoride_solution') * 2000)
    .duration(100)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
    .inputs(ore('dustPotassiumFluoride') * 4)
    .fluidInputs(fluid('tantalum_fluoride_solution') * 2000)
    .outputs(metaitem('dustPotassiumHeptafluorotantalate') * 10)
    .fluidOutputs(fluid('hydrofluoric_acid') * 2000)
    .duration(100)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()


    
