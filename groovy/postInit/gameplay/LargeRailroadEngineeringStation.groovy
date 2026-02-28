import globals.Globals
import static gregtech.api.GTValues.*
import cam72cam.immersiverailroading.IRItems
import cam72cam.mod.serialization.TagCompound
import supersymmetry.api.recipes.SuSyRecipeMaps
import trackapi.lib.Gauges

recipemap('assembler').recipeBuilder()					// awful cuz I hate groovy (and fuck you planetme)
            .inputs(item('gregtech:machine', 989))
            .inputs(item('gregtech:meta_item_1', 190) * 2)
            .inputs(item('gregtech:meta_item_2', 3026))
			.inputs(item('gregtech:meta_plate_double', 323) * 2)
			.inputs(item('gregtech:meta_item_1', 160) * 2)
            .outputs(item('gregtech:machine', 18520))
            .duration(200)
            .EUt(VA[EV])
            .buildAndRegister();

Globals.solders.each { key, val ->
 	cam72cam.mod.item.ItemStack is1 = new cam72cam.mod.item.ItemStack(IRItems.ITEM_ROLLING_STOCK, 1);
    ItemRollingStock.Data data = new ItemRollingStock.Data(is1);
    data.def = DefinitionManager.getDefinition("rolling_stock/transporter_erector/soyuz_transporter.json");
    data.gauge = Gauges.STANDARD;
    data.write();

	// https://en.wikipedia.org/wiki/Transporter_erector
	// https://positron96.gitlab.io/projects/soyuz-transporter/
	SuSyRecipeMaps.LARGE_RAILROAD_ENGINEERING_STATION.recipeBuilder()
		.circuitMeta(6)
		.inputs(ore('plateHsla980X') * 64) 
		//.inputs(ore('frameGtHsla980X') * 64) 
		//.inputs(ore('gearSteel') * 8) 
		.inputs(metaitem('minecart_wheels.steel') * 8)
		.inputs(item('susy:metallurgy', 1) * 8) 
		//.inputs(metaitem('fluid.regulator.hv') * 4) 
		//.inputs(metaitem('electric.pump.hv') * 4) 
		//.inputs(metaitem('electric.motor.hv') * 8) 
		.inputs(ore('stickLongSteel') * 64) 
		.inputs(metaitem('sensor.ev') * 4) 
		.inputs(ore('circuitHv') * 8) 
		.inputs(metaitem('battery_buffer.hv.4')) 
		.inputs(ore('cableGtQuadrupleCopper') * 32) 
		.inputs(ore('pipeNormalFluidSteel') * 32)
		.fluidInputs(fluid(key) * (val * 20)) 
		.fluidInputs(fluid('hydraulic_fluid') * 5000)
		.outputs(is1.internal)
		.EUt(VA[LV]) 
		.duration(1)
		.buildAndRegister();
}
