import static globals.Globals.*

POLYMERIZATION = recipemap('polymerization_tank')
FLUID_SOLIDIFIER = recipemap('fluid_solidifier')

// Polyethylene

POLYMERIZATION.recipeBuilder()
        .notConsumable(metaitem('dustPhilipsCatalyst'))
        .fluidInputs(fluid('ethylene') * 144)
        .chancedOutput(metaitem('dustPlastic') * 3, 5000, 0)
        .EUt(30)
        .duration(75)
        .buildAndRegister()

POLYMERIZATION.recipeBuilder()
        .notConsumable(metaitem('dustZieglerNattaCatalyst'))
        .circuitMeta(2)
        .fluidInputs(fluid('ethylene') * 144)
        .outputs(metaitem('dustPlastic') * 2)
        .EUt(30)
        .duration(30)
        .buildAndRegister()

POLYMERIZATION.recipeBuilder()
        .notConsumable(metaitem('dustKaminskyCatalyst'))
        .circuitMeta(2)
        .fluidInputs(fluid('ethylene') * 144)
        .chancedOutput(metaitem('dustPlastic') * 5, 5000, 0)
        .EUt(30)
        .duration(30)
        .buildAndRegister()

POLYMERIZATION.recipeBuilder()
        .circuitMeta(1)
        .fluidInputs(fluid('ethylene') * 144)
        .outputs(metaitem('dustPlastic'))
        .EUt(30)
        .duration(300)
        .buildAndRegister()

// UHMWPE

// Ultra High Molecular Weight Polyethylene (UHMWPE) Plate * 1
mods.gregtech.compressor.removeByInput(2, [metaitem('dustUltraHighMolecularWeightPolyethylene')], null)
// Ultra High Molecular Weight Polyethylene (UHMWPE) Plate * 1
mods.gregtech.fluid_solidifier.removeByInput(7, [metaitem('shape.mold.plate')], [fluid('ultra_high_molecular_weight_polyethylene') * 144])
// Ultra High Molecular Weight Polyethylene (UHMWPE) * 144
mods.gregtech.extractor.removeByInput(30, [metaitem('plateUltraHighMolecularWeightPolyethylene')], null)

POLYMERIZATION.recipeBuilder()
        .circuitMeta(4)
        .notConsumable(metaitem('dustKaminskyCatalyst'))
        .fluidInputs(fluid('ethylene') * 144)
        .outputs(metaitem('dustUltraHighMolecularWeightPolyethylene'))
        .EUt(1920)
        .duration(20)
        .buildAndRegister()

POLYMERIZATION.recipeBuilder()
        .circuitMeta(3)
        .notConsumable(metaitem('dustZieglerNattaCatalyst'))
        .fluidInputs(fluid('ethylene') * 144)
        .chancedOutput(metaitem('dustUltraHighMolecularWeightPolyethylene'), 5000, 0)
        .EUt(1920)
        .duration(20)
        .buildAndRegister()

FLUID_SOLIDIFIER.recipeBuilder()
        .notConsumable(metaitem('spinneret'))
        .fluidInputs(fluid('ultra_high_molecular_weight_polyethylene') * 144)
        .outputs(metaitem('fiberUltraHighMolecularWeightPolyethylene'))
        .EUt(480)
        .duration(20)
        .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(ore('threadUltraHighMolecularWeightPolyethylene') * 8)
    .outputs(metaitem('plateUltraHighMolecularWeightPolyethylene'))
    .EUt(1920)
    .duration(300)
    .buildAndRegister()

// Polypropylene

POLYMERIZATION.recipeBuilder()
        .notConsumable(metaitem('dustPhilipsCatalyst'))
        .fluidInputs(fluid('propene') * 144)
        .fluidOutputs(fluid('polypropylene') * 216)
        .EUt(30)
        .duration(500)
        .buildAndRegister()

POLYMERIZATION.recipeBuilder()
        .notConsumable(metaitem('dustZieglerNattaCatalyst'))
        .fluidInputs(fluid('propene') * 144)
        .fluidOutputs(fluid('polypropylene') * 288)
        .EUt(30)
        .duration(200)
        .buildAndRegister()

POLYMERIZATION.recipeBuilder()
        .notConsumable(metaitem('dustKaminskyCatalyst'))
        .fluidInputs(fluid('propene') * 144)
        .fluidOutputs(fluid('polypropylene') * 360)
        .EUt(30)
        .duration(200)
        .buildAndRegister()