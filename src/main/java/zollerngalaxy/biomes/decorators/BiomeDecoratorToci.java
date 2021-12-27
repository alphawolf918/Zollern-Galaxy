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
import zollerngalaxy.core.dimensions.chunkproviders.ChunkProviderToci;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.core.enums.EnumOreGenZG;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.worldgen.WorldGenCraterZG;
import zollerngalaxy.worldgen.WorldGenMinableZG;
import zollerngalaxy.worldgen.WorldGenOutpost;
import zollerngalaxy.worldgen.WorldGenSmallHouse;
import zollerngalaxy.worldgen.WorldGenTunnel;

public class BiomeDecoratorToci extends BiomeDecoratorZG {
	
	private static final Block STONE = ZGBlocks.tociStone;
	private static final Block SAND = ZGBlocks.tociSand;
	private static final Block STAR_SAND = ZGBlocks.tociStarSand;
	private static final Block GRAVEL = ZGBlocks.tociGravel;
	private static final Block COBBLESTONE = ZGBlocks.tociCobblestone;
	private static final Block STONE_BRICKS = ZGBlocks.tociStoneBricks;
	private static final Block WOOD_PLANKS = ZGBlocks.perdWoodPlanks;
	
	private WorldGenerator nickelGen;
	private WorldGenerator tinGen;
	private WorldGenerator bronzeGen;
	private WorldGenerator silverGen;
	private WorldGenerator leadGen;
	private WorldGenerator copperGen;
	private WorldGenerator zincGen;
	private WorldGenerator superChargedCoalGen;
	private WorldGenerator redstoneGen;
	private WorldGenerator goldGen;
	private WorldGenerator amaranthGen;
	private WorldGenerator emeraldGen;
	private WorldGenerator coalGen;
	private WorldGenerator fueltoniumGen;
	private WorldGenerator ironGen;
	private WorldGenerator diamondGen;
	private WorldGenerator quartzGen;
	private WorldGenerator gravelGen;
	
	public int tunnelsPerChunk = 8;
	public int cratersPerChunk = 4;
	public int housesPerChunk = 2;
	
	public boolean generateCraters = true;
	public boolean generateTunnels = true;
	public boolean generateHouses = true;
	
	private WorldGenerator tunnelGen = new WorldGenTunnel();
	private WorldGenerator craterGen = new WorldGenCraterZG();
	private WorldGenerator houseGen = new WorldGenSmallHouse(COBBLESTONE.getDefaultState(), STONE_BRICKS.getDefaultState(), WOOD_PLANKS.getDefaultState());
	
	public BiomeDecoratorToci() {
		this.nickelGen = new WorldGenMinableZG(ZGBlocks.tociNickelOre, STONE, EnumOreGenZG.NICKEL);
		this.tinGen = new WorldGenMinableZG(ZGBlocks.tociTinOre, STONE, EnumOreGenZG.TIN);
		this.bronzeGen = new WorldGenMinableZG(ZGBlocks.tociBronzeOre, STONE, EnumOreGenZG.BRONZE);
		this.silverGen = new WorldGenMinableZG(ZGBlocks.tociSilverOre, STONE, EnumOreGenZG.SILVER);
		this.leadGen = new WorldGenMinableZG(ZGBlocks.tociLeadOre, STONE, EnumOreGenZG.LEAD);
		this.copperGen = new WorldGenMinableZG(ZGBlocks.tociCopperOre, STONE, EnumOreGenZG.COPPER);
		this.zincGen = new WorldGenMinableZG(ZGBlocks.tociZincOre, STONE, EnumOreGenZG.ZINC);
		this.superChargedCoalGen = new WorldGenMinableZG(ZGBlocks.tociSuperChargedCoalOre, STONE, EnumOreGenZG.SUPER_CHARGED_COAL);
		this.redstoneGen = new WorldGenMinableZG(ZGBlocks.tociRedstoneOre, STONE, EnumOreGenZG.REDSTONE);
		this.goldGen = new WorldGenMinableZG(ZGBlocks.tociGoldOre, STONE, EnumOreGenZG.GOLD);
		this.amaranthGen = new WorldGenMinableZG(ZGBlocks.tociAmaranthOre, STONE, EnumOreGenZG.AMARANTH);
		this.emeraldGen = new WorldGenMinableZG(ZGBlocks.tociEmeraldOre, STONE, EnumOreGenZG.EMERALD);
		this.coalGen = new WorldGenMinableZG(ZGBlocks.tociCoalOre, STONE, EnumOreGenZG.COAL);
		this.fueltoniumGen = new WorldGenMinableZG(ZGBlocks.tociFueltoniumOre, STONE, EnumOreGenZG.FUELTONIUM);
		this.ironGen = new WorldGenMinableZG(ZGBlocks.tociIronOre, STONE, EnumOreGenZG.IRON);
		this.diamondGen = new WorldGenMinableZG(ZGBlocks.tociDiamondOre, STONE, EnumOreGenZG.DIAMOND);
		this.quartzGen = new WorldGenMinableZG(ZGBlocks.tociQuartzOre, STONE, EnumOreGenZG.QUARTZ);
		this.gravelGen = new WorldGenMinableZG(ZGBlocks.tociGravel, STONE, EnumOreGenZG.GRAVEL.setGenCount(10));
	}
	
	@Override
	protected void generate(Biome biome, World world, Random rand) {
		int x = rand.nextInt(16) + 8;
		int z = rand.nextInt(16) + 8;
		
		ChunkPrimer chunkPrimer = new ChunkPrimer();
		
		int genY = 248;
		int y = genY;
		
		// if (biome instanceof BiomeSpace) {
		// BiomeSpace spaceBiome = (BiomeSpace) biome;
		// genY = spaceBiome.getBiomeHeight();
		// }
		
		this.generateOre(this.nickelGen, EnumOreGenZG.NICKEL, world, rand);
		this.generateOre(this.tinGen, EnumOreGenZG.TIN, world, rand);
		this.generateOre(this.bronzeGen, EnumOreGenZG.BRONZE, world, rand);
		this.generateOre(this.silverGen, EnumOreGenZG.SILVER, world, rand);
		this.generateOre(this.leadGen, EnumOreGenZG.LEAD, world, rand);
		this.generateOre(this.copperGen, EnumOreGenZG.COPPER, world, rand);
		this.generateOre(this.zincGen, EnumOreGenZG.ZINC, world, rand);
		this.generateOre(this.superChargedCoalGen, EnumOreGenZG.SUPER_CHARGED_COAL, world, rand);
		this.generateOre(this.redstoneGen, EnumOreGenZG.REDSTONE, world, rand);
		this.generateOre(this.goldGen, EnumOreGenZG.GOLD, world, rand);
		this.generateOre(this.amaranthGen, EnumOreGenZG.AMARANTH, world, rand);
		this.generateOre(this.emeraldGen, EnumOreGenZG.EMERALD, world, rand);
		this.generateOre(this.coalGen, EnumOreGenZG.COAL, world, rand);
		this.generateOre(this.fueltoniumGen, EnumOreGenZG.FUELTONIUM, world, rand);
		this.generateOre(this.ironGen, EnumOreGenZG.IRON, world, rand);
		this.generateOre(this.diamondGen, EnumOreGenZG.DIAMOND, world, rand);
		this.generateOre(this.quartzGen, EnumOreGenZG.QUARTZ, world, rand);
		this.generateOre(this.gravelGen, EnumOreGenZG.GRAVEL, world, rand);
		
		// Tunnels
		if (this.generateTunnels && this.tunnelsPerChunk > 0) {
			if (ZGHelper.rngInt(1, 100) <= 45) {
				y = rand.nextInt(rand.nextInt(genY) + 8);
				for (int i = 0; i < this.tunnelsPerChunk; ++i) {
					if (y <= 60) {
						this.tunnelGen.generate(world, rand, this.chunkPos.add(x, y, z));
					}
				}
			}
		}
		
		// Houses
		if (this.generateHouses && this.housesPerChunk > 0) {
			if (ZGHelper.rngInt(1, 100) <= 32) {
				for (int i = 0; i < this.housesPerChunk; i++) {
					y = rand.nextInt(rand.nextInt(genY) + 8);
					if (y >= 60) {
						this.houseGen.generate(world, rand, this.chunkPos.add(x, y, z));
					}
				}
			}
		}
		
		// Craters
		if (this.generateCraters && this.cratersPerChunk > 0) {
			ChunkProviderToci.INSTANCE.createCraters(x, z, chunkPrimer);
			y = rand.nextInt(rand.nextInt(genY) + 8);
			if (ZGHelper.rngInt(1, 100) <= 50) {
				for (int i = 0; i < this.cratersPerChunk; ++i) {
					if (y <= 80) {
						this.craterGen.generate(world, rand, this.chunkPos.add(x, y, z));
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