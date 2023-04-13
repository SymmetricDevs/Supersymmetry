import static globals.Globals.*

import gregtech.api.recipes.recipeproperties.RecipeProperty;
import gregtech.api.recipes.RecipeBuilder;

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