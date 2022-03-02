#norun
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
import crafttweaker.block.IBlock;

var loc = "vacuum_chamber";
var meta = 20004; // Choose something that won't conflict. You'll get a warning in the crafttweaker logs if something goes wrong.

var vacuum_chamber = Builder.start(loc, meta)
    .withPattern(
        FactoryBlockPattern.start(RelativeDirection.RIGHT, RelativeDirection.UP, RelativeDirection.BACK)		
			.aisle("  DDD  ", " D   D ", "D     D", "D     D", "D     D", " D   D ", "  DDD  ")
			.aisle("GGDDDGG", "GDDDDDG", "DDIIIDD", "DDIIIDD", "DDIIIDD", " DDDDD ", "  DDD  ")
			.aisle("  DED  ", " DYCYD ", "D     D", "D     D", "D     D", " D   D ", "  DED  ")
			.aisle("GGDEDGG", "GDYCYDG", "D     D", "V     V", "D     D", " D   D ", "  DED  ")
			.aisle("  DED  ", " DYCYD ", "D     D", "V     V", "D     D", " D   D ", "  DED  ")
			.aisle("GGDEDGG", "GDYCYDG", "D     D", "V     V", "D     D", " D   D ", "  DED  ")
			.aisle("  DED  ", " DYCYD ", "D     D", "D     D", "D     D", " D   D ", "  DED  ")
			.aisle("GGDDDGG", "GDDSDDG", "DDIIIDD", "DDIIIDD", "DDIIIDD", " DDDDD ", "  DDD  ")
			.aisle("  DDD  ", " D   D ", "D     D", "D     D", "D     D", " D   D ", "  DDD  ")
            .whereOr("I",
				<contenttweaker:vacuum_casing> as IBlock as IBlockMatcher,
                IBlockMatcher.abilityPartPredicate(
                    MultiblockAbility.IMPORT_ITEMS,
                    MultiblockAbility.EXPORT_ITEMS
                ))
			.whereOr("V",
				<contenttweaker:vacuum_casing> as IBlock as IBlockMatcher,
                IBlockMatcher.abilityPartPredicate(
                    MultiblockAbility.IMPORT_FLUIDS,
					MultiblockAbility.EXPORT_FLUIDS
                ))
			.whereOr("E", 
				<contenttweaker:vacuum_casing> as IBlock as IBlockMatcher,
				IBlockMatcher.abilityPartPredicate(
                    MultiblockAbility.INPUT_ENERGY
				))
			.whereOr("C",
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
					<metastate:gtadditions:ga_conveyor_casing:13>
				)
			.where("D", <contenttweaker:vacuum_casing>)
            .where("S", IBlockMatcher.controller(loc))
            .where(" ", IBlockMatcher.ANY)
			.where("G", <ore:frameGtSteel>.firstItem)
			.where("Y", <ore:frameGtStainlessSteel>.firstItem)
            .build())
    .addDesign(
        FactoryMultiblockShapeInfo.start()
			.aisle(
				" G G G G ",
				" G G G G ",
				"DDDDDDDDD",
				"DDDDFDDDD",
				"DDDDDDDDD",
				"         ",
				"         ")
			.aisle(
				" G G G G ",
				"DDDDDDDDD",
				" D     D ",
				" D     D ",
				" D     D ",
				"DDDDDDDDD",
				"         ")
			.aisle(
				"DDDDDDDDD",
				" DYYYYYD ",
				" D     D ",
				" D     D ",
				" D     D ",
				" D     D ",
				"DDDDDDDDD")
			.aisle(
				"DDDDDDDDD",
				" SCCCCCD ",
				" I     O ",
				" D     D ",
				" D     D ",
				" D     D ",
				"DDDDEDDDD")
			.aisle(
				"DDDDDDDDD",
				" DYYYYYD ",
				" D     D ",
				" D     D ",
				" D     D ",
				" D     D ",
				"DDDDDDDDD")
			.aisle(
				" G G G G ",
				"DDDDDDDDD",
				" D     D ",
				" D     D ",
				" D     D ",
				"DDDDDDDDD",
				"         ")
			.aisle(
				" G G G G ",
				" G G G G ",
				"DDDDDDDDD",
				"DDDDBDDDD",
				"DDDDDDDDD",
				"         ",
				"         ")
            .where("S", IBlockInfo.controller(loc))
            .where("I", MetaTileEntities.ITEM_IMPORT_BUS[3], IFacing.west())
            .where("F", MetaTileEntities.FLUID_IMPORT_HATCH[3], IFacing.north())
			.where("B", MetaTileEntities.FLUID_EXPORT_HATCH[3], IFacing.south())
            .where("O", MetaTileEntities.ITEM_EXPORT_BUS[3], IFacing.east())
            .where("E", MetaTileEntities.ENERGY_INPUT_HATCH[3], IFacing.up())
			.where("D", <contenttweaker:vacuum_casing>)
			.where("G", <ore:frameGtSteel>.firstItem)
			.where("Y", <ore:frameGtStainlessSteel>.firstItem)
			.where("V", <metastate:chisel:technical1:3>)
			.where("C", <metastate:gtadditions:ga_conveyor_casing:0>)
            .where(" ", IBlockInfo.EMPTY)
            .build())
    .clearTooltips(true)
    .withRecipeMap(
        FactoryRecipeMap.start(loc)
		    .minInputs(1)
		    .maxInputs(9)
		    .minOutputs(1)
		    .maxOutputs(9)
		    .maxFluidInputs(1)
			.maxFluidOutputs(1)
		    .build())
    .buildAndRegister();

recipes.addShaped(
    <gregtech:machine:20004>,
    [
        [pumps[3], circuits[4], pumps[3]],
        [pumps[3], hulls[4], pumps[3]],
        [pumps[3], circuits[4], pumps[3]]
    ]	
);