/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.decorators;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.TempCategory;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenLiquids;
import net.minecraft.world.gen.feature.WorldGenSand;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.blocks.ZGBlockTallGrass;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.dimensions.chunkproviders.ChunkProviderExodus;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.core.enums.EnumOreGenZG;
import zollerngalaxy.lib.helpers.ZGDecorateHelper;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.util.BiomeUtils;
import zollerngalaxy.worldgen.WorldGenBattleTower;
import zollerngalaxy.worldgen.WorldGenCrops;
import zollerngalaxy.worldgen.WorldGenFlowersZG;
import zollerngalaxy.worldgen.WorldGenLakesZG;
import zollerngalaxy.worldgen.WorldGenMinableZG;
import zollerngalaxy.worldgen.WorldGenOutpost;
import zollerngalaxy.worldgen.WorldGenTallGrassZG;

public class BiomeDecoratorExodus extends BiomeDecoratorZG {
	
	private WorldGenerator dirtGen;
	private WorldGenerator gravGen;
	private WorldGenerator ironOreGen;
	private WorldGenerator goldOreGen;
	private WorldGenerator diamondOreGen;
	private WorldGenerator redstoneOreGen;
	private WorldGenerator copperOreGen;
	
	private WorldGenerator tallGrassGen = new WorldGenTallGrassZG((ZGBlockTallGrass) ZGBlocks.exodusTallGrass);
	private WorldGenerator flowerGen = new WorldGenFlowersZG(ZGBlocks.exodusFlower.getDefaultState());
	private WorldGenerator sandGen = new WorldGenSand(ZGBlocks.exodusSand, 7);
	private WorldGenerator gravelGen = new WorldGenSand(ZGBlocks.exodusGravel, 6);
	private WorldGenerator battleTowerGen = new WorldGenBattleTower(ZGBlocks.exoWoodPlanks.getDefaultState(), ZGBlocks.blockShinestonePolished.getDefaultState());
	private WorldGenerator cropGen;
	
	public boolean generateLakes = true;
	public boolean generateVines = false;
	public boolean generateTrees = true;
	public boolean generateCraters = true;
	public boolean generateCrops = true;
	public boolean generateBattleTowers = true;
	
	public int tallGrassPerChunk = 10;
	public int waterLakesPerChunk = 2;
	public int lavaLakesPerChunk = (this.enableExtremeMode) ? 2 : 1;
	public int flowersPerChunk = 2;
	public int cropsPerChunk = 2;
	public int battleTowersPerChunk = 2;
	
	private static final Block STONE = ZGBlocks.exodusStone;
	
	public BiomeDecoratorExodus() {
		this.dirtGen = new WorldGenMinableZG(ZGBlocks.exodusDirt, ZGBlocks.exodusGrass, EnumOreGenZG.DIRT);
		this.gravGen = new WorldGenMinableZG(ZGBlocks.exodusGravel, STONE, EnumOreGenZG.GRAVEL);
		this.ironOreGen = new WorldGenMinableZG(ZGBlocks.exodusIronOre, STONE, EnumOreGenZG.IRON);
		this.goldOreGen = new WorldGenMinableZG(ZGBlocks.exodusGoldOre, STONE, EnumOreGenZG.GOLD);
		this.diamondOreGen = new WorldGenMinableZG(ZGBlocks.exodusDiamondOre, STONE, EnumOreGenZG.DIAMOND);
		this.redstoneOreGen = new WorldGenMinableZG(ZGBlocks.exodusRedstoneOre, STONE, EnumOreGenZG.REDSTONE);
		this.copperOreGen = new WorldGenMinableZG(ZGBlocks.exodusCopperOre, STONE, EnumOreGenZG.COPPER);
	}
	
	@Override
	protected void generate(Biome biome, World world, Random rand) {
		int x = rand.nextInt(16) + 8;
		int z = rand.nextInt(16) + 8;
		
		ChunkPrimer chunkPrimer = new ChunkPrimer();
		ChunkPos forgeChunkPos = new ChunkPos(chunkPos);
		
		int genY = 248;
		int y = genY;
		
		Block BLOCK_TOP = biome.topBlock.getBlock();
		Block BLOCK_FILL = biome.fillerBlock.getBlock();
		Block BLOCK_STONE = STONE;
		
		if (biome instanceof BiomeSpace) {
			BiomeSpace spaceBiome = (BiomeSpace) biome;
			genY = spaceBiome.getBiomeHeight();
		}
		
		// Ore gen
		this.generateOre(this.dirtGen, EnumOreGenZG.DIRT, world, rand);
		this.generateOre(this.gravGen, EnumOreGenZG.GRAVEL, world, rand);
		this.generateOre(this.ironOreGen, EnumOreGenZG.IRON, world, rand);
		this.generateOre(this.goldOreGen, EnumOreGenZG.GOLD, world, rand);
		this.generateOre(this.diamondOreGen, EnumOreGenZG.DIAMOND, world, rand);
		this.generateOre(this.redstoneOreGen, EnumOreGenZG.REDSTONE, world, rand);
		this.generateOre(this.copperOreGen, EnumOreGenZG.COPPER, world, rand);
		
		// Tall Grass
		if (this.tallGrassPerChunk > 0) {
			for (int i = 0; i < this.tallGrassPerChunk + 4; ++i) {
				ZGDecorateHelper.generatePlants(this.tallGrassGen, world, rand, this.chunkPos);
			}
		}
		
		// Water Lakes
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.LAKE_WATER)) {
			if (this.generateLakes && this.waterLakesPerChunk > 0) {
				for (int i = 0; i < this.waterLakesPerChunk; ++i) {
					y = rand.nextInt(rand.nextInt(genY) + 8);
					Block blockToUse = (biome.getTempCategory() == TempCategory.COLD) ? Blocks.ICE : Blocks.WATER;
					(new WorldGenLakesZG(blockToUse, BLOCK_TOP)).generate(world, rand, this.chunkPos.add(x, y, z));
				}
			}
		}
		
		// Lava Lakes
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.LAKE_LAVA)) {
			if (this.generateLakes && this.lavaLakesPerChunk > 0) {
				if (rand.nextInt(5) == 0) {
					for (int i = 0; i < this.lavaLakesPerChunk; ++i) {
						y = rand.nextInt(rand.nextInt(genY) + 8);
						
						if (rand.nextInt((this.enableExtremeMode) ? 75 : 100) <= 50) {
							(new WorldGenLakesZG(Blocks.LAVA, BLOCK_STONE)).generate(world, rand, this.chunkPos.add(x, y, z));
						}
					}
				}
			}
		}
		
		// Flowers
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.FLOWERS)) {
			for (int l2 = 0; l2 < this.flowersPerChunk; ++l2) {
				int i7 = rand.nextInt(16) + 8;
				int l10 = rand.nextInt(16) + 8;
				int j14 = world.getHeight(this.chunkPos.add(i7, 0, l10)).getY() + 32;
				
				if (j14 > 0) {
					int k17 = rand.nextInt(j14);
					BlockPos blockpos1 = this.chunkPos.add(i7, k17, l10);
					Block blockflower = ZGBlocks.exodusFlower;
					
					if (blockflower.getDefaultState().getMaterial() != Material.AIR) {
						this.flowerGen.generate(world, rand, blockpos1);
					}
				}
			}
		}
		
		// Trees
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.TREE)) {
			if (rand.nextInt(3) == 0) {
				for (int j2 = 0; j2 < y; ++j2) {
					int k6 = rand.nextInt(16) + 8;
					int l = rand.nextInt(16) + 8;
					WorldGenAbstractTree worldgenabstracttree = biome.getRandomTreeFeature(rand);
					worldgenabstracttree.setDecorationDefaults();
					BlockPos blockpos = world.getHeight(this.chunkPos.add(k6, 0, l));
					
					if (worldgenabstracttree.generate(world, rand, blockpos)) {
						worldgenabstracttree.generateSaplings(world, rand, blockpos);
					}
				}
			}
		}
		
		// Falls
		if (this.generateFalls) {
			if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.LAKE_WATER))
				for (int k5 = 0; k5 < 50; ++k5) {
					int i10 = rand.nextInt(16) + 8;
					int l13 = rand.nextInt(16) + 8;
					int i17 = rand.nextInt(120) + 8;
					
					if (i17 > 0) {
						int k19 = rand.nextInt(i17);
						BlockPos blockpos6 = this.chunkPos.add(i10, k19, l13);
						(new WorldGenLiquids(Blocks.FLOWING_WATER)).generate(world, rand, blockpos6);
					}
				}
			
			if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.LAKE_LAVA))
				if (rand.nextInt(3) == 0) {
					for (int l5 = 0; l5 < 20; ++l5) {
						int j10 = rand.nextInt(16) + 8;
						int i14 = rand.nextInt(16) + 8;
						int j17 = rand.nextInt(rand.nextInt(rand.nextInt(112) + 8) + 8);
						BlockPos blockpos3 = this.chunkPos.add(j10, j17, i14);
						(new WorldGenLiquids(Blocks.FLOWING_LAVA)).generate(world, rand, blockpos3);
					}
				}
		}
		
		// Sand
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.SAND)) {
			for (int i = 0; i < this.sandPatchesPerChunk; ++i) {
				int j = rand.nextInt(16) + 8;
				int k = rand.nextInt(16) + 8;
				this.sandGen.generate(world, rand, world.getTopSolidOrLiquidBlock(this.chunkPos.add(j, 0, k)));
			}
		}
		
		// Gravel
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.SAND_PASS2)) {
			for (int j1 = 0; j1 < this.gravelPatchesPerChunk; ++j1) {
				int i2 = rand.nextInt(16) + 8;
				int j6 = rand.nextInt(16) + 8;
				this.gravelGen.generate(world, rand, world.getTopSolidOrLiquidBlock(this.chunkPos.add(i2, 0, j6)));
			}
		}
		
		// Crops
		if (this.generateCrops && this.cropsPerChunk > 0 && !BiomeUtils.isOceanBiome(biome)) {
			if (ZGHelper.rngInt(1, 100) <= 45) {
				for (int i = 0; i < this.cropsPerChunk; ++i) {
					y = rand.nextInt(rand.nextInt(genY) + 8);
					if (y >= 62) {
						this.cropGen = new WorldGenCrops(ZGHelper.getRandomCrop(rand).getDefaultState());
						this.cropGen.generate(world, rand, this.chunkPos.add(x, y, z));
					}
				}
			}
		}
		
		// Battle Towers
		if (this.generateBattleTowers && this.battleTowersPerChunk > 0 && !BiomeUtils.isOceanBiome(biome)) {
			if (ZGHelper.rngInt(1, 250) <= 35) {
				for (int i = 0; i < this.battleTowersPerChunk; ++i) {
					y = rand.nextInt(rand.nextInt(genY) + 8);
					if (y >= 60 && y < 80) {
						this.battleTowerGen.generate(world, rand, this.chunkPos.add(x, y, z));
					}
				}
			}
		}
		
		// Craters
		if (this.generateCraters) {
			ChunkProviderExodus.INSTANCE.createCraters(x, z, chunkPrimer);
		}
		
		// Outposts
		if (this.generateOutposts && this.outpostsPerChunk > 0) {
			if (biome instanceof BiomeSpace) {
				BiomeSpace spaceBiome = (BiomeSpace) biome;
				if (spaceBiome.getBiomeType() == EnumBiomeTypeZG.OCEAN) {
					return;
				}
			}
			y = rand.nextInt(rand.nextInt(genY) + 8);
			if (y >= 62) {
				IBlockState OUTPOST_STATE = ZGBlocks.blockOutpost.getDefaultState();
				WorldGenerator outpostGen = new WorldGenOutpost(OUTPOST_STATE, OUTPOST_STATE);
				for (int i = 0; i < this.outpostsPerChunk; i++) {
					if (rand.nextInt((this.enableExtremeMode) ? 200 : 100) <= ConfigManagerZG.outpostGenChance) {
						outpostGen.generate(world, rand, this.chunkPos.add(x, y, z));
					}
				}
			}
		}
	}
}