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
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockStone;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenCactus;
import net.minecraft.world.gen.feature.WorldGenDeadBush;
import net.minecraft.world.gen.feature.WorldGenLiquids;
import net.minecraft.world.gen.feature.WorldGenMegaJungle;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenWaterlily;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.dimensions.chunkproviders.ChunkProviderMetztli;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.core.enums.EnumOreGenZG;
import zollerngalaxy.lib.helpers.ZGDecorateHelper;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.util.BiomeUtils;
import zollerngalaxy.worldgen.WorldGenBattleTower;
import zollerngalaxy.worldgen.WorldGenCrops;
import zollerngalaxy.worldgen.WorldGenLakesZG;
import zollerngalaxy.worldgen.WorldGenMinableZG;
import zollerngalaxy.worldgen.WorldGenOutpost;
import zollerngalaxy.worldgen.WorldGenZGMushroomTree;

public class BiomeDecoratorMetztli extends BiomeDecoratorZG {
	
	private static final Block STONE = Blocks.STONE;
	private static final Block GRASS = Blocks.GRASS;
	
	private WorldGenerator dirtGen;
	private WorldGenerator graniteGen;
	private WorldGenerator dioriteGen;
	private WorldGenerator andesiteGen;
	private WorldGenerator ironGen;
	private WorldGenerator goldGen;
	private WorldGenerator redstoneGen;
	private WorldGenerator diamondGen;
	private WorldGenerator emeraldGen;
	private WorldGenerator lapisGen;
	private WorldGenerator aquamarineGen;
	private WorldGenerator amberGen;
	private WorldGenerator zincGen;
	private WorldGenerator garnetGen;
	private WorldGenerator superChargedCoalGen;
	private WorldGenerator sapphireGen;
	private WorldGenerator opalGen;
	private WorldGenerator rubyGen;
	private WorldGenerator amaranthGen;
	private WorldGenerator topazGen;
	private WorldGenerator fueltoniumGen;
	
	private WorldGenerator tallGrassGen = new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);
	private WorldGenerator fernGen = new WorldGenTallGrass(BlockTallGrass.EnumType.FERN);
	private WorldGenerator treeGenMushroom = new WorldGenZGMushroomTree(false, ZGHelper.rngInt(3, 10));
	private WorldGenerator waterLilyGen = new WorldGenWaterlily();
	private WorldGenerator treeGen = new WorldGenBigTree(true);
	private WorldGenerator cactusGen = new WorldGenCactus();
	private WorldGenerator deadBushGen = new WorldGenDeadBush();
	private WorldGenerator battleTowerGen = new WorldGenBattleTower(Blocks.COBBLESTONE.getDefaultState(), Blocks.GLOWSTONE.getDefaultState());
	private WorldGenerator cropGen;
	private WorldGenerator jungleTreeGen;
	
	public int waterLakesPerChunk = 3;
	public int lavaLakesPerChunk = 4;
	public int waterLilyPerChunk = 4;
	public int tallGrassPerChunk = 6;
	public int treesPerChunk = 4;
	public int mushroomTreesPerChunk = 2;
	public int cactiPerChunk = 5;
	public int deadBushesPerChunk = 4;
	public int reedsPerChunk = 4;
	public int battleTowersPerChunk = 2;
	public int cropsPerChunk = 2;
	public int fernsPerChunk = 4;
	public int jungleTreesPerChunk = 0;
	public int mushroomsPerChunk = 20;
	public int clayPerChunk = 3;
	
	public boolean generateLakes = true;
	public boolean generateWaterLilies = true;
	public boolean generateTallGrass = true;
	public boolean generateTrees = true;
	public boolean generateMushroomTrees = false;
	public boolean generateCraters = true;
	public boolean generateCacti = false;
	public boolean generateDeadBushes = false;
	public boolean generateReeds = true;
	public boolean generateVines = false;
	public boolean generateBattleTowers = true;
	public boolean generateCrops = true;
	public boolean generateFerns = true;
	public boolean generateJungleTrees = false;
	public boolean generateMushrooms = true;
	
	public BiomeDecoratorMetztli() {
		this.dirtGen = new WorldGenMinableZG(Blocks.DIRT, GRASS, EnumOreGenZG.DIRT);
		this.graniteGen = new WorldGenMinableZG(STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE), STONE, EnumOreGenZG.STONE);
		this.dioriteGen = new WorldGenMinableZG(STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.DIORITE), STONE, EnumOreGenZG.STONE);
		this.andesiteGen = new WorldGenMinableZG(STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE), STONE, EnumOreGenZG.STONE);
		this.ironGen = new WorldGenMinableZG(Blocks.IRON_ORE, STONE, EnumOreGenZG.IRON);
		this.goldGen = new WorldGenMinableZG(Blocks.GOLD_ORE, STONE, EnumOreGenZG.GOLD);
		this.redstoneGen = new WorldGenMinableZG(Blocks.REDSTONE_ORE, STONE, EnumOreGenZG.REDSTONE);
		this.diamondGen = new WorldGenMinableZG(Blocks.DIAMOND_ORE, STONE, EnumOreGenZG.DIAMOND);
		this.emeraldGen = new WorldGenMinableZG(Blocks.EMERALD_ORE, STONE, EnumOreGenZG.EMERALD);
		this.lapisGen = new WorldGenMinableZG(Blocks.LAPIS_ORE, STONE, EnumOreGenZG.LAPIS);
		this.aquamarineGen = new WorldGenMinableZG(ZGBlocks.harranAquamarineOre, STONE, EnumOreGenZG.POWER_GEM);
		this.amberGen = new WorldGenMinableZG(ZGBlocks.harranAmberOre, STONE, EnumOreGenZG.POWER_GEM);
		this.zincGen = new WorldGenMinableZG(ZGBlocks.harranZincOre, STONE, EnumOreGenZG.ZINC);
		this.garnetGen = new WorldGenMinableZG(ZGBlocks.harranGarnetOre, STONE, EnumOreGenZG.POWER_GEM);
		this.superChargedCoalGen = new WorldGenMinableZG(ZGBlocks.harranSuperChargedCoalOre, STONE, EnumOreGenZG.SUPER_CHARGED_COAL);
		this.sapphireGen = new WorldGenMinableZG(ZGBlocks.harranSapphireOre, STONE, EnumOreGenZG.SAPPHIRE);
		this.opalGen = new WorldGenMinableZG(ZGBlocks.harranOpalOre, STONE, EnumOreGenZG.POWER_GEM);
		this.rubyGen = new WorldGenMinableZG(ZGBlocks.harranRubyOre, STONE, EnumOreGenZG.RUBY);
		this.amaranthGen = new WorldGenMinableZG(ZGBlocks.harranAmaranthOre, STONE, EnumOreGenZG.AMARANTH);
		this.topazGen = new WorldGenMinableZG(ZGBlocks.harranTopazOre, STONE, EnumOreGenZG.POWER_GEM);
		this.fueltoniumGen = new WorldGenMinableZG(ZGBlocks.harranFueltoniumOre, STONE, EnumOreGenZG.FUELTONIUM);
	}
	
	@Override
	protected void generate(Biome biome, World world, Random rand) {
		int x = rand.nextInt(16) + 8;
		int z = rand.nextInt(16) + 8;
		int y = rand.nextInt(120) + 8;
		
		ChunkPrimer chunkPrimer = new ChunkPrimer();
		ChunkPos forgeChunkPos = new ChunkPos(chunkPos);
		
		Block BLOCK_TOP = biome.topBlock.getBlock();
		Block BLOCK_FILL = biome.fillerBlock.getBlock();
		Block BLOCK_STONE = Blocks.STONE;
		
		this.generateOre(this.dirtGen, EnumOreGenZG.DIRT, world, rand);
		this.generateOre(this.graniteGen, EnumOreGenZG.STONE, world, rand);
		this.generateOre(this.dioriteGen, EnumOreGenZG.STONE, world, rand);
		this.generateOre(this.andesiteGen, EnumOreGenZG.STONE, world, rand);
		this.generateOre(this.ironGen, EnumOreGenZG.IRON, world, rand);
		this.generateOre(this.goldGen, EnumOreGenZG.GOLD, world, rand);
		this.generateOre(this.redstoneGen, EnumOreGenZG.REDSTONE, world, rand);
		this.generateOre(this.diamondGen, EnumOreGenZG.DIAMOND, world, rand);
		this.generateOre(this.emeraldGen, EnumOreGenZG.EMERALD, world, rand);
		this.generateOre(this.lapisGen, EnumOreGenZG.LAPIS, world, rand);
		this.generateOre(this.aquamarineGen, EnumOreGenZG.POWER_GEM, world, rand);
		this.generateOre(this.amberGen, EnumOreGenZG.POWER_GEM, world, rand);
		this.generateOre(this.zincGen, EnumOreGenZG.ZINC, world, rand);
		this.generateOre(this.garnetGen, EnumOreGenZG.POWER_GEM, world, rand);
		this.generateOre(this.superChargedCoalGen, EnumOreGenZG.SUPER_CHARGED_COAL, world, rand);
		this.generateOre(this.opalGen, EnumOreGenZG.POWER_GEM, world, rand);
		this.generateOre(this.rubyGen, EnumOreGenZG.RUBY, world, rand);
		this.generateOre(this.amaranthGen, EnumOreGenZG.AMARANTH, world, rand);
		this.generateOre(this.topazGen, EnumOreGenZG.POWER_GEM, world, rand);
		this.generateOre(this.fueltoniumGen, EnumOreGenZG.FUELTONIUM, world, rand);
		
		int genY = y;
		
		if (biome instanceof BiomeSpace) {
			BiomeSpace spaceBiome = (BiomeSpace) biome;
			genY = spaceBiome.getBiomeHeight();
		}
		
		// Lava Lakes
		if (this.generateLakes && this.lavaLakesPerChunk > 0) {
			for (int i = 0; i < this.lavaLakesPerChunk; ++i) {
				y = rand.nextInt(rand.nextInt(genY) + 8);
				
				if (rand.nextInt((this.enableExtremeMode) ? 75 : 100) <= 50) {
					(new WorldGenLakesZG(Blocks.LAVA, BLOCK_STONE)).generate(world, rand, this.chunkPos.add(x, y, z));
				}
			}
		}
		
		// Water Lakes
		if (this.generateLakes && this.waterLakesPerChunk > 0) {
			for (int i = 0; i < this.waterLakesPerChunk; ++i) {
				y = rand.nextInt(rand.nextInt(genY) + 8);
				Block blockToUse = (BiomeUtils.isColdBiome(biome)) ? Blocks.ICE : Blocks.WATER;
				(new WorldGenLakesZG(blockToUse, BLOCK_TOP)).generate(world, rand, this.chunkPos.add(x, y, z));
			}
			
			// Water Lilies
			if (this.generateWaterLilies && this.waterlilyPerChunk > 0) {
				for (int i = 0; i < this.waterlilyPerChunk; ++i) {
					this.waterLilyGen.generate(world, rand, this.chunkPos.add(x, y, z));
				}
			}
		}
		
		// Tall Grass
		if (this.generateTallGrass && this.tallGrassPerChunk > 0) {
			for (int i = 0; i < this.tallGrassPerChunk + 4; ++i) {
				ZGDecorateHelper.generatePlants(this.tallGrassGen, world, rand, this.chunkPos);
			}
		}
		
		// Ferns
		if (this.generateFerns && this.fernsPerChunk > 0) {
			for (int i = 0; i < this.fernsPerChunk + 2; ++i) {
				ZGDecorateHelper.generatePlants(this.fernGen, world, rand, this.chunkPos);
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
		
		// Trees
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.TREE)) {
			if (this.generateTrees && this.treesPerChunk > 0) {
				for (int i = 0; i < this.treesPerChunk; ++i) {
					y = rand.nextInt(rand.nextInt(genY) + 8);
					if (y < 64) {
						y = ZGHelper.rngInt(64, 82);
					}
					
					if (rand.nextInt(100) <= 45) {
						this.treeGen.generate(world, rand, this.chunkPos.add(x, y, z));
					}
				}
			}
		}
		
		// Jungle Trees
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.TREE)) {
			if (this.generateJungleTrees && this.jungleTreesPerChunk > 0) {
				for (int i = 0; i <= this.jungleTreesPerChunk; ++i) {
					y = rand.nextInt(rand.nextInt(genY) + 8);
					if (y < 64) {
						y = ZGHelper.rngInt(64, 82);
					}
					
					IBlockState JUNGLE_LOG = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE);
					IBlockState JUNGLE_LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.JUNGLE).withProperty(BlockLeaves.CHECK_DECAY,
							Boolean.valueOf(false));
					IBlockState OAK_LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.OAK).withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
					
					if (rand.nextInt(100) <= 85) {
						this.jungleTreeGen = rand.nextInt(2) == 0 ? new WorldGenMegaJungle(false, 10, 20, JUNGLE_LOG, JUNGLE_LEAF)
								: new WorldGenTrees(false, 4 + rand.nextInt(7), JUNGLE_LOG, JUNGLE_LEAF, true);
						this.jungleTreeGen.generate(world, rand, this.chunkPos.add(x, y, z));
					}
				}
			}
		}
		
		// Mushroom Trees
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.BIG_SHROOM)) {
			if (this.generateMushroomTrees && this.mushroomTreesPerChunk > 0) {
				for (int i = 0; i < this.mushroomTreesPerChunk; ++i) {
					y = rand.nextInt(rand.nextInt(genY) + 8);
					if (y < 64) {
						y = ZGHelper.rngInt(64, 82);
					}
					
					if (rand.nextInt(100) <= 45) {
						this.treeGenMushroom.generate(world, rand, this.chunkPos.add(x, 0, z));
					}
				}
			}
		}
		
		// Craters
		if (this.generateCraters) {
			ChunkProviderMetztli.INSTANCE.createCraters(x, z, chunkPrimer);
		}
		
		// Cactus
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.CACTUS)) {
			if (rand.nextInt(2) == 0) {
				for (int i = 0; i < this.cactiPerChunk; ++i) {
					int x1 = rand.nextInt(16) + 8;
					int z1 = rand.nextInt(16) + 8;
					int y1 = world.getHeight(this.chunkPos.add(x1, 0, z1)).getY() * 2;
					if (y1 > 0) {
						int y2 = rand.nextInt(y1);
						this.cactusGen.generate(world, rand, this.chunkPos.add(x1, y2, z1));
					}
				}
			}
		}
		
		// Dead Bush
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.DEAD_BUSH)) {
			if (rand.nextInt(2) == 0) {
				for (int i = 0; i < this.deadBushPerChunk; ++i) {
					int x1 = rand.nextInt(16) + 8;
					int z1 = rand.nextInt(16) + 8;
					int y1 = world.getHeight(this.chunkPos.add(x1, 0, z1)).getY() * 2;
					if (y1 > 0) {
						int y2 = rand.nextInt(y1);
						this.deadBushGen.generate(world, rand, this.chunkPos.add(x1, y2, z1));
					}
				}
			}
		}
		
		// Reeds
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.REED)) {
			if (rand.nextInt(4) == 0) {
				for (int i = 0; i < this.reedsPerChunk; ++i) {
					int x1 = rand.nextInt(16) + 8;
					int z1 = rand.nextInt(16) + 8;
					int y1 = world.getHeight(this.chunkPos.add(x1, 0, z1)).getY() * 2;
					if (y1 > 0) {
						int y2 = rand.nextInt(y1);
						this.reedGen.generate(world, rand, this.chunkPos.add(x1, y2, z1));
					}
				}
			}
		}
		
		// Clay
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.CLAY)) {
			for (int i1 = 0; i1 < this.clayPerChunk; ++i1) {
				int l1 = rand.nextInt(16) + 8;
				int i6 = rand.nextInt(16) + 8;
				this.clayGen.generate(world, rand, world.getTopSolidOrLiquidBlock(this.chunkPos.add(l1, 0, i6)));
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
		
		// Random Tree Feature
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.TREE)) {
			if (rand.nextInt(6) == 0) {
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
				for (int l5 = 0; l5 < 20; ++l5) {
					int j10 = rand.nextInt(16) + 8;
					int i14 = rand.nextInt(16) + 8;
					int j17 = rand.nextInt(rand.nextInt(rand.nextInt(112) + 8) + 8);
					BlockPos blockpos3 = this.chunkPos.add(j10, j17, i14);
					(new WorldGenLiquids(Blocks.FLOWING_LAVA)).generate(world, rand, blockpos3);
				}
		}
		
		// Mushrooms (Small)
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.SHROOM)) {
			if (this.generateMushrooms) {
				for (int l3 = 0; l3 < this.mushroomsPerChunk; ++l3) {
					if (rand.nextInt(4) == 0) {
						int i8 = rand.nextInt(16) + 8;
						int l11 = rand.nextInt(16) + 8;
						BlockPos blockpos2 = world.getHeight(this.chunkPos.add(i8, 0, l11));
						this.mushroomBrownGen.generate(world, rand, blockpos2);
					}
					
					if (rand.nextInt(8) == 0) {
						int j8 = rand.nextInt(16) + 8;
						int i12 = rand.nextInt(16) + 8;
						int j15 = world.getHeight(this.chunkPos.add(j8, 0, i12)).getY() * 2;
						
						if (j15 > 0) {
							int k18 = rand.nextInt(j15);
							BlockPos blockpos5 = this.chunkPos.add(j8, k18, i12);
							this.mushroomRedGen.generate(world, rand, blockpos5);
						}
					}
				}
				
				if (rand.nextInt(4) == 0) {
					int i4 = rand.nextInt(16) + 8;
					int k8 = rand.nextInt(16) + 8;
					int j12 = world.getHeight(this.chunkPos.add(i4, 0, k8)).getY() * 2;
					
					if (j12 > 0) {
						int k15 = rand.nextInt(j12);
						this.mushroomBrownGen.generate(world, rand, this.chunkPos.add(i4, k15, k8));
					}
				}
				
				if (rand.nextInt(8) == 0) {
					int j4 = rand.nextInt(16) + 8;
					int l8 = rand.nextInt(16) + 8;
					int k12 = world.getHeight(this.chunkPos.add(j4, 0, l8)).getY() * 2;
					
					if (k12 > 0) {
						int l15 = rand.nextInt(k12);
						this.mushroomRedGen.generate(world, rand, this.chunkPos.add(j4, l15, l8));
					}
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