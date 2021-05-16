/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.altum;

import java.util.Random;
import micdoodle8.mods.galacticraft.core.entities.EntityAlienVillager;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.biomes.decorators.BiomeDecoratorAltum;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.celestial.ZGPlanets;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.ZGLootTables;
import zollerngalaxy.core.dimensions.chunkproviders.ChunkProviderAltum;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.mobs.entities.EntityBladeFish;
import zollerngalaxy.mobs.entities.EntityBlubberFish;
import zollerngalaxy.mobs.entities.EntityGypsyFish;
import zollerngalaxy.mobs.entities.EntityJellyfish;
import zollerngalaxy.mobs.entities.EntityShark;
import zollerngalaxy.mobs.entities.EntitySquidlus;
import zollerngalaxy.mobs.entities.villagers.EntityAbyssalVillager;
import zollerngalaxy.worldgen.WorldGenTreasure;

public class BiomeAltumBase extends BiomeSpace {
	
	protected static final IBlockState STONE = ZGBlocks.altumStone.getDefaultState();
	protected static final IBlockState ROCK = ZGBlocks.altumRock.getDefaultState();
	protected static final IBlockState AIR = Blocks.AIR.getDefaultState();
	protected static final IBlockState BEDROCK = Blocks.BEDROCK.getDefaultState();
	protected static final IBlockState GRAVEL = ZGBlocks.altumGravel.getDefaultState();
	protected static final IBlockState DIRT = ZGBlocks.altumDirt.getDefaultState();
	protected static final IBlockState SAND = ZGBlocks.altumSand.getDefaultState();
	protected static final IBlockState ICE = Blocks.ICE.getDefaultState();
	protected static final IBlockState SEAWEED = ZGBlocks.altumSeaweed.getDefaultState();
	protected static final IBlockState WATER = Blocks.WATER.getDefaultState();
	protected static final IBlockState SPONGE = Blocks.SPONGE.getDefaultState();
	
	protected static final PropertyBool WET = PropertyBool.create("wet");
	
	protected static final ResourceLocation LOOT_TABLE = ZGLootTables.CHEST_OCEAN_TREASURE;
	protected static final WorldGenerator OCEAN_TREASURE_GEN = new WorldGenTreasure(LOOT_TABLE);
	
	protected static final int SEA_LEVEL = ChunkProviderAltum.SEA_LEVEL;
	protected static final int SEA_FLOOR_LEVEL = ChunkProviderAltum.SEA_FLOOR_LEVEL;
	
	public BiomeDecoratorAltum biomeDecor = this.getBiomeDecorator();
	
	public BiomeAltumBase(String singleName, BiomeProperties props) {
		super(singleName, props);
		props.setBaseHeight(0.5F);
		props.setHeightVariation(0.6F);
		this.setTempCategory(TempCategory.MEDIUM);
		this.setBiomeHeight(45);
		this.setTemp(84.23F);
		this.addWaterSpawns();
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
		int z2 = x & 15;
		int x2 = z & 15;
		
		for (int y = 255; y >= 0; --y) {
			if (y == 0) {
				chunkPrimerIn.setBlockState(x2, y, z2, BEDROCK);
			} else {
				IBlockState iblockstate2 = chunkPrimerIn.getBlockState(x2, y, z2);
				if (this.getBiomeType() == EnumBiomeTypeZG.OCEAN) {
					topState = SAND;
					fillState = ROCK;
					if ((y < SEA_LEVEL) && (y > SEA_FLOOR_LEVEL)) {
						chunkPrimerIn.setBlockState(x2, y, z2, WATER);
					} else if (y < SEA_FLOOR_LEVEL) {
						chunkPrimerIn.setBlockState(x2, y, z2, STONE);
					} else if (y == SEA_FLOOR_LEVEL) {
						if (rand.nextInt(10) == 2) {
							chunkPrimerIn.setBlockState(x2, (y + 1), z2, SPONGE.withProperty(WET, Boolean.valueOf(true)));
						}
						if (rand.nextInt(10) == 2) {
							chunkPrimerIn.setBlockState(x2, (y + 1), (z2 + 1), GRAVEL);
							if (rand.nextInt(5) == 2) {
								chunkPrimerIn.setBlockState(x2, (y + 2), (z2 + 1), GRAVEL);
							}
						}
						if (rand.nextInt(300) == 3) {
							for (int i2 = 0; i2 < ZGHelper.rngInt(1, 5); i2++) {
								IBlockState blockToUse = (ZGHelper.getRNG().nextInt(5) == 1) ? DIRT : STONE;
								chunkPrimerIn.setBlockState(x2, (y + i2), z2, blockToUse);
							}
						} else {
							if (rand.nextInt(20) == 2) {
								chunkPrimerIn.setBlockState(x2, (y + 1), z2, SEAWEED);
							}
							chunkPrimerIn.setBlockState(x2, y, z2, DIRT);
						}
						//
						if (rand.nextInt(1000) <= 5) {
							BlockPos chestPos = new BlockPos(x2, (y + 1), z2);
							
							int posX = chestPos.getX();
							int posY = chestPos.getY();
							int posZ = chestPos.getZ();
							
							IBlockState state = chunkPrimerIn.getBlockState(posX, posY, posZ);
							Block block = state.getBlock();
							
							if (chestPos != null && chestPos != null && block != null) {
								OCEAN_TREASURE_GEN.generate(worldIn, rand, chestPos);
							}
						}
						//
					} else if (y >= SEA_LEVEL) {
						chunkPrimerIn.setBlockState(x2, y, z2, AIR);
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
								chunkPrimerIn.setBlockState(x2, y, z2, topState);
							} else if (y < i - 7 - k) {
								topState = AIR;
								fillState = STONE;
								chunkPrimerIn.setBlockState(x2, y, z2, GRAVEL);
							} else {
								chunkPrimerIn.setBlockState(x2, y, z2, fillState);
							}
						} else if (j > 0) {
							--j;
							chunkPrimerIn.setBlockState(x2, y, z2, fillState);
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
	
	public void addWaterSpawns() {
		this.spawnableWaterCreatureList.add(new SpawnListEntry(EntitySquidlus.class, 75, 2, 4));
		this.spawnableWaterCreatureList.add(new SpawnListEntry(EntitySquid.class, 70, 2, 4));
		this.spawnableWaterCreatureList.add(new SpawnListEntry(EntityJellyfish.class, 65, 1, 4));
		this.spawnableWaterCreatureList.add(new SpawnListEntry(EntityGypsyFish.class, 62, 4, 8));
		this.spawnableWaterCreatureList.add(new SpawnListEntry(EntityBlubberFish.class, 60, 3, 6));
		this.spawnableWaterCreatureList.add(new SpawnListEntry(EntityBladeFish.class, 55, 1, 3));
		this.spawnableWaterCreatureList.add(new SpawnListEntry(EntityShark.class, 45, 1, 2));
		this.spawnableWaterCreatureList.add(new SpawnListEntry(EntityAbyssalVillager.class, 40, 1, 2));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityAbyssalVillager.class, 40, 1, 2));
		
		if (ConfigManagerZG.enableAlienVillagerSpawn) {
			this.spawnableCreatureList.add(new SpawnListEntry(EntityAlienVillager.class, 5, 1, 2));
		}
	}
	
}