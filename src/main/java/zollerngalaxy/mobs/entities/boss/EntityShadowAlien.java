/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities.boss;

import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.core.ZollernGalaxyCore;
import zollerngalaxy.events.ZGSoundEvents;
import zollerngalaxy.mobs.entities.EntityScorpion;
import zollerngalaxy.mobs.entities.interfaces.IShadeEntity;
import zollerngalaxy.util.ZGUtils;

public class EntityShadowAlien extends EntityMob implements IShadeEntity {
	
	private int maxHealth = 1000;
	private int xp = 2000;
	private double attackDamage = 8.0D;
	
	public EntityShadowAlien(World worldIn) {
		super(worldIn);
		this.setSize(this.width * 1.4F, this.height * 1.4F);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityGolem.class, 8.0F));
		this.tasks.addTask(4, new EntityAILookIdle(this));
		this.tasks.addTask(5, new EntityAIAttackMelee(this, 2.5D, false));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityGolem.class, true));
		this.experienceValue = this.xp;
		this.scoreValue = this.xp;
		this.stepHeight = 2F;
		this.setCanPickUpLoot(true);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return ZGSoundEvents.ENTITY_SHADOW_ALIEN_SAY;
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return ZGSoundEvents.ENTITY_SHADOW_ALIEN_HURT;
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		return ZGSoundEvents.ENTITY_SHADOW_ALIEN_DEATH;
	}
	
	@Override
	protected float getSoundVolume() {
		return 5.0F;
	}
	
	@Override
	public void fall(float par1, float par2) {
	}
	
	@Override
	public void onLivingUpdate() {
		Random rand = new Random();
		int randInt = rand.nextInt(900);
		if (randInt <= 10) {
			double health = this.getHealth();
			if (health < maxHealth && health > 0 && !this.isDead) {
				health += rand.nextInt(10) >= 5 ? 10 : 20;
				this.setHealth((float) health);
			}
		}
		
		if (rand.nextInt(4632) <= 16 && this.getHealth() <= 500) {
			if (!this.world.isRemote) {
				EntityScorpion scorpion = new EntityScorpion(this.world);
				scorpion.setLocationAndAngles(this.posX, this.posY, this.posZ, 0, 0);
				this.world.spawnEntity(scorpion);
			}
		}
		
		if (this.getHealth() <= 250 && rand.nextInt(1000) <= 10) {
			double atkDmg = this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getBaseValue();
			double maxAtkDmg = this.attackDamage * 2;
			if (atkDmg < maxAtkDmg) {
				this.attackDamage += 0.1D;
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(this.attackDamage);
			}
		}
		super.onLivingUpdate();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getBrightnessForRender() {
		return 16828890;
	}
	
	@Override
	public float getBrightness() {
		return 5.0F;
	}
	
	@Override
	public boolean canBePushed() {
		return false;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(45.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1000);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(this.attackDamage);
	}
	
	@Override
	public boolean attackEntityAsMob(Entity p_70652_1_) {
		super.attackEntityAsMob(p_70652_1_);
		return true;
	}
	
	@Override
	public void setInWeb() {
	}
	
	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.ARTHROPOD;
	}
	
	@Override
	public void onDeath(DamageSource par1) {
		super.onDeath(par1);
		if (attackingPlayer != null) {
			ZollernGalaxyCore.proxy.sendChatMessage(attackingPlayer, ZGUtils.translate("tooltips.shadowbossbeaten"));
		}
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
	public void onKillEntity(EntityLivingBase par1EntityLivingBase) {
		float health = this.maxHealth;
		if (health <= maxHealth / 2) {
			int randInt = new Random().nextInt(50);
			this.setHealth(this.maxHealth / 2 + randInt);
		}
	}
	
	// Below code donated by DabbingEevee
	
	@Override
	public boolean isNonBoss() {
		return false;
	}
	
	private final BossInfoServer bossInfo = new BossInfoServer(this.getDisplayName(), BossInfo.Color.RED, BossInfo.Overlay.PROGRESS);
	
	@Override
	public void addTrackingPlayer(EntityPlayerMP player) {
		super.addTrackingPlayer(player);
		this.bossInfo.addPlayer(player);
	}
	
	@Override
	public void removeTrackingPlayer(EntityPlayerMP player) {
		super.removeTrackingPlayer(player);
		this.bossInfo.removePlayer(player);
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
	}
	
}