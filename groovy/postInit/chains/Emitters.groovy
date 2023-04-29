import static globals.Globals.*

//REMOVALS

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

//HV EMITTER

crafting.replaceShaped('gregtech:emitter_hv', metaitem('emitter.hv'), [
        [metaitem('cableGtSingleGold'), metaitem('stickChrome'), ore('circuitHv')],
        [metaitem('stickChrome'), metaitem('gemGalliumPhosphate'), metaitem('stickChrome')],
        [ore('circuitHv'), metaitem('stickChrome'), metaitem('cableGtSingleGold')]
])

mods.gregtech.assembler.recipeBuilder()
        .inputs(metaitem('stickChrome') * 4)
        .inputs(metaitem('cableGtSingleGold') * 2)
        .inputs(ore('circuitHv') * 2)
        .inputs(metaitem('gemGalliumPhosphate'))
        .notConsumable(Globals.circuit(1))
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
        .inputs(metaitem('stickPlatinum') * 4)
        .inputs(metaitem('cableGtSingleAluminium') * 2)
        .inputs(ore('circuitEv') * 2)
        .inputs(metaitem('gemLithiumNiobate'))
        .notConsumable(Globals.circuit(1))
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
        .inputs(metaitem('stickIridium') * 4)
        .inputs(metaitem('cableGtSingleTungsten') * 2)
        .inputs(ore('circuitIv') * 2)
        .inputs(metaitem('gemLeadZirconateTitanate'))
        .notConsumable(Globals.circuit(1))
        .outputs(metaitem('emitter.iv'))
        .duration(100)
        .EUt(30)
        .buildAndRegister();

//LuV EMITTER

mods.gregtech.assembly_line.recipeBuilder()
        .inputs(metaitem('frameHsss'))
        .inputs(metaitem('electric.motor.luv'))
        .inputs(metaitem('stickLongRuridit') * 4)
        .inputs(metaitem('platePolyvinylideneFluoride') * 4)
        .inputs(ore('circuitLuv') * 2)
        .inputs(metaitem('foilPalladium') * 64)
        .inputs(metaitem('foilPalladium') * 32)
        .inputs(metaitem('cableGtSingleNiobiumTitanium') * 4)
        .fluidInputs(fluid('soldering_alloy') * 288)
        .outputs(metaitem('emitter.luv'))
        .duration(600)
        .EUt(6000)
        .buildAndRegister();

//ZPM EMITTER

mods.gregtech.assembly_line.recipeBuilder()
        .inputs(metaitem('frameNaquadahAlloy'))
        .inputs(metaitem('electric.motor.zpm'))
        .inputs(metaitem('stickLongOsmiridium') * 4)
        .inputs(metaitem('platePolyvinylideneFluoride') * 8)
        .inputs(ore('circuitZpm') * 2)
        .inputs(metaitem('foilTrinium') * 64)
        .inputs(metaitem('foilTrinium') * 32)
        .inputs(metaitem('cableGtSingleVanadiumGallium') * 4)
        .fluidInputs(fluid('soldering_alloy') * 576)
        .outputs(metaitem('emitter.zpm'))
        .duration(600)
        .EUt(24000)
        .buildAndRegister();

//UV EMITTER

mods.gregtech.assembly_line.recipeBuilder()
        .inputs(metaitem('frameTritanium'))
        .inputs(metaitem('electric.motor.uv'))
        .inputs(metaitem('stickLongTritanium') * 4)
        .inputs(metaitem('rydberg_atom_array'))
        .inputs(ore('circuitUv') * 2)
        .inputs(metaitem('foilNaquadria') * 64)
        .inputs(metaitem('foilNaquadria') * 32)
        .inputs(metaitem('cableGtSingleYttriumBariumCuprate') * 4)
        .fluidInputs(fluid('soldering_alloy') * 1152)
        .fluidInputs(fluid('naquadria') * 576)
        .outputs(metaitem('emitter.uv'))
        .duration(600)
        .EUt(100000)
        .buildAndRegister();