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
    metaitem('battery.re.ulv.tantalum'),
    metaitem('battery.zpm.naquadria'),
    metaitem('battery.uv.naquadria'),
    metaitem('energy.module'),
    metaitem('energy.cluster'),
    metaitem('max.battery'),
)

[
    metaitem('battery.re.lv.sodium'),
    metaitem('battery.re.mv.sodium'),
    metaitem('battery.re.hv.sodium'),
    metaitem('battery.re.lv.lithium'),
    metaitem('battery.re.mv.lithium'),
    metaitem('battery.re.hv.lithium'),
    metaitem('battery.re.lv.cadmium'),
    metaitem('battery.re.mv.cadmium'),
    metaitem('battery.re.hv.cadmium'),
    metaitem('energy_crystal'),
    metaitem('lapotron_crystal'),
    metaitem('battery.ev.vanadium'),
    metaitem('battery.iv.vanadium'),
    metaitem('battery.luv.vanadium'),
    metaitem('energy.lapotronic_orb'),
    metaitem('energy.lapotronic_orb_cluster'),
].each { battery ->
    crafting.removeByInput(battery)
    mods.jei.ingredient.yeet(battery)
}

['lv', 'mv', 'hv', 'iv', 'ev', 'luv', 'zpm', 'uv'].each { voltage ->
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
    .circuitMeta(1)
    .inputs(metaitem('cableGtSingleTin') * 2)
    .inputs(ore('plateEbonite') * 6)
    .outputs(metaitem('battery.primitivehull.lv'))
    .duration(20)
    .EUt(VA[ULV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .circuitMeta(2)
    .inputs(metaitem('cableGtSingleCopper') * 2)
    .inputs(ore('plateEbonite') * 8)
    .outputs(metaitem('battery.primitivehull.mv'))
    .duration(20)
    .EUt(VA[LV])
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

// Nickel-Cadmium Battery

MIXER.recipeBuilder()
    .inputs(ore('dustPolycaprolactam'))
    .fluidInputs(fluid('tetrahydrofuran') * 720)
    .fluidOutputs(fluid('polycaprolactam_solution') * 720)
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister()

CHEMICAL_BATH.recipeBuilder()
    .inputs(ore('foilPlastic'))
    .fluidInputs(fluid('polycaprolactam_solution') * 144)
    .outputs(metaitem('membrane.cast_film'))
    .EUt(VA[ULV])
    .duration(40)
    .buildAndRegister()

CHEMICAL_BATH.recipeBuilder()
    .inputs(metaitem('membrane.cast_film'))
    .fluidInputs(fluid('water') * 500)
    .outputs(metaitem('membrane.caprolactam_wet'))
    .fluidOutputs(fluid('wastewater') * 100)
    .outputs(metaitem('foilPlastic'))
    .EUt(VA[HV])
    .duration(100)
    .buildAndRegister()

DRYER.recipeBuilder()
    .inputs(metaitem('membrane.caprolactam_wet'))
    .outputs(metaitem('membrane.caprolactam'))
    .fluidOutputs(fluid('dense_steam') * 100)
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister()

ELECTROLYTIC_CELL.recipeBuilder()
    .notConsumable(fluid('watts_bath_electrolyte') * 1000)
    .inputs(ore('foilNickel'))
    .inputs(ore('foilSteel'))
    .outputs(metaitem('electrode.nickeled_steel_foil'))
    .duration(160)
    .EUt(VA[LV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('electrode.nickeled_steel_foil'))
    .inputs(ore('dustNickel'))
    .inputs(ore('dustSodiumCarboxymethylCellulose'))
    .outputs(metaitem('cathode.nioh2'))
    .duration(200)
    .EUt(VA[MV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('electrode.nickeled_steel_foil') * 2)
    .inputs(ore('dustNickel') * 2)
    .inputs(ore('dustPolytetrafluoroethylene'))
    .outputs(metaitem('cathode.nioh2') * 2)
    .duration(150)
    .EUt(VA[HV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('electrode.nickeled_steel_foil') * 4)
    .inputs(ore('dustNickel') * 4)
    .inputs(ore('dustPolyvinylideneFluoride'))
    .outputs(metaitem('cathode.nioh2') * 4)
    .duration(100)
    .EUt(VA[EV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .circuitMeta(5)
    .inputs(ore('plateStainlessSteel') * 4)
    .inputs(ore('ringStainlessSteel'))
    .inputs(ore('nuggetStainlessSteel'))
    .outputs(metaitem('battery.stainless_steel_hull.hv'))
    .duration(40)
    .EUt(VA[HV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .circuitMeta(7)
    .inputs(ore('plateStainlessSteel') * 6)
    .inputs(ore('ringStainlessSteel'))
    .inputs(ore('nuggetStainlessSteel'))
    .outputs(metaitem('battery.stainless_steel_hull.ev'))
    .duration(40)
    .EUt(VA[HV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .circuitMeta(9)
    .inputs(ore('plateStainlessSteel') * 8)
    .inputs(ore('ringStainlessSteel') * 2)
    .inputs(ore('nuggetStainlessSteel') * 2)
    .outputs(metaitem('battery.stainless_steel_hull.iv'))
    .duration(40)
    .EUt(VA[HV])
    .buildAndRegister()

ARC_FURNACE.recipeBuilder()
    .fluidInputs(fluid('oxygen') * 1000)
    .inputs(ore('dustCadmium'))
    .outputs(metaitem('dustCadmiumOxide'))
    .EUt(VA[HV])
    .duration(100)
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('electrode.nickeled_steel_foil'))
    .inputs(ore('dustCadmiumOxide'))
    .inputs(ore('dustPolytetrafluoroethylene'))
    .inputs(ore('dustAnyPurityCarbon'))
    .outputs(metaitem('anode.cadmium_oxide'))
    .duration(200)
    .EUt(VA[HV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('electrode.nickeled_steel_foil') * 2)
    .inputs(ore('dustCadmiumOxide') * 2)
    .inputs(ore('dustPolyvinylideneFluoride'))
    .inputs(ore('dustAnyPurityCarbon'))
    .outputs(metaitem('anode.cadmium_oxide') * 2)
    .duration(150)
    .EUt(VA[HV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('battery.stainless_steel_hull.hv'))
    .inputs(metaitem('cableGtSingleGold') * 2)
    .inputs(metaitem('membrane.caprolactam'))
    .inputs(metaitem('anode.cadmium_oxide'))
    .inputs(metaitem('cathode.nioh2'))
    .fluidInputs(fluid('potassium_hydroxide_solution') * 1050)
    .outputs(metaitem('battery.ni_cd.mv'))
    .duration(200)
    .EUt(VA[HV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('battery.stainless_steel_hull.ev'))
    .inputs(metaitem('cableGtSingleAluminium') * 2)
    .inputs(metaitem('membrane.caprolactam') * 2)
    .inputs(metaitem('anode.cadmium_oxide') * 2)
    .inputs(metaitem('cathode.nioh2') * 2)
    .fluidInputs(fluid('potassium_hydroxide_solution') * 2050)
    .outputs(metaitem('battery.ni_cd.hv'))
    .duration(200)
    .EUt(VA[HV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('battery.stainless_steel_hull.iv'))
    .inputs(metaitem('cableGtSinglePlatinum') * 2)
    .inputs(metaitem('membrane.caprolactam') * 4)
    .inputs(metaitem('anode.cadmium_oxide') * 4)
    .inputs(metaitem('cathode.nioh2') * 4)
    .fluidInputs(fluid('potassium_hydroxide_solution') * 4050)
    .outputs(metaitem('battery.ni_cd.ev'))
    .duration(200)
    .EUt(VA[HV])
    .buildAndRegister()

// Nickel Metal Hydride Battery

// Liquid AB-2 Metal Alloy * 4320
mods.gregtech.advanced_arc_furnace.removeByInput(1920, [metaitem('dustHighPurityZirconium') * 8, metaitem('dustTitanium') * 2, metaitem('dustVanadium') * 6, metaitem('dustManganese') * 3, metaitem('dustPalladium'), metaitem('dustNickel') * 8, metaitem('dustIron') * 2, metaitem('circuit.integrated').withNbt(['Configuration': 17])], [fluid('refractory_gunning_mixture') * 1700, fluid('argon') * 1500])
mods.gregtech.advanced_arc_furnace.removeByInput(1920, [metaitem('dustHighPurityZirconium') * 8, metaitem('dustTitanium') * 2, metaitem('dustVanadium') * 6, metaitem('dustManganese') * 3, metaitem('dustPalladium'), metaitem('dustNickel') * 8, metaitem('dustIron') * 2, metaitem('circuit.integrated').withNbt(['Configuration': 7])], [fluid('refractory_gunning_mixture') * 2600])

// Liquid Annealed AB-5 Metal Alloy * 8640
mods.gregtech.advanced_arc_furnace.removeByInput(1920, [metaitem('dustLanthanum') * 8, metaitem('dustHighPurityZirconium') * 2, metaitem('dustNickel') * 45, metaitem('dustAluminium') * 5, metaitem('circuit.integrated').withNbt(['Configuration': 14])], [fluid('refractory_gunning_mixture') * 3650, fluid('argon') * 3000])
mods.gregtech.advanced_arc_furnace.removeByInput(1920, [metaitem('dustLanthanum') * 8, metaitem('dustHighPurityZirconium') * 2, metaitem('dustNickel') * 45, metaitem('dustAluminium') * 5, metaitem('circuit.integrated').withNbt(['Configuration': 4])], [fluid('refractory_gunning_mixture') * 5550])


ADVANCED_ARC_FURNACE.recipeBuilder()
    .inputs(ore('dustHighPurityZirconium') * 8)
    .inputs((ore('dustAnyPurityTitanium') * 2))
    .inputs(ore('dustAnyPurityVanadium') * 6)
    .inputs(ore('dustAnyPurityManganese') * 3)
    .inputs(ore('dustAnyPurityPalladium'))
    .inputs(ore('dustAnyPurityNickel') * 8)
    .inputs(ore('dustAnyPurityIron') * 2)
    .fluidInputs(fluid('argon') * 4000)
    .fluidOutputs(fluid('ab_2_metal_alloy') * 4320)
    .duration(445)
    .EUt(VA[EV])
    .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
    .inputs(ore('dustLanthanum') * 8)
    .inputs(ore('dustHighPurityZirconium') * 2)
    .inputs(ore('dustAnyPurityNickel') * 45)
    .inputs(ore('dustAnyPurityAluminium') * 5)
    .fluidInputs(fluid('argon') * 4000)
    .fluidOutputs(fluid('ab_5_metal_alloy') * 8640)
    .duration(845)
    .EUt(VA[EV])
    .buildAndRegister()

ARC_FURNACE.recipeBuilder()
    .fluidInputs(fluid('oxygen') * 100)
    .inputs(metaitem('ingotAb2MetalAlloy'))
    .outputs(metaitem('ingotAnnealedAb2MetalAlloy'))
    .EUt(VA[HV])
    .duration(120)
    .buildAndRegister()

ARC_FURNACE.recipeBuilder()
    .fluidInputs(fluid('oxygen') * 100)
    .inputs(metaitem('ingotAb5MetalAlloy'))
    .outputs(metaitem('ingotAnnealedAb5MetalAlloy'))
    .EUt(VA[EV])
    .duration(120)
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustAnnealedAb2MetalAlloy') * 6)
    .inputs(ore('dustAnnealedAb5MetalAlloy') * 3)
    .inputs(ore('dustHighPurityCopper'))
    .outputs(metaitem('dustMetalHydrideMixAnode') * 10)
    .EUt(VA[EV])
    .duration(20)
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('electrode.nickeled_steel_foil'))
    .inputs(ore('dustMetalHydrideMixAnode'))
    .inputs(ore('dustPolyvinylideneFluoride'))
    .inputs(ore('dustAnyPurityCarbon'))
    .outputs(metaitem('anode.mh'))
    .duration(200)
    .EUt(VA[EV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('battery.stainless_steel_hull.hv'))
    .inputs(metaitem('cableGtSingleAluminium') * 2)
    .inputs(metaitem('membrane.caprolactam'))
    .inputs(metaitem('anode.mh'))
    .inputs(metaitem('cathode.nioh2'))
    .fluidInputs(fluid('potassium_hydroxide_solution') * 1050)
    .outputs(metaitem('battery.ni_mh.hv'))
    .duration(200)
    .EUt(VA[EV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('battery.stainless_steel_hull.ev'))
    .inputs(metaitem('cableGtSinglePlatinum') * 2)
    .inputs(metaitem('membrane.caprolactam') * 2)
    .inputs(metaitem('anode.mh') * 2)
    .inputs(metaitem('cathode.nioh2') * 2)
    .fluidInputs(fluid('potassium_hydroxide_solution') * 2050)
    .outputs(metaitem('battery.ni_mh.ev'))
    .duration(200)
    .EUt(VA[EV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('battery.stainless_steel_hull.iv'))
    .inputs(metaitem('cableGtSinglePlatinum') * 2)
    .inputs(metaitem('membrane.caprolactam') * 4)
    .inputs(metaitem('anode.mh') * 4)
    .inputs(metaitem('cathode.nioh2') * 4)
    .fluidInputs(fluid('potassium_hydroxide_solution') * 4050)
    .outputs(metaitem('battery.ni_mh.iv'))
    .duration(200)
    .EUt(VA[EV])
    .buildAndRegister()

// HV Battery Hull  TO CHANGE
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

RecyclingHelper.removeRecyclingRecipes(metaitem('battery.hull.hv'))
RecyclingHelper.handleRecycling(metaitem('battery.hull.hv'), [ore('plateStainlessSteel') * 8, metaitem('cableGtSingleGold') * 4, ore('dustPolycaprolactam'), ore('dustPolyvinylChloride'), ore('dustPolypropylene') * 9])

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

//Vanadium flow battery (for PSS)

//Electrode
//Source: https://hal.umontpellier.fr/hal-01670248/file/Carbon%2C%202017%2C%20122%2C%20564-591.pdf
EXTRUDER.recipeBuilder()
    .notConsumable(metaitem('shape.extruder.wire'))
    .inputs(ore('boltSteel'))
    .outputs(metaitem('needle.steel') * 4)
    .duration(50)
    .EUt(VA[MV])
    .buildAndRegister()

BENDER.recipeBuilder()
    .inputs(metaitem('needle.steel'))
    .outputs(metaitem('needle.steel.barbed'))
    .duration(5)
    .EUt(VA[LV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('needle.steel.barbed') * 64)
    .inputs(ore('plateSteel'))
    .outputs(metaitem('needle_assembly.steel.barbed'))
    .duration(270)
    .EUt(VA[MV])
    .buildAndRegister()

// Thin Polyacrylonitrile (PAN) Sheet * 4
mods.gregtech.extruder.removeByInput(24, [metaitem('ingotPolyacrylonitrile'), metaitem('shape.extruder.foil')], null)
// Thin Polyacrylonitrile (PAN) Sheet * 4
mods.gregtech.extruder.removeByInput(24, [metaitem('dustPolyacrylonitrile'), metaitem('shape.extruder.foil')], null)

ASSEMBLER.recipeBuilder()
    .inputs(ore('threadPolyacrylonitrile') * 8)
    .circuitMeta(2)
    .outputs(metaitem('foilPolyacrylonitrile'))
    .duration(40)
    .EUt(VA[MV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .notConsumable(metaitem('needle_assembly.steel.barbed'))
    .inputs(ore('foilPolyacrylonitrile'))
    .outputs(metaitem('foil.punched_polyacrylonitrile'))
    .duration(40)
    .EUt(VA[MV])
    .buildAndRegister()

TUBE_FURNACE.recipeBuilder()
    .fluidInputs(fluid('argon') * 50)
    .inputs(metaitem('foil.punched_polyacrylonitrile'))
    .outputs(metaitem('foil.carbon_felt'))
    .duration(300)
    .EUt(VA[EV])
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(metaitem('foil.carbon_felt'))
    .fluidInputs(fluid('oxygen') * 1000)
    .outputs(metaitem('foil.activated_carbon_felt'))
    .duration(180)
    .EUt(VA[MV])
    .buildAndRegister()

//Membrane
//Source (DADMAC): https://en.wikipedia.org/wiki/PolyDADMAC
CSTR.recipeBuilder()
    .fluidInputs(fluid('allyl_chloride') * 100)
    .fluidInputs(fluid('dimethylamine') * 50)
    .notConsumable(metaitem('springKanthal'))
    .fluidOutputs(fluid('diallyldimethylammonium_chloride') * 50)
    .fluidOutputs(fluid('hydrogen_chloride') * 50)
    .duration(5)
    .EUt(VA[MV])
    .buildAndRegister()

MIXER.recipeBuilder()
    .fluidInputs(fluid('diallyldimethylammonium_chloride') * 1000)
    .fluidInputs(fluid('deionized_water') * 1000)
    .fluidOutputs(fluid('diallyldimethylammonium_chloride_solution') * 2000)
    .duration(40)
    .EUt(VA[LV])
    .buildAndRegister()

POLYMERIZATION_TANK.recipeBuilder()
    .fluidInputs(fluid('diallyldimethylammonium_chloride_solution') * 2000)
    .fluidInputs(fluid('tert_butyl_hydroperoxide') * 50)
    .fluidOutputs(fluid('polydiallyldimethylammonium_chloride_solution') * 2000)
    .duration(200)
    .EUt(VA[MV])
    .buildAndRegister()

//Source (membrane): https://advanced.onlinelibrary.wiley.com/doi/10.1002/adfm.202109427
//Free version: https://sci-hub.st/https://advanced.onlinelibrary.wiley.com/doi/10.1002/adfm.202109427
//source wasn't 100% clear on the manufacturing process, verification would be appreciated

BR.recipeBuilder()
    .inputs(metaitem('dustGrapheneOxide'))
    .fluidInputs(fluid('sodium_tungstate_solution') * 300)//0.3 H20, 0.6 Na
    .fluidInputs(fluid('polydiallyldimethylammonium_chloride_solution') * 600)//0.3 H2O
    .fluidOutputs(fluid('graphene_oxide_tungstate_solution') * 900)//0.6 H2O, 0.3 polydadmac, 0.6 Na
    .duration(200)
    .EUt(VA[MV])
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('graphene_oxide_tungstate_solution') * 900)//0.6 H2O, 0.3 polydadmac, 0.6 Na
    .fluidInputs(fluid('hydrochloric_acid') * 600)//0.6 H2O, 0.6 Cl
    .fluidOutputs(fluid('acidified_graphene_oxide_tungstate_solution') * 1500)// 1.2 H2O, 0.3 polydadmac, 0.6 NaCl
    .duration(200)
    .EUt(VA[MV])
    .buildAndRegister()

CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('acidified_graphene_oxide_tungstate_solution') * 1500)
    .fluidInputs(fluid('deionized_water') * 2000)
    .outputs(metaitem('dustAcidifiedGrapheneOxideTungstate'))//0.3 dadmac goes into the dust
    .fluidOutputs(fluid('wastewater') * 3200)
    .duration(200)
    .EUt(VA[MV])
    .buildAndRegister()

TUBE_FURNACE.recipeBuilder() //source says "annealed in a muffle furnace", tube furnace is imo the closest, though it could be the resistance furnace
    .inputs(metaitem('dustAcidifiedGrapheneOxideTungstate'))
    .outputs(metaitem('dustTungstenModifiedGrapheneOxideNanosheet'))
    .duration(200)
    .EUt(VA[HV])
    .buildAndRegister()

MIXER.recipeBuilder()
    .fluidInputs(fluid('isopropyl_alcohol') * 1000)
    .inputs(metaitem('dustNafion'))
    .fluidOutputs(fluid('nafion_dispersion') * 1000)
    .duration(140)
    .EUt(VA[MV])
    .buildAndRegister()

MIXER.recipeBuilder()
    .fluidInputs(fluid('nafion_dispersion') * 1000)
    .inputs(metaitem('dustTinyTungstenModifiedGrapheneOxideNanosheet'))
    .fluidOutputs(fluid('nanoparticle_modified_nafion_dispersion') * 1000)
    .duration(320)
    .EUt(VA[EV])
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('nanoparticle_modified_nafion_dispersion') * 1000)
    .outputs(metaitem('dustNanoparticleModifiedNafion'))
    .fluidOutputs(fluid('isopropyl_alcohol') * 1000)
    .duration(400)
    .EUt(VA[LV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('foilNanoparticleModifiedNafion') * 4)
    .inputs(metaitem('foilExpandedPolytetrafluoroethylene') * 4)
    .outputs(metaitem('membrane.vanadium_battery'))
    .duration(50)
    .EUt(VA[MV])
    .buildAndRegister()

//Graphite paper
//Source (expandable graphite): https://en.wikipedia.org/wiki/Expandable_graphite
BR.recipeBuilder()
    .inputs(metaitem('dustGraphite') * 4)
    .inputs(metaitem('dustPotassiumPermanganate') * 6)
    .fluidInputs(fluid('sulfuric_acid') * 1000)
    .outputs(metaitem('dustExpandableGraphite') * 4)
    .duration(360)
    .EUt(VA[HV])
    .buildAndRegister()

//Source (graphite paper): https://patents.google.com/patent/CN114853475A/en
BENDER.recipeBuilder()
    .inputs(metaitem('expanded_graphite_worms') * 2)
    .outputs(metaitem('graphite_paper'))
    .duration(120)
    .EUt(VA[MV])
    .buildAndRegister()

//Assembly
ASSEMBLER.recipeBuilder()
    .inputs(item('gregtech:machine_casing', 4))
    .inputs(metaitem('large_fluid_cell.titanium') * 2)
    .inputs(metaitem('electric.pump.hv') * 2)
    .inputs(ore('pipeSmallFluidPolytetrafluoroethylene') * 6)
    .inputs(metaitem('cableGtQuadrupleSilver') * 2)
    .outputs(item('gregtech:battery_block'))
    .duration(180)
    .EUt(VA[EV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(item('gregtech:battery_block'))
    .inputs(metaitem('graphite_paper') * 2)
    .inputs(metaitem('platePolytetrafluoroethylene') * 2)
    .inputs(metaitem('foil.activated_carbon_felt') * 2)
    .inputs(metaitem('plateGraphite') * 2)
    .inputs(metaitem('plateCopper') * 2)
    .inputs(metaitem('membrane.vanadium_battery'))
    .inputs(metaitem('cableGtSinglePlatinum') * 2)
    .fluidInputs(fluid('vanadyl_sulfate_solution') * 8000)
    .fluidInputs(fluid('vanadium_iii_sulfate_solution') * 8000)
    .outputs(item('gregtech:battery_block', 1))
    .duration(240)
    .EUt(VA[EV])
    .buildAndRegister()

//Removing old recipes
mods.gregtech.assembler.removeByInput(480, [metaitem('frameUltimet'), metaitem('plateUltimet') * 6, metaitem('screwUltimet') * 24], null)
mods.gregtech.packer.removeByInput(30, [item('gregtech:battery_block', 1), metaitem('circuit.integrated').withNbt(['Configuration': 2])], null)
mods.gregtech.packer.removeByInput(30, [item('gregtech:battery_block', 2), metaitem('circuit.integrated').withNbt(['Configuration': 2])], null)
mods.gregtech.macerator.removeByInput(32, [item('gregtech:battery_block')], null)
mods.gregtech.arc_furnace.removeByInput(30, [item('gregtech:battery_block')], [fluid('oxygen') * 650])
