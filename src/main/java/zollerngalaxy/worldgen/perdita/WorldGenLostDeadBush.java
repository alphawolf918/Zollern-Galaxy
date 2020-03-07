/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.worldgen.perdita;

import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.blocks.perdita.ZGDeadBush;
import zollerngalaxy.worldgen.ZGWorldGenMaster;

public class WorldGenLostDeadBush extends ZGWorldGenMaster {
	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		for (IBlockState iblockstate = worldIn.getBlockState(position); (iblockstate.getBlock().isAir(iblockstate, worldIn, position) || iblockstate
				.getBlock().isLeaves(iblockstate, worldIn, position)) && position.getY() > 0; iblockstate = worldIn.getBlockState(position)) {
			position = position.down();
		}
		
		for (int i = 0; i < 4; ++i) {
			BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4),
					rand.nextInt(8) - rand.nextInt(8));
			
			if (worldIn.isAirBlock(blockpos) && ZGDeadBush.canBushStay(worldIn, blockpos, ZGBlocks.perdDeadBush.getDefaultState())) {
				worldIn.setBlockState(blockpos, ZGBlocks.perdDeadBush.getDefaultState(), 2);
			}
		}
		
		return true;
	}
}