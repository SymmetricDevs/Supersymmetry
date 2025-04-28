import globals.Globals
import postInit.utils.RecyclingHelper
import gregtech.api.recipes.ingredients.nbtmatch.*

ASSEMBLER = recipemap('assembler')

ASSEMBLER.recipeBuilder()
    .inputs(ore('plateAluminium') * 20)
    .inputs(ore('plateReinforcedEpoxyResin') * 20)
    .inputs(ore('pipeSmallFluidAluminium') * 6)
    .inputs(ore('stickLongStainlessSteel') * 8)
    .inputs(ore('ringStainlessSteel') * 8)
    .inputs(ore('plateStainlessSteel') * 20)
    .inputs(metaitem('electric.pump.ev') * 4)
    .inputs(metaitem('electric.motor.ev'))
    .fluidInputs(fluid('supreme_lubricant') * 5000)
    .circuitMeta(22)
    .outputs(item('supercritical:gas_centrifuge_casing') * 5)
    .duration(240)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()

RecyclingHelper.handleRecycling(item('supercritical:gas_centrifuge_casing') * 5,
    [ore('plateAluminium') * 20,
    ore('pipeSmallFluidAluminium') * 6,
    ore('stickLongStainlessSteel') * 8,
    ore('ringStainlessSteel') * 8,
    ore('plateStainlessSteel') * 20,
    metaitem('electric.pump.ev') * 4,
    metaitem('electric.motor.ev')]
)

// Gas Centrifuge Heater
ASSEMBLER.recipeBuilder()
    .inputs(ore('springKanthal') * 4)
    .inputs(ore('plateStainlessSteel') * 4)
    .inputs(ore('cableGtSingleAluminium') * 4)
    .inputs(ore('frameGtStainlessSteel'))
    .outputs(item('supercritical:nuclear_casing', 1))
    .circuitMeta(22)
    .duration(240)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()

RecyclingHelper.handleRecycling(item('supercritical:nuclear_casing', 1),
    [ore('springKanthal') * 4,
    ore('plateStainlessSteel') * 4,
    ore('cableGtSingleAluminium') * 4,
    ore('frameGtStainlessSteel')]
)

// Gas Centrifuge Controller
ASSEMBLER.recipeBuilder()
    .inputs(metaitem('hull.ev'))
    .inputs(ore('circuitEv') * 8)
    .inputs(metaitem('plate.power_integrated_circuit') * 4)
    .inputs(ore('pipeSmallFluidAluminium') * 16)
    .inputs(metaitem('electric.pump.ev') * 4)
    .circuitMeta(22)
    .outputs(item('gregtech:machine', 14403))
    .duration(240)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

RecyclingHelper.handleRecycling(item('gregtech:machine', 14403),
    [metaitem('hull.ev'),
    ore('circuitEv') * 8,
    metaitem('plate.power_integrated_circuit') * 4,
    ore('pipeSmallFluidAluminium') * 16,
    metaitem('electric.pump.ev') * 4]
)