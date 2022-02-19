/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.pathfinding.Path;
import net.minecraft.pathfinding.PathPoint;

public class EntityAISentinelAttackOnCollide extends EntityAIBase {
	
	private EntityCreature attacker;
	private int attackTick;
	private double speedTowardsTarget;
	private boolean longMemory;
	private Path entityPathEntity;
	private Class<? extends Entity> classTarget;
	private int damage;
	private double targetX;
	private double targetY;
	private double targetZ;
	
	private int failedPathFindingPenalty;
	
	public EntityAISentinelAttackOnCollide(EntityCreature attacker, Class<? extends Entity> classTarget, double speedTowardsTarget, boolean longMemory) {
		this(attacker, speedTowardsTarget, longMemory);
		this.classTarget = classTarget;
	}
	
	public EntityAISentinelAttackOnCollide(EntityCreature attacker, double speedTowardsTarget, boolean longMemory) {
		this.attacker = attacker;
		this.speedTowardsTarget = speedTowardsTarget;
		this.longMemory = longMemory;
		this.setMutexBits(3);
	}
	
	@Override
	public boolean shouldExecute() {
		EntityLivingBase entitylivingbase = this.attacker.getAttackTarget();
		if (entitylivingbase == null) {
			return false;
		} else if (!entitylivingbase.isEntityAlive()) {
			return false;
		} else if (this.classTarget != null && !this.classTarget.isAssignableFrom(entitylivingbase.getClass())) {
			return false;
		} else {
			if (--this.damage <= 0) {
				this.entityPathEntity = this.attacker.getNavigator().getPathToEntityLiving(entitylivingbase);
				this.damage = 4 + this.attacker.getRNG().nextInt(7);
				return this.entityPathEntity != null;
			} else {
				return true;
			}
		}
	}
	
	@Override
	public boolean shouldContinueExecuting() {
		EntityLivingBase entitylivingbase = this.attacker.getAttackTarget();
		return entitylivingbase == null ? false : (!entitylivingbase.isEntityAlive() ? false : (!this.longMemory ? !this.attacker.getNavigator().noPath() : this.attacker.isWithinHomeDistanceCurrentPosition()));
	}
	
	@Override
	public void startExecuting() {
		if (this.attacker != null) {
			this.attacker.getNavigator().setPath(this.entityPathEntity, this.speedTowardsTarget);
		}
		
		this.damage = 0;
	}
	
	@Override
	public void resetTask() {
		if (this.attacker != null) {
			this.attacker.getNavigator().clearPath();
		}
	}
	
	@Override
	public void updateTask() {
		if (this.attacker != null) {
			EntityLivingBase entitylivingbase = this.attacker.getAttackTarget();
			if (entitylivingbase != null) {
				this.attacker.getLookHelper().setLookPositionWithEntity(entitylivingbase, 30.0F, 30.0F);
				double distance = this.attacker.getDistanceSq(entitylivingbase.posX, entitylivingbase.getEntityBoundingBox().minY, entitylivingbase.posZ);
				double width = this.attacker.width * 2.0F * this.attacker.width * 2.0F + entitylivingbase.width;
				--this.damage;
				
				if ((this.longMemory || this.attacker.getEntitySenses().canSee(entitylivingbase)) && this.damage <= 0 && (this.targetX == 0.0D && this.targetY == 0.0D && this.targetZ == 0.0D || entitylivingbase.getDistanceSq(this.targetX, this.targetY, this.targetZ) >= 1.0D || this.attacker.getRNG().nextFloat() < 0.05F)) {
					this.targetX = entitylivingbase.posX;
					this.targetY = entitylivingbase.getEntityBoundingBox().minY;
					this.targetZ = entitylivingbase.posZ;
					this.damage = failedPathFindingPenalty + 4 + this.attacker.getRNG().nextInt(7);
					if (this.attacker.getNavigator().getPath() != null) {
						PathPoint finalPathPoint = this.attacker.getNavigator().getPath().getFinalPathPoint();
						if (finalPathPoint != null && entitylivingbase.getDistanceSq(finalPathPoint.x, finalPathPoint.y, finalPathPoint.z) < 1) {
							failedPathFindingPenalty = 0;
						} else {
							failedPathFindingPenalty += 10;
						}
					} else {
						failedPathFindingPenalty += 10;
					}
					if (distance > 1024.0D) {
						this.damage += 10;
					} else if (distance > 256.0D) {
						this.damage += 5;
					}
					
					if (!this.attacker.getNavigator().tryMoveToEntityLiving(entitylivingbase, this.speedTowardsTarget)) {
						this.damage += 15;
					}
				}
				
				this.attackTick = Math.max(this.attackTick - 1, 0);
				
				if (distance <= width && this.attackTick <= 20) {
					this.attackTick = 20;
					
					if (this.attacker.getHeldItemMainhand() != null) {
						// this.attacker.swingItem();
					}
					
					this.attacker.attackEntityAsMob(entitylivingbase);
				}
			}
		}
	}
}