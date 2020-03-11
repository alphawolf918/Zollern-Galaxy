/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.altum;

import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.biomes.decorators.BiomeDecoratorAltum;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.dimensions.chunkproviders.ChunkProviderAltum;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.mobs.entities.EntityBlubberFish;
import zollerngalaxy.mobs.entities.EntitySquidlus;
import zollerngalaxy.planets.ZGPlanets;

public class BiomeAltumBase extends BiomeSpace {
	
	protected static final IBlockState STONE = ZGBlocks.altumStone.getDefaultState();
	protected static final IBlockState AIR = Blocks.AIR.getDefaultState();
	protected static final IBlockState BEDROCK = Blocks.BEDROCK.getDefaultState();
	protected static final IBlockState GRAVEL = ZGBlocks.altumGravel.getDefaultState();
	protected static final IBlockState DIRT = ZGBlocks.altumDirt.getDefaultState();
	protected static final IBlockState ICE = Blocks.ICE.getDefaultState();
	protected static final IBlockState WATER = Blocks.WATER.getDefaultState();
	
	protected static final int SEA_LEVEL = ChunkProviderAltum.SEA_LEVEL;
	protected static final int SEA_FLOOR_LEVEL = 42;
	
	public BiomeDecoratorAltum biomeDecor = this.getBiomeDecorator();
	
	public BiomeAltumBase(String singleName, BiomeProperties props) {
		super(singleName, props);
		this.setTempCategory(TempCategory.MEDIUM);
		this.setBiomeHeight(45);
		this.setTemp(84.23F);
		this.spawnableWaterCreatureList.add(new SpawnListEntry(EntitySquid.class, 10, 1, 4));
		this.spawnableWaterCreatureList.add(new SpawnListEntry(EntitySquidlus.class, 10, 1, 4));
		this.spawnableWaterCreatureList.add(new SpawnListEntry(EntityBlubberFish.class, 10, 2, 8));
		this.waterColor = 0x00008b;
		this.setPlanetForBiome(ZGPlanets.planetAltum);
	}
	
	public final void generateAltumTerrain(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
		int i = worldIn.getSeaLevel();
		float biomeHeight = this.getBiomeHeight();
		IBlockState topState = this.topBlock;
		IBlockState fillState = this.fillerBlock;
		int j = -1;
		int k = (int) (noiseVal / 3.0D + 3.0D + rand.nextDouble() * 0.25D);
		int x2 = x & 15;
		int z2 = z & 15;
		
		for (int y = 255; y >= 0; --y) {
			if (y == 0) {
				chunkPrimerIn.setBlockState(z2, y, x2, BEDROCK);
			} else {
				IBlockState iblockstate2 = chunkPrimerIn.getBlockState(z2, y, x2);
				if (this.getBiomeType() == EnumBiomeTypeZG.OCEAN) {
					if ((y < SEA_LEVEL) && (y > SEA_FLOOR_LEVEL)) {
						chunkPrimerIn.setBlockState(z2, y, x2, WATER);
					} else if (y < SEA_FLOOR_LEVEL) {
						chunkPrimerIn.setBlockState(z2, y, x2, STONE);
					} else if (y == SEA_FLOOR_LEVEL) {
						chunkPrimerIn.setBlockState(z2, y, x2, DIRT);
					} else if (y >= SEA_LEVEL) {
						chunkPrimerIn.setBlockState(z2, y, x2, AIR);
					}
				} else {
					if (iblockstate2.getMaterial() == Material.AIR) {
						j = -1;
					} else if (iblockstate2.getBlock() == ZGBlocks.altumStone) {
						if (j == -1) {
							if (k <= 0) {
								topState = AIR;
								fillState = STONE;
							} else if (y >= i - 4 && y <= i + 1) {
								topState = this.topBlock;
								fillState = this.fillerBlock;
							}
							
							if (y < i && (topState == null || topState.getMaterial() == Material.AIR)) {
								topState = WATER;
							}
							
							j = k;
							
							if (y >= i - 1) {
								chunkPrimerIn.setBlockState(z2, y, x2, topState);
							} else if (y < i - 7 - k) {
								topState = AIR;
								fillState = STONE;
								chunkPrimerIn.setBlockState(z2, y, x2, GRAVEL);
							} else {
								chunkPrimerIn.setBlockState(z2, y, x2, fillState);
							}
						} else if (j > 0) {
							--j;
							chunkPrimerIn.setBlockState(z2, y, x2, fillState);
						}
					}
				}
			}
		}
	}
	
	@Override
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
		this.generateAltumTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
	}
	
	@Override
	public float getSpawningChance() {
		return 0.1F;
	}
	
	@Override
	public BiomeDecorator createBiomeDecorator() {
		return new BiomeDecoratorAltum();
	}
	
	protected BiomeDecoratorAltum getBiomeDecorator() {
		return (BiomeDecoratorAltum) this.decorator;
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
