#norun
import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.liquid.ILiquidStack;
import crafttweaker.oredict.IOreDictEntry;

val name_removals as string[] = [
	"advancedrocketry:unpackblocktin",
	"advancedrocketry:unpackblockcopper",
	"advancedrocketry:unpackblocksilicon",
	"advancedrocketry:unpackblocksteel",
	"advancedrocketry:unpackblocktitanium",
	"advancedrocketry:unpackblockaluminum",
	"advancedrocketry:unpackblockiridium",
	"advancedrocketry:unpackingottin",
	"advancedrocketry:unpackingotcopper",
	"advancedrocketry:unpackingotsilicon",
	"advancedrocketry:unpackingotsteel",
	"advancedrocketry:unpackingottitanium",
	"advancedrocketry:unpackingotaluminum",
	"advancedrocketry:unpackingotiridium",
	"advancedrocketry:unpacknuggettin",
	"advancedrocketry:unpacknuggetcopper",
	"advancedrocketry:unpacknuggetsilicon",
	"advancedrocketry:unpacknuggetsteel",
	"advancedrocketry:unpacknuggettitanium",
	"advancedrocketry:unpacknuggetaluminum",
	"advancedrocketry:unpacknuggetiridium",
	"advancedrocketry:packblocktin",
	"advancedrocketry:packblockcopper",
	"advancedrocketry:packblocksilicon",
	"advancedrocketry:packblocksteel",
	"advancedrocketry:packblocktitanium",
	"advancedrocketry:packblockaluminum",
	"advancedrocketry:packblockiridium",
	"advancedrocketry:sticktin",
	"advancedrocketry:stickcopper",
	"advancedrocketry:sticksilicon",
	"advancedrocketry:sticksteel",
	"advancedrocketry:sticktitanium",
	"advancedrocketry:stickaluminum",
	"advancedrocketry:stickiridium",
	"advancedrocketry:blockfueltank",
	"advancedrocketry:blockbipropellantfueltank",
	"advancedrocketry:blockoxidizerfueltank",
	"advancedrocketry:engine",
	"advancedrocketry:bipropellantengine"
];

for item in name_removals {
	recipes.removeByRecipeName(item);
}

//--------------------------HEAT SHIELD------------------------

pyrolyse_oven.recipeBuilder()
.inputs([<metaitem:carbon.fibers> * 2, <metaitem:dustCoke> * 4])
.outputs(<contenttweaker:unprepared_heat_shield>)
.duration(1200)
.EUt(64)
.buildAndRegister();

chemical_bath.recipeBuilder()
.inputs([<contenttweaker:unprepared_heat_shield>])
.fluidInputs([<liquid:acetylene> * 250])
.outputs(<contenttweaker:heat_shield>)
.duration(1200)
.EUt(64)
.buildAndRegister();

//--------------------------SUPER ALLOY-----------------------------

alloy_blast_smelter.recipeBuilder()
.property("temperature", 4120)
.inputs([<metaitem:dustHafniumCarbide> * 4, <metaitem:dustRhenium> * 1, <metaitem:dustTantalumCarbide> * 4, <metaitem:dustHastelloyX> * 16])
.fluidOutputs([<liquid:extreme> * 3600])
.duration(2000)
.EUt(360)
.buildAndRegister();

//----------------------------ROCKET PARTS-----------------------------

//THIS IS UNFINISHED, MAKE RECIPES MORE COMPLICATED LATER

assembler.recipeBuilder()
.circuit(0)
.inputs([<metaitem:plateExtreme> * 5, <contenttweaker:heat_shield> * 4])
.fluidInputs([<liquid:soldering_alloy> * 288])
.outputs(<advancedrocketry:rocketmotor>)
.duration(200)
.EUt(192)
.buildAndRegister();

assembler.recipeBuilder()
.circuit(1)
.inputs([<metaitem:plateExtreme> * 5, <contenttweaker:heat_shield> * 4])
.fluidInputs([<liquid:soldering_alloy> * 288])
.outputs(<advancedrocketry:bipropellantrocketmotor>)
.duration(200)
.EUt(192)
.buildAndRegister();

assembler.recipeBuilder()
.circuit(0)
.inputs([<metaitem:drum.stainless_steel>, <contenttweaker:heat_shield> * 6])
.fluidInputs([<liquid:soldering_alloy> * 288])
.outputs(<advancedrocketry:bipropellantfueltank>)
.duration(200)
.EUt(192)
.buildAndRegister();

assembler.recipeBuilder()
.circuit(1)
.inputs([<metaitem:drum.stainless_steel>, <contenttweaker:heat_shield> * 6])
.fluidInputs([<liquid:soldering_alloy> * 288])
.outputs(<advancedrocketry:fueltank>)
.duration(200)
.EUt(192)
.buildAndRegister();

assembler.recipeBuilder()
.circuit(2)
.inputs([<metaitem:drum.stainless_steel>, <contenttweaker:heat_shield> * 6])
.fluidInputs([<liquid:soldering_alloy> * 288])
.outputs(<advancedrocketry:oxidizerfueltank>)
.duration(200)
.EUt(192)
.buildAndRegister();