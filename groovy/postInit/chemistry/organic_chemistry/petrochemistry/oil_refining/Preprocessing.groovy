import petrochemistry.Petrochemistry

MIXER = recipemap('mixer')
ELECTROSTATIC_SEPARATOR = recipemap('electrostatic_separator')
CENTRIFUGE = recipemap('centrifuge')
FLUID_HEATER = recipemap('fluid_heater')

oils.each { _, oil -> {
        MIXER.recipeBuilder()
        .fluidInputs(fluid('water') * 100)
        .fluidInputs(oil.get(1000))
        .fluidOutputs(oil.getDiluted(1000))
        .duration(40)
        .EUt(30)
        .buildAndRegister()
    }
}

// Desalting

ELECTROSTATIC_SEPARATOR.recipeBuilder()
        .fluidInputs(fluid('diluted_oil') * 1000)
        .fluidOutputs(fluid('oily_brine') * 100)
        .fluidOutputs(fluid('desalted_oil') * 1000)
        .duration(40)
        .EUt(30)
        .buildAndRegister()

ELECTROSTATIC_SEPARATOR.recipeBuilder()
        .fluidInputs(fluid('diluted_oil_light') * 1000)
        .fluidOutputs(fluid('light_oily_brine') * 100)
        .fluidOutputs(fluid('desalted_oil_light') * 1000)
        .duration(40)
        .EUt(30)
        .buildAndRegister()

ELECTROSTATIC_SEPARATOR.recipeBuilder()
        .fluidInputs(fluid('diluted_oil_heavy') * 1000)
        .fluidOutputs(fluid('heavy_oily_brine') * 100)
        .fluidOutputs(fluid('desalted_oil_heavy') * 1000)
        .duration(40)
        .EUt(30)
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('oily_brine') * 1000)
        .fluidOutputs(fluid('desalted_oil') * 200)
        .fluidOutputs(fluid('salt_water') * 1000)
        .duration(40)
        .EUt(30)
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('light_oily_brine') * 1000)
        .fluidOutputs(fluid('desalted_oil_light') * 200)
        .fluidOutputs(fluid('salt_water') * 1000)
        .duration(40)
        .EUt(30)
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('heavy_oily_brine') * 1000)
        .fluidOutputs(fluid('desalted_oil_heavy') * 200)
        .fluidOutputs(fluid('salt_water') * 1000)
        .duration(40)
        .EUt(30)
        .buildAndRegister()

// Preheating

oils.each { _, oil -> {
        FLUID_HEATER.recipeBuilder()
        .fluidInputs(oil.getDesalted(1000))
        .fluidOutputs(oil.getHeated(1000))
        .duration(40)
        .EUt(30)
        .buildAndRegister()
    }
}