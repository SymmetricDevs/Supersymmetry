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