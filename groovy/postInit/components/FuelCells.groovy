import static prePostInit.Recipemaps.*
import globals.Sintering
import static gregtech.api.GTValues.*

import postInit.utils.RecyclingHelper

// PEMFCs

// Carbon Fiber Mesh * 1
mods.gregtech.compressor.removeByInput(2, [metaitem('carbon.fibers') * 2], null)

SPINNING.recipeBuilder()
    .inputs(metaitem('carbon.fibers') * 16)
    .outputs(metaitem('carbon.mesh'))
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustPolytetrafluoroethylene') * 2)
    .fluidInputs(fluid('cyclohexane') * 1000)
    .fluidOutputs(fluid('polytetrafluoroethylene_coating_solution') * 1000)
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister()

CHEMICAL_BATH.recipeBuilder()
    .inputs(metaitem('carbon.mesh'))
    .fluidInputs(fluid('polytetrafluoroethylene_coating_solution') * 50)
    .outputs(metaitem('carbon.mesh.treated'))
    .duration(1000)
    .EUt(VA[MV])
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustPlatinumOnCarbon'))
    .inputs(ore('dustNafion'))
    .fluidInputs(fluid('isopropyl_alcohol') * 1000)
    .fluidOutputs(fluid('fuel_cell_catalyst_solution') * 1000)
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(ore('plateNafion') * 16)
    .inputs(metaitem('carbon.mesh.treated') * 32)
    .inputs(ore('ringViton') * 32)
    .inputs(ore('frameGtPolysulfone'))
    .inputs(ore('circuitEv') * 2)
    .inputs(metaitem('electric.pump.ev') * 2)
    .inputs(ore('pipeSmallFluidTitanium') * 4)
    .inputs(metaitem('hull.ev'))
    .fluidInputs(fluid('fuel_cell_catalyst_solution') * 1000)
    .outputs(metaitem('proton_exchange_membrane_fuel_cell'))
    .duration(1000)
    .EUt(VA[EV])
    .buildAndRegister()

// SOFCs

// LSM cathode

TUBE_FURNACE.recipeBuilder()
    .notConsumable(metaitem('shape.mold.plate'))
    .inputs(ore('dustGraphite')) // pore former
    .inputs(ore('dustLanthanumCarbonate') * 28)
    .inputs(ore('dustStrontiumCarbonate') * 5)
    .inputs(ore('dustManganeseIiCarbonate') * 25)
    .fluidInputs(fluid('argon') * 50)
    .outputs(metaitem('plateLanthanumStrontiumManganite') * 5)
    .duration(1000)
    .EUt(VA[EV])
    .buildAndRegister()

// GDC electrolyte

TUBE_FURNACE.recipeBuilder() // no pores to prevent fuel-air crossover
    .circuitMeta(1)
    .notConsumable(metaitem('shape.mold.plate'))
    .inputs(ore('dustGadoliniumCarbonate') * 7)
    .inputs(ore('dustCeriumIiiCarbonate') * 63)
    .fluidInputs(fluid('argon') * 100)
    .outputs(metaitem('plateGadoliniumDopedCeria') * 10)
    .duration(2000)
    .EUt(VA[EV])
    .buildAndRegister()

// Ni-GDC anode

TUBE_FURNACE.recipeBuilder()
    .circuitMeta(2)
    .notConsumable(metaitem('shape.mold.plate'))
    .inputs(ore('dustGraphite') * 4)
    .inputs(ore('dustNickelIiOxide') * 20)
    .inputs(ore('dustGadoliniumCarbonate') * 7)
    .inputs(ore('dustCeriumIiiCarbonate') * 63)
    .fluidInputs(fluid('argon') * 100)
    .outputs(metaitem('plateNickelGadoliniumDopedCeria') * 20)
    .duration(2000)
    .EUt(VA[EV])
    .buildAndRegister()

// YSZ electrolyte
Sintering.blankets.each { blanket ->
    SINTERING_OVEN.recipeBuilder()
        .circuitMeta(1)
        .notConsumable(metaitem('shape.extruder.plate'))
        .inputs(ore('dustYttriaStabilizedZirconia'))
        .fluidInputs(fluid('polyvinyl_alcohol_binder') * 50)
        .fluidInputs(fluid(blanket.name) * blanket.amountRequired)
        .outputs(metaitem('plateYttriaStabilizedZirconia'))
        .duration(blanket.duration)
        .EUt(VA[MV])
        .buildAndRegister()
}

// Ni-YSZ anode

Sintering.blankets.each { blanket ->
    SINTERING_OVEN.recipeBuilder()
        .circuitMeta(2)
        .notConsumable(metaitem('shape.extruder.plate'))
        .inputs(ore('dustNickelIiOxide') * 2)
        .inputs(ore('dustYttriaStabilizedZirconia') * 6)
        .fluidInputs(fluid('polyvinyl_alcohol_binder') * 400)
        .fluidInputs(fluid(blanket.name) * blanket.amountRequired)
        .outputs(metaitem('plateNickelYttriaStabilizedZirconia') * 8)
        .duration(blanket.duration)
        .EUt(VA[MV])
        .buildAndRegister()
}
// LSC interconnects

TUBE_FURNACE.recipeBuilder()
    .notConsumable(metaitem('shape.mold.plate'))
    .inputs(ore('dustLanthanumCarbonate') * 28)
    .inputs(ore('dustStrontiumCarbonate') * 5)
    .inputs(ore('dustChromiumIiiCarbonate') * 35)
    .fluidInputs(fluid('argon') * 50)
    .outputs(metaitem('plateLanthanumStrontiumChromite') * 5)
    .duration(1000)
    .EUt(VA[EV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(ore('plateLanthanumStrontiumManganite') * 16)
    .inputs(ore('plateGadoliniumDopedCeria') * 16)
    .inputs(ore('plateNickelGadoliniumDopedCeria') * 16)
    .inputs(ore('plateStainlessSteel') * 16)
    .inputs(ore('circuitEv') * 2)
    .inputs(ore('pipeSmallFluidTitanium') * 4)
    .inputs(metaitem('electric.pump.ev') * 2)
    .inputs(metaitem('hull.ev'))
    .outputs(metaitem('susy:fuel_cell.ev'))
    .duration(1000)
    .EUt(VA[EV])
    .buildAndRegister()

RecyclingHelper.handleRecycling(metaitem('susy:fuel_cell.ev'), [metaitem('hull.ev'), metaitem('electric.pump.ev') * 2, ore('pipeSmallFluidTitanium') * 4, ore('plateStainlessSteel') * 16])

ASSEMBLER.recipeBuilder()
    .inputs(ore('plateLanthanumStrontiumManganite') * 16)
    .inputs(ore('plateYttriaStabilizedZirconia') * 16)
    .inputs(ore('plateNickelYttriaStabilizedZirconia') * 16)
    .inputs(ore('plateLanthanumStrontiumChromite') * 16)
    .inputs(ore('circuitIv') * 2)
    .inputs(ore('pipeSmallFluidTungstenSteel') * 4)
    .inputs(metaitem('electric.pump.iv') * 2)
    .inputs(metaitem('hull.iv'))
    .outputs(metaitem('susy:fuel_cell.iv'))
    .duration(1000)
    .EUt(VA[EV])
    .buildAndRegister()

RecyclingHelper.handleRecycling(metaitem('susy:fuel_cell.iv'), [metaitem('hull.iv'), metaitem('electric.pump.iv') * 2, ore('pipeSmallFluidTungstenSteel') * 4])
