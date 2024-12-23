import globals.Globals

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;

POLYMERIZATION_TANK = recipemap('polymerization_tank')
MIXER = recipemap('mixer')
SIFTER = recipemap('sifter')
DRYER = recipemap('dryer')
EXTRACTOR = recipemap('extractor')

//REMOVALS
// Raw Rubber Pulp * 2
mods.gregtech.extractor.removeByInput(2, [item('minecraft:slime_ball')], null)
// Raw Rubber Pulp * 3
mods.gregtech.extractor.removeByInput(2, [metaitem('rubber_drop')], null)
// Raw Rubber Pulp * 1
mods.gregtech.extractor.removeByInput(2, [item('gregtech:rubber_sapling')], null)
// Raw Rubber Pulp * 1
mods.gregtech.extractor.removeByInput(2, [item('gregtech:rubber_leaves') * 16], null)
// Raw Rubber Pulp * 1
mods.gregtech.extractor.removeByInput(2, [item('gregtech:rubber_log')], null)
// Liquid Latex * 144
mods.gregtech.extractor.removeByInput(30, [metaitem('dustLatex')], null)

//DEFINITIONS
class Catalyser {
    String name
    int speed_bonus

    Catalyser(name, speed_bonus) {
        this.name = name
        this.speed_bonus = speed_bonus
    }
}

class SulfurSource {
    String name
    int amount_required

    SulfurSource(name, amount_required) {
        this.name = name
        this.amount_required = amount_required
    }
}

class Rubber {
    String name 
    String output
    int amount_required
    int duration
    int yield
    boolean isFluid 

    Rubber(name, output, amount_required, duration, yield, isFluid){
        this.name = name
        this.output = output
        this.amount_required = amount_required
        this.duration = duration
        this.yield = yield
        this.isFluid = isFluid
    }
}

class Coagulant {
    String name
    int amount_required
    int speed_bonus
    int yield_bonus
    boolean isFluid

    Coagulant(name, amount_required, speed_bonus, yield_bonus, isFluid){
        this.name = name
        this.amount_required = amount_required
        this.speed_bonus = speed_bonus
        this.yield_bonus = yield_bonus
        this.isFluid = isFluid
    }
}

class Shape {
    String name
    int yield

    Shape(name, yield){
        this.name = name
        this.yield = yield
    }
}

def CoagulationRecipe(coagulant, amount, duration) {
    def COAGULATION_RECIPES = recipemap("coagulation_tank")

    if (coagulant.isFluid) {
        COAGULATION_RECIPES.recipeBuilder()
        .fluidInputs(fluid('latex') * (1000 * amount))
        .notConsumable(fluid(coagulant.name) * (coagulant.amount_required * amount))
        .outputs(metaitem('dustLatex') * (coagulant.yield_bonus * amount))
        .duration(duration.intdiv(coagulant.speed_bonus))
        .buildAndRegister()
    } else {
        COAGULATION_RECIPES.recipeBuilder()
        .fluidInputs(fluid('latex') * (1000 * amount))
        .notConsumable(ore(coagulant.name) * (coagulant.amount_required * amount))
        .outputs(metaitem('dustLatex') * (coagulant.yield_bonus * amount))
        .duration(duration.intdiv(coagulant.speed_bonus))
        .buildAndRegister()
    }
}

def CoagulationRecipe(amount, duration){
    def COAGULATION_RECIPES = recipemap("coagulation_tank")

    COAGULATION_RECIPES.recipeBuilder()
    .fluidInputs(fluid('latex') * (1000 * amount))
    .notConsumable(ore('stickIron'))
    .outputs(metaitem('dustLatex') * amount)
    .duration(duration)
    .buildAndRegister()
}

def rubbers = [
    new Rubber('dustLatex', 'Rubber', 4, 40 * 20, 4, false),
    new Rubber('dustCompoundedPolyisoprene', 'Rubber', 8, 225, 8, false),
    new Rubber('dustCompoundedStyreneIsopreneRubber', 'StyreneIsopreneRubber', 4, 30 * 20, 4, false),
    new Rubber('dustCompoundedStyreneButadieneRubber', 'StyreneButadieneRubber', 4, 30 * 20, 4, false)
]

def sulfurSources = [
    new SulfurSource('dustSulfur', 1)
]

def catalysers = [
    new Catalyser('dustZincite', 2),
    new Catalyser('dustMagnesia', 2)
]

def coagulants = [
    new Coagulant('dustCalciumChloride', 2, 1, 1, false),
    new Coagulant('acetic_acid', 250, 4, 1, true),
    new Coagulant('sulfuric_acid', 125, 2, 1, true)
]

def shapes = [
    new Shape('plate', 1),
    new Shape('ring', 4),
    new Shape('foil', 4),
    new Shape('ingot', 1),
]

def VULCANIZING_RECIPES = recipemap("vulcanizing_press")

for (rubber in rubbers) {
    for (sulfurSource in sulfurSources) { 
        for(shape in shapes) {
            for (catalyser in catalysers) {
                    VULCANIZING_RECIPES.recipeBuilder()
                    .inputs(ore(rubber.name) * rubber.amount_required)
                    .inputs(ore(sulfurSource.name) * sulfurSource.amount_required)
                    .notConsumable(ore(catalyser.name))
                    .notConsumable(metaitem('shape.extruder.' + shape.name))
                    .outputs(metaitem(shape.name + rubber.output) * (rubber.yield * shape.yield))
                    .duration(rubber.duration.intdiv(catalyser.speed_bonus))
                    .EUt(7)
                    .buildAndRegister()
                }
                if (rubber.isFluid)  {
                    VULCANIZING_RECIPES.recipeBuilder()
                    .fluidInputs(fluid(rubber.name) * rubber.amount_required * 1000)
                    .inputs(ore(sulfurSource.name) * sulfurSource.amount_required)
                    .notConsumable(metaitem('shape.extruder.' + shape.name))
                    .circuitMeta(2)
                    .outputs(metaitem(shape.name + rubber.output) * (rubber.yield * shape.yield))
                    .duration(rubber.duration)
                    .EUt(7)
                    .buildAndRegister()
                } 
                else {
                    VULCANIZING_RECIPES.recipeBuilder()
                    .inputs(ore(rubber.name) * rubber.amount_required)
                    .inputs(ore(sulfurSource.name) * sulfurSource.amount_required)
                    .notConsumable(metaitem('shape.extruder.' + shape.name))
                    .circuitMeta(2)
                    .outputs(metaitem(shape.name + rubber.output) * (rubber.yield * shape.yield))
                    .duration(rubber.duration)
                    .EUt(7)
                    .buildAndRegister()
            }
        }    
    }
}

CoagulationRecipe(1, 150)

for (coagulant in coagulants) {
    CoagulationRecipe(coagulant, 1, 150)
}

// Polyisoprene

POLYMERIZATION_TANK.recipeBuilder()
    .fluidInputs(fluid('isoprene') * 1000)
    .outputs(metaitem('dustPolyisoprene') * 4)
    .notConsumable(metaitem('dustZieglerNattaCatalyst'))
    .duration(200)
    .EUt(120)
    .buildAndRegister()

POLYMERIZATION_TANK.recipeBuilder()
    .fluidInputs(fluid('isoprene') * 1000)
    .outputs(metaitem('dustPolyisoprene') * 6)
    .notConsumable(fluid('butyllithium') * 100)
    .duration(200)
    .EUt(120)
    .buildAndRegister()

POLYMERIZATION_TANK.recipeBuilder()
    .fluidInputs(fluid('purified_isoprene') * 1000)
    .outputs(metaitem('dustPolyisoprene') * 6)
    .notConsumable(metaitem('dustZieglerNattaCatalyst'))
    .duration(200)
    .EUt(120)
    .buildAndRegister()

POLYMERIZATION_TANK.recipeBuilder()
    .fluidInputs(fluid('purified_isoprene') * 1000)
    .outputs(metaitem('dustPolyisoprene') * 8)
    .notConsumable(fluid('butyllithium') * 100)
    .duration(200)
    .EUt(120)
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustPolyisoprene') * 8)
    .inputs(ore('dustCarbonBlack') * 2)
    .outputs(metaitem('dustCompoundedPolyisoprene') * 10)
    .EUt(120)
    .duration(250)
    .buildAndRegister()

// Styrene-Isoprene rubber

MIXER.recipeBuilder()
.fluidInputs(fluid('styrene') * 1000)
.fluidInputs(fluid('isoprene') * 3000)
.fluidInputs(fluid('ethanol') * 1000)
.fluidOutputs(fluid('styrene_isoprene_solution') * 5000)
.EUt(60)
.duration(200)
.buildAndRegister()

POLYMERIZATION.recipeBuilder()
.fluidInputs(fluid('styrene_isoprene_solution') * 5000)
.notConsumable(fluid('butyllithium') * 100)
.fluidOutputs(fluid('polymerized_styrene_isoprene_solution') * 5000)
.EUt(120)
.duration(533)
.buildAndRegister()

DRYER.recipeBuilder()
.fluidInputs(fluid('polymerized_styrene_isoprene_solution') * 5000)
.fluidOutputs(fluid('ethanol') * 1000)
.outputs(metaitem('dustRawStyreneIsopreneRubber') * 16)
.EUt(120)
.duration(533)
.buildAndRegister()

MIXER.recipeBuilder()
.inputs(ore('dustRawStyreneIsopreneRubber') * 8)
.inputs(ore('dustCarbonBlack') * 2)
.outputs(metaitem('dustCompoundedStyreneIsopreneRubber') * 10)
.EUt(120)
.duration(250)
.buildAndRegister()

// Styrene-Butadiene rubber

SIFTER.recipeBuilder()
.fluidInputs(fluid('ethanol_water_azeotrope') * 1000)
.inputs(ore('dustMolecularSieve')* 4)
.fluidOutputs(fluid('ethanol') * 900)
.outputs(metaitem('dustWetMolecularSieve') * 4)
.EUt(30)
.duration(200)
.buildAndRegister()

MIXER.recipeBuilder()
.fluidInputs(fluid('styrene') * 1000)
.fluidInputs(fluid('butadiene') * 3000)
.fluidInputs(fluid('ethanol') * 1000)
.fluidOutputs(fluid('styrene_butadiene_solution') * 5000)
.EUt(60)
.duration(200)
.buildAndRegister()

POLYMERIZATION.recipeBuilder()
.fluidInputs(fluid('styrene_butadiene_solution') * 5000)
.notConsumable(fluid('butyllithium') * 100)
.fluidOutputs(fluid('polymerized_styrene_butadiene_solution') * 5000)
.EUt(120)
.duration(533)
.buildAndRegister()

DRYER.recipeBuilder()
.fluidInputs(fluid('polymerized_styrene_butadiene_solution') * 5000)
.fluidOutputs(fluid('ethanol') * 1000)
.outputs(metaitem('dustRawStyreneButadieneRubber') * 16)
.EUt(120)
.duration(533)
.buildAndRegister()

MIXER.recipeBuilder()
.inputs(ore('dustRawStyreneButadieneRubber') * 8)
.inputs(ore('dustCarbonBlack') * 2)
.outputs(metaitem('dustCompoundedStyreneButadieneRubber') * 10)
.EUt(120)
.duration(250)
.buildAndRegister()