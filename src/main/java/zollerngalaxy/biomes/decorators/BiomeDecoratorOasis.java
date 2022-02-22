/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.decorators;

import java.util.Random;
import micdoodle8.mods.galacticraft.core.GCBlocks;
import micdoodle8.mods.galacticraft.core.event.EventHandlerGC;
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
import net.minecraft.world.gen.feature.WorldGenLiquids;
import net.minecraft.world.gen.feature.WorldGenWaterlily;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.blocks.ZGBlockTallGrass;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.core.enums.EnumOreGenZG;
import zollerngalaxy.lib.helpers.ZGDecorateHelper;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.util.BiomeUtils;
import zollerngalaxy.worldgen.WorldGenBattleTower;
import zollerngalaxy.worldgen.WorldGenClayZG;
import zollerngalaxy.worldgen.WorldGenCrops;
import zollerngalaxy.worldgen.WorldGenFlowersZG;
import zollerngalaxy.worldgen.WorldGenLakesZG;
import zollerngalaxy.worldgen.WorldGenMinableZG;
import zollerngalaxy.worldgen.WorldGenOutpost;
import zollerngalaxy.worldgen.WorldGenSandZG;
import zollerngalaxy.worldgen.WorldGenTallGrassZG;

public class BiomeDecoratorOasis extends BiomeDecoratorZG {
	
	public static final Block SURFACE_ROCK = ZGBlocks.oasisRock;
	public static final Block STONE = ZGBlocks.oasisStone;
	
	private WorldGenerator dirtOreGen;
	private WorldGenerator gravelOreGen;
	private WorldGenerator superChargedCoalGen;
	private WorldGenerator diamondGen;
	private WorldGenerator redstoneGen;
	private WorldGenerator coalGen;
	private WorldGenerator ironGen;
	private WorldGenerator goldGen;
	private WorldGenerator tinGen;
	private WorldGenerator leadGen;
	private WorldGenerator shinestoneGen;
	
	public WorldGenerator battleTowerGen = new WorldGenBattleTower(ZGBlocks.oasisCobble.getDefaultState(), ZGBlocks.blockOutpost.getDefaultState());
	public WorldGenerator clayGen = new WorldGenClayZG(ZGBlocks.mudClayBlock, 8);
	public WorldGenerator gravelGen = new WorldGenSandZG(ZGBlocks.oasisGravel, 6);
	public WorldGenerator sandGen = new WorldGenSandZG(ZGBlocks.oasisSand, 7);
	public WorldGenerator flowerGen = new WorldGenFlowersZG(ZGBlocks.oasisFlower.getDefaultState());
	public WorldGenerator treeGen;
	public WorldGenerator cropGen;
	
	public int waterLakesPerChunk = 4;
	public int lavaLakesPerChunk = (this.enableExtremeMode) ? 12 : 6;
	public int oilLakesPerChunk = 2;
	public int oasisTallGrassPerChunk = 3;
	public int oasisFlowersPerChunk = 4;
	public int battleTowersPerChunk = 2;
	public int clayPerChunk = 2;
	public int cropsPerChunk = 2;
	public int gravelPatchesPerChunk = 2;
	public int sandPatchesPerChunk = 3;
	public int treesPerChunk = 1;
	public int flowersPerChunk = 6;
	public int waterlilyPerChunk = 0;
	
	public boolean generateLakes = true;
	public boolean generateVines = false;
	public boolean generateCraters = false;
	public boolean generateBattleTowers = true;
	public boolean generateCrops = true;
	public boolean generateClay = true;
	public boolean generateFalls = true;
	public boolean generateTrees = true;
	public boolean generateTallGrass = true;
	public boolean generateFlowers = true;
	public boolean generateGravel = true;
	public boolean generateSand = true;
	
	public BiomeDecoratorOasis() {
		this.dirtOreGen = new WorldGenMinableZG(ZGBlocks.oasisDirt, STONE, EnumOreGenZG.DIRT);
		this.gravelOreGen = new WorldGenMinableZG(ZGBlocks.oasisGravel, STONE, EnumOreGenZG.GRAVEL);
		this.superChargedCoalGen = new WorldGenMinableZG(ZGBlocks.oasisSuperChargedCoalOre, STONE, EnumOreGenZG.SUPER_CHARGED_COAL);
		this.diamondGen = new WorldGenMinableZG(ZGBlocks.oasisDiamondOre, STONE, EnumOreGenZG.DIAMOND);
		this.redstoneGen = new WorldGenMinableZG(ZGBlocks.oasisRedstoneOre, STONE, EnumOreGenZG.REDSTONE);
		this.coalGen = new WorldGenMinableZG(ZGBlocks.oasisCoalOre, STONE, EnumOreGenZG.COAL);
		this.ironGen = new WorldGenMinableZG(ZGBlocks.oasisIronOre, STONE, EnumOreGenZG.IRON);
		this.goldGen = new WorldGenMinableZG(ZGBlocks.oasisGoldOre, STONE, EnumOreGenZG.GOLD);
		this.tinGen = new WorldGenMinableZG(ZGBlocks.oasisTinOre, STONE, EnumOreGenZG.TIN);
		this.leadGen = new WorldGenMinableZG(ZGBlocks.oasisLeadOre, STONE, EnumOreGenZG.LEAD);
		this.shinestoneGen = new WorldGenMinableZG(ZGBlocks.blockShinestone, STONE, EnumOreGenZG.SHINESTONE);
	}
	
	@Override
	protected void generate(Biome biome, World world, Random rand) {
		int x = rand.nextInt(16) + 8;
		int z = rand.nextInt(16) + 8;
		
		int genY = 248;
		int y = genY;
		
		Block BLOCK_TOP = biome.topBlock.getBlock();
		Block BLOCK_FILL = biome.fillerBlock.getBlock();
		Block BLOCK_STONE = STONE;
		
		this.generateOre(this.dirtOreGen, EnumOreGenZG.DIRT, world, rand);
		this.generateOre(this.gravelOreGen, EnumOreGenZG.GRAVEL, world, rand);
		this.generateOre(this.superChargedCoalGen, EnumOreGenZG.SUPER_CHARGED_COAL, world, rand);
		this.generateOre(this.diamondGen, EnumOreGenZG.DIAMOND, world, rand);
		this.generateOre(this.redstoneGen, EnumOreGenZG.REDSTONE, world, rand);
		this.generateOre(this.ironGen, EnumOreGenZG.IRON, world, rand);
		this.generateOre(this.coalGen, EnumOreGenZG.COAL, world, rand);
		this.generateOre(this.goldGen, EnumOreGenZG.GOLD, world, rand);
		this.generateOre(this.tinGen, EnumOreGenZG.TIN, world, rand);
		this.generateOre(this.leadGen, EnumOreGenZG.LEAD, world, rand);
		this.generateOre(this.shinestoneGen, EnumOreGenZG.SHINESTONE, world, rand);
		
		ChunkPrimer chunkPrimer = new ChunkPrimer();
		ChunkPos forgeChunkPos = new ChunkPos(this.chunkPos);
		
		if (biome instanceof BiomeSpace) {
			BiomeSpace spaceBiome = (BiomeSpace) biome;
			genY = spaceBiome.getBiomeHeight();
		}
		
		// Water Lakes
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.LAKE_WATER)) {
			if (this.generateLakes && this.waterLakesPerChunk > 0) {
				for (int i = 0; i < this.waterLakesPerChunk; ++i) {
					y = rand.nextInt(rand.nextInt(genY) + 8);
					Block blockToUse = (biome.getTempCategory() == TempCategory.COLD) ? Blocks.ICE : Blocks.WATER;
					(new WorldGenLakesZG(blockToUse, BLOCK_TOP)).generate(world, rand, this.chunkPos.add(x, y, z));
				}
				
				// Lilypads
				if (this.waterlilyPerChunk > 0) {
					for (int i = 0; i < this.waterlilyPerChunk; ++i) {
						(new WorldGenWaterlily()).generate(world, rand, this.chunkPos.add(x, y, z));
					}
				}
			}
		}
		
		// Lava Lakes
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.LAKE_LAVA)) {
			if (this.generateLakes && this.lavaLakesPerChunk > 0) {
				for (int i = 0; i < this.lavaLakesPerChunk; ++i) {
					y = rand.nextInt(rand.nextInt(genY) + 8);
					if (rand.nextInt(100) <= 5) {
						(new WorldGenLakesZG(Blocks.LAVA, STONE)).generate(world, rand, this.chunkPos.add(x, y, z));
					}
				}
			}
		}
		
		// Oil Lakes
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.CUSTOM)) {
			if (this.generateOil && this.oilPerChunk > 0 && ConfigManagerZG.enableOilLakes) {
				for (int i = 0; i < this.oilPerChunk; ++i) {
					y = rand.nextInt(rand.nextInt(genY) + 8);
					(new WorldGenLakesZG(GCBlocks.crudeOil, BLOCK_STONE)).generate(world, rand, this.chunkPos.add(x, y, z));
					EventHandlerGC.generateOil(world, rand, x, z, false);
				}
			}
		}
		
		// Tall Grass
		if (this.generateTallGrass && this.oasisTallGrassPerChunk > 0) {
			for (int i = 0; i < this.oasisTallGrassPerChunk + 4; ++i) {
				ZGDecorateHelper.generatePlants(new WorldGenTallGrassZG((ZGBlockTallGrass) ZGBlocks.oasisTallGrass), world, rand, this.chunkPos);
			}
		}
		
		// Flowers
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.FLOWERS)) {
			if (this.generateFlowers && this.flowersPerChunk > 0) {
				for (int l2 = 0; l2 < this.flowersPerChunk; ++l2) {
					int i7 = rand.nextInt(16) + 8;
					int l10 = rand.nextInt(16) + 8;
					int j14 = world.getHeight(this.chunkPos.add(i7, 0, l10)).getY() + 32;
					
					if (j14 > 0) {
						int k17 = rand.nextInt(j14);
						BlockPos blockpos1 = this.chunkPos.add(i7, k17, l10);
						Block blockflower = ZGBlocks.oasisFlower;
						
						if (blockflower.getDefaultState().getMaterial() != Material.AIR) {
							this.flowerGen.generate(world, rand, blockpos1);
						}
					}
				}
			}
		}
		
		// Clay
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.CLAY)) {
			if (this.generateClay && this.clayPerChunk > 0) {
				for (int i1 = 0; i1 < this.clayPerChunk; ++i1) {
					int l1 = rand.nextInt(16) + 8;
					int i6 = rand.nextInt(16) + 8;
					this.clayGen.generate(world, rand, world.getTopSolidOrLiquidBlock(this.chunkPos.add(l1, 0, i6)));
				}
			}
		}
		
		// Gravel
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.SAND_PASS2)) {
			if (this.generateGravel && this.gravelPatchesPerChunk > 0) {
				for (int j1 = 0; j1 < this.gravelPatchesPerChunk; ++j1) {
					int i2 = rand.nextInt(16) + 8;
					int j6 = rand.nextInt(16) + 8;
					this.gravelGen.generate(world, rand, world.getTopSolidOrLiquidBlock(this.chunkPos.add(i2, 0, j6)));
				}
			}
		}
		
		// Sand
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.SAND)) {
			if (this.generateSand && this.sandPatchesPerChunk > 0) {
				for (int i = 0; i < this.sandPatchesPerChunk; ++i) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					this.sandGen.generate(world, rand, world.getTopSolidOrLiquidBlock(this.chunkPos.add(j, 0, k)));
				}
			}
		}
		
		int k1 = this.treesPerChunk;
		
		if (rand.nextFloat() < this.extraTreeChance) {
			++k1;
		}
		
		// Trees
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.TREE)) {
			if (this.generateTrees && this.treesPerChunk > 0) {
				for (int i = 0; i < k1; ++i) {
					y = rand.nextInt(rand.nextInt(genY) + 8);
					if (y < 64) {
						y = ZGHelper.rngInt(64, 82);
					}
					
					if (rand.nextInt(100) <= 45) {
						this.treeGen = ZGHelper.getRandomFruitTree(rand);
						this.treeGen.generate(world, rand, this.chunkPos.add(x, y, z));
					}
				}
			}
		}
		
		// Battle Towers
		if (this.generateBattleTowers && this.battleTowersPerChunk > 0 && !BiomeUtils.isOceanBiome(biome)) {
			if (ZGHelper.rngInt(1, 100) <= 35) {
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
			if (ZGHelper.rngInt(1, 100) <= 35) {
				for (int i = 0; i < this.cropsPerChunk; ++i) {
					y = rand.nextInt(rand.nextInt(genY) + 8);
					if (y >= 60) {
						this.cropGen = new WorldGenCrops(ZGHelper.getRandomCrop(rand).getDefaultState());
						this.cropGen.generate(world, rand, this.chunkPos.add(x, y, z));
					}
				}
			}
		}
		
		// Falls
		if (this.generateFalls) {
			if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.LAKE_WATER)) {
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
			}
			
			if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.LAKE_LAVA)) {
				for (int l5 = 0; l5 < 20; ++l5) {
					int j10 = rand.nextInt(16) + 8;
					int i14 = rand.nextInt(16) + 8;
					int j17 = rand.nextInt(rand.nextInt(rand.nextInt(112) + 8) + 8);
					BlockPos blockpos3 = this.chunkPos.add(j10, j17, i14);
					(new WorldGenLiquids(Blocks.FLOWING_LAVA)).generate(world, rand, blockpos3);
				}
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