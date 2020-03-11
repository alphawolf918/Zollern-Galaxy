/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities;

import java.util.Random;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import zollerngalaxy.mobs.entities.ai.EntityAIFishPanic;
import zollerngalaxy.mobs.entities.ai.EntityAIFishWander;

public class EntityBlubberFish extends EntityWaterMobZG {
	
	private float rotationVelocity;
	private float health = 12.64F;
	protected Random rand = new Random();
	protected float minSize = 0.1F;
	protected float maxSize = 6.5F;
	protected float fishEq = this.rand.nextFloat();
	protected float fishSize = (this.fishEq + this.minSize);
	
	public EntityBlubberFish(World worldIn) {
		super(worldIn);
		this.setSize(0.8F, 0.8F);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIFishWander(this, 2.0D));
		this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
		this.tasks.addTask(3, new EntityAILookIdle(this));
		this.tasks.addTask(4, new EntityAIFishPanic(this, 1.25D));
		this.setHealth(this.health);
		// EntitySquid
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.214D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(this.health);
	}
	
	@Override
	public boolean getCanSpawnHere() {
		boolean seaHeightMax = this.posY >= 35.0D;
		boolean seaHeightMin = this.posY <= this.world.getSeaLevel();
		boolean canSpawnHereSuper = super.getCanSpawnHere();
		boolean canSpawn = (seaHeightMax && seaHeightMin && canSpawnHereSuper);
		return seaHeightMax && seaHeightMin && canSpawnHereSuper;
	}
}