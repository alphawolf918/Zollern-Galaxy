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
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.mobs.entities.ai.EntityAIKreeAttack;
import zollerngalaxy.mobs.entities.base.EntityZGVillagerBase;
import zollerngalaxy.mobs.entities.robots.EntityVexBot;
import zollerngalaxy.mobs.entities.robots.sentinels.EntityAbstractSentinel;

public class EntityKree extends EntityMob implements IEntityBreathable {
	
	protected static final DataParameter<Boolean> ARMS_RAISED = EntityDataManager.<Boolean> createKey(EntityKree.class, DataSerializers.BOOLEAN);
	protected final EntityAIBreakDoor breakDoor = new EntityAIBreakDoor(this);
	protected boolean isBreakDoorsTaskSet;
	
	public EntityKree(World worldIn) {
		super(worldIn);
		this.setSize(this.width * 1.2F, this.height * 1.2F);
		this.setCanPickUpLoot(true);
		this.experienceValue = 90;
		this.scoreValue = 90;
		this.stepHeight = 2.0F;
	}
	
	@Override
	protected void initEntityAI() {
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIKreeAttack(this, 1.4F, true));
		this.tasks.addTask(3, new EntityAIMoveTowardsRestriction(this, 1.8F));
		this.tasks.addTask(4, new EntityAIWanderAvoidWater(this, 1.4F));
		this.applyEntityAI();
	}
	
	protected void applyEntityAI() {
		this.tasks.addTask(5, new EntityAIMoveThroughVillage(this, 1.8F, false));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityZGVillagerBase.class, true));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityAlienVillager.class, true));
		this.targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, EntityZombie.class, true));
		this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntitySpider.class, true));
		this.targetTasks.addTask(6, new EntityAINearestAttackableTarget(this, EntityCreeper.class, true));
		this.targetTasks.addTask(7, new EntityAINearestAttackableTarget(this, EntityEnderman.class, true));
		this.targetTasks.addTask(8, new EntityAINearestAttackableTarget(this, EntityAgeable.class, true));
		this.targetTasks.addTask(9, new EntityAINearestAttackableTarget(this, EntityFacehugger.class, true));
		this.targetTasks.addTask(10, new EntityAINearestAttackableTarget(this, EntityXenomorph.class, true));
		this.targetTasks.addTask(11, new EntityAINearestAttackableTarget(this, EntityVexBot.class, true));
		this.targetTasks.addTask(12, new EntityAINearestAttackableTarget(this, EntityAbstractSentinel.class, true));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(80.0D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.28557213517232513D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.2D);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).setBaseValue(10.0D);
	}
	
	@Override
	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		super.setEquipmentBasedOnDifficulty(difficulty);
		this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(ZGItems.kreeReaperAxe));
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
	protected Item getDropItem() {
		return ZGItems.kreeFlesh;
	}
	
	@Override
	protected int getExperiencePoints(EntityPlayer player) {
		if (this.isChild()) {
			this.experienceValue = (int) (this.experienceValue * 2.5F);
		}
		
		return super.getExperiencePoints(player);
	}
	
	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		boolean flag = super.attackEntityAsMob(entityIn);
		return flag;
	}
	
	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEFINED;
	}
	
	@Override
	@Nullable
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		livingdata = super.onInitialSpawn(difficulty, livingdata);
		float f = difficulty.getClampedAdditionalDifficulty();
		this.setBreakDoorsAItask(this.rand.nextFloat() < f * 0.1F);
		this.setCanPickUpLoot(this.rand.nextFloat() < 0.55F * f);
		this.setEquipmentBasedOnDifficulty(difficulty);
		this.setEnchantmentBasedOnDifficulty(difficulty);
		AttributeModifier attrMod = new AttributeModifier("Random spawn bonus", this.rand.nextDouble() * 0.05000000074505806D, 0);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).applyModifier(attrMod);
		if (this.rand.nextFloat() < f * 0.05F) {
			this.setBreakDoorsAItask(true);
		}
		return livingdata;
	}
	
	@Override
	protected PathNavigate createNavigator(World worldIn) {
		return new PathNavigateGround(this, worldIn);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getBrightnessForRender() {
		return 15728890;
	}
	
	@Override
	public float getBrightness() {
		return 5.0F;
	}
	
	@Override
	public boolean canBePushed() {
		return false;
	}
	
	@Override
	public void knockBack(Entity entityIn, float par2, double par3, double par4) {
	}
	
	@Override
	public int getMaxSpawnedInChunk() {
		return 4;
	}
	
	@Override
	public float getBlockPathWeight(BlockPos pos) {
		return 1.5F - this.world.getLightBrightness(pos);
	}
	
	@Override
	public boolean canBreath() {
		return true;
	}
}