/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities.robots;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zollerngalaxy.blocks.fluids.ZGFluids;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.events.ZGSoundEvents;
import zollerngalaxy.mobs.entities.base.EntityRobotBaseZG;

public class EntityVexBot extends EntityRobotBaseZG {
	
	public EntityVexBot(World worldIn) {
		super(worldIn);
		this.setSize(this.width * 1.1F, this.height * 1.1F);
		this.isImmuneToFire = true;
		this.scoreValue = 470;
		this.experienceValue = 671;
		this.stepHeight = 1.5F;
	}
	
	@Override
	public void fall(float par1, float par2) {
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(14.8D);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(60.0D);
	}
	
	@Override
	public float getBlockPathWeight(BlockPos pos) {
		return 1.5F - this.world.getLightBrightness(pos);
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return ZGSoundEvents.ENTITY_VEXBOT_SAY;
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return ZGSoundEvents.ENTITY_VEXBOT_HURT;
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		return ZGSoundEvents.ENTITY_VEXBOT_DIE;
	}
	
	@Override
	public void onDeath(DamageSource par1) {
		super.onDeath(par1);
		if (!this.world.isRemote) {
			IBlockState stateCheck = world.getBlockState(entPos.add(0, 1, 0));
			if (stateCheck == Blocks.AIR.getDefaultState() && !ConfigManagerZG.disableVexbotRadiolaria) {
				IBlockState radiolaria = ZGFluids.blockWhiteLavaFluid.getDefaultState();
				this.world.setBlockState(entPos, radiolaria);
			}
		}
	}
}