import globals.Globals
import globals.semiconductors.Lithography
import globals.semiconductors.Etching

import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*
import gregtech.api.metatileentity.multiblock.CleanroomType

/*
Etchants used:
- Aluminum: Phosphoric Acid, chlorine plasma
- Indium Tin Oxide: Nitration mixture, fluorine plasma
- Chromium: Hydrochloric acid, fluorine plasma
- GaAs: Hydrogen Peroxide, chlorine plasma
- Gold & Platinum: Aqua Regia, fluorine plasma
- Photoresist: Sulfuric Acid, oxygen plasma
- Silicon: Nitric Acid or Hydrofluoric Acid, chlorine plasma
- Silica: Hydrofluoric acid, CF4 plasma
- Silicon nitride: phosphoric acid, CF4 plasma
- Titanium: hydrofluoric acid, BCl3 plasma
- Tungsten: Hydrogen peroxide, CF4 plasma
- Copper: Iron III chloride or Sodium bisulfite, fluorine plasma
 */

//REMOVALS

// CPU * 8
mods.gregtech.cutter.removeByInput(120, [metaitem('wafer.central_processing_unit')], [fluid('lubricant') * 84])
// CPU * 8
mods.gregtech.cutter.removeByInput(120, [metaitem('wafer.central_processing_unit')], [fluid('distilled_water') * 253])
// CPU * 8
mods.gregtech.cutter.removeByInput(120, [metaitem('wafer.central_processing_unit')], [fluid('water') * 337])
// RAM * 32
mods.gregtech.cutter.removeByInput(96, [metaitem('wafer.random_access_memory')], [fluid('lubricant') * 67])
// RAM * 32
mods.gregtech.cutter.removeByInput(96, [metaitem('wafer.random_access_memory')], [fluid('distilled_water') * 202])
// RAM * 32
mods.gregtech.cutter.removeByInput(96, [metaitem('wafer.random_access_memory')], [fluid('water') * 270])
// ULPIC * 6
mods.gregtech.cutter.removeByInput(120, [metaitem('wafer.ultra_low_power_integrated_circuit')], [fluid('lubricant') * 84])
// ULPIC * 6
mods.gregtech.cutter.removeByInput(120, [metaitem('wafer.ultra_low_power_integrated_circuit')], [fluid('distilled_water') * 253])
// ULPIC * 6
mods.gregtech.cutter.removeByInput(120, [metaitem('wafer.ultra_low_power_integrated_circuit')], [fluid('water') * 337])
// LPIC * 4
mods.gregtech.cutter.removeByInput(480, [metaitem('wafer.low_power_integrated_circuit')], [fluid('lubricant') * 250])
// LPIC * 4
mods.gregtech.cutter.removeByInput(480, [metaitem('wafer.low_power_integrated_circuit')], [fluid('distilled_water') * 750])
// LPIC * 4
mods.gregtech.cutter.removeByInput(480, [metaitem('wafer.low_power_integrated_circuit')], [fluid('water') * 1000])

// Integrated Circuit * 8
mods.gregtech.cutter.removeByInput(64, [metaitem('wafer.integrated_logic_circuit')], [fluid('lubricant') * 45])
// Integrated Circuit * 8
mods.gregtech.cutter.removeByInput(64, [metaitem('wafer.integrated_logic_circuit')], [fluid('distilled_water') * 135])
// Integrated Circuit * 8
mods.gregtech.cutter.removeByInput(64, [metaitem('wafer.integrated_logic_circuit')], [fluid('water') * 180])

// PIC * 4
mods.gregtech.cutter.removeByInput(1920, [metaitem('wafer.power_integrated_circuit')], [fluid('lubricant') * 250])
// PIC * 4
mods.gregtech.cutter.removeByInput(1920, [metaitem('wafer.power_integrated_circuit')], [fluid('distilled_water') * 750])
// PIC * 4
mods.gregtech.cutter.removeByInput(1920, [metaitem('wafer.power_integrated_circuit')], [fluid('water') * 1000])

// NAND * 32
mods.gregtech.cutter.removeByInput(192, [metaitem('wafer.nand_memory_chip')], [fluid('lubricant') * 135])
// NAND * 32
mods.gregtech.cutter.removeByInput(192, [metaitem('wafer.nand_memory_chip')], [fluid('distilled_water') * 405])
// NAND * 32
mods.gregtech.cutter.removeByInput(192, [metaitem('wafer.nand_memory_chip')], [fluid('water') * 540])
// NOR * 16
mods.gregtech.cutter.removeByInput(192, [metaitem('wafer.nor_memory_chip')], [fluid('lubricant') * 135])
// NOR * 16
mods.gregtech.cutter.removeByInput(192, [metaitem('wafer.nor_memory_chip')], [fluid('distilled_water') * 405])
// NOR * 16
mods.gregtech.cutter.removeByInput(192, [metaitem('wafer.nor_memory_chip')], [fluid('water') * 540])
