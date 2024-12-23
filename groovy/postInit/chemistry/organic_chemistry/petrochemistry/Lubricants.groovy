import globals.Globals
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
CSTR = recipemap('continuous_stirred_tank_reactor')
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
BLENDER = recipemap('blender')
PHASE_SEPARATOR = recipemap('phase_separator')

// Lubricant base oils

    // Straight run lubricating oil

    MIXER.recipeBuilder()
        .fluidInputs(fluid('butanone') * 1000)
        .fluidInputs(fluid('methyl_isobutyl_ketone') * 1000)
        .fluidOutputs(fluid('dewaxing_solvent') * 2000)
        .duration(20)
        .EUt(30)
        .buildAndRegister()

    MIXER.recipeBuilder()
        .fluidInputs(fluid('one_two_dichloroethane') * 1000)
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

    CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('deasphalted_oil') * 850)
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

    PHASE_SEPARATOR.recipeBuilder()
        .fluidInputs(fluid('cold_solvent_lubricant_mixture') * 2850)
        .fluidOutputs(fluid('slack_wax') * 350)
        .fluidOutputs(fluid('dewaxed_lubricant_mixture') * 2500)
        .duration(5)
        .buildAndRegister()

    DT.recipeBuilder()
        .fluidInputs(fluid('dewaxed_lubricant_mixture') * 2500)
        .fluidOutputs(fluid('sulfuric_lubricating_oil') * 500)
        .fluidOutputs(fluid('dewaxing_solvent') * 2000)
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
            .fluidOutputs(fluid('sour_gas') * 315)
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

    // Esters
    
    def alcoholTab = [
        'n_octanol',
        'n_decanol',
        'n_dodecanol'
    ]

    LCR.recipeBuilder()
        .fluidInputs(fluid('pseudocumene') * 1000)
        .fluidInputs(fluid('hot_hp_air') * 12000)
        .fluidInputs(fluid('acetic_acid') * 1000)
        .notConsumable(metaitem('dustAmocoProcessCatalyst'))
        .fluidOutputs(fluid('trimellitic_acid_slurry') * 2000)
        .EUt(1920)
        .duration(200)
        .buildAndRegister()

    DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('trimellitic_acid_slurry') * 2000)
        .outputs(metaitem('dustTrimelliticAcid') * 21)
        .fluidOutputs(fluid('diluted_acetic_acid') * 2000)
        .EUt(120)
        .duration(100)
        .buildAndRegister()

    ROASTER.recipeBuilder()
        .inputs(ore('dustTrimelliticAcid') * 21)
        .fluidOutputs(fluid('dense_steam') * 1000)
        .outputs(metaitem('dustTrimelliticAnhydride') * 18)
        .EUt(120)
        .duration(100)
        .buildAndRegister()

    for (alcohol in alcoholTab) {
        BR.recipeBuilder()
            .inputs(ore('dustPhthalicAnhydride') * 15)
            .fluidInputs(fluid(alcohol) * 1000)
            .fluidOutputs(fluid('ester_base_oil') * 1000)
            .EUt(120)
            .duration(100)
            .buildAndRegister()

        BR.recipeBuilder()
            .inputs(ore('dustTrimelliticAnhydride') * 18)
            .fluidInputs(fluid(alcohol) * 1000)
            .fluidOutputs(fluid('ester_base_oil') * 1500)
            .EUt(120)
            .duration(100)
            .buildAndRegister()

        BR.recipeBuilder()
            .inputs(ore('dustPyromelliticDianhydride') * 18)
            .fluidInputs(fluid(alcohol) * 2000)
            .fluidOutputs(fluid('ester_base_oil') * 3000)
            .EUt(120)
            .duration(100)
            .buildAndRegister()
    }

// Friction Modifiers

    /*Mechanically working FMs: molybdenum disulfide,
    graphite, PTFE, polyamide, fluorinated
    graphite*/

    // Molybdenum disulfide

    CENTRIFUGE.recipeBuilder()
        .inputs(ore('dustFlotatedMolybdenite'))
        .outputs(metaitem('dustMolybdenumDisulfide'))
        .duration(200)
        .EUt(120)
        .buildAndRegister()

    ROASTER.recipeBuilder()
        .notConsumable(fluid('nitrogen') * 8000)
        .inputs(ore('dustMolybdenumTrisulfide'))
        .outputs(metaitem('dustMolybdenumDisulfide'))
        .outputs(metaitem('dustSulfur'))
        .duration(200)
        .EUt(120)
        .buildAndRegister()

    // Fluorinated graphite

    REACTION_FURNACE.recipeBuilder()
        .inputs(ore('dustGraphite'))
        .fluidInputs(fluid('fluorine') * 1000)
        .outputs(metaitem('dustFluorinatedGraphite'))
        .duration(200)
        .EUt(240)
        .buildAndRegister()

    /*Adsoprtion layer FMs:
    long-chain carboxylic acids, fatty acid esters,
    ethers, alcohols, amides*/

    // Oleomide

    CSTR.recipeBuilder()
        .notConsumable(ore('springKanthal'))
        .fluidInputs(fluid('oleic_acid') * 50)
        .fluidInputs(fluid('ammonia') * 50)
        .fluidOutputs(fluid('oleylamide') * 50)
        .fluidOutputs(fluid('water') * 50)
        .duration(10)
        .EUt(240)
        .buildAndRegister()

    // Monoglycerides

    CSTR.recipeBuilder()
        .notConsumable(ore('springKanthal'))
        .fluidInputs(fluid('seed_oil') * 50)
        .fluidInputs(fluid('glycerol') * 100)
        .fluidOutputs(fluid('monoglycerides') * 150)
        .duration(10)
        .EUt(240)
        .buildAndRegister()

    /*Tribochemical FMs:
    saturated fatty acids, phosphoric and thiophosphoric
    acid esters, xanthates, sulfurized fatty
    acids*/

    // Stearic acid

    AUTOCLAVE.recipeBuilder()
        .fluidInputs(fluid('distilled_water') * 3000)
        .fluidInputs(fluid('gtfo_stearin') * 1000)
        .fluidOutputs(fluid('glycerol') * 1000)
        .fluidOutputs(fluid('stearic_acid') * 3000)
        .EUt(30)
        .duration(200)
        .buildAndRegister()

    // Palmitic acid

    // ADD PALM OIL WHEN READY

    LCR.recipeBuilder()
        .inputs(ore('dustChromiumTrioxide') * 16)
        .fluidInputs(fluid('sulfuric_acid') * 6000)
        .fluidInputs(fluid('distilled_water') * 15000)
        .fluidInputs(fluid('acetone') * 1000)
        .fluidInputs(fluid('n_hexadecanol') * 3000)
        .fluidOutputs(fluid('chromium_sulfate_solution') * 1000)
        .fluidOutputs(fluid('palmitic_acid') * 3000)
        .duration(200)
        .EUt(200)
        .buildAndRegister()

    /*Friction polymer FMs:
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
        .fluidInputs(fluid('gtfo_aniline') * 1000)
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
        .duration(200)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

    BR.recipeBuilder()
        .fluidInputs(fluid('polyisobutene_mixture') * 4125)
        .fluidInputs(fluid('water') * 500)
        .outputs(metaitem('dustPolyisobutene'))
        .fluidOutputs(fluid('boron_trifluoride_mixture') * 625)
        .duration(200)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

    // Ethylene propylene copolymer

    POLYMERIZATION.recipeBuilder()
        .circuitMeta(2)
        .notConsumable(metaitem('dustKaminskyCatalyst'))
        .fluidInputs(fluid('ethylene') * 1000)
        .fluidInputs(fluid('propene') * 1000)
        .outputs(metaitem('dustEthylenePropyleneCopolymer') * 2)
        .EUt(30)
        .duration(200)
        .buildAndRegister()

    // Polyalkyl methacrylate

    BR.recipeBuilder()
        .inputs(ore('dustMethacrylamideSulfate'))
        .fluidInputs(fluid('water') * 1000)
        .fluidOutputs(fluid('methacrylic_acid') * 1000)
        .outputs(metaitem('dustAmmoniumBisulfate') * 11)
        .duration(200)
        .EUt(30)
        .buildAndRegister()

    CSTR.recipeBuilder()
        .fluidInputs(fluid('methacrylic_acid') * 50)
        .fluidInputs(fluid('n_dodecanol') * 50)
        .fluidInputs(fluid('sulfuric_acid') * 50)
        .fluidOutputs(fluid('alkyl_methacrylate') * 50)
        .fluidOutputs(fluid('diluted_sulfuric_acid') * 100)
        .duration(10)
        .EUt(30)
        .buildAndRegister()

    MIXER.recipeBuilder()
        .fluidInputs(fluid('alkyl_methacrylate') * 1000)
        .fluidInputs(fluid('water') * 1000)
        .fluidInputs(fluid('gtfo_sodium_stearate') * 100)
        .fluidOutputs(fluid('alkyl_methacrylate_emulsion') * 2000)
        .duration(200)
        .EUt(30)
        .buildAndRegister()

    POLYMERIZATION.recipeBuilder()
        .fluidInputs(fluid('alkyl_methacrylate_emulsion') * 2000)
        .inputs(ore('dustTinyPotassiumPersulfate'))
        .fluidOutputs(fluid('polyalkyl_methacrylate_solution') * 2000)
        .duration(200)
        .EUt(30)
        .buildAndRegister()

    DRYER.recipeBuilder()
        .fluidInputs(fluid('polyalkyl_methacrylate_solution') * 2000)
        .outputs(metaitem('dustPama'))
        .duration(200)
        .EUt(30)
        .buildAndRegister()

    // Hydrogenated styrene-butadiene rubber

    BR.recipeBuilder()
        .inputs(ore('dustRawStyreneIsopreneRubber') * 16)
        .fluidInputs(fluid('hydrogen') * 6000)
        .notConsumable(metaitem('catalystBedSupportedPalladium'))
        .outputs(metaitem('dustHydrogenatedStyreneIsopreneRubber') * 16)
        .fluidOutputs(fluid('water') * 3000)
        .duration(20)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()

    // Hydrogenated styrene-isoprene rubber

    BR.recipeBuilder()
        .inputs(ore('dustRawStyreneButadieneRubber') * 16)
        .fluidInputs(fluid('hydrogen') * 6000)
        .notConsumable(metaitem('catalystBedSupportedPalladium'))
        .outputs(metaitem('dustHydrogenatedStyreneButadieneRubber') * 16)
        .fluidOutputs(fluid('water') * 3000)
        .duration(20)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()

// Detergents/dispersants

    // Calcium phenate

    BR.recipeBuilder()
        .fluidInputs(fluid('phenol') * 1000)
        .fluidInputs(fluid('one_dodecene') * 1000)
        .notConsumable(fluid('hydrofluoric_acid') * 100)
        .outputs(metaitem('dustDodecylphenol'))
        .duration(200)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustDodecylphenol'))
        .inputs(ore('dustCalcite') * 5)
        .fluidInputs(fluid('sulfur_dichloride') * 1000)
        .fluidOutputs(fluid('calcium_phenate') * 1000)
        .fluidOutputs(fluid('hydrogen_chloride') * 2000)
        .duration(200)
        .EUt(30)
        .buildAndRegister()

    // Calcium dodecylbenzene sulfonate

    BR.recipeBuilder()
        .circuitMeta(3)
        .fluidInputs(fluid('benzene') * 1000)
        .fluidInputs(fluid('one_dodecene') * 1000)
        .notConsumable(fluid('hydrofluoric_acid') * 100)
        .outputs(metaitem('dustDodecylbenzene'))
        .duration(200)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustDodecylbenzene'))
        .fluidInputs(fluid('oleum') * 11000)
        .outputs(metaitem('dustDodecylbenzenesulfonicAcid'))
        .fluidOutputs(fluid('sulfuric_acid') * 10000)
        .duration(200)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

    BR.recipeBuilder()
        .notConsumable(ore('platePolytetrafluoroethylene') * 6)
        .inputs(ore('dustDodecylbenzene'))
        .fluidInputs(fluid('chlorosulfuric_acid') * 1000)
        .outputs(metaitem('dustDodecylbenzenesulfonicAcid'))
        .fluidOutputs(fluid('hydrogen_chloride') * 1000)
        .duration(200)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustDodecylbenzenesulfonicAcid') * 2)
        .fluidInputs(fluid('calcium_hydroxide_slurry') * 1000)
        .outputs(metaitem('dustCalciumDodecylbenzeneSulfonate'))
        .fluidOutputs(fluid('water') * 1000)
        .duration(200)
        .EUt(120)
        .buildAndRegister()

    // Calcium salicylate

    LCR.recipeBuilder()
        .inputs(ore('dustCalciumHydroxide') * 5)
        .inputs(ore('dustCalcite'))
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

    FLUIDIZEDBR.recipeBuilder()
        .fluidInputs(fluid('butane') * 1000)
        .fluidInputs(fluid('oxygen') * 7000)
        .notConsumable(ore('dustVanadiumPentoxide'))
        .fluidOutputs(fluid('dense_steam') * 4000)
        .outputs(metaitem('dustMaleicAnhydride') * 9)
        .duration(200)
        .EUt(240)
        .buildAndRegister()

    REACTION_FURNACE.recipeBuilder()
        .inputs(ore('dustMaleicAnhydride') * 9)
        .inputs(ore('dustPolyisobutene'))
        .outputs(metaitem('dustPolyisobuteneSuccinicAnhydride'))
        .duration(200)
        .EUt(240)
        .buildAndRegister()

// Demulsifiers

    // Calcium dinonylnaphthalene sulfonate

    BR.recipeBuilder()
        .inputs(ore('dustDinonylnaphthaleneSulfonicAcid') * 2)
        .fluidInputs(fluid('calcium_hydroxide_slurry') * 1000)
        .outputs(metaitem('dustCalciumDinonylnaphthaleneSulfonate'))
        .fluidOutputs(fluid('water') * 1000)
        .duration(200)
        .EUt(120)
        .buildAndRegister()

    // Polyethylene glycol

    POLYMERIZATION.recipeBuilder()
        .fluidInputs(fluid('ethylene_oxide') * 1000)
        .fluidInputs(fluid('boron_trifluoride') * 10)
        .fluidOutputs(fluid('polyethylene_glycol') * 1000)
        .duration(200)
        .EUt(240)
        .buildAndRegister()

// Antiwear

    // Tri-(m/p)-cresylphosphate

    DISTILLATION_TOWER.recipeBuilder()
        .fluidInputs(fluid('cresol') * 1000)
        .fluidOutputs(fluid('meta_para_cresol_mixture') * 700) // needs to be slightly higher than SATP
        .fluidOutputs(fluid('ortho_cresol') * 300)
        .duration(200)
        .EUt(240)
        .buildAndRegister()

    CSTR.recipeBuilder()
        .fluidInputs(fluid('meta_para_cresol_mixture') * 150)
        .fluidInputs(fluid('phosphoryl_chloride') * 50)
        .fluidOutputs(fluid('acidic_tricresyl_phosphate') * 200)
        .duration(10)
        .EUt(120)
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustSodiumHydroxide') * 9)
        .fluidInputs(fluid('acidic_tricresyl_phosphate') * 4000)
        .fluidOutputs(fluid('tricresyl_phosphate') * 1000)
        .fluidOutputs(fluid('salt_water') * 3000)
        .duration(200)
        .EUt(120)
        .buildAndRegister()

    // Zinc/Molybdenum dialkyldithiophosphate

    BR.recipeBuilder()
        .inputs(ore('dustPhosphorusPentasulfide') * 7)
        .fluidInputs(fluid('isopropyl_alcohol') * 4000)
        .fluidOutputs(fluid('diisopropyldithiophosphoric_acid') * 2000)
        .fluidOutputs(fluid('hydrogen_sulfide') * 1000)
        .duration(200)
        .EUt(120)
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustPhosphorusPentasulfide') * 7)
        .fluidInputs(fluid('n_butanol') * 4000)
        .fluidOutputs(fluid('dibutyldithiophosphoric_acid') * 2000)
        .fluidOutputs(fluid('hydrogen_sulfide') * 1000)
        .duration(200)
        .EUt(120)
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustZincOxide') * 2)
        .fluidInputs(fluid('diisopropyldithiophosphoric_acid') * 2000)
        .fluidOutputs(fluid('zinc_dialkyldithiophosphate') * 1000)
        .fluidOutputs(fluid('water') * 1000)
        .duration(200)
        .EUt(120)
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustZincOxide') * 2)
        .fluidInputs(fluid('dibutyldithiophosphoric_acid') * 2000)
        .fluidOutputs(fluid('zinc_dialkyldithiophosphate') * 1000)
        .fluidOutputs(fluid('water') * 1000)
        .duration(200)
        .EUt(120)
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustAmmoniumDimolybdate') * 19)
        .fluidInputs(fluid('diisopropyldithiophosphoric_acid') * 4000)
        .outputs(metaitem('dustMolybdenumDialkyldithiophosphate'))
        .fluidOutputs(fluid('diluted_ammonia_solution') * 4000)
        .duration(200)
        .EUt(120)
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustAmmoniumDimolybdate') * 19)
        .fluidInputs(fluid('dibutyldithiophosphoric_acid') * 4000)
        .outputs(metaitem('dustMolybdenumDialkyldithiophosphate'))
        .fluidOutputs(fluid('diluted_ammonia_solution') * 4000)
        .duration(200)
        .EUt(120)
        .buildAndRegister()

    // Zinc-bis(diethyldithiocarbamate)

    FBR.recipeBuilder()
        .notConsumable(metaitem('catalystBedAlumina'))
        .fluidInputs(fluid('n_pentanol') * 100)
        .fluidInputs(fluid('ammonia') * 50)
        .fluidOutputs(fluid('diamylamine') * 50)
        .duration(5)
        .EUt(120)
        .buildAndRegister();

    BR.recipeBuilder()
        .inputs(ore('dustSodiumHydroxide') * 3)
        .fluidInputs(fluid('carbon_disulfide') * 1000)
        .fluidInputs(fluid('diamylamine') * 1000)
        .fluidOutputs(fluid('sodium_diamyldithiocarbamate_solution') * 1000)
        .duration(200)
        .EUt(120)
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustZincChloride') * 3)
        .fluidInputs(fluid('sodium_diamyldithiocarbamate_solution') * 2000)
        .outputs(metaitem('dustZincBisdiamyldithiocarbamate'))
        .fluidOutputs(fluid('salt_water') * 2000)
        .duration(200)
        .EUt(120)
        .buildAndRegister()

// Antirust

    // Calcium didodecylbenzene sulfonate

    BR.recipeBuilder()
        .circuitMeta(1)
        .fluidInputs(fluid('benzene') * 1000)
        .fluidInputs(fluid('one_dodecene') * 2000)
        .notConsumable(fluid('hydrofluoric_acid') * 100)
        .outputs(metaitem('dustDidodecylbenzene'))
        .duration(100)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

    BR.recipeBuilder()
        .circuitMeta(2)
        .inputs(ore('dustDodecylbenzene'))
        .fluidInputs(fluid('one_dodecene') * 1000)
        .notConsumable(fluid('hydrofluoric_acid') * 100)
        .outputs(metaitem('dustDidodecylbenzene'))
        .duration(100)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustDidodecylbenzene'))
        .fluidInputs(fluid('oleum') * 11000)
        .outputs(metaitem('dustDidodecylbenzenesulfonicAcid'))
        .fluidOutputs(fluid('sulfuric_acid') * 10000)
        .duration(100)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

    BR.recipeBuilder()
        .notConsumable(ore('platePolytetrafluoroethylene') * 6)
        .inputs(ore('dustDidodecylbenzene'))
        .fluidInputs(fluid('chlorosulfuric_acid') * 1000)
        .outputs(metaitem('dustDidodecylbenzenesulfonicAcid'))
        .fluidOutputs(fluid('hydrogen_chloride') * 1000)
        .duration(100)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustDidodecylbenzenesulfonicAcid') * 2)
        .fluidInputs(fluid('calcium_hydroxide_slurry') * 1000)
        .outputs(metaitem('dustCalciumDidodecylbenzeneSulfonate'))
        .fluidOutputs(fluid('water') * 1000)
        .duration(200)
        .EUt(120)
        .buildAndRegister()

    // 4-nonylphenoxyacetic acid

    BR.recipeBuilder()
        .fluidInputs(fluid('phenol') * 1000)
        .fluidInputs(fluid('tripropylene') * 1000)
        .notConsumable(fluid('hydrofluoric_acid') * 100)
        .fluidOutputs(fluid('nonylphenol') * 1000)
        .duration(200)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

    CSTR.recipeBuilder()
        .fluidInputs(fluid('trichloroethylene') * 50)
        .fluidInputs(fluid('diluted_sulfuric_acid') * 200)
        .fluidOutputs(fluid('chloroacetic_acid_solution') * 150)
        .fluidOutputs(fluid('hydrogen_chloride') * 100)
        .duration(10)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

    VACUUM_DT.recipeBuilder()
        .fluidInputs(fluid('chloroacetic_acid_solution') * 3000)
        .fluidOutputs(fluid('sulfuric_acid') * 2000)
        .fluidOutputs(fluid('chloroacetic_acid') * 1000)
        .duration(200)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

    BR.recipeBuilder()
        .fluidInputs(fluid('nonylphenol') * 1000)
        .fluidInputs(fluid('sodium_hydroxide_solution') * 1000)
        .fluidInputs(fluid('chloroacetic_acid') * 1000)
        .outputs(metaitem('dustFourNonylphenoxyaceticAcid'))
        .fluidOutputs(fluid('diluted_saltwater') * 2000)
        .duration(10)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()
    
// Corrosion inhibitors

    // Benzotriazole

    BR.recipeBuilder()
        .fluidInputs(fluid('two_chloronitrobenzene') * 144)
        .fluidInputs(fluid('ammonia') * 2000)
        .outputs(metaitem('dustAmmoniumChloride') * 6)
        .fluidOutputs(fluid('two_nitroaniline_solution') * 1000)
        .duration(600)
        .EUt(120)
        .buildAndRegister()

    BCR.recipeBuilder()
        .notConsumable(ore('catalystBedPalladium'))
        .fluidInputs(fluid('two_nitroaniline_solution') * 50)
        .fluidInputs(fluid('hydrogen') * 300)
        .fluidOutputs(fluid('ortho_phenylenediamine_slurry') * 150)
        .duration(200)
        .EUt(30)
        .buildAndRegister()

    DISTILLATION_TOWER.recipeBuilder()
        .fluidInputs(fluid('ortho_phenylenediamine_slurry') * 3000)
        .fluidOutputs(fluid('toluene') * 1000)
        .fluidOutputs(fluid('water') * 2000)
        .outputs(metaitem('dustOrthoPhenylenediamine') * 16)
        .duration(200)
        .EUt(30)
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustOrthoPhenylenediamine') * 16)
        .inputs(ore('dustSodiumNitrite') * 4)
        .fluidInputs(fluid('hydrogen_chloride') * 1000)
        .outputs(metaitem('dustBenzotriazole'))
        .fluidOutputs(fluid('diluted_saltwater') * 2000)
        .duration(200)
        .EUt(30)
        .buildAndRegister()

    // Mercaptobenzothiazole

    BR.recipeBuilder()
        .inputs(ore('dustSulfur'))
        .fluidInputs(fluid('gtfo_aniline') * 1000)
        .fluidInputs(fluid('carbon_disulfide') * 1000)
        .outputs(metaitem('dustMercaptobenzothiazole'))
        .fluidOutputs(fluid('hydrogen_sulfide') * 1000)
        .duration(200)
        .EUt(30)
        .buildAndRegister()

// Chelates: SALEN

BR.recipeBuilder()
    .fluidInputs(fluid('ethylenediamine') * 1000)
    .fluidInputs(fluid('hydrogen_chloride') * 1000)
    .fluidInputs(fluid('salicylaldehyde') * 2000)
    .outputs(metaitem('dustSalicylideneEthylenediamine'))
    .fluidOutputs(fluid('diluted_hydrochloric_acid') * 2000)
    .duration(200)
    .EUt(120)
    .buildAndRegister()

// Final blending

def baseOilMap = [
    'seed_oil': 0.5,
    'lubricating_oil': 1,
    'light_cycle_oil' : 1,
    'polybutene': 1.5,
    'polyalphaolefin': 2.5,
    'ester_base_oil': 3
]

def solidFrictionModifierMap = [
    'dustTalc': 0.5,
    'dustSoapstone': 0.5,
    'dustGraphite': 1,
    'dustFluorinatedGraphite': 2,
    'dustPolycaprolactam': 3,
    'dustPolytetrafluoroethylene': 4,
    'dustMolybdenumDisulfide': 4
]

def liquidFrictionModifierMap = [
    'oleic_acid': 1,
    'stearic_acid': 1,
    'linoleic_acid': 1,
    'palmitic_acid': 1,
    'oleylamide': 2,
    'monoglycerides': 2
]

def solidAntiwearMap = [
    'dustMolybdenumDialkyldithiophosphate': 4,
    'dustZincBisdiamyldithiocarbamate': 2
]

def liquidAntiwearMap = [
    'tricresyl_phosphate': 1,
    'zinc_dialkyldithiophosphate': 1.5
]

def pourPointDepressantMap = [
    'dustEthylenePropyleneCopolymer': 1,
    'dustHydrogenatedStyreneIsopreneRubber': 2,
    'dustHydrogenatedStyreneButadieneRubber': 2,
    'dustPolyisobutene': 2,
    'dustPama': 4
]

// calcium_phenate: 3

def detergentMap = [
    'dustSmallCalciumDodecylbenzeneSulfonate': 1,
    'dustCalciumSalicylate': 2,
    'dustPolyisobuteneSuccinicAnhydride': 4
]

def chelates = [
    'dustSalicylideneEthylenediamine',
    'dustSalicylideneOneTwoPropanediamine'
]

def corrosionInhibitors = [
    'dustBenzotriazole',
    'dustMercaptobenzothiazole'
]

// dustNPhenylOneNaphthylamine: 2

def antioxidantMap = [
    'butylated_hydroxytoluene': 1.5,
    'dimethyl_tert_butylphenol': 1,
    'di_tert_butylphenol': 1
]

// Base
baseOilMap.each { oil, multiplier1 ->
    solidFrictionModifierMap.each { sfm, multiplier2 ->
        MIXER.recipeBuilder()
            .inputs(ore(sfm))
            .fluidInputs(fluid(oil) * (1000 * multiplier2 * 4))
            .fluidOutputs(fluid('lubricant') * (1000 * multiplier1 * multiplier2 * 4))
            .duration(200)
            .EUt(7)
            .buildAndRegister()
    }

    liquidFrictionModifierMap.each { lfm, multiplier3 ->
        MIXER.recipeBuilder()
            .fluidInputs(fluid(oil) * (1000 * multiplier3))
            .fluidInputs(fluid(lfm) * 250)
            .fluidOutputs(fluid('lubricant') * (1000 * multiplier1 * multiplier3))
            .duration(200)
            .EUt(7)
            .buildAndRegister()
    }
}

// Midgrade
solidAntiwearMap.each { saw, multiplier ->
    BLENDER.recipeBuilder()
        .inputs(ore(saw))
        .fluidInputs(fluid('lubricant') * (1000 * multiplier * 4))
        .fluidInputs(fluid('polyethylene_glycol') * 1000)
        .fluidInputs(fluid('antifoaming_additive') * 1000)
        .fluidOutputs(fluid('midgrade_lubricant') * (1000 * multiplier * 4))
        .duration(200)
        .EUt(120)
        .buildAndRegister()
        
    BLENDER.recipeBuilder()
        .inputs(ore(saw))
        .inputs(ore('dustSmallCalciumDinonylnaphthaleneSulfonate'))
        .fluidInputs(fluid('lubricant') * (1000 * multiplier * 4))
        .fluidInputs(fluid('antifoaming_additive') * 1000)
        .fluidOutputs(fluid('midgrade_lubricant') * (1000 * multiplier * 4))
        .duration(200)
        .EUt(120)
        .buildAndRegister()
}

liquidAntiwearMap.each { law, multiplier ->
    BLENDER.recipeBuilder()
        .fluidInputs(fluid('lubricant') * (1000 * multiplier))
        .fluidInputs(fluid('polyethylene_glycol') * 250)
        .fluidInputs(fluid('antifoaming_additive') * 250)
        .fluidInputs(fluid(law) * 250)
        .fluidOutputs(fluid('midgrade_lubricant') * (1000 * multiplier))
        .duration(200)
        .EUt(120)
        .buildAndRegister()

    BLENDER.recipeBuilder()
        .inputs(ore('dustSmallCalciumDinonylnaphthaleneSulfonate'))
        .fluidInputs(fluid('lubricant') * (1000 * multiplier * 4))
        .fluidInputs(fluid('antifoaming_additive') * 1000)
        .fluidInputs(fluid(law) * 1000)
        .fluidOutputs(fluid('midgrade_lubricant') * (1000 * multiplier * 4))
        .duration(200)
        .EUt(120)
        .buildAndRegister()
}

// Premium
pourPointDepressantMap.each { ppd, multiplier1 ->
    BLENDER.recipeBuilder()
        .inputs(ore(ppd))
        .fluidInputs(fluid('calcium_phenate') * 1000)
        .inputs(ore('dustTinyCalciumDidodecylbenzeneSulfonate'))
        .fluidInputs(fluid('midgrade_lubricant') * (1000 * multiplier1 * 3 * 4))
        .fluidOutputs(fluid('premium_lubricant') * (1000 * multiplier1 * 3 * 4))
        .duration(200)
        .EUt(120)
        .buildAndRegister()

    BLENDER.recipeBuilder()
        .inputs(ore(ppd))
        .fluidInputs(fluid('calcium_phenate') * 1000)
        .inputs(ore('dustSmallFourNonylphenoxyaceticAcid'))
        .fluidInputs(fluid('midgrade_lubricant') * (1000 * multiplier1 * 3 * 4 * 1.5))
        .fluidOutputs(fluid('premium_lubricant') * (1000 * multiplier1 * 3 * 4 * 1.5))
        .duration(200)
        .EUt(120)
        .buildAndRegister()
    
    detergentMap.each { det, multiplier2 ->
        BLENDER.recipeBuilder()
            .inputs(ore(det))
            .inputs(ore(ppd))
            .inputs(ore('dustTinyCalciumDidodecylbenzeneSulfonate'))
            .fluidInputs(fluid('midgrade_lubricant') * (1000 * multiplier1 * multiplier2 * 4))
            .fluidOutputs(fluid('premium_lubricant') * (1000 * multiplier1 * multiplier2 * 4))
            .duration(200)
            .EUt(120)
            .buildAndRegister()

        BLENDER.recipeBuilder()
            .inputs(ore(det))
            .inputs(ore(ppd))
            .inputs(ore('dustSmallFourNonylphenoxyaceticAcid'))
            .fluidInputs(fluid('midgrade_lubricant') * (1000 * multiplier1 * multiplier2 * 4))
            .fluidOutputs(fluid('premium_lubricant') * (1000 * multiplier1 * multiplier2 * 4))
            .duration(200)
            .EUt(120)
            .buildAndRegister()
    }
}

// Supreme

for (chelate in chelates) {
    for (ci in corrosionInhibitors) {
        BLENDER.recipeBuilder()
            .inputs(ore(chelate))
            .inputs(ore(ci))
            .inputs(ore('dustNPhenylOneNaphthylamine'))
            .fluidInputs(fluid('premium_lubricant') * 4000)
            .fluidOutputs(fluid('supreme_lubricant') * 4000)
            .duration(200)
            .EUt(120)
            .buildAndRegister()

        antioxidantMap.each { ant, multiplier ->
            BLENDER.recipeBuilder()
                .inputs(ore(chelate))
                .inputs(ore(ci))
                .fluidInputs(fluid(ant) * 1000)
                .fluidInputs(fluid('premium_lubricant') * (1000 * multiplier * 4))
                .fluidOutputs(fluid('supreme_lubricant') * (1000 * multiplier * 4))
                .duration(200)
                .EUt(120)
                .buildAndRegister()
        }
    }
}
