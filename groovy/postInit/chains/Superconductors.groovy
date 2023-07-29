import static globals.Globals.*
import classes.*;

def recipesToRemove = [
        'gregtech:manganese_phosphide_wire_single',
        'gregtech:uranium_triplatinum_wire_single',
        'gregtech:indium_tin_barium_titanium_cuprate_wire_single',
        'gregtech:uranium_rhodium_dinaquadide_wire_single',
        'gregtech:enriched_naquadah_trinium_europium_duranide_wire_single',
        'gregtech:ruthenium_trinium_americium_neutronate_wire_single'
]

for(name in recipesToRemove) {
    crafting.remove(name)
}

// Mercury Barium Calcium Cuprate Dust * 16
mods.gregtech.mixer.removeByInput(120, [metaitem('dustBarium') * 2, metaitem('dustCalcium') * 2, metaitem('dustCopper') * 3, metaitem('circuit.integrated').withNbt(["Configuration": 4])], [fluid('mercury') * 1000, fluid('oxygen') * 8000])
// Samarium Iron Arsenic Oxide Dust * 4
mods.gregtech.mixer.removeByInput(7680, [metaitem('dustSamarium'), metaitem('dustIron'), metaitem('dustArsenic'), metaitem('circuit.integrated').withNbt(["Configuration": 4])], [fluid('oxygen') * 1000])
// Yttrium Barium Cuprate Dust * 13
mods.gregtech.mixer.removeByInput(1920, [metaitem('dustYttrium'), metaitem('dustBarium') * 2, metaitem('dustCopper') * 3, metaitem('circuit.integrated').withNbt(["Configuration": 2])], [fluid('oxygen') * 7000])
// Indium Tin Barium Titanium Cuprate Dust * 16
mods.gregtech.mixer.removeByInput(30720, [metaitem('dustIndium') * 4, metaitem('dustTin') * 2, metaitem('dustBarium') * 2, metaitem('dustTitanium'), metaitem('dustCopper') * 7, metaitem('circuit.integrated').withNbt(["Configuration": 4])], [fluid('oxygen') * 14000])

// Hot Mercury Barium Calcium Cuprate Ingot * 1
mods.gregtech.electric_blast_furnace.removeByInput(480, [metaitem('dustMercuryBariumCalciumCuprate'), metaitem('circuit.integrated').withNbt(["Configuration": 2])], [fluid('nitrogen') * 1000])
// Hot Mercury Barium Calcium Cuprate Ingot * 1
mods.gregtech.electric_blast_furnace.removeByInput(480, [metaitem('dustMercuryBariumCalciumCuprate'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)
// Hot Samarium Iron Arsenic Oxide Ingot * 1
mods.gregtech.electric_blast_furnace.removeByInput(1920, [metaitem('dustSamariumIronArsenicOxide'), metaitem('circuit.integrated').withNbt(["Configuration": 2])], [fluid('helium') * 100])
// Hot Samarium Iron Arsenic Oxide Ingot * 1
mods.gregtech.electric_blast_furnace.removeByInput(1920, [metaitem('dustSamariumIronArsenicOxide'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)
// Hot Magnesium Diboride Ingot * 1
mods.gregtech.electric_blast_furnace.removeByInput(480, [metaitem('dustMagnesiumDiboride'), metaitem('circuit.integrated').withNbt(["Configuration": 2])], [fluid('nitrogen') * 1000])
// Hot Magnesium Diboride Ingot * 1
mods.gregtech.electric_blast_furnace.removeByInput(480, [metaitem('dustMagnesiumDiboride'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)

def TUBE_FURNACE = recipemap('tube_furnace')
def EBF = recipemap('electric_blast_furnace')
def EXTRUDER = recipemap('extruder')
def CHEMICAL_BATH = recipemap('chemical_bath')
def CANNER = recipemap('canner')
def ASSEMBLER = recipemap('assembler')
VACUUM_FREEZER = recipemap('vacuum_freezer')
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
MIXER = recipemap('mixer')
DRYER = recipemap('dryer')
SIFTER = recipemap('sifter')
CENTRIFUGE = recipemap('centrifuge')
PYROLYSE = recipemap('pyrolyse_oven')
LCR = recipemap('large_chemical_reactor')
EBF = recipemap('electric_blast_furnace')
VULCANIZER = recipemap('vulcanizing_press')
ALLOY_SMELTER = recipemap('alloy_smelter')
ARC_FURNACE = recipemap('arc_furnace')
AUTOCLAVE = recipemap('autoclave')
COMPRESSOR = recipemap('compressor')
ELECTROLYZER = recipemap('electrolyzer')
ELECTROLYTIC_CELL = recipemap('electrolytic_cell')
REACTION_FURNACE = recipemap('reaction_furnace')
ELECTROMAGNETIC_SEPARATOR = recipemap('electromagnetic_separator')
PSA = recipemap('pressure_swing_adsorption')

def allSuperconductors = ["ManganesePhosphide", "MagnesiumDiboride", "MercuryBariumCalciumCuprate", "UraniumTriplatinum", "SamariumIronArsenicOxide", "IndiumTinBariumTitaniumCuprate", "UraniumRhodiumDinaquadide", "EnrichedNaquadahTriniumEuropiumDuranide", "RutheniumTriniumAmericiumNeutronate"]
def lowTempSuperconductors = ["ManganesePhosphide", "UraniumTriplatinum", "IndiumTinBariumTitaniumCuprate", "UraniumRhodiumDinaquadide", "EnrichedNaquadahTriniumEuropiumDuranide", "RutheniumTriniumAmericiumNeutronate"]
def highTempSuperconductors = ["MagnesiumDiboride", "MercuryBariumCalciumCuprate", "SamariumIronArsenicOxide"]

def allSuperconductorsLowerCase = ["manganesephosphide", "magnesiumdiboride", "mercurybariumcalciumcuprate", "uraniumtriplatinum", "samariumironarsenicoxide", "indiumtinbariumtitaniumcuprate", "uraniumrhodiumdinaquadide", "enrichednaquadahtriniumeuropiumduranide", "rutheniumtriniumamericiumneutronate"]
def lowTempSuperconductorsLowerCase = ["manganesephosphide", "uraniumtriplatinum", "indiumtinbariumtitaniumcuprate", "uraniumrhodiumdinaquadide", "enrichednaquadahtriniumeuropiumduranide", "rutheniumtriniumamericiumneutronate"]
def highTempSuperconductorsLowerCase = ["magnesiumdiboride", "mercurybariumcalciumcuprate", "samariumironarsenicoxide"]

def criticalTemperatures = [100, 80, 50, 5, 5, 5, 5, 5, 5]

for (i = 0; i < 6; i++) {
    //REMOVE AUTOGENERATED GT RECIPES FOR SUPERCONDUCTORS
    mods.gregtech.wiremill.removeByInput(7, [metaitem('wireGtSingle' + lowTempSuperconductors[i]), metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)

    ASSEMBLER.recipeBuilder()
            .inputs(metaitem('wireGtSingleCopper'))
            .inputs(metaitem('wireFine' + lowTempSuperconductors[i]) * 8)
            .inputs(metaitem('foilCopper'))
            .outputs(metaitem('assembly' + lowTempSuperconductorsLowerCase[i]))
            .duration(200)
            .EUt(30)
            .buildAndRegister();

    EXTRUDER.recipeBuilder()
            .inputs(metaitem('assembly' + lowTempSuperconductorsLowerCase[i]))
            .notConsumable(metaitem('shape.extruder.wire'))
            .outputs(metaitem('base' + lowTempSuperconductorsLowerCase[i]) * 4)
            .duration(200)
            .EUt(30)
            .buildAndRegister();
}

TUBE_FURNACE.recipeBuilder()
        .inputs(metaitem('cannedmagnesiumdiboride'))
        .fluidInputs(fluid('nitrogen') * 500)
        .outputs(metaitem('tubemagnesiumdiboride'))
        .duration(1006)
        .EUt(120)
        .buildAndRegister();

TUBE_FURNACE.recipeBuilder()
        .inputs(metaitem('cannedmagnesiumdiboride'))
        .fluidInputs(fluid('argon') * 50)
        .outputs(metaitem('tubemagnesiumdiboride'))
        .duration(670)
        .EUt(120)
        .buildAndRegister();

TUBE_FURNACE.recipeBuilder()
        .inputs(metaitem('cannedmercurybariumcalciumcuprate'))
        .fluidInputs(fluid('nitrogen') * 500)
        .outputs(metaitem('tubemercurybariumcalciumcuprate'))
        .duration(1500)
        .EUt(480)
        .buildAndRegister();

TUBE_FURNACE.recipeBuilder()
        .inputs(metaitem('cannedmercurybariumcalciumcuprate'))
        .fluidInputs(fluid('argon') * 50)
        .outputs(metaitem('tubemercurybariumcalciumcuprate'))
        .duration(1005)
        .EUt(480)
        .buildAndRegister();

TUBE_FURNACE.recipeBuilder()
        .inputs(metaitem('cannedsamariumironarsenicoxide'))
        .fluidInputs(fluid('argon') * 50)
        .outputs(metaitem('tubesamariumironarsenicoxide'))
        .duration(1005)
        .EUt(3840)
        .buildAndRegister();

for (i = 0; i < 3; i++) {
    CANNER.recipeBuilder()
            .inputs(metaitem('pipeTinyFluidSilver'))
            .inputs(metaitem('dust' + highTempSuperconductors[i]))
            .outputs(metaitem('canned' + highTempSuperconductorsLowerCase[i]))
            .duration(200)
            .EUt(30)
            .buildAndRegister();

    EXTRUDER.recipeBuilder()
            .inputs(metaitem('tube' + highTempSuperconductorsLowerCase[i]))
            .notConsumable(metaitem('shape.extruder.wire'))
            .outputs(metaitem('base' + highTempSuperconductorsLowerCase[i]) * 4)
            .duration(200)
            .EUt(30)
            .buildAndRegister();
}

for (def i = 0; i < 9; i++) {
    //REMOVE AUTOGENERATED GT RECIPES FOR SUPERCONDUCTORS
    if (i < 2) {
        mods.gregtech.extruder.removeByInput(42, [metaitem('ingot' + allSuperconductors[i]), metaitem('shape.extruder.wire')], null)
        mods.gregtech.wiremill.removeByInput(7, [metaitem('ingot' + allSuperconductors[i]), metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)
        mods.gregtech.wiremill.removeByInput(7, [metaitem('ingot' + allSuperconductors[i]), metaitem('circuit.integrated').withNbt(["Configuration": 2])], null)
        mods.gregtech.wiremill.removeByInput(7, [metaitem('ingot' + allSuperconductors[i]) * 2, metaitem('circuit.integrated').withNbt(["Configuration": 4])], null)
        mods.gregtech.wiremill.removeByInput(7, [metaitem('ingot' + allSuperconductors[i]) * 4, metaitem('circuit.integrated').withNbt(["Configuration": 8])], null)
        mods.gregtech.wiremill.removeByInput(7, [metaitem('ingot' + allSuperconductors[i]) * 8, metaitem('circuit.integrated').withNbt(["Configuration": 16])], null)
    } else {
        mods.gregtech.extruder.removeByInput(180, [metaitem('ingot' + allSuperconductors[i]), metaitem('shape.extruder.wire')], null)
        mods.gregtech.wiremill.removeByInput(30, [metaitem('ingot' + allSuperconductors[i]), metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)
        mods.gregtech.wiremill.removeByInput(30, [metaitem('ingot' + allSuperconductors[i]), metaitem('circuit.integrated').withNbt(["Configuration": 2])], null)
        mods.gregtech.wiremill.removeByInput(30, [metaitem('ingot' + allSuperconductors[i]) * 2, metaitem('circuit.integrated').withNbt(["Configuration": 4])], null)
        mods.gregtech.wiremill.removeByInput(30, [metaitem('ingot' + allSuperconductors[i]) * 4, metaitem('circuit.integrated').withNbt(["Configuration": 8])], null)
        mods.gregtech.wiremill.removeByInput(30, [metaitem('ingot' + allSuperconductors[i]) * 8, metaitem('circuit.integrated').withNbt(["Configuration": 16])], null)
    }

        def cryoLiquids = [
                'liquid_hydrogen': 14,
                'liquid_oxygen': 90,
                'liquid_helium': 4,
                'liquid_neon': 27,
                'liquid_argon': 87,
                'liquid_krypton': 120,
                'liquid_xenon': 165,
                'liquid_nitrogen': 77,
                'liquid_refinery_gas': 80,
                'liquid_natural_gas': 80
        ];

        cryoLiquids.each { key, val ->
                if (criticalTemperatures[i] > val) {
                CHEMICAL_BATH.recipeBuilder()
                        .inputs(metaitem('base' + allSuperconductorsLowerCase[i]))
                        .fluidInputs(liquid(key) * 2)
                        .outputs(metaitem('wireGtSingle' + allSuperconductors[i]))
                        .duration(50)
                        .EUt(Globals.voltAmps[i + 1])
                        .buildAndRegister();
                }
        }
}

ROASTER.recipeBuilder()
        .inputs(metaitem('dustBarium') * 1)
        .fluidInputs(liquid('oxygen') * 1000)
        .outputs(metaitem('dustBariumOxide') * 2)
        .duration(200)
        .EUt(120)
        .buildAndRegister();

ROASTER.recipeBuilder()
        .fluidInputs(liquid('mercury') * 1000)
        .fluidInputs(liquid('oxygen') * 1000)
        .outputs(metaitem('dustMercuryOxide') * 2)
        .duration(200)
        .EUt(120)
        .buildAndRegister();

MIXER.recipeBuilder()
        .inputs(metaitem('dustMercuryOxide') * 2)
        .inputs(metaitem('dustQuicklime') * 4)
        .inputs(metaitem('dustBariumOxide') * 4)
        .inputs(metaitem('dustCopperIiOxide') * 6)
        .outputs(metaitem('dustMercuryBariumCalciumCuprate') * 16)
        .duration(300)
        .EUt(240)
        .buildAndRegister();

TUBE_FURNACE.recipeBuilder()
        .inputs(metaitem('dustSamarium'))
        .inputs(metaitem('dustArsenic'))
        .inputs(metaitem('dustIron'))
        .fluidInputs(fluid('oxygen') * 1000)
        .outputs(metaitem('dustSamariumIronArsenicOxide') * 4)
        .duration(600)
        .EUt(1920)
        .buildAndRegister();

MIXER.recipeBuilder()
        .inputs(metaitem('dustYttriumOxide') * 5)
        .inputs(metaitem('dustBariumOxide') * 8)
        .inputs(metaitem('dustCopperIiOxide') * 12)
        .outputs(metaitem('dustYttriumBariumCuprate') * 25)
        .duration(600)
        .EUt(7680)
        .buildAndRegister();

ROASTER.recipeBuilder()
        .inputs(metaitem('dustIndium') * 1)
        .fluidInputs(liquid('chlorine') * 3000)
        .outputs(metaitem('dustIndiumChloride') * 4)
        .duration(200)
        .EUt(120)
        .buildAndRegister();

BR.recipeBuilder()
        .inputs(metaitem('dustIndiumChloride') * 4)
        .fluidInputs(liquid('sodium_hydroxide_solution') * 3000)
        .outputs(metaitem('dustIndiumHydroxide') * 7)
        .fluidOutputs(liquid('salt_water') * 3000)
        .duration(200)
        .EUt(120)
        .buildAndRegister();

ROASTER.recipeBuilder()
        .inputs(metaitem('dustIndiumHydroxide') * 14)
        .outputs(metaitem('dustIndiumOxide') * 5)
        .fluidOutputs(liquid('steam') * 3000)
        .duration(200)
        .EUt(120)
        .buildAndRegister();

MIXER.recipeBuilder()
        .inputs(metaitem('dustIndiumOxide') * 10)
        .inputs(metaitem('dustPurifiedTinIiOxide') * 4)
        .inputs(metaitem('dustBariumOxide') * 4)
        .inputs(metaitem('dustTitaniumDioxide') * 2)
        .inputs(metaitem('dustCopperIiOxide') * 14)
        .outputs(metaitem('dustIndiumTinBariumTitaniumCuprate') * 16)
        .duration(600)
        .EUt(30720)
        .buildAndRegister();