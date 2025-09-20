import globals.Globals
import static globals.SinteringGlobals.*

MIXER = recipemap('mixer')
SPINNING = recipemap('spinning')
ASSEMBLER = recipemap('assembler')
CHEMICAL_BATH = recipemap('chemical_bath')
TUBE_FURNACE = recipemap('tube_furnace')

// PEMFCs

SPINNING.recipeBuilder()
    .inputs(metaitem('carbon.fibers') * 16)
    .outputs(metaitem('carbon.mesh'))
    .duration(100)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustPolytetrafluoroethylene') * 2)
    .fluidInputs(fluid('cyclohexane') * 1000)
    .fluidOutputs(fluid('polytetrafluoroethylene_coating_solution') * 1000)
    .duration(100)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

CHEMICAL_BATH.recipeBuilder()
    .inputs(metaitem('carbon.mesh'))
    .fluidInputs(fluid('polytetrafluoroethylene_coating_solution') * 50)
    .outputs(metaitem('carbon.mesh.treated'))
    .duration(1000)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustPlatinumOnCarbon'))
    .inputs(ore('dustNafion'))
    .fluidInputs(fluid('isopropyl_alcohol') * 1000)
    .fluidOutputs(fluid('fuel_cell_catalyst_solution') * 1000)
    .duration(100)
    .EUt(Globals.voltAmps[2])
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
    .EUt(Globals.voltAmps[4])
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
    .EUt(Globals.voltAmps[4])
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
    .EUt(Globals.voltAmps[4])
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
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()

// YSZ electrolyte

for (blanket in sintering_blankets) {
    SINTERING_OVEN.recipeBuilder()
        .notConsumable(metaitem('shape.extruder.plate'))
        .inputs(ore('dustYttriaStabilizedZirconia'))
        .fluidInputs(fluid('polyvinyl_alcohol_binder') * 50)
        .outputs(metaitem('plateYttriaStabilizedZirconia'))
        .duration(blanket.duration)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()
}

// Ni-YSZ anode

for (blanket in sintering_blankets) {
    SINTERING_OVEN.recipeBuilder()
        .notConsumable(metaitem('shape.extruder.plate'))
        .inputs(ore('dustNickelIiOxide') * 2)
        .inputs(ore('dustYttriaStabilizedZirconia') * 6)
        .fluidInputs(fluid('polyvinyl_alcohol_binder') * 400)
        .outputs(metaitem('plateNickelYttriaStabilizedZirconia') * 8)
        .duration(blanket.duration)
        .EUt(Globals.voltAmps[2])
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
    .EUt(Globals.voltAmps[4])
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
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()

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
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()