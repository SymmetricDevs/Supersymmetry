#norun
import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.liquid.ILiquidStack;
import crafttweaker.oredict.IOreDictEntry;

val name_removals as string[] = [
	"xnet:netcable_0",
	"xnet:netcable_routing",
	"xnet:connector_0",
	"xnet:advanced_connector_0",
	"xnet:controller_rftools",
	"xnet:router_rftools",
	"xnet:wireless_router_rftools",
	"xnet:antenna",
	"xnet:antenna_base",
	"xnet:antenna_dish",
	"xnet:redstone_proxy_rftools",
	"xnet:redstone_proxy_upd",
	"xnet:connector_routing",
	"xnet:connector_upgrade",
	"xnet:xnet_manual"
];

for item in name_removals {
	recipes.removeByRecipeName(item);
}

recipes.addShapeless("xnet_redstone_proxy_1", <xnet:redstone_proxy>, [<xnet:redstone_proxy_upd>]);
recipes.addShapeless("xnet_redstone_proxy_2", <xnet:redstone_proxy_upd>, [<xnet:redstone_proxy>]);

recipes.addShaped("xnet_cable", <xnet:netcable:0>*24, [
	[<ore:cableGtSingleTin>, <ore:cableGtSingleTin>, <ore:cableGtSingleTin>],
	[<ore:plateSteel>, <ore:plateSteel>, <ore:plateSteel>],
	[<ore:pipeTinySteel>, <ore:pipeTinySteel>, <ore:pipeTinySteel>]
]);

recipes.addShaped("xnet_cable_routing", <xnet:netcable:4>*48, [
	[<ore:cableGtQuadrupleTin>, <ore:cableGtQuadrupleTin>, <ore:cableGtQuadrupleTin>],
	[<ore:plateSteel>, <ore:plateSteel>, <ore:plateSteel>],
	[<ore:pipeMediumSteel>, <ore:pipeMediumSteel>, <ore:pipeMediumSteel>]
]);

recipes.addShaped("xnet_connector", <xnet:connector:0>, [
	[<ore:plateSteel>, circuits[1], <ore:plateSteel>],
	[robotArms[1], hulls[1], pumps[1]],
	[<ore:plateSteel>, <ore:wireGtSingleTin>, <ore:plateSteel>]
]);

recipes.addShaped("xnet_connector_advanced", <xnet:advanced_connector:0>, [
	[<ore:plateAluminium>, circuits[2], <ore:plateAluminium>],
	[robotArms[2], hulls[2], pumps[2]],
	[<ore:plateAluminium>, <ore:wireGtSingleAnnealedCopper>, <ore:plateAluminium>]
]);

recipes.addShaped("xnet_controller", <xnet:controller>, [
	[<xnet:netcable:0>, <xnet:netcable:0>, <xnet:netcable:0>],
	[<ore:wireFineRedAlloy>, hulls[1], <ore:wireFineRedAlloy>],
	[<ore:plateSteel>, circuits[1], <ore:plateSteel>]
]);

recipes.addShaped("xnet_router", <xnet:router>, [
	[<xnet:netcable:0>, <xnet:connector:0>, <xnet:netcable:0>],
	[<ore:wireFineRedAlloy>, hulls[1], <ore:wireFineRedAlloy>],
	[<ore:plateSteel>, circuits[1], <ore:plateSteel>]
]);

recipes.addShaped("xnet_redstone_proxy", <xnet:redstone_proxy>, [
	[<ore:wireFineRedAlloy>, <ore:blockRedstone>, <ore:wireFineRedAlloy>],
	[<ore:wireFineRedAlloy>, hulls[1], <ore:wireFineRedAlloy>],
	[<ore:wireFineRedAlloy>, <ore:wireFineRedAlloy>, <ore:wireFineRedAlloy>]
]);

recipes.addShaped("xnet_routing_connector", <xnet:connector:4>, [
	[<ore:wireFineRedAlloy>, <ore:wireFineRedAlloy>, <ore:wireFineRedAlloy>],
	[<ore:plateGold>, <xnet:connector:0>, <ore:plateGold>],
	[<ore:wireFineRedAlloy>, <ore:wireFineRedAlloy>, <ore:wireFineRedAlloy>]
]);

recipes.addShaped("xnet_connector_upgrade", <xnet:connector_upgrade>, [
	[<ore:plateAluminium>, <ore:plateAluminium>, <ore:plateAluminium>],
	[robotArms[2], circuits[2], pumps[2]],
	[<ore:plateAluminium>, <ore:plateAluminium>, <ore:plateAluminium>]
]);