#norun
#priority 498

import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.oredict.IOreDictEntry;
import crafttweaker.liquid.ILiquidStack;

import mods.gregtech.recipe.RecipeMap;
import mods.gregtech.recipe.RecipeMaps;
import mods.gtadditions.recipe.Utils;
import mods.gtadditions.recipe.LargeRecipeMap;
import mods.gtadditions.recipe.GARecipeMaps;

import scripts.thermodynamics.ICoolant.ICoolant;
import scripts.thermodynamics.IRefrigerant.IRefrigerant;

import mods.immersivetechnology.HeatExchanger;

zenClass ICryoGas {
	val normal_gas as ILiquidStack;
	val hot_high_pressure_gas as ILiquidStack;
	val high_pressure_gas as ILiquidStack;
	val cold_high_pressure_gas as ILiquidStack;
	val liquid_gas as ILiquidStack;
	
	var amount_to_use as int = 20000;
	
	var EUt as int = 30;
	var duration as int = 20;
	
	var PowerHeatExchanger as int = 20;
	var DurationHeatExchanger as int = 10;
	
	var DurationRadiator as int = 100;
	
	var temperature as int = 300;
	
	static fluid_de_compressor as RecipeMap = RecipeMap.getByName("fluid_de_compressor");
	
	zenConstructor(gas_normal as ILiquidStack, gas_hot_hp as ILiquidStack, gas_hp as ILiquidStack, gas_cold_hp as ILiquidStack, gas_liquid as ILiquidStack) {
		normal_gas = gas_normal;
		hot_high_pressure_gas = gas_hot_hp;
		high_pressure_gas = gas_hp;
		cold_high_pressure_gas = gas_cold_hp;
		liquid_gas = gas_liquid;
	}
	
	function setEUt(power as int) as void {
		EUt = power;
	}
	
	function setDuration(time as int) as void {
		duration = time;
	}
	
	function setPowerHX(power_hx as int) as void {
		PowerHeatExchanger = power_hx;
	}
	
	function setDurationHX(duration_hx as int) as void {
		DurationHeatExchanger = duration_hx;
	}
	
	function setDurationRadiator(duration_rad as int) as void {
		DurationRadiator = duration_rad;
	}
	
	function getGas(amount as int) as ILiquidStack{
		return normal_gas*amount;
	}
	
	function getHotHPGas(amount as int) as ILiquidStack{
		return hot_high_pressure_gas*amount;
	}
	
	function getHPGas(amount as int) as ILiquidStack{
		return high_pressure_gas*amount;
	}
	
	function getColdHPGas(amount as int) as ILiquidStack{
		return cold_high_pressure_gas*amount;
	}
	
	function getLiquidGas(amount as int) as ILiquidStack{
		return liquid_gas*amount;
	}
	
	function getPowerToCompress() as int{
		return EUt;
	}
	
	function getDurationToCompress() as int{
		return duration;
	}
	
	function setTemperature(temp as int) as void{
		this.temperature = temp;
	}
	
	function getTemperature() as int{
		return this.temperature;
	}
	
	function GenerateHXCooling(coolant as ICoolant) as void{
		mods.immersivetechnology.HeatExchanger.addRecipe(this.getHPGas(this.amount_to_use), coolant.getWarmCoolant(), this.getHotHPGas(this.amount_to_use), coolant.getCoolant(), PowerHeatExchanger, DurationHeatExchanger + coolant.getTimeFactor());
	}
	
	function GenerateHXRefrigeration(refrigerant as IRefrigerant) as void{
		mods.immersivetechnology.HeatExchanger.addRecipe(this.getColdHPGas(this.amount_to_use), refrigerant.getRefrigerant(), this.getHPGas(this.amount_to_use), refrigerant.getColdRefrigerant(), PowerHeatExchanger, DurationHeatExchanger + refrigerant.getTimeFactor());
	}
	
	function GenerateRecipes() as void {
	
		//Compression
		fluid_de_compressor.recipeBuilder()
			.fluidInputs(this.getGas(1280))
			.fluidOutputs(this.getHotHPGas(1280))
			.duration(this.duration)
			.EUt(this.EUt)
			.buildAndRegister();
			
		//Radiator Cooling
		
		//Decompression
		fluid_de_compressor.recipeBuilder()
			.fluidInputs(this.getColdHPGas(1280))
			.fluidOutputs(this.getLiquidGas(20))
			.duration(20)
			.EUt(8)
			.buildAndRegister();
			
		//Radiative Cooling
		mods.immersivetechnology.Radiator.addRecipe(this.getHPGas(this.amount_to_use), this.getHotHPGas(this.amount_to_use), this.DurationHeatExchanger*5);
	}
}