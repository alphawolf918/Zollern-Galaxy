/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zollerngalaxy.lib.helpers.ZGHelper;

public class ZGFruitLeaves extends ZGBlockLeaves {
	
	private Item droppedFood;
	
	public ZGFruitLeaves(String blockName, Block sapling, Item itemFood) {
		super(blockName, sapling);
		this.droppedFood = itemFood;
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
		super.onBlockDestroyedByPlayer(worldIn, pos, state);
		this.dropFruit(worldIn, pos);
	}
	
	@Override
	protected void dropApple(World worldIn, BlockPos pos, IBlockState state, int chance) {
		super.dropApple(worldIn, pos, state, chance);
		this.dropFruit(worldIn, pos);
	}
	
	protected void dropFruit(World worldIn, BlockPos pos) {
		if (!worldIn.isRemote) {
			if (ZGHelper.getRNGChance(4, 10)) {
				int randInt = ZGHelper.rngNumber(1, 2);
				for (int i = 0; i < randInt; i++) {
					ZGHelper.dropItem(droppedFood, worldIn, pos);
				}
			}
		}
	}
}