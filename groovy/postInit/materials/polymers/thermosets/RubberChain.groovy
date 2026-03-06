import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*
import gregtech.api.recipes.ModHandler
import gregtech.api.unification.material.Materials
import gregtech.api.unification.ore.OrePrefix
import gregtech.api.unification.stack.UnificationEntry

import groovy.transform.TupleConstructor

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

trait Fluid {}

@TupleConstructor
class Catalyst {
    String name
    int speed_bonus
}

@TupleConstructor
class Sulfur {
    String name
    int amount_required
}

@TupleConstructor
class Rubber {
    String name 
    String output
    int amount_required
    int duration
    int yield
}

@TupleConstructor
class Coagulant {
    String name
    int amount_required
    int speed_bonus
    int yield_bonus
}

class Shape {
    String name
    String shapeName
    int yield

    Shape(name, yield) {
        this.name = name
        this.shapeName = name
        this.yield = yield
    }
    
    Shape(name, shapeName, yield) {
        this.name = name
        this.shapeName = shapeName
        this.yield = yield
    }
}

def rubbers = [
    new Rubber('dustLatex', 'Rubber', 4, 40 * 20, 4),
    new Rubber('dustCompoundedPolyisoprene', 'Rubber', 8, 225, 8),
    new Rubber('dustCompoundedStyreneIsopreneRubber', 'StyreneIsopreneRubber', 4, 30 * 20, 4),
    new Rubber('dustCompoundedStyreneButadieneRubber', 'StyreneButadieneRubber', 4, 30 * 20, 4),
    new Rubber('dustRawNitrileRubber', 'NitrileRubber', 4, 30 * 20, 4)
]

def sulfurs = [
    new Sulfur('dustSulfur', 1)
]

def catalysts = [
    new Catalyst('', 0),  // circuitMeta(2)
    new Catalyst('dustZincite', 2),
    new Catalyst('dustMagnesia', 2)
]

def coagulants = [
    new Coagulant('stickIron', 1, 1, 1),
    new Coagulant('dustCalciumChloride', 2, 1, 1),
    new Coagulant('acetic_acid', 250, 4, 1).withTraits(Fluid),
    new Coagulant('sulfuric_acid', 125, 2, 1).withTraits(Fluid)
]

def shapes = [
    new Shape('plate', 1),
    new Shape('ring', 4),
    new Shape('foil', 4),
    new Shape('ingot', 1),
    new Shape('pipeTinyFluid', 'pipe.tiny', 2)
]

// Rubber vulcanization
for (rubber in rubbers) {
    for (sulfur in sulfurs) { 
        for (catalyst in catalysts) {
            for (shape in shapes) {
                if (oreDict.getItems(shape.name + rubber.output).size() == 0) {
                    continue;
                }
                VULCANIZER.recipeBuilder()
                    .tap {
                        rubber instanceof Fluid ?
                            fluidInputs(fluid(rubber.name) * (rubber.amount_required * 1000)) :
                            inputs(ore(rubber.name) * rubber.amount_required)
                    }
                    .tap {
                        sulfur instanceof Fluid ?
                            fluidInputs(fluid(sulfur.name) * (sulfur.amount_required * 1000)) :
                            inputs(ore(sulfur.name) * sulfur.amount_required)
                    }
                    .tap {
                        if (catalyst.speed_bonus == 0) {
                            circuitMeta(2)
                            duration(rubber.duration)
                        } else {
                            notConsumable(ore(catalyst.name))
                            duration(rubber.duration.intdiv(catalyst.speed_bonus))
                        }
                    }
                    .notConsumable(metaitem('shape.extruder.' + shape.shapeName))
                    .outputs(ore(shape.name + rubber.output)[0] * (rubber.yield * shape.yield))
                    .info('recipe.vulcanization.' + catalyst.name)
                    .EUt(VA[ULV])
                    .buildAndRegister()
            }
        }
    }
}

// Ebonite
for (rubber in rubbers) {
    coal_amount = Math.max(1, rubber.amount_required.intdiv(4))
    for (sulfur in sulfurs) { 
        MIXER.recipeBuilder()
            .tap {
                rubber instanceof Fluid ?
                    fluidInputs(fluid(rubber.name) * (rubber.amount_required * 1000)) :
                    inputs(ore(rubber.name) * rubber.amount_required)
            }
            .tap {
                sulfur instanceof Fluid ?
                    fluidInputs(fluid(sulfur.name) * (rubber.amount_required * sulfur.amount_required * 1000)) :
                    inputs(ore(sulfur.name) * (rubber.amount_required * sulfur.amount_required))
            }
            .inputs(ore('dustCoal') * coal_amount)
            .outputs(metaitem('dustCompoundedEbonite') * (rubber.yield * 2))
            .duration(40 * rubber.yield)
            .EUt(VA[LV])
            .buildAndRegister()
    }
}

ebonite_vulcanization_duration = 400
for (catalyst in catalysts) {
    VULCANIZER.recipeBuilder()
        .inputs(ore('dustCompoundedEbonite'))
        .notConsumable(metaitem('shape.mold.plate'))
        .tap {
            if (catalyst.speed_bonus == 0) {
                circuitMeta(2)
                duration(ebonite_vulcanization_duration)
            } else {
                notConsumable(ore(catalyst.name))
                duration(ebonite_vulcanization_duration.intdiv(catalyst.speed_bonus))
            }
        }
        .outputs(metaitem('plateEbonite'))
        .EUt(VA[LV])
        .buildAndRegister()
}

// Coagulaiton
coagulation_duration = 150
for (coagulant in coagulants) {
    COAGULATOR.recipeBuilder()
        .fluidInputs(fluid('latex') * 1000)
        .tap {
            coagulant instanceof Fluid ?
                notConsumable(fluid(coagulant.name) * coagulant.amount_required) :
                notConsumable(ore(coagulant.name) * coagulant.amount_required)
        }
        .outputs(metaitem('dustLatex') * coagulant.yield_bonus)
        .duration(coagulation_duration.intdiv(coagulant.speed_bonus))
        .buildAndRegister()
}

// Polyisoprene

POLYMERIZATION_TANK.recipeBuilder()
    .fluidInputs(fluid('isoprene') * 1000)
    .outputs(metaitem('dustPolyisoprene') * 4)
    .notConsumable(metaitem('dustZieglerNattaCatalyst'))
    .duration(200)
    .EUt(VA[MV])
    .buildAndRegister()

POLYMERIZATION_TANK.recipeBuilder()
    .fluidInputs(fluid('isoprene') * 1000)
    .outputs(metaitem('dustPolyisoprene') * 6)
    .notConsumable(fluid('butyllithium') * 100)
    .duration(200)
    .EUt(VA[MV])
    .buildAndRegister()

POLYMERIZATION_TANK.recipeBuilder()
    .fluidInputs(fluid('purified_isoprene') * 1000)
    .outputs(metaitem('dustPolyisoprene') * 6)
    .notConsumable(metaitem('dustZieglerNattaCatalyst'))
    .duration(200)
    .EUt(VA[MV])
    .buildAndRegister()

POLYMERIZATION_TANK.recipeBuilder()
    .fluidInputs(fluid('purified_isoprene') * 1000)
    .outputs(metaitem('dustPolyisoprene') * 8)
    .notConsumable(fluid('butyllithium') * 100)
    .duration(200)
    .EUt(VA[MV])
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustPolyisoprene') * 8)
    .inputs(ore('dustCarbon') * 2)
    .outputs(metaitem('dustCompoundedPolyisoprene') * 10)
    .info('recipe.compounded_polyisoprene')
    .EUt(VA[MV])
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

POLYMERIZATION_TANK.recipeBuilder()
    .fluidInputs(fluid('styrene_isoprene_solution') * 5000)
    .notConsumable(fluid('butyllithium') * 100)
    .fluidOutputs(fluid('polymerized_styrene_isoprene_solution') * 5000)
    .EUt(VA[MV])
    .duration(533)
    .buildAndRegister()

DRYER.recipeBuilder()
    .fluidInputs(fluid('polymerized_styrene_isoprene_solution') * 5000)
    .fluidOutputs(fluid('ethanol') * 1000)
    .outputs(metaitem('dustRawStyreneIsopreneRubber') * 16)
    .EUt(VA[MV])
    .duration(533)
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustRawStyreneIsopreneRubber') * 8)
    .inputs(ore('dustCarbon') * 2)
    .outputs(metaitem('dustCompoundedStyreneIsopreneRubber') * 10)
    .EUt(VA[MV])
    .duration(250)
    .buildAndRegister()

// Styrene-Butadiene rubber

MIXER.recipeBuilder()
    .fluidInputs(fluid('styrene') * 1000)
    .fluidInputs(fluid('butadiene') * 3000)
    .fluidInputs(fluid('ethanol') * 1000)
    .fluidOutputs(fluid('styrene_butadiene_solution') * 5000)
    .EUt(60)
    .duration(200)
    .buildAndRegister()

POLYMERIZATION_TANK.recipeBuilder()
    .fluidInputs(fluid('styrene_butadiene_solution') * 5000)
    .notConsumable(fluid('butyllithium') * 100)
    .fluidOutputs(fluid('polymerized_styrene_butadiene_solution') * 5000)
    .EUt(VA[MV])
    .duration(533)
    .buildAndRegister()

DRYER.recipeBuilder()
    .fluidInputs(fluid('polymerized_styrene_butadiene_solution') * 5000)
    .fluidOutputs(fluid('ethanol') * 1000)
    .outputs(metaitem('dustRawStyreneButadieneRubber') * 16)
    .EUt(VA[MV])
    .duration(533)
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustRawStyreneButadieneRubber') * 8)
    .inputs(ore('dustCarbon') * 2)
    .outputs(metaitem('dustCompoundedStyreneButadieneRubber') * 10)
    .EUt(VA[MV])
    .duration(250)
    .buildAndRegister()

// Nitrile-Butadiene rubber

MIXER.recipeBuilder()
    .inputs(ore('dustTinySodiumDodecylSulfate'))
    .fluidInputs(fluid('butadiene') * 400)
    .fluidInputs(fluid('acrylonitrile') * 1000)
    .fluidInputs(fluid('water') * 2000)
    .fluidOutputs(fluid('nitrile_rubber_precursor_emulsion') * 3400)
    .EUt(VA[MV])
    .duration(20)
    .buildAndRegister()

POLYMERIZATION_TANK.recipeBuilder()
    .inputs(ore('dustTinySodiumDithionite'))
    .inputs(ore('dustTinyIronSulfate'))
    .fluidInputs(fluid('nitrile_rubber_precursor_emulsion') * 3400)
    .fluidInputs(fluid('di_tert_butyl_peroxide') * 50)
    .fluidOutputs(fluid('nitrile_rubber_emulsion') * 2400)
    .EUt(VA[MV])
    .duration(500)
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('nitrile_rubber_emulsion') * 2400)
    .fluidOutputs(fluid('nitrile_rubber_latex') * 2000)
    .fluidOutputs(fluid('acrylonitrile') * 300)
    .fluidOutputs(fluid('butadiene') * 100)
    .EUt(VA[MV])
    .duration(125)
    .buildAndRegister()

BR.recipeBuilder()
    .circuitMeta(2)
    .inputs(ore('dustSalt') * 2)
    .fluidInputs(fluid('sulfuric_acid') * 100)
    .fluidInputs(fluid('nitrile_rubber_latex') * 2000)
    .fluidOutputs(fluid('acidic_wastewater') * 2100)
    .outputs(metaitem('dustRawNitrileRubber'))
    .EUt(VA[MV])
    .duration(250)
    .buildAndRegister()