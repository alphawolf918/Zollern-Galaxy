/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities.base;

import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityFlyHelper;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateFlying;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zollerngalaxy.mobs.entities.ai.EntityAIBugAvoidWater;
import zollerngalaxy.mobs.entities.ai.EntityAIBugWander;
import zollerngalaxy.mobs.entities.ai.EntityAIBugWanderAvoidWaterFlying;

public class EntityBugZG extends EntityFlying implements net.minecraft.entity.passive.EntityFlying {
	
	protected float randomMotionVecX;
	protected float randomMotionVecY;
	protected float randomMotionVecZ;
	
	private BlockPos homePosition = BlockPos.ORIGIN;
	private float maximumHomeDistance = -1.0F;
	
	public EntityBugZG(World worldIn) {
		super(worldIn);
		this.setSize(0.7F, 1.4F);
		this.tasks.addTask(1, new EntityAIBugWander(this, 0.8D));
		this.tasks.addTask(2, new EntityAIBugAvoidWater(this, 0.8D));
		this.tasks.addTask(3, new EntityAIBugWanderAvoidWaterFlying(this, 1.0D));
		this.moveHelper = new EntityFlyHelper(this);
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.28D);
		this.getEntityAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(0.4800000059604645D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(45.0D);
	}
	
	@Override
	protected float getSoundVolume() {
		return 0.2F;
	}
	
	@Override
	protected float getSoundPitch() {
		return super.getSoundPitch() * 0.25F;
	}
	
	@Override
	protected PathNavigate createNavigator(World worldIn) {
		PathNavigateFlying pathnavigateflying = new PathNavigateFlying(this, worldIn);
		pathnavigateflying.setCanOpenDoors(false);
		pathnavigateflying.setCanFloat(true);
		pathnavigateflying.setCanEnterDoors(true);
		return pathnavigateflying;
	}
	
	@Override
	public boolean canBePushed() {
		return true;
	}
	
	public boolean isFlying() {
		return !this.onGround;
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