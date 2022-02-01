/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.oasis;

import java.util.Random;
import cofh.thermalfoundation.init.TFFluids;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.biomes.decorators.BiomeDecoratorOasis;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.celestial.ZGPlanets;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.dimensions.chunkproviders.ChunkProviderOasis;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.lib.helpers.ModHelperBase;
import zollerngalaxy.mobs.entities.villagers.EntityOasisVillager;

public abstract class BiomeOasisBase extends BiomeSpace {
	
	protected static final IBlockState STONE = ZGBlocks.oasisStone.getDefaultState();
	protected static final IBlockState AIR = Blocks.AIR.getDefaultState();
	protected static final IBlockState BEDROCK = Blocks.BEDROCK.getDefaultState();
	protected static final IBlockState GRAVEL = ZGBlocks.oasisGravel.getDefaultState();
	protected static final IBlockState DIRT = ZGBlocks.oasisDirt.getDefaultState();
	protected static final IBlockState ICE = Blocks.ICE.getDefaultState();
	protected static final IBlockState WATER = Blocks.WATER.getDefaultState();
	
	protected static final int SEA_LEVEL = ChunkProviderOasis.SEA_LEVEL;
	protected static final int SEA_FLOOR_LEVEL = (SEA_LEVEL - 21);
	
	protected boolean shouldUseRedstone = (ModHelperBase.useThermalFoundation && ConfigManagerZG.shouldOasisUseLiquidRedstone);
	
	public BiomeDecoratorOasis biomeDecor = this.getBiomeDecorator();
	
	public BiomeOasisBase(String singleName, BiomeProperties props) {
		super(singleName, props);
		this.setTempCategory(TempCategory.MEDIUM);
		if (ConfigManagerZG.enableAlienVillagerSpawn) {
			this.spawnableCreatureList.add(new SpawnListEntry(EntityOasisVillager.class, this.villagerSpawnRate, this.villagerMinSpawnRate, this.villagerMaxSpawnRate));
		}
		this.setStoneBlock(ZGBlocks.oasisStone);
		this.setPlanetForBiome(ZGPlanets.planetOasis);
	}
	
	@Override
	public BiomeDecorator createBiomeDecorator() {
		return new BiomeDecoratorOasis();
	}
	
	protected BiomeDecoratorOasis getBiomeDecorator() {
		return (BiomeDecoratorOasis) this.decorator;
	}
	
	public final void generateOasisTerrain(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
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
					// int seaLevelMod = (SEA_LEVEL + 4);
					if ((j1 < SEA_LEVEL) && (j1 > SEA_FLOOR_LEVEL)) {
						IBlockState blockToUse = (shouldUseRedstone) ? TFFluids.blockFluidRedstone.getDefaultState() : WATER;
						chunkPrimerIn.setBlockState(i1, j1, l, blockToUse);
					} else if (j1 >= SEA_LEVEL) {
						chunkPrimerIn.setBlockState(i1, j1, l, AIR);
					}
				}
				if (iblockstate2.getMaterial() == Material.AIR) {
					j = -1;
				} else if (iblockstate2.getBlock() == STONE.getBlock()) {
					if (j == -1) {
						if (k <= 0) {
							topState = AIR;
							fillState = STONE;
						} else if (j1 >= i - 4 && j1 <= i + 1) {
							topState = this.topBlock;
							fillState = this.fillerBlock;
						}
						
						if (j1 < i && (topState == null || topState.getMaterial() == Material.AIR)) {
							topState = (this.getIsColdBiome()) ? ICE : WATER;
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
				if ((this.getBiomeType() == EnumBiomeTypeZG.OCEAN) && (j1 >= (SEA_LEVEL + 0)) && (chunkPrimerIn.getBlockState(i1, j1, l).getBlock() != WATER)) {
					chunkPrimerIn.setBlockState(i1, j1, l, AIR);
				}
			}
		}
	}
	
	@Override
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
		this.generateOasisTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
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