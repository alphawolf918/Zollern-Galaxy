/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities;

import java.util.Set;
import java.util.UUID;
import javax.annotation.Nullable;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISit;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.mobs.entities.ai.EntityAIDragonBeg;

public class EntityGalaxyDragon extends EntityTameable {
	
	private static final DataParameter<Boolean> SADDLED = EntityDataManager.<Boolean> createKey(EntityGalaxyDragon.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Integer> BOOST_TIME = EntityDataManager.<Integer> createKey(EntityGalaxyDragon.class, DataSerializers.VARINT);
	private static final Set<Item> TEMPTATION_ITEMS = Sets.newHashSet(ZGItems.creamBall, ZGItems.perdBerry, ZGItems.perdPeach);
	
	private static final DataParameter<Float> DATA_HEALTH_ID = EntityDataManager.<Float> createKey(EntityGalaxyDragon.class, DataSerializers.FLOAT);
	private static final DataParameter<Boolean> BEGGING = EntityDataManager.<Boolean> createKey(EntityGalaxyDragon.class, DataSerializers.BOOLEAN);
	
	private boolean boosting;
	private int boostTime;
	private int totalBoostTime;
	
	public EntityGalaxyDragon(World worldIn) {
		super(worldIn);
		this.setSize(this.width * 2.0F, this.height * 2.0F);
		this.setTamed(false);
	}
	
	@Override
	protected void initEntityAI() {
		this.aiSit = new EntityAISit(this);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, this.aiSit);
		this.tasks.addTask(4, new EntityAILeapAtTarget(this, 0.4F));
		this.tasks.addTask(5, new EntityAIAttackMelee(this, 1.0D, true));
		this.tasks.addTask(6, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
		this.tasks.addTask(7, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(8, new EntityAIWanderAvoidWater(this, 1.0D));
		this.tasks.addTask(9, new EntityAIDragonBeg(this, 8.0F));
		this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(10, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
		this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true, new Class[0]));
		this.targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, AbstractSkeleton.class, false));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.34200001192092896D);
		
		if (this.isTamed()) {
			this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(120.0D);
		} else {
			this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(60.0D);
		}
		
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);
	}
	
	public void walkOnWater() {
		World world = this.world;
		BlockPos pos = new BlockPos((int) this.posX, (int) (this.posY - 1), (int) this.posZ);
		IBlockState block = world.getBlockState(pos);
		if (block == Blocks.WATER.getDefaultState()) {
			this.world.setBlockState(pos, Blocks.ICE.getDefaultState());
		}
	}
	
	@Override
	@Nullable
	public Entity getControllingPassenger() {
		return this.getPassengers().isEmpty() ? null : (Entity) this.getPassengers().get(0);
	}
	
	@Override
	public void setAttackTarget(@Nullable EntityLivingBase entitylivingbaseIn) {
		super.setAttackTarget(entitylivingbaseIn);
		
		if (entitylivingbaseIn == null) {
			this.setAngry(false);
		} else if (!this.isTamed()) {
			this.setAngry(true);
		}
	}
	
	@Override
	protected void updateAITasks() {
		this.dataManager.set(DATA_HEALTH_ID, Float.valueOf(this.getHealth()));
	}
	
	@Override
	public boolean canBeSteered() {
		Entity entity = this.getControllingPassenger();
		
		if (!(entity instanceof EntityPlayer)) {
			return false;
		} else {
			EntityPlayer entityplayer = (EntityPlayer) entity;
			return entityplayer.getHeldItemMainhand().getItem() == ZGItems.perdBerry || entityplayer.getHeldItemOffhand().getItem() == ZGItems.perdBerry;
		}
	}
	
	@Override
	public void notifyDataManagerChange(DataParameter<?> key) {
		if (BOOST_TIME.equals(key) && this.world.isRemote) {
			this.boosting = true;
			this.boostTime = 0;
			this.totalBoostTime = this.dataManager.get(BOOST_TIME).intValue();
		}
		
		super.notifyDataManagerChange(key);
	}
	
	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(SADDLED, Boolean.valueOf(false));
		this.dataManager.register(BOOST_TIME, Integer.valueOf(0));
		this.dataManager.register(DATA_HEALTH_ID, Float.valueOf(this.getHealth()));
		this.dataManager.register(BEGGING, Boolean.valueOf(false));
	}
	
	@Override
	protected void playStepSound(BlockPos pos, Block blockIn) {
		this.playSound(SoundEvents.ENTITY_WOLF_STEP, 0.15F, 1.0F);
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setBoolean("Saddle", this.getSaddled());
		compound.setBoolean("Angry", this.isAngry());
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.setSaddled(compound.getBoolean("Saddle"));
		this.setAngry(compound.getBoolean("Angry"));
	}
	
	public boolean getSaddled() {
		return this.dataManager.get(SADDLED).booleanValue();
	}
	
	public void setSaddled(boolean saddled) {
		if (saddled) {
			this.dataManager.set(SADDLED, Boolean.valueOf(true));
		} else {
			this.dataManager.set(SADDLED, Boolean.valueOf(false));
		}
	}
	
	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand) {
		ItemStack itemstack = player.getHeldItem(hand);
		if (itemstack.getItem() == Items.NAME_TAG) {
			itemstack.interactWithEntity(player, this, hand);
			return true;
		} else if (this.getSaddled() && !this.isBeingRidden()) {
			if (!this.world.isRemote) {
				player.startRiding(this);
			}
			
			return true;
		} else if (itemstack.getItem() == Items.SADDLE) {
			itemstack.interactWithEntity(player, this, hand);
			return true;
		}
		if (this.isTamed()) {
			if (!itemstack.isEmpty()) {
				if (itemstack.getItem() instanceof ItemFood) {
					ItemFood itemfood = (ItemFood) itemstack.getItem();
					
					if (this.dataManager.get(DATA_HEALTH_ID).floatValue() < 20.0F) {
						if (!player.capabilities.isCreativeMode) {
							itemstack.shrink(1);
						}
						
						this.heal(itemfood.getHealAmount(itemstack));
						return true;
					}
				}
			}
			
			if (this.isOwner(player) && !this.world.isRemote && !this.isBreedingItem(itemstack)) {
				this.aiSit.setSitting(!this.isSitting());
				this.isJumping = false;
				this.navigator.clearPath();
				this.setAttackTarget((EntityLivingBase) null);
			}
		} else if (itemstack.getItem() == Items.BONE && !this.isAngry()) {
			if (!player.capabilities.isCreativeMode) {
				itemstack.shrink(1);
			}
			
			if (!this.world.isRemote) {
				if (this.rand.nextInt(3) == 0 && !ForgeEventFactory.onAnimalTame(this, player)) {
					this.setTamedBy(player);
					this.navigator.clearPath();
					this.setAttackTarget((EntityLivingBase) null);
					this.aiSit.setSitting(true);
					this.setHealth(120.0F);
					this.playTameEffect(true);
					this.world.setEntityState(this, (byte) 7);
				} else {
					this.playTameEffect(false);
					this.world.setEntityState(this, (byte) 6);
				}
			}
			
			return true;
		}
		return super.processInteract(player, hand);
	}
	
	@Override
	public void onDeath(DamageSource cause) {
		super.onDeath(cause);
		
		if (!this.world.isRemote) {
			if (this.getSaddled()) {
				this.dropItem(Items.SADDLE, 1);
			}
		}
	}
	
	@Override
	public EntityGalaxyDragon createChild(EntityAgeable ageable) {
		EntityGalaxyDragon entitydragon = new EntityGalaxyDragon(this.world);
		UUID uuid = this.getOwnerId();
		
		if (uuid != null) {
			entitydragon.setOwnerId(uuid);
			entitydragon.setTamed(true);
		}
		
		return entitydragon;
	}
	
	@Override
	public void travel(float strafe, float vertical, float forward) {
		Entity entity = this.getPassengers().isEmpty() ? null : (Entity) this.getPassengers().get(0);
		
		if (this.isBeingRidden() && this.canBeSteered()) {
			this.rotationYaw = entity.rotationYaw;
			this.prevRotationYaw = this.rotationYaw;
			this.rotationPitch = entity.rotationPitch * 0.5F;
			this.setRotation(this.rotationYaw, this.rotationPitch);
			this.renderYawOffset = this.rotationYaw;
			this.rotationYawHead = this.rotationYaw;
			this.stepHeight = 1.0F;
			this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;
			
			if (this.boosting && this.boostTime++ > this.totalBoostTime) {
				this.boosting = false;
			}
			
			if (this.canPassengerSteer()) {
				float f = (float) this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue() * 0.225F;
				
				if (this.boosting) {
					f += f * 1.15F * MathHelper.sin((float) this.boostTime / (float) this.totalBoostTime * (float) Math.PI);
				}
				
				this.setAIMoveSpeed(f);
				super.travel(0.0F, 0.0F, 1.0F);
			} else {
				this.motionX = 0.0D;
				this.motionY = 0.0D;
				this.motionZ = 0.0D;
			}
			
			this.prevLimbSwingAmount = this.limbSwingAmount;
			double d1 = this.posX - this.prevPosX;
			double d0 = this.posZ - this.prevPosZ;
			float f1 = MathHelper.sqrt(d1 * d1 + d0 * d0) * 4.0F;
			
			if (f1 > 1.0F) {
				f1 = 1.0F;
			}
			
			this.limbSwingAmount += (f1 - this.limbSwingAmount) * 0.4F;
			this.limbSwing += this.limbSwingAmount;
		} else {
			this.stepHeight = 0.5F;
			this.jumpMovementFactor = 0.02F;
			super.travel(strafe, vertical, forward);
		}
	}
	
	public boolean boost() {
		if (this.boosting) {
			return false;
		} else {
			this.boosting = true;
			this.boostTime = 0;
			this.totalBoostTime = this.getRNG().nextInt(841) + 140;
			this.getDataManager().set(BOOST_TIME, Integer.valueOf(this.totalBoostTime));
			return true;
		}
	}
	
	@Override
	public boolean isBreedingItem(ItemStack stack) {
		return TEMPTATION_ITEMS.contains(stack.getItem());
	}
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		if (!this.world.isRemote && this.getAttackTarget() == null && this.isAngry()) {
			this.setAngry(false);
		}
	}
	
	@Override
	public float getEyeHeight() {
		return this.height * 1.2F;
	}
	
	@Override
	public int getVerticalFaceSpeed() {
		return this.isSitting() ? 20 : super.getVerticalFaceSpeed();
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (this.isEntityInvulnerable(source)) {
			return false;
		} else {
			Entity entity = source.getTrueSource();
			
			if (this.aiSit != null) {
				this.aiSit.setSitting(false);
			}
			
			if (entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow)) {
				amount = (amount + 1.0F) / 2.0F;
			}
			
			return super.attackEntityFrom(source, amount);
		}
	}
	
	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), ((int) this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue()));
		
		if (flag) {
			this.applyEnchantments(this, entityIn);
		}
		
		return flag;
	}
	
	@Override
	public void setTamed(boolean tamed) {
		super.setTamed(tamed);
		
		if (tamed) {
			this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(120.0D);
		} else {
			this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(60.0D);
		}
		
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);
	}
	
	public boolean isAngry() {
		return (this.dataManager.get(TAMED).byteValue() & 2) != 0;
	}
	
	public void setAngry(boolean angry) {
		byte b0 = this.dataManager.get(TAMED).byteValue();
		
		if (angry) {
			this.dataManager.set(TAMED, Byte.valueOf((byte) (b0 | 2)));
		} else {
			this.dataManager.set(TAMED, Byte.valueOf((byte) (b0 & -3)));
		}
	}
	
	public void setBegging(boolean beg) {
		this.dataManager.set(BEGGING, Boolean.valueOf(beg));
	}
	
	public boolean isBegging() {
		return this.dataManager.get(BEGGING).booleanValue();
	}
	
	@Override
	public boolean canMateWith(EntityAnimal otherAnimal) {
		if (otherAnimal == this) {
			return false;
		} else if (!this.isTamed()) {
			return false;
		} else if (!(otherAnimal instanceof EntityGalaxyDragon)) {
			return false;
		} else {
			EntityGalaxyDragon entitydragon = (EntityGalaxyDragon) otherAnimal;
			
			if (!entitydragon.isTamed()) {
				return false;
			} else if (entitydragon.isSitting()) {
				return false;
			} else {
				return this.isInLove() && entitydragon.isInLove();
			}
		}
	}
	
	@Override
	public boolean shouldAttackEntity(EntityLivingBase target, EntityLivingBase owner) {
		if (!(target instanceof EntityCreeper) && !(target instanceof EntityGhast)) {
			if (target instanceof EntityGalaxyDragon) {
				EntityGalaxyDragon entitydragon = (EntityGalaxyDragon) target;
				
				if (entitydragon.isTamed() && entitydragon.getOwner() == owner) {
					return false;
				}
			}
			
			if (target instanceof EntityPlayer && owner instanceof EntityPlayer && !((EntityPlayer) owner).canAttackPlayer((EntityPlayer) target)) {
				return false;
			} else {
				return !(target instanceof AbstractHorse) || !((AbstractHorse) target).isTame();
			}
		} else {
			return false;
		}
	}
	
	@Override
	public boolean canBeLeashedTo(EntityPlayer player) {
		return !this.isAngry() && super.canBeLeashedTo(player);
	}
}