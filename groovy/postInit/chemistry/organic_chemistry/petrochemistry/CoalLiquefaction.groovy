import globals.Globals

FBR = recipemap('fixed_bed_reactor')
FLBR = recipemap('fluidized_bed_reactor')
SIEVE_DT = recipemap('sieve_distillation')
VACUUM_DT = recipemap('vacuum_distillation')

FBR.recipeBuilder()
    .notConsumable(ore('catalystBedSupportedNickel'))
    .fluidInputs(fluid('naphthalene') * 1000)
    .fluidInputs(fluid('hydrogen') * 4000)
    .fluidOutputs(fluid('tetralin') * 1000)
    .duration(40)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

FLBR.recipeBuilder()
    .notConsumable(ore('dustSupportedNickel'))
    .notConsumable(fluid('tetralin') * 8000)
    .inputs(ore('dustCoal') * 16)
    .fluidInputs(fluid('hydrogen') * 22440)
    .fluidOutputs(fluid('fuel_gas') * 4830)
    .fluidOutputs(fluid('liquefaction_oil') * 940)
    .duration(30)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

SIEVE_DT.recipeBuilder()
    .fluidInputs(fluid('liquefaction_oil') * 940)
    .fluidOutputs(fluid('light_liquefaction_oil') * 610)
    .fluidOutputs(fluid('crude_medium_liquefaction_oil') * 330)
    .duration(30)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

VACUUM_DT.recipeBuilder()
    .fluidInputs(fluid('crude_medium_liquefaction_oil') * 330)
    .outputs(metaitem('dustCoal') * 4)
    .fluidOutputs(fluid('medium_liquefaction_oil') * 300)
    .duration(30)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

def oils = [
    'light_liquefaction_oil',
    'medium_liquefaction_oil'
]

for (oil in oils) {
    FLUID_HEATER.recipeBuilder()
        .fluidInputs(fluid(oil) * 1000)
        .fluidOutputs(fluid('heated_' + oil) * 1000)
        .duration(40)
        .EUt(30)
        .buildAndRegister()

    FBR.recipeBuilder()
        .fluidInputs(fluid('heated_' + oil) * 1000)
        .fluidInputs(fluid('hydrogen') * 10)
        .notConsumable(metaitem('catalystBedHydrotreatingCatalyst'))
        .fluidOutputs(fluid('treated_sulfuric_' + oil) * 1000)
        .duration(15)
        .EUt(30)
        .buildAndRegister()
}

DT.recipeBuilder()
    .fluidInputs(fluid('treated_sulfuric_light_liquefaction_oil') * 1000)
    .fluidOutputs(fluid('naphtha') * 1000)
    .fluidOutputs(fluid('sour_gas') * 10)
    .duration(50)
    .EUt(30)
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('treated_sulfuric_medium_liquefaction_oil') * 1000)
    .fluidOutputs(fluid('light_gas_oil') * 1000)
    .fluidOutputs(fluid('sour_gas') * 10)
    .duration(50)
    .EUt(30)
    .buildAndRegister()