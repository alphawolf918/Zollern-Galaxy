/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.worldgen;

import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WorldGenZGTree2 extends ZGWorldGenMaster {
	
	private IBlockState woodState;
	private IBlockState leafState;
	
	public WorldGenZGTree2(IBlockState woodStateIn, IBlockState leafStateIn) {
		this.woodState = woodStateIn;
		this.leafState = leafStateIn;
	}
	
	@Override
	public boolean generate(World world, Random rand, BlockPos position) {
		if (!this.isValidSpawn(world, position)) {
			return false;
		}
		
		this.setBlock(world, position.add(1, 4, 3), this.leafState);
		this.setBlock(world, position.add(1, 4, 4), this.leafState);
		this.setBlock(world, position.add(1, 4, 5), this.leafState);
		this.setBlock(world, position.add(1, 4, 6), this.leafState);
		this.setBlock(world, position.add(1, 4, 7), this.leafState);
		this.setBlock(world, position.add(1, 4, 8), this.leafState);
		this.setBlock(world, position.add(1, 4, 9), this.leafState);
		this.setBlock(world, position.add(1, 4, 10), this.leafState);
		this.setBlock(world, position.add(1, 4, 11), this.leafState);
		this.setBlock(world, position.add(2, 4, 3), this.leafState);
		this.setBlock(world, position.add(2, 4, 4), this.woodState);
		this.setBlock(world, position.add(2, 4, 5), this.woodState);
		this.setBlock(world, position.add(2, 4, 6), this.woodState);
		this.setBlock(world, position.add(2, 4, 7), this.woodState);
		this.setBlock(world, position.add(2, 4, 8), this.woodState);
		this.setBlock(world, position.add(2, 4, 9), this.woodState);
		this.setBlock(world, position.add(2, 4, 10), this.woodState);
		this.setBlock(world, position.add(2, 4, 11), this.leafState);
		this.setBlock(world, position.add(2, 5, 4), this.leafState);
		this.setBlock(world, position.add(2, 5, 5), this.leafState);
		this.setBlock(world, position.add(2, 5, 6), this.leafState);
		this.setBlock(world, position.add(2, 5, 7), this.leafState);
		this.setBlock(world, position.add(2, 5, 8), this.leafState);
		this.setBlock(world, position.add(2, 5, 9), this.leafState);
		this.setBlock(world, position.add(2, 5, 10), this.leafState);
		this.setBlock(world, position.add(3, 4, 3), this.leafState);
		this.setBlock(world, position.add(3, 4, 4), this.woodState);
		this.setBlock(world, position.add(3, 4, 10), this.woodState);
		this.setBlock(world, position.add(3, 4, 11), this.leafState);
		this.setBlock(world, position.add(3, 5, 4), this.leafState);
		this.setBlock(world, position.add(3, 5, 5), this.woodState);
		this.setBlock(world, position.add(3, 5, 6), this.woodState);
		this.setBlock(world, position.add(3, 5, 7), this.woodState);
		this.setBlock(world, position.add(3, 5, 8), this.woodState);
		this.setBlock(world, position.add(3, 5, 9), this.woodState);
		this.setBlock(world, position.add(3, 5, 10), this.leafState);
		this.setBlock(world, position.add(3, 6, 5), this.leafState);
		this.setBlock(world, position.add(3, 6, 6), this.leafState);
		this.setBlock(world, position.add(3, 6, 7), this.leafState);
		this.setBlock(world, position.add(3, 6, 8), this.leafState);
		this.setBlock(world, position.add(3, 6, 9), this.leafState);
		this.setBlock(world, position.add(4, 4, 3), this.leafState);
		this.setBlock(world, position.add(4, 4, 4), this.woodState);
		this.setBlock(world, position.add(4, 4, 10), this.woodState);
		this.setBlock(world, position.add(4, 4, 11), this.leafState);
		this.setBlock(world, position.add(4, 5, 4), this.leafState);
		this.setBlock(world, position.add(4, 5, 5), this.woodState);
		this.setBlock(world, position.add(4, 5, 6), this.woodState);
		this.setBlock(world, position.add(4, 5, 7), this.woodState);
		this.setBlock(world, position.add(4, 5, 8), this.woodState);
		this.setBlock(world, position.add(4, 5, 9), this.woodState);
		this.setBlock(world, position.add(4, 5, 10), this.leafState);
		this.setBlock(world, position.add(4, 6, 5), this.leafState);
		this.setBlock(world, position.add(4, 6, 6), this.woodState);
		this.setBlock(world, position.add(4, 6, 7), this.woodState);
		this.setBlock(world, position.add(4, 6, 8), this.woodState);
		this.setBlock(world, position.add(4, 6, 9), this.leafState);
		this.setBlock(world, position.add(4, 7, 6), this.leafState);
		this.setBlock(world, position.add(4, 7, 7), this.leafState);
		this.setBlock(world, position.add(4, 7, 8), this.leafState);
		this.setBlock(world, position.add(4, 8, 7), this.leafState);
		this.setBlock(world, position.add(5, 0, 7), this.woodState);
		this.setBlock(world, position.add(5, 1, 7), this.woodState);
		this.setBlock(world, position.add(5, 2, 7), this.woodState);
		this.setBlock(world, position.add(5, 3, 7), this.woodState);
		this.setBlock(world, position.add(5, 4, 3), this.leafState);
		this.setBlock(world, position.add(5, 4, 4), this.woodState);
		this.setBlock(world, position.add(5, 4, 7), this.woodState);
		this.setBlock(world, position.add(5, 4, 10), this.woodState);
		this.setBlock(world, position.add(5, 4, 11), this.leafState);
		this.setBlock(world, position.add(5, 5, 4), this.leafState);
		this.setBlock(world, position.add(5, 5, 5), this.woodState);
		this.setBlock(world, position.add(5, 5, 6), this.woodState);
		this.setBlock(world, position.add(5, 5, 7), this.woodState);
		this.setBlock(world, position.add(5, 5, 8), this.woodState);
		this.setBlock(world, position.add(5, 5, 9), this.woodState);
		this.setBlock(world, position.add(5, 5, 10), this.leafState);
		this.setBlock(world, position.add(5, 6, 5), this.leafState);
		this.setBlock(world, position.add(5, 6, 6), this.woodState);
		this.setBlock(world, position.add(5, 6, 7), this.woodState);
		this.setBlock(world, position.add(5, 6, 8), this.woodState);
		this.setBlock(world, position.add(5, 6, 9), this.leafState);
		this.setBlock(world, position.add(5, 7, 6), this.leafState);
		this.setBlock(world, position.add(5, 7, 7), this.woodState);
		this.setBlock(world, position.add(5, 7, 8), this.leafState);
		this.setBlock(world, position.add(5, 8, 6), this.leafState);
		this.setBlock(world, position.add(5, 8, 7), this.leafState);
		this.setBlock(world, position.add(5, 8, 8), this.leafState);
		this.setBlock(world, position.add(5, 9, 7), this.leafState);
		this.setBlock(world, position.add(6, 4, 3), this.leafState);
		this.setBlock(world, position.add(6, 4, 4), this.woodState);
		this.setBlock(world, position.add(6, 4, 10), this.woodState);
		this.setBlock(world, position.add(6, 4, 11), this.leafState);
		this.setBlock(world, position.add(6, 5, 4), this.leafState);
		this.setBlock(world, position.add(6, 5, 5), this.woodState);
		this.setBlock(world, position.add(6, 5, 6), this.woodState);
		this.setBlock(world, position.add(6, 5, 7), this.woodState);
		this.setBlock(world, position.add(6, 5, 8), this.woodState);
		this.setBlock(world, position.add(6, 5, 9), this.woodState);
		this.setBlock(world, position.add(6, 5, 10), this.leafState);
		this.setBlock(world, position.add(6, 6, 5), this.leafState);
		this.setBlock(world, position.add(6, 6, 6), this.woodState);
		this.setBlock(world, position.add(6, 6, 7), this.woodState);
		this.setBlock(world, position.add(6, 6, 8), this.woodState);
		this.setBlock(world, position.add(6, 6, 9), this.leafState);
		this.setBlock(world, position.add(6, 7, 6), this.leafState);
		this.setBlock(world, position.add(6, 7, 7), this.leafState);
		this.setBlock(world, position.add(6, 7, 8), this.leafState);
		this.setBlock(world, position.add(6, 8, 7), this.leafState);
		this.setBlock(world, position.add(7, 4, 3), this.leafState);
		this.setBlock(world, position.add(7, 4, 4), this.woodState);
		this.setBlock(world, position.add(7, 4, 10), this.woodState);
		this.setBlock(world, position.add(7, 4, 11), this.leafState);
		this.setBlock(world, position.add(7, 5, 4), this.leafState);
		this.setBlock(world, position.add(7, 5, 5), this.woodState);
		this.setBlock(world, position.add(7, 5, 6), this.woodState);
		this.setBlock(world, position.add(7, 5, 7), this.woodState);
		this.setBlock(world, position.add(7, 5, 8), this.woodState);
		this.setBlock(world, position.add(7, 5, 9), this.woodState);
		this.setBlock(world, position.add(7, 5, 10), this.leafState);
		this.setBlock(world, position.add(7, 6, 5), this.leafState);
		this.setBlock(world, position.add(7, 6, 6), this.leafState);
		this.setBlock(world, position.add(7, 6, 7), this.leafState);
		this.setBlock(world, position.add(7, 6, 8), this.leafState);
		this.setBlock(world, position.add(7, 6, 9), this.leafState);
		this.setBlock(world, position.add(8, 4, 3), this.leafState);
		this.setBlock(world, position.add(8, 4, 4), this.woodState);
		this.setBlock(world, position.add(8, 4, 5), this.woodState);
		this.setBlock(world, position.add(8, 4, 6), this.woodState);
		this.setBlock(world, position.add(8, 4, 7), this.woodState);
		this.setBlock(world, position.add(8, 4, 8), this.woodState);
		this.setBlock(world, position.add(8, 4, 9), this.woodState);
		this.setBlock(world, position.add(8, 4, 10), this.woodState);
		this.setBlock(world, position.add(8, 4, 11), this.leafState);
		this.setBlock(world, position.add(8, 5, 4), this.leafState);
		this.setBlock(world, position.add(8, 5, 5), this.leafState);
		this.setBlock(world, position.add(8, 5, 6), this.leafState);
		this.setBlock(world, position.add(8, 5, 7), this.leafState);
		this.setBlock(world, position.add(8, 5, 8), this.leafState);
		this.setBlock(world, position.add(8, 5, 9), this.leafState);
		this.setBlock(world, position.add(8, 5, 10), this.leafState);
		this.setBlock(world, position.add(9, 4, 3), this.leafState);
		this.setBlock(world, position.add(9, 4, 4), this.leafState);
		this.setBlock(world, position.add(9, 4, 5), this.leafState);
		this.setBlock(world, position.add(9, 4, 6), this.leafState);
		this.setBlock(world, position.add(9, 4, 7), this.leafState);
		this.setBlock(world, position.add(9, 4, 8), this.leafState);
		this.setBlock(world, position.add(9, 4, 9), this.leafState);
		this.setBlock(world, position.add(9, 4, 10), this.leafState);
		this.setBlock(world, position.add(9, 4, 11), this.leafState);
		
		return true;
	}
}