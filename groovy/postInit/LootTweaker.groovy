import leviathan143.loottweaker.common.zenscript.LootTableTweakManager;
import leviathan143.loottweaker.common.zenscript.LootTableTweakManager.*;
import leviathan143.loottweaker.common.LootTweaker;
import leviathan143.loottweaker.common.LootTweaker.*;
import leviathan143.loottweaker.common.zenscript.wrapper.ZenLootTableWrapper;
import leviathan143.loottweaker.common.zenscript.LootTweakerContext;
import leviathan143.loottweaker.common.CTLoggingErrorHandler;

println("Running LootTweaker.groovy...")

def context = new LootTweakerContext(new CTLoggingErrorHandler());
def tweak_manager = context.createLootTableTweakManager()

def simple_dungeon = tweak_manager.getTable('minecraft:chests/simple_dungeon');
def village_blacksmith = tweak_manager.getTable("minecraft:chests/village_blacksmith");

simple_dungeon.getPool("sgcraft0").clearEntries();
village_blacksmith.getPool("sgcraft0").clearEntries();