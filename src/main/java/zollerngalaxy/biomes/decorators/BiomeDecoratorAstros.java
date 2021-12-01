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
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.dimensions.chunkproviders.ChunkProviderAstros;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.core.enums.EnumOreGenZG;
import zollerngalaxy.lib.helpers.ZGDecorateHelper;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.worldgen.WorldGenMinableZG;
import zollerngalaxy.worldgen.WorldGenOutpost;
import zollerngalaxy.worldgen.WorldGenTunnel;
import zollerngalaxy.worldgen.WorldGenZGCrystals;

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
	private WorldGenerator sapphireGen;
	
	private static final Block STONE = ZGBlocks.astrosStone;
	private static final Block ROCK = ZGBlocks.astrosRock;
	private static final Block OUTPOST = ZGBlocks.blockOutpost;
	private static final Block ICE = ZGBlocks.astrosIce;
	
	public int edenCrystalsPerChunk = 1;
	public int tunnelsPerChunk = 4;
	
	public boolean generateEdenCrystals = true;
	public boolean generateCraters = true;
	public boolean generateTunnels = true;
	
	private WorldGenerator edenCrystalsGen = new WorldGenZGCrystals(ZGBlocks.blockCrystalsEden.getDefaultState(), 60);
	private WorldGenerator tunnelGen = new WorldGenTunnel();
	
	public BiomeDecoratorAstros() {
		this.dirtGen = new WorldGenMinableZG(ZGBlocks.astrosDirt, ROCK, EnumOreGenZG.DIRT);
		this.gravelGen = new WorldGenMinableZG(ZGBlocks.astrosGravel, ROCK, EnumOreGenZG.GRAVEL);
		this.packedIceGen = new WorldGenMinableZG(ICE, ROCK, EnumOreGenZG.PACKED_ICE);
		this.ironGen = new WorldGenMinableZG(ZGBlocks.astrosIronOre, STONE, EnumOreGenZG.IRON);
		this.goldGen = new WorldGenMinableZG(ZGBlocks.astrosGoldOre, STONE, EnumOreGenZG.GOLD);
		this.diamondGen = new WorldGenMinableZG(ZGBlocks.astrosDiamondOre, STONE, EnumOreGenZG.DIAMOND);
		this.emeraldGen = new WorldGenMinableZG(ZGBlocks.astrosEmeraldOre, STONE, EnumOreGenZG.EMERALD);
		this.coalGen = new WorldGenMinableZG(ZGBlocks.astrosCoalOre, STONE, EnumOreGenZG.COAL);
		this.superChargedCoalGen = new WorldGenMinableZG(ZGBlocks.astrosSuperChargedCoalOre, STONE, EnumOreGenZG.SUPER_CHARGED_COAL);
		this.redstoneGen = new WorldGenMinableZG(ZGBlocks.astrosRedstoneOre, STONE, EnumOreGenZG.REDSTONE);
		this.tinGen = new WorldGenMinableZG(ZGBlocks.astrosTinOre, STONE, EnumOreGenZG.TIN);
		this.zollerniumGen = new WorldGenMinableZG(ZGBlocks.astrosZollerniumOre, STONE, EnumOreGenZG.ZOLLERNIUM);
		this.sapphireGen = new WorldGenMinableZG(ZGBlocks.astrosSapphireOre, STONE, EnumOreGenZG.SAPPHIRE);
	}
	
	@Override
	protected void generate(Biome biome, World world, Random rand) {
		int x = rand.nextInt(16) + 8;
		int z = rand.nextInt(16) + 8;
		
		ChunkPrimer chunkPrimer = new ChunkPrimer();
		
		this.generateOre(this.ironGen, EnumOreGenZG.IRON, world, rand);
		this.generateOre(this.goldGen, EnumOreGenZG.GOLD, world, rand);
		this.generateOre(this.diamondGen, EnumOreGenZG.DIAMOND, world, rand);
		this.generateOre(this.emeraldGen, EnumOreGenZG.EMERALD, world, rand);
		this.generateOre(this.coalGen, EnumOreGenZG.COAL, world, rand);
		this.generateOre(this.superChargedCoalGen, EnumOreGenZG.SUPER_CHARGED_COAL, world, rand);
		this.generateOre(this.redstoneGen, EnumOreGenZG.REDSTONE, world, rand);
		this.generateOre(this.tinGen, EnumOreGenZG.TIN, world, rand);
		this.generateOre(this.zollerniumGen, EnumOreGenZG.ZOLLERNIUM, world, rand);
		this.generateOre(this.sapphireGen, EnumOreGenZG.SAPPHIRE, world, rand);
		this.generateOre(this.dirtGen, EnumOreGenZG.DIRT, world, rand);
		this.generateOre(this.gravelGen, EnumOreGenZG.GRAVEL, world, rand);
		this.generateOre(this.packedIceGen, EnumOreGenZG.PACKED_ICE, world, rand);
		
		int genY = 248;
		int y = genY;
		
		if (biome instanceof BiomeSpace) {
			BiomeSpace spaceBiome = (BiomeSpace) biome;
			genY = spaceBiome.getBiomeHeight();
		}
		
		// Eden Crystals
		if (this.generateEdenCrystals && this.edenCrystalsPerChunk > 0) {
			if (ZGHelper.rngInt(1, 100) <= 45) {
				y = rand.nextInt(rand.nextInt(genY) + 8);
				for (int i = 0; i < this.edenCrystalsPerChunk; ++i) {
					if (y <= 60) {
						ZGDecorateHelper.generateCrystals(this.edenCrystalsGen, world, rand, this.chunkPos.add(x, y, z));
					}
				}
			}
		}
		
		// Tunnels
		if (this.generateTunnels && this.tunnelsPerChunk > 0) {
			if (ZGHelper.rngInt(1, 100) <= 35) {
				y = rand.nextInt(rand.nextInt(genY) + 8);
				for (int i = 0; i < this.tunnelsPerChunk; ++i) {
					if (y <= 60) {
						tunnelGen.generate(world, rand, this.chunkPos.add(x, y, z));
					}
				}
			}
		}
		
		// Craters
		if (this.generateCraters) {
			ChunkProviderAstros.INSTANCE.createCraters(x, z, chunkPrimer);
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