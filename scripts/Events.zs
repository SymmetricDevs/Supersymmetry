#priority 100

import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.liquid.ILiquidStack;
import crafttweaker.oredict.IOreDictEntry;
import crafttweaker.entity.IEntity;
import crafttweaker.entity.IEntityLivingBase;
import crafttweaker.player.IPlayer;
import crafttweaker.world.IRayTraceResult;
import crafttweaker.world.IBlockPos;
import crafttweaker.world.IBlockAccess;
import crafttweaker.block.IBlockState;
import crafttweaker.command.ICommandSender;
import crafttweaker.events.IEventManager;
import crafttweaker.event.PlayerInteractBlockEvent;
import crafttweaker.event.PlayerInteractEvent;
import crafttweaker.world.IWorld;

/*
val LeavesIDs as string[] = [
		"minecraft:leaves",
		"minecraft:leaves2",
		"biomesoplenty:leaves_0",
		"biomesoplenty:leaves_1",
		"biomesoplenty:leaves_2",
		"biomesoplenty:leaves_3",
		"biomesoplenty:leaves_4",
		"biomesoplenty:leaves_5",
		"gregtech:leaves",
		"quark:variant_leaves"
];

events.onPlayerInteractBlock(function (event as PlayerInteractBlockEvent) {
	if (!event.canceled && !event.world.isRemote() && !isNull(event.player.currentItem)) {
		if (event.player.currentItem.definition.id == "minecraft:flint") {
			for ID in LeavesIDs {
				if(event.block.definition.id == ID){
					event.world.setBlockState(<blockstate:minecraft:air>, event.position);
					event.player.give(<minecraft:stick>);
					break;
				}
			}
		}
		if (event.player.currentItem.definition.id == "notreepunching:knife/flint") {
			for ID in LeavesIDs {
				if(event.block.definition.id == ID){
					event.world.setBlockState(<blockstate:minecraft:air>, event.position);
					event.player.give(<notreepunching:grass_fiber>);
					break;
				}
			}
		}
	}
});
*/