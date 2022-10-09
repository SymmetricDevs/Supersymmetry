import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.liquid.ILiquidStack;
import crafttweaker.oredict.IOreDictEntry;
import mods.gregtech.recipe.RecipeMaps;

val name_removals as string[] = [
	"gaspunk:diffuser"
];

for item in name_removals {
	recipes.removeByRecipeName(item);
}

//Brewing removals
brewing.removeRecipe(<gaspunk:gas_tube>.withTag({"gaspunk:contained_gas": "gaspunk:smoke"}), <minecraft:sugar>);
brewing.removeRecipe(<gaspunk:gas_tube>.withTag({"gaspunk:contained_gas": "gaspunk:smoke"}), <gaspunk:ash>);
brewing.removeRecipe(<gaspunk:gas_tube>.withTag({"gaspunk:contained_gas": "gaspunk:smoke"}), <minecraft:ghast_tear>);
brewing.removeRecipe(<gaspunk:gas_tube>.withTag({"gaspunk:contained_gas": "gaspunk:smoke"}), <minecraft:fermented_spider_eye>);
brewing.removeRecipe(<minecraft:potion>.withTag({Potion: "minecraft:water"}), <ore:dustSulfur>.firstItem);
brewing.removeRecipe(<minecraft:potion>.withTag({Potion: "minecraft:water"}), <minecraft:poisonous_potato>);

for solder in soldering_alloys {
	weapons_factory.recipeBuilder()
		.inputs([
			<ore:ringRubber>*4,
			<ore:platePlastic>,
			<ore:plateSteel>
		])
		.fluidInputs([solder, <liquid:plastic>*144])
		.outputs(<gaspunk:diffuser>)
		.duration(200)
		.EUt(60)
		.buildAndRegister();
}

val GasMapMV as string[ILiquidStack] = {
	<liquid:fluorine> : "gaspunk:fluorine",
	<liquid:carbon_monoxide> : "gaspunk:carbon_monoxide",
	<liquid:chlorine> : "gaspunk:chlorine",
	<liquid:diborane> : "gaspunk:diborane",
	<liquid:hydrogen_cyanide> : "gaspunk:hydrogen_cyanide",
	<liquid:radon> : "gaspunk:radon"
};

for key in GasMapMV {
	canner.recipeBuilder()
		.inputs([<minecraft:glass_bottle>])
		.fluidInputs(key*100)
		.outputs(<gaspunk:gas_tube>.withTag({"gaspunk:contained_gas": GasMapMV[key]}))
		.duration(20)
		.EUt(60)
		.buildAndRegister();
}