/*
println("Running ImmersiveRailroading.groovy...")

import static globals.Globals.*

def weapons_factory = recipemap('assembler') // REPLACE WITH WEAPONS FACTORY AFTER RECIPE MAPS ARE FIXED

ArrayList<String> name_removals = [
		"immersiverailroading:item_manual",
		"immersiverailroading:item_conductor_whistle",
		"immersiverailroading:item_paint_brush",
		"immersiverailroading:item_golden_spike",
		"immersiverailroading:item_radio_control_card",
		"immersiverailroading:item_switch_key",
		"immersiverailroading:item_track_exchanger",
		"immersiverailroading:item_large_wrench"
];

for (item in name_removals) {
	crafting.remove(item);
}

crafting.addShaped("ir_conductor_whistle", item('immersiverailroading:item_conductor_whistle'), [
		[ore('foilGold'), ore('foilGold'), null],
		[ore('foilGold'), ore('foilGold'), null],
		[ore('foilGold'), ore('foilGold'), null]
]);

crafting.addShaped("ir_paint_brush", item('immersiverailroading:item_paint_brush'), [
		[null, ore('wool'), null],
		[null, ore('plateSteel'), null],
		[null, ore('stickWood'), null]
]);

crafting.addShaped("ir_large_wrench", item('immersiverailroading:item_large_wrench'), [
		[null, ore('plateSteel'), null],
		[ore('plateSteel'), ore('plateSteel'), ore('plateSteel')],
		[ore('plateSteel'), ore('craftingToolHardHammer').transform(damageTool), ore('plateSteel')]
]);

crafting.addShaped("ir_gold_spike", item('immersiverailroading:item_golden_spike'), [
		[ore('plateGold'), ore('plateGold'), null],
		[ore('stickGold'), null, null],
		[ore('stickGold'), null, null]
]);

crafting.addShaped("ir_switch_key", item('immersiverailroading:item_switch_key'), [
		[null, ore('stickSteel'), null],
		[ore('craftingToolFile').transform(damageTool), ore('stickSteel'), null],
		[null, ore('ringSteel')]
]);

crafting.addShaped("ir_track_exchanger", item('immersiverailroading:item_track_exchanger'), [
		[ore('paneGlass'), ore('paneGlass'), ore('paneGlass')],
		[item('immersiverailroading:item_large_wrench'), ore('plateSteel'), item('immersiverailroading:item_rail')],
		[ore('paneGlass'), ore('wireFineRedAlloy'), ore('paneGlass')]
]);
*/