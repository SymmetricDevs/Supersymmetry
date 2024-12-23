import globals.Globals
import static globals.CarbonGlobals.*

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;

def PYROLYSE_OVEN = recipemap('pyrolyse_oven');
def DISTILLATION_TOWER = recipemap('distillation_tower');
def CENTRIFUGE = recipemap('centrifuge');
def MIXER = recipemap('mixer');
def CSTR = recipemap('continuous_stirred_tank_reactor');
def DISTILLERY = recipemap('distillery');

byNames(['dustCoal', 'gemCoal', 'dustCharcoal', 'gemCharcoal']).each { input ->
    int CARBON_PROCESSED = 1200
    def output = byName(input.pyrolysis_product)
    PYROLYSE_OVEN.recipeBuilder()
        .inputs(ore(input.name) * input.num_items_by_carbon(CARBON_PROCESSED))
        .outputs(metaitem(output.name) * output.num_items_by_carbon(CARBON_PROCESSED))
        .fluidOutputs(fluid('coal_gas') * 2500)
        .fluidOutputs(fluid('coal_tar') * 2500)
        .duration(320)
        .EUt(60)
        .buildAndRegister()
}

byNames(['dustAnthracite', 'gemAnthracite']).each { input ->
    int CARBON_PROCESSED = 1400
    def output = byName(input.pyrolysis_product)
    PYROLYSE_OVEN.recipeBuilder()
        .inputs(ore(input.name) * input.num_items_by_carbon(CARBON_PROCESSED))
        .outputs(metaitem(output.name) * output.num_items_by_carbon(CARBON_PROCESSED))
        .fluidOutputs(fluid('coal_gas') * 3200)
        .fluidOutputs(fluid('coal_tar') * 3200)
        .duration(320)
        .EUt(60)
        .buildAndRegister()
}

byNames(['dustLignite', 'gemLignite']).each { input ->
    int CARBON_PROCESSED = 400
    def output = byName(input.pyrolysis_product)
    PYROLYSE_OVEN.recipeBuilder()
        .inputs(ore(input.name) * input.num_items_by_carbon(CARBON_PROCESSED))
        .outputs(metaitem(output.name) * output.num_items_by_carbon(CARBON_PROCESSED))
        .fluidOutputs(fluid('creosote') * 1600)
        .fluidOutputs(fluid('syngas') * 2000)
        .duration(320)
        .EUt(60)
        .buildAndRegister()
}

byNames(['dustCoke', 'gemCoke']).each { input ->
    def output = byName(input.pyrolysis_product)
    PYROLYSE_OVEN.recipeBuilder()
        .inputs(ore(input.name) * 16)
        .outputs(metaitem(output.name) * 12)
        .fluidInputs(fluid('dense_steam') * 15000)
        .fluidOutputs(fluid('syngas') * 12000)
        .duration(320)
        .EUt(60)
        .buildAndRegister()
}

byNames(['dustLigniteCoke', 'gemLigniteCoke']).each { input ->
    def output = byName(input.pyrolysis_product)
    PYROLYSE_OVEN.recipeBuilder()
        .inputs(ore(input.name) * 16)
        .outputs(metaitem(output.name) * 9)
        .fluidInputs(fluid('dense_steam') * 15000)
        .fluidOutputs(fluid('syngas') * 12000)
        .duration(320)
        .EUt(60)
        .buildAndRegister()
}

CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('coal_gas') * 10000)
        .fluidInputs(fluid('water') * 1000)
        .fluidOutputs(fluid('syngas') * 10000)
        .fluidOutputs(fluid('ammonia_solution') * 1000)
        .duration(120)
        .EUt(30)
        .buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
        .chancedOutput(metaitem('bitumen'), 5000, 0)
        .fluidInputs(fluid('coal_tar') * 1000)
        .fluidOutputs(fluid('anthracene_oil') * 100)
        .fluidOutputs(fluid('naphthalene_oil') * 100)
        .fluidOutputs(fluid('creosote') * 450)
        .fluidOutputs(fluid('light_oil') * 350)
        .duration(200)
        .EUt(48)
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('naphthalene_oil') * 1000)
        .fluidInputs(fluid('sodium_hydroxide_solution') * 100)
        .fluidOutputs(fluid('creosote') * 100)
        .fluidOutputs(fluid('alkaline_naphthalene_oil') * 1000)
        .duration(120)
        .EUt(30)
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('alkaline_naphthalene_oil') * 1000)
        .fluidInputs(fluid('sulfuric_acid') * 100)
        .fluidOutputs(fluid('sodium_sulfate_solution') * 100)
        .fluidOutputs(fluid('purified_naphthalene_oil') * 1000)
        .duration(120)
        .EUt(30)
        .buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
        .fluidInputs(fluid('purified_naphthalene_oil') * 1000)
        .fluidOutputs(fluid('anthracene_oil') * 100)
        .fluidOutputs(fluid('naphthalene') * 800)
        .fluidOutputs(fluid('light_oil') * 100)
        .duration(200)
        .EUt(48)
        .buildAndRegister()

MIXER.recipeBuilder()
        .fluidInputs(fluid('light_oil') * 1000)
        .fluidInputs(fluid('sulfuric_acid') * 100)
        .fluidOutputs(fluid('acidic_light_oil') * 1000)
        .duration(120)
        .EUt(30)
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('acidic_light_oil') * 1000)
        .fluidInputs(fluid('furfural') * 75)
        .fluidOutputs(fluid('btex_extract') * 750)
        .fluidOutputs(fluid('crude_pyridinium_sulfate') * 250)
        .duration(120)
        .EUt(30)
        .buildAndRegister()

CSTR.recipeBuilder()
        .fluidInputs(fluid('crude_pyridinium_sulfate') * 50)
        .fluidInputs(fluid('ammonia') * 100)
        .fluidOutputs(fluid('impure_pyridine') * 50)
        .duration(1)
        .EUt(30)
        .buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
        .fluidInputs(fluid('impure_pyridine') * 1000)
        .outputs(metaitem('dustAmmoniumSulfate') * 15)
        .fluidOutputs(fluid('gtfo_aniline') * 250)
        .fluidOutputs(fluid('pyridine') * 750)
        .duration(200)
        .EUt(48)
        .buildAndRegister()

MIXER.recipeBuilder()
        .fluidInputs(fluid('anthracene_oil') * 1000)
        .fluidInputs(fluid('sulfuric_acid') * 100)
        .fluidOutputs(fluid('acidic_anthracene_oil') * 1000)
        .duration(120)
        .EUt(30)
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('acidic_anthracene_oil') * 1000)
        .fluidInputs(fluid('ethylene_glycol') * 75)
        .fluidOutputs(fluid('anthracene_extract') * 750)
        .fluidOutputs(fluid('crude_quinolinium_sulfate') * 250)
        .duration(120)
        .EUt(30)
        .buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
        .fluidInputs(fluid('anthracene_extract') * 1000)
        .chancedOutput(metaitem('dustAnthracene'), 8000, 0)
        .fluidOutputs(fluid('ethylene_glycol') * 100)
        .fluidOutputs(fluid('light_oil') * 200)
        .duration(200)
        .EUt(48)
        .buildAndRegister()

CSTR.recipeBuilder()
        .fluidInputs(fluid('crude_quinolinium_sulfate') * 50)
        .fluidInputs(fluid('ammonia') * 100)
        .fluidOutputs(fluid('impure_quinoline') * 50)
        .duration(1)
        .EUt(30)
        .buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
        .fluidInputs(fluid('impure_quinoline') * 1000)
        .outputs(metaitem('dustAmmoniumSulfate') * 15)
        .fluidOutputs(fluid('quinoline') * 800)
        .fluidOutputs(fluid('naphthalene_oil') * 200)
        .duration(200)
        .EUt(48)
        .buildAndRegister()

// Centrifuging Lignite to Carbon
CENTRIFUGE.recipeBuilder()
        .inputs(ore('dustLignite'))
        .chancedOutput(metaitem('dustCarbon'), 2500, 0)
        .duration(80)
        .EUt(30)
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .inputs(ore('dustLigniteCoke'))
        .chancedOutput(metaitem('dustCarbon'), 7500, 0)
        .duration(80)
        .EUt(30)
        .buildAndRegister()