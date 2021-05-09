/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.mobs.entities;

import micdoodle8.mods.galacticraft.api.entity.IEntityBreathable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.events.ZGSoundEvents;

public class EntityGrayAlien extends EntityMob implements IEntityBreathable {
	
	public EntityGrayAlien(World worldIn) {
		super(worldIn);
		this.setSize(this.width * 0.6F, this.height * 0.6F);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIMoveIndoors(this));
		this.tasks.addTask(3, new EntityAIRestrictOpenDoor(this));
		this.tasks.addTask(4, new EntityAIOpenDoor(this, true));
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 0.6D));
		this.tasks.addTask(9, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
		this.tasks.addTask(9, new EntityAIWatchClosest2(this, EntityGrayAlien.class, 5.0F, 0.02F));
		this.tasks.addTask(9, new EntityAIWatchClosest2(this, EntityMummy.class, 5.0F, 0.02F));
		this.tasks.addTask(9, new EntityAIWander(this, 15.6D));
		this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
		this.scoreValue = 70;
		this.experienceValue = 180;
		this.stepHeight = 2.5F;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(45.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23000000417232513D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(180.0D);
	}
	
	@Override
	public boolean canBreath() {
		return true;
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
	public void updateFallState(double y, boolean onGroundIn, IBlockState stateIn, BlockPos pos) {
		
	}
	
	@Override
	public void fall(float par1, float par2) {
		
	}
	
	@Override
	public boolean canBePushed() {
		return false;
	}
	
	@Override
	public boolean canPickUpLoot() {
		return true;
	}
	
	@Override
	protected boolean isValidLightLevel() {
		return true;
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return ZGSoundEvents.ENTITY_ALIEN_AMBIENT;
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return ZGSoundEvents.ENTITY_ALIEN_HURT;
	}
}