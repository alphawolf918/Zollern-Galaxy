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
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.blocks.ZGWaterGrass;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.ZGLootTables;
import zollerngalaxy.core.dimensions.chunkproviders.ChunkProviderAltum;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.core.enums.EnumOreGenZG;
import zollerngalaxy.worldgen.WorldGenLakesZG;
import zollerngalaxy.worldgen.WorldGenMinableZG;
import zollerngalaxy.worldgen.WorldGenOutpost;
import zollerngalaxy.worldgen.WorldGenWaterGrass;

public class BiomeDecoratorAltum extends BiomeDecoratorZG {
	
	private static final Block STONE = ZGBlocks.altumStone;
	
	private WorldGenerator amaranthGen;
	private WorldGenerator redstoneGen;
	private WorldGenerator ironGen;
	private WorldGenerator diamondGen;
	private WorldGenerator zollerniumGen;
	private WorldGenerator goldGen;
	private WorldGenerator eveniumGen;
	private WorldGenerator rhodiumGen;
	private WorldGenerator coalGen;
	private WorldGenerator prismarineGen;
	
	public int waterLakesPerChunk = 2;
	public int treasurePerChunk = 1;
	public int seaweedPerChunk = 2;
	
	private ResourceLocation oceanLootTable = ZGLootTables.CHEST_OCEAN_TREASURE;
	
	private int seaLevel = ChunkProviderAltum.SEA_LEVEL;
	
	private WorldGenerator waterLakeGen = new WorldGenLakesZG(Blocks.WATER, ZGBlocks.altumSand);
	// private WorldGenerator treasureGen = new
	// WorldGenTreasure(oceanLootTable).setLootTable(oceanLootTable);
	private WorldGenerator seaweedGen = new WorldGenWaterGrass((ZGWaterGrass) ZGBlocks.altumSeaweed);
	
	public BiomeDecoratorAltum() {
		this.amaranthGen = new WorldGenMinableZG(ZGBlocks.altumAmaranthOre, STONE, EnumOreGenZG.AMARANTH);
		this.redstoneGen = new WorldGenMinableZG(ZGBlocks.altumRedstoneOre, STONE, EnumOreGenZG.REDSTONE);
		this.diamondGen = new WorldGenMinableZG(ZGBlocks.altumDiamondOre, STONE, EnumOreGenZG.DIAMOND);
		this.zollerniumGen = new WorldGenMinableZG(ZGBlocks.altumZollerniumOre, STONE, EnumOreGenZG.ZOLLERNIUM);
		this.ironGen = new WorldGenMinableZG(ZGBlocks.altumIronOre, STONE, EnumOreGenZG.IRON);
		this.goldGen = new WorldGenMinableZG(ZGBlocks.altumGoldOre, STONE, EnumOreGenZG.GOLD);
		this.eveniumGen = new WorldGenMinableZG(ZGBlocks.altumEveniumOre, STONE, EnumOreGenZG.EVENIUM);
		this.rhodiumGen = new WorldGenMinableZG(ZGBlocks.altumRhodiumOre, STONE, EnumOreGenZG.RHODIUM);
		this.coalGen = new WorldGenMinableZG(ZGBlocks.altumCoalOre, STONE, EnumOreGenZG.COAL);
		this.prismarineGen = new WorldGenMinableZG(Blocks.PRISMARINE, STONE, EnumOreGenZG.PRISMARINE);
	}
	
	@Override
	protected void generate(Biome biome, World world, Random rand) {
		int x = rand.nextInt(16) + 8;
		int z = rand.nextInt(16) + 8;
		int genY = 248;
		int y = genY;
		
		if (biome instanceof BiomeSpace) {
			BiomeSpace spaceBiome = (BiomeSpace) biome;
			genY = spaceBiome.getBiomeHeight();
		}
		
		this.generateOre(this.amaranthGen, EnumOreGenZG.AMARANTH, world, rand);
		this.generateOre(this.redstoneGen, EnumOreGenZG.REDSTONE, world, rand);
		this.generateOre(this.ironGen, EnumOreGenZG.IRON, world, rand);
		this.generateOre(this.diamondGen, EnumOreGenZG.DIAMOND, world, rand);
		this.generateOre(this.zollerniumGen, EnumOreGenZG.ZOLLERNIUM, world, rand);
		this.generateOre(this.goldGen, EnumOreGenZG.GOLD, world, rand);
		this.generateOre(this.eveniumGen, EnumOreGenZG.EVENIUM, world, rand);
		this.generateOre(this.rhodiumGen, EnumOreGenZG.RHODIUM, world, rand);
		this.generateOre(this.coalGen, EnumOreGenZG.COAL, world, rand);
		this.generateOre(this.prismarineGen, EnumOreGenZG.PRISMARINE, world, rand);
		
		ChunkPos forgeChunkPos = new ChunkPos(chunkPos);
		
		// Lakes
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.LAKE_WATER)) {
			if (rand.nextInt(2) == 0) {
				for (int i = 0; i < this.waterLakesPerChunk; ++i) {
					int x1 = rand.nextInt(16) + 8;
					int z1 = rand.nextInt(16) + 8;
					int y1 = world.getHeight(this.chunkPos.add(x1, 0, z1)).getY() * 2;
					if (y1 > 0) {
						int y2 = rand.nextInt(y1);
						this.waterLakeGen.generate(world, rand, this.chunkPos.add(x1, y2, z1));
					}
				}
			}
		}
		
		// Chest Gen
		// if (TerrainGen.decorate(world, rand, forgeChunkPos,
		// DecorateBiomeEvent.Decorate.EventType.CUSTOM)) {
		// // if (rand.nextInt(50) == 0) {
		// // for (int i = 0; i < this.treasurePerChunk; i++) {
		// // int x1 = rand.nextInt(16) + 8;
		// // int z1 = rand.nextInt(16) + 8;
		// // y = rand.nextInt(rand.nextInt(genY) + 8);
		// // // int y1 = world.getHeight(this.chunkPos.add(x1, 0, z1)).getY();
		// // if (y > 40) {
		// // BlockPos chestPos = this.chunkPos.add(x1, y, z1);
		// // chestPos = chestPos.down();
		// // this.treasureGen.generate(world, rand, chestPos);
		// // }
		// // }
		// // }
		// }
		
		// Seaweed Gen
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.GRASS)) {
			if (rand.nextInt(5) == 0) {
				for (int i = 0; i < this.seaweedPerChunk; i++) {
					int x1 = rand.nextInt(16) + 8;
					int z1 = rand.nextInt(16) + 8;
					int y1 = world.getHeight(this.chunkPos.add(x1, 0, z1)).getY() * 2;
					if (y1 > 0) {
						int y2 = rand.nextInt(y1);
						this.seaweedGen.generate(world, rand, this.chunkPos.add(x1, y2, z1));
					}
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
			IBlockState OUTPOST_STATE = ZGBlocks.blockOutpost.getDefaultState();
			if (y >= 62) {
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