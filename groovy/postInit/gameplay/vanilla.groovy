//Change Netherrack Breaking Time
net.minecraft.init.Blocks.NETHERRACK.blockHardness = 3.0

//Remove Enchantments
mods.hei.hide(ore('bookEnchanted'));
mods.hei.hide(item('minecraft:enchanting_table'));

//Remove Potions
mods.hei.hide(item('minecraft:brewing_stand'));
