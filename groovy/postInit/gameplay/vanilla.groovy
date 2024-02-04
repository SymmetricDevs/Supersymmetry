//Change Netherrack Breaking Time
net.minecraft.init.Blocks.NETHERRACK.blockHardness = 3.0

//Remove Enchantments
mods.jei.hide(ore('bookEnchanted'));
mods.jei.hide(item('minecraft:enchanting_table'));

//Remove Potions
mods.jei.hide(item('minecraft:brewing_stand'));

item('biomesoplenty:mudball').Item.setMaxStackSize(64)
