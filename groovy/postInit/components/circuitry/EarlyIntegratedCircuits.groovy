import static prePostInit.Recipemaps.*
import classes.*
import static gregtech.api.GTValues.*
import gregtech.api.metatileentity.multiblock.CleanroomType

import globals.Globals
import globals.Lithography
import globals.Etching
import globals.Deposition
import globals.Packaging
import globals.Doping

mods.gregtech.circuit_assembler.removeByInput(16, [metaitem('circuit_board.basic'), metaitem('plate.integrated_logic_circuit'), metaitem('component.resistor') * 2, metaitem('component.diode') * 2, metaitem('wireFineCopper') * 2, metaitem('boltTin') * 2], [fluid('soldering_alloy') * 72])

// NAND Chip * 8
mods.gregtech.circuit_assembler.removeByInput(120, [metaitem('circuit_board.good'), metaitem('plate.simple_system_on_chip'), metaitem('boltRedAlloy') * 2, metaitem('wireFineTin') * 2], [fluid('soldering_alloy') * 72])
// NAND Chip * 8
mods.gregtech.circuit_assembler.removeByInput(120, [metaitem('circuit_board.good'), metaitem('plate.simple_system_on_chip'), metaitem('boltRedAlloy') * 2, metaitem('wireFineTin') * 2], [fluid('tin') * 144])
// NAND Chip * 12
mods.gregtech.circuit_assembler.removeByInput(120, [metaitem('circuit_board.plastic'), metaitem('plate.simple_system_on_chip'), metaitem('boltRedAlloy') * 2, metaitem('wireFineTin') * 2], [fluid('soldering_alloy') * 72])
// NAND Chip * 12
mods.gregtech.circuit_assembler.removeByInput(120, [metaitem('circuit_board.plastic'), metaitem('plate.simple_system_on_chip'), metaitem('boltRedAlloy') * 2, metaitem('wireFineTin') * 2], [fluid('tin') * 144])
// Microprocessor * 6
mods.gregtech.circuit_assembler.removeByInput(600, [metaitem('circuit_board.plastic'), metaitem('plate.system_on_chip'), metaitem('wireFineCopper') * 2, metaitem('boltTin') * 2], [fluid('soldering_alloy') * 72])
// Microprocessor * 6
mods.gregtech.circuit_assembler.removeByInput(600, [metaitem('circuit_board.plastic'), metaitem('plate.system_on_chip'), metaitem('wireFineCopper') * 2, metaitem('boltTin') * 2], [fluid('tin') * 144])

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

// Depletion load NMOS IC fabrication chain

// FEOL

// LOCOS transistor isolation
Deposition.generateChemicalVaporDepositionRecipe('wafer.silicon.p_doped', 'wafer.early_ic.step_one', 400, 'silicon_nitride', 1)
Lithography.generatePhotolithographyRecipes('wafer.early_ic.step_one', 'wafer.early_ic.step_two', 'novolacs_resist', 'mask.early_ic_set', true)
Etching.generateWetEtchingRecipes('wafer.early_ic.step_two', 'wafer.early_ic.step_three', 'silicon_nitride', 400, false, false)
Lithography.generateResistStrippingRecipes('wafer.early_ic.step_three', 'wafer.early_ic.step_four', 'HV', 1)
Doping.generateIonImplantationRecipes('wafer.early_ic.step_four', 'wafer.early_ic.step_five', 400, 'boron_trifluoride')
Deposition.generateSiliconDioxideGrowthRecipe('wafer.early_ic.step_four', 'wafer.early_ic.step_five', 400, true)
Etching.generateWetEtchingRecipes('wafer.early_ic.step_five', 'wafer.early_ic.step_six', 'silicon_nitride', 400, false, false)

// Dope depletion-load transistors
Lithography.generatePhotolithographyRecipes('wafer.early_ic.step_six', 'wafer.early_ic.step_seven', 'novolacs_resist', 'mask.early_ic_set', true)
Doping.generateIonImplantationRecipes('wafer.early_ic.step_seven', 'wafer.early_ic.step_eight', 100, 'phosphine')
Lithography.generateResistStrippingRecipes('wafer.early_ic.step_eight', 'wafer.early_ic.step_nine', 'HV', 1)

// Gate and gate oxide formation
Deposition.generateSiliconDioxideGrowthRecipe('wafer.early_ic.step_nine', 'wafer.early_ic.step_ten', 400, false)
Deposition.generateChemicalVaporDepositionRecipe('wafer.early_ic.step_ten', 'wafer.early_ic.step_eleven', 400, 'silicon')
Lithography.generatePhotolithographyRecipes('wafer.early_ic.step_eleven', 'wafer.early_ic.step_twelve', 'novolacs_resist', 'mask.early_ic_set', true)
Etching.generateWetEtchingRecipes('wafer.early_ic.step_twelve', 'wafer.early_ic.step_thirteen', 'silicon', 400, false, false)
Lithography.generateResistStrippingRecipes('wafer.early_ic.step_thirteen', 'wafer.early_ic.step_fourteen', 'HV', 1)

// Source/drain doping
Lithography.generatePhotolithographyRecipes('wafer.early_ic.step_fourteen', 'wafer.early_ic.step_fifteen', 'novolacs_resist', 'mask.early_ic_set', true)
Etching.generateWetEtchingRecipes('wafer.early_ic.step_fifteen', 'wafer.early_ic.step_sixteen', 'silicon_dioxide', 400, false, false)
Doping.generateIonImplantationRecipes('wafer.early_ic.step_sixteen', 'wafer.early_ic.step_seventeen', 400, 'phosphine')
Lithography.generateResistStrippingRecipes('wafer.early_ic.step_seventeen', 'wafer.early_ic.step_eighteen', 'HV', 1)
Doping.generateDriveInRecipe('wafer.early_ic.step_eighteen', 'wafer.early_ic.step_nineteen', 100)

// BEOL

Deposition.generateSputteringRecipes('wafer.early_ic.step_nineteen', 'wafer.early_ic.step_twenty', [ 'aluminium' : 396, 'silicon' : 4 ])
Lithography.generatePhotolithographyRecipes('wafer.early_ic.step_twenty', 'wafer.early_ic.step_twenty_one', 'novolacs_resist', 'mask.early_ic_set', true)
Etching.generateWetEtchingRecipes('wafer.early_ic.step_twenty_one', 'wafer.early_ic.step_twenty_two', 'aluminium', 400, false, false)
Lithography.generateResistStrippingRecipes('wafer.early_ic.step_twenty_two', 'wafer.early_ic.step_twenty_three', 'HV', 1)
Deposition.generateSinteringRecipe('wafer.early_ic.step_twenty_three', 'wafer.early_ic.step_twenty_four', 400, HV)

// Packaging

Packaging.generateDicingRecipe('wafer.early_ic.step_twenty_four', 'die.early_ic', 24, 400, HV)
Packaging.generateWireBondingRecipe('die.early_ic', 'plate.early_power_integrated_circuit', 'gold', 50, HV)

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('die.early_ic.bonded'))
    .inputs(metaitem('component.lead_frame')) // or leadframe material
    .fluidInputs(fluid('epoxy_molding_compound') * 288)
    .outputs(metaitem('plate.early_power_integrated_circuit'))
    .duration(50)
    .EUt(VA[HV])
    .buildAndRegister()

/*Globals.solders.each { key, val ->;
       CIRCUIT_ASSEMBLER.recipeBuilder()
                .inputs(metaitem('circuit_board.good'))
                .inputs(metaitem('plate.integrated_logic_circuit'))
                .inputs(ore('boltAnnealedCopper') * 2)
                .inputs(ore('wireFineTin') * 2)
                .fluidInputs(fluid(key) * val)
                .outputs(metaitem('circuit.nand_chip') * 16)
                .duration(10)
                .EUt(VA[LV])
                .buildAndRegister();

        CIRCUIT_ASSEMBLER.recipeBuilder()
                .inputs(metaitem('circuit_board.plastic'))
                .inputs(metaitem('plate.integrated_logic_circuit'))
                .inputs(ore('boltAnnealedCopper') * 2)
                .inputs(ore('wireFineTin') * 2)
                .fluidInputs(fluid(key) * val)
                .outputs(metaitem('circuit.nand_chip') * 24)
                .duration(10)
                .EUt(VA[LV])
                .buildAndRegister();

        CIRCUIT_ASSEMBLER.recipeBuilder()
                .inputs(metaitem('circuit_board.plastic'))
                .inputs(metaitem('plate.integrated_logic_circuit'))
                .inputs(metaitem('component.smd.resistor') * 2)
                .inputs(metaitem('component.smd.diode') * 2)
                .inputs(metaitem('wireFineCopper') * 2)
                .inputs(metaitem('boltTin') * 2)
                .fluidInputs(fluid(key) * val)
                .outputs(metaitem('circuit.microprocessor') * 6)
                .duration(200)
                .EUt(VA[MV])
                .buildAndRegister()

        CIRCUIT_ASSEMBLER.recipeBuilder()
                .inputs(metaitem('circuit_board.plastic'))
                .inputs(metaitem('plate.central_processing_unit'))
                .inputs(metaitem('component.smd.resistor') * 2)
                .inputs(metaitem('component.smd.capacitor') * 2)
                .inputs(metaitem('component.smd.transistor') * 2)
                .inputs(ore('wireFineCopper') * 2)
                .fluidInputs(fluid(key) * val)
                .outputs(metaitem('circuit.microprocessor') * 12)
                .duration(200)
                .EUt(VA[MV])
                .buildAndRegister();

        CIRCUIT_ASSEMBLER.recipeBuilder()
                .inputs(metaitem('circuit_board.plastic'))
                .inputs(metaitem('plate.system_on_chip'))
                .inputs(ore('wireFineCopper') * 2)
                .inputs(ore('boltTin') * 2)
                .fluidInputs(fluid(key) * val)
                .outputs(metaitem('circuit.microprocessor') * 18)
                .duration(50)
                .EUt(VA[EV])
                .buildAndRegister();

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
                .EUt(VA[MV])
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
                .EUt(VA[MV])
                .buildAndRegister()

        CIRCUIT_ASSEMBLER.recipeBuilder()
                .inputs(metaitem('frameAluminium'))
                .inputs(metaitem('circuit.assembly') * 2)
                .inputs(metaitem('component.smd.diode') * 4)
                .inputs(metaitem('plate.nand_memory_chip') * 4)
                .inputs(metaitem('plate.central_processing_unit') * 4)
                .inputs(ore('cableGtSingleElectrum') * 4)
                .fluidInputs(fluid(key) * (val * 2))
                .outputs(metaitem('circuit.workstation'))
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(400)
                .EUt(VA[MV])
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
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(500)
                .EUt(VA[HV])
                .buildAndRegister();

}
