import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.liquid.ILiquidStack;
import crafttweaker.oredict.IOreDictEntry;

val name_removals as string[] = [
	"industrialrenewal:prospecting_pan",
	"industrialrenewal:screwdrive",
	"industrialrenewal:steel_saw",
	"industrialrenewal:cargo_container",
	"industrialrenewal:cart_hopper",
	"industrialrenewal:fluid_container",
	"industrialrenewal:small_slabs",
	"industrialrenewal:medkit",
	"industrialrenewal:fire_extinguisher",
	"industrialrenewal:coil_hv",
	"industrialrenewal:barrel_item",
	"industrialrenewal:firebox_solid",
	"industrialrenewal:firebox_fluid",
	"industrialrenewal:battery",
	"industrialrenewal:battery_lithium",
	"industrialrenewal:motor",
	"industrialrenewal:small_wind_blade",
	"industrialrenewal:drill_steel",
	"industrialrenewal:drill_diamond",
	"industrialrenewal:drill_deep",
	"industrialrenewal:concrete",
	"industrialrenewal:frame",
	"industrialrenewal:catwalk_hatch",
	"industrialrenewal:bunker_hatch",
	"industrialrenewal:hazard_block",
	"industrialrenewal:aisle_hazard",
	"industrialrenewal:caution_hazard",
	"industrialrenewal:defective_hazard",
	"industrialrenewal:fire_hazard",
	"industrialrenewal:radiation_hazard",
	"industrialrenewal:safety_hazard",
	"industrialrenewal:handrail",
	"industrialrenewal:handrail_steel",
	"industrialrenewal:catwalk_pillar_steel",
	"industrialrenewal:catwalk_column_steel",
	"industrialrenewal:brace",
	"industrialrenewal:brace_steel",
	"industrialrenewal:lathe",
	"industrialrenewal:electric_pump",
	"industrialrenewal:fuse_box",
	"industrialrenewal:catwalk_ladder",
	"industrialrenewal:catwalk_gate",
	"industrialrenewal:catwalk_pillar",
	"industrialrenewal:catwalk_column",
	"industrialrenewal:catwalk_ladder_steel",
	"industrialrenewal:entity_detector",
	"industrialrenewal:sensor_rain",
	"industrialrenewal:signal_indicator",
	"industrialrenewal:traffic_light",
	"industrialrenewal:chimney_block",
	"industrialrenewal:electric_fence",
	"industrialrenewal:fence_big_column",
	"industrialrenewal:fence_big_wire",
	"industrialrenewal:electric_gate",
	"industrialrenewal:solar_panel"
];

for item in name_removals {
	recipes.removeByRecipeName(item);
}

recipes.addShaped("irw_screwdriver", <industrialrenewal:screwdrive>, [
	[<ore:stickSteel>, <ore:plateCurvedSteel>, motors[1]],
	[null, <ore:gregScrewDrivers>, <ore:stickSteel>],
	[null, <ore:gregWrenches>, <ore:stickSteel>]
]);
/*
recipes.addShaped("irw_saw", <industrialrenewal:steel_saw>, [
	[<ore:plateIron>, <ore:plateSteel>, null],
	[<ore:plateIron>, <ore:plateSteel>, null],
	[<ore:stickWood>, <ore:stickWood>, null]
]);
*/
recipes.addShaped("irw_linker", <industrialrenewal:cart_linkable>, [
	[null, <ore:plateSteel>, <ore:plateSteel>],
	[null, null, <ore:plateSteel>],
	[null, null, <ore:stickLongSteel>]
]);

recipes.addShaped("irw_container", <industrialrenewal:cargo_container>, [
	[<ore:screwSteel>, <ore:gregScrewDrivers>, <ore:screwSteel>],
	[<ore:plateSteel>, <ore:chest>, <ore:plateSteel>],
	[<ore:plateSteel>, <industrialrenewal:minecart_flat>, <ore:plateSteel>]
]);

recipes.addShaped("irw_hopper", <industrialrenewal:cart_hopper>, [
	[<ore:screwSteel>, <ore:gregScrewDrivers>, <ore:screwSteel>],
	[<ore:plateSteel>, <ore:blockHopper>, <ore:plateSteel>],
	[<ore:plateSteel>, <industrialrenewal:minecart_flat>, <ore:plateSteel>]
]);

recipes.addShaped("irw_tank_cart", <industrialrenewal:fluid_container>, [
	[<ore:screwSteel>, <ore:gregScrewDrivers>, <ore:screwSteel>],
	[<ore:stickSteel>, <industrialrenewal:barrel_item>, <ore:stickSteel>],
	[null, <industrialrenewal:minecart_flat>, null]
]);

recipes.addShaped("irw_small_slabs", <industrialrenewal:small_slab>*24, [
	[<ore:slabStone>, <ore:slabStone>, <ore:slabStone>],
	[null, null, null],
	[null, null, null]
]);

recipes.addShaped("irw_barrel", <industrialrenewal:barrel_item>*2, [
	[<ore:plateCurvedIron>, <industrialrenewal:small_slab>, <ore:plateCurvedIron>],
	[<ore:plateCurvedIron>, null, <ore:plateCurvedIron>],
	[<ore:plateCurvedIron>, <industrialrenewal:small_slab>, <ore:plateCurvedIron>]
]);

recipes.addShaped("irw_motor", <industrialrenewal:motor>, [
	[<ore:plateSteel>, <ore:plateSteel>, <ore:plateSteel>],
	[<ore:gearSteel>, motors[1], <ore:wireFineCopper>],
	[<ore:plateSteel>, <ore:plateSteel>, <ore:plateSteel>]
]);

recipes.addShaped("irw_wind_blade", <industrialrenewal:small_wind_blade>, [
	[<ore:plateIron>, <ore:stickSteel>, <ore:plateIron>],
	[<ore:stickSteel>, <ore:plateSteel>, <ore:stickSteel>],
	[<ore:plateIron>, <ore:stickSteel>, <ore:plateIron>]
]);

recipes.addShaped("irw_frame", <industrialrenewal:frame>*6, [
	[<ore:stickSteel>, <ore:stickSteel>, <ore:stickSteel>],
	[null, <ore:stickSteel>, null],
	[<ore:stickSteel>, <ore:stickSteel>, <ore:stickSteel>]
]);

recipes.addShaped("irw_catwalk_hatch", <industrialrenewal:catwalk_hatch>, [
	[<ore:plateSteel>, <minecraft:iron_trapdoor>, <ore:plateSteel>],
	[<ore:stickSteel>, <minecraft:ladder>, <ore:stickSteel>],
	[<ore:stickSteel>, <ore:stickSteel>, <ore:stickSteel>]
]);

recipes.addShaped("irw_bunker_hatch", <industrialrenewal:bunker_hatch>, [
	[<industrialrenewal:small_slab>, <industrialrenewal:small_slab>, <industrialrenewal:small_slab>],
	[<ore:plateSteel>, <ore:stickSteel>, <ore:plateSteel>],
	[<industrialrenewal:small_slab>, <industrialrenewal:small_slab>, <industrialrenewal:small_slab>]
]);

recipes.addShaped("irw_steel_drill", <industrialrenewal:drill_steel>, [
	[null, <ore:stickSteel>, null],
	[<ore:plateSteel>, <ore:plateSteel>, <ore:plateSteel>],
	[<ore:plateSteel>, <metaitem:toolHeadDrillSteel>, <ore:plateSteel>]
]);

recipes.addShaped("irw_diamond_drill", <industrialrenewal:drill_diamond>, [
	[null, <ore:stickSteel>, null],
	[<ore:plateSteel>, <ore:plateSteel>, <ore:plateSteel>],
	[<ore:plateDiamond>, <metaitem:toolHeadDrillSteel>, <ore:plateDiamond>]
]);

recipes.addShaped("irw_hazard_block", <industrialrenewal:block_hazard>*32, [
	[<ore:plateIron>, <ore:plateIron>, <ore:plateIron>],
	[<ore:dyeYellow>, null, <ore:dyeBlack>],
	[<ore:plateIron>, <ore:plateIron>, <ore:plateIron>]
]);

recipes.addShaped("irw_hazard_block1", <industrialrenewal:aisle_hazard>*32, [
	[<ore:plateIron>, <ore:plateIron>, <ore:plateIron>],
	[<ore:dyeBlack>, null, <ore:dyeWhite>],
	[<ore:plateIron>, <ore:plateIron>, <ore:plateIron>]
]);

recipes.addShaped("irw_hazard_block2", <industrialrenewal:caution_hazard>*32, [
	[<ore:plateIron>, <ore:plateIron>, <ore:plateIron>],
	[<ore:dyeOrange>, null, <ore:dyeWhite>],
	[<ore:plateIron>, <ore:plateIron>, <ore:plateIron>]
]);

recipes.addShaped("irw_hazard_block3", <industrialrenewal:defective_hazard>*32, [
	[<ore:plateIron>, <ore:plateIron>, <ore:plateIron>],
	[<ore:dyeBlue>, null, <ore:dyeWhite>],
	[<ore:plateIron>, <ore:plateIron>, <ore:plateIron>]
]);

recipes.addShaped("irw_hazard_block4", <industrialrenewal:fire_hazard>*32, [
	[<ore:plateIron>, <ore:plateIron>, <ore:plateIron>],
	[<ore:dyeRed>, null, <ore:dyeWhite>],
	[<ore:plateIron>, <ore:plateIron>, <ore:plateIron>]
]);

recipes.addShaped("irw_hazard_block5", <industrialrenewal:radiation_hazard>*32, [
	[<ore:plateIron>, <ore:plateIron>, <ore:plateIron>],
	[<ore:dyeMagenta>, null, <ore:dyeYellow>],
	[<ore:plateIron>, <ore:plateIron>, <ore:plateIron>]
]);

recipes.addShaped("irw_hazard_block6", <industrialrenewal:safety_hazard>*32, [
	[<ore:plateIron>, <ore:plateIron>, <ore:plateIron>],
	[<ore:dyeLime>, null, <ore:dyeWhite>],
	[<ore:plateIron>, <ore:plateIron>, <ore:plateIron>]
]);

recipes.addShaped("irw_iron_handrail", <industrialrenewal:handrail>*8, [
	[<ore:stickIron>, <ore:stickIron>, <ore:stickIron>],
	[<ore:stickIron>, null, <ore:stickIron>],
	[<ore:stickIron>, <ore:stickLongIron>, <ore:stickIron>]
]);

recipes.addShaped("irw_iron_caged_ladder", <industrialrenewal:catwalk_ladder>*6, [
	[<ore:stickIron>, <minecraft:ladder>, <ore:stickIron>],
	[<ore:stickIron>, <minecraft:ladder>, <ore:stickIron>],
	[<ore:stickIron>, <minecraft:ladder>, <ore:stickIron>]
]);

recipes.addShaped("irw_steel_handrail", <industrialrenewal:handrail_steel>*8, [
	[<ore:stickSteel>, <ore:stickSteel>, <ore:stickSteel>],
	[<ore:stickSteel>, null, <ore:stickSteel>],
	[<ore:stickSteel>, <ore:stickLongSteel>, <ore:stickSteel>]
]);

recipes.addShaped("irw_steel_caged_ladder", <industrialrenewal:catwalk_ladder_steel>*6, [
	[<ore:stickSteel>, <minecraft:ladder>, <ore:stickSteel>],
	[<ore:stickSteel>, <minecraft:ladder>, <ore:stickSteel>],
	[<ore:stickSteel>, <minecraft:ladder>, <ore:stickSteel>]
]);

recipes.addShaped("irw_pillar", <industrialrenewal:catwalk_steel_pillar>*24, [
	[<ore:plateSteel>, null, <ore:plateSteel>],
	[<ore:plateSteel>, <ore:plateSteel>, <ore:plateSteel>],
	[<ore:plateSteel>, null, <ore:plateSteel>]
]);

recipes.addShaped("irw_pillar1", <industrialrenewal:catwalk_column_steel>*24, [
	[<ore:plateSteel>, <ore:plateSteel>, <ore:plateSteel>],
	[null, <ore:plateSteel>, null],
	[<ore:plateSteel>, <ore:plateSteel>, <ore:plateSteel>]
]);

recipes.addShaped("irw_pillar2", <industrialrenewal:brace_steel>*24, [
	[<ore:plateSteel>, <ore:stickSteel>, null],
	[<ore:stickSteel>, <ore:plateSteel>, <ore:stickSteel>],
	[null, <ore:stickSteel>, <ore:plateSteel>]
]);

recipes.addShaped("irw_pump", <industrialrenewal:electric_pump>, [
	[null, <ore:pipeMediumCopper>, <ore:plateSteel>],
	[<industrialrenewal:motor>, <ore:stickSteel>, <ore:plateSteel>],
	[null, <ore:pipeMediumCopper>, <ore:plateSteel>]
]);

recipes.addShaped("irw_fusebox", <industrialrenewal:fuse_box>, [
	[<ore:stickSteel>, <ore:wireFineRedAlloy>, <ore:stickSteel>],
	[<ore:stickSteel>, <ore:chest>, <ore:stickSteel>],
	[<ore:stickSteel>, <ore:wireFineRedAlloy>, <ore:stickSteel>]
]);

recipes.addShaped("irw_catwalk_gate", <industrialrenewal:catwalk_gate>*2, [
	[<ore:stickIron>, <ore:stickLongIron>, <ore:stickIron>],
	[<ore:stickIron>, <ore:stickLongIron>, <ore:stickIron>],
	[<ore:stickIron>, null, <ore:stickIron>]
]);

recipes.addShaped("irw_pillar_iron1", <industrialrenewal:catwalk_pillar>*24, [
	[<ore:plateIron>, <ore:stickIron>, <ore:plateIron>],
	[<ore:plateIron>, <ore:stickIron>, <ore:plateIron>],
	[<ore:plateIron>, <ore:stickIron>, <ore:plateIron>]
]);

recipes.addShaped("irw_pillar_iron2", <industrialrenewal:catwalk_pillar>*24, [
	[<ore:plateIron>, <ore:plateIron>, <ore:plateIron>],
	[<ore:stickIron>, <ore:stickIron>, <ore:stickIron>],
	[<ore:plateIron>, <ore:plateIron>, <ore:plateIron>]
]);

recipes.addShaped("irw_pillar_brace", <industrialrenewal:brace>*24, [
	[<ore:stickIron>, <ore:plateIron>, null],
	[<ore:plateIron>, <ore:stickIron>, <ore:plateIron>],
	[null, <ore:plateIron>, <ore:stickIron>]
]);

recipes.addShaped("irw_rain_sensor", <industrialrenewal:sensor_rain>, [
	[null, <ore:plateSteel>, null],
	[<ore:plateSteel>, <ore:wireFineRedAlloy>, <ore:plateSteel>],
	[<ore:minislabStone>, <ore:minislabStone>, <ore:minislabStone>]
]);

recipes.addShaped("irw_signal_indicator", <industrialrenewal:signal_indicator>, [
	[null, <ore:craftingRedstoneTorch>, null],
	[null, <ore:stickIron>, null],
	[null, <ore:plateIron>, null]
]);

recipes.addShaped("irw_traffic_light", <industrialrenewal:traffic_light>, [
	[<ore:plateSteel>, circuits[0], <ore:dyeRed>],
	[<ore:wireFineRedAlloy>, circuits[0], <ore:dyeYellow>],
	[<ore:plateSteel>, circuits[0], <ore:dyeGreen>]
]);

recipes.addShaped("irw_chimney", <industrialrenewal:block_chimney>, [
	[<ore:plateSteel>, <ore:pipeMediumSteel>, <ore:plateSteel>],
	[<ore:plateSteel>, <ore:pipeMediumSteel>, <ore:plateSteel>],
	[<ore:plateSteel>, <ore:plateSteel>, <ore:plateSteel>]
]);

recipes.addShaped("irw_electric_fence", <industrialrenewal:electric_fence>*16, [
	[null, null, null],
	[<ore:wireGtSingleSteel>, <ore:stickSteel>, <ore:wireGtSingleSteel>],
	[<ore:wireGtSingleSteel>, <ore:stickSteel>, <ore:wireGtSingleSteel>]
]);

recipes.addShaped("irw_electric_fence_big", <industrialrenewal:fence_big_column>*16, [
	[<ore:stickSteel>, <ore:wireGtSingleSteel>, <ore:stickSteel>],
	[<ore:stickSteel>, <ore:wireGtSingleSteel>, <ore:stickSteel>],
	[<ore:stickSteel>, <ore:wireGtSingleSteel>, <ore:stickSteel>]
]);

recipes.addShaped("irw_big_wire", <industrialrenewal:fence_big_wire>*16, [
	[null, <ore:wireGtSingleSteel>, null],
	[null, <ore:wireGtSingleSteel>, null],
	[<ore:wireGtSingleSteel>, <ore:stickSteel>, <ore:wireGtSingleSteel>]
]);

recipes.addShaped("irw_electric_gate", <industrialrenewal:electric_gate>, [
	[null, null, null],
	[<ore:stickSteel>, <ore:wireGtSingleSteel>, <ore:stickSteel>],
	[<ore:stickSteel>, <ore:wireGtSingleSteel>, <ore:stickSteel>]
]);

canner.recipeBuilder().EUt(30).duration(20)
	.inputs(<techguns:itemshared:24>)
	.fluidInputs(<liquid:carbon_dioxide>*1000)
	.outputs(<industrialrenewal:item_fire_extinguisher>)
	.buildAndRegister();

for solder in soldering_alloys {
assembler.recipeBuilder().EUt(30).duration(20)
	.inputs(sensors[1])
	.inputs(<ore:wireFineRedAlloy>*4)
	.inputs(<ore:stickSteel>)
	.fluidInputs(solder*72)
	.outputs(<industrialrenewal:entity_detector>)
	.buildAndRegister();
}