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

def generateNMOSFabrication(String componentName, int circ) {

    // FEOL

    // LOCOS transistor isolation
    Deposition.generateChemicalVaporDepositionRecipe('wafer.silicon.p_doped', 'wafer.' + componentName + '.step_one', 400, 'silicon_nitride', 1)
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_one', 'wafer.' + componentName + '.step_two', 'novolacs_resist', 'mask.' + componentName + '_set', true)
    Etching.generateWetEtchingRecipes('wafer.' + componentName + '.step_two', 'wafer.' + componentName + '.step_three', 'silicon_nitride', 400, false, false)
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_three', 'wafer.' + componentName + '.step_four', 'HV', 1)
    Doping.generateIonImplantationRecipes('wafer.' + componentName + '.step_four', 'wafer.' + componentName + '.step_five', 400, 'boron_trifluoride')
    Deposition.generateSiliconDioxideGrowthRecipe('wafer.' + componentName + '.step_four', 'wafer.' + componentName + '.step_five', 400, true)
    Etching.generateWetEtchingRecipes('wafer.' + componentName + '.step_five', 'wafer.' + componentName + '.step_six', 'silicon_nitride', 400, false, false)

    // Dope depletion-load transistors
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_six', 'wafer.' + componentName + '.step_seven', 'novolacs_resist', 'mask.' + componentName + '_set', true)
    Doping.generateIonImplantationRecipes('wafer.' + componentName + '.step_seven', 'wafer.' + componentName + '.step_eight', 100, 'phosphine')
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_eight', 'wafer.' + componentName + '.step_nine', 'HV', 1)

    // Gate and gate oxide formation
    Deposition.generateSiliconDioxideGrowthRecipe('wafer.' + componentName + '.step_nine', 'wafer.' + componentName + '.step_ten', 400, false)
    Deposition.generateChemicalVaporDepositionRecipe('wafer.' + componentName + '.step_ten', 'wafer.' + componentName + '.step_eleven', 400, 'silicon')
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_eleven', 'wafer.' + componentName + '.step_twelve', 'novolacs_resist', 'mask.' + componentName + '_set', true)
    Etching.generateWetEtchingRecipes('wafer.' + componentName + '.step_twelve', 'wafer.' + componentName + '.step_thirteen', 'silicon', 400, false, false)
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_thirteen', 'wafer.' + componentName + '.step_fourteen', 'HV', 1)

    // Source/drain doping
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_fourteen', 'wafer.' + componentName + '.step_fifteen', 'novolacs_resist', 'mask.' + componentName + '_set', true)
    Etching.generateWetEtchingRecipes('wafer.' + componentName + '.step_fifteen', 'wafer.' + componentName + '.step_sixteen', 'silicon_dioxide', 400, false, false)
    Doping.generateIonImplantationRecipes('wafer.' + componentName + '.step_sixteen', 'wafer.' + componentName + '.step_seventeen', 400, 'phosphine')
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_seventeen', 'wafer.' + componentName + '.step_eighteen', 'HV', 1)
    Doping.generateDriveInRecipe('wafer.' + componentName + '.step_eighteen', 'wafer.' + componentName + '.step_nineteen', 100)

    // BEOL

    Deposition.generateSputteringRecipes('wafer.' + componentName + '.step_nineteen', 'wafer.' + componentName + '.step_twenty', [ 'aluminium' : 396, 'silicon' : 4 ])
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_twenty', 'wafer.' + componentName + '.step_twenty_one', 'novolacs_resist', 'mask.' + componentName + '_set', true)
    Etching.generateWetEtchingRecipes('wafer.' + componentName + '.step_twenty_one', 'wafer.' + componentName + '.step_twenty_two', 'aluminium', 400, false, false)
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_twenty_two', 'wafer.' + componentName + '.step_twenty_three', 'HV', 1)
    Deposition.generateSinteringRecipe('wafer.' + componentName + '.step_twenty_three', 'wafer.' + componentName + '.step_twenty_four', 400, HV)

    // Packaging

    Packaging.generateDicingRecipe('wafer.' + componentName + '.step_twenty_four', 'die.' + componentName, 24, 400, HV)
    Packaging.generateWireBondingRecipe('die.' + componentName, 'die.' + componentName + '.bonded', 'gold', 50, HV)

    ASSEMBLER.recipeBuilder()
        .inputs(metaitem('die.' + componentName + '.bonded'))
        .inputs(metaitem('component.lead_frame')) // or leadframe material
        .fluidInputs(fluid('epoxy_molding_compound') * 288)
        .outputs(metaitem('component.' + componentName))
        .duration(50)
        .EUt(VA[HV])
        .buildAndRegister()

}

generateNMOSFabrication('nmos_cpu', 1)
generateNMOSFabrication('nmos_sram', 2)
generateNMOSFabrication('nmos_uart', 3)
generateNMOSFabrication('nmos_mask_rom', 4)

// NMOS planar DRAM, no depletion load

// FEOL

// LOCOS transistor isolation
Deposition.generateChemicalVaporDepositionRecipe('wafer.silicon.p_doped', 'wafer.nmos_dram.step_one', 400, 'silicon_nitride', 5)
Lithography.generatePhotolithographyRecipes('wafer.nmos_dram.step_one', 'wafer.nmos_dram.step_two', 'novolacs_resist', 'mask.nmos_dram_set', true)
Etching.generateWetEtchingRecipes('wafer.nmos_dram.step_two', 'wafer.nmos_dram.step_three', 'silicon_nitride', 400, false, false)
Lithography.generateResistStrippingRecipes('wafer.nmos_dram.step_three', 'wafer.nmos_dram.step_four', 'HV', 1)
Doping.generateIonImplantationRecipes('wafer.nmos_dram.step_four', 'wafer.nmos_dram.step_five', 400, 'boron_trifluoride')
Deposition.generateSiliconDioxideGrowthRecipe('wafer.nmos_dram.step_five', 'wafer.nmos_dram.step_six', 400, true)
Etching.generateWetEtchingRecipes('wafer.nmos_dram.step_six', 'wafer.nmos_dram.step_seven', 'silicon_nitride', 400, false, false)

// Gate and gate oxide formation
Deposition.generateSiliconDioxideGrowthRecipe('wafer.nmos_dram.step_seven', 'wafer.nmos_dram.step_eight', 400, false)
Deposition.generateChemicalVaporDepositionRecipe('wafer.nmos_dram.step_eight', 'wafer.nmos_dram.step_nine', 400, 'silicon')
Lithography.generatePhotolithographyRecipes('wafer.nmos_dram.step_nine', 'wafer.nmos_dram.step_ten', 'novolacs_resist', 'mask.nmos_dram_set', true)
Etching.generateWetEtchingRecipes('wafer.nmos_dram.step_ten', 'wafer.nmos_dram.step_eleven', 'silicon', 400, false, false)
Lithography.generateResistStrippingRecipes('wafer.nmos_dram.step_eleven', 'wafer.nmos_dram.step_twelve', 'HV', 1)

// Source/drain doping
Lithography.generatePhotolithographyRecipes('wafer.nmos_dram.step_twelve', 'wafer.nmos_dram.step_thirteen', 'novolacs_resist', 'mask.nmos_dram_set', true)
Etching.generateWetEtchingRecipes('wafer.nmos_dram.step_thirteen', 'wafer.nmos_dram.step_fourteen', 'silicon_dioxide', 400, false, false)
Doping.generateIonImplantationRecipes('wafer.nmos_dram.step_fourteen', 'wafer.nmos_dram.step_fifteen', 400, 'phosphine')
Lithography.generateResistStrippingRecipes('wafer.nmos_dram.step_fifteen', 'wafer.nmos_dram.step_sixteen', 'HV', 1)
Doping.generateDriveInRecipe('wafer.nmos_dram.step_sixteen', 'wafer.nmos_dram.step_seventeen', 100)

// BEOL

Deposition.generateSputteringRecipes('wafer.nmos_dram.step_seventeen', 'wafer.nmos_dram.step_eighteen', [ 'aluminium' : 396, 'silicon' : 4 ])
Lithography.generatePhotolithographyRecipes('wafer.nmos_dram.step_eighteen', 'wafer.nmos_dram.step_nineteen', 'novolacs_resist', 'mask.nmos_dram_set', true)
Etching.generateWetEtchingRecipes('wafer.nmos_dram.step_nineteen', 'wafer.nmos_dram.step_twenty', 'aluminium', 400, false, false)
Lithography.generateResistStrippingRecipes('wafer.nmos_dram.step_twenty', 'wafer.nmos_dram.step_twenty_one', 'HV', 1)
Deposition.generateSinteringRecipe('wafer.nmos_dram.step_twenty_one', 'wafer.nmos_dram.step_twenty_two', 400, HV)

// Packaging

Packaging.generateDicingRecipe('wafer.nmos_dram.step_twenty_two', 'die.nmos_dram', 24, 400, HV)
Packaging.generateWireBondingRecipe('die.nmos_dram', 'die.nmos_dram.bonded', 'gold', 50, HV)

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('die.nmos_dram.bonded'))
    .inputs(metaitem('component.lead_frame')) // or leadframe material
    .fluidInputs(fluid('epoxy_molding_compound') * 288)
    .outputs(metaitem('component.nmos_dram'))
    .duration(50)
    .EUt(VA[HV])
    .buildAndRegister()

// Clock generator

CIRCUIT_ASSEMBLER.recipeBuilder()
    .inputs(metaitem('circuit_board.plastic'))
    .inputs(metaitem('component.crystal_oscillator'))
    .inputs(ore('componentCapacitorMedium') * 2)
    .inputs(ore('componentResistorMedium') * 2)
    .inputs(ore('componentTransistor') * 2)
    .fluidInputs(fluid('soldering_alloy') * 72)
    .outputs(metaitem('component.clock_generator'))
    .duration(20)
    .EUt(VA[LV])
    .buildAndRegister()

// Magnetic storage

ROASTER.recipeBuilder()
    .inputs(ore('dustPurifiedIronTwoThreeOxide') * 14)
    .fluidInputs(fluid('oxygen') * 1000)
    .outputs(metaitem('dustGammaIronThreeOxide') * 15)
    .duration(200)
    .EUt(VA[LV])
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustGammaIronThreeOxide') * 5)
    .inputs(ore('dustCarbon'))
    .fluidInputs(fluid('polyester_melt') * 2100)
    .fluidInputs(fluid('methyl_ethyl_ketone') * 1900)
    .fluidOutputs(fluid('magnetic_lining_slurry') * 4000)
    .duration(200)
    .EUt(VA[LV])
    .buildAndRegister()

    // Floppy disks

    ASSEMBLER.recipeBuilder()
        .inputs(ore('foilMylar'))
        .inputs(ore('platePolyvinylChloride') * 2)
        .inputs(ore('foilSteel'))
        .fluidInputs(fluid('magnetic_lining_slurry') * 100)
        .outputs(metaitem('component.floppy_disk'))
        .duration(200)
        .EUt(VA[MV])
        .buildAndRegister()

    // Floppy disk drive

    CIRCUIT_ASSEMBLER.recipeBuilder()
        .inputs(ore('circuit_board.plastic'))
        .inputs(metaitem('electric.motor.lv') * 2)
        .inputs(ore('boltNickelZincFerrite'))
        .inputs(ore('wireFineCopper') * 4)
        .inputs(metaitem('component.op_amp') * 2)
        .inputs(metaitem('component.solenoid')


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
