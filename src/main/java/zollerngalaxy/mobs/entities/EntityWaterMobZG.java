/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities;

import java.util.Random;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import zollerngalaxy.lib.helpers.ZGHelper;

public class EntityWaterMobZG extends EntityWaterMob {
	
	private float randomMotionVecX;
	private float randomMotionVecY;
	private float randomMotionVecZ;
	private float randomMotionSpeed = 1.0F;
	
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
	protected double motionYStart;
	
	public EntityWaterMobZG(World worldIn) {
		super(worldIn);
		motionYStart = this.motionY;
	}
	
	public static void registerFixesSquid(DataFixer fixer) {
		EntityLiving.registerFixesMob(fixer, EntityWaterMobZG.class);
	}
	
	@Override
	protected void initEntityAI() {
		this.tasks.addTask(0, new EntityWaterMobZG.AIMoveRandom(this));
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
		return 0.4F;
	}
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		this.prevFishPitch = this.fishPitch;
		this.prevFishYaw = this.fishYaw;
		
		if (this.inWater) {
			if (motionY <= seaLevel) {
				if (this.getRNG().nextFloat() > 0.75D) {
					this.randomMotionSpeed = ZGHelper.rngFloat(0.1F, 1.0F);
				} else {
					this.randomMotionSpeed *= ZGHelper.rngFloat(0.1F, 0.9F);
				}
			}
			
			if (!this.world.isRemote) {
				float motionYNew = this.randomMotionVecY * this.randomMotionSpeed;
				if (motionYNew >= (seaLevel - 5)) {
					motionYNew = (seaLevel - (seaLevel / 2));
					this.randomMotionSpeed = ZGHelper.rngFloat(0.1F, 1.0F);
				}
				
				this.motionX = this.randomMotionVecX * this.randomMotionSpeed;
				this.motionY = motionYNew;
				this.motionZ = this.randomMotionVecZ * this.randomMotionSpeed;
				if (!this.inWater) {
					this.motionY -= 2.08D;
				}
			}
			
			float f1 = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
			this.renderYawOffset += (-((float) MathHelper.atan2(this.motionX, this.motionZ)) * (180F / (float) Math.PI) - this.renderYawOffset) * 0.1F;
			this.fishYaw = (float) (this.fishYaw + Math.PI * 1.5D);
			this.fishPitch += (-((float) MathHelper.atan2(f1, this.motionY)) * (180F / (float) Math.PI) - this.fishPitch) * 0.1F;
		} else {
			if (!this.world.isRemote) {
				this.motionX = 0.0D;
				this.motionZ = 0.0D;
				
				if (this.isPotionActive(MobEffects.LEVITATION)) {
					this.motionY += 0.05D * (this.getActivePotionEffect(MobEffects.LEVITATION).getAmplifier() + 1) - this.motionY;
				} else {
					this.motionY -= 2.08D;
				}
				
				this.motionY -= 1.9800000190734863D;
			}
			
			this.fishPitch = (float) (this.fishPitch + (-90.0F - this.fishPitch) * 0.02D);
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
	
	static class AIMoveRandom extends EntityAIBase {
		
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
				this.fish.setMovementVector(0.0F, 1.0F, 0.0F);
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