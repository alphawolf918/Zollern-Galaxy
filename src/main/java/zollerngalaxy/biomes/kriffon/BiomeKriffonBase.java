/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.kriffon;

import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.biomes.decorators.BiomeDecoratorKriffon;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.celestial.ZGPlanets;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.dimensions.chunkproviders.ChunkProviderKriffon;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.mobs.entities.robots.sentinels.EntitySentinelDrone;
import zollerngalaxy.mobs.entities.villagers.EntityKriffonVillager;

public abstract class BiomeKriffonBase extends BiomeSpace {
	
	protected static final IBlockState STONE = ZGBlocks.kriffStone.getDefaultState();
	protected static final IBlockState AIR = Blocks.AIR.getDefaultState();
	protected static final IBlockState BEDROCK = Blocks.BEDROCK.getDefaultState();
	protected static final IBlockState MAGMA = ZGBlocks.kriffMagmaRock.getDefaultState();
	protected static final IBlockState DIRT = ZGBlocks.kriffDirt.getDefaultState();
	protected static final IBlockState BLAZE_ROCK = ZGBlocks.blazeRock.getDefaultState();
	protected static final IBlockState LAVA = Blocks.LAVA.getDefaultState();
	
	protected static final int SEA_LEVEL = ChunkProviderKriffon.SEA_LEVEL;
	protected static final int SEA_FLOOR_LEVEL = 36;
	
	public BiomeDecoratorKriffon biomeDecor = this.getBiomeDecorator();
	
	public BiomeKriffonBase(String singleName, BiomeProperties props) {
		super(singleName, props);
		this.setTempCategory(TempCategory.WARM);
		this.biomeDecor.flowersPerChunk = -999;
		this.biomeDecor.treesPerChunk = -999;
		this.biomeDecor.grassPerChunk = -999;
		this.biomeDecor.mushroomsPerChunk = -999;
		if (ConfigManagerZG.enableSentinels) {
			this.spawnableMonsterList.add(new SpawnListEntry(EntitySentinelDrone.class, 10, 1, 2));
		}
		if (ConfigManagerZG.enableAlienVillagerSpawn) {
			this.spawnableCreatureList.add(new SpawnListEntry(EntityKriffonVillager.class, this.villagerSpawnRate, this.villagerMinSpawnRate, this.villagerMaxSpawnRate));
		}
		this.setStoneBlock(ZGBlocks.kriffStone);
		this.setPlanetForBiome(ZGPlanets.planetKriffon);
	}
	
	@Override
	public BiomeDecorator createBiomeDecorator() {
		return new BiomeDecoratorKriffon();
	}
	
	protected BiomeDecoratorKriffon getBiomeDecorator() {
		return (BiomeDecoratorKriffon) this.decorator;
	}
	
	public final void generateKriffonTerrain(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
		int i = worldIn.getSeaLevel();
		float biomeHeight = this.getBiomeHeight();
		IBlockState topState = this.topBlock;
		IBlockState fillState = this.fillerBlock;
		int j = -1;
		int k = (int) (noiseVal / 3.0D + 3.0D + rand.nextDouble() * 0.25D);
		int l = x & 15;
		int i1 = z & 15;
		
		for (int j1 = 255; j1 >= 0; --j1) {
			if (j1 == 0) {
				chunkPrimerIn.setBlockState(i1, j1, l, BEDROCK);
			} else if (j1 >= 128) {
				chunkPrimerIn.setBlockState(i1, j1, l, AIR);
			} else {
				IBlockState iblockstate2 = chunkPrimerIn.getBlockState(i1, j1, l);
				if (this.getBiomeType() == EnumBiomeTypeZG.OCEAN) {
					if ((j1 < SEA_LEVEL) && (j1 > SEA_FLOOR_LEVEL)) {
						chunkPrimerIn.setBlockState(i1, j1, l, LAVA);
					} else if (j1 < SEA_FLOOR_LEVEL) {
						chunkPrimerIn.setBlockState(i1, j1, l, STONE);
					} else if (j1 == SEA_FLOOR_LEVEL) {
						chunkPrimerIn.setBlockState(i1, j1, l, DIRT);
					} else if (j1 >= SEA_LEVEL) {
						chunkPrimerIn.setBlockState(i1, j1, l, AIR);
					}
				} else {
					if (iblockstate2.getMaterial() == Material.AIR) {
						j = -1;
					} else if (iblockstate2.getBlock() == ZGBlocks.kriffStone) {
						if (j == -1) {
							if (k <= 0) {
								topState = AIR;
								fillState = STONE;
							} else if (j1 >= i - 4 && j1 <= i + 1) {
								topState = this.topBlock;
								fillState = this.fillerBlock;
							}
							
							if (j1 < i && (topState == null || topState.getMaterial() == Material.AIR)) {
								topState = (this.getIsColdBiome()) ? BLAZE_ROCK : LAVA;
							}
							
							j = k;
							
							if (j1 >= i - 1) {
								chunkPrimerIn.setBlockState(i1, j1, l, topState);
							} else if (j1 < i - 7 - k) {
								topState = AIR;
								fillState = STONE;
								chunkPrimerIn.setBlockState(i1, j1, l, MAGMA);
							} else {
								chunkPrimerIn.setBlockState(i1, j1, l, fillState);
							}
						} else if (j > 0) {
							--j;
							chunkPrimerIn.setBlockState(i1, j1, l, fillState);
						}
					}
				}
			}
		}
	}
	
	@Override
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
		this.generateKriffonTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
	}
	
	@Override
	public int getModdedBiomeFoliageColor(int original) {
		return this.grassFoliageColor;
	}
	
	@Override
	public int getModdedBiomeGrassColor(int original) {
		return this.grassFoliageColor;
	}
	
}