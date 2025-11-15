import supersymmetry.loaders.recipes.handlers.RecyclingManager

event_manager.listen { RecyclingManager.PreRecyclingEvent event ->
    RecyclingManager.addRecyclingGroovy(metaitem('electric.motor.lv') * 6, [
        ore('cableGtSingleTin') * 2,
        ore('stickLongSteel'),
        ore('plateSteelMagnetic') * 3,
        ore('wireGtSingleCopper') * 4
    ])

    RecyclingManager.addRecyclingGroovy(metaitem('electric.motor.mv') * 6, [
        ore('cableGtSingleCopper') * 2,
        ore('stickLongAluminium'),
        ore('plateSteelMagnetic') * 3,
        ore('wireGtDoubleAnnealedCopper') * 4
    ])

    RecyclingManager.addRecyclingGroovy(metaitem('electric.motor.hv') * 6, [
        ore('cableGtDoubleSilver') * 2,
        ore('stickLongStainlessSteel'),
        ore('plateAlnicoMagnetic') * 3,
        ore('wireGtDoubleElectrum') * 4
    ])

    RecyclingManager.addRecyclingGroovy(metaitem('electric.motor.ev') * 6, [
        ore('cableGtDoubleAluminium') * 2,
        ore('stickLongTitanium'),
        ore('plateAlnicoMagnetic') * 3,
        ore('wireGtDoubleGold') * 4
    ])

    RecyclingManager.addRecyclingGroovy(metaitem('electric.motor.iv') * 3, [
        ore('cableGtDoublePlatinum') * 2,
        ore('stickLongTungstenSteel'),
        ore('plateNeodymiumAlloyMagnetic') * 3,
        ore('wireGtDoubleGraphene') * 4
    ])

    RecyclingManager.addRecyclingGroovy(metaitem('voltage_coil.ev'), [
        ore('stickAlnicoMagnetic'),
        ore('wireFinePlatinum') * 16
    ])

    RecyclingManager.addRecyclingGroovy(item('gregtech:metal_casing', 4) * 4, [
        ore('frameGtSteel'),
        ore('plateSteel') * 6
    ])

    RecyclingManager.addRecyclingGroovy(item('gregtech:boiler_casing', 1) * 4, [
        ore('frameGtSteel'),
        ore('pipeNormalFluidSteel') * 4,
        ore('plateSteel') * 4
    ])

    RecyclingManager.addRecyclingGroovy(item('gregtech:boiler_firebox_casing', 1) * 4, [
        ore('frameGtSteel'),
        ore('stickSteel') * 4,
        ore('plateSteel') * 4
    ])

    RecyclingManager.addRecyclingGroovy(metaitem('engine.spark_plug.palladium'), [
    ore('boltPalladium'),
    ore('plateSteel'),
    ore('boltSteel'),
    metaitem('cableGtSingleCopper'),
    ])

    RecyclingManager.addRecyclingGroovy(metaitem('engine.spark_plug.iridium'), [
        ore('boltIridium'),
        ore('plateStainlessSteel'),
        ore('boltStainlessSteel'),
        metaitem('cableGtSingleCopper'),
    ])

    RecyclingManager.addRecyclingGroovy(metaitem('engine.piston'), [
        ore('plateDoubleStainlessSteel'),
        ore('boltStainlessSteel'),
        ore('ringStainlessSteel') * 4,
        ore('ingotStainlessSteel'),
    ])

    RecyclingManager.addRecyclingGroovy(metaitem('engine.crankshaft'), [
        ore('stickLongSteel') * 2,
        ore('ringSteel') * 2
    ])
}
