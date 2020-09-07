/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.blocks.eden;

import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import zollerngalaxy.blocks.ZGBlockBase;
import zollerngalaxy.core.enums.EnumBlockType;
import zollerngalaxy.lib.helpers.ZGHelper;

public class BlockRedshroom extends ZGBlockBase {
	
	public BlockRedshroom() {
		super("redshroomblock", 0.5F);
		this.setSound(SoundType.CLOTH);
		this.setBlockType(EnumBlockType.MUSHROOM);
	}
	
	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		int j = ZGHelper.rngInt(2, 8);
		for (int k = 0; k < j; ++k) {
			drops.add(new ItemStack(Blocks.RED_MUSHROOM, 1, 0));
		}
	}
}