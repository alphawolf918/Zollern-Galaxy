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

import galaxymod.biomes.BiomeList;
import galaxymod.blocks.BlockList;
import galaxymod.core.config.ConfigManagerZG;
import galaxymod.worldgen.eden.WorldGenCrystalTower;
import galaxymod.worldgen.eden.WorldGenDropShip;
import galaxymod.worldgen.eden.WorldGenGiantBone;
import galaxymod.worldgen.eden.village.VillageHouseOne;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraft.world.gen.feature.WorldGenerator;
import cpw.mods.fml.common.IWorldGenerator;

public class NGWorldGenManager implements IWorldGenerator {
	
	public static BiomeGenBase currentBiome;
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		if (world.provider.dimensionId == 0) {
			this.generateEarth(world, random, chunkX * 16, chunkZ * 16);
		} else if (world.provider.dimensionId == ConfigManagerZG.planetEdenDimensionId) {
			this.generateEden(world, random, chunkX * 16, chunkZ * 16);
		}
	}
	
	private void generateEarth(World world, Random random, int x, int z) {
		
	}
	
	private void generateEden(World world, Random random, int x, int z) {
		
		// Grab Biome
		currentBiome = world.getBiomeGenForCoords(x, z);
		
		// Current Layer
		int y = world.getHeightValue(x, z);
		
		// Drop Ship
		if (random.nextInt(120) <= 5) {
			this.spawnStructure(62, 80, world, random, x, y, z,
					new WorldGenDropShip());
		}
		
		// Crystal Tower
		if (random.nextInt(60) <= 10) {
			if (currentBiome == BiomeList.biomeEden
					|| currentBiome == BiomeList.biomeEdenTerranValley) {
				this.spawnStructure(36, 94, world, random, x, y, z,
						new WorldGenCrystalTower());
			}
		}
		
		// Outpost
		if (random.nextInt(100) <= 20) {
			this.spawnStructure(26, 50, world, random, x, y, z,
					new WorldGenOutpost());
		}
		
		// Eden's Flowers
		if (random.nextInt(4) == 1) {
			if (currentBiome == BiomeList.biomeEden
					|| currentBiome == BiomeList.biomeEdenTerranValley
					|| currentBiome == BiomeList.biomeEdenForest
					|| currentBiome == BiomeList.biomeEdenGarden
					|| currentBiome == BiomeList.biomeEdenSwamp
					|| currentBiome == BiomeList.biomeEdenSnowyPlains) {
				Block flowerBlock;
				Random r = new Random();
				int flowerType = r.nextInt(7);
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
					case 7:
						flowerBlock = BlockList.edenFlowerGreen;
					break;
				}
				this.spawnStructure(14, 18, world, random, x, y, z,
						new WorldGenFlowers(flowerBlock));
			}
		}
		
		// Eden Village
		if (random.nextInt(280) <= 10) {
			this.spawnStructure(5, 280, world, random, x, y, z,
					new VillageHouseOne());
		}
		
		if (currentBiome == BiomeList.biomeEdenBloodDesert) {
			this.spawnStructure(14, 19, world, random, x, y, z,
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
}