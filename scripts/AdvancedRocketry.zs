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
	"advancedrocketry:stickiridium"
];

for item in name_removals {
	recipes.removeByRecipeName(item);
}