import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*
import gregtech.api.recipes.recipeproperties.RecipeProperty
import gregtech.api.recipes.RecipeBuilder
import static gregtech.api.recipes.RecipeMaps.*
import gregtech.api.unification.material.Materials.*

import gregtech.api.recipes.ModHandler
import gregtech.api.unification.material.Materials
import gregtech.api.unification.ore.OrePrefix
import gregtech.api.unification.stack.UnificationEntry

import postInit.utils.RecyclingHelper

log.infoMC("Running Batteries.groovy...")

mods.jei.ingredient.yeet(
//        metaitem('battery.re.ulv.tantalum'),
        metaitem('battery.zpm.naquadria'),
        metaitem('battery.uv.naquadria'),
        metaitem('energy.module'),
        metaitem('energy.cluster'),
        metaitem('max.battery'),
        metaitem('battery.ni_zn.mv'),
        metaitem('battery.ni_zn.hv'),
)

[
        metaitem('battery.re.lv.sodium'),
        metaitem('battery.re.mv.sodium'),
        metaitem('battery.re.hv.sodium'),
        metaitem('battery.re.lv.lithium'),
        metaitem('battery.re.mv.lithium'),
//        metaitem('battery.re.hv.lithium'),
        metaitem('battery.re.lv.cadmium'),
        metaitem('battery.re.mv.cadmium'),
//        metaitem('battery.re.hv.cadmium'),
        metaitem('energy_crystal'),
        metaitem('lapotron_crystal'),
//        metaitem('battery.ev.vanadium'),
        metaitem('battery.iv.vanadium'),
        metaitem('battery.luv.vanadium'),
        metaitem('energy.lapotronic_orb'),
        metaitem('energy.lapotronic_orb_cluster'),
].each { battery ->
    crafting.removeByInput(battery)
    mods.jei.ingredient.yeet(battery)
}

['lv', 'mv', 'iv', 'luv', 'zpm', 'uv'].each { voltage ->
    crafting.remove('gregtech:battery_hull_' + voltage)
    RecyclingHelper.removeRecyclingRecipes(metaitem('battery.hull.' + voltage))
    mods.jei.ingredient.yeet((metaitem('battery.hull.' + voltage)))
}

// Small Battery Hull * 1
mods.gregtech.assembler.removeByInput(1, [metaitem('cableGtSingleTin'), metaitem('plateBatteryAlloy')], [fluid('plastic') * 144])
// Small Battery Hull * 1
mods.gregtech.extractor.removeByInput(2, [metaitem('battery.re.lv.cadmium')], null)
// Small Battery Hull * 1
mods.gregtech.extractor.removeByInput(2, [metaitem('battery.re.lv.lithium')], null)
// Small Battery Hull * 1
mods.gregtech.extractor.removeByInput(2, [metaitem('battery.re.lv.sodium')], null)
// Medium Battery Hull * 1
mods.gregtech.assembler.removeByInput(2, [metaitem('cableGtSingleAnnealedCopper') * 2, metaitem('plateBatteryAlloy') * 3], [fluid('plastic') * 432])
// Medium Battery Hull * 1
mods.gregtech.extractor.removeByInput(2, [metaitem('battery.re.mv.cadmium')], null)
// Medium Battery Hull * 1
mods.gregtech.extractor.removeByInput(2, [metaitem('battery.re.mv.lithium')], null)
// Medium Battery Hull * 1
mods.gregtech.extractor.removeByInput(2, [metaitem('battery.re.mv.sodium')], null)
// Large Battery Hull * 1
mods.gregtech.assembler.removeByInput(4, [metaitem('cableGtSingleGold') * 4, metaitem('plateBatteryAlloy') * 9], [fluid('plastic') * 1296])
//// Large Battery Hull * 1
//mods.gregtech.extractor.removeByInput(2, [metaitem('battery.re.hv.lithium')], null)
//// Large Battery Hull * 1
//mods.gregtech.extractor.removeByInput(2, [metaitem('battery.re.hv.cadmium')], null)
// Large Battery Hull * 1
mods.gregtech.extractor.removeByInput(2, [metaitem('battery.re.hv.sodium')], null)
// Small Vanadium Battery Hull * 1
mods.gregtech.assembler.removeByInput(480, [metaitem('cableGtSingleAluminium') * 2, metaitem('plateBlueSteel') * 2], [fluid('polytetrafluoroethylene') * 144])
// Small Vanadium Battery Hull * 1
mods.gregtech.extractor.removeByInput(2, [metaitem('battery.ev.vanadium')], null)
// Medium Vanadium Battery Hull * 1
mods.gregtech.assembler.removeByInput(1920, [metaitem('cableGtSinglePlatinum') * 2, metaitem('plateRoseGold') * 6], [fluid('polytetrafluoroethylene') * 288])
// Medium Vanadium Battery Hull * 1
mods.gregtech.extractor.removeByInput(2, [metaitem('battery.iv.vanadium')], null)
// Large Vanadium Battery Hull * 1
mods.gregtech.extractor.removeByInput(2, [metaitem('battery.luv.vanadium')], null)
// Medium Naquadria Battery Hull * 1
mods.gregtech.extractor.removeByInput(2, [metaitem('battery.zpm.naquadria')], null)
// Large Naquadria Battery Hull * 1
mods.gregtech.extractor.removeByInput(2, [metaitem('battery.uv.naquadria')], null)
//// Tantalum Capacitor * 8
//mods.gregtech.assembler.removeByInput(4, [metaitem('dustTantalum'), metaitem('foilManganese')], [fluid('plastic') * 144])
// Small Sodium Battery * 1
mods.gregtech.canner.removeByInput(2, [metaitem('battery.hull.lv'), metaitem('dustSodium') * 2], null)
// Medium Sodium Battery * 1
mods.gregtech.canner.removeByInput(2, [metaitem('battery.hull.mv'), metaitem('dustSodium') * 8], null)
// Large Sodium Battery * 1
mods.gregtech.canner.removeByInput(2, [metaitem('battery.hull.hv'), metaitem('dustSodium') * 16], null)
// Small Lithium Battery * 1
mods.gregtech.canner.removeByInput(2, [metaitem('battery.hull.lv'), metaitem('dustLithium') * 2], null)
// Medium Lithium Battery * 1
mods.gregtech.canner.removeByInput(2, [metaitem('battery.hull.mv'), metaitem('dustLithium') * 8], null)
// Large Lithium Battery * 1
mods.gregtech.canner.removeByInput(2, [metaitem('battery.hull.hv'), metaitem('dustLithium') * 16], null)
// Small Cadmium Battery * 1
mods.gregtech.canner.removeByInput(2, [metaitem('battery.hull.lv'), metaitem('dustCadmium') * 2], null)
// Medium Cadmium Battery * 1
mods.gregtech.canner.removeByInput(2, [metaitem('battery.hull.mv'), metaitem('dustCadmium') * 8], null)
// Large Cadmium Battery * 1
mods.gregtech.canner.removeByInput(2, [metaitem('battery.hull.hv'), metaitem('dustCadmium') * 16], null)
// Energium Crystal * 1
mods.gregtech.autoclave.removeByInput(480, [metaitem('energium_dust') * 9], [fluid('water') * 1000])
// Energium Crystal * 1
mods.gregtech.autoclave.removeByInput(320, [metaitem('energium_dust') * 9], [fluid('distilled_water') * 1000])
// Energium Crystal * 1
mods.gregtech.autoclave.removeByInput(256, [metaitem('energium_dust') * 9], [fluid('black_steel') * 288])
// Energium Crystal * 1
mods.gregtech.autoclave.removeByInput(192, [metaitem('energium_dust') * 9], [fluid('blue_steel') * 72])
//// Small Vanadium Battery * 1
//mods.gregtech.canner.removeByInput(480, [metaitem('battery.hull.ev'), metaitem('dustVanadium') * 2], null)
// Medium Vanadium Battery * 1
mods.gregtech.canner.removeByInput(1024, [metaitem('battery.hull.iv'), metaitem('dustVanadium') * 8], null)
// Large Vanadium Battery * 1
mods.gregtech.canner.removeByInput(1920, [metaitem('battery.hull.luv'), metaitem('dustVanadium') * 16], null)
// Medium Naquadria Battery * 1
mods.gregtech.canner.removeByInput(4096, [metaitem('battery.hull.zpm'), metaitem('dustNaquadria') * 8], null)
// Large Naquadria Battery * 1
mods.gregtech.canner.removeByInput(7680, [metaitem('battery.hull.uv'), metaitem('dustNaquadria') * 16], null)
// Lapotronic Energy Orb * 1
mods.gregtech.circuit_assembler.removeByInput(1024, [metaitem('circuit_board.extreme'), metaitem('plate.power_integrated_circuit') * 4, metaitem('engraved.lapotron_chip') * 24, metaitem('plate.nano_central_processing_unit') * 2, metaitem('wireFinePlatinum') * 16, metaitem('platePlatinum') * 8], [fluid('soldering_alloy') * 144])
// Lapotronic Energy Orb * 1
mods.gregtech.circuit_assembler.removeByInput(1024, [metaitem('circuit_board.extreme'), metaitem('plate.power_integrated_circuit') * 4, metaitem('engraved.lapotron_chip') * 24, metaitem('plate.nano_central_processing_unit') * 2, metaitem('wireFinePlatinum') * 16, metaitem('platePlatinum') * 8], [fluid('tin') * 288])

// Lead-Acid Batteries

crafting.addShapeless("anode_lead", metaitem('anode.lead'), [
        metaitem('plateLead'), metaitem('cableGtSingleTin')
]);

MIXER.recipeBuilder()
        .inputs(ore('dustLeadIvOxide') * 3)
        .fluidInputs(fluid('diluted_sulfuric_acid') * 1000)
        .outputs(metaitem('cathode.lead_paste'))
        .duration(80)
        .EUt(VA[LV])
        .buildAndRegister()

crafting.addShaped("cathode_lead_frame", metaitem('cathode.lead_frame'), [
        [null, null, null],
        [ore('craftingToolWireCutter'), ore('plateLead'), null],
        [null, null, null]
]);

FORMING_PRESS.recipeBuilder()
        .notConsumable(metaitem('cathode.lead_frame'))
        .inputs(ore('plateLead'))
        .outputs(metaitem('cathode.lead_frame'))
        .duration(80)
        .EUt(VA[LV])
        .buildAndRegister()

crafting.addShaped("cathode_lead", metaitem('cathode.lead'), [
        [null, metaitem('cableGtSingleTin'), ore('craftingToolWireCutter')],
        [null, metaitem('cathode.lead_frame'), null],
        [ore('craftingToolRollingPin'), metaitem('cathode.lead_paste'), null]
]);

crafting.addShaped('primitive_battery_hull_lv', metaitem('battery.primitivehull.lv'), [
        [metaitem('cableGtSingleTin'), null, metaitem('cableGtSingleTin')],
        [ore('plateEbonite'), ore('plateEbonite'), ore('plateEbonite')],
        [ore('plateEbonite'), ore('plateEbonite'), ore('plateEbonite')]
])

ASSEMBLER.recipeBuilder()
        .inputs(metaitem('cableGtSingleTin') * 2)
        .inputs(ore('plateEbonite') * 6)
        .outputs(metaitem('battery.primitivehull.lv'))
        .duration(80)
        .EUt(VA[LV])
        .buildAndRegister()

ASSEMBLER.recipeBuilder()
        .inputs(metaitem('cableGtSingleCopper') * 2)
        .inputs(ore('plateEbonite') * 8)
        .outputs(metaitem('battery.primitivehull.mv'))
        .duration(80)
        .EUt(VA[ULV])
        .buildAndRegister()

crafting.addShaped("battery_lead_acid", metaitem('battery.lead_acid'), [
        [null,                     null,                                  null],
        [metaitem('cathode.lead'), fluid('diluted_sulfuric_acid') * 1000, metaitem('anode.lead')],
        [null,                     metaitem('battery.primitivehull.lv'),  null]
]);

ASSEMBLER.recipeBuilder()
        .inputs(metaitem('battery.primitivehull.lv'))
        .inputs(ore('plateLead'))
        .inputs(metaitem('cathode.lead_frame'))
        .inputs(metaitem('cathode.lead_paste'))
        .fluidInputs(fluid('diluted_sulfuric_acid') * 1000)
        .outputs(metaitem('battery.lead_acid'))
        .duration(200)
        .EUt(VA[LV])
        .buildAndRegister()

ASSEMBLER.recipeBuilder()
        .inputs(metaitem('battery.primitivehull.mv'))
        .inputs(ore('plateLead') * 2)
        .inputs(metaitem('cathode.lead_frame') * 2)
        .inputs(metaitem('cathode.lead_paste') * 2)
        .fluidInputs(fluid('diluted_sulfuric_acid') * 2000)
        .outputs(metaitem('battery.lead_acid.mv'))
        .duration(200)
        .EUt(VA[LV])
        .buildAndRegister()

// Nickel-Iron Batteries

crafting.addShaped("electrode_steel_frame", metaitem('electrode.steel_frame'), [
        [null, null, null],
        [null, ore('plateSteel'), null],
        [ore('craftingToolHardHammer'), null, null]
]);

ASSEMBLER.recipeBuilder()
        .circuitMeta(5)
        .inputs(ore('plateSteel') * 4)
        .outputs(metaitem('battery.steel_hull.lv'))
        .duration(40)
        .EUt(VA[LV])
        .buildAndRegister()

ASSEMBLER.recipeBuilder()
        .circuitMeta(7)
        .inputs(ore('plateSteel') * 6)
        .outputs(metaitem('battery.steel_hull.mv'))
        .duration(40)
        .EUt(VA[LV])
        .buildAndRegister()

ASSEMBLER.recipeBuilder()
        .circuitMeta(9)
        .inputs(ore('plateSteel') * 8)
        .outputs(metaitem('battery.steel_hull.hv'))
        .duration(40)
        .EUt(VA[LV])
        .buildAndRegister()

FORMING_PRESS.recipeBuilder()
        .notConsumable(metaitem('electrode.steel_frame'))
        .inputs(ore('plateSteel'))
        .outputs(metaitem('electrode.steel_frame'))
        .duration(80)
        .EUt(VA[LV])
        .buildAndRegister()

MIXER.recipeBuilder()
        .inputs(ore('dustNickelSulfate') * 30)
        .inputs(ore('dustNickelChloride') * 3)
        .inputs(ore('dustBoricAcid') * 14)
        .fluidInputs(fluid('distilled_water') * 1000)
        .fluidOutputs(fluid('watts_bath_electrolyte') * 1000)
        .duration(160)
        .EUt(VA[LV])
        .buildAndRegister()

ELECTROLYTIC_CELL.recipeBuilder()
        .notConsumable(fluid('watts_bath_electrolyte') * 1000)
        .inputs(ore('foilNickel'))
        .inputs(metaitem('electrode.steel_frame'))
        .outputs(metaitem('electrode.nickeled_steel_frame'))
        .duration(160)
        .EUt(VA[LV])
        .buildAndRegister()

ELECTROLYTIC_CELL.recipeBuilder()
        .notConsumable(fluid('watts_bath_electrolyte') * 1000)
        .inputs(ore('foilNickel') * 4)
        .inputs(metaitem('battery.steel_hull.lv'))
        .outputs(metaitem('battery.ni_fe_hull.lv'))
        .duration(160)
        .EUt(VA[LV])
        .buildAndRegister()

ELECTROLYTIC_CELL.recipeBuilder()
        .notConsumable(fluid('watts_bath_electrolyte') * 1000)
        .inputs(ore('foilNickel') * 6)
        .inputs(metaitem('battery.steel_hull.mv'))
        .outputs(metaitem('battery.ni_fe_hull.mv'))
        .duration(160)
        .EUt(VA[LV])
        .buildAndRegister()

ELECTROLYTIC_CELL.recipeBuilder()
        .notConsumable(fluid('watts_bath_electrolyte') * 1000)
        .inputs(ore('foilNickel') * 8)
        .inputs(metaitem('battery.steel_hull.hv'))
        .outputs(metaitem('battery.ni_fe_hull.hv'))
        .duration(160)
        .EUt(VA[LV])
        .buildAndRegister()

ASSEMBLER.recipeBuilder()
        .inputs(metaitem('battery.ni_fe_hull.lv'))
        .inputs(metaitem('cableGtSingleTin') * 2)
        .inputs(metaitem('electrode.nickeled_steel_frame'))
        .inputs(ore('dustNickelHydroxide') * 5)
        .inputs(ore('dustIronTwoThreeOxide') * 7)
        .fluidInputs(fluid('potassium_hydroxide_solution') * 1000)
        .outputs(metaitem('battery.ni_fe.lv'))
        .duration(200)
        .EUt(VA[MV])
        .buildAndRegister()

ASSEMBLER.recipeBuilder()
        .inputs(metaitem('battery.ni_fe_hull.mv'))
        .inputs(metaitem('cableGtSingleCopper') * 2)
        .inputs(metaitem('electrode.nickeled_steel_frame') * 2)
        .inputs(ore('dustNickelHydroxide') * 10)
        .inputs(ore('dustIronTwoThreeOxide') * 14)
        .fluidInputs(fluid('potassium_hydroxide_solution') * 2000)
        .outputs(metaitem('battery.ni_fe'))
        .duration(200)
        .EUt(VA[MV])
        .buildAndRegister()

ASSEMBLER.recipeBuilder()
        .inputs(metaitem('battery.ni_fe_hull.hv'))
        .inputs(metaitem('cableGtSingleGold') * 2)
        .inputs(metaitem('electrode.nickeled_steel_frame') * 4)
        .inputs(ore('dustNickelHydroxide') * 20)
        .inputs(ore('dustIronTwoThreeOxide') * 28)
        .fluidInputs(fluid('potassium_hydroxide_solution') * 4000)
        .outputs(metaitem('battery.ni_fe.hv'))
        .duration(200)
        .EUt(VA[MV])
        .buildAndRegister()

// HV Battery Hull
ASSEMBLER.recipeBuilder()
        .circuitMeta(5)
        .inputs(ore('plateStainlessSteel') * 8)
        .inputs(ore('platePolycaprolactam'))
        .inputs(ore('foilPolyvinylChloride') * 4)
        .inputs(metaitem('cableGtSingleGold') * 4)
        .fluidInputs(fluid('polypropylene') * 1296)
        .outputs(metaitem('battery.hull.hv'))
        .duration(240)
        .EUt(VA[MV])
        .buildAndRegister()

RecyclingHelper.handleRecycling(metaitem('battery.hull.hv'),
        [ore('plateStainlessSteel') * 8, metaitem('cableGtSingleGold') * 4, ore('dustPolycaprolactam'), ore('dustPolyvinylChloride'), ore('dustPolypropylene') * 9])

ASSEMBLER.recipeBuilder()
        .circuitMeta(5)
        .inputs(ore('plateStainlessSteel') * 16)
        .inputs(metaitem('cableGtSingleAluminium') * 2)
        .fluidInputs(fluid('polytetrafluoroethylene') * 144)
        .outputs(metaitem('battery.hull.ev'))
        .duration(240)
        .EUt(VA[HV])
        .buildAndRegister()

RecyclingHelper.handleRecycling(metaitem('battery.hull.ev'),
        [ore('plateStainlessSteel') * 16, metaitem('cableGtSingleAluminium') * 2, ore('dustPolytetrafluoroethylene')])

/* Old recipes */

ROASTER.recipeBuilder()
        .inputs(ore('dustLithiumCarbonate') * 6)
        .fluidInputs(fluid('hydrogen_fluoride') * 2000)
        .fluidOutputs(fluid('dense_steam') * 1000)
        .fluidOutputs(fluid('carbon_dioxide') * 1000)
        .outputs(metaitem('dustLithiumFluoride') * 4)
        .duration(140)
        .EUt(VA[LV])
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(ore('dustLithiumFluoride') * 2)
        .inputs(ore('dustPhosphorusPentachloride') * 6)
        .fluidInputs(fluid('hydrogen_fluoride') * 5000)
        .fluidOutputs(fluid('hydrogen_chloride') * 5000)
        .outputs(metaitem('dustLithiumHexafluorophosphate') * 8)
        .duration(140)
        .EUt(VA[LV])
        .buildAndRegister()

MIXER_RECIPES.recipeBuilder()
        .inputs(ore('dustLithiumHexafluorophosphate') * 8)
        .fluidInputs(fluid('ethylene_carbonate') * 1000)
        .fluidOutputs(fluid('lithium_hexafluorophosphate_electrolyte') * 1000)
        .duration(400)
        .EUt(VA[LV])
        .buildAndRegister()

ROASTER.recipeBuilder()
        .inputs(ore('dustLithiumCarbonate') * 6)
        .inputs(ore('dustHighPurityCobaltOxide') * 4)
        .fluidOutputs(fluid('carbon_monoxide') * 1000)
        .outputs(metaitem('dustLithiumCobaltOxide') * 8)
        .duration(140)
        .EUt(VA[LV])
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(metaitem('battery.hull.hv'))
        .inputs(ore('dustGraphite') * 4)
        .inputs(ore('dustLithiumCobaltOxide') * 4)
        .fluidInputs(fluid('lithium_hexafluorophosphate_electrolyte') * 500)
        .outputs(metaitem('battery.re.hv.lithium'))
        .duration(400)
        .EUt(16)
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(metaitem('battery.hull.hv'))
        .inputs(ore('dustCadmium') * 4)
        .inputs(ore('dustNickelHydroxide') * 10)
        .fluidInputs(fluid('potassium_hydroxide_solution') * 500)
        .outputs(metaitem('battery.re.hv.cadmium'))
        .duration(400)
        .EUt(16)
        .buildAndRegister()




