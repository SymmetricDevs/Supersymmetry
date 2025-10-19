import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Tungstensteel
ADVANCED_ARC_FURNACE.recipeBuilder()
    .circuitMeta(1)
    .fluidInputs(fluid('molten.steel') * 8640) //equal to 60 Steel dust 
    .inputs(ore('dustTungsten') * 8)
    .inputs(ore('dustChrome') * 3)
    .inputs(ore('dustVanadium') * 1)
    .inputs(ore('dustMolybdenum') * 2)  
    .fluidOutputs(fluid('molten.tungsten_steel') * 10656) // 74 ingot 
    .EUt(VA[IV])
    .duration(22000) 
    .buildAndRegister()

ADVANCED_ARC_FURNACE.recipeBuilder()
    .circuitMeta(2)
    .fluidInputs(fluid('molten.steel') * 8640) //equal to 60 Steel dust
    .fluidInputs(fluid('argon') * 6000)
    .inputs(ore('dustTungsten') * 8)
    .inputs(ore('dustChrome') * 3)
    .inputs(ore('dustVanadium') * 1)
    .inputs(ore('dustMolybdenum') * 2)  
    .fluidOutputs(fluid('molten.tungsten_steel') * 10656) // 74 ingot 
    .EUt(VA[IV])
    .duration(17000) 
    .buildAndRegister()
