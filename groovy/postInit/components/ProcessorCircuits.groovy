import classes.*;
import globals.Globals
import gregtech.api.metatileentity.multiblock.CleanroomType

// Workstation * 1
mods.gregtech.circuit_assembler.removeByInput(120, [metaitem('circuit_board.plastic'), metaitem('circuit.assembly') * 2, metaitem('component.diode') * 4, metaitem('plate.random_access_memory') * 4, metaitem('wireFineElectrum') * 16, metaitem('boltBlueAlloy') * 16], [fluid('soldering_alloy') * 144])
// Workstation * 1
mods.gregtech.circuit_assembler.removeByInput(120, [metaitem('circuit_board.plastic'), metaitem('circuit.assembly') * 2, metaitem('component.diode') * 4, metaitem('plate.random_access_memory') * 4, metaitem('wireFineElectrum') * 16, metaitem('boltBlueAlloy') * 16], [fluid('tin') * 288])

Globals.solders.each { key, val ->
	recipemap('circuit_assembler').recipeBuilder()
		.inputs(metaitem('frameAluminium'))
		.inputs(metaitem('circuit.assembly') * 2)
		.inputs(ore('componentDiode') * 4)
		.inputs(metaitem('plate.random_access_memory') * 4)
		.inputs(metaitem('plate.nand_memory_chip') * 4)
		.inputs(ore('cableGtSingleElectrum') * 4)
		.fluidInputs(fluid(key) * val)
		.outputs(metaitem('circuit.workstation'))
		.cleanroom(CleanroomType.CLEANROOM)
		.duration(250)
		.EUt(120)
		.buildAndRegister();
}
