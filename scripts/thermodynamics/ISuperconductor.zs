#norun
#priority 500

import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.oredict.IOreDictEntry;
import crafttweaker.liquid.ILiquidStack;

zenClass ISuperconductor{
	val Base as IItemStack;
	val SC as IItemStack;
	
	var CritTemp as int = 0;
	var Tier as int = 0; 
	
	zenConstructor(base as IItemStack, sc as IItemStack, crittemp as int, tier as int){
		this.Base = base;
		this.SC = sc;
		this.CritTemp = crittemp;
		this.Tier = tier;
	}
	
	function getBase(amount as int) as IItemStack{
		return (this.Base * amount);
	}
	
	function getSC(amount as int) as IItemStack{
		return (this.SC * amount);
	}
	
	function getCriticalTemperature() as int{
		return this.CritTemp;
	}
	
	function getTier() as int{
		return this.Tier;
	}
}