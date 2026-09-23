import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*
import gregtech.api.metatileentity.multiblock.CleanroomType
import globals.semiconductors.Deposition
import globals.semiconductors.Packaging


// Alloy-junction bipolar transistor (MV)

Packaging.generateDicingRecipe('wafer.germanium.n_doped', 'die.alloy_junction_transistor.step_one', 4, 400, LV)

RESISTANCE_FURNACE.recipeBuilder()
    .notConsumable(ore('springCupronickel'))
    .inputs(ore('nuggetHighPurityIndium') * 2)
    .inputs(metaitem('die.alloy_junction_transistor.step_one'))
    .outputs(metaitem('die.alloy_junction_transistor.step_two'))
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister();

// Backside (collector) metallization for ohmic contact
Deposition.generateEvaporationRecipe('die.alloy_junction_transistor.step_two', 'die.alloy_junction_transistor.step_three', 100, 'gold_antimony', false)

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('die.alloy_junction_transistor.step_three'))
    .inputs(ore('wireFineDumet') * 3)
    .inputs(ore('boltKovar'))
    .fluidInputs(fluid('high_temperature_solder') * 18)
    .outputs(metaitem('component.transistor.alloy_junction.core'))
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('component.transistor.alloy_junction.core'))
    .inputs(ore('wireFineNickel') * 3)
    .fluidInputs(fluid('glass') * 72)
    .fluidInputs(fluid('high_temperature_solder') * 72)
    .fluidInputs(fluid('nitrogen') * 50)
    .outputs(metaitem('component.transistor.alloy_junction'))
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister();

// Power Si-MOSFET (VDMOS for power, LDMOS for RF/high-speed)

// Power SiC-MOSFET

// IGBT (power electronics)
