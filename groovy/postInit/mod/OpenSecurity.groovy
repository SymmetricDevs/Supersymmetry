def solder = fluid('soldering_alloy') * 72

def name_removals = [
"opensecurity:blocks/keypad",
"opensecurity:blocks/entity_detector",
"opensecurity:blocks/rfid_reader",
"opensecurity:blocks/security_terminal",
"opensecurity:blocks/card_writer",
"opensecurity:blocks/alarm",
"opensecurity:blocks/data_block",
"opensecurity:blocks/card_writer",
"opensecurity:blocks/mag_reader",
"opensecurity:blocks/biometric_reader",
"opensecurity:blocks/energy_turret",
"opensecurity:blocks/nanofog_terminal",
"opensecurity:blocks/secure_door",
"opensecurity:blocks/private_secure_door",
"opensecurity:blocks/rolldoor",
"opensecurity:blocks/door_controller",
"opensecurity:items/energy_upgrade",
"opensecurity:items/damage_upgrade",
"opensecurity:items/movement_upgrade",
"opensecurity:items/movement_upgrade",
"opensecurity:items/rfid_card",
"opensecurity:items/mag_card",
"opensecurity:items/rfid_reader_card",
"opensecurity:items/nanodna"
]

for (item in name_removals) {
    crafting.remove(item);
}

mods.gregtech.assembler.recipeBuilder()
		.inputs(metaitem('hull.mv'))
		.inputs(ore('oc:materialNumPad'))
		.inputs(ore('oc:cpu1'))
		.fluidInputs(solder)
		.outputs(item('opensecurity:keypad'))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputs(metaitem('hull.mv'))
		.inputs(ore('oc:cpu1'))
		.inputs(ore('oc:ram1'))
		.inputs(metaitem('emitter.mv'))
		.circuitMeta(3)
		.fluidInputs(solder)
		.outputs(item('opensecurity:rfid_reader'))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputs(metaitem('hull.mv'))
		.inputs(ore('oc:cpu1'))
		.inputs(ore('oc:ram1'))
		.inputs(item('opensecurity:rfid_card'))
		.fluidInputs(solder)
		.outputs(item('opensecurity:card_writer'))
		.duration(400)
		.EUt(120)
		.buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
		.inputs(metaitem('hull.mv'))
		.inputs(ore('oc:cpu1'))
		.inputs(ore('wireFineRedAlloy') * 8)
		.inputs(item('minecraft:noteblock'))
		.fluidInputs(solder)
		.outputs(item('opensecurity:alarm'))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputs(metaitem('hull.mv'))
		.inputs(ore('oc:cpu1'))
		.inputs(ore('oc:ram1'))
		.inputs(ore('oc:dataCard1'))
		.fluidInputs(solder)
		.outputs(item('opensecurity:data_block'))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputs(metaitem('hull.mv'))
		.inputs(ore('oc:cpu1'))
		.inputs(ore('oc:dataCard1'))
		.inputs(metaitem('sensor.lv'))
		.inputs(metaitem('emitter.lv'))
		.fluidInputs(solder)
		.outputs(item('opensecurity:entity_detector'))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputs(metaitem('hull.mv'))
		.inputs(ore('oc:cpu1'))
		.inputs(metaitem('emitter.mv'))
		.circuitMeta(1)
		.fluidInputs(solder)
		.outputs(item('opensecurity:mag_reader'))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputs(metaitem('hull.mv'))
		.inputs(ore('oc:cpu1'))
		.inputs(metaitem('emitter.mv'))
		.inputs(ore('blockConcrete'))
		.circuitMeta(2)
		.fluidInputs(solder)
		.outputs(item('opensecurity:mag_reader_camo'))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputs(metaitem('hull.hv'))
		.inputs(ore('oc:cpu2'))
		.inputs(ore('oc:ram2'))
		.inputs(metaitem('sensor.hv'))
		.fluidInputs(solder)
		.outputs(item('opensecurity:biometric_reader'))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputs(ore('oc:cpu1'))
		.inputs(ore('plateSteel') * 5)
		.inputs(ore('blockConcrete'))
		.fluidInputs(solder)
		.outputs(item('opensecurity:secure_door'))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputs(ore('oc:cpu2'))
		.inputs(ore('oc:ram2'))
		.inputs(ore('plateSteel') * 5)
		.inputs(ore('blockConcrete'))
		.fluidInputs(solder)
		.outputs(item('opensecurity:private_secure_door'))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputs(ore('oc:cpu1'))
		.inputs(ore('plateSteel') * 8)
		.circuitMeta([1])
		.fluidInputs(solder)
		.outputs(item('opensecurity:rolldoor'))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputs(metaitem('hull.mv'))
		.inputs(ore('oc:cpu1'))
		.inputs(ore('oc:ram1'))
		.circuitMeta([10])
		.fluidInputs(solder)
		.outputs(item('opensecurity:door_controller'))
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputs(metaitem('hull.mv'))
		.inputs(ore('oc:cpu1'))
		.inputs(ore('oc:ram1'))
		.circuitMeta([20])
		.fluidInputs(solder)
		.outputs(item('opensecurity:rolldoor_controller')) //same recipe, diff circuit
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputs(ore('platePlastic'))
		.inputs(metaitem('plate.integrated_logic_circuit'))
		.inputs(ore('foilCopper'))
		.circuitMeta(2)
		.outputs(item('opensecurity:rfid_card')) 
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
		.inputs(ore('platePlastic'))
		.inputs(metaitem('plate.integrated_logic_circuit'))
		.inputs(ore('dustIronMagnetic'))
		.circuitMeta(3)
		.outputs(item('opensecurity:mag_card')) 
		.duration(400)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.circuit_assembler.recipeBuilder()
		.inputs(item('opencomputers:component', 6))
		.inputs(item('opencomputers:component'))
		.inputs(ore('wireFineCopper') * 4)
		.inputs(metaitem('plate.integrated_logic_circuit'))
		.inputs(metaitem('circuit_board.good'))
		.fluidInputs(solder)
		.circuitMeta([13])
		.outputs(item('opensecurity:rfid_reader_card'))
		.duration(400)
		.EUt(30)
		.buildAndRegister();