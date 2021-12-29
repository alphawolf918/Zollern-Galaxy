/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import zollerngalaxy.mobs.entities.EntityXenomorph;

public class EntityAIXenomorphAttack extends EntityAIAttackMelee {
	
	private final EntityXenomorph xeno;
	private int raiseArmTicks;
	
	public EntityAIXenomorphAttack(EntityXenomorph xenoIn, double speedIn, boolean longMemoryIn) {
		super(xenoIn, speedIn, longMemoryIn);
		this.xeno = xenoIn;
	}
	
	@Override
	protected void checkAndPerformAttack(EntityLivingBase p_190102_1_, double p_190102_2_) {
		double d0 = this.getAttackReachSqr(p_190102_1_);
		
		if (p_190102_2_ <= d0 && this.attackTick <= 0) {
			this.attackTick = 20;
			this.attacker.attackEntityAsMob(p_190102_1_);
		}
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