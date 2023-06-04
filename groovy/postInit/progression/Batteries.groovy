import static globals.Globals.*

import gregtech.api.recipes.recipeproperties.RecipeProperty;
import gregtech.api.recipes.RecipeBuilder;
import static gregtech.api.recipes.RecipeMaps.*;
import gregtech.api.unification.material.Materials.*;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;

//REMOVALS
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


CSTR = recipemap('continuous_stirred_tank_reactor')
ROASTER = recipemap('roaster')
BR = recipemap('batch_reactor')
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

crafting.addShaped("drum_lead", metaitem('drum.lead'), [
        [null,ore('craftingToolHardHammer'),null],
        [metaitem('plateLead'),metaitem('stickLongLead'),metaitem('plateLead')],
        [metaitem('plateLead'),metaitem('stickLongLead'),metaitem('plateLead')]
]);

crafting.addShapeless("drum_nbt_lead", metaitem('drum.lead'), [
        metaitem('drum.lead').noreturn()
]);

mods.gregtech.assembler.recipeBuilder()
        .inputs(metaitem('battery.hull.lv'))
        .inputs(metaitem('plateLead') * 2)
        .fluidInputs(fluid('sulfuric_acid') * 1000)
        .outputs(metaitem('battery.lead_acid'))
        .duration(100)
        .EUt(16)
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('stickLongLead') * 2)
        .inputs(ore('plateLead') * 4)
        .outputs(metaitem('drum.lead'))
        .duration(200)
        .EUt(16)
        .notConsumable(Globals.circuit(2))
        .buildAndRegister()

MIXER_RECIPES.recipeBuilder()
.fluidInputs(Materials.SulfurTrioxide.getFluid(1000))
.fluidInputs(Materials.Water.getFluid(1000))
.fluidOutputs(Materials.SulfuricAcid.getFluid(1000))
.EUt(7)
.duration(40)
.buildAndRegister()

mods.gregtech.electric_blast_furnace.recipeBuilder()
        .inputs(metaitem('dustSodium') * 4)
        .inputs(metaitem('dustIron') * 3)
        .inputs(metaitem('dustManganese') * 3)
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
        .inputs(metaitem('dustLithiumCarbonate') * 6)
        .fluidInputs(fluid('hydrogen_fluoride') * 2000)
        .fluidOutputs(fluid('steam') * 1000)
        .fluidOutputs(fluid('carbon_dioxide') * 1000)
        .outputs(metaitem('dustLithiumFluoride') * 4)
        .duration(140)
        .EUt(30)
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(metaitem('dustLithiumFluoride') * 2)
        .inputs(metaitem('dustPhosphorusPentachloride') * 6)
        .fluidInputs(fluid('hydrogen_fluoride') * 5000)
        .fluidOutputs(fluid('hydrogen_chloride') * 5000)
        .fluidOutputs(fluid('lithium_hexafluorophosphate') * 1000)
        .duration(140)
        .EUt(30)
        .buildAndRegister()

ROASTER.recipeBuilder()
        .inputs(metaitem('dustLithiumCarbonate') * 6)
        .inputs(metaitem('dustCobaltOxide') * 4)
        .fluidOutputs(fluid('carbon_monoxide') * 1000)
        .outputs(metaitem('dustLithiumCobaltOxide') * 8)
        .duration(140)
        .EUt(30)
        .buildAndRegister()

ROASTER.recipeBuilder()
        .inputs(metaitem('dustNickel') * 1)
        .fluidInputs(fluid('chlorine') * 2000)
        .outputs(metaitem('dustNickelChloride') * 3)
        .duration(100)
        .EUt(30)
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(metaitem('dustNickelChloride') * 3)
        .fluidInputs(fluid('potassium_hydroxide_solution') * 2000)
        .outputs(metaitem('dustNickelHydroxide') * 5)
        .fluidOutputs(fluid('potassium_chloride_solution') * 2000)
        .duration(100)
        .EUt(30)
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(metaitem('dustNickelHydroxide') * 10)
        .fluidInputs(fluid('potassium_hydroxide_solution') * 2000)
        .fluidInputs(fluid('chlorine') * 2000)
        .outputs(metaitem('dustNickelOxideHydroxide') * 8)
        .fluidOutputs(fluid('dilute_rock_salt_solution') * 4000)
        .duration(100)
        .EUt(30)
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(metaitem('battery.hull.lv'))
        .inputs(metaitem('dustCarbon'))
        .inputs(metaitem('dustSodiumCathodeAlloy'))
        .fluidInputs(fluid('dimethyl_carbonate') * 100)
        .outputs(metaitem('battery.re.lv.sodium'))
        .duration(100)
        .EUt(16)
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(metaitem('battery.hull.mv'))
        .inputs(metaitem('dustCarbon') * 2)
        .inputs(metaitem('dustSodiumCathodeAlloy') * 2)
        .fluidInputs(fluid('dimethyl_carbonate') * 200)
        .outputs(metaitem('battery.re.mv.sodium'))
        .duration(200)
        .EUt(16)
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(metaitem('battery.hull.hv'))
        .inputs(metaitem('dustCarbon') * 4)
        .inputs(metaitem('dustSodiumCathodeAlloy') * 4)
        .fluidInputs(fluid('dimethyl_carbonate') * 500)
        .outputs(metaitem('battery.re.hv.sodium'))
        .duration(400)
        .EUt(16)
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(metaitem('battery.hull.lv'))
        .inputs(metaitem('dustGraphite'))
        .inputs(metaitem('dustLithiumCobaltOxide'))
        .fluidInputs(fluid('lithium_hexafluorophosphate') * 100)
        .outputs(metaitem('battery.re.lv.lithium'))
        .duration(100)
        .EUt(16)
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(metaitem('battery.hull.mv'))
        .inputs(metaitem('dustGraphite') * 2)
        .inputs(metaitem('dustLithiumCobaltOxide') * 2)
        .fluidInputs(fluid('lithium_hexafluorophosphate') * 200)
        .outputs(metaitem('battery.re.mv.lithium'))
        .duration(200)
        .EUt(16)
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(metaitem('battery.hull.hv'))
        .inputs(metaitem('dustGraphite') * 4)
        .inputs(metaitem('dustLithiumCobaltOxide') * 4)
        .fluidInputs(fluid('lithium_hexafluorophosphate') * 500)
        .outputs(metaitem('battery.re.hv.lithium'))
        .duration(400)
        .EUt(16)
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(metaitem('battery.hull.lv'))
        .inputs(metaitem('dustCadmium'))
        .inputs(metaitem('dustNickelOxideHydroxide'))
        .fluidInputs(fluid('potassium_hydroxide_solution') * 100)
        .outputs(metaitem('battery.re.lv.cadmium'))
        .duration(100)
        .EUt(16)
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(metaitem('battery.hull.mv'))
        .inputs(metaitem('dustCadmium') * 2)
        .inputs(metaitem('dustNickelOxideHydroxide') * 2)
        .fluidInputs(fluid('potassium_hydroxide_solution') * 200)
        .outputs(metaitem('battery.re.mv.cadmium'))
        .duration(200)
        .EUt(16)
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(metaitem('battery.hull.hv'))
        .inputs(metaitem('dustCadmium') * 4)
        .inputs(metaitem('dustNickelOxideHydroxide') * 4)
        .fluidInputs(fluid('potassium_hydroxide_solution') * 500)
        .outputs(metaitem('battery.re.hv.cadmium'))
        .duration(400)
        .EUt(16)
        .buildAndRegister()

// Remove Batteries
mods.hei.removeAndHide(metaitem('energy_crystal'));
mods.hei.removeAndHide(metaitem('lapotron_crystal'));

mods.hei.removeAndHide(metaitem('energy.lapotronic_orb'));
mods.hei.removeAndHide(metaitem('energy.lapotronic_orb_cluster'));
mods.hei.removeAndHide(metaitem('energy.module'));
mods.hei.removeAndHide(metaitem('energy.cluster'));
mods.hei.removeAndHide(metaitem('max.battery'));

