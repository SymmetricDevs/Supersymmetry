import globals.Globals;
import postInit.utils.RecyclingHelper

FORMINGPRESS = recipemap('forming_press')
ASSEMBLER = recipemap('assembler')
BENDER = recipemap('bender')

FORMINGPRESS.recipeBuilder()
    .inputs(ore('dustAlumina') * 10)
    .notConsumable(metaitem('shape.mold.ring'))
    .outputs(metaitem('sintered_alumina.insulator'))
    .duration(500)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .circuitMeta(16)
    .inputs(ore('stickIridium'))
    .inputs(ore('plateStainlessSteel'))
    .inputs(ore('boltStainlessSteel'))
    .inputs(metaitem('sintered_alumina.insulator'))
    .inputs(metaitem('cableGtSingleCopper'))
    .outputs(metaitem('engine.spark_plug'))
    .duration(100)
    .EUt(Globals.voltAmps[3])
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
    .EUt(Globals.voltAmps[3])
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
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

RecyclingHelper.handleRecycling(metaitem('engine.crankshaft'), [
    ore('stickLongStainlessSteel') * 2,
])