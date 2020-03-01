/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.worldgen.perdita;

import java.util.Random;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.blocks.perdita.LostCactus;

public class WorldGenLostCactus extends WorldGenerator {
	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		for (int i = 0; i < 10; ++i) {
			BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4),
					rand.nextInt(8) - rand.nextInt(8));
			
			if (worldIn.isAirBlock(blockpos)) {
				int j = 1 + rand.nextInt(rand.nextInt(3) + 1);
				
				for (int k = 0; k < j; ++k) {
					if (LostCactus.canBlockStay(worldIn, blockpos)) {
						worldIn.setBlockState(blockpos.up(k), ZGBlocks.perdCactus.getDefaultState(), 2);
					}
				}
			}
		}
		
		return true;
	}
}