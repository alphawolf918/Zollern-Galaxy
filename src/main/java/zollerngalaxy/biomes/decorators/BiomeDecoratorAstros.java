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
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumOreGenZG;
import zollerngalaxy.worldgen.WorldGenMinableZG;

public class BiomeDecoratorAstros extends BiomeDecoratorZG {
	
	private WorldGenerator dirtGen;
	private WorldGenerator packedIceGen;
	private WorldGenerator gravelGen;
	private WorldGenerator ironGen;
	private WorldGenerator goldGen;
	private WorldGenerator diamondGen;
	private WorldGenerator emeraldGen;
	private WorldGenerator coalGen;
	private WorldGenerator superChargedCoalGen;
	private WorldGenerator redstoneGen;
	private WorldGenerator tinGen;
	private WorldGenerator zollerniumGen;
	
	private static final Block STONE = ZGBlocks.astrosStone;
	private static final Block ROCK = ZGBlocks.astrosRock;
	
	public BiomeDecoratorAstros() {
		this.dirtGen = new WorldGenMinableZG(ZGBlocks.astrosDirt, ROCK, EnumOreGenZG.DIRT);
		this.gravelGen = new WorldGenMinableZG(ZGBlocks.astrosGravel, ROCK, EnumOreGenZG.GRAVEL);
		this.packedIceGen = new WorldGenMinableZG(Blocks.PACKED_ICE, ROCK, EnumOreGenZG.PACKED_ICE);
		this.ironGen = new WorldGenMinableZG(ZGBlocks.astrosIronOre, STONE, EnumOreGenZG.IRON);
		this.goldGen = new WorldGenMinableZG(ZGBlocks.astrosGoldOre, STONE, EnumOreGenZG.GOLD);
		this.diamondGen = new WorldGenMinableZG(ZGBlocks.astrosDiamondOre, STONE, EnumOreGenZG.DIAMOND);
		this.emeraldGen = new WorldGenMinableZG(ZGBlocks.astrosEmeraldOre, STONE, EnumOreGenZG.EMERALD);
		this.coalGen = new WorldGenMinableZG(ZGBlocks.astrosCoalOre, STONE, EnumOreGenZG.COAL);
		this.superChargedCoalGen = new WorldGenMinableZG(ZGBlocks.astrosSuperChargedCoalOre, STONE, EnumOreGenZG.SUPER_CHARGED_COAL);
		this.redstoneGen = new WorldGenMinableZG(ZGBlocks.astrosRedstoneOre, STONE, EnumOreGenZG.REDSTONE);
		this.tinGen = new WorldGenMinableZG(ZGBlocks.astrosTinOre, STONE, EnumOreGenZG.TIN);
		this.zollerniumGen = new WorldGenMinableZG(ZGBlocks.astrosZollerniumOre, STONE, EnumOreGenZG.ZOLLERNIUM);
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
		
		this.generateOre(this.ironGen, EnumOreGenZG.IRON, world, rand);
		this.generateOre(this.goldGen, EnumOreGenZG.GOLD, world, rand);
		this.generateOre(this.diamondGen, EnumOreGenZG.DIAMOND, world, rand);
		this.generateOre(this.emeraldGen, EnumOreGenZG.EMERALD, world, rand);
		this.generateOre(this.coalGen, EnumOreGenZG.COAL, world, rand);
		this.generateOre(this.superChargedCoalGen, EnumOreGenZG.SUPER_CHARGED_COAL, world, rand);
		this.generateOre(this.redstoneGen, EnumOreGenZG.REDSTONE, world, rand);
		this.generateOre(this.tinGen, EnumOreGenZG.TIN, world, rand);
		this.generateOre(this.zollerniumGen, EnumOreGenZG.ZOLLERNIUM, world, rand);
		this.generateOre(this.dirtGen, EnumOreGenZG.DIRT, world, rand);
		this.generateOre(this.gravelGen, EnumOreGenZG.GRAVEL, world, rand);
		this.generateOre(this.packedIceGen, EnumOreGenZG.PACKED_ICE, world, rand);
	}
}