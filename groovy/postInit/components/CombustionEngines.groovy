import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*
import postInit.utils.RecyclingHelper

ASSEMBLER.recipeBuilder()
    .circuitMeta(16)
    .inputs(ore('boltPalladium'))
    .inputs(ore('plateSteel'))
    .inputs(ore('boltSteel'))
    .inputs(metaitem('sintered_alumina.insulator'))
    .inputs(metaitem('cableGtSingleCopper'))
    .outputs(metaitem('engine.spark_plug.palladium'))
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .circuitMeta(16)
    .inputs(ore('boltIridium'))
    .inputs(ore('plateStainlessSteel'))
    .inputs(ore('boltStainlessSteel'))
    .inputs(metaitem('sintered_alumina.insulator'))
    .inputs(metaitem('cableGtSingleCopper'))
    .outputs(metaitem('engine.spark_plug.iridium'))
    .duration(100)
    .EUt(VA[HV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .circuitMeta(16)
    .inputs(ore('plateDoubleSteel'))
    .inputs(ore('boltSteel'))
    .inputs(ore('ringSteel') * 4)
    .inputs(ore('ingotSteel'))
    .outputs(metaitem('engine.piston'))
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .circuitMeta(16)
    .inputs(ore('stickLongSteel') * 2)
    .inputs(ore('ringSteel') * 2)
    .outputs(metaitem('engine.crankshaft'))
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .circuitMeta(16)
    .inputs(ore('plateSteel') * 4)
    .inputs(ore('frameGtSteel'))
    .inputs(ore('pipeTinyFluidSteel'))
    .inputs(metaitem('engine.piston'))
    .inputs(metaitem('engine.spark_plug.palladium'))
    .inputs(metaitem('electric.pump.mv'))
    .fluidInputs(fluid('lubricant') * 100)
    .outputs(item('susy:engine_casing'))
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister()

RecyclingHelper.handleRecycling(item('susy:engine_casing'), [
    ore('plateSteel') * 4,
    ore('frameGtSteel'),
    ore('pipeTinyFluidSteel'),
    metaitem('engine.piston'),
    metaitem('engine.spark_plug.palladium'),
    metaitem('electric.pump.mv'),
])

ASSEMBLER.recipeBuilder()
    .circuitMeta(16)
    .inputs(ore('plateSteel') * 3)
    .inputs(ore('frameGtSteel'))
    .inputs(ore('pipeTinyFluidSteel') * 2)
    .inputs(metaitem('engine.crankshaft'))
    .fluidInputs(fluid('lubricant') * 100)
    .outputs(item('susy:engine_casing_2'))
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister()

RecyclingHelper.handleRecycling(item('susy:engine_casing_2'), [
    ore('plateSteel') * 3,
    ore('frameGtSteel'),
    ore('pipeTinyFluidSteel') * 2,
    metaitem('engine.crankshaft'),
])

RecyclingHelper.addShaped("susy:basic_intake", item('susy:active_casing') * 2, [
    [ore('pipeNormalFluidSteel'),ore('craftingToolHardHammer'),ore('pipeNormalFluidSteel')],
    [ore('rotorSteel'),item('gregtech:metal_casing', 4),ore('rotorSteel')],
    [ore('pipeNormalFluidSteel'),ore('craftingToolWrench'),ore('pipeNormalFluidSteel')]
])

ASSEMBLER.recipeBuilder()
    .inputs(ore('rotorSteel') * 2)
    .inputs(ore('pipeNormalFluidSteel') * 4)
    .inputs(item('gregtech:metal_casing', 4))
    .outputs(item('susy:active_casing') * 2)
    .duration(50)
    .EUt(VHA[LV])
    .buildAndRegister()