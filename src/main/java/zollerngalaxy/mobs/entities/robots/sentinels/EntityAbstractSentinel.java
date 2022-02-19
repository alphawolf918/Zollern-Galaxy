/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities.robots.sentinels;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.mobs.entities.ai.EntityAIFindNearestPlayerZG;
import zollerngalaxy.mobs.entities.ai.EntityAISentinelLaserAttack;
import zollerngalaxy.mobs.entities.base.EntityRobotBaseZG;

public abstract class EntityAbstractSentinel extends EntityRobotBaseZG {
	
	protected static final DataParameter<Boolean> ATTACKING = EntityDataManager.<Boolean> createKey(EntityAbstractSentinel.class, DataSerializers.BOOLEAN);
	protected int threatLevel;
	protected static final int MAX_THREAT_LEVEL = 10;
	
	public EntityAbstractSentinel(World worldIn) {
		super(worldIn);
		this.threatLevel = 0;
	}
	
	@Override
	protected void initEntityAI() {
		super.initEntityAI();
		this.tasks.addTask(0, new EntityAIHurtByTarget(this, true));
		this.tasks.addTask(5, new EntityAISentinelLaserAttack(this));
		this.targetTasks.addTask(6, new EntityAIFindNearestPlayerZG(this));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(25.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).setBaseValue(5.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
	}
	
	@Override
	public void onLivingUpdate() {
		IAttributeInstance maxHealth = this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH);
		if ((this.threatLevel >= 8) || (this.getHealth() <= (maxHealth.getBaseValue() / 2) && rand.nextInt(3) == 0)) {
			this.callReinforcements();
		}
		super.onLivingUpdate();
	}
	
	@Override
	public void onDeath(DamageSource damagesource) {
		super.onDeath(damagesource);
		if (rand.nextInt(3) == 0) {
			this.callReinforcements();
		}
	}
	
	protected void callReinforcements() {
		if (!this.world.isRemote && ConfigManagerZG.enableSentinelReinforcements) {
			if (rand.nextInt(this.getCallReinforcementsChance()) == 0) {
				EntityAbstractSentinel sentinel = null;
				int spawnTypeChance = rand.nextInt(100);
				if (spawnTypeChance <= 15) {
					sentinel = new EntitySentinelHound(this.world);
				} else if (spawnTypeChance <= 35) {
					sentinel = new EntitySentinelDrone(this.world);
				}
				if (sentinel != null) {
					sentinel.copyLocationAndAnglesFrom(this);
					this.world.spawnEntity(sentinel);
					this.setThreatLevel(0);
				}
			}
		}
	}
	
	/**
	 * Chance for this Sentinel to call for reinforcements.
	 * Smaller Numbers = Higher Chance / Higher Numbers = Smaller Chance.
	 * Default: 6
	 * 
	 * @return
	 */
	protected int getCallReinforcementsChance() {
		return 6;
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound tag) {
		super.writeEntityToNBT(tag);
		tag.setShort("ThreatLevel", (short) threatLevel);
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound tag) {
		super.readEntityFromNBT(tag);
		this.threatLevel = tag.getShort("ThreatLevel");
	}
	
	protected void setThreatLevel(int i) {
		this.threatLevel = i;
	}
	
	protected int getThreatLevel() {
		return this.threatLevel;
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (this.isEntityInvulnerable(source)) {
			return false;
		} else {
			Entity entity = source.getTrueSource();
			if (entity instanceof EntityPlayer) {
				this.threatLevel += (rand.nextInt(3) == 0) ? 1 : 0;
				if (this.getThreatLevel() > MAX_THREAT_LEVEL) {
					this.setThreatLevel(MAX_THREAT_LEVEL);
				}
			}
			return super.attackEntityFrom(source, amount);
		}
	}
	
	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(ATTACKING, Boolean.valueOf(false));
	}
	
	public void setAttacking(boolean attacking) {
		this.dataManager.set(ATTACKING, Boolean.valueOf(attacking));
	}
	
	@SideOnly(Side.CLIENT)
	public boolean isAttacking() {
		return this.dataManager.get(ATTACKING).booleanValue();
	}
	
	@Override
	protected float getSoundVolume() {
		return 5.0F;
	}
}