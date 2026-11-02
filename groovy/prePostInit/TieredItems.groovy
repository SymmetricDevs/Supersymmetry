package prePostInit

class TieredItems {
    static final def circuits = [ore('circuitUlv'), ore('circuitLv'), ore('circuitMv'),
                                 ore('circuitHv'), ore('circuitEv'), ore('circuitIv'),
                                 ore('circuitLuv'), ore('circuitZpm'), ore('circuitUv'),
                                 ore('circuitUhv'), ore('circuitUev'), ore('circuitUiv'),
                                 ore('circuitUxv'), ore('circuitOpv')];

    static final def conveyors = [null, metaitem('conveyor.module.lv'), metaitem('conveyor.module.mv'), metaitem('conveyor.module.hv'),
                                  metaitem('conveyor.module.ev'), metaitem('conveyor.module.iv'), metaitem('conveyor.module.luv'),
                                  metaitem('conveyor.module.zpm'), metaitem('conveyor.module.uv'), metaitem('conveyor.module.uhv'),
                                  metaitem('conveyor.module.uev'), metaitem('conveyor.module.uiv'), metaitem('conveyor.module.opv'),
                                  metaitem('conveyor.module.uxv')];

    static final def pumps = [null, metaitem('electric.pump.lv'), metaitem('electric.pump.mv'), metaitem('electric.pump.hv'),
                              metaitem('electric.pump.ev'), metaitem('electric.pump.iv'), metaitem('electric.pump.luv'),
                              metaitem('electric.pump.zpm'), metaitem('electric.pump.uv'), metaitem('electric.pump.uhv'),
                              metaitem('electric.pump.uev'), metaitem('electric.pump.uiv'), metaitem('electric.pump.uxv'),
                              metaitem('electric.pump.opv')];

/*static final def regulators = [null, metaitem('fluid.regulator.lv'), metaitem('fluid.regulator.mv'), metaitem('fluid.regulator.hv'),
         metaitem('fluid.regulator.ev'), metaitem('fluid.regulator.iv'), metaitem('fluid.regulator.luv'),
         metaitem('fluid.regulator.zpm'), metaitem('fluid.regulator.uv'), metaitem('fluid.regulator.uhv'),
         metaitem('fluid.regulator.uev'), metaitem('fluid.regulator.uiv'), metaitem('fluid.regulator.uxv'),
         metaitem('fluid.regulator.opv')];*/

    static final def field_generators = [null, metaitem('field.generator.lv'), metaitem('field.generator.mv'), metaitem('field.generator.hv'),
                                         metaitem('field.generator.ev'), metaitem('field.generator.iv'), metaitem('field.generator.luv'),
                                         metaitem('field.generator.zpm'), metaitem('field.generator.uv'), metaitem('field.generator.uhv'),
                                         metaitem('field.generator.uev'), metaitem('field.generator.uiv'), metaitem('field.generator.uxv'),
                                         metaitem('field.generator.opv')];

    static final def emitters = [null, metaitem('emitter.lv'), metaitem('emitter.mv'), metaitem('emitter.hv'),
                                 metaitem('emitter.ev'), metaitem('emitter.iv'), metaitem('emitter.luv'),
                                 metaitem('emitter.zpm'), metaitem('emitter.uv'), metaitem('emitter.uhv'),
                                 metaitem('emitter.uev'), metaitem('emitter.uiv'), metaitem('emitter.uxv'),
                                 metaitem('emitter.opv')];

    static final def sensors = [null, metaitem('sensor.lv'), metaitem('sensor.mv'), metaitem('sensor.hv'),
                                metaitem('sensor.ev'), metaitem('sensor.iv'), metaitem('sensor.luv'),
                                metaitem('sensor.zpm'), metaitem('sensor.uv'), metaitem('sensor.uhv'),
                                metaitem('sensor.uev'), metaitem('sensor.uiv'), metaitem('sensor.uxv'),
                                metaitem('sensor.opv')];

    static final def motors = [null, metaitem('electric.motor.lv'), metaitem('electric.motor.mv'), metaitem('electric.motor.hv'),
                               metaitem('electric.motor.ev'), metaitem('electric.motor.iv'), metaitem('electric.motor.luv'),
                               metaitem('electric.motor.zpm'), metaitem('electric.motor.uv'), metaitem('electric.motor.uhv'),
                               metaitem('electric.motor.uev'), metaitem('electric.motor.uiv'), metaitem('electric.motor.uxv'),
                               metaitem('electric.motor.opv')];

    static final def pistons = [null, metaitem('electric.piston.lv'), metaitem('electric.piston.mv'), metaitem('electric.piston.hv'),
                                metaitem('electric.piston.ev'), metaitem('electric.piston.iv'), metaitem('electric.piston.luv'),
                                metaitem('electric.piston.zpm'), metaitem('electric.piston.uv'), metaitem('electric.piston.uhv'),
                                metaitem('electric.piston.uev'), metaitem('electric.piston.uiv'), metaitem('electric.piston.uxv'),
                                metaitem('electric.piston.opv')];

    static final def robotArms = [null, metaitem('robot.arm.lv'), metaitem('robot.arm.mv'), metaitem('robot.arm.hv'),
                                  metaitem('robot.arm.ev'), metaitem('robot.arm.iv'), metaitem('robot.arm.luv'),
                                  metaitem('robot.arm.zpm'), metaitem('robot.arm.uv'), metaitem('robot.arm.uhv'),
                                  metaitem('robot.arm.uev'), metaitem('robot.arm.uiv'), metaitem('robot.arm.uxv'),
                                  metaitem('robot.arm.opv')];

    static final def hulls = [metaitem('hull.ulv'), metaitem('hull.lv'), metaitem('hull.mv'), metaitem('hull.hv'),
                              metaitem('hull.ev'), metaitem('hull.iv'), metaitem('hull.luv'),
                              metaitem('hull.zpm'), metaitem('hull.uv'), metaitem('hull.uhv'),
                              metaitem('hull.uev'), metaitem('hull.uiv'), metaitem('hull.uxv'),
                              metaitem('hull.opv')];

    static final def tieredWires = [ore('wireGtQuadrupleLead'), ore('wireGtQuadrupleCopper'), ore('wireGtQuadrupleCupronickel'), ore('wireGtQuadrupleNichrome'),
                                    ore('wireGtQuadrupleKanthal'), ore('stickMolybdenumDisilicide'), ore('wireGtQuadrupleTungsten'),
                                    ore('wireGtQuadrupleNaquadah'), ore('wireGtQuadrupleNaquadahAlloy')];

    static final def tieredPlates = [ore('plateWroughtIron'), ore('plateSteel'), ore('plateAluminium'), ore('plateStainlessSteel'),
                                     ore('plateTitanium'), ore('plateTungstenSteel'), ore('plateRhodiumPlatedPalladium'),
                                     ore('plateNaquadahAlloy'), ore('plateDarmstadtium')];

    static final def tieredSticks = [ore('stickWroughtIron'), ore('stickIron'), ore('stickSteel'), ore('stickSteel'),
                                     ore('stickNeodymiumAlloy'), ore('stickVanadiumGallium'), ore('stickVanadiumGallium'),
                                     ore('stickVanadiumGallium'), ore('stickVanadiumGallium')];

    static final def tieredGlass = [ore('blockGlass'), ore('blockGlass'), ore('blockGlass'), item('gregtech:transparent_casing:0'),
                                    item('gregtech:transparent_casing:0'), item('gregtech:transparent_casing:2'), item('gregtech:transparent_casing:2'),
                                    item('gregtech:transparent_casing:1'), item('gregtech:transparent_casing:1')];

    static final def tieredCables = [ore('cableGtSingleLead'), ore('cableGtSingleTin'), ore('cableGtSingleCopper'), ore('cableGtSingleGold'),
                                     ore('cableGtSingleAluminium'), ore('cableGtSinglePlatinum'), ore('cableGtSingleNiobiumTitanium'),
                                     ore('cableGtSingleVanadiumGallium'), ore('cableGtSingleYttriumBariumCuprate')]

    static final def tieredQuadCables = [ore('cableGtQuadrupleLead'), ore('cableGtQuadrupleTin'), ore('cableGtQuadrupleCopper'), ore('cableGtQuadrupleGold'),
                                         ore('cableGtQuadrupleAluminium'), ore('cableGtQuadruplePlatinum'), ore('cableGtQuadrupleNiobiumTitanium'),
                                         ore('cableGtQuadrupleVanadiumGallium'), ore('cableGtQuadrupleYttriumBariumCuprate')]

    static final def tieredOctCables = [ore('cableGtOctalLead'), ore('cableGtOctalTin'), ore('cableGtOctalCopper'), ore('cableGtOctalGold'),
                                        ore('cableGtOctalAluminium'), ore('cableGtOctalPlatinum'), ore('cableGtOctalNiobiumTitanium'),
                                        ore('cableGtOctalVanadiumGallium'), ore('cableGtOctalYttriumBariumCuprate')]

    static final def tieredHexCables = [ore('cableGtHexLead'), ore('cableGtHexTin'), ore('cableGtHexCopper'), ore('cableGtHexGold'),
                                        ore('cableGtHexAluminium'), ore('cableGtHexPlatinum'), ore('cableGtHexNiobiumTitanium'),
                                        ore('cableGtHexVanadiumGallium'), ore('cableGtHexYttriumBariumCuprate')]

    static final def tieredSprings = [metaitem('springIron'), metaitem('springCopper'), metaitem('springCupronickel'), metaitem('springNichrome'),
                                      metaitem('springKanthal'), metaitem('springMolybdenumDisilicide'), metaitem('springTungsten'),
                                      metaitem('springNaquadah'), metaitem('springNaquadahAlloy')]

    static final def rotors = [
        ore('rotorLead'),
        ore('rotorTin'),
        ore('rotorBronze'),
        ore('rotorSteel'),
        ore('rotorStainlessSteel'),
        ore('rotorTungstenSteel'),
        ore('rotorRhodiumPlatedPalladium'),
        ore('rotorNaquadahAlloy'),
        ore('rotorDarmstadtium')
    ]

    static final def chemicalReactorParts = [ore('blockGlass'), ore('blockGlass'), ore('blockGlass'), metaitem('pipeNormalFluidPlastic'), metaitem('pipeLargeFluidPlastic'),
                                             metaitem('pipeHugeFluidPlastic'), metaitem('pipeNormalFluidPolytetrafluoroethylene'), metaitem('pipeLargeFluidPolytetrafluoroethylene'),
                                             metaitem('pipeHugeFluidPolytetrafluoroethylene')]

    static final def tieredPipes = [metaitem('pipeLargeFluidSteel'), metaitem('pipeLargeFluidSteel'), metaitem('pipeLargeFluidAluminium'), metaitem('pipeLargeFluidStainlessSteel'),
                                    metaitem('pipeLargeFluidTitanium'), metaitem('pipeLargeFluidTungstenSteel'), metaitem('pipeLargeFluidNiobiumTitanium'),
                                    metaitem('pipeLargeFluidNaquadah'), metaitem('pipeLargeFluidDuranium')]

    static final def tieredMagnets = [metaitem('stickIronMagnetic'), metaitem('stickSteelMagnetic'), metaitem('stickSteelMagnetic'), metaitem('stickAlnicoMagnetic'),
                                      metaitem('stickAlnicoMagnetic'), metaitem('stickNeodymiumAlloyMagnetic'), metaitem('stickSamariumAlloyMagnetic'),
                                      metaitem('stickSamariumAlloyMagnetic'), metaitem('stickSamariumAlloyMagnetic')];

    static final def refractories = [item('gregtech:metal_casing', 1), item('gregtech:metal_casing', 1), item('susy:susy_multiblock_casing', 11), item('susy:susy_multiblock_casing', 11),
                                     item('susy:susy_multiblock_casing', 9), item('susy:susy_multiblock_casing', 9), item('susy:susy_multiblock_casing', 9),
                                     item('susy:susy_multiblock_casing', 9), item('susy:susy_multiblock_casing', 9)]
}