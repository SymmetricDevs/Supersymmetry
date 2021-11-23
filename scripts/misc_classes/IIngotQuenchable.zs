#priority 500

import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.oredict.IOreDictEntry;
import crafttweaker.liquid.ILiquidStack;

zenClass IIngotQuenchable{
	
	val Ingot as IItemStack;
	val HotIngot as IOreDictEntry;
	
	val need_inert as bool;
	val EUt as int;
	
	zenConstructor(Ingot as IItemStack, HotIngot as IOreDictEntry, need_inert as bool, EUt as int){
		this.Ingot = Ingot;
		this.HotIngot = HotIngot;
		this.need_inert = need_inert;
		this.EUt = EUt;
	}
	
	function getIngot() as IItemStack{
		return this.Ingot;
	}
	
	function getHotIngot() as IOreDictEntry{
		return this.HotIngot;
	}
	
	function NeedsInert() as bool{
		return this.need_inert;
	}
	
	function getEUt() as int {
		return this.EUt;
	}
}