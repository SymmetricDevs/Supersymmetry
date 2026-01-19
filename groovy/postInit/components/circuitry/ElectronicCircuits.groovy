import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*
import gregtech.api.recipes.ingredients.GTRecipeItemInput

// Electronic Circuit * 2
mods.gregtech.circuit_assembler.removeByInput(16, [metaitem('circuit_board.basic'), metaitem('component.resistor') * 2, metaitem('wireGtSingleRedAlloy') * 2, metaitem('circuit.vacuum_tube') * 2], [fluid('tin') * 144])
// Electronic Circuit * 2
mods.gregtech.circuit_assembler.removeByInput(16, [metaitem('circuit_board.basic'), metaitem('component.resistor') * 2, metaitem('wireGtSingleRedAlloy') * 2, metaitem('circuit.vacuum_tube') * 2], [fluid('soldering_alloy') * 72])

//Remove steel plates from electronic circuits since they were unnecessary

crafting.replaceShaped("gregtech:electronic_circuit_lv", metaitem('circuit.electronic'), [
    [metaitem('component.resistor'), ore('craftingToolWireCutter'), metaitem('component.resistor')],
    [metaitem('circuit.vacuum_tube'), metaitem('circuit_board.basic'), metaitem('circuit.vacuum_tube')],
    [ore('wireGtSingleCopper'), ore('wireGtSingleCopper'), ore('wireGtSingleCopper')]])

CIRCUIT_ASSEMBLER.recipeBuilder()
    .inputs(ore('circuitUlv') * 2)
    .inputs(ore('componentResistor') * 2)
    .inputs(metaitem('circuit_board.basic'))
    .inputs(ore('wireGtSingleCopper') * 2)
    .outputs(metaitem('circuit.electronic') * 2)
    .duration(200)
    .EUt(16)
    .buildAndRegister();

crafting.replaceShaped("gregtech:electronic_circuit_mv", metaitem('circuit.good_electronic'), [
    [metaitem('component.capacitor'), ore('craftingToolWireCutter'), metaitem('component.capacitor')],
    [metaitem('circuit.electronic'), metaitem('circuit_board.good'), metaitem('circuit.electronic')],
    [ore('wireGtSingleCopper'), metaitem('component.relay'), ore('wireGtSingleCopper')]])