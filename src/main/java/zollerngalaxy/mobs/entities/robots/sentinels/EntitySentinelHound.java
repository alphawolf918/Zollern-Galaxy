/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities.robots.sentinels;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import zollerngalaxy.events.ZGSoundEvents;

public class EntitySentinelHound extends EntityAbstractSentinel {
	
	public EntitySentinelHound(World worldIn) {
		super(worldIn);
		this.setSize(this.width * 2.2F, this.height * 2.2F);
	}
	
	@Override
	public void initEntityAI() {
		super.initEntityAI();
		this.tasks.addTask(6, new EntityAILeapAtTarget(this, 1.0F));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(85.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.32D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(15.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).setBaseValue(16.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50.0D);
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return ZGSoundEvents.ENTITY_SENTINEL_HOUND_SAY;
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return ZGSoundEvents.ENTITY_SENTINEL_HOUND_HURT;
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		return ZGSoundEvents.ENTITY_SENTINEL_HOUND_DIE;
	}
	
	@Override
	protected int getCallReinforcementsChance() {
		return 10;
	}
	
	@Override
	public int getMaxSpawnedInChunk() {
		return 2;
	}
}