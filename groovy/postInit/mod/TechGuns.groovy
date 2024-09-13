import globals.Globals
import techguns.items.guns.GenericGun;
import techguns.plugins.crafttweaker.EnumGunStat;

def name_removals = [
	"techguns:basicmachine_0_ammo_press",
	"techguns:basicmachine_1_metal_press_alt",
	"techguns:basicmachine_1_metal_press",
	"techguns:basicmachine_2_chem_lab",
	"techguns:basicmachine_3_turret",
	"techguns:simplemachine2_8_grinder",
	"techguns:simplemachine_11_blast_furnace",
	"techguns:simplemachine_10_charging_station",
	"techguns:multiblockmachine_0_fabricator_housing",
	"techguns:multiblockmachine_1_fabricator_glass",
	"techguns:multiblockmachine_2_fabricator_controller",
	"techguns:multiblockmachine_3_reactionchamber_housing",
	"techguns:multiblockmachine_4_reactionchamber_glass",
	"techguns:multiblockmachine_5_reactionchamber_controller",
	"techguns:oredrill_0_frame",
	"techguns:oredrill_1_scaffold",
	"techguns:oredrill_2_rod",
	"techguns:oredrill_3_engine",
	"techguns:oredrill_4_controller",
	"techguns:itemshared_1_pistolrounds",
	"techguns:itemshared_2_shotgunrounds",
	"techguns:itemshared_7_rocket",
	"techguns:itemshared_10_smgmagazineempty",
	"techguns:itemshared_12_pistolmagazineempty",
	"techguns:itemshared_14_assaultriflemagazineempty",
	"techguns:itemshared_16_lmgmagazineempty",
	"techguns:itemshared_18_minigundrumempty",
	"techguns:itemshared_20_as50magazineempty",
	"techguns:itemshared_22_advancedmagazineempty",
	"techguns:itemshared_26_biotankempty",
	"techguns:itemshared_28_fueltankempty",
	"techguns:itemshared_33_ironreceiver",
	"techguns:itemshared_34_steelreceiver",
	"techguns:itemshared_35_obsidiansteelreceiver",
	"techguns:itemshared_36_carbonreceiver",
	"techguns:itemshared_38_ironbarrel",
	"techguns:itemshared_39_obsidiansteelbarrel",
	"techguns:itemshared_43_plasticstock",
	"techguns:itemshared_61_biomass",
	"techguns:itemshared_62_copperwire",
	"techguns:itemshared_65_circuitboard",
	"techguns:itemshared_66_circuitboardelite",
	"techguns:itemshared_68_coil",
	"techguns:itemshared_70_electricengine",
	"techguns:itemshared_72_pumpmechanism",
	"techguns:itemshared_103_quartzrod",
	"techguns:itemshared_103_quartzrod_alt",
	"techguns:itemshared_104_rcheatray",
	"techguns:itemshared_117_rocket_nuke",
	"techguns:itemshared_118_tacticalnukewarhead",
	"techguns:itemshared_134_oredrillsmall_steel",
	"techguns:itemshared_135_oredrillsmall_obsidiansteel",
	"techguns:itemshared_136_oredrillsmall_carbon",
	"techguns:itemshared_137_oredrillmedium_steel",
	"techguns:itemshared_138_oredrillmedium_obsidiansteel",
	"techguns:itemshared_139_oredrillmedium_carbon",
	"techguns:itemshared_140_oredrilllarge_steel",
	"techguns:itemshared_141_oredrilllarge_obsidiansteel",
	"techguns:itemshared_142_oredrilllarge_carbon",
	"techguns:itemshared_146_infusionbag",
	"techguns:thompson",
	"techguns:thompson_alt",
	"techguns:ak47",
	"techguns:ak47_alt",
	"techguns:m4",
	"techguns:m4_alt",
	"techguns:m4_infiltrator",
	"techguns:m4_infiltrator_alt",
	"techguns:pistol",
	"techguns:pistol_alt",
	"techguns:combatshotgun",
	"techguns:goldenrevolver",
	"techguns:mac10",
	"techguns:mac10_alt",
	"techguns:flamethrower",
	"techguns:flamethrower_alt",
	"techguns:fraggrenade",
	"techguns:rocketlauncher",
	"techguns:rocketlauncher_alt",
	"techguns:guidedmissilelauncher",
	"techguns:guidedmissilelauncher_alt",
	"techguns:grimreaper",
	"techguns:grenadelauncher",
	"techguns:aug",
	"techguns:aug_alt",
	"techguns:sawedoff",
	"techguns:netherblaster",
	"techguns:biogun",
	"techguns:biogun_alt",
	"techguns:teslagun",
	"techguns:teslagun_alt",
	"techguns:lmg",
	"techguns:lmg_alt",
	"techguns:minigun",
	"techguns:minigun_alt",
	"techguns:as50",
	"techguns:as50_alt",
	"techguns:vector",
	"techguns:vector_alt",
	"techguns:scar",
	"techguns:scar_alt",
	"techguns:lasergun",
	"techguns:lasergun_alt",
	"techguns:blasterrifle",
	"techguns:blasterrifle_alt",
	"techguns:sonicshotgun",
	"techguns:sonicshotgun_alt",
	"techguns:pdw",
	"techguns:pdw_alt",
	"techguns:pulserifle",
	"techguns:pulserifle_alt",
	"techguns:mibgun",
	"techguns:mibgun_alt",
	"techguns:powerhammer",
	"techguns:powerhammer_alt",
	"techguns:chainsaw",
	"techguns:chainsaw_alt",
	"techguns:nucleardeathray",
	"techguns:nucleardeathray_alt",
	"techguns:gaussrifle",
	"techguns:gaussrifle_alt",
	"techguns:miningdrill",
	"techguns:miningdrill_alt",
	"techguns:tfg",
	"techguns:tfg_alt",
	"techguns:laserpistol",
	"techguns:laserpistol_alt",
	"techguns:compressedairtankempty",
	"techguns:compressedairtankempty_alt",
	"techguns:simplemachine_8_camo_bench",
	"techguns:simplemachine_9_upgrade_bench",
	"techguns:simplemachine2_9_armor_bench",
	"techguns:itemshared_60_heavycloth",
	"techguns:t2_commando_helmet",
	"techguns:t2_commando_chestplate",
	"techguns:t2_commando_leggings",
	"techguns:t2_commando_boots",
	"techguns:t2_combat_helmet",
	"techguns:t2_combat_chestplate",
	"techguns:t2_combat_leggings",
	"techguns:t2_combat_boots",
	"techguns:t3_exo_helmet",
	"techguns:t3_exo_chestplate",
	"techguns:t3_exo_leggings",
	"techguns:t3_exo_boots",
	"techguns:t3_miner_helmet",
	"techguns:t3_miner_chestplate",
	"techguns:t3_miner_leggings",
	"techguns:t3_miner_boots",
	"techguns:t4_praetor_helmet",
	"techguns:t4_praetor_chestplate",
	"techguns:t4_praetor_leggings",
	"techguns:t4_praetor_boots",
	"techguns:hazmat_helmet",
	"techguns:hazmat_chestplate",
	"techguns:hazmat_leggings",
	"techguns:hazmat_boots",
	"techguns:itemshared_147_upgrade_protection_1",
	"techguns:itemshared_150_upgrade_protection_2",
	"techguns:itemshared_153_upgrade_protection_3",
	"techguns:itemshared_148_upgrade_projectile_protection_1",
	"techguns:itemshared_151_upgrade_projectile_protection_2",
	"techguns:itemshared_154_upgrade_projectile_protection_3",
	"techguns:itemshared_149_upgrade_blast_protection_1",
	"techguns:itemshared_152_upgrade_blast_protection_2",
	"techguns:itemshared_155_upgrade_blast_protection_3",
	"techguns:itemshared_86_nuggetcopper",
	"techguns:itemshared_87_nuggetlead",
	"techguns:itemshared_88_nuggetsteel"
]

for (name in name_removals) {
	crafting.remove(name);
}

mods.jei.ingredient.yeet( // hide techguns plates, ingots, and ores
		item('techguns:itemshared', 46),
		item('techguns:itemshared', 47),
		item('techguns:itemshared', 48),
		item('techguns:itemshared', 49),
		item('techguns:itemshared', 50),
		item('techguns:itemshared', 52),
		item('techguns:itemshared', 54),
		item('techguns:itemshared', 78),
		item('techguns:itemshared', 79),
		item('techguns:itemshared', 80),
		item('techguns:itemshared', 81),
		item('techguns:itemshared', 82),
		item('techguns:itemshared', 83),
		item('techguns:itemshared', 85)
)

crafting.replaceShaped("techguns:stielgranate", item('techguns:stielgranate'), [
		[null, null, null],
		[null, item('techguns:itemshared', 5), null],
		[null, item('minecraft:stick'), null]
])

crafting.addShaped("techguns:netherdoor", item('techguns:item_door3x3', 3), [
	[item('techguns:nethermetal'), item('techguns:nethermetal'), item('techguns:nethermetal')],
	[item('minecraft:piston'), item('techguns:nethermetal'), item('minecraft:piston')],
	[item('techguns:nethermetal'), item('techguns:nethermetal'), item('techguns:nethermetal')]
])

crafting.replaceShaped("techguns:simplemachine_8_camo_bench", item('techguns:simplemachine', 8), [
	[ore('dye'), ore('dye'), ore('dye')],
	[ore('plateIron'), ore('workbench'), ore('plateIron')],
	[ore('plateIron'), ore('plateIron'), ore('plateIron')]
])

crafting.replaceShaped("techguns:simplemachine_9_repair_bench", item('techguns:simplemachine', 9), [
	[ore('plateIron'), ore('gearSteel'), ore('plateIron')],
	[ore('plateIron'), ore('workbench'), ore('plateIron')],
	[ore('plateIron'), ore('plateIron'), ore('plateIron')]
])

crafting.replaceShaped("techguns:simplemachine2_9_armor_bench", item('techguns:simplemachine2', 9), [
	[ore('plateIron'), metaitem('stickSteel'), ore('plateIron')],
	[ore('gearSteel'), ore('workbench'), ore('gearSteel')],
	[null, ore('circuitLv'), null]
])

crafting.replaceShaped("techguns:explosive_charge_0_tnt", item('techguns:explosive_charge') * 8, [
	[ore('plateRubber'), ore('dustGunpowder'), ore('plateRubber')],
	[ore('dustGunpowder'), ore('circuitLv'), ore('dustGunpowder')],
	[ore('plateRubber'), ore('dustGunpowder'), ore('plateRubber')]
])

crafting.replaceShaped("techguns:explosive_charge_1_advanced", item('techguns:explosive_charge', 1) * 4, [
	[ore('platePlastic'), item('minecraft:tnt'), ore('platePlastic')],
	[item('minecraft:tnt'), ore('circuitMv'), item('minecraft:tnt')],
	[ore('platePlastic'), item('minecraft:tnt'), ore('platePlastic')]
])

crafting.replaceShaped("techguns:lamp0_0", item('techguns:lamp0') * 32, [
	[ore('plateIron'), ore('plateIron'), ore('plateIron')],
	[ore('plateGlass'), ore('dustGlowstone'), ore('plateGlass')],
	[ore('plateGlass'), ore('plateGlass'), ore('plateGlass')]
])

crafting.replaceShaped("techguns:lamp0_12", item('techguns:lamp0', 12) * 32, [
	[ore('plateGlass'), ore('plateIron'), ore('plateGlass')],
	[ore('plateGlass'), ore('dustGlowstone'), ore('plateGlass')],
	[ore('plateGlass'), ore('plateIron'), ore('plateGlass')]
])

crafting.replaceShaped("techguns:neonlights_0", item('techguns:neonlights') * 32, [
	[ore('plateIron'), ore('plateIron'), ore('plateIron')],
	[ore('plateGlass'), ore('dustGlowstone'), ore('plateGlass')],
	[ore('plateIron'), ore('plateIron'), ore('plateIron')]
])

crafting.replaceShaped("techguns:ladder0_8", item('techguns:ladder0', 8) * 16, [
	[ore('stickIron'), ore('stickIron'), ore('stickIron')],
	[null, ore('stickIron'), null],
	[ore('stickIron'), ore('stickIron'), ore('stickIron')]
])

crafting.replaceShaped("techguns:ladder0_8_alt", item('techguns:ladder0', 8) * 16, [
	[ore('stickTin'), ore('stickTin'), ore('stickTin')],
	[null, ore('stickTin'), null],
	[ore('stickTin'), ore('stickTin'), ore('stickTin')]
])

crafting.replaceShaped("techguns:camonet_0", item('techguns:camonet') * 8, [
	[null, null, null],
	[ore('stickWood'), ore('treeLeaves'), ore('stickWood')],
	[ore('stickWood'), ore('treeLeaves'), ore('stickWood')]
])

crafting.replaceShaped("techguns:camonet_top_0", item('techguns:camonet_top') * 16, [
	[ore('stickWood'), ore('treeLeaves'), ore('stickWood')],
	[ore('treeLeaves'), ore('string'), ore('treeLeaves')],
	[ore('stickWood'), ore('treeLeaves'), ore('stickWood')]
])

crafting.replaceShaped("techguns:itemshared_37_stonebarrel", item('techguns:itemshared', 37), [
	[null, ore('craftingToolHardHammer'), null],
	[null, ore('craftingToolFile'), null],
	[null, ore('stone'), null]
])

crafting.replaceShaped("techguns:itemshared_42_woodstock", item('techguns:itemshared', 42), [
	[null, null, null],
	[ore('craftingToolFile'), ore('logWood'), ore('craftingToolSaw')],
	[null, null, null]
])

crafting.replaceShaped("techguns:t1_miner_helmet", item('techguns:t1_miner_helmet'), [
	[null, null, null],
	[ore('plateIron'), ore('dyeYellow'), ore('plateIron')],
	[item('techguns:itemshared', 60), ore('craftingToolHardHammer'), item('techguns:itemshared', 60)]
])

crafting.replaceShaped("techguns:t1_miner_chestplate", item('techguns:t1_miner_chestplate'), [
	[item('techguns:itemshared', 60), ore('craftingToolHardHammer'), item('techguns:itemshared', 60)],
	[item('techguns:itemshared', 60), item('techguns:itemshared', 60), item('techguns:itemshared', 60)],
	[ore('plateIron'), item('techguns:itemshared', 60), ore('plateIron')]
])

crafting.replaceShaped("techguns:t1_miner_leggings", item('techguns:t1_miner_leggings'), [
	[ore('plateIron'), item('techguns:itemshared', 60), ore('plateIron')],
	[item('techguns:itemshared', 60), ore('craftingToolHardHammer'), item('techguns:itemshared', 60)],
	[item('techguns:itemshared', 60), null, item('techguns:itemshared', 60)]
])

crafting.replaceShaped("techguns:t1_miner_boots", item('techguns:t1_miner_boots'), [
	[null, null, null],
	[item('techguns:itemshared', 60), null, item('techguns:itemshared', 60)],
	[ore('plateIron'), ore('craftingToolHardHammer'), ore('plateIron')]
])

crafting.replaceShaped("techguns:steam_helmet", item('techguns:steam_helmet'), [
	[null, null, null],
	[item('techguns:itemshared', 45), item('techguns:itemshared', 45), item('techguns:itemshared', 45)],
	[item('techguns:itemshared', 45), ore('craftingToolWrench'), item('techguns:itemshared', 45)]
])

crafting.replaceShaped("techguns:steam_chestplate", item('techguns:steam_chestplate'), [
	[item('techguns:itemshared', 45), ore('craftingToolWrench'), item('techguns:itemshared', 45)],
	[item('techguns:itemshared', 45), item('techguns:itemshared', 45), item('techguns:itemshared', 45)],
	[item('techguns:itemshared', 45), item('techguns:itemshared', 45), item('techguns:itemshared', 45)]
])

crafting.replaceShaped("techguns:steam_leggings", item('techguns:steam_leggings'), [
	[item('techguns:itemshared', 45), item('techguns:itemshared', 45), item('techguns:itemshared', 45)],
	[item('techguns:itemshared', 45), ore('craftingToolWrench'), item('techguns:itemshared', 45)],
	[item('techguns:itemshared', 45), null, item('techguns:itemshared', 45)]
])

crafting.replaceShaped("techguns:steam_boots", item('techguns:steam_boots'), [
	[null, null, null],
	[item('techguns:itemshared', 45), ore('craftingToolWrench'), item('techguns:itemshared', 45)],
	[item('techguns:itemshared', 45), null, item('techguns:itemshared', 45)]
])

crafting.replaceShaped("techguns:item_bunkerdoor", item('techguns:item_bunkerdoor'), [
	[null, ore('craftingToolHardHammer'), ore('screwIron')],
	[null, ore('plateIron'), item('minecraft:iron_door')],
	[null, ore('craftingToolScrewdriver'), ore('screwIron')]
])

crafting.replaceShaped("techguns:revolver", item('techguns:revolver'), [
	[ore('craftingToolHardHammer'), ore('plateIron'), ore('springSmallIron')],
	[item('techguns:itemshared', 38), ore('gearSmallIron'), ore('boltIron')],
	[ore('craftingToolFile'), item('techguns:itemshared', 42), ore('craftingToolScrewdriver')]
])

crafting.replaceShaped("techguns:boltaction", item('techguns:boltaction'), [
	[null, ore('craftingToolWrench'), null],
	[ore('plateGlass'), ore('ringIron'), ore('plateGlass')],
	[item('techguns:itemshared', 38), item('techguns:itemshared', 33), item('techguns:itemshared', 42)]
])

crafting.replaceShaped("techguns:pistolrounds", item('techguns:itemshared', 1) * 4, [
	[ore('plateBrass'), ore('gunpowder'), ore('roundLead')],
])

crafting.replaceShaped("techguns:shotgunrounds", item('techguns:itemshared', 2) * 8, [
		[ore('plateSteel'), ore('gunpowder'), ore('roundLead')],
])


crafting.replaceShapeless("techguns:sandbags", item('techguns:sandbags') * 8, [
	ore('plateRubber'), 
	ore('sand'),
	ore('sand'),
	ore('sand'),
	ore('sand'),
	ore('sand'),
	ore('sand'),
	ore('sand'),
	ore('sand')
])

crafting.addShaped("tg_sawoff", item('techguns:sawedoff'), [
		[metaitem('gun.barrel.steel'), ore('springSmallSteel'), metaitem('gun.barrel.steel')],
		[item('techguns:itemshared', 33), item('techguns:itemshared', 2), item('techguns:itemshared', 42)],
		[null, null, null]
]);

mods.gregtech.assembler.recipeBuilder()
	.inputs(metaitem('hull.lv'))
	.inputs(metaitem('electric.motor.lv'))
	.inputs(ore('circuitLv'))
	.inputs(ore('wireFineRedAlloy'))
	.inputs(ore('plateSteel') * 4)
	.fluidInputs(fluid('soldering_alloy') * 72)
	.outputs(item('techguns:basicmachine', 3))
	.duration(100)
	.EUt(Globals.voltAmps[1])
	.buildAndRegister()

Globals.solders.each { key, val ->
	recipemap('weapons_factory').recipeBuilder()
		.inputs(ore('plateIron') * 3)
		.inputs(ore('stickIron') * 2)
		.inputs(ore('gearSmallIron'))
		.inputs(ore('springSmallIron'))
		.inputs(ore('boltIron') * 2)
		.inputs(ore('screwIron') * 2)
		.fluidInputs(fluid(key) * val)
		.outputs(item('techguns:itemshared', 33))
		.duration(100)
		.EUt(Globals.voltAmps[1])
		.buildAndRegister()

	recipemap('weapons_factory').recipeBuilder()
		.inputs(ore('plateSteel') * 3)
		.inputs(ore('stickSteel') * 2)
		.inputs(ore('gearSmallSteel'))
		.inputs(ore('springSmallSteel'))
		.inputs(ore('boltSteel') * 2)
		.inputs(ore('screwSteel') * 2)
		.fluidInputs(fluid(key) * val)
		.outputs(item('techguns:itemshared:34'))
		.duration(80)
		.EUt(Globals.voltAmps[1])
		.buildAndRegister();

	recipemap('weapons_factory').recipeBuilder()
			.inputs(ore('plateStainlessSteel') * 3)
			.inputs(ore('stickStainlessSteel') * 2)
			.inputs(ore('gearSmallStainlessSteel'))
			.inputs(ore('springSmallStainlessSteel'))
			.inputs(ore('boltStainlessSteel') * 2)
			.inputs(ore('screwStainlessSteel') * 2)
			.fluidInputs(fluid(key) * val)
			.outputs(item('techguns:itemshared:35'))
			.duration(80)
			.EUt(Globals.voltAmps[2])
			.buildAndRegister();

	recipemap('weapons_factory').recipeBuilder()
			.inputs(ore('plateGraphene') * 3)
			.inputs(ore('wireGtSingleGraphene') * 2)
			.inputs(ore('gearSmallTungstenSteel'))
			.inputs(ore('springSmallTungsten'))
			.inputs(ore('boltTungstenSteel') * 2)
			.inputs(ore('screwTungstenSteel') * 2)
			.fluidInputs(fluid(key) * val)
			.outputs(item('techguns:itemshared:36'))
			.duration(80)
			.EUt(Globals.voltAmps[3])
			.buildAndRegister();

	recipemap('weapons_factory').recipeBuilder()
		.inputs([ore('plateSteel'),
					ore('springSmallSteel'),
					ore('gearSmallSteel'),
					metaitem('gun.barrel.steel'),
					ore('plateRubber')*2,
					item('techguns:itemshared:11')
		])
		.fluidInputs(fluid(key) * val)
		.outputs(item('techguns:pistol'))
		.duration(300)
		.EUt(Globals.voltAmps[1])
		.buildAndRegister();

	recipemap('weapons_factory').recipeBuilder()
		.inputs([ore('plateSteel'),
					ore('springSmallSteel')*4
		])
		.fluidInputs(fluid(key) * val)
		.circuitMeta(1)
		.outputs(item('techguns:itemshared:12')*4)
		.duration(10)
		.EUt(Globals.voltAmps[1])
		.buildAndRegister();

	recipemap('weapons_factory').recipeBuilder()
		.inputs([
				ore('springSmallSteel')*4,
				ore('plateSteel')
		])
		.fluidInputs(fluid(key) * val)
		.circuitMeta(2)
		.outputs(item('techguns:itemshared:10')*4)
		.duration(20)
		.EUt(Globals.voltAmps[2])
		.buildAndRegister();

	recipemap('weapons_factory').recipeBuilder()
		.inputs([
				ore('springSmallSteel')*4,
				ore('plateSteel')
		])
		.fluidInputs(fluid(key) * val)
		.circuitMeta(3)
		.outputs(item('techguns:itemshared:14')*4)
		.duration(20)
		.EUt(Globals.voltAmps[2])
		.buildAndRegister();

	recipemap('weapons_factory').recipeBuilder()
			.inputs([
					ore('springSmallSteel')*4,
					ore('plateSteel') * 2
			])
			.fluidInputs(fluid(key) * val)
			.circuitMeta(4)
			.outputs(item('techguns:itemshared:16'))
			.duration(20)
			.EUt(Globals.voltAmps[2])
			.buildAndRegister();

	recipemap('weapons_factory').recipeBuilder()
			.inputs([
					ore('springSmallSteel')*4,
					ore('plateSteel') * 3
			])
			.fluidInputs(fluid(key) * val)
			.circuitMeta(5)
			.outputs(item('techguns:itemshared:18'))
			.duration(20)
			.EUt(Globals.voltAmps[3])
			.buildAndRegister();

	recipemap('weapons_factory').recipeBuilder()
			.inputs([
					ore('springSmallSteel')*4,
					ore('plateSteel') * 2
			])
			.fluidInputs(fluid(key) * val)
			.circuitMeta(6)
			.outputs(item('techguns:itemshared:20') * 2)
			.duration(20)
			.EUt(Globals.voltAmps[2])
			.buildAndRegister();

	recipemap('weapons_factory').recipeBuilder()
			.inputs([
					ore('springSmallStainlessSteel')*4,
					ore('plateStainlessSteel')
			])
			.fluidInputs(fluid(key) * val)
			.circuitMeta(1)
			.outputs(item('techguns:itemshared:22') * 4)
			.duration(20)
			.EUt(Globals.voltAmps[2])
			.buildAndRegister();

	recipemap('weapons_factory').recipeBuilder()
		.inputs([
			item('techguns:itemshared', 38),
			item('techguns:itemshared', 42),
			ore('plateIron'),
			ore('gearSmallIron'),
			ore('boltIron'),
			ore('springSmallIron')
		])
		.fluidInputs(fluid(key) * val)
		.outputs(item('techguns:revolver'))
		.duration(20)
		.EUt(Globals.voltAmps[1])
		.buildAndRegister();

	recipemap('weapons_factory').recipeBuilder()
		.inputs([
				metaitem('gun.barrel.steel'),
				item('techguns:itemshared', 34),
				item('techguns:itemshared', 42),
				item('techguns:itemshared', 9)
		])
		.circuitMeta(1)
		.fluidInputs(fluid(key) * val)
		.outputs(item('techguns:thompson'))
		.duration(200)
		.EUt(Globals.voltAmps[2])
		.buildAndRegister();

	recipemap('weapons_factory').recipeBuilder()
		.inputs([
				metaitem('gun.barrel.steel'),
				item('techguns:itemshared', 34),
				item('techguns:itemshared', 42),
				item('techguns:itemshared', 13),
				ore('plateWood')
		])
		.fluidInputs(fluid(key) * val)
		.outputs(item('techguns:ak47'))
		.duration(200)
		.EUt(Globals.voltAmps[2])
		.buildAndRegister();

	recipemap('weapons_factory').recipeBuilder()
		.inputs([
				metaitem('gun.barrel.steel'),
				item('techguns:itemshared', 34),
				item('techguns:itemshared', 43),
				item('techguns:itemshared', 13),
				ore('plateSteel'),
				ore('plateGlass'),
				ore('ringIron')
		])
		.fluidInputs(fluid(key) * val)
		.outputs(item('techguns:m4'))
		.duration(200)
		.EUt(Globals.voltAmps[2])
		.buildAndRegister();

	recipemap('weapons_factory').recipeBuilder()
		.inputs([
				metaitem('gun.barrel.steel'),
				item('techguns:itemshared', 34),
				item('techguns:itemshared', 43),
				item('techguns:itemshared', 13),
				ore('plateSteel') * 2,
				ore('lensGlass'),
				ore('ringIron') * 2,
				ore('boltSteel') * 2
		])
		.fluidInputs(fluid(key) * val)
		.outputs(item('techguns:m4_infiltrator'))
		.duration(200)
		.EUt(Globals.voltAmps[2])
		.buildAndRegister();

	recipemap('weapons_factory').recipeBuilder()
		.inputs([
				metaitem('gun.barrel.steel'),
				item('techguns:itemshared', 34),
				item('techguns:itemshared', 43),
				ore('stickSteel'),
				ore('springSmallSteel'),
				ore('plateSteel') * 4
		])
		.fluidInputs(fluid(key) * val)
		.outputs(item('techguns:combatshotgun'))
		.duration(400)
		.EUt(Globals.voltAmps[1])
		.buildAndRegister();

	recipemap('weapons_factory').recipeBuilder()
			.inputs([
					metaitem('gun.barrel.steel') * 2,
					item('techguns:itemshared', 34),
					item('techguns:itemshared', 42),
					ore('springSmallSteel'),
					item('techguns:itemshared', 2)
			])
			.fluidInputs(fluid(key) * val)
			.outputs(item('techguns:sawedoff'))
			.duration(400)
			.EUt(Globals.voltAmps[1])
			.buildAndRegister();

	recipemap('weapons_factory').recipeBuilder()
		.inputs([
				metaitem('gun.barrel.steel'),
				item('techguns:itemshared', 34),
				item('techguns:itemshared', 9),
				ore('platePlastic')
		])
		.fluidInputs(fluid(key) * val)
		.outputs(item('techguns:mac10'))
		.duration(200)
		.EUt(Globals.voltAmps[2])
		.buildAndRegister();

	recipemap('weapons_factory').recipeBuilder()
			.inputs([
					item('techguns:itemshared', 72),
					item('techguns:itemshared', 33),
					item('techguns:itemshared', 43),
					item('techguns:itemshared', 27),
					item('minecraft:flint_and_steel')
			])
			.fluidInputs(fluid(key) * val)
			.outputs(item('techguns:flamethrower'))
			.duration(200)
			.EUt(Globals.voltAmps[2])
			.buildAndRegister();

	recipemap('weapons_factory').recipeBuilder()
			.inputs([
					item('techguns:itemshared', 39) * 2,
					item('techguns:itemshared', 35),
					metaitem('ringSteel') * 2,
					item('minecraft:flint_and_steel'),
					item('techguns:itemshared', 7)
			])
			.fluidInputs(fluid(key) * val)
			.outputs(item('techguns:rocketlauncher'))
			.circuitMeta(1)
			.duration(200)
			.EUt(Globals.voltAmps[4])
			.buildAndRegister();

	recipemap('weapons_factory').recipeBuilder()
			.inputs([
					item('techguns:itemshared', 39) * 2,
					item('techguns:itemshared', 35),
					item('minecraft:flint_and_steel'),
					metaitem('ringSteel') * 2,
					metaitem('cover.screen'),
					ore('circuitHv'),
					item('techguns:itemshared', 7)
			])
			.fluidInputs(fluid(key) * val)
			.outputs(item('techguns:guidedmissilelauncher'))
			.circuitMeta(2)
			.duration(200)
			.EUt(Globals.voltAmps[4])
			.buildAndRegister();

	recipemap('weapons_factory').recipeBuilder()
			.inputs([
					item('techguns:itemshared', 39) * 8,
					item('techguns:itemshared', 36),
					item('minecraft:flint_and_steel'),
					metaitem('ringSteel') * 4,
					metaitem('cover.screen'),
					ore('circuitHv') * 4,
					item('techguns:itemshared', 7) * 4
			])
			.fluidInputs(fluid(key) * val)
			.outputs(item('techguns:grimreaper'))
			.circuitMeta(3)
			.duration(200)
			.EUt(Globals.voltAmps[5])
			.buildAndRegister();

	recipemap('weapons_factory').recipeBuilder()
			.inputs([
					item('techguns:itemshared', 39),
					item('techguns:itemshared', 35),
					item('techguns:itemshared', 43),
					metaitem('large_fluid_cell.steel'),
					item('techguns:itemshared', 5) * 6
			])
			.fluidInputs(fluid(key) * val)
			.outputs(item('techguns:grenadelauncher'))
			.duration(200)
			.EUt(Globals.voltAmps[4])
			.buildAndRegister();

	recipemap('weapons_factory').recipeBuilder()
			.inputs([
					item('techguns:itemshared', 39),
					item('techguns:itemshared', 35),
					item('techguns:itemshared', 43),
					item('techguns:itemshared', 14),
					metaitem('platePlastic'),
					metaitem('plateSteel'),
					ore('craftingLensGlass')
			])
			.fluidInputs(fluid(key) * val)
			.outputs(item('techguns:aug'))
			.duration(200)
			.EUt(Globals.voltAmps[3])
			.buildAndRegister();

	recipemap('weapons_factory').recipeBuilder()
			.inputs([
					item('techguns:itemshared', 39),
					item('techguns:itemshared', 35),
					item('techguns:itemshared', 43),
					item('techguns:itemshared', 16),
					metaitem('platePlastic'),
					ore('craftingLensGlass')
			])
			.fluidInputs(fluid(key) * val)
			.outputs(item('techguns:lmg'))
			.duration(200)
			.EUt(Globals.voltAmps[3])
			.buildAndRegister();

	recipemap('weapons_factory').recipeBuilder()
			.inputs([
					item('techguns:itemshared', 39) * 6,
					metaitem('electric.motor.ev'),
					item('techguns:itemshared', 35),
					item('techguns:itemshared', 18),
			])
			.fluidInputs(fluid(key) * val)
			.outputs(item('techguns:minigun'))
			.duration(200)
			.EUt(Globals.voltAmps[4])
			.buildAndRegister();

	recipemap('weapons_factory').recipeBuilder()
			.inputs([
					item('techguns:itemshared', 39) * 2,
					item('techguns:itemshared', 35),
					item('techguns:itemshared', 43),
					item('techguns:itemshared', 19),
					ore('craftingLensGlass') * 2
			])
			.fluidInputs(fluid(key) * val)
			.outputs(item('techguns:as50'))
			.duration(200)
			.EUt(Globals.voltAmps[3])
			.buildAndRegister();

	recipemap('weapons_factory').recipeBuilder()
			.inputs([
					item('techguns:itemshared', 39),
					item('techguns:itemshared', 35),
					item('techguns:itemshared', 43),
					item('techguns:itemshared', 10),
					metaitem('platePlastic') * 2,
					ore('craftingLensGlass')
			])
			.fluidInputs(fluid(key) * val)
			.outputs(item('techguns:vector'))
			.duration(200)
			.EUt(Globals.voltAmps[3])
			.buildAndRegister();

	recipemap('weapons_factory').recipeBuilder()
			.inputs([
					item('techguns:itemshared', 39),
					item('techguns:itemshared', 35),
					item('techguns:itemshared', 43),
					item('techguns:itemshared', 14),
					metaitem('platePlastic') * 1,
					ore('craftingLensGlass'),
					metaitem('boltSteel') * 2
			])
			.fluidInputs(fluid(key) * val)
			.outputs(item('techguns:scar'))
			.duration(200)
			.EUt(Globals.voltAmps[3])
			.buildAndRegister();
}

recipemap('weapons_factory').recipeBuilder()
		.inputs([ore('plateCupronickel'),
				ore('dustGunpowder'),
				ore('roundLead')
		])
		.outputs(item('techguns:itemshared', 3)*8)
		.duration(10)
		.EUt(16)
		.buildAndRegister();

recipemap('weapons_factory').recipeBuilder()
		.inputs([ore('plateAluminium'),
				ore('dustGunpowder'),
				ore('roundLead')
		])
		.outputs(item('techguns:itemshared', 4)*8)
		.duration(10)
		.EUt(16)
		.buildAndRegister();

recipemap('weapons_factory').recipeBuilder()
		.inputs([
				ore('dustGunpowder') * 2,
				metaitem('plateSteel'),
				metaitem('ringSteel') * 2,
				metaitem('boltSteel')
		])
		.circuitMeta(1)
		.outputs(item('techguns:itemshared', 5)*4)
		.duration(80)
		.EUt(30)
		.buildAndRegister();

recipemap('weapons_factory').recipeBuilder()
		.inputs([
				ore('dustGunpowder') * 2,
				metaitem('plateSteel'),
				metaitem('ringSteel') * 2,
				metaitem('boltSteel'),
				metaitem('roundLead') * 4
		])
		.circuitMeta(2)
		.outputs(item('techguns:fraggrenade')*4)
		.duration(80)
		.EUt(30)
		.buildAndRegister();

recipemap('weapons_factory').recipeBuilder()
		.inputs(ore('platePlastic')*4)
		.circuitMeta(1)
		.outputs(item('techguns:itemshared', 43))
		.duration(200)
		.EUt(Globals.voltAmps[1])
		.buildAndRegister();

recipemap('weapons_factory').recipeBuilder()
		.circuitMeta(1)
		.inputs([ore('plateBrass'),
				ore('gunpowder'),
				ore('roundLead')
		])
		.outputs(item('techguns:itemshared', 1)*12)
		.duration(10)
		.EUt(Globals.voltAmps[1])
		.buildAndRegister();

recipemap('weapons_factory').recipeBuilder()
		.circuitMeta(2)
		.inputs([ore('plateBrass') * 2,
				ore('gunpowder'),
				ore('roundLead') * 3
		])
		.outputs(item('techguns:itemshared', 2) * 5)
		.duration(10)
		.EUt(Globals.voltAmps[1])
		.buildAndRegister();

recipemap('assembler').recipeBuilder()
		.inputs(ore('platePlastic') * 4)
		.inputs(ore('ringTin') * 2)
		.outputs(item('techguns:itemshared', 28))
		.duration(200)
		.EUt(Globals.voltAmps[1])
		.buildAndRegister();

recipemap('assembler').recipeBuilder()
		.inputs(metaitem('electric.pump.mv'))
		.inputs(ore('ringSteel') * 2)
		.inputs(ore('platePlastic') * 4)
		.outputs(item('techguns:itemshared', 72))
		.duration(200)
		.EUt(Globals.voltAmps[1])
		.buildAndRegister();

mods.gregtech.forming_press.recipeBuilder()
	.inputs(ore('plateBronze'))
	.inputs(ore('plateSteel'))
	.inputs(ore('plateBrass'))
	.inputs(ore('boltBronze'))
	.inputs(ore('boltSteel'))
	.inputs(ore('boltBrass'))
	.outputs(item('techguns:itemshared', 45))
	.duration(60)
	.EUt(Globals.voltAmps[1])
	.buildAndRegister()

mods.gregtech.lathe.recipeBuilder()
	.inputs(ore('stickIron'))
	.outputs(item('techguns:itemshared', 38))
	.duration(80)
	.EUt(Globals.voltAmps[1])
	.buildAndRegister()

mods.gregtech.lathe.recipeBuilder()
	.inputs(ore('stickSteel'))
	.outputs(metaitem('gun.barrel.steel'))
	.duration(80)
	.EUt(Globals.voltAmps[1])
	.buildAndRegister()

recipemap('chemical_bath').recipeBuilder()
		.inputs(item('techguns:itemshared', 4) * 4)
		.fluidInputs(fluid('glyceryl_trinitrate') * 250)
		.outputs(item('techguns:itemshared', 144) * 4)
		.duration(100)
		.EUt(30)
		.buildAndRegister();

recipemap('canner').recipeBuilder()
		.inputs(item('techguns:itemshared', 2) * 4)
		.inputs(ore('dustPhosphorus'))
		.outputs(item('techguns:itemshared', 106) * 4)
		.duration(100)
		.EUt(30)
		.buildAndRegister();

recipemap('canner').recipeBuilder()
		.inputs(item('techguns:itemshared', 4) * 4)
		.inputs(ore('dustPhosphorus'))
		.outputs(item('techguns:itemshared', 108) * 4)
		.duration(100)
		.EUt(30)
		.buildAndRegister();

recipemap('canner').recipeBuilder()
		.inputs(item('techguns:itemshared', 1) * 6)
		.inputs(ore('dustPhosphorus'))
		.outputs(item('techguns:itemshared', 109) * 6)
		.duration(100)
		.EUt(30)
		.buildAndRegister();

recipemap('canner').recipeBuilder()
		.inputs(item('techguns:itemshared', 3) * 4)
		.inputs(ore('dustPhosphorus'))
		.outputs(item('techguns:itemshared', 110) * 4)
		.duration(100)
		.EUt(30)
		.buildAndRegister();

crafting.replaceShaped("techguns:riot_shield", item('techguns:riot_shield'), [
		[metaitem('stickLongSteel'), metaitem('platePolycarbonate'), metaitem('stickLongSteel')],
		[metaitem('stickSteel'), metaitem('plateSteel'), metaitem('stickSteel')],
		[metaitem('stickLongSteel'), metaitem('platePolycarbonate'), metaitem('stickLongSteel')]
]);

crafting.replaceShaped("techguns:ballistic_shield", item('techguns:ballistic_shield'), [
		[metaitem('plateBoronNitride'), item('gregtech:transparent_casing'), metaitem('plateBoronNitride')],
		[metaitem('plateKevlar'), item('techguns:riot_shield'), metaitem('plateKevlar')],
		[metaitem('plateBoronNitride'), metaitem('plateKevlar'), metaitem('plateBoronNitride')]
]);

crafting.replaceShaped("techguns:advanced_shield", item('techguns:advanced_shield'), [
		[metaitem('plateUltraHighMolecularWeightPolyethylene'), metaitem('plateAluminiumOxynitride'), metaitem('plateUltraHighMolecularWeightPolyethylene')],
		[metaitem('plateKevlar'), item('techguns:ballistic_shield'), metaitem('plateUltraHighMolecularWeightPolyethylene')],
		[metaitem('plateUltraHighMolecularWeightPolyethylene'), metaitem('plateUltraHighMolecularWeightPolyethylene'), metaitem('plateUltraHighMolecularWeightPolyethylene')]
]);

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

crafting.addShaped("heavy_cloth", item('techguns:itemshared:60')*6, [
		[ore('platePolycaprolactam'), ore('platePolycaprolactam'), ore('platePolycaprolactam')],
		[ore('wireFineSteel'), ore('wireFineSteel'), ore('wireFineSteel')],
		[ore('platePolycaprolactam'), ore('platePolycaprolactam'), ore('platePolycaprolactam')]
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

crafting.replaceShaped("techguns:t1_combat_helmet", item('techguns:t1_combat_helmet'), [
		[ore('plateSteel'), ore('plateSteel'), ore('plateSteel')],
		[item('techguns:itemshared:60'), ore('craftingToolHardHammer'), item('techguns:itemshared:60')]
]);

crafting.replaceShaped("techguns:t1_combat_chestplate", item('techguns:t1_combat_chestplate'), [
		[item('techguns:itemshared:60'), ore('craftingToolHardHammer'), item('techguns:itemshared:60')],
		[ore('plateSteel'), ore('plateSteel'), ore('plateSteel')],
		[item('techguns:itemshared:60'), item('techguns:itemshared:60'), item('techguns:itemshared:60')]
]);

crafting.replaceShaped("techguns:t1_combat_leggings", item('techguns:t1_combat_leggings'), [
		[ore('plateSteel'), ore('plateSteel'), ore('plateSteel')],
		[item('techguns:itemshared:60'), ore('craftingToolHardHammer'), item('techguns:itemshared:60')],
		[item('techguns:itemshared:60'), null, item('techguns:itemshared:60')]
]);

crafting.replaceShaped("techguns:t1_combat_boots", item('techguns:t1_combat_boots'), [
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

//--------------------GregTech machines only recipes--------------------

recipemap('forming_press').recipeBuilder()
		.inputs([metaitem('platePolycaprolactam') * 2,
				 ore('wireFineSteel') * 1
		])
		.outputs(item('techguns:itemshared:60') * 2)
		.duration(40)
		.EUt(16)
		.buildAndRegister();

recipemap('forming_press').recipeBuilder()
		.inputs([metaitem('foilSteel'), item('techguns:itemshared:38')])
		.outputs(item('techguns:itemshared:39'))
		.duration(30)
		.EUt(30)
		.buildAndRegister();

recipemap('roaster').recipeBuilder()
		.inputs(item('minecraft:leather'))
		.fluidInputs(fluid('water') * 1000)
		.outputs(item('techguns:itemshared:77'))
		.duration(85)
		.EUt(7)
		.buildAndRegister();

crafting.addShaped("bound_leather", metaitem('bound_leather')*8, [
		[item('techguns:itemshared:77'), item('techguns:itemshared:77'), item('techguns:itemshared:77')],
		[item('techguns:itemshared:77'), item('minecraft:string'), item('techguns:itemshared:77')],
		[item('techguns:itemshared:77'), item('techguns:itemshared:77'), item('techguns:itemshared:77')]
]);

recipemap('weapons_factory').recipeBuilder()
		.circuitMeta(1)
		.inputs(ore('plateUltraHighMolecularWeightPolyethylene') * 5)
		.inputs(ore('plateBoronNitride') * 2)
		.outputs(item('techguns:t2_commando_helmet'))
		.duration(100)
		.EUt(960)
		.buildAndRegister();

recipemap('weapons_factory').recipeBuilder()
		.circuitMeta(2)
		.inputs(ore('plateUltraHighMolecularWeightPolyethylene') * 8)
		.inputs(ore('plateBoronNitride') * 4)
		.outputs(item('techguns:t2_commando_chestplate'))
		.duration(100)
		.EUt(960)
		.buildAndRegister();

recipemap('weapons_factory').recipeBuilder()
		.circuitMeta(3)
		.inputs(ore('plateUltraHighMolecularWeightPolyethylene') * 7)
		.inputs(ore('plateBoronNitride') * 3)
		.outputs(item('techguns:t2_commando_leggings'))
		.duration(100)
		.EUt(960)
		.buildAndRegister();

recipemap('weapons_factory').recipeBuilder()
		.circuitMeta(4)
		.inputs(ore('plateUltraHighMolecularWeightPolyethylene') * 4)
		.inputs(ore('plateBoronNitride') * 2)
		.outputs(item('techguns:t2_commando_boots'))
		.duration(100)
		.EUt(960)
		.buildAndRegister();

recipemap('weapons_factory').recipeBuilder()
		.circuitMeta(1)
		.inputs(ore('plateKevlar') * 5)
		.inputs(ore('plateBoronNitride') * 2)
		.outputs(item('techguns:t2_combat_helmet'))
		.duration(100)
		.EUt(960)
		.buildAndRegister();

recipemap('weapons_factory').recipeBuilder()
		.circuitMeta(2)
		.inputs(ore('plateKevlar') * 8)
		.inputs(ore('plateBoronNitride') * 4)
		.outputs(item('techguns:t2_combat_chestplate'))
		.duration(100)
		.EUt(960)
		.buildAndRegister();

recipemap('weapons_factory').recipeBuilder()
		.circuitMeta(3)
		.inputs(ore('plateKevlar') * 7)
		.inputs(ore('plateBoronNitride') * 3)
		.outputs(item('techguns:t2_combat_leggings'))
		.duration(100)
		.EUt(960)
		.buildAndRegister();

recipemap('weapons_factory').recipeBuilder()
		.circuitMeta(4)
		.inputs(ore('plateKevlar') * 4)
		.inputs(ore('plateBoronNitride') * 2)
		.outputs(item('techguns:t2_combat_boots'))
		.duration(100)
		.EUt(960)
		.buildAndRegister();
		
//Armor upgrades

recipemap('weapons_factory').recipeBuilder()
		.circuitMeta(10)
		.inputs(ore('plateSteel') * 4)
		.outputs(item('techguns:itemshared:147'))
		.duration(100)
		.EUt(30)
		.buildAndRegister();

recipemap('weapons_factory').recipeBuilder()
		.circuitMeta(11)
		.inputs(ore('plateSteel') * 2)
		.inputs(ore('platePolycaprolactam') * 2)
		.outputs(item('techguns:itemshared:150'))
		.duration(100)
		.EUt(120)
		.buildAndRegister();

recipemap('weapons_factory').recipeBuilder()
		.circuitMeta(12)
		.inputs(ore('plateBoronNitride') * 2)
		.inputs(ore('plateKevlar') * 2)
		.outputs(item('techguns:itemshared:153'))
		.duration(100)
		.EUt(480)
		.buildAndRegister();

recipemap('weapons_factory').recipeBuilder()
		.circuitMeta(13)
		.inputs(ore('plateSteel') * 4)
		.outputs(item('techguns:itemshared:148'))
		.duration(100)
		.EUt(30)
		.buildAndRegister();

recipemap('weapons_factory').recipeBuilder()
		.circuitMeta(14)
		.inputs(ore('plateSteel') * 2)
		.inputs(ore('platePolycaprolactam') * 2)
		.outputs(item('techguns:itemshared:151'))
		.duration(100)
		.EUt(120)
		.buildAndRegister();

recipemap('weapons_factory').recipeBuilder()
		.circuitMeta(15)
		.inputs(ore('plateBoronNitride') * 2)
		.inputs(ore('plateKevlar') * 2)
		.outputs(item('techguns:itemshared:154'))
		.duration(100)
		.EUt(480)
		.buildAndRegister();

recipemap('weapons_factory').recipeBuilder()
		.circuitMeta(16)
		.inputs(ore('plateSteel') * 4)
		.outputs(item('techguns:itemshared:149'))
		.duration(100)
		.EUt(30)
		.buildAndRegister();

recipemap('weapons_factory').recipeBuilder()
		.circuitMeta(17)
		.inputs(ore('plateSteel') * 2)
		.inputs(ore('platePolycaprolactam') * 2)
		.outputs(item('techguns:itemshared:152'))
		.duration(100)
		.EUt(120)
		.buildAndRegister();

recipemap('weapons_factory').recipeBuilder()
		.circuitMeta(18)
		.inputs(ore('plateBoronNitride') * 2)
		.inputs(ore('plateKevlar') * 2)
		.outputs(item('techguns:itemshared:155'))
		.duration(100)
		.EUt(480)
		.buildAndRegister();

//Compressed air

recipemap('canner').recipeBuilder()
		.inputs(item('techguns:itemshared:24'))
		.fluidInputs(fluid('hp_air') * 1000)
		.outputs(item('techguns:itemshared:23'))
		.duration(100)
		.EUt(7)
		.buildAndRegister();

//-------------------Change TechGuns damage values to be better suited with SUSy progression----------------

//Taken from Techguns2 source code for crafttweaker integration
//Balanced by DPS (damage per second)
//Steam weapons: 8 DPS
//LV weapons: 16 DPS
//MV weapons: 32 DPS
//HV weapons: 64 DPS

// TODO: Waiting for grs update
//SetWeaponStat = { String weapon, String stat, float value ->
//	def gun = (GenericGun) item('techguns:' + weapon).getItem();
//	gun.setGunStat(EnumGunStat.parseFromString(stat), value);
//}
//
//
////Handcannon (1 shot per 1.5 seconds)
//SetWeaponStat("handcannon","DAMAGE",13);
//SetWeaponStat("handcannon","DAMAGE_MIN",11);
//
////Bolt Action (1 shot per second)
//SetWeaponStat("boltaction","DAMAGE",10);
//SetWeaponStat("boltaction","DAMAGE_MIN",8);
//
////Pistol (4 shots per second)
//SetWeaponStat("pistol","DAMAGE",5);
//SetWeaponStat("pistol","DAMAGE_MIN",4);
//
////Double Barrel Shotgun (8 bullets per shot, 1 shot per second)
//SetWeaponStat("sawedoff","DAMAGE",2.4);
//SetWeaponStat("sawedoff","DAMAGE_MIN",2);
//
////Revolver (2.5 shots per second)
//SetWeaponStat("revolver","DAMAGE",6);
//SetWeaponStat("revolver","DAMAGE_MIN",4);
//
////Combat Shotgun (8 bullets per shot, 1 shot per second)
//SetWeaponStat("combatshotgun","DAMAGE",2.4);
//SetWeaponStat("combatshotgun","DAMAGE_MIN",2);
//
////Thompson SMG (6 shots per second)
//SetWeaponStat("thompson","DAMAGE",6);
//SetWeaponStat("thompson","DAMAGE_MIN",5);
//
////AK47 (6 shots per second)
//SetWeaponStat("ak47","DAMAGE",6);
//SetWeaponStat("ak47","DAMAGE_MIN",5);
//
////M4 (6 shots per second)
//SetWeaponStat("m4","DAMAGE",6);
//SetWeaponStat("m4","DAMAGE_MIN",5);
//
////Infiltrator (6 shots per second)
//SetWeaponStat("m4_infiltrator","DAMAGE",6);
//SetWeaponStat("m4_infiltrator","DAMAGE_MIN",5);
//
////Mac-10 (6 shots per second)
//SetWeaponStat("mac10","DAMAGE", 6);
//SetWeaponStat("mac10","DAMAGE_MIN", 5);
//
////AUG (6 shots per second)
//SetWeaponStat("aug","DAMAGE", 12);
//SetWeaponStat("aug","DAMAGE_MIN", 10);
//
////LMG (10 shots per second)
//SetWeaponStat("lmg","DAMAGE", 7);
//SetWeaponStat("lmg","DAMAGE_MIN", 6);
//
////AS50 (2 shots per second)
//SetWeaponStat("as50","DAMAGE", 34);
//SetWeaponStat("as50","DAMAGE_MIN", 30);
//
////Vector (10 shots per second)
//SetWeaponStat("vector","DAMAGE", 7);
//SetWeaponStat("vector","DAMAGE_MIN", 6);
//
////Scar (5 shots per second)
//SetWeaponStat("scar","DAMAGE", 14);
//SetWeaponStat("scar","DAMAGE_MIN", 12);
//
////Minigun (20 shots per second)
//SetWeaponStat("minigun","DAMAGE", 5);
//SetWeaponStat("minigun","DAMAGE_MIN", 4);
