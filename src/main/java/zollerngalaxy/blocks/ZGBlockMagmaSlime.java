/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.init.Items;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.lib.helpers.ZGHelper;

public class ZGBlockMagmaSlime extends ZGBlockBreakable {
	
	protected ZGBlockMagmaSlime() {
		super("magmaslimeblock", 2.4F, false);
		this.setMaterial(Material.CLAY);
		this.setSlipperiness(0.8F);
		this.setIsHotBlock(true);
		this.setShouldAlwaysBurn(true);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}
	
	@Override
	public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
		if (entityIn.isSneaking()) {
			super.onFallenUpon(worldIn, pos, entityIn, fallDistance);
		} else {
			entityIn.fall(fallDistance, 0.0F);
		}
	}
	
	@Override
	public void onLanded(World worldIn, Entity entityIn) {
		if (entityIn.isSneaking()) {
			super.onLanded(worldIn, entityIn);
		} else if (entityIn.motionY < 0.0D) {
			entityIn.motionY = -entityIn.motionY;
			
			if (!(entityIn instanceof EntityLivingBase)) {
				entityIn.motionY *= 1.2D;
			}
		}
	}
	
	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		super.onEntityWalk(worldIn, pos, entityIn);
		if (Math.abs(entityIn.motionY) < 0.1D && !entityIn.isSneaking()) {
			double d0 = 0.4D + Math.abs(entityIn.motionY) * 0.4D;
			entityIn.motionX *= d0;
			entityIn.motionZ *= d0;
		}
		
		super.onEntityWalk(worldIn, pos, entityIn);
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
		super.onBlockDestroyedByPlayer(worldIn, pos, state);
		for (int i = 0; i < this.rand.nextInt(4); i++) {
			ZGHelper.dropItem(Items.MAGMA_CREAM, worldIn, pos);
		}
		
		if (!worldIn.isRemote) {
			if (this.rand.nextInt(100) <= 50) {
				ZGHelper.spawnEntity(new EntityMagmaCube(worldIn), worldIn, pos);
			}
		}
	}
}