#norun
#priority 499

import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.oredict.IOreDictEntry;
import crafttweaker.liquid.ILiquidStack;

import mods.gregtech.recipe.RecipeMap;
import mods.gregtech.recipe.RecipeMaps;

zenClass ICoolant {
	val coolant as ILiquidStack;
	val warm_coolant as ILiquidStack;
	
	var DurationRadiator as int = 200;
	var amount_to_use as int = 1000;
	
	var HX_time_factor as int = 10;
	
	zenConstructor(coolant_normal as ILiquidStack, coolant_warm as ILiquidStack) {
		coolant = coolant_normal;
		warm_coolant = coolant_warm;
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
	
	function getCoolant() as ILiquidStack {
		return coolant*amount_to_use;
	}
	
	function getWarmCoolant() as ILiquidStack {
		return warm_coolant*amount_to_use;
	}
	
	function GenerateRecipes() as void {
	    radiator.recipeBuilder()
        .fluidInputs([this.getWarmCoolant()])
        .fluidOutputs([this.getCoolant()])
        .duration(this.DurationRadiator)
        .EUt(8)
        .buildAndRegister();
	}
}