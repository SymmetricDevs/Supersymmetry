#norun
import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.liquid.ILiquidStack;
import crafttweaker.oredict.IOreDictEntry;

val name_removals as string[] = [
	"industrialwires:wires/noic2_copper_conn",
	"industrialwires:wires/noic2_copper_relay",
	"industrialwires:wires/noic2_gold_conn",
	"industrialwires:wires/noic2_gold_relay",
	"industrialwires:wires/noic2_hv_conn",
	"industrialwires:wires/noic2_hv_relay",
	"industrialwires:jacobs_ladder_small",
	"industrialwires:jacobs_ladder_normal",
	"industrialwires:jacobs_ladder_huge",
	"industrialwires:control_panel_connector",
	"industrialwires:control_panel_creator",
	"industrialwires:control_panel_unfinished",
	"industrialwires:key_ring"
];

for item in name_removals {
	recipes.removeByRecipeName(item);
}

recipes.addShaped("iw_jacobs_small", <industrialwires:jacobs_ladder:0>, [
	[<ore:stickCopper>, null, <ore:stickCopper>],
	[<ore:plateSteel>, <immersiveengineering:connector:8>, <ore:plateSteel>],
	[null, null, null]
]);

recipes.addShaped("iw_jacobs_normal", <industrialwires:jacobs_ladder:1>, [
	[<ore:stickLongCopper>, null, <ore:stickLongCopper>],
	[<ore:plateSteel>, <immersiveengineering:connector:8>, <ore:plateSteel>],
	[null, null, null]
]);

recipes.addShaped("iw_jacobs_huge", <industrialwires:jacobs_ladder:2>, [
	[<ore:stickLongCopper>, null, <ore:stickLongCopper>],
	[<ore:stickLongCopper>, null, <ore:stickLongCopper>],
	[<ore:plateSteel>, <immersiveengineering:connector:8>, <ore:plateSteel>]
]);

recipes.addShaped("iw_panel_connector", <industrialwires:control_panel:2>*4, [
	[null , <ore:wireFineRedAlloy>, null],
	[<ore:wireFineRedAlloy>, <industrialwires:control_panel:4>, <ore:wireFineRedAlloy>],
	[null, <ore:wireFineRedAlloy>, null]
]);

recipes.addShaped("iw_control_panel_creator", <industrialwires:control_panel:3>, [
	[<ore:stickSteel>, <ore:circuitPrimitive>, <ore:stickSteel>],
	[<ore:stickSteel>, <industrialwires:control_panel:2>, <ore:stickSteel>],
	[<ore:stickSteel>, <ore:plateCopper>, <ore:stickSteel>]
]);

recipes.addShaped("iw_unfinished_panel", <industrialwires:control_panel:4>*3, [
	[<ore:plateIron>, <ore:plateIron>, <ore:plateIron>],
	[<ore:wireFineCopper>, <ore:wireFineCopper>, <ore:wireFineCopper>],
	[<ore:plateIron>, <ore:plateIron>, <ore:plateIron>]
]);

recipes.addShaped("iw_key_ring", <industrialwires:key:2>, [
	[null, <ore:stickSteel>, null],
	[<ore:stickSteel>, <ore:ringSteel>, <ore:stickSteel>],
	[null, <ore:stickSteel>, null]
]);

