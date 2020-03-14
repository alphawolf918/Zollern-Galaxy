/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import zollerngalaxy.util.ZGDamageSrc;

public class EntityJellyfish extends EntitySquid {
	
	public EntityJellyfish(World worldIn) {
		super(worldIn);
		this.rand.setSeed(1 + this.getEntityId());
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.24D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(2.0D);
	}
	
	@Override
	public void onCollideWithPlayer(EntityPlayer playerIn) {
		if (!this.getEntityWorld().isRemote) {
			playerIn.attackEntityFrom(ZGDamageSrc.deathJellyfish, ZGDamageSrc.deathJellyfish.getDamageBase());
		}
	}
	
	@Override
	public boolean getCanSpawnHere() {
		boolean seaHeightMax = this.posY >= 15.0D;
		boolean seaHeightMin = this.posY <= this.getEntityWorld().getSeaLevel();
		boolean canSpawnHereSuper = super.getCanSpawnHere();
		boolean canSpawn = (seaHeightMax && seaHeightMin && canSpawnHereSuper);
		return canSpawn;
	}
	
}