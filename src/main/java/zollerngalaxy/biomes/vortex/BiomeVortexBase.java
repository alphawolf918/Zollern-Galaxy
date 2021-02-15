/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.vortex;

import java.util.Random;
import micdoodle8.mods.galacticraft.core.entities.EntityAlienVillager;
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
import zollerngalaxy.biomes.decorators.BiomeDecoratorVortex;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.blocks.fluids.ZGFluids;
import zollerngalaxy.celestial.ZGPlanets;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.dimensions.chunkproviders.ChunkProviderVortex;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.mobs.entities.EntityMegaCreeper;

public class BiomeVortexBase extends BiomeSpace {
	
	protected static final IBlockState STONE = ZGBlocks.vortexStone.getDefaultState();
	protected static final IBlockState AIR = Blocks.AIR.getDefaultState();
	protected static final IBlockState BEDROCK = Blocks.BEDROCK.getDefaultState();
	protected static final IBlockState VOLTROCK = ZGBlocks.vortexVoltRock.getDefaultState();
	protected static final IBlockState COBBLESTONE = ZGBlocks.vortexCobblestone.getDefaultState();
	protected static final IBlockState WATER = Blocks.WATER.getDefaultState();
	
	protected static final int SEA_LEVEL = ChunkProviderVortex.SEA_LEVEL;
	protected static final int SEA_FLOOR_LEVEL = (SEA_LEVEL - 21);
	
	public BiomeVortexBase(String singleName, BiomeProperties props) {
		super(singleName, props);
		this.init();
	}
	
	public BiomeVortexBase(String singleName) {
		this(singleName, new BiomeProperties(singleName));
	}
	
	private void init() {
		this.setTempCategory(TempCategory.WARM);
		this.decorator.flowersPerChunk = -999;
		this.decorator.treesPerChunk = -999;
		this.decorator.grassPerChunk = -999;
		this.decorator.mushroomsPerChunk = -999;
		this.clearAllSpawning();
		
		if (ConfigManagerZG.enableAlienVillagerSpawn) {
			this.spawnableCreatureList.add(new SpawnListEntry(EntityAlienVillager.class, 5, 1, 2));
		}
		
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedZombie.class, 80, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedSpider.class, 80, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedSkeleton.class, 80, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedCreeper.class, 80, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityMegaCreeper.class, 80, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedEnderman.class, 80, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedWitch.class, 80, 1, 4));
		this.setPlanetForBiome(ZGPlanets.planetVortex);
	}
	
	public final void generateVortexTerrain(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
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
			} else {
				IBlockState iblockstate2 = chunkPrimerIn.getBlockState(i1, j1, l);
				if (this.getBiomeType() == EnumBiomeTypeZG.OCEAN) {
					if ((j1 < SEA_LEVEL) && (j1 > SEA_FLOOR_LEVEL)) {
						IBlockState FLUID_BLOCK = ZGFluids.blockChargiumFluid.getDefaultState();
						chunkPrimerIn.setBlockState(i1, j1, l, FLUID_BLOCK);
					} else if (j1 < SEA_FLOOR_LEVEL) {
						chunkPrimerIn.setBlockState(i1, j1, l, STONE);
					} else if (j1 == SEA_FLOOR_LEVEL) {
						chunkPrimerIn.setBlockState(i1, j1, l, COBBLESTONE);
					} else if (j1 >= SEA_LEVEL) {
						chunkPrimerIn.setBlockState(i1, j1, l, AIR);
					}
				} else {
					if (iblockstate2.getMaterial() == Material.AIR) {
						j = -1;
					} else if (iblockstate2.getBlock() == ZGBlocks.vortexStone) {
						if (j == -1) {
							if (k <= 0) {
								topState = AIR;
								fillState = STONE;
							} else if (j1 >= i - 4 && j1 <= i + 1) {
								topState = this.topBlock;
								fillState = this.fillerBlock;
							}
							
							j = k;
							
							if (j1 >= i - 1) {
								chunkPrimerIn.setBlockState(i1, j1, l, topState);
							} else if (j1 < i - 7 - k) {
								topState = AIR;
								fillState = STONE;
								chunkPrimerIn.setBlockState(i1, j1, l, VOLTROCK);
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
		this.generateVortexTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
	}
	
	@Override
	public float getSpawningChance() {
		return 0.001F;
	}
	
	@Override
	public BiomeDecorator createBiomeDecorator() {
		return new BiomeDecoratorVortex();
	}
	
	protected BiomeDecoratorVortex getBiomeDecorator() {
		return (BiomeDecoratorVortex) this.decorator;
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
