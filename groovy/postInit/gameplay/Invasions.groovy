import supersymmetry.api.event.MobHordeEvent;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import techguns.entities.npcs.Bandit;

new MobHordeEvent((player) -> {EntityZombie zombie = new EntityZombie(player.world);
			        zombie.addPotionEffect(new PotionEffect(MobEffects.SPEED, 999999, 1));
				return zombie;}, 5, 10, "zombie_medium")
	.setAdvancementUnlock(new ResourceLocation("gregtech:steam/1_first_tools"))
	.setNightOnly(true)
	.setTimer(144000, 216000)		// 2 - 3 hours
	.setCanUsePods(false)

new MobHordeEvent((player) -> {EntityZombie zombie = new EntityZombie(player.world); 
			        zombie.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 999999, 1));
			        zombie.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 999999, 1));
			        zombie.addPotionEffect(new PotionEffect(MobEffects.SPEED, 999999, 1));
				return zombie;}, 6, 12, "zombie_hard")
	.setAdvancementUnlock(new ResourceLocation("gregtech:steam/16_steel_boiler"))
	.setNightOnly(true)
	.setTimer(144000, 216000)		// 2 - 3 hours
	.setCanUsePods(false)

new MobHordeEvent((player) -> {Bandit bandit = new Bandit(player.world); bandit.addRandomArmor(0); return bandit;}, 2, 4, "bandit_medium")
	.setAdvancementUnlock(new ResourceLocation("gregtech:low_voltage/23_lv_assembler"))
	.setTimer(72000, 216000)	        // 1 - 3 hours

