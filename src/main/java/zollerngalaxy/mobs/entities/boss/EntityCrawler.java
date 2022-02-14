/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities.boss;

import java.util.List;
import java.util.Random;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.entity.IEntityBreathable;
import micdoodle8.mods.galacticraft.core.entities.EntityAlienVillager;
import micdoodle8.mods.galacticraft.core.entities.EntityBossBase;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BossInfo.Color;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.events.ZGSoundEvents;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.mobs.entities.EntityGrayAlien;
import zollerngalaxy.mobs.entities.EntityScorpion;
import zollerngalaxy.mobs.entities.EntitySpiderling;
import zollerngalaxy.mobs.entities.base.EntityZGVillagerBase;

public class EntityCrawler extends EntityBossBase implements IEntityBreathable {
	
	private BlockPos entPos = this.getPosition();
	public static int deathTicks = 0;
	public static int ticksExisted = 0;
	
	public EntityCrawler(World world) {
		super(world);
		this.setSize(this.width * 2.5F, this.height * 2.0F);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(3, new EntityAILookIdle(this));
		this.tasks.addTask(4, new EntityAIAttackMelee(this, 1.0, true));
		this.tasks.addTask(5, new EntityAIWander(this, 0.8D));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<>(this, EntityPlayer.class, false, true));
		this.ignoreFrustumCheck = true;
		this.experienceValue = 1000;
		this.scoreValue = 1000;
	}
	
	@Override
	protected void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIMoveTowardsRestriction(this, 1.6D));
		this.tasks.addTask(3, new EntityAIWanderAvoidWater(this, 3.0D));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 16.0F));
		this.tasks.addTask(4, new EntityAILookIdle(this));
		this.applyEntityAI();
	}
	
	protected void applyEntityAI() {
		this.tasks.addTask(5, new EntityAIMoveThroughVillage(this, 1.5D, false));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityAgeable.class, true));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityZGVillagerBase.class, false));
		this.targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, EntityAlienVillager.class, false));
		this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntityGrayAlien.class, true));
	}
	
	@Override
	public void onLivingUpdate() {
		this.entPos = this.getPosition();
		Random rand = new Random();
		int randInt = rand.nextInt(10);
		int randIntI = rand.nextInt(4);
		
		if (!this.world.isRemote) {
			if (ticksExisted >= 1000) {
				Entity spider;
				spider = (randInt >= 5) ? new EntitySpiderling(this.world) : new EntityScorpion(this.world);
				spider.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
				for (int i = 1; i < randIntI; i++) {
					this.world.spawnEntity(spider);
					this.heal(randIntI * 6.0F);
				}
				ticksExisted = 0;
			}
			ticksExisted++;
			if (rand.nextInt(1000) == 5) {
				this.world.setBlockState(new BlockPos((int) this.posX, (int) this.posY, (int) this.posZ), ZGBlocks.spiderlingEgg.getDefaultState());
				this.heal(randIntI * 6.0F);
			}
		}
		super.onLivingUpdate();
	}
	
	@Override
	public boolean canBePushed() {
		return false;
	}
	
	@Override
	protected PathNavigate createNavigator(World worldIn) {
		return new PathNavigateGround(this, worldIn);
	}
	
	@Override
	public void setInWeb() {
	}
	
	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.ARTHROPOD;
	}
	
	@Override
	public boolean isValidLightLevel() {
		return true;
	}
	
	@Override
	public boolean getCanSpawnHere() {
		return this.world.getDifficulty() != EnumDifficulty.PEACEFUL;
	}
	
	@Override
	public void knockBack(Entity entityIn, float par2, double par3, double par4) {
	}
	
	@SuppressWarnings("incomplete-switch")
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		double difficulty = 0;
		switch (this.world.getDifficulty()) {
			case HARD:
				difficulty = (ConfigManagerZG.enableExtremeMode) ? 4D : 2D;
				break;
			case NORMAL:
				difficulty = (ConfigManagerZG.enableExtremeMode) ? 2D : 1D;
				break;
		}
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(850.0F * ConfigManagerCore.dungeonBossHealthMod);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D + 0.005 * difficulty);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(25.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(15.5D);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(20.0D);
	}
	
	@Override
	protected float getSoundPitch() {
		return (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5F;
	}
	
	@Override
	protected float getSoundVolume() {
		return 8.0F;
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return ZGSoundEvents.ENTITY_CRAWLER_SAY;
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return ZGSoundEvents.ENTITY_CRAWLER_HURT;
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_SPIDER_DEATH;
	}
	
	@Override
	protected void playStepSound(BlockPos pos, Block blockIn) {
		this.playSound(SoundEvents.ENTITY_SPIDER_STEP, 0.5F, 0.5F);
	}
	
	@Override
	protected Item getDropItem() {
		return Items.STRING;
	}
	
	@Override
	protected void dropFewItems(boolean par1, int par2) {
		super.dropFewItems(par1, par2);
		
		if (par1 && (this.rand.nextInt(3) == 0 || this.rand.nextInt(1 + par2) > 0)) {
			this.dropItem(Items.SPIDER_EYE, 1);
		}
	}
	
	@Override
	public boolean isPotionApplicable(PotionEffect potioneffectIn) {
		return potioneffectIn.getPotion() != MobEffects.POISON && super.isPotionApplicable(potioneffectIn);
	}
	
	@Override
	public float getEyeHeight() {
		return 0.65F;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getBrightnessForRender() {
		return 16728890;
	}
	
	@Override
	public float getBrightness() {
		return 5.0F;
	}
	
	@Override
	public int getChestTier() {
		return 4;
	}
	
	@Override
	public ItemStack getGuaranteedLoot(Random rand) {
		List<ItemStack> stackList = GalacticraftRegistry.getDungeonLoot(3);
		return stackList.get(rand.nextInt(stackList.size())).copy();
	}
	
	@Override
	public void dropKey() {
		this.entityDropItem(new ItemStack(ZGItems.edenDungeonKey, 1, 0), 0.5F);
	}
	
	@Override
	public Color getHealthBarColor() {
		return Color.GREEN;
	}
	
	@Override
	public boolean canBreath() {
		return true;
	}
}