PHASE_SEPARATOR = recipemap('phase_separator')
MIXER = recipemap('mixer')
FLUID_HEATER = recipemap('fluid_heater')
CENTRIFUGE = recipemap('centrifuge')
SIFTER = recipemap('sifter')
DRYER = recipemap('dryer')
VACUUM_CHAMBER = recipemap('vacuum_chamber')
PSA = recipemap('pressure_swing_adsorption')
BR = recipemap('batch_reactor')
BCR = recipemap('bubble_column_reactor')
TBR = recipemap('trickle_bed_reactor')
DT = recipemap('distillation_tower')
SIEVE_DT = recipemap('sieve_distillation')

class Lipid {

    String name
    int eqMultiplier

    Lipid(String name, int eqMultiplier = 1) {
        this.name = name
        this.eqMultiplier = eqMultiplier
    }

    def get(int amount = 1000) {
        return fluid(this.name) * (amount * this.eqMultiplier)
    }

}

class Alcohol {

    String name
    String group_name

    Alcohol(String name) {
        this.name = name
        this.group_name = this.name.replace('anol', 'yl')
    }

    def get(int amount = 1000) {
        return fluid(this.name) * amount
    }

    def getGlycerolSolution(int amount = 1000) {
        return fluid("glycerol_${this.name}_solution") * amount
    }

    def getCrudeEster(int amount = 1000) {
        return fluid("crude_fatty_acid_${this.group_name}_ester") * amount
    }

    def getNeutralizedEster(int amount = 1000) {
        return fluid("neutralized_fatty_acid_${this.group_name}_ester") * amount
    }

}

grade1Lipids = [
    new Lipid('gtfo_olive_oil'),
    //    new Lipid('palm_oil'),
    new Lipid('gtfo_soybean_oil'),
    new Lipid('coconut_oil'),
    new Lipid('seed_oil'),
    new Lipid('deacidified_lipid')
]

grade2Lipids = [
    new Lipid('fish_oil'),
    new Lipid('gtfo_stearin')
]

alcohols = [
    new Alcohol('methanol'),
    new Alcohol('ethanol')
]

// tick per bucket of biodiesel
int tpbb = 12

// -------- Grade 2 Lipids -> Grade 1 Lipids --------
// Via Distillation, Neutralization, or Esterification.
// First 2 methods are lossy but fast, while esterification is slower.
// Let's assume they have 10% fatty acid content.
grade2Lipids.forEach { lipid ->
    // Distillation
    DT.recipeBuilder()
        .fluidInputs(lipid.get())
        .fluidOutputs(fluid('deacidified_lipid') * 900)
        .fluidOutputs(fluid('stearic_acid') * 100)
        .duration(50)
        .EUt(30)
        .buildAndRegister()

    // Neutralization
    MIXER.recipeBuilder()
        .fluidInputs(lipid.get())
        .fluidInputs(fluid('diluted_sodium_hydroxide_solution') * 100)
        .fluidOutputs(fluid('deacidified_lipid') * 900)
        .fluidOutputs(fluid('gtfo_sodium_stearate') * 100)
        .duration(15)
        .EUt(7)
        .buildAndRegister()

    // Esterification
    BR.recipeBuilder()
        .fluidInputs(lipid.get())
        .fluidInputs(fluid('glycerol') * 100)
        .notConsumable(fluid('sulfuric_acid') * 1000)
        .fluidOutputs(fluid('deacidified_lipid') * 1000)
        .duration(120)
        .EUt(120)
        .buildAndRegister()
}

// -------- Bio Diesel Chain --------
alcohols.forEach { alcohol ->
    // Catalytic transesterification
    grade1Lipids.forEach { lipid ->
        BR.recipeBuilder()
        .inputs(ore('dustSodiumHydroxide'))
        .fluidInputs(lipid.get())
        .fluidInputs(alcohol.get(6000)) // Optimal condition of 6 eq. alcohol
        .fluidOutputs(alcohol.getGlycerolSolution(3500))
        .fluidOutputs(alcohol.getCrudeEster(3500))
        .duration(tpbb * 3)
        .EUt(30)
        .buildAndRegister()
    }

    // Vacuum Flash Distillation of Glycerol Solutions
    VACUUM_CHAMBER.recipeBuilder()
        .fluidInputs(fluid('diluted_hydrochloric_acid') * 1000)
        .fluidInputs(alcohol.getGlycerolSolution(7000))
        .fluidOutputs(fluid('crude_glycerol') * 3000)
        .fluidOutputs(alcohol.get(5000))
        .duration(60)
        .EUt(30)
        .buildAndRegister()
}
    // Distillation of Crude Glycerol
    DT.recipeBuilder()
        .fluidInputs(fluid('crude_glycerol') * 3000)
        .outputs(metaitem('dustSalt'))
        .fluidOutputs(fluid('glycerol') * 2000)
        .fluidOutputs(fluid('water') * 1000)
        .duration(20)
        .EUt(30)
        .buildAndRegister()

alcohols.forEach { alcohol ->
    // Neutralization of Crude FAXEs
    MIXER.recipeBuilder()
        .fluidInputs(fluid('diluted_hydrochloric_acid') * 1000)
        .fluidInputs(alcohol.getCrudeEster(3500))
        .fluidOutputs(alcohol.getNeutralizedEster(3500))
        .fluidOutputs(fluid('diluted_salt_water') * 1000)
        .duration(30)
        .EUt(7)
        .buildAndRegister()

    // Distillation of Neutralized FAXEs
    DT.recipeBuilder()
        .fluidInputs(alcohol.getNeutralizedEster(3500))
        .fluidOutputs(fluid('unscrubbed_bio_diesel') * 3000)
        .fluidOutputs(alcohol.get(500))
        .duration(tpbb * 3)
        .EUt(30)
        .buildAndRegister()
}
    // Washing of Bio Diesel with heated water
    MIXER.recipeBuilder()
        .fluidInputs(fluid('gtfo_heated_water') * 1000)
        .fluidInputs(fluid('unscrubbed_bio_diesel') * 3000)
        .fluidOutputs(fluid('wastewater') * 1000)
        .fluidOutputs(fluid('moist_bio_diesel') * 3000)
        .duration(tpbb * 3)
        .EUt(7)
        .buildAndRegister()

    // Drying
    DRYER.recipeBuilder()
        .fluidInputs(fluid('moist_bio_diesel') * 1000)
        .fluidOutputs(fluid('bio_diesel') * 1000)
        .duration(tpbb)
        .EUt(30)
        .buildAndRegister()

// tick per 1/4 bucket of n-paraffin
int tpbnp = 20

// -------- Green Diesel Chain --------
// Pretreatment to remove undesired pigments
// such as carotenoids and chlorophyll via decolorization
grade1Lipids.forEach { lipid ->
    MIXER.recipeBuilder()
        .inputs(ore('dustAluminiumSilicate'))
        .notConsumable(fluid('phosphoric_acid') * 500)
        .fluidInputs(lipid.get())
        .fluidOutputs(fluid('bleaching_lipid_mix') * 1000)
        .duration(120)
        .EUt(30)
        .buildAndRegister()
}
// Separation of Al2SiO5
SIFTER.recipeBuilder()
    .fluidInputs(fluid('bleaching_lipid_mix') * 1000)
    .outputs(metaitem('dustAluminiumSilicate'))
    .fluidOutputs(fluid('bleached_lipid') * 1000)
    .duration(20)
    .EUt(30)
    .buildAndRegister()

// Preheat the bleached lipid for the hydrotreating process
FLUID_HEATER.recipeBuilder()
    .fluidInputs(fluid('bleached_lipid') * 1000)
    .fluidOutputs(fluid('heated_lipid') * 1000)
    .duration(30)
    .EUt(30)
    .buildAndRegister()

// Hydrotreating heated lipid
TBR.recipeBuilder()
    .fluidInputs(fluid('heated_lipid') * 250)
    .fluidInputs(fluid('hydrogen') * 8000)
    .notConsumable(ore('dustHydrotreatingCatalyst')) // Since molybdenum is EV
    .fluidOutputs(fluid('hydrotreated_lipid_mixture') * 7000)
    .duration(tpbnp)
    .EUt(120)
    .buildAndRegister()

// Separating out water & gases
PHASE_SEPARATOR.recipeBuilder()
    .fluidInputs(fluid('hydrotreated_lipid_mixture') * 7000)
    .fluidOutputs(fluid('water') * 1500)
    .fluidOutputs(fluid('crude_n_paraffin') * 1000)
    .fluidOutputs(fluid('acidic_hydrogen_vapor') * 4500)
    .duration(50)
    .buildAndRegister()

// Hydrogen recycling
// The carbon dioxide in the gaseous phase is formed via decarboxylation
// You can use either PSA or NaOH solution
PSA.recipeBuilder()
    .notConsumable(ore('dustMolecularSieve') * 5)
    .fluidInputs(fluid('acidic_hydrogen_vapor') * 9000)
    .fluidOutputs(fluid('hydrogen') * 8000)
    .fluidOutputs(fluid('carbon_dioxide') * 1000)
    .duration(20)
    .EUt(120)
    .buildAndRegister()

// Using the same number as the one uses pure CO2
BCR.recipeBuilder()
    .fluidInputs(fluid('acidic_hydrogen_vapor') * 450)
    .fluidInputs(fluid('sodium_hydroxide_solution') * 100)
    .fluidOutputs(fluid('diluted_sodium_carbonate_solution') * 150)
    .fluidOutputs(fluid('hydrogen') * 400)
    .duration(4)
    .EUt(30)
    .buildAndRegister()

// Neutralize unreacted fatty acids in the crude n-paraffin
// Let's assume there are 5% of them
// This won't, however, reduce overall conversion rate, for number-balancing reasons
MIXER.recipeBuilder()
    .fluidInputs(fluid('sodium_hydroxide_solution') * 50)
    .fluidInputs(fluid('crude_n_paraffin') * 1000)
    .fluidOutputs(fluid('gtfo_sodium_stearate') * 50)
    .fluidOutputs(fluid('neutralized_n_paraffin') * 1000)
    .duration(20)
    .EUt(30)
    .buildAndRegister()

// Separation & hydroisomerization of hydrocarbons in the paraffin
// IRL the ratio of fractions is highly related to the catalyst, temperature,
// and the composition of the feedstock. I just choose a random ratio here:
// 25% propane, 6.25% naphtha, 18.75% bio-jet fuel (which is basically green kerosene), and 50% green diesel.

// First fraction distillation, removing light ends
SIEVE_DT.recipeBuilder()
    .fluidInputs(fluid('neutralized_n_paraffin') * 2000)
    .fluidOutputs(fluid('distilled_n_paraffin') * 1375)
    .fluidOutputs(fluid('naphtha') * 125)
    .fluidOutputs(fluid('propane') * 500)
    .duration(tpbnp * 8)
    .EUt(30)
    .buildAndRegister()

// Hydroisomerization of the remaining n-paraffin, to improve the cold flow properties
// 20% Hydrogen is lost in this step              ↑ copilot actually knows the reason wtf
TBR.recipeBuilder()
    .notConsumable(ore('dustSulfatedMetalOxide')) // Since molybdenum is EV
    .fluidInputs(fluid('hydrogen') * 500)
    .fluidInputs(fluid('distilled_n_paraffin') * 5500)
    .fluidOutputs(fluid('hydrogen') * 400)
    .fluidOutputs(fluid('isomerized_paraffin') * 5500)
    .duration(tpbnp * 32)
    .EUt(120)
    .buildAndRegister()

// Second fraction distillation
SIEVE_DT.recipeBuilder()
    .fluidInputs(fluid('isomerized_paraffin') * 1100)
    .fluidOutputs(fluid('diesel') * 800)
    .fluidOutputs(fluid('kerosene') * 300)
    .duration(tpbnp * 6)
    .EUt(30)
    .buildAndRegister()
