/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities;

import micdoodle8.mods.galacticraft.api.entity.IEntityBreathable;
import micdoodle8.mods.galacticraft.core.entities.EntityAlienVillager;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.fluids.ZGFluids;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.events.ZGSoundEvents;
import zollerngalaxy.mobs.entities.ai.EntityAIVexbotAttack;
import zollerngalaxy.mobs.entities.base.EntityZGVillagerBase;

public class EntityVexBot extends EntityMob implements IEntityBreathable {
	
	private BlockPos entPos = this.getPosition();
	
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
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(25.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.28D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(14.8D);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50.0D);
	}
	
	@Override
	protected void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIMoveTowardsRestriction(this, 1.6D));
		this.tasks.addTask(2, new EntityAIVexbotAttack(this, 1.8F, true));
		this.tasks.addTask(3, new EntityAIWanderAvoidWater(this, 3.0D));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 16.0F));
		this.tasks.addTask(4, new EntityAILookIdle(this));
		this.applyEntityAI();
	}
	
	protected void applyEntityAI() {
		this.tasks.addTask(5, new EntityAIMoveThroughVillage(this, 1.5D, false));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityAgeable.class, true));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityZGVillagerBase.class, false));
		this.targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, EntityAlienVillager.class, false));
		this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntityGrayAlien.class, true));
	}
	
	@Override
	public void onLivingUpdate() {
		if (this.isInWater()) {
			this.attackEntityFrom(DamageSource.DROWN, 10.0F);
		}
		this.entPos = this.getPosition();
		super.onLivingUpdate();
	}
	
	@Override
	public int getMaxSpawnedInChunk() {
		return 4;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getBrightnessForRender() {
		return 15728890;
	}
	
	@Override
	public float getBrightness() {
		return 4.0F;
	}
	
	@Override
	public float getBlockPathWeight(BlockPos pos) {
		return 1.5F - this.world.getLightBrightness(pos);
	}
	
	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEFINED;
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
	
	@Override
	public boolean canBreath() {
		return true;
	}
}