import static globals.Globals.*
import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;

def name_removals = [
		'gregtech:steam_turbine_mv',
		'gregtech:steam_turbine_hv',
		'gregtech:gas_turbine_lv',
		'gregtech:gas_turbine_mv',
		'gregtech:gas_turbine_hv',
		'gregtech:diesel_generator_lv',
		'gregtech:diesel_generator_mv',
		'gregtech:diesel_generator_hv',
		'gcym:steam_engine'
]

for (name in name_removals) {
	crafting.remove(name)
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
	ore('rotorBronze'),
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
crafting.addShaped("gregtech:vulcanizing_press.ulv", metaitem('vulcanizing_press.bronze'), [
	[ore('springSmallSteel'), ore('stickSteel'), ore('springSmallSteel')],
	[ore('pipeSmallFluidBronze'), ore('plateSteel'), ore('pipeSmallFluidBronze')],
	[ore('pipeSmallFluidBronze'), item('gregtech:steam_casing', 1), ore('pipeSmallFluidBronze')]
])
crafting.addShaped("gregtech:vulcanizing_press.lv", metaitem('vulcanizing_press.lv'), [
	[ore('cableGtSingleTin'), metaitem('electric.piston.lv'), ore('cableGtSingleTin')],
	[ore('wireGtQuadrupleCopper'), metaitem('hull.lv'), ore('wireGtQuadrupleCopper')],
	[ore('cableGtSingleTin'), ore('circuitLv'), ore('cableGtSingleTin')]
])
crafting.addShaped("gregtech:vulcanizing_press.mv", metaitem('vulcanizing_press.mv'), [
	[ore('cableGtSingleCopper'), metaitem('electric.piston.mv'), ore('cableGtSingleCopper')],
	[ore('wireGtQuadrupleCupronickel'), metaitem('hull.mv'), ore('wireGtQuadrupleCupronickel')],
	[ore('cableGtSingleCopper'), ore('circuitMv'), ore('cableGtSingleCopper')]
])
crafting.addShaped("gregtech:vulcanizing_press.hv", metaitem('vulcanizing_press.hv'), [
	[ore('cableGtSingleGold'), metaitem('electric.piston.hv'), ore('cableGtSingleGold')],
	[ore('wireGtQuadrupleKanthal'), metaitem('hull.hv'), ore('wireGtQuadrupleKanthal')],
	[ore('cableGtSingleGold'), ore('circuitHv'), ore('cableGtSingleGold')]
])
crafting.addShaped("gregtech:vulcanizing_press.ev", metaitem('vulcanizing_press.ev'), [
	[ore('cableGtSingleAluminium'), metaitem('electric.piston.ev'), ore('cableGtSingleAluminium')],
	[ore('wireGtQuadrupleNichrome'), metaitem('hull.ev'), ore('wireGtQuadrupleNichrome')],
	[ore('cableGtSingleAluminium'), ore('circuitEv'), ore('cableGtSingleAluminium')]
])

log.infoMC("Adding Roaster Craft")

//Roaster
crafting.addShaped("gregtech:roaster.ulv", metaitem('roaster.bronze'), [
	[ore('pipeSmallFluidBronze'), ore('rotorBronze'), ore('pipeSmallFluidBronze')],
	[ore('pipeSmallFluidBronze'), item('gregtech:steam_casing', 1), ore('pipeSmallFluidBronze')],
	[ore('pipeSmallFluidBronze'), ore('craftingFurnace'), ore('pipeSmallFluidBronze')]
])

for (i = 1; i <= 8; i++) {
	crafting.addShaped("gregtech:roaster." + Globals.voltageTiers[i], metaitem('roaster.' + Globals.voltageTiers[i]), [
		[circuits[i], rotors[i], circuits[i]],
		[tieredWires[i], hulls[i], tieredWires[i]],
		[tieredCables[i], tieredWires[i], tieredCables[i]]
	])
}

log.infoMC("Adding Latex Collector Craft")

//Latex Collector
crafting.addShaped("gregtech:latex_collector.ulv", metaitem('latex_collector.bronze'), [
	[null, ore('toolHeadDrillSteel'), null],
	[ore('blockGlass'), ore('rotorSteel'), ore('blockGlass')],
	[ore('pipeSmallFluidBronze'), item('gregtech:steam_casing'), ore('pipeSmallFluidBronze')]
])

for (i = 1; i <= 4; i++) {
	crafting.addShaped("gregtech:latex_collector." + Globals.voltageTiers[i], metaitem('latex_collector.' + Globals.voltageTiers[i]), [
		[circuits[i], ore('toolHeadDrillSteel'), circuits[i]],
		[ore('blockGlass'), pumps[i], ore('blockGlass')],
		[tieredCables[i], hulls[i], tieredCables[i]]
	])
}

log.infoMC("Adding Steam Mixer Craft")

//Mixer
crafting.addShaped("gregtech:mixer.ulv", metaitem('mixer.bronze'), [
	[ore('blockGlass'), ore('rotorBronze'), ore('blockGlass')],
	[ore('blockGlass'), ore('stickBronze'), ore('blockGlass')],
	[ore('pipeSmallFluidBronze'), item('gregtech:steam_casing'), ore('pipeSmallFluidBronze')]
])

log.infoMC("Adding Coagulation Tank Craft")

//Coagulation Tank
crafting.addShaped("gregtech:coagulation_tank", metaitem('coagulation_tank'), [
	[ore('plankTreatedWood'), ore('rotorSteel'), ore('plankTreatedWood')],
	[ore('craftingToolSaw'), ore('pipeLargeFluidTreatedWood'), ore('craftingToolHardHammer')],
	[ore('plankTreatedWood'), ore('boltSteel'), ore('plankTreatedWood')]
])
crafting.addShaped("gregtech:coagulation_tank_wall", item('susy:coagulation_tank_wall'), [
	[ore('plankTreatedWood'), ore('boltSteel'), ore('plankTreatedWood')],
	[ore('craftingToolSaw'), ore('frameGtTreatedWood'), ore('craftingToolHardHammer')],
	[ore('plankTreatedWood'), ore('boltSteel'), ore('plankTreatedWood')]
])

//Nerf arc furnaces, add graphite rod chain
recipemap('mixer').recipeBuilder()
		.fluidInputs(fluid('coal_tar') * 1000)
		.inputs(ore('dustCoke') * 4)
		.outputs(metaitem('pitch_binder') * 4)
		.EUt(30)
		.duration(200)
		.buildAndRegister()

recipemap('extruder').recipeBuilder()
		.notConsumable(metaitem('shape.extruder.rod'))
		.inputs(metaitem('pitch_binder'))
		.outputs(metaitem('raw_electrode'))
		.EUt(30)
		.duration(200)
		.buildAndRegister()

recipemap('sintering_oven').recipeBuilder()
		.inputs(metaitem('raw_electrode'))
		.fluidInputs(fluid('syngas') * 100)
		.fluidInputs(fluid('air') * 100)
		.outputs(metaitem('graphite_electrode'))
		.fluidOutputs(fluid('carbon_dioxide') * 50)
		.EUt(30)
		.duration(150)
		.buildAndRegister()

recipemap('sintering_oven').recipeBuilder()
		.inputs(metaitem('raw_electrode'))
		.fluidInputs(fluid('methane') * 100)
		.fluidInputs(fluid('air') * 100)
		.outputs(metaitem('graphite_electrode'))
		.fluidOutputs(fluid('carbon_dioxide') * 50)
		.EUt(30)
		.duration(150)
		.buildAndRegister()

recipemap('sintering_oven').recipeBuilder()
		.inputs(metaitem('raw_electrode'))
		.fluidInputs(fluid('syngas') * 100)
		.fluidInputs(fluid('oxygen') * 80)
		.outputs(metaitem('graphite_electrode'))
		.fluidOutputs(fluid('carbon_dioxide') * 50)
		.EUt(30)
		.duration(150)
		.buildAndRegister()

recipemap('sintering_oven').recipeBuilder()
		.inputs(metaitem('raw_electrode'))
		.fluidInputs(fluid('methane') * 100)
		.fluidInputs(fluid('oxygen') * 80)
		.outputs(metaitem('graphite_electrode'))
		.fluidOutputs(fluid('carbon_dioxide') * 50)
		.EUt(30)
		.duration(150)
		.buildAndRegister()


for (i = 1; i <= 8; i++) {
	crafting.remove('gregtech:gregtech.machine.arc_furnace.' + Globals.voltageTiers[i])

	crafting.addShaped("gregtech:arc_furnace." + Globals.voltageTiers[i], metaitem('arc_furnace.' + Globals.voltageTiers[i]), [
			[tieredQuadCables[i], metaitem('graphite_electrode'), tieredQuadCables[i]],
			[circuits[i], hulls[i], circuits[i]],
			[tieredPlates[i], tieredPlates[i], tieredPlates[i]]
	])
}

//Add recipes for new chemical reactors, and remove old chemical reactor recipes

for (i = 1; i <= 8; i++) {
	crafting.remove('gregtech:gregtech.machine.chemical_reactor.' + Globals.voltageTiers[i])

	crafting.addShaped("gregtech:continuous_stirred_tank_reactor." + Globals.voltageTiers[i], metaitem('continuous_stirred_tank_reactor.' + Globals.voltageTiers[i]), [
			[chemicalReactorParts[i], rotors[i], chemicalReactorParts[i]],
			[tieredCables[i], motors[i], tieredCables[i]],
			[circuits[i], hulls[i], circuits[i]]
	])

	crafting.addShaped("gregtech:batch_reactor." + Globals.voltageTiers[i], metaitem('batch_reactor.' + Globals.voltageTiers[i]), [
			[tieredCables[i], pumps[i], tieredCables[i]],
			[chemicalReactorParts[i], hulls[i], chemicalReactorParts[i]],
			[circuits[i], tieredCables[i], circuits[i]]
	])

	crafting.addShaped("gregtech:bubble_column_reactor." + Globals.voltageTiers[i], metaitem('bubble_column_reactor.' + Globals.voltageTiers[i]), [
			[chemicalReactorParts[i], tieredPipes[i], chemicalReactorParts[i]],
			[tieredCables[i], pumps[i], tieredCables[i]],
			[circuits[i], hulls[i], circuits[i]]
	])

	crafting.addShaped("gregtech:fixed_bed_reactor." + Globals.voltageTiers[i], metaitem('fixed_bed_reactor.' + Globals.voltageTiers[i]), [
			[null, circuits[i], null],
			[tieredPipes[i], pumps[i], tieredPipes[i]],
			[tieredCables[i], hulls[i], tieredCables[i]]
	])

	crafting.addShaped("gregtech:crystallizer." + Globals.voltageTiers[i], metaitem('crystallizer.' + Globals.voltageTiers[i]), [
			[tieredPlates[i], tieredGlass[i], tieredPlates[i]],
			[chemicalReactorParts[i], hulls[i], chemicalReactorParts[i]],
			[circuits[i], pumps[i], circuits[i]]
	])

	crafting.addShaped("gregtech:trickle_bed_reactor." + Globals.voltageTiers[i], metaitem('trickle_bed_reactor.' + Globals.voltageTiers[i]), [
			[tieredCables[i], pumps[i], tieredCables[i]],
			[tieredPipes[i], hulls[i], tieredPipes[i]],
			[circuits[i], pumps[i], circuits[i]]
	])
}

//Polymerization tank and fluidized bed reactor

crafting.addShaped("gregtech:polymerization_tank", metaitem('polymerization_tank'), [
		[tieredCables[1], motors[1], tieredCables[1]],
		[pumps[1], rotors[1], pumps[1]],
		[circuits[1], hulls[1], circuits[1]]
])

crafting.addShaped("gregtech:fluidized_bed_reactor", metaitem('fluidized_bed_reactor'), [
		[tieredCables[3], pumps[3], tieredCables[3]],
		[metaitem('pipeLargeFluidPolytetrafluoroethylene'), hulls[3], metaitem('pipeLargeFluidPolytetrafluoroethylene')],
		[circuits[3], motors[3], circuits[3]]
])

//Dryer

for (i = 1; i <= 8; i++) {
	crafting.addShaped("gregtech:dryer." + Globals.voltageTiers[i], metaitem('dryer.' + Globals.voltageTiers[i]), [
			[tieredCables[i], circuits[i], tieredCables[i]],
			[tieredSprings[i], hulls[i], tieredSprings[i]],
			[tieredCables[i], circuits[i], tieredCables[i]]
	])
}

//Weapons Factory

for (def i = 1; i < 8; i++) {
	crafting.addShaped("gregtech:weapons_factory." + i, metaitem('weapons_factory.' + Globals.voltageTiers[i]), [
			[circuits[i], robotArms[i], circuits[i]],
			[conveyors[i], hulls[i], conveyors[i]],
			[tieredCables[i], circuits[i], tieredCables[i]]
	])
}

//Fluid compressors and decompressors

for (def i = 1; i < 8; i++) {
	crafting.addShaped("gregtech:fluid_decompressor." + i, metaitem('fluid_decompressor.' + Globals.voltageTiers[i]), [
			[tieredGlass[i], pistons[i], tieredGlass[i]],
			[pumps[i], hulls[i], tieredPipes[i]],
			[circuits[i], tieredCables[i], circuits[i]]
	])

	crafting.addShaped("gregtech:fluid_compressor." + i, metaitem('fluid_compressor.' + Globals.voltageTiers[i]), [
			[tieredGlass[i], pistons[i], tieredGlass[i]],
			[tieredPipes[i], hulls[i], pumps[i]],
			[circuits[i], tieredCables[i], circuits[i]]
	])
}

//Nerf polarizer and electromagnetic separator

for (i = 1; i <= 8; i++) {
	crafting.replaceShaped("gregtech:gregtech.machine.polarizer." + Globals.voltageTiers[i], metaitem('polarizer.' + Globals.voltageTiers[i]), [
			[tieredWires[i], tieredMagnets[i], tieredWires[i]],
			[tieredCables[i], hulls[i], tieredCables[i]],
			[tieredWires[i], tieredMagnets[i], tieredWires[i]]
	])

	crafting.replaceShaped("gregtech:gregtech.machine.electromagnetic_separator." + Globals.voltageTiers[i], metaitem('electromagnetic_separator.' + Globals.voltageTiers[i]), [
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
	crafting.replaceShaped("gregtech:gregtech.machine.electrostatic_separator." + Globals.voltageTiers[i], metaitem('electrostatic_separator.' + Globals.voltageTiers[i]), [
			[tieredWires[i], tieredElectrodes[i], tieredWires[i]],
			[tieredCables[i], hulls[i], tieredCables[i]],
			[tieredWires[i], tieredElectrodes[i], tieredWires[i]]
	])
}

//Add recipes for high pressure steam machines

crafting.addShaped("gregtech:vulcanizing_press.steel", metaitem('vulcanizing_press.steel'), [
		[metaitem('plateSteel'), metaitem('plateSteel'), metaitem('plateSteel')],
		[metaitem('pipeSmallFluidTinAlloy'), metaitem('vulcanizing_press.bronze'), metaitem('pipeSmallFluidTinAlloy')],
		[metaitem('plateWroughtIron'), metaitem('plateWroughtIron'), metaitem('plateWroughtIron')]
])

crafting.addShaped("gregtech:mixer.steel", metaitem('mixer.steel'), [
		[metaitem('pipeSmallFluidTinAlloy'), metaitem('plateSteel'), metaitem('pipeSmallFluidTinAlloy')],
		[metaitem('plateWroughtIron'), metaitem('mixer.bronze'), metaitem('plateWroughtIron')],
		[metaitem('pipeSmallFluidTinAlloy'), metaitem('pipeSmallFluidTinAlloy'), metaitem('pipeSmallFluidTinAlloy')]
])

crafting.addShaped("gregtech:vacuum_chamber.steel", metaitem('vacuum_chamber.steel'), [
		[metaitem('plateSteel'), metaitem('pipeSmallFluidTinAlloy'), metaitem('plateSteel')],
		[metaitem('pipeSmallFluidTinAlloy'), metaitem('vacuum_chamber.bronze'), metaitem('pipeSmallFluidTinAlloy')],
		[metaitem('plateWroughtIron'), metaitem('pipeSmallFluidTinAlloy'), metaitem('plateWroughtIron')]
])

crafting.addShaped("gregtech:roaster.steel", metaitem('roaster.steel'), [
		[metaitem('plateWroughtIron'), metaitem('plateWroughtIron'), metaitem('plateWroughtIron')],
		[metaitem('plateSteel'), metaitem('roaster.bronze'), metaitem('plateSteel')],
		[metaitem('pipeSmallFluidTinAlloy'), metaitem('pipeSmallFluidTinAlloy'), metaitem('pipeSmallFluidTinAlloy')]
])

//Add the rest of the vacuum chambers

for (def i = 1; i < 8; i++) {
	crafting.addShaped("gregtech:vacuum_chamber." + i, metaitem('vacuum_chamber.' + Globals.voltageTiers[i]), [
			[tieredPlates[i], tieredPlates[i], tieredPlates[i]],
			[pumps[i], hulls[i], pumps[i]],
			[tieredCables[i], circuits[i], tieredCables[i]]
	])
}

//Sintering oven stuff

crafting.addShaped("gregtech:brick_sintering_block", item('susy:sintering_brick'), [
		[null, ore('craftingToolHardHammer'), null],
		[metaitem('foilSteel'), item('gregtech:metal_casing', 1), metaitem('foilSteel')],
		[null, null, null]
])

crafting.replaceShaped("gregtech:sintering_oven", metaitem('sintering_oven'), [
		[motors[1], rotors[1], metaitem('wireGtQuadrupleCupronickel')],
		[circuits[1], item('gregtech:metal_casing', 1), circuits[1]],
		[pumps[1], metaitem('wireGtQuadrupleCupronickel'), pumps[1]]
])

//Regate pyrolysis oven

crafting.replaceShaped("gregtech:pyrolyse_oven", metaitem('pyrolyse_oven'), [
		[pistons[1], circuits[1], metaitem('wireGtQuadrupleCupronickel')],
		[circuits[1], hulls[1], circuits[1]],
		[pistons[1], pumps[1], metaitem('wireGtQuadrupleCupronickel')]
])

//Laser Engraver -> Electron Beam Lithographer

for (i = 1; i <= 8; i++) {
	crafting.replaceShaped("gregtech:gregtech.machine.laser_engraver." + Globals.voltageTiers[i], metaitem('laser_engraver.' + Globals.voltageTiers[i]), [
			[pistons[i], metaitem('wireFineTungsten'), pistons[i]],
			[circuits[i], hulls[i], circuits[i]],
			[tieredCables[i], circuits[i], tieredCables[i]]
	])
}

//Fermentation Vat (and also remove old fermenters)

for (i = 1; i <= 8; i++) {
	crafting.remove("gregtech:gregtech.machine.fermenter." + Globals.voltageTiers[i])
}

crafting.addShaped("gregtech:fermentation_vat", metaitem('fermentation_vat'), [
		[tieredCables[1], pumps[1], tieredCables[1]],
		[ore('blockGlass'), hulls[1], ore('blockGlass')],
		[tieredCables[1], circuits[1], tieredCables[1]]
])

//UV Light Box

for (i = 1; i <= 8; i++) {
	crafting.addShaped("gregtech:uv_light_box." + Globals.voltageTiers[i], metaitem('uv_light_box.'  + Globals.voltageTiers[i]), [
			[tieredCables[i], metaitem('carbon_arc_lamp'), tieredCables[i]],
			[circuits[i], hulls[i], circuits[i]],
			[tieredPlates[i], tieredPlates[i], tieredPlates[i]]
	])
}

//Ion Implanter

for (i = 1; i <= 8; i++) {
	crafting.addShaped("gregtech:ion_implanter." + Globals.voltageTiers[i], metaitem('ion_implanter.'  + Globals.voltageTiers[i]), [
			[circuits[i], tieredGlass[i], circuits[i]],
			[tieredMagnets[i], hulls[i], tieredMagnets[i]],
			[tieredCables[i], tieredSprings[i], tieredCables[i]]
	])
}

// Pressure Swing Adsorber

crafting.addShaped("gregtech:pressure_swing_adsorber", metaitem('pressure_swing_adsorber'), [
		[metaitem('pipeLargeFluidAluminium'), motors[2], metaitem('pipeLargeFluidAluminium')],
		[pumps[2], metaitem('hull.mv'), pumps[2]],
		[circuits[2], metaitem('pipeLargeFluidAluminium'), circuits[2]]
])

//Turbine Recipes

crafting.addShaped("alternator_coil", item('susy:alternator_coil'), [
		[ore('craftingToolHardHammer'), metaitem('electric.motor.lv'), ore('craftingToolScrewdriver')],
		[metaitem('electric.motor.lv'), ore('plateSteel'),             metaitem('electric.motor.lv')],
		[ore('circuitLv'),              metaitem('cableGtSingleTin'),  ore('circuitLv')]
])

crafting.addShaped("steel_turbine_rotor", item('susy:turbine_rotor'), [
		[ore('plateSteel'),             ore('screwSteel'),     ore('plateSteel')],
		[ore('craftingToolHardHammer'), ore('stickLongSteel'), ore('craftingToolScrewdriver')],
		[ore('plateSteel'),             ore('rotorSteel'),     ore('plateSteel')]
])

crafting.addShaped("steel_turbine_controller", metaitem('basic_steam_turbine'), [
		[ore('plateSteel'),            metaitem('cableGtSingleTin'),       ore('plateSteel')],
		[ore('circuitLv'),             item('gregtech:machine_casing', 1), ore('circuitLv')],
		[metaitem('cableGtSingleTin'), ore('circuitLv'),                   metaitem('cableGtSingleTin')]
])

crafting.replaceShaped("gregtech:casing_steel_turbine_casing", item('gregtech:turbine_casing', 5) * 4, [
		[metaitem('plateSteel'), ore('craftingToolHardHammer'), metaitem('plateSteel')],
		[metaitem('stickLongSteel'), item('gregtech:stone_smooth', 4), metaitem('stickLongSteel')],
		[metaitem('plateSteel'), ore('craftingToolWrench'), metaitem('plateSteel')]
])

crafting.addShaped("gas_turbine_controller", metaitem('basic_gas_turbine'), [
		[ore('plateSteel'),               metaitem('cableGtSingleCopper'),    ore('plateSteel')],
		[ore('circuitMv'),                metaitem('hull.mv'),                ore('circuitMv')],
		[metaitem('cableGtSingleCopper'), ore('circuitMv'),                   metaitem('cableGtSingleCopper')]
])

crafting.addShaped("silicon_carbide_casing", item('susy:susy_multiblock_casing') * 2, [
		[metaitem('plateSiliconCarbide'), ore('craftingToolHardHammer'), metaitem('plateSiliconCarbide')],
		[metaitem('plateSiliconCarbide'), item('gregtech:metal_casing', 5), metaitem('plateSiliconCarbide')],
		[metaitem('plateSiliconCarbide'), ore('craftingToolWrench'), metaitem('plateSiliconCarbide')]
])

recipemap('assembler').recipeBuilder()
		.circuitMeta(6)
		.inputs(ore('plateSiliconCarbide') * 6)
		.inputs(item('gregtech:metal_casing', 5))
		.outputs(item('susy:susy_multiblock_casing') * 2)
		.EUt(16)
		.duration(50)
		.buildAndRegister()

//New Dynamo Hatches

recipemap('assembler').recipeBuilder()
		.inputs(metaitem('transformer.lv'))
		.inputs(metaitem('energy_hatch.output.lv'))
		.inputs(metaitem('voltage_coil.lv'))
		.inputs(ore('wireGtQuadrupleTin') * 2)
		.outputs(metaitem('energy_hatch.output_4a.lv'))
		.EUt(7)
		.duration(100)
		.buildAndRegister()

recipemap('assembler').recipeBuilder()
		.inputs(metaitem('transformer.adjustable.lv'))
		.inputs(metaitem('energy_hatch.output_4a.lv'))
		.inputs(metaitem('voltage_coil.lv'))
		.inputs(ore('wireGtOctalTin') * 2)
		.outputs(metaitem('energy_hatch.output_16a.lv'))
		.EUt(7)
		.duration(200)
		.buildAndRegister()

recipemap('assembler').recipeBuilder()
		.inputs(metaitem('transformer.mv'))
		.inputs(metaitem('energy_hatch.output.mv'))
		.inputs(metaitem('plate.ultra_low_power_integrated_circuit'))
		.inputs(metaitem('voltage_coil.mv'))
		.inputs(ore('wireGtQuadrupleCopper') * 2)
		.outputs(metaitem('energy_hatch.output_4a.mv'))
		.EUt(30)
		.duration(100)
		.buildAndRegister()

recipemap('assembler').recipeBuilder()
		.inputs(metaitem('transformer.adjustable.mv'))
		.inputs(metaitem('energy_hatch.output_4a.mv'))
		.inputs(metaitem('plate.ultra_low_power_integrated_circuit') * 2)
		.inputs(metaitem('voltage_coil.mv'))
		.inputs(ore('wireGtOctalCopper') * 2)
		.outputs(metaitem('energy_hatch.output_16a.mv'))
		.EUt(30)
		.duration(200)
		.buildAndRegister()

recipemap('assembler').recipeBuilder()
		.inputs(metaitem('transformer.hv'))
		.inputs(metaitem('energy_hatch.output.hv'))
		.inputs(metaitem('plate.low_power_integrated_circuit'))
		.inputs(metaitem('voltage_coil.hv'))
		.inputs(ore('wireGtQuadrupleGold') * 2)
		.outputs(metaitem('energy_hatch.output_4a.hv'))
		.EUt(120)
		.duration(100)
		.buildAndRegister()

recipemap('assembler').recipeBuilder()
		.inputs(metaitem('transformer.adjustable.hv'))
		.inputs(metaitem('energy_hatch.output_4a.hv'))
		.inputs(metaitem('plate.low_power_integrated_circuit') * 2)
		.inputs(metaitem('voltage_coil.hv'))
		.inputs(ore('wireGtOctalGold') * 2)
		.outputs(metaitem('energy_hatch.output_16a.hv'))
		.EUt(120)
		.duration(200)
		.buildAndRegister()

recipemap('assembler').recipeBuilder()
		.inputs(metaitem('transformer.adjustable.ev'))
		.inputs(metaitem('energy_hatch.output_4a.ev'))
		.inputs(metaitem('plate.power_integrated_circuit') * 2)
		.inputs(metaitem('voltage_coil.ev'))
		.inputs(ore('wireGtOctalAluminium') * 2)
		.outputs(metaitem('energy_hatch.output_16a.ev'))
		.EUt(480)
		.duration(200)
		.buildAndRegister()

crafting.addShaped("gregtech:ore_sorter", metaitem('ore_sorter'), [
		[robotArms[1], circuits[2], robotArms[1]],
		[pumps[1], hulls[1], pumps[1]],
		[robotArms[1], circuits[2], robotArms[1]]
]);

crafting.addShaped("gregtech:primitive_mud_pump", metaitem('primitive_mud_pump'), [
		[metaitem('ringBronze'), metaitem('pipeNormalFluidTreatedWood'), metaitem('screwBronze')],
		[metaitem('rotorBronze'), item('gregtech:steam_casing'), ore('craftingToolScrewdriver')],
		[item('minecraft:stone_slab', 4), metaitem('pipeLargeFluidWood'), item('minecraft:stone_slab', 4)]
]);

crafting.addShaped("gregtech:railroad_engineering_station", metaitem('railroad_engineering_station'), [
		[robotArms[1], null, robotArms[1]],
		[conveyors[1], hulls[1], conveyors[1]],
		[metaitem('plateSteel'), circuits[1], metaitem('plateSteel')]
]);

crafting.addShaped("gregtech:condenser", metaitem('condenser'), [
		[null, metaitem('electric.pump.lv'), null],
		[metaitem('frameSteel'), item('gregtech:boiler_casing', 1), metaitem('frameSteel')],
		[null, metaitem('electric.pump.lv'), null]
]);

crafting.addShaped("gregtech:condenser", metaitem('condenser'), [
		[null, metaitem('electric.pump.lv'), null],
		[metaitem('frameSteel'), item('gregtech:boiler_casing', 1), metaitem('frameSteel')],
		[null, metaitem('electric.pump.lv'), null]
]);

crafting.addShaped("gregtech:heat_exchanger", metaitem('heat_exchanger'), [
		[null, metaitem('frameSteel'), null],
		[metaitem('electric.pump.lv'), item('gregtech:boiler_casing', 1), metaitem('electric.pump.lv')],
		[null, metaitem('frameSteel'), null]
]);

crafting.addShaped("gregtech:mining_drill", metaitem('mining_drill'), [
		[circuits[1], motors[1], circuits[1]],
		[conveyors[1], hulls[1], conveyors[1]],
		[tieredCables[1], motors[1], tieredCables[1]]
]);

crafting.replaceShaped("gregtech:casing_grate_casing", item('gregtech:multiblock_casing', 2) * 2, [
		[item('minecraft:iron_bars'), metaitem('rotorSteel'), item('minecraft:iron_bars')],
		[item('minecraft:iron_bars'), metaitem('frameSteel'), item('minecraft:iron_bars')],
		[item('minecraft:iron_bars'), metaitem('electric.motor.lv'), item('minecraft:iron_bars')]
])

crafting.addShaped("gregtech:steel_drill_head", item('susy:drill_head'), [
		[pumps[1], conveyors[1], pumps[1]],
		[metaitem('component.grinder.diamond'), item('gregtech:metal_casing', 4), metaitem('component.grinder.diamond')],
		[null, metaitem('component.grinder.diamond'), null]
]);

crafting.addShaped("gregtech:heat_radiator", metaitem('heat_radiator'), [
		[metaitem('frameSteel'), metaitem('pipeLargeFluidSteel'), metaitem('frameSteel')],
		[metaitem('electric.pump.lv'), hulls[1], metaitem('electric.pump.lv')],
		[metaitem('frameSteel'), metaitem('pipeLargeFluidSteel'), metaitem('frameSteel')]
]);

crafting.addShaped("gregtech:large_weapons_factory", metaitem('large_weapons_factory'), [
		[sensors[1], robotArms[1], emitters[1]],
		[conveyors[1], hulls[1], conveyors[1]],
		[circuits[1], robotArms[1], circuits[1]]
]);

crafting.addShaped("gregtech:gravity_separator", metaitem('gravity_separator'), [
		[metaitem('component.grinder.diamond'), circuits[2], metaitem('component.grinder.diamond')],
		[conveyors[2], hulls[2], conveyors[2]],
		[circuits[2], tieredCables[2], circuits[2]]
]);

crafting.addShaped("gregtech:reaction_furnace", metaitem('reaction_furnace'), [
		[tieredQuadCables[2], tieredSprings[2], tieredQuadCables[2]],
		[circuits[2], hulls[2], circuits[2]],
		[tieredPlates[2], tieredPlates[2], tieredPlates[2]]
]);

crafting.addShaped("gregtech:advanced_arc_furnace", metaitem('advanced_arc_furnace'), [
		[metaitem('cableGtHexTin'), item('susy:electrode_assembly'), metaitem('cableGtHexTin')],
		[circuits[1], hulls[1], circuits[1]],
		[tieredPlates[1], tieredPlates[1], tieredPlates[1]]
]);

crafting.addShaped("gregtech:electrode_assembly", item('susy:electrode_assembly'), [
		[metaitem('plateSteel'), metaitem('cableGtSingleCopper'), metaitem('plateSteel')],
		[metaitem('graphite_electrode'), metaitem('frameSteel'), metaitem('graphite_electrode')],
		[metaitem('plateSteel'), metaitem('cableGtSingleCopper'), metaitem('plateSteel')]
]);

crafting.addShaped("gregtech:evaporation_pool", metaitem('evaporation_pool'), [
		[item('gregtech:stone_smooth', 4), metaitem('pipeHugeFluidAluminium'), item('gregtech:stone_smooth', 4)],
		[pumps[2], hulls[2], pumps[2]],
		[item('gregtech:stone_smooth', 4), metaitem('pipeHugeFluidAluminium'), item('gregtech:stone_smooth', 4)]
]);

crafting.addShaped("gregtech:evaporation_bed", item('susy:evaporation_bed') * 8, [
		[item('minecraft:sand'), item('minecraft:dirt'), item('minecraft:sand')],
		[item('minecraft:dirt'), item('minecraft:gravel'), item('minecraft:dirt')],
		[item('minecraft:sand'), item('minecraft:dirt'), item('minecraft:sand')]
		]);

crafting.addShaped("gregtech:clarifier", metaitem('clarifier'), [
		[tieredCables[2], metaitem('rotorSteel'), tieredCables[2]],
		[pumps[2], hulls[2], pumps[2]],
		[circuits[2], motors[2], circuits[2]]
]);

crafting.addShaped("gregtech:clarifier_vat", item('susy:multiblock_tank') * 9, [
		[null, null, null],
		[metaitem('plateSteel'), item('minecraft:cauldron'), metaitem('plateSteel')],
		[metaitem('pipeSmallFluidSteel'), metaitem('pipeSmallFluidSteel'), metaitem('pipeSmallFluidSteel')]
]);

crafting.addShaped("gregtech:multi_stage_flash_distillater", metaitem('multi_stage_flash_distiller'), [
		[metaitem('plateStainlessSteel'), tieredCables[3], metaitem('plateStainlessSteel')],
		[pumps[3], hulls[3], pumps[3]],
		[circuits[3], tieredSprings[3], circuits[3]]
]);

crafting.addShaped("gregtech:smoke_stack", metaitem('smoke_stack'), [
		[null, metaitem('rotorSteel'), null],
		[metaitem('pipeSmallFluidSteel'), hulls[1], metaitem('pipeSmallFluidSteel')],
		[null, metaitem('rotorSteel'), null],
]);

crafting.addShaped("gregtech:flare_stack", metaitem('flare_stack'), [
		[null, metaitem('rotorSteel'), null],
		[metaitem('stickSteel'), hulls[1], metaitem('stickSteel')],
		[null, metaitem('rotorSteel'), null],
]);

crafting.addShaped("gregtech:froth_flotation_tank", metaitem('froth_flotation_tank'), [
		[tieredCables[3], metaitem('rotorStainlessSteel'), tieredCables[3]],
		[pumps[3], hulls[3], pumps[3]],
		[circuits[3], motors[3], circuits[3]]
]);

crafting.addShaped("gregtech:froth_flotation_vat", item('susy:multiblock_tank', 1) * 4, [
		[null, null, null],
		[metaitem('plateStainlessSteel'), item('minecraft:cauldron'), metaitem('plateStainlessSteel')],
		[metaitem('pipeSmallFluidStainlessSteel'), metaitem('pipeSmallFluidStainlessSteel'), metaitem('pipeSmallFluidStainlessSteel')]
]);

crafting.addShaped("gregtech:vacuum_distillation_tower", metaitem('vacuum_distillation_tower'), [
		[metaitem('rotorSteel'), circuits[2], metaitem('rotorSteel')],
		[pumps[2], metaitem('hull.mv'), pumps[2]],
		[metaitem('pipeHugeFluidSteel'), circuits[2], metaitem('pipeHugeFluidSteel')]
])

crafting.replaceShaped("gregtech:vacuum_freezer", metaitem('vacuum_freezer'), [
		[pumps[3], pumps[3], pumps[3]],
		[circuits[3], item('gregtech:metal_casing', 3), circuits[3]],
		[metaitem('cableGtSingleGold'), circuits[3], metaitem('cableGtSingleGold')]
])

crafting.addShaped("gregtech:cooling_unit", metaitem('cooling_unit'), [
		[metaitem('rotorStainlessSteel'), metaitem('rotorStainlessSteel'), metaitem('rotorStainlessSteel')],
		[motors[3], metaitem('hull.hv'), motors[3]],
		[pumps[3], circuits[3], pumps[3]]
])

crafting.addShaped("gregtech:quencher", metaitem('quencher'), [
		[pumps[3], metaitem('robot.arm.hv'), pumps[3]],
		[circuits[3], item('gregtech:metal_casing', 5), circuits[3]],
		[metaitem('pipeLargeFluidStainlessSteel'), circuits[3], metaitem('pipeLargeFluidStainlessSteel')]
])

crafting.addShaped("gregtech:dumper", metaitem('dumper'), [
		[metaitem('plateSteel'), metaitem('plateSteel'), metaitem('plateSteel')],
		[metaitem('electric.pump.lv'), metaitem('hull.lv'), metaitem('pipeLargeFluidSteel')],
		[metaitem('plateSteel'), metaitem('plateSteel'), metaitem('plateSteel')]
])

crafting.addShaped("gregtech:ocean_pumper", metaitem('ocean_pumper'), [
		[metaitem('stickLongAluminium'), metaitem('electric.pump.mv'), metaitem('stickLongAluminium')],
		[ore('circuitMv'), metaitem('hull.mv'), ore('circuitMv')],
		[metaitem('cableGtSingleCopper'), metaitem('electric.pump.mv'), metaitem('cableGtSingleCopper')]
])

crafting.addShaped("gregtech:coking_tower", metaitem('coking_tower'), [
		[metaitem('pipeHugeFluidSteel'), pumps[3], metaitem('pipeHugeFluidSteel')],
		[circuits[3], hulls[3], circuits[3]],
		[metaitem('pipeHugeFluidSteel'), pumps[3], metaitem('pipeHugeFluidSteel')]
]);

crafting.addShaped("gregtech:rotary_kiln", metaitem('rotary_kiln'), [
		[circuits[2], null, tieredCables[2]],
		[metaitem('pipeHugeFluidSteel'), hulls[2], metaitem('pipeHugeFluidSteel')],
		[circuits[2], motors[2], tieredCables[2]]
]);

crafting.addShaped("gregtech:high_temperature_distillation_tower", metaitem('high_temperature_distillation_tower'), [
		[circuits[3], item('gregtech:wire_coil'), circuits[3]],
		[pumps[3], hulls[3], pumps[3]],
		[circuits[3], item('gregtech:wire_coil'), circuits[3]]
]);

//ION EXCHANGE COLUMN

for (i = 1; i <= 8; i++) {
	crafting.addShaped("gregtech:ion_exchange_column." + Globals.voltageTiers[i], metaitem('ion_exchange_column.'  + Globals.voltageTiers[i]), [
			[null, pumps[i], null],
			[tieredGlass[i], tieredPipes[i], tieredGlass[i]],
			[circuits[i], hulls[i], circuits[i]]
	])
}

// CVD

for (i = 1; i <= 8; i++) {
	crafting.addShaped("gregtech:cvd." + Globals.voltageTiers[i], metaitem('cvd.'  + Globals.voltageTiers[i]), [
			[pumps[i], tieredGlass[i], tieredGlass[i]],
			[hulls[i], tieredSprings[i], tieredPipes[i]],
			[circuits[i], tieredCables[i], tieredCables[i]]
	])
}

// Zone Refiner

for (i = 1; i <= 8; i++) {
	crafting.addShaped("gregtech:zone_refiner." + Globals.voltageTiers[i], metaitem('zone_refiner.'  + Globals.voltageTiers[i]), [
			[tieredSprings[i], tieredPipes[i], tieredSprings[i]],
			[tieredQuadCables[i], hulls[i], tieredQuadCables[i]],
			[circuits[i], conveyors[i], circuits[i]]
	])
}

// Tube Furnace

for (i = 1; i <= 8; i++) {
	crafting.addShaped("gregtech:tube_furnace." + Globals.voltageTiers[i], metaitem('tube_furnace.'  + Globals.voltageTiers[i]), [
			[circuits[i], tieredGlass[i], tieredGlass[i]],
			[hulls[i], tieredSprings[i], tieredPipes[i]],
			[tieredCables[i], conveyors[i], tieredCables[i]]
	])
}

// Bath Condenser

crafting.addShaped("gregtech:bath_condenser", metaitem('bath_condenser.lv'), [
	[metaitem('pipeSmallFluidStainlessSteel'), metaitem('pipeSmallFluidStainlessSteel'), metaitem('pipeSmallFluidStainlessSteel')],
	[metaitem('pipeSmallFluidStainlessSteel'), metaitem('hull.hv'), metaitem('pipeSmallFluidStainlessSteel')],
	[metaitem('pipeSmallFluidStainlessSteel'), metaitem('pipeSmallFluidStainlessSteel'), metaitem('pipeSmallFluidStainlessSteel')]
])

// Phase Separator

crafting.addShaped("gregtech:phase_separator", metaitem('phase_separator.lv'), [
	[metaitem('frameStainlessSteel'), metaitem('drum.stainless_steel'), metaitem('pipeSmallFluidStainlessSteel')],
	[metaitem('pipeSmallFluidStainlessSteel'), metaitem('hull.hv'), metaitem('pipeSmallFluidStainlessSteel')],
	[null, null, null]
])

//Multiblocked Machines

/*
crafting.addShaped("multiblocked:ore_sorter", item('multiblocked:ore_sorter'), [
		[robotArms[1], circuits[2], robotArms[1]],
		[pumps[1], hulls[1], pumps[1]],
		[robotArms[1], circuits[2], robotArms[1]]
]);

 */

// conversion recipes from greg ports
crafting.addShapeless("lv input bus -> mbd input bus", item('multiblocked:item_input'), [metaitem('item_bus.import.lv')]);
crafting.addShapeless("lv output bus -> mbd output bus", item('multiblocked:item_output'), [metaitem('item_bus.export.lv')]);
crafting.addShapeless("lv input hatch -> mbd input hatch", item('multiblocked:fluid_input'), [metaitem('fluid_hatch.import.lv')]);
crafting.addShapeless("lv output hatch -> mbd output hatch", item('multiblocked:fluid_output'), [metaitem('fluid_hatch.export.lv')]);

// conversion recipes to greg ports
crafting.addShapeless("mbd input bus -> lv input bus", metaitem('item_bus.import.lv'), [item('multiblocked:item_input')]);
crafting.addShapeless("mbd output bus -> lv output bus", metaitem('item_bus.export.lv'), [item('multiblocked:item_output')]);
crafting.addShapeless("mbd input hatch -> lv input hatch", metaitem('fluid_hatch.import.lv'), [item('multiblocked:fluid_input')]);
crafting.addShapeless("mbd output hatch -> lv output hatch", metaitem('fluid_hatch.export.lv'), [item('multiblocked:fluid_output')]);

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

recipemap('assembler').recipeBuilder()
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

recipemap('assembler').recipeBuilder()
		.inputs(metaitem('hull.ev'))
		.inputs(metaitem('frameTitanium') * 4)
		.inputs(metaitem('electric.pump.ev') * 2)
		.inputs(metaitem('pipeHugeFluidTitanium'))
		.inputs(metaitem('rotorTitanium'))
		.inputs(ore('circuitEv'))
		.outputs(metaitem('catalytic_reformer'))
		.circuitMeta(3)
		.EUt(480)
		.duration(600)
		.buildAndRegister()	

//Power Units
recipemap('assembler').recipeBuilder()
		.inputs(ore('gearSmallSteel') * 2)
		.inputs(ore('boltSteel') * 2)
		.inputs(metaitem('electric.motor.lv') * 2)
		.inputs(ore('batteryLv'))
		.outputs(metaitem('power_unit.lv'))
		.EUt(30)
		.duration(150)
		.buildAndRegister()

recipemap('assembler').recipeBuilder()
		.inputs(ore('gearSmallAluminium') * 2)
		.inputs(ore('boltAluminium') * 2)
		.inputs(metaitem('electric.motor.mv') * 2)
		.inputs(ore('batteryMv'))
		.outputs(metaitem('power_unit.mv'))
		.EUt(120)
		.duration(150)
		.buildAndRegister()

recipemap('assembler').recipeBuilder()
		.inputs(ore('gearSmallStainlessSteel') * 2)
		.inputs(ore('boltStainlessSteel') * 2)
		.inputs(metaitem('electric.motor.hv') * 2)
		.inputs(ore('batteryHv'))
		.outputs(metaitem('power_unit.hv'))
		.EUt(480)
		.duration(150)
		.buildAndRegister()

recipemap('assembler').recipeBuilder()
		.inputs(ore('gearSmallTitanium') * 2)
		.inputs(ore('boltTitanium') * 2)
		.inputs(metaitem('electric.motor.ev') * 2)
		.inputs(ore('batteryEv'))
		.outputs(metaitem('power_unit.ev'))
		.EUt(1920)
		.duration(150)
		.buildAndRegister()

recipemap('assembler').recipeBuilder()
		.inputs(ore('gearSmallTungstenSteel') * 2)
		.inputs(ore('boltTungstenSteel') * 2)
		.inputs(metaitem('electric.motor.iv') * 2)
		.inputs(ore('batteryIv'))
		.outputs(metaitem('power_unit.iv'))
		.EUt(7680)
		.duration(150)
		.buildAndRegister()

// AIR DIST. CONTROLLERS

recipemap('assembler').recipeBuilder()
		.circuitMeta(2)
		.inputs(metaitem('hull.Hv'))
		.inputs(metaitem('frameAluminium') * 3)
		.inputs(ore('circuitHv') * 4)
		.inputs(metaitem('electric.pump.hv') * 4)
		.inputs(ore('plateAluminium') * 4)
		.inputs(metaitem('mineral_wool') * 64)
		.outputs(metaitem('single_column_cryogenic_distillation_plant'))
		.EUt(30)
		.duration(600)
		.buildAndRegister()

recipemap('assembler').recipeBuilder()
		.circuitMeta(3)
		.inputs(metaitem('hull.Hv'))
		.inputs(metaitem('frameAluminium') * 3)
		.inputs(ore('circuitHv') * 2)
		.inputs(metaitem('electric.pump.hv') * 4)
		.inputs(ore('plateAluminium') * 4)
		.inputs(item('susy:serpentine') * 6)
		.inputs(metaitem('mineral_wool') * 64)
		.outputs(metaitem('low_pressure_cryogenic_distillation_plant'))
		.EUt(30)
		.duration(600)
		.buildAndRegister()

recipemap('assembler').recipeBuilder()
		.circuitMeta(4)
		.inputs(metaitem('hull.Hv'))
		.inputs(metaitem('frameAluminium') * 12)
		.inputs(ore('circuitHv') * 6)
		.inputs(metaitem('electric.pump.hv') * 8)
		.inputs(ore('plateAluminium') * 4)
		.inputs(metaitem('mineral_wool') * 64)
		.outputs(metaitem('high_pressure_cryogenic_distillation_plant'))
		.EUt(30)
		.duration(600)
		.buildAndRegister()

recipemap('assembler').recipeBuilder()
		.circuitMeta(3)
		.inputs(metaitem('hull.Hv'))
		.inputs(metaitem('frameStainlessSteel'))
		.inputs(ore('platePolytetrafluoroethylene') * 4)
		.inputs(ore('circuitHv') * 2)
		.inputs(metaitem('electric.motor.hv'))
		.inputs(metaitem('electric.pump.hv') * 4)
		.outputs(metaitem('blender'))
		.EUt(30)
		.duration(600)
		.buildAndRegister()