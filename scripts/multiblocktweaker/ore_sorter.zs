#priority 10

import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.liquid.ILiquidStack;
import crafttweaker.oredict.IOreDictEntry;

/*
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

import crafttweaker.block.IBlock;

var loc = "ore_sorter";
var meta = 20002; // Choose something that won't conflict. You'll get a warning in the crafttweaker logs if something goes wrong.

var ore_sorter = Builder.start(loc, meta)
    .withPattern(
        FactoryBlockPattern.start(RelativeDirection.RIGHT, RelativeDirection.UP, RelativeDirection.BACK)		
			.aisle(" DDDDDDDDDDD ", " DDDDDEDDDDD ", " DDDDDDDDDDD ", "             ", "             ")
			.aisle("DDDDDDDDDDDDD", "DDGGGDDDGGGDD", "DDGGGDDDGGGDD", "  GGG   GGG  ", "  GGG   GGG  ")
			.aisle("DDDDDDDDDDDDD", "DG   GYG   GD", "DGAAAGDGAAAGD", " GVVVG GVVVG ", " G   G G   G ")
			.aisle("DDDDDDDDDDDDD", "CP   PYP   PC", "DGAAAGDGAAAGD", " GVVVG GVVVG ", " G   G G   G ")
			.aisle("DDDDDDDDDDDDD", "DG   GYG   GD", "DGAAAGDGAAAGD", " GVVVG GVVVG ", " G   G G   G ")
			.aisle("DDDDDDDDDDDDD", "DDGGGDDDGGGDD", "DDGGGDDDGGGDD", "  GGG   GGG  ", "  GGG   GGG  ")
			.aisle(" DDDDDDDDDDD ", " DCCCDSDCCCD ", " DDDDDDDDDDD ", "             ", "             ")
            .whereOr("C",
				<metastate:immersiveengineering:sheetmetal:8>,
                IBlockMatcher.abilityPartPredicate(
                    MultiblockAbility.IMPORT_ITEMS,
                    MultiblockAbility.IMPORT_FLUIDS,
                    MultiblockAbility.EXPORT_ITEMS,
					MultiblockAbility.EXPORT_FLUIDS
                ))
			.whereOr("E", 
				<metastate:immersiveengineering:sheetmetal:8>,
				IBlockMatcher.abilityPartPredicate(
                    MultiblockAbility.INPUT_ENERGY
				))
			.whereOr("A",
					<metastate:gtadditions:ga_robot_arm_casing:0>,
					<metastate:gtadditions:ga_robot_arm_casing:1>,
					<metastate:gtadditions:ga_robot_arm_casing:2>,
					<metastate:gtadditions:ga_robot_arm_casing:3>,
					<metastate:gtadditions:ga_robot_arm_casing:4>,
					<metastate:gtadditions:ga_robot_arm_casing:5>,
					<metastate:gtadditions:ga_robot_arm_casing:6>,
					<metastate:gtadditions:ga_robot_arm_casing:7>,
					<metastate:gtadditions:ga_robot_arm_casing:8>,
					<metastate:gtadditions:ga_robot_arm_casing:9>,
					<metastate:gtadditions:ga_robot_arm_casing:10>,
					<metastate:gtadditions:ga_robot_arm_casing:11>,
					<metastate:gtadditions:ga_robot_arm_casing:12>,
					<metastate:gtadditions:ga_robot_arm_casing:13>
				)
			.whereOr("P",
					<metastate:gtadditions:ga_pump_casing:0>,
					<metastate:gtadditions:ga_pump_casing:1>,
					<metastate:gtadditions:ga_pump_casing:2>,
					<metastate:gtadditions:ga_pump_casing:3>,
					<metastate:gtadditions:ga_pump_casing:4>,
					<metastate:gtadditions:ga_pump_casing:5>,
					<metastate:gtadditions:ga_pump_casing:6>,
					<metastate:gtadditions:ga_pump_casing:7>,
					<metastate:gtadditions:ga_pump_casing:8>,
					<metastate:gtadditions:ga_pump_casing:9>,
					<metastate:gtadditions:ga_pump_casing:10>,
					<metastate:gtadditions:ga_pump_casing:11>,
					<metastate:gtadditions:ga_pump_casing:12>,
					<metastate:gtadditions:ga_pump_casing:13>
				)
			.where("Y", <metastate:gregtech:boiler_casing:1>)
			.where("V", <metastate:chisel:technical1:3>)
			.where("D", <metastate:immersiveengineering:sheetmetal:8>)
            .where("S", IBlockMatcher.controller(loc))
            .where(" ", IBlockMatcher.ANY)
			.where("G", <metastate:immersiveengineering:sheetmetal:9>)
            .build())
    .addDesign(
        FactoryMultiblockShapeInfo.start()
			.aisle(
				"DDDDDDD",
				"DDDFDDD",
				"DDDDDDD",
				"       ",
				"       ")
			.aisle(
				"DDDDDDD",
				"DDGPGDD",
				"DDGGGDD",
				"  GGG  ",
				"  GGG  ")
			.aisle(
				"DDDDDDD",
				"IG   GD",
				"DGAAAGD",
				" GVVVG ",
				" G   G ")
			.aisle(
				"DDDDDDD",
				"IG   GD",
				"DGAAAGD",
				" GVVVG ",
				" G   G ")
			.aisle(
				"DDDDDDD",
				"IG   GD",
				"DGAAAGD",
				" GVVVG ",
				" G   G ")
			.aisle(
				"DDDDDDD",
				"DDGPGDD",
				"DDGGGDD",
				"  GGG  ",
				"  GGG  ")
			.aisle(
				"DDDDDDD",
				"SDYYYDE",
				"DDDDDDD",
				"       ",
				"       ")
			.aisle(
				"DDDDDDD",
				"DDGPGDD",
				"DDGGGDD",
				"  GGG  ",
				"  GGG  ")
			.aisle(
				"DDDDDDD",
				"OG   GD",
				"DGAAAGD",
				" GVVVG ",
				" G   G ")
			.aisle(
				"DDDDDDD",
				"OG   GD",
				"DGAAAGD",
				" GVVVG ",
				" G   G ")
			.aisle(
				"DDDDDDD",
				"OG   GD",
				"DGAAAGD",
				" GVVVG ",
				" G   G ")
			.aisle(
				"DDDDDDD",
				"DDGPGDD",
				"DDGGGDD",
				"  GGG  ",
				"  GGG  ")
			.aisle(
				"DDDDDDD",
				"DDDBDDD",
				"DDDDDDD",
				"       ",
				"       ")
            .where("S", IBlockInfo.controller(loc))
            .where("I", MetaTileEntities.ITEM_IMPORT_BUS[1], IFacing.west())
            .where("F", MetaTileEntities.FLUID_IMPORT_HATCH[1], IFacing.north())
			.where("B", MetaTileEntities.FLUID_EXPORT_HATCH[1], IFacing.south())
            .where("O", MetaTileEntities.ITEM_EXPORT_BUS[1], IFacing.west())
            .where("E", MetaTileEntities.ENERGY_INPUT_HATCH[1], IFacing.east())
			.where("D", <metastate:immersiveengineering:sheetmetal:8>)
			.where("G", <metastate:immersiveengineering:sheetmetal:9>)
			.where("V", <metastate:chisel:technical1:3>)
			.where("A", <metastate:gtadditions:ga_robot_arm_casing:0>)
			.where("P", <metastate:gtadditions:ga_pump_casing:0>)
			.where("Y", <metastate:gregtech:boiler_casing:1>)
            .where(" ", IBlockInfo.EMPTY)
            .build())
    .clearTooltips(true)
    .withRecipeMap(
        FactoryRecipeMap.start(loc)
		    .minInputs(1)
		    .maxInputs(9)
		    .minOutputs(1)
		    .maxOutputs(27)
		    .maxFluidInputs(1)
			.maxFluidOutputs(1)
		    .build())
    .buildAndRegister();

recipes.addShaped(
    <gregtech:machine:20002>,
    [
        [robotArms[1], circuits[2], robotArms[1]],
        [pumps[1], hulls[1], pumps[1]],
        [robotArms[1], circuits[2], robotArms[1]]
    ]	
);

*/