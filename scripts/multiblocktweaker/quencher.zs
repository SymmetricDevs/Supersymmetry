#priority 10
import mods.gregtech.multiblock.Builder;
import mods.gregtech.multiblock.FactoryBlockPattern;
import mods.gregtech.multiblock.RelativeDirection;
import mods.gregtech.multiblock.IBlockMatcher;
import mods.gregtech.multiblock.MultiblockAbility;
import mods.gregtech.multiblock.FactoryMultiblockShapeInfo;
import mods.gregtech.multiblock.IBlockInfo;
import mods.gregtech.MetaTileEntities;
import mods.gregtech.recipe.FactoryRecipeMap;
import crafttweaker.world.IFacing;
import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.liquid.ILiquidStack;
import crafttweaker.oredict.IOreDictEntry;

import scripts.misc_classes.IQuenchingFluid.IQuenchingFluid;
import scripts.misc_classes.IIngotQuenchable.IIngotQuenchable;

var loc = "quencher";
var meta = 20003; // Choose something that won't conflict. You'll get a warning in the crafttweaker logs if something goes wrong.

var large_weapons_factory = Builder.start(loc, meta)
    .withPattern(
        FactoryBlockPattern.start(RelativeDirection.RIGHT, RelativeDirection.UP, RelativeDirection.BACK)		
			.aisle("G G", "DDD", "FFF", "DDD")
			.aisle("G G", "DCD", "VAV", "DCD")
			.aisle("   ", "DCD", "VAV", "DCD")
			.aisle("G G", "DCD", "VAV", "DCD")
			.aisle("G G", "DDD", "FSF", "DDD")
            .whereOr("C",
                <metastate:gregtech:metal_casing:4>,
                IBlockMatcher.abilityPartPredicate(
                    MultiblockAbility.IMPORT_FLUIDS,
					MultiblockAbility.EXPORT_FLUIDS
                ))
			.whereOr("F",
                <metastate:gregtech:metal_casing:4>,
                IBlockMatcher.abilityPartPredicate(
                    MultiblockAbility.INPUT_ENERGY,
                    MultiblockAbility.IMPORT_ITEMS,
                    MultiblockAbility.EXPORT_ITEMS
                ))
			.where("V", <chisel:technical:4>)
			.where("D", <metastate:gregtech:metal_casing:4>)
            .where("S", IBlockMatcher.controller(loc))
            .where(" ", IBlockMatcher.ANY)
			.where("G", <ore:frameGtSteel>.firstItem)
			.whereOr("A",
					<metastate:gtadditions:ga_conveyor_casing:0>,
					<metastate:gtadditions:ga_conveyor_casing:1>,
					<metastate:gtadditions:ga_conveyor_casing:2>,
					<metastate:gtadditions:ga_conveyor_casing:3>,
					<metastate:gtadditions:ga_conveyor_casing:4>,
					<metastate:gtadditions:ga_conveyor_casing:5>,
					<metastate:gtadditions:ga_conveyor_casing:6>,
					<metastate:gtadditions:ga_conveyor_casing:7>,
					<metastate:gtadditions:ga_conveyor_casing:8>,
					<metastate:gtadditions:ga_conveyor_casing:9>,
					<metastate:gtadditions:ga_conveyor_casing:10>,
					<metastate:gtadditions:ga_conveyor_casing:11>,
					<metastate:gtadditions:ga_conveyor_casing:12>,
					<metastate:gtadditions:ga_conveyor_casing:13>)
            .build()
			)
    .addDesign(
        FactoryMultiblockShapeInfo.start()
			.aisle(
				"G G",
				"CCC",
				"CEO",
				"CCC")
			.aisle(
				"G G",
				"CDC",
				"VAV",
				"CFC")
			.aisle(
				"G G",
				"CCC",
				"VAV",
				"CCC")
			.aisle(
				"G G",
				"CDC",
				"VAV",
				"CFC")
			.aisle(
				"G G",
				"CCC",
				"CSI",
				"CCC")
            .where("C", <metastate:gregtech:metal_casing:4>)
            .where("S", IBlockInfo.controller(loc))
            .where("I", MetaTileEntities.ITEM_IMPORT_BUS[1], IFacing.south())
            .where("F", MetaTileEntities.FLUID_IMPORT_HATCH[1], IFacing.up())
			.where("D", MetaTileEntities.FLUID_EXPORT_HATCH[1], IFacing.down())
            .where("O", MetaTileEntities.ITEM_EXPORT_BUS[1], IFacing.north())
            .where("E", MetaTileEntities.ENERGY_INPUT_HATCH[1], IFacing.north())
			.where("A", <metastate:gtadditions:ga_conveyor_casing:0>)
			.where("G", <ore:frameGtSteel>.firstItem)
			.where("V", <metastate:chisel:technical:4>)
            .where(" ", IBlockInfo.EMPTY)
            .build())
    .clearTooltips(true)
    .withRecipeMap(
        FactoryRecipeMap.start(loc)
		    .minInputs(1)
		    .maxInputs(2)
		    .minOutputs(1)
		    .maxOutputs(1)
		    .maxFluidInputs(2)
			.maxFluidOutputs(2)
		    .build())
    .buildAndRegister();
	
//IQuenchingFluid(cold fluid, hot fluid, amount, duration, isInert)
val Water as IQuenchingFluid = IQuenchingFluid(<liquid:water>, <liquid:warm_water>, 1000, 100, false);

val Air as IQuenchingFluid = IQuenchingFluid(<liquid:air>, <liquid:hot_air>, 10000, 1000, false);
val CompressedAir as IQuenchingFluid = IQuenchingFluid(<liquid:hp_air>, <liquid:hot_hp_air>, 5000, 500, false);

val Nitrogen as IQuenchingFluid = IQuenchingFluid(<liquid:nitrogen>, <liquid:hot_nitrogen>, 10000, 500, true);
val CompressedNitrogen as IQuenchingFluid = IQuenchingFluid(<liquid:hp_nitrogen>, <liquid:hot_hp_nitrogen>, 5000, 500, true);

val Brine as IQuenchingFluid = IQuenchingFluid(<liquid:brine>, <liquid:hot_brine>, 1000, 20, false);

val QuenchingFluids as IQuenchingFluid[] = [
	Water,
	Air,
	CompressedAir,
	Nitrogen,
	CompressedNitrogen,
	Brine
];

//IIngotQuenchable(ingot, hot ingot, needsInert, EUt)
val Titanium as IIngotQuenchable = IIngotQuenchable(<ore:ingotTitanium>.firstItem, <ore:ingotHotTitanium>, false, 120);

val Ingots as IIngotQuenchable[] = [
	Titanium
];

for ingot in Ingots {
	for fluid in QuenchingFluids {
		if(!ingot.NeedsInert()) {
			<multiblock:multiblocktweaker:quencher>.recipeMap.recipeBuilder()
				.inputs([ingot.getHotIngot()])
				.fluidInputs([fluid.getColdFluid()])
				.outputs(ingot.getIngot())
				.fluidOutputs(fluid.getHotFluid())
				.duration(fluid.getDuration())
				.EUt(ingot.getEUt())
				.buildAndRegister();
		} else if(fluid.isInert()) {
			<multiblock:multiblocktweaker:quencher>.recipeMap.recipeBuilder()
				.inputs([ingot.getHotIngot()])
				.fluidInputs([fluid.getColdFluid()])
				.outputs(ingot.getIngot())
				.fluidOutputs(fluid.getHotFluid())
				.duration(fluid.getDuration())
				.EUt(ingot.getEUt())
				.buildAndRegister();
		}
	}
}