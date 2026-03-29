import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Sulfur dioxide

ROASTER.recipeBuilder()
    .circuitMeta(1)
    .inputs(ore('dustSulfur'))
    .fluidInputs(fluid('air') * 3000)
    .fluidOutputs(fluid('sulfur_dioxide') * 1000)
    .duration(120)
    .EUt(VA[ULV])
    .buildAndRegister()

ROASTER.recipeBuilder()
    .circuitMeta(2)
    .inputs(ore('dustSulfur'))
    .fluidInputs(fluid('air') * 3750)
    .fluidOutputs(fluid('glover_tower_mixture') * 1750)
    .duration(120)
    .EUt(VA[ULV])
    .buildAndRegister()

MIXER.recipeBuilder()
    .fluidInputs(fluid('sulfur_dioxide') * 1000)
    .fluidInputs(fluid('air') * 750)
    .fluidOutputs(fluid('glover_tower_mixture') * 1750)
    .duration(10)
    .EUt(VA[ULV])
    .buildAndRegister()

// Iron sulfides and sulfates

ROASTER.recipeBuilder()
    .circuitMeta(2)
    .inputs(ore('dustPyrite'))
    .outputs(metaitem('dustIronIiSulfide') * 2)
    .outputs(metaitem('dustSulfur'))
    .duration(80)
    .EUt(VA[ULV])
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustIronIiiSulfate'))
    .outputs(metaitem('dustBandedIron'))
    .fluidOutputs(fluid('sulfur_trioxide_reaction_mixture') * 6000)
    .duration(160)
    .EUt(VA[ULV])
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('hydrogen_sulfide') * 3000)
    .fluidInputs(fluid('oxygen') * 3000)
    .fluidOutputs(fluid('uncatalyzed_sulfurous_gases') * 3000)
    .outputs(metaitem('dustSulfur'))
    .duration(40)
    .EUt(VA[LV])
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('hydrogen_sulfide') * 3000)
    .fluidInputs(fluid('air') * 15000) //air is composed of ~21% oxygen
    .fluidOutputs(fluid('uncatalyzed_sulfurous_gases') * 3000)
    .outputs(metaitem('dustSulfur'))
    .duration(40)
    .EUt(VA[LV])
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .notConsumable(metaitem('catalystBedAlumina'))
    .fluidInputs(fluid('uncatalyzed_sulfurous_gases') * 3000)
    .fluidOutputs(fluid('dense_steam') * 3000)
    .outputs(metaitem('dustSulfur') * 2)
    .duration(40)
    .EUt(VA[LV])
    .buildAndRegister()

// Sodium bisulfite

BCR.recipeBuilder()
    .fluidInputs(fluid('sulfur_dioxide') * 50)
    .fluidInputs(fluid('sodium_hydroxide_solution') * 50)
    .fluidOutputs(fluid('sodium_bisulfite_solution') * 50)
    .duration(4)
    .EUt(VA[LV])
    .buildAndRegister()

// Sodium dithionite

BR.recipeBuilder()
    .inputs(ore('dustAnyPurityZinc'))
    .fluidInputs(fluid('water') * 1000)
    .fluidInputs(fluid('sulfur_dioxide') * 2000)
    .fluidOutputs(fluid('zinc_dithionite_solution') * 1000)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustSodiumHydroxide') * 6)
    .fluidInputs(fluid('zinc_dithionite_solution') * 1000)
    .fluidOutputs(fluid('sodium_dithionite_solution') * 1000)
    .outputs(metaitem('dustZincHydroxide') * 5)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('sodium_dithionite_solution') * 1000)
    .outputs(metaitem('dustSodiumDithionite') * 7)
    .fluidOutputs(fluid('water') * 1000)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

// Sulfuric acid

MIXER.recipeBuilder()
    .fluidInputs(fluid('sulfur_trioxide') * 1000)
    .fluidInputs(fluid('water') * 1000)
    .fluidOutputs(fluid('sulfuric_acid') * 1000)
    .EUt(VA[ULV])
    .duration(1600)
    .buildAndRegister()

BCR.recipeBuilder()
    .fluidInputs(fluid('sulfur_trioxide') * 50)
    .fluidInputs(fluid('water') * 50)
    .fluidOutputs(fluid('sulfuric_acid') * 50)
    .duration(2)
    .EUt(VA[LV])
    .buildAndRegister()

    // Bootstrap vitriol distillation

    DISTILLERY.recipeBuilder()
        .circuitMeta(10)
        .fluidInputs(fluid('water') * 1000)
        .fluidOutputs(fluid('dense_steam') * 1000)
        .duration(80)
        .EUt(VA[LV])
        .buildAndRegister()

    MIXER.recipeBuilder()
        .fluidInputs(fluid('dense_steam') * 20)
        .fluidInputs(fluid('air') * 980)
        .fluidOutputs(fluid('gtfo_moist_air') * 1000)
        .duration(5)
        .EUt(VA[LV])
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustTinyPyrite'))
        .fluidInputs(fluid('gtfo_moist_air') * 5555)
        .outputs(metaitem('dustTinyGreenVitriol'))
        .duration(120)
        .EUt(VA[ULV])
        .buildAndRegister()

    ROASTER.recipeBuilder()
        .inputs(ore('dustGreenVitriol') * 21)
        .fluidOutputs(fluid('dense_steam') * 7000)
        .outputs(metaitem('dustIronSulfate') * 6)
        .duration(200)
        .EUt(VA[ULV])
        .buildAndRegister()

    // Lead chamber process

        // Initial NO2 for lead chamber process

        ROASTER.recipeBuilder()
            .inputs(ore('dustSaltpeter') * 5)
            .fluidInputs(fluid('sulfuric_acid') * 1000)
            .fluidOutputs(fluid('nitrogen_dioxide') * 1000)
            .fluidOutputs(fluid('oxygen') * 250)
            .fluidOutputs(fluid('water') * 500)
            .outputs(metaitem('dustPotassiumBisulfate') * 7)
            .duration(120)
            .EUt(VA[ULV])
            .buildAndRegister()

        // Reaction chamber

        MIXER.recipeBuilder()
            .fluidInputs(fluid('sulfur_dioxide') * 1000)
            .fluidInputs(fluid('nitrogen_dioxide') * 1000)
            .fluidInputs(fluid('dense_steam') * 1000)
            .fluidOutputs(fluid('lead_chamber_reaction_mixture') * 3000)
            .duration(10)
            .EUt(VA[ULV])
            .buildAndRegister()

        BR.recipeBuilder() // Bootstrap
            .notConsumable(metaitem('foilLead') * 6)
            .fluidInputs(fluid('lead_chamber_reaction_mixture') * 3000)
            .fluidInputs(fluid('water') * 2000)
            .fluidInputs(fluid('diluted_sulfuric_acid') * 2000)
            .fluidOutputs(fluid('chamber_acid') * 5000) // 2 mol H2SO4, 3 mol H2O
            .fluidOutputs(fluid('nitric_oxide') * 1000)
            .duration(800)
            .EUt(VA[ULV])
            .buildAndRegister()

        BR.recipeBuilder()
            .notConsumable(metaitem('foilLead') * 6)
            .fluidInputs(fluid('lead_chamber_reaction_mixture') * 3000)
            .fluidInputs(fluid('water') * 1500)
            .fluidInputs(fluid('chamber_acid') * 2500)
            .fluidOutputs(fluid('chamber_acid') * 5000)
            .fluidOutputs(fluid('nitric_oxide') * 1000)
            .duration(160)
            .EUt(VA[ULV])
            .buildAndRegister()

        // Glover tower

        BR.recipeBuilder()
            .notConsumable(metaitem('foilLead') * 6)
            .fluidInputs(fluid('chamber_acid') * 5000)
            .fluidInputs(fluid('nitrosylsulfuric_acid') * 2000)
            .fluidInputs(fluid('glover_tower_mixture') * 3500)
            .fluidOutputs(fluid('lead_chamber_reaction_mixture') * 6000)
            .fluidOutputs(fluid('sulfuric_acid') * 4000)
            .duration(160)
            .EUt(VA[ULV])
            .buildAndRegister()

        // Gay-Lussac tower

        BR.recipeBuilder()
            .notConsumable(metaitem('foilLead') * 6)
            .fluidInputs(fluid('nitric_oxide') * 2000)
            .fluidInputs(fluid('sulfuric_acid') * 2000)
            .fluidInputs(fluid('air') * 1500)
            .fluidOutputs(fluid('nitrosylsulfuric_acid') * 2000)
            .fluidOutputs(fluid('dense_steam') * 1000)
            .duration(160)
            .EUt(VA[ULV])
            .buildAndRegister()