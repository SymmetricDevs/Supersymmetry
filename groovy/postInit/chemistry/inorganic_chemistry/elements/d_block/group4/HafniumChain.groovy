import static prePostInit.Recipemaps.*
import globals.Globals
import globals.Carbons
import static gregtech.api.GTValues.*

MIXER_SETTLER.recipeBuilder()
    .fluidInputs(fluid('hafnium_extract') * 1000)
    .fluidInputs(fluid('diluted_sulfuric_acid') * 80)
    .fluidOutputs(fluid('hafnium_extraction_mixture') * 1000)
    .fluidOutputs(fluid('hafnium_sulfate_solution') * 40)
    .EUt(VA[HV])
    .requiredCells(2)
    .duration(40)
    .buildAndRegister()

ROASTER.recipeBuilder()
    .fluidInputs(fluid('hafnium_sulfate_solution') * 2000)
    .outputs(metaitem('dustHafniumDioxide') * 3)
    .fluidOutputs(fluid('dense_steam') * 2000)
    .fluidOutputs(fluid('sulfur_trioxide') * 2000)
    .EUt(VA[HV])
    .duration(100)
    .buildAndRegister()

for (highPurityCombustible in Carbons.highPurityCombustibles()) {
    FLUIDIZED_BR.recipeBuilder()
        .inputs(ore('dustHafniumDioxide') * 3)
        .inputs(ore(highPurityCombustible.name) * highPurityCombustible.equivalent(2))
        .fluidInputs(fluid('chlorine') * 4000)
        .outputs(metaitem('dustImpureHafniumTetrachloride') * 5)
        .fluidOutputs(fluid('carbon_monoxide') * 2000)
        .duration(200 * highPurityCombustible.duration)
        .EUt(VA[HV])
        .buildAndRegister()
}

REACTION_FURNACE.recipeBuilder()
    .inputs(ore('dustImpureHafniumTetrachloride') * 5)
    .notConsumable(fluid('nitrogen') * 1000)
    .notConsumable(fluid('hydrogen') * 1000)
    .fluidOutputs(fluid('hafnium_tetrachloride') * 720)
    .duration(100)
    .EUt(VA[EV])
    .buildAndRegister()

for (inertGas in Globals.inertGases) {
    ERF.recipeBuilder()
        .circuitMeta(2)
        .fluidInputs(fluid('hafnium_tetrachloride') * 720)
        .notConsumable(fluid(inertGas.name) * inertGas.amount_required)
        .inputs(ore('dustAnyPurityMagnesium') * 2)
        .outputs(metaitem('sponge.hafnium.crude'))
        .fluidOutputs(fluid('magnesium_chloride') * 864)
        .blastFurnaceTemp(2150)
        .duration(100 * inertGas.duration)
        .EUt(VA[EV])
        .buildAndRegister()
}

VACUUM_CHAMBER.recipeBuilder()
    .inputs(metaitem('sponge.hafnium.crude'))
    .outputs(metaitem('sponge.hafnium'))
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

MACERATOR.recipeBuilder()
    .inputs(metaitem('sponge.hafnium'))
    .outputs(metaitem('dustHafnium'))
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

//VAN ARKEL-DE BOER

BR.recipeBuilder()
    .inputs(ore('dustHafnium'))
    .inputs(ore('dustAnyPurityIodine') * 4)
    .outputs(metaitem('dustHafniumIodide') * 5)
    .duration(360)
    .EUt(VA[HV])
    .buildAndRegister()

CVD.recipeBuilder()
    .inputs(ore('dustHafniumIodide') * 5)
    .notConsumable(metaitem('stickTungsten'))
    .outputs(metaitem('dustHighPurityHafnium'))
    .fluidOutputs(fluid('iodine') * 576)
    .duration(180)
    .EUt(VA[EV])
    .buildAndRegister()
