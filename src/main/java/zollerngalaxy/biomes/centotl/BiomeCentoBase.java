/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.centotl;

import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.biomes.decorators.BiomeDecoratorCentotl;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.celestial.ZGPlanets;
import zollerngalaxy.compat.AvPCompat;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.dimensions.chunkproviders.ChunkProviderCentotl;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.lib.helpers.ModHelperBase;
import zollerngalaxy.mobs.entities.EntityFacehugger;
import zollerngalaxy.mobs.entities.EntityXenomorph;
import zollerngalaxy.mobs.entities.robots.sentinels.EntitySentinelDrone;
import zollerngalaxy.mobs.entities.villagers.EntityCentotlVillager;

public class BiomeCentoBase extends BiomeSpace {
	
	protected static final IBlockState STONE = ZGBlocks.centoStone.getDefaultState();
	protected static final IBlockState AIR = Blocks.AIR.getDefaultState();
	protected static final IBlockState BEDROCK = Blocks.BEDROCK.getDefaultState();
	protected static final IBlockState GRAVEL = ZGBlocks.centoGravel.getDefaultState();
	protected static final IBlockState DIRT = ZGBlocks.centoDirt.getDefaultState();
	protected static final IBlockState CONSTRUCT_BLOCK = ZGBlocks.xantheonConstructBlock.getDefaultState();
	
	protected static final int SEA_LEVEL = ChunkProviderCentotl.SEA_LEVEL;
	protected static final int SEA_FLOOR_LEVEL = (SEA_LEVEL - 21);
	
	public BiomeDecoratorCentotl biomeDecor = this.getBiomeDecorator();
	
	public BiomeCentoBase(String singleName, BiomeProperties props) {
		super(singleName, props);
		this.setTempCategory(TempCategory.WARM);
		this.setTemp(8.42F);
		this.clearAllSpawning();
		if (ConfigManagerZG.enableSentinels) {
			this.spawnableMonsterList.add(new SpawnListEntry(EntitySentinelDrone.class, 10, 1, 2));
		}
		this.spawnableMonsterList.add(new SpawnListEntry(EntityFacehugger.class, 4, 1, 1));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityXenomorph.class, 2, 1, 1));
		if (ConfigManagerZG.enableAlienVillagerSpawn) {
			this.spawnableCreatureList.add(new SpawnListEntry(EntityCentotlVillager.class, this.villagerSpawnRate, this.villagerMinSpawnRate, this.villagerMaxSpawnRate));
		}
		if (ModHelperBase.useAvP && ConfigManagerZG.enableAvPCompat) {
			AvPCompat.addAvPSpawns(this);
		}
		this.setBodyForBiome(ZGPlanets.planetCentotl);
	}
	
	public final void generateCentotlTerrain(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
		int i = worldIn.getSeaLevel();
		float biomeHeight = this.getBiomeHeight();
		IBlockState topState = this.topBlock;
		IBlockState fillState = this.fillerBlock;
		int j = -1;
		int k = (int) (noiseVal / 2.0D + 2.5D + rand.nextDouble() * 0.35D);
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
						chunkPrimerIn.setBlockState(i1, j1, l, CONSTRUCT_BLOCK);
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
					} else if (iblockstate2 == STONE) {
						if (j == -1) {
							if (k <= 0) {
								topState = AIR;
								fillState = STONE;
							} else if (j1 >= i - 4 && j1 <= i + 1) {
								topState = this.topBlock;
								fillState = this.fillerBlock;
							}
							
							if (j1 < i && (topState == null || topState.getMaterial() == Material.AIR)) {
								topState = CONSTRUCT_BLOCK;
							}
							
							j = k;
							
							if (j1 >= i - 1) {
								chunkPrimerIn.setBlockState(i1, j1, l, topState);
							} else if (j1 < i - 7 - k) {
								topState = AIR;
								fillState = STONE;
								chunkPrimerIn.setBlockState(i1, j1, l, GRAVEL);
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
		this.generateCentotlTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
	}
	
	@Override
	public float getSpawningChance() {
		return 0.1F;
	}
	
	@Override
	public BiomeDecorator createBiomeDecorator() {
		return new BiomeDecoratorCentotl();
	}
	
	protected BiomeDecoratorCentotl getBiomeDecorator() {
		return (BiomeDecoratorCentotl) this.decorator;
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