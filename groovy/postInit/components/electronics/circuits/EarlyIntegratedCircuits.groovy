import static prePostInit.Recipemaps.*
import classes.*
import static gregtech.api.GTValues.*
import gregtech.api.metatileentity.multiblock.CleanroomType

import globals.Globals
import globals.semiconductors.Lithography
import globals.semiconductors.Etching
import globals.semiconductors.Deposition
import globals.semiconductors.Packaging
import globals.semiconductors.Doping

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
mods.gregtech.circuit_assembler.removeByInput(60, [metaitem('circuit_board.plastic'), metaitem('plate.central_processing_unit'), metaitem('component.resistor') * 2, metaitem('component.capacitor') * 2, metaitem('component.transistor') * 2, metaitem('wireFineCopper') * 2], [fluid('tin') * 144])
mods.gregtech.circuit_assembler.removeByInput(60, [metaitem('circuit_board.plastic'), metaitem('plate.central_processing_unit'), metaitem('component.resistor') * 2, metaitem('component.capacitor') * 2, metaitem('component.transistor') * 2, metaitem('wireFineCopper') * 2], [fluid('soldering_alloy') * 72])

// Integrated Processor * 2
mods.gregtech.circuit_assembler.removeByInput(60, [metaitem('circuit_board.plastic'), metaitem('plate.central_processing_unit'), metaitem('component.resistor') * 4, metaitem('component.capacitor') * 4, metaitem('component.transistor') * 4, metaitem('wireFineRedAlloy') * 4], [fluid('tin') * 144])
mods.gregtech.circuit_assembler.removeByInput(60, [metaitem('circuit_board.plastic'), metaitem('plate.central_processing_unit'), metaitem('component.resistor') * 4, metaitem('component.capacitor') * 4, metaitem('component.transistor') * 4, metaitem('wireFineRedAlloy') * 4], [fluid('soldering_alloy') * 72])

// Processor Assembly * 1
mods.gregtech.circuit_assembler.removeByInput(90, [metaitem('circuit_board.plastic'), metaitem('circuit.processor') * 2, metaitem('component.inductor') * 4, metaitem('component.capacitor') * 8, metaitem('plate.random_access_memory') * 4, metaitem('wireFineRedAlloy') * 8], [fluid('soldering_alloy') * 144])
mods.gregtech.circuit_assembler.removeByInput(90, [metaitem('circuit_board.plastic'), metaitem('circuit.processor') * 2, metaitem('component.inductor') * 4, metaitem('component.capacitor') * 8, metaitem('plate.random_access_memory') * 4, metaitem('wireFineRedAlloy') * 8], [fluid('tin') * 288])

// Mainframe * 1
mods.gregtech.circuit_assembler.removeByInput(480, [metaitem('frameAluminium') * 2, metaitem('circuit.workstation') * 2, metaitem('component.inductor') * 8, metaitem('component.capacitor') * 16, metaitem('plate.random_access_memory') * 16, metaitem('wireGtSingleAnnealedCopper') * 16], [fluid('soldering_alloy') * 288])
mods.gregtech.circuit_assembler.removeByInput(480, [metaitem('frameAluminium') * 2, metaitem('circuit.workstation') * 2, metaitem('component.inductor') * 8, metaitem('component.capacitor') * 16, metaitem('plate.random_access_memory') * 16, metaitem('wireGtSingleAnnealedCopper') * 16], [fluid('tin') * 576])
mods.gregtech.circuit_assembler.removeByInput(480, [metaitem('frameAluminium') * 2, metaitem('circuit.workstation') * 2, metaitem('component.advanced_smd.inductor') * 2, metaitem('component.advanced_smd.capacitor') * 4, metaitem('plate.random_access_memory') * 16, metaitem('wireGtSingleAnnealedCopper') * 16], [fluid('soldering_alloy') * 288])
mods.gregtech.circuit_assembler.removeByInput(480, [metaitem('frameAluminium') * 2, metaitem('circuit.workstation') * 2, metaitem('component.advanced_smd.inductor') * 2, metaitem('component.advanced_smd.capacitor') * 4, metaitem('plate.random_access_memory') * 16, metaitem('wireGtSingleAnnealedCopper') * 16], [fluid('tin') * 576])

// Workstation * 1
mods.gregtech.circuit_assembler.removeByInput(120, [metaitem('circuit_board.plastic'), metaitem('circuit.assembly') * 2, metaitem('component.diode') * 4, metaitem('plate.random_access_memory') * 4, metaitem('wireFineElectrum') * 16, metaitem('boltBlueAlloy') * 16], [fluid('soldering_alloy') * 144])
mods.gregtech.circuit_assembler.removeByInput(120, [metaitem('circuit_board.plastic'), metaitem('circuit.assembly') * 2, metaitem('component.diode') * 4, metaitem('plate.random_access_memory') * 4, metaitem('wireFineElectrum') * 16, metaitem('boltBlueAlloy') * 16], [fluid('tin') * 288])

// Leadframes

FORMING_PRESS.recipeBuilder()
    .notConsumable(metaitem('shape.mold.leadframe'))
    .inputs(ore('plateAnnealedCopper'))
    .outputs(metaitem('component.lead_frame') * 24)
    .duration(120)
    .EUt(VA[MV])
    .buildAndRegister()

// Depletion load NMOS IC fabrication chain
Deposition.generateChemicalVaporDepositionRecipe('wafer.silicon.p_doped', 'wafer.nmos.step_one', 2.0, "silicon_nitride.silane")
Lithography.generateCoatingRecipe('wafer.nmos.step_one', 'novolac_resist', true) // Coat with photoresist for LOCOS patterning

def generateNMOSFabrication(String componentName, int circ) {

    // FEOL

    // LOCOS transistor isolation
    Lithography.generateSplitPhotolithographyRecipes('wafer.nmos.step_one', 'wafer.' + componentName + '.step_one', 'wafer.' + componentName + '.step_two', 'novolac_resist', 'mask_set.' + componentName, true)
    Etching.generateWetEtchingRecipe('wafer.' + componentName + '.step_two', 'wafer.' + componentName + '.step_three', 'silicon_nitride', 400, false)
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_three', 'wafer.' + componentName + '.step_four', 1, false, true)
    Doping.generateIonImplantationRecipes('wafer.' + componentName + '.step_four', 'wafer.' + componentName + '.step_five', 400, 'boron_trifluoride')
    Deposition.generateSiliconDioxideGrowthRecipe('wafer.' + componentName + '.step_four', 'wafer.' + componentName + '.step_five', 400, true)
    Etching.generateWetEtchingRecipe('wafer.' + componentName + '.step_five', 'wafer.' + componentName + '.step_six', 'silicon_nitride', 400, false)

    // Dope depletion-load transistors
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_six', 'wafer.' + componentName + '.step_seven', 'novolac_resist', 'mask_set.' + componentName, true)
    Doping.generateIonImplantationRecipes('wafer.' + componentName + '.step_seven', 'wafer.' + componentName + '.step_eight', 100, 'phosphine')
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_eight', 'wafer.' + componentName + '.step_nine', 1, false, true)

    // Gate and gate oxide formation
    Deposition.generateSiliconDioxideGrowthRecipe('wafer.' + componentName + '.step_nine', 'wafer.' + componentName + '.step_ten', 400, false)
    Deposition.generateChemicalVaporDepositionRecipe('wafer.' + componentName + '.step_ten', 'wafer.' + componentName + '.step_eleven', 0.5, 'silicon')
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_eleven', 'wafer.' + componentName + '.step_twelve', 'novolac_resist', 'mask_set.' + componentName, true)
    Etching.generateWetEtchingRecipe('wafer.' + componentName + '.step_twelve', 'wafer.' + componentName + '.step_thirteen', 'silicon', 400, false)
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_thirteen', 'wafer.' + componentName + '.step_fourteen', 1, false, true)

    // Source/drain doping
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_fourteen', 'wafer.' + componentName + '.step_fifteen', 'novolac_resist', 'mask_set.' + componentName, true)
    Etching.generateWetEtchingRecipe('wafer.' + componentName + '.step_fifteen', 'wafer.' + componentName + '.step_sixteen', 'silicon_dioxide', 400, false)
    Doping.generateIonImplantationRecipes('wafer.' + componentName + '.step_sixteen', 'wafer.' + componentName + '.step_seventeen', 400, 'phosphine')
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_seventeen', 'wafer.' + componentName + '.step_eighteen', 1, false, true)
    Doping.generateDriveInRecipe('wafer.' + componentName + '.step_eighteen', 'wafer.' + componentName + '.step_nineteen', 100)

    // BEOL

    Deposition.generateSputteringRecipe('wafer.' + componentName + '.step_nineteen', 'wafer.' + componentName + '.step_twenty', [ 'aluminium' : 396, 'silicon' : 4 ])
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_twenty', 'wafer.' + componentName + '.step_twenty_one', 'novolac_resist', 'mask_set.' + componentName, false)
    Etching.generateWetEtchingRecipe('wafer.' + componentName + '.step_twenty_one', 'wafer.' + componentName + '.step_twenty_two', 'aluminium', 400, false)
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_twenty_two', 'wafer.' + componentName + '.step_twenty_three', 1, false, true)
    Deposition.generateSinteringRecipe('wafer.' + componentName + '.step_twenty_three', 'wafer.' + componentName + '.step_twenty_four', 400, HV)

    // Packaging

    Packaging.generateDicingRecipe('wafer.' + componentName + '.step_twenty_four', 'die.' + componentName, 24, 400, HV)
    Packaging.generateWireBondingRecipe('die.' + componentName, 'die.' + componentName + '.bonded', 'gold', 50, HV)

    ASSEMBLER.recipeBuilder()
        .inputs(metaitem('die.' + componentName + '.bonded'))
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
generateNMOSFabrication('nmos_bus_controller', 5)

// NMOS planar DRAM, no depletion load

// FEOL

// LOCOS transistor isolation
Lithography.generateSplitPhotolithographyRecipes('wafer.nmos.step_one', 'wafer.nmos_dram.step_one', 'wafer.nmos_dram.step_two', 'novolac_resist', 'mask_set.nmos_dram', true)
Etching.generateWetEtchingRecipe('wafer.nmos_dram.step_two', 'wafer.nmos_dram.step_three', 'silicon_nitride', 400, false)
Lithography.generateResistStrippingRecipes('wafer.nmos_dram.step_three', 'wafer.nmos_dram.step_four', 1, false, true)
Doping.generateIonImplantationRecipes('wafer.nmos_dram.step_four', 'wafer.nmos_dram.step_five', 400, 'boron_trifluoride')
Deposition.generateSiliconDioxideGrowthRecipe('wafer.nmos_dram.step_five', 'wafer.nmos_dram.step_six', 400, true)
Etching.generateWetEtchingRecipe('wafer.nmos_dram.step_six', 'wafer.nmos_dram.step_seven', 'silicon_nitride', 400, false)

// Gate and gate oxide formation
Deposition.generateSiliconDioxideGrowthRecipe('wafer.nmos_dram.step_seven', 'wafer.nmos_dram.step_eight', 400, false)
Deposition.generateChemicalVaporDepositionRecipe('wafer.nmos_dram.step_eight', 'wafer.nmos_dram.step_nine', 0.5, 'silicon')
Lithography.generatePhotolithographyRecipes('wafer.nmos_dram.step_nine', 'wafer.nmos_dram.step_ten', 'novolac_resist', 'mask_set.nmos_dram', true)
Etching.generateWetEtchingRecipe('wafer.nmos_dram.step_ten', 'wafer.nmos_dram.step_eleven', 'silicon', 400, false)
Lithography.generateResistStrippingRecipes('wafer.nmos_dram.step_eleven', 'wafer.nmos_dram.step_twelve', 1, false, true)

// Source/drain doping
Lithography.generatePhotolithographyRecipes('wafer.nmos_dram.step_twelve', 'wafer.nmos_dram.step_thirteen', 'novolac_resist', 'mask_set.nmos_dram', true)
Etching.generateWetEtchingRecipe('wafer.nmos_dram.step_thirteen', 'wafer.nmos_dram.step_fourteen', 'silicon_dioxide', 400, false)
Doping.generateIonImplantationRecipes('wafer.nmos_dram.step_fourteen', 'wafer.nmos_dram.step_fifteen', 400, 'phosphine')
Lithography.generateResistStrippingRecipes('wafer.nmos_dram.step_fifteen', 'wafer.nmos_dram.step_sixteen', 1, false, true)
Doping.generateDriveInRecipe('wafer.nmos_dram.step_sixteen', 'wafer.nmos_dram.step_seventeen', 100)

// BEOL

Deposition.generateSputteringRecipe('wafer.nmos_dram.step_seventeen', 'wafer.nmos_dram.step_eighteen', [ 'aluminium' : 396, 'silicon' : 4 ])
Lithography.generatePhotolithographyRecipes('wafer.nmos_dram.step_eighteen', 'wafer.nmos_dram.step_nineteen', 'novolac_resist', 'mask_set.nmos_dram', false)
Etching.generateWetEtchingRecipe('wafer.nmos_dram.step_nineteen', 'wafer.nmos_dram.step_twenty', 'aluminium', 400, false)
Lithography.generateResistStrippingRecipes('wafer.nmos_dram.step_twenty', 'wafer.nmos_dram.step_twenty_one', 1, false, true)
Deposition.generateSinteringRecipe('wafer.nmos_dram.step_twenty_one', 'wafer.nmos_dram.step_twenty_two', 400, HV)

// Packaging

Packaging.generateDicingRecipe('wafer.nmos_dram.step_twenty_two', 'die.nmos_dram', 24, 400, HV)
Packaging.generateWireBondingRecipe('die.nmos_dram', 'die.nmos_dram.bonded', 'gold', 50, HV)

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('die.nmos_dram.bonded'))
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

    // Floppy disks

    ROASTER.recipeBuilder()
        .inputs(ore('dustPurifiedIronIiiOxide') * 15)
        .outputs(metaitem('dustGammaIronThreeOxide') * 15)
        .duration(200)
        .EUt(VA[LV])
        .buildAndRegister()

    MIXER.recipeBuilder()
        .inputs(ore('dustGammaIronThreeOxide') * 5)
        .inputs(ore('dustCarbon'))
        .fluidInputs(fluid('polyester_melt') * 2100)
        .fluidInputs(fluid('butanone') * 1900)
        .fluidOutputs(fluid('magnetic_lining_slurry') * 4000)
        .duration(200)
        .EUt(VA[LV])
        .buildAndRegister()
        
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

    ASSEMBLER.recipeBuilder()
        .inputs(ore('boltNickelZincFerrite'))
        .inputs(ore('wireFineEnameledCopper') * 4)
        .inputs(metaitem('component.solenoid'))
        .inputs(ore('boltSteel'))
        .fluidInputs(fluid('epoxy') * 144)
        .outputs(metaitem('component.floppy_head'))
        .duration(200)
        .EUt(VA[LV])
        .buildAndRegister()

    // Floppy disk controller board

    CIRCUIT_ASSEMBLER.recipeBuilder()
        .inputs(metaitem('circuit_board.plastic'))
        .inputs(metaitem('component.nmos_cpu'))
        .inputs(ore('componentOpAmp') * 2)
        .inputs(ore('componentTransistor') * 4)
        .inputs(ore('componentResistorMedium') * 12)
        .inputs(ore('componentCapacitorMedium') * 8)
        .inputs(ore('componentDiodeSignal') * 4)
        .inputs(metaitem('component.crystal_oscillator'))
        .fluidInputs(fluid('soldering_alloy') * 288)
        .outputs(metaitem('component.floppy_controller'))
        .duration(300)
        .EUt(VA[MV])
        .buildAndRegister()

    // Final assembly

    ASSEMBLER.recipeBuilder()
        .inputs(metaitem('component.floppy_controller'))
        .inputs(metaitem('component.floppy_head'))
        .inputs(metaitem('component.floppy_disk'))
        .inputs(metaitem('electric.motor.lv') * 2)
        .inputs(ore('wireFineAnnealedCopper') * 4)
        .inputs(ore('plateAluminium') * 4)
        .fluidInputs(fluid('soldering_alloy') * 144)
        .outputs(metaitem('component.floppy_drive'))
        .duration(200)
        .EUt(VA[MV])
        .buildAndRegister()

// Circuit assembly

FORMING_PRESS.recipeBuilder()
    .notConsumable(metaitem('shape.mold.pin'))
    .inputs(ore('plateBrass'))
    .outputs(metaitem('pinBrass') * 64)
    .duration(60)
    .EUt(VA[MV])
    .buildAndRegister()

CIRCUIT_ASSEMBLER.recipeBuilder()
    .circuitMeta(1)
    .inputs(metaitem('circuit_board.plastic'))
    .inputs(metaitem('component.nmos_cpu'))
    .inputs(metaitem('component.nmos_dram'))
    .inputs(metaitem('component.nmos_uart'))
    .inputs(metaitem('component.nmos_mask_rom'))
    .inputs(metaitem('component.clock_generator'))
    .inputs(ore('componentResistorMedium') * 2)
    .inputs(ore('componentCapacitorMedium') * 2)
    .inputs(ore('pinBrass') * 12)
    .fluidInputs(fluid('soldering_alloy') * 144)
    .outputs(metaitem('circuit.microprocessor') * 8)
    .duration(200)
    .EUt(VA[MV])
    .buildAndRegister();

CIRCUIT_ASSEMBLER.recipeBuilder()
    .circuitMeta(2)
    .inputs(metaitem('circuit_board.plastic'))
    .inputs(metaitem('component.nmos_cpu') * 2)
    .inputs(metaitem('component.nmos_dram') * 2)
    .inputs(metaitem('component.nmos_sram') * 2)
    .inputs(metaitem('component.nmos_uart'))
    .inputs(metaitem('component.nmos_mask_rom'))
    .inputs(metaitem('component.clock_generator'))
    .inputs(ore('componentResistorMedium') * 2)
    .inputs(ore('componentCapacitorMedium') * 2)
    .inputs(ore('componentTransistorMedium') * 2)
    .inputs(ore('pinBrass') * 16)
    .fluidInputs(fluid('soldering_alloy') * 288)
    .outputs(metaitem('circuit.processor') * 2)
    .duration(200)
    .EUt(VA[MV])
    .buildAndRegister();

CIRCUIT_ASSEMBLER.recipeBuilder()
    .inputs(metaitem('circuit_board.plastic'))
    .inputs(metaitem('component.nmos_bus_controller'))
    .inputs(ore('componentResistorMedium') * 2)
    .inputs(ore('componentCapacitorMedium') * 2)
    .inputs(ore('pinBrass') * 16)
    .inputs(ore('plateAluminium'))
    .fluidInputs(fluid('soldering_alloy') * 288)
    .outputs(metaitem('component.nmos_expansion_bus'))
    .duration(200)
    .EUt(VA[MV])
    .buildAndRegister();

CIRCUIT_ASSEMBLER.recipeBuilder()
    .inputs(metaitem('circuit.processor') * 2)
    .inputs(metaitem('component.nmos_expansion_bus'))
    .inputs(metaitem('circuit.power.mv'))
    .inputs(ore('wireFineEnameledCopper') * 16)
    .fluidInputs(fluid('soldering_alloy') * 288)
    .outputs(metaitem('circuit.assembly'))
    .duration(200)
    .EUt(VA[MV])
    .buildAndRegister();

CIRCUIT_ASSEMBLER.recipeBuilder()
    .inputs(metaitem('circuit.processor') * 4)
    .inputs(metaitem('component.nmos_expansion_bus') * 3)
    .inputs(metaitem('circuit.power.hv'))
    .inputs(ore('frameGtAluminium'))
    .inputs(ore('wireFineEnameledCopper') * 48)
    .inputs(metaitem('component.floppy_drive'))
    .fluidInputs(fluid('soldering_alloy') * 512)
    .outputs(metaitem('circuit.workstation'))
    .duration(200)
    .EUt(VA[MV])
    .buildAndRegister();

CIRCUIT_ASSEMBLER.recipeBuilder()
    .inputs(metaitem('circuit.workstation') * 4)
    .inputs(metaitem('component.nmos_expansion_bus') * 3)
    .inputs(metaitem('circuit.power.ev'))
    .inputs(metaitem('component.floppy_drive'))
    .inputs(ore('frameGtAluminium') * 2)
    .inputs(ore('plateAluminium') * 12)
    .inputs(metaitem('component.heat_sink') * 4)
    .inputs(metaitem('electric.motor.hv') * 2)
    .inputs(ore('rotorAluminium') * 2)
    .inputs(ore('wireFineEnameledCopper') * 64)
    .fluidInputs(fluid('soldering_alloy') * 1024)
    .outputs(metaitem('circuit.mainframe'))
    .duration(200)
    .EUt(VA[HV])
    .buildAndRegister();

// Power Integrated Circuits

    // BJT PIC Fabrication

    // N+ collector formation
    Lithography.generatePhotolithographyRecipes('wafer.silicon.p_doped', 'wafer.bjt_pic_base.step_one', 'novolac_resist', 'mask_set.bjt_pic_base', true)
    Doping.generateIonImplantationRecipes('wafer.bjt_pic_base.step_one', 'wafer.bjt_pic_base.step_two', 400, 'purified_antimony_trioxide')
    Lithography.generateResistStrippingRecipes('wafer.bjt_pic_base.step_two', 'wafer.bjt_pic_base.step_three', 1, false, true)
    Doping.generateDriveInRecipe('wafer.bjt_pic_base.step_three', 'wafer.bjt_pic_base.step_four', 100)

    // N collector body epitaxy
    Deposition.generateChemicalVaporDepositionRecipe('wafer.bjt_pic_base.step_four', 'wafer.bjt_pic_base.step_five', 2.0, 'n_doped_silicon')

    // P+ isolation formation
    Lithography.generatePhotolithographyRecipes('wafer.bjt_pic_base.step_five', 'wafer.bjt_pic_base.step_six', 'novolac_resist', 'mask_set.bjt_pic_base', true)
    Doping.generateIonImplantationRecipes('wafer.bjt_pic_base.step_six', 'wafer.bjt_pic_base.step_seven', 400, 'boron_trifluoride')
    Lithography.generateResistStrippingRecipes('wafer.bjt_pic_base.step_seven', 'wafer.bjt_pic_base.step_eight', 1, false, true)
    Doping.generateDriveInRecipe('wafer.bjt_pic_base.step_eight', 'wafer.bjt_pic_base.step_nine', 100)

    // P+ base formation
    Lithography.generatePhotolithographyRecipes('wafer.bjt_pic_base.step_nine', 'wafer.bjt_pic_base.step_ten', 'novolac_resist', 'mask_set.bjt_pic_base', true)
    Doping.generateIonImplantationRecipes('wafer.bjt_pic_base.step_ten', 'wafer.bjt_pic_base.step_eleven', 400, 'boron_trifluoride')
    Lithography.generateResistStrippingRecipes('wafer.bjt_pic_base.step_eleven', 'wafer.bjt_pic_base.step_twelve', 1, false, true)
    Doping.generateDriveInRecipe('wafer.bjt_pic_base.step_twelve', 'wafer.bjt_pic_base.step_thirteen', 100)

    // N+ emitter + collector contact formation
    Lithography.generatePhotolithographyRecipes('wafer.bjt_pic_base.step_thirteen', 'wafer.bjt_pic_base.step_fourteen', 'novolac_resist', 'mask_set.bjt_pic_base', true)
    Doping.generateIonImplantationRecipes('wafer.bjt_pic_base.step_fourteen', 'wafer.bjt_pic_base.step_fifteen', 400, 'phosphine')
    Lithography.generateResistStrippingRecipes('wafer.bjt_pic_base.step_fifteen', 'wafer.bjt_pic_base.step_sixteen', 1, false, true)
    Doping.generateDriveInRecipe('wafer.bjt_pic_base.step_sixteen', 'wafer.bjt_pic_base.step_seventeen', 100)

    // ULPIC (MV) BEOL, NPN-BJT only, transistor-transistor-logic (TTL), control only

    // Sputter deposit aluminium and etch to form interconnects 
    Deposition.generateSputteringRecipe('wafer.bjt_pic_base.step_seventeen', 'wafer.bjt_ulpic.step_one', [ 'aluminium' : 396, 'silicon' : 4 ])
    Lithography.generatePhotolithographyRecipes('wafer.bjt_ulpic.step_one', 'wafer.bjt_ulpic.step_two', 'novolac_resist', 'mask_set.bjt_ulpic', false)
    Etching.generateWetEtchingRecipe('wafer.bjt_ulpic.step_two', 'wafer.bjt_ulpic.step_three', 'aluminium', 400, false)
    Lithography.generateResistStrippingRecipes('wafer.bjt_ulpic.step_three', 'wafer.bjt_ulpic.step_four', 1, false, true)
    Deposition.generateSinteringRecipe('wafer.bjt_ulpic.step_four', 'wafer.bjt_ulpic.step_five', 400, HV)

    // Packaging

    Packaging.generateDicingRecipe('wafer.bjt_ulpic.step_five', 'die.bjt_ulpic', 32, 400, HV)
    Packaging.generateWireBondingRecipe('die.bjt_ulpic', 'die.bjt_ulpic.bonded', 'gold', 50, HV)

    // LPIC (HV) FEOL, NPN/PNP BJT extension + polysi resistors for transistor-resistor logic (TRL), control only

    // Additional P doping for lateral PNP transistor body
    Lithography.generatePhotolithographyRecipes('wafer.bjt_pic_base.step_seventeen', 'wafer.bjt_lpic.step_one', 'novolac_resist', 'mask_set.bjt_lpic', true)
    Doping.generateIonImplantationRecipes('wafer.bjt_lpic.step_one', 'wafer.bjt_lpic.step_two', 400, 'boron_trifluoride')
    Lithography.generateResistStrippingRecipes('wafer.bjt_lpic.step_two', 'wafer.bjt_lpic.step_three', 1, false, true)

    // Polysilicon resistor formation (shared by LPIC and PIC)

    // Deposit polysilicon, dope it to adjust sheet resistance, then pattern. Drive-in is deferred so it can co-anneal with the PNP body implant.
    Deposition.generateChemicalVaporDepositionRecipe('wafer.bjt_lpic.step_three', 'wafer.bjt_lpic.step_four', 0.5, 'silicon')
    Doping.generateIonImplantationRecipes('wafer.bjt_lpic.step_four', 'wafer.bjt_lpic.step_five', 100, 'phosphine')
    Lithography.generatePhotolithographyRecipes('wafer.bjt_lpic.step_five', 'wafer.bjt_lpic.step_six', 'novolac_resist', 'mask_set.bjt_lpic', true)
    Etching.generateWetEtchingRecipe('wafer.bjt_lpic.step_six', 'wafer.bjt_lpic.step_seven', 'silicon', 400, false)
    Lithography.generateResistStrippingRecipes('wafer.bjt_lpic.step_seven', 'wafer.bjt_lpic.step_eight', 1, false, true)

    // Combined drive-in: activates both the lateral PNP P+ implant and the poly resistor phosphorus in one thermal step
    Doping.generateDriveInRecipe('wafer.bjt_lpic.step_eight', 'wafer.bjt_lpic.step_nine', 100)

    // LPIC (HV) BEOL

    // Deposit dielectric
    Deposition.generateChemicalVaporDepositionRecipe('wafer.bjt_lpic.step_nine', 'wafer.bjt_lpic.step_ten', 3.0, 'phosphosilicate_glass')
    Lithography.generatePhotolithographyRecipes('wafer.bjt_lpic.step_ten', 'wafer.bjt_lpic.step_eleven', 'novolac_resist', 'mask_set.bjt_lpic', true)
    Etching.generateWetEtchingRecipe('wafer.bjt_lpic.step_eleven', 'wafer.bjt_lpic.step_twelve', 'silicon_dioxide', 400, false)
    Lithography.generateResistStrippingRecipes('wafer.bjt_lpic.step_twelve', 'wafer.bjt_lpic.step_thirteen', 1, false, true)

    // Deposit diffusion barrier
    Deposition.generateChemicalVaporDepositionRecipe('wafer.bjt_lpic.step_thirteen', 'wafer.bjt_lpic.step_fourteen', 1.0, 'titanium_nitride')

    // Sputter deposit aluminium and etch to form interconnects
    Deposition.generateSputteringRecipe('wafer.bjt_lpic.step_fourteen', 'wafer.bjt_lpic.step_fifteen', [ 'aluminium' : 398, 'copper' : 2 ])
    Lithography.generatePhotolithographyRecipes('wafer.bjt_lpic.step_fifteen', 'wafer.bjt_lpic.step_sixteen', 'novolac_resist', 'mask_set.bjt_lpic', false)
    Etching.generateWetEtchingRecipe('wafer.bjt_lpic.step_sixteen', 'wafer.bjt_lpic.step_seventeen', 'aluminium', 400, false)
    Lithography.generateResistStrippingRecipes('wafer.bjt_lpic.step_seventeen', 'wafer.bjt_lpic.step_eighteen', 1, false, true)
    Deposition.generateSinteringRecipe('wafer.bjt_lpic.step_eighteen', 'wafer.bjt_lpic.step_nineteen', 400, HV)

    // Packaging
    Packaging.generateDicingRecipe('wafer.bjt_lpic.step_nineteen', 'die.bjt_lpic', 16, 400, HV)
    Packaging.generateWireBondingRecipe('die.bjt_lpic', 'die.bjt_lpic.bonded', 'gold', 50, HV)

    // PIC (EV) BEOL Extension (branches from LPIC after via etch, before metallization, to allow integrated Schottky formation)

    // Schottky barrier formation: blanket Pt sputter, sinter to form PtSi on exposed silicon, strip unreacted Pt with aqua regia
    Deposition.generateSputteringRecipe('wafer.bjt_lpic.step_thirteen', 'wafer.bjt_pic.step_one', 100, 'platinum')
    Deposition.generateSinteringRecipe('wafer.bjt_pic.step_one', 'wafer.bjt_pic.step_two', 200, HV)
    Etching.generateWetEtchingRecipe('wafer.bjt_pic.step_two', 'wafer.bjt_pic.step_three', 'platinum', 50, false)

    // Diffusion barrier
    Deposition.generateChemicalVaporDepositionRecipe('wafer.bjt_pic.step_three', 'wafer.bjt_pic.step_four', 1.0, 'titanium_nitride')

    // First metal layer (M1)
    Deposition.generateSputteringRecipe('wafer.bjt_pic.step_four', 'wafer.bjt_pic.step_five', [ 'aluminium' : 398, 'copper' : 2 ])
    Lithography.generatePhotolithographyRecipes('wafer.bjt_pic.step_five', 'wafer.bjt_pic.step_six', 'novolac_resist', 'mask_set.bjt_pic', false)
    Etching.generateWetEtchingRecipe('wafer.bjt_pic.step_six', 'wafer.bjt_pic.step_seven', 'aluminium', 400, false)
    Lithography.generateResistStrippingRecipes('wafer.bjt_pic.step_seven', 'wafer.bjt_pic.step_eight', 1, false, true)

    // Interlayer dielectric (ILD)
    Deposition.generateChemicalVaporDepositionRecipe('wafer.bjt_pic.step_eight', 'wafer.bjt_pic.step_nine', 3.0, 'phosphosilicate_glass')
    Lithography.generatePhotolithographyRecipes('wafer.bjt_pic.step_nine', 'wafer.bjt_pic.step_ten', 'novolac_resist', 'mask_set.bjt_pic', true)
    Etching.generateWetEtchingRecipe('wafer.bjt_pic.step_ten', 'wafer.bjt_pic.step_eleven', 'silicon_dioxide', 400, false)
    Lithography.generateResistStrippingRecipes('wafer.bjt_pic.step_eleven', 'wafer.bjt_pic.step_twelve', 1, false, true)

    // Second metal layer (M2) allows formation of capacitors and accomodates additional routing for the more complex PIC design
    Deposition.generateSputteringRecipe('wafer.bjt_pic.step_twelve', 'wafer.bjt_pic.step_thirteen', [ 'aluminium' : 398, 'copper' : 2 ])
    Lithography.generatePhotolithographyRecipes('wafer.bjt_pic.step_thirteen', 'wafer.bjt_pic.step_fourteen', 'novolac_resist', 'mask_set.bjt_pic', false)
    Etching.generateWetEtchingRecipe('wafer.bjt_pic.step_fourteen', 'wafer.bjt_pic.step_fifteen', 'aluminium', 400, false)
    Lithography.generateResistStrippingRecipes('wafer.bjt_pic.step_fifteen', 'wafer.bjt_pic.step_sixteen', 1, false, true)
    Deposition.generateSinteringRecipe('wafer.bjt_pic.step_sixteen', 'wafer.bjt_pic.step_seventeen', 400, HV)

    // Packaging
    Packaging.generateDicingRecipe('wafer.bjt_pic.step_seventeen', 'die.bjt_pic', 4, 400, HV)
    Packaging.generateWireBondingRecipe('die.bjt_pic', 'die.bjt_pic.bonded', 'gold', 50, HV)

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('die.bjt_ulpic.bonded'))
    .fluidInputs(fluid('epoxy_molding_compound') * 288)
    .outputs(metaitem('component.bjt_ulpic'))
    .duration(50)
    .EUt(VA[HV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('die.bjt_lpic.bonded'))
    .fluidInputs(fluid('epoxy_molding_compound') * 288)
    .outputs(metaitem('component.bjt_lpic'))
    .duration(50)
    .EUt(VA[HV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('die.bjt_pic.bonded'))
    .fluidInputs(fluid('epoxy_molding_compound') * 288)
    .outputs(metaitem('component.bjt_pic'))
    .duration(50)
    .EUt(VA[HV])
    .buildAndRegister()

CIRCUIT_ASSEMBLER.recipeBuilder()
    .inputs(metaitem('circuit_board.plastic'))
    .inputs(metaitem('component.bjt_ulpic'))
    .inputs(ore('componentResistorMedium') * 2)
    .inputs(ore('componentCapacitorMedium') * 2)
    .fluidInputs(fluid('soldering_alloy') * 72)
    .outputs(metaitem('circuit.power.mv'))
    .duration(200)
    .EUt(VA[MV])
    .buildAndRegister()

CIRCUIT_ASSEMBLER.recipeBuilder()
    .inputs(metaitem('circuit_board.plastic'))
    .inputs(metaitem('component.bjt_lpic'))
    .inputs(ore('componentResistorMedium'))
    .inputs(ore('componentCapacitorMedium') * 3)
    .inputs(ore('componentDiodeSignal'))
    .inputs(metaitem('component.fuse.hv'))
    .inputs(metaitem('component.heat_sink'))
    .fluidInputs(fluid('soldering_alloy') * 72)
    .outputs(metaitem('circuit.power.hv'))
    .duration(200)
    .EUt(VA[LV])
    .buildAndRegister()

CIRCUIT_ASSEMBLER.recipeBuilder()
    .inputs(metaitem('circuit_board.plastic'))
    .inputs(metaitem('component.bjt_pic'))
    .inputs(ore('componentInductor'))
    .inputs(ore('componentCapacitorMedium') * 4)
    .inputs(ore('componentDiodeSignal'))
    .inputs(metaitem('component.diode.power'))
    .inputs(metaitem('component.heat_sink'))
    .fluidInputs(fluid('soldering_alloy') * 288)
    .outputs(metaitem('circuit.power.ev'))
    .duration(200)
    .EUt(VA[LV])
    .buildAndRegister()
