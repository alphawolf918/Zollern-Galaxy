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

import galaxymod.biomes.BiomeList;
import galaxymod.blocks.BlockList;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;
import cpw.mods.fml.common.IWorldGenerator;

public class NGWorldGenManager implements IWorldGenerator {

	public static BiomeGenBase currentBiome;

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
		case 0:
			generateEarth(world, random, chunkX * 16, chunkZ * 16);
			break;
		case -31:
			generateZollus(world, random, chunkX * 16, chunkZ * 16);
			break;
		case -32:
			generateEden(world, random, chunkX * 16, chunkZ * 16);
			break;
		}
	}

	private void generateEarth(World world, Random random, int x, int z) {

	}

	private void generateZollus(World world, Random random, int x, int z) {

	}

	private void generateEden(World world, Random random, int x, int z) {

		// Grab Biome
		currentBiome = world.getBiomeGenForCoords(x, z);

		// Current Layer
		int y = world.getHeightValue(x, z);

		// Iron Ore
		addEdenOreSpawn(BlockList.edenIronOre, world, random, x, z, 16, 16,
				4 + random.nextInt(6), 15, 4, 52);

		// Meteoric Iron Ore
		addEdenOreSpawn(BlockList.edenMeteoricIronOre, world, random, x, z, 16,
				16, 2 + random.nextInt(2), 15, 4, 32);

		// Gold Ore
		addEdenOreSpawn(BlockList.edenGoldOre, world, random, x, z, 16, 16,
				4 + random.nextInt(2), 10, 4, 32);

		// Desh Ore
		addEdenOreSpawn(BlockList.edenDeshOre, world, random, x, z, 16, 16,
				4 + random.nextInt(6), 10, 4, 42);

		// Copper Ore
		addEdenOreSpawn(BlockList.edenCopperOre, world, random, x, z, 16, 16,
				4 + random.nextInt(4), 18, 4, 62);

		// Tin Ore
		addEdenOreSpawn(BlockList.edenTinOre, world, random, x, z, 16, 16,
				4 + random.nextInt(10), 25, 4, 64);

		// Coal Ore
		addEdenOreSpawn(BlockList.edenCoalOre, world, random, x, z, 16, 16,
				6 + random.nextInt(10), 16, 4, 52);

		// Diamond Ore
		addEdenOreSpawn(BlockList.edenDiamondOre, world, random, x, z, 16, 16,
				2 + random.nextInt(2), 5, 4, 16);

		// Emerald Ore
		addEdenOreSpawn(BlockList.edenEmeraldOre, world, random, x, z, 16, 16,
				1 + random.nextInt(1), 4, 4, 22);

		// Drop Ship
		if (random.nextInt(50) <= 4 && y <= 32) {
			this.spawnStructure(22, 80, world, random, x, y, z,
					new WorldGenDropShip());
		}

		// Crystal Tower
		if (random.nextInt(50) <= 10) {
			if (currentBiome == BiomeList.biomeEden
					|| currentBiome == BiomeList.biomeEdenTerranValley) {
				this.spawnStructure(52, 90, world, random, x, y, z,
						new WorldGenCrystalTower());
			}
		}

		if (random.nextInt(2) == 1) {
			if (currentBiome == BiomeList.biomeEden
					|| currentBiome == BiomeList.biomeEdenTerranValley) {
				Block flowerBlock;
				Random r = new Random();
				int flowerType = r.nextInt(5);
				switch (flowerType) {
				default:
				case 0:
					flowerBlock = BlockList.edenFlower;
					break;
				case 1:
					flowerBlock = BlockList.edenFlowerBlue;
					break;
				case 2:
					flowerBlock = BlockList.edenFlowerCyan;
					break;
				case 3:
					flowerBlock = BlockList.edenFlowerOrange;
					break;
				case 4:
					flowerBlock = BlockList.edenFlowerPurple;
					break;
				case 5:
					flowerBlock = BlockList.edenFlowerRed;
					break;
				case 6:
					flowerBlock = BlockList.edenFlowerYellow;
					break;
				}
				this.spawnStructure(16, 17, world, random, x, y, z,
						new WorldGenFlowers(flowerBlock));
			}
		}

		if (currentBiome == BiomeList.biomeEden
				|| currentBiome == BiomeList.biomeEdenTerranValley) {
			this.spawnStructure(16, 17, world, random, x, y, z,
					new WorldGenTallGrass(BlockList.edenTallGrass, 0));
		}

		if (currentBiome == BiomeList.biomeEdenBloodDesert) {
			this.spawnStructure(16, 17, world, random, x, y, z,
					new WorldGenGiantBone());
		}
	}

	/**
	 * Spawns a structure in the world
	 *
	 * @author Zollern Wolf
	 * @param minChance
	 *            The minimum chance that the structure has to spawn.
	 * @param maxChance
	 *            The maximum chance that the structure has to spawn.
	 * @param world
	 *            The world for the structure to spawn in.
	 * @param random
	 *            Needed for randomization and comparison.
	 * @param x
	 *            The X coordinate to spawn in at.
	 * @param y
	 *            The Y coordinate to spawn in at.
	 * @param z
	 * @param wg
	 *            The structure.
	 */
	public static void spawnStructure(int minChance, int maxChance,
			World world, Random random, int x, int y, int z, WorldGenerator wg) {
		if (random.nextInt(maxChance) == minChance) {
			wg.generate(world, random, x, y, z);
		}
	}

	public void addEdenOreSpawn(Block block, World world, Random random,
			int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize,
			int chancesToSpawn, int minY, int maxY) {
		int maxPossY = minY + maxY - 1;
		assert maxY > minY : "The maximum Y must be greater than the Minimum Y";
		assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";
		assert minY > 0 : "addOreSpawn: The Minimum Y must be greater than 0";
		assert maxY < 256 && maxY > 0 : "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";
		assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";

		int diffBtwnMinMaxY = maxY - minY;
		for (int x = 0; x < chancesToSpawn; x++) {
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(diffBtwnMinMaxY);
			int posZ = blockZPos + random.nextInt(maxZ);
			new WorldGenMinableEden(block, maxVeinSize).generate(world, random,
					posX, posY, posZ);
		}
	}

}