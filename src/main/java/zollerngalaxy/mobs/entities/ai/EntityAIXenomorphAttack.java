/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities.ai;

import net.minecraft.entity.ai.EntityAIAttackMelee;
import zollerngalaxy.mobs.entities.EntityXenomorph;

public class EntityAIXenomorphAttack extends EntityAIAttackMelee {
	
	private final EntityXenomorph xeno;
	private int raiseArmTicks;
	
	public EntityAIXenomorphAttack(EntityXenomorph xenoIn, double speedIn, boolean longMemoryIn) {
		super(xenoIn, speedIn, longMemoryIn);
		this.xeno = xenoIn;
	}
	
	/**
	 * Execute a one shot task or start executing a continuous task
	 */
	@Override
	public void startExecuting() {
		super.startExecuting();
		this.raiseArmTicks = 0;
	}
	
	/**
	 * Resets the task
	 */
	@Override
	public void resetTask() {
		super.resetTask();
		this.xeno.setArmsRaised(false);
	}
	
	/**
	 * Updates the task
	 */
	@Override
	public void updateTask() {
		super.updateTask();
		++this.raiseArmTicks;
		
		if (this.raiseArmTicks >= 5 && this.attackTick < 10) {
			this.xeno.setArmsRaised(true);
		} else {
			this.xeno.setArmsRaised(false);
		}
	}
}