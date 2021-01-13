/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.decorators;

import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.blocks.ZGBlockTallGrass;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.enums.EnumOreGenZG;
import zollerngalaxy.lib.helpers.ZGDecorateHelper;
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
	
	public int exodusTallGrassPerChunk = 4;
	
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
			ZGBlockTallGrass exoTallGrass = (ZGBlockTallGrass) ZGBlocks.exodusTallGrass;
			WorldGenTallGrassZG worldGen = new WorldGenTallGrassZG(exoTallGrass);
			for (int i = 0; i < this.exodusTallGrassPerChunk; ++i) {
				ZGDecorateHelper.generatePlants(worldGen, world, rand, this.chunkPos);
			}
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