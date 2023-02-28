class Combustible {
    String name
    boolean isPlasma
    int amountRequired
    int duration
    String byproduct
    int byproductAmount

    Combustible(name, isPlasma, amountRequired, duration, byproduct, byproductAmount) {
        this.name = name
        this.isPlasma = isPlasma
        this.amountRequired = amountRequired
        this.duration = duration
        this.byproduct = byproduct
        this.byproductAmount = byproductAmount
    }
}

class Comburent {
    String name
    int amountRequired
    int duration

    Comburent(name, amountRequired, duration) {
        this.name = name
        this.amountRequired = amountRequired
        this.duration = duration
    }
}

class CoolantGases {
    String name
    String byproduct
    int amount
    int duration

    CoolantGases(name, byproduct, amount, duration) {
        this.name = name
        this.byproduct = byproduct
        this.amount = amount
        this.duration = duration
    }
}


def SINTERING_RECIPES = recipemap("sintering_oven")

def fuels = [
    new Combustible('methane', false, 100, 100, 'carbon_dioxide', 50),
    new Combustible('plasma.helium', true, 10, 10, 'helium', 10)
]

def comburents = [
    new Comburent('air', 100, 50)
]

for (fuel in fuels) {

    if (fuel.isPlasma) {

        SINTERING_RECIPES.recipeBuilder()
        .inputs(ore('dustClay'))
        .inputs(metaitem('limestone.dust'))
        .fluidInputs(fluid(fuel.name) * fuel.amountRequired)
        .outputs(metaitem('hot.cement.clinker'))
        .fluidOutputs(fluid(fuel.byproduct) * fuel.byproductAmount)
        .duration(fuel.duration)
        .EUt(600)
        .buildAndRegister()

    } else {

        for (comburent in comburents) {

            SINTERING_RECIPES.recipeBuilder()
            .inputs(ore('dustClay'))
            .inputs(metaitem('limestone.dust'))
            .fluidInputs(fluid(fuel.name) * fuel.amountRequired)
            .fluidInputs(fluid(comburent.name) * comburent.amountRequired)
            .outputs(metaitem('hot.cement.clinker'))
            .fluidOutputs(fluid(fuel.byproduct) * fuel.byproductAmount)
            .duration(fuel.duration + comburent.duration)
            .EUt(6)
            .buildAndRegister()

        }
    }

}

def gases = [
    new CoolantGases('air', 'hot_air', 100, 40)
]

for (gas in gases) {
    mods.gregtech.mixer.recipeBuilder()
        .inputs(metaitem('hot.cement.clinker'))
        .fluidInputs(fluid(gas.name) * gas.amount)
        .outputs(metaitem('cement.clinker'))
        .fluidOutputs(fluid(gas.byproduct) * gas.amount)
        .duration(gas.duration)
        .EUt(6)
        .buildAndRegister()
}