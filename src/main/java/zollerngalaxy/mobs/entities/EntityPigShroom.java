/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.world.World;

public class EntityPigShroom extends EntityOinkus {
	
	public EntityPigShroom(World worldIn) {
		super(worldIn);
		this.setSize(this.width * 0.6F, this.height * 0.6F);
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.50D);
	}
	
	public static void registerFixesPig(DataFixer fixer) {
		EntityLiving.registerFixesMob(fixer, EntityPigShroom.class);
	}
	
	@Override
	public void onStruckByLightning(EntityLightningBolt par1EntityLightningBolt) {
	}
	
	@Override
	public EntityOinkus createChild(EntityAgeable ageable) {
		return new EntityPigShroom(this.world);
	}
	
}