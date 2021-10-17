#priority 9
import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.oredict.IOreDictEntry;
import crafttweaker.liquid.ILiquidStack;

import mods.gregtech.recipe.RecipeMap;
import mods.gregtech.recipe.RecipeMaps;
import mods.gregtech.recipe.RecipeBuilder;
import mods.gtadditions.recipe.Utils;
import mods.gtadditions.recipe.LargeRecipeMap;
import mods.gtadditions.recipe.GARecipeMaps;

zenClass IOreRock{
	val rock as IItemStack;
	val inputFluid as ILiquidStack;
	val outputFluid as ILiquidStack;
	
	zenConstructor(rock as IItemStack, inputFluid as ILiquidStack, outputFluid as ILiquidStack){
		this.rock = rock;
		this.inputFluid = inputFluid;
		this.outputFluid = outputFluid;
	}

	function getFluidIn(amount as int) as ILiquidStack {
		return (this.inputFluid * amount);
	}
	
	function getFluidOut(amount as int) as ILiquidStack {
		return (this.outputFluid * amount);
	}
	
	function getRock(amount as int) as IItemStack {
		return (this.rock * amount);
	}
}