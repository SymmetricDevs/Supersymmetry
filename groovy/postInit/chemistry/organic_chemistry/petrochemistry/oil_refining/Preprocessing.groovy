import static prePostInit.Recipemaps.*
import static globals.Petrochemistry.*
import static gregtech.api.GTValues.*

oils.each { _, oil -> {
        // Desalting
        MIXER.recipeBuilder()
            .fluidInputs(oil.get(1000))
            .fluidInputs(fluid('water') * 100)
            .fluidOutputs(oil.getDiluted(1100))
            .duration(20)
            .EUt(VA[LV])
            .buildAndRegister()
        
        ELECTROSTATIC_SEPARATOR.recipeBuilder()
            .fluidInputs(oil.getDiluted(1100))
            .fluidOutputs(oil.getBrine(100))
            .fluidOutputs(oil.getDesalted(980))
            .duration(20)
            .EUt(VA[LV])
            .buildAndRegister()

        CENTRIFUGE.recipeBuilder()
            .fluidInputs(oil.getBrine(1000))
            .fluidOutputs(oil.getDesalted(200))
            .fluidOutputs(fluid('brine') * 1000)
            .duration(20)
            .EUt(VA[LV])
            .buildAndRegister()

        // Preheating
        FLUID_HEATER.recipeBuilder()
            .fluidInputs(oil.getDesalted(1000))
            .fluidOutputs(oil.getHeated(1000))
            .duration(20)
            .EUt(VA[LV])
            .buildAndRegister()
    }
}
