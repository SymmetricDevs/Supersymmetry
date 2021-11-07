import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.liquid.ILiquidStack;
import crafttweaker.oredict.IOreDictEntry;


val name_removals as string[] = [
		"immersiveengineering:tool/revolver",
		"immersiveengineering:metal_devices/tesla_coil",
		"techguns:itemshared_38_ironbarrel",
		"techguns:revolver",
		"techguns:goldenrevolver",
		"techguns:boltaction",
		"techguns:itemshared_39_obsidiansteelbarrel",
		"techguns:itemshared_33_ironreceiver",
		"techguns:itemshared_37_stonebarrel",
		"techguns:itemshared_42_woodstock",
		"techguns:itemshared_0_stonebullets",
		"techguns:itemshared_34_steelreceiver",
		"techguns:pistol_alt",
		"techguns:pistol",
		"techguns:itemshared_10_smgmagazineempty",
		"techguns:itemshared_12_pistolmagazineempty",
		"techguns:itemshared_14_assaultriflemagazineempty",
		"techguns:itemshared_1_pistolrounds",
		"techguns:combatshotgun",
		"techguns:itemshared_2_shotgunrounds",
		"techguns:itemshared_65_circuitboard",
		"techguns:itemshared_66_circuitboardelite",
		"techguns:itemshared_90_gliderbackpack",
		"techguns:itemshared_91_gliderwing",
		"techguns:basicmachine_0_ammo_press",
		"techguns:basicmachine_1_metal_press",
		"techguns:basicmachine_1_metal_press_alt",
		"techguns:basicmachine_2_chem_lab",
		"techguns:basicmachine_3_turret",
		"techguns:simplemachine_10_charging_station",
		"techguns:simplemachine_11_blast_furnace",
		"techguns:simplemachine2_8_grinder",
		"techguns:simplemachine2_9_armor_bench",
		"techguns:multiblockmachine_0_fabricator_housing",
		"techguns:multiblockmachine_1_fabricator_glass",
		"techguns:multiblockmachine_2_fabricator_controller",
		"techguns:multiblockmachine_3_reactionchamber_housing",
		"techguns:multiblockmachine_4_reactionchamber_glass",
		"techguns:multiblockmachine_5_fabricator_controller",
		"techguns:itemshared_60_heavycloth",
		"techguns:t1_combat_helmet",
		"techguns:t1_combat_chestplate",
		"techguns:t1_combat_leggings",
		"techguns:t1_combat_boots",
		"techguns:t2_combat_helmet",
		"techguns:t2_combat_chestplate",
		"techguns:t2_combat_leggings",
		"techguns:t2_combat_boots",
		"techguns:thompson_alt",
		"techguns:thompson",
		"techguns:ak47_alt",
		"techguns:ak47",
		"techguns:m4_alt",
		"techguns:m4",
		"techguns:mac10_alt",
		"techguns:mac10"
];

for item in name_removals {
	recipes.removeByRecipeName(item);
}

recipes.addShaped("stone_barrel", <techguns:itemshared:37>, [
	[null, <ore:gregFiles>, null],
	[<ore:gregScrewDrivers>, <ore:stone>, <ore:gregHardHammers>],
	[null, null, null]
]);

recipes.addShaped("wood_stock", <techguns:itemshared:42>, [
	[<ore:plankWood>, <ore:plankWood>, null],
	[<ore:gregSaws>, <ore:plankWood>, <ore:gregFiles>],
	[null, null, null]
]);

recipes.addShaped("stone_bullets", <techguns:itemshared:0>*16, [
	[<ore:rock>, <ore:rock>, null],
	[<ore:rock>, <ore:dustGunpowder>, null],
	[null, null, null]
]);

recipes.addShaped("ie_revolver", <immersiveengineering:revolver>, [
	[<ore:gregScrewDrivers>, <ore:gregWrenches>, <ore:gregFiles>],
	[<immersiveengineering:material:14>, <immersiveengineering:material:15>, <immersiveengineering:material:16>],
	[null, <ore:plateSteel>, <immersiveengineering:material:13>]
]);

recipes.addShaped("ie_tesla_coil", <immersiveengineering:metal_device1:8>, [
	[<ore:plateCurvedSteel>, <ore:plateCurvedSteel>, <ore:plateCurvedSteel>],
	[<ore:gregScrewDrivers>, <ore:coilCopper>, <ore:gregWrenches>],
	[<immersiveengineering:connector:8>, <ore:coilCopper>, <immersiveengineering:metal_device0:2>]
]);

recipes.addShaped("iron_barrel", <techguns:itemshared:38>, [
	[null, <ore:gregFiles>, null],
	[<ore:gregScrewDrivers>, <ore:stickIron>, <ore:gregHardHammers>],
	[null, null, null]
]);

recipes.addShaped("techguns_revolver", <techguns:revolver>, [
	[<ore:gregScrewDrivers>, <ore:gregWrenches>, <ore:gregFiles>],
	[<techguns:itemshared:37>, <immersiveengineering:material:15>, <immersiveengineering:material:16>],
	[null, <ore:plateSteel>, <techguns:itemshared:42>]
]);

recipes.addShaped("techguns_boltaction", <techguns:boltaction>, [
	[<ore:gregScrewDrivers>, <ore:gregWrenches>, <ore:gregFiles>],
	[<ore:blockGlassColorless>, <ore:plateCurvedIron>, null],
	[<techguns:itemshared:39>, <techguns:itemshared:33>, <techguns:itemshared:42>]
]);

recipes.addShaped("heavy_cloth", <techguns:itemshared:60>*3, [
	[<ore:fabricHemp>, <ore:fabricHemp>, <ore:fabricHemp>],
	[<ore:wireFineSteel>, <ore:wireFineSteel>, <ore:wireFineSteel>],
	[<ore:fabricHemp>, <ore:fabricHemp>, <ore:fabricHemp>]
]);

recipes.addShaped("steel_barrel", <techguns:itemshared:39>, [
	[null, <ore:gregFiles>, null],
	[<ore:gregScrewDrivers>, <ore:stickLongSteel>, <ore:gregHardHammers>],
	[null, null, null]
]);

recipes.addShaped("techguns_iron_receiver", <techguns:itemshared:33>, [
	[<ore:plateIron>, <ore:plateIron>, <ore:plateIron>],
	[<ore:gregScrewDrivers>, <ore:boltIron>, <ore:stickIron>],
	[null, <ore:screwIron>, <ore:screwIron>]
]);

recipes.addShaped("tg_soldier_helmet", <techguns:t1_combat_helmet>, [
	[null, null, null],
	[<ore:plateIron>, <ore:plateIron>, <ore:plateIron>],
	[<techguns:itemshared:60>, <ore:gregHardHammers>, <techguns:itemshared:60>]
]);

recipes.addShaped("tg_soldier_chestplate", <techguns:t1_combat_chestplate>, [
	[<techguns:itemshared:60>, <ore:gregHardHammers>, <techguns:itemshared:60>],
	[<ore:plateIron>, <ore:plateIron>, <ore:plateIron>],
	[<techguns:itemshared:60>, <techguns:itemshared:60>, <techguns:itemshared:60>]
]);

recipes.addShaped("tg_soldier_leggings", <techguns:t1_combat_leggings>, [
	[<ore:plateIron>, <ore:plateIron>, <ore:plateIron>],
	[<techguns:itemshared:60>, <ore:gregHardHammers>, <techguns:itemshared:60>],
	[<techguns:itemshared:60>, null, <techguns:itemshared:60>]
]);

recipes.addShaped("tg_soldier_boots", <techguns:t1_combat_boots>, [
	[null, null, null],
	[<techguns:itemshared:60>, null, <techguns:itemshared:60>],
	[<ore:plateIron>, <ore:gregHardHammers>, <ore:plateIron>]
]);

recipes.addShaped("tg_combat_helmet", <techguns:t2_combat_helmet>, [
	[null, null, null],
	[<ore:plateSteel>, <ore:plateSteel>, <ore:plateSteel>],
	[<techguns:itemshared:60>, <ore:gregHardHammers>, <techguns:itemshared:60>]
]);

recipes.addShaped("tg_combat_chestplate", <techguns:t2_combat_chestplate>, [
	[<techguns:itemshared:60>, <ore:gregHardHammers>, <techguns:itemshared:60>],
	[<ore:plateSteel>, <ore:plateSteel>, <ore:plateSteel>],
	[<techguns:itemshared:60>, <techguns:itemshared:60>, <techguns:itemshared:60>]
]);

recipes.addShaped("tg_combat_leggings", <techguns:t2_combat_leggings>, [
	[<ore:plateSteel>, <ore:plateSteel>, <ore:plateSteel>],
	[<techguns:itemshared:60>, <ore:gregHardHammers>, <techguns:itemshared:60>],
	[<techguns:itemshared:60>, null, <techguns:itemshared:60>]
]);

recipes.addShaped("tg_combat_boots", <techguns:t2_combat_boots>, [
	[null, null, null],
	[<techguns:itemshared:60>, null, <techguns:itemshared:60>],
	[<ore:plateSteel>, <ore:gregHardHammers>, <ore:plateSteel>]
]);

recipes.addShaped("tg_pistol_rounds", <techguns:itemshared:1>*12, [
	[null, <ore:gregHardHammers>, null],
	[null, <ore:roundLead>, null],
	[<ore:plateCurvedBrass>, <ore:dustGunpowder>, <ore:plateCurvedBrass>]
]);

recipes.addShaped("tg_glider_backpack", <techguns:itemshared:90>, [
	[<techguns:itemshared:60>, <techguns:itemshared:60>, <techguns:itemshared:60>],
	[<ore:boltAluminium>, <ore:plateAluminium>, <ore:boltAluminium>],
	[<techguns:itemshared:60>, <techguns:itemshared:60>, <techguns:itemshared:60>]
]);

recipes.addShaped("tg_glider_wing", <techguns:itemshared:91>, [
	[<ore:stickAluminium>, <ore:stickAluminium>, <ore:stickAluminium>],
	[<ore:platePlastic>, <ore:platePlastic>, <ore:platePlastic>],
	[<ore:platePlastic>, <ore:platePlastic>, <ore:platePlastic>]
]);


//--------------------Weapons Factory recipes--------------------
weapons_factory.recipeBuilder()
	.inputs([<ore:plateSteel>*3,
			<ore:stickSteel>,
			<ore:screwSteel>,
			<ore:boltSteel>
		])
	.outputs(<techguns:itemshared:34>)
	.duration(80)
	.EUt(20)
	.buildAndRegister();
	
weapons_factory.recipeBuilder()
	.inputs([<ore:plateSteel>,
			<ore:springSmallSteel>,
			<ore:gearSmallSteel>,
			<techguns:itemshared:39>,
			<ore:plateRubber>*2,
			<techguns:itemshared:11>
		])
	.outputs(<techguns:pistol>)
	.duration(300)
	.EUt(30)
	.buildAndRegister();
	
weapons_factory.recipeBuilder()
	.inputs([<ore:plateSteel>, 
			<ore:springSmallSteel>*4
		])
	.notConsumable(intCircuit(1))
	.outputs(<techguns:itemshared:12>*4)
	.duration(10)
	.EUt(16)
	.buildAndRegister();
	
weapons_factory.recipeBuilder()
	.inputs([<ore:plateCurvedBrass>,
			<ore:gunpowder>,
			<ore:roundLead>
		])
	.outputs(<techguns:itemshared:1>*12)
	.duration(10)
	.EUt(16)
	.buildAndRegister();
	
weapons_factory.recipeBuilder()
	.inputs([<techguns:itemshared:39>,
			<techguns:itemshared:34>,
			<techguns:itemshared:43>,
			<techguns:itemshared:2>
		])
	.outputs(<techguns:combatshotgun>)
	.duration(400)
	.EUt(30)
	.buildAndRegister();
	
weapons_factory.recipeBuilder()
	.inputs(<ore:platePlastic>*4)
	.outputs(<techguns:itemshared:43>)
	.duration(200)
	.EUt(30)
	.buildAndRegister();
	
weapons_factory.recipeBuilder()
	.inputs([<ore:plateBrass>,
			<ore:gunpowder>,
			<ore:roundLead>*4
		])
	.outputs(<techguns:itemshared:2>*6)
	.duration(10)
	.EUt(16)
	.buildAndRegister();
	
weapons_factory.recipeBuilder()
	.inputs([<ore:plateCurvedCupronickel>,
			<ore:dustGunpowder>,
			<ore:roundLead>
		])
	.outputs(<techguns:itemshared:3>*8)
	.duration(10)
	.EUt(16)
	.buildAndRegister();
	
weapons_factory.recipeBuilder()
	.inputs([
		<ore:springSmallSteel>*4,
		<ore:plateSteel>
	])
	.notConsumable(intCircuit(2))
	.outputs(<techguns:itemshared:10>*4)
	.duration(20)
	.EUt(60)
	.buildAndRegister();
	
weapons_factory.recipeBuilder()
	.inputs([
		<ore:springSmallSteel>*4,
		<ore:plateSteel>
	])
	.notConsumable(intCircuit(3))
	.outputs(<techguns:itemshared:14>*4)
	.duration(20)
	.EUt(60)
	.buildAndRegister();
	
weapons_factory.recipeBuilder()
	.inputs([
		<techguns:itemshared:39>,
		<techguns:itemshared:34>,
		<techguns:itemshared:42>,
		<techguns:itemshared:9>
	])
	.outputs(<techguns:thompson>)
	.duration(200)
	.EUt(60)
	.buildAndRegister();
	
weapons_factory.recipeBuilder()
	.inputs([
		<techguns:itemshared:39>,
		<techguns:itemshared:34>,
		<techguns:itemshared:42>,
		<techguns:itemshared:13>,
		<ore:plateWood>
	])
	.outputs(<techguns:ak47>)
	.duration(200)
	.EUt(60)
	.buildAndRegister();
	
weapons_factory.recipeBuilder()
	.inputs([
		<techguns:itemshared:39>,
		<techguns:itemshared:34>,
		<techguns:itemshared:43>,
		<techguns:itemshared:13>,
		<ore:plateSteel>,
		<ore:lensGlass>
	])
	.outputs(<techguns:m4>)
	.duration(200)
	.EUt(60)
	.buildAndRegister();
	
weapons_factory.recipeBuilder()
	.inputs([
		<techguns:itemshared:39>,
		<techguns:itemshared:34>,
		<techguns:itemshared:9>,
		<ore:platePlastic>
	])
	.outputs(<techguns:mac10>)
	.duration(200)
	.EUt(60)
	.buildAndRegister();

//--------------------GregTech machines only recipes--------------------

forming_press.recipeBuilder()
	.inputs([<ore:itemLeather>,
			<ore:fabricHemp>
	])
	.outputs(<techguns:itemshared:60>)
	.duration(40)
	.EUt(16)
	.buildAndRegister();

lathe.recipeBuilder()
	.inputs(<ore:stickSteel>)
	.outputs(<techguns:itemshared:39>)
	.duration(30)
	.EUt(30)
	.buildAndRegister();