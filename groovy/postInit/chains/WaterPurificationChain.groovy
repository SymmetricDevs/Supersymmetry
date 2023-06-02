import static globals.Globals.*

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;

def DUMPER = recipemap('dumping');
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

// Salt * 2
mods.gregtech.centrifuge.removeByInput(30, null, [fluid('salt_water') * 1000])

DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('salt_water') * 1000)
        .outputs(metaitem('dustSalt') * 2)
        .fluidOutputs(fluid('water') * 1000)
        .duration(240)
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
        .duration(150)
        .EUt(120)
        .buildAndRegister()

EVAPORATION_POOL.recipeBuilder()
        .fluidInputs(fluid('sea_water') * 20000)
        .outputs(metaitem('dustSalt') * 6)
        .duration(150)
        .EUt(120)
        .buildAndRegister()

MSFD.recipeBuilder()
        .fluidInputs(fluid('sea_water') * 9000)
        .fluidInputs(fluid('steam') * 1000)
        .fluidOutputs(fluid('water') * 9000)
        .fluidOutputs(fluid('salt_water') * 1000)
        .duration(10)
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

DUMPER.recipeBuilder()
        .fluidInputs(fluid('wastewater_sludge') * 100)
        .duration(20)
        .buildAndRegister()

FLUID_HEATER.recipeBuilder()
        .fluidInputs(fluid('wastewater') * 1000)
        .fluidOutputs(fluid('heated_wastewater') * 1000)
        .duration(80)
        .EUt(30)
        .buildAndRegister()

MIXER.recipeBuilder()
        .fluidInputs(fluid('heated_wastewater') * 1000)
        .inputs(metaitem('dustAluminiumSulfate') * 1)
        .fluidOutputs(fluid('flocculated_wastewater') * 1000)
        .duration(80)
        .EUt(30)
        .buildAndRegister()

CLARIFIER.recipeBuilder()
        .fluidInputs(fluid('flocculated_wastewater') * 8000)
        .outputs(metaitem('dustAluminiumSulfate') * 8)
        //.fluidOutputs(fluid('wastewater_sludge') * 2000)
        .fluidOutputs(fluid('water') * 6000)
        .duration(600)
        .EUt(30)
        .buildAndRegister()

DRYER.recipeBuilder()
        .inputs(metaitem('dustWetMolecularSieve'))
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