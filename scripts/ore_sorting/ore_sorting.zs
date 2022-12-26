#norun
#priority 8
import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.oredict.IOreDictEntry;
import crafttweaker.liquid.ILiquidStack;

import mods.gregtech.recipe.RecipeMap;
import mods.gregtech.recipe.RecipeMaps;

import scripts.ore_sorting.IOreRock.IOreRock;

val fluid_amount as int = 100;

//FORMAT: ORE NAME : CHANCE (out of 10000)
val sulfur_tier_1 as int[IItemStack] = {
	<ore:oreSulfur>.firstItem*1 : 10000,
	<ore:oreBornite>.firstItem*1 : 10000,
	<ore:oreChalcocite>.firstItem*1 : 10000,
	<ore:oreEnargite>.firstItem*1 : 10000,
	<ore:orePyrite>.firstItem*1 : 10000,
	<ore:oreChalcopyrite>.firstItem*1 : 10000,
	<ore:oreCinnabar>.firstItem*1 : 10000,
	<ore:oreSphalerite>.firstItem*1 : 10000,
	<ore:oreGypsum>.firstItem*1 : 10000,
	<ore:oreAlunite>.firstItem*1 : 10000,
	<ore:oreTetrahedrite>.firstItem*1 : 10000
};

val sulfur_tier_2 as int[IItemStack] = {
	<ore:oreSulfur>.firstItem*1 : 10000,
	<ore:oreBornite>.firstItem*1 : 10000,
	<ore:oreChalcocite>.firstItem*1 : 10000,
	<ore:oreEnargite>.firstItem*1 : 10000,
	<ore:orePyrite>.firstItem*1 : 10000,
	<ore:oreChalcopyrite>.firstItem*1 : 10000,
	<ore:oreCinnabar>.firstItem*1 : 10000,
	<ore:oreSphalerite>.firstItem*1 : 10000,
	<ore:oreGypsum>.firstItem*1 : 10000,
	<ore:oreAlunite>.firstItem*1 : 10000,
	<ore:oreTetrahedrite>.firstItem*1 : 10000,

	<ore:oreGalena>.firstItem*1 : 10000,
	<ore:oreSilver>.firstItem*1 : 10000,
	<ore:oreGold>.firstItem*1 : 10000,
	<ore:oreLazurite>.firstItem*1 : 10000,
	<ore:oreCobaltite>.firstItem*1 : 10000
};

val oxide_tier_1 as int[IItemStack] = {
	<ore:oreCassiterite>.firstItem*1 : 10000,
	<ore:oreMagnetite>.firstItem*1 : 10000,
	<ore:oreYellowLimonite>.firstItem*1 : 10000,
	<ore:oreBrownLimonite>.firstItem*1 : 10000,
	<ore:oreHematite>.firstItem*1 : 10000,
	<ore:oreRuby>.firstItem*1 : 10000,
	<ore:oreTenorite>.firstItem*1 : 10000,
	<ore:oreCuprite>.firstItem*1 : 10000
};

val oxide_tier_2 as int[IItemStack] = {
	<ore:oreCassiterite>.firstItem*1 : 10000,
	<ore:oreMagnetite>.firstItem*1 : 10000,
	<ore:oreYellowLimonite>.firstItem*1 : 10000,
	<ore:oreBrownLimonite>.firstItem*1 : 10000,
	<ore:oreHematite>.firstItem*1 : 10000,
	<ore:oreRuby>.firstItem*1 : 10000,
	<ore:oreTenorite>.firstItem*1 : 10000,
	<ore:oreCuprite>.firstItem*1 : 10000,

	<ore:oreTantalite>.firstItem*1 : 10000,
	<ore:orePyrolusite>.firstItem*1 : 10000,
	<ore:oreGarnierite>.firstItem*1 : 10000,
	<ore:oreSapphire>.firstItem*1 : 10000,
	<ore:oreBastnasite>.firstItem*1 : 10000
};

val sedimentary_tier_1 as int[IItemStack] = {
	<ore:oreDiatomite>.firstItem*1 : 10000,
	<ore:oreTrona>.firstItem*1 : 10000,
	<ore:oreSalt>.firstItem*1 : 10000,
	<ore:oreRockSalt>.firstItem*1 : 10000,
	<ore:oreSaltpeter>.firstItem*1 : 10000
};

val silicate_tier_1 as int[IItemStack] = {
	<ore:oreAsbestos>.firstItem*1 : 10000,
	<ore:oreGarnetSand>.firstItem*1 : 10000,
	<ore:oreGarnetYellow>.firstItem*1 : 10000,
	<ore:oreGarnetRed>.firstItem*1 : 10000,
	<ore:oreMica>.firstItem*1 : 10000,
	<ore:oreRedstone>.firstItem*1 : 10000,
	<ore:oreLepidolite>.firstItem*1 : 10000,
	<ore:oreSpodumene>.firstItem*1 : 10000
};

val silicate_tier_2 as int[IItemStack] = {
	<ore:oreAsbestos>.firstItem*1 : 10000,
	<ore:oreGarnetSand>.firstItem*1 : 10000,
	<ore:oreGarnetYellow>.firstItem*1 : 10000,
	<ore:oreGarnetRed>.firstItem*1 : 10000,
	<ore:oreMica>.firstItem*1 : 10000,
	<ore:oreRedstone>.firstItem*1 : 10000,
	<ore:oreLepidolite>.firstItem*1 : 10000,
	<ore:oreSpodumene>.firstItem*1 : 10000,

	<ore:oreAlmandine>.firstItem*1 : 10000,
	<ore:orePyrope>.firstItem*1 : 10000,
	<ore:oreBeryllium>.firstItem*1 : 10000,
	<minecraft:emerald_ore>*1 : 10000,
	<ore:oreSpessartine>.firstItem*1 : 10000,
	<ore:oreGrossular>.firstItem*1 : 10000,
	<ore:oreZeolite>.firstItem*1 : 10000,
	<ore:oreGlauconiteSand>.firstItem*1 : 10000,
	<ore:oreSodalite>.firstItem*1 : 10000,
	<ore:oreOlivine>.firstItem*1 : 10000,
	<ore:oreQuartzite>.firstItem*1 : 10000,
	<ore:oreTopaz>.firstItem*1 : 10000
};

val carbonate_tier_1 as int[IItemStack] = {
	<ore:oreDolomite>.firstItem*1 : 10000,
	<ore:oreMalachite>.firstItem*1 : 10000,
	<ore:oreCalcite>.firstItem*1 : 10000
};

val clay_tier_1 as int[IItemStack] = {
	<ore:oreKaolinite>.firstItem*1 : 10000,
	<ore:oreSoapstone>.firstItem*1 : 10000,
	<ore:oreTalc>.firstItem*1 : 10000,
	<ore:oreFullersEarth>.firstItem*1 : 10000,
	<ore:oreBentonite>.firstItem*1 : 10000
};

val carbon_tier_1 as int[IItemStack] = {
	<ore:oreGraphite>.firstItem*1 : 10000,
	<ore:oreDiamond>.firstItem*1 : 500
};

val phosphate_tier_1 as int[IItemStack] = {
	<ore:oreApatite>.firstItem*1 : 10000,
	<ore:oreFluorapatite>.firstItem*1 : 10000,
	<ore:oreTricalciumPhosphate>.firstItem*1 : 10000
};

val precious_tier_1 as int[IItemStack] = {
	<ore:orePreciousMetal>.firstItem*1 : 5000,
	<ore:oreGold>.firstItem*1 : 10000,
	<ore:oreSilver>.firstItem*1 : 10000
};

val radioactive_tier_1 as int[IItemStack] = {
	<ore:orePitchblende>.firstItem*1 : 10000,
	<ore:oreUraninite>.firstItem*1 : 10000,
	<ore:oreMonazite>.firstItem*1 : 10000
};


//FORMAT: BASE ROCK, WASHING FLUID, WASTE FLUID, ORE OUTPUT LISTS, STARTING VOLTAGE TIER

val rock_sulfur = IOreRock(<contenttweaker:rock_sulfur>, <liquid:water>, <liquid:sulfurous_water>, [sulfur_tier_1, sulfur_tier_2], 1);
val rock_oxide = IOreRock(<contenttweaker:rock_oxide>, <liquid:water>, <liquid:oxide_water>, [oxide_tier_1, oxide_tier_2], 1);
val rock_sedimentary = IOreRock(<contenttweaker:rock_sedimentary>, <liquid:water>, <liquid:mineralized_water>, [sedimentary_tier_1], 1);
val rock_silicate = IOreRock(<contenttweaker:rock_silicate>, <liquid:water>, <liquid:silicate_water>, [silicate_tier_1, silicate_tier_2], 1);
val rock_carbonate = IOreRock(<contenttweaker:rock_carbonate>, <liquid:water>, <liquid:calcium_carbonate_solution>, [carbonate_tier_1], 1);
val rock_clay = IOreRock(<contenttweaker:rock_clay>, <liquid:water>, <liquid:bentonite_clay_solution>, [clay_tier_1], 1);
val rock_carbon = IOreRock(<contenttweaker:rock_carbon>, <liquid:water>, <liquid:graphite_water>, [carbon_tier_1], 2);
val rock_phosphate = IOreRock(<contenttweaker:rock_phosphate>, <liquid:water>, <liquid:phosphate_water>, [phosphate_tier_1], 2);
val rock_precious = IOreRock(<contenttweaker:rock_precious>, <liquid:water>, <liquid:precious_runoff>, [precious_tier_1], 3);
val rock_radioactive = IOreRock(<contenttweaker:rock_radioactive>, <liquid:water>, <liquid:radioactive_runoff>, [radioactive_tier_1], 3);

val rocks as IOreRock[] = [
    rock_sulfur,
    rock_oxide,
    rock_sedimentary,
    rock_silicate,
    rock_carbonate,
    rock_clay,
    rock_carbon,
    rock_phosphate,
    rock_precious,
    rock_radioactive
];

for rock in rocks {
    var a = 0;
    for oreList in rock.getOreLists() {
        val recipe = ore_sorter.recipeBuilder();
        recipe.circuit(a);
        recipe.inputs([rock.getRock(oreList.length)]);
        for ore in oreList {
            recipe.chancedOutput(ore, oreList[ore], 0);
        }
        recipe.fluidInputs(rock.getFluidIn(fluid_amount * oreList.length));
        recipe.fluidOutputs(rock.getFluidOut(fluid_amount * oreList.length));
        recipe.duration(20);
        recipe.EUt(voltageTiersInt[rock.getStartingTier() + a]);
        recipe.buildAndRegister();

        a += 1;
    }
}