import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.liquid.ILiquidStack;
import crafttweaker.oredict.IOreDictEntry;
import mods.gregtech.recipe.RecipeMap;
import mods.gtadditions.recipe.Utils;
import mods.gtadditions.recipe.LargeRecipeMap;
import mods.gtadditions.recipe.GARecipeMaps;

val name_removals as string[] = [
	"gtadditions:ga_gregtech.machine.brewery.lv",
	"gtadditions:ga_gregtech.machine.brewery.mv",
	"gtadditions:ga_gregtech.machine.brewery.hv",
	"gtadditions:ga_gregtech.machine.brewery.ev",
	"gtadditions:ga_gtadditions.machine.brewery.iv",
	"gtadditions:ga_gtadditions.machine.brewery.luv",
	"gtadditions:ga_gtadditions.machine.brewery.zpm",
	"gtadditions:ga_gtadditions.machine.brewery.uv",
	"gtadditions:ga_gtadditions.machine.brewery.uhv",
	"gtadditions:ga_gtadditions.machine.brewery.uev",
	"gtadditions:ga_gtadditions.machine.brewery.uiv",
	"gtadditions:ga_gtadditions.machine.brewery.umv",
	"gtadditions:ga_gtadditions.machine.brewery.uxv",
	"gtadditions:ga_gregtech.machine.distillery.lv",
	"gtadditions:ga_gregtech.machine.distillery.mv",
	"gtadditions:ga_gregtech.machine.distillery.hv",
	"gtadditions:ga_gregtech.machine.distillery.ev",
	"gtadditions:ga_gtadditions.machine.distillery.iv",
	"gtadditions:ga_gtadditions.machine.distillery.luv",
	"gtadditions:ga_gtadditions.machine.distillery.zpm",
	"gtadditions:ga_gtadditions.machine.distillery.uv",
	"gtadditions:ga_gtadditions.machine.distillery.uhv",
	"gtadditions:ga_gtadditions.machine.distillery.uev",
	"gtadditions:ga_gtadditions.machine.distillery.uiv",
	"gtadditions:ga_gtadditions.machine.distillery.umv",
	"gtadditions:ga_gtadditions.machine.distillery.uxv"
];

for item in name_removals{
	recipes.removeByRecipeName(item);
}

Utils.removeRecipeByOutput(assembler, [<metaitem:circuit.vacuum_tube>], null, false);

recipes.addShaped("tin_wire_rubber", <ore:cableGtSingleTin>.firstItem, [
	[<ore:wireGtSingleTin>, <ore:plateRubber>, null],
	[null, null, null],
	[null, null, null]
]);

recipes.addShaped("redalloy_wire_rubber", <ore:cableGtSingleRedAlloy>.firstItem, [
	[<ore:wireGtSingleRedAlloy>, <ore:plateRubber>, null],
	[null, null, null],
	[null, null, null]
]);

recipes.addShaped("lead_wire_rubber", <ore:cableGtSingleLead>.firstItem, [
	[<ore:wireGtSingleLead>, <ore:plateRubber>, null],
	[null, null, null],
	[null, null, null]
]);

recipes.addShaped("cobalt_wire_rubber", <ore:cableGtSingleCobalt>.firstItem, [
	[<ore:wireGtSingleCobalt>, <ore:plateRubber>, null],
	[null, null, null],
	[null, null, null]
]);

recipes.addShaped("rubber_plate_manual", <ore:plateRubber>.firstItem, [
	[null, <ore:gregHardHammers>, null],
	[null, <ore:ingotRubber>, null],
	[null, <ore:ingotRubber>, null]
]);

recipes.addShaped("rubber_rod_manual", <ore:stickRubber>.firstItem, [
	[<ore:gregFiles>, null, null],
	[null, <ore:ingotRubber>, null],
	[null, null, null]
]);

//Brewery recipes
for i in 1 to voltageTiers.length{
	recipes.addShaped("gt_brewery_" + voltageTiers[i], breweries[i], [
		[tieredGlass[i], pumps[i], tieredGlass[i]],
		[tieredCables[i], hulls[i], tieredCables[i]],
		[circuits[i], tieredSticks[i], circuits[i]]
	]);
	
	recipes.addShaped("gt_distilleries_" + voltageTiers[i], distilleries[i], [
		[tieredGlass[i], tieredSticks[i], tieredGlass[i]],
		[circuits[i], hulls[i], circuits[i]],
		[tieredCables[i], pumps[i], tieredCables[i]]
	]);
}

alloy_smelter.recipeBuilder()
	.inputs(<ore:dustRawRubber>*6)
	.inputs(<ore:dustSulfur>*1)
	.outputs(<ore:dustRubber>.firstItem*6)
	.duration(400)
	.EUt(8)
	.buildAndRegister();
	
//Vacuum tubes
assembler.recipeBuilder()
	.inputs([
		<ore:platePaper>*2,
		<ore:wireGtSingleCopper>*2,
		<metaitem:component.glass.tube>
	])
	.fluidInputs(<liquid:extremely_high_vacuum>*10)
	.outputs(<metaitem:circuit.vacuum_tube>)
	.duration(120)
	.EUt(8)
	.buildAndRegister();
	
assembler.recipeBuilder()
	.inputs([
		<ore:platePaper>*2,
		<ore:wireFineCopper>*2,
		<metaitem:component.glass.tube>
	])
	.fluidInputs(<liquid:extremely_high_vacuum>*10)
	.outputs(<metaitem:circuit.vacuum_tube>)
	.duration(120)
	.EUt(8)
	.buildAndRegister();
	
blast_furnace.recipeBuilder()
	.inputs(<ore:dustIron>)
	.outputs(<minecraft:iron_ingot>)
	.property("temperature", 1800)
	.duration(60)
	.EUt(60)
	.buildAndRegister();
	
blast_furnace.recipeBuilder()
	.inputs(<ore:dustNickel>)
	.outputs(<ore:ingotNickel>.firstItem)
	.property("temperature", 1800)
	.duration(60)
	.EUt(60)
	.buildAndRegister();

//Primitive blast furnace disassembling removal
disassembler.findRecipe(32, [<gregtech:machine:510>*1], null).remove();
//TechGuns carbon plate removal
fluid_solidifier.findRecipe(8, [<metaitem:shape.mold.plate>*1], [<liquid:carbon>*144]).remove();