//Change transistor to use silicon wafer instead of silicon plate
// Transistor * 8
mods.gregtech.assembler.removeByInput(120, [metaitem('plateSilicon'), metaitem('wireFineTin') * 6], [fluid('plastic') * 144])

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('wireFineTin') * 6)
        .inputs(metaitem('wafer.silicon'))
        .fluidInputs(fluid('plastic') * 144)
        .outputs(metaitem('component.transistor') * 8)
        .duration(160)
        .EUt(120)
        .buildAndRegister()