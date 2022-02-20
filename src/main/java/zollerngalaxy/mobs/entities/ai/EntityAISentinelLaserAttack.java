/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities.ai;

import java.util.Random;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import zollerngalaxy.events.ZGSoundEvents;
import zollerngalaxy.mobs.entities.projectiles.EntitySentinelLaser;
import zollerngalaxy.mobs.entities.robots.sentinels.EntityAbstractSentinel;

public class EntityAISentinelLaserAttack extends EntityAIBase {
	
	private final EntityAbstractSentinel parentEntity;
	public int attackTimer;
	
	public EntityAISentinelLaserAttack(EntityAbstractSentinel sentinel) {
		this.parentEntity = sentinel;
	}
	
	@Override
	public boolean shouldExecute() {
		return this.parentEntity.getAttackTarget() != null;
	}
	
	@Override
	public void startExecuting() {
		this.attackTimer = 0;
	}
	
	@Override
	public void resetTask() {
		this.parentEntity.setAttacking(false);
	}
	
	@Override
	public void updateTask() {
		Random rand = new Random();
		EntityLivingBase entityLivingTarget = this.parentEntity.getAttackTarget();
		if (entityLivingTarget.getDistanceSq(this.parentEntity) < 4096.0D && this.parentEntity.canEntityBeSeen(entityLivingTarget)) {
			World world = this.parentEntity.world;
			++this.attackTimer;
			if (this.attackTimer == 10) {
				for (int i = 0; i < 9; i++) {
					if ((i % 2) == 0 && rand.nextInt(8) == 0) {
						continue;
					}
					Vec3d vec3d = this.parentEntity.getLook(1.0F);
					double d2 = entityLivingTarget.posX - (this.parentEntity.posX + vec3d.x * 4.0D);
					double d3 = entityLivingTarget.getEntityBoundingBox().minY + entityLivingTarget.height / 2.0F - (0.5D + this.parentEntity.posY + this.parentEntity.height / 2.0F);
					double d4 = entityLivingTarget.posZ - (this.parentEntity.posZ + vec3d.z * 4.0D);
					EntitySentinelLaser entitySentinelLaser = new EntitySentinelLaser(world, this.parentEntity, d2, d3, d4);
					entitySentinelLaser.posX = this.parentEntity.posX + vec3d.x * 4.0D;
					entitySentinelLaser.posY = this.parentEntity.posY + this.parentEntity.height / 2.0F + 0.5D;
					entitySentinelLaser.posZ = this.parentEntity.posZ + vec3d.z * 4.0D;
					world.spawnEntity(entitySentinelLaser);
					this.parentEntity.world.playSound(null, this.parentEntity.getPosition(), ZGSoundEvents.ENTITY_SENTINEL_SHOOT, SoundCategory.MASTER, 8.0F, 1.0F);
					this.attackTimer = -5;// EntityGhast
				}
			}
		} else if (this.attackTimer > 0) {
			--this.attackTimer;
		}
		this.parentEntity.setAttacking(this.attackTimer > 5);
	}
}