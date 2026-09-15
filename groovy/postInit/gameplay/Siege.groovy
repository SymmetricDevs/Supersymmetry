import supersymmetry.common.tileentities.TileEntityFlare

import techguns.entities.npcs.Bandit
import techguns.entities.npcs.Outcast
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.util.math.BlockPos

System.out.println("grs Siege loaded")

// /setblock ~ ~ ~ susy:raid_flare_block 0 replace {targetUUID:"31c4910d-9b69-4725-8969-9ed53ac8a7dc"}
// deverloper uuid, use for RunClient

TileEntityFlare.metaClass.callGroovySpawn = { String type, player ->

    switch (type) {
        case "bandit_flare":
            spawnBanditRaid(player)
            break
        case "fed_flare":
            spawnFedRaid(player)
            break
    }
}

//bandit siege
def spawnBanditRaid(player) {

    def world = player.world

    for (int attempt = 0; attempt < 12; attempt++) {
        Bandit bandit = new Bandit(world)
        // ===== Custom NBT =====
        NBTTagCompound root = bandit.getEntityData().getCompoundTag("susy")
        root.setString("faction", "Bandits")
        root.setInteger("hate", 0)
        bandit.getEntityData().setTag("susy", root)
        bandit.addRandomArmor(1);

        // ===== Random weapon =====
        String[] weapons = [
                "techguns:ak47",
                "techguns:thompson",
                "techguns:boltaction"
        ]

        String chosen = weapons[(int)(Math.random() * weapons.length)]

        NBTTagCompound nbt = new NBTTagCompound()
        def hands = new NBTTagList()

        def main = new NBTTagCompound()
        main.setString("id", chosen)
        main.setByte("Count", (byte)1)

        hands.appendTag(main)
        hands.appendTag(new NBTTagCompound())

        nbt.setTag("HandItems", hands)
        bandit.readEntityFromNBT(nbt)

        //shamelessly stolen from bruberu
        double angle = Math.random() * 2 * Math.PI
        int radius = 16

        double x = (int)(player.posX + radius * Math.cos(angle)) + 0.5
        double z = (int)(player.posZ + radius * Math.sin(angle)) + 0.5

        BlockPos topPos = world.getTopSolidOrLiquidBlock(new BlockPos(x, 0, z))
        double y = topPos.getY() + 0.01

        bandit.setPosition(x, y, z)

        if (!bandit.isNotColliding()) continue

        world.spawnEntity(bandit)

        return
    }

}

//fed siege
def spawnFedRaid(player) {

    def world = player.world

    for (int attempt = 0; attempt < 12; attempt++) {
        Outcast outcast = new Outcast(world)
        // ===== Custom NBT =====
        NBTTagCompound root = outcast.getEntityData().getCompoundTag("susy")
        root.setString("faction", "Feds")
        root.setInteger("hate", 0)
        outcast.getEntityData().setTag("susy", root)
        outcast.addRandomArmor(1);

        // ===== Random weapon =====
        String[] weapons = [
                "techguns:lmg",
                "techguns:flamethrower",
                "techguns:minigun"
        ]

        String chosen = weapons[(int)(Math.random() * weapons.length)]

        NBTTagCompound nbt = new NBTTagCompound()
        def hands = new NBTTagList()

        def main = new NBTTagCompound()
        main.setString("id", chosen)
        main.setByte("Count", (byte)1)

        hands.appendTag(main)
        hands.appendTag(new NBTTagCompound())

        nbt.setTag("HandItems", hands)
        outcast.readEntityFromNBT(nbt)

        //shamelessly stolen from bruberu
        double angle = Math.random() * 2 * Math.PI
        int radius = 16

        double x = (int)(player.posX + radius * Math.cos(angle)) + 0.5
        double z = (int)(player.posZ + radius * Math.sin(angle)) + 0.5

        BlockPos topPos = world.getTopSolidOrLiquidBlock(new BlockPos(x, 0, z))
        double y = topPos.getY() + 0.01

        outcast.setPosition(x, y, z)

        if (!outcast.isNotColliding()) continue

        world.spawnEntity(outcast)

        return
    }

}
