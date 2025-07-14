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
        ore('wireGtDoubleCupronickel') * 4
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
        ore('wireGtDoubleKanthal') * 4
    ])

    RecyclingManager.addRecyclingGroovy(metaitem('electric.motor.iv') * 6, [
        ore('cableGtDoubleTungsten') * 2,
        ore('stickLongTungstenSteel'),
        ore('plateAlnicoMagnetic') * 3,
        ore('wireGtDoubleGraphene') * 4
    ])
}