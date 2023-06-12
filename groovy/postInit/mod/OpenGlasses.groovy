def soldering_alloys = [
        liquid('tin') * 144,
        liquid('soldering_alloy') * 72
]

def name_removals = [
"openglasses:items/openglasses_card",
"openglasses:blocks/openglasses_terminal",
"openglasses:items/openglasses"
]

for (item in name_removals) {
    crafting.remove(item);
}



for (solder in soldering_alloys) {

	mods.gregtech.circuit_assembler.recipeBuilder()
			.inputs(item('opencomputers:component', 10))
			.inputs(item('opencomputers:component', 3))
			.inputs(ore('wireFineAluminium') * 4)
			.inputs(metaitem('circuit_board.advanced'))
			.inputs(metaitem('sensor.ev'))
			.inputs(metaitem('emitter.ev'))
            .fluidInputs(solder)
            .outputs(item('openglasses:openglasses_card'))
            .duration(400)
            .EUt(480)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(item('opencomputers:component', 10))
			.inputs(metaitem('hull.ev'))
            .fluidInputs(solder)
			.circuitMeta([2])
            .outputs(item('openglasses:openglasses_terminal'))
            .duration(400)
            .EUt(480)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(item('opencomputers:component', 10))
			.inputs(item('opencomputers:component', 3))
			.inputs(item('opencomputers:screen3') * 2)
			.inputs(ore('wireFineAluminium') * 4)
			.inputs(ore('oc:wlanCard'))
			.inputs(item('opencomputers:card', 3))
			.inputs(metaitem('sensor.ev'))
			.inputs(metaitem('emitter.ev'))
            .fluidInputs(solder)
			.circuitMeta([2])
            .outputs(item('openglasses:openglasses'))
            .duration(400)
            .EUt(480)
            .buildAndRegister();

}

