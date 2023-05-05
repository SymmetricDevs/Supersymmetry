import static globals.Globals.*

import gregtech.api.recipes.recipeproperties.RecipeProperty;
import gregtech.api.recipes.RecipeBuilder;
import static gregtech.api.recipes.RecipeMaps.*;
import gregtech.api.unification.material.Materials.*;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;

crafting.addShaped("battery_lead_acid", metaitem('battery.lv.lead_acid'), [
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

def makeBattery(cathode, annode, seperator, electrolyte, outputMaterial, tierRanges, tierOffset) {
  for(tier in tierRanges) {
    // Can recipie
    def tierToKey = Globals.voltageTiers.indexOf(tier)
    def tierToKeyOffset = tierToKey - tierOffset
    def myRecipie = mods.gregtech.assembler.recipeBuilder()
      .inputs(cathode * Math.min(Math.max(tierToKeyOffset, 1), 4))
      .inputs(annode * Math.min(Math.max(tierToKeyOffset, 1), 4))
      .inputs(Globals.cableTiers[tier] * Math.min(Math.max(tierToKeyOffset * 2, 1), 4)) // 1, 2, 4
      .outputs(metaitem("battery.hull.${outputMaterial}.${tier}"))
      .duration(20 * Math.max(tierToKeyOffset, 1)) // start incrementing at MV (2)
      .EUt(Globals.voltageTiersInt[tierToKeyOffset])

    if (tierToKey > 2) {
      myRecipie.fluidInputs(fluid('polyvinyl_chloride') * (144 * Math.min(Math.max(tierToKeyOffset * 3, 1), 9)))
    } else {
      myRecipie.fluidInputs(fluid('plastic') * 144)
    }

    if (seperator != null) {
      myRecipie.inputs(seperator)
    }

    myRecipie.buildAndRegister()

    // Canning recipie
    mods.gregtech.canner.recipeBuilder()
      .inputs(metaitem("battery.hull.${outputMaterial}.${tier}"))
      .inputs(electrolyte * Math.min(Math.max(tierToKeyOffset, 1), 4))
      .outputs(metaitem("battery.${tier}.${outputMaterial}"))
      .duration(10 * Math.max(tierToKeyOffset, 1)) // start incrementing at MV (2)
      .EUt(Globals.voltageTiersInt[tierToKeyOffset])
      .buildAndRegister()
  }
  println("[INFO]: Built battery ${outputMaterial} at tier range of ${tierRanges}")
}

// lipf6 missing add
makeBattery(
  metaitem("cathode.lithium_cobalt_oxide"), 
  metaitem("anode.graphite"), 
  null, //ore("seperator.mv"), 
  metaitem("lipf6"), 
  "lithium",
  ["mv", "hv", "ev"],
  1
)

makeBattery(
  metaitem("cathode.lithium_cobalt_oxide"), 
  metaitem("anode.graphite"), 
  null, //ore("seperator.mv"), 
  metaitem("lipf6"), 
  "vanadium",
  ["hv", "ev", "iv"],
  2
)


// Remove Batteries
// mods.hei.removeAndHide(metaitem('battery.hull.lv'));
// mods.hei.removeAndHide(metaitem('battery.hull.mv'));
// mods.hei.removeAndHide(metaitem('battery.hull.hv'));
// mods.hei.removeAndHide(metaitem('battery.hull.ev'));
// mods.hei.removeAndHide(metaitem('battery.hull.iv'));
// mods.hei.removeAndHide(metaitem('battery.hull.luv'));
// mods.hei.removeAndHide(metaitem('battery.hull.zpm'));
// mods.hei.removeAndHide(metaitem('battery.hull.uv'));

mods.hei.removeAndHide(metaitem('battery.re.lv.sodium'));
mods.hei.removeAndHide(metaitem('battery.re.mv.sodium'));
mods.hei.removeAndHide(metaitem('battery.re.hv.sodium'));

// mods.hei.removeAndHide(metaitem('battery.re.lv.lithium'));
// mods.hei.removeAndHide(metaitem('battery.re.mv.lithium'));
// mods.hei.removeAndHide(metaitem('battery.re.hv.lithium'));

mods.hei.removeAndHide(metaitem('battery.re.lv.cadmium'));
mods.hei.removeAndHide(metaitem('battery.re.mv.cadmium'));
mods.hei.removeAndHide(metaitem('battery.re.hv.cadmium'));

mods.hei.removeAndHide(metaitem('battery.ev.vanadium'));
mods.hei.removeAndHide(metaitem('battery.iv.vanadium'));
mods.hei.removeAndHide(metaitem('battery.luv.vanadium'));

mods.hei.removeAndHide(metaitem('battery.zpm.naquadria'));
mods.hei.removeAndHide(metaitem('battery.uv.naquadria'));

mods.hei.removeAndHide(metaitem('energy_crystal'));
mods.hei.removeAndHide(metaitem('lapotron_crystal'));

mods.hei.removeAndHide(metaitem('energy.lapotronic_orb'));
mods.hei.removeAndHide(metaitem('energy.lapotronic_orb_cluster'));
mods.hei.removeAndHide(metaitem('energy.module'));
mods.hei.removeAndHide(metaitem('energy.cluster'));
// mods.hei.removeAndHide(metaitem('max.battery')); dont remove the testing battery

