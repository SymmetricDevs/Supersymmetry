def soldering_alloys = [
        liquid('tin') * 144,
        liquid('soldering_alloy') * 72
]

def name_removals = [
"opencomputers:adapter0",
"opencomputers:assembler1",
"opencomputers:cable2",
"opencomputers:capacitor3",
"opencomputers:case14",
"opencomputers:case35",
"opencomputers:case26",
"opencomputers:chameliumblock7",
"opencomputers:charger8",
"opencomputers:disassembler9",
"opencomputers:diskdrive10",
"opencomputers:geolyzer11",
"opencomputers:hologram112",
"opencomputers:hologram213",
"opencomputers:motionsensor15",
"opencomputers:powerconverter16",
"opencomputers:powerdistributor17",
"opencomputers:printer18",
"opencomputers:raid19",
"opencomputers:redstone20",
"opencomputers:relay21",
"opencomputers:screen122",
"opencomputers:screen323",
"opencomputers:screen224",
"opencomputers:rack25",
"opencomputers:waypoint26",
"opencomputers:endstone27",
"opencomputers:netsplitter28",
"opencomputers:transposer29",
"opencomputers:carpetedcapacitor30",
"opencomputers:material31",
"opencomputers:grog32", // please GTFO add this lmao
"opencomputers:material33",
"opencomputers:material34",
"opencomputers:material35",
"opencomputers:material36", //microchips
"opencomputers:material37",
"opencomputers:material38",
"opencomputers:material39", //ALU
"opencomputers:material40",
"opencomputers:material41", //disc platter (might need GT process and glorious igblon chain)
"opencomputers:material42", //interweb !! WARNING !! REDDIT REFERENCE !! ACIDIC !!
"opencomputers:material46", //tablet case 1
"opencomputers:material47", //tablet case 2
"opencomputers:material48", //microcontroller cases
"opencomputers:material49", 
"opencomputers:material50", //drone cases
"opencomputers:material51", 
"opencomputers:material52", //ink cartridges	
"opencomputers:material53", 
"opencomputers:material54", //chamelium
"opencomputers:material55", //diamond chip



]

for (item in name_removals) {
    crafting.remove(item);
}



for (solder in soldering_alloys) {

	mods.gregtech.assembler.recipeBuilder()
			.inputs(ore('oc:cable') * 4)
			.inputs(metaitem('hull.mv'))
			.inputs(ore('circuitMv'))
            .fluidInputs(solder)
            .outputs(item('opencomputers:adapter'))
            .duration(200)
            .EUt(120)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(ore('oc:cable') * 4)
			.inputs(metaitem('hull.mv'))
			.inputs(metaitem('robot.arm.mv'))
			.inputs(metaitem('conveyor.module.mv') * 2)
			.inputs(ore('circuitMv'))
            .fluidInputs(solder)
            .outputs(item('opencomputers:assembler'))
            .duration(200)
            .EUt(120)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(ore('oc:cable') * 4)
			.inputs(metaitem('hull.mv'))
			.inputs(metaitem('screwAluminium') * 4)
			.inputs(metaitem('rotorSteel') * 2)
			.inputs(item('opencomputers:component', 3))
			.inputs(ore('circuitMv'))
            .fluidInputs(solder)
            .outputs(item('opencomputers:case1'))
            .duration(200)
            .EUt(120)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(ore('oc:cable') * 4)
			.inputs(metaitem('hull.hv'))
			.inputs(metaitem('screwStainlessSteel') * 4)
			.inputs(metaitem('rotorStainlessSteel') * 2)
			.inputs(item('opencomputers:component', 4))
			.inputs(ore('circuitHv'))
            .fluidInputs(solder)
            .outputs(item('opencomputers:case2'))
            .duration(200)
            .EUt(120)
            .buildAndRegister();
			
	mods.gregtech.assembler.recipeBuilder()
			.inputs(ore('oc:cable') * 4)
			.inputs(metaitem('hull.ev'))
			.inputs(metaitem('screwTitanium') * 4)
			.inputs(metaitem('rotorTitanium') * 2)
			.inputs(item('opencomputers:component', 5))
			.inputs(ore('circuitEv'))
            .fluidInputs(solder)
            .outputs(item('opencomputers:case3'))
            .duration(200)
            .EUt(120)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(metaitem('hull.mv'))
			.inputs(ore('cableGtSingleCopper') * 4)
            .fluidInputs(solder)
            .outputs(item('opencomputers:charger'))
            .duration(200)
            .EUt(120)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(metaitem('hull.mv'))
			.inputs(ore('circuitMv'))
			.inputs(metaitem('sensor.mv'))
			.inputs(metaitem('emitter.mv'))
			.inputs(ore('lensGlass'))
            .fluidInputs(solder)
            .outputs(item('opencomputers:diskdrive'))
            .duration(200)
            .EUt(120)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(metaitem('hull.hv'))
			.inputs(ore('circuitHv'))
			.inputs(metaitem('sensor.hv') * 2)
			.circuitMeta([1])
            .fluidInputs(solder)
            .outputs(item('opencomputers:geolyzer'))
            .duration(200)
            .EUt(480)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(metaitem('hull.hv'))
			.inputs(ore('circuitHv'))
			.inputs(metaitem('emitter.hv') * 2)
            .fluidInputs(solder)
            .outputs(item('opencomputers:hologram1'))
            .duration(200)
            .EUt(480)
            .buildAndRegister();
			
	mods.gregtech.assembler.recipeBuilder()
			.inputs(metaitem('hull.ev'))
			.inputs(ore('circuitEv'))
			.inputs(metaitem('emitter.ev') * 2)
            .fluidInputs(solder)
            .outputs(item('opencomputers:hologram2'))
            .duration(200)
            .EUt(480)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(metaitem('hull.hv'))
			.inputs(ore('circuitHv'))
			.inputs(metaitem('sensor.hv'))
			.circuitMeta([2])
            .fluidInputs(solder)
            .outputs(item('opencomputers:motionsensor'))
            .duration(200)
            .EUt(480)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(metaitem('hull.mv'))
			.inputs(metaitem('plateIron'))
			.inputs(ore('gtWireSingleCopper') * 2)
			.inputs(ore('cableGtSingleCopper') * 4)
			.inputs(ore('circuitMv'))
            .fluidInputs(solder)
            .outputs(item('opencomputers:powerdistributor'))
            .duration(200)
            .EUt(120)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(metaitem('hull.ev'))
			.inputs(metaitem('drum.stainless_steel'))
			.inputs(metaitem('electric.pump.ev') * 2)
            .fluidInputs(solder)
            .outputs(item('opencomputers:printer'))
            .duration(200)
            .EUt(120)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(metaitem('hull.hv'))
			.inputs(metaitem('plate.random_access_memory'))
			.inputs(metaitem('plate.central_processing_unit'))
			.inputs(item('opencomputers:diskdrive') * 3)
			.inputs(ore('circuitHv'))
            .fluidInputs(solder)
            .outputs(item('opencomputers:raid'))
            .duration(200)
            .EUt(120)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(metaitem('hull.mv'))
			.inputs(item('opencomputers:card', 4))
			.inputs(ore('circuitMv'))
            .fluidInputs(solder)
            .outputs(item('opencomputers:redstone'))
            .duration(200)
            .EUt(120)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(metaitem('hull.mv'))
			.inputs(item('opencomputers:card', 6))
			.inputs(ore('cableGtSingleCopper') * 4)
			.inputs(ore('circuitMv'))			
            .fluidInputs(solder)
            .outputs(item('opencomputers:relay'))
            .duration(200)
            .EUt(120)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(metaitem('hull.mv'))
			.inputs(item('opencomputers:card', 6))
			.inputs(ore('cableGtSingleCopper') * 4)
			.inputs(ore('circuitMv'))
            .fluidInputs(solder)
			.circuitMeta([1])
            .outputs(item('opencomputers:relay'))
            .duration(200)
            .EUt(120)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(metaitem('hull.mv'))
			.inputs(metaitem('monitor_screen'))
            .fluidInputs(solder)
            .outputs(item('opencomputers:screen1'))
            .duration(200)
            .EUt(120)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(metaitem('hull.hv'))
			.inputs(metaitem('monitor_screen') * 2)
            .fluidInputs(solder)
            .outputs(item('opencomputers:screen2'))
            .duration(200)
            .EUt(480)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(metaitem('hull.ev'))
			.inputs(metaitem('monitor_screen') * 4)
            .fluidInputs(solder)
            .outputs(item('opencomputers:screen3'))
            .duration(200)
            .EUt(1920)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(item('opencomputers:relay'))
			.inputs(item('opencomputers:powerdistributor'))
			.inputs(metaitem('hull.mv'))
			.inputs(item('opencomputers:upgrade', 31))
            .fluidInputs(solder)
            .outputs(item('opencomputers:rack'))
            .duration(200)
            .EUt(120)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(metaitem('hull.mv'))
			.inputs(item('opencomputers:card', 6))
			.circuitMeta([2])
            .fluidInputs(solder)
            .outputs(item('opencomputers:waypoint'))
            .duration(200)
            .EUt(120)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(metaitem('hull.mv'))
			.inputs(ore('cableGtSingleCopper') * 2)
			.inputs(ore('circuitLv') * 2)
			.circuitMeta([2])
            .fluidInputs(solder)
            .outputs(item('opencomputers:netsplitter'))
            .duration(200)
            .EUt(120)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(metaitem('hull.mv'))
			.inputs(metaitem('pipeNormalItemPolyvinylChloride') * 2)
			.inputs(metaitem('pipeNormalFluidAluminium') * 2)
			.inputs(ore('circuitLv') * 2)
            .fluidInputs(solder)
            .outputs(item('opencomputers:transposer'))
            .duration(200)
            .EUt(120)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(ore('stickIron'))
			.inputs(metaitem('circuit_board.plastic'))
            .fluidInputs(solder)
            .outputs(item('opencomputers:material', 5))
            .duration(200)
            .EUt(120)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(metaitem('power_unit.mv'))
			.inputs(ore('cableGtSingleCopper') * 4)
			.inputs(ore('screwAluminium') * 2)
			.inputs(ore('plateAluminium') * 4)
			.inputs(item('opencomputers:component', 3))
            .fluidInputs(solder)
			.circuitMeta([1])
            .outputs(item('opencomputers:material', 17))
            .duration(200)
            .EUt(120)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(metaitem('power_unit.hv'))
			.inputs(ore('plateStainlessSteel') * 4)
			.inputs(ore('screwStainlessSteel') * 2)
			.inputs(ore('cableGtSingleGold') * 4)
			.inputs(item('opencomputers:component', 4))
            .fluidInputs(solder)
            .outputs(item('opencomputers:material', 18))
			.circuitMeta([1])
            .duration(200)
            .EUt(480)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(metaitem('power_unit.mv'))
			.inputs(ore('cableGtSingleCopper') * 2)
			.inputs(ore('plateAluminium') * 1)
			.inputs(item('opencomputers:component', 3))
            .fluidInputs(solder)
			.circuitMeta([2])
            .outputs(item('opencomputers:material', 20))
            .duration(200)
            .EUt(120)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(metaitem('power_unit.hv'))
			.inputs(ore('plateStainlessSteel') * 4)
			.inputs(ore('cableGtSingleGold') * 4)
			.inputs(item('opencomputers:component', 4))
            .fluidInputs(solder)
            .outputs(item('opencomputers:material', 21))
			.circuitMeta([2])
            .duration(200)
            .EUt(480)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(metaitem('power_unit.mv'))
			.inputs(ore('cableGtSingleCopper') * 2)
			.inputs(ore('plateAluminium') * 1)
			.inputs(item('opencomputers:material', 20))
			.inputs(item('opencomputers:component', 3))
            .fluidInputs(solder)
			.circuitMeta([2])
            .outputs(item('opencomputers:material', 23))
            .duration(200)
            .EUt(120)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(metaitem('power_unit.hv'))
			.inputs(ore('plateStainlessSteel') * 4)
			.inputs(ore('cableGtSingleGold') * 4)
			.inputs(item('opencomputers:material', 21))
			.inputs(item('opencomputers:component', 4))
            .fluidInputs(solder)
            .outputs(item('opencomputers:material', 24))
			.circuitMeta([2])
            .duration(200)
            .EUt(480)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(ore('platePolyethylene') * 4)
            .fluidInputs(solder)
            .outputs(item('opencomputers:material', 26))
			.circuitMeta([15])
            .duration(200)
            .EUt(120)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(ore('dyeBlack'))
			.inputs(ore('dyeCyan'))
			.inputs(ore('dyeYellow'))
			.inputs(ore('dyeMagenta'))
			.inputs(item('opencomputers:material', 26))
            .outputs(item('opencomputers:material', 27))
            .duration(200)
            .EUt(120)
            .buildAndRegister();


}


