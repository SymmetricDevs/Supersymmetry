//Change Netherrack Breaking Time
net.minecraft.init.Blocks.NETHERRACK.blockHardness = 3.0

//Remove Enchantments
mods.jei.ingredient.hide(ore('bookEnchanted'));
mods.jei.ingredient.hide(item('minecraft:enchanting_table'));

//Remove Potions
mods.jei.ingredient.hide(item('minecraft:brewing_stand'));

//Remove Furnace recipe
crafting.remove("minecraft:furnace")
