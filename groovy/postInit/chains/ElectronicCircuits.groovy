//Remove steel plates from electronic circuits since they were unnecessary

crafting.replaceShaped("gregtech:electronic_circuit_lv", metaitem('circuit.electronic'), [
        [metaitem('component.resistor'), ore('craftingToolWireCutter'), metaitem('component.resistor')],
        [metaitem('circuit.vacuum_tube'), metaitem('circuit_board.basic'), metaitem('circuit.vacuum_tube')],
        [metaitem('cableGtSingleRedAlloy'), metaitem('cableGtSingleRedAlloy'), metaitem('cableGtSingleRedAlloy')]])

crafting.replaceShaped("gregtech:electronic_circuit_mv", metaitem('circuit.good_electronic'), [
        [metaitem('component.diode'), ore('craftingToolWireCutter'), metaitem('component.diode')],
        [metaitem('circuit.electronic'), metaitem('circuit_board.good'), metaitem('circuit.electronic')],
        [metaitem('wireGtSingleCopper'), metaitem('circuit.electronic'), metaitem('wireGtSingleCopper')]])