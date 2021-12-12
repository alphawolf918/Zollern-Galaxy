/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities;

import java.util.Random;
import javax.annotation.Nullable;
import micdoodle8.mods.galacticraft.api.entity.IEntityBreathable;
import micdoodle8.mods.galacticraft.core.entities.EntityAlienVillager;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateClimber;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.PotionEvent.PotionApplicableEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.blocks.centotl.BlockFacehuggerEgg;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.mobs.entities.base.EntityZGVillagerBase;
import zollerngalaxy.mobs.entities.boss.EntityXenomorphQueen;
import zollerngalaxy.mobs.entities.interfaces.IShadeEntity;

public class EntityFacehugger extends EntityMob implements IShadeEntity, IEntityBreathable {
	
	private static final DataParameter<Byte> CLIMBING = EntityDataManager.<Byte> createKey(EntityFacehugger.class, DataSerializers.BYTE);
	
	public EntityFacehugger(World worldIn) {
		super(worldIn);
		this.setSize(this.width * 0.6F, this.height * 0.6F);
	}
	
	@Override
	public void fall(float par1, float par2) {
	}
	
	@Override
	protected void initEntityAI() {
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAILeapAtTarget(this, 1.4F));
		this.tasks.addTask(3, new EntityFacehugger.AIFacehuggerAttack(this));
		this.tasks.addTask(4, new EntityAIWanderAvoidWater(this, 1.8D));
		this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 1.4F));
		this.tasks.addTask(5, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
		this.targetTasks.addTask(2, new EntityFacehugger.AIFacehuggerTarget(this, EntityPlayer.class));
		this.targetTasks.addTask(3, new EntityFacehugger.AIFacehuggerTarget(this, EntityZGVillagerBase.class));
		this.targetTasks.addTask(4, new EntityFacehugger.AIFacehuggerTarget(this, EntityAlienVillager.class));
		this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		this.targetTasks.addTask(6, new EntityAINearestAttackableTarget(this, EntityZGVillagerBase.class, true));
		this.targetTasks.addTask(7, new EntityAINearestAttackableTarget(this, EntityAlienVillager.class, true));
		this.targetTasks.addTask(8, new EntityAINearestAttackableTarget(this, EntityZombie.class, true));
		this.targetTasks.addTask(9, new EntityAINearestAttackableTarget(this, EntitySpider.class, true));
		this.targetTasks.addTask(10, new EntityAINearestAttackableTarget(this, EntityCreeper.class, true));
		this.targetTasks.addTask(11, new EntityAINearestAttackableTarget(this, EntityEnderman.class, true));
		this.targetTasks.addTask(12, new EntityAINearestAttackableTarget(this, EntityAgeable.class, true));
	}
	
	@Override
	public void onKillEntity(EntityLivingBase entityLivingIn) {
		super.onKillEntity(entityLivingIn);
		BlockPos pos = new BlockPos(entityLivingIn.posX, entityLivingIn.posY, entityLivingIn.posZ);
		if (this.rand.nextInt(100) <= 5) {
			EntityXenomorphQueen xeno = new EntityXenomorphQueen(this.world);
			ZGHelper.spawnEntity(xeno, world, pos);
		} else {
			EntityXenomorph xeno = new EntityXenomorph(this.world);
			ZGHelper.spawnEntity(xeno, world, pos);
		}
		this.killFacehugger();
	}
	
	@Override
	protected PathNavigate createNavigator(World worldIn) {
		return new PathNavigateClimber(this, worldIn);
	}
	
	@Override
	protected void playStepSound(BlockPos pos, Block blockIn) {
		this.playSound(SoundEvents.ENTITY_SPIDER_STEP, 0.15F, 1.0F);
	}
	
	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(CLIMBING, Byte.valueOf((byte) 0));
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		if (!this.world.isRemote) {
			this.setBesideClimbableBlock(this.collidedHorizontally);
		}
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.29621341192092896D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10.0F);
	}
	
	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		if (super.attackEntityAsMob(entityIn)) {
			if (entityIn instanceof EntityLivingBase) {
				int i = 1;
				
				if (this.world.getDifficulty() == EnumDifficulty.NORMAL) {
					i = 7;
				} else if (this.world.getDifficulty() == EnumDifficulty.HARD) {
					i = 15;
				}
				
				if (i > 0) {
					((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.POISON, i * 20, 0));
				}
			}
			
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public void onLivingUpdate() {
		if (rand.nextInt(500) <= 25) {
			BlockPos entPos = new BlockPos(this.posX, this.posY, this.posZ);
			BlockPos entPosUp = entPos.up();
			BlockPos entPosDown = entPos.down();
			World world = this.world;
			IBlockState state = world.getBlockState(entPos);
			IBlockState stateUp = world.getBlockState(entPosUp);
			IBlockState stateDown = world.getBlockState(entPosDown);
			boolean hasHatchedEgg = false;
			if (state == ZGBlocks.facehuggerEgg.getDefaultState() && !hasHatchedEgg) {
				((BlockFacehuggerEgg) state.getBlock()).hatchEgg(world, entPos);
			} else if (stateUp == ZGBlocks.facehuggerEgg.getDefaultState() && !hasHatchedEgg) {
				((BlockFacehuggerEgg) stateUp.getBlock()).hatchEgg(world, entPosUp);
			} else if (stateDown == ZGBlocks.facehuggerEgg.getDefaultState() && !hasHatchedEgg) {
				((BlockFacehuggerEgg) stateDown.getBlock()).hatchEgg(world, entPosDown);
			}
			if (hasHatchedEgg) {
				this.killFacehugger();
			}
		}
		super.onLivingUpdate();
	}
	
	public void killFacehugger() {
		if (!this.world.isRemote) {
			this.setDead();
			this.ticksExisted = 0;
		}
	}
	
	@Override
	public boolean isOnLadder() {
		return this.isBesideClimbableBlock();
	}
	
	@Override
	public void setInWeb() {
	}
	
	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.ARTHROPOD;
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
	
	public boolean isBesideClimbableBlock() {
		return (this.dataManager.get(CLIMBING).byteValue() & 1) != 0;
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
	
	@Override
	@Nullable
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		livingdata = super.onInitialSpawn(difficulty, livingdata);
		
		if (livingdata == null) {
			livingdata = new EntityFacehugger.GroupData();
			
			EnumDifficulty difficultyLevel = this.world.getDifficulty();
			
			if (difficultyLevel == EnumDifficulty.HARD && this.world.rand.nextFloat() < 0.1F * difficulty.getClampedAdditionalDifficulty()) {
				((EntityFacehugger.GroupData) livingdata).setRandomEffect(this.world.rand);
			}
		}
		
		if (livingdata instanceof EntityFacehugger.GroupData) {
			Potion potion = ((EntityFacehugger.GroupData) livingdata).effect;
			
			if (potion != null) {
				this.addPotionEffect(new PotionEffect(potion, Integer.MAX_VALUE));
			}
		}
		
		return livingdata;
	}
	
	@Override
	public float getEyeHeight() {
		return 0.65F;
	}
	
	static class AIFacehuggerAttack extends EntityAIAttackMelee {
		public AIFacehuggerAttack(EntityFacehugger spider) {
			super(spider, 1.6D, true);
		}
		
		@Override
		public boolean shouldContinueExecuting() {
			if (this.attacker.getRNG().nextInt(100) == 0) {
				this.attacker.setAttackTarget((EntityLivingBase) null);
				return false;
			} else {
				return super.shouldContinueExecuting();
			}
		}
		
		@Override
		protected double getAttackReachSqr(EntityLivingBase attackTarget) {
			return 4.5F + attackTarget.width;
		}
	}
	
	static class AIFacehuggerTarget<T extends EntityLivingBase> extends EntityAINearestAttackableTarget<T> {
		public AIFacehuggerTarget(EntityFacehugger spider, Class<T> classTarget) {
			super(spider, classTarget, true);
		}
		
		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		@Override
		public boolean shouldExecute() {
			float f = this.taskOwner.getBrightness();
			return f >= 0.5F ? false : super.shouldExecute();
		}
	}
	
	public static class GroupData implements IEntityLivingData {
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
	
	@Override
	public boolean canBreath() {
		return true;
	}
}