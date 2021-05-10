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
import net.minecraft.world.World;

public class EntitySquidlus extends EntitySquid {
	
	public EntitySquidlus(World worldIn) {
		super(worldIn);
		this.setSize(this.width * 5F, this.height * 5F);
		this.rand.setSeed(1 + this.getEntityId());
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.21D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
	}
	
	@Override
	public boolean getCanSpawnHere() {
		boolean seaHeightMax = this.posY >= 25.0D;
		boolean seaHeightMin = this.posY <= this.getEntityWorld().getSeaLevel();
		boolean canSpawnHereSuper = super.getCanSpawnHere();
		boolean canSpawn = (seaHeightMax && seaHeightMin && canSpawnHereSuper);
		return canSpawn;
	}
	
}