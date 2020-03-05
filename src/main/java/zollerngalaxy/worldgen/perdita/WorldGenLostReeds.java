/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.worldgen.perdita;

import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.blocks.perdita.LostReeds;

public class WorldGenLostReeds extends WorldGenerator {
	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		for (int i = 0; i < 20; ++i) {
			BlockPos blockpos = position.add(rand.nextInt(4) - rand.nextInt(4), 0, rand.nextInt(4) - rand.nextInt(4));
			
			if (worldIn.isAirBlock(blockpos)) {
				BlockPos blockpos1 = blockpos.down();
				
				if (worldIn.getBlockState(blockpos1.west()).getMaterial() == Material.WATER
						|| worldIn.getBlockState(blockpos1.east()).getMaterial() == Material.WATER
						|| worldIn.getBlockState(blockpos1.north()).getMaterial() == Material.WATER
						|| worldIn.getBlockState(blockpos1.south()).getMaterial() == Material.WATER) {
					int j = 2 + rand.nextInt(rand.nextInt(3) + 1);
					
					for (int k = 0; k < j; ++k) {
						if (LostReeds.canReedStay(worldIn, blockpos)) {
							worldIn.setBlockState(blockpos.up(k), ZGBlocks.perdReeds.getDefaultState(), 2);
						}
					}
				}
			}
		}
		
		return true;
	}
}