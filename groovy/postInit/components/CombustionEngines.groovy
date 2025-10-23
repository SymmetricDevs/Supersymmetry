import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*
import postInit.utils.RecyclingHelper

ASSEMBLER.recipeBuilder()
    .circuitMeta(16)
    .inputs(ore('boltIridium'))
    .inputs(ore('plateStainlessSteel'))
    .inputs(ore('boltStainlessSteel'))
    .inputs(metaitem('sintered_alumina.insulator'))
    .inputs(metaitem('cableGtSingleCopper'))
    .outputs(metaitem('engine.spark_plug'))
    .duration(100)
    .EUt(VA[HV])
    .buildAndRegister()

RecyclingHelper.handleRecycling(metaitem('engine.spark_plug'), [
    ore('stickIridium'),
    ore('plateStainlessSteel'),
    ore('boltStainlessSteel'),
    metaitem('cableGtSingleCopper'),
])

ASSEMBLER.recipeBuilder()
    .circuitMeta(16)
    .inputs(ore('plateDoubleStainlessSteel'))
    .inputs(ore('boltStainlessSteel'))
    .inputs(ore('ringStainlessSteel') * 4)
    .inputs(ore('ingotStainlessSteel'))
    .outputs(metaitem('engine.piston'))
    .duration(100)
    .EUt(VA[HV])
    .buildAndRegister()

RecyclingHelper.handleRecycling(metaitem('engine.piston'), [
    ore('plateDoubleStainlessSteel'),
    ore('boltStainlessSteel'),
    ore('ringStainlessSteel') * 4,
    ore('ingotStainlessSteel'),
])

BENDER.recipeBuilder()
    .circuitMeta(16)
    .inputs(ore('stickLongStainlessSteel') * 2)
    .outputs(metaitem('engine.crankshaft'))
    .duration(100)
    .EUt(VA[HV])
    .buildAndRegister()

RecyclingHelper.handleRecycling(metaitem('engine.crankshaft'), [
    ore('stickLongStainlessSteel') * 2,
])
