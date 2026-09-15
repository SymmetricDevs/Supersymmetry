// side: client
// This registers loot tables for entities with Just Enough Resources.

import net.minecraft.entity.EntityList
import jeresources.compatibility.minecraft.MinecraftCompat
import net.minecraftforge.fml.common.registry.ForgeRegistries
import jeresources.compatibility.JERAPI
import techguns.entities.npcs.GenericNPC

def registry = JERAPI.getInstance().getMobRegistry()
def world = MinecraftCompat.getWorld()

for (entityEntry in ForgeRegistries.ENTITIES.getValues()) {
    // log.infoMC(entityEntry.getName());

    def entityClass = entityEntry.getEntityClass();
    def entityInstance = EntityList.newEntity(entityClass, world)
    if (!(entityInstance instanceof GenericNPC)) {
        continue
    }

    def lootResource = entityInstance.getLootTable()

    if (lootResource == null) {
        continue
    }
    registry.register(entityInstance, lootResource)
}

// convenient location for this

import net.minecraftforge.event.entity.player.ItemTooltipEvent
import gregtech.client.utils.TooltipHelper

event_manager.listen { ItemTooltipEvent event ->
    if (event.getItemStack() in item('travelersbackpack:travelers_backpack')) {
        event.getToolTip() <<  "${TooltipHelper.BLINKING_RED}Deprecated! Could be remove in the next release!".toString()
    }
}