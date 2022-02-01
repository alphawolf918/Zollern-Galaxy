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
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zollerngalaxy.blocks.ZGBlockDirt;

public class WorldGenClayZG extends ZGWorldGenMaster {
	
	private final Block block;
	private final int numberOfBlocks;
	
	public WorldGenClayZG(Block clayBlockIn, int numBlocksIn) {
		this.numberOfBlocks = numBlocksIn;
		this.block = clayBlockIn;
	}
	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		if (worldIn.getBlockState(position).getMaterial() != Material.WATER) {
			return false;
		} else {
			int i = rand.nextInt(this.numberOfBlocks - 2) + 2;
			int j = 1;
			
			for (int k = position.getX() - i; k <= position.getX() + i; ++k) {
				for (int l = position.getZ() - i; l <= position.getZ() + i; ++l) {
					int i1 = k - position.getX();
					int j1 = l - position.getZ();
					
					if (i1 * i1 + j1 * j1 <= i * i) {
						for (int k1 = position.getY() - 1; k1 <= position.getY() + 1; ++k1) {
							BlockPos blockpos = new BlockPos(k, k1, l);
							Block blockSt = worldIn.getBlockState(blockpos).getBlock();
							
							if (blockSt instanceof ZGBlockDirt || blockSt == this.block) {
								worldIn.setBlockState(blockpos, this.block.getDefaultState(), 2);
							}
						}
					}
				}
			}
			return true;
		}
	}
}