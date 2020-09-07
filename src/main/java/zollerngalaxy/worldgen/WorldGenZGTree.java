/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.worldgen;

import java.util.Random;
import net.minecraft.block.BlockVine;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import zollerngalaxy.blocks.ZGBlockDirt;
import zollerngalaxy.blocks.ZGBlockGrass;

public class WorldGenZGTree extends WorldGenAbstractTree {
	
	private final int minTreeHeight;
	private final boolean vinesGrow;
	private final IBlockState blockLog;
	private final IBlockState blockLeaves;
	
	public WorldGenZGTree(boolean notify, int minTreeHeightIn, IBlockState blockStateLog, IBlockState blockLeavesState, boolean growVines) {
		super(notify);
		this.minTreeHeight = minTreeHeightIn;
		this.blockLog = blockStateLog;
		this.blockLeaves = blockLeavesState;
		this.vinesGrow = growVines;
	}
	
	@SuppressWarnings("unused")
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		int i = rand.nextInt(3) + this.minTreeHeight;
		boolean flag = true;
		
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
					
					if (state.getBlock() instanceof ZGBlockGrass || state.getBlock() instanceof ZGBlockDirt) {
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
										
										if (state.getBlock().isAir(state, worldIn, blockpos)
												|| state.getBlock().isLeaves(state, worldIn, blockpos)
												|| state.getMaterial() == Material.VINE) {
											this.setBlockAndNotifyAdequately(worldIn, blockpos, this.blockLeaves);
										}
									}
								}
							}
						}
						
						for (int j3 = 0; j3 < i; ++j3) {
							BlockPos upN = position.up(j3);
							state = worldIn.getBlockState(upN);
							
							if (state.getBlock().isAir(state, worldIn, upN) || state.getBlock().isLeaves(state, worldIn, upN)
									|| state.getMaterial() == Material.VINE) {
								this.setBlockAndNotifyAdequately(worldIn, position.up(j3), this.blockLog);
								
								if (this.vinesGrow && j3 > 0) {
									if (rand.nextInt(3) > 0 && worldIn.isAirBlock(position.add(-1, j3, 0))) {
										this.addVine(worldIn, position.add(-1, j3, 0), BlockVine.EAST);
									}
									
									if (rand.nextInt(3) > 0 && worldIn.isAirBlock(position.add(1, j3, 0))) {
										this.addVine(worldIn, position.add(1, j3, 0), BlockVine.WEST);
									}
									
									if (rand.nextInt(3) > 0 && worldIn.isAirBlock(position.add(0, j3, -1))) {
										this.addVine(worldIn, position.add(0, j3, -1), BlockVine.SOUTH);
									}
									
									if (rand.nextInt(3) > 0 && worldIn.isAirBlock(position.add(0, j3, 1))) {
										this.addVine(worldIn, position.add(0, j3, 1), BlockVine.NORTH);
									}
								}
							}
						}
						
						// if (rand.nextInt(3) == 0 && i > 4) {
						// for (int l3 = 0; l3 < 2; ++l3) {
						// for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL) {
						// if (rand.nextInt(8 - l3) == 0) {
						// EnumFacing enumfacing1 = enumfacing.getOpposite();
						// this.placeFruit(
						// worldIn,
						// rand.nextInt(3),
						// position.add(enumfacing1.getFrontOffsetX(), i - 5 + l3,
						// enumfacing1.getFrontOffsetZ()), enumfacing);
						// }
						// }
						// }
						// }
						
						return true;
					} else {
						return false;
					}
				}
			}
		} else {
			return false;
		}
		return flag;
	}
	
	private void placeFruit(World worldIn, int p_181652_2_, BlockPos pos, EnumFacing side) {
		// this.setBlockAndNotifyAdequately(
		// worldIn,
		// pos,
		// ZGBlocks.edenFruit.getDefaultState().withProperty(EdenFruit.AGE,
		// Integer.valueOf(p_181652_2_))
		// .withProperty(EdenFruit.FACING, side));
		// TODO: Peaches?
	}
	
	private void addVine(World worldIn, BlockPos pos, PropertyBool prop) {
		this.setBlockAndNotifyAdequately(worldIn, pos, Blocks.VINE.getDefaultState().withProperty(prop, Boolean.valueOf(true)));
	}
	
	private void addHangingVine(World worldIn, BlockPos pos, PropertyBool prop) {
		this.addVine(worldIn, pos, prop);
		int i = 4;
		
		for (BlockPos blockpos = pos.down(); worldIn.isAirBlock(blockpos) && i > 0; --i) {
			this.addVine(worldIn, blockpos, prop);
			blockpos = blockpos.down();
		}
	}
}