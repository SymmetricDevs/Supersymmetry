import static prePostInit.Recipemaps.*
import globals.Globals
import postInit.utils.RecyclingHelper
import static gregtech.api.GTValues.*

mods.gregtech.mixer.removeByInput(480, [metaitem('dustCobalt') * 5, metaitem('dustChrome') * 2, metaitem('dustNickel'),
                                        metaitem('dustMolybdenum'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)

// GRCop-84

mods.gregtech.arc_furnace.removeByInput(30, [metaitem('dustGrcop84')], [fluid('oxygen') * 63])
mods.gregtech.extractor.removeByInput(30, [metaitem('dustGrcop84')], null)

MIXER.recipeBuilder()
        .inputs(metaitem('dustCopper') * 19)
        .inputs(metaitem('dustChrome') * 2)
        .inputs(metaitem('dustNiobium'))
        .outputs(metaitem('dustGrcop84') * 22)
        .duration(5)
        .EUt(VA[HV])
        .buildAndRegister()

// MAR-M246

mods.gregtech.assembler.removeByInput(400, [metaitem('turbineBladeMarM246') * 8, metaitem('stickLongMagnalium')], null)

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('turbineBladeMarM246') * 8)
    .inputs(metaitem('stickLongIncoloy908'))
    .outputs(metaitem('turbine_rotor').withNbt(['GT.PartStats': ['Material': 'susy:mar_m_246']]))
    .duration(1000)
    .EUt(VA[EV])
    .buildAndRegister()


// Secure Maceration Casing
RecyclingHelper.replaceShaped('gcym:casing_large_macerator', item('gcym:large_multiblock_casing') * 2, [
    [ore('plateStelliteJ'), ore('craftingToolHardHammer'), ore('plateStelliteJ')],
    [ore('plateStelliteJ'), ore('frameGtHsla980X'), ore('plateStelliteJ')],
    [ore('plateStelliteJ'), ore('craftingToolWrench'), ore('plateStelliteJ')]])

ASSEMBLER.recipeBuilder()
    .circuitMeta(6)
    .inputs(ore('frameGtHsla980X'))
    .inputs(ore('plateStelliteJ') * 6)
    .outputs(item('gcym:large_multiblock_casing') * 2)
    .duration(50)
    .EUt(16)
    .buildAndRegister()

// Stress Proof Casing
RecyclingHelper.replaceShaped('gcym:casing_stress_proof', item('gcym:large_multiblock_casing', 3) * 2, [
    [ore('plateIncoloy908'), ore('craftingToolHardHammer'), ore('plateIncoloy908')],
    [ore('plateIncoloy908'), ore('frameGtHsla980X'), ore('plateIncoloy908')],
    [ore('plateIncoloy908'), ore('craftingToolWrench'), ore('plateIncoloy908')]])

ASSEMBLER.recipeBuilder()
    .circuitMeta(6)
    .inputs(ore('frameGtHsla980X'))
    .inputs(ore('plateIncoloy908') * 6)
    .outputs(item('gcym:large_multiblock_casing', 3) * 2)
    .duration(50)
    .EUt(16)
    .buildAndRegister()

// Nonconducting Casing
RecyclingHelper.replaceShaped('gcym:casing_nonconducting', item('gcym:large_multiblock_casing', 8) * 2, [
    [ore('plateStellite6'), ore('craftingToolHardHammer'), ore('plateStellite6')],
    [ore('plateStellite6'), ore('frameGtHsla980X'), ore('plateStellite6')],
    [ore('plateStellite6'), ore('craftingToolWrench'), ore('plateStellite6')]])

ASSEMBLER.recipeBuilder()
    .circuitMeta(6)
    .inputs(ore('frameGtHsla980X'))
    .inputs(ore('plateStellite6') * 6)
    .outputs(item('gcym:large_multiblock_casing', 8) * 2)
    .duration(50)
    .EUt(16)
    .buildAndRegister()

// Heat Vent
RecyclingHelper.replaceShaped('gcym:heat_vent', item('gcym:unique_casing', 3) * 2, [
        [ore('stickInconel601'), ore('craftingToolHardHammer'), ore('stickInconel601')],
        [ore('rotorReneN5'), ore('frameGtInconel601'), ore('rotorReneN5')],
        [ore('stickInconel601'), ore('craftingToolWrench'), ore('stickInconel601')]])

ASSEMBLER.recipeBuilder()
        .circuitMeta(6)
        .inputs(ore('frameGtInconel601'))
        .inputs(ore('stickInconel601') * 4)
        .inputs(ore('rotorReneN5') * 2)
        .outputs(item('gcym:unique_casing', 3) * 2)
        .duration(50)
        .EUt(16)
        .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('iron') * 1728)
    .fluidInputs(fluid('nickel') * 1152)
    .inputs(metaitem('dustChrome') * 12)
    .inputs(metaitem('dustManganese'))
    .inputs(metaitem('dustCopper') * 2)
    .inputs(metaitem('dustNiobium'))
    .inputs(metaitem('dustTantalum'))
    .inputs(metaitem('dustMolybdenum') * 2)
    .fluidOutputs(fluid('incoloy_20') * 5616)
    .EUt(VA[EV])
    .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('iron') * 2880)
    .fluidInputs(fluid('nickel') * 2304)
    .inputs(metaitem('dustChrome') * 7)
    .inputs(metaitem('dustManganese'))
    .inputs(metaitem('dustCopper') * 2)
    .inputs(metaitem('dustAluminium'))
    .inputs(metaitem('dustTitanium'))
    .inputs(metaitem('dustMolybdenum') * 2)
    .fluidOutputs(fluid('incoloy_825') * 5616)
    .EUt(VA[EV])
    .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('iron') * 2880)
    .fluidInputs(fluid('nickel') * 4320)
    .inputs(metaitem('dustCobalt'))
    .inputs(metaitem('dustChrome') * 3)
    .inputs(metaitem('dustAluminium'))
    .inputs(metaitem('dustTitanium') * 2)
    .inputs(metaitem('dustTungsten'))
    .inputs(metaitem('dustNiobium') * 2)
    .fluidOutputs(fluid('incoloy_908') * 8640)
    .EUt(VA[EV])
    .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('nickel') * 3168)
    .inputs(metaitem('dustCobalt') * 4)
    .inputs(metaitem('dustChrome') * 3)
    .inputs(metaitem('dustAluminium') * 3)
    .inputs(metaitem('dustTungsten') * 2)
    .inputs(metaitem('dustHafnium'))
    .inputs(metaitem('dustRhenium') * 2)
    .inputs(metaitem('dustTantalum') * 3)
    .fluidOutputs(fluid('rene_n_5') * 5760)
    .EUt(VA[EV])
    .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('cobalt') * 2160)
    .inputs(metaitem('dustIron') * 2)
    .inputs(metaitem('dustNickel') * 2)
    .inputs(metaitem('dustChrome') * 13)
    .inputs(metaitem('dustManganese'))
    .inputs(metaitem('dustTungsten') * 7)
    .fluidOutputs(fluid('stellite_j') * 5760)
    .EUt(VA[EV])
    .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('cobalt') * 3456)
    .inputs(metaitem('dustNickel'))
    .inputs(metaitem('dustChrome') * 10)
    .inputs(metaitem('dustManganese'))
    .inputs(metaitem('dustTungsten') * 3)
    .inputs(metaitem('dustMolybdenum'))
    .fluidOutputs(fluid('stellite_6') * 5760)
    .EUt(VA[EV])
    .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('nickel') * 2736)
    .inputs(metaitem('dustChrome') * 6)
    .inputs(metaitem('dustManganese'))
    .inputs(metaitem('dustIron'))
    .inputs(metaitem('dustAluminium') * 2)
    .inputs(metaitem('dustTitanium'))
    .inputs(metaitem('dustCobalt') * 8)
    .fluidOutputs(fluid('nimonic_105') * 5328)
    .EUt(VA[EV])
    .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('nickel') * 5904)
    .inputs(metaitem('dustIron') * 19)
    .inputs(metaitem('dustChrome') * 20)
    .inputs(metaitem('dustNiobium') * 3)
    .inputs(metaitem('dustMolybdenum') * 2)
    .inputs(metaitem('dustTitanium'))
    .inputs(metaitem('dustAluminium') * 2)
    .fluidOutputs(fluid('inconel_718') * 12672)
    .EUt(VA[EV])
    .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
        .fluidInputs(fluid('nickel') * 8496)
        .inputs(metaitem('dustIron') * 17)
        .inputs(metaitem('dustChrome') * 26)
        .inputs(metaitem('dustAluminium') * 2)
        .inputs(metaitem('dustManganese') * 2)
        .inputs(metaitem('dustCarbon'))
        .inputs(metaitem('dustSilicon'))
        .fluidOutputs(fluid('inconel_601') * 15264)
        .EUt(VA[EV])
        .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
        .inputs(metaitem('dustNimonic105') * 1)
        .fluidOutputs(fluid('molten.nimonic_105') * 144)
        .duration(80)
        .EUt(VA[HV])
        .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
        .inputs(metaitem('dustIncoloy825') * 1)
        .fluidOutputs(fluid('molten.incoloy_825') * 144)
        .duration(80)
        .EUt(VA[HV])
        .buildAndRegister()


INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('iron') * 3456)
    .inputs(metaitem('dustChrome') * 8)
    .inputs(metaitem('dustNickel') * 5)
    .inputs(metaitem('dustMolybdenum') * 2)
    .inputs(metaitem('dustManganese'))
    .fluidOutputs(fluid('food_grade_stainless_steel') * 5760)
    .EUt(VA[EV])
    .buildAndRegister()
    
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('cobalt') * 720)
    .inputs(metaitem('dustChrome') * 2)
    .inputs(metaitem('dustNickel'))
    .inputs(metaitem('dustMolybdenum'))
    .fluidOutputs(fluid('ultimet') * 1296)
    .EUt(VA[EV])
    .buildAndRegister()
/*
    Blocks from GT superalloys need to be removed (block, frame, sheeted frame) and liquids
    Recipes for GCYM casings need to be changed to use SuSy superalloys, currently they still have recipes with old ones
 */
