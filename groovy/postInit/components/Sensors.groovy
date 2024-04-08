import globals.Globals

//REMOVALS

// MV Sensor * 1
mods.gregtech.assembler.removeByInput(30, [metaitem('stickElectrum'), metaitem('plateAluminium') * 4, metaitem('circuit.good_integrated'), metaitem('gemFlawlessEmerald')], null)
// HV Sensor * 1
mods.gregtech.assembler.removeByInput(30, [metaitem('stickChrome'), metaitem('plateStainlessSteel') * 4, metaitem('circuit.assembly'), item('minecraft:ender_eye')], null)
// EV Sensor * 1
mods.gregtech.assembler.removeByInput(30, [metaitem('stickPlatinum'), metaitem('plateTitanium') * 4, metaitem('circuit.nano_assembly'), metaitem('quantumeye')], null)
// IV Sensor * 1
mods.gregtech.assembler.removeByInput(30, [metaitem('stickIridium'), metaitem('plateTungstenSteel') * 4, metaitem('circuit.crystal_processor'), metaitem('quantumstar')], null)
// LuV Sensor * 1
mods.gregtech.assembly_line.removeByInput(6000, [metaitem('frameHsss'), metaitem('electric.motor.luv'), metaitem('plateRuridit') * 4, metaitem('quantumstar'), metaitem('circuit.crystal_assembly') * 2, metaitem('foilPalladium') * 64, metaitem('foilPalladium') * 32, metaitem('cableGtSingleNiobiumTitanium') * 4], [fluid('soldering_alloy') * 288])
// ZPM Sensor * 1
mods.gregtech.assembly_line.removeByInput(24000, [metaitem('frameNaquadahAlloy'), metaitem('electric.motor.zpm'), metaitem('plateOsmiridium') * 4, metaitem('quantumstar') * 2, metaitem('circuit.wetware_assembly') * 2, metaitem('foilTrinium') * 64, metaitem('foilTrinium') * 32, metaitem('cableGtSingleVanadiumGallium') * 4], [fluid('soldering_alloy') * 576])
// UV Sensor * 1
mods.gregtech.assembly_line.removeByInput(100000, [metaitem('frameTritanium'), metaitem('electric.motor.uv'), metaitem('plateTritanium') * 4, metaitem('gravistar'), metaitem('circuit.wetware_computer') * 2, metaitem('foilNaquadria') * 64, metaitem('foilNaquadria') * 32, metaitem('cableGtSingleYttriumBariumCuprate') * 4], [fluid('soldering_alloy') * 1152, fluid('naquadria') * 576])

//REPLACEMENTS

//MV SENSOR

crafting.replaceShaped('gregtech:sensor_mv', metaitem('sensor.mv'), [
        [metaitem('plateAluminium'), null, item('minecraft:emerald')],
        [metaitem('plateAluminium'), metaitem('stickElectrum'), null],
        [ore('circuitMv'), metaitem('plateAluminium'), metaitem('plateAluminium')]
])

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('stickElectrum'))
        .inputs(ore('plateAluminium') * 4)
        .inputs(ore('circuitMv'))
        .inputs(item('minecraft:emerald'))
        .outputs(metaitem('sensor.mv'))
        .duration(100)
        .EUt(30)
        .buildAndRegister();

//HV EMITTER

crafting.replaceShaped('gregtech:sensor_hv', metaitem('sensor.hv'), [
        [metaitem('plateStainlessSteel'), null, ore('gemGalliumPhosphate')],
        [metaitem('plateStainlessSteel'), metaitem('stickChrome'), null],
        [ore('circuitHv'), metaitem('plateStainlessSteel'), metaitem('plateStainlessSteel')]
])

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('stickChrome'))
        .inputs(ore('plateStainlessSteel') * 4)
        .inputs(ore('circuitHv'))
        .inputs(ore('gemGalliumPhosphate'))
        .outputs(metaitem('sensor.hv'))
        .duration(100)
        .EUt(30)
        .buildAndRegister();

//EV EMITTER

crafting.replaceShaped('gregtech:sensor_ev', metaitem('sensor.ev'), [
        [metaitem('plateTitanium'), null, ore('gemLithiumNiobate')],
        [metaitem('plateTitanium'), metaitem('stickPlatinum'), null],
        [ore('circuitEv'), metaitem('plateTitanium'), metaitem('plateTitanium')]
])

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('stickPlatinum'))
        .inputs(ore('plateTitanium') * 4)
        .inputs(ore('circuitEv'))
        .inputs(ore('gemLithiumNiobate'))
        .outputs(metaitem('sensor.ev'))
        .duration(100)
        .EUt(30)
        .buildAndRegister();

//IV EMITTER

crafting.replaceShaped('gregtech:sensor_iv', metaitem('sensor.iv'), [
        [metaitem('plateTungstenSteel'), null, ore('gemLeadZirconateTitanate')],
        [metaitem('plateTungstenSteel'), metaitem('stickIridium'), null],
        [ore('circuitIv'), metaitem('plateTungstenSteel'), metaitem('plateTungstenSteel')]
])

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('stickIridium'))
        .inputs(ore('plateTungstenSteel') * 4)
        .inputs(ore('circuitIv'))
        .inputs(ore('gemLeadZirconateTitanate'))
        .outputs(metaitem('sensor.iv'))
        .duration(100)
        .EUt(30)
        .buildAndRegister();

//LuV EMITTER

mods.gregtech.assembly_line.recipeBuilder()
        .inputs(metaitem('frameHsss'))
        .inputs(metaitem('electric.motor.luv'))
        .inputs(ore('plateRuridit') * 4)
        .inputs(ore('platePolyvinylideneFluoride') * 4)
        .inputs(ore('circuitLuv') * 2)
        .inputs(ore('foilPalladium') * 64)
        .inputs(ore('foilPalladium') * 32)
        .inputs(ore('cableGtSingleNiobiumTitanium') * 4)
        .fluidInputs(fluid('soldering_alloy') * 288)
        .outputs(metaitem('sensor.luv'))
        .duration(600)
        .EUt(6000)
        .buildAndRegister();

//ZPM EMITTER

mods.gregtech.assembly_line.recipeBuilder()
        .inputs(metaitem('frameNaquadahAlloy'))
        .inputs(metaitem('electric.motor.zpm'))
        .inputs(ore('plateOsmiridium') * 4)
        .inputs(ore('platePolyvinylideneFluoride') * 8)
        .inputs(ore('circuitZpm') * 2)
        .inputs(ore('foilTrinium') * 64)
        .inputs(ore('foilTrinium') * 32)
        .inputs(ore('cableGtSingleVanadiumGallium') * 4)
        .fluidInputs(fluid('soldering_alloy') * 576)
        .outputs(metaitem('sensor.zpm'))
        .duration(600)
        .EUt(24000)
        .buildAndRegister();

//UV EMITTER

mods.gregtech.assembly_line.recipeBuilder()
        .inputs(metaitem('frameTritanium'))
        .inputs(metaitem('electric.motor.uv'))
        .inputs(ore('plateTritanium') * 4)
        .inputs(metaitem('rydberg_atom_array'))
        .inputs(ore('circuitUv') * 2)
        .inputs(ore('foilNaquadria') * 64)
        .inputs(ore('foilNaquadria') * 32)
        .inputs(ore('cableGtSingleYttriumBariumCuprate') * 4)
        .fluidInputs(fluid('soldering_alloy') * 1152)
        .fluidInputs(fluid('naquadria') * 576)
        .outputs(metaitem('sensor.uv'))
        .duration(600)
        .EUt(100000)
        .buildAndRegister();