import static globals.Globals.*

CSTR = recipemap('continuous_stirred_tank_reactor')
TBR = recipemap('trickle_bed_reactor')
FBR = recipemap('fixed_bed_reactor')
BCR = recipemap('bubble_column_reactor')
BR = recipemap('batch_reactor')
POLYMERIZATION = recipemap('polymerization_tank')
FLUIDIZEDBR = recipemap('fluidized_bed_reactor')
DISTILLATION_TOWER = recipemap('distillation_tower')
DISTILLERY = recipemap('distillery')
ROASTER = recipemap('roaster')
CRYSTALLIZER = recipemap('crystallizer')
MIXER = recipemap('mixer')
DRYER = recipemap('dryer')
CHEMICAL_BATH = recipemap('chemical_bath')
CENTRIFUGE = recipemap('centrifuge')
PYROLYSE = recipemap('pyrolyse_oven')
LCR = recipemap('large_chemical_reactor')
EBF = recipemap('electric_blast_furnace')
VULCANIZER = recipemap('vulcanizing_press')
ALLOY_SMELTER = recipemap('alloy_smelter')
ARC_FURNACE = recipemap('arc_furnace')
VACUUM_DT = recipemap('vacuum_distillation')
AUTOCLAVE = recipemap('autoclave')
COMPRESSOR = recipemap('compressor')
ASSEMBLER = recipemap('assembler')
ELECTROLYZER = recipemap('electrolyzer')
ELECTROLYTIC_CELL = recipemap('electrolytic_cell')
REACTION_FURNACE = recipemap('reaction_furnace')
ELECTROMAGNETIC_SEPARATOR = recipemap('electromagnetic_separator')
PSA = recipemap('pressure_swing_adsorption')
SINTERING_OVEN = recipemap('sintering_oven')

def major_solvents = [
    'xylene'
    'naphtha'
    'toluene'
]

def minor_solvents = [
    'naphthalene'
    'pseudocumene'
    'isopropyl_alcohol'
    'ethylbenzene'
]

// Antioxidant active ingredients

    // 2,6-Di-tert-butylphenol

    CSTR.recipeBuilder()
        .fluidInputs(fluid('isobutylene') * 50)
        .fluidInputs(fluid('water') * 50)
        .notConsumable(fluid('sulfuric_acid') * 50)
        .fluidOutputs(fluid('tert_butyl_alcohol') * 50)
        .duration(5)
        .EUt(120)
        .buildAndRegister()

    // 2,4,6-tri-tert-butylphenol (BHT)

    CSTR.recipeBuilder()
        .fluidInputs(fluid('isobutylene') * 100)
        .fluidInputs(fluid('cresol') * 50)
        .notConsumable(fluid('sulfuric_acid') * 50)
        .fluidOutputs(fluid('butylated_hydroxytoluene') * 50)
        .duration(5)
        .EUt(120)
        .buildAndRegister()

    // 2,4-Dimethyl-6-tert-butylphenol

    CSTR.recipeBuilder()
        .fluidInputs(fluid('isobutylene') * 50)
        .fluidInputs(fluid('xylenol') * 50)
        .notConsumable(fluid('sulfuric_acid') * 50)
        .fluidOutputs(fluid('dimethyl_tert_butylphenol') * 50)
        .duration(5)
        .EUt(120)
        .buildAndRegister()

    // 2,6-Di-tert-butylphenol

    BR.recipeBuilder()
        .inputs(ore('dustAluminium'))
        .fluidInputs(fluid('phenol') * 3000)
        .fluidOutputs(fluid('aluminium_phenolate') * 1000)
        .fluidOutputs(fluid('hydrogen') * 3000)
        .duration(200)
        .EUt(120)
        .buildAndRegister()

    CSTR.recipeBuilder()
        .fluidInputs(fluid('isobutylene') * 100)
        .fluidInputs(fluid('phenol') * 50)
        .notConsumable(fluid('aluminium_phenolate') * 50)
        .fluidOutputs(fluid('di_tert_butylphenol') * 50)
        .duration(5)
        .EUt(120)
        .buildAndRegister()

    // N-substituted p-Phenylenediamine

    BR.recipeBuilder()
        .inputs(ore('dustParaPhenylenediamine') * 16)
        .inputs(ore('dustSodiumCyanoborohydride') * 14)
        .fluidInputs(fluid('hydrochloric_acid') * 2000)
        .fluidInputs(fluid('acetone') * 2000)
        .fluidOutputs(fluid('diisopropyl_para_phenylenediamine_solution') * 2000)
        .duration(200)
        .EUt(120)
        .buildAndRegister()

    DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('diisopropyl_para_phenylenediamine_solution') * 1000)
        .outputs(metaitem('dustDiisopropylParaPhenylenediamine') * 36)
        .fluidOutputs(fluid('wastewater') * 2000)
        .duration(20)
        .EUt(30)
        .buildAndRegister()        

// Fuel system icing inhibitor & diglyme

CSTR.recipeBuilder()
    .circuitMeta(1)
    .fluidInputs(fluid('sulfuric_acid') * 50)
    .fluidInputs(fluid('diethylene_glycol') * 50)
    .fluidInputs(fluid('methanol') * 100)
    .fluidOutputs(fluid('diglyme') * 50)
    .fluidOutputs(fluid('very_diluted_sulfuric_acid') * 150)
    .duration(5)
    .EUt(120)
    .buildAndRegister()

CSTR.recipeBuilder()
    .circuitMeta(2)
    .fluidInputs(fluid('sulfuric_acid') * 50)
    .fluidInputs(fluid('diethylene_glycol') * 50)
    .fluidInputs(fluid('methanol') * 50)
    .fluidOutputs(fluid('methyl_carbitol') * 50)
    .fluidOutputs(fluid('diluted_sulfuric_acid') * 100)
    .duration(5)
    .EUt(120)
    .buildAndRegister()

// Antiknock active ingredients

    // Isooctane

    CSTR.recipeBuilder()
        .fluidInputs(fluid('isobutylene') * 50)
        .fluidInputs(fluid('isobutane') * 50)
        .notConsumable(fluid('sulfuric_acid') * 50)
        .fluidOutputs(fluid('isooctane') * 50)
        .duration(5)
        .EUt(120)
        .buildAndRegister()

    // Ferrocene

    ALLOY_SMELTER.recipeBuilder()
        .inputs(ore('dustPotassium'))
        .inputs(ore('dustMolecularSieve') * 4)
        .outputs(metaitem('dustPotassiumMolecularSieve') * 4)
        .duration(300)
        .EUt(120)
        .buildAndRegister()

    ALLOY_SMELTER.recipeBuilder()
        .inputs(ore('dustCaesium'))
        .inputs(ore('dustMolecularSieve') * 4)
        .outputs(metaitem('dustCesiumMolecularSieve') * 4)
        .duration(400)
        .EUt(120)
        .buildAndRegister()

    ALLOY_SMELTER.recipeBuilder()
        .inputs(ore('dustSodium'))
        .inputs(ore('dustLead'))
        .outputs(metaitem('ingotSodiumLeadAlloy') * 2)
        .duration(300)
        .EUt(30)
        .buildAndRegister()

    SIFTER.recipeBuilder()
        .fluidInputs(fluid('isoprene') * 4000)
        .inputs(ore('dustCesiumMolecularSieve') * 1)
        .fluidOutputs(fluid('purified_isoprene') * 4000)
        .outputs(metaitem('dustSaturatedCesiumMolecularSieve') * 1)
        .duration(200)
        .EUt(120)
        .buildAndRegister()

    SIFTER.recipeBuilder()
        .fluidInputs(fluid('isoprene') * 4000)
        .inputs(ore('dustPotassiumMolecularSieve') * 1)
        .fluidOutputs(fluid('purified_isoprene') * 4000)
        .outputs(metaitem('dustSaturatedPotassiumMolecularSieve') * 1)
        .duration(300)
        .EUt(120)
        .buildAndRegister()

    CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('benzene') * 50)
        .inputs(ore('dustSaturatedPotassiumMolecularSieve') * 1)
        .fluidOutputs(fluid('cyclopentadiene_solution') * 100)
        .outputs(metaitem('dustPotassiumMolecularSieve') * 1)
        .duration(200)
        .EUt(120)
        .buildAndRegister()

    CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('benzene') * 100)
        .inputs(ore('dustSaturatedCesiumMolecularSieve') * 1)
        .fluidOutputs(fluid('cyclopentadiene_solution') * 200)
        .outputs(metaitem('dustCesiumMolecularSieve') * 1)
        .duration(200)
        .EUt(120)
        .buildAndRegister()

    DT.recipeBuilder()
        .fluidInputs(fluid('cyclopentadiene_solution') * 2000)
        .fluidOutputs(fluid('benzene') * 1000)
        .fluidOutputs(fluid('cyclopentadiene') * 1000)
        .duration(200)
        .EUt(120)
        .buildAndRegister()

    BR.recipeBuilder()
        .fluidInputs(fluid('iron_pentacarbonyl') * 1000)
        .fluidInputs(fluid('cyclopentadiene') * 2000)
        .outputs(metaitem('dustFerrocene') * 11)
        .fluidOutputs(fluid('carbon_monoxide') * 5000)
        .fluidOutputs(fluid('hydrogen') * 2000)
        .duration(300)
        .EUt(120)
        .buildAndRegister()

    // Methylcyclopentadienylmanganese tricarbonyl

    CSTR.recipeBuilder()
        .fluidInputs(fluid('sodium_cyclopentadienide_solution') * 50)
        .fluidInputs(fluid('chloromethane') * 50)
        .fluidOutputs(fluid('methylcyclopentadiene_solution') * 100)
        .fluidOutputs(fluid('hydrogen') * 1000)
        .duration(5)
        .EUt(120)
        .buildAndRegister()

    DT.recipeBuilder()
        .fluidInputs(fluid('methylcyclopentadiene_solution') * 2000)
        .outputs(metaitem('dustSalt') * 2)
        .fluidOutputs(fluid('methylcyclopentadiene') * 1000)
        .fluidOutputs(fluid('tetrahydrofuran') * 1000)
        .duration(20)
        .EUt(30)
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustManganeseIiChloride') * 3)
        .fluidInputs(fluid('sodium') * 288)
        .fluidInputs(fluid('methylcyclopentadiene') * 2000)
        .fluidInputs(fluid('diglyme') * 1000)
        .fluidOutputs(fluid('bismethylcyclopentadienylmanganese_solution') * 2000)
        .duration(100)
        .EUt(120)
        .buildAndRegister()
    
    DT.recipeBuilder()
        .fluidInputs(fluid('bismethylcyclopentadienylmanganese_solution') * 1000)
        .outputs(metaitem('dustSalt') * 4)
        .fluidOutputs(fluid('diglyme') * 1000)
        .fluidOutputs(fluid('bismethylcyclopentadienylmanganese') * 1000)
        .duration(100)
        .EUt(120)
        .buildAndRegister()

    BR.recipeBuilder()
        .notConsumable(ore('springCupronickel'))
        .fluidInputs(fluid('hot_hp_carbon_monoxide') * 3000)
        .fluidInputs(fluid('bismethylcyclopentadienylmanganese') * 1000)
        .fluidOutputs(fluid('methylcyclopentadienylmanganese_tricarbonyl') * 1000)
        .fluidOutputs(fluid('methylcyclopentadiene') * 1000)
        .duration(100)
        .EUt(120)
        .buildAndRegister()

    // Tetraethyl Lead

    BCR.recipeBuilder()
        .fluidInputs(fluid('hydrogen_chloride') * 50)
        .fluidInputs(fluid('ethylene') * 50)
        .fluidOutputs(fluid('chloroethane') * 50)
        .duration(5)
        .EUt(120)
        .buildAndRegister()

    BR.recipeBuilder()
        .fluidInputs(fluid('chloroethane') * 4000)
        .inputs(ore('dustSodiumLeadAlloy') * 8)
        .fluidOutputs(fluid('tetraethyllead_sludge') * 2000)
        .duration(200)
        .EUt(120)
        .buildAndRegister()

    DT.recipeBuilder()
        .fluidInputs(fluid('tetraethyllead_sludge') * 2000)
        .outputs(metaitem('dustSalt') * 8)
        .fluidOutputs(fluid('lead') * 432)
        .fluidOutputs(fluid('tetraethyllead') * 1000)
        .duration(200)
        .EUt(120)
        .buildAndRegister()

// Cetane improver (2-ethylhexyl nitrate)

CSTR.recipeBuilder()
    .fluidInputs(fluid('two_ethylhexanol') * 50)
    .fluidInputs(fluid('nitration_mixture') * 100)
    .fluidOutputs(fluid('diluted_two_ethylhexyl_nitrate') * 150)
    .duration(5)
    .EUt(120)
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('diluted_two_ethylhexyl_nitrate') * 3000)
    .fluidOutputs(fluid('two_ethylhexyl_nitrate') * 1000)
    .fluidOutputs(fluid('water') * 1000)
    .fluidOutputs(fluid('sulfuric_acid') * 1000)
    .duration(200)
    .EUt(120)
    .buildAndRegister()

// Metal deactivator (N,N’-Disalicylidene-1,2-propanediamine, SALPN)

CSTR.recipeBuilder()
    .fluidInputs(fluid('propylene_oxide') * 50)
    .fluidInputs(fluid('ammonia') * 50)
    .fluidOutputs(fluid('propanolamine_mix') * 50)
    .duration(5)
    .EUt(120)
    .buildAndRegister()

FBR.recipeBuilder()
    .notConsumable(metaitem('catalystBedAlumina'))
    .fluidInputs(fluid('propanolamine_mix') * 50)
    .fluidInputs(fluid('ammonia') * 50)
    .fluidOutputs(fluid('one_two_diaminopropane_solution') * 100)
    .duration(5)
    .EUt(120)
    .buildAndRegister();

BR.recipeBuilder()
    .inputs(ore('dustPotassiumHydroxide') * 9)
    .fluidInputs(fluid('phenol') * 1000)
    .fluidInputs(fluid('chloroform') * 1000)
    .fluidOutputs(fluid('salicylaldehyde_solution') * 3000)
    .duration(200)
    .EUt(120)
    .buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
    .fluidInputs(fluid('salicylaldehyde_solution') * 3000)
    .outputs(metaitem('dustRockSalt') * 6)
    .fluidOutputs(fluid('salicylaldehyde') * 1000)
    .fluidOutputs(fluid('water') * 2000)
    .duration(200)
    .EUt(120)
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('one_two_diaminopropane_solution') * 2000)
    .inputs(ore('dustSodiumCyanoborohydride') * 14)
    .fluidInputs(fluid('hydrochloric_acid') * 2000)
    .fluidInputs(fluid('salicylaldehyde') * 2000)
    .fluidOutputs(fluid('salicylidene_one_two_propanediamine_solution') * 3000)
    .duration(200)
    .EUt(120)
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('salicylidene_one_two_propanediamine_solution') * 3000)
    .outputs(metaitem('dustSalicylideneOneTwoPropanediamine'))
    .fluidOutputs(fluid('wastewater') * 3000)
    .duration(20)
    .EUt(30)
    .buildAndRegister()  

def OxygenateMap = [
    'methanol': 125,
    'ethanol': 125,
    'n_propanol': 125,
    'isopropyl_alcohol': 125,
    'n_butanol': 125,
    'isobutyl_alcohol': 125,
    'tert_butyl_alcohol': 125,
    'ethyl_tertbutyl_ether': 125
]

def AntioxidantMap = [
    'butylated_hydroxytoluene': 200,
    'dimethyl_tert_butylphenol': 200,
    'di_tert_butylphenol': 200
]

def AntiknockMap = [
    'toluene': 500,
    'isooctane': 300,
    'tetraethyllead': 100
]

def getUniquePairs(Map materialsMap) {
    def pairs = []

    materialsMap.each { material1, _ ->
        materialsMap.each { material2, __ ->
            if (material1 == material2) { return }
            def combinationExists = pairs.any { combination -> combination.contains(material1) && combination.contains(material2) }
            if (!combinationExists) { pairs << [material1, material2] }
        }
    }

    return pairs
}

getUniquePairs(OxygenateMap).each { key, val -> 
    MIXER.recipeBuilder()
        .fluidInputs(fluid(key) * OxygenateMap[key])
        .fluidInputs(fluid(val) * OxygenateMap[val])
        .fluidOutputs(fluid('gasoline_oxygenates') * 1000)
        .duration(200)
        .EUt(120)
        .buildAndRegister()
}

getUniquePairs(AntiknockMap).each { key, val -> 
    MIXER.recipeBuilder()
        .fluidInputs(fluid(key) * AntiknockMap[key])
        .fluidInputs(fluid(val) * AntiknockMap[val])
        .fluidOutputs(fluid('gasoline_antiknock') * 1000)
        .duration(200)
        .EUt(120)
        .buildAndRegister()
}

// Cetane-Boosted Diesel * 750
mods.gregtech.mixer.removeByInput(480, null, [fluid('bio_diesel') * 1000, fluid('tetranitromethane') * 40])
// Cetane-Boosted Diesel * 1000
mods.gregtech.mixer.removeByInput(480, null, [fluid('diesel') * 1000, fluid('tetranitromethane') * 20])

for (major_solvent in major_solvents) {
    for (minor_solvent in minor_solvents) {
        MIXER.recipeBuilder()
            .inputs(metaitem('dustSmallSodiumDodecylSulfate'))
            .fluidInputs(fluid('two_butoxyethanol') * 250)
            .fluidInputs(fluid(major_solvent) * 1500)
            .fluidInputs(fluid(minor_solvent) * 250)
            .fluidOutputs(fluid('lubricity_additive') * 2000)
            .duration(200)
            .EUt(Globals.voltAmps[2])
            .buildAndRegister()
    
        MIXER.recipeBuilder()
            .inputs(ore('dustSmallDinonylnaphthaleneSulfonicAcid'))
            .fluidInputs(fluid(major_solvent) * 1500)
            .fluidInputs(fluid(minor_solvent) * 500)
            .fluidOutputs(fluid('antistatic_additive') * 2000)
            .duration(200)
            .EUt(Globals.voltAmps[2])
            .buildAndRegister()

        MIXER.recipeBuilder()
            .inputs(ore('dustSmallDinonylnaphthaleneSulfonicAcid'))
            .fluidInputs(fluid(major_solvent) * 1500)
            .fluidInputs(fluid(minor_solvent) * 500)
            .fluidOutputs(fluid('antistatic_additive') * 2000)
            .duration(200)
            .EUt(Globals.voltAmps[2])
            .buildAndRegister()

        MIXER.recipeBuilder()
            .inputs(ore('dustSmallSalicylideneOneTwoPropanediamine'))
            .fluidInputs(fluid(major_solvent) * 1500)
            .fluidInputs(fluid(minor_solvent) * 500)
            .fluidOutputs(fluid('metal_deactivator') * 2000)
            .duration(200)
            .EUt(Globals.voltAmps[2])
            .buildAndRegister()

        MIXER.recipeBuilder()
            .fluidInputs(fluid('two_ethylhexyl_nitrate') * 250)
            .fluidInputs(fluid(major_solvent) * 1500)
            .fluidInputs(fluid(minor_solvent) * 250)
            .fluidOutputs(fluid('ignition_improver') * 2000)
            .duration(200)
            .EUt(Globals.voltAmps[2])
            .buildAndRegister()

        getUniquePairs(AntioxidantMap).each { key, val -> 
            MIXER.recipeBuilder()
                .fluidInputs(fluid(key) * AntioxidantMap[key])
                .fluidInputs(fluid(val) * AntioxidantMap[val])
                .fluidInputs(fluid(major_solvent) * 1200)
                .fluidInputs(fluid(minor_solvent) * 400)
                .fluidOutputs(fluid('antioxidants') * 2000)
                .duration(200)
                .EUt(120)
                .buildAndRegister()
        }

        for (antioxidant in AntioxidantMap) {
            MIXER.recipeBuilder()
                    .inputs(ore('dustDiisopropylParaPhenyleneDiamine') * 4)
                    .fluidInputs(fluid(antioxidant) * 200)
                    .fluidInputs(fluid(major_solvent) * 1400)
                    .fluidInputs(fluid(minor_solvent) * 400)
                    .fluidOutputs(fluid('gasoline_antiknock') * 2000)
                    .duration(200)
                    .EUt(120)
                    .buildAndRegister()
        }
    }
}

// Gasoline final blending

LCR.recipeBuilder()
    .circuitMeta(1)
    .fluidInputs(fluid('gasoline') * 1000)
    .fluidInputs(fluid('gasoline_antioxidants') * 100)
    .fluidInputs(fluid('gasoline_oxygenates') * 100)
    .fluidOutputs(fluid('midgrade_gasoline') * 1000)
    .duration(10)
    .EUt(120)
    .buildAndRegister()

LCR.recipeBuilder()
    .circuitMeta(2)
    .fluidInputs(fluid('gasoline') * 1000)
    .fluidInputs(fluid('gasoline_general_additives') * 100)
    .fluidInputs(fluid('gasoline_antioxidants') * 100)
    .fluidInputs(fluid('gasoline_oxygenates') * 100)
    .fluidOutputs(fluid('premium_gasoline') * 1000)
    .duration(10)
    .EUt(120)
    .buildAndRegister()

LCR.recipeBuilder()
    .circuitMeta(3)
    .fluidInputs(fluid('gasoline') * 1000)
    .fluidInputs(fluid('gasoline_general_additives') * 100)
    .fluidInputs(fluid('gasoline_oxygenates') * 100)
    .fluidInputs(fluid('gasoline_antiknock') * 100)
    .fluidInputs(fluid('gasoline_antioxidants') * 100)
    .fluidOutputs(fluid('supreme_gasoline') * 1000)
    .duration(10)
    .EUt(120)
    .buildAndRegister()

// Diesel final blending

// Kerosene final blending