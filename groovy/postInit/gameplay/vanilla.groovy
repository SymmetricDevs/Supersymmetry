//Change Netherrack Breaking Time
net.minecraft.init.Blocks.NETHERRACK.blockHardness = 3.0

//Remove Enchantments
mods.jei.ingredient.hide(ore('bookEnchanted'));
mods.jei.ingredient.hide(item('minecraft:enchanting_table'));

//Remove Potions
mods.jei.ingredient.hide(item('minecraft:brewing_stand'));

crafting.replaceShaped("minecraft:furnace", item('minecraft:furnace'), [
        [metaitem('plateWroughtIron'), item('pyrotech:masonry_brick_block'), metaitem('plateWroughtIron')],
        [item('pyrotech:masonry_brick_block'), ore('craftingToolHardHammer'), item('pyrotech:masonry_brick_block')],
        [metaitem('plateWroughtIron'), item('pyrotech:masonry_brick_block'), metaitem('plateWroughtIron')]
])

// Furnace * 1
mods.gregtech.assembler.removeByInput(7, [metaitem('circuit.integrated').withNbt(['Configuration': 8]), item('minecraft:mossy_cobblestone:*') * 8 * 8], null)

mods.gregtech.assembler.recipeBuilder()
        .inputs(metaitem('plateWroughtIron') * 4)
        .inputs(item('pyrotech:masonry_brick_block') * 4)
        .outputs(item('minecraft:furnace'))
        .duration(100)
        .EUt(7)
        .circuitMeta(8)
        .buildAndRegister()
