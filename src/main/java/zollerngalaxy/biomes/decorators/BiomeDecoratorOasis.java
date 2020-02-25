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
import net.minecraft.world.gen.feature.WorldGenWaterlily;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollerngalaxy.blocks.ZGBlockTallGrass;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumOreGenZG;
import zollerngalaxy.lib.helpers.ZGDecorateHelper;
import zollerngalaxy.worldgen.WorldGenLakesZG;
import zollerngalaxy.worldgen.WorldGenMinableZG;
import zollerngalaxy.worldgen.WorldGenTallGrassZG;
import zollerngalaxy.worldgen.oasis.WorldGenOasisFlowers;

public class BiomeDecoratorOasis extends BiomeDecoratorZG {
	
	public static final Block SURFACE_ROCK = ZGBlocks.oasisRock;
	public static final Block STONE = ZGBlocks.oasisStone;
	
	private WorldGenerator dirtGen;
	private WorldGenerator gravelGen;
	private WorldGenerator superChargedCoalGen;
	private WorldGenerator diamondGen;
	private WorldGenerator redstoneGen;
	private WorldGenerator coalGen;
	private WorldGenerator ironGen;
	private WorldGenerator goldGen;
	private WorldGenerator tinGen;
	private WorldGenerator leadGen;
	private WorldGenerator shinestoneGen;
	
	public int waterLakesPerChunk = 4;
	public int lavaLakesPerChunk = 6;
	public int oilLakesPerChunk = 4;
	public int oasisTallGrassPerChunk = 3;
	public int oasisFlowersPerChunk = 4;
	
	public boolean generateLakes = true;
	public boolean generateVines = false;
	public boolean generateCraters = false;
	
	public BiomeDecoratorOasis() {
		this.dirtGen = new WorldGenMinableZG(ZGBlocks.oasisDirt, STONE, EnumOreGenZG.DIRT);
		this.gravelGen = new WorldGenMinableZG(ZGBlocks.oasisGravel, STONE, EnumOreGenZG.GRAVEL);
		this.superChargedCoalGen = new WorldGenMinableZG(ZGBlocks.oasisSuperChargedCoalOre, STONE,
				EnumOreGenZG.SUPER_CHARGED_COAL);
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
		
		this.generateOre(this.dirtGen, EnumOreGenZG.DIRT, world, rand);
		this.generateOre(this.gravelGen, EnumOreGenZG.GRAVEL, world, rand);
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
		
		if (this.oasisTallGrassPerChunk > 0) {
			for (int i = 0; i < this.oasisTallGrassPerChunk + 4; ++i) {
				ZGDecorateHelper.generatePlants(new WorldGenTallGrassZG((ZGBlockTallGrass) ZGBlocks.oasisTallGrass), world, rand,
						this.chunkPos);
			}
		}
		
		if (this.oasisFlowersPerChunk > 0) {
			for (int i = 0; i < this.oasisFlowersPerChunk + 2; i++) {
				IBlockState flowerState = ZGBlocks.oasisFlower.getDefaultState();
				ZGDecorateHelper.generatePlants(new WorldGenOasisFlowers(flowerState), world, rand, this.chunkPos);
			}
		}
	}
}