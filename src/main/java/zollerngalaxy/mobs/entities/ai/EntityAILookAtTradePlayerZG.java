/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities.ai;

import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import zollerngalaxy.mobs.entities.EntityAbyssalVillager;

public class EntityAILookAtTradePlayerZG extends EntityAIWatchClosest {
	
	private final EntityAbyssalVillager theMerchant;
	
	public EntityAILookAtTradePlayerZG(EntityAbyssalVillager theMerchantIn) {
		super(theMerchantIn, EntityPlayer.class, 8.0F);
		this.theMerchant = theMerchantIn;
	}
	
	/**
	 * Returns whether the EntityAIBase should begin execution.
	 */
	@Override
	public boolean shouldExecute() {
		if (this.theMerchant.isTrading()) {
			this.closestEntity = this.theMerchant.getCustomer();
			return true;
		} else {
			return false;
		}
	}
}