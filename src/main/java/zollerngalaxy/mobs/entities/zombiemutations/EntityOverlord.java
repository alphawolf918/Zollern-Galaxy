/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities.zombiemutations;

import java.util.Calendar;
import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateClimber;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeModContainer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.PotionEvent.PotionApplicableEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import zollerngalaxy.mobs.entities.base.EntityMutantZombie;

public class EntityOverlord extends EntityMutantZombie {
	
	private static final DataParameter<Byte> CLIMBING = EntityDataManager.<Byte> createKey(EntityOverlord.class, DataSerializers.BYTE);
	
	public EntityOverlord(World world) {
		super(world);
		this.setMutantMultiplyChance(10);
		this.setMutantName("Overlord");
		this.setMutantFireTime(2);
		this.setMutantScale(2.0F);
		this.setSize(this.width * 2.0F, this.height * 2.0F);
		this.applyEntityAI();
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(70.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.33000001192092896D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(15.5D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(85.0D);
	}
	
	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(CLIMBING, Byte.valueOf((byte) 0));
	}
	
	@Override
	protected SoundEvent getStepSound() {
		return SoundEvents.ENTITY_SPIDER_STEP;
	}
	
	@Override
	public void setInWeb() {
	}
	
	@Override
	public boolean isPotionApplicable(PotionEffect potioneffectIn) {
		if (potioneffectIn.getPotion() == MobEffects.POISON) {
			PotionApplicableEvent event = new PotionApplicableEvent(this, potioneffectIn);
			MinecraftForge.EVENT_BUS.post(event);
			return event.getResult() == Result.ALLOW;
		}
		return super.isPotionApplicable(potioneffectIn);
	}
	
	@Override
	public double getMountedYOffset() {
		return this.height * 0.5F;
	}
	
	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.ARTHROPOD;
	}
	
	@Override
	protected PathNavigate createNavigator(World worldIn) {
		return new PathNavigateClimber(this, worldIn);
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		
		if (!this.world.isRemote) {
			this.setBesideClimbableBlock(this.collidedHorizontally);
		}
	}
	
	public void setBesideClimbableBlock(boolean climbing) {
		byte b0 = this.dataManager.get(CLIMBING).byteValue();
		
		if (climbing) {
			b0 = (byte) (b0 | 1);
		} else {
			b0 = (byte) (b0 & -2);
		}
		
		this.dataManager.set(CLIMBING, Byte.valueOf(b0));
	}
	
	public boolean isBesideClimbableBlock() {
		return (this.dataManager.get(CLIMBING).byteValue() & 1) != 0;
	}
	
	@Override
	public boolean isOnLadder() {
		return this.isBesideClimbableBlock();
	}
	
	@Override
	public void onKillEntity(EntityLivingBase entityLivingIn) {
		super.onKillEntity(entityLivingIn);
		
		if ((this.world.getDifficulty() == EnumDifficulty.NORMAL || this.world.getDifficulty() == EnumDifficulty.HARD) && entityLivingIn instanceof EntityVillager) {
			if (this.world.getDifficulty() != EnumDifficulty.HARD && this.rand.nextBoolean()) {
				return;
			}
			
			EntityVillager entityvillager = (EntityVillager) entityLivingIn;
			EntityOverlord entityzombievillager = new EntityOverlord(this.world);
			entityzombievillager.copyLocationAndAnglesFrom(entityvillager);
			this.world.removeEntity(entityvillager);
			entityzombievillager.onInitialSpawn(this.world.getDifficultyForLocation(new BlockPos(entityzombievillager)), new EntityOverlord.GroupData(false));
			entityzombievillager.setChild(entityvillager.isChild());
			entityzombievillager.setNoAI(entityvillager.isAIDisabled());
			
			if (entityvillager.hasCustomName()) {
				entityzombievillager.setCustomNameTag(entityvillager.getCustomNameTag());
				entityzombievillager.setAlwaysRenderNameTag(entityvillager.getAlwaysRenderNameTag());
			}
			
			this.world.spawnEntity(entityzombievillager);
			this.world.playEvent((EntityPlayer) null, 1026, new BlockPos(this), 0);
		}
	}
	
	@Override
	@Nullable
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		livingdata = super.onInitialSpawn(difficulty, livingdata);
		float f = difficulty.getClampedAdditionalDifficulty();
		this.setCanPickUpLoot(this.rand.nextFloat() < 0.55F * f);
		
		if (livingdata == null) {
			livingdata = new EntityOverlord.GroupData(this.world.rand.nextFloat() < ForgeModContainer.zombieBabyChance);
		}
		
		if (livingdata instanceof EntityOverlord.GroupData) {
			EntityOverlord.GroupData entityzombie$groupdata = (EntityOverlord.GroupData) livingdata;
			
			if (entityzombie$groupdata.isChild) {
				this.setChild(true);
			}
		}
		
		this.setBreakDoorsAItask(this.rand.nextFloat() < f * 0.1F);
		this.setEquipmentBasedOnDifficulty(difficulty);
		this.setEnchantmentBasedOnDifficulty(difficulty);
		
		if (this.getItemStackFromSlot(EntityEquipmentSlot.HEAD).isEmpty()) {
			Calendar calendar = this.world.getCurrentDate();
			
			if (calendar.get(2) + 1 == 10 && calendar.get(5) == 31 && this.rand.nextFloat() < 0.25F) {
				this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(this.rand.nextFloat() < 0.1F ? Blocks.LIT_PUMPKIN : Blocks.PUMPKIN));
				this.inventoryArmorDropChances[EntityEquipmentSlot.HEAD.getIndex()] = 0.0F;
			}
		}
		
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE)
				.applyModifier(new AttributeModifier("Random spawn bonus", this.rand.nextDouble() * 0.05000000074505806D, 0));
		double d0 = this.rand.nextDouble() * 1.5D * f;
		
		if (d0 > 1.0D) {
			this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).applyModifier(new AttributeModifier("Random zombie-spawn bonus", d0, 2));
		}
		
		if (this.rand.nextFloat() < f * 0.05F) {
			this.getEntityAttribute(SPAWN_REINFORCEMENTS_CHANCE).applyModifier(new AttributeModifier("Leader zombie bonus", this.rand.nextDouble() * 0.25D + 0.5D, 0));
			this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH)
					.applyModifier(new AttributeModifier("Leader zombie bonus", this.rand.nextDouble() * 3.0D + 1.0D, 2));
			this.setBreakDoorsAItask(true);
		}
		
		if (this.world.rand.nextInt(100) == 0) {
			EntitySkeleton entityskeleton = new EntitySkeleton(this.world);
			entityskeleton.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			entityskeleton.onInitialSpawn(difficulty, (IEntityLivingData) null);
			this.world.spawnEntity(entityskeleton);
			entityskeleton.startRiding(this);
		}
		
		livingdata = new EntityOverlord.GroupData(this.isChild());
		
		if (this.world.getDifficulty() == EnumDifficulty.HARD && this.world.rand.nextFloat() < 0.1F * difficulty.getClampedAdditionalDifficulty()) {
			((EntityOverlord.GroupData) livingdata).setRandomEffect(this.world.rand);
		}
		
		if (livingdata instanceof EntityOverlord.GroupData) {
			Potion potion = ((EntityOverlord.GroupData) livingdata).effect;
			
			if (potion != null) {
				this.addPotionEffect(new PotionEffect(potion, Integer.MAX_VALUE));
			}
		}
		
		return livingdata;
	}
	
	class GroupData implements IEntityLivingData {
		public boolean isChild;
		
		private GroupData(boolean p_i47328_2_) {
			this.isChild = p_i47328_2_;
		}
		
		public Potion effect;
		
		public void setRandomEffect(Random rand) {
			int i = rand.nextInt(5);
			
			if (i <= 1) {
				this.effect = MobEffects.SPEED;
			} else if (i <= 2) {
				this.effect = MobEffects.STRENGTH;
			} else if (i <= 3) {
				this.effect = MobEffects.REGENERATION;
			} else if (i <= 4) {
				this.effect = MobEffects.INVISIBILITY;
			}
		}
	}
	
	static class AIOverlordAttack extends EntityAIAttackMelee {
		
		public AIOverlordAttack(EntityOverlord spider) {
			super(spider, 1.0D, true);
		}
		
		@Override
		public boolean shouldContinueExecuting() {
			float f = this.attacker.getBrightness();
			
			if (f >= 0.5F && this.attacker.getRNG().nextInt(100) == 0) {
				this.attacker.setAttackTarget((EntityLivingBase) null);
				return false;
			} else {
				return super.shouldContinueExecuting();
			}
		}
		
		@Override
		protected double getAttackReachSqr(EntityLivingBase attackTarget) {
			return 6.0F + attackTarget.width;
		}
	}
	
	static class AIOverlordTarget<T extends EntityLivingBase> extends EntityAINearestAttackableTarget<T> {
		
		public AIOverlordTarget(EntityOverlord overlord, Class<T> classTarget) {
			super(overlord, classTarget, true);
		}
		
		@Override
		public boolean shouldExecute() {
			float f = this.taskOwner.getBrightness();
			return f >= 0.5F ? false : super.shouldExecute();
		}
	}
}