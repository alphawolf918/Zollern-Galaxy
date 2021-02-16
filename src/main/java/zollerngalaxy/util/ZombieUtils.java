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
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import zollerngalaxy.events.ZGSoundEvents;

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
		EntityMob zombie = new EntityZombie(world); // Zombie by default; prevents nulls
		if (entityName != "Zombie") {
			try {
				zombie = entityMutant.getDeclaredConstructor(World.class).newInstance(world);
			} catch (InstantiationException e) {
				zombie.setWorld(world);
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}
		}
		zombie.setLocationAndAngles(x, y, z, player.rotationYaw, player.rotationPitch);
		zombie.setCustomNameTag(entityName + " " + playerName);
		world.spawnEntity(zombie);
		ZombieUtils.playMutateSound(zombie.posX, zombie.posY, zombie.posY, world, rand);
	}
	
	/**
	 * For playing the Mutation sound.
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @param world
	 * @param rand
	 */
	public static void playMutateSound(double x, double y, double z, World world, Random rand) {
		float randFloat = 4.0F + rand.nextFloat();
		float randFloat2 = rand.nextFloat() * 0.7F + 0.3F;
		double extendBy = 1.5D;
		x += extendBy;
		y += extendBy;
		z += extendBy;
		world.playSound(x, y, z, ZGSoundEvents.ENTITY_VOLATILE_MUTATE, SoundCategory.AMBIENT, randFloat, randFloat2, false);
	}
	
}