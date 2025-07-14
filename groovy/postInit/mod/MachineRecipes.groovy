import globals.Globals
import postInit.utils.RecyclingHelper

ASSEMBLER = recipemap('assembler')
MIXER = recipemap('mixer')
EXTRUDER = recipemap('extruder')
SINTERING_OVEN = recipemap('sintering_oven')

def name_removals = [
    'gregtech:gregtech.machine.fisher.lv',
    'gregtech:gregtech.machine.fisher.mv',
    'gregtech:gregtech.machine.fisher.hv',
    'gregtech:gregtech.machine.fisher.ev',
    'gregtech:diesel_generator_lv',
    'gregtech:diesel_generator_mv',
    'gregtech:diesel_generator_hv'
]

for (name in name_removals) {
    crafting.remove(name)
}

mods.jei.ingredient.yeet(
    metaitem('steam_turbine.mv'),
    metaitem('steam_turbine.hv'),
    metaitem('gas_turbine.lv'),
    metaitem('gas_turbine.mv'),
    metaitem('gas_turbine.hv'),
    metaitem('gcym:steam_engine'),
    item('gcym:large_multiblock_casing:12'),
    metaitem('large_turbine.steam'),
    metaitem('large_turbine.gas'),
    metaitem('large_turbine.plasma'),
    metaitem('large_combustion_engine'),
    metaitem('extreme_combustion_engine'),
    metaitem('reservoir_hatch'),
    metaitem('rotor_holder.hv'),
    metaitem('rotor_holder.ev'),
    metaitem('rotor_holder.iv'),
    metaitem('rotor_holder.luv'),
    metaitem('rotor_holder.zpm'),
    metaitem('rotor_holder.uv')
)

//Add recipes for new chemical reactors, and remove old chemical reactor recipes

for (i = 1; i <= 13; i++) {
    mods.jei.ingredient.yeet(
        metaitem('chemical_reactor.' + Globals.voltageTiers[i])
    )
}
for (i = 1; i <= 8; i++) {
    mods.jei.ingredient.yeet(
        metaitem('world_accelerator.' + Globals.voltageTiers[i])
    )
}

def circuits = [ore('circuitUlv'), ore('circuitLv'), ore('circuitMv'),
                ore('circuitHv'), ore('circuitEv'), ore('circuitIv'),
                ore('circuitLuv'), ore('circuitZpm'), ore('circuitUv'),
                ore('circuitUhv'), ore('circuitUev'), ore('circuitUiv'),
                ore('circuitUxv'), ore('circuitOpv')];

def conveyors = [null, metaitem('conveyor.module.lv'), metaitem('conveyor.module.mv'), metaitem('conveyor.module.hv'),
                 metaitem('conveyor.module.ev'), metaitem('conveyor.module.iv'), metaitem('conveyor.module.luv'),
                 metaitem('conveyor.module.zpm'), metaitem('conveyor.module.uv'), metaitem('conveyor.module.uhv'),
                 metaitem('conveyor.module.uev'), metaitem('conveyor.module.uiv'), metaitem('conveyor.module.opv'),
                 metaitem('conveyor.module.uxv')];

def pumps = [null, metaitem('electric.pump.lv'), metaitem('electric.pump.mv'), metaitem('electric.pump.hv'),
             metaitem('electric.pump.ev'), metaitem('electric.pump.iv'), metaitem('electric.pump.luv'),
             metaitem('electric.pump.zpm'), metaitem('electric.pump.uv'), metaitem('electric.pump.uhv'),
             metaitem('electric.pump.uev'), metaitem('electric.pump.uiv'), metaitem('electric.pump.uxv'),
             metaitem('electric.pump.opv')];

/*def regulators = [null, metaitem('fluid.regulator.lv'), metaitem('fluid.regulator.mv'), metaitem('fluid.regulator.hv'),
         metaitem('fluid.regulator.ev'), metaitem('fluid.regulator.iv'), metaitem('fluid.regulator.luv'),
         metaitem('fluid.regulator.zpm'), metaitem('fluid.regulator.uv'), metaitem('fluid.regulator.uhv'),
         metaitem('fluid.regulator.uev'), metaitem('fluid.regulator.uiv'), metaitem('fluid.regulator.uxv'),
         metaitem('fluid.regulator.opv')];*/

def field_generators = [null, metaitem('field.generator.lv'), metaitem('field.generator.mv'), metaitem('field.generator.hv'),
                        metaitem('field.generator.ev'), metaitem('field.generator.iv'), metaitem('field.generator.luv'),
                        metaitem('field.generator.zpm'), metaitem('field.generator.uv'), metaitem('field.generator.uhv'),
                        metaitem('field.generator.uev'), metaitem('field.generator.uiv'), metaitem('field.generator.uxv'),
                        metaitem('field.generator.opv')];

def emitters = [null, metaitem('emitter.lv'), metaitem('emitter.mv'), metaitem('emitter.hv'),
                metaitem('emitter.ev'), metaitem('emitter.iv'), metaitem('emitter.luv'),
                metaitem('emitter.zpm'), metaitem('emitter.uv'), metaitem('emitter.uhv'),
                metaitem('emitter.uev'), metaitem('emitter.uiv'), metaitem('emitter.uxv'),
                metaitem('emitter.opv')];

def sensors = [null, metaitem('sensor.lv'), metaitem('sensor.mv'), metaitem('sensor.hv'),
               metaitem('sensor.ev'), metaitem('sensor.iv'), metaitem('sensor.luv'),
               metaitem('sensor.zpm'), metaitem('sensor.uv'), metaitem('sensor.uhv'),
               metaitem('sensor.uev'), metaitem('sensor.uiv'), metaitem('sensor.uxv'),
               metaitem('sensor.opv')];

def motors = [null, metaitem('electric.motor.lv'), metaitem('electric.motor.mv'), metaitem('electric.motor.hv'),
              metaitem('electric.motor.ev'), metaitem('electric.motor.iv'), metaitem('electric.motor.luv'),
              metaitem('electric.motor.zpm'), metaitem('electric.motor.uv'), metaitem('electric.motor.uhv'),
              metaitem('electric.motor.uev'), metaitem('electric.motor.uiv'), metaitem('electric.motor.uxv'),
              metaitem('electric.motor.opv')];

def pistons = [null, metaitem('electric.piston.lv'), metaitem('electric.piston.mv'), metaitem('electric.piston.hv'),
               metaitem('electric.piston.ev'), metaitem('electric.piston.iv'), metaitem('electric.piston.luv'),
               metaitem('electric.piston.zpm'), metaitem('electric.piston.uv'), metaitem('electric.piston.uhv'),
               metaitem('electric.piston.uev'), metaitem('electric.piston.uiv'), metaitem('electric.piston.uxv'),
               metaitem('electric.piston.opv')];

def robotArms = [null, metaitem('robot.arm.lv'), metaitem('robot.arm.mv'), metaitem('robot.arm.hv'),
                 metaitem('robot.arm.ev'), metaitem('robot.arm.iv'), metaitem('robot.arm.luv'),
                 metaitem('robot.arm.zpm'), metaitem('robot.arm.uv'), metaitem('robot.arm.uhv'),
                 metaitem('robot.arm.uev'), metaitem('robot.arm.uiv'), metaitem('robot.arm.uxv'),
                 metaitem('robot.arm.opv')];

def hulls = [metaitem('hull.ulv'), metaitem('hull.lv'), metaitem('hull.mv'), metaitem('hull.hv'),
             metaitem('hull.ev'), metaitem('hull.iv'), metaitem('hull.luv'),
             metaitem('hull.zpm'), metaitem('hull.uv'), metaitem('hull.uhv'),
             metaitem('hull.uev'), metaitem('hull.uiv'), metaitem('hull.uxv'),
             metaitem('hull.opv')];

def tieredWires = [ore('wireGtQuadrupleRedAlloy'), ore('wireGtQuadrupleCopper'), ore('wireGtQuadrupleCupronickel'), ore('wireGtQuadrupleKanthal'),
                   ore('wireGtQuadrupleNichrome'), ore('wireGtQuadrupleTungstenSteel'), ore('wireGtQuadrupleHssg'),
                   ore('wireGtQuadrupleNaquadah'), ore('wireGtQuadrupleNaquadahAlloy')];

def tieredPlates = [ore('plateWroughtIron'), ore('plateSteel'), ore('plateAluminium'), ore('plateStainlessSteel'),
                    ore('plateTitanium'), ore('plateTungstenSteel'), ore('plateRhodiumPlatedPalladium'),
                    ore('plateNaquadahAlloy'), ore('plateDarmstadtium')];

def tieredSticks = [ore('stickWroughtIron'), ore('stickIron'), ore('stickSteel'), ore('stickSteel'),
                    ore('stickNeodymiumAlloy'), ore('stickVanadiumGallium'), ore('stickVanadiumGallium'),
                    ore('stickVanadiumGallium'), ore('stickVanadiumGallium')];

def tieredGlass = [ore('blockGlass'), ore('blockGlass'), ore('blockGlass'), item('gregtech:transparent_casing:0'),
                   item('gregtech:transparent_casing:0'), item('gregtech:transparent_casing:2'), item('gregtech:transparent_casing:2'),
                   item('gregtech:transparent_casing:1'), item('gregtech:transparent_casing:1')];

def tieredCables = [ore('cableGtSingleRedAlloy'), ore('cableGtSingleTin'), ore('cableGtSingleCopper'), ore('cableGtSingleGold'),
                    ore('cableGtSingleAluminium'), ore('cableGtSinglePlatinum'), ore('cableGtSingleNiobiumTitanium'),
                    ore('cableGtSingleVanadiumGallium'), ore('cableGtSingleYttriumBariumCuprate')]

def tieredQuadCables = [ore('cableGtQuadrupleRedAlloy'), ore('cableGtQuadrupleTin'), ore('cableGtQuadrupleCopper'), ore('cableGtQuadrupleGold'),
                        ore('cableGtQuadrupleAluminium'), ore('cableGtQuadruplePlatinum'), ore('cableGtQuadrupleNiobiumTitanium'),
                        ore('cableGtQuadrupleVanadiumGallium'), ore('cableGtQuadrupleYttriumBariumCuprate')]

def tieredSprings = [metaitem('springIron'), metaitem('springCopper'), metaitem('springCupronickel'), metaitem('springKanthal'),
                     metaitem('springNichrome'), metaitem('springTungstenSteel'), metaitem('springHssg'),
                     metaitem('springNaquadah'), metaitem('springNaquadahAlloy')]

def rotors = [
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

def chemicalReactorParts = [ore('blockGlass'), ore('blockGlass'), ore('blockGlass'), metaitem('pipeNormalFluidPlastic'), metaitem('pipeLargeFluidPlastic'),
                            metaitem('pipeHugeFluidPlastic'), metaitem('pipeNormalFluidPolytetrafluoroethylene'), metaitem('pipeLargeFluidPolytetrafluoroethylene'),
                            metaitem('pipeHugeFluidPolytetrafluoroethylene')]

def tieredPipes = [metaitem('pipeLargeFluidSteel'), metaitem('pipeLargeFluidSteel'), metaitem('pipeLargeFluidAluminium'), metaitem('pipeLargeFluidStainlessSteel'),
                   metaitem('pipeLargeFluidTitanium'), metaitem('pipeLargeFluidTungstenCarbide'), metaitem('pipeLargeFluidNiobiumTitanium'),
                   metaitem('pipeLargeFluidNaquadah'), metaitem('pipeLargeFluidDuranium')]

def tieredMagnets = [metaitem('stickIronMagnetic'), metaitem('stickIronMagnetic'), metaitem('stickSteelMagnetic'), metaitem('stickSteelMagnetic'),
                     metaitem('stickNeodymiumAlloyMagnetic'), metaitem('stickNeodymiumAlloyMagnetic'), metaitem('stickSamariumAlloyMagnetic'),
                     metaitem('stickSamariumAlloyMagnetic'), metaitem('stickSamariumAlloyMagnetic')];

log.infoMC("Adding Vulcanizing Press Craft")

//Vulcanizing Press
RecyclingHelper.addShaped("gregtech:vulcanizing_press.ulv", metaitem('susy:vulcanizing_press.bronze'), [
    [ore('springSmallSteel'), ore('stickSteel'), ore('springSmallSteel')],
    [ore('pipeSmallFluidBronze'), ore('plateSteel'), ore('pipeSmallFluidBronze')],
    [ore('pipeSmallFluidBronze'), item('gregtech:steam_casing', 1), ore('pipeSmallFluidBronze')]
])
RecyclingHelper.addShaped("gregtech:vulcanizing_press.lv", metaitem('susy:vulcanizing_press.lv'), [
    [ore('cableGtSingleTin'), metaitem('electric.piston.lv'), ore('cableGtSingleTin')],
    [ore('wireGtQuadrupleCopper'), metaitem('hull.lv'), ore('wireGtQuadrupleCopper')],
    [ore('cableGtSingleTin'), ore('circuitLv'), ore('cableGtSingleTin')]
])
RecyclingHelper.addShaped("gregtech:vulcanizing_press.mv", metaitem('susy:vulcanizing_press.mv'), [
    [ore('cableGtSingleCopper'), metaitem('electric.piston.mv'), ore('cableGtSingleCopper')],
    [ore('wireGtQuadrupleCupronickel'), metaitem('hull.mv'), ore('wireGtQuadrupleCupronickel')],
    [ore('cableGtSingleCopper'), ore('circuitMv'), ore('cableGtSingleCopper')]
])
RecyclingHelper.addShaped("gregtech:vulcanizing_press.hv", metaitem('susy:vulcanizing_press.hv'), [
    [ore('cableGtSingleGold'), metaitem('electric.piston.hv'), ore('cableGtSingleGold')],
    [ore('wireGtQuadrupleKanthal'), metaitem('hull.hv'), ore('wireGtQuadrupleKanthal')],
    [ore('cableGtSingleGold'), ore('circuitHv'), ore('cableGtSingleGold')]
])
RecyclingHelper.addShaped("gregtech:vulcanizing_press.ev", metaitem('susy:vulcanizing_press.ev'), [
    [ore('cableGtSingleAluminium'), metaitem('electric.piston.ev'), ore('cableGtSingleAluminium')],
    [ore('wireGtQuadrupleNichrome'), metaitem('hull.ev'), ore('wireGtQuadrupleNichrome')],
    [ore('cableGtSingleAluminium'), ore('circuitEv'), ore('cableGtSingleAluminium')]
])

log.infoMC("Adding Roaster Craft")

//Roaster
RecyclingHelper.addShaped("gregtech:roaster.ulv", metaitem('susy:roaster.bronze'), [
    [ore('pipeSmallFluidBronze'), ore('rotorBronze'), ore('pipeSmallFluidBronze')],
    [ore('pipeSmallFluidBronze'), ore('plateBronze'), ore('pipeSmallFluidBronze')],
    [ore('pipeSmallFluidBronze'), item('gregtech:steam_casing', 1), ore('pipeSmallFluidBronze')]
])

for (i = 1; i <= 8; i++) {
    RecyclingHelper.addShaped("gregtech:roaster." + Globals.voltageTiers[i], metaitem('susy:roaster.' + Globals.voltageTiers[i]), [
        [circuits[i], rotors[i], circuits[i]],
        [tieredWires[i], hulls[i], tieredWires[i]],
        [tieredCables[i], tieredWires[i], tieredCables[i]]
    ])
}

log.infoMC("Adding Latex Collector Craft")

//Latex Collector
RecyclingHelper.addShaped("gregtech:latex_collector.ulv", metaitem('susy:latex_collector.bronze'), [
    [null, ore('toolHeadDrillSteel'), null],
    [ore('blockGlass'), ore('rotorSteel'), ore('blockGlass')],
    [ore('pipeSmallFluidBronze'), item('gregtech:steam_casing'), ore('pipeSmallFluidBronze')]
])

for (i = 1; i <= 4; i++) {
    RecyclingHelper.addShaped("gregtech:latex_collector." + Globals.voltageTiers[i], metaitem('susy:latex_collector.' + Globals.voltageTiers[i]), [
        [circuits[i], ore('toolHeadDrillSteel'), circuits[i]],
        [ore('blockGlass'), pumps[i], ore('blockGlass')],
        [tieredCables[i], hulls[i], tieredCables[i]]
    ])
}

log.infoMC("Adding Steam Mixer Craft")

//Mixer
RecyclingHelper.addShaped("gregtech:mixer.ulv", metaitem('susy:mixer.bronze'), [
    [ore('blockGlass'), ore('rotorBronze'), ore('blockGlass')],
    [ore('blockGlass'), ore('stickBronze'), ore('blockGlass')],
    [ore('pipeSmallFluidBronze'), item('gregtech:steam_casing'), ore('pipeSmallFluidBronze')]
])

log.infoMC("Adding Coagulation Tank Craft")

//Coagulation Tank
RecyclingHelper.addShaped("gregtech:coagulation_tank", metaitem('susy:coagulation_tank'), [
    [ore('plankTreatedWood'), ore('rotorSteel'), ore('plankTreatedWood')],
    [ore('craftingToolSaw'), ore('pipeLargeFluidTreatedWood'), ore('craftingToolHardHammer')],
    [ore('plankTreatedWood'), ore('boltSteel'), ore('plankTreatedWood')]
])
RecyclingHelper.addShaped("gregtech:coagulation_tank_wall", item('susy:coagulation_tank_wall'), [
    [ore('plankTreatedWood'), ore('boltSteel'), ore('plankTreatedWood')],
    [ore('craftingToolSaw'), ore('frameGtTreatedWood'), ore('craftingToolHardHammer')],
    [ore('plankTreatedWood'), ore('boltSteel'), ore('plankTreatedWood')]
])

//Nerf arc furnaces, add graphite rod chain
MIXER.recipeBuilder()
    .fluidInputs(fluid('coal_tar') * 1000)
    .inputs(ore('dustCoke') * 4)
    .outputs(metaitem('pitch_binder') * 4)
    .EUt(30)
    .duration(200)
    .buildAndRegister()

EXTRUDER.recipeBuilder()
    .notConsumable(metaitem('shape.extruder.rod'))
    .inputs(metaitem('pitch_binder'))
    .outputs(metaitem('raw_electrode'))
    .EUt(30)
    .duration(200)
    .buildAndRegister()

SINTERING_OVEN.recipeBuilder()
    .inputs(metaitem('raw_electrode'))
    .fluidInputs(fluid('monoxide_rich_syngas') * 100)
    .fluidInputs(fluid('air') * 100)
    .outputs(metaitem('graphite_electrode'))
    .fluidOutputs(fluid('carbon_dioxide') * 50)
    .EUt(30)
    .duration(150)
    .buildAndRegister()

SINTERING_OVEN.recipeBuilder()
    .inputs(metaitem('raw_electrode'))
    .fluidInputs(fluid('methane') * 100)
    .fluidInputs(fluid('air') * 100)
    .outputs(metaitem('graphite_electrode'))
    .fluidOutputs(fluid('carbon_dioxide') * 50)
    .EUt(30)
    .duration(150)
    .buildAndRegister()

SINTERING_OVEN.recipeBuilder()
    .inputs(metaitem('raw_electrode'))
    .fluidInputs(fluid('monoxide_rich_syngas') * 100)
    .fluidInputs(fluid('oxygen') * 80)
    .outputs(metaitem('graphite_electrode'))
    .fluidOutputs(fluid('carbon_dioxide') * 50)
    .EUt(30)
    .duration(150)
    .buildAndRegister()

SINTERING_OVEN.recipeBuilder()
    .inputs(metaitem('raw_electrode'))
    .fluidInputs(fluid('methane') * 100)
    .fluidInputs(fluid('oxygen') * 80)
    .outputs(metaitem('graphite_electrode'))
    .fluidOutputs(fluid('carbon_dioxide') * 50)
    .EUt(30)
    .duration(150)
    .buildAndRegister()


for (i = 1; i <= 8; i++) {
    RecyclingHelper.removeByOutput(metaitem('arc_furnace.' + Globals.voltageTiers[i]))

    RecyclingHelper.addShaped("gregtech:arc_furnace." + Globals.voltageTiers[i], metaitem('arc_furnace.' + Globals.voltageTiers[i]), [
        [tieredQuadCables[i], metaitem('graphite_electrode'), tieredQuadCables[i]],
        [circuits[i], hulls[i], circuits[i]],
        [tieredPlates[i], tieredPlates[i], tieredPlates[i]]
    ])
}
for (i = 1; i <= 8; i++) {

    RecyclingHelper.addShaped("gregtech:continuous_stirred_tank_reactor." + Globals.voltageTiers[i], metaitem('susy:continuous_stirred_tank_reactor.' + Globals.voltageTiers[i]), [
        [chemicalReactorParts[i], rotors[i], chemicalReactorParts[i]],
        [tieredCables[i], motors[i], tieredCables[i]],
        [circuits[i], hulls[i], circuits[i]]
    ])

    RecyclingHelper.addShaped("gregtech:batch_reactor." + Globals.voltageTiers[i], metaitem('susy:batch_reactor.' + Globals.voltageTiers[i]), [
        [tieredCables[i], pumps[i], tieredCables[i]],
        [chemicalReactorParts[i], hulls[i], chemicalReactorParts[i]],
        [circuits[i], tieredCables[i], circuits[i]]
    ])

    RecyclingHelper.addShaped("gregtech:bubble_column_reactor." + Globals.voltageTiers[i], metaitem('susy:bubble_column_reactor.' + Globals.voltageTiers[i]), [
        [chemicalReactorParts[i], tieredPipes[i], chemicalReactorParts[i]],
        [tieredCables[i], pumps[i], tieredCables[i]],
        [circuits[i], hulls[i], circuits[i]]
    ])

    RecyclingHelper.addShaped("gregtech:fixed_bed_reactor." + Globals.voltageTiers[i], metaitem('susy:fixed_bed_reactor.' + Globals.voltageTiers[i]), [
        [null, circuits[i], null],
        [tieredPipes[i], pumps[i], tieredPipes[i]],
        [tieredCables[i], hulls[i], tieredCables[i]]
    ])

    RecyclingHelper.addShaped("gregtech:crystallizer." + Globals.voltageTiers[i], metaitem('susy:crystallizer.' + Globals.voltageTiers[i]), [
        [tieredPlates[i], tieredGlass[i], tieredPlates[i]],
        [chemicalReactorParts[i], hulls[i], chemicalReactorParts[i]],
        [circuits[i], pumps[i], circuits[i]]
    ])

    RecyclingHelper.addShaped("gregtech:trickle_bed_reactor." + Globals.voltageTiers[i], metaitem('susy:trickle_bed_reactor.' + Globals.voltageTiers[i]), [
        [tieredCables[i], pumps[i], tieredCables[i]],
        [tieredPipes[i], hulls[i], tieredPipes[i]],
        [circuits[i], pumps[i], circuits[i]]
    ])
}

//Polymerization tank and fluidized bed reactor

RecyclingHelper.addShaped("gregtech:polymerization_tank", metaitem('susy:polymerization_tank'), [
    [tieredCables[1], motors[1], tieredCables[1]],
    [pumps[1], rotors[1], pumps[1]],
    [circuits[1], hulls[1], circuits[1]]
])

RecyclingHelper.addShaped("gregtech:fluidized_bed_reactor", metaitem('susy:fluidized_bed_reactor'), [
    [tieredCables[3], pumps[3], tieredCables[3]],
    [metaitem('pipeLargeFluidPolytetrafluoroethylene'), hulls[3], metaitem('pipeLargeFluidPolytetrafluoroethylene')],
    [circuits[3], motors[3], circuits[3]]
])

//Dryer

for (i = 1; i <= 8; i++) {
    RecyclingHelper.addShaped("gregtech:dryer." + Globals.voltageTiers[i], metaitem('susy:dryer.' + Globals.voltageTiers[i]), [
        [tieredCables[i], circuits[i], tieredCables[i]],
        [tieredSprings[i], hulls[i], tieredSprings[i]],
        [tieredCables[i], circuits[i], tieredCables[i]]
    ])
}

//Weapons Factory

for (def i = 1; i < 8; i++) {
    RecyclingHelper.addShaped("gregtech:weapons_factory." + i, metaitem('susy:weapons_factory.' + Globals.voltageTiers[i]), [
        [circuits[i], robotArms[i], circuits[i]],
        [conveyors[i], hulls[i], conveyors[i]],
        [tieredCables[i], circuits[i], tieredCables[i]]
    ])
}

//Fluid compressors and decompressors

for (def i = 1; i < 8; i++) {
    RecyclingHelper.addShaped("gregtech:fluid_decompressor." + i, metaitem('susy:fluid_decompressor.' + Globals.voltageTiers[i]), [
        [tieredGlass[i], pistons[i], tieredGlass[i]],
        [pumps[i], hulls[i], tieredPipes[i]],
        [circuits[i], tieredCables[i], circuits[i]]
    ])

    RecyclingHelper.addShaped("gregtech:fluid_compressor." + i, metaitem('susy:fluid_compressor.' + Globals.voltageTiers[i]), [
        [tieredGlass[i], pistons[i], tieredGlass[i]],
        [tieredPipes[i], hulls[i], pumps[i]],
        [circuits[i], tieredCables[i], circuits[i]]
    ])
}

//Nerf polarizer and electromagnetic separator

for (i = 1; i <= 8; i++) {
    RecyclingHelper.replaceShaped("gregtech:gregtech.machine.polarizer." + Globals.voltageTiers[i], metaitem('polarizer.' + Globals.voltageTiers[i]), [
        [tieredWires[i], tieredMagnets[i], tieredWires[i]],
        [tieredCables[i], hulls[i], tieredCables[i]],
        [tieredWires[i], tieredMagnets[i], tieredWires[i]]
    ])

    RecyclingHelper.replaceShaped("gregtech:gregtech.machine.electromagnetic_separator." + Globals.voltageTiers[i], metaitem('electromagnetic_separator.' + Globals.voltageTiers[i]), [
        [conveyors[i], tieredCables[i], tieredWires[i]],
        [tieredCables[i], hulls[i], tieredMagnets[i]],
        [circuits[i], tieredCables[i], tieredWires[i]]
    ])
}

//Electrostatic separator

def tieredElectrodes = [ore('wireFineRedAlloy'), ore('wireFineSteel'), metaitem('graphite_electrode'), ore('wireFinePlatinum'), ore('wireFineTitanium'),
                        ore('wireFineTungsten'), ore('wireFineOsmiridium'), ore('wireFineNiobiumTitanium'),
                        ore('wireFineNaquadah'), ore('wireFineNaquadahAlloy')];

for (i = 1; i <= 8; i++) {
    RecyclingHelper.replaceShaped("gregtech:gregtech.machine.electrostatic_separator." + Globals.voltageTiers[i], metaitem('susy:electrostatic_separator.' + Globals.voltageTiers[i]), [
        [tieredWires[i], tieredElectrodes[i], tieredWires[i]],
        [tieredCables[i], hulls[i], tieredCables[i]],
        [tieredWires[i], tieredElectrodes[i], tieredWires[i]]
    ])
}

//Add recipes for high pressure steam machines

RecyclingHelper.addShaped("gregtech:vulcanizing_press.steel", metaitem('susy:vulcanizing_press.steel'), [
    [metaitem('plateSteel'), metaitem('plateSteel'), metaitem('plateSteel')],
    [metaitem('pipeSmallFluidTinAlloy'), metaitem('susy:vulcanizing_press.bronze'), metaitem('pipeSmallFluidTinAlloy')],
    [metaitem('plateWroughtIron'), metaitem('plateWroughtIron'), metaitem('plateWroughtIron')]
])

RecyclingHelper.addShaped("gregtech:mixer.steel", metaitem('susy:mixer.steel'), [
    [metaitem('pipeSmallFluidTinAlloy'), metaitem('plateSteel'), metaitem('pipeSmallFluidTinAlloy')],
    [metaitem('plateWroughtIron'), metaitem('susy:mixer.bronze'), metaitem('plateWroughtIron')],
    [metaitem('pipeSmallFluidTinAlloy'), metaitem('pipeSmallFluidTinAlloy'), metaitem('pipeSmallFluidTinAlloy')]
])

RecyclingHelper.addShaped("gregtech:vacuum_chamber.steel", metaitem('susy:vacuum_chamber.steel'), [
    [metaitem('plateSteel'), metaitem('pipeSmallFluidTinAlloy'), metaitem('plateSteel')],
    [metaitem('pipeSmallFluidTinAlloy'), metaitem('susy:vacuum_chamber.bronze'), metaitem('pipeSmallFluidTinAlloy')],
    [metaitem('plateWroughtIron'), metaitem('pipeSmallFluidTinAlloy'), metaitem('plateWroughtIron')]
])

RecyclingHelper.addShaped("gregtech:roaster.steel", metaitem('susy:roaster.steel'), [
    [metaitem('plateWroughtIron'), metaitem('plateWroughtIron'), metaitem('plateWroughtIron')],
    [metaitem('plateSteel'), metaitem('susy:roaster.bronze'), metaitem('plateSteel')],
    [metaitem('pipeSmallFluidTinAlloy'), metaitem('pipeSmallFluidTinAlloy'), metaitem('pipeSmallFluidTinAlloy')]
])

//Add the rest of the vacuum chambers

for (def i = 1; i < 8; i++) {
    RecyclingHelper.addShaped("gregtech:vacuum_chamber." + i, metaitem('susy:vacuum_chamber.' + Globals.voltageTiers[i]), [
        [tieredPlates[i], tieredPlates[i], tieredPlates[i]],
        [pumps[i], hulls[i], pumps[i]],
        [tieredCables[i], circuits[i], tieredCables[i]]
    ])
}

//Sintering oven stuff

RecyclingHelper.addShaped("gregtech:brick_sintering_block", item('susy:sintering_brick'), [
    [null, ore('craftingToolHardHammer'), null],
    [metaitem('foilSteel'), item('gregtech:metal_casing', 1), metaitem('foilSteel')],
    [null, null, null]
])

RecyclingHelper.replaceShaped("gregtech:sintering_oven", metaitem('susy:sintering_oven'), [
    [motors[1], rotors[1], metaitem('wireGtQuadrupleCupronickel')],
    [circuits[1], item('gregtech:metal_casing', 1), circuits[1]],
    [pumps[1], metaitem('wireGtQuadrupleCupronickel'), pumps[1]]
])

//Regate pyrolysis oven

RecyclingHelper.replaceShaped("gregtech:pyrolyse_oven", metaitem('pyrolyse_oven'), [
    [pistons[1], circuits[1], metaitem('wireGtQuadrupleCupronickel')],
    [circuits[1], hulls[1], circuits[1]],
    [pistons[1], pumps[1], metaitem('wireGtQuadrupleCupronickel')]
])

//Laser Engraver -> Electron Beam Lithographer

for (i = 1; i <= 8; i++) {
    RecyclingHelper.replaceShaped("gregtech:gregtech.machine.laser_engraver." + Globals.voltageTiers[i], metaitem('laser_engraver.' + Globals.voltageTiers[i]), [
        [pistons[i], metaitem('wireFineTungsten'), pistons[i]],
        [circuits[i], hulls[i], circuits[i]],
        [tieredCables[i], circuits[i], tieredCables[i]]
    ])
}

//Fermentation Vat (and also remove old fermenters)

for (i = 1; i <= 8; i++) {
    crafting.remove("gregtech:gregtech.machine.fermenter." + Globals.voltageTiers[i])
}

RecyclingHelper.addShaped("gregtech:fermentation_vat", metaitem('susy:fermentation_vat'), [
    [tieredCables[1], pumps[1], tieredCables[1]],
    [ore('blockGlass'), hulls[1], ore('blockGlass')],
    [tieredCables[1], circuits[1], tieredCables[1]]
])

//UV Light Box

for (i = 1; i <= 8; i++) {
    RecyclingHelper.addShaped("gregtech:uv_light_box." + Globals.voltageTiers[i], metaitem('susy:uv_light_box.' + Globals.voltageTiers[i]), [
        [tieredCables[i], metaitem('carbon_arc_lamp'), tieredCables[i]],
        [circuits[i], hulls[i], circuits[i]],
        [tieredPlates[i], tieredPlates[i], tieredPlates[i]]
    ])
}

//Ion Implanter

for (i = 1; i <= 8; i++) {
    RecyclingHelper.addShaped("gregtech:ion_implanter." + Globals.voltageTiers[i], metaitem('susy:ion_implanter.' + Globals.voltageTiers[i]), [
        [circuits[i], tieredGlass[i], circuits[i]],
        [tieredMagnets[i], hulls[i], tieredMagnets[i]],
        [tieredCables[i], tieredSprings[i], tieredCables[i]]
    ])
}

// Pressure Swing Adsorber

RecyclingHelper.addShaped("gregtech:pressure_swing_adsorber", metaitem('susy:pressure_swing_adsorber'), [
    [metaitem('pipeLargeFluidAluminium'), motors[2], metaitem('pipeLargeFluidAluminium')],
    [pumps[2], metaitem('hull.mv'), pumps[2]],
    [circuits[2], metaitem('pipeLargeFluidAluminium'), circuits[2]]
])

//Turbine Recipes

RecyclingHelper.addShaped("alternator_coil", item('susy:alternator_coil'), [
    [ore('craftingToolHardHammer'), metaitem('electric.motor.lv'), ore('craftingToolScrewdriver')],
    [metaitem('electric.motor.lv'), ore('plateSteel'),             metaitem('electric.motor.lv')],
    [ore('circuitLv'),              metaitem('cableGtSingleTin'),  ore('circuitLv')]
])

RecyclingHelper.addShaped("steel_turbine_rotor", item('susy:turbine_rotor'), [
    [ore('plateSteel'),             ore('screwSteel'),     ore('plateSteel')],
    [ore('craftingToolHardHammer'), ore('stickLongSteel'), ore('craftingToolScrewdriver')],
    [ore('plateSteel'),             ore('rotorSteel'),     ore('plateSteel')]
])

RecyclingHelper.addShaped("steel_turbine_controller", metaitem('susy:basic_steam_turbine'), [
    [ore('plateSteel'),            metaitem('cableGtSingleTin'),       ore('plateSteel')],
    [ore('circuitLv'),             metaitem('hull.lv'), ore('circuitLv')],
    [metaitem('cableGtSingleTin'), ore('circuitLv'),                   metaitem('cableGtSingleTin')]
])

RecyclingHelper.replaceShaped("gregtech:casing_steel_turbine_casing", item('gregtech:turbine_casing', 5) * 4, [
    [metaitem('plateSteel'), ore('craftingToolHardHammer'), metaitem('plateSteel')],
    [metaitem('stickLongSteel'), item('gregtech:stone_smooth', 4), metaitem('stickLongSteel')],
    [metaitem('plateSteel'), ore('craftingToolWrench'), metaitem('plateSteel')]
])

RecyclingHelper.addShaped("gas_turbine_controller", metaitem('susy:basic_gas_turbine'), [
    [ore('plateSteel'),               metaitem('cableGtSingleCopper'),    ore('plateSteel')],
    [ore('circuitMv'),                metaitem('hull.mv'),                ore('circuitMv')],
    [metaitem('cableGtSingleCopper'), ore('circuitMv'),                   metaitem('cableGtSingleCopper')]
])

RecyclingHelper.addShaped("titanium_hp_turbine_controller", metaitem('susy:high_pressure_advanced_steam_turbine'), [
    [ore('plateTitanium'),            metaitem('pipeSmallFluidTitanium'),       ore('plateTitanium')],
    [ore('circuitEv'),             metaitem('hull.ev'), ore('circuitEv')],
    [metaitem('cableGtHexAluminium'), ore('circuitEv'),                   metaitem('cableGtHexAluminium')]
])

RecyclingHelper.addShaped("titanium_lp_turbine_controller", metaitem('susy:low_pressure_advanced_steam_turbine'), [
    [ore('plateTitanium'),            metaitem('pipeHugeFluidTitanium'),       ore('plateTitanium')],
    [ore('circuitEv'),             metaitem('hull.ev'), ore('circuitEv')],
    [metaitem('cableGtHexAluminium'), ore('circuitEv'),                   metaitem('cableGtHexAluminium')]
])

RecyclingHelper.addShaped("hp_turbine_rotor", item('susy:turbine_rotor', 8), [
    [ore('plateTitanium'),             ore('ringNimonic105'),     ore('plateTitanium')],
    [ore('craftingToolHardHammer'), ore('stickLongNimonic105'), ore('craftingToolScrewdriver')],
    [ore('plateTitanium'),             ore('rotorNimonic105'),     ore('plateTitanium')]
])

RecyclingHelper.addShaped("lp_turbine_rotor", item('susy:turbine_rotor', 4), [
    [ore('plateTitanium'),             ore('ringIncoloy825'),     ore('plateTitanium')],
    [ore('craftingToolHardHammer'), ore('stickLongIncoloy825'), ore('craftingToolScrewdriver')],
    [ore('plateTitanium'),             ore('rotorIncoloy825'),     ore('plateTitanium')]
])

// Titanium Turbine Casing * 2
mods.gregtech.assembler.removeByInput(16, [item('gregtech:turbine_casing', 5), metaitem('plateTitanium') * 6, metaitem('circuit.integrated').withNbt(['Configuration': 6])], null)

RecyclingHelper.replaceShaped("gregtech:casing_titanium_turbine_casing", item('gregtech:turbine_casing', 6) * 2, [
    [metaitem('plateTitanium'), ore('craftingToolHardHammer'), metaitem('plateTitanium')],
    [metaitem('stickLongTitanium'), item('gregtech:stone_smooth', 4), metaitem('stickLongTitanium')],
    [metaitem('plateTitanium'), ore('craftingToolWrench'), metaitem('plateTitanium')]
])

RecyclingHelper.addShaped("silicon_carbide_casing", item('susy:susy_multiblock_casing') * 2, [
    [metaitem('plateSiliconCarbide'), ore('craftingToolHardHammer'), metaitem('plateSiliconCarbide')],
    [metaitem('plateSiliconCarbide'), item('gregtech:metal_casing', 5), metaitem('plateSiliconCarbide')],
    [metaitem('plateSiliconCarbide'), ore('craftingToolWrench'), metaitem('plateSiliconCarbide')]
])

ASSEMBLER.recipeBuilder()
    .circuitMeta(6)
    .inputs(ore('plateSiliconCarbide') * 6)
    .inputs(item('gregtech:metal_casing', 5))
    .outputs(item('susy:susy_multiblock_casing') * 2)
    .EUt(16)
    .duration(50)
    .buildAndRegister()

//New Dynamo Hatches

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('transformer.lv'))
    .inputs(metaitem('energy_hatch.output.lv'))
    .inputs(metaitem('voltage_coil.lv'))
    .inputs(ore('wireGtQuadrupleTin') * 2)
    .outputs(metaitem('susy:energy_hatch.output_4a.lv'))
    .EUt(7)
    .duration(100)
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('transformer.adjustable.lv'))
    .inputs(metaitem('susy:energy_hatch.output_4a.lv'))
    .inputs(metaitem('voltage_coil.lv'))
    .inputs(ore('wireGtOctalTin') * 2)
    .outputs(metaitem('susy:energy_hatch.output_16a.lv'))
    .EUt(7)
    .duration(200)
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('transformer.mv'))
    .inputs(metaitem('energy_hatch.output.mv'))
    .inputs(metaitem('plate.ultra_low_power_integrated_circuit'))
    .inputs(metaitem('voltage_coil.mv'))
    .inputs(ore('wireGtQuadrupleCopper') * 2)
    .outputs(metaitem('susy:energy_hatch.output_4a.mv'))
    .EUt(30)
    .duration(100)
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('transformer.adjustable.mv'))
    .inputs(metaitem('susy:energy_hatch.output_4a.mv'))
    .inputs(metaitem('plate.ultra_low_power_integrated_circuit') * 2)
    .inputs(metaitem('voltage_coil.mv'))
    .inputs(ore('wireGtOctalCopper') * 2)
    .outputs(metaitem('susy:energy_hatch.output_16a.mv'))
    .EUt(30)
    .duration(200)
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('transformer.hv'))
    .inputs(metaitem('energy_hatch.output.hv'))
    .inputs(metaitem('plate.low_power_integrated_circuit'))
    .inputs(metaitem('voltage_coil.hv'))
    .inputs(ore('wireGtQuadrupleGold') * 2)
    .outputs(metaitem('susy:energy_hatch.output_4a.hv'))
    .EUt(120)
    .duration(100)
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('transformer.adjustable.hv'))
    .inputs(metaitem('susy:energy_hatch.output_4a.hv'))
    .inputs(metaitem('plate.low_power_integrated_circuit') * 2)
    .inputs(metaitem('voltage_coil.hv'))
    .inputs(ore('wireGtOctalGold') * 2)
    .outputs(metaitem('susy:energy_hatch.output_16a.hv'))
    .EUt(120)
    .duration(200)
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('transformer.adjustable.ev'))
    .inputs(metaitem('energy_hatch.output_4a.ev'))
    .inputs(metaitem('plate.power_integrated_circuit') * 2)
    .inputs(metaitem('voltage_coil.ev'))
    .inputs(ore('wireGtOctalAluminium') * 2)
    .outputs(metaitem('susy:energy_hatch.output_16a.ev'))
    .EUt(480)
    .duration(200)
    .buildAndRegister()

//Extra Quadruple Hatches
def materialPipe = [null, "Bronze", "Steel", "StainlessSteel", "Titanium", "Tungstensteel", "NiobiumTitanium", "Iridium", "Naquadah", "Neutronium", null, null, null, null];

for (i = 1; i <= 3; i++) {

    ASSEMBLER.recipeBuilder()
        .inputs(metaitem('fluid_hatch.import.' + Globals.voltageTiers[i]))
        .inputs(ore('pipeQuadrupleFluid' + materialPipe[i]))
        .circuitMeta(4)
        .fluidInputs(fluid('plastic') * 576)
        .outputs(metaitem('fluid_hatch.import_4x.' + Globals.voltageTiers[i]))
        .EUt(Globals.voltAmps[i])
        .duration(300)
        .buildAndRegister()

    ASSEMBLER.recipeBuilder()
        .inputs(metaitem('fluid_hatch.export.' + Globals.voltageTiers[i]))
        .inputs(ore('pipeQuadrupleFluid' + materialPipe[i]))
        .circuitMeta(4)
        .fluidInputs(fluid('plastic') * 576)
        .outputs(metaitem('fluid_hatch.export_4x.' + Globals.voltageTiers[i]))
        .EUt(Globals.voltAmps[i])
        .duration(300)
        .buildAndRegister()

    ASSEMBLER.recipeBuilder()
        .inputs(metaitem('fluid_hatch.import.' + Globals.voltageTiers[i]))
        .inputs(ore('pipeNonupleFluid' + materialPipe[i]))
        .circuitMeta(4)
        .fluidInputs(fluid('plastic') * 1296)
        .outputs(metaitem('fluid_hatch.import_9x.' + Globals.voltageTiers[i]))
        .EUt(Globals.voltAmps[i])
        .duration(600)
        .buildAndRegister()

    ASSEMBLER.recipeBuilder()
        .inputs(metaitem('fluid_hatch.export.' + Globals.voltageTiers[i]))
        .inputs(ore('pipeNonupleFluid' + materialPipe[i]))
        .circuitMeta(4)
        .fluidInputs(fluid('plastic') * 1296)
        .outputs(metaitem('fluid_hatch.export_9x.' + Globals.voltageTiers[i]))
        .EUt(Globals.voltAmps[i])
        .duration(600)
        .buildAndRegister()

    // Interconversion
    crafting.addShaped("susy:fluid_hatch.import_to_export.4x." + Globals.voltageTiers[i], 
        metaitem('fluid_hatch.import_4x.' + Globals.voltageTiers[i]), [
            [ore('craftingToolScrewdriver')],
            [metaitem('fluid_hatch.export_4x.' + Globals.voltageTiers[i])]
    ])
    crafting.addShaped("susy:fluid_hatch.export_to_import.4x." + Globals.voltageTiers[i], 
        metaitem('fluid_hatch.export_4x.' + Globals.voltageTiers[i]), [
            [ore('craftingToolScrewdriver')],
            [metaitem('fluid_hatch.import_4x.' + Globals.voltageTiers[i])]
    ])

    crafting.addShaped("susy:fluid_hatch.import_to_export.9x." + Globals.voltageTiers[i], 
        metaitem('fluid_hatch.import_9x.' + Globals.voltageTiers[i]), [
            [ore('craftingToolScrewdriver')],
            [metaitem('fluid_hatch.export_9x.' + Globals.voltageTiers[i])]
    ])
    crafting.addShaped("susy:fluid_hatch.export_to_import.9x." + Globals.voltageTiers[i], 
        metaitem('fluid_hatch.export_9x.' + Globals.voltageTiers[i]), [
            [ore('craftingToolScrewdriver')],
            [metaitem('fluid_hatch.import_9x.' + Globals.voltageTiers[i])]
    ])
}

RecyclingHelper.addShaped("gregtech:ore_sorter", metaitem('susy:ore_sorter'), [
    [robotArms[1], circuits[2], robotArms[1]],
    [pumps[1], hulls[1], pumps[1]],
    [robotArms[1], circuits[2], robotArms[1]]
]);

RecyclingHelper.addShaped("gregtech:primitive_mud_pump", metaitem('susy:primitive_mud_pump'), [
    [metaitem('ringBronze'), metaitem('pipeNormalFluidTreatedWood'), metaitem('screwBronze')],
    [metaitem('rotorBronze'), item('gregtech:steam_casing'), ore('craftingToolScrewdriver')],
    [item('minecraft:stone_slab', 4), metaitem('pipeLargeFluidWood'), item('minecraft:stone_slab', 4)]
]);

RecyclingHelper.addShaped("gregtech:railroad_engineering_station", metaitem('susy:railroad_engineering_station'), [
    [robotArms[1], null, robotArms[1]],
    [conveyors[1], hulls[1], conveyors[1]],
    [metaitem('plateSteel'), circuits[1], metaitem('plateSteel')]
]);

RecyclingHelper.addShaped("gregtech:condenser", metaitem('susy:condenser'), [
    [null, metaitem('electric.pump.lv'), null],
    [metaitem('frameSteel'), item('gregtech:boiler_casing', 1), metaitem('frameSteel')],
    [null, metaitem('electric.pump.lv'), null]
]);

RecyclingHelper.addShaped("gregtech:heat_exchanger", metaitem('susy:heat_exchanger'), [
    [null, metaitem('frameSteel'), null],
    [metaitem('electric.pump.lv'), item('gregtech:boiler_casing', 1), metaitem('electric.pump.lv')],
    [null, metaitem('frameSteel'), null]
]);

RecyclingHelper.addShaped("gregtech:mining_drill", metaitem('susy:mining_drill'), [
    [circuits[1], motors[1], circuits[1]],
    [conveyors[1], hulls[1], conveyors[1]],
    [tieredCables[1], motors[1], tieredCables[1]]
]);

RecyclingHelper.replaceShaped("gregtech:casing_grate_casing", item('gregtech:multiblock_casing', 2) * 2, [
    [item('minecraft:iron_bars'), metaitem('rotorSteel'), item('minecraft:iron_bars')],
    [item('minecraft:iron_bars'), metaitem('frameSteel'), item('minecraft:iron_bars')],
    [item('minecraft:iron_bars'), metaitem('electric.motor.lv'), item('minecraft:iron_bars')]
])

RecyclingHelper.addShaped("gregtech:steel_drill_head", item('susy:drill_head'), [
    [pumps[1], conveyors[1], pumps[1]],
    [metaitem('component.grinder.diamond'), item('gregtech:metal_casing', 4), metaitem('component.grinder.diamond')],
    [null, metaitem('component.grinder.diamond'), null]
]);

RecyclingHelper.addShaped("gregtech:heat_radiator", metaitem('susy:heat_radiator'), [
    [metaitem('frameSteel'), metaitem('pipeLargeFluidSteel'), metaitem('frameSteel')],
    [metaitem('electric.pump.lv'), hulls[1], metaitem('electric.pump.lv')],
    [metaitem('frameSteel'), metaitem('pipeLargeFluidSteel'), metaitem('frameSteel')]
]);

RecyclingHelper.addShaped("gregtech:large_weapons_factory", metaitem('susy:large_weapons_factory'), [
    [sensors[1], robotArms[1], emitters[1]],
    [conveyors[1], hulls[1], conveyors[1]],
    [circuits[1], robotArms[1], circuits[1]]
]);

RecyclingHelper.addShaped("gregtech:gravity_separator", metaitem('susy:gravity_separator'), [
    [metaitem('component.grinder.diamond'), circuits[2], metaitem('component.grinder.diamond')],
    [conveyors[2], hulls[2], conveyors[2]],
    [circuits[2], tieredCables[2], circuits[2]]
]);

RecyclingHelper.addShaped("gregtech:reaction_furnace", metaitem('susy:reaction_furnace'), [
    [tieredQuadCables[2], tieredSprings[2], tieredQuadCables[2]],
    [circuits[2], hulls[2], circuits[2]],
    [tieredPlates[2], tieredPlates[2], tieredPlates[2]]
]);

RecyclingHelper.addShaped("gregtech:advanced_arc_furnace", metaitem('susy:advanced_arc_furnace'), [
    [metaitem('cableGtHexTin'), item('susy:electrode_assembly'), metaitem('cableGtHexTin')],
    [circuits[1], hulls[1], circuits[1]],
    [pumps[1], tieredPlates[1], robotArms[1]]
]);

RecyclingHelper.addShaped("gregtech:arc_furnace_complex", metaitem('susy:arc_furnace_complex'), [
    [metaitem('cableGtHexPlatinum'), item('susy:electrode_assembly'), metaitem('cableGtHexPlatinum')],
    [circuits[4], hulls[4], circuits[4]],
    [pumps[4], tieredPlates[4], robotArms[4]]
]);

RecyclingHelper.addShaped("gregtech:electrode_assembly", item('susy:electrode_assembly'), [
    [metaitem('plateSteel'), metaitem('cableGtSingleCopper'), metaitem('plateSteel')],
    [metaitem('graphite_electrode'), metaitem('frameSteel'), metaitem('graphite_electrode')],
    [metaitem('plateSteel'), metaitem('cableGtSingleCopper'), metaitem('plateSteel')]
]);

RecyclingHelper.addShaped("gregtech:evaporation_pool", metaitem('susy:evaporation_pool'), [
    [item('gregtech:stone_smooth', 4), metaitem('pipeHugeFluidAluminium'), item('gregtech:stone_smooth', 4)],
    [pumps[2], hulls[2], pumps[2]],
    [item('gregtech:stone_smooth', 4), metaitem('pipeHugeFluidAluminium'), item('gregtech:stone_smooth', 4)]
]);

crafting.addShaped("gregtech:evaporation_bed", item('susy:evaporation_bed') * 8, [
    [item('minecraft:sand'), item('minecraft:dirt'), item('minecraft:sand')],
    [item('minecraft:dirt'), item('minecraft:gravel'), item('minecraft:dirt')],
    [item('minecraft:sand'), item('minecraft:dirt'), item('minecraft:sand')]
]);

RecyclingHelper.addShaped("gregtech:clarifier", metaitem('susy:clarifier'), [
    [tieredCables[2], metaitem('rotorSteel'), tieredCables[2]],
    [pumps[2], hulls[2], pumps[2]],
    [circuits[2], motors[2], circuits[2]]
]);

RecyclingHelper.addShaped("gregtech:clarifier_vat", item('susy:multiblock_tank') * 9, [
    [null, null, null],
    [metaitem('plateSteel'), item('minecraft:cauldron'), metaitem('plateSteel')],
    [metaitem('pipeSmallFluidSteel'), metaitem('pipeSmallFluidSteel'), metaitem('pipeSmallFluidSteel')]
]);

RecyclingHelper.addShaped("gregtech:multi_stage_flash_distillater", metaitem('susy:multi_stage_flash_distiller'), [
    [metaitem('plateStainlessSteel'), tieredCables[3], metaitem('plateStainlessSteel')],
    [pumps[3], hulls[3], pumps[3]],
    [circuits[3], tieredSprings[3], circuits[3]]
]);

RecyclingHelper.addShaped("gregtech:smoke_stack", metaitem('susy:smoke_stack'), [
    [null, metaitem('rotorSteel'), null],
    [metaitem('pipeSmallFluidSteel'), hulls[1], metaitem('pipeSmallFluidSteel')],
    [null, metaitem('rotorSteel'), null],
]);

RecyclingHelper.addShaped("gregtech:flare_stack", metaitem('susy:flare_stack'), [
    [null, metaitem('rotorSteel'), null],
    [metaitem('stickSteel'), hulls[1], metaitem('stickSteel')],
    [null, metaitem('rotorSteel'), null],
]);

RecyclingHelper.addShaped("gregtech:froth_flotation_tank", metaitem('susy:froth_flotation_tank'), [
    [tieredCables[3], metaitem('rotorStainlessSteel'), tieredCables[3]],
    [pumps[3], hulls[3], pumps[3]],
    [circuits[3], motors[3], circuits[3]]
]);

RecyclingHelper.addShaped("gregtech:froth_flotation_vat", item('susy:multiblock_tank', 1) * 4, [
    [null, null, null],
    [metaitem('plateStainlessSteel'), item('minecraft:cauldron'), metaitem('plateStainlessSteel')],
    [metaitem('pipeSmallFluidStainlessSteel'), metaitem('pipeSmallFluidStainlessSteel'), metaitem('pipeSmallFluidStainlessSteel')]
]);

RecyclingHelper.addShaped("gregtech:vacuum_distillation_tower", metaitem('susy:vacuum_distillation_tower'), [
    [metaitem('rotorSteel'), circuits[2], metaitem('rotorSteel')],
    [pumps[2], metaitem('hull.mv'), pumps[2]],
    [metaitem('pipeHugeFluidSteel'), circuits[2], metaitem('pipeHugeFluidSteel')]
])

RecyclingHelper.replaceShaped("gregtech:vacuum_freezer", metaitem('vacuum_freezer'), [
    [pumps[3], pumps[3], pumps[3]],
    [circuits[3], item('gregtech:metal_casing', 3), circuits[3]],
    [metaitem('cableGtSingleGold'), circuits[3], metaitem('cableGtSingleGold')]
])

RecyclingHelper.addShaped("gregtech:natural_draft_cooling_tower", metaitem('susy:natural_draft_cooling_tower'), [
    [metaitem('pipeHugeFluidStainlessSteel'), metaitem('pipeHugeFluidStainlessSteel'), metaitem('pipeHugeFluidStainlessSteel')],
    [motors[3], metaitem('hull.hv'), motors[3]],
    [pumps[3], circuits[3], pumps[3]]
])

RecyclingHelper.addShaped("gregtech:quencher", metaitem('susy:quencher'), [
    [pumps[3], metaitem('robot.arm.hv'), pumps[3]],
    [circuits[3], item('gregtech:metal_casing', 5), circuits[3]],
    [metaitem('pipeLargeFluidStainlessSteel'), circuits[3], metaitem('pipeLargeFluidStainlessSteel')]
])

RecyclingHelper.addShaped("gregtech:dumper", metaitem('susy:dumper'), [
    [metaitem('plateSteel'), metaitem('plateSteel'), metaitem('plateSteel')],
    [metaitem('electric.pump.lv'), metaitem('hull.lv'), metaitem('pipeLargeFluidSteel')],
    [metaitem('plateSteel'), metaitem('plateSteel'), metaitem('plateSteel')]
])

RecyclingHelper.addShaped("gregtech:coking_tower", metaitem('susy:coking_tower'), [
    [metaitem('pipeHugeFluidSteel'), pumps[3], metaitem('pipeHugeFluidSteel')],
    [circuits[3], hulls[3], circuits[3]],
    [metaitem('pipeHugeFluidSteel'), pumps[3], metaitem('pipeHugeFluidSteel')]
]);

RecyclingHelper.addShaped("gregtech:rotary_kiln", metaitem('susy:rotary_kiln'), [
    [circuits[2], null, tieredCables[2]],
    [metaitem('pipeHugeFluidSteel'), hulls[2], metaitem('pipeHugeFluidSteel')],
    [circuits[2], motors[2], tieredCables[2]]
]);

RecyclingHelper.addShaped("gregtech:high_temperature_distillation_tower", metaitem('susy:high_temperature_distillation_tower'), [
    [circuits[3], item('gregtech:wire_coil'), circuits[3]],
    [pumps[3], hulls[3], pumps[3]],
    [circuits[3], item('gregtech:wire_coil'), circuits[3]]
]);

//ION EXCHANGE COLUMN

for (i = 1; i <= 8; i++) {
    RecyclingHelper.addShaped("gregtech:ion_exchange_column." + Globals.voltageTiers[i], metaitem('susy:ion_exchange_column.' + Globals.voltageTiers[i]), [
        [null, pumps[i], null],
        [tieredGlass[i], tieredPipes[i], tieredGlass[i]],
        [circuits[i], hulls[i], circuits[i]]
    ])
}

// CVD

for (i = 1; i <= 8; i++) {
    RecyclingHelper.addShaped("gregtech:cvd." + Globals.voltageTiers[i], metaitem('susy:cvd.' + Globals.voltageTiers[i]), [
        [pumps[i], tieredGlass[i], tieredGlass[i]],
        [hulls[i], tieredSprings[i], tieredPipes[i]],
        [circuits[i], tieredCables[i], tieredCables[i]]
    ])
}

// Zone Refiner

for (i = 1; i <= 8; i++) {
    RecyclingHelper.addShaped("gregtech:zone_refiner." + Globals.voltageTiers[i], metaitem('susy:zone_refiner.' + Globals.voltageTiers[i]), [
        [tieredSprings[i], tieredPipes[i], tieredSprings[i]],
        [tieredQuadCables[i], hulls[i], tieredQuadCables[i]],
        [circuits[i], conveyors[i], circuits[i]]
    ])
}

// Tube Furnace

for (i = 1; i <= 8; i++) {
    RecyclingHelper.addShaped("gregtech:tube_furnace." + Globals.voltageTiers[i], metaitem('susy:tube_furnace.' + Globals.voltageTiers[i]), [
        [circuits[i], tieredGlass[i], tieredGlass[i]],
        [hulls[i], tieredSprings[i], tieredPipes[i]],
        [tieredCables[i], conveyors[i], tieredCables[i]]
    ])
}

// Polishing Machine

for (i = 1; i <= 8; i++) {
    RecyclingHelper.addShaped("gregtech:polishing_machine." + Globals.voltageTiers[i], metaitem('susy:polishing_machine.' + Globals.voltageTiers[i]), [
        [robotArms[i], circuits[i], pumps[i]],
        [tieredGlass[i], hulls[i], tieredGlass[i]],
        [tieredCables[i], motors[i], tieredCables[i]]
    ])
}

// Textile Spinner

for (i = 1; i <= 8; i++) {
    RecyclingHelper.addShaped("gregtech:textile_spinner." + Globals.voltageTiers[i], metaitem('susy:textile_spinner.' + Globals.voltageTiers[i]), [
        [circuits[i], tieredCables[i], circuits[i]],
        [pumps[i], hulls[i], motors[i]],
        [tieredCables[i], motors[i], motors[i]]
    ])
}

// Incinerator

for (i = 1; i <= 4; i++) {
    RecyclingHelper.addShaped("gregtech:incinerator." + Globals.voltageTiers[i], metaitem('susy:incinerator.' + Globals.voltageTiers[i]), [
        [circuits[i], pumps[i], circuits[i]],
        [tieredQuadCables[i], hulls[i], tieredQuadCables[i]],
        [tieredSprings[i], tieredSprings[i], tieredSprings[i]]
    ])
}

// Bath Condenser

RecyclingHelper.addShaped("gregtech:bath_condenser", metaitem('susy:bath_condenser'), [
    [metaitem('pipeSmallFluidStainlessSteel'), metaitem('pipeSmallFluidStainlessSteel'), metaitem('pipeSmallFluidStainlessSteel')],
    [metaitem('pipeSmallFluidStainlessSteel'), metaitem('hull.hv'), metaitem('pipeSmallFluidStainlessSteel')],
    [metaitem('pipeSmallFluidStainlessSteel'), metaitem('pipeSmallFluidStainlessSteel'), metaitem('pipeSmallFluidStainlessSteel')]
])

// Phase Separator

RecyclingHelper.addShaped("gregtech:phase_separator", metaitem('susy:phase_separator'), [
    [metaitem('frameSteel'), metaitem('drum.steel'), metaitem('pipeSmallFluidSteel')],
    [metaitem('pipeSmallFluidSteel'), metaitem('hull.lv'), metaitem('pipeSmallFluidSteel')]
])

//Multiblocked Machines

/*
crafting.addShaped("multiblocked:ore_sorter", item('multiblocked:ore_sorter'), [
    [robotArms[1], circuits[2], robotArms[1]],
    [pumps[1], hulls[1], pumps[1]],
    [robotArms[1], circuits[2], robotArms[1]]
]);

 */

//// conversion recipes from greg ports
//crafting.addShapeless("lv input bus -> mbd input bus", item('multiblocked:item_input'), [metaitem('item_bus.import.lv')]);
//crafting.addShapeless("lv output bus -> mbd output bus", item('multiblocked:item_output'), [metaitem('item_bus.export.lv')]);
//crafting.addShapeless("lv input hatch -> mbd input hatch", item('multiblocked:fluid_input'), [metaitem('fluid_hatch.import.lv')]);
//crafting.addShapeless("lv output hatch -> mbd output hatch", item('multiblocked:fluid_output'), [metaitem('fluid_hatch.export.lv')]);
//
//// conversion recipes to greg ports
//crafting.addShapeless("mbd input bus -> lv input bus", metaitem('item_bus.import.lv'), [item('multiblocked:item_input')]);
//crafting.addShapeless("mbd output bus -> lv output bus", metaitem('item_bus.export.lv'), [item('multiblocked:item_output')]);
//crafting.addShapeless("mbd input hatch -> lv input hatch", metaitem('fluid_hatch.import.lv'), [item('multiblocked:fluid_input')]);
//crafting.addShapeless("mbd output hatch -> lv output hatch", metaitem('fluid_hatch.export.lv'), [item('multiblocked:fluid_output')]);

//MetaTileEntityLoader.registerMachineRecipe(true, SuSyMetaTileEntities.VULCANIZING_PRESS, "WPW", "CHC", "WEW", 'H' as char, HULL, 'E' as char, CIRCUIT, 'W' as char, CABLE, 'C' as char, COIL_HEATING_DOUBLE, 'P' as char, PISTON)
//MetaTileEntityLoader.registerMachineRecipe(true, SuSyMetaTileEntities.ROASTER, "ERE", "CHC", "WCW", 'H' as char, HULL, 'E' as char, CIRCUIT, 'W' as char, CABLE, 'C' as char, COIL_HEATING_DOUBLE, 'R' as char, ROTOR)
//MetaTileEntityLoader.registerMachineRecipe(true, SuSyMetaTileEntities.LATEX_COLLECTOR, "ETE", "GPG", "WHW", 'H' as char, HULL, 'E' as char, CIRCUIT, 'W' as char, CABLE, 'T' as char, new UnificationEntry(OrePrefix.toolHeadDrill, Materials.Steel), 'P' as char, PUMP, 'G' as char, GLASS)

//ModHandler.addShapedRecipe(true, "roaster.bronze", SuSyMetaTileEntities.roaster.bronze.getStackForm(), "XRX", "XMX", "XFX", 'M' as char, MetaBlocks.STEAM_CASING.getItemVariant(SteamCasingType.BRONZE_BRICKS_HULL), 'X' as char, new UnificationEntry(OrePrefix.pipeSmallFluid, Materials.Bronze), 'F' as char, OreDictNames.craftingFurnace, 'R' as char, new UnificationEntry(OrePrefix.rotor, Materials.Bronze))
//ModHandler.addShapedRecipe(true, "vulcanizing_press.bronze", SuSyMetaTileEntities.vulcanizing_press.bronze.getStackForm(), "SRS", "XPX", "XMX", 'M' as char, MetaBlocks.STEAM_CASING.getItemVariant(SteamCasingType.BRONZE_BRICKS_HULL), 'X' as char, new UnificationEntry(OrePrefix.pipeSmallFluid, Materials.Bronze), 'P' as char, new UnificationEntry(OrePrefix.plate, Materials.Steel), 'S' as char, new UnificationEntry(OrePrefix.springSmall, Materials.Steel), 'R' as char, new UnificationEntry(OrePrefix.stick, Materials.Steel))
//ModHandler.addShapedRecipe(true, "latex_collector_bronze", SuSyMetaTileEntities.LATEX_COLLECTOR_BRONZE.getStackForm(), " T ", "GPG", "XMX", 'M' as char, MetaBlocks.STEAM_CASING.getItemVariant(SteamCasingType.BRONZE_HULL), 'X' as char, new UnificationEntry(OrePrefix.pipeSmallFluid, Materials.Bronze), 'G' as char, new UnificationEntry(OrePrefix.blockGlass), 'P' as char, new UnificationEntry(OrePrefix.rotor, Materials.Steel), 'T' as char, new UnificationEntry(OrePrefix.toolHeadDrill, Materials.Steel))
//ModHandler.addShapedRecipe(true, "mixer.bronze", SuSyMetaTileEntities.mixer.bronze.getStackForm(), "GPG", "GRG", "XMX", 'M' as char, MetaBlocks.STEAM_CASING.getItemVariant(SteamCasingType.BRONZE_HULL), 'X' as char, new UnificationEntry(OrePrefix.pipeSmallFluid, Materials.Bronze), 'G' as char, new UnificationEntry(OrePrefix.blockGlass), 'P' as char, new UnificationEntry(OrePrefix.rotor, Materials.Bronze), 'R' as char, new UnificationEntry(OrePrefix.stick, Materials.Bronze))
//ModHandler.addShapedRecipe(true, "coagulation_tank_wall", SuSyBlocks.COAGULATION_TANK_WALL.getItemVariant(CoagulationTankWallType.WOODEN_COAGULATION_TANK_WALL), "WBW", "sPh", "WBW", 'W' as char, MetaBlocks.PLANKS.getItemVariant(BlockGregPlanks.BlockType.TREATED_PLANK), 'P' as char, new UnificationEntry(OrePrefix.frameGt, Materials.TreatedWood), 'B' as char, new UnificationEntry(OrePrefix.bolt, Materials.Steel));
//ModHandler.addShapedRecipe(true, "coagulation_tank", SuSyMetaTileEntities.COAGULATION_TANK.getStackForm(), "WRW", "sPh", "WBW", 'W' as char, MetaBlocks.PLANKS.getItemVariant(BlockGregPlanks.BlockType.TREATED_PLANK), 'P' as char, new UnificationEntry(OrePrefix.pipeLargeFluid, Materials.TreatedWood), 'B' as char, new UnificationEntry(OrePrefix.bolt, Materials.Steel), 'R' as char, new UnificationEntry(OrePrefix.rotor, Materials.Steel));

//Fluid Drilling Rig
mods.gregtech.assembler.removeByInput(120, [metaitem('hull.mv'), metaitem('frameSteel') * 4, metaitem('circuit.good_integrated') * 4, metaitem('electric.motor.mv') * 4, metaitem('electric.pump.mv') * 4, metaitem('gearVanadiumSteel') * 4, metaitem('circuit.integrated').withNbt(["Configuration": 2])], null)

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('hull.lv'))
    .inputs(metaitem('frameSteel') * 4)
    .inputs(ore('circuitLv') * 4)
    .inputs(metaitem('electric.pump.lv') * 4)
    .inputs(metaitem('electric.motor.lv') * 4)
    .inputs(ore('gearSteel') * 4)
    .circuitMeta(2)
    .outputs(metaitem('fluid_drilling_rig.mv'))
    .EUt(30)
    .duration(600)
    .buildAndRegister()

//Catalytic Reformer

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('hull.hv'))
    .inputs(metaitem('frameStainlessSteel') * 4)
    .inputs(metaitem('electric.pump.hv') * 2)
    .inputs(metaitem('pipeHugeFluidStainlessSteel'))
    .inputs(metaitem('rotorStainlessSteel'))
    .inputs(ore('circuitHv'))
    .outputs(metaitem('susy:catalytic_reformer'))
    .circuitMeta(3)
    .EUt(480)
    .duration(600)
    .buildAndRegister() 

//Power Units
ASSEMBLER.recipeBuilder()
    .inputs(ore('gearSmallSteel') * 2)
    .inputs(ore('screwSteel'))
    .inputs(ore('plateSteel') * 2)
    .inputs(metaitem('electric.motor.lv'))
    .inputs(ore('batteryLv'))
    .outputs(metaitem('power_unit.lv'))
    .EUt(30)
    .duration(150)
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(ore('gearSmallAluminium') * 2)
    .inputs(ore('screwAluminium'))
    .inputs(ore('plateAluminium') * 2)
    .inputs(metaitem('electric.motor.mv'))
    .inputs(ore('batteryMv'))
    .outputs(metaitem('power_unit.mv'))
    .EUt(120)
    .duration(150)
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(ore('gearSmallStainlessSteel') * 2)
    .inputs(ore('screwStainlessSteel'))
    .inputs(ore('plateStainlessSteel') * 2)
    .inputs(metaitem('electric.motor.hv'))
    .inputs(ore('batteryHv'))
    .outputs(metaitem('power_unit.hv'))
    .EUt(480)
    .duration(150)
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(ore('gearSmallTitanium') * 2)
    .inputs(ore('screwTitanium'))
    .inputs(ore('plateTitanium') * 2)
    .inputs(metaitem('electric.motor.ev'))
    .inputs(ore('batteryEv'))
    .outputs(metaitem('power_unit.ev'))
    .EUt(1920)
    .duration(150)
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(ore('gearSmallTungstenSteel') * 2)
    .inputs(ore('screwTungstenSteel'))
    .inputs(ore('plateTungstenSteel') * 2)
    .inputs(metaitem('electric.motor.iv'))
    .inputs(ore('batteryIv'))
    .outputs(metaitem('power_unit.iv'))
    .EUt(7680)
    .duration(150)
    .buildAndRegister()

// AIR DIST. CONTROLLERS

ASSEMBLER.recipeBuilder()
    .circuitMeta(2)
    .inputs(metaitem('hull.Hv'))
    .inputs(metaitem('frameAluminium') * 3)
    .inputs(ore('circuitHv') * 4)
    .inputs(metaitem('electric.pump.hv') * 4)
    .inputs(ore('plateAluminium') * 4)
    .inputs(metaitem('mineral_wool') * 64)
    .fluidInputs(fluid('cryogenic_solder') * 1296)
    .outputs(metaitem('susy:single_column_cryogenic_distillation_plant'))
    .EUt(30)
    .duration(600)
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .circuitMeta(3)
    .inputs(metaitem('hull.Hv'))
    .inputs(metaitem('frameAluminium') * 3)
    .inputs(ore('circuitHv') * 2)
    .inputs(metaitem('electric.pump.hv') * 4)
    .inputs(ore('plateAluminium') * 4)
    .inputs(item('susy:serpentine') * 6)
    .inputs(metaitem('mineral_wool') * 64)
    .fluidInputs(fluid('cryogenic_solder') * 1296)
    .outputs(metaitem('susy:low_pressure_cryogenic_distillation_plant'))
    .EUt(30)
    .duration(600)
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .circuitMeta(4)
    .inputs(metaitem('hull.Hv'))
    .inputs(metaitem('frameAluminium') * 12)
    .inputs(ore('circuitHv') * 6)
    .inputs(metaitem('electric.pump.hv') * 8)
    .inputs(ore('plateAluminium') * 4)
    .inputs(metaitem('mineral_wool') * 64)
    .fluidInputs(fluid('cryogenic_solder') * 1296)
    .outputs(metaitem('susy:high_pressure_cryogenic_distillation_plant'))
    .EUt(30)
    .duration(600)
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .circuitMeta(3)
    .inputs(metaitem('hull.Hv'))
    .inputs(metaitem('frameStainlessSteel'))
    .inputs(ore('platePolytetrafluoroethylene') * 4)
    .inputs(ore('circuitHv') * 2)
    .inputs(metaitem('electric.motor.hv'))
    .inputs(metaitem('electric.pump.hv') * 4)
    .outputs(metaitem('susy:blender'))
    .EUt(30)
    .duration(600)
    .buildAndRegister()

RecyclingHelper.addShaped('gregtech:large_fluid_pump', metaitem('susy:large_fluid_pump'), [
    [metaitem('rotorBronze'), ore('circuitLv'), metaitem('rotorBronze')],
    [metaitem('cableGtQuadrupleTin'), metaitem('hull.lv'), metaitem('cableGtQuadrupleTin')],
    [metaitem('rotorBronze'), ore('circuitLv'), metaitem('rotorBronze')]
])

RecyclingHelper.addShaped("gregtech:sieve_distillation_tower", metaitem('susy:sieve_distillation_tower'), [
    [metaitem('frameStainlessSteel'), ore('circuitHv'), metaitem('frameStainlessSteel')],
    [metaitem('springKanthal'), metaitem('hull.Hv'), metaitem('springKanthal')],
    [metaitem('frameStainlessSteel'), metaitem('electric.pump.hv'), metaitem('frameStainlessSteel')]
])

// COMBUSTION ENGINES

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('hull.Lv'))
    .inputs(ore('springCopper'))
    .inputs(ore('springSmallCopper'))
    .inputs(ore('circuitLv'))
    .inputs(metaitem('engine.spark_plug') * 4)
    .inputs(metaitem('engine.piston') * 4)
    .inputs(metaitem('engine.crankshaft'))
    .inputs(ore('gearSteel') * 2)
    .inputs(ore('pipeHugeFluidSteel'))
    .outputs(metaitem('combustion_generator.lv'))
    .EUt(30)
    .duration(600)
    .buildAndRegister()

RecyclingHelper.removeRecyclingRecipes(metaitem('combustion_generator.lv'))
RecyclingHelper.handleRecycling(metaitem('combustion_generator.lv'), [
    metaitem('hull.Lv'),
    ore('springCopper'),
    ore('springSmallCopper'),
    metaitem('engine.spark_plug') * 4, //doesn't get counted by RecyclingHandler
    metaitem('engine.piston') * 4,     //doesn't get counted by RecyclingHandler
    metaitem('engine.crankshaft'),     //doesn't get counted by RecyclingHandler
    ore('gearSteel') * 2,
    ore('pipeHugeFluidSteel'),
])

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('hull.Mv'))
    .inputs(ore('springCopper'))
    .inputs(ore('springSmallCopper'))
    .inputs(ore('circuitMv'))
    .inputs(metaitem('engine.spark_plug') * 4)
    .inputs(metaitem('engine.piston') * 4)
    .inputs(metaitem('engine.crankshaft'))
    .inputs(ore('gearAluminium') * 2)
    .inputs(ore('pipeHugeFluidAluminium'))
    .outputs(metaitem('combustion_generator.mv'))
    .EUt(30)
    .duration(600)
    .buildAndRegister()

RecyclingHelper.removeRecyclingRecipes(metaitem('combustion_generator.mv'))
RecyclingHelper.handleRecycling(metaitem('combustion_generator.mv'), [
    metaitem('hull.Mv'),
    ore('springCopper'),
    ore('springSmallCopper'),
    metaitem('engine.spark_plug') * 4, //doesn't get counted by RecyclingHandler
    metaitem('engine.piston') * 4,     //doesn't get counted by RecyclingHandler
    metaitem('engine.crankshaft'),     //doesn't get counted by RecyclingHandler
    ore('gearAluminium') * 2,
    ore('pipeHugeFluidAluminium'),
])

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('hull.Hv'))
    .inputs(ore('springCopper'))
    .inputs(ore('springSmallCopper'))
    .inputs(ore('circuitHv'))
    .inputs(metaitem('engine.spark_plug') * 4)
    .inputs(metaitem('engine.piston') * 4)
    .inputs(metaitem('engine.crankshaft'))
    .inputs(ore('gearStainlessSteel') * 2)
    .inputs(ore('pipeHugeFluidStainlessSteel'))
    .outputs(metaitem('combustion_generator.hv'))
    .EUt(30)
    .duration(600)
    .buildAndRegister()

RecyclingHelper.removeRecyclingRecipes(metaitem('combustion_generator.hv'))
RecyclingHelper.handleRecycling(metaitem('combustion_generator.hv'), [
    metaitem('hull.Hv'),
    ore('springCopper'),
    ore('springSmallCopper'),
    metaitem('engine.spark_plug') * 4, //doesn't get counted by RecyclingHandler
    metaitem('engine.piston') * 4,     //doesn't get counted by RecyclingHandler
    metaitem('engine.crankshaft'),     //doesn't get counted by RecyclingHandler
    ore('gearStainlessSteel') * 2,
    ore('pipeHugeFluidStainlessSteel'),
])

// Train interfaces
RecyclingHelper.addShaped("gregtech:fluid_loader", metaitem('susy:stock_fluid_exchanger'), [
		[ore('craftingToolHardHammer'), metaitem('electric.pump.lv'), ore('craftingToolWrench')],
		[ore('pipeSmallFluidSteel'), metaitem('hull.lv'), ore('pipeSmallFluidSteel')],
		[ore('pipeSmallFluidSteel'), metaitem('conveyor.module.lv'), ore('pipeSmallFluidSteel')]
])

RecyclingHelper.addShaped("gregtech:item_loader", metaitem('susy:stock_item_exchanger'), [
		[ore('craftingToolHardHammer'), ore('circuitLv'), ore('craftingToolWrench')],
		[ore('pipeSmallItemNickel'), metaitem('hull.lv'), ore('pipeSmallItemNickel')],
		[ore('pipeSmallItemNickel'), metaitem('electric.pump.lv'), ore('pipeSmallItemNickel')]
])

RecyclingHelper.addShaped("gregtech:locomotive_controller", metaitem('susy:stock_controller'), [
		[ore('craftingToolHardHammer'), ore('circuitLv'), ore('craftingToolWrench')],
		[ore('pipeSmallItemNickel'), metaitem('hull.lv'), ore('pipeSmallItemNickel')],
		[metaitem('emitter.lv'), ore('circuitLv'), metaitem('sensor.lv')]
])
