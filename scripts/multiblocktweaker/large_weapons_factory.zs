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

var loc = "large_weapons_factory";
var meta = 20001; // Choose something that won't conflict. You'll get a warning in the crafttweaker logs if something goes wrong.

var large_weapons_factory = Builder.start(loc, meta)
    .withPattern(
        FactoryBlockPattern.start(RelativeDirection.RIGHT, RelativeDirection.UP, RelativeDirection.BACK)		
			.aisle("GDDDG", " DCD ", " DDD ", "     ")
			.aisle("GDDDG", "GD DG", "GDDDG", "GGGGG")
			.aisle("GDDDG", " V V ", " CCC ", "     ")
			.aisle("GDDDG", "GD DG", "GDDDG", "GGGGG")
			.aisle("GDDDG", " V V ", " CCC ", "     ")
			.aisle("GDDDG", "GD DG", "GDDDG", "GGGGG")
			.aisle("GDDDG", " V V ", " CCC ", "     ")
			.aisle("GDDDG", "GD DG", "GDDDG", "GGGGG")
			.aisle("GDDDG", " V V ", " CCC ", "     ")
			.aisle("GDDDG", "GD DG", "GDDDG", "GGGGG")
			.aisle("GDDDG", " DSD ", " DDD ", "     ")
            .whereOr("C",
                <metastate:gregtech:metal_casing_lead:0>,
                IBlockMatcher.abilityPartPredicate(
                    MultiblockAbility.INPUT_ENERGY,
                    MultiblockAbility.IMPORT_ITEMS,
                    MultiblockAbility.IMPORT_FLUIDS,
                    MultiblockAbility.EXPORT_ITEMS
                ))
			.where("V", <chisel:technical:4>)
			.where("D", <metastate:gregtech:metal_casing_lead:0>)
            .where("S", IBlockMatcher.controller(loc))
            .where(" ", IBlockMatcher.ANY)
			.where("G", <ore:frameGtSteel>.firstItem)
            .build())
    .addDesign(
        FactoryMultiblockShapeInfo.start()
			.aisle(
				"GCCCG",
				" COC ",
				" CCC ",
				"     ")
			.aisle(
				"GCCCG",
				"GC CG",
				"GCCCG",
				"GGGGG")
			.aisle(
				"GCCCG",
				" V V ",
				" IFI ",
				"     ")
			.aisle(
				"GCCCG",
				"GC CG",
				"GCCCG",
				"GGGGG")
			.aisle(
				"GCCCG",
				" V V ",
				" IFI ",
				"     ")
			.aisle(
				"GCCCG",
				"GC CG",
				"GCCCG",
				"GGGGG")
			.aisle(
				"GCCCG",
				" V V ",
				" IFI ",
				"     ")
			.aisle(
				"GCCCG",
				"GC CG",
				"GCCCG",
				"GGGGG")
			.aisle(
				"GCCCG",
				" V V ",
				" IEI ",
				"     ")
			.aisle(
				"GCCCG",
				"GC CG",
				"GCCCG",
				"GGGGG")
			.aisle(
				"GCCCG",
				" CSC ",
				" CCC ",
				"     ")
            .where("C", <metastate:gregtech:metal_casing_lead:0>)
            .where("S", IBlockInfo.controller(loc))
            .where("I", MetaTileEntities.ITEM_IMPORT_BUS[1], IFacing.up())
            .where("F", MetaTileEntities.FLUID_IMPORT_HATCH[1], IFacing.up())
            .where("O", MetaTileEntities.ITEM_EXPORT_BUS[1], IFacing.north())
            .where("E", MetaTileEntities.ENERGY_INPUT_HATCH[1], IFacing.up())
			.where("G", <ore:frameGtSteel>.firstItem)
			.where("V", <chisel:technical:4>)
            .where(" ", IBlockInfo.EMPTY)
            .build())
    .clearTooltips(true)
    .withRecipeMap(
        FactoryRecipeMap.start(loc)
		    .minInputs(1)
		    .maxInputs(9)
		    .minOutputs(1)
		    .maxOutputs(1)
		    .maxFluidInputs(3)
		    .build())
    .buildAndRegister();

recipes.addShaped(
    <gregtech:machine:20001>,
    [
        [conveyors[2], conveyors[2], conveyors[2]],
        [robotArms[2], hulls[2], robotArms[2]],
        [motors[2], circuits[2], motors[2]]
    ]
);

val solidfuels as IOreDictEntry[] = [
	<ore:dustSugar>
];

val solidoxys as IOreDictEntry[] = [
	<ore:dustSaltpeter>
];

val liquidfuels as ILiquidStack[] = [
	<liquid:liquid_hydrogen>,
	<liquid:ethanol>,
	<liquid:rp>
];

val liquidoxys as ILiquidStack[] = [
	<liquid:liquid_oxygen>,
	<liquid:hydrogen_peroxide>,
	<liquid:nitric_acid>
];

for solder in soldering_alloys {
	for s_fuel in solidfuels {
		for s_oxy in solidoxys {
			for i in 0 to 8 {
				<multiblock:multiblocktweaker:large_weapons_factory>.recipeMap.recipeBuilder()
					.inputs([<ore:stickAluminium>*4, 
							<ore:ringAluminium>*2,
							<ore:plateAluminium>*2,
							<ore:plateCurvedAluminium>*4,
							s_oxy*16,
							s_fuel*16,
							<icbmclassic:explosives>.definition.makeStack(i)
						])
					.fluidInputs(solder*576)
					.outputs(<icbmclassic:missile>.definition.makeStack(i))
					.duration(2000)
					.EUt(30)
					.buildAndRegister();
			}
			weapons_factory.recipeBuilder()
				.inputs([
					<ore:plateStainlessSteel>,
					<minecraft:tnt>,
					<ore:wireFineRedAlloy>,
					s_oxy,
					s_fuel
				])
				.fluidInputs(solder*36)
				.outputs(<openmodularturrets:ammo_meta:4>*8)
				.duration(20)
				.EUt(200)
				.buildAndRegister();
		}
		for l_oxy in liquidoxys {
			for j in 8 to 14 {
				<multiblock:multiblocktweaker:large_weapons_factory>.recipeMap.recipeBuilder()
					.inputs([<ore:stickStainlessSteel>*4, 
							<ore:ringStainlessSteel>*2,
							<ore:plateStainlessSteel>*2,
							<ore:plateCurvedStainlessSteel>*4,
							s_fuel*16,
							<icbmclassic:explosives>.definition.makeStack(j)
						])
					.fluidInputs([solder*576, l_oxy*2000])
					.outputs(<icbmclassic:missile>.definition.makeStack(j))
					.duration(200)
					.EUt(120)
					.buildAndRegister();
			}
		}
	}
	for l_fuel in liquidfuels {
		for l_oxy_1 in liquidoxys {
			for k in 16 to 24 {
				<multiblock:multiblocktweaker:large_weapons_factory>.recipeMap.recipeBuilder()
					.inputs([<ore:stickTitanium>*4, 
							<ore:ringTitanium>*2,
							<ore:plateTitanium>*2,
							<ore:plateCurvedTitanium>*4,
							<icbmclassic:explosives>.definition.makeStack(k)
						])
					.fluidInputs([solder*576, l_oxy_1*2000, l_fuel*2000])
					.outputs(<icbmclassic:missile>.definition.makeStack(k))
					.duration(200)
					.EUt(500)
					.buildAndRegister();
			}
		}
	}
}