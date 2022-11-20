#priority 500

import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.oredict.IOreDictEntry;
import crafttweaker.liquid.ILiquidStack;

import mods.gregtech.recipe.RecipeMap;
import mods.gregtech.recipe.RecipeMaps;

zenClass IWorkingFluid {
	val fluid_normal as ILiquidStack;
	val fluid_heated as ILiquidStack;
	val leftover as ILiquidStack;
	
	var duration as int;
	var amount_to_use as int;
	
	var conversion_factor as int = 160;
	
	var efficiency as int = 1;
	
	var temp as int;
	
	zenConstructor(fluid_normal as ILiquidStack, fluid_heated as ILiquidStack, leftover as ILiquidStack) {
		this.fluid_normal = fluid_normal;
		this.fluid_heated = fluid_heated;
		this.leftover = leftover;
	}
	
	function setDuration(duration as int) as void {
		this.duration = duration;
	}
	
	function setAmountToUse(amount_to_use as int) as void {
		this.amount_to_use = amount_to_use;
	}
	
	function setEfficiency(efficiency as int) as void {
		this.efficiency = efficiency;
	}
	
	function setConversionFactor(conversion_factor as int) as void {
		this.conversion_factor = conversion_factor;
	}
	
	function getHeatedFluid(n as int) as ILiquidStack{
		return this.fluid_heated * n;
	}
	
	function getNormalFluid(n as int) as ILiquidStack {
		return this.fluid_normal * n;
	}
	
	function getLeftOver() as ILiquidStack {
		return this.leftover;
	}
	
	function GenerateHXRecipe() as void {
	    heat_exchanger_recipes.recipeBuilder()
        .fluidInputs([this.getNormalFluid(this.amount_to_use), <liquid:flue_gas>*1000])
        .fluidOutputs([this.getHeatedFluid(this.amount_to_use*this.conversion_factor)])
        .duration(this.duration)
        .EUt(8)
        .buildAndRegister();
	}
	
	function GenerateTurbineRecipe() as void {
	    steam_turbine.recipeBuilder()
        .fluidInputs([this.fluid_heated*(this.amount_to_use*this.conversion_factor)])
        .fluidOutputs([this.leftover*(this.amount_to_use*this.conversion_factor)])
        .duration(this.duration*this.efficiency)
        .EUt(32)
        .buildAndRegister();
	}
	
	function GenerateCoolingTowerRecipe() as void {
	    cooling_tower.recipeBuilder()
        .fluidInputs([this.leftover*(this.amount_to_use*this.conversion_factor), <liquid:water>*1000])
        .fluidOutputs([this.fluid_normal*this.amount_to_use, <liquid:water>*750])
        .duration(this.duration)
        .EUt(8)
        .buildAndRegister();
	}
	
	function GenerateRadiatorRecipe() as void {
	    radiator.recipeBuilder()
            .fluidInputs([this.leftover*(this.amount_to_use*this.conversion_factor)])
            .fluidOutputs([this.fluid_normal*this.amount_to_use])
            .duration(this.duration*8)
            .EUt(8)
            .buildAndRegister();
	}
	
	function GenerateRecipes() as void {
		this.GenerateHXRecipe();
		this.GenerateTurbineRecipe();
		this.GenerateCoolingTowerRecipe();
		this.GenerateRadiatorRecipe();
	}
}
