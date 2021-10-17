import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.liquid.ILiquidStack;
import crafttweaker.oredict.IOreDictEntry;

import mods.gregtech.recipe.RecipeMap;

import mods.immersiveengineering.ArcFurnace;
import mods.immersiveengineering.BlastFurnace;
import mods.immersiveengineering.CokeOven;
import mods.immersiveengineering.Crusher;
import mods.immersiveengineering.Blueprint;
import mods.immersiveengineering.BottlingMachine;
import mods.immersiveengineering.MetalPress;
import mods.immersiveengineering.Mixer;
import mods.immersiveengineering.Refinery;
import mods.immersiveengineering.Squeezer;
import mods.immersiveengineering.Fermenter;

import mods.immersivetechnology.Boiler;
import mods.immersivetechnology.SteamTurbine;

//import mods.immersiveintelligence.Electrolyzer;
//import mods.immersiveintelligence.ChemicalBath;

val name_removals = [
	"immersiveengineering:wooden_devices/watermill",
	"immersiveengineering:wooden_devices/windmill",
	"gregtech:vacuum_tube_wire",
	"gregtech:vacuum_tube_wire_fine",
	"gtadditions:basic_board",
	"immersiveengineering:wooden_devices/item_router",
	"immersiveengineering:wooden_devices/turntable",
	"immersiveengineering:wooden_devices/fluid_router",
	"immersiveengineering:metal_decoration/redstone_engineering",
	"immersiveengineering:metal_decoration/light_engineering",
	"immersiveengineering:metal_decoration/heavy_engineering",
	"immersiveengineering:metal_decoration/generator",
	"immersiveengineering:metal_decoration/radiator",
	"immersiveengineering:metal_decoration/steel_scaffolding",
	"immersiveengineering:metal_decoration/aluminum_scaffolding",
	"immersiveengineering:metal_decoration/steel_wallmount",
	"immersiveengineering:metal_decoration/aluminum_wallmount",
	"immersiveengineering:material/stick_iron",
	"immersiveengineering:material/stick_steel",
	"immersiveengineering:material/stick_aluminum",
	"immersiveengineering:connectors/connector_lv",
	"immersiveengineering:connectors/relay_lv",
	"immersiveengineering:connectors/connector_mv",
	"immersiveengineering:connectors/relay_mv",
	"immersiveengineering:connectors/connector_hv",
	"immersiveengineering:connectors/relay_hv",
	"immersiveengineering:stone_decoration/insulating_glass",
	"immersiveengineering:connectors/connector_structural",
	"immersiveengineering:connectors/transformer",
	"immersiveengineering:connectors/transformer_hv",
	"immersiveengineering:connectors/breaker_switch",
	"immersiveengineering:connectors/redstone_breaker",
	"immersiveengineering:connectors/current_transformer",
	"immersiveengineering:connectors/connector_redstone",
	"immersiveengineering:connectors/connector_probe",
	"immersiveengineering:conveyors/conveyor_basic_rubber",
	"immersiveengineering:conveyors/conveyor_basic",
	"immersiveengineering:conveyors/conveyor_vertical",
	"immersiveengineering:conveyors/conveyor_splitter",
	"immersiveengineering:metal_devices/thermoelectric_generator",
	"immersiveengineering:metal_devices/dynamo",
	"immersiveengineering:metal_devices/furnace_heater",
	"immersiveengineering:material/component_iron",
	"immersiveengineering:material/component_steel",
	"immersiveengineering:material/wooden_grip",
	"immersiveengineering:material/gunpart_barrel",
	"immersiveengineering:material/gunpart_drum",
	"immersiveengineering:material/gunpart_hammer",
	"immersiveengineering:material/wire_steel",
	"immersiveengineering:material/wire_copper",
	"immersiveengineering:material/wire_electrum",
	"immersiveengineering:material/wire_aluminum",
	"immersiveengineering:material/dust_constantan",
	"immersiveengineering:sheetmetal/copper_sheetmetal_uncraft",
	"immersiveengineering:material/plate_copper",
	"immersiveengineering:sheetmetal/aluminum_sheetmetal_uncraft",
	"immersiveengineering:material/plate_aluminum",
	"immersiveengineering:sheetmetal/lead_sheetmetal_uncraft",
	"immersiveengineering:material/plate_lead",
	"immersiveengineering:sheetmetal/silver_sheetmetal_uncraft",
	"immersiveengineering:material/plate_silver",
	"immersiveengineering:sheetmetal/nickel_sheetmetal_uncraft",
	"immersiveengineering:material/plate_nickel",
	"immersiveengineering:sheetmetal/uranium_sheetmetal_uncraft",
	"immersiveengineering:material/plate_uranium",
	"immersiveengineering:sheetmetal/constantan_sheetmetal_uncraft",
	"immersiveengineering:material/plate_constantan",
	"immersiveengineering:sheetmetal/electrum_sheetmetal_uncraft",
	"immersiveengineering:material/plate_electrum",
	"immersiveengineering:sheetmetal/steel_sheetmetal_uncraft",
	"immersiveengineering:material/plate_steel",
	"immersiveengineering:sheetmetal/gold_sheetmetal_uncraft",
	"immersiveengineering:material/plate_gold",
	"immersiveengineering:sheetmetal/iron_sheetmetal_uncraft",
	"immersiveengineering:material/plate_iron",
	"immersiveengineering:tool/steel_sword",
	"immersiveengineering:tool/steel_hoe",
	"immersiveengineering:tool/steel_axe",
	"immersiveengineering:tool/steel_shovel",
	"immersiveengineering:tool/steel_pickaxe",
	"immersiveengineering:wirecoils/wirecoil_redstone",
	"immersiveengineering:wirecoils/wirecoil_redstone2",
	"immersiveengineering:wirecoils/wirecoil_structural",
	"immersiveengineering:tool/manual",
	"immersiveengineering:tool/voltmeter",
	"immersiveengineering:tool/wirecutters",
	"immersiveengineering:tool/drillhead_steel",
	"immersiveengineering:tool/drillhead_iron",
	"immersiveengineering:blueprints/basic_circuits",
	"immersiveengineering:tool/speedloader",
	"immersiveengineering:tool/skyhook",
	"immersiveengineering:metal_devices/capacitor_lv",
	"immersiveengineering:metal_devices/capacitor_mv",
	"immersiveengineering:metal_devices/capacitor_hv",
	"immersiveengineering:metal_devices/fluid_pump",
	"immersiveengineering:metal_devices/powered_lantern",
	"immersiveengineering:metal_devices/charging_station",
	"immersiveengineering:metal_devices/fluid_pipe",
	"immersiveengineering:metal_devices/coresample_drill",
	"immersiveengineering:metal_devices/floodlight",
	"immersiveengineering:metal_devices/garden_cloche",
	"immersiveengineering:toolupgrades/drill_waterproof",
	"immersivepetroleum:toolupgrades/drill_lube",
	"immersivepetroleum:toolupgrades/drill_lube_alt",
	"immersiveengineering:toolupgrades/drill_damage",
	"immersiveengineering:toolupgrades/drill_capacity",
	"immersiveengineering:toolupgrades/revolver_bayonet",
	"immersiveengineering:toolupgrades/revolver_magazine",
	"immersiveengineering:toolupgrades/revolver_electro",
	"immersiveengineering:toolupgrades/chemthrower_focus",
	"immersiveengineering:toolupgrades/railgun_scope",
	"immersiveengineering:toolupgrades/shield_flash",
	"immersiveengineering:toolupgrades/shield_magnet",
	"immersiveengineering:armor/faraday_boots",
	"immersiveengineering:armor/faraday_legs",
	"immersiveengineering:armor/faraday_chest",
	"immersiveengineering:armor/faraday_helm",
	"immersiveengineering:metal_devices/turret_chemthrower",
	"immersiveengineering:metal_devices/turret_gun",
	"immersiveengineering:material/dust_electrum"
] as string[];

for item in name_removals {
    recipes.removeByRecipeName(item);
}

recipes.addShaped("ie_gun_turret", <immersiveengineering:metal_device1:11>, [
	[null, <immersiveengineering:toolupgrade:8>, null],
	[null, <immersiveengineering:revolver>, circuits[1]],
	[<immersiveengineering:toolupgrade:5>, <immersiveengineering:wooden_device0:6>, <immersiveengineering:metal_decoration0:3>]
]);

recipes.addShaped("ie_chem_turret", <immersiveengineering:metal_device1:10>, [
	[null, <immersiveengineering:toolupgrade:8>, null],
	[null, <immersiveengineering:chemthrower>, circuits[1]],
	[<immersiveengineering:metal_device0:4>, <immersiveengineering:wooden_device0:6>, <immersiveengineering:metal_decoration0:3>]
]);

recipes.addShaped("ie_faraday_hat", <immersiveengineering:faraday_suit_head>, [
	[null, null, null],
	[<ore:ringAluminium>, <ore:ringAluminium>, <ore:ringAluminium>],
	[<ore:ringAluminium>, <ore:gregHardHammers>, <ore:ringAluminium>]
]);

recipes.addShaped("ie_faraday_chest", <immersiveengineering:faraday_suit_chest>, [
	[<ore:ringAluminium>, <ore:gregHardHammers>, <ore:ringAluminium>],
	[<ore:ringAluminium>, <ore:ringAluminium>, <ore:ringAluminium>],
	[<ore:ringAluminium>, <ore:ringAluminium>, <ore:ringAluminium>]
]);

recipes.addShaped("ie_faraday_legs", <immersiveengineering:faraday_suit_legs>, [
	[<ore:ringAluminium>, <ore:ringAluminium>, <ore:ringAluminium>],
	[<ore:ringAluminium>, <ore:gregHardHammers>, <ore:ringAluminium>],
	[<ore:ringAluminium>, null, <ore:ringAluminium>]
]);

recipes.addShaped("ie_faraday_feet", <immersiveengineering:faraday_suit_feet>, [
	[null, null, null],
	[<ore:ringAluminium>, null, <ore:ringAluminium>],
	[<ore:ringAluminium>, <ore:gregHardHammers>, <ore:ringAluminium>]
]);

recipes.addShaped("ie_magnet_glove", <immersiveengineering:toolupgrade:12>, [
	[null, null, <ore:itemLeather>],
	[<ore:itemLeather>, <ore:blockCoil>, null],
	[<ore:itemLeather>, <ore:stickMagneticIron>, <ore:itemLeather>]
]);

recipes.addShaped("ie_flash", <immersiveengineering:toolupgrade:10>, [
	[null, null, null],
	[null, null, null],
	[<ore:plateCurvedSilver>, circuits[0], <ore:plateCurvedSilver>]
]);

recipes.addShaped("ie_scope", <immersiveengineering:toolupgrade:8>, [
	[<ore:lensGlass>, <ore:plateCurvedCopper>, null],
	[<ore:plateCurvedCopper>, null, <ore:plateCurvedCopper>],
	[null, <ore:plateCurvedCopper>, <ore:lensGlass>]
]);

recipes.addShaped("ie_nozzle", <immersiveengineering:toolupgrade:7>, [
	[null, <ore:plateSteel>, <ore:plateSteel>],
	[<immersiveengineering:metal_device1:6>, <immersiveengineering:metal_device1:6>, <ore:blockHopper>],
	[null, <ore:plateSteel>, <ore:plateSteel>]
]);

recipes.addShaped("ie_revolver_tubes", <immersiveengineering:toolupgrade:6>, [
	[null, null, null],
	[circuits[0], circuits[0], circuits[0]],
	[<ore:stickSteel>, <ore:wireGtSingleCopper>, <ore:stickSteel>]
]);

recipes.addShaped("ie_magazine", <immersiveengineering:toolupgrade:5>, [
	[null, <ore:plateCopper>, <ore:plateSteel>],
	[<ore:plateCopper>, null, <ore:plateCopper>],
	[<immersiveengineering:material:9>, <ore:plateCopper>, null]
]);

recipes.addShaped("ie_bayonet", <immersiveengineering:toolupgrade:4>, [
	[<ore:stickSteel>, <ore:plateSteel>, null],
	[<ore:plateSteel>, <ore:plankTreatedWood>, null],
	[null, null, null]
]);

recipes.addShaped("ie_largetank", <immersiveengineering:toolupgrade:3>, [
	[<immersiveengineering:material:9>, <ore:plateCurvedSteel>, <ore:dyeRed>],
	[<ore:plateCurvedSteel>, pumps[1], <ore:plateCurvedSteel>],
	[<ore:dyeRed>, <ore:plateCurvedSteel>, <ore:plateSteel>]
]);

recipes.addShaped("ie_auger", <immersiveengineering:toolupgrade:2>, [
	[null, null, null],
	[<ore:plateSteel>, <ore:plateSteel>, <ore:plateSteel>],
	[null, <immersiveengineering:material:9>, null]
]);

recipes.addShaped("ie_luber", <immersiveengineering:toolupgrade:1>, [
	[<ore:plateIron>, <ore:plateCurvedIron>, <ore:dyeBlue>],
	[<ore:plateCurvedIron>, pumps[1], <ore:plateCurvedIron>],
	[<ore:dyeBlue>, <ore:plateCurvedIron>, <immersiveengineering:material:8>]
]);

recipes.addShaped("ie_airtank", <immersiveengineering:toolupgrade:0>, [
	[<ore:plateSteel>, <ore:plateCurvedSteel>, <ore:dyeBlue>],
	[<ore:plateCurvedSteel>, null, <ore:plateCurvedSteel>],
	[<ore:dyeBlue>, <ore:plateCurvedSteel>, <immersiveengineering:material:9>]
]);

//IE Waterwheel Crafting
recipes.addShaped("ie_waterwheel", <immersiveengineering:wooden_device1>, [
	[null, <immersiveengineering:material:10>, null],
	[<immersiveengineering:material:10>, <ore:stickSteel>, <immersiveengineering:material:10>],
	[null, <immersiveengineering:material:10>, null]
]);

//IE Windmill Crafting
recipes.addShaped("ie_windmill", <immersiveengineering:wooden_device1:1>, [
	[<immersiveengineering:material:11>, <immersiveengineering:material:11>, <immersiveengineering:material:11>],
	[<immersiveengineering:material:11>, <ore:stickIron>, <immersiveengineering:material:11>],
	[<immersiveengineering:material:11>, <immersiveengineering:material:11>, <immersiveengineering:material:11>]
]);

//IE Item Router
recipes.addShaped("ie_item_router", <immersiveengineering:wooden_device0:3>, [
	[<ore:plankTreatedWood>, <ore:gregScrewDrivers>, <ore:plankTreatedWood>],
	[<ore:plateIron>, <immersiveengineering:conveyor>, <ore:plateIron>],
	[<ore:plankTreatedWood>, <immersiveengineering:material:8>, <ore:plankTreatedWood>]
]);

//IE Turntable
recipes.addShaped("ie_turntable", <immersiveengineering:wooden_device0:6>, [
	[<ore:gregScrewDrivers>, <ore:screwIron>, <ore:gregHardHammers>],
	[<ore:plankTreatedWood>, <ore:plateIron>, <ore:plankTreatedWood>],
	[<ore:wireFineRedAlloy>, <ore:coilCopper>, <ore:wireFineRedAlloy>]
]);

//IE Fluid Router
recipes.addShaped("ie_fluid_router", <immersiveengineering:wooden_device0:7>, [
	[<ore:plankTreatedWood>, <ore:gregWrenches>, <ore:plankTreatedWood>],
	[<ore:plateIron>, <immersiveengineering:metal_device1:6>, <ore:plateIron>],
	[<ore:plankTreatedWood>, <immersiveengineering:material:8>, <ore:plankTreatedWood>]
]);

//IE Redstone Engineering Block
recipes.addShaped("ie_redstone_engineering_block", <immersiveengineering:metal_decoration0:3>*2, [
	[<ore:plateIron>, <ore:wireFineRedAlloy>, <ore:plateIron>],
	[<ore:wireFineRedAlloy>, <ore:plateCopper>, <ore:wireFineRedAlloy>],
	[<ore:plateIron>, <ore:wireFineRedAlloy>, <ore:plateIron>]
]);

//IE Light Engineering Block
recipes.addShaped("ie_light_engineering_block", <immersiveengineering:metal_decoration0:4>*2, [
	[<ore:plateIron>, <immersiveengineering:material:8>, <ore:plateIron>],
	[<ore:plateCopper>, <ore:plateCopper>, <ore:plateCopper>],
	[<ore:plateIron>, <immersiveengineering:material:8>, <ore:plateIron>]
]);

//IE Heavy Engineering Block
recipes.addShaped("ie_heavy_engineering_block", <immersiveengineering:metal_decoration0:5>*2, [
	[<ore:plateSteel>, <immersiveengineering:material:9>, <ore:plateSteel>],
	[<metaitem:electric.piston.lv>, <ore:plateElectrum>, <metaitem:electric.piston.lv>],
	[<ore:plateSteel>, <immersiveengineering:material:9>, <ore:plateSteel>]
]);

//IE Generator Block
recipes.addShaped("ie_generator_block", <immersiveengineering:metal_decoration0:6>*2, [
	[<ore:plateSteel>, <ore:plateSteel>, <ore:plateSteel>],
	[<ore:plateCopper>, <immersiveengineering:metal_device1:2>, <ore:plateCopper>],
	[<ore:plateSteel>, <ore:plateSteel>, <ore:plateSteel>]
]);

//IE Radiator Block
recipes.addShaped("ie_radiator_block", <immersiveengineering:metal_decoration0:7>*2, [
	[<ore:plateSteel>, <ore:pipeSmallCopper>, <ore:plateSteel>],
	[<ore:pipeSmallCopper>, <ore:pipeMediumCopper>, <ore:pipeSmallCopper>],
	[<ore:plateSteel>, <ore:pipeSmallCopper>, <ore:plateSteel>]
]);

//IE Steel Scaffolding
recipes.addShaped("ie_steel_scaffolding", <immersiveengineering:metal_decoration1:1>*6, [
	[<ore:plateSteel>, <ore:stickSteel>, <ore:plateSteel>],
	[<ore:stickSteel>, null, <ore:stickSteel>],
	[<ore:plateSteel>, <ore:stickSteel>, <ore:plateSteel>]
]);

//IE Aluminium Scaffolding
recipes.addShaped("ie_aluminium_scaffolding", <immersiveengineering:metal_decoration1:5>*6, [
	[<ore:plateAluminium>, <ore:stickAluminium>, <ore:plateAluminium>],
	[<ore:stickAluminium>, null, <ore:stickAluminium>],
	[<ore:plateAluminium>, <ore:stickAluminium>, <ore:plateAluminium>]
]);

//IE Steel Wallmount
recipes.addShaped("ie_steel_wallmount", <immersiveengineering:metal_decoration2:1>*4, [
	[<ore:plateSteel>, <ore:plateSteel>, null],
	[<ore:plateSteel>, <ore:stickSteel>, null],
	[null, null, null]
]);

//IE Aluminium Wallmount
recipes.addShaped("ie_aluminium_wallmount", <immersiveengineering:metal_decoration2:3>*4, [
	[<ore:plateAluminium>, <ore:plateAluminium>, null],
	[<ore:plateAluminium>, <ore:stickAluminium>, null],
	[null, null, null]
]);

recipes.addShaped("ie_connector_lv", <immersiveengineering:connector:0>, [
	[null, <ore:stickCopper>, null],
	[<ore:hardened_clay>, <ore:stickCopper>, <ore:hardened_clay>],
	[<ore:hardened_clay>, <ore:stickCopper>, <ore:hardened_clay>]
]);

recipes.addShaped("ie_connector_mv", <immersiveengineering:connector:2>, [
	[null, <ore:stickIron>, null],
	[<ore:hardened_clay>, <ore:stickIron>, <ore:hardened_clay>],
	[<ore:hardened_clay>, <ore:stickIron>, <ore:hardened_clay>]
]);

recipes.addShaped("ie_connector_hv", <immersiveengineering:connector:4>, [
	[null, <ore:stickElectrum>, null],
	[<ore:hardened_clay>, <ore:stickElectrum>, <ore:hardened_clay>],
	[<ore:hardened_clay>, <ore:stickElectrum>, <ore:hardened_clay>]
]);

recipes.addShaped("ie_relay_lv", <immersiveengineering:connector:1>, [
	[null, null, null],
	[null, <ore:stickCopper>, null],
	[<ore:hardened_clay>, <ore:stickCopper>, <ore:hardened_clay>]
]);

recipes.addShaped("ie_relay_mv", <immersiveengineering:connector:3>, [
	[null, null, null],
	[null, <ore:stickIron>, null],
	[<ore:hardened_clay>, <ore:stickIron>, <ore:hardened_clay>]
]);

recipes.addShaped("ie_relay_hv", <immersiveengineering:connector:5>, [
	[null, <ore:stickElectrum>, null],
	[<immersiveengineering:stone_decoration:8>, <ore:stickElectrum>, <immersiveengineering:stone_decoration:8>],
	[<immersiveengineering:stone_decoration:8>, <ore:stickElectrum>, <immersiveengineering:stone_decoration:8>]
]);

recipes.addShaped("ie_structural_connector", <immersiveengineering:connector:6>*8, [
	[null, null, null],
	[<ore:plateSteel>, <ore:stickSteel>, <ore:plateSteel>],
	[<ore:plateSteel>, <ore:plateSteel>, <ore:plateSteel>]
]);

recipes.addShaped("ie_transformer", <immersiveengineering:connector:7>, [
	[<immersiveengineering:connector:0>, null, <immersiveengineering:connector:2>],
	[<ore:coilElectrum>, <ore:plateSteel>, <ore:coilElectrum>],
	[<ore:plateSteel>, <ore:plateSteel>, <ore:plateSteel>]
]);

recipes.addShaped("ie_transformer_hv", <immersiveengineering:connector:8>, [
	[<immersiveengineering:connector:2>, null, <immersiveengineering:connector:4>],
	[<ore:coilHighVoltage>, <ore:plateSteel>, <ore:coilHighVoltage>],
	[<ore:plateSteel>, <ore:plateSteel>, <ore:plateSteel>]
]);

recipes.addShaped("ie_breaker", <immersiveengineering:connector:9>, [
	[null, null, null],
	[null, <minecraft:lever>, null],
	[<ore:hardened_clay>, <ore:plateCopper>, <ore:hardened_clay>]
]);

recipes.addShaped("ie_redstone_breaker", <immersiveengineering:connector:10>, [
	[<immersiveengineering:connector:4>, null, <immersiveengineering:connector:4>],
	[<ore:plateSteel>, <minecraft:repeater>, <ore:plateSteel>],
	[<ore:plateSteel>, <ore:wireFineRedAlloy>, <ore:plateSteel>]
]);

recipes.addShaped("ie_current_transformer", <immersiveengineering:connector:11>, [
	[null, <immersiveengineering:tool:2>, null],
	[<ore:hardened_clay>, <ore:coilCopper>, <ore:hardened_clay>],
	[<ore:plateSteel>, <ore:coilCopper>, <ore:plateSteel>]
]);

recipes.addShaped("ie_redstone_wire_connector", <immersiveengineering:connector:12>*3, [
	[null, null, null],
	[<ore:boltElectrum>, <ore:boltElectrum>, <ore:boltElectrum>],
	[<ore:hardened_clay>, <ore:wireFineRedAlloy>, <ore:hardened_clay>]
]);

recipes.addShaped("ie_redstone_probe_connector", <immersiveengineering:connector:13>, [
	[null, <immersiveengineering:connector:12>, null],
	[<ore:paneGlass>, circuits[1], <ore:paneGlass>],
	[null, <ore:gemQuartz>, null]
]);

recipes.addShaped("ie_conveyor_rubber", <immersiveengineering:conveyor>.withTag({conveyorType: "immersiveengineering:conveyor"})*32, [
	[null, null, null],
	[<ore:plateRubber>, <ore:plateRubber>, <ore:plateRubber>],
	[motors[1], <ore:wireFineRedAlloy>, motors[1]]
]);

recipes.addShaped("ie_conveyor", <immersiveengineering:conveyor>.withTag({conveyorType: "immersiveengineering:conveyor"})*16, [
	[null, null, null],
	[<ore:leather>, <ore:leather>, <ore:leather>],
	[motors[1], <ore:wireFineRedAlloy>, motors[1]]
]);

recipes.addShaped("ie_conveyor_vertical", <immersiveengineering:conveyor>.withTag({conveyorType: "immersiveengineering:vertical"})*3, [
	[<immersiveengineering:conveyor>.withTag({conveyorType: "immersiveengineering:conveyor"}), <ore:plateIron>, null],
	[<immersiveengineering:conveyor>.withTag({conveyorType: "immersiveengineering:conveyor"}), null, null],
	[<immersiveengineering:conveyor>.withTag({conveyorType: "immersiveengineering:conveyor"}), <ore:plateIron>, null]
]);

recipes.addShaped("ie_conveyor_splitter", <immersiveengineering:conveyor>.withTag({conveyorType: "immersiveengineering:splitter"}), [
	[null, null, null],
	[<immersiveengineering:conveyor>.withTag({conveyorType: "immersiveengineering:conveyor"}), <ore:plateIron>, <immersiveengineering:conveyor>.withTag({conveyorType: "immersiveengineering:conveyor"})],
	[null, <immersiveengineering:conveyor>.withTag({conveyorType: "immersiveengineering:conveyor"}), null]
]);

recipes.addShaped("ie_furnace_heater", <immersiveengineering:metal_device1:1>, [
	[<ore:plateIron>, <ore:plateCopper>, <ore:plateIron>],
	[<ore:plateCopper>, <ore:coilCopper>, <ore:plateCopper>],
	[<ore:plateIron>, <ore:wireFineRedAlloy>, <ore:plateIron>]
]);

recipes.addShaped("ie_dynamo", <immersiveengineering:metal_device1:2>, [
	[null, null, null],
	[<ore:wireFineRedAlloy>, motors[1], <ore:wireFineRedAlloy>],
	[<ore:plateIron>, <ore:plateIron>, <ore:plateIron>]
]);

recipes.addShaped("ie_thermoelectric_generator", <immersiveengineering:metal_device1:3>, [
	[<ore:plateSteel>, <ore:plateSteel>, <ore:plateSteel>],
	[<ore:plateCupronickel>, <ore:coilCopper>, <ore:plateCupronickel>],
	[<ore:plateCupronickel>, <ore:plateCupronickel>, <ore:plateCupronickel>]
]);

recipes.addShaped("ie_mechanical_component_iron", <immersiveengineering:material:8>, [
	[<ore:plateIron>, <ore:gearIron>, <ore:plateIron>],
	[<ore:boltIron>, <ore:plateCopper>, <ore:boltIron>],
	[<ore:plateIron>, <ore:screwIron>, <ore:plateIron>]
]);

recipes.addShaped("ie_mechanical_component_steel", <immersiveengineering:material:9>, [
	[<ore:plateSteel>, <ore:gearSteel>, <ore:plateSteel>],
	[<ore:boltSteel>, <ore:plateCopper>, <ore:boltSteel>],
	[<ore:plateSteel>, <ore:screwSteel>, <ore:plateSteel>]
]);

recipes.addShaped("ie_wooden_grip", <immersiveengineering:material:13>, [
	[<ore:plateWood>, <ore:plateWood>, <ore:gregSaws>],
	[<ore:screwBronze>,<ore:plateWood>, <ore:gregScrewDrivers>],
	[<ore:plateWood>, <ore:plateWood>, null]
]);

recipes.addShaped("ie_gun_barrel", <immersiveengineering:material:14>, [
	[null, <ore:gregSaws>, null],
	[<ore:stickSteel>, <ore:stickSteel>, <ore:gregFiles>],
	[null, null, null]
]);

recipes.addShaped("ie_revolver_drum", <immersiveengineering:material:15>, [
	[null, null, null],
	[<ore:plateCurvedSteel>, <immersiveengineering:material:8>, <ore:plateCurvedSteel>],
	[null, null, null]
]);

recipes.addShaped("ie_revolver_hammer", <immersiveengineering:material:16>, [
	[null, null, <ore:gregHardHammers>],
	[<ore:boltSteel>, <ore:stickSteel>, null],
	[null, null, null]
]);

recipes.addShaped("ie_redstone_wirecoil", <immersiveengineering:wirecoil:5>*4, [
	[null, <ore:wireFineRedAlloy>, null],
	[<ore:wireFineRedAlloy>, <ore:stickWood>, <ore:wireFineRedAlloy>],
	[null, <ore:wireFineRedAlloy>, null]
]);

recipes.addShaped("ie_structural_wirecoil", <immersiveengineering:wirecoil:4>*4, [
	[null, <ore:wireFineSteel>, null],
	[<ore:wireFineSteel>, <ore:stickWood>, <ore:wireFineSteel>],
	[null, <ore:wireFineSteel>, null]
]);

recipes.addShaped("ie_voltmeter", <immersiveengineering:tool:2>, [
	[null, null, null],
	[null, <minecraft:compass>, null],
	[<ore:stickWood>, <ore:plateCopper>, <ore:stickWood>]
]);

recipes.addShaped("ie_wirecutters", <immersiveengineering:tool:1>, [
	[<ore:plateIron>, null, <ore:plateIron>],
	[<ore:stickWood>, <ore:boltIron>, <ore:stickWood>],
	[<ore:stickWood>, null, <ore:stickWood>]
]);

recipes.addShaped("ie_drillhead_steel", <immersiveengineering:drillhead:0>, [
	[<ore:plateCurvedSteel>, <ore:plateCurvedSteel>, null],
	[<ore:blockSteel>, <ore:blockSteel>, <ore:plateSteel>],
	[<ore:plateCurvedSteel>, <ore:plateCurvedSteel>, null]
]);

recipes.addShaped("ie_drillhead_iron", <immersiveengineering:drillhead:1>, [
	[<ore:plateCurvedIron>, <ore:plateCurvedIron>, null],
	[<ore:blockIron>, <ore:blockIron>, <ore:plateIron>],
	[<ore:plateCurvedIron>, <ore:plateCurvedIron>, null]
]);

recipes.addShaped("ie_bp_basic_circuits", <immersiveengineering:blueprint>.withTag({blueprint: "basic_circuits"}), [
	[<ore:wireFineRedAlloy>, <ore:paper>, <ore:wireFineRedAlloy>],
	[<ore:dyeBlue>, <ore:dyeBlue>, <ore:dyeBlue>],
	[<ore:paper>, <ore:paper>, <ore:paper>]
]);

recipes.addShaped("ie_speedloader", <immersiveengineering:speedloader>, [
	[null, <ore:gregHardHammers>, <ore:plateSteel>],
	[<ore:stickSteel>, <ore:stickSteel>, <ore:plateSteel>],
	[null, <ore:gregFiles>, <ore:plateSteel>]
]);

recipes.addShaped("ie_skyhook", <immersiveengineering:skyhook>, [
	[<ore:plateSteel>, <ore:plateSteel>, <ore:gregScrewDrivers>],
	[<ore:plateSteel>, <immersiveengineering:material:8>, motors[1]],
	[motors[1], <ore:plateSteel>, <immersiveengineering:material:13>]
]);

recipes.addShaped("vacuum_ejector", <contenttweaker:unsoldered_vacuum_ejector>, [
	[<ore:gregSaws>, <ore:gregFiles>, <ore:plateCurvedBrass>],
	[<ore:gregWrenches>, <ore:gregHardHammers>, <ore:plateCurvedBrass>],
	[<ore:plateCurvedBrass>, <ore:plateCurvedBrass>, <ore:plateCurvedBrass>]
]);

recipes.addShaped("ie_lv_capacitor", <immersiveengineering:metal_device0:0>, [
	[<ore:plateSteel>, <ore:plateSteel>, <ore:plateSteel>],
	[<ore:plateCopper>, <ore:plateWood>, <ore:plateCopper>],
	[<ore:plankTreatedWood>, <ore:wireFineRedAlloy>, <ore:plankTreatedWood>]
]);

recipes.addShaped("ie_mv_capacitor", <immersiveengineering:metal_device0:1>, [
	[<ore:plateSteel>, <ore:plateSteel>, <ore:plateSteel>],
	[<ore:plateIron>, <ore:plateWood>, <ore:plateIron>],
	[<ore:plankTreatedWood>, <ore:wireFineRedAlloy>, <ore:plankTreatedWood>]
]);

recipes.addShaped("ie_hv_capacitor", <immersiveengineering:metal_device0:2>, [
	[<ore:plateSteel>, <ore:plateSteel>, <ore:plateSteel>],
	[<ore:plateElectrum>, <ore:plateWood>, <ore:plateElectrum>],
	[<ore:plankTreatedWood>, <ore:wireFineRedAlloy>, <ore:plankTreatedWood>]
]);

recipes.addShaped("ie_pump", <immersiveengineering:metal_device0:5>, [
	[<ore:gregWrenches>, <ore:plateIron>, <ore:gregHardHammers>],
	[<ore:plateIron>, pumps[1], <ore:plateIron>],
	[<immersiveengineering:metal_device1:6>, <immersiveengineering:metal_device1:6>, <immersiveengineering:metal_device1:6>]
]);

recipes.addShaped("ie_powered_lantern", <immersiveengineering:metal_device1:4>*3, [
	[<ore:gregScrewDrivers>, <ore:plateIron>, <ore:gregWrenches>],
	[<ore:paneGlass>, circuits[0], <ore:paneGlass>],
	[<ore:plateIron>, <ore:wireFineRedAlloy>, <ore:plateIron>]
]);

recipes.addShaped("ie_charger", <immersiveengineering:metal_device1:5>, [
	[<ore:plateIron>, <immersiveengineering:connector:2>, <ore:plateIron>],
	[<ore:paneGlass>, <ore:paneGlass>, <ore:paneGlass>],
	[<ore:plankTreatedWood>, <ore:coilCopper>, <ore:plankTreatedWood>]
]);

recipes.addShaped("ie_pipes", <immersiveengineering:metal_device1:6>*8, [
	[<ore:plateCurvedIron>, <ore:gregHardHammers>, <ore:plateCurvedIron>],
	[<ore:plateCurvedIron>, <ore:gregBendingCylinders>, <ore:plateCurvedIron>],
	[<ore:plateCurvedIron>, <ore:gregWrenches>, <ore:plateCurvedIron>]
]);

recipes.addShaped("ie_core_sample_drill", <immersiveengineering:metal_device1:7>, [
	[<ore:scaffoldingSteel>, pistons[1], <ore:scaffoldingSteel>],
	[<ore:scaffoldingSteel>, <ore:stickLongSteel>, <ore:scaffoldingSteel>],
	[<ore:irLightEngineering>, <ore:stickLongSteel>, <ore:irLightEngineering>]
]);

recipes.addShaped("ie_floodlight", <immersiveengineering:metal_device1:9>, [
	[<ore:plateIron>, <ore:plateIron>, <ore:plateIron>],
	[<ore:paneGlass>, circuits[0], <ore:coilCopper>],
	[<ore:plateIron>, <immersiveengineering:material:8>, <ore:plateIron>]
]);

recipes.addShaped("ie_garden_cloche", <immersiveengineering:metal_device1:13>, [
	[<ore:paneGlass>, circuits[0], <ore:paneGlass>],
	[<ore:paneGlass>, null, <ore:paneGlass>],
	[<ore:plankTreatedWood>, <immersiveengineering:material:8>, <ore:plankTreatedWood>]
]);

alloy_smelter.recipeBuilder()
	.duration(60)
	.EUt(8)
	.inputs(<ore:blockGlass>*2)
	.inputs(<ore:dustIron>*2)
	.outputs(<immersiveengineering:stone_decoration:8>*2)
	.buildAndRegister();
	
alloy_smelter.recipeBuilder()
	.duration(60)
	.EUt(8)
	.inputs(<contenttweaker:unsoldered_vacuum_ejector>)
	.inputs(<ore:wireFineTin>)
	.outputs(<contenttweaker:vacuum_ejector>)
	.buildAndRegister();
	
alloy_smelter.recipeBuilder()
	.duration(60)
	.EUt(8)
	.inputs(<contenttweaker:vacuum_ejector>*5)
	.inputs(<ore:wireFineTin>*4)
	.outputs(<contenttweaker:vacuum_ejector_cascade>)
	.buildAndRegister();
	
mixer.recipeBuilder()
	.duration(75)
	.EUt(4)
	.inputs(<ore:plankWood>)
	.fluidInputs(<liquid:creosote>*125)
	.outputs(<immersiveengineering:treated_wood:0>)
	.buildAndRegister();

val FermenterYeetFluid as ILiquidStack[] = [
	<liquid:ethanol>
];

val SqueezerYeetFluid as ILiquidStack[] = [
	<liquid:plantoil>,
	<liquid:blood>
];

val MetalPressYeet as IItemStack[] = [
	<immersiveengineering:metal:30>,
	<immersiveengineering:metal:31>,
	<immersiveengineering:metal:32>,
	<immersiveengineering:metal:33>,
	<immersiveengineering:metal:34>,
	<immersiveengineering:metal:35>,
	<immersiveengineering:metal:36>,
	<immersiveengineering:metal:37>,
	<immersiveengineering:metal:38>,
	<immersiveengineering:metal:39>,
	<immersiveengineering:metal:40>,
	<immersiveengineering:material:20>,
	<immersiveengineering:material:21>,
	<immersiveengineering:material:22>,
	<immersiveengineering:material:23>,
	<immersiveengineering:graphite_electrode>,
	<machinemod:irongear>,
	<libvulpes:productgear:6>,
	<libvulpes:productgear:7>,
	<advancedrocketry:productgear:0>,
	<advancedrocketry:productgear:1>,
	<libvulpes:productplate:3>,
	<libvulpes:productplate:5>,
	<libvulpes:productplate:7>,
	<libvulpes:productplate:10>,
	<advancedrocketry:productplate:0>,
	<advancedrocketry:productplate:1>,
	<techguns:itemshared:49>,
	<techguns:itemshared:53>,
	<techguns:itemshared:51>,
	<alternatingflux:material:0>,
	<techguns:itemshared:63>,
	<immersiveengineering:bullet:0>,
	<immersiveengineering:material:1>,
	<libvulpes:productrod:4>,
	<immersiveengineering:material:2>,
	<libvulpes:productrod:7>,
	<libvulpes:productrod:10>,
	<advancedrocketry:productrod:0>,
	<advancedrocketry:productrod:1>,
	<immersiveengineering:material:3>,
	<immersiveposts:metal_rods:0>,
	<immersiveposts:metal_rods:2>,
	<immersiveposts:metal_rods:3>,
	<immersiveposts:metal_rods:4>,
	<immersiveposts:metal_rods:5>,
	<immersiveposts:metal_rods:6>,
	<immersiveposts:metal_rods:7>,
	<minecraft:melon>
];

val BlastFurnaceYeet as IItemStack[] = [
	<immersiveengineering:metal:8>,
	<immersiveengineering:storage:8>
];

val CokeOvenYeet as IItemStack[] = [
	<immersiveengineering:material:6>,
	<immersiveengineering:stone_decoration:3>,
	<minecraft:coal:1>
];

val CrusherYeet as IItemStack[] = [
	<minecraft:gravel>,
	<minecraft:sand>,
	<minecraft:clay_ball>,
	<minecraft:quartz>,
	<minecraft:glowstone_dust>,
	<minecraft:blaze_powder>,
	<minecraft:dye:15>,
	<immersiveengineering:material:17>,
	<minecraft:string>,
	<immersiveengineering:metal:19>,
	<immersiveengineering:metal:18>,
	<minecraft:dye:4>,
	<minecraft:diamond>,
	<minecraft:redstone>,
	<minecraft:emerald>,
	<minecraft:quartz>,
	<minecraft:coal>,
	<minecraft:prismarine_crystals>,
	<enderio:item_material:32>,
	//<draconicevolution:draconium_dust>,
	<immersiveengineering:metal:18>,
	<immersiveengineering:metal:9>,
	<immersiveengineering:metal:11>,
	<immersiveengineering:metal:14>,
	<immersiveengineering:metal:10>,
	<immersiveengineering:metal:12>,
	<immersiveengineering:metal:13>,
	<immersiveengineering:metal:15>,
	<immersiveengineering:metal:16>
];

val MixerYeet as ILiquidStack[] = [
	<liquid:concrete>,
	<liquid:brine>,
	<liquid:methanol>,
	<liquid:sulfuric_acid>,
	<liquid:hydrofluoric_acid>,
	<liquid:nitric_acid>,
	<liquid:napalm>
];

val RefineryYeet as ILiquidStack[] = [
	<liquid:biodiesel>
];

//Arc Furnace Removals
val ArcFurnaceYeet as IOreDictEntry[] = [
	<ore:ingotConstantan>,
	<ore:ingotDraconium>,
	<ore:ingotAluminium>,
	<ore:ingotAluminum>,
	<ore:ingotTungsten>,
	<ore:ingotTitanium>,
	<ore:ingotChromium>,
	<ore:ingotZirconium>,
	<ore:ingotOsmium>,
	<ore:ingotIridium>,
	<ore:ingotPlatinum>
];

val ArcFurnaceYeet1 as IItemStack[] = [
	<immersiveengineering:metal:8>,
	<immersiveengineering:metal:7>,
	<immersiveengineering:metal:0>,
	<immersiveengineering:metal:2>,
	<immersiveengineering:metal:5>,
	<immersiveengineering:metal:6>,
	<immersiveengineering:metal:1>,
	<immersiveengineering:metal:3>,
	<immersiveengineering:metal:4>,
	<libvulpes:productingot:3>,
	<advancedrocketry:productingot:0>,
	<advancedrocketry:productingot:1>,
	<nuclearcraft:alloy:0>,
	<nuclearcraft:alloy:13>,
	<nuclearcraft:ingot:1>,
	<nuclearcraft:ingot:3>,
	<nuclearcraft:ingot:5>,
	<nuclearcraft:ingot:6>,
	<nuclearcraft:ingot:7>,
	<nuclearcraft:ingot:8>,
	<nuclearcraft:ingot:9>,
	<nuclearcraft:ingot:10>,
	<nuclearcraft:ingot:11>,
	<nuclearcraft:ingot:14>,
	<nuclearcraft:ingot:15>,
	<enderio:item_alloy_ingot:7>,
	<qmd:ingot:0>,
	<qmd:ingot:1>,
	<qmd:ingot:3>,
	<qmd:ingot:4>,
	<qmd:ingot:6>,
	<qmd:ingot:7>,
	<qmd:ingot:8>,
	<qmd:ingot:9>,
	<qmd:ingot:10>,
	<qmd:ingot:11>,
	<qmd:ingot:12>,
	<qmd:ingot:13>,
	<qmd:ingot:14>,
	<qmd:ingot2:0>,
	<qmd:ingot2:1>,
	<trinity:ingot_au_198>
];

for yeets in ArcFurnaceYeet {
	for yeet in yeets.items {
		mods.immersiveengineering.ArcFurnace.removeRecipe(yeet);
	}
}

for yeet in ArcFurnaceYeet1 {
	mods.immersiveengineering.ArcFurnace.removeRecipe(yeet);
}

//BlastFurnace Removals
for yeet in BlastFurnaceYeet {
	mods.immersiveengineering.BlastFurnace.removeRecipe(yeet);
}

//Blueprint Removals
mods.immersiveengineering.Blueprint.removeRecipe(<immersiveengineering:material:8>);
mods.immersiveengineering.Blueprint.removeRecipe(<immersiveengineering:material:9>);
mods.immersiveengineering.Blueprint.removeRecipe(<immersiveengineering:material:26>);
mods.immersiveengineering.Blueprint.removeRecipe(<immersiveengineering:material:27>);

//mods.immersiveengineering.Blueprint.removeRecipe(<immersiveintelligence:material_spring:0>);
//mods.immersiveengineering.Blueprint.removeRecipe(<immersiveintelligence:material_spring:1>);
//mods.immersiveengineering.Blueprint.removeRecipe(<immersiveintelligence:material_spring:2>);

//Coke Oven Removals
for yeet in CokeOvenYeet {
	mods.immersiveengineering.CokeOven.removeRecipe(yeet);
}

//Crusher Removals
for yeet in CrusherYeet {
	mods.immersiveengineering.Crusher.removeRecipe(yeet);
}

//Vacuum tube crafting
mods.immersiveengineering.Blueprint.addRecipe("basic_circuits", <contenttweaker:unfinished_vacuum_tube>, [<ore:wireFineCopper>*3, <metaitem:component.glass.tube>, <ore:plateCurvedCopper>*3, <ore:wireFineSteel>]);
mods.immersiveengineering.Blueprint.addRecipe("basic_circuits", <contenttweaker:unfinished_vacuum_tube>, [<ore:wireGtSingleCopper>*3, <metaitem:component.glass.tube>, <ore:plateCurvedCopper>*3, <ore:wireFineSteel>]);

//Basic circuit board crafting
mods.immersiveengineering.Blueprint.addRecipe("basic_circuits", <metaitem:board.basic>, [<ore:wireGtSingleCopper>*4, <metaitem:board.coated>]);

//Boiler recipes
/*mods.immersivetechnology.Boiler.addRecipe(<liquid:steam> * 9600, <liquid:water> * 60, 10);
mods.immersivetechnology.Boiler.addRecipe(<liquid:steam> * 9600, <liquid:distilled_water> * 60, 5);
mods.immersivetechnology.Boiler.addFuel(<liquid:biodiesel> * 100, 10, 1);
mods.immersivetechnology.Boiler.addFuel(<liquid:gasoline> * 500, 10, 1);
mods.immersivetechnology.Boiler.addFuel(<liquid:diesel> * 70, 10, 1);
*/

//Putting the vacuum in vacuum tubes
mods.immersiveengineering.BottlingMachine.addRecipe(<metaitem:circuit.vacuum_tube>, <contenttweaker:unfinished_vacuum_tube>, <liquid:extremely_high_vacuum>*10);

//II Chemical Bath Recipes
/*mods.immersiveintelligence.ChemicalBath.removeRecipe(<immersiveintelligence:material:3>);
//mods.immersiveintelligence.ChemicalBath.removeRecipe(<immersiveintelligence:material:6>);
//mods.immersiveintelligence.ChemicalBath.removeRecipe(<immersiveintelligence:material:11>);

//mods.immersiveintelligence.ChemicalBath.addRecipe(<contenttweaker:raw_basic_circuit_board>, <metaitem:board.basic>, <liquid:etching_acid>*100, 100, 80);

//II Electrolyzer Recipes
//mods.immersiveintelligence.Electrolyzer.removeRecipe(<liquid:oxygen>*250, <liquid:hydrogen>*500);
//mods.immersiveintelligence.Electrolyzer.removeRecipe(<liquid:chlorine>*375, <liquid:hydrogen>*375);

mods.immersiveintelligence.Electrolyzer.addRecipe(<liquid:water>*500, <liquid:hydrogen>*1000, 120, 750, <liquid:oxygen>*500);
*/

//Fermenter removals
for yeet in FermenterYeetFluid {
	mods.immersiveengineering.Fermenter.removeFluidRecipe(yeet);
}

//Metal Press Removals
for yeet in MetalPressYeet {
	mods.immersiveengineering.MetalPress.removeRecipe(yeet);
}

//Arc Furnace recipes

val ArcFurnaceDustMap as IItemStack[IOreDictEntry] = {
	<ore:dustCopper> : <ore:IngotCopper>.firstItem,
	<ore:dustZinc> : <ore:ingotZinc>.firstItem,
	<ore:dustSilver> : <ore:ingotSilver>.firstItem,
	<ore:dustSteel> : <ore:ingotSteel>.firstItem,
	<ore:dustLead> : <ore:ingotLead>.firstItem,
	<ore:dustBrass> : <ore:ingotBrass>.firstItem,
	<ore:dustBronze> : <ore:ingotBronze>.firstItem,
	<ore:dustCupronickel> : <ore:ingotCupronickel>.firstItem,
	<ore:dustThorium> : <ore:ingotThorium>.firstItem,
	<ore:dustUranium> : <ore:ingotUranium>.firstItem,
	<ore:dustUraniumRadioactive> : <ore:ingotUraniumRadioactive>.firstItem
};

for key in ArcFurnaceDustMap {
	mods.immersiveengineering.ArcFurnace.addRecipe(ArcFurnaceDustMap[key], key, null, 10, 512);
}

//Metal Press recipes
mods.immersiveengineering.MetalPress.addRecipe(<immersiveengineering:graphite_electrode>.withTag({Unbreakable: 1 as byte}), <ore:ingotHOPGraphite>*4, <immersiveengineering:mold:2>, 200);

val PlateMap = {
	<ore:ingotIron> : <ore:plateIron>.firstItem,
	<ore:ingotCopper> : <ore:plateCopper>.firstItem,
	<ore:ingotTin> : <ore:plateTin>.firstItem,
	<ore:ingotBrass> : <ore:plateBrass>.firstItem,
	<ore:ingotBronze> : <ore:plateBronze>.firstItem,
	<ore:ingotSteel> : <ore:plateSteel>.firstItem,
	<ore:ingotNickel> : <ore:plateNickel>.firstItem,
	<ore:ingotCupronickel> : <ore:plateCupronickel>.firstItem,
	<ore:ingotGold> : <ore:plateGold>.firstItem,
	<ore:ingotSilver> : <ore:plateSilver>.firstItem,
	<ore:ingotZinc> : <ore:plateZinc>.firstItem,
	<ore:ingotLead> : <ore:plateLead>.firstItem,
	<ore:ingotRubber> : <ore:plateRubber>.firstItem
} as IItemStack[IOreDictEntry];

val RotorMap = {
	<ore:ingotTin> : <ore:rotorTin>.firstItem,
	<ore:ingotBronze> : <ore:rotorBronze>.firstItem,
	<ore:ingotSteel> : <ore:rotorSteel>.firstItem
} as IItemStack[IOreDictEntry];

for key in PlateMap {
	mods.immersiveengineering.MetalPress.addRecipe(PlateMap[key], key, <metaitem:shape.mold.plate>, 200);
}

for key in RotorMap {
	mods.immersiveengineering.MetalPress.addRecipe(RotorMap[key], key * 5, <metaitem:shape.mold.rotor>, 200);
}

//Mixer Recipes
for yeet in MixerYeet {
	mods.immersiveengineering.Mixer.removeRecipe(yeet);
}

for yeet in RefineryYeet {
	mods.immersiveengineering.Refinery.removeRecipe(yeet);
}

//Steam Turbine Recipes
//mods.immersivetechnology.SteamTurbine.addFuel(<liquid:exhaust_steam>*500, <liquid:steam>*500, 1);

//Squeezer removals
for yeet in SqueezerYeetFluid {
	mods.immersiveengineering.Squeezer.removeFluidRecipe(yeet);
}

<immersiveengineering:faraday_suit_head>.maxDamage = 100;
<immersiveengineering:faraday_suit_chest>.maxDamage = 100;
<immersiveengineering:faraday_suit_legs>.maxDamage = 100;
<immersiveengineering:faraday_suit_feet>.maxDamage = 100;