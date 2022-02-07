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
		this.droppedSapling = sapling;
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
		super.onBlockDestroyedByPlayer(worldIn, pos, state);
		this.dropFruit(worldIn, pos);
		this.dropSapling(worldIn, pos);
	}
	
	@Override
	protected void dropFruit(World worldIn, BlockPos pos, IBlockState state, int chance) {
		super.dropFruit(worldIn, pos, state, chance);
		this.dropFruit(worldIn, pos);
		if (ZGHelper.getRNGChance(1, 2)) {
			this.dropSapling(worldIn, pos);
		}
	}
	
	protected void dropFruit(World worldIn, BlockPos pos) {
		if (!worldIn.isRemote) {
			if (ZGHelper.getRNGChance(4, 8)) {
				int randInt = ZGHelper.rngInt(1, 2);
				for (int i = 0; i < randInt; i++) {
					ZGHelper.dropItem(this.droppedFood, worldIn, pos);
				}
			}
		}
	}
	
	protected void dropSapling(World worldIn, BlockPos pos) {
		if (ZGHelper.getRNGChance(1, 4)) {
			int randInt = ZGHelper.rngInt(1, 2);
			for (int i = 0; i < randInt; i++) {
				ZGHelper.dropItem(Item.getItemFromBlock(this.droppedSapling), worldIn, pos);
			}
		}
	}
}