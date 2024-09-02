package postInit.mod

import com.codetaylor.mc.pyrotech.modules.tech.basic.ModuleTechBasic;
import com.codetaylor.mc.pyrotech.modules.tech.basic.block.BlockKilnPit;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;

log.infoMC("Running Pyrotech.groovy...")

// Make it easier to create a pit kiln
event_manager.listen { PlayerInteractEvent.RightClickBlock event ->
    EnumFacing facing = event.getFace();
    ItemStack stack = event.getItemStack();
    if (facing == EnumFacing.UP && stack.isItemEqual(item('pyrotech:material', 2))) {
        World world = event.getWorld();
        BlockPos pos = event.getPos();
        IBlockState state = world.getBlockState(pos);
        if (state == ModuleTechBasic.Blocks.KILN_PIT.getDefaultState().withProperty(BlockKilnPit.VARIANT, BlockKilnPit.EnumType.EMPTY) && stack.getCount() >= 3) {
            world.setBlockState(pos, state.withProperty(BlockKilnPit.VARIANT, BlockKilnPit.EnumType.THATCH));
            stack.setCount(stack.getCount() - 3);
        } else if (state.isSideSolid(world, pos, facing) && world.isAirBlock(pos.offset(facing))) {
            world.setBlockState(pos.offset(facing), ModuleTechBasic.Blocks.KILN_PIT.getDefaultState().withProperty(BlockKilnPit.VARIANT, BlockKilnPit.EnumType.EMPTY));
            stack.setCount(stack.getCount() - 1);
        } else {
            return;
        }
        event.setCanceled(true);
        if (event.getSide().isClient()) {
            event.getEntityPlayer().swingArm(EnumHand.MAIN_HAND);
        }
    }
}

// Re-balance pit kiln drops
event_manager.listen { BlockEvent.HarvestDropsEvent event ->
    if (event.getState().getBlock() instanceof BlockKilnPit) {
        event.getDrops().replaceAll(stack -> stack.isItemEqual(item('pyrotech:kiln_pit')) ? (item('pyrotech:material', 2) * stack.getCount()) :
                stack.isItemEqual(item('pyrotech:thatch')) ? (item('pyrotech:material', 2) * (3 * stack.getCount())) : stack); // Yeah I know this is caused but it works so :clueless:
    }
}

def name_removals = [
        "pyrotech:crude_hammer",
        "pyrotech:tech/basic/worktable",
        "pyrotech:tech/basic/worktable_stone",
        "pyrotech:tech/basic/anvil_obsidian",
        "pyrotech:tech/basic/anvil_iron_plated",
        "pyrotech:tech/basic/dried_plant_fibers_from_pit_kiln",
        "pyrotech:tech/basic/kiln_pit",
        "pyrotech:crafting_table",
        "pyrotech:unfired_brick",
        "pyrotech:bucket/bucket_wood",
        "pyrotech:bucket/bucket_stone",
        "pyrotech:ignition/matchstick",
        "pyrotech:ignition/flint_and_tinder",
        "pyrotech:obsidian_hammer",
        "pyrotech:tech/bloomery/tongs_obsidian",
        "pyrotech:tech/machine/sawmill_blade_obsidian",
        "pyrotech:tech/machine/cog_obsidian",
        "pyrotech:straw_bed",
        "pyrotech:clay",
        "pyrotech:cobbled_limestone",
        "pyrotech:cobbled_andesite",
        "pyrotech:cobbled_diorite",
        "pyrotech:cobbled_granite",
        "pyrotech:leather_leggings_fireproof",
        "pyrotech:leather_helmet_fireproof",
        "pyrotech:leather_chestplate_fireproof",
        "pyrotech:leather_boots_fireproof"
]

for (item in name_removals) {
    crafting.remove(item);
}

def categories_hides = [
        "pyrotech.wither.forge",
        "pyrotech.anvil.ironclad",
        "pyrotech.anvil.obsidian",
        "pyrotech.worktable"
]

for (item in categories_hides) {
    mods.jei.category.hideCategory(item);
}

mods.jei.catalyst.remove("pyrotech.pit.kiln", item('pyrotech:kiln_pit'))
mods.jei.catalyst.add("pyrotech.pit.kiln", item('pyrotech:material', 2), item('pyrotech:kiln_pit'))

mods.jei.ingredient.yeet(
        item('pyrotech:living_tar'),
        item('pyrotech:tainted_meat'),
        item('pyrotech:dense_redstone_ore_large'),
        item('pyrotech:dense_redstone_ore_small'),
        item('pyrotech:dense_redstone_ore_rocks'),
        item('pyrotech:dense_quartz_ore_large'),
        item('pyrotech:dense_quartz_ore_small'),
        item('pyrotech:dense_quartz_ore_rocks'),
        item('pyrotech:fossil_ore'),
        item('pyrotech:dense_coal_ore'),
        item('pyrotech:dense_nether_coal_ore'),
        item('pyrotech:rock', 1),
        item('pyrotech:rock', 2),
        item('pyrotech:rock', 3),
        item('pyrotech:rock', 4),
        item('pyrotech:rock', 5),
        item('pyrotech:rock', 6),
        item('pyrotech:rock', 8),
        item('pyrotech:rock', 9),
        item('pyrotech:rock', 10),
        item('pyrotech:rock', 11),
        item('pyrotech:rock_grass'),
        item('pyrotech:rock_netherrack'),
        item('pyrotech:anvil_obsidian'),
        item('pyrotech:anvil_iron_plated'),
        item('pyrotech:obsidian_hammer'),
        item('pyrotech:tongs_obsidian'),
        item('pyrotech:sawmill_blade_obsidian'),
        item('pyrotech:cog_obsidian'),
        item('pyrotech:worktable'),
        item('pyrotech:worktable_stone'),
        item('pyrotech:material', 8),
        item('pyrotech:material', 22),
        item('pyrotech:material', 24),
        item('pyrotech:material', 28),
        item('pyrotech:cobblestone', 3),
        item('pyrotech:bucket_wood'),
        item('pyrotech:bucket_stone'),
        item('pyrotech:matchstick'),
        item('pyrotech:flint_and_tinder'),
        item('pyrotech:straw_bed'),
        item('pyrotech:limestone')
)

def furnace_removals = [
        item('pyrotech:cobblestone', 3),
        item('pyrotech:material', 28)
]

for (item in furnace_removals) {
        furnace.removeByInput(item);
}

// Util closures
def kiln_remove = { String string ->
        mods.pyrotech.kiln.remove("pyrotech:" + string)
        mods.pyrotech.kiln.remove("pyrotech:pit_kiln/" + string) // TODO
        mods.pyrotech.kiln.remove("pyrotech:stone_kiln/pit_kiln/" + string) // TODO
}

mods.pyrotech.soaking_pot.remove("pyrotech:living_tar")

// Remove pyrotech limestone
mods.pyrotech.anvil.remove("pyrotech:limestone_to_cobbled")
mods.pyrotech.anvil.remove("pyrotech:cobbled_limestone_to_rocks")
mods.pyrotech.anvil.remove("pyrotech:limestone_rocks_to_crushed_limestone")
mods.pyrotech.soaking_pot.remove("pyrotech:slaked_lime")
kiln_remove("quicklime") // TODO: add a recipe for SuSy quicklime
kiln_remove("limestone")

// Limestone dust
mods.pyrotech.anvil.recipeBuilder()
        .name("supersymmetry:limestone_dust")
        .input(item('susy:susy_stone_cobble', 2))
        .output(item('gregtech:meta_dust', 27202))
        .typeHammer()
        .hits(2)
        .tierGranite()
        .register()

// Slaked lime
mods.pyrotech.soaking_pot.recipeBuilder()
        .name("supersymmetry:slaked_lime")
        .input(item('gregtech:meta_dust', 360))
        .fluidInput(fluid('water') * 50)
        .output(item('gregtech:meta_dust', 8100))
        .time(1)
        .campfireRequired(false)
        .register()

// Clay
// Clay to brick
kiln_remove("brick")
mods.pyrotech.kiln.recipeBuilder()
        .name("pyrotech:pit_kiln/brick")
        .input(item('gregtech:meta_item_1', 349))
        .output(item('minecraft:brick'))
        .burnTime(16800)
        .failureChance(0.33)
        .failureOutput(
                item('pyrotech:material', 7),
                item('pyrotech:material', 6),
                item('pyrotech:material')
        )
        .register()

// Straw
crafting.addShapeless("supersymmetry:cutting_wheat", item('pyrotech:material', 2), [
        item('minecraft:wheat'),
        ore('craftingToolKnife')
])

// Masonry brick
mods.pyrotech.anvil.remove("pyrotech:brick_stone")
mods.pyrotech.anvil.recipeBuilder()
        .name("pyrotech:brick_stone")
        .input(ore('stone'))
        .output(item('pyrotech:material', 16) * 4)
        .typePickaxe()
        .hits(4)
        .tierGranite()
        .register()

// Bow drill
crafting.replaceShaped("pyrotech:ignition/bow_drill", item('pyrotech:bow_drill'), [
        [item('pyrotech:material', 14), ore('stickWood'), ore('craftingToolKnife')],
        [item('pyrotech:material', 14), ore('stickLongWood'), ore('stickWood')],
        [item('pyrotech:material', 14), ore('stickWood'), null]
])

// Clay bucket
crafting.replaceShaped("pyrotech:bucket/bucket_clay_unfired", item('pyrotech:bucket_clay_unfired'), [
        [item('gregtech:meta_item_1', 349), null, item('gregtech:meta_item_1', 349)],
        [null, item('gregtech:meta_item_1', 349), null]
])

// Mechanical hopper
crafting.replaceShaped("pyrotech:tech/machine/mechanical_hopper", item('pyrotech:mechanical_hopper'), [
        [item('pyrotech:material', 16), null, item('pyrotech:material', 16)],
        [item('pyrotech:material', 16), null, item('pyrotech:material', 16)],
        [null, item('pyrotech:material', 16), null]
])

// Mechanical hopper with a stone gear
crafting.addShaped("pyrotech:tech/machine/mechanical_hopper_with_gear", item('pyrotech:mechanical_hopper').withNbt(['BlockEntityTag': ['id': 'pyrotech:tile.tilestonehopper', 'ForgeCaps': [], 'cogStackHandler': ['Items': [['Slot': 0, 'id': 'pyrotech:cog_stone', 'Count': 1, 'Damage': (short) 0]], 'Size': 1]], 'display': ['Lore': ['(+NBT)']]]), [
        [item('pyrotech:material', 16), null, item('pyrotech:material', 16)],
        [item('pyrotech:material', 16), item('pyrotech:cog_stone'), item('pyrotech:material', 16)],
        [null, item('pyrotech:material', 16), null]
])

// Refractory clay
crafting.replaceShaped("pyrotech:refractory_clay_ball", item('pyrotech:material', 4) * 2, [
        [ore('dustCalciumHydroxide'), item('pyrotech:material')],
        [ore('dustFlint'), ore('ingotClay')]
])