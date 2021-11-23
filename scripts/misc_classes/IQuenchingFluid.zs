#priority 500

import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.oredict.IOreDictEntry;
import crafttweaker.liquid.ILiquidStack;

zenClass IQuenchingFluid{
	
	val ColdFluid as ILiquidStack;
	val HotFluid as ILiquidStack;
	
	var amount as int;
	var time as int;
	var inert as bool;
	
	zenConstructor(ColdFluid as ILiquidStack, HotFluid as ILiquidStack, amount as int, time as int, inert as bool){
		this.ColdFluid = ColdFluid;
		this.HotFluid = HotFluid;
		this.amount = amount;
		this.time = time;
		this.inert = inert;
	}
	
	function getColdFluid() as ILiquidStack{
		return (this.ColdFluid*amount);
	}
	
	function getHotFluid() as ILiquidStack{
		return (this.HotFluid*amount);
	}
	
	function getDuration() as int{
		return this.time;
	}
	
	function isInert() as bool{
		return this.inert;
	}
}