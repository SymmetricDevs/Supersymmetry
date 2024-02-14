import supersymmetry.api.event.MobHordeEvent;
import net.minecraft.entity.monster.EntityZombie;
import techguns.entities.npcs.Bandit;

new MobHordeEvent((player) -> {return new EntityZombie(player.world);}, 5, 10, "zombie_medium")
	.setNightOnly(true)
	.setTimer(216000, 360000)		// 3 - 5 hours
	
new MobHordeEvent((player) -> {Bandit bandit = new Bandit(player.world); bandit.addRandomArmor(0); return bandit;}, 2, 4, "bandit_medium")
	.setAdvancementUnlock(new ResourceLocation("gregtech:low_voltage/23_lv_assembler"))
	.setTimer(360000, 720000)			// 5-10 hours
