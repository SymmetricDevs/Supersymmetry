import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.liquid.ILiquidStack;
import crafttweaker.oredict.IOreDictEntry;

import mods.gregtech.recipe.RecipeMap;

//Vacuum Ejector Recipes
mixer.recipeBuilder()
	.fluidInputs(<liquid:steam>*100)
	.notConsumable(<contenttweaker:vacuum_ejector>)
	.notConsumable(<engineersdecor:straight_pipe_valve>)
	.fluidOutputs(<liquid:low_vacuum>*100)
	.EUt(8)
	.duration(10)
	.buildAndRegister();
	
mixer.recipeBuilder()
	.fluidInputs([<liquid:steam>*100, <liquid:low_vacuum>*100])
	.notConsumable(<contenttweaker:vacuum_ejector>)
	.fluidOutputs(<liquid:medium_vacuum>*100)
	.EUt(8)
	.duration(10)
	.buildAndRegister();
	
mixer.recipeBuilder()
	.fluidInputs([<liquid:steam>*100, <liquid:medium_vacuum>*100])
	.notConsumable(<contenttweaker:vacuum_ejector>)
	.fluidOutputs(<liquid:high_vacuum>*100)
	.EUt(8)
	.duration(10)
	.buildAndRegister();
	
mixer.recipeBuilder()
	.fluidInputs([<liquid:steam>*100, <liquid:high_vacuum>*100])
	.notConsumable(<contenttweaker:vacuum_ejector>)
	.fluidOutputs(<liquid:ultra_high_vacuum>*100)
	.EUt(8)
	.duration(10)
	.buildAndRegister();
	
mixer.recipeBuilder()
	.fluidInputs([<liquid:steam>*100, <liquid:ultra_high_vacuum>*100])
	.notConsumable(<contenttweaker:vacuum_ejector>)
	.fluidOutputs(<liquid:extremely_high_vacuum>*100)
	.EUt(8)
	.duration(10)
	.buildAndRegister();
	
//Cascade Ejector Recipes

mixer.recipeBuilder()
	.fluidInputs(<liquid:steam>*500)
	.notConsumable(<contenttweaker:vacuum_ejector_cascade>)
	.fluidOutputs(<liquid:extremely_high_vacuum>*100)
	.EUt(8)
	.duration(80)
	.buildAndRegister();