/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities.base;

import java.util.Random;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.mobs.entities.ai.EntityAIFishPanic;
import zollerngalaxy.mobs.entities.ai.EntityAIFishWander;

public class EntityWaterMobZG extends EntityWaterMob {
	
	private BlockPos homePosition = BlockPos.ORIGIN;
	private float maximumHomeDistance = -1.0F;
	private final float restoreWaterCost = PathNodeType.WATER.getPriority();
	
	protected float randomMotionVecX;
	protected float randomMotionVecY;
	protected float randomMotionVecZ;
	protected float randomMotionSpeed = 0.1F;
	
	public float fishPitch;
	public float prevFishPitch;
	public float fishYaw;
	public float prevFishYaw;
	
	protected Random rand = new Random();
	protected float minSize = 0.1F;
	protected float maxSize = 6.5F;
	protected float fishEq = this.rand.nextFloat();
	protected float fishSize = (this.fishEq + this.minSize);
	
	protected float seaLevel = (this.getEntityWorld().getSeaLevel() * 1.0F);
	protected float acceptableLevel = (seaLevel - 5);
	
	protected double motionYStart;
	protected double posYStart;
	
	public EntityWaterMobZG(World worldIn) {
		super(worldIn);
		this.motionYStart = this.motionY;
		this.posYStart = this.posY;
	}
	
	public static void registerFixesSquid(DataFixer fixer) {
		EntityLiving.registerFixesMob(fixer, EntityWaterMobZG.class);
	}
	
	@Override
	protected void initEntityAI() {
		this.tasks.addTask(0, new EntityWaterMobZG.AIMoveRandom(this));
		this.tasks.addTask(1, new EntityAIFishWander(this, this.randomMotionSpeed));
		this.tasks.addTask(2, new EntityAIFishPanic(this, this.randomMotionSpeed));
	}
	
	@Override
	protected boolean canTriggerWalking() {
		return false;
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
	
	@Override
	protected float getSoundVolume() {
		return 0.8F;
	}
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		this.prevFishPitch = this.fishPitch;
		this.prevFishYaw = this.fishYaw;
		float acceptableLevel = (this.seaLevel - 5);
		if (!this.getEntityWorld().isRemote) {
			this.randomMotionSpeed = (this.isInWater()) ? ZGHelper.rngFloat(0.1F, 2.0F) : 0.0F;
			if (this.isInWater()) {
				if (this.getRNG().nextFloat() == 0.75D) {
					this.randomMotionSpeed = ZGHelper.rngFloat(0.1F, 0.4F);
				}
				this.randomMotionSpeed = (this.randomMotionSpeed > 2.0F) ? 2.0F : this.randomMotionSpeed;
				float addYVector = (this.randomMotionVecY + this.randomMotionSpeed);
				float subYVector = (this.randomMotionVecY - this.randomMotionSpeed);
				double motionYNew = (this.getRNG().nextInt(10) == 1) ? addYVector : subYVector;
				if (motionYNew >= acceptableLevel) {
					motionYNew = (this.randomMotionVecY - this.randomMotionSpeed);
					this.randomMotionSpeed = 0.1F;
					this.randomMotionVecY = 0.1F;
				}
				this.motionX = (this.randomMotionVecX * this.randomMotionSpeed);
				if (ZGHelper.getRNGChance(5, 20)) {
					this.motionY = motionYNew;
				}
				this.motionZ = (this.randomMotionVecZ * this.randomMotionSpeed);
				float f1 = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
				this.renderYawOffset += (-((float) MathHelper.atan2(this.motionX, this.motionZ)) * (180F / (float) Math.PI) - this.renderYawOffset) * 0.1F;
				this.fishYaw = (float) (this.fishYaw + Math.PI * 1.5D);
				this.fishPitch = (float) (this.fishPitch + (-90.0F - this.fishPitch) * 0.02D);
			} else {
				this.motionX = 0.0D;
				this.motionZ = 0.0D;
				if (this.isPotionActive(MobEffects.LEVITATION)) {
					this.motionY += 0.05D * (this.getActivePotionEffect(MobEffects.LEVITATION).getAmplifier() + 1) - this.motionY;
				} else {
					this.motionY -= 2.08D;
				}
				this.motionY -= 1.9800000190734863D;
			}
		}
	}
	
	@Override
	public void travel(float strafe, float vertical, float forward) {
		this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
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
	public boolean getCanSpawnHere() {
		boolean seaHeightMax = this.posY >= 25.0D;
		boolean seaHeightMin = this.posY <= this.getEntityWorld().getSeaLevel();
		boolean canSpawnHereSuper = super.getCanSpawnHere();
		boolean canSpawn = (seaHeightMax && seaHeightMin && canSpawnHereSuper);
		return canSpawn;
	}
	
	@Override
	public boolean hasNoGravity() {
		return true;
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
	
	protected static class AIMoveRandom extends EntityAIBase {
		
		private final EntityWaterMobZG fish;
		
		public AIMoveRandom(EntityWaterMobZG fishIn) {
			this.fish = fishIn;
		}
		
		@Override
		public boolean shouldExecute() {
			return true;
		}
		
		@Override
		public void updateTask() {
			int i = this.fish.getIdleTime();
			
			if (i > 100) {
				this.fish.setMovementVector(0.0F, ZGHelper.rngFloat(0.1F, 1.0F), 0.0F);
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