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
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.dimensions.chunkproviders.ChunkProviderCaligro;
import zollerngalaxy.core.enums.EnumOreGenZG;
import zollerngalaxy.worldgen.WorldGenMinableZG;
import zollerngalaxy.worldgen.caligro.WorldGenShadowShrine;
import zollerngalaxy.worldgen.caligro.WorldGenShadowSkull;
import zollerngalaxy.worldgen.caligro.WorldGenSpiderEgg;

public class BiomeDecoratorCaligro extends BiomeDecoratorZG {
	
	private WorldGenerator dirtGen;
	private WorldGenerator gravelGen;
	private WorldGenerator ironGen;
	private WorldGenerator goldGen;
	private WorldGenerator tinGen;
	private WorldGenerator copperGen;
	private WorldGenerator leadGen;
	private WorldGenerator redstoneGen;
	private WorldGenerator diamondGen;
	private WorldGenerator emeraldGen;
	private WorldGenerator shiniumGen;
	private WorldGenerator silverGen;
	private WorldGenerator nickelGen;
	private WorldGenerator topazGen;
	private WorldGenerator amberGen;
	private WorldGenerator opalGen;
	private WorldGenerator aquamarineGen;
	private WorldGenerator garnetGen;
	private WorldGenerator rubyGen;
	private WorldGenerator lapisGen;
	private WorldGenerator radiumGen;
	private WorldGenerator fueltoniumGen;
	private WorldGenerator superChargedCoalGen;
	private WorldGenerator zincGen;
	private WorldGenerator amaranthGen;
	private WorldGenerator zollerniumGen;
	private WorldGenerator witheriteGen;
	private WorldGenerator creepstoneGen;
	private WorldGenerator creepstoneDirtGen;
	
	// Corruption Layer
	private WorldGenerator corruptAscendiumGen;
	private WorldGenerator corruptEtriumGen;
	private WorldGenerator corruptChargiumGen;
	private WorldGenerator corruptRockGen;
	private WorldGenerator corruptCreepstoneGen;
	
	private static final Block STONE = ZGBlocks.caligroStone;
	private static final Block CORRUPTED_STONE = ZGBlocks.corruptStone;
	
	private static final int SEA_LEVEL = ChunkProviderCaligro.SEA_LEVEL;
	private static final int CORRUPTION_LAYER = ChunkProviderCaligro.CORRUPTION_LAYER;
	
	private static final EnumOreGenZG TIN = EnumOreGenZG.TIN;
	private static final EnumOreGenZG COPPER = EnumOreGenZG.COPPER;
	private static final EnumOreGenZG IRON = EnumOreGenZG.IRON;
	private static final EnumOreGenZG GOLD = EnumOreGenZG.GOLD;
	private static final EnumOreGenZG LEAD = EnumOreGenZG.LEAD;
	private static final EnumOreGenZG REDSTONE = EnumOreGenZG.REDSTONE;
	private static final EnumOreGenZG DIAMOND = EnumOreGenZG.DIAMOND;
	private static final EnumOreGenZG EMERALD = EnumOreGenZG.EMERALD;
	private static final EnumOreGenZG PLATINUM = EnumOreGenZG.PLATINUM;
	private static final EnumOreGenZG SILVER = EnumOreGenZG.SILVER;
	private static final EnumOreGenZG NICKEL = EnumOreGenZG.NICKEL;
	private static final EnumOreGenZG POWER_GEM = EnumOreGenZG.POWER_GEM;
	private static final EnumOreGenZG LAPIS = EnumOreGenZG.LAPIS;
	private static final EnumOreGenZG RADIUM = EnumOreGenZG.RADIUM;
	private static final EnumOreGenZG FUELTONIUM = EnumOreGenZG.FUELTONIUM;
	private static final EnumOreGenZG SUPER_CHARGED_COAL = EnumOreGenZG.SUPER_CHARGED_COAL;
	private static final EnumOreGenZG ZINC = EnumOreGenZG.ZINC;
	private static final EnumOreGenZG AMARANTH = EnumOreGenZG.AMARANTH;
	private static final EnumOreGenZG ZOLLERNIUM = EnumOreGenZG.ZOLLERNIUM;
	
	public int spiderlingEggsPerChunk = 5;
	public int shadowShrinesPerChunk = 1;
	public int shadowSkullsPerChunk = 1;
	
	public boolean generateSpiderlingEggs = true;
	public boolean generateCraters = true;
	public boolean generateShadowShrines = true;
	public boolean generateShadowSkulls = true;
	
	private WorldGenSpiderEgg spiderEggGen = new WorldGenSpiderEgg();
	private WorldGenShadowShrine shadowShrineGen = new WorldGenShadowShrine();
	private WorldGenShadowSkull shadowSkullGen = new WorldGenShadowSkull();
	
	public BiomeDecoratorCaligro() {
		this.modifyOreGens();
		this.dirtGen = new WorldGenMinableZG(ZGBlocks.caligroDirt, ZGBlocks.caligroSurfaceRock, EnumOreGenZG.DIRT);
		this.gravelGen = new WorldGenMinableZG(ZGBlocks.caligroGravel, ZGBlocks.caligroStone, EnumOreGenZG.GRAVEL);
		this.tinGen = new WorldGenMinableZG(ZGBlocks.caligroTinOre, STONE, TIN);
		this.copperGen = new WorldGenMinableZG(ZGBlocks.caligroCopperOre, STONE, COPPER);
		this.ironGen = new WorldGenMinableZG(ZGBlocks.caligroIronOre, STONE, IRON);
		this.goldGen = new WorldGenMinableZG(ZGBlocks.caligroGoldOre, STONE, GOLD);
		this.leadGen = new WorldGenMinableZG(ZGBlocks.caligroLeadOre, STONE, LEAD);
		this.redstoneGen = new WorldGenMinableZG(ZGBlocks.caligroRedstoneOre, STONE, REDSTONE);
		this.diamondGen = new WorldGenMinableZG(ZGBlocks.caligroDiamondOre, STONE, DIAMOND);
		this.emeraldGen = new WorldGenMinableZG(ZGBlocks.caligroEmeraldOre, STONE, EMERALD);
		this.shiniumGen = new WorldGenMinableZG(ZGBlocks.caligroShiniumOre, STONE, PLATINUM);
		this.silverGen = new WorldGenMinableZG(ZGBlocks.caligroSilverOre, STONE, SILVER);
		this.nickelGen = new WorldGenMinableZG(ZGBlocks.caligroNickelOre, STONE, NICKEL);
		this.topazGen = new WorldGenMinableZG(ZGBlocks.caligroTopazOre, STONE, POWER_GEM);
		this.amberGen = new WorldGenMinableZG(ZGBlocks.caligroAmberOre, STONE, POWER_GEM);
		this.opalGen = new WorldGenMinableZG(ZGBlocks.caligroOpalOre, STONE, POWER_GEM);
		this.aquamarineGen = new WorldGenMinableZG(ZGBlocks.caligroAquamarineOre, STONE, POWER_GEM);
		this.garnetGen = new WorldGenMinableZG(ZGBlocks.caligroGarnetOre, STONE, POWER_GEM);
		this.rubyGen = new WorldGenMinableZG(ZGBlocks.caligroRubyOre, STONE, POWER_GEM);
		this.lapisGen = new WorldGenMinableZG(ZGBlocks.caligroLapisOre, STONE, LAPIS);
		this.radiumGen = new WorldGenMinableZG(ZGBlocks.caligroRadiumOre, STONE, RADIUM);
		this.fueltoniumGen = new WorldGenMinableZG(ZGBlocks.caligroFueltoniumOre, STONE, FUELTONIUM);
		this.superChargedCoalGen = new WorldGenMinableZG(ZGBlocks.caligroSuperChargedCoalOre, STONE, SUPER_CHARGED_COAL);
		this.zincGen = new WorldGenMinableZG(ZGBlocks.caligroZincOre, STONE, ZINC);
		this.amaranthGen = new WorldGenMinableZG(ZGBlocks.caligroAmaranthOre, STONE, AMARANTH);
		this.zollerniumGen = new WorldGenMinableZG(ZGBlocks.caligroZollerniumOre, STONE, ZOLLERNIUM);
		this.witheriteGen = new WorldGenMinableZG(ZGBlocks.caligroWitheriteOre, STONE, EnumOreGenZG.POWER_GEM);
		this.creepstoneGen = new WorldGenMinableZG(ZGBlocks.caligroCreepstone, STONE, EnumOreGenZG.SPECIAL_STONE);
		this.creepstoneDirtGen = new WorldGenMinableZG(ZGBlocks.caligroCreepdirt, STONE, EnumOreGenZG.DIRT.setMaxHeight(32));
		this.corruptAscendiumGen = new WorldGenMinableZG(ZGBlocks.corruptAscendiumOre, CORRUPTED_STONE, EnumOreGenZG.POWER_GEM);
		this.corruptEtriumGen = new WorldGenMinableZG(ZGBlocks.corruptEtriumOre, CORRUPTED_STONE, EnumOreGenZG.POWER_GEM);
		this.corruptChargiumGen = new WorldGenMinableZG(ZGBlocks.corruptChargiumOre, CORRUPTED_STONE, EnumOreGenZG.ZOLLERNIUM);
		this.corruptRockGen = new WorldGenMinableZG(ZGBlocks.corruptRock, CORRUPTED_STONE, EnumOreGenZG.MAGMA);
		this.corruptCreepstoneGen = new WorldGenMinableZG(ZGBlocks.corruptCreepstone, CORRUPTED_STONE, EnumOreGenZG.SPECIAL_STONE);
	}
	
	private void modifyOreGens() {
		this.setOreGenDataList(TIN, COPPER, IRON, GOLD, LEAD, REDSTONE, DIAMOND, EMERALD, PLATINUM, SILVER, NICKEL, POWER_GEM);
		this.setOreGenDataList(LAPIS, RADIUM, FUELTONIUM, SUPER_CHARGED_COAL, ZINC, AMARANTH, ZOLLERNIUM);
	}
	
	private void setOreGenData(EnumOreGenZG oreGen) {
		oreGen.setMinHeight(CORRUPTION_LAYER);
		
		int genCount = 6;
		int blockCount = 5;
		int maxHeight = 52;
		
		if (oreGen.getGenCount() > genCount) {
			oreGen.setGenCount(genCount);
		}
		
		if (oreGen.getBlockCount() > genCount) {
			oreGen.setBlockCount(genCount);
		}
		
		if (oreGen.getMaxHeight() < maxHeight) {
			oreGen.setMaxHeight(maxHeight);
		}
	}
	
	private void setOreGenDataList(EnumOreGenZG... oreGens) {
		for (EnumOreGenZG e : oreGens) {
			this.setOreGenData(e);
		}
	}
	
	@Override
	protected void generate(Biome biome, World world, Random rand) {
		int x = rand.nextInt(16) + 8;
		int z = rand.nextInt(16) + 8;
		
		ChunkPrimer chunkPrimer = new ChunkPrimer();
		
		this.generateOre(this.dirtGen, EnumOreGenZG.DIRT, world, rand);
		this.generateOre(this.gravelGen, EnumOreGenZG.GRAVEL, world, rand);
		this.generateOre(this.ironGen, IRON, world, rand);
		this.generateOre(this.goldGen, GOLD, world, rand);
		this.generateOre(this.tinGen, TIN, world, rand);
		this.generateOre(this.copperGen, COPPER, world, rand);
		this.generateOre(this.leadGen, LEAD, world, rand);
		this.generateOre(this.redstoneGen, REDSTONE, world, rand);
		this.generateOre(this.diamondGen, DIAMOND, world, rand);
		this.generateOre(this.emeraldGen, EMERALD, world, rand);
		this.generateOre(this.shiniumGen, PLATINUM, world, rand);
		this.generateOre(this.silverGen, SILVER, world, rand);
		this.generateOre(this.nickelGen, NICKEL, world, rand);
		this.generateOre(this.topazGen, POWER_GEM, world, rand);
		this.generateOre(this.opalGen, POWER_GEM, world, rand);
		this.generateOre(this.aquamarineGen, POWER_GEM, world, rand);
		this.generateOre(this.garnetGen, POWER_GEM, world, rand);
		this.generateOre(this.rubyGen, POWER_GEM, world, rand);
		this.generateOre(this.lapisGen, LAPIS, world, rand);
		this.generateOre(this.radiumGen, RADIUM, world, rand);
		this.generateOre(this.fueltoniumGen, FUELTONIUM, world, rand);
		this.generateOre(this.superChargedCoalGen, SUPER_CHARGED_COAL, world, rand);
		this.generateOre(this.zincGen, ZINC, world, rand);
		this.generateOre(this.amaranthGen, AMARANTH, world, rand);
		this.generateOre(this.zollerniumGen, ZOLLERNIUM, world, rand);
		this.generateOre(this.witheriteGen, DIAMOND, world, rand);
		this.generateOre(this.creepstoneGen, EnumOreGenZG.SPECIAL_STONE, world, rand);
		this.generateOre(this.creepstoneDirtGen, EnumOreGenZG.DIRT, world, rand);
		this.generateOre(this.corruptAscendiumGen, POWER_GEM, world, rand);
		this.generateOre(this.corruptEtriumGen, POWER_GEM, world, rand);
		this.generateOre(this.corruptChargiumGen, ZOLLERNIUM, world, rand);
		this.generateOre(this.corruptRockGen, EnumOreGenZG.MAGMA, world, rand);
		this.generateOre(this.corruptCreepstoneGen, EnumOreGenZG.SPECIAL_STONE, world, rand);
		
		int genY = 248;
		int y = genY;
		
		Block BLOCK_TOP = biome.topBlock.getBlock();
		Block BLOCK_FILL = biome.fillerBlock.getBlock();
		Block BLOCK_STONE = ZGBlocks.caligroStone;
		Block CORRUPTED_STONE = ZGBlocks.corruptStone;
		
		if (biome instanceof BiomeSpace) {
			BiomeSpace spaceBiome = (BiomeSpace) biome;
			genY = spaceBiome.getBiomeHeight();
		}
		
		// Spiderling Nest
		if (this.generateSpiderlingEggs && this.spiderlingEggsPerChunk > 0) {
			for (int i = 0; i < this.spiderlingEggsPerChunk; i++) {
				y = rand.nextInt(rand.nextInt(genY) + 8);
				if (rand.nextInt(152) <= 59) {
					this.spiderEggGen.generate(world, rand, this.chunkPos.add(x, y, z));
					this.spiderEggGen.generate(world, rand, this.chunkPos.add(x + 3, y, z));
					this.spiderEggGen.generate(world, rand, this.chunkPos.add(x - 3, y, z));
					this.spiderEggGen.generate(world, rand, this.chunkPos.add(x, y, z + 3));
					this.spiderEggGen.generate(world, rand, this.chunkPos.add(x - 3, y, z + 3));
					this.spiderEggGen.generate(world, rand, this.chunkPos.add(x + 3, y, z - 3));
				}
			}
		}
		
		// Shadow Shrine
		if (this.generateShadowShrines && this.shadowShrinesPerChunk > 0) {
			for (int i = 0; i < this.shadowShrinesPerChunk; i++) {
				y = rand.nextInt(rand.nextInt(genY) + 8);
				if (y >= SEA_LEVEL) {
					if (rand.nextInt(2000) <= 42) {
						this.shadowShrineGen.generate(world, rand, this.chunkPos.add(x, y, z));
					}
				}
			}
		}
		
		// Shadow Skull
		if (this.generateShadowSkulls && this.shadowSkullsPerChunk > 0) {
			for (int i = 0; i < this.shadowSkullsPerChunk; i++) {
				y = rand.nextInt(rand.nextInt(genY) + 8);
				if (y >= SEA_LEVEL) {
					if (rand.nextInt(800) <= 52) {
						this.shadowSkullGen.generate(world, rand, this.chunkPos.add(x, y, z));
					}
				}
			}
		}
		
		// Craters
		if (this.generateCraters) {
			ChunkProviderCaligro.INSTANCE.createCraters(x, z, chunkPrimer);
		}
	}
}