/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.blocks.crops.nether;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;
import zollerngalaxy.blocks.crops.ZGBlockCropBase;

public abstract class BlockNetherCropBase extends ZGBlockCropBase {
	
	public BlockNetherCropBase(String cropNameIn) {
		super(cropNameIn);
	}
	
	@Override
	protected Item getSeed() {
		return Items.NETHER_WART;
	}
	
	@Override
	protected Item getCrop() {
		return Items.NETHER_WART;
	}
	
	@Override
	protected boolean canSustainBush(IBlockState state) {
		Block soilBlock = state.getBlock();
		return (soilBlock == Blocks.SOUL_SAND);
	}
	
	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
		return EnumPlantType.Nether;
	}
}