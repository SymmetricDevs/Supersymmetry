import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.liquid.ILiquidStack;
import crafttweaker.oredict.IOreDictEntry;
import mods.gregtech.recipe.RecipeMap;

recipes.addShaped("rubber_rod_manual", <metaitem:stickRubber>, [
	[<ore:gregFiles>, null, null],
	[null, <ore:ingotRubber>, null],
	[null, null, null]
]);

//Manual chad for early paper
val water_ingredient as IIngredient = <liquid:water> * 1000;
recipes.addShapeless("manual_chad", <metaitem:dustPaper>, [
	<ore:dustWood>, 
	<ore:dustWood>,
	water_ingredient
]);

alloy_smelter.recipeBuilder()
	.inputs(<ore:dustRawRubber> * 6)
	.inputs(<ore:dustSulfur>)
	.outputs(<metaitem:dustRubber>)
	.duration(400)
	.EUt(8)
	.buildAndRegister();
	
ebf.recipeBuilder()
	.inputs(<ore:dustIron>)
	.outputs(<minecraft:iron_ingot>)
	.property("temperature", 1800) //1811K is too high for the base EBF
	.duration(60)
	.EUt(60)
	.buildAndRegister();
	
ebf.recipeBuilder()
	.inputs(<ore:dustNickel>)
	.outputs(<metaitem:ingotNickel>)
	.property("temperature", 1728)
	.duration(60)
	.EUt(60)
	.buildAndRegister();

//TechGuns carbon plate removal
fluid_solidifier.findRecipe(7, [<metaitem:shape.mold.plate>], [<liquid:carbon> * 144]).remove();
