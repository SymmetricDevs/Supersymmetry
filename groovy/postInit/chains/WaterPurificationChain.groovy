import static globals.Globals.*

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;

def HEAT_EXCHANGER = recipemap('heat_exchanger');
def SIFTER = recipemap('sifter');
def DRYER = recipemap('dryer');

// Salt * 2
mods.gregtech.centrifuge.removeByInput(30, null, [fluid('salt_water') * 1000])

DRYER.recipeBuilder()
        .fluidInputs(fluid('salt_water') * 1000)
        .outputs(metaitem('dustSalt') * 2)
        .fluidOutputs(fluid('water') * 1000)
        .duration(240)
        .EUt(30)
        .buildAndRegister()

//MULTI STAGE FLASH DISTILLATION MODELLED BY HEAT EXCHANGER
HEAT_EXCHANGER.recipeBuilder()
        .fluidInputs(fluid('sea_water') * 9000)
        .fluidInputs(fluid('steam') * 1000)
        .fluidOutputs(fluid('water') * 9000)
        .fluidOutputs(fluid('salt_water') * 1000)
        .duration(60)
        .EUt(30)
        .buildAndRegister()

SIFTER.recipeBuilder()
        .fluidInputs(fluid('distilled_water') * 1000)
        .inputs(metaitem('dustMolecularSieve'))
        .fluidOutputs(fluid('high_purity_water') * 1000)
        .outputs(metaitem('dustWetMolecularSieve'))
        .duration(200)
        .EUt(30)
        .buildAndRegister()

DRYER.recipeBuilder()
        .inputs(metaitem('dustWetMolecularSieve'))
        .outputs(metaitem('dustMolecularSieve'))
        .duration(100)
        .EUt(30)
        .buildAndRegister()