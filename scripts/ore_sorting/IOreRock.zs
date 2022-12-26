#norun
#priority 9
import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.oredict.IOreDictEntry;
import crafttweaker.liquid.ILiquidStack;

import mods.gregtech.recipe.RecipeMap;
import mods.gregtech.recipe.RecipeMaps;
import mods.gregtech.recipe.RecipeBuilder;

zenClass IOreRock{
	val rock as IItemStack;
	val inputFluid as ILiquidStack;
	val outputFluid as ILiquidStack;
	val startingTier as int;
	val oreLists as int[IItemStack][];
	
	zenConstructor(rock as IItemStack, inputFluid as ILiquidStack, outputFluid as ILiquidStack, oreLists as int[IItemStack][], startingTier as int){
		this.rock = rock;
		this.inputFluid = inputFluid;
		this.outputFluid = outputFluid;
		this.oreLists = oreLists;
		this.startingTier = startingTier;
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

	function getStartingTier() as int {
		return startingTier;
	}

	function getOreLists() as int[IItemStack][] {
		return oreLists;
	}
}