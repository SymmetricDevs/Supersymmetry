import globals.Globals
import globals.GroovyUtils

import gregtech.api.recipes.recipeproperties.RecipeProperty;
import gregtech.api.recipes.RecipeBuilder;
import static gregtech.api.recipes.RecipeMaps.*;
import gregtech.api.unification.material.Materials.*;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;

CSTR = recipemap('continuous_stirred_tank_reactor')
ROASTER = recipemap('roaster')
MIXER = recipemap('mixer')
BR = recipemap('batch_reactor')
BCR = recipemap('bubble_column_reactor')
BENDER = recipemap('bender')
ASSEMBLER = recipemap('assembler')

crafting.addShaped("battery_lead_acid", metaitem('battery.lead_acid'), [
        [metaitem('plateBatteryAlloy'), metaitem('cableGtSingleTin'), metaitem('plateBatteryAlloy')],
        [metaitem('cathode.lead'),fluid('sulfuric_acid') * 1000, metaitem('anode.lead')],
        [metaitem('plateBatteryAlloy'), metaitem('plateBatteryAlloy'), metaitem('plateBatteryAlloy')]
]);

crafting.addShaped("cathode_lead", metaitem('cathode.lead'), [
        [null,null,null],
        [metaitem('cableGtSingleTin'), metaitem('plateLead'),null],
        [null,null,null]
]);

crafting.addShaped("anode_lead", metaitem('anode.lead'), [
        [null,null,null],
        [null,metaitem('plateLead'),metaitem('cableGtSingleTin')],
        [null,null,null]
]);

mods.gregtech.assembler.recipeBuilder()
        .inputs(metaitem('battery.hull.lv'))
        .inputs(ore('plateLead') * 2)
        .fluidInputs(fluid('sulfuric_acid') * 1000)
        .outputs(metaitem('battery.lead_acid'))
        .duration(100)
        .EUt(16)
        .buildAndRegister()

MIXER_RECIPES.recipeBuilder()
        .fluidInputs(Materials.SulfurTrioxide.getFluid(1000))
        .fluidInputs(Materials.Water.getFluid(1000))
        .fluidOutputs(Materials.SulfuricAcid.getFluid(1000))
        .EUt(7)
        .duration(40)
        .buildAndRegister()

mods.gregtech.electric_blast_furnace.recipeBuilder()
        .inputs(ore('dustSodium') * 4)
        .inputs(ore('dustIron') * 3)
        .inputs(ore('dustManganese') * 3)
        .fluidInputs(fluid('oxygen') * 12000)
        .outputs(metaitem('dustSodiumCathodeAlloy') * 10)
        .blastFurnaceTemp(1250)
        .duration(300)
        .EUt(30)
        .buildAndRegister()

CSTR.recipeBuilder()
        .fluidInputs(fluid('phosgene') * 50)
        .fluidInputs(fluid('methanol') * 100)
        .fluidOutputs(fluid('dimethyl_carbonate') * 50)
        .fluidOutputs(fluid('hydrogen_chloride') * 100)
        .duration(1)
        .EUt(30)
        .buildAndRegister()

ROASTER.recipeBuilder()
        .inputs(ore('dustLithiumCarbonate') * 6)
        .fluidInputs(fluid('hydrogen_fluoride') * 2000)
        .fluidOutputs(fluid('dense_steam') * 1000)
        .fluidOutputs(fluid('carbon_dioxide') * 1000)
        .outputs(metaitem('dustLithiumFluoride') * 4)
        .duration(140)
        .EUt(30)
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(ore('dustLithiumFluoride') * 2)
        .inputs(ore('dustPhosphorusPentachloride') * 6)
        .fluidInputs(fluid('hydrogen_fluoride') * 5000)
        .fluidOutputs(fluid('hydrogen_chloride') * 5000)
        .outputs(metaitem('dustLithiumHexafluorophosphate') * 8)
        .duration(140)
        .EUt(30)
        .buildAndRegister()

BCR.recipeBuilder()
        .fluidInputs(fluid('ethylene_oxide') * 50)
        .fluidInputs(fluid('carbon_dioxide') * 50)
        .fluidOutputs(fluid('ethylene_carbonate') * 50)
        .duration(5)
        .EUt(30)
        .buildAndRegister()

MIXER_RECIPES.recipeBuilder()
        .inputs(ore('dustLithiumHexafluorophosphate') * 8)
        .fluidInputs(fluid('ethylene_carbonate') * 1000)
        .fluidOutputs(fluid('lithium_hexafluorophosphate_electrolyte') * 1000)
        .duration(400)
        .EUt(30)
        .buildAndRegister()

ROASTER.recipeBuilder()
        .inputs(ore('dustLithiumCarbonate') * 6)
        .inputs(ore('dustCobaltOxide') * 4)
        .fluidOutputs(fluid('carbon_monoxide') * 1000)
        .outputs(metaitem('dustLithiumCobaltOxide') * 8)
        .duration(140)
        .EUt(30)
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(metaitem('battery.hull.lv'))
        .inputs(ore('dustCarbon'))
        .inputs(ore('dustSodiumCathodeAlloy'))
        .fluidInputs(fluid('dimethyl_carbonate') * 100)
        .outputs(metaitem('battery.re.lv.sodium'))
        .duration(100)
        .EUt(16)
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(metaitem('battery.hull.mv'))
        .inputs(ore('dustCarbon') * 2)
        .inputs(ore('dustSodiumCathodeAlloy') * 2)
        .fluidInputs(fluid('dimethyl_carbonate') * 200)
        .outputs(metaitem('battery.re.mv.sodium'))
        .duration(200)
        .EUt(16)
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(metaitem('battery.hull.hv'))
        .inputs(ore('dustCarbon') * 4)
        .inputs(ore('dustSodiumCathodeAlloy') * 4)
        .fluidInputs(fluid('dimethyl_carbonate') * 500)
        .outputs(metaitem('battery.re.hv.sodium'))
        .duration(400)
        .EUt(16)
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(metaitem('battery.hull.lv'))
        .inputs(ore('dustGraphite'))
        .inputs(ore('dustLithiumCobaltOxide'))
        .fluidInputs(fluid('lithium_hexafluorophosphate_electrolyte') * 100)
        .outputs(metaitem('battery.re.lv.lithium'))
        .duration(100)
        .EUt(16)
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(metaitem('battery.hull.mv'))
        .inputs(ore('dustGraphite') * 2)
        .inputs(ore('dustLithiumCobaltOxide') * 2)
        .fluidInputs(fluid('lithium_hexafluorophosphate_electrolyte') * 200)
        .outputs(metaitem('battery.re.mv.lithium'))
        .duration(200)
        .EUt(16)
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
        .inputs(metaitem('battery.hull.lv'))
        .inputs(ore('dustCadmium'))
        .inputs(ore('dustNickelOxideHydroxide'))
        .fluidInputs(fluid('potassium_hydroxide_solution') * 100)
        .outputs(metaitem('battery.re.lv.cadmium'))
        .duration(100)
        .EUt(16)
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(metaitem('battery.hull.mv'))
        .inputs(ore('dustCadmium') * 2)
        .inputs(ore('dustNickelOxideHydroxide') * 2)
        .fluidInputs(fluid('potassium_hydroxide_solution') * 200)
        .outputs(metaitem('battery.re.mv.cadmium'))
        .duration(200)
        .EUt(16)
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(metaitem('battery.hull.hv'))
        .inputs(ore('dustCadmium') * 4)
        .inputs(ore('dustNickelOxideHydroxide') * 4)
        .fluidInputs(fluid('potassium_hydroxide_solution') * 500)
        .outputs(metaitem('battery.re.hv.cadmium'))
        .duration(400)
        .EUt(16)
        .buildAndRegister()

// NiO(OH) cathode line

ROASTER.recipeBuilder()
        .inputs(ore('dustNickel') * 1)
        .fluidInputs(fluid('chlorine') * 2000)
        .outputs(metaitem('dustNickelChloride') * 3)
        .duration(100)
        .EUt(30)
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(ore('dustNickelChloride') * 3)
        .fluidInputs(fluid('potassium_hydroxide_solution') * 2000)
        .outputs(metaitem('dustNickelHydroxide') * 5)
        .fluidOutputs(fluid('potassium_chloride_solution') * 2000)
        .duration(100)
        .EUt(30)
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(ore('dustNickelHydroxide') * 5)
        .fluidInputs(fluid('potassium_hydroxide_solution') * 1000)
        .fluidInputs(fluid('chlorine') * 1000)
        .outputs(metaitem('dustNickelOxideHydroxide') * 4)
        .fluidOutputs(fluid('diluted_rock_salt_solution') * 2000)
        .duration(100)
        .EUt(30)
        .buildAndRegister()

BENDER.recipeBuilder()
        .inputs(ore('foilNickel'))
        .inputs(ore('dustSmallNickelOxideHydroxide'))
        .outputs(metaitem('cathode.niooh'))
        .duration(200)
        .EUt(30)
        .buildAndRegister()

// NiFe Battery

ASSEMBLER.recipeBuilder()
        .inputs(metaitem('battery.hull.mv'))
        .inputs(ore('plateIron'))
        .inputs(ore('dustNickelOxideHydroxide') * 4)
        .fluidInputs(fluid('potassium_hydroxide_solution') * 1000)
        .outputs(GroovyUtils.makeCharged(metaitem('battery.ni_fe')))
        .duration(400)
        .EUt(30)
        .buildAndRegister()

// MnO2 cathode line

MIXER.recipeBuilder()
        .inputs(ore('dustManganeseDioxide') * 27) // MnO2 * 9
        .inputs(ore('dustGraphite'))
        .outputs(metaitem('dustManganeseDioxideCathode') * 28)
        .duration(200)
        .EUt(30)
        .buildAndRegister()

// RAM Battery

ASSEMBLER.recipeBuilder()
        .inputs(metaitem('battery.hull.mv'))
        .inputs(ore('foilZinc') * 4)
        .inputs(ore('dustManganeseDioxideCathode') * 7)
        .inputs(item('minecraft:paper'))
        .fluidInputs(fluid('potassium_hydroxide_solution') * 1000)
        .outputs(GroovyUtils.makeCharged(metaitem('battery.ram')))
        .duration(200)
        .EUt(120)
        .buildAndRegister()

// Remove Batteries

// Sodium Battery
mods.gregtech.canner.removeByInput(2, [metaitem('battery.hull.lv'), metaitem('dustSodium') * 2], null)
mods.gregtech.canner.removeByInput(2, [metaitem('battery.hull.mv'), metaitem('dustSodium') * 8], null)
mods.gregtech.canner.removeByInput(2, [metaitem('battery.hull.hv'), metaitem('dustSodium') * 16], null)
// Lithium Battery
mods.gregtech.canner.removeByInput(2, [metaitem('battery.hull.lv'), metaitem('dustLithium') * 2], null)
mods.gregtech.canner.removeByInput(2, [metaitem('battery.hull.mv'), metaitem('dustLithium') * 8], null)
mods.gregtech.canner.removeByInput(2, [metaitem('battery.hull.hv'), metaitem('dustLithium') * 16], null)
// Cadmium Battery
mods.gregtech.canner.removeByInput(2, [metaitem('battery.hull.lv'), metaitem('dustCadmium') * 2], null)
mods.gregtech.canner.removeByInput(2, [metaitem('battery.hull.mv'), metaitem('dustCadmium') * 8], null)
mods.gregtech.canner.removeByInput(2, [metaitem('battery.hull.hv'), metaitem('dustCadmium') * 16], null)
// Energy crystal
mods.gregtech.autoclave.removeByInput(480, [metaitem('energium_dust') * 9], [fluid('water') * 1000])
mods.gregtech.autoclave.removeByInput(320, [metaitem('energium_dust') * 9], [fluid('distilled_water') * 1000])
mods.gregtech.autoclave.removeByInput(256, [metaitem('energium_dust') * 9], [fluid('black_steel') * 288])
mods.gregtech.autoclave.removeByInput(192, [metaitem('energium_dust') * 9], [fluid('blue_steel') * 72])
// Lapotron
mods.gregtech.autoclave.removeByInput(480, [metaitem('dustLapotron') * 15], [fluid('water') * 1000])
mods.gregtech.autoclave.removeByInput(320, [metaitem('dustLapotron') * 15], [fluid('distilled_water') * 1000])
mods.gregtech.autoclave.removeByInput(256, [metaitem('dustLapotron') * 15], [fluid('blue_steel') * 288])
mods.gregtech.autoclave.removeByInput(192, [metaitem('dustLapotron') * 15], [fluid('red_steel') * 72])

mods.jei.ingredient.removeAndHide(metaitem('energy_crystal'));
mods.jei.ingredient.removeAndHide(metaitem('lapotron_crystal'));

mods.jei.ingredient.removeAndHide(metaitem('energy.lapotronic_orb'));
mods.jei.ingredient.removeAndHide(metaitem('energy.lapotronic_orb_cluster'));
mods.jei.ingredient.removeAndHide(metaitem('energy.module'));
mods.jei.ingredient.removeAndHide(metaitem('energy.cluster'));
mods.jei.ingredient.removeAndHide(metaitem('max.battery'));

