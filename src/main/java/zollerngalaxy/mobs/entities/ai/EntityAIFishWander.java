/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities.ai;

import javax.annotation.Nullable;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.math.Vec3d;
import zollerngalaxy.mobs.entities.EntityWaterMobZG;
import zollerngalaxy.util.RandPosGen;

public class EntityAIFishWander extends EntityAIBase {
	
	protected final EntityWaterMobZG entity;
	protected double x;
	protected double y;
	protected double z;
	protected final double speed;
	protected int executionChance;
	protected boolean mustUpdate;
	
	public EntityAIFishWander(EntityWaterMobZG creatureIn, double speedIn) {
		this(creatureIn, speedIn, 120);
	}
	
	public EntityAIFishWander(EntityWaterMobZG creatureIn, double speedIn, int chance) {
		this.entity = creatureIn;
		this.speed = speedIn;
		this.executionChance = chance;
		this.setMutexBits(1);
	}
	
	/**
	 * Returns whether the EntityAIBase should begin execution.
	 */
	@Override
	public boolean shouldExecute() {
		if (!this.mustUpdate) {
			if (this.entity.getIdleTime() >= 100) {
				return false;
			}
			
			if (this.entity.getRNG().nextInt(this.executionChance) != 0) {
				return false;
			}
		}
		
		Vec3d vec3d = this.getPosition();
		
		if (vec3d == null) {
			return false;
		} else {
			this.x = vec3d.x;
			this.y = vec3d.y;
			this.z = vec3d.z;
			this.mustUpdate = false;
			return true;
		}
	}
	
	@Nullable
	protected Vec3d getPosition() {
		return RandPosGen.findRandomTarget(this.entity, 10, 7);
	}
	
	/**
	 * Returns whether an in-progress EntityAIBase should continue executing
	 */
	@Override
	public boolean shouldContinueExecuting() {
		return !this.entity.getNavigator().noPath();
	}
	
	/**
	 * Execute a one shot task or start executing a continuous task
	 */
	@Override
	public void startExecuting() {
		this.entity.getNavigator().tryMoveToXYZ(this.x, this.y, this.z, this.speed);
	}
	
	/**
	 * Makes task to bypass chance
	 */
	public void makeUpdate() {
		this.mustUpdate = true;
	}
	
	/**
	 * Changes task random possibility for execution
	 */
	public void setExecutionChance(int newchance) {
		this.executionChance = newchance;
	}
}