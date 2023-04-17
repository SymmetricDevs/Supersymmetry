import techguns.items.guns.GenericGun;
import techguns.plugins.crafttweaker.GunStatTweaker;
import static globals.Globals.*

def name_removals = [
	"techguns:basicmachine_0_ammo_press",
	"techguns:basicmachine_1_metal_press_alt",
	"techguns:basicmachine_1_metal_press",
	"techguns:basicmachine_2_chem_lab",
	"techguns:basicmachine_3_turret",
	"techguns:simplemachine2_8_grinder",
	"techguns:simplemachine_11_blast_furnace",
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
	"techguns:itemshared_10_smgmagazineempty",
	"techguns:itemshared_12_pistolmagazineempty",
	"techguns:itemshared_14_assaultriflemagazineempty",
	"techguns:itemshared_33_ironreceiver",
	"techguns:itemshared_34_steelreceiver",
	"techguns:itemshared_38_ironbarrel",
	"techguns:itemshared_43_plasticstock",
	"techguns:itemshared_61_biomass",
	"techguns:itemshared_62_copperwire",
	"techguns:itemshared_65_circuitboard",
	"techguns:itemshared_66_circuitboardelite",
	"techguns:itemshared_68_coil",
	"techguns:itemshared_70_electricengine",
	"techguns:itemshared_103_quartzrod",
	"techguns:itemshared_103_quartzrod_alt",
	"techguns:itemshared_104_rcheatray",
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
	"techguns:mac10",
	"techguns:mac10_alt"
]

for (name in name_removals) {
	crafting.remove(name);
}

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

crafting.replaceShaped("techguns:t1_combat_helmet", item('techguns:t1_combat_helmet'), [
	[null, null, null],
	[ore('plateIron'), ore('plateIron'), ore('plateIron')],
	[item('techguns:itemshared', 60), ore('craftingToolHardHammer'), item('techguns:itemshared', 60)]
])

crafting.replaceShaped("techguns:t1_combat_chestplate", item('techguns:t1_combat_chestplate'), [
	[item('techguns:itemshared', 60), ore('craftingToolHardHammer'), item('techguns:itemshared', 60)],
	[ore('plateIron'), ore('plateIron'), ore('plateIron')],
	[item('techguns:itemshared', 60), item('techguns:itemshared', 60), item('techguns:itemshared', 60)]
])

crafting.replaceShaped("techguns:t1_combat_leggings", item('techguns:t1_combat_leggings'), [
	[ore('plateIron'), ore('plateIron'), ore('plateIron')],
	[item('techguns:itemshared', 60), ore('craftingToolHardHammer'), item('techguns:itemshared', 60)],
	[item('techguns:itemshared', 60), null, item('techguns:itemshared', 60)]
])

crafting.replaceShaped("techguns:t1_combat_boots", item('techguns:t1_combat_boots'), [
	[null, null, null],
	[ore('plateIron'), ore('craftingToolHardHammer'), ore('plateIron')],
	[item('techguns:itemshared', 60), null, item('techguns:itemshared', 60)]
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

Globals.solders.each { key, val ->
	mods.gregtech.assembler.recipeBuilder()
		.inputs(metaitem('hull.lv'))
		.inputs(metaitem('electric.motor.lv'))
		.inputs(ore('circuitLv'))
		.inputs(ore('wireFineRedAlloy'))
		.inputs(ore('plateSteel') * 4)
		.fluidInputs(fluid(key) * val)
		.outputs(item('techguns:basicmachine', 3))
		.duration(100)
		.EUt(Globals.voltAmps[1])
		.buildAndRegister()

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
		.notConsumable(circuit(1))
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
		.notConsumable(circuit(2))
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
		.notConsumable(circuit(3))
		.outputs(item('techguns:itemshared:14')*4)
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
		.notConsumable(circuit(1))
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
				item('techguns:itemshared', 2)
		])
		.fluidInputs(fluid(key) * val)
		.outputs(item('techguns:combatshotgun'))
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
}

recipemap('weapons_factory').recipeBuilder()
		.inputs([ore('plateBrass'),
				 ore('gunpowder'),
				 ore('roundLead')
		])
		.outputs(item('techguns:itemshared', 1)*12)
		.duration(10)
		.EUt(Globals.voltAmps[1])
		.buildAndRegister();

recipemap('weapons_factory').recipeBuilder()
		.inputs([ore('plateBrass') * 2,
				 ore('gunpowder'),
				 ore('roundLead') * 3
		])
		.outputs(item('techguns:itemshared', 2) * 5)
		.duration(10)
		.EUt(Globals.voltAmps[1])
		.buildAndRegister();

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
		.inputs(ore('platePlastic')*4)
		.notConsumable(circuit(1))
		.outputs(item('techguns:itemshared', 43))
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

/*
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
*/