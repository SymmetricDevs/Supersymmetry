import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*
import gregtech.api.recipes.ingredients.GTRecipeItemInput

// Electronic Circuit * 2
mods.gregtech.circuit_assembler.removeByInput(16, [metaitem('circuit_board.basic'), metaitem('component.resistor') * 2, metaitem('wireGtSingleRedAlloy') * 2, metaitem('circuit.vacuum_tube') * 2], [fluid('tin') * 144])
// Electronic Circuit * 2
mods.gregtech.circuit_assembler.removeByInput(16, [metaitem('circuit_board.basic'), metaitem('component.resistor') * 2, metaitem('wireGtSingleRedAlloy') * 2, metaitem('circuit.vacuum_tube') * 2], [fluid('soldering_alloy') * 72])

//Remove steel plates from electronic circuits since they were unnecessary

crafting.replaceShaped("gregtech:electronic_circuit_lv", metaitem('circuit.electronic'), [
    [ore('componentResistorMedium'), ore('craftingToolWireCutter'), ore('componentResistorMedium')],
    [metaitem('circuit.vacuum_tube'), metaitem('circuit_board.basic'), metaitem('circuit.vacuum_tube')],
    [ore('wireGtSingleCopper'), ore('wireGtSingleCopper'), ore('wireGtSingleCopper')]])

CIRCUIT_ASSEMBLER.recipeBuilder()
    .inputs(ore('circuitUlv') * 2)
    .inputs(ore('componentResistor') * 2)
    .inputs(ore('wireFineCopper') * 2)
    .inputs(metaitem('circuit_board.basic'))
    .outputs(metaitem('circuit.electronic') * 2)
    .duration(50)
    .EUt(16)
    .buildAndRegister();

crafting.replaceShaped("gregtech:electronic_circuit_mv", metaitem('circuit.good_electronic'), [
    [ore('componentCapacitorMedium'), metaitem('circuit.electronic'), ore('componentCapacitorMedium')],
    [ore('circuitLv'), metaitem('circuit_board.basic'), metaitem('circuit.electronic')],
    [ore('wireGtSingleCopper'), metaitem('component.relay'), ore('wireGtSingleCopper')]])

CIRCUIT_ASSEMBLER.recipeBuilder()
    .inputs(ore('circuitLv') * 2)
    .inputs(ore('componentCapacitorMedium') * 2)
    .inputs(ore('wireGtSingleCopper') * 2)
    .inputs(metaitem('component.relay'))
    .inputs(metaitem('circuit_board.basic'))
    .duration(50)
    .EUt(16)
    .buildAndRegister();

