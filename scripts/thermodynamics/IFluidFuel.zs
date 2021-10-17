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
import mods.immersivetechnology.GasTurbine;
import mods.immersiveengineering.DieselHandler;

zenClass IFluidFuel {
	val liquid_fuel as ILiquidStack;
	val byproduct as ILiquidStack;
	
	var duration as int;
	var amount_to_burn as int;
	
	var byproduct_amount as int = 1000;
	
	var diesel as bool = false;
	var gas_turbine as bool = true;
	
	zenConstructor(liquid_fuel as ILiquidStack, byproduct as ILiquidStack) {
		this.liquid_fuel = liquid_fuel;
		this.byproduct = byproduct;
	}
	
	function setDuration(duration as int) as void {
		this.duration = duration;
	}
	
	function setAmountToBurn(amount_to_burn as int) as void {
		this.amount_to_burn = amount_to_burn;
	}
	
	function setByproductAmount(byproduct_amount as int) as void {
		this.byproduct_amount = byproduct_amount;
	}
	
	function setIsDiesel(b as bool) as void {
		this.diesel = b;
	}
	
	function setIsGasTurbineFuel(b as bool){
		this.gas_turbine = b;
	}

	function GenerateBoilerRecipe() as void {
		mods.immersivetechnology.Boiler.addFuel(this.liquid_fuel * this.amount_to_burn, this.duration, 10);
	}
	
	function GenerateGasTurbineRecipe() as void {
		if(this.gas_turbine){
			mods.immersivetechnology.GasTurbine.addFuel(this.byproduct * this.byproduct_amount, this.liquid_fuel * this.amount_to_burn, this.duration);
		}
	}
	
	function GenerateDieselGeneratorRecipe() as void {
		if(this.diesel){
			mods.immersiveengineering.DieselHandler.addFuel(this.liquid_fuel, this.duration);
		}
	}
	
	function GenerateRecipes() as void {
		this.GenerateBoilerRecipe();
		this.GenerateGasTurbineRecipe();
		this.GenerateDieselGeneratorRecipe();
	}
}
