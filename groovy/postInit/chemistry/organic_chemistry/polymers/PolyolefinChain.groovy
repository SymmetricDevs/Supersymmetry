import static globals.Globals.*

POLYMERIZATION = recipemap('polymerization_tank')

// Polyethylene

POLYMERIZATION.recipeBuilder()
        .notConsumable(metaitem('dustPhilipsCatalyst'))
        .fluidInputs(fluid('ethylene') * 144)
        .fluidOutputs(fluid('plastic') * 216)
        .EUt(30)
        .duration(75)
        .buildAndRegister()

POLYMERIZATION.recipeBuilder()
        .notConsumable(metaitem('dustZieglerNattaCatalyst'))
        .fluidInputs(fluid('ethylene') * 144)
        .fluidOutputs(fluid('plastic') * 288)
        .EUt(30)
        .duration(30)
        .buildAndRegister()

POLYMERIZATION.recipeBuilder()
        .notConsumable(metaitem('dustKaminskyCatalyst'))
        .fluidInputs(fluid('ethylene') * 144)
        .fluidOutputs(fluid('plastic') * 360)
        .EUt(30)
        .duration(30)
        .buildAndRegister()

POLYMERIZATION.recipeBuilder()
        .circuitMeta(1)
        .fluidInputs(fluid('ethylene') * 144)
        .fluidOutputs(fluid('plastic') * 144)
        .EUt(30)
        .duration(300)
        .buildAndRegister()

// POLYPROPYLENE

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