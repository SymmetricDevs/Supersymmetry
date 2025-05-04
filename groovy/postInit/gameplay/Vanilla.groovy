//Change Netherrack Breaking Time
net.minecraft.init.Blocks.NETHERRACK.blockHardness = 3.0

//Remove Enchantments
mods.jei.ingredient.hide(ore('bookEnchanted'));
mods.jei.ingredient.hide(item('minecraft:enchanting_table'));

//Remove Potions
mods.jei.ingredient.hide(item('minecraft:brewing_stand'));

//Remove Furnace recipe
crafting.remove("minecraft:furnace")
// Furnace * 1
mods.gregtech.assembler.removeByInput(7, [metaitem('circuit.integrated').withNbt(['Configuration': 8]), item('minecraft:mossy_cobblestone:*') * 8 * 8], null)

