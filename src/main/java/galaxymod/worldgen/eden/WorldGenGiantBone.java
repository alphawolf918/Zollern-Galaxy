/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic
 * Final Frontier
 * Galacticraft Add-On Mod
 * You CAN:
 * 	- Learn from it
 *  - Use it to get ideas and concepts
 * You CAN'T:
 *  - Redistribute it
 *  - Claim it as your own
 ******************************************************************************/

package galaxymod.worldgen.eden;

import galaxymod.blocks.BlockList;
import galaxymod.worldgen.eden.treasure.TreasureGenEden;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenGiantBone extends WorldGenerator implements
		IWorldGenerator {
	protected Block[] getValidSpawnBlocks() {
		return new Block[] { BlockList.edenBloodSand };
	}

	public boolean locationIsValidSpawn(World world, int i, int j, int k) {
		int distanceToAir = 0;
		Block check = world.getBlock(i, j, k);

		while (check != Blocks.air) {
			if (distanceToAir > 3) {
				return false;
			}

			distanceToAir++;
			check = world.getBlock(i, j + distanceToAir, k);
		}

		j += distanceToAir - 1;

		Block block = world.getBlock(i, j, k);
		Block blockAbove = world.getBlock(i, j + 1, k);
		Block blockBelow = world.getBlock(i, j - 1, k);

		for (Block x : getValidSpawnBlocks()) {
			if (blockAbove != Blocks.air) {
				return false;
			}
			if (block == x) {
				return true;
			} else if (block == Blocks.snow && blockBelow == x) {
				return true;
			}
		}

		return false;
	}

	public WorldGenGiantBone() {
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
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

		if (((new Random()).nextInt(100)) <= 35) {
			TreasureGenEden.addChest(i, j - 1, k, rand, world);
		}

		this.setBlock(world, i, j, k, BlockList.edenBoneStone, 0);
		this.setBlock(world, i, j + 1, k, BlockList.edenBoneStone, 0);
		this.setBlock(world, i, j + 2, k, BlockList.edenBoneStone, 0);
		this.setBlock(world, i, j + 3, k, BlockList.edenBoneStone, 0);
		this.setBlock(world, i, j + 4, k, BlockList.edenBoneStone, 0);

		this.setBlock(world, i + 1, j + 4, k, BlockList.edenBoneStone, 0);
		this.setBlock(world, i + 1, j + 5, k, BlockList.edenBoneStone, 0);
		this.setBlock(world, i + 1, j + 6, k, BlockList.edenBoneStone, 0);
		this.setBlock(world, i + 2, j + 6, k, BlockList.edenBoneStone, 0);
		this.setBlock(world, i + 3, j + 6, k, BlockList.edenBoneStone, 0);
		this.setBlock(world, i + 3, j + 7, k, BlockList.edenBoneStone, 0);
		this.setBlock(world, i + 3, j + 8, k, BlockList.edenBoneStone, 0);

		this.setBlock(world, i + 1, j + 7, k, BlockList.edenBoneStone, 0);
		this.setBlock(world, i + 1, j + 8, k, BlockList.edenBoneStone, 0);
		this.setBlock(world, i - 1, j + 4, k, BlockList.edenBoneStone, 0);
		this.setBlock(world, i - 1, j + 5, k, BlockList.edenBoneStone, 0);
		this.setBlock(world, i - 1, j + 6, k, BlockList.edenBoneStone, 0);
		this.setBlock(world, i - 2, j + 6, k, BlockList.edenBoneStone, 0);
		this.setBlock(world, i - 3, j + 6, k, BlockList.edenBoneStone, 0);
		this.setBlock(world, i - 3, j + 7, k, BlockList.edenBoneStone, 0);
		this.setBlock(world, i - 3, j + 8, k, BlockList.edenBoneStone, 0);

		this.setBlock(world, i - 1, j + 7, k, BlockList.edenBoneStone, 0);
		this.setBlock(world, i - 1, j + 8, k, BlockList.edenBoneStone, 0);

		return true;
	}
}