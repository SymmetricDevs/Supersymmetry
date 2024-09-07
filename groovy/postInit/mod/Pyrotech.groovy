package postInit.mod

import com.codetaylor.mc.pyrotech.modules.tech.basic.ModuleTechBasic;
import com.codetaylor.mc.pyrotech.modules.tech.basic.block.BlockKilnPit;
import com.cleanroommc.groovyscript.api.IIngredient;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent

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
        "pyrotech:stone_hammer",
        "pyrotech:obsidian_hammer",
        "pyrotech:tech/bloomery/tongs_obsidian",
        "pyrotech:tech/machine/sawmill_blade_stone",
        "pyrotech:tech/machine/sawmill_blade_flint",
        "pyrotech:tech/machine/sawmill_blade_bone",
        "pyrotech:tech/machine/sawmill_blade_iron",
        "pyrotech:tech/machine/sawmill_blade_gold",
        "pyrotech:tech/machine/sawmill_blade_diamond",
        "pyrotech:tech/machine/sawmill_blade_obsidian",
        "pyrotech:tech/machine/stone_sawmill",
        "pyrotech:tech/machine/brick_sawmill",
        "pyrotech:tech/machine/cog_wood",
        "pyrotech:tech/machine/cog_bone",
        "pyrotech:tech/machine/cog_obsidian",
        "pyrotech:tech/machine/mechanical_compacting_bin",
        "pyrotech:tech/machine/bellows",
        "pyrotech:tech/machine/mechanical_bellows",
        "pyrotech:tech/machine/mechanical_spreader",
        "pyrotech:tech/machine/stone_crucible",
        "pyrotech:tech/machine/brick_crucible",
        "pyrotech:boat_spruce",
        "pyrotech:boat_oak",
        "pyrotech:boat_jungle",
        "pyrotech:boat_dark_oak",
        "pyrotech:boat_birch",
        "pyrotech:boat_acacia",
        "pyrotech:dough",
        "pyrotech:bread_dough",
        "pyrotech:straw_bed",
        "pyrotech:clay",
        "pyrotech:cobbled_limestone",
        "pyrotech:cobbled_andesite",
        "pyrotech:cobbled_diorite",
        "pyrotech:cobbled_granite",
        "pyrotech:crafting_table_template",
        "pyrotech:furnace_core",
        "pyrotech:furnace",
        "pyrotech:refractory_brick_block",
        "pyrotech:pyroberry_seeds",
        "pyrotech:gloamberry_seeds",
        "pyrotech:freckleberryberry_seeds",
        "pyrotech:pyroberry_wine",
        "pyrotech:gloamberry_wine",
        "pyrotech:freckleberry_wine",
        "pyrotech:pyroberry_cocktail",
        "pyrotech:refractory_clay_ball",
        "pyrotech:refractory_brick_unfired",
        "pyrotech:refractory_clay_lump_from_unfired_refractory_brick",
        "pyrotech:refractory_clay_lump",
        "pyrotech:bucket/bucket_refractory_unfired",
        "pyrotech:tech/bloomery/bloomery",
        "pyrotech:tech/bloomery/wither_forge",
        "pyrotech:tech/refractory/tar_drain_brick",
        "pyrotech:tech/refractory/tar_collector_brick",
        "pyrotech:ignition/igniter_stone",
        "pyrotech:ignition/igniter_brick",
        "pyrotech:refractory_glass",
        "pyrotech:refractory_door",
        "pyrotech:storage/stone_tank",
        "pyrotech:storage/stone_tank_empty",
        "pyrotech:storage/brick_tank",
        "pyrotech:storage/brick_tank_empty",
        "pyrotech:storage/brick_faucet",
        "pyrotech:leather_leggings_fireproof",
        "pyrotech:leather_helmet_fireproof",
        "pyrotech:leather_chestplate_fireproof",
        "pyrotech:leather_boots_fireproof"
]

for (item in name_removals) {
    crafting.remove(item);
}

def categories_hides = [
        "pyrotech.bloomery",
        "pyrotech.wither.forge",
        "pyrotech.anvil.ironclad",
        "pyrotech.anvil.obsidian",
        "pyrotech.mechanical.compacting.bin",
        "pyrotech.stone.crucible",
        "pyrotech.stone.mill",
        "pyrotech.brick.crucible",
        "pyrotech.brick.mill",
        "pyrotech.refractory.burn",
        "pyrotech.worktable"
]

for (item in categories_hides) {
    mods.jei.category.hideCategory(item);
}

mods.jei.catalyst.remove("pyrotech.pit.kiln", item('pyrotech:kiln_pit'))
mods.jei.catalyst.add("pyrotech.pit.kiln", item('pyrotech:material', 2))

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
        item('pyrotech:crude_hammer'),
        item('pyrotech:stone_hammer'),
        item('pyrotech:obsidian_hammer'),
        item('pyrotech:tongs_obsidian'),
        item('pyrotech:sawmill_blade_stone'),
        item('pyrotech:sawmill_blade_flint'),
        item('pyrotech:sawmill_blade_bone'),
        item('pyrotech:sawmill_blade_iron'),
        item('pyrotech:sawmill_blade_gold'),
        item('pyrotech:sawmill_blade_diamond'),
        item('pyrotech:sawmill_blade_obsidian'),
        item('pyrotech:stone_sawmill'),
        item('pyrotech:brick_sawmill'),
        item('pyrotech:kiln_pit'),
        item('pyrotech:cog_wood'),
        item('pyrotech:cog_bone'),
        item('pyrotech:cog_obsidian'),
        item('pyrotech:worktable'),
        item('pyrotech:mechanical_compacting_bin'),
        item('pyrotech:bellows'),
        item('pyrotech:mechanical_bellows'),
        item('pyrotech:mechanical_mulch_spreader'),
        item('pyrotech:stone_crucible'),
        item('pyrotech:brick_crucible'),
        item('pyrotech:worktable_stone'),
        item('pyrotech:material', 1),
        item('pyrotech:material', 3),
        item('pyrotech:material', 4),
        item('pyrotech:material', 5),
        item('pyrotech:material', 8),
        item('pyrotech:material', 9),
        item('pyrotech:material', 20),
        item('pyrotech:material', 22),
        item('pyrotech:material', 23),
        item('pyrotech:material', 24),
        item('pyrotech:material', 25),
        item('pyrotech:material', 28),
        item('pyrotech:material', 31),
        item('pyrotech:material', 33),
        item('pyrotech:material', 35),
        item('pyrotech:material', 36),
        item('pyrotech:material', 37),
        item('pyrotech:material', 49),
        item('pyrotech:material', 50),
        item('pyrotech:material', 51),
        item('pyrotech:material', 52),
        item('pyrotech:material', 54),
        item('pyrotech:cobblestone', 3),
        item('pyrotech:bucket_wood'),
        item('pyrotech:bucket_stone'),
        item('pyrotech:bucket_refractory_unfired'),
        item('pyrotech:bucket_refractory'),
        item('pyrotech:matchstick'),
        item("pyrotech:crafting_table_template"),
        item('pyrotech:flint_and_tinder'),
        item('pyrotech:straw_bed'),
        item('pyrotech:limestone'),
        item('pyrotech:furnace_core'),
        item('pyrotech:refractory_door'),
        item('pyrotech:refractory_glass'),
        item('pyrotech:igniter'),
        item('pyrotech:igniter', 1),
        item('pyrotech:stone_tank'),
        item('pyrotech:brick_tank'),
        item('pyrotech:faucet_brick'),
        item('pyrotech:tar_collector', 1),
        item('pyrotech:tar_drain', 1),
        item('pyrotech:bloomery'),
        item('pyrotech:wither_forge'),
        item('pyrotech:pyroberry_seeds'),
        item('pyrotech:gloamberry_seeds'),
        item('pyrotech:freckleberry_seeds'),
        item('pyrotech:pyroberries'),
        item('pyrotech:gloamberries'),
        item('pyrotech:freckleberries'),
        item('pyrotech:pyroberry_wine'),
        item('pyrotech:gloamberry_wine'),
        item('pyrotech:freckleberry_wine'),
        item('pyrotech:pyroberry_cocktail'),
        item('pyrotech:fluid.liquid_clay'),
        item('pyrotech:fluid.pyroberry_wine'),
        item('pyrotech:fluid.gloamberry_wine'),
        item('pyrotech:fluid.freckleberry_wine'),
        item('forge:bucketfilled').withNbt(['FluidName': 'liquid_clay', 'Amount': 1000]),
        item('forge:bucketfilled').withNbt(['FluidName': 'pyroberry_wine', 'Amount': 1000]),
        item('forge:bucketfilled').withNbt(['FluidName': 'gloamberry_wine', 'Amount': 1000]),
        item('forge:bucketfilled').withNbt(['FluidName': 'freckleberry_wine', 'Amount': 1000]),
        item('pyrotech:pile_ash')
)

def furnace_removals = [
        item('pyrotech:bucket_refractory_unfired'),
        item('pyrotech:cobblestone', 3),
        item('pyrotech:rock', 7),
        item('pyrotech:material', 9),
        item('pyrotech:material', 28),
        item('pyrotech:material', 52)
]

for (item in furnace_removals) {
        furnace.removeByInput(item);
}

mods.pyrotech.pit_kiln.removeAll()
mods.pyrotech.stone_kiln.removeAll()
mods.pyrotech.brick_kiln.removeAll()
mods.pyrotech.anvil.removeAll()
mods.pyrotech.barrel.removeAll()

// Util closures
def kiln_add = { String name, IIngredient itemInput, ItemStack output, int burnTime, ArrayList<ItemStack> failureOutput,
                 ArrayList<Float> failureChance = [0.33, 0.08, 0.02], int tier = 0 ->

        def domain = "susy:"
        def prefix = ""
        switch(tier) {
                case 0:
                        mods.pyrotech.pit_kiln.recipeBuilder()
                                .name(domain + prefix + name)
                                .input(itemInput)
                                .output(output)
                                .burnTime(burnTime)
                                .failureChance(failureChance[0])
                                .failureOutput(failureOutput)
                                .register()
                        prefix = "pit_kiln/" + prefix
                case 1:
                        mods.pyrotech.stone_kiln.recipeBuilder()
                                .name(domain + prefix + name)
                                .input(itemInput)
                                .output(output)
                                .burnTime(burnTime.intdiv(2))
                                .failureChance(failureChance[1])
                                .failureOutput(failureOutput)
                                .register()
                        prefix = "stone_kiln/" + prefix
                default:
                        mods.pyrotech.brick_kiln.recipeBuilder()
                                .name(domain + prefix + name)
                                .input(itemInput)
                                .output(output)
                                .burnTime(burnTime.intdiv(5))
                                .failureChance(failureChance[2])
                                .failureOutput(failureOutput)
                                .register()
        }
}

def oven_remove = { String name, int tier = 0 ->

        def domain = "pyrotech:"
        def prefix = ""
        switch (tier) {
                case 0:
                        try {
                                mods.pyrotech.stone_oven.remove(domain + prefix + name)
                        } catch (Exception ignored) {}
                        prefix = "stone_oven/" + prefix
                default:
                        try {
                                mods.pyrotech.brick_oven.remove(domain + prefix + name)
                        } catch (Exception ignored) {}
        }
}

def oven_add = { String name, IIngredient itemInput, ItemStack output, int duration,
                 boolean isSuSyRecipe = false ->

    def domain = isSuSyRecipe ? "susy:" : "pyrotech:"
    def prefix = ""
    duration = duration.intdiv(8)
    mods.pyrotech.stone_oven.recipeBuilder()
            .name(domain + prefix + name)
                    .input(itemInput)
                    .output(output)
                    .duration(duration.intdiv(2))
                    .register()
    prefix = "stone_oven/" + prefix
    mods.pyrotech.brick_oven.recipeBuilder()
                    .name(domain + prefix + name)
                    .input(itemInput)
                    .output(output)
                    .duration(duration.intdiv(5))
                    .register()
}

def drying_remove = { String name, int tier = 0 ->

        def domain = "pyrotech:"
        def prefix = ""
        switch (tier) {
                case 0:
                        try {
                                mods.pyrotech.crude_drying_rack.remove(domain + prefix + name)
                        } catch (Exception ignored) {}
                        prefix = "crude_drying_rack/" + prefix
                default:
                        try {
                                mods.pyrotech.drying_rack.remove(domain + prefix + name)
                        } catch (Exception ignored) {}
                        prefix = "drying_rack/" + prefix
                        oven_remove(prefix + name)
        }
}

def drying_add = { String name, IIngredient itemInput, ItemStack output, int dryTime,
                   boolean addOvenRecipe = false, int tier = 0, boolean isSuSyRecipe = false ->

        def domain = isSuSyRecipe ? "susy:" : "pyrotech:"
        def prefix = ""
        switch(tier) {
                case 0:
                        mods.pyrotech.crude_drying_rack.recipeBuilder()
                                .name(domain + prefix + name)
                                .input(itemInput)
                                .output(output)
                                .dryTime(dryTime * 4) // since we have a 4 x speed boost in config
                                .register()
                        prefix = "crude_drying_rack/" + prefix
                default:
                        mods.pyrotech.drying_rack.recipeBuilder()
                                .name(domain + prefix + name)
                                .input(itemInput)
                                .output(output)
                                .dryTime(dryTime)
                                .register()
                        if (addOvenRecipe) {
                                prefix = "drying_rack/" + prefix
                                oven_add(prefix + name, itemInput, output, dryTime, isSuSyRecipe)
                        }
        }
}

def anvil_add = { String name, IIngredient itemInput, ItemStack output, int hits, boolean requiresHammer = true ->

        def domain = "susy:"
        def builder = mods.pyrotech.anvil.recipeBuilder()
                .name(domain + name)
                .input(itemInput)
                .output(output)
                .hits(hits)
                .tierGranite()
        if (requiresHammer) {
                builder.typeHammer()
        } else {
                builder.typePickaxe()
        }
        builder.register()
}

// Misc removals
mods.pyrotech.soaking_pot.remove("pyrotech:living_tar")
mods.pyrotech.soaking_pot.remove("pyrotech:flint_clay")
mods.pyrotech.soaking_pot.remove("pyrotech:clay_blasting")
mods.pyrotech.soaking_pot.remove("pyrotech:pulp_from_reeds")
mods.pyrotech.soaking_pot.remove("pyrotech:pulp_from_wood_chips")
mods.pyrotech.soaking_pot.remove("pyrotech:board_tarred")
mods.pyrotech.soaking_pot.remove("pyrotech:dough")
drying_remove("paper")

// Remove pyrotech limestone
mods.pyrotech.soaking_pot.remove("pyrotech:slaked_lime")
mods.pyrotech.compacting_bin.remove("pyrotech:ash_pile")

// Slaked lime
mods.pyrotech.soaking_pot.recipeBuilder()
        .name("susy:slaked_lime")
        .input(item('gregtech:meta_dust', 360))
        .fluidInput(fluid('water') * 50)
        .output(item('gregtech:meta_dust', 8100))
        .time(1)
        .campfireRequired(false)
        .register()

// Ash
// Ash -> ceu ash
crafting.addShapeless("susy:ash_to_ashes", item('gregtech:meta_dust', 254), [
        item('pyrotech:material')
])

// Wood chips
// Wood chips -> ceu wood pulp
crafting.addShapeless("susy:wood_chips_to_wood_plup", item('gregtech:meta_dust', 1617), [
        item('pyrotech:rock', 7)
])

// Wood pulp compating
mods.pyrotech.compacting_bin.remove("pyrotech:pile_wood_chips")
mods.pyrotech.compacting_bin.add("pyrotech:pile_wood_chips", item('gregtech:meta_dust', 1617) * 4, item('pyrotech:pile_wood_chips'), 4)

// Paper chad from wood pulp
mods.pyrotech.soaking_pot.recipeBuilder()
        .name("susy:chad_from_wood")
        .input(item('gregtech:meta_dust', 1617))
        .fluidInput(fluid('water') * 200)
        .output(item('gregtech:meta_dust', 1618))
        .time(1)
        .campfireRequired(false)
        .register()

// Straw
crafting.addShapeless("susy:cutting_wheat", item('pyrotech:material', 2), [
        item('minecraft:wheat'),
        ore('craftingToolKnife')
])

crafting.replaceShaped("pyrotech:straw", item('pyrotech:material', 2) * 4, [
        [item('pyrotech:material', 13), item('pyrotech:material', 13), item('pyrotech:material', 13)],
        [item('pyrotech:material', 13), ore('twine'), item('pyrotech:material', 13)],
        [item('pyrotech:material', 13), item('pyrotech:material', 13), item('pyrotech:material', 13)]
])

// Durable spindle
crafting.replaceShaped("pyrotech:bow_drill_durable_stick", item('pyrotech:material', 48), [
        [item('pyrotech:material', 39)],
        [ore('stickLongWood')]
])

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
crafting.addShaped("pyrotech:tech/machine/mechanical_hopper_with_gear", item('pyrotech:mechanical_hopper')
        .withNbt(['BlockEntityTag': ['id': 'pyrotech:tile.tilestonehopper', 'ForgeCaps': [], 'cogStackHandler': [
                'Items': [['Slot': 0, 'id': 'pyrotech:cog_stone', 'Count': 1, 'Damage': (short) 0]], 'Size': 1]
        ], 'display': ['Lore': ['With Stone Gear']]]), [
        [item('pyrotech:material', 16), null, item('pyrotech:material', 16)],
        [item('pyrotech:material', 16), item('pyrotech:cog_stone'), item('pyrotech:material', 16)],
        [null, item('pyrotech:material', 16), null]
])

// Refractory brick
// Inter-conversion using Chisel
mods.chisel.carving.addGroup("fire_bricks")
mods.chisel.carving.addVariation("fire_bricks", item('gregtech:metal_casing', 1))
mods.chisel.carving.addVariation("fire_bricks", item('pyrotech:refractory_brick_block'))

// Mud brick
drying_add("mudbrick", item('gregtechfoodoption:gtfo_meta_item', 43), item('gregtechfoodoption:gtfo_meta_item', 44), 14400, true, 1, true)

// Kiln recipes
def kiln_recipes = [
        // Brick
        ["brick", item('gregtech:meta_item_1', 349), item('minecraft:brick'), 2400, [
                item('pyrotech:material', 7), item('pyrotech:material', 6), item('gregtech:meta_dust', 254) * 2
        ]],

        // Coke oven brick
        ["coke_oven_brick", item('gregtech:meta_item_1', 350), item('gregtech:meta_item_1', 353), 2400, [
                item('gregtech:meta_item_1', 350), item('gregtech:meta_dust', 2063), item('gregtech:meta_dust', 254) * 2
        ], [1, 0.05, 0.01], 1],

        // Fire brick
        ["fire_brick", item('gregtech:meta_item_1', 351), item('gregtech:meta_item_1', 352), 3000, [
                item('gregtech:meta_item_1', 351), item('gregtech:meta_dust', 2525), item('gregtech:meta_dust', 254) * 2
        ], [1, 0.15, 0.02], 1],

        // Quicklime
        ["quicklime", ore('dustLimestone'), item('gregtech:meta_dust', 360), 2400, [
                item('gregtech:meta_dust', 254) * 2
        ], [0.0, 0.0, 0.0], 1],

        // Misc recipes
        ["cob", item('pyrotech:cob_wet'), item('pyrotech:cob_dry'), 2400, [
                item('biomesoplenty:mudball') * 3, item('gregtech:meta_dust', 254) * 2
        ]],
        ["stone", item('minecraft:cobblestone'), item('minecraft:stone'), 2400, [
                item('pyrotech:rock') * 3, item('gregtech:meta_dust', 254) * 2
        ]],
        ["stone_andesite", item('pyrotech:cobblestone'), item('minecraft:stone', 5), 2400, [
                item('pyrotech:rock') * 3, item('gregtech:meta_dust', 254) * 2
        ]],
        ["stone_granite", item('pyrotech:cobblestone', 2), item('minecraft:stone', 1), 2400, [
                item('pyrotech:rock') * 3, item('gregtech:meta_dust', 254) * 2
        ]],
        ["stone_diorite", item('pyrotech:cobblestone', 1), item('minecraft:stone', 3), 2400, [
                item('pyrotech:rock') * 3, item('gregtech:meta_dust', 254) * 2
        ]],
        ["hardened_clay", item('minecraft:clay'), item('minecraft:hardened_clay'), 2400, [
                item('pyrotech:material', 7), item('pyrotech:material', 6), item('gregtech:meta_dust', 254) * 2
        ]],
        ["bucket_clay", item('pyrotech:bucket_clay_unfired'), item('pyrotech:bucket_clay'), 2400, [
                item('pyrotech:material', 7), item('pyrotech:material', 6), item('gregtech:meta_dust', 254) * 2
        ]],
        ["stone_slab", item('minecraft:stone_slab', 3), item('minecraft:stone_slab'), 2400, [
                item('minecraft:stone_slab', 3), item('pyrotech:rock') * 3, item('gregtech:meta_dust', 254) * 2
        ]]
]

kiln_recipes.forEach { recipe ->
        kiln_add(*recipe)
}

// Misc anvil recipes
def anvil_recipes = [
        ["andesite_to_cobbled", item('minecraft:stone', 5), item('pyrotech:cobblestone'), 2],
        ["granite_to_cobbled", item('minecraft:stone', 1), item('pyrotech:cobblestone', 2), 2],
        ["diorite_to_cobbled", item('minecraft:stone', 3), item('pyrotech:cobblestone', 1), 2],
        ["flour_from_wheat", ore('itemWheat').or(ore('cropWheat')), metaitem('dustWheat'), 1],
        ["brick_stone", ore('stone'), item('pyrotech:material', 16) * 4, 2, false],
        ["stick_stone", item('pyrotech:material', 16), item('pyrotech:material', 27) * 2, 2, false],
        ["bone_shard", ore('bone'), item('pyrotech:material', 11) * 3, 2],
        ["iron_shard", ore('ingotIron'), item('pyrotech:material', 19) * 9, 2],
        ["gold_shard", ore('ingotGold'), item('pyrotech:material', 34) * 9, 2],
        ["diamond_shard", ore('gemDiamond'), item('pyrotech:material', 18) * 9, 4],
        ["coal_pieces", ore('gemCoal'), item('pyrotech:material', 21) * 8, 2],
        ["charcoal_flakes", ore('charcoal'), item('pyrotech:material', 15) * 8, 2],
        ["cobblestone_to_rocks", ore('cobblestone'), item('pyrotech:rock') * 8, 2, false],
        ["limestone_to_cobbled", ore('stoneLimestone'), item('susy:susy_stone_cobble', 2), 2],
        ["limestone_dust", item('susy:susy_stone_cobble', 2), item('gregtech:meta_dust', 27202), 2],
        ["pottery_shard_to_dust", item('pyrotech:material', 7), metaitem('dustSmallBrick') * 2, 1],
        ["pottery_fragments_to_dust", item('pyrotech:material', 6), metaitem('dustSmallBrick') * 2, 1]
]

anvil_recipes.forEach { recipe ->
        anvil_add(*recipe)
}

// Machines
// Stone machines

// Stone oven
crafting.replaceShaped("pyrotech:tech/machine/stone_oven", item('pyrotech:stone_oven'), [
        [item('pyrotech:masonry_brick_block'), item('pyrotech:material', 16), item('pyrotech:masonry_brick_block')],
        [item('pyrotech:masonry_brick_block'), ore('craftingToolHardHammer'), item('pyrotech:masonry_brick_block')],
        [item('pyrotech:masonry_brick_block'), item('pyrotech:masonry_brick_block'), item('pyrotech:masonry_brick_block')]
])

// Stone kiln
crafting.replaceShaped("pyrotech:tech/machine/stone_kiln", item('pyrotech:stone_kiln'), [
        [item('pyrotech:masonry_brick_block'), ore('stickStone'), item('pyrotech:masonry_brick_block')],
        [item('pyrotech:masonry_brick_block'), ore('craftingToolHardHammer'), item('pyrotech:masonry_brick_block')],
        [item('pyrotech:masonry_brick_block'), item('pyrotech:masonry_brick_block'), item('pyrotech:masonry_brick_block')]
])

// Misc machines
// Trip Hammer
crafting.replaceShaped("pyrotech:tech/machine/trip_hammer", item('pyrotech:trip_hammer'), [
        [item('pyrotech:material', 16), ore('plankTreatedWood'), item('pyrotech:material', 16)],
        [ore('plankTreatedWood'),  ore('gearSmallBronze'), ore('plankTreatedWood')],
        [item('pyrotech:masonry_brick_block'), ore('springSmallCopper'), item('pyrotech:masonry_brick_block')]
])

// Soaking pot
crafting.replaceShaped("pyrotech:tech/basic/soaking_pot", item('pyrotech:soaking_pot'), [
        [item('pyrotech:material', 16),  null, item('pyrotech:material', 16)],
        [ore('plankWood'), item('pyrotech:material', 16), ore('plankWood')]
])

// Barrel lid
crafting.replaceShaped("pyrotech:tech/basic/barrel_lid", item('pyrotech:barrel_lid'), [
        [ore('craftingToolSaw')],
        [ore('slabTreatedWood')]
])

// Barrel
crafting.replaceShaped("pyrotech:tech/basic/barrel", item('pyrotech:barrel'), [
        [ore('plankTreatedWood'), null, ore('plankTreatedWood')],
        [ore('plankTreatedWood'), ore('craftingToolSaw'), ore('plankTreatedWood')],
        [ore('plankTreatedWood'), ore('plankTreatedWood'), ore('plankTreatedWood')]
])

// Durable stash
crafting.replaceShaped("pyrotech:storage/stash_durable", item('pyrotech:stash_stone'), [
        [ore('slabTreatedWood'), null, ore('slabTreatedWood')],
        [item('pyrotech:material', 16), ore('slabTreatedWood'), item('pyrotech:material', 16)]
])

// Durable shelf
crafting.replaceShaped("pyrotech:storage/shelf_durable", item('pyrotech:shelf_stone'), [
        [item('pyrotech:material', 16), ore('slabTreatedWood'), item('pyrotech:material', 16)],
        [ore('plankTreatedWood'), ore('slabTreatedWood'), ore('plankTreatedWood')],
        [item('pyrotech:material', 16), ore('slabTreatedWood'), item('pyrotech:material', 16)]
])

// Durable crate
crafting.replaceShaped("pyrotech:storage/crate_durable", item('pyrotech:crate_stone'), [
        [item('pyrotech:material', 16), ore('plankTreatedWood'), item('pyrotech:material', 16)],
        [ore('plankTreatedWood'), ore('slabTreatedWood'), ore('plankTreatedWood')],
        [item('pyrotech:material', 16), ore('plankTreatedWood'), item('pyrotech:material', 16)]
])

// Brick machines
// Brick oven
crafting.replaceShaped("pyrotech:tech/machine/brick_oven", item('pyrotech:brick_oven'), [
        [ore('plateIron'), item('gregtech:meta_item_1', 352), ore('plateIron')],
        [item('gregtech:metal_casing', 1), ore('craftingToolHardHammer'), item('gregtech:metal_casing', 1)],
        [ore('plateIron'), item('gregtech:metal_casing', 1), ore('plateIron')]
])

// Brick kiln
crafting.replaceShaped("pyrotech:tech/machine/brick_kiln", item('pyrotech:brick_kiln'), [
        [ore('plateIron'), ore('frameGtIron'), ore('plateIron')],
        [item('gregtech:metal_casing', 1), ore('craftingToolHardHammer'), item('gregtech:metal_casing', 1)],
        [ore('plateIron'), item('gregtech:metal_casing', 1), ore('plateIron')]
])

// Smelter recipes
// Ore metallurgy
oreDict.add("flakeCoal", item('pyrotech:material', 15))
oreDict.add("flakeCharcoal", item('pyrotech:material', 21))

class Reductant {
    String name
    int consumption
    float duration_multiplier
    Reductant(String name, int consumption, float multiplier) {
        this.name = name
        this.consumption = consumption
        this.duration_multiplier = multiplier
    }

    IIngredient get() {
        return ore(name) * consumption
    }
}

class Prefix {
    String name
    float duration_multiplier
    Prefix(String name, float multiplier) {
        this.name = name
        this.duration_multiplier = multiplier
    }
}

class Ore {
    String name
    String output
    int duration
    int output_multiplier
    String byproduct
    int byproduct_amount
    Ore(String name, String output, int duration = 400, int output_multiplier = 1, String byproduct = null, int byproduct_amount = 0) {
        this.name = name
        this.output = output
        this.duration = duration
        this.output_multiplier = output_multiplier
        this.byproduct = byproduct
        this.byproduct_amount = byproduct_amount
    }

    IIngredient get(Prefix prefix) {
        return ore(prefix.name + name) * 8
    }

    ItemStack getOutput() {
        return metaitem("ingot" + output) * output_multiplier * 8
    }

    int getDuration(Reductant reductant, Prefix prefix) {
        return  (int) duration * reductant.duration_multiplier * prefix.duration_multiplier
    }

    ItemStack getByproduct() {
        return byproduct == null ? null : (item(byproduct) * byproduct_amount)
    }
}

def reductants = [
        new Reductant("charcoal", 12, 1),
        new Reductant("gemCoal", 10, 1), // Standard consumption, 10 = 8 + 2
        new Reductant("gemLigniteCoke", 12, 1.2),
        new Reductant("fuelCoke", 8, 0.8),
        new Reductant("gemAnthracite", 8, 0.75),
        new Reductant("dustCharcoal", 12, 0.95),
        new Reductant("dustCoal", 10, 0.9),
        new Reductant("dustLigniteCoke", 12, 1),
        new Reductant("dustCoke", 8, 0.75),
        new Reductant("dustAnthracite", 8, 0.7),
        new Reductant("flakeCharcoal", 96, 0.95),
        new Reductant("flakeCoal", 80, 0.9)
]

def prefixes = [
        new Prefix("ore", 1),
        new Prefix("crushed", 0.5)
]

def ores = [
        // Copper ores
        new Ore("Malachite", "Copper"),
        new Ore("Tetrahedrite", "Copper"),
//        new Ore("Chalcopyrite", "Copper"),
        new Ore("Bornite", "Copper"),
        new Ore("Chalcocite", "Copper"),

        // Lead ores
        new Ore("Cerussite", "Lead"),
        new Ore("Anglesite", "Lead"),
        new Ore("Galena", "Lead"),

        // Zinc ores
        new Ore("Smithsonite", "Zinc"),
        new Ore("Sphalerite", "Zinc")
]

// Ore smashing
ores.forEach { oreIn ->
    mods.pyrotech.anvil.recipeBuilder()
            .name("supersymmetry:" + oreIn.name.toLowerCase())
            .input(ore("ore" + oreIn.name))
            .output(metaitem("crushed" + oreIn.name))
            .typeHammer()
            .hits(2)
            .tierGranite()
            .register()
}

// Actual ore smelting
SMELTER = recipemap('primitive_smelter')

reductants.forEach { reductant ->
    ores.forEach { oreIn ->
        prefixes.forEach { prefix ->
            def builder = SMELTER.recipeBuilder()
                    .inputs(oreIn.get(prefix))
                    .inputs(reductant.get())
                    .duration(oreIn.getDuration(reductant, prefix))
                    .outputs(oreIn.getOutput())
            if (oreIn.getByproduct() != null) {
                    builder.outputs(oreIn.getByproduct())
            }
            builder.buildAndRegister()
        }
    }
}

// Smelter alloying recipes
// Bronze
