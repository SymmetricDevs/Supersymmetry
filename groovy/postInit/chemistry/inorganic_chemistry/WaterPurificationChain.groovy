import globals.Globals

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;

def MIXER = recipemap('mixer');
def CLARIFIER = recipemap('clarifier');
def DRYER = recipemap('dryer');
def DISTILLERY = recipemap('distillery');
def PSA = recipemap('pressure_swing_adsorption');
def MSFD = recipemap('multi_stage_flash_distillation');
def EVAPORATION_POOL = recipemap('evaporation_pool');
def FLUID_HEATER = recipemap('fluid_heater');
def ION_EXCHANGE = recipemap('ion_exchange_column');
def VACUUM_CHAMBER = recipemap('vacuum_chamber');
def FLUID_COMPRESSOR = recipemap('fluid_compressor');
def UV_LIGHT_BOX = recipemap('uv_light_box');
def BR = recipemap('batch_reactor');
def BCR = recipemap('bubble_column_reactor');
def CENTRIFUGE = recipemap('centrifuge');
def SIFTER = recipemap('sifter');

// Salt * 2
mods.gregtech.centrifuge.removeByInput(30, null, [fluid('salt_water') * 1000])

oreDict.add('dustFlocculant', metaitem('dustPotassiumAlum'))
oreDict.add('dustFlocculant', metaitem('dustSodiumAlum'))
oreDict.add('dustFlocculant', metaitem('dustAluminiumSulfate'))

// Desalination
DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('salt_water') * 1000)
    .outputs(metaitem('dustSalt') * 2)
    .fluidOutputs(fluid('water') * 1000)
    .duration(240)
    .EUt(30)
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('concentrated_salt_water') * 1000)
    .outputs(metaitem('dustSalt') * 4)
    .fluidOutputs(fluid('water') * 1000)
    .duration(280)
    .EUt(30)
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('hypersaline_water') * 1000)
    .outputs(metaitem('dustSalt') * 8)
    .fluidOutputs(fluid('water') * 1000)
    .duration(320)
    .EUt(30)
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('sea_water') * 1000)
    .fluidOutputs(fluid('water') * 1000)
    .duration(240)
    .EUt(30)
    .buildAndRegister()

EVAPORATION_POOL.recipeBuilder()
    .fluidInputs(fluid('salt_water') * 20000)
    .outputs(metaitem('dustSalt') * 40)
    .duration(1800)
    .buildAndRegister()

EVAPORATION_POOL.recipeBuilder()
    .fluidInputs(fluid('sea_water') * 20000)
    .outputs(metaitem('dustSalt') * 20)
    .duration(1800)
    .buildAndRegister()

EVAPORATION_POOL.recipeBuilder()
    .fluidInputs(fluid('concentrated_salt_water') * 20000)
    .outputs(metaitem('dustSalt') * 64)
    .outputs(metaitem('dustSalt') * 16)
    .duration(1800)
    .buildAndRegister()

EVAPORATION_POOL.recipeBuilder()
    .fluidInputs(fluid('hypersaline_water') * 20000)
    .outputs(metaitem('dustSalt') * 64)
    .outputs(metaitem('dustSalt') * 64)
    .outputs(metaitem('dustSalt') * 32)
    .duration(1800)
    .buildAndRegister()

// Underground brine separation
EVAPORATION_POOL.recipeBuilder()
    .fluidInputs(fluid('brine') * 10000)
    .outputs(metaitem('dustSalt') * 64)
    .outputs(metaitem('dustSalt') * 16)
    .fluidOutputs(fluid('concentrated_brine') * 2500)
    .duration(1800)
    .buildAndRegister()

EVAPORATION_POOL.recipeBuilder()
    .fluidInputs(fluid('concentrated_brine') * 2500)
    .outputs(metaitem('dustCarnallite') * 50)
    .outputs(metaitem('dustPotassiumCarbonate') * 20)
    .outputs(metaitem('dustCalciumChloride') * 15)
    .fluidOutputs(fluid('very_concentrated_brine') * 250)
    .duration(1800)
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('very_concentrated_brine') * 1000)
    .fluidInputs(fluid('hydrochloric_acid') * 200)
    .outputs(metaitem('dustBoricAcid') * 7)
    .fluidOutputs(fluid('boron_free_brine') * 1000)
    .duration(120)
    .EUt(120)
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('boron_free_brine') * 1000)
    .inputs(ore('dustSodaAsh') * 6)
    .outputs(metaitem('gregtechfoodoption:lithium_carbonate_dust') * 6)
    .fluidOutputs(fluid('lithium_free_brine') * 1000)
    .duration(120)
    .EUt(120)
    .buildAndRegister()

BCR.recipeBuilder()
    .fluidInputs(fluid('lithium_free_brine') * 50)
    .fluidInputs(fluid('chlorine') * 25)
    .fluidOutputs(fluid('chlorinated_brine') * 50)
    .duration(1)
    .EUt(120)
    .buildAndRegister()

VACUUM_CHAMBER.recipeBuilder()
    .fluidInputs(fluid('steam') * 250)
    .fluidInputs(fluid('chlorinated_brine') * 1000)
    .fluidOutputs(fluid('impure_bromine') * 500)
    .fluidOutputs(fluid('wastewater_sludge') * 500)
    .duration(120)
    .EUt(120)
    .buildAndRegister()

CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('impure_bromine') * 1000)
    .fluidOutputs(fluid('bromine') * 1000)
    .chancedOutput(metaitem('dustIodine'), 1000, 1000)
    .duration(120)
    .EUt(120)
    .buildAndRegister()

MSFD.recipeBuilder()
    .fluidInputs(fluid('sea_water') * 10000)
    .fluidInputs(fluid('steam') * 1000)
    .fluidOutputs(fluid('water') * 5000)
    .fluidOutputs(fluid('salt_water') * 5000)
    .duration(10)
    .EUt(120)
    .buildAndRegister()

MSFD.recipeBuilder()
    .fluidInputs(fluid('salt_water') * 5000)
    .fluidInputs(fluid('steam') * 1000)
    .fluidOutputs(fluid('water') * 2500)
    .fluidOutputs(fluid('concentrated_salt_water') * 2500)
    .duration(10)
    .EUt(120)
    .buildAndRegister()

MSFD.recipeBuilder()
    .fluidInputs(fluid('concentrated_salt_water') * 2500)
    .fluidInputs(fluid('steam') * 1000)
    .fluidOutputs(fluid('water') * 1250)
    .fluidOutputs(fluid('hypersaline_water') * 1250)
    .duration(10)
    .EUt(120)
    .buildAndRegister()

MSFD.recipeBuilder()
    .fluidInputs(fluid('water') * 17500)
    .fluidInputs(fluid('steam') * 2000)
    .fluidOutputs(fluid('distilled_water') * 17500)
    .duration(10)
    .EUt(120)
    .buildAndRegister()

FLUID_COMPRESSOR.recipeBuilder()
    .notConsumable(metaitem('membrane.cellulose_acetate'))
    .fluidInputs(fluid('salt_water') * 10000)
    .fluidOutputs(fluid('hypersaline_water') * 2500)
    .fluidOutputs(fluid('water') * 7500)
    .duration(40)
    .EUt(480)
    .buildAndRegister()

FLUID_COMPRESSOR.recipeBuilder()
    .notConsumable(metaitem('membrane.cellulose_acetate'))
    .fluidInputs(fluid('concentrated_salt_water') * 10000)
    .fluidOutputs(fluid('hypersaline_water') * 5000)
    .fluidOutputs(fluid('water') * 5000)
    .duration(40)
    .EUt(480)
    .buildAndRegister()

// Wastewater treatment
FLUID_HEATER.recipeBuilder()
    .fluidInputs(fluid('wastewater') * 1000)
    .fluidOutputs(fluid('heated_wastewater') * 1000)
    .duration(80)
    .EUt(30)
    .buildAndRegister()

MIXER.recipeBuilder()
    .fluidInputs(fluid('heated_wastewater') * 1000)
    .inputs(ore('dustFlocculant'))
    .fluidOutputs(fluid('flocculated_wastewater') * 1000)
    .duration(80)
    .EUt(30)
    .buildAndRegister()

CLARIFIER.recipeBuilder()
    .fluidInputs(fluid('flocculated_wastewater') * 8000)
    .outputs(metaitem('dustAluminiumSulfate') * 8)
    .fluidOutputs(fluid('wastewater_sludge') * 2000)
    .fluidOutputs(fluid('water') * 6000)
    .duration(600)
    .EUt(30)
    .buildAndRegister()

// Deionized water
ION_EXCHANGE.recipeBuilder()
    .notConsumable(metaitem('beads.strong_acidic_cation_exchange'))
    .fluidInputs(fluid('ro_water') * 12800)
    .fluidInputs(fluid('diluted_sulfuric_acid') * 20)
    .fluidOutputs(fluid('partially_deionized_water') * 12800)
    .fluidOutputs(fluid('wastewater') * 10)
    .EUt(480)
    .duration(20)
    .buildAndRegister()

ION_EXCHANGE.recipeBuilder()
    .notConsumable(metaitem('beads.strong_basic_anion_exchange'))
    .fluidInputs(fluid('partially_deionized_water') * 12800)
    .fluidInputs(fluid('sodium_hydroxide_solution') * 10)
    .fluidOutputs(fluid('deionized_water') * 12800)
    .fluidOutputs(fluid('wastewater') * 10)
    .EUt(480)
    .duration(20)
    .buildAndRegister()

ION_EXCHANGE.recipeBuilder()
    .notConsumable(metaitem('beads.strong_acidic_cation_exchange'))
    .fluidInputs(fluid('sea_water') * 12800)
    .fluidInputs(fluid('diluted_sulfuric_acid') * 6400)
    .fluidOutputs(fluid('partially_deionized_sea_water') * 12800)
    .fluidOutputs(fluid('wastewater') * 3200)
    .EUt(480)
    .duration(20)
    .buildAndRegister()

ION_EXCHANGE.recipeBuilder()
    .notConsumable(metaitem('beads.strong_basic_anion_exchange'))
    .fluidInputs(fluid('partially_deionized_sea_water') * 12800)
    .fluidInputs(fluid('sodium_hydroxide_solution') * 3200)
    .fluidOutputs(fluid('deionized_sea_water') * 12800)
    .fluidOutputs(fluid('wastewater') * 3200)
    .EUt(480)
    .duration(20)
    .buildAndRegister()

// Ultrapure water for semiconductors
SIFTER.recipeBuilder()
    .fluidInputs(fluid('water') * 1000)
    .notConsumable(ore('dustActivatedCarbon') * 4)
    .fluidOutputs(fluid('filtered_water') * 1000)
    .duration(100)
    .EUt(30)
    .buildAndRegister()

VACUUM_CHAMBER.recipeBuilder()
    .fluidInputs(fluid('filtered_water') * 1000)
    .fluidInputs(fluid('steam') * 100)
    .fluidOutputs(fluid('deaerated_water') * 1100)
    .duration(110)
    .EUt(30)
    .buildAndRegister()

// Reverse osmosis
FLUID_COMPRESSOR.recipeBuilder()
    .fluidInputs(fluid('deaerated_water') * 1000)
    .notConsumable(metaitem('membrane.cellulose_acetate'))
    .fluidOutputs(fluid('ro_water') * 800)
    .fluidOutputs(fluid('wastewater') * 200)
    .duration(100)
    .EUt(30)
    .buildAndRegister()

// Deionization occurs between these two steps

UV_LIGHT_BOX.recipeBuilder()
    .fluidInputs(fluid('deionized_water') * 1000)
    .fluidOutputs(fluid('sterilized_water') * 1000)
    .duration(100)
    .EUt(30)
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('ro_water') * 100)
    .fluidOutputs(fluid('ultrapure_water') * 30)
    .duration(10)
    .EUt(40)
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('deionized_water') * 100)
    .fluidOutputs(fluid('ultrapure_water') * 60)
    .duration(10)
    .EUt(60)
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('sterilized_water') * 100)
    .fluidOutputs(fluid('ultrapure_water') * 90)
    .duration(10)
    .EUt(30)
    .buildAndRegister()