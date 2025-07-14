ADVANCED_ARC_FURNACE = recipemap('advanced_arc_furnace')

// Tungstensteel
ADVANCED_ARC_FURNACE.recipeBuilder()
    .fluidInputs(fluid('molten.steel') * 144)
    .inputs(ore('dustTungsten') * 1)    
    .fluidOutputs(fluid('molten.tungsten_steel') * 288)
    .EUt(480)
    .duration(1300) // Give a good number of overclocks
    .buildAndRegister()