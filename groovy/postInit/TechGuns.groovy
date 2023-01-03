import techguns.items.guns.GenericGun;
import techguns.plugins.crafttweaker.GunStatTweaker;

def circuit(x) {
	return metaitem('circuit.integrated').withNbt([Configuration: x])
}

println("Running TechGuns.groovy...")

ArrayList<String> name_removals = [
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

for (item in name_removals) {
	crafting.remove(item);
}

crafting.addShaped("stone_barrel", item('techguns:itemshared:37'), [
		[null, ore('craftingToolFile'), null],
		[ore('craftingToolScrewdriver'), ore('stone'), ore('craftingToolHardHammer')]
]);

crafting.addShaped("wood_stock", item('techguns:itemshared:42'), [
		[ore('plankWood'), ore('plankWood'), null],
		[ore('craftingToolSaw'), ore('plankWood'), ore('craftingToolFile')]
]);

crafting.addShaped("stone_bullets", item('techguns:itemshared:0')*16, [
		[ore('rock'), ore('rock'), null],
		[ore('rock'), ore('dustGunpowder'), null]
]);

crafting.addShaped("iron_barrel", item('techguns:itemshared:38'), [
		[null, ore('craftingToolFile'), null],
		[ore('craftingToolScrewdriver'), ore('stickIron'), ore('craftingToolHardHammer')]
]);

crafting.addShaped("techguns_revolver", item('techguns:revolver'), [
		[ore('craftingToolScrewdriver'), ore('craftingToolWrench'), ore('craftingToolFile')],
		[item('techguns:itemshared:37'), ore('plateSteel'), ore('boltSteel')],
		[null, ore('plateSteel'), item('techguns:itemshared:42')]
]);

crafting.addShaped("techguns_boltaction", item('techguns:boltaction'), [
		[ore('craftingToolScrewdriver'), ore('craftingToolWrench'), ore('craftingToolFile')],
		[ore('blockGlassColorless'), ore('plateIron'), null],
		[item('techguns:itemshared:39'), item('techguns:itemshared:33'), item('techguns:itemshared:42')]
]);

crafting.addShaped("heavy_cloth", item('techguns:itemshared:60')*3, [
		[ore('leather'), ore('leather'), ore('leather')],
		[ore('wireFineSteel'), ore('wireFineSteel'), ore('wireFineSteel')],
		[ore('leather'), ore('leather'), ore('leather')]
]);

crafting.addShaped("steel_barrel", item('techguns:itemshared:39'), [
		[null, ore('craftingToolFile'), null],
		[ore('craftingToolScrewdriver'), ore('stickLongSteel'), ore('craftingToolHardHammer')]
]);

crafting.addShaped("techguns_iron_receiver", item('techguns:itemshared:33'), [
		[ore('plateIron'), ore('plateIron'), ore('plateIron')],
		[ore('craftingToolScrewdriver'), ore('boltIron'), ore('stickIron')],
		[null, ore('screwIron'), ore('screwIron')]
]);

crafting.addShaped("tg_soldier_helmet", item('techguns:t1_combat_helmet'), [
		[ore('plateIron'), ore('plateIron'), ore('plateIron')],
		[item('techguns:itemshared:60'), ore('craftingToolHardHammer'), item('techguns:itemshared:60')]
]);

crafting.addShaped("tg_soldier_chestplate", item('techguns:t1_combat_chestplate'), [
		[item('techguns:itemshared:60'), ore('craftingToolHardHammer'), item('techguns:itemshared:60')],
		[ore('plateIron'), ore('plateIron'), ore('plateIron')],
		[item('techguns:itemshared:60'), item('techguns:itemshared:60'), item('techguns:itemshared:60')]
]);

crafting.addShaped("tg_soldier_leggings", item('techguns:t1_combat_leggings'), [
		[ore('plateIron'), ore('plateIron'), ore('plateIron')],
		[item('techguns:itemshared:60'), ore('craftingToolHardHammer'), item('techguns:itemshared:60')],
		[item('techguns:itemshared:60'), null, item('techguns:itemshared:60')]
]);

crafting.addShaped("tg_soldier_boots", item('techguns:t1_combat_boots'), [
		[item('techguns:itemshared:60'), null, item('techguns:itemshared:60')],
		[ore('plateIron'), ore('craftingToolHardHammer'), ore('plateIron')]
]);

crafting.addShaped("tg_combat_helmet", item('techguns:t2_combat_helmet'), [
		[ore('plateSteel'), ore('plateSteel'), ore('plateSteel')],
		[item('techguns:itemshared:60'), ore('craftingToolHardHammer'), item('techguns:itemshared:60')]
]);

crafting.addShaped("tg_combat_chestplate", item('techguns:t2_combat_chestplate'), [
		[item('techguns:itemshared:60'), ore('craftingToolHardHammer'), item('techguns:itemshared:60')],
		[ore('plateSteel'), ore('plateSteel'), ore('plateSteel')],
		[item('techguns:itemshared:60'), item('techguns:itemshared:60'), item('techguns:itemshared:60')]
]);

crafting.addShaped("tg_combat_leggings", item('techguns:t2_combat_leggings'), [
		[ore('plateSteel'), ore('plateSteel'), ore('plateSteel')],
		[item('techguns:itemshared:60'), ore('craftingToolHardHammer'), item('techguns:itemshared:60')],
		[item('techguns:itemshared:60'), null, item('techguns:itemshared:60')]
]);

crafting.addShaped("tg_combat_boots", item('techguns:t2_combat_boots'), [
		[item('techguns:itemshared:60'), null, item('techguns:itemshared:60')],
		[ore('plateSteel'), ore('craftingToolHardHammer'), ore('plateSteel')]
]);

crafting.addShaped("tg_pistol_rounds", item('techguns:itemshared:1')*12, [
		[null, ore('craftingToolHardHammer'), null],
		[null, ore('roundLead'), null],
		[ore('plateBrass'), ore('dustGunpowder'), ore('plateBrass')]
]);

crafting.addShaped("tg_glider_backpack", item('techguns:itemshared:90'), [
		[item('techguns:itemshared:60'), item('techguns:itemshared:60'), item('techguns:itemshared:60')],
		[ore('boltAluminium'), ore('plateAluminium'), ore('boltAluminium')],
		[item('techguns:itemshared:60'), item('techguns:itemshared:60'), item('techguns:itemshared:60')]
]);

crafting.addShaped("tg_glider_wing", item('techguns:itemshared:91'), [
		[ore('stickAluminium'), ore('stickAluminium'), ore('stickAluminium')],
		[ore('platePlastic'), ore('platePlastic'), ore('platePlastic')],
		[ore('platePlastic'), ore('platePlastic'), ore('platePlastic')]
]);


//--------------------Weapons Factory recipes--------------------
recipemap('weapons_factory').recipeBuilder()
		.inputs([ore('plateSteel')*3,
				 ore('stickSteel'),
				 ore('screwSteel'),
				 ore('boltSteel')
		])
		.outputs(item('techguns:itemshared:34'))
		.duration(80)
		.EUt(20)
		.buildAndRegister();

recipemap('weapons_factory').recipeBuilder()
		.inputs([ore('plateSteel'),
				 ore('springSmallSteel'),
				 ore('gearSmallSteel'),
				 item('techguns:itemshared:39'),
				 ore('plateRubber')*2,
				 item('techguns:itemshared:11')
		])
		.outputs(item('techguns:pistol'))
		.duration(300)
		.EUt(30)
		.buildAndRegister();

recipemap('weapons_factory').recipeBuilder()
		.inputs([ore('plateSteel'),
				 ore('springSmallSteel')*4
		])
		.notConsumable(circuit(1))
		.outputs(item('techguns:itemshared:12')*4)
		.duration(10)
		.EUt(16)
		.buildAndRegister();

recipemap('weapons_factory').recipeBuilder()
		.inputs([ore('plateBrass'),
				 ore('gunpowder'),
				 ore('roundLead')
		])
		.outputs(item('techguns:itemshared:1')*12)
		.duration(10)
		.EUt(16)
		.buildAndRegister();

recipemap('weapons_factory').recipeBuilder()
		.inputs([item('techguns:itemshared:39'),
				 item('techguns:itemshared:34'),
				 item('techguns:itemshared:43'),
				 item('techguns:itemshared:2')
		])
		.outputs(item('techguns:combatshotgun'))
		.duration(400)
		.EUt(30)
		.buildAndRegister();

recipemap('weapons_factory').recipeBuilder()
		.inputs(ore('platePlastic')*4)
		.outputs(item('techguns:itemshared:43'))
		.duration(200)
		.EUt(30)
		.buildAndRegister();

recipemap('weapons_factory').recipeBuilder()
		.inputs([ore('plateBrass'),
				 ore('gunpowder'),
				 ore('roundLead')*4
		])
		.outputs(item('techguns:itemshared:2')*6)
		.duration(10)
		.EUt(16)
		.buildAndRegister();

recipemap('weapons_factory').recipeBuilder()
		.inputs([ore('plateCupronickel'),
				 ore('dustGunpowder'),
				 ore('roundLead')
		])
		.outputs(item('techguns:itemshared:3')*8)
		.duration(10)
		.EUt(16)
		.buildAndRegister();

recipemap('weapons_factory').recipeBuilder()
		.inputs([
				ore('springSmallSteel')*4,
				ore('plateSteel')
		])
		.notConsumable(circuit(2))
		.outputs(item('techguns:itemshared:10')*4)
		.duration(20)
		.EUt(60)
		.buildAndRegister();

recipemap('weapons_factory').recipeBuilder()
		.inputs([
				ore('springSmallSteel')*4,
				ore('plateSteel')
		])
		.notConsumable(circuit(3))
		.outputs(item('techguns:itemshared:14')*4)
		.duration(20)
		.EUt(60)
		.buildAndRegister();

recipemap('weapons_factory').recipeBuilder()
		.inputs([
				item('techguns:itemshared:39'),
				item('techguns:itemshared:34'),
				item('techguns:itemshared:42'),
				item('techguns:itemshared:9')
		])
		.outputs(item('techguns:thompson'))
		.duration(200)
		.EUt(60)
		.buildAndRegister();

recipemap('weapons_factory').recipeBuilder()
		.inputs([
				item('techguns:itemshared:39'),
				item('techguns:itemshared:34'),
				item('techguns:itemshared:42'),
				item('techguns:itemshared:13'),
				ore('plateWood')
		])
		.outputs(item('techguns:ak47'))
		.duration(200)
		.EUt(60)
		.buildAndRegister();

recipemap('weapons_factory').recipeBuilder()
		.inputs([
				item('techguns:itemshared:39'),
				item('techguns:itemshared:34'),
				item('techguns:itemshared:43'),
				item('techguns:itemshared:13'),
				ore('plateSteel'),
				ore('lensGlass')
		])
		.outputs(item('techguns:m4'))
		.duration(200)
		.EUt(60)
		.buildAndRegister();

recipemap('weapons_factory').recipeBuilder()
		.inputs([
				item('techguns:itemshared:39'),
				item('techguns:itemshared:34'),
				item('techguns:itemshared:9'),
				ore('platePlastic')
		])
		.outputs(item('techguns:mac10'))
		.duration(200)
		.EUt(60)
		.buildAndRegister();

//--------------------GregTech machines only recipes--------------------

recipemap('forming_press').recipeBuilder()
		.inputs([item('minecraft:leather') * 2,
				 ore('wireFineSteel') * 1
		])
		.outputs(item('techguns:itemshared:60'))
		.duration(40)
		.EUt(16)
		.buildAndRegister();

recipemap('forming_press').recipeBuilder()
		.inputs([metaitem('foilSteel'), item('techguns:itemshared:38')])
		.outputs(item('techguns:itemshared:39'))
		.duration(30)
		.EUt(30)
		.buildAndRegister();


//-------------------Change TechGuns damage values to be better suited with SUSy progression----------------

//Taken from Techguns2 source code for crafttweaker integration

//Double Barrel Shotgun
GunStatTweaker.setWeaponStat("sawedoff","DAMAGE",1.5);
GunStatTweaker.setWeaponStat("sawedoff","DAMAGE_MIN",1.2);

//Handcannon
GunStatTweaker.setWeaponStat("handcannon","DAMAGE",8.0);
GunStatTweaker.setWeaponStat("handcannon","DAMAGE_MIN",6.0);

//Revolver
GunStatTweaker.setWeaponStat("revolver","DAMAGE",10.0);
GunStatTweaker.setWeaponStat("revolver","DAMAGE_MIN",7.5);

//Combat Shotgun
GunStatTweaker.setWeaponStat("combatshotgun","DAMAGE",3.0);
GunStatTweaker.setWeaponStat("combatshotgun","DAMAGE_MIN",2.4);

//Pistol
GunStatTweaker.setWeaponStat("pistol","DAMAGE",20.0);
GunStatTweaker.setWeaponStat("pistol","DAMAGE_MIN",16.0);

//Mac-10
GunStatTweaker.setWeaponStat("mac10","DAMAGE",32.0);
GunStatTweaker.setWeaponStat("mac10","DAMAGE_MIN",28.0);

//M4 assault rifle
GunStatTweaker.setWeaponStat("m4","DAMAGE",36.0);
GunStatTweaker.setWeaponStat("m4","DAMAGE_MIN",30.0);

//Thompson SMG
GunStatTweaker.setWeaponStat("thompson","DAMAGE",45.0);
GunStatTweaker.setWeaponStat("thompson","DAMAGE_MIN",40.0);

//AK47
GunStatTweaker.setWeaponStat("thompson","DAMAGE",40.0);
GunStatTweaker.setWeaponStat("thompson","DAMAGE_MIN",36.0);
