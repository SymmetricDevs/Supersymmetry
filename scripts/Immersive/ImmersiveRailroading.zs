import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.liquid.ILiquidStack;
import crafttweaker.oredict.IOreDictEntry;

val name_removals as string[] = [
	"immersiverailroading:item_manual",
	"immersiverailroading:item_conductor_whistle",
	"immersiverailroading:item_paint_brush",
	"immersiverailroading:item_golden_spike",
	"immersiverailroading:item_radio_control_card",
	"immersiverailroading:item_switch_key",
	"immersiverailroading:item_track_exchanger",
	"immersiverailroading:item_large_wrench"
];

for item in name_removals {
	recipes.removeByRecipeName(item);
}

recipes.addShaped("ir_conductor_whistle", <immersiverailroading:item_conductor_whistle>, [
	[<ore:plateCurvedGold>, <ore:plateCurvedGold>, null],
	[<ore:plateCurvedGold>, <ore:plateCurvedGold>, null],
	[<ore:plateCurvedGold>, <ore:plateCurvedGold>, null]
]);

recipes.addShaped("ir_paint_brush", <immersiverailroading:item_paint_brush>, [
	[null, <ore:wool>, null],
	[null, <ore:plateSteel>, null],
	[null, <ore:stickWood>, null]
]);

recipes.addShaped("ir_large_wrench", <immersiverailroading:item_large_wrench>, [
	[null, <ore:plateSteel>, null],
	[<ore:plateSteel>, <ore:plateSteel>, <ore:plateSteel>],
	[<ore:plateSteel>, <ore:gregHardHammers>, <ore:plateSteel>]
]);

recipes.addShaped("ir_gold_spike", <immersiverailroading:item_golden_spike>, [
	[<ore:plateGold>, <ore:plateGold>, null],
	[<ore:stickGold>, null, null],
	[<ore:stickGold>, null, null]
]);

recipes.addShaped("ir_switch_key", <immersiverailroading:item_switch_key>, [
	[null, <ore:stickSteel>, null],
	[<ore:gregFiles>, <ore:stickSteel>, null],
	[null, <ore:ringSteel>]
]);

recipes.addShaped("ir_track_exchanger", <immersiverailroading:item_track_exchanger>, [
	[<ore:paneGlass>, <ore:paneGlass>, <ore:paneGlass>],
	[<immersiverailroading:item_large_wrench>, <ore:plateSteel>, <immersiverailroading:item_rail>],
	[<ore:paneGlass>, <ore:wireFineRedAlloy>, <ore:paneGlass>]
]);