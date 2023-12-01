import static globals.Globals.*
import static globals.SinteringGlobals.*

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;

BR = recipemap('batch_reactor')
MIXER = recipemap('mixer')
ELECTROSTATIC_SEPARATOR = recipemap('electrostatic_separator')
CENTRIFUGE = recipemap('centrifuge')
DT = recipemap('distillation_tower')
ROASTER = recipemap('roaster')
VACUUM_DT = recipemap('vacuum_distillation')
CRYSTALLIZER = recipemap('crystallizer')
EXTRACTOR = recipemap('extractor')
ROTARY_KILN = recipemap('rotary_kiln')
COKING = recipemap('coking_tower')
CSTR = recipemap('continuous_stirred_tank_reactor')
CRACKER = recipemap('cracker')
EBF = recipemap('electric_blast_furnace')
REFORMER = recipemap('catalytic_reformer_recipes')
REACTION_FURNACE = recipemap('reaction_furnace')
FBR = recipemap('fixed_bed_reactor')
SIFTER = recipemap('sifter')
ALLOY_SMELTER = recipemap('alloy_smelter')
POLYMERIZATION_TANK = recipemap('polymerization_tank')
BCR = recipemap('bubble_column_reactor')
TBR = recipemap('trickle_bed_reactor')
LCR = recipemap('large_chemical_reactor')
AUTOCLAVE = recipemap('autoclave')
HEAT_EXCHANGER = recipemap('heat_exchanger')
UV_LIGHT_BOX = recipemap('uv_light_box')

// Lubricant base oils

    // Straight run lubricating oil

    MIXER.recipeBuilder()
        .fluidInputs(fluid('dichloroethane') * 1000)
        .fluidInputs(fluid('dichloromethane') * 1000)
        .fluidOutputs(fluid('dewaxing_solvent') * 2000)
        .duration(20)
        .EUt(30)
        .buildAndRegister()

    CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('crude_lubricating_oil') * 850)
        .fluidInputs(fluid('dewaxing_solvent') * 2000)
        .fluidOutputs(fluid('solvent_lubricant_mixture') * 2850)
        .duration(20)
        .EUt(30)
        .buildAndRegister()

    HEAT_EXCHANGER.recipeBuilder()
        .fluidInputs(fluid('ice') * 500)
        .fluidInputs(fluid('solvent_lubricant_mixture') * 2850)
        .fluidOutputs(fluid('water') * 500)
        .fluidOutputs(fluid('cold_solvent_lubricant_mixture') * 2850)
        .duration(5)
        .buildAndRegister()

    SIFTER.recipeBuilder()
        .notConsumable(metaitem('item_filter'))
        .fluidInputs(fluid('cold_solvent_lubricant_mixture') * 2850)
        .fluidOutputs(fluid('slack_wax') * 350)
        .fluidOutputs(fluid('dewaxed_lubricant_mixture') * 2500)
        .duration(20)
        .EUt(30)
        .buildAndRegister()

    DT.recipeBuilder()
        .fluidInputs(fluid('dewaxed_lubricant_mixture') * 2500)
        .fluidOutputs(fluid('sulfuric_lubricating_oil') * 500)
        .fluidOutputs(fluid('dewaxing_solvent') * 2000)
        .duration(20)
        .EUt(30)
        .buildAndRegister()

    FBR.recipeBuilder()
        .fluidInputs(fluid('sulfuric_lubricating_oil') * 180)
        .fluidInputs(fluid('hydrogen') * 45)
        .notConsumable(metaitem('catalystBedAlumina'))
        .fluidOutputs(fluid('lubricating_oil') * 180)
        .duration(20)
        .EUt(30)
        .buildAndRegister()

        // Hydrodewaxing catalyst

        LCR.recipeBuilder()
            .inputs(ore('dustAlumina') * 5)
            .fluidInputs(fluid('diisopropylamine') * 1200)
            .fluidInputs(fluid('phosphoric_acid') * 1000)
            .fluidInputs(fluid('tetraethyl_orthosilicate') * 200)
            .fluidInputs(fluid('demineralized_water') * 5000)
            .outputs(metaitem('dustSapoEleven'))
            .duration(600)
            .EUt(1920)
            .buildAndRegister()

        BR.recipeBuilder()
            .inputs(ore('dustPlatinum'))
            .fluidInputs(fluid('aqua_regia') * 8000)
            .fluidInputs(fluid('nitric_acid') * 2000)
            .fluidOutputs(fluid('chloroplatinic_acid_solution') * 4000)
            .fluidOutputs(fluid('nitrogen_dioxide') * 4000)
            .duration(20)
            .EUt(30)
            .buildAndRegister()
            
        BR.recipeBuilder()
            .inputs(ore('dustSapoEleven'))
            .inputs(ore('dustSodiumHydroxide') * 3)
            .fluidInputs(fluid('ethylene_glycol') * 500)
            .fluidInputs(fluid('chloroplatinic_acid_solution') * 1000)
            .outputs(metaitem('dustPlatinumSapoEleven'))
            .fluidOutputs(fluid('wastewater') * 1500)
            .duration(600)
            .EUt(1920)
            .buildAndRegister()

        // Hydrodewaxing

        FBR.recipeBuilder()
            .fluidInputs(fluid('crude_lubricating_oil') * 850)
            .fluidInputs(fluid('hydrogen') * 315)
            .notConsumable(metaitem('catalystBedPlatinumSapoEleven'))
            .fluidOutputs(fluid('lubricating_oil') * 850)
            .duration(20)
            .EUt(30)
            .buildAndRegister()

    // Silicone oil

    CSTR.recipeBuilder()
        .fluidInputs(fluid('methyldichlorosilane') * 50)
        .fluidInputs(fluid('chlorobenzene') * 50)
        .fluidOutputs(fluid('methylphenyldichlorosilane') * 50)
        .fluidOutputs(fluid('hydrogen_chloride') * 50)
        .duration(10)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

    BR.recipeBuilder()
        .fluidInputs(fluid('methyldichlorosilane') * 900)
        .fluidInputs(fluid('methylphenyldichlorosilane') * 100)
        .fluidInputs(fluid('water') * 3000)
        .fluidOutputs(fluid('silicone_oil_mixture') * 3000)
        .duration(20)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()

    PHASE_SEPARATOR.recipeBuilder()
        .fluidInputs(fluid('silicone_oil_mixture') * 3000)
        .fluidOutputs(fluid('silicone_oil') * 1000)
        .fluidOutputs(fluid('hydrochloric_acid') * 2000)
        .duration(10)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

    // Polyalphaolefins

    MIXER.recipeBuilder()
        .fluidInputs(fluid('boron_trifluoride') * 750)
        .fluidInputs(fluid('n_butanol') * 250)
        .fluidOutputs(fluid('olefin_polymerization_initiator') * 1000)
        .duration(50)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

    CSTR.recipeBuilder()
        .fluidInputs(fluid('one_dodecene') * 600)
        .fluidInputs(fluid('olefin_polymerization_initiator') * 100)
        .fluidOutputs(fluid('crude_polyalphaolefin_mixture') * 225)
        .duration(2)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

    CSTR.recipeBuilder()
        .fluidInputs(fluid('one_decene') * 600)
        .fluidInputs(fluid('olefin_polymerization_initiator') * 100)
        .fluidOutputs(fluid('crude_polyalphaolefin_mixture') * 225)
        .duration(2)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

    CSTR.recipeBuilder()
        .fluidInputs(fluid('crude_polyalphaolefin_mixture') * 225)
        .fluidInputs(fluid('water') * 100)
        .fluidOutputs(fluid('unsaturated_polyalphaolefin') * 200)
        .fluidOutputs(fluid('boron_trifluoride_mixture') * 125)
        .duration(2)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

    BR.recipeBuilder()
        .fluidInputs(fluid('boron_trifluoride_mixture') * 1250)
        .fluidInputs(fluid('sulfuric_acid') * 50)
        .fluidOutputs(fluid('boron_trifluoride') * 500)
        .fluidOutputs(fluid('n_butanol_waste') * 1250)
        .duration(40)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

    DISTILLATION_TOWER.recipeBuilder()
        .fluidInputs(fluid('n_butanol_waste') * 1250)
        .fluidOutputs(fluid('n_butanol') * 250)
        .fluidOutputs(fluid('wastewater') * 1000)
        .duration(40)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

    MIXER.recipeBuilder()
        .inputs(ore('dustDiamminedichloropalladium') * 11)
        .fluidInputs(fluid('phosphoric_acid') * 1000)
        .fluidOutputs(fluid('palladium_precursor_solution') * 1000)
        .duration(100)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()

    SINTERING_OVEN.recipeBuilder()
        .inputs(ore('dustAlumina') * 5)
        .fluidInputs(fluid('palladium_precursor_solution') * 1000)
        .outputs(metaitem('dustSupportedPalladium'))
        .fluidOutputs(fluid('phosphoric_acid') * 1000)
        .fluidOutputs(fluid('ammonia') * 2000)
        .duration(100)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()

    FBR.recipeBuilder()
        .fluidInputs(fluid('unsaturated_polyalphaolefin') * 50)
        .fluidInputs(fluid('hydrogen') * 100)
        .notConsumable(metaitem('catalystBedSupportedPalladium'))
        .fluidOutputs(fluid('polyalphaolefin') * 50)
        .fluidOutputs(fluid('water') * 50)
        .duration(20)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()

    // Polybutenes

    POLYMERIZATION.recipeBuilder()
        .fluidInputs(fluid('butene') * 4000)
        .fluidInputs(fluid('olefin_polymerization_initiator') * 500)
        .fluidOutputs(fluid('polybutene_mixture') * 4125)
        .duration(80)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

    CSTR.recipeBuilder()
        .fluidInputs(fluid('polybutene_mixture') * 4125)
        .fluidInputs(fluid('water') * 500)
        .fluidOutputs(fluid('polybutene') * 4000)
        .fluidOutputs(fluid('boron_trifluoride_mixture') * 625)
        .duration(4)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

    // Simple esters
    
    LCR.recipeBuilder()
        .fluidInputs(fluid('pseudocumene') * 1000)
        .fluidInputs(fluid('hot_hp_air') * 12000)
        .fluidInputs(fluid('acetic_acid') * 1000)
        .notConsumable(metaitem('dustAmocoProcessCatalyst'))
        .fluidOutputs(fluid('trimellitic_anhydride_slurry') * 2000)
        .EUt(1920)
        .duration(200)
        .buildAndRegister()

    DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('trimellitic_anhydride_slurry') * 2000)
        .outputs(metaitem('dustTrimelliticAcid') * 21)
        .fluidOutputs(fluid('diluted_acetic_acid') * 2000)
        .EUt(120)
        .duration(100)
        .buildAndRegister()

    ROASTER.recipeBuilder()
        .inputs(ore('dustTrimelliticAcid') * 21)
        .fluidOutputs(fluid('steam') * 1000)
        .outputs(metaitem('dustTrimelliticAnhydride') * 18)
        .EUt(120)
        .duration(100)
        .buildAndRegister()

// Friction Modifiers

    /*Mechanically working FMs: molybdenum disulfide,
    graphite, PTFE, polyamide, polyimide, fluorinated
    graphite

    Adsoprtion layer FMs:
    long-chain carboxylic acids, fatty acid esters,
    ethers, alcohols, amines, amides, imides

    Tribochemical FMs:
    saturated fatty acids, phosphoric and thiophosphoric
    acid esters, xanthates, sulfurized fatty
    acids

    Friction polymer FMs:
    ethoxylated dicarboxylic acid monoesters, dialkyl phthalates,
    methacrylates, unsaturated fatty acids, sulfurized olefins*/

// Lubricant antioxidants

    // N-phenyl-1-naphthylamine

    BR.recipeBuilder()
        .fluidInputs(fluid('naphthalene') * 1000)
        .fluidInputs(fluid('nitration_mixture') * 2000)
        .outputs(metaitem('dustCrudeOneNitronaphthalene'))
        .fluidOutputs(fluid('diluted_sulfuric_acid') * 2000)
        .duration(200)
        .EUt(120)
        .buildAndRegister()

    VACUUM_DT.recipeBuilder()
        .inputs(ore('dustCrudeOneNitronaphthalene'))
        .outputs(metaitem('dustOneNitronaphthalene'))
        .duration(200)
        .EUt(120)
        .buildAndRegister()

    FBR.recipeBuilder()
        .inputs(ore('dustOneNitronaphthalene'))
        .notConsumable(ore('catalystBedNickel'))
        .fluidInputs(fluid('hydrogen') * 6000)
        .outputs(metaitem('dustOneNaphthylamine'))
        .fluidOutputs(fluid('water') * 2000)
        .duration(200)
        .EUt(120)
        .buildAndRegister()

    ROASTER.recipeBuilder()
        .fluidInputs(fluid('one_naphthylamine') * 144)
        .fluidInputs(fluid('aniline') * 1000)
        .outputs(metaitem('dustNPhenylOneNaphthylamine'))
        .duration(200)
        .EUt(120)
        .buildAndRegister()
        
// Pour point depressants

    // Polyisobutene
    POLYMERIZATION.recipeBuilder()
        .fluidInputs(fluid('isobutylene') * 4000)
        .fluidInputs(fluid('olefin_polymerization_initiator') * 500)
        .fluidOutputs(fluid('polyisobutene_mixture') * 4125)
        .duration(80)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

    CSTR.recipeBuilder()
        .fluidInputs(fluid('polyisobutene_mixture') * 4125)
        .fluidInputs(fluid('water') * 500)
        .fluidOutputs(fluid('polyisobutene') * 4000)
        .fluidOutputs(fluid('boron_trifluoride_mixture') * 625)
        .duration(4)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

    // Ethylene propylene copolymer

    POLYMERIZATION.recipeBuilder()
        .notConsumable(metaitem('dustKaminskyCatalyst'))
        .fluidInputs(fluid('ethylene') * 500)
        .fluidInputs(fluid('propene') * 500)
        .outputs(metaitem('dustEthylenePropyleneCopolymer'))
        .EUt(30)
        .duration(200)
        .buildAndRegister()

    // Polyalkyl methacrylate

    BR.recipeBuilder()
        .fluidInputs(fluid('methacrylamide_sulfate') * 1000)
        .fluidInputs(fluid('water') * 1000)
        .fluidOutputs(fluid('methacrylic_acid') * 1000)
        .outputs(metaitem('dustAmmoniumBisulfate') * 11)
        .duration(300)
        .EUt(30)
        .buildAndRegister()

    CSTR.recipeBuilder()
        .fluidInputs(fluid('methacrylic_acid') * 50)
        .fluidInputs(fluid('lauric_acid') * 50)
        .fluidInputs(fluid('sulfuric_acid') * 50)
        .fluidOutputs(fluid('alkyl_methacrylate') * 50)
        .fluidOutputs(fluid('diluted_sulfuric_acid') * 100)
        .duration(15)
        .EUt(30)
        .buildAndRegister()

    MIXER.recipeBuilder()
        .fluidInputs(fluid('alkyl_methacrylate') * 1000)
        .fluidInputs(fluid('water') * 1000)
        .fluidInputs(fluid('gtfo_sodium_stearate') * 100)
        .fluidOutputs(fluid('alkyl_methacrylate_emulsion') * 2000)
        .duration(300)
        .EUt(30)
        .buildAndRegister()

    POLYMERIZATION.recipeBuilder()
        .fluidInputs(fluid('alkyl_methacrylate_emulsion') * 2000)
        .inputs(ore('dustTinyPotassiumPersulfate'))
        .fluidOutputs(fluid('polyalkyl_methacrylate_solution') * 2000)
        .duration(300)
        .EUt(30)
        .buildAndRegister()

    DRYER.recipeBuilder()
        .fluidInputs(fluid('polyalkyl_methacrylate_solution') * 2000)
        .outputs(metaitem('dustPama') * 7)
        .duration(300)
        .EUt(30)
        .buildAndRegister()

    // Hydrogenated styrene-butadiene rubber

    // Hydrogenated styrene-isoprene rubber

// Detergents/dispersants

    // Calcium phenate

    // Calcium dodecylsulfonate

    // Calcium dodecylbenzylsulfonate

    // Calcium salicylate

        BR.recipeBuilder()
            .inputs(ore('dustCalciumHydroxide') * 5)
            .inputs(ore('dustCalciumCarbonate') * 5)
            .fluidInputs(fluid('phenol') * 2000)
            .fluidInputs(fluid('carbon_dioxide') * 2000)
            .fluidInputs(fluid('diethylene_glycol') * 1000)
            .notConsumable(fluid('hp_nitrogen') * 6400)
            .fluidOutputs(fluid('calcium_salicylate_solution') * 1000)
            .duration(200)
            .EUt(120)
            .buildAndRegister()

        DISTILLERY.recipeBuilder()
            .fluidInputs(fluid('calcium_salicylate_solution') * 1000)
            .outputs(metaitem('dustCalciumSalicylate'))
            .fluidOutputs(fluid('diethylene_glycol') * 1000)
            .duration(20)
            .EUt(30)
            .buildAndRegister()

    // Polyisobutene succinic anhydride

// Demulsifiers

    // Calcium dinonylnaphthalene sulfonate

    // Polyethylene glycol

// Antiwear

    // Tri-(m/p)-cresylphosphate

    // Zinc/Molybdenum dialkyldithiophosphate

    // Zinc-bis(diethyldithiocarbamate)

// Antirust

    // Calcium didodecylbenzene sulfonate

    // Alkylsuccinic acid

// Corrosion inhibitors

    // Benzo/tolyltriazole

    // Mercaptobenzothiazole

    // SALEN

// Final blending

def frictionModifiersMap = [
    'dustTalc': 0.5
    'dustSoapstone': 0.5
]

def baseOils = [

]