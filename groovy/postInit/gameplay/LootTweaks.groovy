import com.cleanroommc.groovyscript.event.LootTablesLoadedEvent;

def lootTables = ["minecraft:chests/simple_dungeon", "minecraft:chests/village_blacksmith", "minecraft:chests/stronghold_library"]
def bonusChestTable = "minecraft:chests/spawn_bonus_chest"
def bonusChestPools = ["main", "pool1", "pool2", "pool3", "sgcraft0", "sgcraft1", "sgcraft2", "sgcraft3"]

event_manager.listen { LootTablesLoadedEvent event ->
    for (def lt in lootTables) {
        event.loot.getTable(lt).removePool("sgcraft0");
    }
    for (def pool in bonusChestPools) {
        event.loot.getTable(bonusChestTable).removePool(pool);
    }
}