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
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.TempCategory;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.blocks.ZGBlockTallGrass;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.dimensions.chunkproviders.ChunkProviderExodus;
import zollerngalaxy.core.enums.EnumOreGenZG;
import zollerngalaxy.lib.helpers.ZGDecorateHelper;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.worldgen.WorldGenFlowersZG;
import zollerngalaxy.worldgen.WorldGenLakesZG;
import zollerngalaxy.worldgen.WorldGenMinableZG;
import zollerngalaxy.worldgen.WorldGenOutpost;
import zollerngalaxy.worldgen.WorldGenTallGrassZG;
import zollerngalaxy.worldgen.exodus.WorldGenExoTrees;

public class BiomeDecoratorExodus extends BiomeDecoratorZG {
	
	private WorldGenerator dirtGen;
	private WorldGenerator gravGen;
	private WorldGenerator ironOreGen;
	private WorldGenerator goldOreGen;
	private WorldGenerator diamondOreGen;
	private WorldGenerator redstoneOreGen;
	private WorldGenerator copperOreGen;
	
	public boolean generateLakes = true;
	public boolean generateVines = false;
	public boolean generateTrees = true;
	public boolean generateCraters = true;
	
	private WorldGenerator tallGrassGen = new WorldGenTallGrassZG((ZGBlockTallGrass) ZGBlocks.exodusTallGrass);
	private WorldGenerator treeGenExo = new WorldGenExoTrees(false, ZGHelper.rngInt(5, 10), ZGBlocks.exoWoodLogs.getDefaultState(),
			ZGBlocks.exoWoodLeaves.getDefaultState(), this.generateVines);
	
	public int exodusTallGrassPerChunk = 10;
	public int exodusTreesPerChunk = 2;
	public int waterLakesPerChunk = 2;
	public int lavaLakesPerChunk = (this.enableExtremeMode) ? 12 : 6;
	public int astersPerChunk = 10;
	
	public BiomeDecoratorExodus() {
		this.dirtGen = new WorldGenMinableZG(ZGBlocks.exodusDirt, ZGBlocks.exodusGrass, EnumOreGenZG.DIRT);
		this.gravGen = new WorldGenMinableZG(ZGBlocks.exodusGravel, ZGBlocks.exodusStone, EnumOreGenZG.GRAVEL);
		this.ironOreGen = new WorldGenMinableZG(ZGBlocks.exodusIronOre, ZGBlocks.exodusStone, EnumOreGenZG.IRON);
		this.goldOreGen = new WorldGenMinableZG(ZGBlocks.exodusGoldOre, ZGBlocks.exodusStone, EnumOreGenZG.GOLD);
		this.diamondOreGen = new WorldGenMinableZG(ZGBlocks.exodusDiamondOre, ZGBlocks.exodusStone, EnumOreGenZG.DIAMOND);
		this.redstoneOreGen = new WorldGenMinableZG(ZGBlocks.exodusRedstoneOre, ZGBlocks.exodusStone, EnumOreGenZG.REDSTONE);
		this.copperOreGen = new WorldGenMinableZG(ZGBlocks.exodusCopperOre, ZGBlocks.exodusStone, EnumOreGenZG.COPPER);
	}
	
	@Override
	protected void generate(Biome biome, World world, Random rand) {
		int x = rand.nextInt(16) + 8;
		int z = rand.nextInt(16) + 8;
		
		ChunkPrimer chunkPrimer = new ChunkPrimer();
		
		int genY = 248;
		int y = genY;
		
		Block BLOCK_TOP = biome.topBlock.getBlock();
		Block BLOCK_FILL = biome.fillerBlock.getBlock();
		Block BLOCK_STONE = ZGBlocks.exodusStone;
		
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
		if (this.exodusTallGrassPerChunk > 0) {
			for (int i = 0; i < this.exodusTallGrassPerChunk + 4; ++i) {
				ZGDecorateHelper.generatePlants(this.tallGrassGen, world, rand, this.chunkPos);
			}
		}
		
		// Water Lakes
		if (this.generateLakes && this.waterLakesPerChunk > 0) {
			for (int i = 0; i < this.waterLakesPerChunk; ++i) {
				y = rand.nextInt(rand.nextInt(genY) + 8);
				Block blockToUse = (biome.getTempCategory() == TempCategory.COLD) ? Blocks.ICE : Blocks.WATER;
				(new WorldGenLakesZG(blockToUse, BLOCK_TOP)).generate(world, rand, this.chunkPos.add(x, y, z));
			}
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
		
		// Galaxy Asters
		if (this.astersPerChunk > 0) {
			for (int i = 0; i < this.astersPerChunk + 2; i++) {
				IBlockState flowerState = ZGBlocks.exodusFlower.getDefaultState();
				ZGDecorateHelper.generatePlants(new WorldGenFlowersZG(flowerState), world, rand, this.chunkPos);
			}
		}
		
		// Exowood Trees
		if (this.generateTrees && this.exodusTreesPerChunk > 0) {
			for (int i = 0; i < this.exodusTreesPerChunk; ++i) {
				y = rand.nextInt(rand.nextInt(genY) + 8);
				if (y < 64) {
					y = ZGHelper.rngInt(64, 82);
				}
				
				if (rand.nextInt(100) <= 50) {
					treeGenExo.generate(world, rand, this.chunkPos.add(x, y, z));
				}
			}
		}
		
		// Craters
		if (this.generateCraters) {
			ChunkProviderExodus.INSTANCE.createCraters(x, z, chunkPrimer);
		}
		
		// Outposts
		if (this.generateOutposts && this.outpostsPerChunk > 0) {
			y = rand.nextInt(rand.nextInt(genY) + 8);
			if (y >= 62) {
				IBlockState outpostState = ZGBlocks.blockOutpost.getDefaultState();
				WorldGenerator outpostGen = new WorldGenOutpost(outpostState, outpostState);
				for (int i = 0; i < this.outpostsPerChunk; i++) {
					if (rand.nextInt((this.enableExtremeMode) ? 200 : 100) <= ConfigManagerZG.outpostGenChance) {
						outpostGen.generate(world, rand, this.chunkPos.add(x, y, z));
					}
				}
			}
		}
	}
}