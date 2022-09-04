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
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenGlowBlocksZG2 extends WorldGenerator {
	
	private Block glowBlock;
	private Block caveBlock;
	
	public WorldGenGlowBlocksZG2(Block glowBlockIn, Block caveBlockIn) {
		this.glowBlock = glowBlockIn;
		this.caveBlock = caveBlockIn;
	}
	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		if (!worldIn.isAirBlock(position)) {
			return false;
		} else if (worldIn.getBlockState(position.up()).getBlock() != this.caveBlock) {
			return false;
		} else {
			worldIn.setBlockState(position, this.glowBlock.getDefaultState(), 2);
			
			for (int i = 0; i < 1500; ++i) {
				BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), -rand.nextInt(12), rand.nextInt(8) - rand.nextInt(8));
				
				if (worldIn.isAirBlock(blockpos)) {
					int j = 0;
					
					for (EnumFacing enumfacing : EnumFacing.values()) {
						if (worldIn.getBlockState(blockpos.offset(enumfacing)).getBlock() == this.glowBlock) {
							++j;
						}
						
						if (j > 1) {
							break;
						}
					}
					
					if (j == 1) {
						worldIn.setBlockState(blockpos, this.glowBlock.getDefaultState(), 2);
					}
				}
			}
			
			return true;
		}
	}
}