/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities.ai;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import zollerngalaxy.mobs.entities.EntityGalaxyDragon;

public class EntityAIDragonBeg extends EntityAIBase {
	
	private final EntityGalaxyDragon dragon;
	private EntityPlayer player;
	private final World world;
	private final float minPlayerDistance;
	private int timeoutCounter;
	
	public EntityAIDragonBeg(EntityGalaxyDragon dragon, float minDistance) {
		this.dragon = dragon;
		this.world = dragon.world;
		this.minPlayerDistance = minDistance;
		this.setMutexBits(2);
	}
	
	@Override
	public boolean shouldExecute() {
		this.player = this.world.getClosestPlayerToEntity(this.dragon, this.minPlayerDistance);
		return this.player == null ? false : this.hasTemptationItemInHand(this.player);
	}
	
	@Override
	public boolean shouldContinueExecuting() {
		if (!this.player.isEntityAlive()) {
			return false;
		} else if (this.dragon.getDistanceSq(this.player) > this.minPlayerDistance * this.minPlayerDistance) {
			return false;
		} else {
			return this.timeoutCounter > 0 && this.hasTemptationItemInHand(this.player);
		}
	}
	
	/**
	 * Execute a one shot task or start executing a continuous task
	 */
	@Override
	public void startExecuting() {
		this.dragon.setBegging(true);
		this.timeoutCounter = 40 + this.dragon.getRNG().nextInt(40);
	}
	
	/**
	 * Reset the task's internal state. Called when this task is interrupted by another one
	 */
	@Override
	public void resetTask() {
		this.dragon.setBegging(false);
		this.player = null;
	}
	
	/**
	 * Keep ticking a continuous task that has already been started
	 */
	@Override
	public void updateTask() {
		this.dragon.getLookHelper().setLookPosition(this.player.posX, this.player.posY + this.player.getEyeHeight(), this.player.posZ, 10.0F, this.dragon.getVerticalFaceSpeed());
		--this.timeoutCounter;
	}
	
	/**
	 * Gets if the Player has the Bone in the hand.
	 */
	private boolean hasTemptationItemInHand(EntityPlayer player) {
		for (EnumHand enumhand : EnumHand.values()) {
			ItemStack itemstack = player.getHeldItem(enumhand);
			
			if (this.dragon.isTamed() && itemstack.getItem() == Items.BONE) {
				return true;
			}
			
			if (this.dragon.isBreedingItem(itemstack)) {
				return true;
			}
		}
		
		return false;
	}
}