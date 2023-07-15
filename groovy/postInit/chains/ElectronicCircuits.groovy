// Diode * 2
mods.gregtech.assembler.removeByInput(30, [metaitem('wireFineAnnealedCopper') * 4, metaitem('dustSmallGalliumArsenide')], [fluid('glass') * 144])
// Diode * 1
mods.gregtech.assembler.removeByInput(30, [metaitem('wireFineCopper') * 4, metaitem('dustSmallGalliumArsenide')], [fluid('glass') * 144])
// Diode * 4
mods.gregtech.assembler.removeByInput(30, [metaitem('wireFineAnnealedCopper') * 4, metaitem('wafer.silicon')], [fluid('plastic') * 144])
// Diode * 2
mods.gregtech.assembler.removeByInput(30, [metaitem('wireFineCopper') * 4, metaitem('wafer.silicon')], [fluid('plastic') * 144])
// Diode * 4
mods.gregtech.assembler.removeByInput(30, [metaitem('wireFineAnnealedCopper') * 4, metaitem('dustSmallGalliumArsenide')], [fluid('plastic') * 144])
// Diode * 2
mods.gregtech.assembler.removeByInput(30, [metaitem('wireFineCopper') * 4, metaitem('dustSmallGalliumArsenide')], [fluid('plastic') * 144])

//Remove steel plates from electronic circuits since they were unnecessary

crafting.replaceShaped("gregtech:electronic_circuit_lv", metaitem('circuit.electronic'), [
        [metaitem('component.resistor'), ore('craftingToolWireCutter'), metaitem('component.resistor')],
        [metaitem('circuit.vacuum_tube'), metaitem('circuit_board.basic'), metaitem('circuit.vacuum_tube')],
        [metaitem('cableGtSingleRedAlloy'), metaitem('cableGtSingleRedAlloy'), metaitem('cableGtSingleRedAlloy')]])

crafting.replaceShaped("gregtech:electronic_circuit_mv", metaitem('circuit.good_electronic'), [
        [metaitem('component.diode'), ore('craftingToolWireCutter'), metaitem('component.diode')],
        [metaitem('circuit.electronic'), metaitem('circuit_board.good'), metaitem('circuit.electronic')],
        [metaitem('wireGtSingleCopper'), metaitem('circuit.electronic'), metaitem('wireGtSingleCopper')]])

crafting.addShaped('resistor_wire_anthracite', metaitem('component.resistor') * 2, [
    [metaitem('rubber_drop'),item('minecraft:paper'),metaitem('rubber_drop')],
    [metaitem('wireFineCopper'),metaitem('dustAnthracite'), metaitem('wireGtSingleCopper')],
    [null,item('minecraft:paper'),null]])

crafting.addShaped('resistor_wire_fine_anthracite', metaitem('component.resistor') * 2, [
    [metaitem('rubber_drop'),item('minecraft:paper'),metaitem('rubber_drop')],
    [metaitem('wireGtSingleCopper'),metaitem('dustAnthracite'), metaitem('wireFineCopper')],
    [null,item('minecraft:paper'),null]])
	
crafting.addShaped('resistor_wire_coke', metaitem('component.resistor') * 2, [
    [metaitem('rubber_drop'),item('minecraft:paper'),metaitem('rubber_drop')],
    [metaitem('wireFineCopper'),metaitem('dustCoke'), metaitem('wireGtSingleCopper')],
    [null,item('minecraft:paper'),null]])

crafting.addShaped('resistor_wire_fine_coke', metaitem('component.resistor') * 2, [
    [metaitem('rubber_drop'),item('minecraft:paper'),metaitem('rubber_drop')],
    [metaitem('wireGtSingleCopper'),metaitem('dustCoke'), metaitem('wireFineCopper')],
    [null,item('minecraft:paper'),null]])

mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('glass') * 144)
        .inputs(metaitem('wireFineCopper') * 4)
        .inputs(metaitem('dustSmallGalena') * 1)
        .outputs(metaitem('component.diode'))
        .duration(400)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('glass') * 144)
        .inputs(metaitem('wireFineAnnealedCopper') * 4)
        .inputs(metaitem('dustSmallGalena') * 1)
        .outputs(metaitem('component.diode') * 2)
        .duration(400)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('glass') * 144)
        .inputs(metaitem('wireFineCopper') * 4)
        .inputs(metaitem('dustSmallGalliumArsenide') * 1)
        .outputs(metaitem('component.diode') * 3)
        .duration(400)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('glass') * 144)
        .inputs(metaitem('wireFineAnnealedCopper') * 4)
        .inputs(metaitem('dustSmallGalliumArsenide') * 1)
        .outputs(metaitem('component.diode') * 4)
        .duration(400)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('plastic') * 144)
        .inputs(metaitem('wireFineCopper') * 4)
        .inputs(metaitem('dustSmallGalliumArsenide') * 1)
        .outputs(metaitem('component.diode') * 6)
        .duration(400)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('plastic') * 144)
        .inputs(metaitem('wireFineAnnealedCopper') * 4)
        .inputs(metaitem('dustSmallGalliumArsenide') * 1)
        .outputs(metaitem('component.diode') * 8)
        .duration(400)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('plastic') * 144)
        .inputs(metaitem('wireFineCopper') * 4)
        .inputs(metaitem('wafer.silicon') * 1)
        .outputs(metaitem('component.diode') * 12)
        .duration(400)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('plastic') * 144)
        .inputs(metaitem('wireFineAnnealedCopper') * 4)
        .inputs(metaitem('wafer.silicon') * 1)
        .outputs(metaitem('component.diode') * 16)
        .duration(400)
        .EUt(30)
        .buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('glue') * 100)
        .inputs(metaitem('wireFineAnnealedCopper') * 4)
        .inputs(metaitem('dustAnthracite') * 1)
        .outputs(metaitem('component.resistor') * 4)
        .duration(160)
        .EUt(6)
        .buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('glue') * 100)
        .inputs(metaitem('wireFineAnnealedCopper') * 4)
        .inputs(metaitem('dustCoke') * 1)
        .outputs(metaitem('component.resistor') * 4)
        .duration(160)
        .EUt(6)
        .buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('glue') * 100)
        .inputs(metaitem('dustAnthracite') * 1)
        .inputs(metaitem('wireFineCopper') * 4)
        .outputs(metaitem('component.resistor') * 2)
        .duration(160)
        .EUt(6)
        .buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('glue') * 100)
        .inputs(metaitem('dustCoke') * 1)
        .inputs(metaitem('wireFineCopper') * 4)
        .outputs(metaitem('component.resistor') * 2)
        .duration(160)
        .EUt(6)
        .buildAndRegister();