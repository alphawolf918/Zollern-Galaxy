/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderMetztli;
import zollerngalaxy.events.ZGSoundEvents;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.mobs.entities.base.EntityMutantZombie;
import zollerngalaxy.mobs.entities.villagers.EntityHarranVillager;
import zollerngalaxy.mobs.entities.zombiemutations.EntityGhoul;
import zollerngalaxy.mobs.entities.zombiemutations.EntityOverlord;
import zollerngalaxy.mobs.entities.zombiemutations.EntitySeeker;
import zollerngalaxy.mobs.entities.zombiemutations.EntityVolatile;

public abstract class ZombieUtils {
	
	public static final int MUTATE_VOLATILE_CHANCE = 50;
	public static final int MUTATE_SEEKER_CHANCE = 32;
	public static final int MUTATE_OVERLORD_CHANCE = 26;
	public static final int MUTATE_GHOUL_CHANCE = 15;
	public static final int MUTATE_LIGHTWALKER_CHANCE = 2;
	public static final int HULK_CHANCE = 5;
	
	/**
	 * Uses Java Reflection to "convert" (spawn) the Mutant that the Player was killed by.
	 * 
	 * @param player
	 * @param world
	 * @param entityMutant
	 * @param entityName
	 */
	public static void convertToZombie(EntityPlayer player, World world, Class<? extends EntityMob> entityMutant, String entityName) {
		String playerName = player.getName();
		double x = player.posX;
		double y = player.posY;
		double z = player.posZ;
		Random rand = new Random();
		EntityMob zombie = new EntityZombie(world); // Zombie by default; prevents nulls.
		if (entityName != "Zombie") {
			try {
				zombie = entityMutant.getDeclaredConstructor(World.class).newInstance(world);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
				ZGHelper.LogErr("There was an error when trying to mutate a Zombie!");
				e.printStackTrace();
			}
		}
		zombie.setLocationAndAngles(x, y, z, player.rotationYaw, player.rotationPitch);
		zombie.setCustomNameTag(entityName + " " + playerName);
		world.spawnEntity(zombie);
		ZombieUtils.playMutateSound(zombie.posX, zombie.posY, zombie.posZ, world, rand);
	}
	
	/**
	 * For playing the Mutation sound. Seems to have issues playing though.
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @param world
	 * @param rand
	 */
	public static void playMutateSound(double x, double y, double z, World world, Random rand) {
		float volume = 4.0F + rand.nextFloat();
		float pitch = rand.nextFloat() * 0.7F + 0.3F;
		boolean distanceDelay = false;
		double extendBy = 1.5D;
		x += extendBy;
		y += extendBy;
		z += extendBy;
		world.playSound(x, y, z, ZGSoundEvents.ENTITY_VOLATILE_MUTATE, SoundCategory.AMBIENT, volume, pitch, distanceDelay);
	}
	
	public static boolean isValidLightLevel(World world, EntityZombie zombieIn, Random rand) {
		BlockPos blockpos = new BlockPos(zombieIn.posX, zombieIn.getEntityBoundingBox().minY, zombieIn.posZ);
		if (world.getLightFor(EnumSkyBlock.SKY, blockpos) > rand.nextInt(32)) {
			return false;
		} else {
			int i = world.getLightFromNeighbors(blockpos);
			
			if (world.isThundering()) {
				int j = world.getSkylightSubtracted();
				world.setSkylightSubtracted(10);
				i = world.getLightFromNeighbors(blockpos);
				world.setSkylightSubtracted(j);
			}
			
			return i <= rand.nextInt(8);
		}
	}
	
	/**
	 * Do the mutations!
	 * 
	 * @param world
	 * @param entity
	 * @param rand
	 */
	public static void HandleMutations(EntityLivingBase entity, Random rand) {
		if (entity instanceof EntityZombie && !(entity instanceof EntityMutantZombie)) {
			EntityZombie zombie = (EntityZombie) entity;
			World world = entity.world;
			if (!world.isRemote) {
				if (world.provider instanceof WorldProviderMetztli) {
					if (rand.nextInt(400) == 0) {
						int mutantChance = rand.nextInt(100);
						
						// Ghoul
						if (mutantChance <= ZombieUtils.MUTATE_GHOUL_CHANCE) {
							EntityGhoul gzombie = new EntityGhoul(world);
							gzombie.copyLocationAndAnglesFrom(zombie);
							if (zombie.hasCustomName()) {
								String zombieName = zombie.getCustomNameTag();
								String gZombieName = zombieName.replace("Zombie", "Ghoul");
								gzombie.setCustomNameTag(gZombieName);
							}
							world.spawnEntity(gzombie);
							ZombieUtils.playMutateSound(gzombie.posX, gzombie.posY, gzombie.posZ, world, rand);
							
							// Overlord
						} else if (mutantChance <= ZombieUtils.MUTATE_OVERLORD_CHANCE) {
							zombie.setDead();
							
							EntityOverlord ozombie = new EntityOverlord(world);
							ozombie.copyLocationAndAnglesFrom(zombie);
							if (zombie.hasCustomName()) {
								String zombieName = zombie.getCustomNameTag();
								String oZombieName = zombieName.replace("Zombie", "Overlord");
								ozombie.setCustomNameTag(oZombieName);
							}
							world.spawnEntity(ozombie);
							ZombieUtils.playMutateSound(ozombie.posX, ozombie.posY, ozombie.posZ, world, rand);
							
							// Seeker
						} else if (mutantChance <= ZombieUtils.MUTATE_SEEKER_CHANCE) {
							zombie.setDead();
							
							EntitySeeker szombie = new EntitySeeker(world);
							szombie.copyLocationAndAnglesFrom(zombie);
							if (zombie.hasCustomName()) {
								String zombieName = zombie.getCustomNameTag();
								String sZombieName = zombieName.replace("Zombie", "Seeker");
								szombie.setCustomNameTag(sZombieName);
							}
							world.spawnEntity(szombie);
							ZombieUtils.playMutateSound(szombie.posX, szombie.posY, szombie.posZ, world, rand);
							
							// Volatile
						} else if (mutantChance <= ZombieUtils.MUTATE_VOLATILE_CHANCE) {
							zombie.setDead();
							
							EntityVolatile vzombie = new EntityVolatile(world);
							vzombie.copyLocationAndAnglesFrom(zombie);
							if (zombie.hasCustomName()) {
								String zombieName = zombie.getCustomNameTag();
								String vZombieName = zombieName.replace("Zombie", "Volatile");
								vzombie.setCustomNameTag(vZombieName);
							}
							world.spawnEntity(vzombie);
							ZombieUtils.playMutateSound(vzombie.posX, vzombie.posY, vzombie.posZ, world, rand);
						}
					}
				}
			}
		}
	}
	
	public static void doMutation(Entity entity, Random rand) {
		if (entity instanceof EntityHarranVillager && ConfigManagerZG.enableAlienVillagerMutation) {
			EntityHarranVillager villager = (EntityHarranVillager) entity;
			World world = villager.getEntityWorld();
			if (!world.isRemote) {
				WorldProvider provider = world.provider;
				
				if (provider instanceof WorldProviderMetztli) {
					EntityEvolvedZombie zombie = new EntityEvolvedZombie(world);
					if (!provider.isDaytime()) {
						if (rand.nextInt(500) == 0) {
							villager.setDead();
							zombie.copyLocationAndAnglesFrom(villager);
							zombie.setCustomNameTag("Harran Villager Mutant");
							world.spawnEntity(zombie);
							ZombieUtils.playMutateSound(zombie.posX, zombie.posY, zombie.posZ, world, rand);
							ZombieUtils.playMutateSound(villager.posX, villager.posY, villager.posZ, world, rand);
						}
					}
				}
			}
		}
	}
}