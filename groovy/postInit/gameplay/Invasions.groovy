import supersymmetry.api.event.MobHordeEvent;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import techguns.entities.npcs.Bandit;
import techguns.entities.npcs.Outcast;
import net.minecraft.util.ResourceLocation;
import net.minecraft.nbt.NBTTagCompound

//zombie waves
//can happen at any time, for any reason
//great at keeping the tension up while not being too world-ending

new MobHordeEvent((player) -> {
    EntityZombie zombie = new EntityZombie(player.world);
    zombie.addPotionEffect(new PotionEffect(MobEffects.SPEED, 999999, 0));
    return zombie;
}, 2, 4, "zombie_small")
        .setNightOnly(true)
        .setTimer(144000, 216000)        // 2 - 3 hours
        .setCanUsePods(false)

new MobHordeEvent((player) -> {
    EntityZombie zombie = new EntityZombie(player.world);
    zombie.addPotionEffect(new PotionEffect(MobEffects.SPEED, 999999, 1));
    zombie.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 999999, 0));
    return zombie;
}, 5, 10, "zombie_medium")
        .setNightOnly(true)
        .setTimer(144000, 216000)        // 2 - 3 hours
        .setCanUsePods(false)

new MobHordeEvent((player) -> {
    EntityZombie zombie = new EntityZombie(player.world);
    zombie.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 999999, 1));
    zombie.addPotionEffect(new PotionEffect(MobEffects.SPEED, 999999, 1));
    return zombie;
}, 8, 18, "zombie_large")
        .setNightOnly(true)
        .setTimer(144000, 216000)        // 2 - 3 hours
        .setCanUsePods(false)

new MobHordeEvent((player) -> {
    EntityZombie zombie = new EntityZombie(player.world);
    zombie.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 999999, 1));
    zombie.addPotionEffect(new PotionEffect(MobEffects.SPEED, 999999, 1));
    zombie.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 999999, 2));
    return zombie;
}, 20, 30, "zombie_massive")
        .setNightOnly(true)
        .setTimer(144000, 216000)        // 2 - 3 hours
        .setCanUsePods(false)

//HATE
// invading raiders have negative hate, that hate gets subtracted when they get killed
// when the raid ends and there are raiders alive, the hate gets inverted and added instead
// this means that the player will slowly build up hate the longer they ignore invasions for
// only applies to human factions, zombies are :dimbass: and don't understand hate
// if hate is not meant to change, just set it to 0 (important for sieges)

// Why this system? "Weakness invites aggression" - Ronald Reagan
// if the bandits think they can get away with raiding yo shit they will keep doing it :troll:

//HATE advancement Reg, for progression

MobHordeEvent.baseline(new ResourceLocation("gregtech:steam/12_electronic_circuit"), 1)
MobHordeEvent.baseline(new ResourceLocation("gregtech:low_voltage/root_lv"), 3)
MobHordeEvent.baseline(new ResourceLocation("gregtech:low_voltage/23_lv_assembler"), 5)
MobHordeEvent.baseline(new ResourceLocation("gregtech:low_voltage/27_electric_blast_furnace"), 10)
MobHordeEvent.baseline(new ResourceLocation("gregtech:medium_voltage/root_mv"), 15)
MobHordeEvent.baseline(new ResourceLocation("gregtech:medium_voltage/42_kanthal_coil"), 20)
MobHordeEvent.baseline(new ResourceLocation("gregtech:high_voltage/root_hv"), 23)
MobHordeEvent.baseline(new ResourceLocation("gregtech:medium_voltage/37_advanced_integrated_logic_circuit"), 25)
MobHordeEvent.baseline(new ResourceLocation("gregtech:high_voltage/44_distillation_tower"), 35)
MobHordeEvent.baseline(new ResourceLocation("gregtech:extreme_voltage/root_ev"), 40)
MobHordeEvent.baseline(new ResourceLocation("gregtech:high_voltage/40_workstation"), 50)
MobHordeEvent.baseline(new ResourceLocation("gregtech:insane_voltage/root_iv"), 65)

//Human invasions
//Bandits

//Scripted
/**
 Ivan, the tutorial raider
 only Ivan
 beer bottle
 no armor
 hangover
 scripted event, here to show that there are other humans out there
 Poor Ivan, stumbling his way through the dark he always finds himself in all sorts of trouble
 The only invasion enemy which will not increase HATE if you let him escape
 **/

new MobHordeEvent((player) -> {
    Bandit bandit = new Bandit(player.world);
    NBTTagCompound root = bandit.getEntityData().getCompoundTag("susy");
    root.setString("faction", "Bandits");
    root.setInteger("hate", 0);
    bandit.getEntityData().setTag("susy", root);
    bandit.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 999999, 2));

    return bandit;
}, 1, 1, "bandit_scripted_Ivan")
        .setPostSpawnModifier({ entity ->
            NBTTagCompound nbt = new NBTTagCompound()
            def armor = new net.minecraft.nbt.NBTTagList()
            ["boots", "leggings", "chestplate", "helmet"].eachWithIndex { name, idx -> //no armor
                def tag = new NBTTagCompound()
                armor.appendTag(tag)
            }
            def hands = new net.minecraft.nbt.NBTTagList()
            def main = new NBTTagCompound()
            main.setString("id", "gregtechfoodoption:gtfo_meta_item")
            main.setByte("Count", (byte) 1)
            main.setInteger("Damage", 220)
            hands.appendTag(main)
            hands.appendTag(new NBTTagCompound())
            nbt.setTag("ArmorItems", armor)
            nbt.setTag("HandItems", hands)
            entity.readEntityFromNBT(nbt)
            return entity
        })
        .triggerOnAdvancement(new ResourceLocation("gregtech:steam/91_primitive_blast_furnace"))
        .runOnce()

//Random
/**
 bandit scouts
 1-2 people
 combat knives
 bandit helmets only
 very weak, early game enemies
 you haven't been noticed... yet
 **/
new MobHordeEvent((player) -> {
    Bandit bandit = new Bandit(player.world);
    //hate
    NBTTagCompound root = bandit.getEntityData().getCompoundTag("susy");
    root.setString("faction", "Bandits");
    root.setInteger("hate", -1);
    bandit.getEntityData().setTag("susy", root);

    return bandit;
}, 1, 2, "bandit_scouts")
        .setPostSpawnModifier({ entity ->
            NBTTagCompound nbt = new NBTTagCompound()
            def armor = new net.minecraft.nbt.NBTTagList()
            ["boots", "leggings", "chestplate", "helmet"].eachWithIndex { name, idx ->
                def tag = new NBTTagCompound()
                if (idx == 3) {
                    tag.setString("id", "techguns:t1_scout_helmet")
                    tag.setByte("Count", (byte) 1)
                }
                armor.appendTag(tag)
            }
            def hands = new net.minecraft.nbt.NBTTagList()
            def main = new NBTTagCompound()
            main.setString("id", "techguns:combatknife")
            main.setByte("Count", (byte) 1)
            hands.appendTag(main)
            hands.appendTag(new NBTTagCompound())
            nbt.setTag("ArmorItems", armor)
            nbt.setTag("HandItems", hands)
            entity.readEntityFromNBT(nbt)
            return entity
        })
        .setTimer(144000, 216000)
        .minHate("Bandits", 5)

/**
 small raiding party
 3-6 people
 weapons: combat knives, revolvers, bolt action rifles
 random bandit armor
 congratulations player, you have made enough noise to be noticed!
 **/

new MobHordeEvent((player) -> {
    Bandit bandit = new Bandit(player.world);
    //hate
    NBTTagCompound root = bandit.getEntityData().getCompoundTag("susy");
    root.setString("faction", "Bandits");
    root.setInteger("hate", -1);
    bandit.getEntityData().setTag("susy", root);

    return bandit;
}, 3, 6, "bandit_small_raid")
        .setTimer(144000, 216000)
        .minHate("Bandits", 15)
        .setPostSpawnModifier(entity -> {

            NBTTagCompound nbt = new NBTTagCompound();

            // List of possible weapons
            String[] possibleWeapons = new String[]{
                    "techguns:combatknife",
                    "techguns:revolver",
                    "techguns:boltaction"
            };

            // Pick a random weapon
            String chosenWeapon = possibleWeapons[(int) (Math.random() * possibleWeapons.length)];
            net.minecraft.nbt.NBTTagList hands = new net.minecraft.nbt.NBTTagList();
            net.minecraft.nbt.NBTTagCompound main = new net.minecraft.nbt.NBTTagCompound();
            main.setString("id", chosenWeapon);
            main.setByte("Count", (byte) 1);
            hands.appendTag(main);
            hands.appendTag(new net.minecraft.nbt.NBTTagCompound()); // offhand empty
            nbt.setTag("HandItems", hands);
            entity.readEntityFromNBT(nbt);
            return entity;
        });

/**
 medium raiding party
 5-10 people
 weapons: revolvers, bolt action rifles, sawed off shotgun, pistol
 random bandit armor
 Looks like you're stuck here for a while after all.
 **/

new MobHordeEvent((player) -> {
    Bandit bandit = new Bandit(player.world);
    //hate
    NBTTagCompound root = bandit.getEntityData().getCompoundTag("susy");
    root.setString("faction", "Bandits");
    root.setInteger("hate", -2);
    bandit.getEntityData().setTag("susy", root);

    return bandit;
}, 5, 10, "bandit_medium_raid")
        .setTimer(144000, 216000)
        .minHate("Bandits", 30)
        .setPostSpawnModifier(entity -> {

            NBTTagCompound nbt = new NBTTagCompound();

            // List of possible weapons
            String[] possibleWeapons = new String[]{
                    "techguns:sawedoff",
                    "techguns:revolver",
                    "techguns:boltaction",
                    "techguns:pistol"
            };

            // Pick a random weapon
            String chosenWeapon = possibleWeapons[(int) (Math.random() * possibleWeapons.length)];
            net.minecraft.nbt.NBTTagList hands = new net.minecraft.nbt.NBTTagList();
            net.minecraft.nbt.NBTTagCompound main = new net.minecraft.nbt.NBTTagCompound();
            main.setString("id", chosenWeapon);
            main.setByte("Count", (byte) 1);
            hands.appendTag(main);
            hands.appendTag(new net.minecraft.nbt.NBTTagCompound()); // offhand empty
            nbt.setTag("HandItems", hands);
            entity.readEntityFromNBT(nbt);
            return entity;
        });

/**
 large raiding party
 10-18 people
 weapons: thompson, bolt action rifles, ak47, mac10
 full bandit armor
 organized spawn instead of random insertion
 auxiliaries present
 Well well well, someone is becoming a problem.
 **/

new MobHordeEvent((player) -> null, 10, 18, "bandit_large_raid")
        .setTimer(144000, 216000)
        .minHate("Bandits", 50)

//normal raider
        .addPattern(
                //circle
                t -> {
                    double radius = 10;
                    double angle = t * 2 * Math.PI;
                    return new MobHordeEvent.Vec2(radius * Math.cos(angle), radius * Math.sin(angle));
                },
                null,
                player -> {
                    Bandit bandit = new Bandit(player.world);
                    NBTTagCompound root = bandit.getEntityData().getCompoundTag("susy");
                    root.setString("faction", "Bandits");
                    root.setInteger("hate", -3);
                    bandit.getEntityData().setTag("susy", root);
                    return bandit;
                },
                entity -> {
                    NBTTagCompound nbt = new NBTTagCompound();

                    // Armor
                    net.minecraft.nbt.NBTTagList armor = new net.minecraft.nbt.NBTTagList();
                    String[] armorItems = new String[]{
                            "techguns:t1_scout_boots",
                            "techguns:t1_scout_leggings",
                            "techguns:t1_scout_chestplate",
                            "techguns:t1_scout_helmet"
                    };
                    for (String item : armorItems) {
                        net.minecraft.nbt.NBTTagCompound armorTag = new net.minecraft.nbt.NBTTagCompound();
                        armorTag.setString("id", item);
                        armorTag.setByte("Count", (byte)1);
                        armor.appendTag(armorTag);
                    }
                    nbt.setTag("ArmorItems", armor);

                    // Random weapon
                    String[] possibleWeapons = new String[]{
                            "techguns:thompson",
                            "techguns:boltaction",
                            "techguns:mac10",
                            "techguns:ak47"
                    };
                    String chosenWeapon = possibleWeapons[(int) (Math.random() * possibleWeapons.length)];

                    net.minecraft.nbt.NBTTagList hands = new net.minecraft.nbt.NBTTagList();
                    net.minecraft.nbt.NBTTagCompound main = new net.minecraft.nbt.NBTTagCompound();
                    main.setString("id", chosenWeapon);
                    main.setByte("Count", (byte)1);
                    hands.appendTag(main);
                    hands.appendTag(new net.minecraft.nbt.NBTTagCompound()); // offhand empty
                    nbt.setTag("HandItems", hands);

                    entity.readEntityFromNBT(nbt);

                    return entity;
                }
        )
//mercenary
        .addPattern(
                //square
                t -> {
                    double n = 2;
                    double angle = t * 2 * Math.PI;
                    double radius = 15;
                    double x = (Math.cos(angle) < 0 ? -1 : 1) * Math.pow(Math.abs(Math.cos(angle)), 2/n) * radius;
                    double z = (Math.sin(angle) < 0 ? -1 : 1) * Math.pow(Math.abs(Math.sin(angle)), 2/n) * radius;
                    return new MobHordeEvent.Vec2(x, z);
                },
                null,
                player -> {
                    Bandit bandit = new Bandit(player.world);
                    NBTTagCompound root = bandit.getEntityData().getCompoundTag("susy");
                    root.setString("faction", "Bandits");
                    root.setInteger("hate", -6);
                    bandit.getEntityData().setTag("susy", root);
                    return bandit;
                },
                entity -> {
                    NBTTagCompound nbt = new NBTTagCompound();

                    // Armor
                    net.minecraft.nbt.NBTTagList armor = new net.minecraft.nbt.NBTTagList();
                    String[] armorItems = new String[]{
                            "techguns:t2_combat_boots",
                            "techguns:t2_combat_leggings",
                            "techguns:t2_combat_chestplate",
                            "techguns:t2_combat_helmet"
                    };
                    for (String item : armorItems) {
                        net.minecraft.nbt.NBTTagCompound armorTag = new net.minecraft.nbt.NBTTagCompound();
                        armorTag.setString("id", item);
                        armorTag.setByte("Count", (byte)1);
                        armor.appendTag(armorTag);
                    }
                    nbt.setTag("ArmorItems", armor);

                    // m4 only
                    String chosenWeapon = "techguns:m4"

                    net.minecraft.nbt.NBTTagList hands = new net.minecraft.nbt.NBTTagList();
                    net.minecraft.nbt.NBTTagCompound main = new net.minecraft.nbt.NBTTagCompound();
                    main.setString("id", chosenWeapon);
                    main.setByte("Count", (byte)1);
                    hands.appendTag(main);
                    hands.appendTag(new net.minecraft.nbt.NBTTagCompound()); // offhand empty
                    nbt.setTag("HandItems", hands);

                    entity.readEntityFromNBT(nbt);
                    return entity;
                }
        )
        .setDistribution(90.0,10.0); //mostly normal bandits, some mercenaries

/**
 massive raiding party
 20-30 people
 weapons: ak47, combat shotguns, thompson
 full basic combat armor
 organized spawn instead of random insertion
 Congratulations, you have become impossible to ignore
 **/

new MobHordeEvent((player) -> null, 20, 30, "bandit_massive_raid")
        .setTimer(144000, 216000)
        .minHate("Bandits", 100)

//normal raider
        .addPattern(
                //circle
                t -> {
                    double radius = 10;
                    double angle = t * 2 * Math.PI;
                    return new MobHordeEvent.Vec2(radius * Math.cos(angle), radius * Math.sin(angle));
                },
                null,
                player -> {
                    Bandit bandit = new Bandit(player.world);
                    NBTTagCompound root = bandit.getEntityData().getCompoundTag("susy");
                    root.setString("faction", "Bandits");
                    root.setInteger("hate", -5);
                    bandit.getEntityData().setTag("susy", root);
                    return bandit;
                },
                entity -> {
                    NBTTagCompound nbt = new NBTTagCompound();

                    // Armor
                    net.minecraft.nbt.NBTTagList armor = new net.minecraft.nbt.NBTTagList();
                    String[] armorItems = new String[]{
                            "techguns:t1_combat_boots",
                            "techguns:t1_combat_leggings",
                            "techguns:t1_combat_chestplate",
                            "techguns:t1_scout_helmet"
                    };
                    for (String item : armorItems) {
                        net.minecraft.nbt.NBTTagCompound armorTag = new net.minecraft.nbt.NBTTagCompound();
                        armorTag.setString("id", item);
                        armorTag.setByte("Count", (byte)1);
                        armor.appendTag(armorTag);
                    }
                    nbt.setTag("ArmorItems", armor);

                    // Random weapon
                    String[] possibleWeapons = new String[]{
                            "techguns:thompson",
                            "techguns:combatshotgun",
                            "techguns:ak47"
                    };
                    String chosenWeapon = possibleWeapons[(int) (Math.random() * possibleWeapons.length)];

                    net.minecraft.nbt.NBTTagList hands = new net.minecraft.nbt.NBTTagList();
                    net.minecraft.nbt.NBTTagCompound main = new net.minecraft.nbt.NBTTagCompound();
                    main.setString("id", chosenWeapon);
                    main.setByte("Count", (byte)1);
                    hands.appendTag(main);
                    hands.appendTag(new net.minecraft.nbt.NBTTagCompound()); // offhand empty
                    nbt.setTag("HandItems", hands);

                    entity.readEntityFromNBT(nbt);
                    return entity;
                }
        )
//mercenary
        .addPattern(
                //square
                t -> {
                    double n = 2;
                    double angle = t * 2 * Math.PI;
                    double radius = 15;
                    double x = (Math.cos(angle) < 0 ? -1 : 1) * Math.pow(Math.abs(Math.cos(angle)), 2/n) * radius;
                    double z = (Math.sin(angle) < 0 ? -1 : 1) * Math.pow(Math.abs(Math.sin(angle)), 2/n) * radius;
                    return new MobHordeEvent.Vec2(x, z);
                },
                null,
                player -> {
                    Bandit bandit = new Bandit(player.world);
                    NBTTagCompound root = bandit.getEntityData().getCompoundTag("susy");
                    root.setString("faction", "Bandits");
                    root.setInteger("hate", -6);
                    bandit.getEntityData().setTag("susy", root);
                    return bandit;
                },
                entity -> {
                    NBTTagCompound nbt = new NBTTagCompound();

                    // Armor
                    net.minecraft.nbt.NBTTagList armor = new net.minecraft.nbt.NBTTagList();
                    String[] armorItems = new String[]{
                            "techguns:t2_combat_boots",
                            "techguns:t2_combat_leggings",
                            "techguns:t2_combat_chestplate",
                            "techguns:t2_combat_helmet"
                    };
                    for (String item : armorItems) {
                        net.minecraft.nbt.NBTTagCompound armorTag = new net.minecraft.nbt.NBTTagCompound();
                        armorTag.setString("id", item);
                        armorTag.setByte("Count", (byte)1);
                        armor.appendTag(armorTag);
                    }
                    nbt.setTag("ArmorItems", armor);

                    // m4 only
                    String chosenWeapon = "techguns:m4"

                    net.minecraft.nbt.NBTTagList hands = new net.minecraft.nbt.NBTTagList();
                    net.minecraft.nbt.NBTTagCompound main = new net.minecraft.nbt.NBTTagCompound();
                    main.setString("id", chosenWeapon);
                    main.setByte("Count", (byte)1);
                    hands.appendTag(main);
                    hands.appendTag(new net.minecraft.nbt.NBTTagCompound()); // offhand empty
                    nbt.setTag("HandItems", hands);

                    entity.readEntityFromNBT(nbt);
                    return entity;
                }
        )
        .setDistribution(80.0,20.0); //mostly normal bandits, some mercenaries

/**
 Siege
 40+ people
 weapons: ak47, combat shotguns, m4
 full basic combat armor for normal troops
 spawns in formation
 mortar support
 sandbags
 bandit flare (keeps spawning bandits until you destroy it, they do not count towards the raid)
 hate resets to baseline if you manage to defeat the Siege
 The bandits consider themselves at total war with you
 **/

new MobHordeEvent((player) -> null, 62, 62, "bandit_siege")
        .setTimer(144000, 216000)
        .minHate("Bandits", 300)

//walls
        .addPattern(
                //square
                t -> {
                    double n = 2;
                    double angle = t * 2 * Math.PI;
                    double radius = 15;
                    double x = (Math.cos(angle) < 0 ? -1 : 1) * Math.pow(Math.abs(Math.cos(angle)), 2/n) * radius;
                    double z = (Math.sin(angle) < 0 ? -1 : 1) * Math.pow(Math.abs(Math.sin(angle)), 2/n) * radius;
                    return new MobHordeEvent.Vec2(x, z);
                },
                Arrays.asList("#gen SandBags"), //replace with bigger sandbags
                null,
                null,
        )
//mortar
        .addPattern(
                //square
                t -> {
                    return new MobHordeEvent.Vec2(0, 0); //always spawns in the center of the invasion
                },
                Arrays.asList("#gen AutoMortar"), //replace with auto-mortar, shells do not destroy blocks before the player launches a rocket
                null,
                null,
        )
//flare
        .addPattern(
                //circle
                t -> {
                    double radius = 5;
                    double angle = t * 2 * Math.PI;
                    return new MobHordeEvent.Vec2(radius * Math.cos(angle), radius * Math.sin(angle));
                },
                Arrays.asList("setblock ~ ~ ~ susy:raid_flare_block 0 replace {targetUUID:\"%player_uuid%\"}"), //add player data tag
                null,
                null,
        )
//initial defender wave
        .addPattern(
                //square
                t -> {
                    double radius = 10;
                    double angle = t * 2 * Math.PI;
                    return new MobHordeEvent.Vec2(radius * Math.cos(angle), radius * Math.sin(angle));
                },
                null,
                player -> {
                    Bandit bandit = new Bandit(player.world);
                    NBTTagCompound root = bandit.getEntityData().getCompoundTag("susy");
                    root.setString("faction", "Bandits");
                    root.setInteger("hate", -5);
                    bandit.getEntityData().setTag("susy", root);
                    return bandit;
                },
                entity -> {
                    NBTTagCompound nbt = new NBTTagCompound();

                    // Armor
                    net.minecraft.nbt.NBTTagList armor = new net.minecraft.nbt.NBTTagList();
                    String[] armorItems = new String[]{
                            "techguns:t1_combat_boots",
                            "techguns:t1_combat_leggings",
                            "techguns:t1_combat_chestplate",
                            "techguns:t1_scout_helmet"
                    };
                    for (String item : armorItems) {
                        net.minecraft.nbt.NBTTagCompound armorTag = new net.minecraft.nbt.NBTTagCompound();
                        armorTag.setString("id", item);
                        armorTag.setByte("Count", (byte)1);
                        armor.appendTag(armorTag);
                    }
                    nbt.setTag("ArmorItems", armor);

                    // Random weapon
                    String[] possibleWeapons = new String[]{
                            "techguns:m4",
                            "techguns:combatshotgun",
                            "techguns:ak47"
                    };
                    String chosenWeapon = possibleWeapons[(int) (Math.random() * possibleWeapons.length)];

                    net.minecraft.nbt.NBTTagList hands = new net.minecraft.nbt.NBTTagList();
                    net.minecraft.nbt.NBTTagCompound main = new net.minecraft.nbt.NBTTagCompound();
                    main.setString("id", chosenWeapon);
                    main.setByte("Count", (byte)1);
                    hands.appendTag(main);
                    hands.appendTag(new net.minecraft.nbt.NBTTagCompound()); // offhand empty
                    nbt.setTag("HandItems", hands);

                    entity.readEntityFromNBT(nbt);
                    return entity;
                }
        )
//mercenaries
        .addPattern(
                //square
                t -> {
                    double n = 2;
                    double angle = t * 2 * Math.PI;
                    double radius = 12;
                    double x = (Math.cos(angle) < 0 ? -1 : 1) * Math.pow(Math.abs(Math.cos(angle)), 2/n) * radius;
                    double z = (Math.sin(angle) < 0 ? -1 : 1) * Math.pow(Math.abs(Math.sin(angle)), 2/n) * radius;
                    return new MobHordeEvent.Vec2(x, z);
                },
                null,
                player -> {
                    Bandit bandit = new Bandit(player.world);
                    NBTTagCompound root = bandit.getEntityData().getCompoundTag("susy");
                    root.setString("faction", "Bandits");
                    root.setInteger("hate", -7);
                    bandit.getEntityData().setTag("susy", root);
                    return bandit;
                },
                entity -> {
                    if (entity instanceof Bandit) {
                        NBTTagCompound nbt = new NBTTagCompound();

                        // Armor
                        net.minecraft.nbt.NBTTagList armor = new net.minecraft.nbt.NBTTagList();
                        String[] armorItems = new String[]{
                                "techguns:t2_combat_boots",
                                "techguns:t2_combat_leggings",
                                "techguns:t2_combat_chestplate",
                                "techguns:t2_combat_helmet"
                        };
                        for (String item : armorItems) {
                            net.minecraft.nbt.NBTTagCompound armorTag = new net.minecraft.nbt.NBTTagCompound();
                            armorTag.setString("id", item);
                            armorTag.setByte("Count", (byte)1);
                            armor.appendTag(armorTag);
                        }
                        nbt.setTag("ArmorItems", armor);
                        // m4 only
                        String chosenWeapon = "techguns:m4"

                        net.minecraft.nbt.NBTTagList hands = new net.minecraft.nbt.NBTTagList();
                        net.minecraft.nbt.NBTTagCompound main = new net.minecraft.nbt.NBTTagCompound();
                        main.setString("id", chosenWeapon);
                        main.setByte("Count", (byte)1);
                        hands.appendTag(main);
                        hands.appendTag(new net.minecraft.nbt.NBTTagCompound()); // offhand empty
                        nbt.setTag("HandItems", hands);

                        entity.readEntityFromNBT(nbt);
                    }
                    return entity;
                }
        )
//Siege commander
        .addPattern(
                //center point
                t -> {
                    return new MobHordeEvent.Vec2(5, 0); //defends mortar directly
                },
                null,
                player -> {
                    Bandit bandit = new Bandit(player.world);
                    NBTTagCompound root = bandit.getEntityData().getCompoundTag("susy");
                    root.setString("faction", "Bandits");
                    root.setInteger("hate", -50);
                    bandit.getEntityData().setTag("susy", root);
                    return bandit;
                },
                entity -> {
                    NBTTagCompound nbt = new NBTTagCompound();

                    // Armor
                    net.minecraft.nbt.NBTTagList armor = new net.minecraft.nbt.NBTTagList();
                    String[] armorItems = new String[]{
                            "techguns:t2_riot_boots",
                            "techguns:t2_riot_leggings",
                            "techguns:t2_riot_chestplate",
                            "techguns:t2_beret"
                    };
                    for (String item : armorItems) {
                        net.minecraft.nbt.NBTTagCompound armorTag = new net.minecraft.nbt.NBTTagCompound();
                        armorTag.setString("id", item);
                        armorTag.setByte("Count", (byte)1);
                        armor.appendTag(armorTag);
                    }
                    nbt.setTag("ArmorItems", armor);

                    //flamethrower
                    String chosenWeapon = "techguns:flamethrower"

                    net.minecraft.nbt.NBTTagList hands = new net.minecraft.nbt.NBTTagList();
                    net.minecraft.nbt.NBTTagCompound main = new net.minecraft.nbt.NBTTagCompound();
                    main.setString("id", chosenWeapon);
                    main.setByte("Count", (byte)1);
                    hands.appendTag(main);
                    hands.appendTag(new net.minecraft.nbt.NBTTagCompound()); // offhand empty
                    nbt.setTag("HandItems", hands);

                    entity.readEntityFromNBT(nbt);

                    return entity;
                }
        )
        .setExactDistribution(20,1,1,29,10,1); //walls, artillery, Siege flare, initial Siege wave, mercenaries, Siege commander

//Feds
//Scripted
//Fed ortibal intervention

//Random
/**
 federation scout
 1 person
 LMG
 full power armor
 active combat stims
 Whatever's left of the federation has noticed your presence, good luck
 **/

new MobHordeEvent((player) -> {
    Outcast outcast = new Outcast(player.world);
    //hate
    NBTTagCompound root = outcast.getEntityData().getCompoundTag("susy");
    root.setString("faction", "Feds");
    root.setInteger("hate", -10);
    outcast.getEntityData().setTag("susy", root);
    outcast.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 999999, 1));
    //do not use addRandomArmor in here if you set the nbt tag later, otherwise it will override it for some reason

    return outcast;
}, 1, 1, "fed_scout")
        .setPostSpawnModifier({ entity ->
            NBTTagCompound nbt = new NBTTagCompound()
            def hands = new net.minecraft.nbt.NBTTagList()
            def main = new NBTTagCompound()
            main.setString("id", "techguns:lmg")
            main.setByte("Count", (byte) 1)
            hands.appendTag(main)
            hands.appendTag(new NBTTagCompound())
            nbt.setTag("HandItems", hands)
            entity.readEntityFromNBT(nbt)
            return entity
        })
        .setTimer(144000, 216000)
        .minHate("Feds", 80)

/**
 federation squad
 6-13 people
 LMG, miniguns, flamethrowers
 full power armor
 active combat stims
 A 'surgical' strike team with orders to hunt you down. They realised you are not just some bandit
 This would be a really good time to invest in ground to air
 **/

new MobHordeEvent((player) -> {
    Outcast outcast = new Outcast(player.world);
    //hate
    NBTTagCompound root = outcast.getEntityData().getCompoundTag("susy");
    root.setString("faction", "Feds");
    root.setInteger("hate", -10);
    outcast.getEntityData().setTag("susy", root);
    outcast.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 999999, 1));
    //do not use addRandomArmor in here if you set the nbt tag later, otherwise it will override it for some reason

    return outcast;
}, 6, 13, "fed_squad")
        .setPostSpawnModifier({ entity ->
            NBTTagCompound nbt = new NBTTagCompound()
            def hands = new net.minecraft.nbt.NBTTagList()
            def main = new NBTTagCompound()

            // Random weapon
            String[] possibleWeapons = new String[]{
                    "techguns:lmg",
                    "techguns:flamethrower",
                    "techguns:minigun"
            };
            String chosenWeapon = possibleWeapons[(int) (Math.random() * possibleWeapons.length)];

            main.setString("id", chosenWeapon)
            main.setByte("Count", (byte) 1)
            hands.appendTag(main)
            hands.appendTag(new NBTTagCompound())
            nbt.setTag("HandItems", hands)
            entity.readEntityFromNBT(nbt)
            return entity
        })
        .setTimer(144000, 216000)
        .minHate("Feds", 185)

/*
// Commands for pods
// example code only, templates, etc...
// not meant to be used in actual gameplay, dev only
String command1 = "#gen Test";
String command2 = "#gen Test1";
String command0 = "say init"
String command3 = "say 1";
String command4 = "say 2"
String command5 = "say 3"

new MobHordeEvent((player) -> null, 20, 20, "debug_invasion")
        .runCommandOnLanding(command0)
        .addPattern(
                t -> {
                    double radius = 20;
                    double angle = t * 2 * Math.PI;
                    return new MobHordeEvent.Vec2(radius * Math.cos(angle), radius * Math.sin(angle));
                },
                null,                        // pattern-specific commands
                null,                        // supplierOverride (null = default)
                null                         // postSpawnModifier (null = default)
        )

        .addPattern(
                t -> {
                    double radius = 30;
                    double angle = t * 2 * Math.PI;
                    return new MobHordeEvent.Vec2(radius * Math.cos(angle), radius * Math.sin(angle));
                },
                Arrays.asList(command3, command4, command5),
                player -> {
                    Bandit bandit = new Bandit(player.world);
                    bandit.addRandomArmor(1);
                    return bandit;
                },
                entity -> {
                    // optional post-spawn modifier per entity
                    return entity;
                }
        )
        .allignBlock()
        .setDistribution(50.0,50.0);

 */
/*
// Example 1: Square
//old code going forward, only use for math equation for shapes
//test before adding

new MobHordeEvent({ player -> null }, 10, 10, "square_invasion")
        .addPattern(t -> {
                    double n = 2;
                    double angle = t * 2 * Math.PI;
                    double radius = 20;
                    double x = (Math.cos(angle) < 0 ? -1 : 1) * Math.pow(Math.abs(Math.cos(angle)), 2/n) * radius;
                    double z = (Math.sin(angle) < 0 ? -1 : 1) * Math.pow(Math.abs(Math.sin(angle)), 2/n) * radius;
                    return new MobHordeEvent.Vec2(x, z);
                },
        })

// Example 2: Trapezoid
new MobHordeEvent({ player -> null }, 12, 12, "trapezoid_invasion")
        .addPattern({ t ->
            double n = 2
            double angle = t * 2 * Math.PI
            double xScale = 25   // wider base
            double zScale = 15   // narrower top
            new MobHordeEvent.Vec2(
                    (Math.cos(angle) < 0 ? -1 : 1) * Math.pow(Math.abs(Math.cos(angle)), 2/n) * xScale,
                    (Math.sin(angle) < 0 ? -1 : 1) * Math.pow(Math.abs(Math.sin(angle)), 2/n) * zScale
            )
        })
        .allignBlock()

// Example 3: 5-point star
new MobHordeEvent({ player -> null }, 15, 15, "star_invasion")
        .addPattern({ t ->
            double points = 5
            double angle = t * 2 * Math.PI
            double radiusOuter = 20
            double radiusInner = 10
            double r = (Math.sin(angle * points) >= 0) ? radiusOuter : radiusInner
            new MobHordeEvent.Vec2(
                    Math.cos(angle) * r,
                    Math.sin(angle) * r
            )
        })
        .allignBlock()
 */
