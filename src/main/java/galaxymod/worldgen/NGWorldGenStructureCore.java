/*******************************************************************************
 * Copyright 2016 Zollern Wolf
 * - Zollern Galaxy
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 * Steve Kung's "More Planets" mod was a big help.
 *******************************************************************************/

package galaxymod.worldgen;

import galaxymod.blocks.BlockList;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public abstract class NGWorldGenStructureCore extends WorldGenerator {
	
	protected Block[] GetValidSpawnBlocks() {
		return new Block[] { BlockList.edenSurfaceRock, BlockList.edenRock,
				BlockList.edenBloodSand, BlockList.edenBloodStone,
				BlockList.edenSoil, BlockList.edenCobbleRock,
				BlockList.edenGrass, BlockList.edenWinterRock,
				BlockList.edenMagmaRock, BlockList.edenWinterRock,
				BlockList.edenGoldenGrass };
	}
	
	public boolean LocationIsValidSpawn(World world, int i, int j, int k) {
		int distanceToAir = 0;
		Block checkID = world.getBlock(i, j, k);
		
		while (checkID != Blocks.air) {
			distanceToAir++;
			checkID = world.getBlock(i, j + distanceToAir, k);
		}
		
		if (distanceToAir > 3) {
			return false;
		}
		j += distanceToAir - 1;
		
		Block blockID = world.getBlock(i, j, k);
		Block blockIDAbove = world.getBlock(i, j + 1, k);
		Block blockIDBelow = world.getBlock(i, j - 1, k);
		for (Block x : GetValidSpawnBlocks()) {
			if (blockIDAbove != Blocks.air) {
				return false;
			}
			if (blockID == x) {
				return true;
			} else if (blockID == BlockList.edenRock && blockIDBelow == x) {
				return true;
			}
		}
		return false;
	}
	
	public void setBlock(World world, int x, int y, int z, Block block,
			int metadata) {
		Block b1 = world.getBlock(x, y, z);
		
		if (b1.isAir(world, x, y, z) || b1.isLeaves(world, x, y, z)) {
			world.setBlock(x, y, z, block, metadata, metadata);
		}
	}
	
	@Override
	public boolean generate(World world, Random rand, int i, int j, int k) {
		if (world.getBlock(i, j - 1, k) == Blocks.air) {
			return false;
		}
		return true;
	}
}