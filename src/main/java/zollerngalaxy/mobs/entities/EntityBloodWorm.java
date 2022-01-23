/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities;

import micdoodle8.mods.galacticraft.api.entity.IEntityBreathable;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zollerngalaxy.events.ZGSoundEvents;

public class EntityBloodWorm extends EntityMob implements IEntityBreathable {
	
	public EntityBloodWorm(World worldIn) {
		super(worldIn);
		this.scoreValue = 770;
		this.experienceValue = 782;
		this.stepHeight = 1.5F;
	}
	
	@Override
	protected void initEntityAI() {
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.2D, false));
		this.tasks.addTask(3, new EntityAIWanderAvoidWater(this, 1.4F));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[0]));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(20.0D);
	}
	
	@Override
	public void onUpdate() {
		this.renderYawOffset = this.rotationYaw;
		super.onUpdate();
	}
	
	@Override
	public void setRenderYawOffset(float offset) {
		this.rotationYaw = offset;
		super.setRenderYawOffset(offset);
	}
	
	@Override
	public float getBlockPathWeight(BlockPos pos) {
		return this.world.getBlockState(pos.down()).getBlock() == Blocks.STONE ? 10.0F : super.getBlockPathWeight(pos);
	}
	
	@Override
	public void fall(float par1, float par2) {
	}
	
	@Override
	public boolean canBePushed() {
		return false;
	}
	
	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.ARTHROPOD;
	}
	
	@Override
	protected boolean canTriggerWalking() {
		return false;
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return ZGSoundEvents.ENTITY_BLOODWORM_SAY;
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return ZGSoundEvents.ENTITY_BLOODWORM_HURT;
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		return ZGSoundEvents.ENTITY_BLOODWORM_DEATH;
	}
	
	protected SoundEvent getStepSound() {
		return ZGSoundEvents.ENTITY_BLOODWORM_STEP;
	}
	
	@Override
	public boolean canBreath() {
		return true;
	}
}