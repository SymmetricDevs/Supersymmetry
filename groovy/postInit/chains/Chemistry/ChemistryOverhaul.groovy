import static globals.Globals.*

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;


CSTR = recipemap('continuous_stirred_tank_reactor')
TBR = recipemap('trickle_bed_reactor')
FBR = recipemap('fixed_bed_reactor')
BCR = recipemap('bubble_column_reactor')
CRYSTALLIZER = recipemap('crystallizer')
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

def COAL_SOURCES = [
    "dustCarbon",
    "gemCoal",
    "dustCoal",
    "gemCharcoal",
    "dustCoke",
    "gemCoke",
    "dustCharcoal"
]

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
// TODO: catalyst
FBR.recipeBuilder()
.fluidInputs(fluid('ethylbenzene') * 50)
.fluidInputs(fluid('steam') * 50)
.notConsumable(ore('dustBandedIron'))
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

MIXER.recipeBuilder()
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

MIXER.recipeBuilder()
.inputs(ore('dustFluorite') * 3)
.fluidInputs(fluid('sulfuric_acid') * 1000)
.fluidOutputs(fluid('hydrogen_fluoride') * 2000)
.outputs(ore('dustCalciumSulfate').first() * 6)
.duration(30)
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

MIXER.recipeBuilder()
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
.fluidOutputs(fluid('hydrogen_chloride') * 1000)
.fluidOutputs(fluid('steam') * 1000)
.outputs(ore('dustSodiumSulfate').first())
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

MIXER.recipeBuilder()
.fluidInputs(fluid('sulfuric_acid') * 1000)
.inputs(ore('dustSaltpeter') * 5)
.fluidOutputs(fluid('nitric_acid') * 1000)
.outputs(ore('dustPotassiumBisulfate').first() * 7)
.duration(60)
.EUt(30)
.buildAndRegister()

//TODO: molten potassium bisulfate

// Sodium Sulfide

ROASTER.recipeBuilder()
.inputs(ore('dustSodiumSulfate') * 7)
.inputs(ore('dustCarbon') * 2)
.fluidOutputs(fluid('carbon_dioxide') * 4000)
.outputs(ore('dustSodiumSulfide').first() * 3)
.duration(60)
.EUt(30)
.buildAndRegister()

// Antimony trifluoride

MIXER.recipeBuilder()
.fluidInputs(fluid('hydrofluoric_acid') * 6000)
.inputs(ore('dustAntimonyTrioxide') * 5)
.outputs(ore('dustWetAntimonyTrifluoride').first() * 8)
.duration(60)
.EUt(30)
.buildAndRegister()

DRYER.recipeBuilder()
.inputs(ore('dustWetAntimonyTrifluoride'))
.fluidOutputs(fluid('steam') * 3000)
.outputs(ore('dustAntimonyTrifluoride').first())
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
//TODO: Remove EBF Recipe
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
//TODO: molten calcium chloride can be electrolyzed in a Downs cell (gaming[gaming]) 

// Soda Ash 
    
    // Leblanc process

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
.outputs(ore('dustSodiumSulfide').first() * 2)
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
//TODO: Replace with platinum catalyst bed
FBR.recipeBuilder()
.fluidInputs(fluid('ethylene') * 100)
.fluidInputs(fluid('oxygen') * 100)
.fluidOutputs(fluid('gtfo_acetaldehyde') * 100)
.duration(5)
.EUt(30)
.buildAndRegister()
//TODO: Replace with cobalt catalyst bed
FBR.recipeBuilder()
.fluidInputs(fluid('gtfo_acetaldehyde') * 100)
.fluidInputs(fluid('oxygen') * 100)
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
//TODO: Solid Phosphoric Acid Catalyst Tray
FBR.recipeBuilder()
.fluidInputs(fluid('hp_propene') * 50)
.fluidInputs(fluid('hp_benzene') * 50)
.notConsumable(fluid('phosphoric_acid'))
.fluidOutputs(fluid('cumene') * 50)
.duration(5)
.EUt(30)
.buildAndRegister()

// Ethylene

CSTR.recipeBuilder()
.fluidInputs(fluid('sulfuric_acid') * 100)
.fluidInputs(fluid('ethanol') * 100)
.fluidOutputs(fluid('ethylene') * 100)
.fluidOutputs(fluid('diluted_sulfuric_acid') * 150)
.duration(5)
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
//TODO: IDFK Think of a fucking solution lol
// MIXER.recipeBuilder()
// .fluidInputs(fluid('acidic_tetrafluoroethylene') * 5000)
// .fluidInputs(fluid('water') * 4000)
// .fluidOutputs(fluid('tetrafluoroethylene') * 1000)
// .fluidOutputs(fluid('hydrochloric_acid') * 4000)
// .duration(200)
// .EUt(30)
// .buildAndRegister()

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