import classes.*;
import globals.Globals
import gregtech.api.metatileentity.multiblock.CleanroomType

def ASSEMBLER = recipemap('assembler')
def VACUUM = recipemap('vacuum_chamber')
def CIRCUIT_ASSEMBLER = recipemap('circuit_assembler')

mods.gregtech.circuit_assembler.removeByInput(16, [metaitem('circuit_board.basic'), metaitem('plate.integrated_logic_circuit'), metaitem('component.resistor') * 2, metaitem('component.diode') * 2, metaitem('wireFineCopper') * 2, metaitem('boltTin') * 2], [fluid('soldering_alloy') * 72])

// Microprocessor * 5
mods.gregtech.circuit_assembler.removeByInput(60, [metaitem('circuit_board.plastic'), metaitem('plate.central_processing_unit'), metaitem('component.resistor') * 2, metaitem('component.capacitor') * 2, metaitem('component.transistor') * 2, metaitem('wireFineCopper') * 2], [fluid('tin') * 144 * 144])
mods.gregtech.circuit_assembler.removeByInput(60, [metaitem('circuit_board.plastic'), metaitem('plate.central_processing_unit'), metaitem('component.resistor') * 2, metaitem('component.capacitor') * 2, metaitem('component.transistor') * 2, metaitem('wireFineCopper') * 2], [fluid('soldering_alloy') * 72 * 72])


// Integrated Processor * 2
mods.gregtech.circuit_assembler.removeByInput(60, [metaitem('circuit_board.plastic'), metaitem('plate.central_processing_unit'), metaitem('component.resistor') * 4, metaitem('component.capacitor') * 4, metaitem('component.transistor') * 4, metaitem('wireFineRedAlloy') * 4], [fluid('tin') * 144 * 144])
mods.gregtech.circuit_assembler.removeByInput(60, [metaitem('circuit_board.plastic'), metaitem('plate.central_processing_unit'), metaitem('component.resistor') * 4, metaitem('component.capacitor') * 4, metaitem('component.transistor') * 4, metaitem('wireFineRedAlloy') * 4], [fluid('soldering_alloy') * 72 * 72])

// Processor Assembly * 1
mods.gregtech.circuit_assembler.removeByInput(90, [metaitem('circuit_board.plastic'), metaitem('circuit.processor') * 2, metaitem('component.inductor') * 4, metaitem('component.capacitor') * 8, metaitem('plate.random_access_memory') * 4, metaitem('wireFineRedAlloy') * 8], [fluid('soldering_alloy') * 144 * 144])
mods.gregtech.circuit_assembler.removeByInput(90, [metaitem('circuit_board.plastic'), metaitem('circuit.processor') * 2, metaitem('component.inductor') * 4, metaitem('component.capacitor') * 8, metaitem('plate.random_access_memory') * 4, metaitem('wireFineRedAlloy') * 8], [fluid('tin') * 288 * 288])

// Mainframe * 1
mods.gregtech.circuit_assembler.removeByInput(480, [metaitem('frameAluminium') * 2, metaitem('circuit.workstation') * 2, metaitem('component.inductor') * 8, metaitem('component.capacitor') * 16, metaitem('plate.random_access_memory') * 16, metaitem('wireGtSingleAnnealedCopper') * 16], [fluid('soldering_alloy') * 288 * 288])
mods.gregtech.circuit_assembler.removeByInput(480, [metaitem('frameAluminium') * 2, metaitem('circuit.workstation') * 2, metaitem('component.inductor') * 8, metaitem('component.capacitor') * 16, metaitem('plate.random_access_memory') * 16, metaitem('wireGtSingleAnnealedCopper') * 16], [fluid('tin') * 576 * 576])
mods.gregtech.circuit_assembler.removeByInput(480, [metaitem('frameAluminium') * 2, metaitem('circuit.workstation') * 2, metaitem('component.advanced_smd.inductor') * 2, metaitem('component.advanced_smd.capacitor') * 4, metaitem('plate.random_access_memory') * 16, metaitem('wireGtSingleAnnealedCopper') * 16], [fluid('soldering_alloy') * 288 * 288])
mods.gregtech.circuit_assembler.removeByInput(480, [metaitem('frameAluminium') * 2, metaitem('circuit.workstation') * 2, metaitem('component.advanced_smd.inductor') * 2, metaitem('component.advanced_smd.capacitor') * 4, metaitem('plate.random_access_memory') * 16, metaitem('wireGtSingleAnnealedCopper') * 16], [fluid('tin') * 576 * 576])

// Workstation * 1
mods.gregtech.circuit_assembler.removeByInput(120, [metaitem('circuit_board.plastic'), metaitem('circuit.assembly') * 2, metaitem('component.diode') * 4, metaitem('plate.random_access_memory') * 4, metaitem('wireFineElectrum') * 16, metaitem('boltBlueAlloy') * 16], [fluid('soldering_alloy') * 144])
mods.gregtech.circuit_assembler.removeByInput(120, [metaitem('circuit_board.plastic'), metaitem('circuit.assembly') * 2, metaitem('component.diode') * 4, metaitem('plate.random_access_memory') * 4, metaitem('wireFineElectrum') * 16, metaitem('boltBlueAlloy') * 16], [fluid('tin') * 288])


Globals.solders.each { key, val ->
        CIRCUIT_ASSEMBLER.recipeBuilder()
                .inputs(metaitem('circuit_board.plastic'))
                .inputs(metaitem('plate.integrated_logic_circuit'))
                .inputs(metaitem('component.smd.resistor') * 2)
                .inputs(metaitem('component.smd.diode') * 2)
                .inputs(metaitem('wireFineCopper') * 2)
                .inputs(metaitem('boltTin') * 2)
		.fluidInputs(fluid(key) * val)
                .outputs(metaitem('circuit.microprocessor') * 5)
                .duration(200)
                .EUt(240)
                .buildAndRegister()

        CIRCUIT_ASSEMBLER.recipeBuilder()
                .inputs(metaitem('circuit_board.plastic'))
                .inputs(metaitem('plate.integrated_logic_circuit'))
                .inputs(metaitem('component.smd.resistor') * 4)
                .inputs(metaitem('component.smd.capacitor') * 4)
                .inputs(metaitem('component.smd.transistor') * 4)
                .inputs(metaitem('wireFineAnnealedCopper') * 4)
		.fluidInputs(fluid(key) * val)
                .outputs(metaitem('circuit.processor') * 2)
                .duration(200)
                .EUt(240)
                .buildAndRegister()

        CIRCUIT_ASSEMBLER.recipeBuilder()
                .inputs(metaitem('circuit.processor') * 2)
                .inputs(metaitem('plate.integrated_logic_circuit') * 2)
                .inputs(metaitem('plate.random_access_memory') * 2)
                .inputs(metaitem('component.smd.transistor') * 4)
                .inputs(metaitem('wireFineElectrum') * 8)
                .inputs(metaitem('boltAnnealedCopper') * 8)
		.fluidInputs(fluid(key) * (val * 2))
                .outputs(metaitem('circuit.assembly') * 1)
                .duration(300)
                .EUt(360)
                .buildAndRegister()

	CIRCUIT_ASSEMBLER.recipeBuilder()
		.inputs(metaitem('frameAluminium'))
		.inputs(metaitem('circuit.assembly') * 2)
		.inputs(ore('componentDiode') * 4)
		.inputs(metaitem('plate.random_access_memory') * 4)
		.inputs(metaitem('plate.central_processing_unit') * 4)
		.inputs(ore('cableGtSingleElectrum') * 4)
		.fluidInputs(fluid(key) * (val * 2))
		.outputs(metaitem('circuit.workstation'))
		.cleanroom(CleanroomType.CLEANROOM)
		.duration(400)
		.EUt(480)
		.buildAndRegister();

        CIRCUIT_ASSEMBLER.recipeBuilder()
                .inputs(metaitem('frameAluminium') * 2)
                .inputs(metaitem('circuit.workstation') * 2)
                .inputs(metaitem('component.smd.inductor') * 8)
                .inputs(metaitem('component.smd.capacitor') * 16)
                .inputs(metaitem('plate.nand_memory_chip') * 16)
                .inputs(metaitem('wireGtSingleAnnealedCopper') * 16)
                .fluidInputs(fluid(key) * (val * 4))
                .outputs(metaitem('circuit.mainframe'))
                .duration(500)
		.EUt(480)
		.buildAndRegister();

}
