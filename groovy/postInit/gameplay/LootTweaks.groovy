import com.cleanroommc.groovyscript.event.LootTablesLoadedEvent;

def lootTables = ["minecraft:chests/simple_dungeon", "minecraft:chests/village_blacksmith", "minecraft:chests/spawn_bonus_chest", "minecraft:chests/stronghold_library"]

event_manager.listen { LootTablesLoadedEvent event ->
    for (def lt in lootTables) {
        event.loot.getTable(lt).removePool("sgcraft0");
    }
}