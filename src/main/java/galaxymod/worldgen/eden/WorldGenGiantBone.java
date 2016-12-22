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

package galaxymod.worldgen.eden;

import galaxymod.blocks.BlockList;
import galaxymod.worldgen.NGWorldGenStructureCore;
import galaxymod.worldgen.eden.treasure.TreasureGenEden;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenGiantBone extends NGWorldGenStructureCore implements
		IWorldGenerator {
	protected Block[] getValidSpawnBlocks() {
		return new Block[] { BlockList.edenBloodSand, BlockList.edenBloodStone };
	}
	
	public WorldGenGiantBone() {
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
	}
	
	@Override
	public boolean generate(World world, Random rand, int i, int j, int k) {
		
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