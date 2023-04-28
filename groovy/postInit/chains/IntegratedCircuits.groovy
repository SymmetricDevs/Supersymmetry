//Change transistor to use silicon wafer instead of silicon plate
//TODO: FIGURE OUT WHY THIS WONT WORK
//mods.gregtech.assembler.removeByInput(120, [item('gregtech:meta_item_1', 371), item('gregtech:meta_wire_fine', 112)], [fluid('plastic') * 144])

mods.gregtech.assembler.recipeBuilder()
        .inputs(metaitem('wireFineTin') * 6)
        .inputs(metaitem('wafer.silicon'))
        .fluidInputs(fluid('plastic') * 144)
        .outputs(metaitem('component.transistor') * 8)
        .duration(160)
        .EUt(120)
        .buildAndRegister()