import static globals.Globals.*

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;

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

def CoagulationRecipe(coagulant, amount, duration, circ){
    def COAGULATION_RECIPES = recipemap("coagulation_tank")

    if(coagulant.isFluid){
        COAGULATION_RECIPES.recipeBuilder()
        .fluidInputs(fluid('latex') * (1000 * amount))
        .notConsumable(fluid(coagulant.name) * (coagulant.amount_required * amount))
        .notConsumable(Globals.circuit(circ))
        .outputs(metaitem('dustLatex') * (coagulant.yield_bonus * amount))
        .duration(duration.intdiv(coagulant.speed_bonus))
        .buildAndRegister()
    }
    else{
        COAGULATION_RECIPES.recipeBuilder()
        .fluidInputs(fluid('latex') * (1000 * amount))
        .notConsumable(ore(coagulant.name) * (coagulant.amount_required * amount))
        .notConsumable(Globals.circuit(circ))
        .outputs(metaitem('dustLatex') * (coagulant.yield_bonus * amount))
        .duration(duration.intdiv(coagulant.speed_bonus))
        .buildAndRegister()
    }
}

def CoagulationRecipe(amount, duration, circ){
    def COAGULATION_RECIPES = recipemap("coagulation_tank")

    COAGULATION_RECIPES.recipeBuilder()
    .fluidInputs(fluid('latex') * (1000 * amount))
    .notConsumable(ore('stickIron'))
    .outputs(metaitem('dustLatex') * amount)
    .duration(duration)
    .buildAndRegister()
}

def rubbers = [
    new Rubber('dustLatex', 'Rubber', 16, 10 * 20, 4, false),
    new Rubber('latex', 'Rubber', 32, 20 * 20, 1, true),
    new Rubber('dustPolyisoprene', 'Rubber', 8, 225, 8, false),
    new Rubber('dustPolydimethylsiloxane', 'SiliconeRubber', 4, 30 * 20, 4, false),
    new Rubber('dustRawStyreneButadieneRubber', 'StyreneButadieneRubber', 4, 30 * 20, 4, false)
]
def sulfurSources = [
    new SulfurSource('dustSulfur', 1)
]

def catalysers = [
    new Catalyser('dustZincite', 2),
    new Catalyser('dustMagnesia', 2)
]

def coagulants = [
    new Coagulant('dustCalciumChloride', 2, 1, 4, false),
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
                    if(rubber.isFluid)  {
                        VULCANIZING_RECIPES.recipeBuilder()
                        .fluidInputs(fluid(rubber.name) * rubber.amount_required * 1000)
                        .inputs(ore(sulfurSource.name) * sulfurSource.amount_required)
                        .notConsumable(ore(catalyser.name))
                        .notConsumable(metaitem('shape.extruder.' + shape.name))
                        .outputs(metaitem(shape.name + rubber.output) * (rubber.yield * shape.yield))
                        .duration(rubber.duration.intdiv(catalyser.speed_bonus))
                        .EUt(7)
                        .buildAndRegister()
                    } 
                    else {
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
                }
                if(rubber.isFluid)  {
                    VULCANIZING_RECIPES.recipeBuilder()
                    .fluidInputs(fluid(rubber.name) * rubber.amount_required * 1000)
                    .inputs(ore(sulfurSource.name) * sulfurSource.amount_required)
                    .notConsumable(metaitem('shape.extruder.' + shape.name))
                    .notConsumable(Globals.circuit(0))
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
                    .notConsumable(Globals.circuit(0))
                    .outputs(metaitem(shape.name + rubber.output) * (rubber.yield * shape.yield))
                    .duration(rubber.duration)
                    .EUt(7)
                    .buildAndRegister()
            }
        }    
    }
}

CoagulationRecipe(1, 400, 0)
CoagulationRecipe(4, 1000, 1)
CoagulationRecipe(16, 2500, 2)

for (coagulant in coagulants) {
    CoagulationRecipe(coagulant, 1, 400, 3)
    CoagulationRecipe(coagulant, 4, 1000, 4)
    CoagulationRecipe(coagulant, 16, 2500, 5)
}
