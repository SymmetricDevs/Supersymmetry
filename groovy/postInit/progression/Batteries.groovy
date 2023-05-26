import static globals.Globals.*

import gregtech.api.recipes.recipeproperties.RecipeProperty;
import gregtech.api.recipes.RecipeBuilder;
import static gregtech.api.recipes.RecipeMaps.*;
import gregtech.api.unification.material.Materials.*;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;

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

// Remove Batteries
mods.hei.removeAndHide(metaitem('energy_crystal'));
mods.hei.removeAndHide(metaitem('lapotron_crystal'));

mods.hei.removeAndHide(metaitem('energy.lapotronic_orb'));
mods.hei.removeAndHide(metaitem('energy.lapotronic_orb_cluster'));
mods.hei.removeAndHide(metaitem('energy.module'));
mods.hei.removeAndHide(metaitem('energy.cluster'));
mods.hei.removeAndHide(metaitem('max.battery'));

