def soldering_alloys = [
        liquid('tin') * 144,
        liquid('soldering_alloy') * 72
]

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



for (solder in soldering_alloys) {

	mods.gregtech.assembler.recipeBuilder()
			.inputs(metaitem('hull.mv'))
			.inputs(ore('oc:materialNumPad'))
			.inputs(ore('circuitMv'))
            .fluidInputs(solder)
            .outputs(item('opensecurity:keypad'))
            .duration(400)
            .EUt(120)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(metaitem('hull.mv'))
			.inputs(item('opensecurity:rfid_reader_card'))
            .fluidInputs(solder)
            .outputs(item('opensecurity:rfid_reader'))
            .duration(400)
            .EUt(120)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(metaitem('hull.mv'))
			.inputs(ore('circuitMv'))
			.inputs(item('opensecurity:rfid_card'))
            .fluidInputs(solder)
            .outputs(item('opensecurity:card_writer'))
            .duration(400)
            .EUt(120)
            .buildAndRegister();
			
	mods.gregtech.assembler.recipeBuilder()
			.inputs(metaitem('hull.mv'))
			.inputs(item('minecraft:noteblock'))
            .fluidInputs(solder)
            .outputs(item('opensecurity:alarm'))
            .duration(400)
            .EUt(120)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(metaitem('hull.mv'))
			.inputs(ore('oc:dataCard1'))
            .fluidInputs(solder)
            .outputs(item('opensecurity:data_block'))
            .duration(400)
            .EUt(120)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(metaitem('hull.mv'))
			.inputs(ore('circuitMv'))
			.inputs(metaitem('sensor.lv'))
			.fluidInputs(solder)
			.outputs(item('opensecurity:entity_detector'))
			.duration(400)
			.EUt(120)
			.buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(metaitem('hull.mv'))
			.inputs(ore('circuitMv'))
			.inputs(item('opensecurity:mag_card'))
            .fluidInputs(solder)
            .outputs(item('opensecurity:mag_reader'))
            .duration(400)
            .EUt(120)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(metaitem('hull.mv'))
			.inputs(item('opensecurity:mag_card'))
			.inputs(ore('blockConcrete'))
			.circuitMeta([2])
            .fluidInputs(solder)
            .outputs(item('opensecurity:mag_reader_camo'))
            .duration(400)
            .EUt(120)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(metaitem('hull.hv'))
			.inputs(ore('circuitHv'))
			.inputs(metaitem('sensor.hv'))
            .fluidInputs(solder)
            .outputs(item('opensecurity:biometric_reader'))
            .duration(400)
            .EUt(120)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(ore('plateSteel') * 5)
			.inputs(ore('blockConcrete'))
            .outputs(item('opensecurity:secure_door'))
            .duration(400)
            .EUt(120)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(ore('plateSteel') * 5)
			.inputs(ore('blockConcrete'))
			.circuitMeta([1])
            .outputs(item('opensecurity:private_secure_door'))
            .duration(400)
            .EUt(120)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(ore('plateSteel') * 8)
			.circuitMeta([1])
            .fluidInputs(solder)
            .outputs(item('opensecurity:rolldoor'))
            .duration(400)
            .EUt(120)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(metaitem('hull.mv'))
			.inputs(ore('circuitMv'))
			.circuitMeta([10])
            .fluidInputs(solder)
            .outputs(item('opensecurity:door_controller'))
            .duration(400)
            .EUt(120)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(metaitem('hull.mv'))
			.inputs(ore('circuitMv'))
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
			.inputs(ore('circuitMv'))
            .outputs(item('opensecurity:rfid_card')) 
            .duration(400)
            .EUt(120)
            .buildAndRegister();

	mods.gregtech.assembler.recipeBuilder()
			.inputs(ore('platePlastic'))
			.inputs(metaitem('plate.integrated_logic_circuit'))
			.inputs(ore('dustMagneticIron'))
            .outputs(item('opensecurity:mag_card')) 
            .duration(400)
            .EUt(120)
            .buildAndRegister();

	mods.gregtech.circuit_assembler.recipeBuilder()
			.inputs(ore('wireFineCopper') * 4)
			.inputs(metaitem('plate.integrated_logic_circuit'))
			.inputs(metaitem('circuit_board.good'))
            .fluidInputs(solder)
			.circuitMeta([1])
            .outputs(item('opensecurity:rfid_reader_card'))
            .duration(400)
            .EUt(30)
            .buildAndRegister();

}

