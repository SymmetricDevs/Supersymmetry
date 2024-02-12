import supersymmetry.api.event.MobHordeEvent;
import net.minecraft.entity.monster.EntityZombie;
import techguns.entities.npcs.Bandit;

new MobHordeEvent((player) -> {return new EntityZombie(player.world);}, 5, 10)
	.setNightOnly(true)
	.setTimer(10000, 20000)
	
new MobHordeEvent((player) -> {Bandit bandit = new Bandit(player.world); bandit.addRandomArmor(0); return bandit;}, 2, 4)
	.setAdvancementUnlock(new ResourceLocation("gregtech:low_voltage/23_lv_assembler"))
	.setTimer(6000, 15000)
