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
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.dimensions.chunkproviders.ChunkProviderZollus;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.core.enums.EnumOreGenZG;
import zollerngalaxy.lib.helpers.ZGDecorateHelper;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.util.BiomeUtils;
import zollerngalaxy.worldgen.WorldGenBattleTower;
import zollerngalaxy.worldgen.WorldGenMinableZG;
import zollerngalaxy.worldgen.WorldGenOutpost;
import zollerngalaxy.worldgen.WorldGenSmallCraterZG;
import zollerngalaxy.worldgen.WorldGenTunnel;
import zollerngalaxy.worldgen.zollus.WorldGenZGIceSpikes;
import zollerngalaxy.worldgen.zollus.WorldGenZolniumCrystals;

public class BiomeDecoratorZollus extends BiomeDecoratorZG {
	
	private static final Block COBBLE = ZGBlocks.zolCobbleRock;
	private static final Block ROCK_BRICKS = ZGBlocks.zolRockBricks;
	private static final Block STONE = ZGBlocks.zolStone;
	
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
	public int tunnelsPerChunk = 3;
	public int cratersPerChunk = 6;
	public int battleTowersPerChunk = 2;
	
	public boolean generateCrystals = true;
	public boolean generateIceSpikes = true;
	public boolean generateTunnels = true;
	public boolean generateTallGrass = false;
	public boolean generateCraters = true;
	public boolean generateBattleTowers = true;
	
	private WorldGenerator zolCrystalGen = new WorldGenZolniumCrystals(ZGBlocks.zolCrystals.getDefaultState());
	private WorldGenerator iceSpikeGen = new WorldGenZGIceSpikes();
	private WorldGenerator tunnelGen = new WorldGenTunnel();
	private WorldGenerator craterGen = new WorldGenSmallCraterZG();
	private WorldGenerator battleTowerGen = new WorldGenBattleTower(COBBLE.getDefaultState(), ROCK_BRICKS.getDefaultState());
	
	public BiomeDecoratorZollus() {
		this.dirtGen = new WorldGenMinableZG(ZGBlocks.zolDirt, ZGBlocks.zolSurfaceRock, EnumOreGenZG.DIRT);
		this.packedIceGen = new WorldGenMinableZG(ZGBlocks.zolIce, ZGBlocks.zolSurfaceRock, EnumOreGenZG.PACKED_ICE);
		this.tinGen = new WorldGenMinableZG(ZGBlocks.zolTinOre, STONE, EnumOreGenZG.TIN);
		this.copperGen = new WorldGenMinableZG(ZGBlocks.zolCopperOre, STONE, EnumOreGenZG.COPPER);
		this.ironGen = new WorldGenMinableZG(ZGBlocks.zolIronOre, STONE, EnumOreGenZG.IRON);
		this.goldGen = new WorldGenMinableZG(ZGBlocks.zolGoldOre, STONE, EnumOreGenZG.GOLD);
		this.heartiumGen = new WorldGenMinableZG(ZGBlocks.zolHeartOre, STONE, EnumOreGenZG.HEARTIUM);
		this.coalGen = new WorldGenMinableZG(ZGBlocks.zolCoalOre, STONE, EnumOreGenZG.COAL);
	}
	
	@Override
	protected void generate(Biome biome, World world, Random rand) {
		int x = rand.nextInt(16) + 8;
		int z = rand.nextInt(16) + 8;
		
		ChunkPrimer chunkPrimer = new ChunkPrimer();
		ChunkPos forgeChunkPos = new ChunkPos(this.chunkPos);
		
		int genY = 128;
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
				ZGDecorateHelper.generatePlants(this.zolCrystalGen, world, rand, this.chunkPos);
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
					this.iceSpikeGen.generate(world, rand, this.chunkPos.add(x, y, z));
				}
			}
		}
		
		// Tunnels
		if (this.generateTunnels && this.tunnelsPerChunk > 0) {
			if (ZGHelper.rngInt(1, 100) <= 35) {
				y = rand.nextInt(rand.nextInt(genY) + 8);
				for (int i = 0; i < this.tunnelsPerChunk; ++i) {
					if (y <= 60) {
						this.tunnelGen.generate(world, rand, this.chunkPos.add(x, y, z));
					}
				}
			}
		}
		
		// Craters (Small)
		int craterSpawnChance = ConfigManagerZG.craterSpawnChance;
		if (this.generateCraters && this.cratersPerChunk > 0 && craterSpawnChance > 0) {
			ChunkProviderZollus.INSTANCE.createCraters(x, z, chunkPrimer);
			y = rand.nextInt(rand.nextInt(genY) + 8);
			if (ZGHelper.rngInt(1, 100) <= craterSpawnChance) {
				for (int i = 0; i < this.cratersPerChunk; ++i) {
					if (y <= 70) {
						this.craterGen.generate(world, rand, this.chunkPos.add(x, y, z));
					}
				}
			}
		}
		
		// Battle Towers
		if (this.generateBattleTowers && this.battleTowersPerChunk > 0 && !BiomeUtils.isOceanBiome(biome)) {
			if (ZGHelper.rngInt(1, 250) <= 25) {
				for (int i = 0; i < this.battleTowersPerChunk; ++i) {
					y = rand.nextInt(rand.nextInt(genY) + 8);
					if (y >= 60 && y < 80) {
						this.battleTowerGen.generate(world, rand, this.chunkPos.add(x, y, z));
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