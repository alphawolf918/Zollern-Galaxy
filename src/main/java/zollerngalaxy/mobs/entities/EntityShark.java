/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import zollerngalaxy.mobs.entities.ai.EntityAINearestAttackableWaterMobTarget;
import zollerngalaxy.util.ZGDamageSrc;

public class EntityShark extends EntityWaterMobZG {
	
	protected float damageShark = ZGDamageSrc.deathSharkAttack.getDamageBase();
	
	public EntityShark(World worldIn) {
		super(worldIn);
		// this.setSize(4.6F, 4.6F);
		this.rand.setSeed(1 + this.getEntityId());
	}
	
	@Override
	protected void initEntityAI() {
		this.tasks.addTask(0, new EntityWaterMobZG.AIMoveRandom(this));
		this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 16.0F));
		this.tasks.addTask(2, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAINearestAttackableWaterMobTarget(this, EntityPlayer.class, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableWaterMobTarget(this, EntityBlubberFish.class, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableWaterMobTarget(this, EntityGypsyFish.class, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableWaterMobTarget(this, EntityBladeFish.class, true));
		this.targetTasks.addTask(3, new EntityAINearestAttackableWaterMobTarget(this, EntitySquidlus.class, true));
		this.targetTasks.addTask(3, new EntityAINearestAttackableWaterMobTarget(this, EntitySquid.class, true));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2516D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(60.0D);
	}
	
	@Override
	public void onCollideWithPlayer(EntityPlayer playerIn) {
		if (!this.getEntityWorld().isRemote) {
			playerIn.attackEntityFrom(ZGDamageSrc.deathSharkAttack, damageShark);
		}
	}
}