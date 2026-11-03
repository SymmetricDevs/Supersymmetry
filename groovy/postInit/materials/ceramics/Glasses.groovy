import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// GLASS DUST <-> MOLE CONVENTION: EACH DUST ~ 1 MOLE OF NON-OXYGEN ATOMS (Si, Al, B, K, Na, Ca, Mg, Pb, Bi, Te)

// Quartz Sand * 1
mods.gregtech.macerator.removeByInput(2, [item('minecraft:sand')], null)
crafting.remove("gregtech:quartz_sand")

// Slag glass (decorative)

ALLOY_SMELTER.recipeBuilder()
    .inputs(item('pyrotech:slag') * 9)
    .notConsumable(metaitem('shape.mold.block'))
    .outputs(item('pyrotech:slag_glass'))
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister();

ALLOY_SMELTER.recipeBuilder()
    .inputs(item('pyrotech:pile_slag'))
    .notConsumable(metaitem('shape.mold.block'))
    .outputs(item('pyrotech:slag_glass'))
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister();

// Potash-lime glass

MIXER.recipeBuilder()
    .circuitMeta(1)
    .inputs(ore('dustSilicaSource') * 8)
    .inputs(ore('dustPotassiumCarbonate') * 3)
    .inputs(ore('dustLimestone'))
    .outputs(metaitem('dustPotashLimeGlassBlend') * 10)
    .duration(160)
    .EUt(VA[ULV])
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustGlass') * 3)
    .inputs(ore('dustSilicaSource') * 8)
    .inputs(ore('dustPotassiumCarbonate') * 3)
    .inputs(ore('dustLimestone'))
    .outputs(metaitem('dustPotashLimeGlassBlend') * 13)
    .duration(160)
    .EUt(VA[ULV])
    .buildAndRegister()

crafting.addShapeless(metaitem('dustPotashLimeGlassBlend') * 2, [ore('dustSilicaSource'), ore('dustSilicaSource'), ore('dustSmallPotassiumCarbonate'), ore('dustSmallPotassiumCarbonate'), ore('dustSmallPotassiumCarbonate'), ore('dustSmallLimestone')])

PRIMITIVE_SMELTER.recipeBuilder()
    .notConsumable(metaitem('shape.mold.block'))
    .inputs(ore('gemCharcoal') * 4)
    .inputs(metaitem('dustPotashLimeGlassBlend') * 16)
    .outputs(item('minecraft:glass') * 4)
    .duration(320)
    .buildAndRegister()

// Soda-lime glass

MIXER.recipeBuilder()
    .circuitMeta(1)
    .inputs(ore('dustSilicaSource') * 6)
    .inputs(ore('dustSodaAsh') * 4)
    .inputs(ore('dustTinyLimestone') * 6)
    .inputs(ore('dustTinyDolomite') * 3)
    .inputs(ore('dustTinyFeldspar'))
    .outputs(metaitem('dustSodaLimeGlassBlend') * 9)
    .duration(160)
    .EUt(VA[ULV])
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustGlass') * 3)
    .inputs(ore('dustSilicaSource') * 6)
    .inputs(ore('dustSodaAsh') * 4)
    .inputs(ore('dustTinyLimestone') * 6)
    .inputs(ore('dustTinyDolomite') * 3)
    .inputs(ore('dustTinyFeldspar'))
    .outputs(metaitem('dustSodaLimeGlassBlend') * 12)
    .duration(160)
    .EUt(VA[ULV])
    .buildAndRegister()

PRIMITIVE_SMELTER.recipeBuilder()
    .notConsumable(metaitem('shape.mold.block'))
    .inputs(ore('gemCharcoal') * 4)
    .inputs(metaitem('dustSodaLimeGlassBlend') * 16)
    .outputs(item('minecraft:glass') * 4)
    .duration(160)
    .buildAndRegister()

ERF.recipeBuilder()
    .inputs(ore('dustSodaLimeGlassBlend') * 16)
    .fluidOutputs(fluid('soda_lime_glass') * 2304)
    .temperature(1900)
    .duration(80)
    .EUt(VA[MV])
    .buildAndRegister()

SOLIDIFIER.recipeBuilder()
    .notConsumable(metaitem('shape.mold.block'))
    .fluidInputs(fluid('soda_lime_glass') * 144)
    .outputs(item('minecraft:glass'))
    .duration(20)
    .EUt(VA[MV])
    .buildAndRegister()

// Tempered glass

QUENCHER.recipeBuilder()
    .notConsumable(metaitem('shape.mold.block'))
    .fluidInputs(fluid('soda_lime_glass') * 144)
    .fluidInputs(fluid('hp_air') * 50)
    .outputs(item('gregtech:transparent_casing:0'))
    .duration(40)
    .EUt(VA[MV])
    .buildAndRegister()

// Glass fibers

    // Bushings

    ASSEMBLER.recipeBuilder()
        .inputs(metaitem('plateStainlessSteel') * 4)
        .notConsumable(metaitem('toolHeadDrillVanadiumSteel'))
        .outputs(metaitem('stainless_steel_bushing'))
        .circuitMeta(3)
        .EUt(VA[MV])
        .duration(200)
        .buildAndRegister()

    ASSEMBLER.recipeBuilder()
        .inputs(metaitem('plateStainlessSteel') * 4)
        .notConsumable(metaitem('toolHeadDrillHardenedTitanium'))
        .outputs(metaitem('stainless_steel_bushing'))
        .circuitMeta(3)
        .EUt(VA[MV])
        .duration(200)
        .buildAndRegister()

    ASSEMBLER.recipeBuilder()
        .inputs(metaitem('platePlatinum') * 4)
        .notConsumable(metaitem('toolHeadDrillVanadiumSteel'))
        .outputs(metaitem('platinum_bushing'))
        .circuitMeta(3)
        .EUt(VA[MV])
        .duration(200)
        .buildAndRegister()

    ASSEMBLER.recipeBuilder()
        .inputs(metaitem('platePlatinum') * 4)
        .notConsumable(metaitem('toolHeadDrillHardenedTitanium'))
        .outputs(metaitem('platinum_bushing'))
        .circuitMeta(3)
        .EUt(VA[MV])
        .duration(200)
        .buildAndRegister()

    ASSEMBLER.recipeBuilder()
        .inputs(metaitem('platePlatinumRhodium') * 4)
        .notConsumable(metaitem('toolHeadDrillVanadiumSteel'))
        .outputs(metaitem('platinum_rhodium_bushing'))
        .circuitMeta(3)
        .EUt(VA[MV])
        .duration(200)
        .buildAndRegister()

    ASSEMBLER.recipeBuilder()
        .inputs(metaitem('platePlatinumRhodium') * 4)
        .notConsumable(metaitem('toolHeadDrillHardenedTitanium'))
        .outputs(metaitem('platinum_rhodium_bushing'))
        .circuitMeta(3)
        .EUt(VA[MV])
        .duration(200)
        .buildAndRegister()

    // E-glass

    MIXER.recipeBuilder()
        .inputs(ore('dustSilicaSource') * 7)
        .inputs(ore('dustLimestone') * 3)
        .inputs(ore('dustAlumina') * 5)
        .inputs(ore('dustBoronTrioxide') * 5)
        .inputs(ore('dustMagnesia') * 2)
        .outputs(metaitem('dustEGlassBlend') * 15)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister()

    ERF.recipeBuilder()
        .inputs(ore('dustEGlassBlend') * 16)
        .fluidOutputs(fluid('e_glass') * 2304)
        .temperature(1900)
        .duration(80)
        .EUt(VA[MV])
        .buildAndRegister()

    EXTRUDER.recipeBuilder()
        .notConsumable(metaitem('platinum_bushing'))
        .fluidInputs(fluid('e_glass') * 288)
        .outputs(metaitem('glass_fibers'))
        .EUt(VA[MV])
        .duration(35)
        .buildAndRegister()

    EXTRUDER.recipeBuilder()
        .notConsumable(metaitem('platinum_rhodium_bushing'))
        .fluidInputs(fluid('e_glass') * 144)
        .outputs(metaitem('glass_fibers'))
        .EUt(VA[MV])
        .duration(10)
        .buildAndRegister()

    // S-glass

    MIXER.recipeBuilder()
        .inputs(ore('dustSilicaSource') * 5)
        .inputs(ore('dustAlumina') * 5)
        .inputs(ore('dustMagnesia') * 2)
        .outputs(metaitem('dustSGlassBlend') * 8)
        .duration(320)
        .EUt(VA[MV])
        .buildAndRegister()

    ERF.recipeBuilder()
        .inputs(ore('dustSGlassBlend') * 16)
        .fluidOutputs(fluid('s_glass') * 2304)
        .temperature(1900)
        .duration(80)
        .EUt(VA[MV])
        .buildAndRegister()

    EXTRUDER.recipeBuilder()
        .notConsumable(metaitem('platinum_bushing'))
        .fluidInputs(fluid('s_glass') * 288)
        .outputs(metaitem('s_glass_fibers'))
        .duration(35)
        .EUt(VA[MV])
        .buildAndRegister()

    EXTRUDER.recipeBuilder()
        .notConsumable(metaitem('platinum_rhodium_bushing'))
        .fluidInputs(fluid('s_glass') * 144)
        .outputs(metaitem('s_glass_fibers'))
        .duration(10)
        .EUt(VA[MV])
        .buildAndRegister()

// Quartz glass: flame hydrolysis of SiCl4 followed by consolidation in a block mold

REACTION_FURNACE.recipeBuilder()
    .notConsumable(metaitem('shape.mold.block'))
    .fluidInputs(fluid('silicon_tetrachloride') * 2000)
    .fluidInputs(fluid('hydrogen') * 8000)
    .fluidInputs(fluid('oxygen') * 4000)
    .outputs(item('appliedenergistics2:quartz_glass'))
    .fluidOutputs(fluid('hydrogen_chloride') * 8000)
    .duration(35)
    .EUt(VA[MV])
    .buildAndRegister()

// Vibrant glass: phosphorescent quartz glass

ERF.recipeBuilder()
    .inputs(ore('dustSilicaSource') * 15)
    .inputs(metaitem('dustZincSulfide') * 2)
    .inputs(metaitem('dustTinyCopper') * 1)
    .outputs(item('appliedenergistics2:quartz_vibrant_glass') * 15)
    .blastFurnaceTemp(1400)
    .duration(1200)
    .EUt(60)
    .buildAndRegister()

ERF.recipeBuilder()
    .inputs(ore('dustSilicaSource') * 64)
    .inputs(metaitem('dustStrontiumOxide') * 2) // strontium aluminate, should be doped with Eu but that would be way too expensive (and doesn't fit)
    .inputs(metaitem('dustAlumina') * 5)
    .outputs(item('appliedenergistics2:quartz_vibrant_glass') * 64)
    .blastFurnaceTemp(1400)
    .duration(1200)
    .EUt(60)
    .buildAndRegister()

// Laminated glass

FORMING_PRESS.recipeBuilder()
    .inputs(item('gregtech:transparent_casing') * 2)
    .inputs(ore('platePolyvinylButyral') * 2)
    .inputs(ore('platePolycarbonate') * 2)
    .outputs(item('gregtech:transparent_casing', 2))
    .duration(200)
    .EUt(VA[HV])
    .buildAndRegister();

// Tellurite glass

MIXER.recipeBuilder()
    .inputs(ore('dustTelluriumDioxide') * 20)
    .inputs(ore('dustLeadIiOxide') * 12)
    .inputs(ore('dustBismuthIiiOxide'))
    .inputs(ore('dustBoronTrioxide') * 2)
    .outputs(metaitem('dustTelluriteGlassBlend') * 13)
    .duration(320)
    .EUt(VA[MV])
    .buildAndRegister()

RESISTANCE_FURNACE.recipeBuilder()
    .inputs(ore('dustTelluriteGlass'))
    .notConsumable(item('susy:crucible', 1))
    .fluidOutputs(fluid('tellurite_glass') * 144)
    .temperature(1000)
    .duration(20)
    .EUt(VA[MV])
    .buildAndRegister()

QUENCHER.recipeBuilder()
    .fluidInputs(fluid('tellurite_glass') * 144)
    .fluidInputs(fluid('ultrapure_water') * 50)
    .outputs(metaitem('dustTelluriteGlass'))
    .duration(20)
    .EUt(VA[MV])
    .buildAndRegister()

// Glass fibers

MIXER.recipeBuilder()
    .inputs(ore('dustSiliconDioxide') * 3)
    .fluidInputs(fluid('sulfuric_acid') * 10)
    .outputs(metaitem('dustAcidWashedSiliconDioxide') * 3)
    .duration(10)
    .EUt(VA[LV])
    .buildAndRegister()