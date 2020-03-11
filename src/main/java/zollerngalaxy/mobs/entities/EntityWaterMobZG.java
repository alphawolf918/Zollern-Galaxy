/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityWaterMobZG extends EntityLiving implements IAnimals {
	
	/** If -1 there is no maximum distance */
	private float maximumHomeDistance = -1.0F;
	private BlockPos homePosition = BlockPos.ORIGIN;
	private final float restoreWaterCost = PathNodeType.WATER.getPriority();
	
	public static float fishPitch;
	public static float prevFishPitch;
	public static float fishYaw;
	public static float prevFishYaw;
	
	/**
	 * appears to be rotation in radians; we already have pitch & yaw, so this completes the
	 * triumvirate.
	 */
	public float fishRotation;
	/** previous fishRotation in radians */
	public float prevFishRotation;
	/** angle of the tentacles in radians */
	public float finAngle;
	/** the last calculated angle of the tentacles in radians */
	public float lastFinAngle;
	private float randomMotionSpeed;
	/** change in fishRotation in radians. */
	private float rotationVelocity;
	private float rotateSpeed;
	private float randomMotionVecX;
	private float randomMotionVecY;
	private float randomMotionVecZ;
	
	public EntityWaterMobZG(World worldIn) {
		super(worldIn);
		this.rand.setSeed(1 + this.getEntityId());
		this.rotationVelocity = 1.0F / (this.rand.nextFloat() + 1.0F) * 0.2F;
		// this.enablePersistence();
	}
	
	public static void registerFixesSquid(DataFixer fixer) {
		EntityLiving.registerFixesMob(fixer, EntityWaterMobZG.class);
	}
	
	@Override
	protected void initEntityAI() {
		this.tasks.addTask(0, new EntityWaterMobZG.AIMoveRandom(this));
	}
	
	@Override
	public float getEyeHeight() {
		return this.height * 0.5F;
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_SQUID_AMBIENT;
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_SQUID_HURT;
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_SQUID_DEATH;
	}
	
	/**
	 * Returns the volume for the sounds this mob makes.
	 */
	@Override
	protected float getSoundVolume() {
		return 0.4F;
	}
	
	/**
	 * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for
	 * spiders and wolves to
	 * prevent them from trampling crops
	 */
	@Override
	protected boolean canTriggerWalking() {
		return false;
	}
	
	public boolean hasPath() {
		return !this.navigator.noPath();
	}
	
	public boolean isWithinHomeDistanceCurrentPosition() {
		return this.isWithinHomeDistanceFromPosition(new BlockPos(this));
	}
	
	public boolean isWithinHomeDistanceFromPosition(BlockPos pos) {
		if (this.maximumHomeDistance == -1.0F) {
			return true;
		} else {
			return this.homePosition.distanceSq(pos) < this.maximumHomeDistance * this.maximumHomeDistance;
		}
	}
	
	/**
	 * Sets home position and max distance for it
	 */
	public void setHomePosAndDistance(BlockPos pos, int distance) {
		this.homePosition = pos;
		this.maximumHomeDistance = distance;
	}
	
	public BlockPos getHomePosition() {
		return this.homePosition;
	}
	
	public float getMaximumHomeDistance() {
		return this.maximumHomeDistance;
	}
	
	public void detachHome() {
		this.maximumHomeDistance = -1.0F;
	}
	
	/**
	 * Returns whether a home area is defined for this entity.
	 */
	public boolean hasHome() {
		return this.maximumHomeDistance != -1.0F;
	}
	
	public float getBlockPathWeight(BlockPos pos) {
		return 0.0F;
	}
	
	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}
	
	@Override
	public boolean getCanSpawnHere() {
		// return this.posY > 35.0D && this.posY <= this.world.getSeaLevel() &&
		// super.getCanSpawnHere();
		return true;
	}
	
	/**
	 * Checks that the entity is not colliding with any blocks / liquids
	 */
	@Override
	public boolean isNotColliding() {
		return this.world.checkNoEntityCollision(this.getEntityBoundingBox(), this);
	}
	
	/**
	 * Get number of ticks, at least during which the living entity will be silent.
	 */
	@Override
	public int getTalkInterval() {
		return 120;
	}
	
	/**
	 * Determines if an entity can be despawned, used on idle far away entities
	 */
	@Override
	protected boolean canDespawn() {
		return false;
	}
	
	/**
	 * Get the experience points the entity currently has.
	 */
	@Override
	protected int getExperiencePoints(EntityPlayer player) {
		return 1 + this.world.rand.nextInt(3);
	}
	
	/**
	 * Gets called every tick from main Entity class
	 */
	@Override
	public void onEntityUpdate() {
		int i = this.getAir();
		super.onEntityUpdate();
		
		if (this.isEntityAlive() && !this.isInWater()) {
			--i;
			this.setAir(i);
			
			if (this.getAir() == -20) {
				this.setAir(0);
				this.attackEntityFrom(DamageSource.DROWN, 2.0F);
			}
		} else {
			this.setAir(300);
		}
	}
	
	@Override
	public boolean isPushedByWater() {
		return false;
	}
	
	@Override
	public boolean isInWater() {
		return this.getEntityWorld().handleMaterialAcceleration(this.getEntityBoundingBox().expand(0.0D, -0.6000000238418579D, 0.0D),
				Material.WATER, this);
	}
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		this.prevFishPitch = this.fishPitch;
		this.prevFishYaw = this.fishYaw;
		this.prevFishRotation = this.fishRotation;
		this.lastFinAngle = this.finAngle;
		this.fishRotation += this.rotationVelocity;
		
		if (this.fishRotation > (Math.PI * 2D)) {
			if (this.world.isRemote) {
				this.fishRotation = ((float) Math.PI * 2F);
			} else {
				this.fishRotation = (float) (this.fishRotation - (Math.PI * 2D));
				
				if (this.rand.nextInt(10) == 0) {
					this.rotationVelocity = 1.0F / (this.rand.nextFloat() + 1.0F) * 0.2F;
				}
				
				this.world.setEntityState(this, (byte) 19);
			}
		}
		
		if (this.inWater) {
			if (this.fishRotation < (float) Math.PI) {
				float f = this.fishRotation / (float) Math.PI;
				this.finAngle = MathHelper.sin(f * f * (float) Math.PI) * (float) Math.PI * 0.25F;
				
				if (f > 0.75D) {
					this.randomMotionSpeed = 1.0F;
					this.rotateSpeed = 1.0F;
				} else {
					this.rotateSpeed *= 0.8F;
				}
			} else {
				this.finAngle = 0.0F;
				this.randomMotionSpeed *= 0.9F;
				this.rotateSpeed *= 0.99F;
			}
			
			if (!this.world.isRemote) {
				this.motionX = this.randomMotionVecX * this.randomMotionSpeed;
				this.motionY = this.randomMotionVecY * this.randomMotionSpeed;
				this.motionZ = this.randomMotionVecZ * this.randomMotionSpeed;
			}
			
			float f1 = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
			this.renderYawOffset += (-((float) MathHelper.atan2(this.motionX, this.motionZ)) * (180F / (float) Math.PI) - this.renderYawOffset) * 0.1F;
			this.rotationYaw = this.renderYawOffset;
			this.fishYaw = (float) (this.fishYaw + Math.PI * this.rotateSpeed * 1.5D);
			this.fishPitch += (-((float) MathHelper.atan2(f1, this.motionY)) * (180F / (float) Math.PI) - this.fishPitch) * 0.1F;
		} else {
			this.finAngle = MathHelper.abs(MathHelper.sin(this.fishRotation)) * (float) Math.PI * 0.25F;
			
			if (!this.world.isRemote) {
				this.motionX = 0.0D;
				this.motionZ = 0.0D;
				
				if (this.isPotionActive(MobEffects.LEVITATION)) {
					this.motionY += 0.05D * (this.getActivePotionEffect(MobEffects.LEVITATION).getAmplifier() + 1) - this.motionY;
				} else if (!this.hasNoGravity()) {
					this.motionY -= 0.08D;
				}
				
				this.motionY *= 0.9800000190734863D;
			}
			
			this.fishPitch = (float) (this.fishPitch + (-90.0F - this.fishPitch) * 0.02D);
		}
	}
	
	/**
	 * Handler for {@link World#setEntityState}
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void handleStatusUpdate(byte id) {
		if (id == 19) {
			this.fishRotation = 0.0F;
		} else {
			super.handleStatusUpdate(id);
		}
	}
	
	public void setMovementVector(float randomMotionVecXIn, float randomMotionVecYIn, float randomMotionVecZIn) {
		this.randomMotionVecX = randomMotionVecXIn;
		this.randomMotionVecY = randomMotionVecYIn;
		this.randomMotionVecZ = randomMotionVecZIn;
	}
	
	public boolean hasMovementVector() {
		return this.randomMotionVecX != 0.0F || this.randomMotionVecY != 0.0F || this.randomMotionVecZ != 0.0F;
	}
	
	@Override
	public void travel(float strafe, float vertical, float forward) {
		this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
	}
	
	static class AIMoveRandom extends EntityAIBase {
		private final EntityWaterMobZG fish;
		
		public AIMoveRandom(EntityWaterMobZG p_i45859_1_) {
			this.fish = p_i45859_1_;
		}
		
		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		@Override
		public boolean shouldExecute() {
			return true;
		}
		
		/**
		 * Keep ticking a continuous task that has already been started
		 */
		@Override
		public void updateTask() {
			int i = this.fish.getIdleTime();
			
			if (i > 100) {
				this.fish.setMovementVector(0.0F, 0.0F, 0.0F);
			} else if (this.fish.getRNG().nextInt(50) == 0 || !this.fish.inWater || !this.fish.hasMovementVector()) {
				float f = this.fish.getRNG().nextFloat() * ((float) Math.PI * 2F);
				float f1 = MathHelper.cos(f) * 0.2F;
				float f2 = -0.1F + this.fish.getRNG().nextFloat() * 0.2F;
				float f3 = MathHelper.sin(f) * 0.2F;
				this.fish.setMovementVector(f1, f2, f3);
			}
		}
	}
}