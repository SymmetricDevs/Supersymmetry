println("Running XNet.groovy...")

/*
def name_removals = [
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
]

for (item in name_removals) {
    //crafting.remove(item);
}

crafting.addShapeless("xnet_redstone_proxy_1", item('xnet:redstone_proxy'), [item('xnet:redstone_proxy_upd')]);
crafting.addShapeless("xnet_redstone_proxy_2", item('xnet:redstone_proxy_upd'), [item('xnet:redstone_proxy')]);

crafting.addShaped("xnet_cable", item('xnet:netcable:0')*24, [
        [ore('cableGtSingleTin'), ore('cableGtSingleTin'), ore('cableGtSingleTin')],
        [ore('plateSteel'), ore('plateSteel'), ore('plateSteel')],
        [ore('pipeTinySteel'), ore('pipeTinySteel'), ore('pipeTinySteel')]
]);

crafting.addShaped("xnet_cable_routing", item('xnet:netcable:4')*48, [
        [ore('cableGtQuadrupleTin'), ore('cableGtQuadrupleTin'), ore('cableGtQuadrupleTin')],
        [ore('plateSteel'), ore('plateSteel'), ore('plateSteel')],
        [ore('pipeMediumSteel'), ore('pipeMediumSteel'), ore('pipeMediumSteel')]
]);

crafting.addShaped("xnet_connector", item('xnet:connector:0'), [
        [ore('plateSteel'), ore('circuitLv'), ore('plateSteel')],
        [metaitem('robot.arm.lv'), metaitem('hull.lv'), metaitem('pump.lv')],
        [ore('plateSteel'), ore('wireGtSingleTin'), ore('plateSteel')]
]);

crafting.addShaped("xnet_connector_advanced", item('xnet:advanced_connector:0'), [
        [ore('plateAluminium'), ore('circuitMv'), ore('plateAluminium')],
        [metaitem('robot.arm.mv'), metaitem('hull.mv'), metaitem('pump.mv')],
        [ore('plateAluminium'), ore('wireGtSingleAnnealedCopper'), ore('plateAluminium')]
]);

crafting.addShaped("xnet_controller", item('xnet:controller'), [
        [item('xnet:netcable:0'), item('xnet:netcable:0'), item('xnet:netcable:0')],
        [ore('wireFineRedAlloy'), metaitem('hull.lv'), ore('wireFineRedAlloy')],
        [ore('plateSteel'), ore('circuitLv'), ore('plateSteel')]
]);

crafting.addShaped("xnet_router", item('xnet:router'), [
        [item('xnet:netcable:0'), item('xnet:connector:0'), item('xnet:netcable:0')],
        [ore('wireFineRedAlloy'), metaitem('hull.lv'), ore('wireFineRedAlloy')],
        [ore('plateSteel'), ore('circuitLv'), ore('plateSteel')]
]);

crafting.addShaped("xnet_redstone_proxy", item('xnet:redstone_proxy'), [
        [ore('wireFineRedAlloy'), ore('blockRedstone'), ore('wireFineRedAlloy')],
        [ore('wireFineRedAlloy'), metaitem('hull.lv'), ore('wireFineRedAlloy')],
        [ore('wireFineRedAlloy'), ore('wireFineRedAlloy'), ore('wireFineRedAlloy')]
]);

crafting.addShaped("xnet_routing_connector", item('xnet:connector:4'), [
        [ore('wireFineRedAlloy'), ore('wireFineRedAlloy'), ore('wireFineRedAlloy')],
        [ore('plateGold'), item('xnet:connector:0'), ore('plateGold')],
        [ore('wireFineRedAlloy'), ore('wireFineRedAlloy'), ore('wireFineRedAlloy')]
]);

crafting.addShaped("xnet_connector_upgrade", item('xnet:connector_upgrade'), [
        [ore('plateAluminium'), ore('plateAluminium'), ore('plateAluminium')],
        [metaitem('robot.arm.mv'), ore('circuitMv'), metaitem('pump.mv')],
        [ore('plateAluminium'), ore('plateAluminium'), ore('plateAluminium')]
]);
*/