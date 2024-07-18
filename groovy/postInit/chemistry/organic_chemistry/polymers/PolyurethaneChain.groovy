import globals.Globals

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;

def LCR = recipemap('large_chemical_reactor');
def FBR = recipemap('fluidized_bed_reactor');
def CSTR = recipemap('continuous_stirred_tank_reactor');
def POLYMERIZATION = recipemap('polymerization_tank');
def DISTILLATION_TOWER = recipemap('distillation_tower');
def MIXER = recipemap('mixer');
def CHEMICAL_BATH = recipemap('chemical_bath');
def FLUID_COMPRESSOR = recipemap('fluid_compressor');

LCR.recipeBuilder()
        .fluidInputs(fluid('formaldehyde') * 2000)
        .fluidInputs(fluid('gtfo_aniline') * 1000)
        .fluidInputs(fluid('hydrochloric_acid') * 1000)
        .outputs(metaitem('dustMethylenedianiline') * 8)
        .fluidOutputs(fluid('diluted_hydrochloric_acid') * 2000)
        .duration(200)
        .EUt(240)
        .buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
        .fluidInputs(fluid('diluted_hydrochloric_acid') * 500)
        .fluidOutputs(fluid('hydrochloric_acid') * 250)
        .fluidOutputs(fluid('water') * 250)
        .duration(50)
        .EUt(30)
        .buildAndRegister()

FBR.recipeBuilder()
        .inputs(ore('dustMethylenedianiline') * 8)
        .fluidInputs(fluid('phosgene') * 2000)
        .outputs(metaitem('dustMethyleneDiphenylDiisocyanate') * 10)
        .fluidOutputs(fluid('hydrogen_chloride') * 4000)
        .duration(200)
        .EUt(240)
        .buildAndRegister()

CSTR.recipeBuilder()
        .fluidInputs(fluid('ethylene_oxide') * 150)
        .fluidInputs(fluid('ammonia') * 300)
        .fluidOutputs(fluid('ethanolamine_mix') * 150)
        .duration(1)
        .EUt(30)
        .buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
        .fluidInputs(fluid('ethanolamine_mix') * 3000)
        .fluidOutputs(fluid('triethanolamine') * 1000)
        .fluidOutputs(fluid('diethanolamine') * 1000)
        .fluidOutputs(fluid('ethanolamine') * 1000)
        .duration(200)
        .EUt(120)
        .buildAndRegister()

FBR.recipeBuilder()
        .notConsumable(metaitem('dustMolecularSieve'))
        .fluidInputs(fluid('ethanolamine') * 3000)
        .outputs(metaitem('dustTriethylenediamine') * 8)
        .fluidOutputs(fluid('ammonia') * 1000)
        .fluidOutputs(fluid('dense_steam') * 3000)
        .duration(200)
        .EUt(240)
        .buildAndRegister()

POLYMERIZATION.recipeBuilder()
        .inputs(ore('dustMethyleneDiphenylDiisocyanate') * 10)
        .inputs(ore('dustTinyTriethylenediamine'))
        .fluidInputs(fluid('ethylene_oxide') * 750)
        .fluidInputs(fluid('ethylene_glycol') * 250)
        .fluidInputs(fluid('polydimethylsiloxane') * 18)
        .fluidOutputs(fluid('polyurethane_polymerization_mix') * 1000)
        .duration(200)
        .EUt(240)
        .buildAndRegister()

FLUID_COMPRESSOR.recipeBuilder()
        .fluidInputs(fluid('hot_compressed_carbon_dioxide') * 1280)
        .fluidOutputs(fluid('supercritical_carbon_dioxide') * 20)
        .duration(200)
        .EUt(240)
        .buildAndRegister()

MIXER.recipeBuilder()
        .notConsumable(metaitem('shape.mold.block'))
        .fluidInputs(fluid('polyurethane_polymerization_mix') * 9000)
        .fluidInputs(fluid('water') * 180)
        .fluidInputs(fluid('supercritical_carbon_dioxide') * 180)
        .outputs(ore('blockPolyurethane').first())
        .duration(200)
        .EUt(240)
        .buildAndRegister()

MIXER.recipeBuilder()
        .notConsumable(metaitem('shape.mold.plate'))
        .fluidInputs(fluid('polyurethane_polymerization_mix') * 1000)
        .fluidInputs(fluid('water') * 20)
        .fluidInputs(fluid('supercritical_carbon_dioxide') * 20)
        .outputs(metaitem('platePolyurethane'))
        .duration(200)
        .EUt(240)
        .buildAndRegister()

CHEMICAL_BATH.recipeBuilder()
        .inputs(ore('blockPolyurethane'))
        .fluidInputs(fluid('dye_yellow') * 288)
        .outputs(item('minecraft:sponge'))
        .duration(100)
        .EUt(30)
        .buildAndRegister()

// Adipic acid for Spandex

LCR.recipeBuilder()
        .notConsumable(ore('catalystBedPalladium'))
        .notConsumable(fluid('hydrogen_iodide') * 1000)
        .fluidInputs(fluid('butadiene') * 1000)
        .fluidInputs(fluid('carbon_monoxide') * 2000)
        .fluidInputs(fluid('water') * 2000)
        .outputs(metaitem('dustAdipicAcid') * 20)
        .duration(100)
        .EUt(240)
        .buildAndRegister()

POLYMERIZATION.recipeBuilder()
        .inputs(ore('dustMethyleneDiphenylDiisocyanate') * 10)
        .inputs(ore('dustAdipicAcid') * 15)
        .inputs(ore('dustTinyTriethylenediamine') * 1)
        .fluidInputs(fluid('dimethylacetamide') * 4000)
        .fluidOutputs(fluid('spandex_prepolymer') * 4000)
        .duration(200)
        .EUt(240)
        .buildAndRegister()

MIXER.recipeBuilder()
        .fluidInputs(fluid('spandex_prepolymer') * 4000)
        .fluidInputs(fluid('ethylenediamine') * 250)
        .fluidInputs(fluid('diethylamine') * 10)
        .fluidOutputs(fluid('spandex_polymerization_mix') * 4000)
        .duration(200)
        .EUt(240)
        .buildAndRegister()

DRYER.recipeBuilder()
        .fluidInputs(fluid('spandex_polymerization_mix') * 4000)
        .fluidInputs(fluid('hot_air') * 1000)
        .notConsumable(metaitem('spinneret'))
        .outputs(metaitem('fiberSpandex') * 8)
        .fluidOutputs(fluid('air') * 1000)
        .fluidOutputs(fluid('dimethylacetamide') * 3500)
        .EUt(480)
        .duration(100)
        .buildAndRegister()