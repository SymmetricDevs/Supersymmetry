import static globals.Globals.*

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;

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

class LatexSource {
    String name 
    int amount_required
    int duration
    int yield
    boolean isFluid 

    LatexSource(name, amount_required, duration, yield, isFluid){
        this.name = name
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
        .notConsumable(metaitem(coagulant.name) * (coagulant.amount_required * amount))
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
    .notConsumable(metaitem('stickIron'))
    .outputs(metaitem('dustLatex') * amount)
    .duration(duration)
    .buildAndRegister()
}

def latexSources = [
    new LatexSource('dustLatex', 16, 45 * 20, 4, false),
    new LatexSource('latex', 32, 90 * 20, 1, true)
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

def VULCANIZING_RECIPES = recipemap("vulcanizing_press")

for (latexSource in latexSources) {
    for (sulfurSource in sulfurSources) {     
        for (catalyser in catalysers) {
            if(latexSource.isFluid)  {
                VULCANIZING_RECIPES.recipeBuilder()
                .notConsumable(metaitem(catalyser.name))
                .fluidInputs(fluid(latexSource.name) * latexSource.amount_required * 1000)
                .inputs(metaitem(sulfurSource.name) * sulfurSource.amount_required)
                .outputs(metaitem('plateRubber') * latexSource.yield)
                .duration(latexSource.duration.intdiv(catalyser.speed_bonus))
                .EUt(7)
                .buildAndRegister()
            } 
            else {
                VULCANIZING_RECIPES.recipeBuilder()
                .inputs(metaitem(latexSource.name) * latexSource.amount_required)
                .inputs(metaitem(sulfurSource.name) * sulfurSource.amount_required)
                .notConsumable(metaitem(catalyser.name))
                .outputs(metaitem('plateRubber') * latexSource.yield)
                .duration(latexSource.duration.intdiv(catalyser.speed_bonus))
                .EUt(7)
                .buildAndRegister()
            }
        }
        if(latexSource.isFluid)  {
            VULCANIZING_RECIPES.recipeBuilder()
            .fluidInputs(fluid(latexSource.name) * latexSource.amount_required * 1000)
            .inputs(metaitem(sulfurSource.name) * sulfurSource.amount_required)
            .notConsumable(Globals.circuit(0))
            .outputs(metaitem('plateRubber') * latexSource.yield)
            .duration(latexSource.duration)
            .EUt(7)
            .buildAndRegister()
        } 
        else {
            VULCANIZING_RECIPES.recipeBuilder()
            .inputs(metaitem(latexSource.name) * latexSource.amount_required)
            .inputs(metaitem(sulfurSource.name) * sulfurSource.amount_required)
            .notConsumable(Globals.circuit(0))
            .outputs(metaitem('plateRubber') * latexSource.yield)
            .duration(latexSource.duration)
            .EUt(7)
            .buildAndRegister()
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
