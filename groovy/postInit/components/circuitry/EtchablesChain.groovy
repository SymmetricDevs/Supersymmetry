import globals.Globals
import globals.Photoresists
import globals.Etchants
import globals.PDopants
import globals.NDopants

import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*
import gregtech.api.metatileentity.multiblock.CleanroomType

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

def generateCuttingRecipes(input, product, productMultiplier, voltageTier, boolean cleanroom) {
    if (cleanroom) {
        CUTTER.recipeBuilder()
                .fluidInputs(fluid('ultrapure_water') * 100)
                .inputs(metaitem(input))
                .outputs(metaitem(product) * productMultiplier)
                .duration(450)
                .cleanroom(CleanroomType.CLEANROOM)
                .EUt(VA[voltageTier])
                .buildAndRegister()

        LASER_ENGRAVER.recipeBuilder()
                .inputs(metaitem(input))
                .outputs(metaitem(product) * productMultiplier)
                .duration(60)
                .cleanroom(CleanroomType.CLEANROOM)
                .EUt(VA[voltageTier])
                .buildAndRegister()
    } else {
        CUTTER.recipeBuilder()
                .fluidInputs(fluid('ultrapure_water') * 100)
                .inputs(metaitem(input))
                .outputs(metaitem(product) * productMultiplier)
                .duration(450)
                .EUt(VA[voltageTier])
                .buildAndRegister()

        LASER_ENGRAVER.recipeBuilder()
                .inputs(metaitem(input))
                .outputs(metaitem(product) * productMultiplier)
                .duration(60)
                .EUt(VA[voltageTier])
                .buildAndRegister()
    }
}

//NOVOLACS

CSTR.recipeBuilder()
        .fluidInputs(fluid('formaldehyde') * 75)
        .fluidInputs(fluid('ammonia_solution') * 50)
        .fluidOutputs(fluid('hexamethylenetetramine_solution') * 50)
        .duration(50)
        .EUt(VA[ULV])
        .buildAndRegister()

CSTR.recipeBuilder()
        .fluidInputs(fluid('formaldehyde') * 50)
        .fluidInputs(fluid('phenol') * 50)
        .fluidInputs(fluid('hexamethylenetetramine_solution') * 5)
        .notConsumable(fluid('sodium_hydroxide_solution') * 50)
        .fluidOutputs(fluid('novolacs') * 100)
        .duration(10)
        .EUt(VA[ULV])
        .buildAndRegister()

//DOPING

for (pdopant in PDopants.pdopants) {
    ION_IMPLANTER.recipeBuilder()
            .inputs(metaitem('wafer.silicon') * 16 * pdopant.efficiency)
            .circuitMeta(1)
            .inputs(metaitem(pdopant.metaItemName))
            .outputs(metaitem('wafer.n_doped.silicon') * 16 * pdopant.efficiency)
            .duration(300)
            .EUt(60)
            .buildAndRegister()

    ION_IMPLANTER.recipeBuilder()
            .inputs(metaitem('etched.silicon_dioxide') * 16 * pdopant.efficiency)
            .circuitMeta(1)
            .inputs(metaitem(pdopant.metaItemName))
            .outputs(metaitem('wafer.doped.silicon_dioxide') * 16 * pdopant.efficiency)
            .cleanroom(CleanroomType.CLEANROOM)
            .duration(300)
            .EUt(240)
            .buildAndRegister()

    for (ndopant in NDopants.ndopants) {
        int batchSize = ndopant.efficiency * pdopant.efficiency

        ION_IMPLANTER.recipeBuilder()
                .inputs(metaitem('wafer.silicon') * 16 * batchSize)
                .inputs(metaitem(ndopant.metaItemName))
                .inputs(metaitem(pdopant.metaItemName))
                .outputs(metaitem('wafer.doped.silicon') * 16 * batchSize)
                .duration(200)
                .EUt(60)
                .buildAndRegister()

        ION_IMPLANTER.recipeBuilder()
                .inputs(metaitem('etched.polysilicon') * 16 * batchSize)
                .inputs(metaitem(ndopant.metaItemName))
                .inputs(metaitem(pdopant.metaItemName))
                .outputs(metaitem('wafer.doped.polysilicon') * 16 * batchSize)
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(200)
                .EUt(240)
                .buildAndRegister()
    }
}

//WAFERS

Photoresists.generatePatterningRecipes('wafer.silicon', 'patterned.ram', 'mask.ram', MV, 4, 1, 1, false)
Photoresists.generatePatterningRecipes('wafer.silicon', 'patterned.ulpic', 'mask.ulpic', MV, 4, 1, 2, false)
Photoresists.generatePatterningRecipes('wafer.silicon', 'patterned.ic', 'mask.ic', MV, 4, 1, 3, false)

Photoresists.generatePatterningRecipes('wafer.silicon', 'patterned.ram', 'mask.ram', MV, 4, 1, 1, false)
Photoresists.generatePatterningRecipes('wafer.silicon', 'patterned.ulpic', 'mask.ulpic', MV, 4, 1, 2, false)
Photoresists.generatePatterningRecipes('wafer.silicon', 'patterned.ic', 'mask.ic', MV, 4, 1, 3, false)

Photoresists.generatePatterningRecipes('wafer.doped.silicon', 'patterned.ram', 'mask.ram', MV, 4, 2, 1, false)
Photoresists.generatePatterningRecipes('wafer.doped.silicon', 'patterned.cpu', 'mask.cpu', MV, 4, 1, 2, false)
Photoresists.generatePatterningRecipes('wafer.doped.silicon', 'patterned.ulpic', 'mask.ulpic', MV, 4, 2, 3, false)
Photoresists.generatePatterningRecipes('wafer.doped.silicon', 'patterned.lpic', 'mask.lpic', HV, 4, 1, 4, false)
Photoresists.generatePatterningRecipes('wafer.doped.silicon', 'patterned.ic', 'mask.ic', MV, 4, 2, 5, false)

Photoresists.generatePatterningRecipes('wafer.silicon_dioxide', 'patterned.silicon_dioxide', 'mask.advanced', HV, 4, 1, 1, true)
Photoresists.generatePatterningRecipes('wafer.polysilicon', 'patterned.polysilicon', 'mask.advanced', HV, 4, 1, 1, true)
Photoresists.generatePatterningRecipes('wafer.silicon_nitride', 'patterned.silicon_nitride', 'mask.advanced', HV, 4, 1, 1, true)
Photoresists.generatePatterningRecipes('wafer.nickel', 'patterned.nand', 'mask.nand', HV, 4, 1, 1, true)
Photoresists.generatePatterningRecipes('wafer.nickel', 'patterned.nor', 'mask.nor', HV, 4, 1, 2, true)

Etchants.generateEtchingRecipes('patterned.ic', 'etched.ic', 'silicon', LV, 1, false)
Etchants.generateEtchingRecipes('patterned.cpu', 'etched.cpu', 'silicon', LV, 1,false)
Etchants.generateEtchingRecipes('patterned.ram', 'etched.ram', 'silicon', LV, 1, false)
Etchants.generateEtchingRecipes('patterned.ulpic', 'etched.ulpic', 'silicon', LV, 1, false)
Etchants.generateEtchingRecipes('patterned.lpic', 'etched.lpic', 'silicon', LV, 1, false)

Etchants.generateEtchingRecipes('patterned.silicon_dioxide', 'etched.silicon_dioxide', 'silicon_dioxide', MV, 1, true)
Etchants.generateEtchingRecipes('patterned.polysilicon', 'etched.polysilicon', 'silicon', MV, 1, true)
Etchants.generateEtchingRecipes('patterned.silicon_nitride', 'etched.silicon_nitride', 'silicon_nitride', MV, 1, true)
Etchants.generateEtchingRecipes('patterned.nand', 'wafer.nand_memory_chip', 'nickel', MV, 1, true)
Etchants.generateEtchingRecipes('patterned.nor', 'wafer.nor_memory_chip', 'nickel', MV, 1, true)

ELECTROLYZER.recipeBuilder()
        .inputs(metaitem('etched.ic'))
        .inputs(ore('foilCopper'))
        .fluidInputs(fluid('sulfuric_acid') * 100)
        .outputs(metaitem('wafer.integrated_logic_circuit'))
        .duration(200)
        .EUt(VA[LV])
        .buildAndRegister()

ELECTROLYZER.recipeBuilder()
        .inputs(metaitem('etched.cpu'))
        .inputs(ore('foilCopper'))
        .fluidInputs(fluid('sulfuric_acid') * 100)
        .outputs(metaitem('wafer.central_processing_unit'))
        .duration(200)
        .EUt(VA[LV])
        .buildAndRegister()

ELECTROLYZER.recipeBuilder()
        .inputs(metaitem('etched.ram'))
        .inputs(ore('foilCopper'))
        .fluidInputs(fluid('sulfuric_acid') * 100)
        .outputs(metaitem('wafer.random_access_memory'))
        .duration(200)
        .EUt(VA[LV])
        .buildAndRegister()

ELECTROLYZER.recipeBuilder()
        .inputs(metaitem('etched.ulpic'))
        .inputs(ore('foilCopper'))
        .fluidInputs(fluid('sulfuric_acid') * 100)
        .outputs(metaitem('wafer.ultra_low_power_integrated_circuit'))
        .duration(200)
        .EUt(VA[LV])
        .buildAndRegister()

ELECTROLYZER.recipeBuilder()
        .inputs(metaitem('etched.lpic'))
        .inputs(ore('foilCopper'))
        .fluidInputs(fluid('sulfuric_acid') * 100)
        .outputs(metaitem('wafer.low_power_integrated_circuit'))
        .duration(200)
        .EUt(VA[LV])
        .buildAndRegister()

generateCuttingRecipes('wafer.central_processing_unit', 'plate.central_processing_unit', 8, MV, false)
generateCuttingRecipes('wafer.ultra_low_power_integrated_circuit', 'plate.ultra_low_power_integrated_circuit', 6, MV, false)
generateCuttingRecipes('wafer.integrated_logic_circuit', 'plate.integrated_logic_circuit', 8, MV, false)
generateCuttingRecipes('wafer.random_access_memory', 'plate.random_access_memory', 32, MV, false)
generateCuttingRecipes('wafer.low_power_integrated_circuit', 'plate.low_power_integrated_circuit', 4, HV, true)
generateCuttingRecipes('wafer.power_integrated_circuit', 'plate.power_integrated_circuit', 4, EV, true)
generateCuttingRecipes('wafer.nand_memory_chip', 'plate.nand_memory_chip', 32, HV, true)
generateCuttingRecipes('wafer.nor_memory_chip', 'plate.nor_memory_chip', 16, HV, true)

//PHENOLIC BOARD (TIER 2)

FORMING_PRESS.recipeBuilder()
        .inputs(metaitem('board.phenolic'))
        .inputs(ore('foilCopper'))
        .outputs(metaitem('laminated.board.phenolic'))
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister()

Photoresists.generatePatterningRecipes('laminated.board.phenolic', 'patterned.board.phenolic', 'mask.pcb', LV, 1, 1, 0, false)
Etchants.generateEtchingRecipes('patterned.board.phenolic', 'circuit_board.good', 'copper', LV, 1, false)

//PLASTIC CIRCUIT BOARD (TIER 3)

FORMING_PRESS.recipeBuilder()
        .inputs(ore('platePlastic'))
        .inputs(ore('foilCopper'))
        .outputs(metaitem('board.plastic'))
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister()

FORMING_PRESS.recipeBuilder()
        .inputs(ore('platePolyvinylChloride'))
        .inputs(ore('foilCopper'))
        .outputs(metaitem('board.plastic') * 2)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister()

FORMING_PRESS.recipeBuilder()
        .inputs(ore('platePolytetrafluoroethylene'))
        .inputs(ore('foilCopper'))
        .outputs(metaitem('board.plastic') * 4)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister()

FORMING_PRESS.recipeBuilder()
        .inputs(ore('platePolybenzimidazole'))
        .inputs(ore('foilCopper'))
        .outputs(metaitem('board.plastic') * 8)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister()

Photoresists.generatePatterningRecipes('board.plastic', 'patterned.board.plastic', 'mask.pcb', MV, 1, 1, 0, false)
Etchants.generateEtchingRecipes('patterned.board.plastic', 'circuit_board.plastic', 'copper', MV, 1, false)

//NAND AND NOR

CVD.recipeBuilder()
        .inputs(metaitem('wafer.doped.silicon_dioxide'))
        .fluidInputs(fluid('silane') * 250)
        .outputs(metaitem('wafer.polysilicon'))
        .fluidOutputs(fluid('hydrogen') * 1000)
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(100)
        .EUt(240)
        .buildAndRegister()

CVD.recipeBuilder()
        .inputs(metaitem('wafer.doped.polysilicon'))
        .fluidInputs(fluid('silane') * 750)
        .fluidInputs(fluid('ammonia') * 1000)
        .outputs(metaitem('wafer.silicon_nitride'))
        .fluidOutputs(fluid('hydrogen') * 3000)
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(200)
        .EUt(240)
        .buildAndRegister()

CVD.recipeBuilder()
        .inputs(metaitem('etched.silicon_nitride'))
        .fluidInputs(fluid('nickel_carbonyl') * 500)
        .outputs(metaitem('wafer.nickel'))
        .fluidOutputs(fluid('carbon_monoxide') * 2000)
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(200)
        .EUt(240)
        .buildAndRegister()

//PIC

ASSEMBLER.recipeBuilder()
        .inputs(metaitem('wafer.doped.polysilicon'))
        .inputs(metaitem('wafer.alumina'))
        .outputs(metaitem('wafer.power_integrated_circuit'))
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(200)
        .EUt(VA[MV])
        .buildAndRegister()

ASSEMBLER.recipeBuilder()
        .inputs(metaitem('wafer.doped.polysilicon'))
        .inputs(metaitem('wafer.beryllium_oxide'))
        .outputs(metaitem('wafer.power_integrated_circuit'))
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(200)
        .EUt(VA[MV])
        .buildAndRegister()

// Phenolic Circuit Board * 1
mods.gregtech.assembler.removeByInput(30, [metaitem('dustWood'), metaitem('circuit.integrated').withNbt(['Configuration': 1])], [fluid('glue') * 50])

ASSEMBLER.recipeBuilder()
        .inputs(ore('dustTreatedWood'))
        .fluidInputs(fluid('glue') * 50)
        .outputs(metaitem('board.phenolic'))
        .duration(160)
        .EUt(VA[LV])
        .buildAndRegister()

ASSEMBLER.recipeBuilder()
        .inputs(metaitem('foilCopper') * 2)
        .inputs(metaitem('plateTreatedWood'))
        .inputs(metaitem('wireFineSilver') * 4)
        .fluidInputs(fluid('glue') * 50)
        .outputs(metaitem('circuit_board.good'))
        .duration(120)
        .EUt(VA[LV])
        .buildAndRegister()
