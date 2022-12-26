#norun
import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.oredict.IOreDictEntry;
import crafttweaker.liquid.ILiquidStack;

import loottweaker.LootTweaker;
import loottweaker.vanilla.loot.LootTable;
import loottweaker.vanilla.loot.LootPool;

val simple_dungeon = LootTweaker.getTable("minecraft:chests/simple_dungeon");
val village_blacksmith = LootTweaker.getTable("minecraft:chests/village_blacksmith");

simple_dungeon.getPool("sgcraft0").clearEntries();
village_blacksmith.getPool("sgcraft0").clearEntries();