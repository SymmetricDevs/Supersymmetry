import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.Event;

/**
 * Adapted from UniversalTweaks
 **/
event_manager.listen { BlockEvent.CreateFluidSourceEvent event ->
    World world = event.getWorld();
    BlockPos pos = event.getPos();
    if (pos.getY() > 62) {
        event.setResult(Event.Result.DENY);
        return;
    }
    Biome biome = world.getBiomeForCoordsBody(pos);
    if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.OCEAN)
            || BiomeDictionary.hasType(biome, BiomeDictionary.Type.RIVER)
            || BiomeDictionary.hasType(biome, BiomeDictionary.Type.BEACH)) return;
    IBlockState state = event.getState();
    if (state.getMaterial() == Material.WATER) {
        event.setResult(Event.Result.DENY)
    }
}