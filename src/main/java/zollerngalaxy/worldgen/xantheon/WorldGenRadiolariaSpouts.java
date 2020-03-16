/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.worldgen.xantheon;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.blocks.fluids.ZGFluids;
import zollerngalaxy.worldgen.ZGWorldGenMaster;

public class WorldGenRadiolariaSpouts extends ZGWorldGenMaster {
	
	protected boolean isValidSpawn(World world, BlockPos pos) {
		Block blockBelow = world.getBlockState(pos.down()).getBlock();
		
		if (blockBelow == Blocks.AIR || blockBelow == ZGFluids.blockWhiteLavaFluid) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public boolean generate(World world, Random rand, BlockPos pos) {
		// if (!isValidSpawn(world, pos)) {
		// return false;
		// }
		
		int randTop = (rand.nextInt(6));
		randTop = (randTop == 0) ? 3 : randTop;
		
		for (int s = 0; s < randTop; s++) {
			this.setBlock(world, pos.add(0, s, 0), ZGBlocks.xantheonConstructBlock);
		}
		
		this.setBlock(world, pos.add(0, (randTop + 1), 0), ZGFluids.blockWhiteLavaFluid);
		
		return true;
	}
}