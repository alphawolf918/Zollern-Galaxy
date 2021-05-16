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
import net.minecraft.inventory.Container;
import zollerngalaxy.mobs.entities.base.EntityZGVillagerBase;

public class EntityAITradePlayerZG extends EntityAIBase {
	
	private EntityZGVillagerBase villager;
	
	public EntityAITradePlayerZG(EntityZGVillagerBase entityZGVillagerBase) {
		this.villager = entityZGVillagerBase;
		this.setMutexBits(5);
	}
	
	@Override
	public boolean shouldExecute() {
		if (!this.villager.isEntityAlive()) {
			return false;
		} else if (this.villager.isInWater()) {
			return false;
		} else if (!this.villager.onGround) {
			return false;
		} else if (this.villager.velocityChanged) {
			return false;
		} else {
			EntityPlayer entityplayer = this.villager.getCustomer();
			return entityplayer == null ? false : (this.villager.getDistanceSq(entityplayer) > 16.0D ? false : entityplayer.openContainer instanceof Container);
		}
	}
	
	@Override
	public void startExecuting() {
		this.villager.getNavigator().clearPath();
	}
	
	@Override
	public void resetTask() {
		this.villager.setCustomer((EntityPlayer) null);
	}
}