import static globals.Globals.*

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;


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

def COAL_SOURCES = [
    "dustCarbon",
    "gemCoal",
    "dustCoal",
    "gemCharcoal",
    "dustCoke",
    "gemCoke",
    "dustCharcoal"
]

// Soap

CENTRIFUGE.recipeBuilder()
.fluidInputs(fluid('methanol') * 250)
.fluidInputs(fluid('fish_oil') * 6000)
.fluidOutputs(fluid('bio_diesel') * 6000)
.fluidOutputs(fluid('glycerol') * 1000)
.duration(200)
.EUt(30)
.buildAndRegister()

CENTRIFUGE.recipeBuilder()
.fluidInputs(fluid('ethanol') * 250)
.fluidInputs(fluid('fish_oil') * 6000)
.fluidOutputs(fluid('bio_diesel') * 6000)
.fluidOutputs(fluid('glycerol') * 1000)
.duration(200)
.EUt(30)
.buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('methanol') * 250)
        .fluidInputs(fluid('seed_oil') * 6000)
        .fluidOutputs(fluid('bio_diesel') * 6000)
        .fluidOutputs(fluid('glycerol') * 1000)
        .duration(200)
        .EUt(30)
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('ethanol') * 250)
        .fluidInputs(fluid('seed_oil') * 6000)
        .fluidOutputs(fluid('bio_diesel') * 6000)
        .fluidOutputs(fluid('glycerol') * 1000)
        .duration(200)
        .EUt(30)
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('methanol') * 250)
        .fluidInputs(fluid('gtfo_stearin') * 6000)
        .fluidOutputs(fluid('bio_diesel') * 6000)
        .fluidOutputs(fluid('glycerol') * 1000)
        .duration(200)
        .EUt(30)
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('ethanol') * 250)
        .fluidInputs(fluid('gtfo_stearin') * 6000)
        .fluidOutputs(fluid('bio_diesel') * 6000)
        .fluidOutputs(fluid('glycerol') * 1000)
        .duration(200)
        .EUt(30)
        .buildAndRegister()

// Ammonium Chloride

BCR.recipeBuilder()
.fluidInputs(fluid('hydrochloric_acid') * 50)
.fluidInputs(fluid('ammonia') * 50)
.fluidOutputs(fluid('ammonium_chloride_solution') * 50)
.duration(5)
.EUt(30)
.buildAndRegister()

DISTILLERY.recipeBuilder()
.fluidInputs(fluid('ammonium_chloride_solution') * 1000)
.outputs(ore('dustAmmoniumChloride').first() * 6)
.fluidOutputs(fluid('water') * 1000)
.duration(120)
.EUt(30)
.buildAndRegister()

// Styrene 

DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('ammonium_chloride_solution') * 1000)
        .outputs(ore('dustAmmoniumChloride').first() * 6)
        .fluidOutputs(fluid('water') * 1000)
        .duration(120)
        .EUt(30)
        .buildAndRegister()

FBR.recipeBuilder()
.fluidInputs(fluid('ethylbenzene') * 50)
.fluidInputs(fluid('steam') * 50)
.notConsumable(ore('catalystBedIronIiiOxide'))
.fluidOutputs(fluid('crude_styrene') * 50)
.fluidOutputs(fluid('hydrogen') * 100)
.duration(2)
.EUt(30)
.buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
.fluidInputs(fluid('crude_styrene') * 1000)
.fluidOutputs(fluid('ethylbenzene') * 100)
.fluidOutputs(fluid('styrene') * 900)
.duration(30)
.EUt(30)
.buildAndRegister()


// Carbon Monoxide roaster

for (coal_source in COAL_SOURCES) {
    ROASTER.recipeBuilder()
    .fluidInputs(fluid('oxygen') * 1000)
    .inputs(ore(coal_source))
    .notConsumable(circuit(1))
    .fluidOutputs(fluid('carbon_monoxide') * 1000)
    .duration(80)
    .EUt(7)
    .buildAndRegister()
}

// Carbon Dioxide roaster
for (coal_source in COAL_SOURCES) {
    ROASTER.recipeBuilder()
    .fluidInputs(fluid('oxygen') * 2000)
    .inputs(ore(coal_source))
    .notConsumable(circuit(2))
    .fluidOutputs(fluid('carbon_dioxide') * 1000)
    .duration(40)
    .EUt(7)
    .buildAndRegister()
}

//CARBON DISULFIDE

for (coal_source in COAL_SOURCES) {
    ROASTER.recipeBuilder()
            .inputs(ore(coal_source))
            .inputs(metaitem('dustSulfur') * 2)
            .fluidOutputs(fluid('carbon_disulfide') * 1000)
            .duration(100)
            .EUt(60)
            .buildAndRegister()
}


// Phosphorous Pentoxide roaster

ROASTER.recipeBuilder()
.fluidInputs(fluid('oxygen') * 10000)
.inputs(ore('dustPhosphorus') * 4)
.outputs(ore('dustPhosphorusPentoxide').first() * 14)
.duration(40)
.EUt(30)
.buildAndRegister()

// Sulfur Dioxide roaster

ROASTER.recipeBuilder()
.fluidInputs(fluid('oxygen') * 2000)
.inputs(ore('dustSulfur'))
.fluidOutputs(fluid('sulfur_dioxide') * 1000)
.duration(60)
.EUt(7)
.buildAndRegister()

//Phosphoric Acid mixer

BR.recipeBuilder()
.inputs(ore('dustPhosphorusPentoxide'))
.fluidInputs(fluid('water') * 6000)
.fluidOutputs(fluid('phosphoric_acid') * 4000)
.duration(40)
.EUt(30)
.buildAndRegister()

//Hydrochloric Acid

CSTR.recipeBuilder()
.fluidInputs(fluid('hydrogen') * 50)
.fluidInputs(fluid('chlorine') * 50)
.fluidOutputs(fluid('hydrogen_chloride') * 50)
.duration(1)
.EUt(7)
.buildAndRegister()

BCR.recipeBuilder()
.fluidInputs(fluid('hydrogen_chloride') * 50)
.fluidInputs(fluid('water') * 50)
.fluidOutputs(fluid('hydrochloric_acid') * 50)
.duration(1)
.EUt(7)
.buildAndRegister()

// Hydrofluoric acid

BR.recipeBuilder()
.inputs(ore('dustFluorite') * 3)
.fluidInputs(fluid('sulfuric_acid') * 1000)
.fluidOutputs(fluid('hydrogen_fluoride') * 2000)
.outputs(ore('dustCalciumSulfate').first() * 6)
.duration(30)
.EUt(7)
.buildAndRegister()

CSTR.recipeBuilder()
        .fluidInputs(fluid('hydrogen') * 50)
        .fluidInputs(fluid('fluorine') * 50)
        .fluidOutputs(fluid('hydrogen_fluoride') * 50)
        .duration(1)
        .EUt(7)
        .buildAndRegister()

BCR.recipeBuilder()
.fluidInputs(fluid('hydrogen_fluoride') * 50)
.fluidInputs(fluid('water') * 50)
.fluidOutputs(fluid('hydrofluoric_acid') * 50)
.duration(1)
.EUt(7)
.buildAndRegister()

ROASTER.recipeBuilder()
.inputs(ore('dustCalciumSulfate') * 6)
.inputs(ore('dustCarbon') * 2)
.outputs(ore('dustCalciumSulfide').first() * 2)
.fluidOutputs(fluid('carbon_dioxide') * 2000)
.duration(30)
.EUt(7)
.buildAndRegister()

// Hydrogen Sulfide 

BR.recipeBuilder()
.inputs(ore('dustIronIiSulfide') * 2)
.fluidInputs(fluid('hydrochloric_acid') * 2000)
.outputs(ore('dustIronIiChloride').first() * 3)
.fluidOutputs(fluid('hydrogen_sulfide') * 1000)
.duration(30)
.EUt(7)
.buildAndRegister()

ROASTER.recipeBuilder()
.inputs(ore('dustSulfur'))
.inputs(ore('dustIron'))
.outputs(ore('dustIronIiSulfide').first() * 2)
.duration(160)
.EUt(7)
.buildAndRegister()

// Antimony Trioxide roaster
ROASTER.recipeBuilder()
.fluidInputs(fluid('oxygen') * 3000)
.inputs(ore('dustAntimony'))
.outputs(ore('dustAntimonyTrioxide').first())
.duration(60)
.EUt(7)
.buildAndRegister()

// Sodium bisulfate and related

CSTR.recipeBuilder()
.fluidInputs(fluid('salt_water') * 50)
.fluidInputs(fluid('sulfuric_acid') * 50)
.fluidOutputs(fluid('hydrogen_chloride') * 50)
.fluidOutputs(fluid('sodium_bisulfate_solution') * 50)
.duration(1)
.EUt(30)
.buildAndRegister()

CSTR.recipeBuilder()
.fluidInputs(fluid('potassium_chloride_solution') * 50)
.fluidInputs(fluid('sulfuric_acid') * 50)
.fluidOutputs(fluid('hydrogen_chloride') * 50)
.fluidOutputs(fluid('potassium_bisulfate_solution') * 50)
.duration(1)
.EUt(30)
.buildAndRegister()

DISTILLERY.recipeBuilder()
.fluidInputs(fluid('sodium_bisulfate_solution') * 1000)
.outputs(ore('dustSodiumBisulfate').first() * 7)
.fluidOutputs(fluid('water') * 1000)
.duration(60)
.EUt(30)
.buildAndRegister()

DISTILLERY.recipeBuilder()
.fluidInputs(fluid('potassium_bisulfate_solution') * 1000)
.outputs(ore('dustPotassiumBisulfate').first() * 7)
.fluidOutputs(fluid('water') * 1000)
.duration(60)
.EUt(30)
.buildAndRegister()

ROASTER.recipeBuilder()
.fluidInputs(fluid('sodium_bisulfate_solution') * 1000)
.inputs(ore('dustSalt') * 2)
.fluidOutputs(fluid('hydrochloric_acid') * 1000)
.outputs(ore('dustSodiumSulfate').first() * 7)
.duration(60)
.EUt(30)
.buildAndRegister()

ROASTER.recipeBuilder()
.fluidInputs(fluid('potassium_bisulfate_solution') * 1000)
.inputs(ore('dustSalt') * 2)
.fluidOutputs(fluid('hydrogen_chloride') * 1000)
.fluidOutputs(fluid('steam') * 1000)
.outputs(ore('dustPotassiumSulfate').first())
.duration(60)
.EUt(30)
.buildAndRegister()

BR.recipeBuilder()
.fluidInputs(fluid('sulfuric_acid') * 1000)
.inputs(ore('dustSaltpeter') * 5)
.fluidOutputs(fluid('nitric_acid') * 1000)
.outputs(ore('dustPotassiumBisulfate').first() * 7)
.duration(60)
.EUt(30)
.buildAndRegister()

// Sodium Sulfide

ROASTER.recipeBuilder()
.inputs(ore('dustSodiumSulfate') * 7)
.inputs(ore('dustCarbon') * 2)
.fluidOutputs(fluid('carbon_dioxide') * 2000)
.outputs(ore('dustSodiumSulfide').first() * 3)
.duration(60)
.EUt(30)
.buildAndRegister()

// Antimony trifluoride

BR.recipeBuilder()
.fluidInputs(fluid('hydrofluoric_acid') * 6000)
.inputs(ore('dustAntimonyTrioxide') * 5)
.outputs(ore('dustWetAntimonyTrifluoride').first() * 8)
.duration(60)
.EUt(30)
.buildAndRegister()

DRYER.recipeBuilder()
.inputs(ore('dustWetAntimonyTrifluoride') * 4)
.fluidOutputs(fluid('water') * 4500)
.outputs(ore('dustAntimonyTrifluoride').first() * 4)
.duration(200)
.EUt(30)
.buildAndRegister()

// Chloroform

CSTR.recipeBuilder()
.fluidInputs(fluid('methane') * 50)
.fluidInputs(fluid('chlorine') * 250)
.fluidOutputs(fluid('chlorinated_methane_mixture') * 200)
.duration(5)
.EUt(30)
.buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
.fluidInputs(fluid('chlorinated_methane_mixture') * 4000)
.fluidOutputs(fluid('hydrogen_chloride') * 2500)
.fluidOutputs(fluid('chloromethane') * 250)
.fluidOutputs(fluid('dichloromethane') * 250)
.fluidOutputs(fluid('chloroform') * 250)
.fluidOutputs(fluid('carbon_tetrachloride') * 250)
.duration(160)
.EUt(30)
.buildAndRegister()

CSTR.recipeBuilder()
.fluidInputs(fluid('chloromethane') * 15)
.fluidInputs(fluid('chlorine') * 60)
.fluidOutputs(fluid('chlorinated_chloromethane_mixture') * 50)
.duration(5)
.EUt(30)
.buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
.fluidInputs(fluid('chlorinated_chloromethane_mixture') * 5000)
.fluidOutputs(fluid('hydrogen_chloride') * 3000)
.fluidOutputs(fluid('dichloromethane') * 500)
.fluidOutputs(fluid('chloroform') * 500)
.fluidOutputs(fluid('carbon_tetrachloride') * 500)
.duration(160)
.EUt(30)
.buildAndRegister()

CSTR.recipeBuilder()
.fluidInputs(fluid('dichloromethane') * 50)
.fluidInputs(fluid('chlorine') * 150)
.fluidOutputs(fluid('chlorinated_dichloromethane_mixture') * 150)
.duration(5)
.EUt(30)
.buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
.fluidInputs(fluid('chlorinated_dichloromethane_mixture') * 3000)
.fluidOutputs(fluid('hydrogen_chloride') * 1500)
.fluidOutputs(fluid('chloroform') * 500)
.fluidOutputs(fluid('carbon_tetrachloride') * 500)
.duration(160)
.EUt(30)
.buildAndRegister()

CSTR.recipeBuilder()
.fluidInputs(fluid('chloroform') * 50)
.fluidInputs(fluid('chlorine') * 50)
.fluidOutputs(fluid('carbon_tetrachloride') * 50)
.fluidOutputs(fluid('hydrogen_chloride') * 50)
.duration(5)
.EUt(30)
.buildAndRegister()

// Chloromethane alternative production

CSTR.recipeBuilder()
.fluidInputs(fluid('methanol') * 50)
.fluidInputs(fluid('hydrochloric_acid') * 50)
.fluidOutputs(fluid('chloromethane_solution') * 150)
.duration(5)
.EUt(30)
.buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
.fluidInputs(fluid('chloromethane_solution') * 3000)
.fluidOutputs(fluid('water') * 2000)
.fluidOutputs(fluid('chloromethane') * 1000)
.duration(160)
.EUt(30)
.buildAndRegister()

// Calcium Chloride
mods.gregtech.electric_blast_furnace.removeByInput(120, [metaitem('dustCalcite') * 5, metaitem('dustSalt') * 4], null)

CENTRIFUGE.recipeBuilder()
.fluidInputs(fluid('hydrochloric_acid') * 2000)
.inputs(ore('dustCalciumSulfide') * 2)
.fluidOutputs(fluid('calcium_chloride_solution') * 1000)
.fluidOutputs(fluid('hydrogen_sulfide') * 1000)
.duration(80)
.EUt(30)
.buildAndRegister()

DISTILLERY.recipeBuilder()
.fluidInputs(fluid('calcium_chloride_solution') * 1000)
.fluidOutputs(fluid('water') * 1000)
.outputs(ore('dustCalciumChloride').first() * 3)
.duration(160)
.EUt(30)
.buildAndRegister()

// Soda Ash 
    
// Leblanc process

ROASTER.recipeBuilder()
        .fluidInputs(fluid('sulfuric_acid') * 1000)
        .inputs(ore('dustSalt') * 4)
        .fluidOutputs(fluid('hydrochloric_acid') * 1000)
        .outputs(ore('dustSodiumSulfate').first() * 7)
        .duration(60)
        .EUt(30)
        .buildAndRegister()

ROASTER.recipeBuilder()
.inputs(ore('dustSodiumSulfide') * 3)
.inputs(ore('dustLimestone') * 5)
.outputs(ore('dustBlackAsh').first() * 8)
.duration(160)
.EUt(30)
.buildAndRegister()

MIXER.recipeBuilder()
.fluidInputs(fluid('water') * 1000)
.inputs(ore('dustBlackAsh') * 8)
.fluidOutputs(fluid('soda_ash_solution') * 1000)
.outputs(ore('dustCalciumSulfide').first() * 2)
.duration(80)
.EUt(30)
.buildAndRegister()

DISTILLERY.recipeBuilder()
.fluidInputs(fluid('soda_ash_solution') * 1000)
.fluidOutputs(fluid('water') * 1000)
.outputs(ore('dustSodaAsh').first() * 6)
.duration(160)
.EUt(30)
.buildAndRegister()

    // Solvay Process

MIXER.recipeBuilder()
.fluidInputs(fluid('salt_water') * 1000)
.fluidInputs(fluid('water') * 1000)
.fluidOutputs(fluid('diluted_saltwater') * 2000)
.duration(80)
.EUt(30)
.buildAndRegister()

BCR.recipeBuilder()
.fluidInputs(fluid('diluted_saltwater') * 100)
.fluidInputs(fluid('carbon_dioxide') * 50)
.fluidInputs(fluid('ammonia') * 50)
.fluidOutputs(fluid('sodium_bicarbonate_solution') * 50)
.duration(5)
.EUt(30)
.buildAndRegister()

SIFTER.recipeBuilder()
.fluidInputs(fluid('sodium_bicarbonate_solution') * 1000)
.fluidOutputs(fluid('ammonium_chloride_solution') * 1000)
.outputs(ore('dustSodiumBicarbonate').first() * 6)
.duration(80)
.EUt(30)
.buildAndRegister()

ROASTER.recipeBuilder()
.inputs(ore('dustCalcite') * 5)
.notConsumable(circuit(0))
.fluidOutputs(fluid('carbon_dioxide') * 3000)
.outputs(ore('dustQuicklime').first() * 2)
.duration(80)
.EUt(30)
.buildAndRegister()

ROASTER.recipeBuilder()
        .inputs(ore('dustLimestone') * 5)
        .notConsumable(circuit(0))
        .fluidOutputs(fluid('carbon_dioxide') * 3000)
        .outputs(ore('dustQuicklime').first() * 2)
        .duration(80)
        .EUt(30)
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
.fluidInputs(fluid('ammonium_chloride_solution') * 2000)
.inputs(ore('dustQuicklime') * 2)
.fluidOutputs(fluid('ammonia') * 2000)
.fluidOutputs(fluid('calcium_chloride_solution') * 2000)
.duration(80)
.EUt(30)
.buildAndRegister()

ROASTER.recipeBuilder()
.inputs(ore('dustSodiumBicarbonate') * 12)
.fluidOutputs(fluid('carbon_dioxide') * 1000)
.fluidOutputs(fluid('steam') * 1000)
.outputs(ore('dustSodaAsh').first())
.duration(80)
.EUt(30)
.buildAndRegister()

// Acetic Acid

FBR.recipeBuilder()
.fluidInputs(fluid('ethylene') * 100)
.fluidInputs(fluid('oxygen') * 100)
.notConsumable(ore('catalystBedPlatinum'))
.fluidOutputs(fluid('gtfo_acetaldehyde') * 100)
.duration(5)
.EUt(30)
.buildAndRegister()

FBR.recipeBuilder()
.fluidInputs(fluid('gtfo_acetaldehyde') * 100)
.fluidInputs(fluid('oxygen') * 100)
.notConsumable(ore('catalystBedCobalt'))
.fluidOutputs(fluid('acetic_acid') * 100)
.duration(5)
.EUt(30)
.buildAndRegister()

// Nitrous Oxide

ROASTER.recipeBuilder()
.inputs(ore('dustAmmoniumNitrate') * 9)
.fluidOutputs(fluid('water') * 2000)
.fluidOutputs(fluid('nitric_oxide') * 1000)
.duration(80)
.EUt(30)
.buildAndRegister()

CSTR.recipeBuilder()
.fluidInputs(fluid('ammonia') * 100)
.fluidInputs(fluid('oxygen') * 100)
.fluidOutputs(fluid('water') * 150)
.fluidOutputs(fluid('nitric_oxide') * 50)
.duration(5)
.EUt(30)
.buildAndRegister()

// Cumene

FBR.recipeBuilder()
.fluidInputs(fluid('hot_hp_propene') * 50)
.fluidInputs(fluid('hot_hp_benzene') * 50)
.notConsumable(fluid('phosphoric_acid'))
.fluidOutputs(fluid('cumene') * 50)
.duration(5)
.EUt(30)
.buildAndRegister()

CSTR.recipeBuilder()
.fluidInputs(fluid('cumene') * 50)
.fluidInputs(fluid('oxygen') * 100)
.fluidOutputs(fluid('phenol') * 50)
.fluidOutputs(fluid('acetone') * 50)
.duration(8)
.EUt(30)
.buildAndRegister()

// Ethylene

CSTR.recipeBuilder()
.fluidInputs(fluid('sulfuric_acid') * 100)
.fluidInputs(fluid('ethanol') * 100)
.fluidOutputs(fluid('ethylene') * 100)
.fluidOutputs(fluid('diluted_sulfuric_acid') * 200)
.duration(5)
.EUt(30)
.buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
        .fluidInputs(fluid('diluted_sulfuric_acid') * 500)
        .fluidOutputs(fluid('water') * 250)
        .fluidOutputs(fluid('sulfuric_acid') * 250)
        .duration(50)
        .EUt(30)
        .buildAndRegister()

for (int i = 0; i < CHEMICAL_DYES.length; i++) {
    MIXER.recipeBuilder()
    .input(dye, MarkerMaterials.Color.VALUES[i])
    .inputs(ore('dustSalt') * 2)
    .fluidInputs(fluid('sulfuric_acid') * 250)
    .fluidOutputs(CHEMICAL_DYES[i].getFluid(288))
    .duration(600)
    .EUt(24)
    .buildAndRegister()
}

DISTILLATION_TOWER.recipeBuilder()
        .fluidInputs(fluid('hydrochloric_acid') * 500)
        .fluidOutputs(fluid('water') * 500)
        .fluidOutputs(fluid('hydrogen_chloride') * 500)
        .duration(50)
        .EUt(30)
        .buildAndRegister()

// Tetrafluoroethylene

BCR.recipeBuilder()
.fluidInputs(fluid('chloroform') * 50)
.fluidInputs(fluid('hydrogen_fluoride') * 100)
.fluidOutputs(fluid('acidic_chlorodifluoromethane') * 150)
.duration(5)
.EUt(30)
.buildAndRegister()

PYROLYSE.recipeBuilder()
.fluidInputs(fluid('acidic_chlorodifluoromethane') * 6000)
.fluidOutputs(fluid('acidic_tetrafluoroethylene') * 5000)
.duration(200)
.EUt(30)
.buildAndRegister()

CENTRIFUGE.recipeBuilder()
.fluidInputs(fluid('acidic_tetrafluoroethylene') * 5000)
.fluidInputs(fluid('water') * 4000)
.fluidOutputs(fluid('tetrafluoroethylene') * 1000)
.fluidOutputs(fluid('hydrochloric_acid') * 4000)
.duration(200)
.EUt(30)
.buildAndRegister()

// Tetranitromethane

CSTR.recipeBuilder()
.fluidInputs(fluid('nitric_acid') * 150)
.fluidInputs(fluid('acetylene') * 50)
.fluidOutputs(fluid('trinitromethane_solution') * 150)
.fluidOutputs(fluid('carbon_monoxide') * 50)
.duration(5)
.EUt(30)
.buildAndRegister()

CSTR.recipeBuilder()
.fluidInputs(fluid('trinitromethane_solution') * 150)
.fluidInputs(fluid('nitration_mixture') * 100)
.fluidOutputs(fluid('tetranitromethane_solution') * 250)
.duration(5)
.EUt(30)
.buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
.fluidInputs(fluid('tetranitromethane_solution') * 5000)
.fluidOutputs(fluid('tetranitromethane') * 1000)
.fluidOutputs(fluid('water') * 3000)
.fluidOutputs(fluid('sulfuric_acid') * 1000)
.duration(160)
.EUt(30)
.buildAndRegister()

// Polydimethylsiloxane

FLUIDIZEDBR.recipeBuilder()
.fluidInputs(fluid('chloromethane') * 2000)
.inputs(ore('dustCuprousOxide'))
.inputs(ore('dustSilicon'))
.fluidOutputs(fluid('impure_dimethyldichlorosilane') * 1000)
.duration(160)
.EUt(30)
.buildAndRegister()

DISTILLERY.recipeBuilder()
.fluidInputs(fluid('impure_dimethyldichlorosilane') * 1000)
.fluidOutputs(fluid('dimethyldichlorosilane') * 1000)
.outputs(ore('dustCuprousOxide').first())
.duration(120)
.EUt(30)
.buildAndRegister()

MIXER.recipeBuilder()
.fluidInputs(fluid('dimethyldichlorosilane') * 1000)
.fluidInputs(fluid('water') * 2000)
.fluidInputs(fluid('gtfo_sodium_stearate') * 100)
.fluidOutputs(fluid('dimethyldichlorosilane_emulsion') * 3000)
.duration(120)
.EUt(30)
.buildAndRegister()

POLYMERIZATION.recipeBuilder()
.fluidInputs(fluid('dimethyldichlorosilane_emulsion') * 3000)
.inputs(ore('dustPotassiumPersulfate'))
.outputs(ore('dustPolydimethylsiloxane').first() * 3)
.fluidOutputs(fluid('hydrogen_chloride') * 2000)
.EUt(30)
.duration(160)
.buildAndRegister()
//Vulcanisation in Rubber Recipes 

// Ammonia

BR.recipeBuilder()
.fluidInputs(fluid('water') * 1000)
.inputs(ore('dustAmmoniumChloride'))
.fluidOutputs(fluid('ammonium_chloride_solution') * 1000)
.EUt(30)
.duration(160)
.buildAndRegister()

CSTR.recipeBuilder()
.fluidInputs(fluid('ammonium_chloride_solution') * 50)
.fluidInputs(fluid('sodium_hydroxide_solution') * 50)
.fluidOutputs(fluid('ammonia') * 50)
.fluidOutputs(fluid('salt_water') * 50)
.duration(1)
.EUt(7)
.buildAndRegister()

// Dinitrogen Tetroxide

BR.recipeBuilder()
.fluidInputs(fluid('nitrogen_dioxide') * 2000)
.fluidOutputs(fluid('dinitrogen_tetroxide') * 1000)
.duration(200)
.EUt(60)
.buildAndRegister()

// 1,1-dimethylhydrazine

CSTR.recipeBuilder()
.fluidInputs(fluid('monochloramine') * 50)
.fluidInputs(fluid('dimethylamine') * 50)
.fluidOutputs(fluid('dimethylhydrazine') * 50)
.fluidOutputs(fluid('hydrogen_chloride') * 50)
.duration(10)
.EUt(30)
.buildAndRegister()

// Vinyl acetate

FBR.recipeBuilder()
.fluidInputs(fluid('acetic_acid') * 50)
.fluidInputs(fluid('ethylene') * 50)
.notConsumable(ore('catalystBedPalladium'))
.fluidOutputs(fluid('vinyl_acetate') * 50)
.duration(10)
.EUt(30)
.buildAndRegister()

// Hypochloric Acid

BCR.recipeBuilder()
.fluidInputs(fluid('water') * 50)
.fluidInputs(fluid('chlorine') * 100)
.fluidOutputs(fluid('hydrogen_chloride') * 50)
.fluidOutputs(fluid('hypochlorous_acid') * 50)
.duration(6)
.EUt(30)
.buildAndRegister()


// Epichlorohydrin

CSTR.recipeBuilder()
.fluidInputs(fluid('glycerol') * 50)
.fluidInputs(fluid('hydrogen_chloride') * 100)
.fluidInputs(fluid('acetic_acid') * 50)
.fluidOutputs(fluid('chlorinated_glycerol') * 50)
.duration(5)
.EUt(30)
.buildAndRegister()

BR.recipeBuilder()
.fluidInputs(fluid('chlorinated_glycerol') * 4000)
.inputs(ore('dustSodiumHydroxide') * 3)
.fluidOutputs(fluid('epichlorohydrin_solution') * 5000)
.duration(120)
.EUt(30)
.buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
.fluidInputs(fluid('epichlorohydrin_solution') * 5000)
.fluidOutputs(fluid('acetic_acid') * 1000)
.fluidOutputs(fluid('water') * 3000)
.fluidOutputs(fluid('epichlorohydrin') * 1000)
.outputs(ore('dustSalt').first() * 2)
.duration(120)
.EUt(30)
.buildAndRegister()

BCR.recipeBuilder()
.fluidInputs(fluid('allyl_chloride') * 50)
.fluidInputs(fluid('hypochlorous_acid') * 50)
.fluidOutputs(fluid('allyl_alcohol_mix') * 50)
.duration(5)
.EUt(30)
.buildAndRegister()

BR.recipeBuilder()
.fluidInputs(fluid('allyl_alcohol_mix') * 1000)
.inputs(ore('dustSodiumHydroxide') * 3)
.fluidOutputs(fluid('dilute_epichlorohydrin') * 2000)
.duration(120)
.EUt(30)
.buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
.fluidInputs(fluid('dilute_epichlorohydrin') * 2000)
.fluidOutputs(fluid('epichlorohydrin') * 1000)
.fluidOutputs(fluid('water') * 1000)
.outputs(ore('dustSalt').first() * 2)
.duration(160)
.EUt(30)
.buildAndRegister()

BR.recipeBuilder()
.fluidInputs(fluid('polyvinyl_acetate') * 144)
.fluidInputs(fluid('butyraldehyde') * 250)
.fluidOutputs(fluid('polyvinyl_butyral') * 250)
.duration(400)
.EUt(480)
.buildAndRegister()

// Ethyl-tert-butyl ether

FBR.recipeBuilder()
.fluidInputs(fluid('butane') * 50)
.notConsumable(ore('dustAluminiumChloride'))
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
.fluidOutputs(fluid('ethyl_tertbutyl_ether') * 50)
.duration(5)
.EUt(30)
.buildAndRegister()

// Cyclohexane

TBR.recipeBuilder()
.fluidInputs(fluid('hydrogen') * 300)
.fluidInputs(fluid('benzene') * 50)
.notConsumable(ore('dustNickel'))
.fluidOutputs(fluid('cyclohexane') * 50)
.duration(5)
.EUt(30)
.buildAndRegister()

// Iron(III)-chloride

ROASTER.recipeBuilder()
.fluidInputs(fluid('chlorine') * 6000)
.inputs(ore('dustIron') * 2)
.outputs(ore('dustIronIiiChloride').first() * 8)
.duration(160)
.EUt(30)
.buildAndRegister()

MIXER.recipeBuilder()
.fluidInputs(fluid('water') * 1000)
.inputs(ore('dustIronIiiChloride') * 8)
.fluidOutputs(fluid('iron_iii_chloride_solution') * 1000)
.duration(160)
.EUt(30)
.buildAndRegister()

// Methanol

FLUIDIZEDBR.recipeBuilder()
.fluidInputs(fluid('hot_hp_carbon_monoxide') * 50)
.fluidInputs(fluid('hot_hp_hydrogen') * 100)
.notConsumable(ore('dustCuprousOxide'))
.fluidOutputs(fluid('methanol') * 50)
.duration(5)
.EUt(30)
.buildAndRegister()

// Phosphoric acid from sulfuric acid? 

    // Fluoroapatite route

BR.recipeBuilder()
    .fluidInputs(fluid('sulfuric_acid') * 5000)
    .inputs(ore('dustFluorapatite') * 21)
    .fluidOutputs(fluid('phosphoric_acid') * 3000)
    .fluidOutputs(fluid('hydrogen_fluoride') * 1000)
    .outputs(ore('dustCalciumSulfate').first() * 30)
    .duration(120)
    .EUt(30)
    .buildAndRegister()

    // Apatite route

BR.recipeBuilder()
    .fluidInputs(fluid('sulfuric_acid') * 5000)
    .inputs(ore('dustApatite') * 21)
    .fluidOutputs(fluid('phosphoric_acid') * 3000)
    .fluidOutputs(fluid('hydrogen_chloride') * 1000)
    .outputs(ore('dustCalciumSulfate').first() * 30)
    .duration(120)
    .EUt(30)
    .buildAndRegister()

// Fluoroantimonic Acid

LCR.recipeBuilder()
.circuitMeta(0)
.fluidInputs(fluid('hydrofluoric_acid') * 4000)
.inputs(ore('dustAntimonyTrifluoride') * 4)
.fluidOutputs(fluid('fluoroantimonic_acid') * 1000)
.fluidOutputs(fluid('hydrogen') * 2000)
.duration(3000)
.EUt(480)
.buildAndRegister()

// Sodium Potassium

MIXER.recipeBuilder()
.inputs(ore('dustSodium'))
.inputs(ore('dustPotassium'))
.fluidOutputs(fluid('sodium_potassium') * 1000)
.duration(3000)
.EUt(30)
.buildAndRegister()

// Polyphenylene Sulfide

POLYMERIZATION.recipeBuilder()
.fluidInputs(fluid('n_methyl_ii_pyrrolidone') * 1000)
.inputs(ore('dustDichlorobenzene') * 12)
.inputs(ore('dustSodiumSulfide') * 3)
.fluidOutputs(fluid('salty_n_methyl_ii_pyrrolidone') * 1000)
.outputs(ore('dustPolyphenyleneSulfide').first() * 11)
.duration(600)
.EUt(240)
.buildAndRegister()

DISTILLERY.recipeBuilder()
.fluidInputs(fluid('salty_n_methyl_ii_pyrrolidone') * 1000)
.fluidOutputs(fluid('n_methyl_ii_pyrrolidone') * 1000)
.outputs(ore('dustSalt').first() * 4)
.duration(400)
.EUt(120)
.buildAndRegister()

// Nitric Acid, Nitrogen Dioxide

CSTR.recipeBuilder()
.fluidInputs(fluid('oxygen') * 50)
.fluidInputs(fluid('nitric_oxide') * 50)
.fluidOutputs(fluid('nitrogen_dioxide') * 50)
.duration(8)
.EUt(30)
.buildAndRegister()

CSTR.recipeBuilder()
.fluidInputs(fluid('water') * 50)
.fluidInputs(fluid('nitrogen_dioxide') * 150)
.fluidOutputs(fluid('nitric_acid') * 100)
.fluidOutputs(fluid('nitric_oxide') * 50)
.duration(12)
.EUt(30)
.buildAndRegister()

// Methyl Acetate

CSTR.recipeBuilder()
.fluidInputs(fluid('acetic_acid') * 50)
.fluidInputs(fluid('methanol') * 50)
.fluidInputs(fluid('sulfuric_acid') * 50)
.fluidOutputs(fluid('methyl_acetate_solution') * 150)
.duration(12)
.EUt(30)
.buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
.fluidInputs(fluid('methyl_acetate_solution') * 3000)
.fluidOutputs(fluid('methyl_acetate') * 1000)
.fluidOutputs(fluid('sulfuric_acid') * 1000)
.fluidOutputs(fluid('water') * 1000)
.duration(120)
.EUt(30)
.buildAndRegister()

// Chlorobenzene

BCR.recipeBuilder()
.fluidInputs(fluid('benzene') * 50)
.fluidInputs(fluid('chlorine') * 100)
.notConsumable(ore('dustIronIiiChloride'))
.fluidOutputs(fluid('chlorobenzene') * 50)
.fluidOutputs(fluid('hydrogen_chloride') * 50)
.duration(12)
.EUt(30)
.buildAndRegister()

// Tungsten from tungsten trioxide

EBF.recipeBuilder()
.fluidInputs(fluid('hydrogen') * 6000)
.inputs(ore('dustTungstenTrioxide') * 4)
.fluidOutputs(fluid('steam') * 3000)
.outputs(ore('dustTungsten').first())
.duration(1000)
.EUt(60)
.buildAndRegister()

EBF.recipeBuilder()
.inputs(ore('dustCarbon') * 3)
.inputs(ore('dustTungstenTrioxide') * 4)
.fluidOutputs(fluid('carbon_monoxide') * 3000)
.outputs(ore('dustTungsten').first())
.duration(1000)
.EUt(60)
.buildAndRegister()

// Nitrochlorobenzenes

BR.recipeBuilder()
.fluidInputs(fluid('chlorobenzene') * 1000)
.fluidInputs(fluid('nitric_acid') * 1000)
.fluidInputs(fluid('toluene') * 1000)
.fluidOutputs(fluid('mixed_nitrochlorobenzene_solution') * 2000)
.duration(100)
.EUt(480)
.buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
.fluidInputs(fluid('mixed_nitrochlorobenzene_solution') * 2000)
.fluidOutputs(fluid('water') * 1000)
.fluidOutputs(fluid('two_nitrochlorobenzene_solution') * 300)
.fluidOutputs(fluid('four_nitrochlorobenzene_solution') * 600)
.duration(300)
.EUt(60)
.buildAndRegister()
 
// 4-nitroaniline

BR.recipeBuilder()
.fluidInputs(fluid('four_nitrochlorobenzene_solution') * 1000)
.fluidInputs(fluid('ammonia') * 2000)
.fluidOutputs(fluid('four_nitroaniline_solution') * 1000)
.outputs(ore('dustAmmoniumChloride').first() * 6)
.duration(600)
.EUt(120)
.buildAndRegister()

// P-Phenylenediamine

BCR.recipeBuilder()
.fluidInputs(fluid('four_nitroaniline_solution') * 50)
.fluidInputs(fluid('hydrogen') * 300)
.fluidOutputs(fluid('para_phenylenediamine_solution') * 150)
.duration(200)
.EUt(30)
.buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
.fluidInputs(fluid('para_phenylenediamine_solution') * 3000)
.fluidOutputs(fluid('steam') * 2000)
.fluidOutputs(fluid('toluene') * 1000)
.outputs(ore('dustParaPhenylenediamine').first() * 16)
.duration(200)
.EUt(30)
.buildAndRegister()

// 3,3'-Dichlorobenzidine

FBR.recipeBuilder()
.fluidInputs(fluid('two_nitrochlorobenzene_solution') * 100)
.fluidInputs(fluid('hot_hp_hydrogen') * 100)
.notConsumable(ore('catalystBedPalladium'))
.fluidOutputs(fluid('two_two_dichlorohydrazobenzene_solution') * 50)
.duration(15)
.EUt(120)
.buildAndRegister()

CSTR.recipeBuilder()
.fluidInputs(fluid('two_two_dichlorohydrazobenzene_solution') * 50)
.fluidInputs(fluid('sulfuric_acid') * 50)
.fluidOutputs(fluid('dichlorobenzidine_solution') * 100)
.duration(10)
.EUt(120)
.buildAndRegister()

// Phthalic Acid

FLUIDIZEDBR.recipeBuilder()
.fluidInputs(fluid('xylene') * 1000)
.fluidInputs(fluid('oxygen') * 6000)
.notConsumable(ore('dustVanadiumPentoxide'))
.fluidOutputs(fluid('steam') * 3000)
.outputs(ore('dustPhthalicAnhydride').first() * 13)
.duration(300)
.EUt(240)
.buildAndRegister()

BR.recipeBuilder()
.fluidInputs(fluid('water') * 1000)
.inputs(ore('dustPhthalicAnhydride') * 15)
.outputs(ore('dustPhthalicAcid').first() * 18)
.duration(200)
.EUt(30)
.buildAndRegister()

// Diphenyl Isophthalate

TBR.recipeBuilder()
.fluidInputs(fluid('carbon_monoxide') * 50)
.fluidInputs(fluid('chlorine') * 100)
.notConsumable(ore('dustCarbon'))
.fluidOutputs(fluid('phosgene') * 50)
.duration(10)
.EUt(30)
.buildAndRegister()

BR.recipeBuilder()
.fluidInputs(fluid('dichloroethane') * 1000)
.inputs(ore('dustPhthalicAcid') * 18)
.fluidOutputs(fluid('phthalic_acid_solution') * 1000)
.duration(120)
.EUt(30)
.buildAndRegister()

CSTR.recipeBuilder()
.fluidInputs(fluid('phthalic_acid_solution') * 50)
.fluidInputs(fluid('phosgene') * 50)
.fluidOutputs(fluid('phthaloyl_dichloride_solution') * 100)
.fluidOutputs(fluid('carbon_dioxide') * 50)
.duration(10)
.EUt(30)
.buildAndRegister()

BR.recipeBuilder()
.fluidInputs(fluid('phenol') * 1000)
.inputs(ore('dustSodiumHydroxide') * 3)
.fluidOutputs(fluid('sodium_phenoxide_solution') * 1000)
.duration(160)
.EUt(30)
.buildAndRegister()

CSTR.recipeBuilder()
.fluidInputs(fluid('phthaloyl_dichloride_solution') * 100)
.fluidInputs(fluid('sodium_phenoxide_solution') * 50)
.fluidOutputs(fluid('diphenyl_isophthalate_solution') * 150)
.duration(10)
.EUt(30)
.buildAndRegister()

// 3,3-Diaminobenzidine

FLUIDIZEDBR.recipeBuilder()
.fluidInputs(fluid('dichlorobenzidine_solution') * 100)
.fluidInputs(fluid('compressed_ammonia') * 200)
.notConsumable(ore('dustCopper'))
.fluidOutputs(fluid('diaminobenzidine_solution') * 100)
.fluidOutputs(fluid('hydrogen_chloride') * 200)
.duration(5)    
.EUt(60)
.buildAndRegister()

// PBI

BR.recipeBuilder()
.fluidInputs(fluid('diaminobenzidine_solution') * 2000)
.fluidInputs(fluid('diphenyl_isophthalate_solution') * 3000)
.fluidOutputs(fluid('pbi_polymerization_mix') * 5000)
.duration(200)
.EUt(30)
.buildAndRegister()

POLYMERIZATION.recipeBuilder()
.fluidInputs(fluid('pbi_polymerization_mix') * 5000)
.fluidOutputs(fluid('pbi_pre_polymer_foam') * 25000)
.duration(200)
.EUt(240)
.buildAndRegister()

POLYMERIZATION.recipeBuilder()
.fluidInputs(fluid('pbi_pre_polymer_foam') * 25000)
.fluidOutputs(fluid('impure_pbi_solution') * 7000)
.duration(200)
.EUt(240)
.buildAndRegister()

CSTR.recipeBuilder()
.fluidInputs(fluid('dimethylamine') * 50)
.fluidInputs(fluid('acetic_acid') * 50)
.fluidOutputs(fluid('dimethylacetamide_solution') * 100)
.duration(5)    
.EUt(30)
.buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
.fluidInputs(fluid('dimethylacetamide_solution') * 2000)
.fluidOutputs(fluid('water') * 1000)
.fluidOutputs(fluid('dimethylacetamide') * 1000)
.duration(200)
.EUt(240)
.buildAndRegister()

CENTRIFUGE.recipeBuilder()
.fluidInputs(fluid('dimethylacetamide') * 1000)
.fluidInputs(fluid('impure_pbi_solution') * 7000)
.fluidOutputs(fluid('pbi_solution') * 1000)
.fluidOutputs(fluid('pbi_waste') * 7000)
.duration(300)
.EUt(120)
.buildAndRegister()

SIFTER.recipeBuilder()
.fluidInputs(fluid('pbi_solution') * 1000)
.fluidOutputs(fluid('dimethylacetamide') * 1000)
.outputs(ore('dustPolybenzimidazole').first() * 7)
.duration(300)
.EUt(120)
.buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
.fluidInputs(fluid('pbi_waste') * 7000)
.fluidOutputs(fluid('dichloroethane') * 1000)
.fluidOutputs(fluid('toluene') * 1000)
.fluidOutputs(fluid('phenol') * 1000)
.fluidOutputs(fluid('water') * 4000)
.outputs(ore('dustSalt').first() * 4)
.duration(300)
.EUt(240)
.buildAndRegister()

// Caprolactam

FBR.recipeBuilder()
.fluidInputs(fluid('nitric_oxide') * 50)
.fluidInputs(fluid('hydrogen') * 150)
.notConsumable(ore('catalystBedPlatinum'))
.fluidOutputs(fluid('hydroxylamine') * 50)
.duration(5)    
.EUt(30)
.buildAndRegister()

FBR.recipeBuilder()
.fluidInputs(fluid('cyclohexane') * 50)
.fluidInputs(fluid('oxygen') * 100)
.notConsumable(ore('catalystBedCobalt'))
.fluidOutputs(fluid('diluted_cyclohexanone') * 100)
.duration(5)    
.EUt(30)
.buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
.fluidInputs(fluid('diluted_cyclohexanone') * 2000)
.fluidOutputs(fluid('water') * 1000)
.fluidOutputs(fluid('cyclohexanone') * 1000)
.duration(300)
.EUt(30)
.buildAndRegister()

BR.recipeBuilder()
.fluidInputs(fluid('cyclohexanone') * 1000)
.fluidInputs(fluid('hydroxylamine') * 1000)
.fluidOutputs(fluid('water') * 1000)
.outputs(ore('dustCyclohexanoneOxime').first() * 34)
.duration(180)
.EUt(30)
.buildAndRegister()

BR.recipeBuilder()
.fluidInputs(fluid('sulfuric_acid') * 1000)
.inputs(ore('dustCyclohexanoneOxime') * 34)
.fluidOutputs(fluid('caprolactam_oxime_solution') * 1000)
.duration(160)
.EUt(30)
.buildAndRegister()

BR.recipeBuilder()
.fluidInputs(fluid('caprolactam_oxime_solution') * 1000)
.fluidInputs(fluid('ammonia') * 2000)
.outputs(ore('dustImpureCaprolactam').first() * 34)
.duration(160)
.EUt(30)
.buildAndRegister()

CENTRIFUGE.recipeBuilder()
.inputs(ore('dustImpureCaprolactam') * 19)
.outputs(ore('dustCaprolactam').first() * 19)
.outputs(ore('dustAmmoniumSulfate').first() * 15)
.duration(160)
.EUt(30)
.buildAndRegister()

// Polycaprolactam

PYROLYSE.recipeBuilder()
.fluidInputs(fluid('nitrogen') * 4000)
.inputs(ore('dustCaprolactam') * 8)
.outputs(ore('dustPolycaprolactam').first() * 8)
.EUt(60)
.duration(200)
.buildAndRegister()

// Butyraldehyde

FBR.recipeBuilder()
.fluidInputs(fluid('propene') * 50)
.fluidInputs(fluid('hot_hp_carbon_monoxide') * 50)
.fluidInputs(fluid('hot_hp_hydrogen') * 100)
.notConsumable(ore('catalystBedRhodium'))
.fluidOutputs(fluid('butyraldehyde') * 50)
.duration(5)
.EUt(30)
.buildAndRegister()

// Epoxy Resin

CSTR.recipeBuilder()
.fluidInputs(fluid('bisphenol_a') * 50)
.fluidInputs(fluid('epichlorohydrin') * 50)
.fluidOutputs(fluid('bisphenola_diglycidyl_ether') * 50)
.duration(10)
.EUt(30)
.buildAndRegister()

BR.recipeBuilder()
.fluidInputs(fluid('bisphenola_diglycidyl_ether') * 1000)
.inputs(ore('dustSodiumHydroxide') * 3)
.fluidOutputs(fluid('impure_epoxy_resin') * 2000)
.duration(200)
.EUt(30)
.buildAndRegister()

CENTRIFUGE.recipeBuilder()
.fluidInputs(fluid('impure_epoxy_resin') * 2000)
.fluidOutputs(fluid('salt_water') * 1000)
.fluidOutputs(fluid('uncured_epoxy_resin') * 1000)
.duration(180)
.EUt(30)
.buildAndRegister()

VULCANIZER.recipeBuilder()
.fluidInputs(fluid('uncured_epoxy_resin') * 1000)
.fluidInputs(fluid('bisphenol_a') * 100)
.notConsumable(metaitem('shape.extruder.plate'))
.outputs(ore('plateEpoxy').first() * 7)
.duration(200)
.EUt(30)
.buildAndRegister()

// Salt from Sodium and Chlorine

ROASTER.recipeBuilder()
.fluidInputs(fluid('chlorine') * 1000)
.inputs(ore('dustSodium'))
.outputs(ore('dustSalt').first() * 2)
.duration(200)
.EUt(7)
.buildAndRegister()

// Rock Salt from Sodium and Chlorine

ROASTER.recipeBuilder()
.fluidInputs(fluid('chlorine') * 1000)
.inputs(ore('dustPotassium'))
.outputs(ore('dustRockSalt').first() * 2)
.duration(200)
.EUt(7)
.buildAndRegister()

// TNT

BR.recipeBuilder()
.fluidInputs(fluid('toluene') * 1000)
.fluidInputs(fluid('nitration_mixture') * 6000)
.fluidOutputs(fluid('tnt_solution') * 3000)
.duration(200)
.EUt(24)
.buildAndRegister()

DISTILLERY.recipeBuilder()
.fluidInputs(fluid('tnt_solution') * 1000)
.fluidOutputs(fluid('diluted_sulfuric_acid') * 1000)
.outputs(ore('dustTnt').first() * 7)
.duration(300)
.EUt(30)
.buildAndRegister()


// Sulfur Trioxide

ROASTER.recipeBuilder()
.fluidInputs(fluid('oxygen') * 1000)
.fluidInputs(fluid('sulfur_dioxide') * 1000)
.notConsumable(ore('dustVanadiumPentoxide'))
.fluidOutputs(fluid('sulfur_trioxide') * 1000)

.duration(200)
.EUt(7)
.buildAndRegister()

// Saltpeter and Sodium Hydroxide Solution

MIXER.recipeBuilder()
.fluidInputs(fluid('water') * 1000)
.inputs(ore('dustSodiumHydroxide') * 3)
.fluidOutputs(fluid('sodium_hydroxide_solution') * 1000)
.duration(80)
.EUt(7)
.buildAndRegister()

MIXER.recipeBuilder()
.fluidInputs(fluid('water') * 1000)
.inputs(ore('dustAmmoniumNitrate') * 9)
.fluidOutputs(fluid('ammonium_nitrate_solution') * 1000)
.duration(80)
.EUt(7)
.buildAndRegister()

MIXER.recipeBuilder()
.fluidInputs(fluid('water') * 1000)
.inputs(ore('dustPotassiumHydroxide') * 3)
.fluidOutputs(fluid('potassium_hydroxide_solution') * 1000)
.duration(80)
.EUt(7)
.buildAndRegister()

MIXER.recipeBuilder()
.fluidInputs(fluid('water') * 1000)
.inputs(ore('dustRockSalt') * 2)
.fluidOutputs(fluid('potassium_chloride_solution') * 1000)
.duration(80)
.EUt(7)
.buildAndRegister()

CSTR.recipeBuilder()
.fluidInputs(fluid('ammonium_nitrate_solution') * 50)
.fluidInputs(fluid('potassium_hydroxide_solution') * 50)
.fluidOutputs(fluid('ammonia') * 50)
.fluidOutputs(fluid('dilute_saltpeter_solution') * 150)
.duration(5)
.EUt(30)
.buildAndRegister()

DISTILLERY.recipeBuilder()
.fluidInputs(fluid('dilute_saltpeter_solution') * 3000)
.fluidOutputs(fluid('water') * 3000)
.outputs(ore('dustSaltpeter').first() * 5)
.duration(300)
.EUt(24)
.buildAndRegister()

CSTR.recipeBuilder()
.fluidInputs(fluid('ammonium_nitrate_solution') * 50)
.fluidInputs(fluid('potassium_chloride_solution') * 50)
.fluidOutputs(fluid('nitrate_solution') * 100)
.duration(5)
.EUt(30)
.buildAndRegister()

DISTILLERY.recipeBuilder()
.fluidInputs(fluid('nitrate_solution') * 2000)
.fluidOutputs(fluid('water') * 1000)
.outputs(ore('dustNitrateSaltMix').first() * 11)
.duration(300)
.EUt(30)
.buildAndRegister()

CENTRIFUGE.recipeBuilder()
.inputs(ore('dustNitrateSaltMix') * 11)
.outputs(ore('dustAmmoniumChloride').first() * 6)
.outputs(ore('dustSaltpeter').first() * 5)
.duration(200)
.EUt(30)
.buildAndRegister()

CSTR.recipeBuilder()
.fluidInputs(fluid('nitric_acid') * 50)
.fluidInputs(fluid('potassium_hydroxide_solution') * 50)
.fluidOutputs(fluid('saltpeter_solution') * 100)
.duration(200)
.EUt(30)
.buildAndRegister()

DISTILLERY.recipeBuilder()
.fluidInputs(fluid('saltpeter_solution') * 2000)
.fluidOutputs(fluid('water') * 1000)
.outputs(ore('dustSaltpeter').first() * 5)
.duration(300)
.EUt(30)
.buildAndRegister()

BR.recipeBuilder()
.fluidInputs(fluid('nitric_acid') *  1000)
.inputs(ore('dustSodiumHydroxide') * 3)
.fluidOutputs(fluid('sodium_nitrate_solution') * 1000)
.duration(160)
.EUt(30)
.buildAndRegister()

CSTR.recipeBuilder()
.fluidInputs(fluid('sodium_nitrate_solution') * 50)
.fluidInputs(fluid('potassium_chloride_solution') * 50)
.fluidOutputs(fluid('salty_saltpeter_solution') * 100)

DISTILLERY.recipeBuilder()
.fluidInputs(fluid('salty_saltpeter_solution') * 2000)
.fluidOutputs(fluid('salt_water') * 1000)
.outputs(ore('dustSaltpeter').first() * 5)
.duration(300)
.EUt(30)
.buildAndRegister()

// Molecular Sieves

BR.recipeBuilder()
.fluidInputs(fluid('sodium_hydroxide_solution') * 2000)
.fluidInputs(fluid('steam') * 1000)
.inputs(ore('dustSiliconDioxide') * 3)
.fluidOutputs(fluid('sodium_silicate_solution') * 4000)
.duration(200)
.EUt(30)
.buildAndRegister()

BR.recipeBuilder()
.fluidInputs(fluid('sodium_hydroxide_solution') * 2000)
.inputs(ore('dustAluminium') * 2)
.fluidOutputs(fluid('hydrogen') * 6000)
.outputs(ore('dustSodiumAluminate').first() * 8)
.duration(200)
.EUt(30)
.buildAndRegister()

AUTOCLAVE.recipeBuilder()
.fluidInputs(fluid('sodium_silicate_solution') * 4000)
.inputs(ore('dustSodiumAluminate') * 4)
.fluidOutputs(fluid('raw_molecular_sieve') * 4000)
.duration(180)
.EUt(30)
.buildAndRegister()

ROASTER.recipeBuilder()
.fluidInputs(fluid('raw_molecular_sieve') * 4000)
.outputs(ore('dustMolecularSieve').first() * 10)
.duration(400)
.EUt(30)
.buildAndRegister()

ALLOY_SMELTER.recipeBuilder()
        .inputs(ore('dustMolecularSieve').first() * 1)
        .inputs(metaitem('dustClay') * 1)
        .outputs(metaitem('cracking_catalyst') * 1)
        .duration(100)
        .EUt(60)
        .buildAndRegister()

// Nitrobenzene

CSTR.recipeBuilder()
.fluidInputs(fluid('distilled_water') * 50)
.fluidInputs(fluid('nitration_mixture') * 100)
.fluidInputs(fluid('benzene') * 250)
.fluidOutputs(fluid('nitrobenzene') * 250)
.fluidOutputs(fluid('diluted_sulfuric_acid') * 100)
.duration(8)
.EUt(480)
.buildAndRegister()

//Glyceryl Trinitrate

BR.recipeBuilder()
        .fluidInputs(fluid('glycerol') * 1000)
        .fluidInputs(fluid('nitration_mixture') * 6000)
        .fluidOutputs(fluid('glyceryl_trinitrate') * 1000)
        .fluidOutputs(fluid('diluted_sulfuric_acid') * 6000)
        .duration(100)
        .EUt(30)
        .buildAndRegister()

// PTFE

MIXER.recipeBuilder()
.fluidInputs(fluid('tetrafluoroethylene') * 1000)
.fluidInputs(fluid('water') * 1000)
.fluidInputs(fluid('gtfo_sodium_stearate') * 100)
.fluidOutputs(fluid('tetrafluoroethylene_emulsion') * 2000)
.duration(200)
.EUt(30)
.buildAndRegister()

POLYMERIZATION.recipeBuilder()
.fluidInputs(fluid('tetrafluoroethylene_emulsion') * 1000)
.inputs(ore('dustPotassiumPersulfate'))
.fluidOutputs(fluid('polytetrafluoroethylene_solution') * 2000)
.duration(300)
.EUt(60)
.buildAndRegister()

DRYER.recipeBuilder()
.fluidInputs(fluid('polytetrafluoroethylene_solution') * 2000)
.outputs(ore('dustPolytetrafluoroethylene').first() * 7)
.duration(260)
.EUt(30)
.buildAndRegister()

// Vinyl Chloride

CSTR.recipeBuilder()
.fluidInputs(fluid('chlorine') * 100)
.fluidInputs(fluid('ethylene') * 50)
.fluidOutputs(fluid('vinyl_chloride') * 50)
.fluidOutputs(fluid('hydrogen_chloride') * 50)
.duration(5)
.EUt(30)
.buildAndRegister()

CSTR.recipeBuilder()
.fluidInputs(fluid('ethylene') * 50)
.fluidInputs(fluid('hydrogen_chloride') * 50)
.fluidInputs(fluid('oxygen') * 50)
.fluidOutputs(fluid('vinyl_chloride') * 50)
.fluidOutputs(fluid('water') * 50)
.duration(10)
.EUt(30)
.buildAndRegister()

CSTR.recipeBuilder()
.fluidInputs(fluid('ethane') * 50)
.fluidInputs(fluid('chlorine') * 200)
.fluidOutputs(fluid('vinyl_chloride') * 50)
.fluidOutputs(fluid('hydrogen_chloride') * 150)
.duration(10)
.EUt(30)
.buildAndRegister()

CSTR.recipeBuilder()
.fluidInputs(fluid('ethane') * 50)
.fluidInputs(fluid('hydrogen_chloride') * 50)
.fluidInputs(fluid('oxygen') * 100)
.fluidOutputs(fluid('vinyl_chloride') * 50)
.fluidOutputs(fluid('water') * 100)
.duration(10)
.EUt(30)
.buildAndRegister()

// PVC

MIXER.recipeBuilder()
.fluidInputs(fluid('vinyl_chloride') * 1000)
.fluidInputs(fluid('water') * 1000)
.fluidOutputs(fluid('vinyl_chloride_solution') * 2000)
.duration(160)
.EUt(30)
.buildAndRegister()

POLYMERIZATION.recipeBuilder()
.fluidInputs(fluid('vinyl_chloride_solution') * 2000)
.inputs(ore('dustPotassiumPersulfate'))
.fluidOutputs(fluid('polyvinyl_chloride_solution') * 2000)
.duration(300)
.EUt(60)
.buildAndRegister()

DRYER.recipeBuilder()
.fluidInputs(fluid('polyvinyl_chloride_solution') * 2000)
.outputs(ore('dustPolyvinylChloride').first() * 7)
.duration(260)
.EUt(30)
.buildAndRegister()

// Polysterene

MIXER.recipeBuilder()
.fluidInputs(fluid('styrene') * 1000)
.fluidInputs(fluid('water') * 1000)
.fluidOutputs(fluid('styrene_solution') * 2000)
.duration(200)
.EUt(30)
.buildAndRegister()

POLYMERIZATION.recipeBuilder()
.fluidInputs(fluid('styrene_solution') * 2000)
.inputs(ore('dustPotassiumPersulfate'))
.fluidOutputs(fluid('polystyrene_solution') * 2000)
.duration(300)
.EUt(60)
.buildAndRegister()

DRYER.recipeBuilder()
.fluidInputs(fluid('polystyrene_solution') * 2000)
.outputs(ore('dustPolystyrene').first() * 7)
.duration(260)
.EUt(30)
.buildAndRegister()

// Polyvinyl Acetate

MIXER.recipeBuilder()
.fluidInputs(fluid('vinyl_acetate') * 1000)
.fluidInputs(fluid('methanol') * 1000)
.fluidOutputs(fluid('vinyl_acetate_solution') * 1000)
.duration(200)
.EUt(30)
.buildAndRegister()

POLYMERIZATION.recipeBuilder()
.fluidInputs(fluid('vinyl_acetate_solution') * 2000)
.inputs(ore('dustPotassiumPersulfate'))
.fluidOutputs(fluid('polyvinyl_acetate_solution') * 2000)
.duration(300)
.EUt(60)
.buildAndRegister()

DRYER.recipeBuilder()
.fluidInputs(fluid('polyvinyl_acetate_solution') * 2000)
.outputs(ore('dustPolyvinylAcetate').first() * 7)
.fluidOutputs(fluid('methanol') * 1000)
.duration(260)
.EUt(30)
.buildAndRegister()

// Polyethylene

POLYMERIZATION.recipeBuilder()
.fluidInputs(fluid('ethylene') * 144)
.fluidInputs(fluid('oxygen') * 1000)
.fluidOutputs(fluid('plastic') * 216)
.EUt(30)
.duration(160)
.buildAndRegister()

// Allyl Chloride

CSTR.recipeBuilder()
.fluidInputs(fluid('chlorine') * 100)
.fluidInputs(fluid('propene') * 50)
.fluidOutputs(fluid('hydrogen_chloride') * 50)
.fluidOutputs(fluid('allyl_chloride') * 50)
.duration(8)
.EUt(30)
.buildAndRegister()

// Monochloramine

CSTR.recipeBuilder()
.fluidInputs(fluid('sodium_hydroxide_solution') * 100)
.fluidInputs(fluid('chlorine') * 100)
.fluidOutputs(fluid('impure_bleach') * 200)
.duration(10)
.EUt(30)
.buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
.fluidInputs(fluid('impure_bleach') * 4000)
.fluidOutputs(fluid('water') * 3000)
.fluidOutputs(fluid('bleach') * 1000)
.outputs(ore('dustSalt').first() * 2)
.duration(300)
.EUt(30)
.buildAndRegister()

BR.recipeBuilder()
.fluidInputs(fluid('bleach') * 1000)
.fluidInputs(fluid('ammonia') * 1000)
.fluidOutputs(fluid('monochloramine') * 1000)
.outputs(ore('dustSodiumHydroxide').first() * 3)
.duration(200)
.EUt(30)
.buildAndRegister()

// Dichlorbenzene

FBR.recipeBuilder()
.fluidInputs(fluid('toluene') * 50)
.fluidInputs(fluid('chlorobenzene') * 50)
.fluidInputs(fluid('chlorine') * 100)
.notConsumable(ore('dustIronIiiChloride'))
.fluidOutputs(fluid('mixed_dichlorobenzene_solution') * 50)
.fluidOutputs(fluid('hydrogen_chloride') * 50)
.duration(5)
.EUt(30)
.buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
.fluidInputs(fluid('mixed_dichlorobenzene_solution') * 1000)
.fluidOutputs(fluid('chlorobenzene') * 100)
.fluidOutputs(fluid('one_four_dichlorobenzene_solution') * 600)
.fluidOutputs(fluid('one_two_dichlorobenzene_solution') * 400)
.duration(300)
.EUt(30)
.buildAndRegister()

DISTILLERY.recipeBuilder()
.fluidInputs(fluid('one_four_dichlorobenzene_solution') * 1000)
.fluidOutputs(fluid('toluene') * 1000)
.outputs(ore('dustDichlorobenzene').first() * 12)
.duration(300)
.EUt(30)
.buildAndRegister()

DISTILLERY.recipeBuilder()
.fluidInputs(fluid('one_two_dichlorobenzene_solution') * 1000)
.fluidOutputs(fluid('toluene') * 1000)
.outputs(ore('dustOneTwoDichlorobenzene').first() * 12)
.duration(300)
.EUt(30)
.buildAndRegister()

//styrene butadiene rubber

SIFTER.recipeBuilder()
.fluidInputs(fluid('ethanol') * 1000)
.inputs(ore('dustMolecularSieve')* 4)
.fluidOutputs(fluid('dry_ethanol') * 1000)
.outputs(ore('dustWetMolecularSieve').first() * 4) //im not too sure about this recipe?
.EUt(30)
.duration(450)
.buildAndRegister()

MIXER.recipeBuilder()
.fluidInputs(fluid('styrene') * 1000)
.fluidInputs(fluid('butadiene') * 1000)
.fluidInputs(fluid('dry_ethanol') * 1000)
.fluidOutputs(fluid('styrene_butadiene_solution') * 3000)
.EUt(60)
.duration(450)
.buildAndRegister()

POLYMERIZATION.recipeBuilder()
.fluidInputs(fluid('styrene_butadiene_solution') * 3000)
.fluidInputs(fluid('butyllithium') * 100)
.fluidOutputs(fluid('polymerized_styrene_butadiene_solution') * 3000)
.EUt(120)
.duration(1200)
.buildAndRegister()

DRYER.recipeBuilder()
.fluidInputs(fluid('polymerized_styrene_butadiene_solution') * 3000)
.fluidOutputs(fluid('ethanol') * 1000)
.outputs(ore('dustRawStyreneButadieneRubber').first() * 16)
.EUt(120)
.duration(600)
.buildAndRegister()


//acetylene

EBF.recipeBuilder()
.inputs(ore('dustQuicklime') * 2)
.inputs(ore('dustCarbon') * 3)
.outputs(ore('dustCalciumCarbide').first() * 3)
.fluidOutputs(fluid('carbon_monoxide') * 1000)
.EUt(120)
.duration(600)
.buildAndRegister()

BR.recipeBuilder()
.inputs(ore('dustCalciumCarbide') * 3)
.fluidInputs(fluid('water') * 2000)
.outputs(ore('dustCalciumHydroxide').first() * 5)
.fluidOutputs(fluid('acetylene') * 1000)
.EUt(30)
.duration(120)
.buildAndRegister()

//ammonium nitrate

BCR.recipeBuilder()
.fluidInputs(fluid('nitric_acid') * 50)
.fluidInputs(fluid('ammonia') * 50)
.fluidOutputs(fluid('ammonium_nitrate_solution') * 50)
.EUt(30)
.duration(10)
.buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
.fluidInputs(fluid('ammonium_nitrate_solution') * 1000)
.outputs(ore('dustAmmoniumNitrate').first() * 2)
.fluidOutputs(fluid('water') * 1000)
.EUt(90)
.duration(300)
.buildAndRegister()

//1,2-dichloroethane

FBR.recipeBuilder()
.fluidInputs(fluid('chlorine') * 100)
.fluidInputs(fluid('ethylene') * 50)
.notConsumable(ore('catalystBedIronIiiOxide'))
.fluidOutputs(fluid('dichloroethane') * 50)
.EUt(30)
.duration(10)
.buildAndRegister()

FBR.recipeBuilder()
.fluidInputs(fluid('ethylene') * 50)
.fluidInputs(fluid('hydrochloric_acid') * 100)
.fluidInputs(fluid('oxygen') * 50)
.notConsumable(ore('catalystBedCopperIiChloride'))
.fluidOutputs(fluid('diluted_dichloroethane') * 200)
.EUt(30)
.duration(10)
.buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
.fluidInputs(fluid('diluted_dichloroethane') * 4000)
.fluidOutputs(fluid('water') * 3000)
.fluidOutputs(fluid('dichloroethane') * 1000)
.EUt(90)
.duration(600)
.buildAndRegister()

//tri/methyl/dimethylamine

FLUIDIZEDBR.recipeBuilder()
.fluidInputs(fluid('methanol') * 300)
.fluidInputs(fluid('ammonia') * 150)
.notConsumable(ore('dustAluminium')) //replace with pregnant catalyst
.fluidOutputs(fluid('methylamine_mix') * 450)
.EUt(120)
.duration(8)
.buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
.fluidInputs(fluid('methylamine_mix') * 9000)
.fluidOutputs(fluid('water') * 6000)
.fluidOutputs(fluid('trimethylamine') * 1000)
.fluidOutputs(fluid('dimethylamine') * 1000)
.fluidOutputs(fluid('methylamine') * 1000)
.EUt(90)
.duration(1200)
.buildAndRegister()

//1,4-butanediol

FBR.recipeBuilder()
.fluidInputs(fluid('formaldehyde') * 100)
.fluidInputs(fluid('acetylene') * 50)
.notConsumable(ore('dustBismuthBronze')) //replace with bismuth-copper catalyst bed
.fluidOutputs(fluid('butynediol') * 50)
.EUt(30)
.duration(10)
.buildAndRegister()

TBR.recipeBuilder()
.fluidInputs(fluid('butynediol') * 50)
.fluidInputs(fluid('hydrogen') * 200)
.notConsumable(ore('dustNickel')) //replace with raney nickel catalyst
.fluidOutputs(fluid('butanediol') * 50)
.EUt(30)
.duration(10)
.buildAndRegister()

//formaldehyde

FBR.recipeBuilder()
.fluidInputs(fluid('methanol') * 100)
.fluidInputs(fluid('oxygen') * 100)
.notConsumable(ore('catalystBedIronIiiOxide'))
.fluidOutputs(fluid('formaldehyde') * 100)
.fluidOutputs(fluid('water') * 100)
.EUt(30)
.duration(10)
.buildAndRegister()

//gamma-Butyrolactone

FBR.recipeBuilder()
.fluidInputs(fluid('butanediol') * 50)
.notConsumable(ore('catalystBedCopper') * 1)
.fluidOutputs(fluid('gamma_butyrolactone') * 50)
.fluidOutputs(fluid('hydrogen') * 200)
.EUt(30)
.duration(10)
.buildAndRegister()

//N-methyl-2-pyrrolidone

CSTR.recipeBuilder()
.fluidInputs(fluid('gamma_butyrolactone') * 50)
.fluidInputs(fluid('methylamine') * 50)
.fluidOutputs(fluid('diluted_methyl_ii_pyrrolidone') * 100)
.EUt(30)
.duration(10)
.buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
.fluidInputs(fluid('diluted_methyl_ii_pyrrolidone') * 2000)
.fluidOutputs(fluid('water') * 1000)
.fluidOutputs(fluid('n_methyl_ii_pyrrolidone') * 1000)
.EUt(90)
.duration(450)
.buildAndRegister()

//1-bromobutane

CSTR.recipeBuilder()
.fluidInputs(fluid('hydrogen_bromide') * 50)
.fluidInputs(fluid('butanol') * 50)
.fluidOutputs(fluid('diluted_bromobutane') * 100)
.EUt(30)
.duration(10)
.buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
        .fluidInputs(fluid('diluted_bromobutane') * 2000)
        .fluidOutputs(fluid('water') * 1000)
        .fluidOutputs(fluid('bromobutane') * 1000)
        .EUt(30)
        .duration(100)
        .buildAndRegister()

//n-butyllithium

MIXER.recipeBuilder()
.inputs(ore('dustLithium') * 2)
.fluidInputs(fluid('diethyl_ether') * 1000)
.fluidOutputs(fluid('lithium_solution') * 1000)
.EUt(30)
.duration(320)
.buildAndRegister()

BR.recipeBuilder()
.fluidInputs(fluid('lithium_solution') * 1000)
.fluidInputs(fluid('bromobutane') * 1000)
.fluidOutputs(fluid('diluted_butyllithium') * 2000)
.outputs(ore('dustLithiumBromide').first() * 2)
.EUt(30)
.duration(300)
.buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
.fluidInputs(fluid('diluted_butyllithium') * 2000)
.fluidOutputs(fluid('diethyl_ether') * 1000)
.fluidOutputs(fluid('butyllithium') * 1000)
.EUt(90)
.duration(360)
.buildAndRegister()


    
//diethyl ether

CSTR.recipeBuilder()
.fluidInputs(fluid('ethanol') * 100)
.fluidInputs(fluid('sulfuric_acid') * 50)
.fluidOutputs(fluid('diethyl_ether_solution') * 150)
.EUt(30)
.duration(5)
.buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
.fluidInputs(fluid('diethyl_ether_solution') * 3000)
.fluidOutputs(fluid('diethyl_ether') * 1000)
.fluidOutputs(fluid('water') * 1000)
.fluidOutputs(fluid('sulfuric_acid') * 1000)
.EUt(90)
.duration(600)
.buildAndRegister()

//useful reactions

BR.recipeBuilder()
.fluidInputs(fluid('calcium_hydroxide_solution') * 1000)
.inputs(ore('dustPotassiumCarbonate') * 6)
.fluidOutputs(fluid('potassium_hydroxide_solution') * 1000)
.outputs(ore('dustCalcite').first() *  5)
.EUt(30)
.duration(200)
.buildAndRegister()

BR.recipeBuilder()
.inputs(ore('dustPotassiumHydroxide') * 3)
.fluidInputs(fluid('hydrochloric_acid')* 1000)
.fluidOutputs(fluid('dilute_rock_salt_solution') * 2000)
.EUt(30)
.duration(160)
.buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
.fluidInputs(fluid('dilute_rock_salt_solution') * 2000)
.fluidOutputs(fluid('water') * 1000)
.fluidOutputs(fluid('potassium_chloride_solution') * 1000)
.EUt(16)
.duration(60)
.buildAndRegister()

DISTILLERY.recipeBuilder()
.fluidInputs(fluid('potassium_chloride_solution') * 1000)
.fluidOutputs(fluid('water') * 1000)
.outputs(ore('dustRockSalt').first() * 2)
.EUt(16)
.duration(60)
.buildAndRegister()

CSTR.recipeBuilder()
.fluidInputs(fluid('potassium_hydroxide_solution') * 100)
.fluidInputs(fluid('carbon_dioxide') * 50)
.fluidOutputs(fluid('dilute_potassium_carbonate_solution') * 150)
.EUt(30)
.duration(15)
.buildAndRegister()

DISTILLERY.recipeBuilder()
.fluidInputs(fluid('dilute_potassium_carbonate_solution') * 3000)
.outputs(ore('dustPotassiumCarbonate').first() * 6)
.fluidOutputs(fluid('water') * 3000)
.EUt(30)
.duration(400)
.buildAndRegister()

BR.recipeBuilder()
.fluidInputs(fluid('ammonium_chloride_solution') * 2000)
.inputs(ore('dustCalciumHydroxide') * 5)
.fluidOutputs(fluid('ammonia') * 2000)
.fluidOutputs(fluid('dilute_calcium_chloride_solution') * 2000)
.EUt(30)
.duration(360)
.buildAndRegister()

DISTILLERY.recipeBuilder()
.fluidInputs(fluid('dilute_calcium_chloride_solution') * 2000)
.fluidOutputs(fluid('water') * 2000)
.outputs(ore('dustCalciumChloride').first() * 3)
.EUt(30)
.duration(100)
.buildAndRegister()

//Silicon

ARC_FURNACE.recipeBuilder()
        .inputs(ore('dustSiliconDioxide') * 3)
        .inputs(ore('dustCoke') * 1)
        .outputs(ore('dustSilicon').first() * 1)
        .fluidOutputs(fluid('carbon_monoxide') * 2000)
        .EUt(30)
        .duration(300)
        .buildAndRegister()

ARC_FURNACE.recipeBuilder()
        .inputs(ore('dustQuartzite') * 3)
        .inputs(ore('dustCoke') * 1)
        .outputs(ore('dustSilicon').first() * 1)
        .fluidOutputs(fluid('carbon_monoxide') * 2000)
        .EUt(30)
        .duration(300)
        .buildAndRegister()

ARC_FURNACE.recipeBuilder()
        .inputs(ore('dustCertusQuartz') * 3)
        .inputs(ore('dustCoke') * 1)
        .outputs(ore('dustSilicon').first() * 1)
        .fluidOutputs(fluid('carbon_monoxide') * 2000)
        .EUt(30)
        .duration(300)
        .buildAndRegister()

ARC_FURNACE.recipeBuilder()
        .inputs(ore('dustNetherQuartz') * 3)
        .inputs(ore('dustCoke') * 1)
        .outputs(ore('dustSilicon').first() * 1)
        .fluidOutputs(fluid('carbon_monoxide') * 2000)
        .EUt(30)
        .duration(300)
        .buildAndRegister()

/*
//TODO: Make it so that integrated circuit can be used to choose between silicon or silicon carbide. increase arc furnace slots to 4

//Graphite

ARC_FURNACE.recipeBuilder()
.inputs(ore('dustSiliconDioxide') * 3)
.inputs(ore('dustCoke') * 3)
.outputs(ore('dustSiliconCarbide').first() * 2)
.fluidOutputs(fluid('carbon_monoxide') * 2000)
.EUt(45)
.duration(300)
.buildAndRegister()

ARC_FURNACE.recipeBuilder()
.inputs(ore('dustSiliconCarbide') * 2)
.outputs(ore('dustSilicon').first())
.outputs(ore('dustGraphite').first())
.EUt(45)
.duration(270)
.buildAndRegister()

 */

// Distilled Water

DISTILLERY.recipeBuilder()
.fluidInputs(fluid('water') * 288)
.notConsumable(circuit(1))
.fluidOutputs(fluid('distilled_water') * 260)
.duration(160)
.EUt(Globals.voltAmps[1])
.buildAndRegister()