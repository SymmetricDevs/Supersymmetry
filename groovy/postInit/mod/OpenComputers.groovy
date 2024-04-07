import gregtech.api.recipes.ingredients.nbtmatch.*

def solder = fluid('soldering_alloy') * 72

def name_removals = [
"opencomputers:adapter0",
"opencomputers:assembler1",
"opencomputers:cable2",
"opencomputers:capacitor3",
"opencomputers:case14",
"opencomputers:case35",
"opencomputers:case26",
"opencomputers:chameliumblock7",
"opencomputers:material157",
"opencomputers:chameliumblock158",
"opencomputers:charger8",
"opencomputers:disassembler9",
"opencomputers:diskdrive10",
"opencomputers:geolyzer11",
"opencomputers:hologram112",
"opencomputers:hologram213",
"opencomputers:motionsensor15",
"opencomputers:powerconverter16",
"opencomputers:powerdistributor17",
"opencomputers:material41",
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
"opencomputers:material32", // GROG
"opencomputers:material33",
"opencomputers:material34",
"opencomputers:material35",
"opencomputers:material36", //microchips
"opencomputers:material37",
"opencomputers:material38",
"opencomputers:material39", //ALU
"opencomputers:material40",
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
"opencomputers:material132", //diamond chip
"opencomputers:tool55", //analyzer
"opencomputers:tool56", //remote control
"opencomputers:tool57", //texture picker
"opencomputers:tool58", //manual
"opencomputers:tool61", //nanomachines
"opencomputers:wrench59", //scrench
"opencomputers:hoverboots60",
"opencomputers:component62", //CPUs
"opencomputers:component63",
"opencomputers:component64",
"opencomputers:component65", //Component Buses
"opencomputers:component66",
"opencomputers:component67",
"opencomputers:component68", //RAMs
"opencomputers:component69",
"opencomputers:component70",
"opencomputers:component71",
"opencomputers:component72",
"opencomputers:component73",
"opencomputers:component74", //Servers
"opencomputers:component75",
"opencomputers:component76",
"opencomputers:component77", //APUs
"opencomputers:component78",
"opencomputers:component79",
"opencomputers:component80",
"opencomputers:card81", //GPUs
"opencomputers:card82",
"opencomputers:card83",
"opencomputers:card84", //Redstone cards
"opencomputers:card85",
"opencomputers:card86", //Network cards
"opencomputers:card87",
"opencomputers:card88",
"opencomputers:card89", //Linked cards (interdimensional transfer is too OP i guess)
"opencomputers:card90", //Data cards
"opencomputers:card91",
"opencomputers:card92",
"opencomputers:upgrade93", //TODO: Angel ring upgrade(might need flight?)
"opencomputers:upgrade94", //Battery upgrades
"opencomputers:upgrade95",
"opencomputers:upgrade96",
"opencomputers:upgrade97", //TODO: Chunkloader upgrade
"opencomputers:upgrade98", //Card containers
"opencomputers:upgrade99",
"opencomputers:upgrade100",
"opencomputers:upgrade101", //Upgrade containers
"opencomputers:upgrade102",
"opencomputers:upgrade103",
"opencomputers:upgrade104", //Crafting table upgrade
"opencomputers:upgrade105", //Storage upgrades
"opencomputers:upgrade106",
"opencomputers:upgrade107",
"opencomputers:upgrade108", //XP upgrades
"opencomputers:upgrade109", //Generator upgrade (might be unrealistic) TODO
"opencomputers:upgrade110", //Inventory upgrade
"opencomputers:upgrade111", //Inventory control upgrade
"opencomputers:upgrade112", //Navigation upgrade
"opencomputers:upgrade113", //Piston upgrade
"opencomputers:upgrade114", //Sign upgrade
"opencomputers:upgrade115", //Solar generator upgrade (might be unrealistic) TODO
"opencomputers:upgrade116", //Tank upgrade
"opencomputers:upgrade117", //Tank control upgrade
"opencomputers:upgrade118", //Magnet upgrade
"opencomputers:upgrade119", //Lead upgrade
"opencomputers:upgrade120", //Hover upgrade
"opencomputers:upgrade121", //Hover upgrade
"opencomputers:upgrade122", //Trading upgrade
"opencomputers:upgrade123", //MFU
"opencomputers:upgrade124", //Redstone Wireless Card
"opencomputers:upgrade125", //Sticky Piston Upgrade
"opencomputers:storage126", //EEPROM
"opencomputers:storage127", //Floppy
"opencomputers:storage128", //HDDs
"opencomputers:storage129",
"opencomputers:storage130",
"computronics:iron_note_block0",
"computronics:audio_cable1",
"computronics:speaker5",
"computronics:tape_reader7",
"computronics:camera3",
"computronics:chat_box4",
"computronics:cipher8",
"computronics:cipher_advanced10",
"computronics:colorful_lamp2",
"computronics:parts21", //tape track
"computronics:tape12", //tapes
"computronics:tape13",
"computronics:tape14",
"computronics:tape15",
"computronics:tape16",
"computronics:tape17",
"computronics:tape18",
"computronics:tape19",
"computronics:tape20",
"computronics:portable_tape_drive11",
"computronics:oc_parts22",
"computronics:oc_parts23",
"computronics:oc_parts24",
"computronics:oc_parts25",
"computronics:oc_parts26",
"computronics:oc_parts27",
"computronics:oc_parts28",
"computronics:oc_parts29",
"computronics:oc_parts30",
"computronics:oc_parts31",
"computronics:oc_parts32",
"computronics:oc_parts33",
"computronics:oc_parts34",
"computronics:oc_parts35",
"computronics:speech_box6"

]

for (item in name_removals) {
    crafting.remove(item);
}

mods.gregtech.assembler.recipeBuilder()
		.inputs(ore('plateRubber'))
		.inputs(ore('wireGtSingleCopper'))
		.circuitMeta(2)
		.outputs(item('opencomputers:cable'))
		.duration(100)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.circuitMeta(2)
		.inputs(ore('cableGtSingleCopper') * 4)
		.inputs(metaitem('hull.mv'))
		.inputs(ore('circuitMv'))
		.fluidInputs(solder)
		.outputs(item('opencomputers:adapter'))
		.duration(200)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputs(ore('cableGtSingleCopper') * 4)
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
		.circuitMeta(1)
		.inputs(ore('cableGtSingleCopper') * 4)
		.inputs(metaitem('hull.mv'))
		.inputs(ore('screwAluminium') * 4)
		.inputs(ore('rotorSteel') * 2)
		.inputs(item('opencomputers:component', 3))
		.inputs(ore('circuitMv'))
		.fluidInputs(solder)
		.outputs(item('opencomputers:case1'))
		.duration(200)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputs(ore('cableGtSingleGold') * 4)
		.inputs(metaitem('hull.hv'))
		.inputs(ore('screwStainlessSteel') * 4)
		.inputs(ore('rotorStainlessSteel') * 2)
		.inputs(item('opencomputers:component', 4))
		.inputs(ore('circuitHv'))
		.fluidInputs(solder)
		.outputs(item('opencomputers:case2'))
		.duration(200)
		.EUt(120)
		.buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
		.inputs(ore('cableGtSingleAluminium') * 4)
		.inputs(metaitem('hull.ev'))
		.inputs(ore('screwTitanium') * 4)
		.inputs(ore('rotorTitanium') * 2)
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
		.circuitMeta([4])
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
		.inputs(ore('plateIron'))
		.inputs(ore('wireGtSingleCopper') * 2)
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
		.circuitMeta(1)
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
		.inputs(ore('pipeNormalItemPolyvinylChloride') * 2)
		.inputs(ore('pipeNormalFluidAluminium') * 2)
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
		.inputNBT(metaitem('power_unit.mv').item, 1, metaitem('power_unit.mv').metadata, NBTMatcher.ANY, NBTCondition.ANY)
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
		.inputNBT(metaitem('power_unit.hv').item, 1, metaitem('power_unit.hv').metadata, NBTMatcher.ANY, NBTCondition.ANY)
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
		.inputNBT(metaitem('power_unit.mv').item, 1, metaitem('power_unit.mv').metadata, NBTMatcher.ANY, NBTCondition.ANY)
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
		.inputNBT(metaitem('power_unit.hv').item, 1, metaitem('power_unit.hv').metadata, NBTMatcher.ANY, NBTCondition.ANY)
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
		.inputNBT(metaitem('power_unit.mv').item, 1, metaitem('power_unit.mv').metadata, NBTMatcher.ANY, NBTCondition.ANY)
		.inputs(ore('cableGtSingleCopper') * 2)
		.inputs(ore('plateAluminium') * 1)
		.inputs(item('opencomputers:material', 20))
		.inputs(item('opencomputers:component', 3))
		.fluidInputs(solder)
		.circuitMeta([4])
		.outputs(item('opencomputers:material', 23))
		.duration(200)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputNBT(metaitem('power_unit.hv').item, 1, metaitem('power_unit.hv').metadata, NBTMatcher.ANY, NBTCondition.ANY)
		.inputs(ore('plateStainlessSteel') * 4)
		.inputs(ore('cableGtSingleGold') * 4)
		.inputs(item('opencomputers:material', 21))
		.inputs(item('opencomputers:component', 4))
		.fluidInputs(solder)
		.outputs(item('opencomputers:material', 24))
		.circuitMeta([4])
		.duration(200)
		.EUt(480)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputs(ore('platePlastic') * 4)
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

mods.gregtech.assembler.recipeBuilder()
		.inputNBT(metaitem('power_unit.mv').item, 1, metaitem('power_unit.mv').metadata, NBTMatcher.ANY, NBTCondition.ANY)
		.inputs(ore('cableGtSingleCopper') * 1)
		.inputs(ore('plateAluminium') * 2)
		.inputs(metaitem('sensor.mv'))
		.inputs(ore('circuitMv'))
		.fluidInputs(solder)
		.circuitMeta([3])
		.outputs(item('opencomputers:tool'))
		.duration(200)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputNBT(metaitem('power_unit.mv').item, 1, metaitem('power_unit.mv').metadata, NBTMatcher.ANY, NBTCondition.ANY)
		.inputs(item('opencomputers:card', 7))
		.inputs(ore('plateAluminium') * 2)
		.inputs(metaitem('monitor_screen'))
		.inputs(ore('circuitMv'))
		.fluidInputs(solder)
		.circuitMeta([3])
		.outputs(item('opencomputers:tool', 2))
		.duration(200)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputs(ore('plateAluminium') * 2)
		.inputs(metaitem('sensor.lv'))
		.inputs(ore('circuitMv'))
		.fluidInputs(solder)
		.circuitMeta([4])
		.outputs(item('opencomputers:tool', 3))
		.duration(200)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.circuit_assembler.recipeBuilder()
		.inputs(metaitem('plate.central_processing_unit'))
		.inputs(metaitem('circuit_board.good'))
		.fluidInputs(solder)
		.circuitMeta([1])
		.outputs(item('opencomputers:component'))
		.duration(200)
		.EUt(30)
		.buildAndRegister();

mods.gregtech.circuit_assembler.recipeBuilder()
		.inputs(metaitem('plate.central_processing_unit') * 2)
		.inputs(metaitem('circuit_board.plastic'))
		.fluidInputs(solder)
		.circuitMeta([2])
		.outputs(item('opencomputers:component', 1))
		.duration(200)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.circuit_assembler.recipeBuilder()
		.inputs(metaitem('plate.central_processing_unit') * 4)
		.inputs(metaitem('circuit_board.advanced'))
		.fluidInputs(solder)
		.circuitMeta([3])
		.outputs(item('opencomputers:component', 2))
		.duration(200)
		.EUt(480)
		.buildAndRegister();

mods.gregtech.circuit_assembler.recipeBuilder()
		.inputs(metaitem('plate.integrated_logic_circuit'))
		.inputs(metaitem('circuit_board.good'))
		.fluidInputs(solder)
		.circuitMeta([1])
		.outputs(item('opencomputers:component', 3))
		.duration(200)
		.EUt(30)
		.buildAndRegister();

mods.gregtech.circuit_assembler.recipeBuilder()
		.inputs(metaitem('plate.integrated_logic_circuit') * 2)
		.inputs(metaitem('circuit_board.plastic'))
		.fluidInputs(solder)
		.circuitMeta([2])
		.outputs(item('opencomputers:component', 4))
		.duration(200)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.circuit_assembler.recipeBuilder()
		.inputs(metaitem('plate.integrated_logic_circuit') * 4)
		.inputs(metaitem('circuit_board.advanced'))
		.fluidInputs(solder)
		.circuitMeta([3])
		.outputs(item('opencomputers:component', 5))
		.duration(200)
		.EUt(480)
		.buildAndRegister();

mods.gregtech.circuit_assembler.recipeBuilder()
		.inputs(metaitem('plate.random_access_memory'))
		.inputs(metaitem('circuit_board.good'))
		.fluidInputs(solder)
		.circuitMeta([1])
		.outputs(item('opencomputers:component', 6))
		.duration(200)
		.EUt(30)
		.buildAndRegister();

mods.gregtech.circuit_assembler.recipeBuilder()
		.inputs(metaitem('plate.random_access_memory') * 2)
		.inputs(metaitem('circuit_board.good'))
		.fluidInputs(solder)
		.circuitMeta([2])
		.outputs(item('opencomputers:component', 7))
		.duration(400)
		.EUt(30)
		.buildAndRegister();

mods.gregtech.circuit_assembler.recipeBuilder()
		.inputs(metaitem('plate.random_access_memory') * 4)
		.inputs(metaitem('circuit_board.plastic'))
		.fluidInputs(solder)
		.circuitMeta([3])
		.outputs(item('opencomputers:component', 8))
		.duration(200)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.circuit_assembler.recipeBuilder()
		.inputs(metaitem('plate.random_access_memory') * 6)
		.inputs(metaitem('circuit_board.plastic'))
		.fluidInputs(solder)
		.circuitMeta([4])
		.outputs(item('opencomputers:component', 9))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.circuit_assembler.recipeBuilder()
		.inputs(metaitem('plate.random_access_memory') * 8)
		.inputs(metaitem('circuit_board.advanced'))
		.fluidInputs(solder)
		.circuitMeta([5])
		.outputs(item('opencomputers:component', 10))
		.duration(200)
		.EUt(480)
		.buildAndRegister();

mods.gregtech.circuit_assembler.recipeBuilder()
		.inputs(metaitem('plate.random_access_memory') * 12)
		.inputs(metaitem('circuit_board.advanced'))
		.fluidInputs(solder)
		.circuitMeta([6])
		.outputs(item('opencomputers:component', 11))
		.duration(400)
		.EUt(480)
		.buildAndRegister();

mods.gregtech.circuit_assembler.recipeBuilder()
		.inputs(item('opencomputers:component', 7))
		.inputs(item('opencomputers:component'))
		.inputs(ore('wireFineCopper') * 4)
		.inputs(metaitem('circuit_board.good'))
		.fluidInputs(solder)
		.circuitMeta([15])
		.outputs(item('opencomputers:component', 13))
		.duration(400)
		.EUt(30)
		.buildAndRegister();

mods.gregtech.circuit_assembler.recipeBuilder()
		.inputs(item('opencomputers:component', 9))
		.inputs(item('opencomputers:component', 1))
		.inputs(ore('wireFineGold') * 8)
		.inputs(metaitem('circuit_board.plastic'))
		.fluidInputs(solder)
		.circuitMeta([15])
		.outputs(item('opencomputers:component', 14))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.circuit_assembler.recipeBuilder()
		.inputs(item('opencomputers:component', 11))
		.inputs(item('opencomputers:component', 2))
		.inputs(ore('wireFineAluminium') * 16)
		.inputs(metaitem('circuit_board.advanced'))
		.fluidInputs(solder)
		.circuitMeta([15])
		.outputs(item('opencomputers:component', 15))
		.duration(400)
		.EUt(480)
		.buildAndRegister();

mods.gregtech.circuit_assembler.recipeBuilder()
		.inputs(item('opencomputers:card', 2))
		.inputs(item('opencomputers:component', 4))
		.inputs(item('opencomputers:component', 1))
		.inputs(ore('wireFineCopper') * 16)
		.inputs(metaitem('circuit_board.good'))
		.fluidInputs(solder)
		.circuitMeta([1])
		.outputs(item('opencomputers:component', 16))
		.duration(400)
		.EUt(30)
		.buildAndRegister();

mods.gregtech.circuit_assembler.recipeBuilder()
		.inputs(item('opencomputers:card', 3))
		.inputs(item('opencomputers:component', 5))
		.inputs(item('opencomputers:component', 2))
		.inputs(ore('wireFineGold') * 4)
		.inputs(metaitem('circuit_board.advanced'))
		.fluidInputs(solder)
		.circuitMeta([2])
		.outputs(item('opencomputers:component', 17))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputs(metaitem('circuit_board.plastic'))
		.inputs(ore('circuitMv'))
		.inputs(metaitem('sensor.mv'))
		.inputs(metaitem('emitter.mv'))
		.inputs(ore('lensGlass'))
		.fluidInputs(solder)
		.outputs(item('opencomputers:diskdrive'))
		.duration(200)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.circuit_assembler.recipeBuilder()
		.inputs(item('opencomputers:component', 6))
		.inputs(item('opencomputers:component'))
		.inputs(ore('wireFineCopper') * 4)
		.inputs(metaitem('circuit_board.good'))
		.fluidInputs(solder)
		.circuitMeta([1])
		.outputs(item('opencomputers:card', 1))
		.duration(400)
		.EUt(30)
		.buildAndRegister();

mods.gregtech.circuit_assembler.recipeBuilder()
		.inputs(item('opencomputers:component', 8))
		.inputs(item('opencomputers:component', 1))
		.inputs(ore('wireFineGold') * 4)
		.inputs(metaitem('circuit_board.plastic'))
		.fluidInputs(solder)
		.circuitMeta([2])
		.outputs(item('opencomputers:card', 2))
		.duration(400)
		.EUt(120)
		.buildAndRegister();
		
mods.gregtech.circuit_assembler.recipeBuilder()
		.inputs(item('opencomputers:component', 9))
		.inputs(item('opencomputers:component', 2))
		.inputs(ore('wireFineAluminium') * 4)
		.inputs(metaitem('circuit_board.advanced'))
		.fluidInputs(solder)
		.circuitMeta([2])
		.outputs(item('opencomputers:card', 3))
		.duration(400)
		.EUt(480)
		.buildAndRegister();
	
mods.gregtech.circuit_assembler.recipeBuilder()
		.inputs(item('opencomputers:component'))
		.inputs(ore('wireFineRedAlloy') * 4)
		.inputs(metaitem('circuit_board.good'))
		.fluidInputs(solder)
		.circuitMeta([1])
		.outputs(item('opencomputers:card', 4))
		.duration(400)
		.EUt(30)
		.buildAndRegister();

mods.gregtech.circuit_assembler.recipeBuilder()
		.inputs(item('opencomputers:component', 1))
		.inputs(ore('wireFineRedAlloy') * 16)
		.inputs(metaitem('circuit_board.plastic'))
		.fluidInputs(solder)
		.circuitMeta([2])
		.outputs(item('opencomputers:card', 5))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.circuit_assembler.recipeBuilder()
		.inputs(ore('wireGtSingleCopper'))
		.inputs(ore('wireFineCopper') * 4)
		.inputs(metaitem('sensor.mv'))
		.inputs(metaitem('emitter.mv'))
		.inputs(metaitem('circuit_board.good'))
		.fluidInputs(solder)
		.circuitMeta([1])
		.outputs(item('opencomputers:card', 6))
		.duration(400)
		.EUt(30)
		.buildAndRegister();

mods.gregtech.circuit_assembler.recipeBuilder()
		.inputs(ore('wireFineGold') * 8)
		.inputs(metaitem('sensor.hv'))
		.inputs(metaitem('emitter.hv'))
		.inputs(metaitem('circuit_board.plastic'))
		.fluidInputs(solder)
		.circuitMeta([2])
		.outputs(item('opencomputers:card', 7))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.circuit_assembler.recipeBuilder()
		.inputs(ore('wireFineAluminium') * 8)
		.inputs(metaitem('sensor.ev'))
		.inputs(metaitem('emitter.ev'))
		.inputs(metaitem('circuit_board.advanced'))
		.fluidInputs(solder)
		.circuitMeta([3])
		.outputs(item('opencomputers:card', 8))
		.duration(400)
		.EUt(480)
		.buildAndRegister();

mods.gregtech.circuit_assembler.recipeBuilder()
		.inputs(item('opencomputers:component'))
		.inputs(ore('wireFineCopper') * 4)
		.inputs(metaitem('circuit_board.good'))
		.fluidInputs(solder)
		.circuitMeta([10])
		.outputs(item('opencomputers:card', 10))
		.duration(400)
		.EUt(30)
		.buildAndRegister();

mods.gregtech.circuit_assembler.recipeBuilder()
		.inputs(item('opencomputers:component', 1))
		.inputs(ore('wireFineGold') * 4)
		.inputs(metaitem('circuit_board.plastic'))
		.fluidInputs(solder)
		.circuitMeta([11])
		.outputs(item('opencomputers:card', 11))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.circuit_assembler.recipeBuilder()
		.inputs(item('opencomputers:component', 2))
		.inputs(ore('wireFineAluminium') * 4)
		.inputs(metaitem('circuit_board.advanced'))
		.fluidInputs(solder)
		.circuitMeta([12])
		.outputs(item('opencomputers:card', 12))
		.duration(400)
		.EUt(480)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputNBT(metaitem('power_unit.mv').item, 1, metaitem('power_unit.mv').metadata, NBTMatcher.ANY, NBTCondition.ANY)
		.inputs(metaitem('circuit_board.good'))
		.fluidInputs(solder)
		.circuitMeta([1])
		.outputs(item('opencomputers:upgrade', 1))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputNBT(metaitem('power_unit.hv').item, 1, metaitem('power_unit.hv').metadata, NBTMatcher.ANY, NBTCondition.ANY)
		.inputs(metaitem('circuit_board.plastic'))
		.fluidInputs(solder)
		.circuitMeta([2])
		.outputs(item('opencomputers:upgrade', 2))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputs(metaitem('power_unit.ev'))
		.inputs(metaitem('circuit_board.advanced'))
		.fluidInputs(solder)
		.circuitMeta([3])
		.outputs(item('opencomputers:upgrade', 3))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputs(ore('plateAluminium') * 4)
		.inputs(item('opencomputers:material', 5))
		.fluidInputs(solder)
		.circuitMeta([1])
		.outputs(item('opencomputers:upgrade', 5))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputs(ore('plateStainlessSteel') * 4)
		.inputs(item('opencomputers:material', 5))
		.fluidInputs(solder)
		.circuitMeta([2])
		.outputs(item('opencomputers:upgrade', 6))
		.duration(400)
		.EUt(120)
		.buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
		.inputs(ore('plateTitanium') * 4)
		.inputs(item('opencomputers:material', 5))
		.fluidInputs(solder)
		.circuitMeta([3])
		.outputs(item('opencomputers:upgrade', 7))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputs(ore('plateAluminium') * 4)
		.inputs(ore('screwAluminium') * 4)
		.fluidInputs(solder)
		.circuitMeta([11])
		.outputs(item('opencomputers:upgrade', 8))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputs(ore('plateStainlessSteel') * 4)
		.inputs(ore('screwStainlessSteel') * 4)
		.fluidInputs(solder)
		.circuitMeta([12])
		.outputs(item('opencomputers:upgrade', 9))
		.duration(400)
		.EUt(120)
		.buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
		.inputs(ore('plateTitanium') * 4)
		.inputs(ore('screwTitanium') * 4)
		.fluidInputs(solder)
		.circuitMeta([13])
		.outputs(item('opencomputers:upgrade', 10))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputs(ore('plateAluminium') * 4)
		.inputs(item('minecraft:crafting_table'))
		.fluidInputs(solder)
		.circuitMeta([1])
		.outputs(item('opencomputers:upgrade', 11))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputs(ore('plateAluminium') * 4)
		.inputs(ore('oc:hdd1'))
		.fluidInputs(solder)
		.circuitMeta([1])
		.outputs(item('opencomputers:upgrade', 12))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputs(ore('plateStainlessSteel') * 4)
		.inputs(ore('oc:hdd2'))
		.fluidInputs(solder)
		.circuitMeta([2])
		.outputs(item('opencomputers:upgrade', 13))
		.duration(400)
		.EUt(120)
		.buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
		.inputs(ore('plateTitanium') * 4)
		.inputs(ore('oc:hdd3'))
		.fluidInputs(solder)
		.circuitMeta([3])
		.outputs(item('opencomputers:upgrade', 14))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputs(ore('plateAluminium') * 4)
		.inputs(metaitem('crate.steel'))
		.fluidInputs(solder)
		.circuitMeta([1])
		.outputs(item('opencomputers:upgrade', 17))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputs(ore('plateStainlessSteel') * 4)
		.inputs(metaitem('robot.arm.hv'))
		.fluidInputs(solder)
		.circuitMeta([1])
		.outputs(item('opencomputers:upgrade', 18))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputs(ore('plateStainlessSteel') * 4)
		.inputs(item('minecraft:compass'))
		.fluidInputs(solder)
		.circuitMeta([1])
		.outputs(item('opencomputers:upgrade', 19))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputs(ore('plateAluminium') * 4)
		.inputs(metaitem('electric.piston.mv'))
		.fluidInputs(solder)
		.circuitMeta([1])
		.outputs(item('opencomputers:upgrade', 20))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputs(ore('plateAluminium') * 4)
		.inputs(ore('dyeBlack') * 2)
		.fluidInputs(solder)
		.circuitMeta([1])
		.outputs(item('opencomputers:upgrade', 21))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputs(ore('plateAluminium') * 4)
		.inputs(metaitem('drum.aluminium'))
		.fluidInputs(solder)
		.circuitMeta([1])
		.outputs(item('opencomputers:upgrade', 23))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputs(ore('plateStainlessSteel') * 4)
		.inputs(metaitem('electric.pump.hv'))
		.fluidInputs(solder)
		.circuitMeta([1])
		.outputs(item('opencomputers:upgrade', 24))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputs(ore('plateTitanium') * 4)
		.inputs(ore('stickNeodymiumAlloyMagnetic'))
		.fluidInputs(solder)
		.circuitMeta([1])
		.outputs(item('opencomputers:upgrade', 25))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputs(ore('plateAluminium') * 4)
		.inputs(item('minecraft:lead'))
		.fluidInputs(solder)
		.circuitMeta([1])
		.outputs(item('opencomputers:upgrade', 26))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputs(ore('plateTitanium') * 4)
		.inputs(metaitem('sensor.ev'))
		.inputs(metaitem('emitter.ev'))
		.fluidInputs(solder)
		.circuitMeta([10])
		.outputs(item('opencomputers:upgrade', 30))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputs(ore('plateSteel') * 4)
		.inputs(ore('wireFineRedAlloy') * 4)
		.inputs(metaitem('sensor.lv'))
		.inputs(metaitem('emitter.lv'))
		.fluidInputs(solder)
		.circuitMeta([10])
		.outputs(item('opencomputers:card', 6))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputs(ore('plateAluminium') * 4)
		.inputs(ore('wireFineRedAlloy') * 4)
		.inputs(metaitem('sensor.mv'))
		.inputs(metaitem('emitter.mv'))
		.fluidInputs(solder)
		.circuitMeta([10])
		.outputs(item('opencomputers:upgrade', 31))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputs(ore('plateAluminium') * 4)
		.inputs(metaitem('electric.piston.lv'))
		.fluidInputs(fluid('glue') * 36)
		.circuitMeta([10])
		.outputs(item('opencomputers:upgrade', 33))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.circuit_assembler.recipeBuilder()
		.inputs(metaitem('component.transistor') * 16)
		.inputs(metaitem('circuit_board.good'))
		.fluidInputs(solder)
		.circuitMeta([1])
		.outputs(item('opencomputers:storage'))
		.duration(400)
		.EUt(30)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputs(item('opencomputers:material', 12))
		.inputs(ore('platePlastic') * 1)
		.inputs(ore('dyeBlack'))
		.fluidInputs(solder)
		.circuitMeta([1])
		.outputs(item('opencomputers:storage', 1))
		.duration(400)
		.EUt(120)
		.buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
		.inputs(item('opencomputers:material', 12))
		.inputs(ore('plateAluminium') * 4)
		.fluidInputs(solder)
		.circuitMeta([1])
		.outputs(item('opencomputers:storage', 2))
		.duration(400)
		.EUt(120)
		.buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
		.inputs(item('opencomputers:material', 12) * 2)
		.inputs(ore('plateStainlessSteel') * 4)
		.fluidInputs(solder)
		.circuitMeta([1])
		.outputs(item('opencomputers:storage', 3))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputs(item('opencomputers:material', 12) * 4)
		.inputs(ore('plateTitanium') * 4)
		.fluidInputs(solder)
		.circuitMeta([1])
		.outputs(item('opencomputers:storage', 4))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.circuit_assembler.recipeBuilder()
		.inputs(ore('circuitHv'))
		.inputs(ore('oc:wlanCard2'))
		.inputs(metaitem('circuit_board.plastic'))
		.fluidInputs(solder)
		.circuitMeta([1])
		.outputs(item('opencomputers:component', 19))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.forming_press.recipeBuilder()
		.inputs(ore('foilPolycaprolactam') * 4)
		.outputs(item('opencomputers:material', 28))
		.duration(160)
		.EUt(120)
		.buildAndRegister();

crafting.addShaped('opencomputers:scrench', item('opencomputers:wrench'), [
    [ore('ingotAluminium'), ore('craftingToolHardHammer'), ore('ingotAluminium')],
    [ore('ingotSteel'), ore('ingotSteel'), ore('ingotSteel')],
    [null, ore('ingotSteel'), null]
])

//disk platter
	mods.gregtech.assembler.recipeBuilder()
			.inputs(ore('lensGlass') * 4)
			.inputs(ore('dustSmallCobalt'))
            .outputs(item('opencomputers:material', 12))
            .duration(400)
            .EUt(120)
            .buildAndRegister();
