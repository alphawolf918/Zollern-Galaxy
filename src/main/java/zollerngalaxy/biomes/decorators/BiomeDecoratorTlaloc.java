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
import zollerngalaxy.core.dimensions.chunkproviders.ChunkProviderTlaloc;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.core.enums.EnumOreGenZG;
import zollerngalaxy.lib.helpers.ZGDecorateHelper;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.worldgen.WorldGenCraterZG;
import zollerngalaxy.worldgen.WorldGenMinableZG;
import zollerngalaxy.worldgen.WorldGenOutpost;
import zollerngalaxy.worldgen.WorldGenTunnel;
import zollerngalaxy.worldgen.WorldGenZGCrystals;

public class BiomeDecoratorTlaloc extends BiomeDecoratorZG {
	
	private static final Block ROCK = ZGBlocks.tlalocRock;
	private static final Block STONE = ZGBlocks.tlalocStone;
	private static final Block CHROME = ZGBlocks.tlalocChrome;
	
	private WorldGenerator constructGen;
	private WorldGenerator constructGen2;
	private WorldGenerator constructGen3;
	private WorldGenerator mechRockGen;
	private WorldGenerator superChargedCoalGen;
	private WorldGenerator redstoneGen;
	private WorldGenerator fueltoniumGen;
	private WorldGenerator quartzGen;
	private WorldGenerator certusQuartzGen;
	private WorldGenerator fluixGen;
	private WorldGenerator shiniumGen;
	private WorldGenerator zollerniumGen;
	private WorldGenerator plutoniumGen;
	
	public int tunnelsPerChunk = 10;
	public int cratersPerChunk = 6;
	public int plutoniumCrystalsPerChunk = 2;
	
	public boolean generateCraters = true;
	public boolean generateTunnels = true;
	public boolean generatePlutoniumCrystals = true;
	
	private WorldGenerator tunnelGen = new WorldGenTunnel();
	private WorldGenerator craterGen = new WorldGenCraterZG();
	private WorldGenerator plutoniumCrystalsGen = new WorldGenZGCrystals(ZGBlocks.blockCrystalsPlutonium.getDefaultState(), 60);
	
	public BiomeDecoratorTlaloc() {
		this.constructGen = new WorldGenMinableZG(ZGBlocks.xantheonConstructBlock, ROCK, EnumOreGenZG.CONSTRUCTED);
		this.constructGen2 = new WorldGenMinableZG(ZGBlocks.xantheonConstructBlock, CHROME, EnumOreGenZG.CONSTRUCTED);
		this.constructGen3 = new WorldGenMinableZG(ZGBlocks.xantheonConstructBlock, STONE, EnumOreGenZG.CONSTRUCTED);
		this.mechRockGen = new WorldGenMinableZG(ZGBlocks.tlalocMechRock, STONE, EnumOreGenZG.CONSTRUCTED);
		this.superChargedCoalGen = new WorldGenMinableZG(ZGBlocks.tlalocSuperChargedCoalOre, STONE, EnumOreGenZG.SUPER_CHARGED_COAL);
		this.redstoneGen = new WorldGenMinableZG(ZGBlocks.tlalocRedstoneOre, STONE, EnumOreGenZG.REDSTONE);
		this.fueltoniumGen = new WorldGenMinableZG(ZGBlocks.tlalocFueltoniumOre, STONE, EnumOreGenZG.FUELTONIUM);
		this.quartzGen = new WorldGenMinableZG(ZGBlocks.tlalocQuartzOre, STONE, EnumOreGenZG.QUARTZ);
		this.certusQuartzGen = new WorldGenMinableZG(ZGBlocks.tlalocCertusQuartzOre, STONE, EnumOreGenZG.CERTUS_QUARTZ);
		this.fluixGen = new WorldGenMinableZG(ZGBlocks.tlalocFluixOre, STONE, EnumOreGenZG.FLUIX);
		this.shiniumGen = new WorldGenMinableZG(ZGBlocks.tlalocShiniumOre, STONE, EnumOreGenZG.SHINIUM);
		this.zollerniumGen = new WorldGenMinableZG(ZGBlocks.tlalocZollerniumOre, STONE, EnumOreGenZG.ZOLLERNIUM);
		this.plutoniumGen = new WorldGenMinableZG(ZGBlocks.tlalocPlutoniumOre, STONE, EnumOreGenZG.PLUTONIUM.setGenCount(15));
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
		
		this.generateOre(this.constructGen, EnumOreGenZG.CONSTRUCTED, world, rand);
		this.generateOre(this.constructGen2, EnumOreGenZG.CONSTRUCTED, world, rand);
		this.generateOre(this.constructGen3, EnumOreGenZG.CONSTRUCTED, world, rand);
		this.generateOre(this.mechRockGen, EnumOreGenZG.CONSTRUCTED, world, rand);
		this.generateOre(this.superChargedCoalGen, EnumOreGenZG.SUPER_CHARGED_COAL, world, rand);
		this.generateOre(this.redstoneGen, EnumOreGenZG.REDSTONE, world, rand);
		this.generateOre(this.fueltoniumGen, EnumOreGenZG.FUELTONIUM, world, rand);
		this.generateOre(this.quartzGen, EnumOreGenZG.QUARTZ, world, rand);
		this.generateOre(this.certusQuartzGen, EnumOreGenZG.CERTUS_QUARTZ, world, rand);
		this.generateOre(this.fluixGen, EnumOreGenZG.FLUIX, world, rand);
		this.generateOre(this.shiniumGen, EnumOreGenZG.SHINIUM, world, rand);
		this.generateOre(this.zollerniumGen, EnumOreGenZG.ZOLLERNIUM, world, rand);
		this.generateOre(this.plutoniumGen, EnumOreGenZG.PLUTONIUM, world, rand);
		
		// Tunnels
		if (this.generateTunnels && this.tunnelsPerChunk > 0) {
			if (ZGHelper.rngInt(1, 100) <= 45) {
				for (int i = 0; i < this.tunnelsPerChunk; ++i) {
					y = rand.nextInt(rand.nextInt(genY) + 8);
					if (y <= 60) {
						this.tunnelGen.generate(world, rand, this.chunkPos.add(x, y, z));
					}
				}
			}
		}
		
		// Craters
		if (this.generateCraters && this.cratersPerChunk > 0) {
			ChunkProviderTlaloc.INSTANCE.createCraters(x, z, chunkPrimer);
			y = rand.nextInt(rand.nextInt(genY) + 8);
			if (ZGHelper.rngInt(1, 100) <= 40) {
				for (int i = 0; i < this.cratersPerChunk; ++i) {
					if (y <= 70) {
						this.craterGen.generate(world, rand, this.chunkPos.add(x, y, z));
					}
				}
			}
		}
		
		// Plutonium Crystals
		if (this.generatePlutoniumCrystals && this.plutoniumCrystalsPerChunk > 0) {
			if (ZGHelper.rngInt(1, 100) <= 45) {
				y = rand.nextInt(rand.nextInt(genY) + 8);
				for (int i = 0; i < this.plutoniumCrystalsPerChunk; ++i) {
					if (y <= 60) {
						ZGDecorateHelper.generateCrystals(this.plutoniumCrystalsGen, world, rand, this.chunkPos.add(x, y, z));
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
			if (y >= 62) {
				IBlockState OUTPOST_STATE = ZGBlocks.blockOutpost.getDefaultState();
				WorldGenerator outpostGen = new WorldGenOutpost(OUTPOST_STATE, OUTPOST_STATE);
				for (int i = 0; i < this.outpostsPerChunk; i++) {
					y = rand.nextInt(rand.nextInt(genY) + 8);
					if (rand.nextInt((this.enableExtremeMode) ? 200 : 100) <= ConfigManagerZG.outpostGenChance) {
						outpostGen.generate(world, rand, this.chunkPos.add(x, y, z));
					}
				}
			}
		}
	}
}