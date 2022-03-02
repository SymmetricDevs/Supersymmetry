#norun
import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.liquid.ILiquidStack;
import crafttweaker.oredict.IOreDictEntry;

val name_removals as string[] = [
	"immersiveposts:recipes/fence_iron",
	"immersiveposts:recipes/fence_gold",
	"immersiveposts:recipes/fence_copper",
	"immersiveposts:recipes/fence_lead",
	"immersiveposts:recipes/fence_silver",
	"immersiveposts:recipes/fence_nickel",
	"immersiveposts:recipes/fence_constantan",
	"immersiveposts:recipes/fence_electrum",
	"immersiveposts:recipes/fence_uranium",
	"immersiveposts:recipes/metal_rods/stick_gold",
	"immersiveposts:recipes/metal_rods/stick_copper",
	"immersiveposts:recipes/metal_rods/stick_lead",
	"immersiveposts:recipes/metal_rods/stick_silver",
	"immersiveposts:recipes/metal_rods/stick_nickel",
	"immersiveposts:recipes/metal_rods/stick_constantan",
	"immersiveposts:recipes/metal_rods/stick_electrum",
	"immersiveposts:recipes/metal_rods/stick_uranium"
];

for item in name_removals {
	recipes.removeByRecipeName(item);
}

val FenceMap as IItemStack[IOreDictEntry] = {
	<ore:stickIron> : <immersiveposts:fence_iron>,
	<ore:stickGold> : <immersiveposts:fence_gold>,
	<ore:stickCopper> : <immersiveposts:fence_copper>,
	<ore:stickLead> : <immersiveposts:fence_lead>,
	<ore:stickSilver> : <immersiveposts:fence_silver>,
	<ore:stickNickel> : <immersiveposts:fence_nickel>,
	<ore:stickCupronickel> : <immersiveposts:fence_constantan>,
	<ore:stickElectrum> : <immersiveposts:fence_electrum>,
	<ore:stickUranium> : <immersiveposts:fence_uranium>
};

val NameMap as string[IOreDictEntry] = {
	<ore:stickIron> : "posts_iron",
	<ore:stickGold> : "posts_gold",
	<ore:stickCopper> : "posts_copper",
	<ore:stickLead> : "posts_lead",
	<ore:stickSilver> : "posts_silver",
	<ore:stickNickel> : "posts_nickel",
	<ore:stickConstantan> : "posts_constantan",
	<ore:stickElectrum> : "posts_electrum",
	<ore:stickUranium> : "posts_uranium"
};

for key in FenceMap {
	recipes.addShaped(NameMap[key], FenceMap[key], [
		[<ore:gregSaws>, <ore:gregWrenches>, <ore:gregFiles>],
		[key, key, key],
		[key, key, key]
	]);
}