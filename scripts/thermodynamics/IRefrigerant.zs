#priority 500

import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.oredict.IOreDictEntry;
import crafttweaker.liquid.ILiquidStack;

import mods.gregtech.recipe.RecipeMap;
import mods.gregtech.recipe.RecipeMaps;

zenClass IRefrigerant {
	val refrigerant as ILiquidStack;
	val hot_refrigerant as ILiquidStack;
	val comp_refrigerant as ILiquidStack;
	val cold_refrigerant as ILiquidStack;
	
	var EUt as int = 30;
	var duration as int = 20;
	
	var DurationRadiator as int = 20;
	var amount_to_use as int = 1000;
	
	var HX_time_factor as int = 10;
	
	zenConstructor(refrigerant_normal as ILiquidStack, refrigerant_hot as ILiquidStack, refrigerant_comp as ILiquidStack ,refrigerant_cold as ILiquidStack) {
		refrigerant = refrigerant_normal;
		hot_refrigerant = refrigerant_hot;
		comp_refrigerant = refrigerant_comp;
		cold_refrigerant = refrigerant_cold;
	}
	
	function setPowerToCompress(power as int) as void {
		EUt = power;
	}
	
	function setDurationToCompress(time as int) as void {
		duration = time;
	}
	
	function setDurationRadiator(time as int) as void {
		DurationRadiator = time;
	}
	
	function setAmountToUse(amount as int) as void {
		amount_to_use = amount;
	}
	
	function setTimeFactor(time as int) as void {
		HX_time_factor = time;
	}
	
	function getTimeFactor() as int {
		return HX_time_factor;
	}
	
	function getColdRefrigerant() as ILiquidStack {
		return cold_refrigerant*amount_to_use;
	}
	
	function getRefrigerant() as ILiquidStack {
		return refrigerant*amount_to_use;
	}

	function getHotRefrigerant() as ILiquidStack {
		return hot_refrigerant*amount_to_use;
	}
	
	function getCompRefrigerant() as ILiquidStack {
		return comp_refrigerant*amount_to_use;
	}
	
	function GenerateRecipes() as void {

		//Compression
		fluid_compressor.recipeBuilder()
			.fluidInputs(this.getRefrigerant())
			.fluidOutputs(this.getHotRefrigerant())
			.EUt(this.EUt)
			.duration(this.duration)
			.buildAndRegister();
		
		//Decompression
		fluid_decompressor.recipeBuilder()
			.fluidInputs(this.getCompRefrigerant())
			.fluidOutputs(this.getColdRefrigerant())
			.EUt(8)
			.duration(this.duration)
			.buildAndRegister();
			
		//Radiative Cooling
	    radiator.recipeBuilder()
            .fluidInputs([this.getHotRefrigerant()])
            .fluidOutputs([this.getCompRefrigerant()])
            .duration(this.DurationRadiator)
            .EUt(8)
            .buildAndRegister();
	}
}