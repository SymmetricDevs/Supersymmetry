#norun
import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.liquid.ILiquidStack;
import crafttweaker.oredict.IOreDictEntry;
import mods.gregtech.recipe.RecipeMaps;

ebf.recipeBuilder()
	.inputs(<contenttweaker:full_engine_block_cast>)
	.outputs([
		<contenttweaker:engine_block>,
		<gregtech:meta_dust:1201>*8
	])
	.property("temperature", 800)
	.duration(500)
	.EUt(100)
	.buildAndRegister();

canner.recipeBuilder()
	.inputs(<contenttweaker:engine_block_cast>)
	.fluidInputs(<liquid:aluminium>*576)
	.outputs(<contenttweaker:full_engine_block_cast>)
	.duration(200)
	.EUt(60)
	.buildAndRegister();
	
forming_press.recipeBuilder()
	.inputs(<gregtech:meta_dust:1200>*8)
	.notConsumable(<ore:plateSteel>)
	.outputs(<contenttweaker:engine_block_cast>)
	.duration(200)
	.EUt(60)
	.buildAndRegister();

mixer.recipeBuilder()
	.inputs(<gregtech:meta_dust:1201>*8)
	.fluidInputs(<liquid:glue>*1)
	.outputs(<gregtech:meta_dust:1200>*8)
	.duration(200)
	.EUt(30)
	.buildAndRegister();

/*

//Blasted Stone Ore Sorting

ore_sorter.recipeBuilder()
	.inputs([
		<ore:anyBlastedStone>*16
	])
	.outputs([
		<contenttweaker:rock_carbon>,
		<contenttweaker:rock_carbonate>,
		<contenttweaker:rock_clay>,
		<contenttweaker:rock_oxide>,
		<contenttweaker:rock_phosphate>,
		<contenttweaker:rock_precious>,
		<contenttweaker:rock_radioactive>,
		<contenttweaker:rock_sedimentary>,
		<contenttweaker:rock_silicate>,
		<contenttweaker:rock_sulfur>
	])
	.duration(20)
	.EUt(60)
	.buildAndRegister();

*/