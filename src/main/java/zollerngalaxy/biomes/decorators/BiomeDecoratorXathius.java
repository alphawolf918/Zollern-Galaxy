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
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.TempCategory;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenWaterlily;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollerngalaxy.biomes.ZGBiomes;
import zollerngalaxy.blocks.ZGBlockTallGrass;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.enums.EnumOreGenZG;
import zollerngalaxy.lib.helpers.ZGDecorateHelper;
import zollerngalaxy.worldgen.WorldGenLakesZG;
import zollerngalaxy.worldgen.WorldGenMinableZG;
import zollerngalaxy.worldgen.WorldGenOutpost;
import zollerngalaxy.worldgen.WorldGenTallGrassZG;

public class BiomeDecoratorXathius extends BiomeDecoratorZG {
	
	public static final Block SURFACE_ROCK = ZGBlocks.xathRock;
	public static final Block STONE = ZGBlocks.xathStone;
	
	private WorldGenerator dirtGen;
	private WorldGenerator gravelGen;
	private WorldGenerator prometheanGen;
	private WorldGenerator emeraldGen;
	private WorldGenerator diamondGen;
	private WorldGenerator redstoneGen;
	private WorldGenerator ironGen;
	private WorldGenerator goldGen;
	private WorldGenerator tinGen;
	private WorldGenerator azuriteGen;
	
	public int waterLakesPerChunk = 4;
	public int lavaLakesPerChunk = 1;
	public int oilLakesPerChunk = 4;
	public int obsidianLakesPerChunk = 1;
	public int xathTallGrassPerChunk = 8;
	
	public boolean generateLakes = true;
	public boolean generateVines = false;
	public boolean generateCraters = false;
	
	public BiomeDecoratorXathius() {
		this.dirtGen = new WorldGenMinableZG(ZGBlocks.xathDirt, STONE, EnumOreGenZG.DIRT);
		this.gravelGen = new WorldGenMinableZG(ZGBlocks.xathGravel, STONE, EnumOreGenZG.GRAVEL);
		this.prometheanGen = new WorldGenMinableZG(ZGBlocks.xathPrometheanOre, STONE, EnumOreGenZG.PROMETHEAN);
		this.emeraldGen = new WorldGenMinableZG(ZGBlocks.xathEmeraldOre, STONE, EnumOreGenZG.EMERALD);
		this.diamondGen = new WorldGenMinableZG(ZGBlocks.xathDiamondOre, STONE, EnumOreGenZG.DIAMOND);
		this.redstoneGen = new WorldGenMinableZG(ZGBlocks.xathRedstoneOre, STONE, EnumOreGenZG.REDSTONE);
		this.ironGen = new WorldGenMinableZG(ZGBlocks.xathIronOre, STONE, EnumOreGenZG.IRON);
		this.goldGen = new WorldGenMinableZG(ZGBlocks.xathGoldOre, STONE, EnumOreGenZG.GOLD);
		this.tinGen = new WorldGenMinableZG(ZGBlocks.xathTinOre, STONE, EnumOreGenZG.TIN);
		this.azuriteGen = new WorldGenMinableZG(ZGBlocks.xathAzuriteOre, Blocks.OBSIDIAN, EnumOreGenZG.AZURITE);
	}
	
	@Override
	protected void generate(Biome biome, World world, Random rand) {
		int x = rand.nextInt(16) + 8;
		int z = rand.nextInt(16) + 8;
		
		int genY = 248;
		int y = genY;
		
		Block BLOCK_TOP = biome.topBlock.getBlock();
		Block BLOCK_FILL = biome.fillerBlock.getBlock();
		
		if (biome.equals(ZGBiomes.XATHIUS_MOUNTAINS)) {
			EnumOreGenZG.GRAVEL.setMaxHeight(256);
			EnumOreGenZG.EMERALD.setMaxHeight(256);
			EnumOreGenZG.DIAMOND.setMaxHeight(256);
			EnumOreGenZG.REDSTONE.setMaxHeight(256);
			EnumOreGenZG.IRON.setMaxHeight(256);
			EnumOreGenZG.GOLD.setMaxHeight(256);
			EnumOreGenZG.TIN.setMaxHeight(256);
		}
		
		this.generateOre(this.dirtGen, EnumOreGenZG.DIRT, world, rand);
		this.generateOre(this.gravelGen, EnumOreGenZG.GRAVEL, world, rand);
		this.generateOre(this.prometheanGen, EnumOreGenZG.PROMETHEAN, world, rand);
		this.generateOre(this.emeraldGen, EnumOreGenZG.EMERALD, world, rand);
		this.generateOre(this.diamondGen, EnumOreGenZG.DIAMOND, world, rand);
		this.generateOre(this.redstoneGen, EnumOreGenZG.REDSTONE, world, rand);
		this.generateOre(this.ironGen, EnumOreGenZG.IRON, world, rand);
		this.generateOre(this.goldGen, EnumOreGenZG.GOLD, world, rand);
		this.generateOre(this.tinGen, EnumOreGenZG.TIN, world, rand);
		this.generateOre(this.azuriteGen, EnumOreGenZG.AZURITE, world, rand);
		
		ChunkPrimer chunkPrimer = new ChunkPrimer();
		
		if (this.generateLakes && this.waterLakesPerChunk > 0) {
			for (int i = 0; i < this.waterLakesPerChunk; ++i) {
				y = rand.nextInt(rand.nextInt(genY) + 8);
				
				Block blockToUse = (biome.getTempCategory() == TempCategory.COLD) ? Blocks.ICE : Blocks.WATER;
				
				(new WorldGenLakesZG(blockToUse, BLOCK_TOP)).generate(world, rand, this.chunkPos.add(x, y, z));
			}
			
			if (this.waterlilyPerChunk > 0) {
				for (int i = 0; i < this.waterlilyPerChunk; ++i) {
					(new WorldGenWaterlily()).generate(world, rand, this.chunkPos.add(x, y, z));
				}
			}
		}
		
		if (this.generateLakes && this.lavaLakesPerChunk > 0) {
			for (int i = 0; i < this.lavaLakesPerChunk; ++i) {
				y = rand.nextInt(rand.nextInt(genY) + 8);
				
				if (rand.nextInt(100) <= 5) {
					(new WorldGenLakesZG(Blocks.LAVA, STONE)).generate(world, rand, this.chunkPos.add(x, y, z));
				}
			}
		}
		
		if (this.generateLakes && this.obsidianLakesPerChunk > 0) {
			for (int i = 0; i < this.obsidianLakesPerChunk; ++i) {
				y = rand.nextInt(rand.nextInt(genY) + 8);
				
				if (rand.nextInt(100) <= 10) {
					(new WorldGenLakesZG(Blocks.OBSIDIAN, STONE)).generate(world, rand, this.chunkPos.add(x, y, z));
				}
			}
		}
		
		if (this.xathTallGrassPerChunk > 0) {
			for (int i = 0; i < this.xathTallGrassPerChunk + 4; ++i) {
				ZGDecorateHelper.generatePlants(new WorldGenTallGrassZG((ZGBlockTallGrass) ZGBlocks.xathTallGrass), world, rand,
						this.chunkPos);
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