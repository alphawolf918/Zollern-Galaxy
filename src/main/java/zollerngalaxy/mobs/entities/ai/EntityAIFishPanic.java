/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities.ai;

import javax.annotation.Nullable;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import zollerngalaxy.mobs.entities.EntityWaterMobZG;
import zollerngalaxy.util.RandPosGen;

public class EntityAIFishPanic extends EntityAIBase {
	
	protected final EntityWaterMobZG fish;
	protected double speed;
	protected double randPosX;
	protected double randPosY;
	protected double randPosZ;
	
	public EntityAIFishPanic(EntityWaterMobZG fish, double speedIn) {
		this.fish = fish;
		this.speed = speedIn;
		this.setMutexBits(1);
	}
	
	/**
	 * Returns whether the EntityAIBase should begin execution.
	 */
	@Override
	public boolean shouldExecute() {
		if (this.fish.getRevengeTarget() == null && !this.fish.isBurning()) {
			return false;
		} else {
			if (this.fish.isBurning()) {
				BlockPos blockpos = this.getRandPos(this.fish.world, this.fish, 5, 4);
				
				if (blockpos != null) {
					this.randPosX = blockpos.getX();
					this.randPosY = blockpos.getY();
					this.randPosZ = blockpos.getZ();
					return true;
				}
			}
			
			return this.findRandomPosition();
		}
	}
	
	protected boolean findRandomPosition() {
		Vec3d vec3d = RandPosGen.findRandomTarget(this.fish, 5, 4);
		
		if (vec3d == null) {
			return false;
		} else {
			this.randPosX = vec3d.x;
			this.randPosY = vec3d.y;
			this.randPosZ = vec3d.z;
			return true;
		}
	}
	
	/**
	 * Execute a one shot task or start executing a continuous task
	 */
	@Override
	public void startExecuting() {
		this.fish.getNavigator().tryMoveToXYZ(this.randPosX, this.randPosY, this.randPosZ, this.speed);
	}
	
	/**
	 * Returns whether an in-progress EntityAIBase should continue executing
	 */
	@Override
	public boolean shouldContinueExecuting() {
		return !this.fish.getNavigator().noPath();
	}
	
	@Nullable
	private BlockPos getRandPos(World worldIn, Entity entityIn, int horizontalRange, int verticalRange) {
		BlockPos blockpos = new BlockPos(entityIn);
		int i = blockpos.getX();
		int j = blockpos.getY();
		int k = blockpos.getZ();
		float f = horizontalRange * horizontalRange * verticalRange * 2;
		BlockPos blockpos1 = null;
		BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
		
		for (int l = i - horizontalRange; l <= i + horizontalRange; ++l) {
			for (int i1 = j - verticalRange; i1 <= j + verticalRange; ++i1) {
				for (int j1 = k - horizontalRange; j1 <= k + horizontalRange; ++j1) {
					blockpos$mutableblockpos.setPos(l, i1, j1);
					IBlockState iblockstate = worldIn.getBlockState(blockpos$mutableblockpos);
					
					if (iblockstate.getMaterial() == Material.WATER) {
						float f1 = (l - i) * (l - i) + (i1 - j) * (i1 - j) + (j1 - k) * (j1 - k);
						
						if (f1 < f) {
							f = f1;
							blockpos1 = new BlockPos(blockpos$mutableblockpos);
						}
					}
				}
			}
		}
		
		return blockpos1;
	}
}