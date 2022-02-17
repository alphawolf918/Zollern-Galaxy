/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities;

import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIFindEntityNearestPlayer;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.events.ZGSoundEvents;
import zollerngalaxy.mobs.entities.EntitySentinel.SentinelMoveHelper.AIGunShotAttack;
import zollerngalaxy.mobs.entities.EntitySentinel.SentinelMoveHelper.AILookAround;
import zollerngalaxy.mobs.entities.EntitySentinel.SentinelMoveHelper.AIRandomFly;
import zollerngalaxy.mobs.entities.base.EntityRobotBaseZG;
import zollerngalaxy.mobs.entities.projectiles.EntitySentinelGunShot;

public class EntitySentinel extends EntityRobotBaseZG {
	
	private static final DataParameter<Boolean> ATTACKING = EntityDataManager.<Boolean> createKey(EntitySentinel.class, DataSerializers.BOOLEAN);
	
	public EntitySentinel(World worldIn) {
		super(worldIn);
		this.moveHelper = new EntitySentinel.SentinelMoveHelper(this);
	}
	
	@Override
	protected void initEntityAI() {
		super.initEntityAI();
		this.tasks.addTask(5, new AIRandomFly(this));
		this.tasks.addTask(6, new AILookAround(this));
		this.tasks.addTask(6, new AIGunShotAttack(this));
		this.targetTasks.addTask(6, new EntityAIFindEntityNearestPlayer(this));
	}
	
	// @Override
	// protected PathNavigate createNavigator(World worldIn) {
	// return new PathNavigateFlying(this, worldIn);
	// }
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(65.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.26D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.85D);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).setBaseValue(5.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(25.0D);
	}
	
	@Override
	public int getMaxSpawnedInChunk() {
		return 6;
	}
	
	public void setAttacking(boolean attacking) {
		this.dataManager.set(ATTACKING, Boolean.valueOf(attacking));
	}
	
	@SideOnly(Side.CLIENT)
	public boolean isAttacking() {
		return this.dataManager.get(ATTACKING).booleanValue();
	}
	
	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(ATTACKING, Boolean.valueOf(false));
	}
	
	@Override
	protected float getSoundVolume() {
		return 10.0F;
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return ZGSoundEvents.ENTITY_SENTINEL_SAY;
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return ZGSoundEvents.ENTITY_SENTINEL_HURT;
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		return ZGSoundEvents.ENTITY_SENTINEL_DIE;
	}
	
	@Override
	public void travel(float strafe, float vertical, float forward) {
		if (this.isInWater()) {
			this.moveRelative(strafe, vertical, forward, 0.02F);
			this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
			this.motionX *= 0.800000011920929D;
			this.motionY *= 0.800000011920929D;
			this.motionZ *= 0.800000011920929D;
		} else if (this.isInLava()) {
			this.moveRelative(strafe, vertical, forward, 0.02F);
			this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
			this.motionX *= 0.5D;
			this.motionY *= 0.5D;
			this.motionZ *= 0.5D;
		} else {
			float f = 0.91F;
			
			if (this.onGround) {
				BlockPos underPos = new BlockPos(MathHelper.floor(this.posX), MathHelper.floor(this.getEntityBoundingBox().minY) - 1, MathHelper.floor(this.posZ));
				IBlockState underState = this.world.getBlockState(underPos);
				f = underState.getBlock().getSlipperiness(underState, this.world, underPos, this) * 0.91F;
			}
			
			float f1 = 0.16277136F / (f * f * f);
			this.moveRelative(strafe, vertical, forward, this.onGround ? 0.1F * f1 : 0.02F);
			f = 0.91F;
			
			if (this.onGround) {
				BlockPos underPos = new BlockPos(MathHelper.floor(this.posX), MathHelper.floor(this.getEntityBoundingBox().minY) - 1, MathHelper.floor(this.posZ));
				IBlockState underState = this.world.getBlockState(underPos);
				f = underState.getBlock().getSlipperiness(underState, this.world, underPos, this) * 0.91F;
			}
			
			this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
			this.motionX *= f;
			this.motionY *= f;
			this.motionZ *= f;
		}
		
		this.prevLimbSwingAmount = this.limbSwingAmount;
		double d1 = this.posX - this.prevPosX;
		double d0 = this.posZ - this.prevPosZ;
		float f2 = MathHelper.sqrt(d1 * d1 + d0 * d0) * 4.0F;
		
		if (f2 > 1.0F) {
			f2 = 1.0F;
		}
		
		this.limbSwingAmount += (f2 - this.limbSwingAmount) * 0.4F;
		this.limbSwing += this.limbSwingAmount;
	}
	
	@Override
	public boolean isOnLadder() {
		return false;
	}
	
	static class SentinelMoveHelper extends EntityMoveHelper {
		
		private final EntitySentinel parentEntity;
		private int courseChangeCooldown;
		
		public SentinelMoveHelper(EntitySentinel sentinel) {
			super(sentinel);
			this.parentEntity = sentinel;
		}
		
		@Override
		public void onUpdateMoveHelper() {
			if (this.action == EntityMoveHelper.Action.MOVE_TO) {
				double d0 = this.posX - this.parentEntity.posX;
				double d1 = this.posY - this.parentEntity.posY;
				double d2 = this.posZ - this.parentEntity.posZ;
				double d3 = d0 * d0 + d1 * d1 + d2 * d2;
				
				if (this.courseChangeCooldown-- <= 0) {
					this.courseChangeCooldown += this.parentEntity.getRNG().nextInt(5) + 2;
					d3 = MathHelper.sqrt(d3);
					
					if (this.isNotColliding(this.posX, this.posY, this.posZ, d3)) {
						this.parentEntity.motionX += d0 / d3 * 0.1D;
						this.parentEntity.motionY += d1 / d3 * 0.1D;
						this.parentEntity.motionZ += d2 / d3 * 0.1D;
					} else {
						this.action = EntityMoveHelper.Action.WAIT;
					}
				}
			}
		}
		
		private boolean isNotColliding(double x, double y, double z, double p_179926_7_) {
			
			double d0 = (x - this.parentEntity.posX) / p_179926_7_;
			double d1 = (y - this.parentEntity.posY) / p_179926_7_;
			double d2 = (z - this.parentEntity.posZ) / p_179926_7_;
			AxisAlignedBB axisalignedbb = this.parentEntity.getEntityBoundingBox();
			
			for (int i = 1; i < p_179926_7_; ++i) {
				axisalignedbb = axisalignedbb.offset(d0, d1, d2);
				if (!this.parentEntity.world.getCollisionBoxes(this.parentEntity, axisalignedbb).isEmpty()) {
					return false;
				}
			}
			return true;
		}
		
		static class AIGunShotAttack extends EntityAIBase {
			
			private final EntitySentinel parentEntity;
			public int attackTimer;
			
			public AIGunShotAttack(EntitySentinel sentinel) {
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
				EntityLivingBase entitylivingbase = this.parentEntity.getAttackTarget();
				double d0 = 64.0D;
				
				if (entitylivingbase.getDistanceSq(this.parentEntity) < 4096.0D && this.parentEntity.canEntityBeSeen(entitylivingbase)) {
					World world = this.parentEntity.world;
					++this.attackTimer;
					
					if (this.attackTimer == 20) {
						double d1 = 4.0D;
						Vec3d vec3d = this.parentEntity.getLook(1.0F);
						double d2 = entitylivingbase.posX - (this.parentEntity.posX + vec3d.x * 4.0D);
						double d3 = entitylivingbase.getEntityBoundingBox().minY + entitylivingbase.height / 2.0F - (0.5D + this.parentEntity.posY + this.parentEntity.height / 2.0F);
						double d4 = entitylivingbase.posZ - (this.parentEntity.posZ + vec3d.z * 4.0D);
						EntitySentinelGunShot entitySentinelShot = new EntitySentinelGunShot(world, this.parentEntity, d2, d3, d4);
						entitySentinelShot.posX = this.parentEntity.posX + vec3d.x * 4.0D;
						entitySentinelShot.posY = this.parentEntity.posY + this.parentEntity.height / 2.0F + 0.5D;
						entitySentinelShot.posZ = this.parentEntity.posZ + vec3d.z * 4.0D;
						world.spawnEntity(entitySentinelShot);
						this.parentEntity.world.playSound(null, this.parentEntity.getPosition(), ZGSoundEvents.ENTITY_SENTINEL_SHOOT, SoundCategory.MASTER, 5.0F, 1.0F);
						this.attackTimer = -40;
					}
				} else if (this.attackTimer > 0) {
					--this.attackTimer;
				}
				
				this.parentEntity.setAttacking(this.attackTimer > 10);
			}
		}
		
		static class AILookAround extends EntityAIBase {
			
			private final EntitySentinel parentEntity;
			
			public AILookAround(EntitySentinel sentinel) {
				this.parentEntity = sentinel;
				this.setMutexBits(2);
			}
			
			@Override
			public boolean shouldExecute() {
				return true;
			}
			
			@Override
			public void updateTask() {
				if (this.parentEntity.getAttackTarget() == null) {
					this.parentEntity.rotationYaw = -((float) MathHelper.atan2(this.parentEntity.motionX, this.parentEntity.motionZ)) * (180F / (float) Math.PI);
					this.parentEntity.renderYawOffset = this.parentEntity.rotationYaw;
				} else {
					EntityLivingBase entitylivingbase = this.parentEntity.getAttackTarget();
					double d0 = 64.0D;
					
					if (entitylivingbase.getDistanceSq(this.parentEntity) < 4096.0D) {
						double d1 = entitylivingbase.posX - this.parentEntity.posX;
						double d2 = entitylivingbase.posZ - this.parentEntity.posZ;
						this.parentEntity.rotationYaw = -((float) MathHelper.atan2(d1, d2)) * (180F / (float) Math.PI);
						this.parentEntity.renderYawOffset = this.parentEntity.rotationYaw;
					}
				}
			}
		}
		
		static class AIRandomFly extends EntityAIBase {
			
			private final EntitySentinel parentEntity;
			
			public AIRandomFly(EntitySentinel sentinel) {
				this.parentEntity = sentinel;
				this.setMutexBits(1);
			}
			
			@Override
			public boolean shouldExecute() {
				EntityMoveHelper entitymovehelper = this.parentEntity.getMoveHelper();
				
				if (!entitymovehelper.isUpdating()) {
					return true;
				} else {
					double d0 = entitymovehelper.getX() - this.parentEntity.posX;
					double d1 = entitymovehelper.getY() - this.parentEntity.posY;
					double d2 = entitymovehelper.getZ() - this.parentEntity.posZ;
					double d3 = d0 * d0 + d1 * d1 + d2 * d2;
					return d3 < 1.0D || d3 > 3600.0D;
				}
			}
			
			@Override
			public boolean shouldContinueExecuting() {
				return false;
			}
			
			@Override
			public void startExecuting() {
				Random random = this.parentEntity.getRNG();
				double d0 = this.parentEntity.posX + (random.nextFloat() * 2.0F - 1.0F) * 16.0F;
				double d1 = this.parentEntity.posY + (random.nextFloat() * 2.0F - 1.0F) * 16.0F;
				double d2 = this.parentEntity.posZ + (random.nextFloat() * 2.0F - 1.0F) * 16.0F;
				this.parentEntity.getMoveHelper().setMoveTo(d0, d1, d2, 1.0D);
			}
		}
	}
}