import globals.Globals

ASSEMBLER = recipemap('assembler')
BR = recipemap('batch_reactor')
FBR = recipemap('fixed_bed_reactor')
REACTION_FURNACE = recipemap('reaction_furnace')
ROASTER = recipemap('roaster')
MIXER = recipemap('mixer')
UV_LIGHT_BOX = recipemap('uv_light_box')

// Acrylic Acid

    // Reppe route
    BR.recipeBuilder()
        .fluidInputs(fluid('butyraldehyde') * 1000)
        .fluidInputs(fluid('formaldehyde') * 3000)
        .fluidInputs(fluid('sodium_hydroxide_solution') * 1000)
        .outputs(metaitem('dustTrimethylolpropane'))
        .fluidOutputs(fluid('wastewater') * 1000)
        .duration(200)
        .EUt(120)
        .buildAndRegister()

    ROASTER.recipeBuilder()
        .inputs(ore('dustCopper'))
        .inputs(ore('dustNickel'))
        .fluidInputs(fluid('bromine') * 4000)
        .outputs(metaitem('dustAcrylicCatalyst'))
        .duration(200)
        .EUt(120)
        .buildAndRegister()

    REACTION_FURNACE.recipeBuilder()
        .notConsumable(ore('dustAcrylicCatalyst'))
        .fluidInputs(fluid('acetylene') * 1000)
        .fluidInputs(fluid('carbon_monoxide') * 1000)
        .fluidInputs(fluid('water') * 1000)
        .fluidOutputs(fluid('acrylic_acid') * 1000)
        .duration(200)
        .EUt(120)
        .buildAndRegister()

    // Propene route
        
        REACTION_FURNACE.recipeBuilder()
            .inputs(ore('dustMolybdenumTrioxide') * 4)
            .inputs(ore('dustVanadiumPentoxide') * 7)
            .inputs(ore('dustAlumina') * 5)
            .outputs(metaitem('dustSupportedMolybdenumVanadium'))
            .duration(200)
            .EUt(120)
            .buildAndRegister()

        FBR.recipeBuilder()
            .notConsumable(ore('dustPhosphomolybdicAcid'))
            .fluidInputs(fluid('propene') * 50)
            .fluidInputs(fluid('oxygen') * 100)
            .fluidOutputs(fluid('acrolein') * 50)
            .fluidOutputs(fluid('dense_steam') * 50)
            .duration(8)
            .EUt(120)
            .buildAndRegister()

        FBR.recipeBuilder()
            .notConsumable(ore('catalystBedSupportedMolybdenumVanadium'))
            .fluidInputs(fluid('acrolein') * 50)
            .fluidInputs(fluid('oxygen') * 50)
            .fluidOutputs(fluid('acrylic_acid') * 50)
            .duration(8)
            .EUt(120)
            .buildAndRegister()

// TMPTA

BR.recipeBuilder()
    .notConsumable(ore('springCupronickel'))
    .notConsumable(fluid('sulfuric_acid') * 1000)
    .inputs(ore('dustTrimethylolpropane'))
    .fluidInputs(fluid('acrylic_acid') * 3000)
    .fluidOutputs(fluid('trimethylolpropane_triacrylate') * 1000)
    .fluidOutputs(fluid('dense_steam') * 3000)
    .duration(200)
    .EUt(120)
    .buildAndRegister()

// UV initiator, Benzenediazonium tetrafluoroborate

BR.recipeBuilder()
    .circuitMeta(1)
    .inputs(ore('dustSodiumNitrite') * 4)
    .fluidInputs(fluid('hydrogen_chloride') * 2000)
    .fluidInputs(fluid('gtfo_aniline') * 1000)
    .outputs(metaitem('dustBenzenediazoniumChloride'))
    .fluidOutputs(fluid('diluted_saltwater') * 2000)
    .duration(200)
    .EUt(120)
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustBenzenediazoniumChloride'))
    .inputs(ore('dustGelatin') * 8)
    .fluidInputs(fluid('trimethylolpropane_triacrylate') * 8000)
    .fluidOutputs(fluid('acrylic_photoemulsion') * 8000)
    .duration(200)
    .EUt(120)
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('foilPlastic'))
    .fluidInputs(fluid('dye_red') * 100)
    .fluidInputs(fluid('acrylic_photoemulsion') * 500)
    .outputs(metaitem('rubylith_film'))
    .duration(200)
    .EUt(120)
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(ore('foilMylar'))
    .inputs(metaitem('rubylith_film'))
    .fluidInputs(fluid('glue') * 100)
    .outputs(metaitem('rubylith'))
    .duration(200)
    .EUt(120)
    .buildAndRegister()

// Early lithography masks

ROASTER.recipeBuilder()
    .inputs(ore('dustSilver'))
    .fluidInputs(fluid('chlorine') * 1000)
    .outputs(metaitem('dustSilverChloride') * 2)
    .duration(100)
    .EUt(30)
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(ore('plateGlass'))
    .inputs(ore('dustGelatin'))
    .inputs(ore('dustSilverChloride'))
    .outputs(metaitem('mask.blank'))
    .duration(200)
    .EUt(7)
    .buildAndRegister()

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
    .EUt(7)
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
    .EUt(7)
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
    .EUt(7)
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
    .EUt(7)
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
    .EUt(7)
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
    .EUt(7)
    .buildAndRegister()

// CrO3 photomasks

REACTION_FURNACE.recipeBuilder()
    .notConsumable(metaitem('shape.mold.plate'))
    .fluidInputs(fluid('silicon_tetrachloride') * 1000)
    .fluidInputs(fluid('oxygen') * 3000)
    .fluidInputs(fluid('hydrogen') * 2000)
    .outputs(metaitem('fused_quartz'))
    .duration(400)
    .EUt(120)
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('fused_quartz'))
    .inputs(ore('dustTinyChromiumTrioxide'))
    .circuitMeta(1)
    .outputs(metaitem('mask.advanced'))
    .duration(200)
    .EUt(120)
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('fused_quartz'))
    .inputs(ore('dustTinyChromiumTrioxide'))
    .circuitMeta(2)
    .outputs(metaitem('mask.nand'))
    .duration(200)
    .EUt(120)
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('fused_quartz'))
    .inputs(ore('dustTinyChromiumTrioxide'))
    .circuitMeta(3)
    .outputs(metaitem('mask.nor'))
    .duration(200)
    .EUt(120)
    .buildAndRegister()
