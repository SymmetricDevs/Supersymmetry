import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*
import globals.semiconductors.Deposition
import gregtech.api.metatileentity.multiblock.CleanroomType

// Early lithography masks

BR.recipeBuilder()
    .inputs(ore('dustGelatin'))
    .fluidInputs(fluid('silver_nitrate_solution') * 1000)
    .fluidInputs(fluid('sodium_bromide_solution') * 1000)
    .fluidOutputs(fluid('photographic_emulsion') * 2000)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(ore('plateGlass'))
    .fluidInputs(fluid('photographic_emulsion') * 500)
    .outputs(metaitem('mask.blank'))
    .duration(200)
    .EUt(VA[ULV])
    .buildAndRegister()

// Rubylith masking film

ASSEMBLER.recipeBuilder()
    .inputs(ore('dustGelatin'))
    .fluidInputs(fluid('dye_red') * 50)
    .fluidInputs(fluid('distilled_water') * 1000)
    .outputs(metaitem('rubylith_film'))
    .duration(200)
    .EUt(VA[MV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(ore('foilMylar'))
    .inputs(metaitem('rubylith_film'))
    .inputs(ore('foilPlastic'))
    .outputs(metaitem('rubylith'))
    .duration(200)
    .EUt(VA[HV])
    .buildAndRegister()

// Early circuit stencils

crafting.addShaped("rubylith_pcb", metaitem('stencil.pcb'), [
    [null, null, ore('craftingToolKnife')],
    [null, metaitem('rubylith'), null],
    [null, null, null]
]);

UV_LIGHT_BOX.recipeBuilder()
    .inputs(metaitem('stencil.pcb'))
    .inputs(metaitem('mask.blank'))
    .outputs(metaitem('mask.pcb'))
    .duration(200)
    .EUt(VA[ULV])
    .buildAndRegister()


CUTTER.recipeBuilder()
    .circuitMeta(3)
    .inputs(metaitem('rubylith'))
    .outputs(metaitem('stencil.pcb'))
    .duration(40)
    .EUt(VA[MV])
    .buildAndRegister()


crafting.addShaped("smd_resistor", metaitem('stencil.resistor'), [
    [metaitem('rubylith'), ore('craftingToolKnife'), null],
    [null, null, null],
    [null, null, null]
]);

UV_LIGHT_BOX.recipeBuilder()
    .inputs(metaitem('stencil.resistor'))
    .inputs(metaitem('mask.blank'))
    .outputs(metaitem('mask.resistor'))
    .duration(200)
    .EUt(VA[ULV])
    .buildAndRegister()


crafting.addShaped("smd_capacitor", metaitem('stencil.capacitor'), [
    [metaitem('rubylith'), null, ore('craftingToolKnife')],
    [null, null, null],
    [null, null, null]
]);

crafting.addShaped("smd_resistor_pads", metaitem('stencil.resistor_pads'), [
    [metaitem('rubylith'), null, null],
    [ore('craftingToolKnife'), null, null],
    [null, null, null]
]);

crafting.addShaped("rubylith_signal_mosfet", metaitem('stencil.signal_mosfet'), [
    [metaitem('rubylith'), null, null],
    [null, ore('craftingToolKnife'), null],
    [null, null, null]
]);

crafting.addShaped("rubylith_nmos_cpu", metaitem('stencil.nmos_cpu'), [
    [metaitem('rubylith'), null, null],
    [null, null, ore('craftingToolKnife')],
    [null, null, null]
]);

crafting.addShaped("rubylith_nmos_sram", metaitem('stencil.nmos_sram'), [
    [metaitem('rubylith'), null, null],
    [null, null, null],
    [ore('craftingToolKnife'), null, null]
]);

crafting.addShaped("rubylith_nmos_mask_rom", metaitem('stencil.nmos_mask_rom'), [
    [metaitem('rubylith'), null, null],
    [null, null, null],
    [null, ore('craftingToolKnife'), null]
]);

crafting.addShaped("rubylith_nmos_bus_controller", metaitem('stencil.nmos_bus_controller'), [
    [metaitem('rubylith'), null, null],
    [null, null, null],
    [null, null, ore('craftingToolKnife')]
]);

crafting.addShaped("rubylith_nmos_dram", metaitem('stencil.nmos_dram'), [
    [ore('craftingToolKnife'), metaitem('rubylith'), null],
    [null, null, null],
    [null, null, null]
]);

crafting.addShaped("rubylith_power_diode", metaitem('stencil.diode.power'), [
    [null, metaitem('rubylith'), ore('craftingToolKnife')],
    [null, null, null],
    [null, null, null]
]);

crafting.addShaped("rubylith_schottky_diode", metaitem('stencil.diode.schottky'), [
    [null, metaitem('rubylith'), null],
    [ore('craftingToolKnife'), null, null],
    [null, null, null]
]);

crafting.addShaped("rubylith_thyristor", metaitem('stencil.thyristor'), [
    [null, metaitem('rubylith'), null],
    [null, ore('craftingToolKnife'), null],
    [null, null, null]
]);

crafting.addShaped("rubylith_bjt_pic_base", metaitem('stencil.bjt_pic_base'), [
    [null, metaitem('rubylith'), null],
    [null, null, ore('craftingToolKnife')],
    [null, null, null]
]);

crafting.addShaped("rubylith_bjt_ulpic", metaitem('stencil.bjt_ulpic'), [
    [null, metaitem('rubylith'), null],
    [null, null, null],
    [ore('craftingToolKnife'), null, null]
]);

crafting.addShaped("rubylith_bjt_lpic", metaitem('stencil.bjt_lpic'), [
    [null, metaitem('rubylith'), null],
    [null, null, null],
    [null, ore('craftingToolKnife'), null]
]);

crafting.addShaped("rubylith_bjt_pic", metaitem('stencil.bjt_pic'), [
    [null, metaitem('rubylith'), null],
    [null, null, null],
    [null, null, ore('craftingToolKnife')]
]);

crafting.addShaped("rubylith_nmos_uart", metaitem('stencil.nmos_uart'), [
    [ore('craftingToolKnife'), null, metaitem('rubylith')],
    [null, null, null],
    [null, null, null]
]);

crafting.addShaped("rubylith_photodiode", metaitem('stencil.photodiode'), [
    [null, ore('craftingToolKnife'), metaitem('rubylith')],
    [null, null, null],
    [null, null, null]
]);

crafting.addShaped("rubylith_monosilicon_photovoltaic", metaitem('stencil.monosilicon_photovoltaic'), [
    [null, null, metaitem('rubylith')],
    [ore('craftingToolKnife'), null, null],
    [null, null, null]
]);

crafting.addShaped("rubylith_diode_planar", metaitem('stencil.diode.planar'), [
    [null, null, metaitem('rubylith')],
    [null, ore('craftingToolKnife'), null],
    [null, null, null]
]);

[
    ['signal_mosfet', 7],
    ['nmos_cpu', 5],
    ['nmos_sram', 5],
    ['nmos_uart', 5],
    ['nmos_mask_rom', 5],
    ['nmos_bus_controller', 5],
    ['nmos_dram', 4],
    ['diode.power', 2],
    ['diode.schottky', 3],
    ['thyristor', 3],
    ['bjt_pic_base', 4],
    ['bjt_ulpic', 1],
    ['bjt_lpic', 4],
    ['bjt_pic', 3],
].each { name, maskCount ->
    UV_LIGHT_BOX.recipeBuilder()
        .inputs(metaitem('stencil.' + name))
        .inputs(metaitem('mask.blank') * maskCount)
        .outputs(metaitem('mask_set.' + name))
        .duration(200 * maskCount)
        .EUt(VA[ULV])
        .buildAndRegister()
}

// Single-use rubylith masks
UV_LIGHT_BOX.recipeBuilder()
        .inputs(metaitem('stencil.photodiode'))
        .inputs(metaitem('mask.blank'))
        .outputs(metaitem('mask.photodiode'))
        .duration(200)
        .EUt(VA[ULV])
        .buildAndRegister()

UV_LIGHT_BOX.recipeBuilder()
    .inputs(metaitem('stencil.diode.planar'))
    .inputs(metaitem('mask.blank'))
    .outputs(metaitem('mask.diode.planar'))
    .duration(200)
    .EUt(VA[ULV])
    .buildAndRegister()

UV_LIGHT_BOX.recipeBuilder()
    .inputs(metaitem('stencil.monosilicon_photovoltaic'))
    .inputs(metaitem('mask.blank'))
    .outputs(metaitem('mask.monosilicon_photovoltaic'))
    .duration(200)
    .EUt(VA[ULV])
    .buildAndRegister()

// Cr2O3 photomasks

REACTION_FURNACE.recipeBuilder()
    .notConsumable(metaitem('shape.mold.plate'))
    .fluidInputs(fluid('purified_silicon_tetrachloride') * 1000)
    .fluidInputs(fluid('oxygen') * 3000)
    .fluidInputs(fluid('hydrogen') * 2000)
    .outputs(metaitem('fused_quartz'))
    .duration(400)
    .EUt(VA[MV])
    .buildAndRegister()


    //Sources:  https://patents.google.com/patent/US6562549B2/en
    //          https://patents.google.com/patent/US7220531B2/en
    //          https://www.sciencedirect.com/science/article/abs/pii/S0040609096089419
    //          https://www.microresist.de/?jet_download=1bc56435506f1a3777a26aedb80b8e53690954bd
    //          https://nanolithography.gatech.edu/pmma.html
Deposition.generateSputteringRecipe('fused_quartz', 'mask.blank.chromium', 400, 'chromium')

SPUTTERING.recipeBuilder()
    .inputs(metaitem('mask.blank.chromium'))
    .inputs(metaitem('target.chromium'))
    .fluidInputs(fluid('argon') * 100)
    .fluidInputs(fluid('oxygen') * 25)
    .outputs(metaitem('mask.blank.chromium_oxide'))
    .duration(100)
    .EUt(VA[HV])
    .cleanroom(CleanroomType.CLEANROOM)
    .buildAndRegister()

RESIST_PROCESSOR.recipeBuilder()
    .inputs(metaitem('mask.blank.chromium_oxide'))
    .fluidInputs(fluid('hydrogen_silsesquioxane_photoresist') * 50)
    .outputs(metaitem('mask.blank.chromium_oxide.wet'))
    .duration(200)
    .EUt(VA[EV])
    .cleanroom(CleanroomType.CLEANROOM)
    .buildAndRegister()

DRYER.recipeBuilder()
    .inputs(metaitem('mask.blank.chromium_oxide.wet'))
    .outputs(metaitem('mask.blank.chromium_oxide.coated'))
    .duration(200)
    .EUt(VA[HV])
    .cleanroom(CleanroomType.CLEANROOM)
    .buildAndRegister()


[   //E-Beam Mask Sets
    ['cmos_cpu', 21, 1],
    ['cmos_gpu', 21, 2],
    ['cmos_chipset', 21, 3],
    ['cmos_phy', 21, 4],
    ['vdmos', 6, 5],
    ['bcd_base', 19, 6],
    ['bcd_lpic', 3, 7],
    ['bcd_pic', 4, 8],
    ['bcd_hpic', 5, 9]
].each { name, maskCount, circuit ->
    LASER_ENGRAVER.recipeBuilder()
        .circuitMeta(circuit)
        .inputs(metaitem('mask.blank.chromium_oxide.coated') * maskCount)
        .outputs(metaitem('mask_set.' + name + '.exposed'))
        .duration(1000 * maskCount)
        .EUt(VA[EV])
        .cleanroom(CleanroomType.CLEANROOM)
        .buildAndRegister()

    RESIST_PROCESSOR.recipeBuilder()
        .inputs(metaitem('mask_set.' + name + '.exposed'))
        .fluidInputs(fluid('methyl_isobutyl_ketone') * (25 * maskCount))
        .fluidInputs(fluid('isopropyl_alcohol') * (75 * maskCount))
        .outputs(metaitem('mask_set.' + name + '.developed'))
        .duration(200 * maskCount)
        .EUt(VA[EV])
        .cleanroom(CleanroomType.CLEANROOM)
        .buildAndRegister()

    REACTIVE_ION_ETCHER.recipeBuilder()
        .inputs(metaitem('mask_set.' + name + '.developed'))
        .fluidInputs(fluid('chlorine') * (75 * maskCount))
        .fluidInputs(fluid('oxygen') * (25 * maskCount))
        .outputs(metaitem('mask_set.' + name + '.etched'))
        .fluidOutputs(fluid('corrosive_gas') * (100 * maskCount))
        .duration(200 * maskCount)
        .EUt(VA[EV])
        .cleanroom(CleanroomType.CLEANROOM)
        .buildAndRegister()

    RESIST_PROCESSOR.recipeBuilder()
        .inputs(metaitem('mask_set.' + name + '.etched'))
        .fluidInputs(fluid('n_methyl_two_pyrrolidone') * (100 * maskCount))
        .fluidInputs(fluid('isopropyl_alcohol') * (50 * maskCount))
        .outputs(metaitem('mask_set.' + name))
        .duration(400 * maskCount)
        .EUt(VA[HV])
        .cleanroom(CleanroomType.CLEANROOM)
        .buildAndRegister()
}

[   //E-Beam Mask Singles
    ['substrate_ev', 1, 10],
    ['multijunction_photovoltaic', 1, 11]
].each { name, maskCount, circuit ->
    LASER_ENGRAVER.recipeBuilder()
        .circuitMeta(circuit)
        .inputs(metaitem('mask.blank.chromium_oxide.coated') * maskCount)
        .outputs(metaitem('mask.' + name + '.exposed'))
        .duration(1000 * maskCount)
        .EUt(VA[EV])
        .cleanroom(CleanroomType.CLEANROOM)
        .buildAndRegister()

    RESIST_PROCESSOR.recipeBuilder()
        .inputs(metaitem('mask.' + name + '.exposed'))
        .fluidInputs(fluid('methyl_isobutyl_ketone') * (25 * maskCount))
        .fluidInputs(fluid('isopropyl_alcohol') * (75 * maskCount))
        .outputs(metaitem('mask.' + name + '.developed'))
        .duration(200 * maskCount)
        .EUt(VA[EV])
        .cleanroom(CleanroomType.CLEANROOM)
        .buildAndRegister()

    REACTIVE_ION_ETCHER.recipeBuilder()
        .inputs(metaitem('mask.' + name + '.developed'))
        .fluidInputs(fluid('chlorine') * (75 * maskCount))
        .fluidInputs(fluid('oxygen') * (25 * maskCount))
        .outputs(metaitem('mask.' + name + '.etched'))
        .fluidOutputs(fluid('corrosive_gas') * (100 * maskCount))
        .duration(200 * maskCount)
        .EUt(VA[EV])
        .cleanroom(CleanroomType.CLEANROOM)
        .buildAndRegister()

    RESIST_PROCESSOR.recipeBuilder()
        .inputs(metaitem('mask.' + name + '.etched'))
        .fluidInputs(fluid('n_methyl_two_pyrrolidone') * (100 * maskCount))
        .fluidInputs(fluid('isopropyl_alcohol') * (50 * maskCount))
        .outputs(metaitem('mask.' + name))
        .duration(2000 * maskCount)
        .EUt(VA[HV])
        .cleanroom(CleanroomType.CLEANROOM)
        .buildAndRegister()
}