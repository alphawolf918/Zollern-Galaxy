/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.worldgen;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zollerngalaxy.blocks.ZGBlocks;

public class WorldGenTunnel extends ZGWorldGenMaster {
	
	private int tunnelDepth = 10;
	private IBlockState airBlock = Blocks.AIR.getDefaultState();
	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos) {
		if (!this.isValidSpawn(worldIn, pos)) {
			return false;
		}
		
		this.generateTunnel(worldIn, pos);
		
		// this.generateTunnels(worldIn, pos);
		//
		// if (rand.nextInt(3) == 0) {
		// this.generateTunnels(worldIn, pos.east(3));
		// }
		
		return true;
	}
	
	private void generateTunnels(World worldIn, BlockPos pos) {
		this.generateTunnel(worldIn, pos);
		if ((new Random()).nextInt(5) == 0) {
			this.generateTunnel(worldIn, pos.add(0, -1, 0));
			this.generateTunnel(worldIn, pos.add(0, -2, 1));
			this.generateTunnel(worldIn, pos.add(0, -3, 0));
			this.generateTunnel(worldIn, pos.add(0, -4, 0));
		}
	}
	
	private void generateTunnel(World worldIn, BlockPos pos) {
		for (int i = 0; i < this.tunnelDepth; i++) {
			worldIn.setBlockState(pos.add(i, 0, 0), airBlock);
			worldIn.setBlockState(pos.add(i, 1, 0), airBlock);
			worldIn.setBlockState(pos.add(i, 2, 0), airBlock);
		}
	}
	
	@Override
	protected void setBlock(World world, BlockPos pos, Block block) {
		IBlockState state = world.getBlockState(pos);
		if (state != ZGBlocks.tlalocDungeonBricks.getDefaultState() && state != Blocks.NETHER_BRICK.getDefaultState()) {
			super.setBlock(world, pos, block);
		}
	}
}