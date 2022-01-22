/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.worldgen.kronos;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockNetherWart;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zollerngalaxy.worldgen.ZGWorldGenMaster;

public class WorldGenNetherWarts extends ZGWorldGenMaster {
	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		for (int i = 0; i < 64; ++i) {
			BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
			
			IBlockState blockState = worldIn.getBlockState(blockpos.down());
			Block block = blockState.getBlock();
			
			if (worldIn.isAirBlock(blockpos)) {
				if (block == Blocks.SOUL_SAND) {
					worldIn.setBlockState(blockpos, Blocks.NETHER_WART.getDefaultState().withProperty(BlockNetherWart.AGE, rand.nextInt(3)));
				}
			}
		}
		
		return true;
	}
}