import globals.Globals

//REMOVALS

// MV Emitter * 1
mods.gregtech.assembler.removeByInput(30, [metaitem('stickElectrum') * 4, metaitem('cableGtSingleCopper') * 2, metaitem('circuit.good_integrated') * 2, metaitem('gemFlawlessEmerald'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)

// HV Emitter * 1
mods.gregtech.assembler.removeByInput(30, [metaitem('stickChrome') * 4, metaitem('cableGtSingleGold') * 2, metaitem('circuit.assembly') * 2, item('minecraft:ender_eye'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)
// EV Emitter * 1
mods.gregtech.assembler.removeByInput(30, [metaitem('stickPlatinum') * 4, metaitem('cableGtSingleAluminium') * 2, metaitem('circuit.nano_assembly') * 2, metaitem('quantumeye'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)
// IV Emitter * 1
mods.gregtech.assembler.removeByInput(30, [metaitem('stickIridium') * 4, metaitem('cableGtSingleTungsten') * 2, metaitem('circuit.quantum_assembly') * 2, metaitem('quantumstar'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)
// LuV Emitter * 1
mods.gregtech.assembly_line.removeByInput(6000, [metaitem('frameHsss'), metaitem('electric.motor.luv'), metaitem('stickLongRuridit') * 4, metaitem('quantumstar'), metaitem('circuit.crystal_assembly') * 2, metaitem('foilPalladium') * 64, metaitem('foilPalladium') * 32, metaitem('cableGtSingleNiobiumTitanium') * 4], [fluid('soldering_alloy') * 288])
// ZPM Emitter * 1
mods.gregtech.assembly_line.removeByInput(24000, [metaitem('frameNaquadahAlloy'), metaitem('electric.motor.zpm'), metaitem('stickLongOsmiridium') * 4, metaitem('quantumstar') * 2, metaitem('circuit.wetware_assembly') * 2, metaitem('foilTrinium') * 64, metaitem('foilTrinium') * 32, metaitem('cableGtSingleVanadiumGallium') * 4], [fluid('soldering_alloy') * 576])
// UV Emitter * 1
mods.gregtech.assembly_line.removeByInput(100000, [metaitem('frameTritanium'), metaitem('electric.motor.uv'), metaitem('stickLongTritanium') * 4, metaitem('gravistar'), metaitem('circuit.wetware_computer') * 2, metaitem('foilNaquadria') * 64, metaitem('foilNaquadria') * 32, metaitem('cableGtSingleYttriumBariumCuprate') * 4], [fluid('soldering_alloy') * 1152, fluid('naquadria') * 576])

//REPLACEMENTS

//MV EMITTER

crafting.replaceShaped('gregtech:emitter_mv', metaitem('emitter.mv'), [
        [metaitem('cableGtSingleCopper'), metaitem('stickElectrum'), ore('circuitMv')],
        [metaitem('stickElectrum'), item('minecraft:emerald'), metaitem('stickElectrum')],
        [ore('circuitMv'), metaitem('stickElectrum'), metaitem('cableGtSingleCopper')]
])

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('stickElectrum') * 4)
        .inputs(ore('cableGtSingleCopper') * 2)
        .inputs(ore('circuitMv') * 2)
        .inputs(item('minecraft:emerald'))
        .circuitMeta(1)
        .outputs(metaitem('emitter.mv'))
        .duration(100)
        .EUt(30)
        .buildAndRegister();

//HV EMITTER

crafting.replaceShaped('gregtech:emitter_hv', metaitem('emitter.hv'), [
        [metaitem('cableGtSingleGold'), metaitem('stickChrome'), ore('circuitHv')],
        [metaitem('stickChrome'), metaitem('gemGalliumPhosphate'), metaitem('stickChrome')],
        [ore('circuitHv'), metaitem('stickChrome'), metaitem('cableGtSingleGold')]
])

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('stickChrome') * 4)
        .inputs(ore('cableGtSingleGold') * 2)
        .inputs(ore('circuitHv') * 2)
        .inputs(ore('gemGalliumPhosphate'))
        .circuitMeta(1)
        .outputs(metaitem('emitter.hv'))
        .duration(100)
        .EUt(30)
        .buildAndRegister();

//EV EMITTER

crafting.replaceShaped('gregtech:emitter_ev', metaitem('emitter.ev'), [
        [metaitem('cableGtSingleAluminium'), metaitem('stickPlatinum'), ore('circuitEv')],
        [metaitem('stickPlatinum'), metaitem('gemLithiumNiobate'), metaitem('stickPlatinum')],
        [ore('circuitEv'), metaitem('stickPlatinum'), metaitem('cableGtSingleAluminium')]
])

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('stickPlatinum') * 4)
        .inputs(ore('cableGtSingleAluminium') * 2)
        .inputs(ore('circuitEv') * 2)
        .inputs(ore('gemLithiumNiobate'))
        .circuitMeta(1)
        .outputs(metaitem('emitter.ev'))
        .duration(100)
        .EUt(30)
        .buildAndRegister();

//IV EMITTER

crafting.replaceShaped('gregtech:emitter_iv', metaitem('emitter.iv'), [
        [metaitem('cableGtSingleTungsten'), metaitem('stickIridium'), ore('circuitIv')],
        [metaitem('stickIridium'), metaitem('gemLeadZirconateTitanate'), metaitem('stickIridium')],
        [ore('circuitIv'), metaitem('stickIridium'), metaitem('cableGtSingleTungsten')]
])

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('stickIridium') * 4)
        .inputs(ore('cableGtSingleTungsten') * 2)
        .inputs(ore('circuitIv') * 2)
        .inputs(ore('gemLeadZirconateTitanate'))
        .circuitMeta(1)
        .outputs(metaitem('emitter.iv'))
        .duration(100)
        .EUt(30)
        .buildAndRegister();

//LuV EMITTER

mods.gregtech.assembly_line.recipeBuilder()
        .inputs(metaitem('frameHsss'))
        .inputs(metaitem('electric.motor.luv'))
        .inputs(ore('stickLongRuridit') * 4)
        .inputs(ore('platePolyvinylideneFluoride') * 4)
        .inputs(ore('circuitLuv') * 2)
        .inputs(ore('foilPalladium') * 64)
        .inputs(ore('foilPalladium') * 32)
        .inputs(ore('cableGtSingleNiobiumTitanium') * 4)
        .fluidInputs(fluid('soldering_alloy') * 288)
        .outputs(metaitem('emitter.luv'))
        .duration(600)
        .EUt(6000)
        .buildAndRegister();

//ZPM EMITTER

mods.gregtech.assembly_line.recipeBuilder()
        .inputs(metaitem('frameNaquadahAlloy'))
        .inputs(metaitem('electric.motor.zpm'))
        .inputs(ore('stickLongOsmiridium') * 4)
        .inputs(ore('platePolyvinylideneFluoride') * 8)
        .inputs(ore('circuitZpm') * 2)
        .inputs(ore('foilTrinium') * 64)
        .inputs(ore('foilTrinium') * 32)
        .inputs(ore('cableGtSingleVanadiumGallium') * 4)
        .fluidInputs(fluid('soldering_alloy') * 576)
        .outputs(metaitem('emitter.zpm'))
        .duration(600)
        .EUt(24000)
        .buildAndRegister();

//UV EMITTER

mods.gregtech.assembly_line.recipeBuilder()
        .inputs(metaitem('frameTritanium'))
        .inputs(metaitem('electric.motor.uv'))
        .inputs(ore('stickLongTritanium') * 4)
        .inputs(metaitem('rydberg_atom_array'))
        .inputs(ore('circuitUv') * 2)
        .inputs(ore('foilNaquadria') * 64)
        .inputs(ore('foilNaquadria') * 32)
        .inputs(ore('cableGtSingleYttriumBariumCuprate') * 4)
        .fluidInputs(fluid('soldering_alloy') * 1152)
        .fluidInputs(fluid('naquadria') * 576)
        .outputs(metaitem('emitter.uv'))
        .duration(600)
        .EUt(100000)
        .buildAndRegister();