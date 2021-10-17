#priority 500

import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.oredict.IOreDictEntry;
import crafttweaker.liquid.ILiquidStack;

import mods.gregtech.recipe.RecipeMap;
import mods.gregtech.recipe.RecipeMaps;
import mods.gtadditions.recipe.Utils;
import mods.gtadditions.recipe.LargeRecipeMap;
import mods.gtadditions.recipe.GARecipeMaps;

import mods.immersivetechnology.Boiler;
import mods.immersivetechnology.SteamTurbine;
import mods.immersivetechnology.HeatExchanger;
import mods.immersivetechnology.CoolingTower;

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

	function GenerateBoilerRecipe() as void {
		mods.immersivetechnology.Boiler.addRecipe(this.fluid_heated*(this.amount_to_use*this.conversion_factor), this.fluid_normal*this.amount_to_use, this.duration);
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
		mods.immersivetechnology.HeatExchanger.addRecipe(this.getHeatedFluid(this.amount_to_use*this.conversion_factor), null, this.getNormalFluid(this.amount_to_use), <liquid:fluegas>*1000, 64, this.duration);
	}
	
	function GenerateTurbineRecipe() as void {
		mods.immersivetechnology.SteamTurbine.addFuel(this.leftover*(this.amount_to_use*this.conversion_factor), this.fluid_heated*(this.amount_to_use*this.conversion_factor), this.duration*this.efficiency);
	}
	
	function GenerateCoolingTowerRecipe() as void {
		mods.immersivetechnology.CoolingTower.addRecipe(this.fluid_normal*this.amount_to_use, <liquid:water>*750, null, this.leftover*(this.amount_to_use*this.conversion_factor), <liquid:water>*1000, this.duration);
	}
	
	function GenerateRadiatorRecipe() as void {
		mods.immersivetechnology.Radiator.addRecipe(this.fluid_normal*this.amount_to_use, this.leftover*(this.amount_to_use*this.conversion_factor), this.duration*8);
	}
	
	function GenerateRecipes() as void {
		this.GenerateBoilerRecipe();
		this.GenerateHXRecipe();
		this.GenerateTurbineRecipe();
		this.GenerateCoolingTowerRecipe();
		this.GenerateRadiatorRecipe();
	}
}
