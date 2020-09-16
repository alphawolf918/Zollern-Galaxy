/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.biomes.decorators;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.blocks.ZGBlockTallGrass;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.blocks.fluids.ZGFluids;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.ZGLootTables;
import zollerngalaxy.core.enums.EnumOreGenZG;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.worldgen.WorldGenLakesZG;
import zollerngalaxy.worldgen.WorldGenMinableZG;
import zollerngalaxy.worldgen.WorldGenOutpost;
import zollerngalaxy.worldgen.WorldGenTallGrassZG;
import zollerngalaxy.worldgen.WorldGenTreasure;
import zollerngalaxy.worldgen.perdita.WorldGenLostCactus;
import zollerngalaxy.worldgen.perdita.WorldGenLostDeadBush;
import zollerngalaxy.worldgen.perdita.WorldGenLostReeds;
import zollerngalaxy.worldgen.perdita.WorldGenPalmwoodTrees;

public class BiomeDecoratorPerdita extends BiomeDecoratorZG {
	
	private static final Block SAND = ZGBlocks.perdSand;
	private static final Block STONE = ZGBlocks.perdStone;
	private static final Block ROCK = ZGBlocks.perdRock;
	
	public int lostCactiPerChunk = 10;
	public int lostDeadBushPerChunk = 5;
	public int lostTallGrassPerChunk = 0;
	public int lostPalmWoodTreesPerChunk = 0;
	public int lostLakesPerChunk = 0;
	public int lostReedsPerChunk = 0;
	public int lostFueltoniumLakesPerChunk = 0;
	public int lostTreasurePerChunk = 1;
	
	private WorldGenerator creepstoneGen;
	private WorldGenerator creepdirtGen;
	private WorldGenerator cavestoneGen;
	private WorldGenerator perdDiamondOreGen;
	private WorldGenerator perdEtriumOreGen;
	private WorldGenerator perdIronOreGen;
	private WorldGenerator perdGoldOreGen;
	private WorldGenerator perdZollerniumOreGen;
	private WorldGenerator perdFueltoniumOreGen;
	
	private WorldGenerator lostCactusGen = new WorldGenLostCactus();
	private WorldGenerator lostDeadBushGen = new WorldGenLostDeadBush();
	private WorldGenerator lostLakeGen = new WorldGenLakesZG(Blocks.WATER, ZGBlocks.perdGrass);
	private WorldGenerator lostTallGrassGen = new WorldGenTallGrassZG((ZGBlockTallGrass) ZGBlocks.perdTallGrass);
	private WorldGenerator lostReedGen = new WorldGenLostReeds();
	private WorldGenerator lostPalmWoodTreeGen = new WorldGenPalmwoodTrees(true, ZGHelper.rngInt(5, 15),
			ZGBlocks.perdWoodLogs.getDefaultState(), ZGBlocks.perdWoodLeaves.getDefaultState(), false);
	private WorldGenerator lostFueltoniumLakeGen = new WorldGenLakesZG(ZGFluids.blockFueltoniumFluid, ZGBlocks.perdSand);
	private WorldGenerator lostTreasureGen = new WorldGenTreasure(ZGLootTables.CHEST_BURIED_TREASURE);
	
	public BiomeDecoratorPerdita() {
		this.creepstoneGen = new WorldGenMinableZG(ZGBlocks.perdCreepStone, STONE, EnumOreGenZG.SPECIAL_STONE);
		this.creepdirtGen = new WorldGenMinableZG(ZGBlocks.perdCreepDirt, STONE, EnumOreGenZG.DIRT.setMaxHeight(32));
		this.cavestoneGen = new WorldGenMinableZG(ZGBlocks.perdCaveStone, STONE, EnumOreGenZG.SPECIAL_STONE);
		this.perdDiamondOreGen = new WorldGenMinableZG(ZGBlocks.perdDiamondOre, STONE, EnumOreGenZG.DIAMOND);
		this.perdEtriumOreGen = new WorldGenMinableZG(ZGBlocks.perdEtriumOre, STONE, EnumOreGenZG.EMERALD);
		this.perdIronOreGen = new WorldGenMinableZG(ZGBlocks.perdIronOre, STONE, EnumOreGenZG.IRON);
		this.perdGoldOreGen = new WorldGenMinableZG(ZGBlocks.perdGoldOre, STONE, EnumOreGenZG.GOLD);
		this.perdZollerniumOreGen = new WorldGenMinableZG(ZGBlocks.perdZollerniumOre, STONE, EnumOreGenZG.ZOLLERNIUM);
		this.perdFueltoniumOreGen = new WorldGenMinableZG(ZGBlocks.perdFueltoniumOre, STONE, EnumOreGenZG.FUELTONIUM);
	}
	
	@Override
	protected void generate(Biome biome, World world, Random rand) {
		int x = rand.nextInt(16) + 8;
		int z = rand.nextInt(16) + 8;
		int y = rand.nextInt(248) + 8;
		
		int genY = y;
		
		if (biome instanceof BiomeSpace) {
			BiomeSpace spaceBiome = (BiomeSpace) biome;
			genY = spaceBiome.getBiomeHeight();
		}
		
		this.generateOre(this.creepstoneGen, EnumOreGenZG.SPECIAL_STONE, world, rand);
		this.generateOre(this.creepdirtGen, EnumOreGenZG.SPECIAL_STONE, world, rand);
		this.generateOre(this.cavestoneGen, EnumOreGenZG.SPECIAL_STONE, world, rand);
		this.generateOre(this.perdDiamondOreGen, EnumOreGenZG.DIAMOND, world, rand);
		this.generateOre(this.perdEtriumOreGen, EnumOreGenZG.EMERALD, world, rand);
		this.generateOre(this.perdIronOreGen, EnumOreGenZG.IRON, world, rand);
		this.generateOre(this.perdGoldOreGen, EnumOreGenZG.GOLD, world, rand);
		this.generateOre(this.perdZollerniumOreGen, EnumOreGenZG.ZOLLERNIUM, world, rand);
		this.generateOre(this.perdFueltoniumOreGen, EnumOreGenZG.FUELTONIUM, world, rand);
		
		ChunkPos forgeChunkPos = new ChunkPos(chunkPos);
		
		// Lost Cactus
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.CACTUS)) {
			if (rand.nextInt(12) == 0) {
				for (int i = 0; i < this.lostCactiPerChunk; ++i) {
					int x1 = rand.nextInt(16) + 8;
					int z1 = rand.nextInt(16) + 8;
					int y1 = world.getHeight(this.chunkPos.add(x1, 0, z1)).getY() * 2;
					if (y1 > 0) {
						int y2 = rand.nextInt(y1);
						this.lostCactusGen.generate(world, rand, this.chunkPos.add(x1, y2, z1));
					}
				}
			}
		}
		
		// Lost Dead Bush
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.DEAD_BUSH)) {
			if (rand.nextInt(6) == 0) {
				for (int i = 0; i < this.lostDeadBushPerChunk; ++i) {
					int x1 = rand.nextInt(16) + 8;
					int z1 = rand.nextInt(16) + 8;
					int y1 = world.getHeight(this.chunkPos.add(x1, 0, z1)).getY() * 2;
					if (y1 > 0) {
						int y2 = rand.nextInt(y1);
						this.lostDeadBushGen.generate(world, rand, this.chunkPos.add(x1, y2, z1));
					}
				}
			}
		}
		
		// Palmwood Trees
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.TREE)) {
			if (rand.nextInt(6) == 0) {
				for (int i = 0; i < this.lostPalmWoodTreesPerChunk; ++i) {
					int x1 = rand.nextInt(16) + 8;
					int z1 = rand.nextInt(16) + 8;
					int y1 = world.getHeight(this.chunkPos.add(x1, 0, z1)).getY() * 2;
					if (y1 > 0) {
						int y2 = rand.nextInt(y1);
						this.lostPalmWoodTreeGen.generate(world, rand, this.chunkPos.add(x1, y2, z1));
					}
				}
			}
		}
		
		// Lake gen for Lost Oasis biome
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.LAKE_WATER)) {
			if (rand.nextInt(2) == 0) {
				for (int i = 0; i < this.lostLakesPerChunk; ++i) {
					int x1 = rand.nextInt(16) + 8;
					int z1 = rand.nextInt(16) + 8;
					int y1 = world.getHeight(this.chunkPos.add(x1, 0, z1)).getY() * 2;
					if (y1 > 0) {
						int y2 = rand.nextInt(y1);
						this.lostLakeGen.generate(world, rand, this.chunkPos.add(x1, y2, z1));
					}
				}
			}
		}
		
		// Fueltonium lakes
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.LAKE_LAVA)) {
			if (rand.nextInt(5) == 0) {
				for (int i = 0; i < this.lostFueltoniumLakesPerChunk; ++i) {
					int x1 = rand.nextInt(16) + 8;
					int z1 = rand.nextInt(16) + 8;
					int y1 = world.getHeight(this.chunkPos.add(x1, 0, z1)).getY() * 2;
					if (y1 > 0) {
						int y2 = rand.nextInt(y1);
						this.lostFueltoniumLakeGen.generate(world, rand, this.chunkPos.add(x1, y2, z1));
					}
				}
			}
		}
		
		// Lost Tall Grass
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.GRASS)) {
			if (rand.nextInt(2) == 0) {
				for (int i = 0; i < this.lostTallGrassPerChunk; ++i) {
					int x1 = rand.nextInt(16) + 8;
					int z1 = rand.nextInt(16) + 8;
					int y1 = world.getHeight(this.chunkPos.add(x1, 0, z1)).getY() * 2;
					if (y1 > 0) {
						int y2 = rand.nextInt(y1);
						this.lostTallGrassGen.generate(world, rand, this.chunkPos.add(x1, y2, z1));
					}
				}
			}
		}
		
		// Lost Bamboo
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.REED)) {
			if (rand.nextInt(3) == 0) {
				for (int i = 0; i < this.lostReedsPerChunk; ++i) {
					int x1 = rand.nextInt(16) + 8;
					int z1 = rand.nextInt(16) + 8;
					int y1 = world.getHeight(this.chunkPos.add(x1, 0, z1)).getY() * 2;
					if (y1 > 0) {
						int y2 = rand.nextInt(y1);
						this.lostReedGen.generate(world, rand, this.chunkPos.add(x1, y2, z1));
					}
				}
			}
		}
		
		// Chest Gen
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.FOSSIL)) {
			if (rand.nextInt(25) == 0) {
				for (int i = 0; i < this.lostTreasurePerChunk; i++) {
					int x1 = rand.nextInt(16) + 8;
					int z1 = rand.nextInt(16) + 8;
					int y1 = world.getHeight(this.chunkPos.add(x1, 0, z1)).getY() * 2;
					if (y1 > 0) {
						int y2 = rand.nextInt(y1);
						BlockPos chestPos = this.chunkPos.add(x1, y2, z1);
						chestPos = chestPos.down();
						this.lostTreasureGen.generate(world, rand, chestPos);
					}
				}
			}
		}
		
		if (this.generateOutposts && this.outpostsPerChunk > 0) {
			y = rand.nextInt(rand.nextInt(genY) + 8);
			if (y >= 62) {
				WorldGenerator outpostGen = new WorldGenOutpost(ZGBlocks.blockOutpost.getDefaultState(),
						ZGBlocks.blockOutpost.getDefaultState());
				for (int i = 0; i < this.outpostsPerChunk; i++) {
					if (rand.nextInt(100) <= ConfigManagerZG.outpostGenChance) {
						outpostGen.generate(world, rand, this.chunkPos.add(x, y, z));
					}
				}
			}
		}
	}
}