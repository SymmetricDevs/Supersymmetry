import globals.Globals

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
ASSEMBLER = recipemap('assembler')
ELECTROLYZER = recipemap('electrolyzer')
ELECTROLYTIC_CELL = recipemap('electrolytic_cell')
REACTION_FURNACE = recipemap('reaction_furnace')
ELECTROMAGNETIC_SEPARATOR = recipemap('electromagnetic_separator')
PSA = recipemap('pressure_swing_adsorption')

def name_removals = [
    "gaspunk:diffuser",
    "gaspunk:grenade",
    "gaspunk:vapor_grenade",
    "gaspunk:grenade_refill",
    "gaspunk:grenade_recycling",
    "gaspunk:inhaler",
    "gp_inhaler:empty_inhaler",
    "gp_inhaler:vapor_inhaler",
    "gp_inhaler:inhaler",
    "gaspunk:vapor_inhaler",
    "gaspunk:gas_mask"
]

for (item in name_removals) {
    crafting.remove(item);
}

def rubber_rings = [
    'ringRubber',
    'ringSiliconeRubber',
    'ringStyreneButadieneRubber',
]

Globals.solders.each { key, val ->
    for (rubber_ring in rubber_rings) {
        recipemap('weapons_factory').recipeBuilder()
            .inputs([
                ore(rubber_ring)*4,
                ore('platePlastic'),
                ore('plateSteel')
            ])
            .fluidInputs(fluid(key) * val)
            .outputs(item('gaspunk:diffuser'))
            .duration(200)
            .EUt(60)
            .buildAndRegister();

        recipemap('weapons_factory').recipeBuilder()
            .inputs([
                ore(rubber_ring)*4,
                metaitem('component.glass.tube'),
                ore('plateSteel')
            ])
            .fluidInputs(fluid(key) * val)
            .outputs(item('gp_inhaler:empty_inhaler'))
            .duration(200)
            .EUt(60)
            .buildAndRegister();
    }
}

recipemap('assembler').recipeBuilder()
        .inputs([
                ore('ringRubber') * 2,
                ore('platePlastic') * 2,
                metaitem('wireFineCopper') * 4,
                metaitem('dustCarbon') * 2,
                metaitem('plateGlass')
        ])
        .fluidInputs(fluid('soldering_alloy') * 72)
        .outputs(item('gaspunk:gas_mask'))
        .duration(200)
        .EUt(60)
        .buildAndRegister();

mods.gregtech.mixer.recipeBuilder()
        .inputs(ore('dustPhosphorus') * 4)
        .fluidInputs(liquid('oxygen') * 1000)
        .fluidOutputs(liquid('smoke_bomb_mix') * 1000)
        .duration(200)
        .EUt(60)
        .buildAndRegister();

def GasMapMV = [
    'fluorine': "gaspunk:fluorine",
    'carbon_monoxide': "gaspunk:carbon_monoxide",
    'chlorine': "gaspunk:chlorine",
    'diborane': "gaspunk:diborane",
    'gtfo_hydrogen_cyanide': "gaspunk:hydrogen_cyanide",
    'radon': "gaspunk:radon",
    'phosphine': "gaspunk:phosphine",
    'smoke_bomb_mix': "gaspunk:smoke",
    'chloroform': "gaspunk:chloroform",
    'hydrogen_sulfide': "gaspunk:hydrogen_sulfide",
    'hydrochloric_acid': "gaspunk:hydrochloric_acid",
    'hydrofluoric_acid': "gaspunk:hydrofluoric_acid",
    'sarin': "gaspunk:sarin_gas",
    'vx': "gaspunk:vx",
    'tear_gas': "gaspunk:tear_gas",
    'mustard_gas': "gaspunk:mustard_gas",
    'novichok': "gaspunk:novichok"
]
for (key in GasMapMV) {
    mods.gregtech.canner.recipeBuilder()
            .inputs([item('minecraft:glass_bottle')])
            .fluidInputs(liquid(key.getKey())*100)
            .outputs(item('gaspunk:gas_tube').withNbt(["gaspunk:contained_gas": GasMapMV[key.getKey()]]))
            .duration(20)
            .EUt(60)
            .buildAndRegister();

    mods.gregtech.canner.recipeBuilder()
            .inputs([item('gaspunk:diffuser')])
            .fluidInputs(liquid(key.getKey())*100)
            .outputs(item('gaspunk:grenade').withNbt(["gaspunk:contained_gas": GasMapMV[key.getKey()]]))
            .duration(20)
            .EUt(60)
            .buildAndRegister();

    mods.gregtech.canner.recipeBuilder()
            .inputs(item('gp_inhaler:empty_inhaler'))
            .fluidInputs(liquid(key.getKey())*100)
            .outputs(item('gp_inhaler:inhaler').withNbt(["gaspunk:contained_gas": GasMapMV[key.getKey()]]))
            .duration(20)
            .EUt(60)
            .buildAndRegister();
}

CSTR.recipeBuilder()
        .fluidInputs(fluid('sulfur_dichloride') * 50)
        .fluidInputs(fluid('ethylene') * 100)
        .fluidOutputs(fluid('mustard_gas') * 50)
        .duration(3)
        .EUt(120)
        .buildAndRegister();

FBR.recipeBuilder()
        .notConsumable(metaitem('catalystBedAluminiumChloride'))
        .fluidInputs(fluid('ethylene_oxide') * 50)
        .fluidInputs(fluid('diisopropylamine') * 50)
        .fluidOutputs(fluid('diisopropylaminoethanol') * 50)
        .duration(3)
        .EUt(120)
        .buildAndRegister();

LCR.recipeBuilder()
        .notConsumable(metaitem('dustAluminiumChloride') * 4)
        .inputs(ore('dustIron') * 1)
        .fluidInputs(fluid('phosphorus_trichloride') * 1000)
        .fluidInputs(fluid('chloromethane') * 1000)
        .fluidOutputs(fluid('methyldichlorophosphine') * 1000)
        .outputs(metaitem('dustIronIiChloride') * 3)
        .duration(200)
        .EUt(480)
        .buildAndRegister();

TBR.recipeBuilder()
        .notConsumable(metaitem('dustCarbon'))
        .fluidInputs(fluid('sulfur_dioxide') * 50)
        .fluidInputs(fluid('chlorine') * 100)
        .fluidOutputs(fluid('sulfuryl_chloride') * 50)
        .duration(3)
        .EUt(120)
        .buildAndRegister();

CSTR.recipeBuilder()
        .fluidInputs(fluid('sulfuryl_chloride') * 50)
        .fluidInputs(fluid('methyldichlorophosphine') * 50)
        .fluidOutputs(fluid('thionyl_chloride') * 50)
        .fluidOutputs(fluid('methylphosphonyl_dichloride') * 50)
        .duration(3)
        .EUt(120)
        .buildAndRegister();

CSTR.recipeBuilder()
        .fluidInputs(fluid('methylphosphonyl_dichloride') * 50)
        .fluidInputs(fluid('hydrogen_fluoride') * 50)
        .fluidOutputs(fluid('methylphosphonyl_difluoride') * 50)
        .fluidOutputs(fluid('hydrogen_chloride') * 50)
        .duration(3)
        .EUt(120)
        .buildAndRegister();

CSTR.recipeBuilder()
        .fluidInputs(fluid('methylphosphonyl_difluoride') * 50)
        .fluidInputs(fluid('isopropyl_alcohol') * 50)
        .fluidOutputs(fluid('sarin') * 50)
        .fluidOutputs(fluid('hydrogen_fluoride') * 50)
        .duration(5)
        .EUt(480)
        .buildAndRegister();

CSTR.recipeBuilder()
        .fluidInputs(fluid('methyldichlorophosphine') * 50)
        .fluidInputs(fluid('ethanol') * 100)
        .fluidOutputs(fluid('methyl_diethylphosphinate') * 50)
        .fluidOutputs(fluid('hydrogen_chloride') * 100)
        .duration(3)
        .EUt(120)
        .buildAndRegister();

CSTR.recipeBuilder()
        .fluidInputs(fluid('methyl_diethylphosphinate') * 50)
        .fluidInputs(fluid('diisopropylaminoethanol') * 50)
        .fluidOutputs(fluid('diisopropylamino_ethyl_ethyl_methylphosphonite') * 50)
        .fluidOutputs(fluid('ethanol') * 50)
        .duration(3)
        .EUt(120)
        .buildAndRegister();

ROASTER.recipeBuilder()
        .fluidInputs(fluid('diisopropylamino_ethyl_ethyl_methylphosphonite') * 1000)
        .inputs(ore('dustSulfur'))
        .fluidOutputs(fluid('vx') * 1000)
        .duration(200)
        .EUt(480)
        .buildAndRegister();

CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('ethanol') * 1000)
        .inputs(metaitem('gregtechfoodoption:black_pepper_dust'))
        .fluidOutputs(fluid('capsaicin_solution') * 1000)
        .duration(200)
        .EUt(120)
        .buildAndRegister();

DRYER.recipeBuilder()
        .fluidInputs(fluid('capsaicin_solution') * 1000)
        .outputs(metaitem('dustTinyCapsaicin'))
        .fluidOutputs(fluid('ethanol') * 1000)
        .duration(200)
        .EUt(120)
        .buildAndRegister();

MIXER.recipeBuilder()
        .fluidInputs(fluid('water') * 1000)
        .inputs(ore('dustCapsaicin'))
        .fluidOutputs(fluid('tear_gas') * 1000)
        .duration(200)
        .EUt(120)
        .buildAndRegister();

FBR.recipeBuilder()
        .notConsumable(metaitem('catalystBedCuprousOxide'))
        .fluidInputs(fluid('acetone') * 100)
        .fluidInputs(fluid('hydrogen') * 100)
        .fluidInputs(fluid('ammonia') * 50)
        .fluidOutputs(fluid('diluted_diisopropylamine') * 150)
        .duration(3)
        .EUt(120)
        .buildAndRegister();

DISTILLATION_TOWER.recipeBuilder()
        .fluidInputs(fluid('diluted_diisopropylamine') * 3000)
        .fluidOutputs(fluid('water') * 2000)
        .fluidOutputs(fluid('diisopropylamine') * 1000)
        .duration(200)
        .EUt(120)
        .buildAndRegister();

CSTR.recipeBuilder()
        .fluidInputs(fluid('propene') * 50)
        .fluidInputs(fluid('water') * 100)
        .fluidInputs(fluid('sulfuric_acid') * 50)
        .fluidOutputs(fluid('hydrated_propene') * 150)
        .duration(3)
        .EUt(120)
        .buildAndRegister();

DISTILLATION_TOWER.recipeBuilder()
        .fluidInputs(fluid('hydrated_propene') * 3000)
        .fluidOutputs(fluid('diluted_sulfuric_acid') * 2000)
        .fluidOutputs(fluid('isopropyl_alcohol') * 1000)
        .duration(200)
        .EUt(120)
        .buildAndRegister();

FBR.recipeBuilder()
        .notConsumable(metaitem('catalystBedAlumina'))
        .fluidInputs(fluid('ethanol') * 300)
        .fluidInputs(fluid('ammonia') * 150)
        .fluidOutputs(fluid('ethylamine_mix') * 450)
        .duration(5)
        .EUt(120)
        .buildAndRegister();

DISTILLATION_TOWER.recipeBuilder()
        .fluidInputs(fluid('ethylamine_mix') * 9000)
        .fluidOutputs(fluid('water') * 6000)
        .fluidOutputs(fluid('triethylamine') * 1000)
        .fluidOutputs(fluid('diethylamine') * 1000)
        .fluidOutputs(fluid('ethylamine') * 1000)
        .duration(300)
        .EUt(120)
        .buildAndRegister();

CSTR.recipeBuilder()
        .fluidInputs(fluid('triethylamine') * 800)
        .fluidInputs(fluid('ethanol') * 800)
        .fluidInputs(fluid('titanium_tetrachloride') * 200)
        .fluidOutputs(fluid('titanium_ethoxide') * 50)
        .duration(20)
        .EUt(1920)
        .buildAndRegister();

CSTR.recipeBuilder()
        .fluidInputs(fluid('diethylamine') * 50)
        .fluidInputs(fluid('gtfo_acetic_anhydride') * 50)
        .fluidOutputs(fluid('diethylacetamide') * 50)
        .fluidOutputs(fluid('acetic_acid') * 50)
        .duration(3)
        .EUt(120)
        .buildAndRegister();

LCR.recipeBuilder()
        .notConsumable(fluid('titanium_ethoxide') * 1000)
        .fluidInputs(fluid('diethylacetamide') * 1000)
        .fluidInputs(fluid('ammonia') * 1000)
        .fluidOutputs(fluid('water') * 1000)
        .fluidOutputs(fluid('diethylacetimidamine') * 1000)
        .duration(200)
        .EUt(1920)
        .buildAndRegister();

LCR.recipeBuilder()
        .fluidInputs(fluid('diethylacetimidamine') * 1000)
        .fluidInputs(fluid('methylphosphonyl_difluoride') * 1000)
        .fluidOutputs(fluid('novichok') * 1000)
        .fluidOutputs(fluid('hydrogen_fluoride') * 1000)
        .duration(200)
        .EUt(1920)
        .buildAndRegister();