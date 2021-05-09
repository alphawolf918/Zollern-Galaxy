/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities;

import micdoodle8.mods.galacticraft.api.entity.IEntityBreathable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import zollerngalaxy.mobs.entities.interfaces.IShadeEntity;

public class EntityScorpion extends EntityCaveSpider implements IEntityBreathable, IShadeEntity {
	
	public EntityScorpion(World par1World) {
		super(par1World);
		this.setSize(this.width * 0.5F, this.height * 0.5F);
		this.setHealth(65.2F);
		this.setAIMoveSpeed(3.2F);
		this.experienceValue = 80;
		this.scoreValue = 550;
		this.stepHeight = 3F;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(65.2D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.600000002020930D);
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_SPIDER_AMBIENT;
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource src) {
		return SoundEvents.ENTITY_SPIDER_HURT;
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_SPIDER_DEATH;
	}
	
	@Override
	public boolean canBreath() {
		return true;
	}
	
}