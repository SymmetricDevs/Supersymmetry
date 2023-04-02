/*
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

def regulators = [null, metaitem('fluid.regulator.lv'), metaitem('fluid.regulator.mv'), metaitem('fluid.regulator.hv'),
		 metaitem('fluid.regulator.ev'), metaitem('fluid.regulator.iv'), metaitem('fluid.regulator.luv'),
		 metaitem('fluid.regulator.zpm'), metaitem('fluid.regulator.uv'), metaitem('fluid.regulator.uhv'),
		 metaitem('fluid.regulator.uev'), metaitem('fluid.regulator.uiv'), metaitem('fluid.regulator.uxv'),
		 metaitem('fluid.regulator.opv')];

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


for (def i = 1; i < 10; i++) {
	crafting.addShaped("weapons_factory_" + i, item('gregtech:machine:' + (31999 + i)), [
			[robotArms[i], circuits[i], robotArms[i]],
			[conveyors[i], hulls[i], conveyors[i]],
			[robotArms[i], circuits[i], robotArms[i]]
	]);

	crafting.addShaped("fluid_decompressor_" + i, item('gregtech:machine:' + (32019 + i)), [
			[tieredGlass[i], pistons[i], tieredGlass[i]],
			[regulators[i], hulls[i], pumps[i]],
			[circuits[i], tieredWires[i], circuits[i]]
	]);

	crafting.addShaped("fluid_compressor_" + i, item('gregtech:machine:' + (32039 + i)), [
			[tieredGlass[i], pistons[i], tieredGlass[i]],
			[pumps[i], hulls[i], pumps[i]],
			[circuits[i], tieredWires[i], circuits[i]]
	]);
}

// conversion recipes from greg ports
crafting.addShapeless("lv input bus -> mbd input bus", item('multiblocked:item_input'), [item('gregtech:machine:1151')]);
crafting.addShapeless("lv output bus -> mbd output bus", item('multiblocked:item_output'), [item('gregtech:machine:1166')]);
crafting.addShapeless("lv input hatch -> mbd input hatch", item('multiblocked:fluid_input'), [item('gregtech:machine:1181')]);
crafting.addShapeless("lv output hatch -> mbd output hatch", item('multiblocked:fluid_output'), [item('gregtech:machine:1196')]);

// conversion recipes to greg ports
crafting.addShapeless("mbd input bus -> lv input bus", item('gregtech:machine:1151'), [item('multiblocked:item_input')]);
crafting.addShapeless("mbd output bus -> lv output bus", item('gregtech:machine:1166'), [item('multiblocked:item_output')]);
crafting.addShapeless("mbd input hatch -> lv input hatch", item('gregtech:machine:1181'), [item('multiblocked:fluid_input')]);
crafting.addShapeless("mbd output hatch -> lv output hatch", item('gregtech:machine:1196'), [item('multiblocked:fluid_output')]);

//multiblocked controllers

crafting.addShaped("multiblocked_ore_sorter", item('multiblocked:ore_sorter'), [
		[robotArms[1], circuits[2], robotArms[1]],
		[pumps[1], hulls[1], pumps[1]],
		[robotArms[1], circuits[2], robotArms[1]]
]);
*/
