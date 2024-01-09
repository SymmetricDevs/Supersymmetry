import static globals.Globals.*
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
COKING = recipemap('coking_tower')
CSTR = recipemap('continuous_stirred_tank_reactor')
CRACKER = recipemap('cracker')
EBF = recipemap('electric_blast_furnace')
REFORMER = recipemap('catalytic_reformer_recipes')
REACTION_FURNACE = recipemap('reaction_furnace')
FBR = recipemap('fixed_bed_reactor')
SIFTER = recipemap('sifter')
ALLOY_SMELTER = recipemap('alloy_smelter')
BCR = recipemap('bubble_column_reactor')
TBR = recipemap('trickle_bed_reactor')
LCR = recipemap('large_chemical_reactor')
AUTOCLAVE = recipemap('autoclave')
HEAT_EXCHANGER = recipemap('heat_exchanger')
UV_LIGHT_BOX = recipemap('uv_light_box')

class Oil {
    String name

    Oil(String name) {
        this.name = name
    }
    
    def getDiluted(int amount) {
        return fluid('diluted_' + this.name) * amount
    }

    def getDesalted(int amount) {
        return fluid('desalted_' + this.name) * amount
    }

    def get(int amount) {
        return fluid(this.name) * amount
    }
}

class OilFraction {
    String name
    Boolean isUpgradable = false
    String upgrade_name = ""

    OilFraction(String name) {
        this.name = name
    }

    OilFraction(String name, String upgrade_name) {
        this.name = name
        this.isUpgradable = true
        this.upgrade_name = upgrade_name
    }

    def getTreatedSulfuric(int amount) {
        return fluid('treated_sulfuric_' + this.name) * amount
    }

    def getSulfuric(int amount) {
        return fluid('sulfuric_' + this.name) * amount
    }

    def getUpgraded(int amount) {
        return fluid(this.upgrade_name) * amount
    }

    def getUpgradedMix(int amount) {
        return fluid('upgraded_' + this.name + '_mix') * amount
    }

    def get(int amount) {
        return fluid(this.name) * amount
    }
}

class OilFractionCrackable extends OilFraction {

    OilFractionCrackable(String name){
        super(name)
    }

    OilFractionCrackable(String name, String upgrade_name){
        super(name, upgrade_name)
    }

    def getLightlyHydro(int amount) {
        return fluid('lightly_hydrocracked_' + this.name) * amount
    }

    def getSeverelyHydro(int amount) {
        return fluid('severely_hydrocracked_' + this.name) * amount
    }

    def getLightlySteam(int amount) {
        return fluid('lightly_steamcracked_' + this.name) * amount
    }

    def getSeverelySteam(int amount) {
        return fluid('severely_steamcracked_' + this.name) * amount
    }

    def getLightlyHydroMix(int amount) {
    return fluid('lightly_hydrocracked_' + this.name + '_mix') * amount
    }

    def getSeverelyHydroMix(int amount) {
        return fluid('severely_hydrocracked_' + this.name + '_mix') * amount
    }

    def getLightlySteamMix(int amount) {
        return fluid('lightly_steamcracked_' + this.name + '_mix') * amount
    }

    def getSeverelySteamMix(int amount) {
        return fluid('severely_steamcracked_' + this.name + '_mix') * amount
    }

}

def fractions = [
    fuel_oil : new OilFraction('fuel_oil', 'diesel'),
    diesel : new OilFraction('diesel', 'kerosene'),
    kerosene : new OilFractionCrackable('kerosene', 'naphtha'),
    naphtha : new OilFractionCrackable('naphtha', 'gasoline'),
    gasoline : new OilFractionCrackable('gasoline'),
    refinery_gas : new OilFraction('refinery_gas'),
    natural_gas : new OilFraction('natural_gas')
]

def oils = [
    oil: new Oil('oil'),
    oil_light: new Oil('oil_light'),
    oil_heavy: new Oil('oil_heavy') 
]



oils.each { _, oil -> {
        MIXER.recipeBuilder()
        .fluidInputs(fluid('water') * 100)
        .fluidInputs(oil.get(1000))
        .fluidOutputs(oil.getDiluted(1000))
        .duration(200)
        .EUt(30)
        .buildAndRegister()
    }
}

ELECTROSTATIC_SEPARATOR.recipeBuilder()
        .fluidInputs(fluid('diluted_oil') * 1000)
        .fluidOutputs(fluid('oily_brine') * 100)
        .fluidOutputs(fluid('desalted_oil') * 1000)
        .duration(160)
        .EUt(30)
        .buildAndRegister()

ELECTROSTATIC_SEPARATOR.recipeBuilder()
        .fluidInputs(fluid('diluted_oil_light') * 1000)
        .fluidOutputs(fluid('light_oily_brine') * 100)
        .fluidOutputs(fluid('desalted_oil_light') * 1000)
        .duration(160)
        .EUt(30)
        .buildAndRegister()

ELECTROSTATIC_SEPARATOR.recipeBuilder()
        .fluidInputs(fluid('diluted_oil_heavy') * 1000)
        .fluidOutputs(fluid('heavy_oily_brine') * 100)
        .fluidOutputs(fluid('desalted_oil_heavy') * 1000)
        .duration(160)
        .EUt(30)
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('oily_brine') * 1000)
        .fluidOutputs(fluid('desalted_oil') * 200)
        .fluidOutputs(fluid('salt_water') * 1000)
        .duration(160)
        .EUt(30)
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('light_oily_brine') * 1000)
        .fluidOutputs(fluid('desalted_oil_light') * 200)
        .fluidOutputs(fluid('salt_water') * 1000)
        .duration(160)
        .EUt(30)
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('heavy_oily_brine') * 1000)
        .fluidOutputs(fluid('desalted_oil_heavy') * 200)
        .fluidOutputs(fluid('salt_water') * 1000)
        .duration(160)
        .EUt(30)
        .buildAndRegister()

DT.recipeBuilder()
.fluidInputs(oils.oil.getDesalted(1000))
.fluidOutputs(fluid('sulfuric_oil_residue') * 150)
.fluidOutputs(fractions.fuel_oil.getSulfuric(150))
.fluidOutputs(fractions.diesel.getSulfuric(200))
.fluidOutputs(fractions.kerosene.getSulfuric(100))
.fluidOutputs(fractions.naphtha.getSulfuric(200))
.fluidOutputs(fractions.gasoline.getSulfuric(100))
.fluidOutputs(fractions.refinery_gas.getSulfuric(500))
.duration(100)
.EUt(30)
.buildAndRegister()

DT.recipeBuilder()
.fluidInputs(oils.oil_light.getDesalted(1000))
.fluidOutputs(fluid('sulfuric_oil_residue') * 50)
.fluidOutputs(fractions.fuel_oil.getSulfuric(100))
.fluidOutputs(fractions.diesel.getSulfuric(150))
.fluidOutputs(fractions.kerosene.getSulfuric(100))
.fluidOutputs(fractions.naphtha.getSulfuric(250))
.fluidOutputs(fractions.gasoline.getSulfuric(150))
.fluidOutputs(fractions.refinery_gas.getSulfuric(1000))
.duration(100)
.EUt(30)
.buildAndRegister()

DT.recipeBuilder()
.fluidInputs(oils.oil_heavy.getDesalted(1000))
.fluidOutputs(fluid('sulfuric_oil_residue') * 300)
.fluidOutputs(fractions.fuel_oil.getSulfuric(200))
.fluidOutputs(fractions.diesel.getSulfuric(150))
.fluidOutputs(fractions.kerosene.getSulfuric(100))
.fluidOutputs(fractions.naphtha.getSulfuric(100))
.fluidOutputs(fractions.gasoline.getSulfuric(50))
.fluidOutputs(fractions.refinery_gas.getSulfuric(250))
.duration(100)
.EUt(30)
.buildAndRegister()

fractions.each { _, fraction -> {
        FBR.recipeBuilder()
        .fluidInputs(fraction.getSulfuric(180))
        .fluidInputs(fluid('hydrogen') * 45)
        .notConsumable(metaitem('catalystBedAlumina'))
        .fluidOutputs(fraction.getTreatedSulfuric(180))
        .duration(30)
        .EUt(30)
        .buildAndRegister()

        DT.recipeBuilder()
        .fluidInputs(fraction.getTreatedSulfuric(1000))
        .fluidOutputs(fraction.get(1000))
        .fluidOutputs(fluid('sour_gas') * 250)
        .duration(100)
        .EUt(30)
        .buildAndRegister()
    }
}

// Sour gas Processing

CENTRIFUGE.recipeBuilder()
.fluidInputs(fluid('sour_gas') * 3000)
.fluidInputs(fluid('ethanolamine_mix') * 1000)
.fluidOutputs(fluid('hydrogen') * 1000)
.fluidOutputs(fluid('rich_amine') * 1000)
.duration(120)
.EUt(120)
.buildAndRegister()

CENTRIFUGE.recipeBuilder()
.fluidInputs(fluid('rich_amine') * 1000)
.fluidOutputs(fluid('hydrogen_sulfide') * 1000)
.fluidOutputs(fluid('ethanolamine_mix') * 1000)
.duration(160)
.EUt(120)
.buildAndRegister()

REACTION_FURNACE.recipeBuilder()
.fluidInputs(fluid('hydrogen_sulfide') * 3000)
.fluidInputs(fluid('oxygen') * 3000)
.fluidOutputs(fluid('uncatalyzed_sulfurous_gases') * 3000)
.outputs(metaitem('dustSulfur'))
.duration(300)
.EUt(30)
.buildAndRegister()

REACTION_FURNACE.recipeBuilder()
.fluidInputs(fluid('hydrogen_sulfide') * 3000)
.fluidInputs(fluid('air') * 9000)
.fluidOutputs(fluid('uncatalyzed_sulfurous_gases') * 3000)
.outputs(metaitem('dustSulfur'))
.duration(300)
.EUt(30)
.buildAndRegister()

REACTION_FURNACE.recipeBuilder()
.notConsumable(metaitem('catalystBedAlumina'))
.fluidInputs(fluid('uncatalyzed_sulfurous_gases') * 3000)
.fluidOutputs(fluid('steam') * 2000)
.outputs(metaitem('dustSulfur') * 2)
.duration(300)
.EUt(30)
.buildAndRegister()

// Natural Gas Processing

CENTRIFUGE.recipeBuilder()
.fluidInputs(fluid('crude_natural_gas') * 1000)
.fluidOutputs(fluid('oil') * 50)
.fluidOutputs(fluid('sulfuric_natural_gas') * 1000)
.duration(400)
.EUt(30)
.buildAndRegister()

// Sulfuric Oil Residue Processing

    // Solvent Dewaxing
    VACUUM_DT.recipeBuilder()
        .fluidInputs(fluid('sulfuric_oil_residue') * 1000)
        .fluidOutputs(fractions.fuel_oil.getSulfuric(200))
        .fluidOutputs(fractions.diesel.getSulfuric(200))
        .fluidOutputs(fractions.kerosene.getSulfuric(150))
        .fluidOutputs(fractions.naphtha.getSulfuric(100))
        .fluidOutputs(fluid('crude_lubricating_oil') * 850)
        .outputs(metaitem('bituminous_residue'))
        .duration(600)
        .EUt(30)
        .buildAndRegister()

// Slack wax Processing

CRYSTALLIZER.recipeBuilder()
.fluidInputs(fluid('slack_wax') * 1000)
.fluidOutputs(fluid('lubricating_oil') * 250)
.outputs(metaitem('paraffin_wax') * 4)
.duration(600)
.EUt(30)
.buildAndRegister()

crafting.addShaped("treated_wood_planks_paraffin", item('gregtech:planks', 1) * 8, [
    [ore('plankWood'),ore('plankWood'),ore('plankWood')],
    [ore('plankWood'),metaitem('paraffin_wax'),ore('plankWood')],
    [ore('plankWood'),ore('plankWood'),ore('plankWood')]
])

EXTRACTOR.recipeBuilder()
.inputs(metaitem('paraffin_wax'))
.circuitMeta(1)
.fluidOutputs(fluid('lubricating_oil') * 250)
.duration(200)
.EUt(30)
.buildAndRegister()

EXTRACTOR.recipeBuilder()
.inputs(metaitem('paraffin_wax'))
.circuitMeta(2)
.fluidOutputs(fluid('resin') * 1000)
.duration(200)
.EUt(30)
.buildAndRegister()

// Bituminous Residue Processing

MIXER.recipeBuilder()
.fluidInputs(fluid('oil') * 500)
.inputs(metaitem('bitumen'))
.fluidOutputs(fluid('bitumen_solution') * 1000)
.duration(200)
.EUt(Globals.voltAmps[1])
.buildAndRegister()

CENTRIFUGE.recipeBuilder()
.fluidInputs(fluid('bitumen_solution') * 1000)
.fluidOutputs(fluid('oil') * 650)
.outputs(metaitem('dustAsphalt') * 4)
.duration(300)
.EUt(Globals.voltAmps[0])
.buildAndRegister()

MIXER.recipeBuilder()
        .fluidInputs(fluid('oil_light') * 500)
        .inputs(metaitem('bitumen'))
        .fluidOutputs(fluid('light_bitumen_solution') * 1000)
        .duration(200)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('light_bitumen_solution') * 1000)
        .fluidOutputs(fluid('oil_light') * 650)
        .outputs(metaitem('dustAsphalt') * 4)
        .duration(300)
        .EUt(Globals.voltAmps[0])
        .buildAndRegister()

MIXER.recipeBuilder()
        .fluidInputs(fluid('oil_heavy') * 500)
        .inputs(metaitem('bitumen'))
        .fluidOutputs(fluid('heavy_bitumen_solution') * 1000)
        .duration(200)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('heavy_bitumen_solution') * 1000)
        .fluidOutputs(fluid('oil_heavy') * 650)
        .outputs(metaitem('dustAsphalt') * 4)
        .duration(300)
        .EUt(Globals.voltAmps[0])
        .buildAndRegister()

MIXER.recipeBuilder()
        .inputs(ore('dustAsphalt'))
        .fluidInputs(fluid('concrete') * 144)
        .outputs(item('gregtech:asphalt') * 2)
        .duration(30)
        .EUt(16)
        .buildAndRegister()

// Bituminous Residue -> Coke

COKING.recipeBuilder()
.fluidInputs(fluid('steam') * 1000)
.inputs(metaitem('bituminous_residue'))
.fluidOutputs(fluid('sulfuric_oil_residue') * 150)
.outputs(metaitem('dustGreenCoke') * 4)
.duration(600)
.EUt(Globals.voltAmps[1] * 2)
.buildAndRegister()

for (fuel in sintering_fuels) {
    if (!fuel.isPlasma) {
        for (comburent in sintering_comburents) {
            ROTARY_KILN.recipeBuilder()
                    .inputs(ore('dustGreenCoke'))
                    .outputs(metaitem('dustCoke'))
                    .fluidInputs(fluid(fuel.name) * fuel.amountRequired)
                    .fluidInputs(fluid(comburent.name) * comburent.amountRequired)
                    .fluidOutputs(fluid(fuel.byproduct) * fuel.byproductAmount)
                    .duration(fuel.duration + comburent.duration)
                    .EUt(120)
                    .buildAndRegister()

            ROTARY_KILN.recipeBuilder()
                    .inputs(metaitem('bituminous_residue'))
                    .fluidInputs(fluid(fuel.name) * fuel.amountRequired)
                    .fluidInputs(fluid(comburent.name) * comburent.amountRequired)
                    .outputs(metaitem('bitumen'))
                    .fluidOutputs(fluid(fuel.byproduct) * fuel.byproductAmount)
                    .duration(fuel.duration + comburent.duration)
                    .EUt(120)
                    .buildAndRegister()
        }
    }
}

// Cracking: Ethane, Propane Butane

ROASTER.recipeBuilder()
.fluidInputs(fluid('ethane') * 1000)
.fluidInputs(fluid('steam') * 1000)
.fluidOutputs(fluid('steamcracked_ethane') * 700)
.duration(300)
.EUt(Globals.voltAmps[1])
.buildAndRegister()

ROASTER.recipeBuilder()
.fluidInputs(fluid('propane') * 1000)
.fluidInputs(fluid('steam') * 1000)
.fluidOutputs(fluid('steamcracked_propane') * 700)
.duration(300)
.EUt(Globals.voltAmps[1])
.buildAndRegister()

ROASTER.recipeBuilder()
.fluidInputs(fluid('butane') * 1000)
.fluidInputs(fluid('steam') * 1000)
.fluidOutputs(fluid('steamcracked_butane') * 700)
.duration(300)
.EUt(Globals.voltAmps[1])
.buildAndRegister()

CRACKER.recipeBuilder()
        .fluidInputs(fluid('ethane') * 1000)
        .fluidInputs(fluid('steam') * 1000)
        .fluidOutputs(fluid('steamcracked_ethane') * 1000)
        .duration(80)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

CRACKER.recipeBuilder()
        .fluidInputs(fluid('propane') * 1000)
        .fluidInputs(fluid('steam') * 1000)
        .fluidOutputs(fluid('steamcracked_propane') * 1000)
        .duration(80)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

CRACKER.recipeBuilder()
        .fluidInputs(fluid('butane') * 1000)
        .fluidInputs(fluid('steam') * 1000)
        .fluidOutputs(fluid('steamcracked_butane') * 1000)
        .duration(80)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

DT.recipeBuilder()
.fluidInputs(fluid('steamcracked_ethane') * 1000)
.fluidOutputs(fluid('butadiene') * 50)
.fluidOutputs(fluid('propene') * 50)
.fluidOutputs(fluid('ethylene') * 800)
.fluidOutputs(fluid('methane') * 50)
.fluidOutputs(fluid('hydrogen') * 50)
.duration(600)
.EUt(Globals.voltAmps[1] * 2)
.buildAndRegister()

DT.recipeBuilder()
.fluidInputs(fluid('steamcracked_propane') * 1000)
.fluidOutputs(fluid('butadiene') * 50)
.fluidOutputs(fluid('propene') * 150)
.fluidOutputs(fluid('ethylene') * 500)
.fluidOutputs(fluid('methane') * 150)
.fluidOutputs(fluid('hydrogen') * 150)
.duration(600)
.EUt(Globals.voltAmps[1] * 2)
.buildAndRegister()

DT.recipeBuilder()
.fluidInputs(fluid('steamcracked_butane') * 1000)
.fluidOutputs(fluid('butadiene') * 150)
.fluidOutputs(fluid('propene') * 250)
.fluidOutputs(fluid('ethylene') * 350)
.fluidOutputs(fluid('methane') * 150)
.fluidOutputs(fluid('hydrogen') * 100)
.duration(600)
.EUt(Globals.voltAmps[1] * 2)
.buildAndRegister()

DT.recipeBuilder()
        .fluidInputs(fluid('fuel_oil') * 1000)
        .fluidOutputs(fluid('hexane') * 300)
        .fluidOutputs(fluid('pentane') * 250)
        .fluidOutputs(fluid('butane') * 200)
        .fluidOutputs(fluid('propane') * 150)
        .fluidOutputs(fluid('ethane') * 100)
        .fluidOutputs(fluid('methane') * 100)
        .duration(600)
        .EUt(Globals.voltAmps[1] * 2)
        .buildAndRegister()

DT.recipeBuilder()
        .fluidInputs(fluid('diesel') * 1000)
        .fluidOutputs(fluid('hexane') * 150)
        .fluidOutputs(fluid('pentane') * 200)
        .fluidOutputs(fluid('butane') * 300)
        .fluidOutputs(fluid('propane') * 200)
        .fluidOutputs(fluid('ethane') * 100)
        .fluidOutputs(fluid('methane') * 100)
        .duration(600)
        .EUt(Globals.voltAmps[1] * 2)
        .buildAndRegister()

DT.recipeBuilder()
        .fluidInputs(fluid('kerosene') * 1000)
        .fluidOutputs(fluid('hexane') * 100)
        .fluidOutputs(fluid('pentane') * 150)
        .fluidOutputs(fluid('butane') * 250)
        .fluidOutputs(fluid('propane') * 250)
        .fluidOutputs(fluid('ethane') * 200)
        .fluidOutputs(fluid('methane') * 100)
        .duration(600)
        .EUt(Globals.voltAmps[1] * 2)
        .buildAndRegister()

DT.recipeBuilder()
        .fluidInputs(fluid('naphtha') * 1000)
        .fluidOutputs(fluid('hexane') * 100)
        .fluidOutputs(fluid('pentane') * 150)
        .fluidOutputs(fluid('butane') * 200)
        .fluidOutputs(fluid('propane') * 300)
        .fluidOutputs(fluid('ethane') * 250)
        .fluidOutputs(fluid('methane') * 150)
        .duration(600)
        .EUt(Globals.voltAmps[1] * 2)
        .buildAndRegister()

DT.recipeBuilder()
        .fluidInputs(fluid('gasoline') * 1000)
        .fluidOutputs(fluid('hexane') * 100)
        .fluidOutputs(fluid('pentane') * 100)
        .fluidOutputs(fluid('butane') * 150)
        .fluidOutputs(fluid('propane') * 200)
        .fluidOutputs(fluid('ethane') * 300)
        .fluidOutputs(fluid('methane') * 250)
        .duration(600)
        .EUt(Globals.voltAmps[1] * 2)
        .buildAndRegister()

// Natural / Refinery -> Gasoline

CSTR.recipeBuilder()
.fluidInputs(fluid('sulfuric_acid') * 250)
.fluidInputs(fluid('natural_gas') * 50)
.fluidOutputs(fluid('alkylated_natural_gas') * 300)
.duration(5)
.EUt(Globals.voltAmps[1])
.buildAndRegister()

CSTR.recipeBuilder()
.fluidInputs(fluid('sulfuric_acid') * 250)
.fluidInputs(fluid('refinery_gas') * 50)
.fluidOutputs(fluid('alkylated_refinery_gas') * 300)
.duration(5)
.EUt(Globals.voltAmps[1])
.buildAndRegister()

DT.recipeBuilder()
.fluidInputs(fluid('alkylated_natural_gas') * 3000)
.fluidOutputs(fluid('sulfuric_acid') * 2500)
.fluidOutputs(fluid('gasoline') * 500)
.duration(200)
.EUt(Globals.voltAmps[1] * 2)
.buildAndRegister()

DT.recipeBuilder()
.fluidInputs(fluid('alkylated_refinery_gas') * 3000)
.fluidOutputs(fluid('sulfuric_acid') * 2500)
.fluidOutputs(fluid('gasoline') * 500)
.duration(200)
.EUt(Globals.voltAmps[1] * 2)
.buildAndRegister()

// Natural Gas Distillation

DT.recipeBuilder()
.fluidInputs(fluid('natural_gas') * 1000)
.fluidOutputs(fluid('butane') * 100)
.fluidOutputs(fluid('propane') * 100)
.fluidOutputs(fluid('ethane') * 100)
.fluidOutputs(fluid('methane') * 750)
.duration(100)
.EUt(Globals.voltAmps[1] * 2)
.buildAndRegister()

DT.recipeBuilder()
.fluidInputs(fluid('liquid_natural_gas') * 20)
.fluidOutputs(fluid('butane') * 128)
.fluidOutputs(fluid('propane') * 128)
.fluidOutputs(fluid('ethane') * 128)
.fluidOutputs(fluid('methane') * 960)
.fluidOutputs(fluid('helium') * 25)
.duration(100)
.EUt(Globals.voltAmps[2] * 2)
.buildAndRegister()

// Refinery Gas Distillation

DT.recipeBuilder()
.fluidInputs(fluid('refinery_gas') * 1000)
.fluidOutputs(fluid('butane') * 100)
.fluidOutputs(fluid('propane') * 100)
.fluidOutputs(fluid('ethane') * 100)
.fluidOutputs(fluid('methane') * 750)
.duration(100)
.EUt(Globals.voltAmps[1] * 2)
.buildAndRegister()

// Kerosene, naphtha and gasoline cracking

// Cracking

fractions.each { _, fraction -> {

        if (fraction instanceof OilFractionCrackable) {

            CRACKER.recipeBuilder()
            .fluidInputs(fraction.get(1000))
            .fluidInputs(fluid('hydrogen') * 1000)
            .fluidOutputs(fraction.getLightlyHydro(1000))
            .duration(260)
            .EUt(Globals.voltAmps[1] * 2)
            .buildAndRegister()
            
            CRACKER.recipeBuilder()
            .fluidInputs(fraction.get(1000))
            .fluidInputs(fluid('hot_hp_hydrogen') * 1000)
            .fluidOutputs(fraction.getSeverelyHydro(1000))
            .duration(260)
            .EUt(Globals.voltAmps[1] * 2)
            .buildAndRegister()
            
            CRACKER.recipeBuilder()
            .fluidInputs(fraction.get(1000))
            .fluidInputs(fluid('steam') * 1000)
            .fluidOutputs(fraction.getLightlySteam(1000))
            .duration(260)
            .EUt(Globals.voltAmps[1] * 2)
            .buildAndRegister()
            
            CRACKER.recipeBuilder()
            .fluidInputs(fraction.get(1000))
            .fluidInputs(fluid('hot_hp_steam') * 1000)
            .fluidOutputs(fraction.getSeverelySteam(1000))
            .duration(260)
            .EUt(Globals.voltAmps[1] * 2)
            .buildAndRegister()
            
        }

    }

}

EBF.recipeBuilder()
.fluidInputs(fluid('oxygen') * 1000)
.inputs(metaitem('spent_cracking_catalyst') * 4)
.fluidOutputs(fluid('flue_gas') * 1000)
.outputs(metaitem('cracking_catalyst') * 4)
.blastFurnaceTemp(1200)
.duration(100)
.EUt(Globals.voltAmps[1] * 2)
.buildAndRegister()

// Cracked Distillation

// Kerosene

DT.recipeBuilder()
.fluidInputs(fractions.kerosene.getLightlyHydro(1000))
.fluidOutputs(fluid('gasoline') * 600)
.fluidOutputs(fluid('naphtha') * 100)
.fluidOutputs(fluid('butane') * 100)
.fluidOutputs(fluid('propane') * 100)
.fluidOutputs(fluid('ethane') * 75)
.fluidOutputs(fluid('methane') * 75)
.duration(600)
.EUt(Globals.voltAmps[1] * 2)
.buildAndRegister()

DT.recipeBuilder()
.fluidInputs(fractions.kerosene.getSeverelyHydro(1000))
.fluidOutputs(fluid('gasoline') * 200)
.fluidOutputs(fluid('naphtha') * 250)
.fluidOutputs(fluid('butane') * 300)
.fluidOutputs(fluid('propane') * 300)
.fluidOutputs(fluid('ethane') * 175)
.fluidOutputs(fluid('methane') * 175)
.duration(600)
.EUt(Globals.voltAmps[1] * 2)
.buildAndRegister()

DT.recipeBuilder()
.fluidInputs(fractions.kerosene.getLightlySteam(1000))
.fluidOutputs(fluid('gasoline') * 300)
.fluidOutputs(fluid('naphtha') * 50)
.fluidOutputs(fluid('toluene') * 25)
.fluidOutputs(fluid('benzene') * 125)
.fluidOutputs(fluid('butene') * 25)
.fluidOutputs(fluid('butadiene') * 15)
.fluidOutputs(fluid('propane') * 3)
.fluidOutputs(fluid('propene') * 30)
.fluidOutputs(fluid('ethane') * 5)
.fluidOutputs(fluid('ethylene') * 50)
.fluidOutputs(fluid('methane') * 50)
.duration(600)
.EUt(Globals.voltAmps[1] * 2)
.buildAndRegister()

DT.recipeBuilder()
.fluidInputs(fractions.kerosene.getSeverelySteam(1000))
.fluidOutputs(fluid('gasoline') * 100)
.fluidOutputs(fluid('naphtha') * 125)
.fluidOutputs(fluid('toluene') * 80)
.fluidOutputs(fluid('benzene') * 125)
.fluidOutputs(fluid('butene') * 80)
.fluidOutputs(fluid('butadiene') * 50)
.fluidOutputs(fluid('propane') * 10)
.fluidOutputs(fluid('propene') * 100)
.fluidOutputs(fluid('ethane') * 15)
.fluidOutputs(fluid('ethylene') * 150)
.fluidOutputs(fluid('methane') * 150)
.duration(600)
.EUt(Globals.voltAmps[1] * 2)
.buildAndRegister()

// Naphtha :concernium:

DT.recipeBuilder()
.fluidInputs(fractions.naphtha.getLightlyHydro(1000))
.fluidOutputs(fluid('butane') * 800)
.fluidOutputs(fluid('propane') * 300)
.fluidOutputs(fluid('ethane') * 250)
.fluidOutputs(fluid('methane') * 250)
.duration(600)
.EUt(Globals.voltAmps[1] * 2)
.buildAndRegister()

DT.recipeBuilder()
.fluidInputs(fractions.naphtha.getSeverelyHydro(1000))
.fluidOutputs(fluid('butane') * 125)
.fluidOutputs(fluid('propane') * 125)
.fluidOutputs(fluid('ethane') * 1500)
.fluidOutputs(fluid('methane') * 1500)
.duration(600)
.EUt(Globals.voltAmps[1] * 2)
.buildAndRegister()

DT.recipeBuilder()
.fluidInputs(fractions.naphtha.getLightlySteam(1000))
.fluidOutputs(fluid('kerosene') * 75)
.fluidOutputs(fluid('gasoline') * 150)
.fluidOutputs(fluid('toluene') * 40)
.fluidOutputs(fluid('benzene') * 150)
.fluidOutputs(fluid('isoprene') * 150)
.fluidOutputs(fluid('butene') * 80)
.fluidOutputs(fluid('butadiene') * 150)
.fluidOutputs(fluid('propane') * 15)
.fluidOutputs(fluid('propene') * 200)
.fluidOutputs(fluid('ethane') * 35)
.fluidOutputs(fluid('ethylene') * 200)
.fluidOutputs(fluid('methane') * 200)
.duration(600)
.EUt(Globals.voltAmps[1] * 2)
.buildAndRegister()

DT.recipeBuilder()
.fluidInputs(fractions.naphtha.getSeverelySteam(1000))
.fluidOutputs(fluid('kerosene') * 25)
.fluidOutputs(fluid('gasoline') * 50)
.fluidOutputs(fluid('toluene') * 20)
.fluidOutputs(fluid('benzene') * 100)
.fluidOutputs(fluid('isoprene') * 350)
.fluidOutputs(fluid('butene') * 50)
.fluidOutputs(fluid('butadiene') * 50)
.fluidOutputs(fluid('propane') * 15)
.fluidOutputs(fluid('propene') * 300)
.fluidOutputs(fluid('ethane') * 65)
.fluidOutputs(fluid('ethylene') * 500)
.fluidOutputs(fluid('methane') * 500)
.duration(600)
.EUt(Globals.voltAmps[1] * 2)
.buildAndRegister()

// Gasoline 

DT.recipeBuilder()
.fluidInputs(fractions.gasoline.getLightlyHydro(1000))
.fluidOutputs(fluid('naphtha') * 800)
.fluidOutputs(fluid('butane') * 150)
.fluidOutputs(fluid('propane') * 200)
.fluidOutputs(fluid('ethane') * 125)
.fluidOutputs(fluid('methane') * 125)
.duration(600)
.EUt(Globals.voltAmps[1] * 2)
.buildAndRegister()

DT.recipeBuilder()
.fluidInputs(fractions.gasoline.getSeverelyHydro(1000))
.fluidOutputs(fluid('naphtha') * 200)
.fluidOutputs(fluid('butane') * 125)
.fluidOutputs(fluid('propane') * 125)
.fluidOutputs(fluid('ethane') * 1500)
.fluidOutputs(fluid('methane') * 1500)
.duration(600)
.EUt(Globals.voltAmps[1] * 2)
.buildAndRegister()

DT.recipeBuilder()
.fluidInputs(fractions.gasoline.getLightlySteam(1000))
.fluidOutputs(fluid('kerosene') * 150)
.fluidOutputs(fluid('naphtha') * 400)
.fluidOutputs(fluid('toluene') * 40)
.fluidOutputs(fluid('benzene') * 200)
.fluidOutputs(fluid('butene') * 75)
.fluidOutputs(fluid('butadiene') * 60)
.fluidOutputs(fluid('propane') * 20)
.fluidOutputs(fluid('propene') * 150)
.fluidOutputs(fluid('ethane') * 10)
.fluidOutputs(fluid('ethylene') * 50)
.fluidOutputs(fluid('methane') * 50)
.duration(600)
.EUt(Globals.voltAmps[1] * 2)
.buildAndRegister()

DT.recipeBuilder()
.fluidInputs(fractions.gasoline.getSeverelySteam(1000))
.fluidOutputs(fluid('kerosene') * 50)
.fluidOutputs(fluid('naphtha') * 100)
.fluidOutputs(fluid('toluene') * 30)
.fluidOutputs(fluid('benzene') * 150)
.fluidOutputs(fluid('butene') * 65)
.fluidOutputs(fluid('butadiene') * 50)
.fluidOutputs(fluid('propane') * 50)
.fluidOutputs(fluid('propene') * 250)
.fluidOutputs(fluid('ethane') * 50)
.fluidOutputs(fluid('ethylene') * 250)
.fluidOutputs(fluid('methane') * 250)
.duration(600)
.EUt(Globals.voltAmps[1] * 2)
.buildAndRegister()

fractions.each { _, fraction -> {
        if (fraction.isUpgradable) {
            CRACKER.recipeBuilder()
            .fluidInputs(fraction.get(1000))
            .inputs(metaitem('cracking_catalyst'))
            .fluidOutputs(fraction.getUpgradedMix(1000))
            .duration(260)
            .EUt(Globals.voltAmps[1] * 2)
            .buildAndRegister()

            CENTRIFUGE.recipeBuilder()
            .fluidInputs(fraction.getUpgradedMix(1000))
            .fluidOutputs(fraction.getUpgraded(1000))
            .outputs(metaitem('spent_cracking_catalyst'))
            .duration(160)
            .EUt(Globals.voltAmps[1])
            .buildAndRegister()
        }
    }
}

CRACKER.recipeBuilder()
        .fluidInputs(fluid('lubricating_oil') * 1000)
        .inputs(metaitem('cracking_catalyst'))
        .fluidOutputs(fluid('upgraded_lubricating_oil_mix') * 1000)
        .duration(260)
        .EUt(Globals.voltAmps[1] * 2)
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('upgraded_lubricating_oil_mix') * 1000)
        .fluidOutputs(fluid('sulfuric_fuel_oil') * 1000)
        .outputs(metaitem('spent_cracking_catalyst'))
        .duration(160)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

// BTEX

REFORMER.recipeBuilder()
.fluidInputs(fluid('naphtha') * 1000)
.fluidInputs(fluid('hydrogen') * 1000)
.notConsumable(ore('catalystBedPlatinum'))
.fluidOutputs(fluid('naphtha_reformate') * 1000)
.duration(25)
.EUt(Globals.voltAmps[3])
.buildAndRegister()

CENTRIFUGE.recipeBuilder()
.fluidInputs(fluid('naphtha_reformate') * 1000)
.fluidInputs(fluid('furfural') * 100)
.fluidOutputs(fluid('btex_extract') * 1000)
.duration(100)
.EUt(Globals.voltAmps[1])
.buildAndRegister()

CENTRIFUGE.recipeBuilder()
.fluidInputs(fluid('btex_extract') * 1000)
.fluidInputs(fluid('steam') * 1000)
.fluidOutputs(fluid('furfural') * 100)
.fluidOutputs(fluid('btex') * 1000)
.duration(100)
.EUt(Globals.voltAmps[1])
.buildAndRegister()

DT.recipeBuilder()
.fluidInputs(fluid('btex') * 1000)
.fluidOutputs(fluid('xylene') * 400)
.fluidOutputs(fluid('ethylbenzene') * 50)
.fluidOutputs(fluid('toluene') * 400)
.fluidOutputs(fluid('benzene') * 150)
.duration(100)
.EUt(Globals.voltAmps[1])
.buildAndRegister()

// XYLENE SEPARATION
DT.recipeBuilder()
.fluidInputs(fluid('xylene') * 1000)
.fluidOutputs(fluid('ortho_xylene') * 200)
.fluidOutputs(fluid('meta_para_xylene_mixture') * 800)
.duration(100)
.EUt(Globals.voltAmps[1] * 2)
.buildAndRegister()

CRYSTALLIZER.recipeBuilder()
.fluidInputs(fluid('meta_para_xylene_mixture') * 4000)
.outputs(metaitem('dustParaXylene'))
.fluidOutputs(fluid('meta_xylene') * 3000)
.duration(100)
.EUt(Globals.voltAmps[1])
.buildAndRegister()

BR.recipeBuilder()
.inputs(ore('dustDicobaltOctacarbonyl') * 18)
.fluidInputs(fluid('hydrogen') * 2000)
.fluidInputs(fluid('carbon_monoxide') * 1000)
.fluidInputs(fluid('ethylene') * 1000)
.fluidOutputs(fluid('propanal_mixture') * 1000)
.EUt(Globals.voltAmps[3])
.duration(80)
.buildAndRegister()

DISTILLERY.recipeBuilder()
.fluidInputs(fluid('propanal_mixture') * 1000)
.outputs(metaitem('dustDicobaltOctacarbonyl') * 18)
.fluidOutputs(fluid('propionaldehyde') * 800)
.EUt(Globals.voltAmps[3])
.duration(80)
.buildAndRegister()

FBR.recipeBuilder()
.fluidInputs(fluid('propionaldehyde') * 50)
.fluidInputs(fluid('hydrogen') * 100)
.notConsumable(metaitem('catalystBedPlatinum'))
.fluidOutputs(fluid('n_propanol') * 50)
.EUt(Globals.voltAmps[3])
.duration(4)
.buildAndRegister()

FBR.recipeBuilder()
.notConsumable(metaitem('catalystBedAlumina'))
.fluidInputs(fluid('ammonia') * 50)
.fluidInputs(fluid('n_propanol') * 150)
.fluidOutputs(fluid('tripropylamine') * 50)
.fluidOutputs(fluid('water') * 150)
.duration(5)
.EUt(120)
.buildAndRegister();

BR.recipeBuilder()
.notConsumable(metaitem('emitter.lv'))
.notConsumable(fluid('hydrogen_peroxide_solution') * 50)
.fluidInputs(fluid('hydrobromic_acid') * 1000)
.fluidInputs(fluid('propene') * 1000)
.fluidOutputs(fluid('n_bromopropane') * 1000)
.fluidOutputs(fluid('water') * 1000)
.duration(5)
.EUt(120)
.buildAndRegister();

CSTR.recipeBuilder()
.fluidInputs(fluid('n_bromopropane') * 50)
.fluidInputs(fluid('tripropylamine') * 50)
.fluidOutputs(fluid('tetrapropylammonium_bromide') * 50)
.duration(5)
.EUt(120)
.buildAndRegister();

BR.recipeBuilder()
.inputs(ore('dustSiliconDioxide') * 6)
.inputs(ore('dustAluminiumSulfate') * 51)
.inputs(ore('dustSodiumHydroxide'))
.fluidInputs(fluid('ethanol') * 100)
.fluidInputs(fluid('demineralized_water') * 1800)
.fluidInputs(fluid('tetrapropylammonium_bromide') * 100)
.outputs(metaitem('dustZsmFive'))
.duration(500)
.EUt(480)
.buildAndRegister();

REFORMER.recipeBuilder()
.notConsumable(metaitem('catalystBedZsmFive'))
.fluidInputs(fluid('meta_xylene') * 1000)
.fluidOutputs(fluid('para_xylene') * 1000)
.duration(60)
.EUt(Globals.voltAmps[1] * 2)
.buildAndRegister()
