/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.worldgen;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zollerngalaxy.blocks.crystals.ZGCrystalBlock;

public class WorldGenZGCrystals extends ZGWorldGenMaster {
	
	private IBlockState crystal;
	private Block crystalBlock;
	private int maxHeightForGen = 128;
	
	public WorldGenZGCrystals(IBlockState crystal) {
		this.crystal = crystal;
		this.crystalBlock = crystal.getBlock();
	}
	
	public WorldGenZGCrystals(IBlockState crystal, int maxHeight) {
		this(crystal);
		this.maxHeightForGen = maxHeight;
	}
	
	@Override
	public boolean generate(World world, Random rand, BlockPos pos) {
		for (int i = 0; i < 128; ++i) {
			BlockPos pos1 = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
			
			if (world.isAirBlock(pos1) && (pos1.getY() < maxHeightForGen) && ((ZGCrystalBlock) this.crystalBlock).canBlockStay(world, pos1, this.crystal)) {
				world.setBlockState(pos1, this.crystal, 2 & 1);
			}
		}
		
		return true;
	}
}