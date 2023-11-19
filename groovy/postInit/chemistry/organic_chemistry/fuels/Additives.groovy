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
]

for (major_solvent in major_solvents) {
    for (minor_solvent in minor_solvents) {
        MIXER.recipeBuilder()
            .inputs(metaitem('dustSodiumDodecylSulfate'))
            .fluidInputs(fluid('two_butoxyethanol') * 100)
            .fluidInputs(fluid(major_solvent) * 1500)
            .fluidInputs(fluid(minor_solvent) * 400)
            .fluidOutputs(fluid('lubricity_additive') * 2000)
            .duration(100)
            .EUt(Globals.voltAmps[1])
            .buildAndRegister()
    
        MIXER.recipeBuilder()
            .inputs(ore('dustSmallDinonylnaphthaleneSulfonicAcid'))
            .fluidInputs(fluid(major_solvent) * 1500)
            .fluidInputs(fluid(minor_solvent) * 500)
            .fluidOutputs(fluid('antistatic_additive') * 2000)
            .duration(100)
            .EUt(Globals.voltAmps[1])
            .buildAndRegister()

        MIXER.recipeBuilder()
            .fluidInputs(fluid('polydimethylsiloxane') * 100)
            .fluidInputs(fluid(major_solvent) * 1500)
            .fluidInputs(fluid(minor_solvent) * 400)
            .fluidOutputs(fluid('lubricity_additive') * 2000)
            .fluidOutputs(fluid('antifoaming_additive') * 2000)
    }
}


