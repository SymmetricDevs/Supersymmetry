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

// trenched VDMOS

CVD.recipeBuilder()
    .inputs(metaitem('wafer.silicon.n_doped'))
    .fluidInputs(fluid('phosphine') * 250)
    .fluidInputs(fluid('silane') * 250)
    .outputs(metaitem('wafer.vdmos.step_one'))
    .fluidOutputs(fluid('hydrogen') * 1000)
    .cleanroom(CleanroomType.CLEANROOM)
    .duration(100)
    .EUt(240)
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(metaitem('wafer.vdmos.step_one'))
    .fluidInputs(fluid('oxygen') * 1000)
    .outputs(metaitem('wafer.vdmos.step_two'))
    .cleanroom(CleanroomType.CLEANROOM)
    .duration(400)
    .EUt(240)
    .buildAndRegister()

Photolithography.generatePatterningRecipes('wafer.vdmos.step_two', 'wafer.vdmos.step_three', 'mask.vdmos', HV, 4, 2, 5, false)

for (pdopant in PDopants.pdopants) {
    ION_IMPLANTER.recipeBuilder()
        .inputs(metaitem('wafer.vdmos.step_three') * 16 * pdopant.efficiency)
        .circuitMeta(1)
        .inputs(metaitem(pdopant.metaItemName))
        .outputs(metaitem('wafer.vdmos.step_four') * 16 * pdopant.efficiency)
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(300)
        .EUt(60)
        .buildAndRegister()
}

Etchants.generateEtchingRecipes('wafer.vdmos.step_four', 'wafer.vdmos.step_five', 'CF4', HV, 1, false)

for (ndopant in NDopants.ndopants) {
        ION_IMPLANTER.recipeBuilder()
            .inputs(metaitem('wafer.vdmos.step_five') * 16 * ndopant.efficiency)
            .circuitMeta(1)
            .inputs(metaitem(ndopant.metaItemName))
            .outputs(metaitem('wafer.vdmos.step_six') * 16 * ndopant.efficiency)
            .cleanroom(CleanroomType.CLEANROOM)
            .duration(300)
            .EUt(60)
            .buildAndRegister()
}

Etchants.generateEtchingRecipes('wafer.vdmos.step_six', 'wafer.vdmos.step_seven', 'buffered_HF', HV, 1, false)

CHEMICAL_BATH.recipeBuilder()
    .inputs(metaitem('wafer.vdmos.step_seven'))
    .fluidInputs(fluid('plasma.chlorine') * 10)
    .outputs(metaitem('wafer.vdmos.step_eight'))
    .cleanroom(CleanroomType.CLEANROOM)
    .duration(60)
    .EUt(VA[HV])
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(metaitem('wafer.vdmos.step_eight'))
    .fluidInputs(fluid('water') * 1000)
    .fluidInputs(fluid('oxygen') * 1000)
    .outputs(metaitem('wafer.vdmos.step_nine'))
    .cleanroom(CleanroomType.CLEANROOM)
    .duration(400)
    .EUt(240)
    .buildAndRegister()

CVD.recipeBuilder()
    .inputs(metaitem('wafer.vdmos.step_nine'))
    .fluidInputs(fluid('polysilicon') * 250)
    .outputs(metaitem('wafer.vdmos.step_ten'))
    .cleanroom(CleanroomType.CLEANROOM)
    .duration(100)
    .EUt(240)
    .buildAndRegister()

for (pdopant in PDopants.pdopants) {
    ION_IMPLANTER.recipeBuilder()
        .inputs(metaitem('wafer.vdmos.step_ten') * 16 * pdopant.efficiency)
        .circuitMeta(1)
        .inputs(metaitem(pdopant.metaItemName))
        .outputs(metaitem('wafer.vdmos.step_eleven') * 16 * pdopant.efficiency)
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(300)
        .EUt(60)
        .buildAndRegister()
}

Etchants.generateEtchingRecipes('wafer.vdmos.step_eleven', 'wafer.vdmos.step_twelve', 'CF4', HV, 1, false)

ROASTER.recipeBuilder()
    .inputs(metaitem('wafer.vdmos.step_twelve'))
    .fluidInputs(fluid('oxygen') * 1000)
    .outputs(metaitem('wafer.vdmos.step_thirdteen'))
    .cleanroom(CleanroomType.CLEANROOM)
    .duration(400)
    .EUt(240)
    .buildAndRegister()

CUTTER.recipeBuilder()
    .inputs(metaitem('wafer.vdmos.final')) 
    .fluidInputs(fluid('ultrapurewater') * 1000)
    .outputs(metaitem('die.vdmos') * 32)
    .cleanroom(CleanroomType.CLEANROOM)
    .duration(400)
    .EUt(240)
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('die.vdmos'))
    .inputs(ore('wireFineDumet') * 3)
    .inputs(ore('boltKovar'))
    .fluidInputs(fluid('high_temperature_solder') * 18)
    .outputs(metaitem('component.transistor.vdmos'))
    .cleanroom(CleanroomType.CLEANROOM)
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister();

// IGBT (power electronics)
