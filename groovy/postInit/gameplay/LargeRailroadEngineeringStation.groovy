import globals.Globals
import static gregtech.api.GTValues.*
import cam72cam.immersiverailroading.IRItems
import cam72cam.mod.serialization.TagCompound
import supersymmetry.api.recipes.SuSyRecipeMaps
import trackapi.lib.Gauges
import static prePostInit.Recipemaps.*

ASSEMBLER.recipeBuilder()
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
	TagCompound tag1 = new TagCompound();

	tag1.setString("defID", "rolling_stock/transporter_erector/soyuz_transporter.json");
	tag1.setFloat("gauge", (float) Gauges.STANDARD);
	
	cam72cam.mod.item.ItemStack is1 = new cam72cam.mod.item.ItemStack(IRItems.ITEM_ROLLING_STOCK, 1);
	is1.setTagCompound(tag1);

	LARGE_RAILROAD_ENGINEERING_STATION.recipeBuilder()
		.circuitMeta(1)
		.inputs(ore('plateHsla980X') * 64) 
		.inputs(ore('frameGtHsla980X') * 64) 
		.inputs(ore('gearSteel') * 8) 
		.inputs(metaitem('minecart_wheels.steel') * 8)
		.inputs(item('susy:metallurgy', 1) * 8) 
		.inputs(metaitem('fluid.regulator.hv') * 4) 
		.inputs(metaitem('electric.pump.hv') * 4) 
		.inputs(metaitem('electric.motor.hv') * 8) 
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
