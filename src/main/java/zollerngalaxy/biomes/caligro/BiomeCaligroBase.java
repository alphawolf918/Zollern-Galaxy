/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.caligro;

import java.util.Random;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedEnderman;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.biomes.decorators.BiomeDecoratorCaligro;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.blocks.fluids.ZGFluids;
import zollerngalaxy.core.dimensions.chunkproviders.ChunkProviderCaligro;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.mobs.entities.EntityGrayAlien;
import zollerngalaxy.mobs.entities.EntityKrull;
import zollerngalaxy.mobs.entities.EntityMegaCreeper;
import zollerngalaxy.mobs.entities.EntityMummy;
import zollerngalaxy.mobs.entities.EntityScorpion;
import zollerngalaxy.mobs.entities.EntityShade;
import zollerngalaxy.mobs.entities.EntityShadowSkeleton;
import zollerngalaxy.mobs.entities.EntitySpiderling;
import zollerngalaxy.planets.ZGPlanets;

public class BiomeCaligroBase extends BiomeSpace {
	
	protected static final IBlockState STONE = ZGBlocks.caligroStone.getDefaultState();
	protected static final IBlockState CORRUPTED_STONE = ZGBlocks.corruptStone.getDefaultState();
	protected static final IBlockState AIR = Blocks.AIR.getDefaultState();
	protected static final IBlockState BEDROCK = Blocks.BEDROCK.getDefaultState();
	protected static final IBlockState GRAVEL = ZGBlocks.caligroGravel.getDefaultState();
	protected static final IBlockState DIRT = ZGBlocks.caligroDirt.getDefaultState();
	protected static final IBlockState ICE = Blocks.PACKED_ICE.getDefaultState();
	
	protected static final int SEA_LEVEL = ChunkProviderCaligro.SEA_LEVEL;
	protected static final int SEA_FLOOR_LEVEL = 42;
	protected static final int CORRUPTION_LAYER = ChunkProviderCaligro.CORRUPTION_LAYER;
	
	public BiomeDecoratorCaligro biomeDecor = this.getBiomeDecorator();
	
	public BiomeCaligroBase(String singleName, BiomeProperties props) {
		super(singleName, props);
		this.setTempCategory(TempCategory.COLD);
		this.biomeDecor.flowersPerChunk = -999;
		this.biomeDecor.treesPerChunk = -999;
		this.biomeDecor.grassPerChunk = -999;
		this.biomeDecor.mushroomsPerChunk = -999;
		this.clearAllSpawning();
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedEnderman.class, 100, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEnderman.class, 100, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityScorpion.class, 100, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntitySpider.class, 100, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityCaveSpider.class, 100, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntitySpiderling.class, 50, 1, 1));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityGrayAlien.class, 100, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityMummy.class, 100, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityZombie.class, 100, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityKrull.class, 50, 1, 1));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityMegaCreeper.class, 100, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityShadowSkeleton.class, 100, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityWitherSkeleton.class, 80, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityShade.class, 100, 1, 4));
		this.setPlanetForBiome(ZGPlanets.planetCaligro);
	}
	
	public final void generateCaligroTerrain(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
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
						IBlockState CHARGIUM = ZGFluids.blockChargiumFluid.getDefaultState();
						chunkPrimerIn.setBlockState(i1, j1, l, CHARGIUM);
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
					} else if (iblockstate2.getBlock() == ZGBlocks.caligroStone || iblockstate2.getBlock() == ZGBlocks.corruptStone) {
						if (j == -1) {
							if (k <= 0) {
								topState = AIR;
								fillState = (j1 > CORRUPTION_LAYER) ? STONE : CORRUPTED_STONE;
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
								fillState = (j1 > CORRUPTION_LAYER) ? STONE : CORRUPTED_STONE;
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
		this.generateCaligroTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
	}
	
	@Override
	public float getSpawningChance() {
		return 0.1F;
	}
	
	@Override
	public BiomeDecorator createBiomeDecorator() {
		return new BiomeDecoratorCaligro();
	}
	
	protected BiomeDecoratorCaligro getBiomeDecorator() {
		return (BiomeDecoratorCaligro) this.decorator;
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