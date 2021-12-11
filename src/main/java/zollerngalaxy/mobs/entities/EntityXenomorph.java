/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities;

import javax.annotation.Nullable;
import micdoodle8.mods.galacticraft.api.entity.IEntityBreathable;
import micdoodle8.mods.galacticraft.core.entities.EntityAlienVillager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.blocks.centotl.BlockFacehuggerEgg;
import zollerngalaxy.events.ZGSoundEvents;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.mobs.entities.ai.EntityAIXenomorphAttack;
import zollerngalaxy.mobs.entities.base.EntityZGVillagerBase;
import zollerngalaxy.mobs.entities.interfaces.IShadeEntity;

public class EntityXenomorph extends EntityMob implements IShadeEntity, IEntityBreathable {
	
	protected static final DataParameter<Boolean> ARMS_RAISED = EntityDataManager.<Boolean> createKey(EntityXenomorph.class, DataSerializers.BOOLEAN);
	protected final EntityAIBreakDoor breakDoor = new EntityAIBreakDoor(this);
	protected boolean isBreakDoorsTaskSet;
	protected double moveSpeed = 1.5D;
	protected float watchDistance = 8.5F;
	
	public EntityXenomorph(World worldIn) {
		super(worldIn);
		this.setSize(0.6F * 3.5F, 1.95F * 5.5F);
		this.isImmuneToFire = true;
	}
	
	@Override
	public void fall(float par1, float par2) {
	}
	
	@Override
	protected void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIXenomorphAttack(this, this.moveSpeed, false));
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, this.moveSpeed));
		this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, this.moveSpeed));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, this.watchDistance));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityZGVillagerBase.class, this.watchDistance));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityAlienVillager.class, this.watchDistance));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityZombie.class, this.watchDistance));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntitySpider.class, this.watchDistance));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityEnderman.class, this.watchDistance));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityAgeable.class, this.watchDistance));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.applyEntityAI();
	}
	
	protected void applyEntityAI() {
		this.tasks.addTask(6, new EntityAIMoveThroughVillage(this, this.moveSpeed, false));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityZGVillagerBase.class, true));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityAlienVillager.class, true));
		this.targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, EntityZombie.class, true));
		this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntitySpider.class, true));
		this.targetTasks.addTask(6, new EntityAINearestAttackableTarget(this, EntityCreeper.class, true));
		this.targetTasks.addTask(7, new EntityAINearestAttackableTarget(this, EntityEnderman.class, true));
		this.targetTasks.addTask(8, new EntityAINearestAttackableTarget(this, EntityAgeable.class, true));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(85.0D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.34257213517232513D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(15.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(20.0D);
	}
	
	@Override
	protected void entityInit() {
		super.entityInit();
		this.getDataManager().register(ARMS_RAISED, Boolean.valueOf(false));
	}
	
	public void setArmsRaised(boolean armsRaised) {
		this.getDataManager().set(ARMS_RAISED, Boolean.valueOf(armsRaised));
	}
	
	@SideOnly(Side.CLIENT)
	public boolean isArmsRaised() {
		return this.getDataManager().get(ARMS_RAISED).booleanValue();
	}
	
	public boolean isBreakDoorsTaskSet() {
		return this.isBreakDoorsTaskSet;
	}
	
	public void setBreakDoorsAItask(boolean enabled) {
		if (this.isBreakDoorsTaskSet != enabled) {
			this.isBreakDoorsTaskSet = enabled;
			((PathNavigateGround) this.getNavigator()).setBreakDoors(enabled);
			
			if (enabled) {
				this.tasks.addTask(1, this.breakDoor);
			} else {
				this.tasks.removeTask(this.breakDoor);
			}
		}
	}
	
	@Override
	protected int getExperiencePoints(EntityPlayer player) {
		return super.getExperiencePoints(player);
	}
	
	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		boolean flag = super.attackEntityAsMob(entityIn);
		return flag;
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return ZGSoundEvents.ENTITY_XENO_SAY;
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return ZGSoundEvents.ENTITY_XENO_HURT;
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		return ZGSoundEvents.ENTITY_XENO_DEATH;
	}
	
	protected SoundEvent getStepSound() {
		return SoundEvents.ENTITY_ZOMBIE_STEP;
	}
	
	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEFINED;
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setBoolean("CanBreakDoors", this.isBreakDoorsTaskSet());
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.setBreakDoorsAItask(compound.getBoolean("CanBreakDoors"));
	}
	
	@Override
	public void onKillEntity(EntityLivingBase entityLivingIn) {
		super.onKillEntity(entityLivingIn);
		World world = this.world;
		BlockPos pos = new BlockPos(this.posX, this.posY, this.posZ);
		if (ZGHelper.rngInt(0, 100) <= 5) {
			if (world.getBlockState(pos) == Blocks.AIR.getDefaultState()) {
				BlockFacehuggerEgg egg = (BlockFacehuggerEgg) ZGBlocks.facehuggerEgg;
				world.setBlockState(pos, egg.getDefaultState());
				if (ZGHelper.rngInt(0, 100) <= 50) {
					egg.hatchEgg(world, pos);
				}
			}
		}
	}
	
	@Override
	public float getEyeHeight() {
		float f = 2.74F;
		return f;
	}
	
	@Override
	@Nullable
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		livingdata = super.onInitialSpawn(difficulty, livingdata);
		float f = difficulty.getClampedAdditionalDifficulty();
		this.setBreakDoorsAItask(this.rand.nextFloat() < f * 0.1F);
		this.setCanPickUpLoot(this.rand.nextFloat() < 0.55F * f);
		AttributeModifier attrMod = new AttributeModifier("Random spawn bonus", this.rand.nextDouble() * 0.05000000074505806D, 0);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).applyModifier(attrMod);
		if (this.rand.nextFloat() < f * 0.05F) {
			this.setBreakDoorsAItask(true);
		}
		return livingdata;
	}
	
	@Override
	public boolean canBreath() {
		return true;
	}
}