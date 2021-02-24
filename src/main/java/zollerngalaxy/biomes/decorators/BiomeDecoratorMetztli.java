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
import net.minecraft.block.BlockTallGrass;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.TempCategory;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenCactus;
import net.minecraft.world.gen.feature.WorldGenDeadBush;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenWaterlily;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.dimensions.chunkproviders.ChunkProviderMetztli;
import zollerngalaxy.core.enums.EnumOreGenZG;
import zollerngalaxy.lib.helpers.ZGDecorateHelper;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.worldgen.WorldGenLakesZG;
import zollerngalaxy.worldgen.WorldGenMinableZG;
import zollerngalaxy.worldgen.WorldGenOutpost;
import zollerngalaxy.worldgen.WorldGenZGMushroomTree;

public class BiomeDecoratorMetztli extends BiomeDecoratorZG {
	
	private WorldGenerator dirtGen;
	private WorldGenerator ironGen;
	private WorldGenerator goldGen;
	private WorldGenerator redstoneGen;
	private WorldGenerator diamondGen;
	private WorldGenerator emeraldGen;
	
	private WorldGenerator tallGrassGen = new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);
	private WorldGenerator treeGenMushroom = new WorldGenZGMushroomTree(false, ZGHelper.rngInt(3, 6));
	private WorldGenerator waterLilyGen = new WorldGenWaterlily();
	private WorldGenerator treeGen = new WorldGenBigTree(true);
	private WorldGenerator cactusGen = new WorldGenCactus();
	private WorldGenerator deadBushGen = new WorldGenDeadBush();
	
	public int waterLakesPerChunk = 3;
	public int lavaLakesPerChunk = 4;
	public int waterLilyPerChunk = 4;
	public int tallGrassPerChunk = 6;
	public int treesPerChunk = 4;
	public int mushroomTreesPerChunk = 2;
	public int cactiPerChunk = 5;
	public int deadBushesPerChunk = 4;
	public int reedsPerChunk = 4;
	
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
	
	public BiomeDecoratorMetztli() {
		this.dirtGen = new WorldGenMinableZG(Blocks.DIRT, Blocks.GRASS, EnumOreGenZG.DIRT);
		this.ironGen = new WorldGenMinableZG(Blocks.IRON_ORE, Blocks.STONE, EnumOreGenZG.IRON);
		this.goldGen = new WorldGenMinableZG(Blocks.GOLD_ORE, Blocks.STONE, EnumOreGenZG.GOLD);
		this.redstoneGen = new WorldGenMinableZG(Blocks.REDSTONE_ORE, Blocks.STONE, EnumOreGenZG.REDSTONE);
		this.diamondGen = new WorldGenMinableZG(Blocks.DIAMOND_ORE, Blocks.STONE, EnumOreGenZG.DIAMOND);
		this.emeraldGen = new WorldGenMinableZG(Blocks.EMERALD_ORE, Blocks.STONE, EnumOreGenZG.EMERALD);
	}
	
	@Override
	protected void generate(Biome biome, World world, Random rand) {
		int x = rand.nextInt(16) + 8;
		int z = rand.nextInt(16) + 8;
		int y = rand.nextInt(248) + 8;
		
		ChunkPrimer chunkPrimer = new ChunkPrimer();
		ChunkPos forgeChunkPos = new ChunkPos(chunkPos);
		
		Block BLOCK_TOP = biome.topBlock.getBlock();
		Block BLOCK_FILL = biome.fillerBlock.getBlock();
		Block BLOCK_STONE = Blocks.STONE;
		
		this.generateOre(this.dirtGen, EnumOreGenZG.DIRT, world, rand);
		this.generateOre(this.ironGen, EnumOreGenZG.IRON, world, rand);
		this.generateOre(this.goldGen, EnumOreGenZG.GOLD, world, rand);
		this.generateOre(this.redstoneGen, EnumOreGenZG.REDSTONE, world, rand);
		this.generateOre(this.diamondGen, EnumOreGenZG.DIAMOND, world, rand);
		this.generateOre(this.emeraldGen, EnumOreGenZG.EMERALD, world, rand);
		
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
				Block blockToUse = (biome.getTempCategory() == TempCategory.COLD) ? Blocks.ICE : Blocks.WATER;
				(new WorldGenLakesZG(blockToUse, BLOCK_TOP)).generate(world, rand, this.chunkPos.add(x, y, z));
			}
			
			// Water Lilies
			if (this.generateWaterLilies && this.waterlilyPerChunk > 0) {
				for (int i = 0; i < this.waterlilyPerChunk; ++i) {
					waterLilyGen.generate(world, rand, this.chunkPos.add(x, y, z));
				}
			}
		}
		
		// Tall Grass
		if (this.generateTallGrass && this.tallGrassPerChunk > 0) {
			for (int i = 0; i < this.tallGrassPerChunk + 4; ++i) {
				ZGDecorateHelper.generatePlants(this.tallGrassGen, world, rand, this.chunkPos);
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
					
					if (rand.nextInt(100) <= 50) {
						treeGen.generate(world, rand, this.chunkPos.add(x, y, z));
					}
				}
			}
		}
		
		// Mushroom Trees
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.BIG_SHROOM)) {
			if (this.generateTrees && this.mushroomTreesPerChunk > 0) {
				for (int i = 0; i < this.mushroomTreesPerChunk; ++i) {
					y = rand.nextInt(rand.nextInt(genY) + 8);
					if (y < 64) {
						y = ZGHelper.rngInt(64, 82);
					}
					
					if (rand.nextInt(100) <= 45) {
						treeGenMushroom.generate(world, rand, this.chunkPos.add(x, y, z));
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
			if (rand.nextInt(12) == 0) {
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
			if (rand.nextInt(6) == 0) {
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
			if (rand.nextInt(3) == 0) {
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
		
		// Outposts
		if (this.generateOutposts && this.outpostsPerChunk > 0) {
			y = rand.nextInt(rand.nextInt(genY) + 8);
			if (y >= 62) {
				WorldGenerator outpostGen = new WorldGenOutpost(ZGBlocks.blockOutpost.getDefaultState(), ZGBlocks.blockOutpost.getDefaultState());
				for (int i = 0; i < this.outpostsPerChunk; i++) {
					if (rand.nextInt(100) <= ConfigManagerZG.outpostGenChance) {
						outpostGen.generate(world, rand, this.chunkPos.add(x, y, z));
					}
				}
			}
		}
	}
}