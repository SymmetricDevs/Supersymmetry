import supersymmetry.api.event.MobHordeEvent;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;

new MobHordeEvent((player) -> {return new EntityZombie(player.world);}, 5, 10, "zombie_medium")
	.setNightOnly(true)
	.setTimer(144000, 216000)		// 2 - 3 hours

new MobHordeEvent((player) -> {EntityZombie zombie = new EntityZombie(player.world); 
			        zombie.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 999999, 1));
			        zombie.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 999999, 1));
			        zombie.addPotionEffect(new PotionEffect(MobEffects.SPEED, 999999));
				return zombie;}, 6, 12, "zombie_hard")
	.setAdvancementUnlock(new ResourceLocation("gregtech:steam/16_steel_boiler"))
	.setNightOnly(true)
	.setTimer(144000, 216000)		// 2 - 3 hours
