#priority 500

import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.oredict.IOreDictEntry;
import crafttweaker.liquid.ILiquidStack;

zenClass IQuenchingFluid{
	
	val ColdFluid as ILiquidStack;
	val HotFluid as ILiquidStack;
	
	var amount as int;
	var time as float;
	var inert as bool;
	var has_recipe as bool;
	
	zenConstructor(ColdFluid as ILiquidStack, HotFluid as ILiquidStack, amount as int, time as float, inert as bool, alreadyHasRecipe as bool){
		this.ColdFluid = ColdFluid;
		this.HotFluid = HotFluid;
		this.amount = amount;
		this.time = time;
		this.inert = inert;
		this.has_recipe = alreadyHasRecipe;
	}
	
	function getColdFluid() as ILiquidStack{
		return (this.ColdFluid*amount);
	}
	
	function getHotFluid() as ILiquidStack{
		return (this.HotFluid*amount);
	}
	
	function getDuration() as float{
		return this.time;
	}
	
	function isInert() as bool{
		return this.inert;
	}

	function hasRecipe() as bool{
		return this.has_recipe;
	}

	function GenerateRadiatorRecipe() as void {
	    radiator.recipeBuilder()
            .fluidInputs([this.getHotFluid()*amount])
            .fluidOutputs([this.getColdFluid()*amount])
            .duration(400)
            .EUt(8)
            .buildAndRegister();
	}

	function GenerateRecipes() as void {
		this.GenerateRadiatorRecipe();
	}
}