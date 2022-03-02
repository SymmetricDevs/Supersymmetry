#norun
#priority 8
import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.oredict.IOreDictEntry;
import crafttweaker.liquid.ILiquidStack;

import mods.gregtech.recipe.RecipeMap;
import mods.gregtech.recipe.RecipeMaps;
import mods.gtadditions.recipe.Utils;
import mods.gtadditions.recipe.LargeRecipeMap;
import mods.gtadditions.recipe.GARecipeMaps;

import mods.immersiveengineering.Excavator;
//mods.immersiveengineering.Excavator.addMineral(String name, int mineralWeight, double failChance, String[] ores, double[] chances, @Optional int[] dimensionWhitelist, @Optional boolean blacklist);

import scripts.ore_sorting.IOreRock.IOreRock;

val name_removals as string[] = [
	"Iron",
	"Magnetite",
	"Pyrite",
	"Bauxite",
	"Copper",
	"Cassiterite",
	"Gold",
	"Nickel",
	"Platinum",
	"Uranium",
	"Quartzite",
	"Galena",
	"Lead",
	"Silver",
	"Lapis",
	"Cinnabar",
	"Coal",
	"Silt"
];

for vein in name_removals {
	mods.immersiveengineering.Excavator.removeMineral(vein);
}

val fluid_amount as int = 100;

//ROCKS & FLUIDS
val rock_sulfur = IOreRock(<contenttweaker:rock_sulfur>, <liquid:water>, <liquid:sulfurous_water>);
val rock_oxide = IOreRock(<contenttweaker:rock_oxide>, <liquid:water>, <liquid:oxide_water>);
val rock_sedimentary = IOreRock(<contenttweaker:rock_sedimentary>, <liquid:water>, <liquid:mineralized_water>);
val rock_silicate = IOreRock(<contenttweaker:rock_silicate>, <liquid:water>, <liquid:silicate_water>);
val rock_carbonate = IOreRock(<contenttweaker:rock_carbonate>, <liquid:water>, <liquid:calcium_carbonate_solution>);
val rock_clay = IOreRock(<contenttweaker:rock_clay>, <liquid:water>, <liquid:bentonite_clay_solution>);
val rock_carbon = IOreRock(<contenttweaker:rock_carbon>, <liquid:water>, <liquid:graphite_water>);
val rock_phosphate = IOreRock(<contenttweaker:rock_phosphate>, <liquid:water>, <liquid:phosphate_water>);
val rock_precious = IOreRock(<contenttweaker:rock_precious>, <liquid:water>, <liquid:precious_runoff>);
val rock_radioactive = IOreRock(<contenttweaker:rock_radioactive>, <liquid:water>, <liquid:radioactive_runoff>);

mods.immersiveengineering.Excavator.addMineral("Sulfur rich mineral", 80, 0, ["mineralRockSulfur"], [1], [0], false);
mods.immersiveengineering.Excavator.addMineral("Oxide mineral", 80, 0, ["mineralRockOxide"], [1], [0], false);
mods.immersiveengineering.Excavator.addMineral("Sedimentary mineral", 80, 0, ["mineralRockSedimentary"], [1], [0], false);
mods.immersiveengineering.Excavator.addMineral("Silicate mineral", 100, 0, ["mineralRockSilicate"], [1], [0], false);
mods.immersiveengineering.Excavator.addMineral("Carbonate mineral", 80, 0, ["mineralRockCarbonate"], [1], [0], false);
mods.immersiveengineering.Excavator.addMineral("Clay mineral", 90, 0, ["mineralRockClay"], [1], [0], false);
mods.immersiveengineering.Excavator.addMineral("Carbon rich mineral", 60, 0, ["mineralRockCarbon"], [1], [0], false);
mods.immersiveengineering.Excavator.addMineral("Phosphate mineral", 75, 0, ["mineralRockPhosphate"], [1], [0], false);
mods.immersiveengineering.Excavator.addMineral("Precious mineral", 50, 0, ["mineralRockPrecious"], [1], [0], false);
mods.immersiveengineering.Excavator.addMineral("Radioactive mineral", 60, 0, ["mineralRockradioactive"], [1], [0], false);

//OUTPUTS
val sulfur_tier_1 as IItemStack[] = [
	<ore:oreSulfur>.firstItem*1,
	<ore:oreBornite>.firstItem*1,
	<ore:oreChalcocite>.firstItem*1,
	<ore:oreEnargite>.firstItem*1,
	<ore:orePyrite>.firstItem*1,
	<ore:oreChalcopyrite>.firstItem*1,
	<ore:oreCinnabar>.firstItem*1,
	<ore:oreSphalerite>.firstItem*1,
	<ore:oreGypsum>.firstItem*1,
	<ore:oreAlunite>.firstItem*1,
	<ore:oreTetrahedrite>.firstItem*1
];

val sulfur_tier_2 as IItemStack[] = [
	<ore:oreGalena>.firstItem*1,
	<ore:oreSilver>.firstItem*1,
	<ore:oreGold>.firstItem*1,
	<ore:oreLazurite>.firstItem*1,
	<ore:oreCobaltite>.firstItem*1
];

val oxide_tier_1 as IItemStack[] = [
	<ore:oreCassiterite>.firstItem*1,
	<ore:oreMagnetite>.firstItem*1,
	<ore:oreYellowLimonite>.firstItem*1,
	<ore:oreBrownLimonite>.firstItem*1,
	<ore:oreBandedIron>.firstItem*1,
	<ore:oreRuby>.firstItem*1,
	<ore:oreTenorite>.firstItem*1,
	<ore:oreCuprite>.firstItem*1
];

val oxide_tier_2 as IItemStack[] = [
	<ore:oreTantalite>.firstItem*1,
	<ore:orePyrolusite>.firstItem*1,
	<ore:oreGarnierite>.firstItem*1,
	<ore:oreSapphire>.firstItem*1,
	<ore:oreGreenSapphire>.firstItem*1,
	<ore:oreZirkelite>.firstItem*1
];

val sedimentary_tier_1 as IItemStack[] = [
	<ore:oreDiatomite>.firstItem*1,
	<ore:oreTrona>.firstItem*1,
	<ore:oreSalt>.firstItem*1,
	<ore:oreRockSalt>.firstItem*1,
	<ore:oreSaltpeter>.firstItem*1
];

val silicate_tier_1 as IItemStack[] = [
	<ore:oreAsbestos>.firstItem*1,
	<ore:oreGarnetSand>.firstItem*1,
	<ore:oreGarnetYellow>.firstItem*1,
	<ore:oreGarnetRed>.firstItem*1,
	<ore:oreWollastonite>.firstItem*1,
	<ore:oreAndradite>.firstItem*1,
	<ore:oreMica>.firstItem*1,
	<ore:oreRedstone>.firstItem*1,
	<ore:oreLepidolite>.firstItem*1,
	<ore:oreSpodumene>.firstItem*1
];

val silicate_tier_2 as IItemStack[] = [
	<ore:oreAlmandine>.firstItem*1,
	<ore:orePyrope>.firstItem*1,
	<ore:oreBeryllium>.firstItem*1,
	<ore:oreEmerald>.firstItem*1,
	<ore:oreSpessartine>.firstItem*1,
	<ore:oreGrossular>.firstItem*1,
	<ore:oreZeolite>.firstItem*1,
	<ore:oreGlauconite>.firstItem*1,
	<ore:oreSodalite>.firstItem*1,
	<ore:oreOlivine>.firstItem*1,
	<ore:orePrasiolite>.firstItem*1,
	<ore:oreQuartzite>.firstItem*1,
	<ore:oreTopaz>.firstItem*1
];

val carbonate_tier_1 as IItemStack[] = [
	<ore:oreDolomite>.firstItem*1,
	<ore:oreMalachite>.firstItem*1,
	<ore:oreCalcite>.firstItem*1
];

val clay_tier_1 as IItemStack[] = [
	<ore:oreKaolinite>.firstItem*1,
	<ore:oreSoapstone>.firstItem*1,
	<ore:oreTalc>.firstItem*1,
	<ore:oreFullersEarth>.firstItem*1,
	<ore:oreBentonite>.firstItem*1
];

val carbon_tier_1 as IItemStack[] = [
	<ore:oreGraphite>.firstItem*1,
	<ore:oreDiamond>.firstItem*1
];

val phosphate_tier_1 as IItemStack[] = [
	<ore:oreApatite>.firstItem*1,
	<ore:oreFluoroapatite>.firstItem*1,
	<ore:orePhosphor>.firstItem*1
];

val precious_tier_1 as IItemStack[] = [
	<ore:orePreciousMetal>.firstItem*1,
	<ore:oreGold>.firstItem*1,
	<ore:oreSilver>.firstItem*1
];

val radioactive_tier_1 as IItemStack[] = [
	<ore:orePitchblende>.firstItem*1,
	<ore:oreUraninite>.firstItem*1,
	<ore:oreMonazite>.firstItem*1
];

//RECIPES

//SULFUR (TIER 1)
<multiblock:multiblocktweaker:ore_sorter>.recipeMap.recipeBuilder()
	.notConsumable(intCircuit(1))
	.inputs(rock_sulfur.getRock(sulfur_tier_1.length))
	.outputs(sulfur_tier_1)
	.fluidInputs(rock_sulfur.getFluidIn(fluid_amount * sulfur_tier_1.length))
	.fluidOutputs(rock_sulfur.getFluidOut(fluid_amount * sulfur_tier_1.length))
	.duration(20)
	.EUt(voltageTiersInt[1])
	.buildAndRegister();
	
//SULFUR (TIER 2)
<multiblock:multiblocktweaker:ore_sorter>.recipeMap.recipeBuilder()
	.notConsumable(intCircuit(2))
	.inputs(rock_sulfur.getRock(sulfur_tier_1.length + sulfur_tier_2.length))
	.outputs(sulfur_tier_1)
	.outputs(sulfur_tier_2)
	.fluidInputs(rock_sulfur.getFluidIn(fluid_amount * (sulfur_tier_1.length + sulfur_tier_2.length)))
	.fluidOutputs(rock_sulfur.getFluidOut(fluid_amount * (sulfur_tier_1.length + sulfur_tier_2.length)))
	.duration(20)
	.EUt(voltageTiersInt[2])
	.buildAndRegister();
	
//OXIDE (TIER 1)
<multiblock:multiblocktweaker:ore_sorter>.recipeMap.recipeBuilder()
	.notConsumable(intCircuit(1))
	.inputs(rock_oxide.getRock(oxide_tier_1.length))
	.outputs(oxide_tier_1)
	.fluidInputs(rock_oxide.getFluidIn(fluid_amount * oxide_tier_1.length))
	.fluidOutputs(rock_oxide.getFluidOut(fluid_amount * oxide_tier_1.length))
	.duration(20)
	.EUt(voltageTiersInt[1])
	.buildAndRegister();
	
//OXIDE (TIER 2)
<multiblock:multiblocktweaker:ore_sorter>.recipeMap.recipeBuilder()
	.notConsumable(intCircuit(2))
	.inputs(rock_oxide.getRock(oxide_tier_1.length + oxide_tier_2.length))
	.outputs(oxide_tier_1)
	.outputs(oxide_tier_2)
	.fluidInputs(rock_oxide.getFluidIn(fluid_amount * (oxide_tier_1.length + oxide_tier_2.length)))
	.fluidOutputs(rock_oxide.getFluidOut(fluid_amount * (oxide_tier_1.length + oxide_tier_2.length)))
	.duration(20)
	.EUt(voltageTiersInt[2])
	.buildAndRegister();
	
//SEDIMENTARY (TIER 1)
<multiblock:multiblocktweaker:ore_sorter>.recipeMap.recipeBuilder()
	.notConsumable(intCircuit(1))
	.inputs(rock_sedimentary.getRock(sedimentary_tier_1.length))
	.outputs(sedimentary_tier_1)
	.fluidInputs(rock_sedimentary.getFluidIn(fluid_amount * sedimentary_tier_1.length))
	.fluidOutputs(rock_sedimentary.getFluidOut(fluid_amount * sedimentary_tier_1.length))
	.duration(20)
	.EUt(voltageTiersInt[1])
	.buildAndRegister();
	
//SILICATE (TIER 1)
<multiblock:multiblocktweaker:ore_sorter>.recipeMap.recipeBuilder()
	.notConsumable(intCircuit(1))
	.inputs(rock_silicate.getRock(silicate_tier_1.length))
	.outputs(silicate_tier_1)
	.fluidInputs(rock_silicate.getFluidIn(fluid_amount * silicate_tier_1.length))
	.fluidOutputs(rock_silicate.getFluidOut(fluid_amount * silicate_tier_1.length))
	.duration(20)
	.EUt(voltageTiersInt[1])
	.buildAndRegister();

//SILICATE (TIER 2)
<multiblock:multiblocktweaker:ore_sorter>.recipeMap.recipeBuilder()
	.notConsumable(intCircuit(2))
	.inputs(rock_silicate.getRock(silicate_tier_1.length + silicate_tier_2.length))
	.outputs(silicate_tier_1)
	.outputs(silicate_tier_2)
	.fluidInputs(rock_silicate.getFluidIn(fluid_amount * (silicate_tier_1.length + silicate_tier_2.length)))
	.fluidOutputs(rock_silicate.getFluidOut(fluid_amount * (silicate_tier_1.length + silicate_tier_2.length)))
	.duration(20)
	.EUt(voltageTiersInt[2])
	.buildAndRegister();
	
//CARBONATE (TIER 1)
<multiblock:multiblocktweaker:ore_sorter>.recipeMap.recipeBuilder()
	.notConsumable(intCircuit(1))
	.inputs(rock_carbonate.getRock(carbonate_tier_1.length))
	.outputs(carbonate_tier_1)
	.fluidInputs(rock_carbonate.getFluidIn(fluid_amount * carbonate_tier_1.length))
	.fluidOutputs(rock_carbonate.getFluidOut(fluid_amount * carbonate_tier_1.length))
	.duration(20)
	.EUt(voltageTiersInt[1])
	.buildAndRegister();
	
//CLAY (TIER 1)
<multiblock:multiblocktweaker:ore_sorter>.recipeMap.recipeBuilder()
	.notConsumable(intCircuit(1))
	.inputs(rock_clay.getRock(clay_tier_1.length))
	.outputs(clay_tier_1)
	.fluidInputs(rock_clay.getFluidIn(fluid_amount * clay_tier_1.length))
	.fluidOutputs(rock_clay.getFluidOut(fluid_amount * clay_tier_1.length))
	.duration(20)
	.EUt(voltageTiersInt[1])
	.buildAndRegister();
	
//CARBON (TIER 1)
<multiblock:multiblocktweaker:ore_sorter>.recipeMap.recipeBuilder()
	.notConsumable(intCircuit(2))
	.inputs(rock_carbon.getRock(carbon_tier_1.length))
	.outputs(carbon_tier_1)
	.fluidInputs(rock_carbon.getFluidIn(fluid_amount * carbon_tier_1.length))
	.fluidOutputs(rock_carbon.getFluidOut(fluid_amount * carbon_tier_1.length))
	.duration(20)
	.EUt(voltageTiersInt[2])
	.buildAndRegister();
	
//PHOSPHATE (TIER 1)
<multiblock:multiblocktweaker:ore_sorter>.recipeMap.recipeBuilder()
	.notConsumable(intCircuit(2))
	.inputs(rock_phosphate.getRock(phosphate_tier_1.length))
	.outputs(phosphate_tier_1)
	.fluidInputs(rock_phosphate.getFluidIn(fluid_amount * phosphate_tier_1.length))
	.fluidOutputs(rock_phosphate.getFluidOut(fluid_amount * phosphate_tier_1.length))
	.duration(20)
	.EUt(voltageTiersInt[2])
	.buildAndRegister();
	
//PRECIOUS (TIER 1)
<multiblock:multiblocktweaker:ore_sorter>.recipeMap.recipeBuilder()
	.notConsumable(intCircuit(3))
	.inputs(rock_precious.getRock(precious_tier_1.length))
	.outputs(precious_tier_1)
	.fluidInputs(rock_precious.getFluidIn(fluid_amount * precious_tier_1.length))
	.fluidOutputs(rock_precious.getFluidOut(fluid_amount * precious_tier_1.length))
	.duration(20)
	.EUt(voltageTiersInt[3])
	.buildAndRegister();
	
//PRECIOUS (TIER 1)
<multiblock:multiblocktweaker:ore_sorter>.recipeMap.recipeBuilder()
	.notConsumable(intCircuit(3))
	.inputs(rock_radioactive.getRock(radioactive_tier_1.length))
	.outputs(radioactive_tier_1)
	.fluidInputs(rock_radioactive.getFluidIn(fluid_amount * radioactive_tier_1.length))
	.fluidOutputs(rock_radioactive.getFluidOut(fluid_amount * radioactive_tier_1.length))
	.duration(20)
	.EUt(voltageTiersInt[3])
	.buildAndRegister();