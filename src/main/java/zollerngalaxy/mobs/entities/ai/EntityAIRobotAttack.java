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
import zollerngalaxy.mobs.entities.base.EntityRobotBaseZG;

public class EntityAIRobotAttack extends EntityAIAttackMelee {
	
	private final EntityRobotBaseZG bot;
	private int raiseArmTicks;
	
	public EntityAIRobotAttack(EntityRobotBaseZG botIn, double speedIn, boolean longMemoryIn) {
		super(botIn, speedIn, longMemoryIn);
		this.bot = botIn;
	}
	
	@Override
	protected void checkAndPerformAttack(EntityLivingBase p_190102_1_, double p_190102_2_) {
		double d0 = this.getAttackReachSqr(p_190102_1_);
		
		if (p_190102_2_ <= d0 && this.attackTick <= 0) {
			this.attackTick = 20;
			this.attacker.attackEntityAsMob(p_190102_1_);
		}
	}
}