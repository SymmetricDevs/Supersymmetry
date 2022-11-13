#priority 8
import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.oredict.IOreDictEntry;
import crafttweaker.liquid.ILiquidStack;

import mods.gregtech.recipe.RecipeMap;
import mods.gregtech.recipe.RecipeMaps;

import scripts.ore_sorting.IOreRock.IOreRock;

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

ore_sorter.recipeBuilder()
	.circuit(1)
	.inputs(rock_sulfur.getRock(sulfur_tier_1.length))
	.outputs(sulfur_tier_1)
	.fluidInputs(rock_sulfur.getFluidIn(fluid_amount * sulfur_tier_1.length))
	.fluidOutputs(rock_sulfur.getFluidOut(fluid_amount * sulfur_tier_1.length))
	.duration(20)
	.EUt(voltageTiersInt[1])
	.buildAndRegister();

val sulfur_tier_2 as IItemStack[] = [
	<ore:oreGalena>.firstItem*1,
	<ore:oreSilver>.firstItem*1,
	<ore:oreGold>.firstItem*1,
	<ore:oreLazurite>.firstItem*1,
	<ore:oreCobaltite>.firstItem*1
];

ore_sorter.recipeBuilder()
	.circuit(2)
	.inputs(rock_sulfur.getRock(sulfur_tier_1.length + sulfur_tier_2.length))
	.outputs(sulfur_tier_1)
	.outputs(sulfur_tier_2)
	.fluidInputs(rock_sulfur.getFluidIn(fluid_amount * (sulfur_tier_1.length + sulfur_tier_2.length)))
	.fluidOutputs(rock_sulfur.getFluidOut(fluid_amount * (sulfur_tier_1.length + sulfur_tier_2.length)))
	.duration(20)
	.EUt(voltageTiersInt[2])
	.buildAndRegister();

val oxide_tier_1 as IItemStack[] = [
	<ore:oreCassiterite>.firstItem*1,
	<ore:oreMagnetite>.firstItem*1,
	<ore:oreYellowLimonite>.firstItem*1,
	<ore:oreBrownLimonite>.firstItem*1,
	<ore:oreHematite>.firstItem*1,
	<ore:oreRuby>.firstItem*1,
	<ore:oreTenorite>.firstItem*1,
	<ore:oreCuprite>.firstItem*1
];

ore_sorter.recipeBuilder()
	.circuit(1)
	.inputs(rock_oxide.getRock(oxide_tier_1.length))
	.outputs(oxide_tier_1)
	.fluidInputs(rock_oxide.getFluidIn(fluid_amount * oxide_tier_1.length))
	.fluidOutputs(rock_oxide.getFluidOut(fluid_amount * oxide_tier_1.length))
	.duration(20)
	.EUt(voltageTiersInt[1])
	.buildAndRegister();

val oxide_tier_2 as IItemStack[] = [
	<ore:oreTantalite>.firstItem*1,
	<ore:orePyrolusite>.firstItem*1,
	<ore:oreGarnierite>.firstItem*1,
	<ore:oreSapphire>.firstItem*1,
	<ore:oreBastnasite>.firstItem*1
];

ore_sorter.recipeBuilder()
	.circuit(2)
	.inputs(rock_oxide.getRock(oxide_tier_1.length + oxide_tier_2.length))
	.outputs(oxide_tier_1)
	.outputs(oxide_tier_2)
	.fluidInputs(rock_oxide.getFluidIn(fluid_amount * (oxide_tier_1.length + oxide_tier_2.length)))
	.fluidOutputs(rock_oxide.getFluidOut(fluid_amount * (oxide_tier_1.length + oxide_tier_2.length)))
	.duration(20)
	.EUt(voltageTiersInt[2])
	.buildAndRegister();

val sedimentary_tier_1 as IItemStack[] = [
	<ore:oreDiatomite>.firstItem*1,
	<ore:oreTrona>.firstItem*1,
	<ore:oreSalt>.firstItem*1,
	<ore:oreRockSalt>.firstItem*1,
	<ore:oreSaltpeter>.firstItem*1
];

ore_sorter.recipeBuilder()
	.circuit(1)
	.inputs(rock_sedimentary.getRock(sedimentary_tier_1.length))
	.outputs(sedimentary_tier_1)
	.fluidInputs(rock_sedimentary.getFluidIn(fluid_amount * sedimentary_tier_1.length))
	.fluidOutputs(rock_sedimentary.getFluidOut(fluid_amount * sedimentary_tier_1.length))
	.duration(20)
	.EUt(voltageTiersInt[1])
	.buildAndRegister();

val silicate_tier_1 as IItemStack[] = [
	<ore:oreAsbestos>.firstItem*1,
	<ore:oreGarnetSand>.firstItem*1,
	<ore:oreGarnetYellow>.firstItem*1,
	<ore:oreGarnetRed>.firstItem*1,
	<ore:oreMica>.firstItem*1,
	<ore:oreRedstone>.firstItem*1,
	<ore:oreLepidolite>.firstItem*1,
	<ore:oreSpodumene>.firstItem*1
];

ore_sorter.recipeBuilder()
	.circuit(1)
	.inputs(rock_silicate.getRock(silicate_tier_1.length))
	.outputs(silicate_tier_1)
	.fluidInputs(rock_silicate.getFluidIn(fluid_amount * silicate_tier_1.length))
	.fluidOutputs(rock_silicate.getFluidOut(fluid_amount * silicate_tier_1.length))
	.duration(20)
	.EUt(voltageTiersInt[1])
	.buildAndRegister();

val silicate_tier_2 as IItemStack[] = [
	<ore:oreAlmandine>.firstItem*1,
	<ore:orePyrope>.firstItem*1,
	<ore:oreBeryllium>.firstItem*1,
	<minecraft:emerald_ore>*1,
	<ore:oreSpessartine>.firstItem*1,
	<ore:oreGrossular>.firstItem*1,
	<ore:oreZeolite>.firstItem*1,
	<ore:oreGlauconiteSand>.firstItem*1,
	<ore:oreSodalite>.firstItem*1,
	<ore:oreOlivine>.firstItem*1,
	<ore:oreQuartzite>.firstItem*1,
	<ore:oreTopaz>.firstItem*1
];

ore_sorter.recipeBuilder()
	.circuit(2)
	.inputs(rock_silicate.getRock(silicate_tier_1.length + silicate_tier_2.length))
	.outputs(silicate_tier_1)
	.outputs(silicate_tier_2)
	.fluidInputs(rock_silicate.getFluidIn(fluid_amount * (silicate_tier_1.length + silicate_tier_2.length)))
	.fluidOutputs(rock_silicate.getFluidOut(fluid_amount * (silicate_tier_1.length + silicate_tier_2.length)))
	.duration(20)
	.EUt(voltageTiersInt[2])
	.buildAndRegister();

val carbonate_tier_1 as IItemStack[] = [
	<ore:oreDolomite>.firstItem*1,
	<ore:oreMalachite>.firstItem*1,
	<ore:oreCalcite>.firstItem*1
];

ore_sorter.recipeBuilder()
	.circuit(1)
	.inputs(rock_carbonate.getRock(carbonate_tier_1.length))
	.outputs(carbonate_tier_1)
	.fluidInputs(rock_carbonate.getFluidIn(fluid_amount * carbonate_tier_1.length))
	.fluidOutputs(rock_carbonate.getFluidOut(fluid_amount * carbonate_tier_1.length))
	.duration(20)
	.EUt(voltageTiersInt[1])
	.buildAndRegister();

val clay_tier_1 as IItemStack[] = [
	<ore:oreKaolinite>.firstItem*1,
	<ore:oreSoapstone>.firstItem*1,
	<ore:oreTalc>.firstItem*1,
	<ore:oreFullersEarth>.firstItem*1,
	<ore:oreBentonite>.firstItem*1
];

ore_sorter.recipeBuilder()
	.circuit(1)
	.inputs(rock_clay.getRock(clay_tier_1.length))
	.outputs(clay_tier_1)
	.fluidInputs(rock_clay.getFluidIn(fluid_amount * clay_tier_1.length))
	.fluidOutputs(rock_clay.getFluidOut(fluid_amount * clay_tier_1.length))
	.duration(20)
	.EUt(voltageTiersInt[1])
	.buildAndRegister();

val carbon_tier_1 as IItemStack[] = [
	<ore:oreGraphite>.firstItem*1,
	<ore:oreDiamond>.firstItem*1
];

ore_sorter.recipeBuilder()
	.circuit(2)
	.inputs(rock_carbon.getRock(carbon_tier_1.length))
	.outputs(carbon_tier_1)
	.fluidInputs(rock_carbon.getFluidIn(fluid_amount * carbon_tier_1.length))
	.fluidOutputs(rock_carbon.getFluidOut(fluid_amount * carbon_tier_1.length))
	.duration(20)
	.EUt(voltageTiersInt[2])
	.buildAndRegister();

val phosphate_tier_1 as IItemStack[] = [
	<ore:oreApatite>.firstItem*1,
	<ore:oreFluorapatite>.firstItem*1,
	<ore:oreTricalciumPhosphate>.firstItem*1
];

ore_sorter.recipeBuilder()
	.circuit(2)
	.inputs(rock_phosphate.getRock(phosphate_tier_1.length))
	.outputs(phosphate_tier_1)
	.fluidInputs(rock_phosphate.getFluidIn(fluid_amount * phosphate_tier_1.length))
	.fluidOutputs(rock_phosphate.getFluidOut(fluid_amount * phosphate_tier_1.length))
	.duration(20)
	.EUt(voltageTiersInt[2])
	.buildAndRegister();

val precious_tier_1 as IItemStack[] = [
	<ore:orePreciousMetal>.firstItem*1,
	<ore:oreGold>.firstItem*1,
	<ore:oreSilver>.firstItem*1
];

ore_sorter.recipeBuilder()
	.circuit(3)
	.inputs(rock_precious.getRock(precious_tier_1.length))
	.outputs(precious_tier_1)
	.fluidInputs(rock_precious.getFluidIn(fluid_amount * precious_tier_1.length))
	.fluidOutputs(rock_precious.getFluidOut(fluid_amount * precious_tier_1.length))
	.duration(20)
	.EUt(voltageTiersInt[3])
	.buildAndRegister();

val radioactive_tier_1 as IItemStack[] = [
	<ore:orePitchblende>.firstItem*1,
	<ore:oreUraninite>.firstItem*1,
	<ore:oreMonazite>.firstItem*1
];

ore_sorter.recipeBuilder()
	.circuit(3)
	.inputs(rock_radioactive.getRock(radioactive_tier_1.length))
	.outputs(radioactive_tier_1)
	.fluidInputs(rock_radioactive.getFluidIn(fluid_amount * radioactive_tier_1.length))
	.fluidOutputs(rock_radioactive.getFluidOut(fluid_amount * radioactive_tier_1.length))
	.duration(20)
	.EUt(voltageTiersInt[3])
	.buildAndRegister();