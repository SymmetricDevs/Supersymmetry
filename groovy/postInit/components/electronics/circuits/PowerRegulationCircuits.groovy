import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

//Change transistor to use silicon wafer instead of silicon plate
// Transistor * 8
mods.gregtech.assembler.removeByInput(120, [metaitem('plateSilicon'), metaitem('wireFineTin') * 6], [fluid('plastic') * 144])

// Op amps

CIRCUIT_ASSEMBLER.recipeBuilder()
    .inputs(ore('wireFineGold') * 10)
    .inputs(ore('componentCapacitorMedium'))
    .inputs(ore('componentResistorMedium') * 8)
    .inputs(ore('componentTransistor') * 8)
    .inputs(ore('componentDiodeSignal') * 2)
    .inputs(metaitem('circuit_board.good'))
    .fluidInputs(fluid('soldering_alloy') * 72)
    .fluidInputs(fluid('phenolic_novolacs_resin') * 200)
    .outputs(metaitem('component.op_amp'))
    .duration(600)
    .EUt(VA[LV])
    .buildAndRegister()

CIRCUIT_ASSEMBLER.recipeBuilder()
    .inputs(ore('wireFineGold') * 10)
    .inputs(ore('componentCapacitorMedium'))
    .inputs(ore('componentResistorMedium') * 8)
    .inputs(ore('componentTransistor') * 8)
    .inputs(ore('componentDiodeSignal') * 2)
    .inputs(metaitem('circuit_board.good'))
    .fluidInputs(fluid('soldering_alloy') * 72)
    .fluidInputs(fluid('epoxy_molding_compound') * 36)
    .fluidInputs(fluid('silicone_rubber') * 72)
    .outputs(metaitem('component.op_amp'))
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

// Heat sink

BENDER.recipeBuilder()
    .circuitMeta(5)
    .inputs(ore('plateAluminium'))
    .outputs(metaitem('component.heat_sink') * 2)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

// High voltage fuse

ASSEMBLER.recipeBuilder()
    .inputs(ore('dustAcidWashedSiliconDioxide'))
    .inputs(ore('wireFineSilver'))
    .inputs(ore('wireFineAnnealedCopper') * 2)
    .fluidInputs(fluid('plastic') * 36)
    .outputs(metaitem('component.fuse.hv') * 4)
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister()

// Protector circuit

CIRCUIT_ASSEMBLER.recipeBuilder()
    .inputs(metaitem('component.resistor.carbon_film') * 2)
    .inputs(metaitem('component.capacitor.film') * 2)
    .inputs(ore('componentTransistor') * 2)
    .inputs(metaitem('component.fuse.hv'))
    .inputs(metaitem('component.zener_diode'))
    .inputs(ore('wireFineAluminium') * 2)
    .inputs(metaitem('circuit_board.good'))
    .fluidInputs(fluid('soldering_alloy') * 72)
    .fluidInputs(fluid('phenolic_novolacs_resin') * 200)
    .outputs(metaitem('component.protector_circuit'))
    .duration(600)
    .EUt(VA[LV])
    .buildAndRegister()

CIRCUIT_ASSEMBLER.recipeBuilder()
    .inputs(metaitem('component.resistor.carbon_film') * 2)
    .inputs(metaitem('component.capacitor.film') * 2)
    .inputs(ore('componentTransistor') * 2)
    .inputs(metaitem('component.fuse.hv'))
    .inputs(metaitem('component.zener_diode'))
    .inputs(ore('wireFineAluminium') * 2)
    .inputs(metaitem('circuit_board.good'))
    .fluidInputs(fluid('soldering_alloy') * 72)
    .fluidInputs(fluid('epoxy_molding_compound') * 36)
    .fluidInputs(fluid('silicone_rubber') * 72)
    .outputs(metaitem('component.protector_circuit'))
    .duration(600)
    .EUt(VA[LV])
    .buildAndRegister()

// LV Power Circuit

CIRCUIT_ASSEMBLER.recipeBuilder()
    .inputs(ore('componentResistorMedium') * 2)
    .inputs(ore('componentTransistor') * 4)
    .inputs(ore('componentCapacitorMedium'))
    .inputs(metaitem('component.zener_diode'))
    .inputs(ore('wireFineCopper') * 2)
    .inputs(metaitem('circuit_board.good'))
    .fluidInputs(fluid('soldering_alloy') * 72)
    .outputs(metaitem('circuit.power.lv'))
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

oreDict.add('circuitLv', metaitem('circuit.power.lv'))

// MV Power Circuit

CIRCUIT_ASSEMBLER.recipeBuilder()
    .inputs(ore('componentResistorMedium') * 4)
    .inputs(ore('componentTransistor') * 6)
    .inputs(ore('componentCapacitorMedium') * 2)
    .inputs(metaitem("component.op_amp"))
    .inputs(metaitem('component.zener_diode'))
    .inputs(ore('wireFineGold') * 2)
    .inputs(metaitem('circuit_board.good'))
    .fluidInputs(fluid('soldering_alloy') * 72)
    .outputs(metaitem('circuit.power.mv'))
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

oreDict.add('circuitMv', metaitem('circuit.power.mv'))

// HV Power Circuit

CIRCUIT_ASSEMBLER.recipeBuilder()
    .inputs(metaitem('component.resistor.carbon_film') * 6)
    .inputs(metaitem('component.capacitor.film') * 2)
    .inputs(metaitem('component.transistor.alloy_junction') * 8)
    .inputs(metaitem('component.protector_circuit'))
    .inputs(metaitem('component.op_amp'))
    .inputs(metaitem('component.zener_diode'))
    .inputs(metaitem('component.heat_sink'))
    .inputs(ore('componentInductor'))
    .inputs(ore('wireFineGold') * 6)
    .inputs(metaitem('circuit_board.g10'))
    .fluidInputs(fluid('soldering_alloy') * 72)
    .outputs(metaitem('circuit.power.hv'))
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

oreDict.add('circuitHv', metaitem('circuit.power.hv'))
