import globals.Globals

ADVANCED_ARC_FURNACE = recipemap('advanced_arc_furnace')

// Tungstensteel
ADVANCED_ARC_FURNACE.recipeBuilder()
    .fluidInputs(fluid('molten.steel') * 8640) //equal to 60 Steel dust 
    .inputs(ore('dustTungsten') * 8)
    .inputs(ore('dustChrome') * 3)
    .inputs(ore('dustVanadium') * 1)
    .inputs(ore('dustMolybdenum') * 2)  
    .fluidOutputs(fluid('molten.tungsten_steel') * 10656) // 74 ingot 
    .EUt(Globals.voltAmps[5])
    .duration(22000) 
    .buildAndRegister()

ADVANCED_ARC_FURNACE.recipeBuilder()
    .fluidInputs(fluid('molten.steel') * 8640) //equal to 60 Steel dust
    .fluidInputs(fluid('argon') * 6000)
    .inputs(ore('dustTungsten') * 8)
    .inputs(ore('dustChrome') * 3)
    .inputs(ore('dustVanadium') * 1)
    .inputs(ore('dustMolybdenum') * 2)  
    .fluidOutputs(fluid('molten.tungsten_steel') * 10656) // 74 ingot 
    .EUt(Globals.voltAmps[5])
    .duration(17000) 
    .buildAndRegister()
