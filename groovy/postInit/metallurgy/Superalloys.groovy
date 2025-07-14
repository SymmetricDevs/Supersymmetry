import globals.Globals
import postInit.utils.RecyclingHelper

ASSEMBLER = recipemap('assembler')
static def removeItemsOfAlloy(String itemCategory) {
    mods.jei.ingredient.removeAndHide(metaitem('ingot' + itemCategory));
    mods.jei.ingredient.removeAndHide(metaitem('ingotHot' + itemCategory));
    mods.jei.ingredient.removeAndHide(metaitem('dust' + itemCategory));
    mods.jei.ingredient.removeAndHide(metaitem('dustSmall' + itemCategory));
    mods.jei.ingredient.removeAndHide(metaitem('dustTiny' + itemCategory));
    mods.jei.ingredient.removeAndHide(metaitem('plate' + itemCategory));
    mods.jei.ingredient.removeAndHide(metaitem('stick' + itemCategory));
    mods.jei.ingredient.removeAndHide(metaitem('nugget' + itemCategory));
}

static def removeItemsOfAlloyNoRod(String itemCategory) {
    mods.jei.ingredient.removeAndHide(metaitem('ingot' + itemCategory));
    mods.jei.ingredient.removeAndHide(metaitem('ingotHot' + itemCategory));
    mods.jei.ingredient.removeAndHide(metaitem('dust' + itemCategory));
    mods.jei.ingredient.removeAndHide(metaitem('dustSmall' + itemCategory));
    mods.jei.ingredient.removeAndHide(metaitem('dustTiny' + itemCategory));
    mods.jei.ingredient.removeAndHide(metaitem('plate' + itemCategory));
    mods.jei.ingredient.removeAndHide(metaitem('nugget' + itemCategory));
}

removeItemsOfAlloy('HastelloyC276');
removeItemsOfAlloy('HastelloyX');
removeItemsOfAlloy('IncoloyMa956');
removeItemsOfAlloy('MaragingSteel300');
removeItemsOfAlloy('WatertightSteel');
removeItemsOfAlloyNoRod('Stellite100');
removeItemsOfAlloyNoRod('Zeron100');

mods.jei.ingredient.removeAndHide(metaitem('ingotHslaSteel'));
mods.jei.ingredient.removeAndHide(metaitem('dustHslaSteel'));
mods.jei.ingredient.removeAndHide(metaitem('dustSmallHslaSteel'));
mods.jei.ingredient.removeAndHide(metaitem('dustTinyHslaSteel'));
mods.jei.ingredient.removeAndHide(metaitem('plateHslaSteel'));
mods.jei.ingredient.removeAndHide(metaitem('stickHslaSteel'));
mods.jei.ingredient.removeAndHide(metaitem('nuggetHslaSteel'));
mods.jei.ingredient.removeAndHide(metaitem('springHslaSteel'));
mods.jei.ingredient.removeAndHide(metaitem('stickLongHslaSteel'));
mods.jei.ingredient.removeAndHide(metaitem('plateDoubleHslaSteel'));

mods.gregtech.mixer.removeByInput(480, [metaitem('dustCobalt') * 5, metaitem('dustChrome') * 2, metaitem('dustNickel'),
                                        metaitem('dustMolybdenum'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)
mods.gregtech.mixer.removeByInput(480, [metaitem('dustInvar') * 2, metaitem('dustVanadium'), metaitem('dustTitanium'),
                                        metaitem('dustMolybdenum'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)
mods.gregtech.assembler.removeByInput(16, [metaitem('plateHslaSteel') * 4, metaitem('plateTitaniumCarbide') * 2,
                                           metaitem('frameTungstenCarbide'), metaitem('circuit.integrated').withNbt(["Configuration": 6])], null)
mods.gregtech.assembler.removeByInput(16, [metaitem('plateZeron100') * 6, metaitem('frameTitanium'),
                                           metaitem('circuit.integrated').withNbt(["Configuration": 6])], null)
mods.gregtech.assembler.removeByInput(16, [metaitem('plateStellite100') * 6, metaitem('frameTungsten'),
                                           metaitem('circuit.integrated').withNbt(["Configuration": 6])], null)
mods.gregtech.assembler.removeByInput(16, [metaitem('plateMaragingSteel300') * 6, metaitem('frameStainlessSteel'),
                                           metaitem('circuit.integrated').withNbt(["Configuration": 6])], null)
mods.gregtech.assembler.removeByInput(16, [metaitem('plateCobaltBrass') * 6, metaitem('gcym:frameHslaSteel'),
                                           metaitem('circuit.integrated').withNbt(['Configuration': 6])], null)
mods.gregtech.assembler.removeByInput(16, [metaitem('plateWatertightSteel') * 6, metaitem('gcym:frameWatertightSteel'),
                                           metaitem('circuit.integrated').withNbt(["Configuration": 6])], null)
mods.gregtech.assembler.removeByInput(16, [metaitem('plateIncoloyMa956') * 6, metaitem('gcym:frameIncoloyMa956'),
                                           metaitem('circuit.integrated').withNbt(["Configuration": 6])], null)
mods.gregtech.assembler.removeByInput(16, [metaitem('plateHastelloyC276') * 6, metaitem('gcym:frameHastelloyC276'),
                                           metaitem('circuit.integrated').withNbt(["Configuration": 6])], null)
mods.gregtech.assembler.removeByInput(16, [metaitem('plateHslaSteel') * 6, metaitem('gcym:frameHslaSteel'),
                                           metaitem('circuit.integrated').withNbt(["Configuration": 6])], null)
mods.gregtech.assembler.removeByInput(16, [metaitem('plateHastelloyX') * 6, metaitem('gcym:frameMaragingSteel300'),
                                           metaitem('circuit.integrated').withNbt(["Configuration": 6])], null)
mods.gregtech.assembler.removeByInput(16, [metaitem('plateTitaniumTungstenCarbide') * 6, metaitem('frameTitanium'),
                                           metaitem('circuit.integrated').withNbt(["Configuration": 6])], null)


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

// High Temperature Casing
RecyclingHelper.replaceShaped('gcym:casing_high_temperature', item('gcym:large_multiblock_casing', 1) * 2, [
    [ore('plateTitanium'), ore('craftingToolHardHammer'), ore('plateTitanium')],
    [ore('plateTitaniumCarbide'), metaitem('frameTungstenCarbide'), ore('plateTitaniumCarbide')],
    [ore('plateTitanium'), ore('craftingToolWrench'), ore('plateTitanium')]])

ASSEMBLER.recipeBuilder()
    .circuitMeta(7)
    .inputs(ore('frameGtTungstenCarbide'))
    .inputs(ore('plateTitanium') * 4)
    .inputs(ore('plateTitaniumCarbide') * 2)
    .outputs(item('gcym:large_multiblock_casing', 1) * 2)
    .duration(50)
    .EUt(16)
    .buildAndRegister()

// Large-Scale Assembler Casing
RecyclingHelper.replaceShaped('gcym:casing_large_assembler', item('gcym:large_multiblock_casing', 2) * 2, [
    [ore('plateHsla980X'), ore('craftingToolHardHammer'), ore('plateHsla980X')],
    [ore('plateHsla980X'), ore('frameGtHsla980X'), ore('plateHsla980X')],
    [ore('plateHsla980X'), ore('craftingToolWrench'), ore('plateHsla980X')]])

ASSEMBLER.recipeBuilder()
    .circuitMeta(6)
    .inputs(ore('frameGtHsla980X'))
    .inputs(ore('plateHsla980X') * 6)
    .outputs(item('gcym:large_multiblock_casing', 2) * 2)
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

// Corrosion Proof Casing
RecyclingHelper.replaceShaped('gcym:casing_corrosion_proof', item('gcym:large_multiblock_casing', 4) * 2, [
    [ore('plateIncoloy825'), ore('craftingToolHardHammer'), ore('plateIncoloy825')],
    [ore('plateReneN5'), ore('frameGtHsla980X'), ore('plateReneN5')],
    [ore('plateIncoloy825'), ore('craftingToolWrench'), ore('plateIncoloy825')]])

ASSEMBLER.recipeBuilder()
    .circuitMeta(7)
    .inputs(ore('frameGtHsla980X'))
    .inputs(ore('plateIncoloy825') * 4)
    .inputs(ore('plateReneN5') * 2)
    .outputs(item('gcym:large_multiblock_casing', 4) * 2)
    .duration(50)
    .EUt(16)
    .buildAndRegister()

// Vibration-Safe Casing
RecyclingHelper.replaceShaped('gcym:casing_vibration_safe', item('gcym:large_multiblock_casing', 5) * 2, [
    [ore('plateStelliteJ'), ore('craftingToolHardHammer'), ore('plateStelliteJ')],
    [ore('plateIncoloy825'), ore('frameGtHsla980X'), ore('plateIncoloy825')],
    [ore('plateStelliteJ'), ore('craftingToolWrench'), ore('plateStelliteJ')]])

ASSEMBLER.recipeBuilder()
    .circuitMeta(8)
    .inputs(ore('frameGtHsla980X'))
    .inputs(ore('plateStelliteJ') * 4)
    .inputs(ore('plateIncoloy825') * 2)
    .outputs(item('gcym:large_multiblock_casing', 5) * 2)
    .duration(50)
    .EUt(16)
    .buildAndRegister()

// Watertight Casing
RecyclingHelper.replaceShaped('gcym:casing_watertight', item('gcym:large_multiblock_casing', 6) * 2, [
    [ore('plateIncoloy825'), ore('craftingToolHardHammer'), ore('plateIncoloy825')],
    [ore('plateIncoloy825'), ore('frameGtHsla980X'), ore('plateIncoloy825')],
    [ore('plateIncoloy825'), ore('craftingToolWrench'), ore('plateIncoloy825')]])

ASSEMBLER.recipeBuilder()
    .circuitMeta(6)
    .inputs(ore('frameGtHsla980X'))
    .inputs(ore('plateIncoloy825') * 6)
    .outputs(item('gcym:large_multiblock_casing', 6) * 2)
    .duration(50)
    .EUt(16)
    .buildAndRegister()

// Shock Proof Cutting Casing
RecyclingHelper.replaceShaped('gcym:casing_large_cutter', item('gcym:large_multiblock_casing', 7) * 2, [
    [ore('plateStelliteJ'), ore('craftingToolHardHammer'), ore('plateStelliteJ')],
    [ore('plateIncoloy908'), ore('frameGtHsla980X'), ore('plateIncoloy908')],
    [ore('plateStelliteJ'), ore('craftingToolWrench'), ore('plateStelliteJ')]])

ASSEMBLER.recipeBuilder()
    .circuitMeta(7)
    .inputs(ore('frameGtHsla980X'))
    .inputs(ore('plateStelliteJ') * 4)
    .inputs(ore('plateIncoloy908') * 2)
    .outputs(item('gcym:large_multiblock_casing', 7) * 2)
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
    .outputs(item('gcym:large_multiblock_casing:', 8) * 2)
    .duration(50)
    .EUt(16)
    .buildAndRegister()

// Reaction-Safe Mixing Casing
RecyclingHelper.replaceShaped('gcym:casing_large_mixer', item('gcym:large_multiblock_casing', 9) * 2, [
    [ore('plateIncoloy20'), ore('craftingToolHardHammer'), ore('plateIncoloy20')],
    [ore('plateIncoloy20'), ore('frameGtHsla980X'), ore('plateIncoloy20')],
    [ore('plateIncoloy20'), ore('craftingToolWrench'), ore('plateIncoloy20')]])

ASSEMBLER.recipeBuilder()
    .circuitMeta(6)
    .inputs(ore('frameGtHsla980X'))
    .inputs(ore('plateIncoloy20') * 6)
    .outputs(item('gcym:large_multiblock_casing', 9) * 2)
    .duration(50)
    .EUt(16)
    .buildAndRegister()

// Laser-Safe Engraving Casing
RecyclingHelper.replaceShaped('gcym:casing_large_engraver', item('gcym:large_multiblock_casing', 10) * 2, [
    [ore('plateReneN5'), ore('craftingToolHardHammer'), ore('plateReneN5')],
    [ore('plateHsla980X'), ore('frameGtHsla980X'), ore('plateHsla980X')],
    [ore('plateReneN5'), ore('craftingToolWrench'), ore('plateReneN5')]])

ASSEMBLER.recipeBuilder()
    .circuitMeta(7)
    .inputs(ore('frameGtHsla980X'))
    .inputs(ore('plateReneN5') * 4)
    .inputs(ore('plateHsla980X') * 2)
    .outputs(item('gcym:large_multiblock_casing', 10) * 2)
    .duration(50)
    .EUt(16)
    .buildAndRegister()

/*
    Blocks from GT superalloys need to be removed (block, frame, sheeted frame) and liquids
    Recipes for GCYM casings need to be changed to use SuSy superalloys, currently they still have recipes with old ones
 */
