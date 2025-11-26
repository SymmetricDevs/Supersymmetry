import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*
import postInit.utils.RecyclingHelper

// Recipes for the machines and components needed for the multiblocks

// Rolls
SOLIDIFIER.recipeBuilder()
    .fluidInputs(fluid('vanadium_steel') * 432)
    .notConsumable(metaitem('shape.mold.cylinder'))
    .outputs(metaitem('work_roll.unfinished'))
    .EUt(VA[LV])
    .duration(80)
    .buildAndRegister()

POLISHING_MACHINE.recipeBuilder()
    .inputs(metaitem('work_roll.unfinished'))
    .fluidInputs(fluid('silicon_dioxide_slurry') * 100)
    .outputs(item('susy:metallurgy_roll'))
    .EUt(VA[MV])
    .duration(200)
    .buildAndRegister()

// Hydraulic Press
ASSEMBLER.recipeBuilder()
    .inputs(ore('plateDoubleStainlessSteel'))
    .inputs(ore('stickStainlessSteel'))
    .inputs(ore('boltStainlessSteel') * 4)
    .inputs(ore('ringStyreneButadieneRubber') * 2)
    .inputs(ore('pipeNormalFluidStainlessSteel'))
    .fluidInputs(fluid('hydraulic_fluid') * 1000)
    .outputs(item('susy:metallurgy'))
    .EUt(VA[MV])
    .duration(300)
    .buildAndRegister()

// Flying Shear Saw
ASSEMBLER.recipeBuilder()
    .inputs(metaitem('component.grinder.diamond'))
    .inputs(ore('stickStainlessSteel'))
    .inputs(item('gregtech:metal_casing', 4))
    .inputs(metaitem('electric.motor.hv'))
    .inputs(metaitem('cableGtSingleGold') * 2)
    .outputs(item('susy:metallurgy_2'))
    .EUt(VA[LV])
    .duration(100)
    .buildAndRegister()

// Monel 500 casings
ASSEMBLER.recipeBuilder()
    .inputs(metaitem('plateMonel500') * 6)
    .inputs(ore('frameGtHsla980X'))
    .outputs(item('susy:susy_multiblock_casing', 5) * 4)
    .EUt(VA[LV])
    .duration(100)
    .buildAndRegister()

// Pipe casing
RecyclingHelper.addShaped("susy:monel_500_pipe_casing", item('susy:susy_multiblock_casing', 6) * 2, [
    [ore('plateMonel500'), ore('pipeNormalFluidMonel500'), ore('plateMonel500')],
    [ore('pipeNormalFluidMonel500'), ore('frameGtHsla980X'), ore('pipeNormalFluidMonel500')],
    [ore('plateMonel500'), ore('pipeNormalFluidMonel500'), ore('plateMonel500')]
])

ASSEMBLER.recipeBuilder()
    .circuitMeta(6)
    .inputs(metaitem('plateCopper') * 4)
    .inputs(ore('frameGtSteel'))
    .inputs(ore('pipeNormalFluidCopper') * 4)
    .outputs(item('susy:susy_multiblock_casing', 7) * 2)
    .EUt(VA[LV])
    .duration(50)
    .buildAndRegister()

RecyclingHelper.addShaped("susy:copper_pipe_casing", item('susy:susy_multiblock_casing', 7) * 2, [
    [ore('plateCopper'), ore('pipeNormalFluidCopper'), ore('plateCopper')],
    [ore('pipeNormalFluidCopper'), ore('frameGtSteel'), ore('pipeNormalFluidCopper')],
    [ore('plateCopper'), ore('pipeNormalFluidCopper'), ore('plateCopper')]
])

// Machines

// Gas atomizer
ASSEMBLER.recipeBuilder()
    .inputs(item('gregtech:boiler_casing', 1))
    .inputs(ore('circuitEv') * 2)
    .inputs(metaitem('electric.pump.ev') * 4)
    .inputs(metaitem('nozzle.boron_nitride'))
    .inputs(ore('plateBoronNitride') * 64)
    .circuitMeta(20)
    .outputs(metaitem('susy:gas_atomizer'))
    .EUt(VA[EV])
    .duration(300)
    .buildAndRegister()

RecyclingHelper.handleRecycling(metaitem('susy:gas_atomizer'), [
    ore('plateBoronNitride') * 64,
    metaitem('nozzle.boron_nitride'),
    metaitem('electric.pump.ev') * 4,
    ore('circuitEv') * 2,
    item('gregtech:boiler_casing', 1)
])

// Hot isostatic press
RecyclingHelper.addShaped("susy:hot_isostatic_press", metaitem('susy:hot_isostatic_press'), [
    [ore('plateStainlessSteel'), metaitem('electric.pump.hv'), ore('plateStainlessSteel')],
        [ore('circuitHv'), item('gregtech:metal_casing', 5), ore('circuitHv')],
        [ore('plateStainlessSteel'), metaitem('electric.piston.hv'), ore('plateStainlessSteel')]
])

// Metallurgical converter
ASSEMBLER.recipeBuilder()
    .inputs(item('gregtech:metal_casing', 4))
    .inputs(ore('circuitEv') * 2)
    .inputs(metaitem('electric.motor.ev') * 2)
    .inputs(metaitem('electric.pump.ev'))
    .circuitMeta(2)
    .outputs(metaitem('susy:metallurgical_converter'))
    .EUt(VA[EV])
    .duration(300)
    .buildAndRegister()

RecyclingHelper.handleRecycling(metaitem('susy:metallurgical_converter'), [
    item('gregtech:metal_casing', 4),
    metaitem('electric.motor.ev') * 2,
    metaitem('electric.pump.ev'),
    ore('circuitEv') * 2
])

// Turning zone
RecyclingHelper.addShaped("susy:turning_zone", metaitem('susy:turning_zone'), [
    [ore('gearUltimet'), metaitem('cableGtOctalNichrome'), ore('gearUltimet')],
    [metaitem('electric.motor.ev'), item('gregtech:metal_casing', 4), metaitem('electric.motor.ev')],
    [metaitem('electric.motor.ev'), ore('circuitMv'), metaitem('electric.motor.ev')]
])

// Rolling mill and cluster mill
RecyclingHelper.addShaped("susy:rolling_mill", metaitem('susy:rolling_mill'), [
    [ore('gearUltimet'), metaitem('cableGtOctalNichrome'), ore('gearUltimet')],
    [metaitem('electric.pump.ev'), item('gregtech:boiler_casing', 1), metaitem('electric.pump.ev')],
    [metaitem('electric.motor.ev'), metaitem('cableGtOctalNichrome'), metaitem('electric.motor.ev')]
])

RecyclingHelper.addShaped("susy:cluster_mill", metaitem('susy:cluster_mill'), [
    [ore('gearUltimet'), metaitem('cableGtHexNichrome'), ore('gearUltimet')],
    [metaitem('electric.pump.ev'), item('gregtech:boiler_casing', 1), metaitem('electric.pump.ev')],
    [metaitem('electric.motor.ev'), metaitem('cableGtHexNichrome'), metaitem('electric.motor.ev')]
])

// Flying shear
RecyclingHelper.addShaped("susy:flying_shear", metaitem('susy:flying_shear'), [
    [ore('gearUltimet'), metaitem('cableGtOctalNichrome'), ore('gearUltimet')],
    [metaitem('sensor.ev'), item('gregtech:metal_casing', 4), metaitem('electric.piston.ev')],
    [metaitem('electric.motor.ev'), ore('circuitEv'), metaitem('electric.piston.ev')]
])

// Molds
RecyclingHelper.addShaped("susy:slab_mold", metaitem('susy:slab_mold'), [
    [metaitem('electric.pump.ev'), metaitem('plateDoubleCopper'), metaitem('electric.pump.ev')],
    [metaitem('sensor.ev'), metaitem('plateDoubleCopper'), ore('circuitEv')],
    [metaitem('electric.pump.ev'), metaitem('plateDoubleCopper'), metaitem('electric.pump.ev')]
])

RecyclingHelper.addShaped("susy:billet_mold", metaitem('susy:billet_mold'), [
    [metaitem('electric.pump.ev'), metaitem('plateSteel'), metaitem('electric.pump.ev')],
    [metaitem('sensor.ev'), metaitem('plateDoubleCopper'), ore('circuitEv')],
    [metaitem('electric.pump.ev'), metaitem('plateSteel'), metaitem('electric.pump.ev')]
])

RecyclingHelper.addShaped("susy:strand_cooler", metaitem("susy:strand_cooler"), [
    [metaitem('electric.pump.ev'), ore('pipeNormalFluidMonel500'), metaitem('electric.pump.ev')],
    [item('susy:metallurgy_roll'), ore('circuitEv'), item('susy:metallurgy_roll')],
    [metaitem('electric.motor.ev'), ore('pipeNormalFluidMonel500'), metaitem('electric.motor.ev')]
])

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('electric.motor.ev') * 2)
    .inputs(item('susy:metallurgy_roll'))
    .inputs(metaitem('hull.ev'))
    .fluidInputs(fluid('soldering_alloy') * 288)
    .circuitMeta(1)
    .outputs(metaitem('susy:strand_bus.import'))
    .EUt(VA[EV])
    .duration(300)
    .buildAndRegister()

RecyclingHelper.handleRecycling(metaitem('susy:strand_bus.import'), [
    metaitem('electric.motor.ev') * 2,
    ore('ingotVanadiumSteel') * 3,
    ore('ingotSolderingAlloy') * 2,
    metaitem('hull.ev')
])

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('electric.motor.ev') * 2)
    .inputs(item('susy:metallurgy_roll'))
    .inputs(metaitem('hull.ev'))
    .fluidInputs(fluid('soldering_alloy') * 288)
    .circuitMeta(2)
    .outputs(metaitem('susy:strand_bus.export'))
    .EUt(VA[EV])
    .duration(300)
    .buildAndRegister()

RecyclingHelper.handleRecycling(metaitem('susy:strand_bus.export'), [
    metaitem('electric.motor.ev') * 2,
    ore('ingotVanadiumSteel') * 3,
    ore('ingotSolderingAlloy') * 2,
    metaitem('hull.ev')
])

// Interconversion
crafting.addShaped("susy:strand_bus_import_to_export", metaitem('susy:strand_bus.export'), [
    [ore('RecyclingHelperToolScrewdriver')],
    [metaitem('susy:strand_bus.import')]
])

crafting.addShaped("susy:strand_bus_export_to_import", metaitem('susy:strand_bus.import'), [
    [ore('RecyclingHelperToolScrewdriver')],
    [metaitem('susy:strand_bus.export')]
])

// Refractories
MIXER.recipeBuilder()
    .inputs(ore('dustAlumina') * 10)
    .inputs(ore('dustBauxite'))
    .inputs(ore('dustSiliconCarbide'))
    .inputs(ore('dustClay'))
    .fluidInputs(fluid('water') * 10000)
    .fluidOutputs(fluid('refractory_gunning_mixture') * 10000)
    .EUt(VA[ULV])
    .duration(10)
    .buildAndRegister()

