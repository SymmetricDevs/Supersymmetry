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

var loc = "railroad_engineering_station";
var meta = 20000; // Choose something that won't conflict. You'll get a warning in the crafttweaker logs if something goes wrong.

var railroad_engineering_station = Builder.start(loc, meta)
    .withPattern(
        FactoryBlockPattern.start(RelativeDirection.RIGHT, RelativeDirection.UP, RelativeDirection.BACK)
            .aisle("CGGGGGGGC", "CCCCCCCCC", "CCCCCCCCC")
            .aisle("CCCCCCCCC", "C       C", "CCCCCCCCC")
            .aisle("CGGGGGGGC", "CSCCCCCCC", "CCCCCCCCC")
            .whereOr("C",
                <metastate:gregtech:metal_casing_steel:0>,
                IBlockMatcher.abilityPartPredicate(
                    MultiblockAbility.INPUT_ENERGY,
                    MultiblockAbility.IMPORT_ITEMS,
                    MultiblockAbility.IMPORT_FLUIDS,
                    MultiblockAbility.EXPORT_ITEMS
                ))
            .where("S", IBlockMatcher.controller(loc))
            .where(" ", IBlockMatcher.ANY)
			.where("G", <ore:frameGtSteel>.firstItem)
            .build())
    .addDesign(
        FactoryMultiblockShapeInfo.start()
			.aisle(
				"ICC",
				"ECC",
				"FCC")
			.aisle(
				"GCG",
				"S C",
				"CCC")
			.aisle(
				"GCG",
				"C C",
				"CCC")
			.aisle(
				"GCG",
				"C C",
				"CCC")
			.aisle(
				"GCG",
				"C C",
				"CCC")
			.aisle(
				"GCG",
				"C C",
				"CCC")
			.aisle(
				"GCG",
				"C C",
				"CCC")
			.aisle(
				"GCG",
				"C C",
				"CCC")
			.aisle(
				"CCC",
				"OCC",
				"CCC")
            .where("C", <metastate:gregtech:metal_casing_steel:0>)
            .where("S", IBlockInfo.controller(loc))
            .where("I", MetaTileEntities.ITEM_IMPORT_BUS[2], IFacing.west())
            .where("F", MetaTileEntities.FLUID_IMPORT_HATCH[2], IFacing.west())
            .where("O", MetaTileEntities.ITEM_EXPORT_BUS[2], IFacing.west())
            .where("E", MetaTileEntities.ENERGY_INPUT_HATCH[2], IFacing.west())
			.where("G", <ore:frameGtSteel>.firstItem)
            .where(" ", IBlockInfo.EMPTY)
            .build())
    .clearTooltips(true)
    .withRecipeMap(
        FactoryRecipeMap.start(loc)
		    .minInputs(1)
		    .maxInputs(2)
		    .minOutputs(1)
		    .maxOutputs(18)
		    .maxFluidInputs(1)
		    .build())
    .buildAndRegister();

recipes.addShaped(
    <gregtech:machine:20000>,
    [
        [motors[2], circuits[2], motors[2]],
        [robotArms[2], hulls[2], robotArms[2]],
        [motors[2], circuits[2], motors[2]]
    ]
);


<multiblock:multiblocktweaker:railroad_engineering_station>.recipeMap.recipeBuilder()
    .duration(5)
    .EUt(60)
    .notConsumable(intCircuit(0))
    .fluidInputs(<liquid:steel> * 288)
    .outputs(<immersiverailroading:item_rail_part>*16)
    .buildAndRegister();
	
<multiblock:multiblocktweaker:railroad_engineering_station>.recipeMap.recipeBuilder()
    .duration(5)
    .EUt(60)
    .inputs(<ore:stickWood>)
    .fluidInputs(<liquid:iron> * 144)
    .outputs(<minecraft:rail>)
    .buildAndRegister();
	
<multiblock:multiblocktweaker:railroad_engineering_station>.recipeMap.recipeBuilder()
    .duration(5)
    .EUt(60)
    .inputs(<ore:wireFineRedAlloy>)
	.inputs(<ore:stickWood>)
    .fluidInputs(<liquid:gold> * 144)
    .outputs(<minecraft:golden_rail>)
    .buildAndRegister();
	
<multiblock:multiblocktweaker:railroad_engineering_station>.recipeMap.recipeBuilder()
    .duration(5)
    .EUt(60)
    .inputs(<ore:wireFineRedAlloy>)
	.inputs(<minecraft:stone_pressure_plate>)
    .fluidInputs(<liquid:iron> * 144)
    .outputs(<minecraft:detector_rail>)
    .buildAndRegister();
	
<multiblock:multiblocktweaker:railroad_engineering_station>.recipeMap.recipeBuilder()
    .duration(5)
    .EUt(60)
    .inputs(<ore:stickWood> * 2)
	.inputs(<minecraft:redstone_torch>)
    .fluidInputs(<liquid:iron> * 144)
    .outputs(<minecraft:activator_rail>)
    .buildAndRegister();
	
<multiblock:multiblocktweaker:railroad_engineering_station>.recipeMap.recipeBuilder()
    .duration(5)
    .EUt(60)
    .inputs(<ore:wireFineRedAlloy>)
	.inputs(<minecraft:piston>)
    .fluidInputs(<liquid:iron> * 144)
    .outputs(<enderio:block_exit_rail>)
    .buildAndRegister();
	
<multiblock:multiblocktweaker:railroad_engineering_station>.recipeMap.recipeBuilder()
    .duration(5)
    .EUt(60)
    .inputs(<ore:ringIron>*4)
	.inputs(<ore:stickIron>*2)
    .fluidInputs(<liquid:iron> * 576)
    .outputs(<minecraft:minecart>)
    .buildAndRegister();
