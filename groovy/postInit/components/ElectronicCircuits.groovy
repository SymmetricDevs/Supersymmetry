import gregtech.api.recipes.ingredients.GTRecipeItemInput;

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
// Resistor * 2
mods.gregtech.assembler.removeByInput(6, [metaitem('dustCoal'), metaitem('wireFineCopper') * 4], [fluid('glue') * 100])
// Resistor * 2
mods.gregtech.assembler.removeByInput(6, [metaitem('dustCharcoal'), metaitem('wireFineCopper') * 4], [fluid('glue') * 100])
// Resistor * 2
mods.gregtech.assembler.removeByInput(6, [metaitem('dustCarbon'), metaitem('wireFineCopper') * 4], [fluid('glue') * 100])
// Resistor * 4
mods.gregtech.assembler.removeByInput(6, [metaitem('dustCoal'), metaitem('wireFineAnnealedCopper') * 4], [fluid('glue') * 100])
// Resistor * 4
mods.gregtech.assembler.removeByInput(6, [metaitem('dustCharcoal'), metaitem('wireFineAnnealedCopper') * 4], [fluid('glue') * 100])
// Resistor * 4
mods.gregtech.assembler.removeByInput(6, [metaitem('dustCarbon'), metaitem('wireFineAnnealedCopper') * 4], [fluid('glue') * 100])

//Remove steel plates from electronic circuits since they were unnecessary

crafting.replaceShaped("gregtech:electronic_circuit_lv", metaitem('circuit.electronic'), [
        [metaitem('component.resistor'), ore('craftingToolWireCutter'), metaitem('component.resistor')],
        [metaitem('circuit.vacuum_tube'), metaitem('circuit_board.basic'), metaitem('circuit.vacuum_tube')],
        [ore('cableGtSingleRedAlloy'), ore('cableGtSingleRedAlloy'), ore('cableGtSingleRedAlloy')]])

crafting.replaceShaped("gregtech:electronic_circuit_mv", metaitem('circuit.good_electronic'), [
        [metaitem('component.diode'), ore('craftingToolWireCutter'), metaitem('component.diode')],
        [metaitem('circuit.electronic'), metaitem('circuit_board.good'), metaitem('circuit.electronic')],
        [ore('wireGtSingleCopper'), metaitem('circuit.electronic'), ore('wireGtSingleCopper')]])

crafting.removeByOutput(metaitem('component.resistor')) 

carbons = new ItemStack[]{
        metaitem('dustCoal'),
        metaitem('dustCharcoal'),
        metaitem('dustCarbon'),
        metaitem('dustHighPurityCarbon'),
        metaitem('dustAnthracite'),
        metaitem('dustCoke')
}

mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('glue') * 100)
        .input(new GTRecipeItemInput(carbons, 1))
        .inputs(ore('wireFineCopper') * 4)
        .outputs(metaitem('component.resistor') * 2)
        .duration(160)
        .EUt(6)
        .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('glue') * 100)
        .input(new GTRecipeItemInput(carbons, 1))
        .inputs(ore('wireFineAnnealedCopper') * 4)
        .outputs(metaitem('component.resistor') * 4)
        .duration(160)
        .EUt(6)
        .buildAndRegister();        

crafting.shapedBuilder()               
        .name('resistor_wire')            
        .output(metaitem('component.resistor') * 2)      
        .matrix('RPR',                      
                'WCW',                 
                ' P ')
        .key('R', metaitem('rubber_drop'))  
        .key('P', item('minecraft:paper'))         
        .key('W', ore('wireGtSingleCopper') | ore('wireFineCopper'))  
        .key('C', ore('dustAnthracite') | ore('dustCoke') | ore('dustCarbon') | ore('dustCoal') | ore('dustCharcoal'))             
        .register() 

mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('glass') * 144)
        .inputs(ore('wireFineCopper') * 4)
        .inputs(ore('dustSmallGalena') * 1)
        .outputs(metaitem('component.diode'))
        .duration(400)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('glass') * 144)
        .inputs(ore('wireFineAnnealedCopper') * 4)
        .inputs(ore('dustSmallGalena') * 1)
        .outputs(metaitem('component.diode') * 2)
        .duration(400)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('glass') * 144)
        .inputs(ore('wireFineCopper') * 4)
        .inputs(ore('dustSmallGalliumArsenide') * 1)
        .outputs(metaitem('component.diode') * 3)
        .duration(400)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('glass') * 144)
        .inputs(ore('wireFineAnnealedCopper') * 4)
        .inputs(ore('dustSmallGalliumArsenide') * 1)
        .outputs(metaitem('component.diode') * 4)
        .duration(400)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('plastic') * 144)
        .inputs(ore('wireFineCopper') * 4)
        .inputs(ore('dustSmallGalliumArsenide') * 1)
        .outputs(metaitem('component.diode') * 6)
        .duration(400)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('plastic') * 144)
        .inputs(ore('wireFineAnnealedCopper') * 4)
        .inputs(ore('dustSmallGalliumArsenide') * 1)
        .outputs(metaitem('component.diode') * 8)
        .duration(400)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('plastic') * 144)
        .inputs(ore('wireFineCopper') * 4)
        .inputs(metaitem('wafer.silicon') * 1)
        .outputs(metaitem('component.diode') * 12)
        .duration(400)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('plastic') * 144)
        .inputs(ore('wireFineAnnealedCopper') * 4)
        .inputs(metaitem('wafer.silicon') * 1)
        .outputs(metaitem('component.diode') * 16)
        .duration(400)
        .EUt(30)
        .buildAndRegister();
