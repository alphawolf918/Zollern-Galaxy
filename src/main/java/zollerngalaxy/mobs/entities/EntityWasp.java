/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities;

import javax.annotation.Nullable;
import micdoodle8.mods.galacticraft.core.entities.EntityAlienVillager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zollerngalaxy.mobs.entities.ai.EntityAIWaspNearestAttackableTarget;
import zollerngalaxy.util.ZGDamageSrc;

public class EntityWasp extends EntityBat implements IMob {
	
	protected float randomMotionVecX;
	protected float randomMotionVecY;
	protected float randomMotionVecZ;
	protected float randomMotionSpeed = 0.1F;
	
	private BlockPos homePosition = BlockPos.ORIGIN;
	private float maximumHomeDistance = -1.0F;
	
	public EntityWasp(World worldIn) {
		super(worldIn);
		this.setSize(0.7F, 1.4F);
		this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 16.0F));
		this.tasks.addTask(2, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIWaspNearestAttackableTarget(this, EntityPlayer.class, true));
		this.targetTasks.addTask(2, new EntityAIWaspNearestAttackableTarget(this, EntityAlienVillager.class, true));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.26D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
	}
	
	@Override
	protected float getSoundVolume() {
		return 1.2F;
	}
	
	@Override
	@Nullable
	public SoundEvent getAmbientSound() {
		return this.getIsBatHanging() && this.rand.nextInt(4) != 0 ? null : SoundEvents.ENTITY_BAT_AMBIENT;
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_BAT_HURT;
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_BAT_DEATH;
	}
	
	@Override
	protected void collideWithEntity(Entity entityIn) {
	}
	
	@Override
	protected void collideWithNearbyEntities() {
	}
	
	@Override
	public void onCollideWithPlayer(EntityPlayer playerIn) {
		if (!this.getEntityWorld().isRemote) {
			playerIn.attackEntityFrom(ZGDamageSrc.deathWasp, ZGDamageSrc.deathWasp.getDamageBase());
		}
	}
	
	@Override
	public void travel(float strafe, float vertical, float forward) {
		this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
	}
	
	public void setMovementVector(float randomMotionVecXIn, float randomMotionVecYIn, float randomMotionVecZIn) {
		this.randomMotionVecX = randomMotionVecXIn;
		this.randomMotionVecY = randomMotionVecYIn;
		this.randomMotionVecZ = randomMotionVecZIn;
	}
	
	public boolean hasMovementVector() {
		return this.randomMotionVecX != 0.0F || this.randomMotionVecY != 0.0F || this.randomMotionVecZ != 0.0F;
	}
	
	public boolean isWithinHomeDistanceCurrentPosition() {
		return this.isWithinHomeDistanceFromPosition(new BlockPos(this));
	}
	
	public boolean isWithinHomeDistanceFromPosition(BlockPos pos) {
		if (this.maximumHomeDistance == -1.0F) {
			return true;
		} else {
			return this.homePosition.distanceSq(pos) < this.maximumHomeDistance * this.maximumHomeDistance;
		}
	}
	
	public void setHomePosAndDistance(BlockPos pos, int distance) {
		this.homePosition = pos;
		this.maximumHomeDistance = distance;
	}
	
	public BlockPos getHomePosition() {
		return this.homePosition;
	}
	
	public float getMaximumHomeDistance() {
		return this.maximumHomeDistance;
	}
	
	public void detachHome() {
		this.maximumHomeDistance = -1.0F;
	}
	
	public boolean hasHome() {
		return this.maximumHomeDistance != -1.0F;
	}
	
	public float getBlockPathWeight(BlockPos pos) {
		return 0.0F;
	}
}