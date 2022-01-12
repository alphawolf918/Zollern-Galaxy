/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.worldgen;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
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
		world.setBlockState(pos, block.getDefaultState(), 3);
	}
	
	/**
	 * Should set a block at the world and tell you where it does a put.
	 * 
	 * @param world
	 * @param pos
	 * @param blockState
	 */
	protected void setBlock(World world, BlockPos pos, IBlockState blockState) {
		world.setBlockState(pos, blockState, 2);
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
	 * Gets the block at the specified coordinates.
	 * 
	 * @param world
	 *            The world that you're searching in.
	 * @param x
	 *            Coord X
	 * @param y
	 *            Coord Y
	 * @param z
	 *            Coord Z
	 * @return The block at that position.
	 */
	public Block getBlock(World world, int x, int y, int z) {
		return this.getBlock(world, new BlockPos(x, y, z));
	}
	
	/**
	 * Replaces the first specified block with the second one, but only if that block is a match at
	 * the given position.
	 * 
	 * @param world
	 *            The world to search in.
	 * @param pos
	 *            The position to check.
	 * @param replaceIn
	 *            The IBlockState to look for.
	 * @param replaceWithIn
	 *            The IBlockState to set.
	 * @return If the replacement was successful.
	 */
	protected boolean replaceBlock(World world, BlockPos pos, IBlockState replaceIn, IBlockState replaceWithIn) {
		if (this.getBlock(world, pos).getDefaultState() == replaceIn) {
			this.setBlock(world, pos, replaceWithIn);
			return true;
		}
		return false;
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
	
	/**
	 * Checks if the spawn point is valid.
	 * 
	 * @param world
	 *            World
	 * @param pos
	 *            Position in world
	 * @return True/False
	 */
	protected boolean isValidSpawn(World world, BlockPos pos) {
		IBlockState state = world.getBlockState(pos.down());
		
		if (state == null) {
			return false;
		}
		
		Block blockBelow = state.getBlock();
		
		if (blockBelow == null) {
			return false;
		}
		
		if (blockBelow == Blocks.AIR || blockBelow == Blocks.WATER) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * Generate a chest at the given coordinates with the supplied loot table.
	 * 
	 * @param world
	 * @param chestPos
	 * @param rand
	 * @param LOOT_TABLE
	 * @param isBigChest
	 */
	public static void generateChest(World world, BlockPos chestPos, Random rand, ResourceLocation LOOT_TABLE, boolean isBigChest) {
		world.setBlockState(chestPos, Blocks.CHEST.correctFacing(world, chestPos, Blocks.CHEST.getDefaultState().withProperty(BlockChest.FACING, EnumFacing.NORTH)), 2);
		TileEntity tileentity1 = world.getTileEntity(chestPos);
		
		if (tileentity1 instanceof TileEntityChest) {
			((TileEntityChest) tileentity1).setLootTable(LOOT_TABLE, rand.nextLong());
		}
	}
	
	/**
	 * Generate a chest at the given coordinates with the supplied loot table.
	 * 
	 * @param world
	 * @param chestPos
	 * @param rand
	 * @param LOOT_TABLE
	 */
	public static void generateChest(World world, BlockPos chestPos, Random rand, ResourceLocation LOOT_TABLE) {
		ZGWorldGenMaster.generateChest(world, chestPos, rand, LOOT_TABLE, false);
	}
}