import globals.Globals
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
mods.gregtech.blender.removeByInput(120, [metaitem('dustBarium') * 2, metaitem('dustCalcium') * 2, metaitem('dustCopper') * 3, metaitem('circuit.integrated').withNbt(["Configuration": 4])], [fluid('mercury') * 1000, fluid('oxygen') * 8000])
// Samarium Iron Arsenic Oxide Dust * 4
mods.gregtech.mixer.removeByInput(7680, [metaitem('dustSamarium'), metaitem('dustIron'), metaitem('dustArsenic'), metaitem('circuit.integrated').withNbt(["Configuration": 4])], [fluid('oxygen') * 1000])
mods.gregtech.blender.removeByInput(7680, [metaitem('dustSamarium'), metaitem('dustIron'), metaitem('dustArsenic'), metaitem('circuit.integrated').withNbt(["Configuration": 4])], [fluid('oxygen') * 1000])
// Yttrium Barium Cuprate Dust * 13
mods.gregtech.mixer.removeByInput(1920, [metaitem('dustYttrium'), metaitem('dustBarium') * 2, metaitem('dustCopper') * 3, metaitem('circuit.integrated').withNbt(["Configuration": 2])], [fluid('oxygen') * 7000])
mods.gregtech.blender.removeByInput(1920, [metaitem('dustYttrium'), metaitem('dustBarium') * 2, metaitem('dustCopper') * 3, metaitem('circuit.integrated').withNbt(["Configuration": 2])], [fluid('oxygen') * 7000])
// Indium Tin Barium Titanium Cuprate Dust * 16
mods.gregtech.mixer.removeByInput(30720, [metaitem('dustIndium') * 4, metaitem('dustTin') * 2, metaitem('dustBarium') * 2, metaitem('dustTitanium'), metaitem('dustCopper') * 7, metaitem('circuit.integrated').withNbt(["Configuration": 4])], [fluid('oxygen') * 14000])
mods.gregtech.blender.removeByInput(30720, [metaitem('dustIndium') * 4, metaitem('dustTin') * 2, metaitem('dustBarium') * 2, metaitem('dustTitanium'), metaitem('dustCopper') * 7, metaitem('circuit.integrated').withNbt(["Configuration": 4])], [fluid('oxygen') * 14000])

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
            .inputs(ore('wireGtSingleCopper'))
            .inputs(ore('wireFine' + lowTempSuperconductors[i]) * 8)
            .inputs(ore('foilCopper'))
            .outputs(metaitem('assembly' + lowTempSuperconductorsLowerCase[i]))
            .duration(200)
            .EUt(30)
            .buildAndRegister();

    EXTRUDER.recipeBuilder()
            .inputs(metaitem('assembly' + lowTempSuperconductorsLowerCase[i]))
            .notConsumable(metaitem('shape.extruder.wire'))
            .outputs(metaitem('base' + lowTempSuperconductorsLowerCase[i]) * 16)
            .duration(200)
            .EUt(30)
            .buildAndRegister();
}

// Remove wire recycling recipes
//Manganese Phosphide has to be handled separately due to having different voltages

mods.gregtech.macerator.removeByInput(8, [metaitem('wireGtSingleManganesePhosphide')], null)
mods.gregtech.macerator.removeByInput(8, [metaitem('wireGtDoubleManganesePhosphide')], null)
mods.gregtech.macerator.removeByInput(8, [metaitem('wireGtQuadrupleManganesePhosphide')], null)
mods.gregtech.macerator.removeByInput(8, [metaitem('wireGtOctalManganesePhosphide')], null)
mods.gregtech.macerator.removeByInput(8, [metaitem('wireGtHexManganesePhosphide')], null)

mods.gregtech.extractor.removeByInput(120, [metaitem('wireGtSingleManganesePhosphide')], null)
mods.gregtech.extractor.removeByInput(120, [metaitem('wireGtDoubleManganesePhosphide')], null)
mods.gregtech.extractor.removeByInput(120, [metaitem('wireGtQuadrupleManganesePhosphide')], null)
mods.gregtech.extractor.removeByInput(120, [metaitem('wireGtOctalManganesePhosphide')], null)
mods.gregtech.extractor.removeByInput(120, [metaitem('wireGtHexManganesePhosphide')], null)

//All the arc furnace ones need to be done by hand

// Manganese Phosphide Nugget * 4
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtSingleManganesePhosphide')], [fluid('oxygen') * 18])
// Magnesium Diboride Nugget * 4
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtSingleMagnesiumDiboride')], [fluid('oxygen') * 6])
// Mercury Barium Calcium Cuprate Nugget * 4
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtSingleMercuryBariumCalciumCuprate')], [fluid('oxygen') * 24])
// Uranium Triplatinum Nugget * 4
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtSingleUraniumTriplatinum')], [fluid('oxygen') * 91])
// Samarium Iron Arsenic Oxide Nugget * 4
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtSingleSamariumIronArsenicOxide')], [fluid('oxygen') * 32])
// Indium Tin Barium Titanium Cuprate Nugget * 4
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtSingleIndiumTinBariumTitaniumCuprate')], [fluid('oxygen') * 24])
// Uranium Rhodium Dinaquadide Nugget * 4
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtSingleUraniumRhodiumDinaquadide')], [fluid('oxygen') * 154])
// Enriched Naquadah Trinium Europium Duranide Nugget * 4
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtSingleEnrichedNaquadahTriniumEuropiumDuranide')], [fluid('oxygen') * 163])
// Ruthenium Trinium Americium Neutronate Nugget * 4
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtSingleRutheniumTriniumAmericiumNeutronate')], [fluid('oxygen') * 98])

// Manganese Phosphide Ingot * 1
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtDoubleManganesePhosphide')], [fluid('oxygen') * 42])
// Magnesium Diboride Ingot * 1
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtDoubleMagnesiumDiboride')], [fluid('oxygen') * 14])
// Mercury Barium Calcium Cuprate Ingot * 1
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtDoubleMercuryBariumCalciumCuprate')], [fluid('oxygen') * 54])
// Uranium Triplatinum Ingot * 1
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtDoubleUraniumTriplatinum')], [fluid('oxygen') * 205])
// Samarium Iron Arsenic Oxide Ingot * 1
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtDoubleSamariumIronArsenicOxide')], [fluid('oxygen') * 74])
// Indium Tin Barium Titanium Cuprate Ingot * 1
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtDoubleIndiumTinBariumTitaniumCuprate')], [fluid('oxygen') * 55])
// Uranium Rhodium Dinaquadide Ingot * 1
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtDoubleUraniumRhodiumDinaquadide')], [fluid('oxygen') * 348])
// Enriched Naquadah Trinium Europium Duranide Ingot * 1
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtDoubleEnrichedNaquadahTriniumEuropiumDuranide')], [fluid('oxygen') * 368])
// Ruthenium Trinium Americium Neutronate Ingot * 1
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtDoubleRutheniumTriniumAmericiumNeutronate')], [fluid('oxygen') * 222])

// Manganese Phosphide Ingot * 2
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtQuadrupleManganesePhosphide')], [fluid('oxygen') * 84])
// Magnesium Diboride Ingot * 2
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtQuadrupleMagnesiumDiboride')], [fluid('oxygen') * 28])
// Mercury Barium Calcium Cuprate Ingot * 2
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtQuadrupleMercuryBariumCalciumCuprate')], [fluid('oxygen') * 108])
// Uranium Triplatinum Ingot * 2
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtQuadrupleUraniumTriplatinum')], [fluid('oxygen') * 410])
// Samarium Iron Arsenic Oxide Ingot * 2
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtQuadrupleSamariumIronArsenicOxide')], [fluid('oxygen') * 148])
// Indium Tin Barium Titanium Cuprate Ingot * 2
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtQuadrupleIndiumTinBariumTitaniumCuprate')], [fluid('oxygen') * 110])
// Uranium Rhodium Dinaquadide Ingot * 2
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtQuadrupleUraniumRhodiumDinaquadide')], [fluid('oxygen') * 696])
// Enriched Naquadah Trinium Europium Duranide Ingot * 2
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtQuadrupleEnrichedNaquadahTriniumEuropiumDuranide')], [fluid('oxygen') * 736])
// Ruthenium Trinium Americium Neutronate Ingot * 2
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtQuadrupleRutheniumTriniumAmericiumNeutronate')], [fluid('oxygen') * 444])

// Manganese Phosphide Ingot * 4
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtOctalManganesePhosphide')], [fluid('oxygen') * 168])
// Magnesium Diboride Ingot * 4
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtOctalMagnesiumDiboride')], [fluid('oxygen') * 56])
// Mercury Barium Calcium Cuprate Ingot * 4
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtOctalMercuryBariumCalciumCuprate')], [fluid('oxygen') * 216])
// Uranium Triplatinum Ingot * 4
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtOctalUraniumTriplatinum')], [fluid('oxygen') * 820])
// Samarium Iron Arsenic Oxide Ingot * 4
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtOctalSamariumIronArsenicOxide')], [fluid('oxygen') * 296])
// Indium Tin Barium Titanium Cuprate Ingot * 4
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtOctalIndiumTinBariumTitaniumCuprate')], [fluid('oxygen') * 220])
// Uranium Rhodium Dinaquadide Ingot * 4
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtOctalUraniumRhodiumDinaquadide')], [fluid('oxygen') * 1392])
// Enriched Naquadah Trinium Europium Duranide Ingot * 4
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtOctalEnrichedNaquadahTriniumEuropiumDuranide')], [fluid('oxygen') * 1472])
// Ruthenium Trinium Americium Neutronate Ingot * 4
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtOctalRutheniumTriniumAmericiumNeutronate')], [fluid('oxygen') * 888])

// Manganese Phosphide Ingot * 8
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtHexManganesePhosphide')], [fluid('oxygen') * 336])
// Magnesium Diboride Ingot * 8
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtHexMagnesiumDiboride')], [fluid('oxygen') * 112])
// Mercury Barium Calcium Cuprate Ingot * 8
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtHexMercuryBariumCalciumCuprate')], [fluid('oxygen') * 432])
// Uranium Triplatinum Ingot * 8
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtHexUraniumTriplatinum')], [fluid('oxygen') * 1640])
// Samarium Iron Arsenic Oxide Ingot * 8
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtHexSamariumIronArsenicOxide')], [fluid('oxygen') * 592])
// Indium Tin Barium Titanium Cuprate Ingot * 8
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtHexIndiumTinBariumTitaniumCuprate')], [fluid('oxygen') * 440])
// Uranium Rhodium Dinaquadide Ingot * 8
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtHexUraniumRhodiumDinaquadide')], [fluid('oxygen') * 2784])
// Enriched Naquadah Trinium Europium Duranide Ingot * 8
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtHexEnrichedNaquadahTriniumEuropiumDuranide')], [fluid('oxygen') * 2944])
// Ruthenium Trinium Americium Neutronate Ingot * 8
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('wireGtHexRutheniumTriniumAmericiumNeutronate')], [fluid('oxygen') * 1776])


for (supercon in allSuperconductors) {

        if (supercon == "ManganesePhosphide") {
                continue
        }

        // Supercon maceration
        mods.gregtech.macerator.removeByInput(32, [metaitem('wireGtSingle' + supercon)], null)
        mods.gregtech.macerator.removeByInput(32, [metaitem('wireGtDouble' + supercon)], null)
        mods.gregtech.macerator.removeByInput(32, [metaitem('wireGtQuadruple' + supercon)], null)
        mods.gregtech.macerator.removeByInput(32, [metaitem('wireGtOctal' + supercon)], null)
        mods.gregtech.macerator.removeByInput(32, [metaitem('wireGtHex' + supercon)], null)
        // Supercon extraction
        mods.gregtech.extractor.removeByInput(480, [metaitem('wireGtSingle' + supercon)], null)
        mods.gregtech.extractor.removeByInput(480, [metaitem('wireGtDouble' + supercon)], null)
        mods.gregtech.extractor.removeByInput(480, [metaitem('wireGtQuadruple' + supercon)], null)
        mods.gregtech.extractor.removeByInput(480, [metaitem('wireGtOctal' + supercon)], null)
        mods.gregtech.extractor.removeByInput(480, [metaitem('wireGtHex' + supercon)], null)


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
            .inputs(ore('pipeTinyFluidSilver'))
            .inputs(ore('dust' + highTempSuperconductors[i]))
            .outputs(metaitem('canned' + highTempSuperconductorsLowerCase[i]))
            .duration(200)
            .EUt(30)
            .buildAndRegister();

    EXTRUDER.recipeBuilder()
            .inputs(metaitem('tube' + highTempSuperconductorsLowerCase[i]))
            .notConsumable(metaitem('shape.extruder.wire'))
            .outputs(metaitem('base' + highTempSuperconductorsLowerCase[i]) * 16)
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
                'liquid_natural_gas': 80
        ];

        cryoLiquids.each { key, val ->
                if (criticalTemperatures[i] > val) {
                CHEMICAL_BATH.recipeBuilder()
                        .inputs(metaitem('base' + allSuperconductorsLowerCase[i]))
                        .fluidInputs(liquid(key) * 1)
                        .outputs(metaitem('wireGtSingle' + allSuperconductors[i]))
                        .duration(50)
                        .EUt(Globals.voltAmps[i + 1])
                        .buildAndRegister();
                }
        }
}

ROASTER.recipeBuilder()
        .inputs(ore('dustAnyPurityBarium') * 1)
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
        .inputs(ore('dustMercuryOxide') * 2)
        .inputs(ore('dustQuicklime') * 4)
        .inputs(ore('dustBariumOxide') * 4)
        .inputs(ore('dustCupricOxide') * 6)
        .outputs(metaitem('dustMercuryBariumCalciumCuprate') * 16)
        .duration(300)
        .EUt(240)
        .buildAndRegister();

TUBE_FURNACE.recipeBuilder()
        .inputs(ore('dustAnyPuritySamarium'))
        .inputs(ore('dustAnyPurityArsenic'))
        .inputs(ore('dustAnyPurityIron'))
        .fluidInputs(fluid('oxygen') * 1000)
        .outputs(metaitem('dustSamariumIronArsenicOxide') * 4)
        .duration(600)
        .EUt(1920)
        .buildAndRegister();


TUBE_FURNACE.recipeBuilder()
        .inputs(ore('dustAnyPurityManganese'))
        .inputs(ore('dustAnyPurityPhosphorus'))
        .fluidInputs(fluid('nitrogen') * 1000)
        .outputs(metaitem('dustManganesePhosphide') * 4)
        .duration(200)
        .EUt(30)
        .buildAndRegister();

MIXER.recipeBuilder()
        .inputs(ore('dustYttriumOxide') * 5)
        .inputs(ore('dustBariumOxide') * 8)
        .inputs(ore('dustCupricOxide') * 12)
        .outputs(metaitem('dustYttriumBariumCuprate') * 25)
        .duration(600)
        .EUt(7680)
        .buildAndRegister();

ROASTER.recipeBuilder()
        .inputs(ore('dustAnyPurityIndium') * 1)
        .fluidInputs(liquid('chlorine') * 3000)
        .outputs(metaitem('dustIndiumChloride') * 4)
        .duration(200)
        .EUt(120)
        .buildAndRegister();

BR.recipeBuilder()
        .inputs(ore('dustIndiumChloride') * 4)
        .fluidInputs(liquid('sodium_hydroxide_solution') * 3000)
        .outputs(metaitem('dustIndiumHydroxide') * 7)
        .fluidOutputs(liquid('salt_water') * 3000)
        .duration(200)
        .EUt(120)
        .buildAndRegister();

ROASTER.recipeBuilder()
        .inputs(ore('dustIndiumHydroxide') * 14)
        .outputs(metaitem('dustIndiumOxide') * 5)
        .fluidOutputs(liquid('dense_steam') * 3000)
        .duration(200)
        .EUt(120)
        .buildAndRegister();

MIXER.recipeBuilder()
        .inputs(ore('dustIndiumOxide') * 10)
        .inputs(ore('dustPurifiedTinIiOxide') * 4)
        .inputs(ore('dustBariumOxide') * 4)
        .inputs(ore('dustTitaniumDioxide') * 2)
        .inputs(ore('dustCupricOxide') * 14)
        .outputs(metaitem('dustIndiumTinBariumTitaniumCuprate') * 16)
        .duration(600)
        .EUt(30720)
        .buildAndRegister();