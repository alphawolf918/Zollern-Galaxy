/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities.base;

import micdoodle8.mods.galacticraft.api.entity.IEntityBreathable;
import micdoodle8.mods.galacticraft.core.entities.EntityAlienVillager;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.mobs.entities.EntityFacehugger;
import zollerngalaxy.mobs.entities.EntityGrayAlien;
import zollerngalaxy.mobs.entities.EntityKree;
import zollerngalaxy.mobs.entities.EntityXenomorph;
import zollerngalaxy.mobs.entities.ai.EntityAIRobotAttack;
import zollerngalaxy.mobs.entities.interfaces.IEntityRobot;

public class EntityRobotBaseZG extends EntityMob implements IEntityRobot, IEntityBreathable {
	
	protected BlockPos entPos = this.getPosition();
	
	public EntityRobotBaseZG(World worldIn) {
		super(worldIn);
	}
	
	@Override
	public void fall(float distance, float damageMultiplier) {
	}
	
	@Override
	protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos) {
	}
	
	@Override
	public void knockBack(Entity par1Entity, float par2, double par3, double par5) {
	}
	
	@Override
	protected void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIMoveTowardsRestriction(this, 1.6D));
		this.tasks.addTask(2, new EntityAIRobotAttack(this, 1.8F, true));
		this.tasks.addTask(3, new EntityAIWanderAvoidWater(this, 3.0D));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 16.0F));
		this.tasks.addTask(4, new EntityAILookIdle(this));
		this.applyEntityAI();
	}
	
	protected void applyEntityAI() {
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityAgeable.class, true));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityZGVillagerBase.class, true));
		this.targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, EntityAlienVillager.class, true));
		this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntityGrayAlien.class, true));
		this.targetTasks.addTask(6, new EntityAINearestAttackableTarget(this, EntityKree.class, true));
		this.targetTasks.addTask(7, new EntityAINearestAttackableTarget(this, EntityFacehugger.class, true));
		this.targetTasks.addTask(8, new EntityAINearestAttackableTarget(this, EntityXenomorph.class, true));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.28D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50.0D);
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
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEFINED;
	}
	
	@Override
	public int getMaxSpawnedInChunk() {
		return 4;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getBrightnessForRender() {
		return 16728890;
	}
	
	@Override
	public float getBrightness() {
		return 5.0F;
	}
	
	@Override
	public boolean canBreath() {
		return true;
	}
}