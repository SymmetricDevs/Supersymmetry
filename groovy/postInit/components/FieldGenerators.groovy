import globals.Globals
import classes.*;
import prePostInit.Thermodynamics

//REMOVALS

def name_removals = [
        'gregtech:field_generator_lv',
        'gregtech:field_generator_mv',
        'gregtech:field_generator_hv',
        'gregtech:field_generator_ev',
        'gregtech:field_generator_iv'
]

for (name in name_removals) {
    crafting.remove(name)
}

// LV Field Generator * 1
mods.gregtech.assembler.removeByInput(30, [item('minecraft:ender_pearl'), metaitem('plateSteel') * 2, metaitem('circuit.microprocessor') * 2, metaitem('wireGtQuadrupleManganesePhosphide') * 4], null)
// MV Field Generator * 1
mods.gregtech.assembler.removeByInput(30, [item('minecraft:ender_eye'), metaitem('plateAluminium') * 2, metaitem('circuit.processor') * 2, metaitem('wireGtQuadrupleMagnesiumDiboride') * 4], null)
// HV Field Generator * 1
mods.gregtech.assembler.removeByInput(30, [metaitem('quantumeye'), metaitem('plateStainlessSteel') * 2, metaitem('circuit.assembly') * 2, metaitem('wireGtQuadrupleMercuryBariumCalciumCuprate') * 4], null)
// EV Field Generator * 1
mods.gregtech.assembler.removeByInput(30, [item('minecraft:nether_star'), metaitem('plateDoubleTitanium') * 2, metaitem('circuit.nano_assembly') * 2, metaitem('wireGtQuadrupleUraniumTriplatinum') * 4], null)
// IV Field Generator * 1
mods.gregtech.assembler.removeByInput(30, [metaitem('quantumstar'), metaitem('plateDoubleTungstenSteel') * 2, metaitem('circuit.quantum_assembly') * 2, metaitem('wireGtQuadrupleSamariumIronArsenicOxide') * 4], null)
// LuV Field Generator * 1
mods.gregtech.assembly_line.removeByInput(6000, [metaitem('frameHsss'), metaitem('plateHsss') * 6, metaitem('quantumstar'), metaitem('emitter.luv') * 2, metaitem('circuit.crystal_assembly') * 2, metaitem('wireFineIndiumTinBariumTitaniumCuprate') * 64, metaitem('wireFineIndiumTinBariumTitaniumCuprate') * 64, metaitem('cableGtSingleNiobiumTitanium') * 4], [fluid('soldering_alloy') * 576])
// ZPM Field Generator * 1
mods.gregtech.assembly_line.removeByInput(24000, [metaitem('frameNaquadahAlloy'), metaitem('plateNaquadahAlloy') * 6, metaitem('quantumstar'), metaitem('emitter.zpm') * 2, metaitem('circuit.wetware_assembly') * 2, metaitem('wireFineUraniumRhodiumDinaquadide') * 64, metaitem('wireFineUraniumRhodiumDinaquadide') * 64, metaitem('cableGtSingleVanadiumGallium') * 4], [fluid('soldering_alloy') * 1152])
// UV Field Generator * 1
mods.gregtech.assembly_line.removeByInput(100000, [metaitem('frameTritanium'), metaitem('plateTritanium') * 6, metaitem('gravistar'), metaitem('emitter.uv') * 2, metaitem('circuit.wetware_computer') * 2, metaitem('wireFineEnrichedNaquadahTriniumEuropiumDuranide') * 64, metaitem('wireFineEnrichedNaquadahTriniumEuropiumDuranide') * 64, metaitem('cableGtSingleYttriumBariumCuprate') * 4], [fluid('soldering_alloy') * 1728, fluid('naquadria') * 576])


//REPLACEMENTS

def cryoLiquids = [
        'liquid_hydrogen': 14,
        'liquid_oxygen': 90,
        'liquid_helium': 4,
        'liquid_neon': 27,
        'liquid_argon': 87,
        'liquid_krypton': 120,
        'liquid_xenon': 165,
        'liquid_nitrogen': 77,
        'liquid_natural_gas': 80
];

cryoLiquids.each { key, val ->
    if(100 > val) {
        mods.gregtech.assembler.recipeBuilder()
                .inputs(metaitem('electric.motor.lv'))
                .inputs(metaitem('large_fluid_cell.steel'))
                .inputs(ore('wireGtQuadrupleManganesePhosphide') * 4)
                .inputs(ore('circuitLv') * 2)
                .fluidInputs(fluid(key) * 250)
                .outputs(metaitem('field.generator.lv'))
                .duration(100)
                .EUt(30)
                .buildAndRegister();
    }
    if(45 > val) {
        mods.gregtech.assembler.recipeBuilder()
                .inputs(metaitem('electric.motor.mv'))
                .inputs(metaitem('large_fluid_cell.aluminium'))
                .inputs(ore('wireGtQuadrupleMagnesiumDiboride') * 4)
                .inputs(ore('circuitMv') * 2)
                .fluidInputs(fluid(key) * 500)
                .outputs(metaitem('field.generator.mv'))
                .duration(100)
                .EUt(120)
                .buildAndRegister();
    }
    if(25 > val) {
        mods.gregtech.assembler.recipeBuilder()
                .inputs(metaitem('electric.motor.hv'))
                .inputs(metaitem('large_fluid_cell.stainless_steel'))
                .inputs(ore('wireGtQuadrupleMercuryBariumCalciumCuprate') * 4)
                .inputs(ore('circuitHv') * 2)
                .fluidInputs(fluid(key) * 1000)
                .outputs(metaitem('field.generator.hv'))
                .duration(100)
                .EUt(480)
                .buildAndRegister();
    }
    if(5 > val) {
        mods.gregtech.assembler.recipeBuilder()
                .inputs(metaitem('electric.motor.ev'))
                .inputs(metaitem('large_fluid_cell.titanium'))
                .inputs(ore('wireGtQuadrupleUraniumTriplatinum') * 4)
                .inputs(ore('circuitEv') * 2)
                .fluidInputs(fluid(key) * 1500)
                .outputs(metaitem('field.generator.ev'))
                .duration(100)
                .EUt(1920)
                .buildAndRegister();
    }
    if(5 > val) {
        mods.gregtech.assembler.recipeBuilder()
                .inputs(metaitem('electric.motor.iv'))
                .inputs(metaitem('large_fluid_cell.tungstensteel'))
                .inputs(ore('wireGtQuadrupleSamariumIronArsenicOxide') * 4)
                .inputs(ore('circuitIv') * 2)
                .fluidInputs(fluid(key) * 2000)
                .outputs(metaitem('field.generator.iv'))
                .duration(100)
                .EUt(7680)
                .buildAndRegister();
    }
    if(5 > val) {
        mods.gregtech.assembly_line.recipeBuilder()
                .inputs(metaitem('frameHsss'))
                .inputs(ore('plateHsss') * 6)
                .inputs(metaitem('emitter.luv') * 2)
                .inputs(ore('circuitLuv') * 2)
                .inputs(metaitem('wireFineIndiumTinBariumTitaniumCuprate') * 64)
                .inputs(metaitem('wireFineIndiumTinBariumTitaniumCuprate') * 64)
                .inputs(ore('cableGtSingleNiobiumTitanium') * 4)
                .fluidInputs(fluid('soldering_alloy') * 576)
                .fluidInputs(fluid(key) * 4000)
                .outputs(metaitem('field.generator.luv'))
                .duration(600)
                .EUt(7680)
                .buildAndRegister();
    }
    if(5 > val) {
        mods.gregtech.assembly_line.recipeBuilder()
                .inputs(metaitem('frameNaquadahAlloy'))
                .inputs(metaitem('plateNaquadahAlloy') * 6)
                .inputs(metaitem('emitter.zpm') * 2)
                .inputs(ore('circuitZpm') * 2)
                .inputs(ore('wireFineUraniumRhodiumDinaquadide') * 64)
                .inputs(ore('wireFineUraniumRhodiumDinaquadide') * 64)
                .inputs(ore('cableGtSingleVanadiumGallium') * 4)
                .fluidInputs(fluid('soldering_alloy') * 1152)
                .fluidInputs(fluid(key) * 8000)
                .outputs(metaitem('field.generator.zpm'))
                .duration(600)
                .EUt(24000)
                .buildAndRegister();
    }
    if(5 > val) {
        mods.gregtech.assembly_line.recipeBuilder()
                .inputs(metaitem('frameTritanium'))
                .inputs(metaitem('plateTritanium') * 6)
                .inputs(metaitem('emitter.uv') * 2)
                .inputs(ore('circuitUv') * 2)
                .inputs(ore('wireFineEnrichedNaquadahTriniumEuropiumDuranide') * 64)
                .inputs(ore('wireFineEnrichedNaquadahTriniumEuropiumDuranide') * 64)
                .inputs(ore('cableGtSingleYttriumBariumCuprate') * 4)
                .fluidInputs(fluid('soldering_alloy') * 1728)
                .fluidInputs(fluid('naquadria') * 576)
                .fluidInputs(fluid(key) * 16000)
                .outputs(metaitem('field.generator.uv'))
                .duration(600)
                .EUt(100000)
                .buildAndRegister();   
    }
}