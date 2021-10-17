#priority 496

import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.liquid.ILiquidStack;
import crafttweaker.oredict.IOreDictEntry;
import mods.gregtech.recipe.RecipeMap;
import mods.gtadditions.recipe.Utils;
import mods.gtadditions.recipe.LargeRecipeMap;
import mods.gtadditions.recipe.GARecipeMaps;

import scripts.thermodynamics.ICryoGas.ICryoGas;
import scripts.thermodynamics.ISuperconductor.ISuperconductor;
import scripts.thermodynamics.thermo;

var LVSuperconductor as ISuperconductor = ISuperconductor(<ore:wireGtSingleManganesePhosphide>.firstItem, <ore:wireGtSingleLvSuperconductor>.firstItem, 90, 1);
var MVSuperconductor as ISuperconductor = ISuperconductor(<ore:wireGtSingleMvSuperconductorBase>.firstItem, <ore:wireGtSingleMvSuperconductor>.firstItem, 85, 2);
var HVSuperconductor as ISuperconductor = ISuperconductor(<ore:wireGtSingleHvSuperconductorBase>.firstItem, <ore:wireGtSingleHvSuperconductor>.firstItem, 80, 3);
var EVSuperconductor as ISuperconductor = ISuperconductor(<ore:wireGtSingleEvSuperconductorBase>.firstItem, <ore:wireGtSingleEvSuperconductor>.firstItem, 75, 4);
var IVSuperconductor as ISuperconductor = ISuperconductor(<ore:wireGtSingleIvSuperconductorBase>.firstItem, <ore:wireGtSingleIvSuperconductor>.firstItem, 70, 5);

val Superconductors as ISuperconductor[] = [
	LVSuperconductor,
	MVSuperconductor,
	HVSuperconductor,
	EVSuperconductor,
	IVSuperconductor
];



for SC in Superconductors {
	mods.gtadditions.recipe.Utils.removeRecipeByOutput(chemical_bath, [SC.getSC(16)], null, false);
	for CryoGas in thermo.CryoGases {
		if(SC.getCriticalTemperature() > CryoGas.getTemperature()){
			chemical_bath.recipeBuilder()
				.inputs(SC.getBase(16))
				.fluidInputs(CryoGas.getLiquidGas(5))
				.outputs(SC.getSC(16))
				.fluidOutputs(CryoGas.getGas(5*64))
				.duration(20)
				.EUt(voltageTiersInt[SC.getTier()]/2)
				.buildAndRegister();
		}
	}
}