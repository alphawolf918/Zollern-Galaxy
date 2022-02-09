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
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
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
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfo.Color;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.events.ZGSoundEvents;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.mobs.entities.EntityGrayAlien;
import zollerngalaxy.mobs.entities.ai.EntityAIVexbotBossAttack;
import zollerngalaxy.mobs.entities.base.EntityZGVillagerBase;

public class EntityVexBotBoss extends EntityBossBase implements IEntityBreathable {
	
	private BlockPos entPos = this.getPosition();
	
	public EntityVexBotBoss(World world) {
		super(world);
		this.setSize(this.width * 2.5F, this.height * 2.0F);
		this.isImmuneToFire = true;
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(3, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<>(this, EntityPlayer.class, false, true));
	}
	
	@Override
	public void knockBack(Entity par1Entity, float par2, double par3, double par5) {
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
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1525.0F * ConfigManagerCore.dungeonBossHealthMod);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.28D + 0.075 * difficulty);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(25.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(15.5D);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(20.0D);
	}
	
	@Override
	protected void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIMoveTowardsRestriction(this, 1.6D));
		this.tasks.addTask(2, new EntityAIVexbotBossAttack(this, 1.8F, true));
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
		if (this.isInWater()) {
			this.attackEntityFrom(DamageSource.DROWN, 10.0F);
		}
		this.entPos = this.getPosition();
		super.onLivingUpdate();
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
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEFINED;
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return ZGSoundEvents.ENTITY_VEXBOT_SAY;
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return ZGSoundEvents.ENTITY_VEXBOT_HURT;
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		return ZGSoundEvents.ENTITY_VEXBOT_DIE;
	}
	
	@Override
	public boolean canBePushed() {
		return false;
	}
	
	@Override
	public int getChestTier() {
		return 10;
	}
	
	@Override
	public ItemStack getGuaranteedLoot(Random rand) {
		List<ItemStack> stackList = GalacticraftRegistry.getDungeonLoot(10);
		return stackList.get(rand.nextInt(stackList.size())).copy();
	}
	
	@Override
	public void dropKey() {
		this.entityDropItem(new ItemStack(ZGItems.tlalocDungeonKey, 1), 0.5F);
	}
	
	@Override
	public Color getHealthBarColor() {
		return BossInfo.Color.WHITE;
	}
	
	@Override
	public boolean canBreath() {
		return true;
	}
}