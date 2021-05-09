/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities;

import javax.annotation.Nullable;
import micdoodle8.mods.galacticraft.core.entities.EntityAlienVillager;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import zollerngalaxy.events.ZGSoundEvents;
import zollerngalaxy.mobs.entities.ai.EntityAIBugNearestAttackableTarget;
import zollerngalaxy.mobs.entities.base.EntityBugZG;
import zollerngalaxy.util.ZGDamageSrc;

public class EntityWasp extends EntityBugZG implements IMob {
	
	public EntityWasp(World worldIn) {
		super(worldIn);
		this.setSize(this.width * 0.6F, this.height * 0.6F);
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 32.0F));
		this.tasks.addTask(4, new EntityAILookIdle(this));
		this.tasks.addTask(5, new EntityAILeapAtTarget(this, 0.4F));
		this.targetTasks.addTask(1, new EntityAIBugNearestAttackableTarget(this, EntityPlayer.class, true));
		this.targetTasks.addTask(2, new EntityAIBugNearestAttackableTarget(this, EntityAlienVillager.class, true));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2631D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(45.0D);
	}
	
	@Override
	protected float getSoundVolume() {
		return 1.2F;
	}
	
	@Override
	@Nullable
	public SoundEvent getAmbientSound() {
		return this.getIsBatHanging() && this.rand.nextInt(4) != 0 ? null : ZGSoundEvents.ENTITY_WASP_SAY;
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return ZGSoundEvents.ENTITY_WASP_HURT;
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		return ZGSoundEvents.ENTITY_WASP_DEATH;
	}
	
	@Override
	public void onCollideWithPlayer(EntityPlayer playerIn) {
		if (!this.getEntityWorld().isRemote) {
			playerIn.attackEntityFrom(ZGDamageSrc.deathWasp, ZGDamageSrc.deathWasp.getDamageBase());
		}
	}
	
}