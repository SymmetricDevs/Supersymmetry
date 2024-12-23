import globals.Globals

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
BLENDER = recipemap('blender')

def major_solvents = [
    'xylene',
    'light_naphtha',
    'toluene'
]

def minor_solvents = [
    'naphthalene',
    'isopropyl_alcohol',
    'ethylbenzene'
]

// Oxygenates

// Methyl-tert-butyl ether

    FBR.recipeBuilder()
        .notConsumable(ore('catalystBedChloridedAlumina'))
        .notConsumable(fluid('hydrogen') * 50)
        .fluidInputs(fluid('butane') * 50)
        .fluidOutputs(fluid('isobutane') * 50)
        .duration(5)
        .EUt(30)
        .buildAndRegister()

    FBR.recipeBuilder()
        .fluidInputs(fluid('isobutane') * 50)
        .notConsumable(ore('dustChromiumTrioxide'))
        .fluidOutputs(fluid('isobutylene') * 50)
        .duration(5)
        .EUt(30)
        .buildAndRegister()

    CSTR.recipeBuilder()
        .fluidInputs(fluid('methanol') * 50)
        .fluidInputs(fluid('isobutylene') * 50)
        .fluidOutputs(fluid('methyl_tert_butyl_ether') * 50)
        .duration(5)
        .EUt(30)
        .buildAndRegister()

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

    // 2,4/5-Dimethyl-6-tert-butylphenol

    CSTR.recipeBuilder()
        .fluidInputs(fluid('isobutylene') * 50)
        .fluidInputs(fluid('two_four_five_xylenol_mixture') * 50)
        .notConsumable(fluid('sulfuric_acid') * 50)
        .fluidOutputs(fluid('dimethyl_tert_butylphenol') * 50)
        .duration(5)
        .EUt(120)
        .buildAndRegister()

    // 2,6-Di-tert-butylphenol

    BR.recipeBuilder()
        .inputs(ore('dustAnyPurityAluminium'))
        .fluidInputs(fluid('phenol') * 3000)
        .outputs(metaitem('dustAluminiumPhenolate'))
        .fluidOutputs(fluid('hydrogen') * 3000)
        .duration(200)
        .EUt(120)
        .buildAndRegister()

    CSTR.recipeBuilder()
        .notConsumable(ore('dustAluminiumPhenolate'))
        .fluidInputs(fluid('isobutylene') * 100)
        .fluidInputs(fluid('phenol') * 50)
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

    ALLOY_SMELTER.recipeBuilder()
        .inputs(ore('dustAnyPuritySodium'))
        .inputs(ore('dustAnyPurityLead'))
        .outputs(metaitem('ingotSodiumLeadAlloy') * 2)
        .duration(300)
        .EUt(30)
        .buildAndRegister()

    ALLOY_SMELTER.recipeBuilder()
        .inputs(ore('dustAnyPuritySodium'))
        .inputs(ore('ingotLead'))
        .outputs(metaitem('ingotSodiumLeadAlloy') * 2)
        .duration(300)
        .EUt(30)
        .buildAndRegister()

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
    .fluidInputs(fluid('water') * 1000)
    .fluidOutputs(fluid('salicylaldehyde') * 1000)
    .fluidOutputs(fluid('potassium_chloride_solution') * 3000)
    .duration(200)
    .EUt(120)
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('one_two_diaminopropane_solution') * 2000)
    .fluidInputs(fluid('hydrogen_chloride') * 1000)
    .fluidInputs(fluid('salicylaldehyde') * 2000)
    .outputs(metaitem('dustSalicylideneOneTwoPropanediamine'))
    .fluidOutputs(fluid('diluted_hydrochloric_acid') * 2000)
    .duration(200)
    .EUt(120)
    .buildAndRegister()

// Cold flow improvers

    // EVA-isobutylene terpolymer for cold flow additives

    POLYMERIZATION.recipeBuilder()
        .circuitMeta(3)
        .fluidInputs(fluid('ethylene') * 1000)
        .fluidInputs(fluid('isobutylene') * 1000)
        .fluidInputs(fluid('vinyl_acetate_suspension') * 1000)
        .inputs(ore('dustTinyPotassiumPersulfate'))
        .fluidOutputs(fluid('ethylene_isobutylene_vinyl_acetate_suspension') * 2000)
        .duration(200)
        .EUt(120)
        .buildAndRegister()

    PHASE_SEPARATOR.recipeBuilder()
        .fluidInputs(fluid('ethylene_isobutylene_vinyl_acetate_suspension') * 2000)
        .outputs(metaitem('dustEthyleneIsobutyleneVinylAcetate') * 3)
        .fluidOutputs(fluid('methanol') * 1000)
        .duration(50)
        .buildAndRegister()

    // Wax antisetlling agent (N,N-dihexadecyl phthalic acid amide)

    FBR.recipeBuilder()
        .notConsumable(metaitem('catalystBedAlumina'))
        .fluidInputs(fluid('n_hexadecanol') * 100)
        .fluidInputs(fluid('ammonia') * 50)
        .fluidOutputs(fluid('dihexadecylamine') * 50)
        .fluidOutputs(fluid('water') * 100)
        .duration(5)
        .EUt(120)
        .buildAndRegister();

    BR.recipeBuilder()
        .inputs(ore("dustPhthalicAnhydride") * 13)
        .fluidInputs(fluid('dihexadecylamine') * 2000)
        .notConsumable(fluid('sulfuric_acid') * 50)
        .outputs(metaitem('dustDihexadecylaminePhthalateAmide'))
        .duration(200)
        .EUt(120)
        .buildAndRegister()

// Corrosion inhibitors
for (inertGas in Globals.inertGases) {
    REACTION_FURNACE.recipeBuilder()
        .notConsumable(ore('dustAluminiumSilicate'))
        .notConsumable(fluid(inertGas.name) * inertGas.amount_required)
        .fluidInputs(fluid('linoleic_acid') * 2000)
        .fluidOutputs(fluid('corrosion_inhibitor') * 2000)
        .duration(200 * inertGas.duration)
        .EUt(120)
        .buildAndRegister()

    REACTION_FURNACE.recipeBuilder()
        .notConsumable(ore('dustAluminiumSilicate'))
        .notConsumable(fluid(inertGas.name) * inertGas.amount_required)
        .fluidInputs(fluid('oleic_acid') * 2000)
        .fluidOutputs(fluid('corrosion_inhibitor') * 2000)
        .duration(200 * inertGas.duration)
        .EUt(120)
        .buildAndRegister()
}
def OxygenateMap = [
    'methanol': 1000,
    'ethanol': 1000,
    'n_propanol': 750,
    'isopropyl_alcohol': 750,
    'n_butanol': 500,
    'isobutyl_alcohol': 500,
    'tert_butyl_alcohol': 250,
    'methyl_tert_butyl_ether': 125
]

def AntioxidantMap = [
    'butylated_hydroxytoluene': 200,
    'dimethyl_tert_butylphenol': 200,
    'di_tert_butylphenol': 200
]

def AntiknockMap = [
    'isooctane': 250,
    'tetraethyllead': 100,
    'methylcyclopentadienylmanganese_tricarbonyl': 50
]

// Returns an array of unique material pairs
def getUniquePairs(Map materialsMap) {
    def pairs = []

    // Convert map entries to a list for easier iteration
    def materialList = materialsMap.entrySet().toList()

    for (int i = 0; i < materialList.size() - 1; i++) {
        def material1 = materialList[i]
        for (int j = i + 1; j < materialList.size(); j++) {
            def material2 = materialList[j]

            // Check if the pair is already in the list
            def combinationExists = pairs.any { it.contains(material1) && it.contains(material2) }

            if (!combinationExists) {
                pairs << [material1, material2]
            }
        }
    }

    return pairs
}

// Cetane-Boosted Diesel * 750
mods.gregtech.mixer.removeByInput(480, null, [fluid('bio_diesel') * 1000, fluid('tetranitromethane') * 40])
mods.gregtech.blender.removeByInput(480, null, [fluid('bio_diesel') * 1000, fluid('tetranitromethane') * 40])
// Cetane-Boosted Diesel * 1000
mods.gregtech.mixer.removeByInput(480, null, [fluid('diesel') * 1000, fluid('tetranitromethane') * 20])
mods.gregtech.blender.removeByInput(480, null, [fluid('diesel') * 1000, fluid('tetranitromethane') * 20])
for (major_solvent in major_solvents) {
    for (minor_solvent in minor_solvents) {
        BLENDER.recipeBuilder()
            .inputs(metaitem('dustSmallSodiumDodecylSulfate'))
            .fluidInputs(fluid('two_butoxyethanol') * 250)
            .fluidInputs(fluid(major_solvent) * 1500)
            .fluidInputs(fluid(minor_solvent) * 250)
            .fluidOutputs(fluid('lubricity_additive') * 2000)
            .duration(200)
            .EUt(Globals.voltAmps[2])
            .buildAndRegister()
    
        BLENDER.recipeBuilder()
            .inputs(ore('dustSmallDinonylnaphthaleneSulfonicAcid'))
            .fluidInputs(fluid(major_solvent) * 1500)
            .fluidInputs(fluid(minor_solvent) * 500)
            .fluidOutputs(fluid('antistatic_additive') * 2000)
            .duration(200)
            .EUt(Globals.voltAmps[2])
            .buildAndRegister()

        BLENDER.recipeBuilder()
            .inputs(ore('dustSmallSalicylideneOneTwoPropanediamine'))
            .fluidInputs(fluid(major_solvent) * 1500)
            .fluidInputs(fluid(minor_solvent) * 500)
            .fluidOutputs(fluid('metal_deactivator') * 2000)
            .duration(200)
            .EUt(Globals.voltAmps[2])
            .buildAndRegister()

        BLENDER.recipeBuilder()
            .fluidInputs(fluid('two_ethylhexyl_nitrate') * 250)
            .fluidInputs(fluid(major_solvent) * 1500)
            .fluidInputs(fluid(minor_solvent) * 250)
            .fluidOutputs(fluid('ignition_improver') * 2000)
            .duration(200)
            .EUt(Globals.voltAmps[2])
            .buildAndRegister()

        BLENDER.recipeBuilder()
            .circuitMeta(1)
            .inputs(ore('dustSmallEthyleneIsobutyleneVinylAcetate'))
            .fluidInputs(fluid(major_solvent) * 1500)
            .fluidInputs(fluid(minor_solvent) * 500)
            .fluidOutputs(fluid('cold_flow_improver') * 2000)
            .duration(200)
            .EUt(Globals.voltAmps[2])
            .buildAndRegister()

        BLENDER.recipeBuilder()
            .fluidInputs(fluid('polydimethylsiloxane') * 250)
            .fluidInputs(fluid(major_solvent) * 1500)
            .fluidInputs(fluid(minor_solvent) * 250)
            .fluidOutputs(fluid('antifoaming_additive') * 2000)
            .duration(200)
            .EUt(Globals.voltAmps[2])
            .buildAndRegister()

        BLENDER.recipeBuilder()
            .inputs(ore('dustSmallEthyleneIsobutyleneVinylAcetate'))
            .inputs(ore('dustSmallDihexadecylaminePhthalateAmide'))
            .fluidInputs(fluid(major_solvent) * 6000)
            .fluidInputs(fluid(minor_solvent) * 2000)
            .fluidOutputs(fluid('cold_flow_improver') * 8000)
            .duration(200)
            .EUt(Globals.voltAmps[2])
            .buildAndRegister()

        AntiknockMap.each { key, val ->
            BLENDER.recipeBuilder()
                .fluidInputs(fluid(key) * val)
                .fluidInputs(fluid(major_solvent) * 1500)
                .fluidInputs(fluid(minor_solvent) * (500 - val))
                .fluidOutputs(fluid('antiknock') * 1000)
                .duration(200)
                .EUt(120)
                .buildAndRegister()
        }

        BLENDER.recipeBuilder()
            .inputs(ore('dustFerrocene'))
            .fluidInputs(fluid(major_solvent) * 1500)
            .fluidInputs(fluid(minor_solvent) * 500)
            .fluidOutputs(fluid('antiknock') * 1000)
            .duration(200)
            .EUt(120)
            .buildAndRegister()


        def antioxidantPairs = getUniquePairs(AntioxidantMap)

        for (pair in antioxidantPairs) {
            BLENDER.recipeBuilder()
                .fluidInputs(fluid(pair[0].getKey()) * pair[0].getValue())
                .fluidInputs(fluid(pair[1].getKey()) * pair[1].getValue())
                .fluidInputs(fluid(major_solvent) * 1400)
                .fluidInputs(fluid(minor_solvent) * 200)
                .fluidOutputs(fluid('antioxidants') * 2000)
                .duration(200)
                .EUt(120)
                .buildAndRegister()
        }
        
        for (antioxidant in AntioxidantMap) {
            BLENDER.recipeBuilder()
                    .inputs(ore('dustDiisopropylParaPhenylenediamine') * 4)
                    .fluidInputs(fluid(antioxidant.key) * 200)
                    .fluidInputs(fluid(major_solvent) * 3400)
                    .fluidInputs(fluid(minor_solvent) * 400)
                    .fluidOutputs(fluid('antioxidants') * 4000)
                    .duration(200)
                    .EUt(120)
                    .buildAndRegister()
        }
    }
}

def oxygenatePairs = getUniquePairs(OxygenateMap)

for (pair in oxygenatePairs) {
    BLENDER.recipeBuilder()
        .fluidInputs(fluid(pair[0].getKey()) * pair[0].getValue())
        .fluidInputs(fluid(pair[1].getKey()) * pair[1].getValue())
        .fluidOutputs(fluid('oxygenates') * 2000)
        .duration(200)
        .EUt(120)
        .buildAndRegister()
}

log.infoMC("Registered oxygenate pairs")

// Gasoline final blending

def GasolineFeedstocks = [
    'naphtha' : 1,
    'light_naphtha' : 1,
    'reformate' : 3,
    'reformate_raffinate' : 2.5,
    'polymerate' : 2,
    'isomerate' : 3,
    'alkylate' : 2.5,
    'pyrolysis_gasoline' : 1.5,
    'pyrolysis_raffinate' : 1
]

GasolineFeedstocks.each { key, val ->
    MIXER.recipeBuilder()
        .fluidInputs(fluid(key) * 1000)
        .fluidOutputs(fluid('gasoline') * ((int)(1000 * val)))
        .circuitMeta(10)
        .duration(2)
        .EUt(120)
        .buildAndRegister()
}

BLENDER.recipeBuilder()
    .fluidInputs(fluid('gasoline') * 1000)
    .fluidInputs(fluid('oxygenates') * 50)
    .fluidInputs(fluid('antiknock') * 50)
    .fluidOutputs(fluid('midgrade_gasoline') * 1000)
    .duration(10)
    .EUt(120)
    .buildAndRegister()

BLENDER.recipeBuilder()
    .fluidInputs(fluid('midgrade_gasoline') * 1000)
    .fluidInputs(fluid('methyl_carbitol') * 50)
    .fluidInputs(fluid('corrosion_inhibitor') * 50)
    .fluidOutputs(fluid('premium_gasoline') * 1000)
    .duration(10)
    .EUt(120)
    .buildAndRegister()

BLENDER.recipeBuilder()
    .fluidInputs(fluid('premium_gasoline') * 1000)
    .fluidInputs(fluid('antioxidants') * 50)
    .fluidInputs(fluid('metal_deactivator') * 50)
    .fluidOutputs(fluid('supreme_gasoline') * 1000)
    .duration(10)
    .EUt(120)
    .buildAndRegister()

// Diesel final blending

MIXER.recipeBuilder()
    .fluidInputs(fluid('light_gas_oil') * 1000)
    .fluidOutputs(fluid('diesel') * 1000)
    .circuitMeta(1)
    .duration(2)
    .EUt(120)
    .buildAndRegister()

MIXER.recipeBuilder()
    .fluidInputs(fluid('light_gas_oil') * 700)
    .fluidInputs(fluid('light_cycle_oil') * 300)
    .fluidOutputs(fluid('diesel') * 1000)
    .circuitMeta(2)
    .duration(2)
    .EUt(120)
    .buildAndRegister()

BLENDER.recipeBuilder()
    .fluidInputs(fluid('diesel') * 1000)
    .fluidInputs(fluid('ignition_improver') * 75)
    .fluidInputs(fluid('cold_flow_improver') * 75)
    .fluidOutputs(fluid('midgrade_diesel') * 1000)
    .duration(10)
    .EUt(120)
    .buildAndRegister()

BLENDER.recipeBuilder()
    .fluidInputs(fluid('midgrade_diesel') * 1000)
    .fluidInputs(fluid('antistatic_additive') * 75)
    .fluidInputs(fluid('lubricity_additive') * 75)
    .fluidOutputs(fluid('premium_diesel') * 1000)
    .duration(10)
    .EUt(120)
    .buildAndRegister()

BLENDER.recipeBuilder()
    .fluidInputs(fluid('premium_diesel') * 1000)
    .fluidInputs(fluid('antioxidants') * 75)
    .fluidInputs(fluid('antifoaming_additive') * 75)
    .fluidOutputs(fluid('supreme_diesel') * 1000)
    .duration(10)
    .EUt(120)
    .buildAndRegister()

// Kerosene final blending

BLENDER.recipeBuilder()
    .fluidInputs(fluid('kerosene') * 1000)
    .fluidInputs(fluid('methyl_carbitol') * 25)
    .fluidInputs(fluid('antistatic_additive') * 25)
    .fluidOutputs(fluid('midgrade_kerosene') * 1000)
    .duration(10)
    .EUt(120)
    .buildAndRegister()

BLENDER.recipeBuilder()
    .fluidInputs(fluid('midgrade_kerosene') * 1000)
    .fluidInputs(fluid('lubricity_additive') * 25)
    .fluidInputs(fluid('antioxidants') * 25)
    .fluidOutputs(fluid('premium_kerosene') * 1000)
    .duration(10)
    .EUt(120)
    .buildAndRegister()

BLENDER.recipeBuilder()
    .fluidInputs(fluid('premium_kerosene') * 1000)
    .fluidInputs(fluid('corrosion_inhibitor') * 25)
    .fluidInputs(fluid('metal_deactivator') * 25)
    .fluidOutputs(fluid('supreme_kerosene') * 1000)
    .duration(10)
    .EUt(120)
    .buildAndRegister()

// RP-1

FBR.recipeBuilder()
    .fluidInputs(fluid('supreme_kerosene') * 1000)
    .fluidInputs(fluid('hydrogen') * 1000)
    .notConsumable(metaitem('catalystBedHydrotreatingCatalyst'))
    .fluidOutputs(fluid('rp_one') * 1000)
    .duration(100)
    .EUt(480)
    .buildAndRegister()

// Diesel * 6000
mods.gregtech.mixer.removeByInput(120, null, [fluid('light_fuel') * 5000 * 5000, fluid('heavy_fuel') * 1000 * 1000])

def residueFeedstocks = [
    'atmospheric_oil_residue',
    'vacuum_oil_residue',
    'visbreaking_residue',
    'deasphalted_oil',
    'clarified_slurry_oil'
]

// Fuel Oil (marine and bunker fuels)

MIXER.recipeBuilder()
    .fluidInputs(fluid('heavy_gas_oil') * 1000)
    .fluidOutputs(fluid('fuel_oil') * 1000)
    .circuitMeta(1)
    .duration(2)
    .EUt(120)
    .buildAndRegister()

for (residue in residueFeedstocks) {
    MIXER.recipeBuilder()
        .fluidInputs(fluid('heavy_gas_oil') * 500)
        .fluidInputs(fluid(residue) * 500)
        .fluidOutputs(fluid('fuel_oil') * 1000)
        .circuitMeta(2)
        .duration(2)
        .EUt(120)
        .buildAndRegister()
}