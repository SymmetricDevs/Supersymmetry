def name_removals = [
        "xnet:netcable_0",
        "xnet:netcable_routing",
        "xnet:connector_0",
        "xnet:advanced_connector_0",
        "xnet:controller_rftools",
        "xnet:router_rftools",
        "xnet:wireless_router_rftools",
        "xnet:redstone_proxy_rftools",
        "xnet:redstone_proxy_upd",
        "xnet:connector_routing",
        "xnet:connector_upgrade",
        "xnet:xnet_manual",
        "xnet:netcable_1",
        "xnet:netcable_2",
        "xnet:netcable_3",
        "xnet:netcable_4",
        "xnet:antenna",
        "xnet:antenna_base",
        "xnet:antenna_dish"
]

for (item in name_removals) {
    crafting.remove(item);
}

crafting.addShapeless("xnet_redstone_proxy_1", item('xnet:redstone_proxy'), [item('xnet:redstone_proxy_upd')]);
crafting.addShapeless("xnet_redstone_proxy_2", item('xnet:redstone_proxy_upd'), [item('xnet:redstone_proxy')]);

crafting.addShaped("xnet_cable", item('xnet:netcable:0') * 24, [
        [ore('cableGtSingleTin'), ore('cableGtSingleTin'), ore('cableGtSingleTin')],
        [ore('plateSteel'), ore('plateSteel'), ore('plateSteel')],
        [metaitem('pipeTinyFluidSteel'), metaitem('pipeTinyFluidSteel'), metaitem('pipeTinyFluidSteel')]
]);

crafting.addShaped("xnet_cable_routing", item('xnet:netcable:4') * 48, [
        [ore('cableGtQuadrupleTin'), ore('cableGtQuadrupleTin'), ore('cableGtQuadrupleTin')],
        [ore('plateSteel'), ore('plateSteel'), ore('plateSteel')],
        [metaitem('pipeNormalFluidSteel'), metaitem('pipeNormalFluidSteel'), metaitem('pipeNormalFluidSteel')]
]);

crafting.addShaped("xnet_connector", item('xnet:connector:0') * 4, [
        [null, ore('circuitLv'), null],
        [metaitem('robot.arm.lv'), metaitem('hull.lv'), metaitem('electric.pump.lv')],
        [null, ore('wireGtSingleTin'), null]
]);

crafting.addShaped("xnet_connector_advanced", item('xnet:advanced_connector:0') * 4, [
        [null, ore('circuitMv'), null],
        [metaitem('robot.arm.mv'), metaitem('hull.mv'), metaitem('electric.pump.mv')],
        [null, ore('wireGtSingleAnnealedCopper'), null]
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

crafting.addShaped("xnet_connector_upgrade", item('xnet:connector_upgrade') * 4, [
        [ore('plateAluminium'), ore('plateAluminium'), ore('plateAluminium')],
        [metaitem('robot.arm.mv'), ore('circuitMv'), metaitem('electric.pump.mv')],
        [ore('plateAluminium'), ore('plateAluminium'), ore('plateAluminium')]
]);

mods.gregtech.chemical_bath.recipeBuilder()
        .fluidInputs(fluid('dye_yellow') * 18)
        .inputs(item('xnet:netcable'))
        .outputs(item('xnet:netcable', 2).withNbt(["display": ["LocName": "tile.xnet.netcable_yellow.name"]]))
        .duration(20)
        .EUt(7)
        .buildAndRegister();

mods.gregtech.chemical_bath.recipeBuilder()
        .fluidInputs(fluid('dye_yellow') * 18)
        .inputs(item('xnet:netcable', 1))
        .outputs(item('xnet:netcable', 2).withNbt(["display": ["LocName": "tile.xnet.netcable_yellow.name"]]))
        .duration(20)
        .EUt(7)
        .buildAndRegister();

mods.gregtech.chemical_bath.recipeBuilder()
        .fluidInputs(fluid('dye_yellow') * 18)
        .inputs(item('xnet:netcable', 3))
        .outputs(item('xnet:netcable', 2).withNbt(["display": ["LocName": "tile.xnet.netcable_yellow.name"]]))
        .duration(20)
        .EUt(7)
        .buildAndRegister();

mods.gregtech.chemical_bath.recipeBuilder()
        .fluidInputs(fluid('dye_blue') * 18)
        .inputs(item('xnet:netcable', 2))
        .outputs(item('xnet:netcable').withNbt(["display": ["LocName": "tile.xnet.netcable_blue.name"]]))
        .duration(20)
        .EUt(7)
        .buildAndRegister();

mods.gregtech.chemical_bath.recipeBuilder()
        .fluidInputs(fluid('dye_blue') * 18)
        .inputs(item('xnet:netcable', 1))
        .outputs(item('xnet:netcable').withNbt(["display": ["LocName": "tile.xnet.netcable_blue.name"]]))
        .duration(20)
        .EUt(7)
        .buildAndRegister();

mods.gregtech.chemical_bath.recipeBuilder()
        .fluidInputs(fluid('dye_blue') * 18)
        .inputs(item('xnet:netcable', 3))
        .outputs(item('xnet:netcable').withNbt(["display": ["LocName": "tile.xnet.netcable_blue.name"]]))
        .duration(20)
        .EUt(7)
        .buildAndRegister();

mods.gregtech.chemical_bath.recipeBuilder()
        .fluidInputs(fluid('dye_red') * 18)
        .inputs(item('xnet:netcable', 2))
        .outputs(item('xnet:netcable', 1).withNbt(["display": ["LocName": "tile.xnet.netcable_red.name"]]))
        .duration(20)
        .EUt(7)
        .buildAndRegister();

mods.gregtech.chemical_bath.recipeBuilder()
        .fluidInputs(fluid('dye_red') * 18)
        .inputs(item('xnet:netcable'))
        .outputs(item('xnet:netcable', 1).withNbt(["display": ["LocName": "tile.xnet.netcable_red.name"]]))
        .duration(20)
        .EUt(7)
        .buildAndRegister();

mods.gregtech.chemical_bath.recipeBuilder()
        .fluidInputs(fluid('dye_red') * 18)
        .inputs(item('xnet:netcable', 3))
        .outputs(item('xnet:netcable', 1).withNbt(["display": ["LocName": "tile.xnet.netcable_red.name"]]))
        .duration(20)
        .EUt(7)
        .buildAndRegister();

mods.gregtech.chemical_bath.recipeBuilder()
        .fluidInputs(fluid('dye_green') * 18)
        .inputs(item('xnet:netcable', 2))
        .outputs(item('xnet:netcable', 3).withNbt(["display": ["LocName": "tile.xnet.netcable_green.name"]]))
        .duration(20)
        .EUt(7)
        .buildAndRegister();

mods.gregtech.chemical_bath.recipeBuilder()
        .fluidInputs(fluid('dye_green') * 18)
        .inputs(item('xnet:netcable'))
        .outputs(item('xnet:netcable', 3).withNbt(["display": ["LocName": "tile.xnet.netcable_green.name"]]))
        .duration(20)
        .EUt(7)
        .buildAndRegister();

mods.gregtech.chemical_bath.recipeBuilder()
        .fluidInputs(fluid('dye_green') * 18)
        .inputs(item('xnet:netcable', 1))
        .outputs(item('xnet:netcable', 3).withNbt(["display": ["LocName": "tile.xnet.netcable_green.name"]]))
        .duration(20)
        .EUt(7)
        .buildAndRegister();