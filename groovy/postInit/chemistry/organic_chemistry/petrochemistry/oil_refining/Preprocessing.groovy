import static globals.Petrochemistry.*

MIXER = recipemap('mixer')
ELECTROSTATIC_SEPARATOR = recipemap('electrostatic_separator')
CENTRIFUGE = recipemap('centrifuge')
FLUID_HEATER = recipemap('fluid_heater')

oils.each { _, oil -> {
        // Desalting
        MIXER.recipeBuilder()
            .fluidInputs(oil.get(1000))
            .fluidInputs(fluid('water') * 100)
            .fluidOutputs(oil.getDiluted(1100))
            .duration(20)
            .EUt(30)
            .buildAndRegister()
        
        ELECTROSTATIC_SEPARATOR.recipeBuilder()
            .fluidInputs(oil.getDiluted(1100))
            .fluidOutputs(oil.getBrine(100))
            .fluidOutputs(oil.getDesalted(980))
            .duration(20)
            .EUt(30)
            .buildAndRegister()

        CENTRIFUGE.recipeBuilder()
            .fluidInputs(oil.getBrine(1000))
            .fluidOutputs(oil.getDesalted(200))
            .fluidOutputs(fluid('salt_water') * 1000)
            .duration(20)
            .EUt(30)
            .buildAndRegister()

        // Preheating
        FLUID_HEATER.recipeBuilder()
            .fluidInputs(oil.getDesalted(1000))
            .fluidOutputs(oil.getHeated(1000))
            .duration(20)
            .EUt(30)
            .buildAndRegister()
    }
}