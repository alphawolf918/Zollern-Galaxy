/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities.robots.sentinels;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.events.ZGSoundEvents;
import zollerngalaxy.mobs.entities.ai.EntityAIFindNearestPlayerZG;
import zollerngalaxy.mobs.entities.base.EntityRobotBaseZG;
import zollerngalaxy.mobs.entities.projectiles.EntitySentinelLaser;

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
		this.tasks.addTask(5, new AISentinelLaserAttack(this));
		this.targetTasks.addTask(6, new EntityAIFindNearestPlayerZG(this));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(25.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).setBaseValue(1.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
	}
	
	@Override
	public void onLivingUpdate() {
		if (!world.isRemote) {
			if (this.getThreatLevel() >= 8 && rand.nextInt(6) == 0) {
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
					this.threatLevel = 0;
				}
			}
		}
		super.onLivingUpdate();
	}
	
	@Override
	public int getMaxSpawnedInChunk() {
		return 4;
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
	
	protected static class AISentinelLaserAttack extends EntityAIBase {
		
		private final EntityAbstractSentinel parentEntity;
		public int attackTimer;
		
		public AISentinelLaserAttack(EntityAbstractSentinel sentinel) {
			this.parentEntity = sentinel;
		}
		
		@Override
		public boolean shouldExecute() {
			return this.parentEntity.getAttackTarget() != null;
		}
		
		@Override
		public void startExecuting() {
			this.attackTimer = 0;
		}
		
		@Override
		public void resetTask() {
			this.parentEntity.setAttacking(false);
		}
		
		@Override
		public void updateTask() {
			EntityLivingBase entityLivingTarget = this.parentEntity.getAttackTarget();
			if (entityLivingTarget.getDistanceSq(this.parentEntity) < 4096.0D && this.parentEntity.canEntityBeSeen(entityLivingTarget)) {
				World world = this.parentEntity.world;
				++this.attackTimer;
				if (this.attackTimer == 20) {
					for (int i = 0; i < 9; i++) {
						if ((i % 2) == 0) {
							continue;
						}
						Vec3d vec3d = this.parentEntity.getLook(1.0F);
						double d2 = entityLivingTarget.posX - (this.parentEntity.posX + vec3d.x * 4.0D);
						double d3 = entityLivingTarget.getEntityBoundingBox().minY + entityLivingTarget.height / 2.0F - (0.5D + this.parentEntity.posY + this.parentEntity.height / 2.0F);
						double d4 = entityLivingTarget.posZ - (this.parentEntity.posZ + vec3d.z * 4.0D);
						EntitySentinelLaser entitySentinelLaser = new EntitySentinelLaser(world, this.parentEntity, d2, d3, d4);
						entitySentinelLaser.posX = this.parentEntity.posX + vec3d.x * 4.0D;
						entitySentinelLaser.posY = this.parentEntity.posY + this.parentEntity.height / 2.0F + 0.5D;
						entitySentinelLaser.posZ = this.parentEntity.posZ + vec3d.z * 4.0D;
						world.spawnEntity(entitySentinelLaser);
						this.parentEntity.world.playSound(null, this.parentEntity.getPosition(), ZGSoundEvents.ENTITY_SENTINEL_SHOOT, SoundCategory.MASTER, 8.0F, 1.0F);
						this.attackTimer = -10;
					}
				}
			} else if (this.attackTimer > 0) {
				--this.attackTimer;
			}
			this.parentEntity.setAttacking(this.attackTimer > 10);
		}
	}
}