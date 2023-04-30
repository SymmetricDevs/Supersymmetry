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
										ore('stickNeodymium'), ore('stickVanadiumGallium'), ore('stickVanadiumGallium'),
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
					 metaitem('stickNeodymiumMagnetic'), metaitem('stickNeodymiumMagnetic'), metaitem('stickSamariumMagnetic'),
					 metaitem('stickSamariumMagnetic'), metaitem('stickSamariumMagnetic')];

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
		.inputs(metaitem('dustCoke') * 4)
		.outputs(metaitem('pitch_binder') * 4)
		.EUt(30)
		.duration(200)
		.buildAndRegister()

recipemap('extruder').recipeBuilder()
		.notConsumable(metaitem('shape.extruder.rod'))
		.inputs(metaitem('pitch_binder') * 4)
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
			[robotArms[i], circuits[i], robotArms[i]],
			[conveyors[i], hulls[i], conveyors[i]],
			[robotArms[i], circuits[i], robotArms[i]]
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

//Multiblocked Machines

crafting.addShaped("multiblocked:ore_sorter", item('multiblocked:ore_sorter'), [
		[robotArms[1], circuits[2], robotArms[1]],
		[pumps[1], hulls[1], pumps[1]],
		[robotArms[1], circuits[2], robotArms[1]]
]);

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