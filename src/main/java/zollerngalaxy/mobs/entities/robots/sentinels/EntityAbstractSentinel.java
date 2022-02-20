/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities.robots.sentinels;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
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
import zollerngalaxy.mobs.entities.EntityFacehugger;
import zollerngalaxy.mobs.entities.EntityKree;
import zollerngalaxy.mobs.entities.EntityXenomorph;
import zollerngalaxy.mobs.entities.ai.EntityAIFindNearestPlayerZG;
import zollerngalaxy.mobs.entities.ai.EntityAISentinelAttackOnCollide;
import zollerngalaxy.mobs.entities.ai.EntityAISentinelLaserAttack;
import zollerngalaxy.mobs.entities.base.EntityRobotBaseZG;

public abstract class EntityAbstractSentinel extends EntityRobotBaseZG {
	
	protected static final DataParameter<Boolean> ATTACKING = EntityDataManager.<Boolean> createKey(EntityAbstractSentinel.class, DataSerializers.BOOLEAN);
	protected int threatLevel;
	protected boolean hasCalledForBackup;
	protected static final int MAX_THREAT_LEVEL = 10;
	
	public EntityAbstractSentinel(World worldIn) {
		super(worldIn);
		this.setThreatLevel(0);
		this.setHasCalledForBackup(false);
	}
	
	@Override
	protected void initEntityAI() {
		super.initEntityAI();
		this.tasks.addTask(0, new EntityAIHurtByTarget(this, true));
		this.tasks.addTask(5, new EntityAISentinelLaserAttack(this));
		this.tasks.addTask(6, new EntityAISentinelAttackOnCollide(this, EntityPlayer.class, 1.0D, true));
		this.tasks.addTask(7, new EntityAISentinelAttackOnCollide(this, EntityAgeable.class, 1.0D, true));
		this.tasks.addTask(7, new EntityAISentinelAttackOnCollide(this, EntityXenomorph.class, 1.0D, true));
		this.tasks.addTask(7, new EntityAISentinelAttackOnCollide(this, EntityFacehugger.class, 1.0D, true));
		this.tasks.addTask(7, new EntityAISentinelAttackOnCollide(this, EntityKree.class, 1.0D, true));
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
		IAttributeInstance maxHealthAttr = this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH);
		float currentHealth = this.getHealth();
		double maxHealth = maxHealthAttr.getBaseValue();
		if ((this.threatLevel >= MAX_THREAT_LEVEL) || (currentHealth <= (maxHealth / 2) && rand.nextInt(10) == 0)) {
			this.callReinforcements();
		}
		super.onLivingUpdate();
	}
	
	@Override
	public void onDeath(DamageSource damagesource) {
		super.onDeath(damagesource);
		if (rand.nextInt(8) == 0) {
			this.callReinforcements();
		}
	}
	
	protected void callReinforcements() {
		if (!this.world.isRemote && ConfigManagerZG.enableSentinelReinforcements && !this.getHasCalledForBackup()) {
			if (this.rand.nextInt(this.getCallReinforcementsChance()) == 0) {
				EntityAbstractSentinel sentinel = null;
				int spawnTypeChance = this.rand.nextInt(100);
				if (spawnTypeChance == 1) {
					sentinel = new EntitySentinelWalker(this.world);
				} else if (spawnTypeChance <= 25) {
					sentinel = new EntitySentinelHound(this.world);
				} else if (spawnTypeChance <= 45) {
					sentinel = new EntitySentinelDrone(this.world);
				}
				if (sentinel != null) {
					if (sentinel.getCanSpawnHere()) {
						sentinel.copyLocationAndAnglesFrom(this);
						this.world.spawnEntity(sentinel);
						this.setThreatLevel(0);
						this.setHasCalledForBackup(true);
					}
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
		return 8;
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound tag) {
		super.writeEntityToNBT(tag);
		tag.setShort("ThreatLevel", (short) this.threatLevel);
		tag.setBoolean("HasCalledForBackup", this.hasCalledForBackup);
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound tag) {
		super.readEntityFromNBT(tag);
		this.threatLevel = tag.getShort("ThreatLevel");
		this.hasCalledForBackup = tag.getBoolean("HasCalledForBackup");
	}
	
	protected void setThreatLevel(int i) {
		this.threatLevel = i;
	}
	
	protected void setHasCalledForBackup(boolean hasCalledIn) {
		this.hasCalledForBackup = hasCalledIn;
	}
	
	protected int getThreatLevel() {
		return this.threatLevel;
	}
	
	protected boolean getHasCalledForBackup() {
		return this.hasCalledForBackup;
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (this.isEntityInvulnerable(source)) {
			return false;
		} else {
			Entity entity = source.getTrueSource();
			if (entity instanceof EntityPlayer) {
				this.threatLevel += (rand.nextInt(4) == 0) ? 1 : 0;
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