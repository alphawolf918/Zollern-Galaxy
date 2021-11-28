/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.astros;

import java.util.Random;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedCreeper;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedEnderman;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSkeleton;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedWitch;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.biomes.decorators.BiomeDecoratorAstros;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.celestial.ZGPlanets;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.dimensions.chunkproviders.ChunkProviderAstros;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.mobs.entities.villagers.EntityAstrosVillager;

public class BiomeAstrosBase extends BiomeSpace {
	
	protected static final IBlockState STONE = ZGBlocks.astrosStone.getDefaultState();
	protected static final IBlockState AIR = Blocks.AIR.getDefaultState();
	protected static final IBlockState BEDROCK = Blocks.BEDROCK.getDefaultState();
	protected static final IBlockState GRAVEL = ZGBlocks.astrosGravel.getDefaultState();
	protected static final IBlockState DIRT = ZGBlocks.astrosDirt.getDefaultState();
	protected static final IBlockState ICE = ZGBlocks.astrosIce.getDefaultState();
	protected static final IBlockState WATER = Blocks.WATER.getDefaultState();
	
	protected static final int SEA_LEVEL = ChunkProviderAstros.SEA_LEVEL;
	protected static final int SEA_FLOOR_LEVEL = (SEA_LEVEL - 21);
	
	public BiomeDecoratorAstros biomeDecor = this.getBiomeDecorator();
	
	public BiomeAstrosBase(String singleName, BiomeProperties props) {
		super(singleName, props);
		this.setTempCategory(TempCategory.COLD);
		this.biomeDecor.flowersPerChunk = -999;
		this.biomeDecor.treesPerChunk = -999;
		this.biomeDecor.grassPerChunk = -999;
		this.biomeDecor.mushroomsPerChunk = -999;
		this.clearAllSpawning();
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedZombie.class, 100, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedSpider.class, 100, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedSkeleton.class, 100, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedCreeper.class, 100, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedEnderman.class, 100, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedWitch.class, 100, 4, 4));
		if (ConfigManagerZG.enableAlienVillagerSpawn) {
			this.spawnableCreatureList.add(new SpawnListEntry(EntityAstrosVillager.class, this.villagerSpawnRate, 1, 1));
		}
		this.setBodyForBiome(ZGPlanets.moonAstros);
	}
	
	public final void generateAstrosTerrain(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
		int i = worldIn.getSeaLevel();
		float biomeHeight = this.getBiomeHeight();
		IBlockState topState = this.topBlock;
		IBlockState fillState = this.fillerBlock;
		int j = -1;
		int k = (int) (noiseVal / 3.0D + 3.5D + rand.nextDouble() * 0.25D);
		int l = x & 15;
		int i1 = z & 15;
		
		for (int j1 = 255; j1 >= 0; --j1) {
			if (j1 == 0) {
				chunkPrimerIn.setBlockState(i1, j1, l, BEDROCK);
			} else {
				IBlockState iblockstate2 = chunkPrimerIn.getBlockState(i1, j1, l);
				if (this.getBiomeType() == EnumBiomeTypeZG.OCEAN) {
					if ((j1 < SEA_LEVEL) && (j1 > SEA_FLOOR_LEVEL)) {
						chunkPrimerIn.setBlockState(i1, j1, l, ICE);
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
								topState = ICE;
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
		this.generateAstrosTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
	}
	
	@Override
	public float getSpawningChance() {
		return 0.1F;
	}
	
	@Override
	public BiomeDecorator createBiomeDecorator() {
		return new BiomeDecoratorAstros();
	}
	
	protected BiomeDecoratorAstros getBiomeDecorator() {
		return (BiomeDecoratorAstros) this.decorator;
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