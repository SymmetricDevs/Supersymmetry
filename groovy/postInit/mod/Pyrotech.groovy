package postInit.mod

import com.cleanroommc.groovyscript.api.IIngredient
import com.codetaylor.mc.pyrotech.library.spi.block.IBlockIgnitableWithIgniterItem
import com.codetaylor.mc.pyrotech.modules.tech.basic.ModuleTechBasic
import com.codetaylor.mc.pyrotech.modules.tech.basic.block.BlockKilnPit
import globals.Globals
import globals.RecyclingHelper
import gregtech.api.items.metaitem.MetaItem
import gregtech.api.items.metaitem.stats.IItemBehaviour
import gregtech.api.util.GTUtility
import gregtech.common.items.behaviors.LighterBehaviour
import net.minecraft.util.EnumHand
import net.minecraftforge.event.entity.player.PlayerInteractEvent
import net.minecraftforge.event.world.BlockEvent
import net.minecraftforge.fml.common.eventhandler.Event

log.infoMC("Running Pyrotech.groovy...")

SMELTER = recipemap('primitive_smelter')
ALLOY_SMELTER = recipemap('alloy_smelter')
CUTTER = recipemap('cutter')
ASSEMBLER = recipemap('assembler')
CHEMICAL_BATH = recipemap('chemical_bath')

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

// Allow igniting pyrotech furnaces with GT items
eventManager.listen { PlayerInteractEvent.RightClickBlock event ->

    World world = event.getWorld()
    BlockPos pos = event.getPos()
    EnumFacing facing = event.getFace()
    EntityPlayer player = event.getEntityPlayer()
    IBlockState blockState = world.getBlockState(pos)
    Block block = blockState.getBlock()

    if (block instanceof IBlockIgnitableWithIgniterItem) {
        def ignitable = (IBlockIgnitableWithIgniterItem) block
        ItemStack stack = event.getItemStack()
        Item item = stack.getItem()

        if (item instanceof MetaItem) {
            def metaItem = (MetaItem) item
            for (IItemBehaviour behaviour : metaItem.getBehaviours(stack)) {
                if (behaviour instanceof LighterBehaviour) {
                    NBTTagCompound compound = GTUtility.getOrCreateNbtCompound(stack)
                    if (stack.isItemEqual(metaitem('tool.matches'))     // Special checks for non-openable igniters
                            || stack.isItemEqual(metaitem('tool.matchbox')) // WTF why is canOpen field privite
                            || compound.getBoolean(LighterBehaviour.LIGHTER_OPEN)) {
                        def lighterBehaviour = (LighterBehaviour) behaviour
                        lighterBehaviour.consumeFuel(player, stack)
                        ignitable.igniteWithIgniterItem(world, pos, blockState, facing)
                        event.setUseItem(Event.Result.DENY)
                        return
                    }
                    break
                }
            }
        }
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
        "pyrotech:stone_hammer",
        "pyrotech:flint_hammer",
        "pyrotech:flint_hammer_durable",
        "pyrotech:bone_hammer",
        "pyrotech:bone_hammer_durable",
        "pyrotech:iron_hammer",
        "pyrotech:gold_hammer",
        "pyrotech:diamond_hammer",
        "pyrotech:obsidian_hammer",
        "pyrotech:tech/bloomery/tongs_stone",
        "pyrotech:tech/bloomery/tongs_flint",
        "pyrotech:tech/bloomery/tongs_bone",
        "pyrotech:tech/bloomery/tongs_iron",
        "pyrotech:tech/bloomery/tongs_gold",
        "pyrotech:tech/bloomery/tongs_diamond",
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
        "pyrotech:saddle",
        "pyrotech:leather_helmet",
        "pyrotech:leather_chestplate",
        "pyrotech:leather_leggings",
        "pyrotech:leather_boots",
        "pyrotech:item_frame",
        "pyrotech:book",
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
        "pyrotech:stone_sword",
        "pyrotech:stone_shovel",
        "pyrotech:stone_pickaxe",
        "pyrotech:stone_axe",
        "pyrotech:stone_hoe",
        "pyrotech:cobbled_limestone",
        "pyrotech:cobbled_andesite",
        "pyrotech:cobbled_diorite",
        "pyrotech:cobbled_granite",
        "pyrotech:crafting_table_template",
        "pyrotech:furnace_core",
        "pyrotech:furnace",
        "pyrotech:cookie_dough",
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
        item('pyrotech:flint_hammer'),
        item('pyrotech:flint_hammer_durable'),
        item('pyrotech:bone_hammer'),
        item('pyrotech:bone_hammer_durable'),
        item('pyrotech:iron_hammer'),
        item('pyrotech:gold_hammer'),
        item('pyrotech:diamond_hammer'),
        item('pyrotech:obsidian_hammer'),
        item('pyrotech:tongs_stone'),
        item('pyrotech:tongs_flint'),
        item('pyrotech:tongs_bone'),
        item('pyrotech:tongs_iron'),
        item('pyrotech:tongs_gold'),
        item('pyrotech:tongs_diamond'),
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
        item('pyrotech:material', 18),
        item('pyrotech:material', 19),
        item('pyrotech:material', 20),
        item('pyrotech:material', 22),
        item('pyrotech:material', 23),
        item('pyrotech:material', 24),
        item('pyrotech:material', 25),
        item('pyrotech:material', 28),
        item('pyrotech:material', 31),
        item('pyrotech:material', 33),
        item('pyrotech:material', 34),
        item('pyrotech:material', 35),
        item('pyrotech:material', 36),
        item('pyrotech:material', 37),
        item('pyrotech:material', 49),
        item('pyrotech:material', 50),
        item('pyrotech:material', 51),
        item('pyrotech:material', 52),
        item('pyrotech:material', 53),
        item('pyrotech:material', 54),
        item('pyrotech:cobblestone', 3),
        item('pyrotech:bucket_wood'),
        item('pyrotech:bucket_stone'),
        item('pyrotech:bucket_refractory_unfired'),
        item('pyrotech:bucket_refractory'),
        item('pyrotech:matchstick'),
        item("pyrotech:crafting_table_template"),
        item('pyrotech:straw_bed'),
        item('pyrotech:limestone'),
        item('pyrotech:furnace_core'),
        item('pyrotech:refractory_door'),
        item('pyrotech:refractory_glass'),
        item('pyrotech:mud_layer'),
        item('pyrotech:mud'),
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
        item('pyrotech:material', 52),
        item('pyrotech:material', 53)
]

for (item in furnace_removals) {
        furnace.removeByInput(item);
}

mods.pyrotech.pit_kiln.removeAll()
mods.pyrotech.stone_kiln.removeAll()
mods.pyrotech.brick_kiln.removeAll()
mods.pyrotech.anvil.removeAll()
mods.pyrotech.barrel.removeAll()
mods.pyrotech.stone_oven.removeAll()
mods.pyrotech.brick_oven.removeAll()

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

def oven_add = { String name, IIngredient itemInput, ItemStack output, int duration ->

    def domain = "susy:"
    def prefix = ""
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
                                oven_add(prefix + name, itemInput, output, dryTime)
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
mods.pyrotech.soaking_pot.remove("pyrotech:mud_clump")
drying_remove("paper")

// Remove pyrotech limestone
mods.pyrotech.soaking_pot.remove("pyrotech:slaked_lime")
mods.pyrotech.compacting_bin.remove("pyrotech:ash_pile")

// Stack size changes
item('pyrotech:cog_stone').Item.setMaxStackSize(16)
item('pyrotech:cog_flint').Item.setMaxStackSize(16)
item('pyrotech:cog_iron').Item.setMaxStackSize(16)
item('pyrotech:cog_gold').Item.setMaxStackSize(16)
item('pyrotech:cog_diamond').Item.setMaxStackSize(16)

// Slaked lime
mods.pyrotech.soaking_pot.recipeBuilder()
        .name("susy:slaked_lime")
        .input(metaitem('dustQuicklime'))
        .fluidInput(fluid('water') * 50)
        .output(metaitem('dustCalciumHydroxide'))
        .time(1)
        .campfireRequired(false)
        .register()

// Wet Cob
crafting.replaceShaped("pyrotech:cob_3x3", item('pyrotech:cob_wet') * 4, [
        [ore('ballMud'), ore('ballMud'), ore('ballMud')],
        [ore('ballMud'), ore('straw'), ore('ballMud')],
        [ore('ballMud'), ore('ballMud'), ore('ballMud')]
])

crafting.replaceShapeless("pyrotech:cob_2x2b", item('pyrotech:cob_wet') * 16, [
        item('pyrotech:thatch'), ore('blockMud'), ore('blockMud'), ore('blockMud')
])

// Ash
// Ash -> ceu ash
crafting.addShapeless("susy:ash_to_ashes", metaitem('dustAsh'), [
        item('pyrotech:material')
])

// Wood chips
// Wood chips -> ceu wood pulp
crafting.addShapeless("susy:wood_chips_to_wood_plup", metaitem('dustWood'), [
        item('pyrotech:rock', 7)
])

// Wood pulp compating
mods.pyrotech.compacting_bin.remove("pyrotech:pile_wood_chips")
mods.pyrotech.compacting_bin.add("pyrotech:pile_wood_chips", metaitem('dustWood') * 4, item('pyrotech:pile_wood_chips'), 4)

// Paper chad from wood pulp
mods.pyrotech.soaking_pot.recipeBuilder()
        .name("susy:chad_from_wood")
        .input(metaitem('dustWood'))
        .fluidInput(fluid('water') * 200)
        .output(metaitem('dustPaper'))
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

// Durable Bow Drill
crafting.replaceShaped("pyrotech:bow_drill_durable", item('pyrotech:bow_drill_durable'), [
        [ore('string'), ore('stickWood'), ore('craftingToolKnife')],
        [ore('string'), item('pyrotech:material', 39), ore('stickStone')],
        [ore('string'), ore('stickWood'), null]
])

// Durable spindle
crafting.replaceShaped("pyrotech:bow_drill_durable_stick", item('pyrotech:material', 48), [
        [ore('craftingToolKnife'), item('pyrotech:material', 39)],
        [null, ore('stickLongWood')]
])

// Bow drill
crafting.replaceShaped("pyrotech:ignition/bow_drill", item('pyrotech:bow_drill'), [
        [item('pyrotech:material', 14), ore('stickWood'), ore('craftingToolKnife')],
        [item('pyrotech:material', 14), ore('stickLongWood'), ore('stickWood')],
        [item('pyrotech:material', 14), ore('stickWood'), null]
])

// Empty wooden form
crafting.addShaped("susy:wooden_form_from_chopping", metaitem('wooden_form.empty'), [
        [ore('toolAxe')],
        [ore('plankWood')]
])

// Clay bucket
crafting.replaceShaped("pyrotech:bucket/bucket_clay_unfired", item('pyrotech:bucket_clay_unfired'), [
        [metaitem('compressed.clay'), null, metaitem('compressed.clay')],
        [null, metaitem('compressed.clay'), null]
])

// Gears
RecyclingHelper.addShapeless("susy:cog_stone", item('pyrotech:cog_stone'), [metaitem('gearStone')])
RecyclingHelper.replaceShapeless("pyrotech:tech/machine/cog_iron", item('pyrotech:cog_iron'), [metaitem('gearIron')])
RecyclingHelper.replaceShapeless("pyrotech:tech/machine/cog_gold", item('pyrotech:cog_gold'), [metaitem('gearGold')])
RecyclingHelper.replaceShapeless("pyrotech:tech/machine/cog_diamond", item('pyrotech:cog_diamond'), [metaitem('gearDiamond')])

oreDict.add("gearStone", item('pyrotech:cog_stone'))
oreDict.add("gearIron", item('pyrotech:cog_iron'))
oreDict.add("gearGold", item('pyrotech:cog_gold'))
oreDict.add("gearDiamond", item('pyrotech:cog_diamond'))

crafting.addShapeless("susy:cog_stone_to_gear", metaitem('gearStone'), [item('pyrotech:cog_stone')])
crafting.addShapeless("susy:cog_iron_to_gear", metaitem('gearIron'), [item('pyrotech:cog_iron')])
crafting.addShapeless("susy:cog_gold_to_gear", metaitem('gearGold'), [item('pyrotech:cog_gold')])
crafting.addShapeless("susy:cog_diamond_to_gear", metaitem('gearDiamond'), [item('pyrotech:cog_diamond')])

// Leather ingredients
// Leather Sheet
crafting.addShaped("susy:leather_sheet", item('pyrotech:material', 38), [
        [ore('craftingToolKnife')],
        [ore('leather')]
])

CUTTER.recipeBuilder()
        .inputs(ore('leather'))
        .outputs(item('pyrotech:material', 38))
        .chancedOutput(item('pyrotech:material', 38), 5000, 0)
        .duration(80)
        .EUt(7)
        .buildAndRegister()

// Leather Strap
crafting.addShaped("susy:leather_strap", item('pyrotech:material', 39) * 2, [
        [ore('craftingToolKnife'), item('pyrotech:material', 38)]
])

CUTTER.recipeBuilder()
        .inputs(item('pyrotech:material', 38))
        .outputs(item('pyrotech:material', 39) * 4)
        .duration(50)
        .EUt(7)
        .buildAndRegister()

// Leather Cord
crafting.addShaped("susy:leather_cord", item('pyrotech:material', 40), [
        [item('pyrotech:material', 39)],
        [item('pyrotech:material', 39)],
        [item('pyrotech:material', 39)]
])

ASSEMBLER.recipeBuilder()
        .inputs(item('pyrotech:material', 39) * 2)
        .outputs(item('pyrotech:material', 40))
        .duration(100)
        .EUt(7)
        .buildAndRegister()

// Durable Leather ingredients
// Durable Leather
CHEMICAL_BATH.recipeBuilder()
        .inputs(ore('leather'))
        .fluidInputs(fluid('creosote') * 200)
        .outputs(item('pyrotech:material', 41))
        .duration(100)
        .EUt(30)
        .buildAndRegister()

// Durable Leather Sheet
crafting.addShaped("susy:leather_sheet_durable", item('pyrotech:material', 42), [
        [ore('craftingToolKnife')],
        [ore('leatherDurable')]
])

CUTTER.recipeBuilder()
        .inputs(ore('leatherDurable'))
        .outputs(item('pyrotech:material', 42))
        .chancedOutput(item('pyrotech:material', 42), 5000, 0)
        .duration(100)
        .EUt(16)
        .buildAndRegister()

CHEMICAL_BATH.recipeBuilder()
        .inputs(item('pyrotech:material', 38))
        .fluidInputs(fluid('creosote') * 200)
        .outputs(item('pyrotech:material', 42))
        .duration(80)
        .EUt(30)
        .buildAndRegister()

// Durable Leather Strap
crafting.addShaped("susy:leather_strap_durable", item('pyrotech:material', 43) * 2, [
        [ore('craftingToolKnife'), item('pyrotech:material', 42)]
])

CUTTER.recipeBuilder()
        .inputs(item('pyrotech:material', 42))
        .outputs(item('pyrotech:material', 43) * 4)
        .duration(80)
        .EUt(16)
        .buildAndRegister()

CHEMICAL_BATH.recipeBuilder()
        .inputs(item('pyrotech:material', 39))
        .fluidInputs(fluid('creosote') * 50)
        .outputs(item('pyrotech:material', 43))
        .duration(50)
        .EUt(7)
        .buildAndRegister()

// Durable Leather Cord
crafting.addShaped("susy:leather_cord_durable", item('pyrotech:material', 44), [
        [item('pyrotech:material', 43)],
        [item('pyrotech:material', 43)],
        [item('pyrotech:material', 43)]
])

ASSEMBLER.recipeBuilder()
        .inputs(item('pyrotech:material', 43) * 2)
        .outputs(item('pyrotech:material', 44))
        .duration(120)
        .EUt(16)
        .buildAndRegister()

CHEMICAL_BATH.recipeBuilder()
        .inputs(item('pyrotech:material', 40))
        .fluidInputs(fluid('creosote') * 100)
        .outputs(item('pyrotech:material', 44))
        .duration(80)
        .EUt(16)
        .buildAndRegister()

// Slag Heap
crafting.addShaped("susy:slag_heap", item('pyrotech:pile_slag'), [
        [item('pyrotech:slag'), item('pyrotech:slag'), item('pyrotech:slag')],
        [item('pyrotech:slag'), item('pyrotech:slag'), item('pyrotech:slag')],
        [item('pyrotech:slag'), item('pyrotech:slag'), item('pyrotech:slag')]
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

// Masonry brick slab
crafting.addShaped("susy:masonry_brick_slab", item('pyrotech:masonry_brick_slab') * 6, [
        [item('pyrotech:masonry_brick_block'), item('pyrotech:masonry_brick_block'), item('pyrotech:masonry_brick_block')]
])

// Refractory brick slab
crafting.addShaped("susy:refractory_brick_slab", item('pyrotech:refractory_brick_slab') * 6, [
        [item('pyrotech:refractory_brick_block'), item('pyrotech:refractory_brick_block'), item('pyrotech:refractory_brick_block')]
])

// Oven recipes
def oven_recipes = [
        // Mud brick
        ["mudbrick", metaitem('gregtechfoodoption:brick.adobe'), metaitem('gregtechfoodoption:brick.adobe_fired'), 1200],

        // Misc recipes
        ["straw", ore('cropWheat'), item('pyrotech:material', 2), 800],
        ["dried_fibers_from_fibers", item('pyrotech:material', 12), item('pyrotech:material', 13), 600],
        ["dried_fibers_from_saplings", ore('treeSapling'), item('pyrotech:material', 13), 600],
        ["sponge", item('minecraft:sponge', 1), item('minecraft:sponge'), 800],

        // Food recipes
        ["cooked_mince_meat_dust", metaitem('dustMeat'), metaitem('gregtechfoodoption:cooked_mince_meat_dust'), 2400],
        ["cooked_meat_ingot", metaitem('gregtechfoodoption:tough_meat_dust'), metaitem('gregtechfoodoption:cooked_meat_ingot'), 2400],
        ["bacon", metaitem('gregtechfoodoption:component.bacon'), metaitem('gregtechfoodoption:food.bacon'), 2400],
        ["baked_potato", ore('cropPotato'), item('minecraft:baked_potato'), 2400],
        ["cooked_beef", item('minecraft:beef'), item('minecraft:cooked_beef'), 2400],
        ["cooked_porkchop", item('minecraft:porkchop'), item('minecraft:cooked_porkchop'), 2400],
        ["cooked_mutton", item('minecraft:mutton'), item('minecraft:cooked_mutton'), 2400],
        ["cooked_chicken", item('minecraft:chicken'), item('minecraft:cooked_chicken'), 2400],
        ["cooked_rabbit", item('minecraft:rabbit'), item('minecraft:cooked_rabbit'), 2400],
        ["cooked_fish", item('minecraft:fish'), item('minecraft:cooked_fish'), 2400],
        ["cooked_salmon", item('minecraft:fish', 1), item('minecraft:cooked_fish', 1), 2400],
        ["toast", metaitem('gregtechfoodoption:food.bread_slice'), metaitem('gregtechfoodoption:food.toast'), 2400],
        ["bun", metaitem('gregtechfoodoption:component.bun'), metaitem('gregtechfoodoption:food.bun'), 2400],
        ["baguette", metaitem('gregtechfoodoption:component.baguette'), metaitem('gregtechfoodoption:food.baguette'), 2400],
        ["bread", metaitem('gregtechfoodoption:component.bread'), item('minecraft:bread'), 2400]
]

oven_recipes.forEach { recipe ->
    oven_add(*recipe)
}

// Kiln recipes
def kiln_recipes = [
        // Brick
        ["brick", metaitem('compressed.clay'), item('minecraft:brick'), 1200, [
                item('pyrotech:material', 7), item('pyrotech:material', 6), metaitem('dustAsh') * 2
        ]],

        // Coke oven brick
        ["coke_oven_brick", metaitem('compressed.coke_clay'), metaitem('brick.coke'), 1200, [
                metaitem('compressed.coke_clay'), metaitem('dustClay'), metaitem('dustAsh') * 2
        ], [1, 0.05, 0.01], 1],

        // Fire brick
        ["fire_brick", metaitem('compressed.fireclay'), metaitem('brick.fireclay'), 1500, [
                metaitem('compressed.fireclay'), metaitem('dustFireclay'), metaitem('dustAsh') * 2
        ], [1, 0.15, 0.02], 1],

        // Quicklime
        ["quicklime", ore('dustLimestone'), metaitem('dustQuicklime'), 1200, [
                metaitem('dustAsh') * 2
        ], [0.0, 0.0, 0.0], 1],

        // Wood ash
        ["wood_ash", ore('dustWood'), metaitem('dustWoodAsh'), 1200, [
                metaitem('dustSmallWoodAsh'), metaitem('dustTinyWoodAsh') * 3, metaitem('dustAsh') * 2
        ], [0.5, 0.15, 0.05]],

        // Stone recipes
        ["stone", item('minecraft:cobblestone'), item('minecraft:stone'), 1200, [
                item('pyrotech:rock') * 3, metaitem('dustAsh') * 2
        ]],
        ["stone_andesite", item('pyrotech:cobblestone'), item('minecraft:stone', 5), 1200, [
                item('pyrotech:rock') * 3, metaitem('dustAsh') * 2
        ]],
        ["stone_granite", item('pyrotech:cobblestone', 2), item('minecraft:stone', 1), 1200, [
                item('pyrotech:rock') * 3, metaitem('dustAsh') * 2
        ]],
        ["stone_diorite", item('pyrotech:cobblestone', 1), item('minecraft:stone', 3), 1200, [
                item('pyrotech:rock') * 3, metaitem('dustAsh') * 2
        ]],
        ["stone_black_granite", item('gregtech:stone_cobble'), item('gregtech:stone_smooth'), 1200, [
                item('pyrotech:rock') * 3, metaitem('dustAsh') * 2
        ]],
        ["stone_red_granite", item('gregtech:stone_cobble', 1), item('gregtech:stone_smooth', 1), 1200, [
                item('pyrotech:rock') * 3, metaitem('dustAsh') * 2
        ]],
        ["stone_marble", item('gregtech:stone_cobble', 2), item('gregtech:stone_smooth', 2), 1200, [
                item('pyrotech:rock') * 3, metaitem('dustAsh') * 2
        ]],
        ["stone_basalt", item('gregtech:stone_cobble', 3), item('gregtech:stone_smooth', 3), 1200, [
                item('pyrotech:rock') * 3, metaitem('dustAsh') * 2
        ]],
        ["stone_concrete_light", item('gregtech:stone_cobble', 4), item('gregtech:stone_smooth', 4), 1200, [
                item('pyrotech:rock') * 3, metaitem('dustAsh') * 2
        ]],
        ["stone_concrete_dark", item('gregtech:stone_cobble', 5), item('gregtech:stone_smooth', 5), 1200, [
                item('pyrotech:rock') * 3, metaitem('dustAsh') * 2
        ]],
        ["stone_gabbro", item('susy:susy_stone_cobble'), item('susy:susy_stone_smooth'), 1200, [
                item('pyrotech:rock') * 3, metaitem('dustAsh') * 2
        ]],
        ["stone_gneiss", item('susy:susy_stone_cobble', 1), item('susy:susy_stone_smooth', 1), 1200, [
                item('pyrotech:rock') * 3, metaitem('dustAsh') * 2
        ]],
        ["stone_limestone", item('susy:susy_stone_cobble', 2), item('susy:susy_stone_smooth', 2), 1200, [
                item('pyrotech:rock') * 3, metaitem('dustAsh') * 2
        ]],
        ["stone_phyllite", item('susy:susy_stone_cobble', 3), item('susy:susy_stone_smooth', 3), 1200, [
                item('pyrotech:rock') * 3, metaitem('dustAsh') * 2
        ]],
        ["stone_quartite", item('susy:susy_stone_cobble', 4), item('susy:susy_stone_smooth', 4), 1200, [
                item('pyrotech:rock') * 3, metaitem('dustAsh') * 2
        ]],
        ["stone_shale", item('susy:susy_stone_cobble', 5), item('susy:susy_stone_smooth', 5), 1200, [
                item('pyrotech:rock') * 3, metaitem('dustAsh') * 2
        ]],
        ["stone_shate", item('susy:susy_stone_cobble', 6), item('susy:susy_stone_smooth', 6), 1200, [
                item('pyrotech:rock') * 3, metaitem('dustAsh') * 2
        ]],
        ["stone_soapstone", item('susy:susy_stone_cobble', 7), item('susy:susy_stone_smooth', 7), 1200, [
                item('pyrotech:rock') * 3, metaitem('dustAsh') * 2
        ]],
        ["stone_kimberlite", item('susy:susy_stone_cobble', 8), item('susy:susy_stone_smooth', 8), 1200, [
                item('pyrotech:rock') * 3, metaitem('dustAsh') * 2
        ]],

        // Misc recipes
        ["cob", item('pyrotech:cob_wet'), item('pyrotech:cob_dry'), 1200, [
                item('biomesoplenty:mudball') * 3, metaitem('dustAsh') * 2
        ]],
        ["hardened_clay", item('minecraft:clay'), item('minecraft:hardened_clay'), 1200, [
                item('pyrotech:material', 7), item('pyrotech:material', 6), metaitem('dustAsh') * 2
        ]],
        ["bucket_clay", item('pyrotech:bucket_clay_unfired'), item('pyrotech:bucket_clay'), 1200, [
                item('pyrotech:material', 7), item('pyrotech:material', 6), metaitem('dustAsh') * 2
        ]],
        ["stone_slab", item('minecraft:stone_slab', 3), item('minecraft:stone_slab'), 1200, [
                item('minecraft:stone_slab', 3), item('pyrotech:rock') * 3, metaitem('dustAsh') * 2
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
        ["flint_shard", ore('gemFlint'), item('pyrotech:material', 10) * 3, 2],
        ["cobblestone_to_rocks", ore('cobblestone'), item('pyrotech:rock') * 8, 2, false],
        ["limestone_to_cobbled", ore('stoneLimestone'), item('susy:susy_stone_cobble', 2), 2],
        ["pig_iron_shearing", ore('ingotPigIron'), metaitem('ingotWroughtIron'), 2],
        ["limestone_dust", item('susy:susy_stone_cobble', 2), metaitem('dustLimestone'), 2],
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

// Primitive smelter
// Controller
crafting.addShaped("susy:primitive_smelter", metaitem('primitive_smelter'), [
        [ore('craftingToolHardHammer')],
        [item('pyrotech:masonry_brick_block')]
])

// Export
crafting.addShaped("susy:primitive_item_export_bus", metaitem('primitive_item_export'), [
        [item('pyrotech:masonry_brick_block')],
        [item('pyrotech:mechanical_hopper')]
])

// Import
crafting.addShaped("susy:primitive_item_import_bus", metaitem('primitive_item_import'), [
        [item('pyrotech:mechanical_hopper')],
        [item('pyrotech:masonry_brick_block')]
])

// Interconversion
crafting.addShaped("susy:primitive_bus_import_to_export", metaitem('primitive_item_export'), [
        [ore('craftingToolHardHammer')],
        [metaitem('primitive_item_import')]
])

crafting.addShaped("susy:primitive_bus_export_to_import", metaitem('primitive_item_import'), [
        [ore('craftingToolHardHammer')],
        [metaitem('primitive_item_export')]
])

// Misc machines
// Trip Hammer
crafting.replaceShaped("pyrotech:tech/machine/trip_hammer", item('pyrotech:trip_hammer'), [
        [item('pyrotech:material', 16), ore('plankTreatedWood'), item('pyrotech:material', 16)],
        [ore('plankTreatedWood'),  null, ore('plankTreatedWood')],
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

// Anvil
crafting.replaceShapeless("pyrotech:tech/basic/anvil_granite", item('pyrotech:anvil_granite'), [
        ore('slabStone')
])

// Brick machines
// Brick oven
crafting.replaceShaped("pyrotech:tech/machine/brick_oven", item('pyrotech:brick_oven'), [
        [ore('plateIron'), metaitem('brick.fireclay'), ore('plateIron')],
        [item('gregtech:metal_casing', 1), ore('craftingToolHardHammer'), item('gregtech:metal_casing', 1)],
        [ore('plateIron'), item('gregtech:metal_casing', 1), ore('plateIron')]
])

// Brick kiln
crafting.replaceShaped("pyrotech:tech/machine/brick_kiln", item('pyrotech:brick_kiln'), [
        [ore('plateIron'), ore('frameGtIron'), ore('plateIron')],
        [item('gregtech:metal_casing', 1), ore('craftingToolHardHammer'), item('gregtech:metal_casing', 1)],
        [ore('plateIron'), item('gregtech:metal_casing', 1), ore('plateIron')]
])

// Coal
mods.pyrotech.anvil.recipeBuilder()
        .name("susy:coal_deposit")
        .input(ore('oreCoalDeposit'))
        .output(item('minecraft:coal') * 8)
        .typeHammer()
        .hits(2)
        .tierGranite()
        .register()

// Native Copper
mods.pyrotech.anvil.recipeBuilder()
        .name("susy:native_copper_deposit")
        .input(ore('oreNativeCopperDeposit'))
        .output(metaitem('native_copper') * 8)
        .typeHammer()
        .hits(2)
        .tierGranite()
        .register()

def materials = [
        "Stone",
        "Flint",
        "Iron",
        "Gold",
        "Diamond"
]

// Smelter recipes
// Ore metallurgy

class Reductant {
    String name
    int consumption
    float duration_multiplier
    Reductant(String name, int consumption, float multiplier) {
        this.name = name
        this.consumption = consumption
        this.duration_multiplier = multiplier
    }

    IIngredient get(Ore oreIn, Prefix prefix) {
        return ore(name) * (consumption * (prefix.name == "ore" ? oreIn.output_multiplier : 1))
    }
}

class Prefix {
    String name
    float duration_multiplier
    int byproduct_amount
    Prefix(String name, float multiplier, int byproduct_amount = 0) {
        this.name = name
        this.duration_multiplier = multiplier
        this.byproduct_amount = byproduct_amount
    }
}

class Ore {
    String name
    String output
    int output_multiplier
    int duration
    String byproduct
    Ore(String name, String output, int output_multiplier = 1, String byproduct = "pyrotech:slag", int duration = 200) {
        this.name = name
        this.output = output
        this.output_multiplier = output_multiplier
        this.duration = duration
        this.byproduct = byproduct
    }

    IIngredient get(Prefix prefix) {
        return ore(prefix.name + name) * 8
    }

    ItemStack getOutput(Prefix prefix) {
        return metaitem("ingot" + output) * ((prefix.name == "ore" ? output_multiplier : 1) * 8)
    }

    int getDuration(Reductant reductant, Prefix prefix) {
        return  (int) duration * reductant.duration_multiplier * prefix.duration_multiplier * (prefix.name == "ore" ? output_multiplier : 1)
    }

    ItemStack getByproduct(Prefix prefix) {
        int amount = prefix.byproduct_amount * output_multiplier * (byproduct == "pyrotech:slag" ? 2 : 8)
        return (byproduct == null || amount == 0) ? null : (item(byproduct) * amount)
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
        new Reductant("dustAnthracite", 8, 0.7)
]

def prefix_ore = new Prefix("ore", 1, 2)
def prefix_crushed = new Prefix("crushed", 0.75, 1)
def prefix_crushed_purified = new Prefix("crushedPurified", 0.75, 1)
def prefix_dust_impure = new Prefix("dustImpure", 0.5)
def prefix_dust = new Prefix("dust", 0.5)
def prefix_ingot = new Prefix("ingot", 1)

def smelting_prefixes = [
        prefix_ore,
        prefix_crushed,
        prefix_crushed_purified,
        prefix_dust_impure,
        prefix_dust
]

def ores = [
        // Copper ores
        new Ore("Malachite", "Copper", 2),
        new Ore("Chalcocite", "Copper"),

        // Lead ores
        new Ore("Anglesite", "Lead"),
        new Ore("Cerussite", "Lead"),
        new Ore("Galena", "Lead"),

        // Zinc ores
        new Ore("Smithsonite", "Zinc"),
        new Ore("Sphalerite", "Zinc"),

        // Tin ores
        new Ore("Cassiterite", "Tin", 2),

        // Silver ores
        new Ore("Silver", "Silver")
]

// Ore smashing
ores.forEach { oreIn ->
    mods.pyrotech.anvil.recipeBuilder()
            .name("susy:" + oreIn.name.toLowerCase())
            .input(ore("ore" + oreIn.name))
            .output(metaitem("crushed" + oreIn.name) * oreIn.output_multiplier)
            .typeHammer()
            .hits(2)
            .tierGranite()
            .register()
}

// Actual ore smelting

reductants.forEach { reductant ->
    ores.forEach { oreIn ->
        smelting_prefixes.forEach { prefix ->
            def builder = SMELTER.recipeBuilder()
                    .inputs(oreIn.get(prefix))
                    .inputs(reductant.get(oreIn, prefix))
                    .duration(oreIn.getDuration(reductant, prefix))
                    .outputs(oreIn.getOutput(prefix))
            if (oreIn.getByproduct(prefix) != null) {
                    builder.outputs(oreIn.getByproduct(prefix))
            }
            builder.buildAndRegister()
        }
    }
}

// Extra smelting recipes
def extra_smelting_recipes = [
        [[ore('gemMalachite') * 8], [metaitem('ingotCopper') * 16], 2,  150],
        [[metaitem('native_copper') * 8, ore('dustTinyLimestone')], [metaitem('ingotCopper') * 8, item('pyrotech:slag')], 1,  100],
        [[ore('oreNativeCopperDeposit'), ore('dustTinyLimestone')], [metaitem('ingotCopper') * 8, item('pyrotech:slag')], 1,  150],
        [[metaitem('native_copper') * 6, ore('ingotTin') * 2], [metaitem('ingotBronze') * 8, item('pyrotech:slag')], 1,  350],
        [[metaitem('native_copper') * 6, ore('dustTin') * 2], [metaitem('ingotBronze') * 8, item('pyrotech:slag')], 1,  300],
        [[ore('ingotPigIron') * 8], [item('minecraft:iron_ingot') * 8, item('pyrotech:slag')], 1,  300]
]

extra_smelting_recipes.forEach { recipe ->
    reductants.forEach { reductant ->
        SMELTER.recipeBuilder()
                .inputs(*(recipe[0]))
                .inputs(ore(reductant.name) * 8)
                .outputs(*(recipe[1]))
                .duration((int) (recipe[3] * reductant.duration_multiplier * recipe[2]))
                .buildAndRegister()
    }
}

// Alloy smelting
def alloying_prefixes = [
        prefix_ingot,
        prefix_dust
]

def alloy_add = {String output, int amount, int duration, ArrayList inputs ->
        int recipe_multiplier = Math.ceil(8 / amount)
        def size = inputs.size().intdiv(2)
        def real = ([alloying_prefixes] * size).combinations()
        reductants.forEach { reductant ->
            real.forEach { bad ->
                def builder = SMELTER.recipeBuilder()
                double multiplier_sum = 0
                int count = 0
                for (int i = 0; i < size; i++) {
                    int amountIn = inputs[ 2 * i + 1 ]
                    multiplier_sum += bad[i].duration_multiplier * amountIn
                    count += amountIn
                    builder.inputs(ore(bad[i].name + inputs[ 2 * i ]) * (amountIn * recipe_multiplier))
                }
                builder.inputs(ore(reductant.name) * (count * recipe_multiplier))
                        .outputs(metaitem("ingot" + output) * (amount * recipe_multiplier))
                        .duration((int) (duration *  multiplier_sum / count) * recipe_multiplier)
                        .buildAndRegister()
            }
        }

}

// Smelter alloying recipes
alloying_recipes = [
        // Bronze
        ["Bronze", 4, 200, ["Copper", 3, "Tin", 1]],
        // Brass
        ["Brass", 4, 200, ["Copper", 3, "Zinc", 1]],
        // SnFe
        ["TinAlloy", 2, 100, ["Iron", 1, "Tin", 1]],
        // Potin
        ["Potin", 9, 100, ["Bronze", 8, "Lead", 1]],
        // Kovar
        ["Kovar", 2, 100, ["Iron", 2, "Nickel", 1, "CobaltMatte", 1]]
]

alloying_recipes.forEach { recipe ->
    alloy_add(*recipe)
}

// Coke oven buff

// Removals
// Charcoal * 1
mods.gregtech.coke_oven.removeByInput(1, [item('minecraft:log:*')], null)
// Coke * 1
mods.gregtech.coke_oven.removeByInput(1, [item('minecraft:coal')], null)
// Block of Coke * 1
mods.gregtech.coke_oven.removeByInput(1, [item('minecraft:coal_block')], null)

// Re-add recipes
// Log -> charcoal
mods.gregtech.coke_oven.recipeBuilder()
        .inputs(ore('logWood'))
        .outputs(item('minecraft:coal', 1))
        .fluidOutputs(fluid('creosote') * 125)
        .duration(100)
        .buildAndRegister()

// Coal -> coke
mods.gregtech.coke_oven.recipeBuilder()
        .inputs(ore('gemCoal'))
        .outputs(metaitem('gemCoke'))
        .fluidOutputs(fluid('creosote') * 250)
        .duration(100)
        .buildAndRegister()

// Coal block -> coke block
mods.gregtech.coke_oven.recipeBuilder()
        .inputs(ore('blockCoal'))
        .outputs(metaitem('blockCoke'))
        .fluidOutputs(fluid('creosote') * 2250)
        .duration(900)
        .buildAndRegister()

// Additional recipes
// Log pile -> charcoal, with extra 1/9 output as a bonus
mods.gregtech.coke_oven.recipeBuilder()
        .inputs(item('pyrotech:log_pile'))
        .outputs(item('minecraft:coal', 1) * 10)
        .fluidOutputs(fluid('creosote') * 1250)
        .duration(900)
        .buildAndRegister()

// Lignite -> lignite coke
mods.gregtech.coke_oven.recipeBuilder()
        .inputs(ore('gemLignite'))
        .outputs(ore('gemLigniteCoke').getFirst())
        .fluidOutputs(fluid('creosote') * 125)
        .duration(100)
        .buildAndRegister()

// Lignite block -> lignite coke block
mods.gregtech.coke_oven.recipeBuilder()
        .inputs(ore('blockLignite'))
        .outputs(ore('blockLigniteCoke').getFirst())
        .fluidOutputs(fluid('creosote') * 1125)
        .duration(900)
        .buildAndRegister()

// Slag glass
ALLOY_SMELTER.recipeBuilder()
        .inputs(item('pyrotech:slag') * 9)
        .notConsumable(metaitem('shape.mold.block'))
        .outputs(item('pyrotech:slag_glass'))
        .duration(100)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister();

ALLOY_SMELTER.recipeBuilder()
        .inputs(item('pyrotech:pile_slag'))
        .notConsumable(metaitem('shape.mold.block'))
        .outputs(item('pyrotech:slag_glass'))
        .duration(100)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister();