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
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import zollerngalaxy.blocks.ZGBlocks;

public class WorldGenZGMushroomTree extends WorldGenAbstractTree {
	
	private final int minTreeHeight;
	private final IBlockState blockLog;
	private final IBlockState blockLeaves;
	
	public WorldGenZGMushroomTree(boolean notify, int minTreeHeightIn) {
		super(notify);
		this.minTreeHeight = minTreeHeightIn;
		this.blockLog = ZGBlocks.blockRedshroomStem.getDefaultState();
		this.blockLeaves = ZGBlocks.blockRedshroom.getDefaultState();
	}
	
	@SuppressWarnings("unused")
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		int i = rand.nextInt(3) + this.minTreeHeight;
		boolean flag = true;
		
		if (worldIn.getBlockState(position.down()) == Blocks.AIR.getDefaultState() || worldIn.getBlockState(position.down()) == ZGBlocks.blockRedshroom.getDefaultState()) {
			return false;
		}
		
		if (position.getY() >= 1 && position.getY() + i + 1 <= worldIn.getHeight()) {
			for (int j = position.getY(); j <= position.getY() + 1 + i; ++j) {
				int k = 1;
				
				if (j == position.getY()) {
					k = 0;
				}
				
				if (j >= position.getY() + 1 + i - 2) {
					k = 2;
				}
				
				BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
				
				if (!flag) {
					return false;
				} else {
					IBlockState state = worldIn.getBlockState(position.down());
					state.getBlock().onPlantGrow(state, worldIn, position.down(), position);
					
					int k2 = 3;
					int l2 = 0;
					
					for (int i3 = position.getY() - 3 + i; i3 <= position.getY() + i; ++i3) {
						int i4 = i3 - (position.getY() + i);
						int j1 = 1 - i4 / 2;
						
						for (int k1 = position.getX() - j1; k1 <= position.getX() + j1; ++k1) {
							int l1 = k1 - position.getX();
							
							for (int i2 = position.getZ() - j1; i2 <= position.getZ() + j1; ++i2) {
								int j2 = i2 - position.getZ();
								
								if (Math.abs(l1) != j1 || Math.abs(j2) != j1 || rand.nextInt(2) != 0 && i4 != 0) {
									BlockPos blockpos = new BlockPos(k1, i3, i2);
									state = worldIn.getBlockState(blockpos);
									
									if (state.getBlock().isAir(state, worldIn, blockpos) || state.getBlock() == ZGBlocks.blockRedshroom) {
										this.setBlockAndNotifyAdequately(worldIn, blockpos, this.blockLeaves);
									}
								}
							}
						}
					}
					
					for (int j3 = 0; j3 < i; ++j3) {
						BlockPos upN = position.up(j3);
						state = worldIn.getBlockState(upN);
						
						if (state.getBlock().isAir(state, worldIn, upN) || state.getBlock() == ZGBlocks.blockRedshroomStem) {
							this.setBlockAndNotifyAdequately(worldIn, position.up(j3), this.blockLog);
						}
					}
					return true;
				}
			}
		}
		return flag;
	}
}