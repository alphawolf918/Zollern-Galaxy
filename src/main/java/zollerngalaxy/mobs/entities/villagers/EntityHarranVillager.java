/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities.villagers;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;
import zollerngalaxy.mobs.entities.base.EntityZGVillagerBase;

public class EntityHarranVillager extends EntityZGVillagerBase {
	
	public EntityHarranVillager(World worldIn) {
		super(worldIn);
		this.setSize(this.width * 1.5375F, this.height * 1.5375F);
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
	}
	
	@Override
	protected float getSoundPitch() {
		return (this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F + 0.2F;
	}
}