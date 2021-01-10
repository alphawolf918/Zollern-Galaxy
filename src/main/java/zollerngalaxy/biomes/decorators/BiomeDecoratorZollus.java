/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.decorators;

import java.util.Random;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.enums.EnumOreGenZG;
import zollerngalaxy.lib.helpers.ZGDecorateHelper;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.worldgen.WorldGenMinableZG;
import zollerngalaxy.worldgen.WorldGenOutpost;
import zollerngalaxy.worldgen.zollus.WorldGenZGIceSpikes;
import zollerngalaxy.worldgen.zollus.WorldGenZolniumCrystals;

public class BiomeDecoratorZollus extends BiomeDecoratorZG {
	
	private WorldGenerator dirtGen;
	private WorldGenerator packedIceGen;
	private WorldGenerator ironGen;
	private WorldGenerator goldGen;
	private WorldGenerator tinGen;
	private WorldGenerator copperGen;
	private WorldGenerator heartiumGen;
	private WorldGenerator coalGen;
	
	public int zolCrystalsPerChunk = 2;
	public int iceSpikesPerChunk = ConfigManagerZG.zollusIceSpikesPerChunk;
	
	public boolean generateCrystals = true;
	public boolean generateIceSpikes = true;
	
	private WorldGenerator zolCrystalGen = new WorldGenZolniumCrystals(ZGBlocks.zolCrystals.getDefaultState());
	private WorldGenerator iceSpikeGen = new WorldGenZGIceSpikes();
	
	public BiomeDecoratorZollus() {
		this.dirtGen = new WorldGenMinableZG(ZGBlocks.zolDirt, ZGBlocks.zolSurfaceRock, EnumOreGenZG.DIRT);
		this.packedIceGen = new WorldGenMinableZG(Blocks.PACKED_ICE, ZGBlocks.zolSurfaceRock, EnumOreGenZG.PACKED_ICE);
		this.tinGen = new WorldGenMinableZG(ZGBlocks.zolTinOre, ZGBlocks.zolStone, EnumOreGenZG.TIN);
		this.copperGen = new WorldGenMinableZG(ZGBlocks.zolCopperOre, ZGBlocks.zolStone, EnumOreGenZG.COPPER);
		this.ironGen = new WorldGenMinableZG(ZGBlocks.zolIronOre, ZGBlocks.zolStone, EnumOreGenZG.IRON);
		this.goldGen = new WorldGenMinableZG(ZGBlocks.zolGoldOre, ZGBlocks.zolStone, EnumOreGenZG.GOLD);
		this.heartiumGen = new WorldGenMinableZG(ZGBlocks.zolHeartOre, ZGBlocks.zolStone, EnumOreGenZG.HEARTIUM);
		this.coalGen = new WorldGenMinableZG(ZGBlocks.zolCoalOre, ZGBlocks.zolStone, EnumOreGenZG.COAL);
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
		this.generateOre(this.tinGen, EnumOreGenZG.TIN, world, rand);
		this.generateOre(this.copperGen, EnumOreGenZG.COPPER, world, rand);
		this.generateOre(this.heartiumGen, EnumOreGenZG.HEARTIUM, world, rand);
		this.generateOre(this.dirtGen, EnumOreGenZG.DIRT, world, rand);
		this.generateOre(this.packedIceGen, EnumOreGenZG.PACKED_ICE, world, rand);
		this.generateOre(this.coalGen, EnumOreGenZG.COAL, world, rand);
		
		// Zollus Crystals
		if (this.generateCrystals && this.zolCrystalsPerChunk > 0) {
			for (int i = 0; i < this.zolCrystalsPerChunk; ++i) {
				ZGDecorateHelper.generatePlants(zolCrystalGen, world, rand, this.chunkPos);
			}
		}
		
		// Ice Spikes
		if (this.generateIceSpikes && this.iceSpikesPerChunk > 0) {
			for (int i = 0; i < this.iceSpikesPerChunk; i++) {
				y = rand.nextInt(rand.nextInt(genY) + 8);
				if (y < 64) {
					y = ZGHelper.rngInt(64, 82);
				}
				if (rand.nextInt(100) <= ConfigManagerZG.zollusIceSpikesGenChance) {
					iceSpikeGen.generate(world, rand, this.chunkPos.add(x, y, z));
				}
			}
		}
		
		if (this.generateOutposts && this.outpostsPerChunk > 0) {
			y = rand.nextInt(rand.nextInt(genY) + 8);
			if (y >= 62) {
				WorldGenerator outpostGen = new WorldGenOutpost(ZGBlocks.blockOutpost.getDefaultState(),
						ZGBlocks.blockOutpost.getDefaultState());
				for (int i = 0; i < this.outpostsPerChunk; i++) {
					if (rand.nextInt((this.enableExtremeMode) ? 200 : 100) <= ConfigManagerZG.outpostGenChance) {
						outpostGen.generate(world, rand, this.chunkPos.add(x, y, z));
					}
				}
			}
		}
	}
}