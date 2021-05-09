/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities;

import java.util.Random;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.mobs.entities.interfaces.IShadeEntity;

public class EntitySpiderling extends EntityCaveSpider implements IShadeEntity {
	
	public EntitySpiderling(World worldIn) {
		super(worldIn);
		this.setSize(this.width * 0.4F, this.height * 0.4F);
	}
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		Random rand = new Random();
		if (rand.nextInt(100) == 5) {
			this.world.setBlockState(new BlockPos((int) this.posX, (int) this.posY, (int) this.posZ - 1), Blocks.WEB.getDefaultState());
		}
		if (this.ticksExisted >= 2000) {
			if (rand.nextInt(1000) <= 5 && !this.isDead) {
				this.world.setBlockState(new BlockPos((int) this.posX, (int) this.posY, (int) this.posZ), ZGBlocks.spiderlingEgg.getDefaultState());
				if (new Random().nextInt(100) <= 50) {
					this.killSpider();
				}
			}
		}
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.320000011920929D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
	}
	
	public void killSpider() {
		this.setDead();
		this.ticksExisted = 0;
	}
	
	@Override
	protected float getSoundPitch() {
		return 2.0F;
	}
	
	@Override
	protected float getSoundVolume() {
		return 2.15F;
	}
	
}
