/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.worldgen;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public abstract class ZGWorldGenMaster extends WorldGenerator {
	
	/**
	 * Should set a block at the world and tell you where it does a put.
	 * 
	 * @param world
	 *            Do I really have to explain this part?
	 * @param pos
	 *            The position to add to. Add it as 0, 0, 0 and then increment
	 *            as needed.
	 * @param block
	 *            Use the block, not the block state. Method handles this
	 *            internally.
	 */
	protected void setBlock(World world, BlockPos pos, Block block) {
		world.setBlockState(pos, block.getDefaultState());
	}
	
	/**
	 * Should set a block at the world and tell you where it does a put.
	 * 
	 * @param world
	 * @param pos
	 * @param blockState
	 */
	protected void setBlock(World world, BlockPos pos, IBlockState blockState) {
		world.setBlockState(pos, blockState);
	}
	
	/**
	 * Set a block using a more direct approach.
	 * 
	 * @param world
	 * @param pos
	 * @param x
	 * @param y
	 * @param z
	 * @param block
	 */
	protected void setBlock(World world, BlockPos pos, int x, int y, int z, Block block) {
		this.setBlock(world, pos.add(x, y, z), block);
	}
	
	/**
	 * Gets the block at the specified coordinates.
	 * 
	 * @param world
	 *            The world that you're searching in.
	 * @param pos
	 *            The block position to check.
	 * @return The block at that position.
	 */
	protected Block getBlock(World world, BlockPos pos) {
		return world.getBlockState(pos).getBlock();
	}
	
	/**
	 * Prints where the structure spawned at. Useful for printing to the
	 * console.
	 * 
	 * @param pos
	 *            The current block position of the structure (best used at the
	 *            end).
	 * @return The X, Y, Z coordinates of the structure.
	 */
	protected String getSpawnedAtString(BlockPos pos) {
		return "Spawned at: " + pos.getX() + " " + pos.getY() + " " + pos.getZ();
	}
	
	protected boolean isValidSpawn(World world, BlockPos pos) {
		Block blockBelow = world.getBlockState(pos.down()).getBlock();
		
		if (blockBelow == Blocks.AIR) {
			return false;
		}
		
		return true;
	}
	
}