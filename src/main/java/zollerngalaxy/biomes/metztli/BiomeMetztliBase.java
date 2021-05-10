/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.metztli;

import java.util.Random;
import micdoodle8.mods.galacticraft.core.entities.EntityAlienVillager;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedCreeper;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedEnderman;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSkeleton;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedWitch;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.biomes.decorators.BiomeDecoratorMetztli;
import zollerngalaxy.celestial.ZGPlanets;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.dimensions.chunkproviders.ChunkProviderMetztli;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.mobs.entities.EntityMegaCreeper;
import zollerngalaxy.mobs.entities.EntityShadowSkeleton;
import zollerngalaxy.mobs.entities.zombiemutations.EntityGhoul;
import zollerngalaxy.mobs.entities.zombiemutations.EntityOverlord;
import zollerngalaxy.mobs.entities.zombiemutations.EntitySeeker;
import zollerngalaxy.mobs.entities.zombiemutations.EntityVolatile;

public abstract class BiomeMetztliBase extends BiomeSpace {
	
	protected static final IBlockState STONE = Blocks.STONE.getDefaultState();
	protected static final IBlockState AIR = Blocks.AIR.getDefaultState();
	protected static final IBlockState BEDROCK = Blocks.BEDROCK.getDefaultState();
	protected static final IBlockState GRAVEL = Blocks.GRAVEL.getDefaultState();
	protected static final IBlockState GRASS = Blocks.GRASS.getDefaultState();
	protected static final IBlockState DIRT = Blocks.DIRT.getDefaultState();
	protected static final IBlockState ICE = Blocks.ICE.getDefaultState();
	protected static final IBlockState WATER = Blocks.WATER.getDefaultState();
	
	protected static final PropertyBool SNOWY = PropertyBool.create("snowy");
	
	protected static final IBlockState SNOWY_GRASS = GRASS.withProperty(SNOWY, Boolean.valueOf(true));
	
	protected static final int SEA_LEVEL = ChunkProviderMetztli.SEA_LEVEL;
	protected static final int SEA_FLOOR_LEVEL = (SEA_LEVEL - 21);
	
	public BiomeDecoratorMetztli biomeDecor = this.getBiomeDecorator();
	
	public BiomeMetztliBase(String singleName, BiomeProperties props) {
		super(singleName, props);
		this.setTempCategory(TempCategory.MEDIUM);
		this.setTemp(62.4F);
		this.biomeDecor.flowersPerChunk = 4;
		this.biomeDecor.grassPerChunk = 2;
		this.biomeDecor.treesPerChunk = 1;
		this.clearAllSpawning();
		
		if (ConfigManagerZG.enableAlienVillagerSpawn) {
			this.spawnableCreatureList.add(new SpawnListEntry(EntityAlienVillager.class, 2, 1, 2));
		}
		
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedZombie.class, 100, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedSpider.class, 100, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedSkeleton.class, 5, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedCreeper.class, 5, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedEnderman.class, 5, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedWitch.class, 5, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityZombie.class, 100, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityGhoul.class, 100, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityOverlord.class, 100, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntitySeeker.class, 100, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityVolatile.class, 100, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntitySpider.class, 100, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntitySkeleton.class, 5, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityShadowSkeleton.class, 5, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityCreeper.class, 5, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityMegaCreeper.class, 5, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEnderman.class, 5, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityWitch.class, 5, 1, 1));
		
		this.setStoneBlock(Blocks.STONE);
		this.setPlanetForBiome(ZGPlanets.planetMetztli);
	}
	
	@Override
	public BiomeDecorator createBiomeDecorator() {
		return new BiomeDecoratorMetztli();
	}
	
	protected BiomeDecoratorMetztli getBiomeDecorator() {
		return (BiomeDecoratorMetztli) this.decorator;
	}
	
	public final void generateMetztliTerrain(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
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
						chunkPrimerIn.setBlockState(i1, j1, l, WATER);
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
					} else if (iblockstate2.getBlock() == Blocks.STONE) {
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
				}
			}
		}
	}
	
	@Override
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
		this.generateMetztliTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
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