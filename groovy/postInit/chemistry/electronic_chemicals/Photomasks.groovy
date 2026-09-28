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
