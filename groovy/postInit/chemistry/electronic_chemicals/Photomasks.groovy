import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

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

crafting.addShaped("rubylith_ram", metaitem('stencil.ram'), [
    [ore('craftingToolKnife'), null, null],
    [null, metaitem('rubylith'), null],
    [null, null, null]
]);

UV_LIGHT_BOX.recipeBuilder()
    .inputs(metaitem('stencil.ram'))
    .inputs(metaitem('mask.blank'))
    .outputs(metaitem('mask.ram'))
    .duration(200)
    .EUt(VA[ULV])
    .buildAndRegister()

crafting.addShaped("rubylith_ic", metaitem('stencil.ic'), [
    [null, ore('craftingToolKnife'), null],
    [null, metaitem('rubylith'), null],
    [null, null, null]
]);

UV_LIGHT_BOX.recipeBuilder()
    .inputs(metaitem('stencil.ic'))
    .inputs(metaitem('mask.blank'))
    .outputs(metaitem('mask.ic'))
    .duration(200)
    .EUt(VA[ULV])
    .buildAndRegister()

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

crafting.addShaped("rubylith_ulpic", metaitem('stencil.ulpic'), [
    [null, null, null],
    [ore('craftingToolKnife'), metaitem('rubylith'), null],
    [null, null, null]
]);

UV_LIGHT_BOX.recipeBuilder()
    .inputs(metaitem('stencil.ulpic'))
    .inputs(metaitem('mask.blank'))
    .outputs(metaitem('mask.ulpic'))
    .duration(200)
    .EUt(VA[ULV])
    .buildAndRegister()

crafting.addShaped("rubylith_lpic", metaitem('stencil.lpic'), [
    [null, null, null],
    [null, metaitem('rubylith'), ore('craftingToolKnife')],
    [null, null, null]
]);

UV_LIGHT_BOX.recipeBuilder()
    .inputs(metaitem('stencil.lpic'))
    .inputs(metaitem('mask.blank'))
    .outputs(metaitem('mask.lpic'))
    .duration(200)
    .EUt(VA[ULV])
    .buildAndRegister()

crafting.addShaped("rubylith_cpu", metaitem('stencil.cpu'), [
    [null, null, null],
    [null, metaitem('rubylith'), null],
    [ore('craftingToolKnife'), null, null]
]);

UV_LIGHT_BOX.recipeBuilder()
    .inputs(metaitem('stencil.cpu'))
    .inputs(metaitem('mask.blank'))
    .outputs(metaitem('mask.cpu'))
    .duration(200)
    .EUt(VA[ULV])
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

// CrO3 photomasks

REACTION_FURNACE.recipeBuilder()
    .notConsumable(metaitem('shape.mold.plate'))
    .fluidInputs(fluid('purified_silicon_tetrachloride') * 1000)
    .fluidInputs(fluid('oxygen') * 3000)
    .fluidInputs(fluid('hydrogen') * 2000)
    .outputs(metaitem('fused_quartz'))
    .duration(400)
    .EUt(VA[MV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('fused_quartz'))
    .inputs(ore('dustTinyChromiumTrioxide'))
    .circuitMeta(1)
    .outputs(metaitem('mask.advanced'))
    .duration(200)
    .EUt(VA[MV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('fused_quartz'))
    .inputs(ore('dustTinyChromiumTrioxide'))
    .circuitMeta(2)
    .outputs(metaitem('mask.nand'))
    .duration(200)
    .EUt(VA[MV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('fused_quartz'))
    .inputs(ore('dustTinyChromiumTrioxide'))
    .circuitMeta(3)
    .outputs(metaitem('mask.nor'))
    .duration(200)
    .EUt(VA[MV])
    .buildAndRegister()
