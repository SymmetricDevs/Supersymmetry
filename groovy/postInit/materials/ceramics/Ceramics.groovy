import static prePostInit.Recipemaps.*
import globals.Sintering
import static gregtech.api.GTValues.*

// PVA binder

MIXER.recipeBuilder()
    .inputs(ore('dustPolyvinylAlcohol'))
    .fluidInputs(fluid('distilled_water') * 1000)
    .fluidOutputs(fluid('polyvinyl_alcohol_binder') * 1000)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

// Alumina

Sintering.blankets.each { blanket ->
    SINTERING_OVEN.recipeBuilder()
        .inputs(ore('dustAlumina') * 10)
        .fluidInputs(fluid('polyvinyl_alcohol_binder') * 200)
        .notConsumable(metaitem('shape.mold.ring'))
        .fluidInputs(fluid(blanket.name) * blanket.amountRequired)
        .outputs(metaitem('sintered_alumina.insulator'))
        .duration(blanket.duration)
        .EUt(VA[MV])
        .buildAndRegister()
}

SINTERING_OVEN.recipeBuilder()
        .inputs(ore('dustAlumina') * 5)
        .inputs(ore('dustSmallGraphite'))    
        .notConsumable(metaitem('shape.mold.plate'))
        .outputs(metaitem('membrane.support.alumina'))
        .duration(300)
        .EUt(VA[MV])
        .buildAndRegister()

// Boron carbide

ARC_FURNACE.recipeBuilder()
    .inputs(ore('dustBoronTrioxide') * 10)
    .inputs(ore('dustAnyPurityCarbon') * 7)
    .outputs(metaitem('dustBoronCarbide') * 5)
    .fluidOutputs(fluid('carbon_monoxide') * 6000)
    .duration(300)
    .EUt(VA[LV])
    .buildAndRegister()

Sintering.blankets.each { blanket ->
    if (blanket.tier >= 2) {
        SINTERING_OVEN.recipeBuilder()
        .inputs(ore('dustBoronCarbide'))
        .fluidInputs(fluid('novolacs') * 100)
        .notConsumable(metaitem('shape.mold.rod'))
        .fluidInputs(fluid(blanket.name) * blanket.amountRequired)
        .outputs(metaitem('stickBoronCarbide') * 2)
        .duration(blanket.duration)
        .EUt(VA[MV])
        .buildAndRegister()
    }
}

// Long Boron Carbide Rod * 1
mods.gregtech.forge_hammer.removeByInput(16, [metaitem('stickBoronCarbide') * 2], null)

Sintering.blankets.each { blanket ->
    if (blanket.tier >= 2) {
        SINTERING_OVEN.recipeBuilder()
            .inputs(ore('dustBoronCarbide'))
            .fluidInputs(fluid('novolacs') * 100)
            .notConsumable(metaitem('shape.mold.long_rod'))
            .fluidInputs(fluid(blanket.name) * blanket.amountRequired)
            .outputs(metaitem('stickLongBoronCarbide'))
            .duration(blanket.duration)
            .EUt(VA[MV])
            .buildAndRegister()
    }
}

// Boron nitride

CVD.recipeBuilder()
    .fluidInputs(fluid('boron_trichloride') * 1000)
    .fluidInputs(fluid('ammonia') * 1000)
    .outputs(metaitem('dustBoronNitride') * 2)
    .fluidOutputs(fluid('hydrogen_chloride') * 3000)
    .duration(120)
    .EUt(VA[LV])
    .buildAndRegister()

FORMING_PRESS.recipeBuilder()
    .inputs(ore('dustBoronNitride') * 14)
    .notConsumable(metaitem('shape.mold.crucible'))
    .outputs(metaitem('crucible.boron.nitride'))
    .duration(2000)
    .EUt(VA[MV])
    .buildAndRegister()

HOT_ISOSTATIC_PRESS.recipeBuilder()
    .inputs(ore('dustBoronNitride') * 12)
    .outputs(metaitem('nozzle.boron_nitride'))
    .duration(600)
    .EUt(VA[HV])
    .buildAndRegister()
