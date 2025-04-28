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
def COMPRESSOR = recipemap('compressor');
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
        .fluidInputs(fluid('water') * 8750)
        .fluidInputs(fluid('steam') * 1000)
        .fluidOutputs(fluid('distilled_water') * 8750)
        .duration(5)
        .EUt(120)
        .buildAndRegister()

PSA.recipeBuilder()
        .notConsumable(metaitem('cellulose_acetate_mesh'))
        .fluidInputs(fluid('salt_water') * 10000)
        .outputs(metaitem('dustSalt') * 20)
        .fluidOutputs(fluid('water') * 10000)
        .duration(80)
        .EUt(480)
        .buildAndRegister()

PSA.recipeBuilder()
        .notConsumable(metaitem('cellulose_acetate_mesh'))
        .fluidInputs(fluid('concentrated_salt_water') * 10000)
        .outputs(metaitem('dustSalt') * 40)
        .fluidOutputs(fluid('water') * 10000)
        .duration(80)
        .EUt(480)
        .buildAndRegister()

PSA.recipeBuilder()
        .notConsumable(metaitem('cellulose_acetate_mesh'))
        .fluidInputs(fluid('hypersaline_water') * 5000)
        .outputs(metaitem('dustSalt') * 40)
        .fluidOutputs(fluid('water') * 5000)
        .duration(40)
        .EUt(480)
        .buildAndRegister()

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

DRYER.recipeBuilder()
        .inputs(ore('dustWetMolecularSieve'))
        .outputs(metaitem('dustMolecularSieve'))
        .duration(100)
        .EUt(30)
        .buildAndRegister()

ION_EXCHANGE.recipeBuilder()
        .fluidInputs(fluid('water') * 1000)
        .notConsumable(metaitem('dustMolecularSieve'))
        .fluidOutputs(fluid('demineralized_water') * 900)
        .duration(100)
        .EUt(30)
        .buildAndRegister()

VACUUM_CHAMBER.recipeBuilder()
        .fluidInputs(fluid('demineralized_water') * 1000)
        .fluidInputs(fluid('steam') * 100)
        .fluidOutputs(fluid('deaerated_water') * 900)
        .duration(100)
        .EUt(30)
        .buildAndRegister()

COMPRESSOR.recipeBuilder()
        .fluidInputs(fluid('deaerated_water') * 1000)
        .notConsumable(metaitem('cellulose_acetate_mesh'))
        .fluidOutputs(fluid('filtered_water') * 900)
        .duration(100)
        .EUt(30)
        .buildAndRegister()

UV_LIGHT_BOX.recipeBuilder()
        .fluidInputs(fluid('filtered_water') * 1000)
        .fluidOutputs(fluid('sterilized_water') * 900)
        .duration(100)
        .EUt(30)
        .buildAndRegister()

DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('deaerated_water') * 100)
        .fluidOutputs(fluid('ultrapure_water') * 15)
        .duration(10)
        .EUt(50)
        .buildAndRegister()

DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('filtered_water') * 100)
        .fluidOutputs(fluid('ultrapure_water') * 30)
        .duration(10)
        .EUt(40)
        .buildAndRegister()

DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('demineralized_water') * 100)
        .fluidOutputs(fluid('ultrapure_water') * 5)
        .duration(10)
        .EUt(60)
        .buildAndRegister()

DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('sterilized_water') * 100)
        .fluidOutputs(fluid('ultrapure_water') * 90)
        .duration(10)
        .EUt(30)
        .buildAndRegister()
