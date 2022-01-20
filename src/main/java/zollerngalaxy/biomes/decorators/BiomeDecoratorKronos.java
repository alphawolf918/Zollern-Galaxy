/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.biomes.decorators;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.enums.EnumOreGenZG;
import zollerngalaxy.util.BiomeUtils;
import zollerngalaxy.worldgen.WorldGenLakesZG;
import zollerngalaxy.worldgen.WorldGenMinableZG;
import zollerngalaxy.worldgen.WorldGenOutpost;

public class BiomeDecoratorKronos extends BiomeDecoratorZG {
	
	private static final Block NETHERRACK = Blocks.NETHERRACK;
	private static final Block SOUL_SAND = Blocks.SOUL_SAND;
	
	private WorldGenerator dirtGen;
	private WorldGenerator sandGen;
	private WorldGenerator coalGen;
	private WorldGenerator fueltoniumGen;
	private WorldGenerator ironGen;
	private WorldGenerator shiniumGen;
	private WorldGenerator silverGen;
	private WorldGenerator nickleGen;
	private WorldGenerator leadGen;
	private WorldGenerator tinGen;
	private WorldGenerator copperGen;
	private WorldGenerator lapisGen;
	private WorldGenerator diamondGen;
	private WorldGenerator emeraldGen;
	private WorldGenerator redstoneGen;
	private WorldGenerator goldGen;
	private WorldGenerator steelGen;
	private WorldGenerator rubyGen;
	private WorldGenerator sapphireGen;
	private WorldGenerator zincGen;
	private WorldGenerator amaranthGen;
	private WorldGenerator superChargedCoalGen;
	
	public boolean generateLakes = true;
	public boolean generateMushrooms = true;
	public boolean generateCraters = true;
	
	public int lavaLakesPerChunk = 10;
	public int mushroomsPerChunk = 5;
	
	public BiomeDecoratorKronos() {
		this.dirtGen = new WorldGenMinableZG(ZGBlocks.netherDirt, NETHERRACK, EnumOreGenZG.DIRT);
		this.sandGen = new WorldGenMinableZG(SOUL_SAND, NETHERRACK, EnumOreGenZG.SAND);
		this.coalGen = new WorldGenMinableZG(ZGBlocks.netherCoalOre, NETHERRACK, EnumOreGenZG.COAL);
		this.fueltoniumGen = new WorldGenMinableZG(ZGBlocks.netherFueltoniumOre, NETHERRACK, EnumOreGenZG.FUELTONIUM);
		this.ironGen = new WorldGenMinableZG(ZGBlocks.netherIronOre, NETHERRACK, EnumOreGenZG.IRON);
		this.shiniumGen = new WorldGenMinableZG(ZGBlocks.netherShiniumOre, NETHERRACK, EnumOreGenZG.SHINIUM);
		this.silverGen = new WorldGenMinableZG(ZGBlocks.netherSilverOre, NETHERRACK, EnumOreGenZG.SILVER);
		this.nickleGen = new WorldGenMinableZG(ZGBlocks.netherNickleOre, NETHERRACK, EnumOreGenZG.NICKEL);
		this.leadGen = new WorldGenMinableZG(ZGBlocks.netherLeadOre, NETHERRACK, EnumOreGenZG.LEAD);
		this.tinGen = new WorldGenMinableZG(ZGBlocks.netherTinOre, NETHERRACK, EnumOreGenZG.TIN);
		this.copperGen = new WorldGenMinableZG(ZGBlocks.netherCopperOre, NETHERRACK, EnumOreGenZG.COPPER);
		this.lapisGen = new WorldGenMinableZG(ZGBlocks.netherLapisOre, NETHERRACK, EnumOreGenZG.LAPIS);
		this.diamondGen = new WorldGenMinableZG(ZGBlocks.netherDiamondOre, NETHERRACK, EnumOreGenZG.DIAMOND);
		this.emeraldGen = new WorldGenMinableZG(ZGBlocks.netherEmeraldOre, NETHERRACK, EnumOreGenZG.EMERALD);
		this.redstoneGen = new WorldGenMinableZG(ZGBlocks.netherRedstoneOre, NETHERRACK, EnumOreGenZG.REDSTONE);
		this.goldGen = new WorldGenMinableZG(ZGBlocks.netherGoldOre, NETHERRACK, EnumOreGenZG.GOLD);
		this.steelGen = new WorldGenMinableZG(ZGBlocks.netherSteelOre, NETHERRACK, EnumOreGenZG.STEEL);
		this.rubyGen = new WorldGenMinableZG(ZGBlocks.netherRubyOre, NETHERRACK, EnumOreGenZG.RUBY);
		this.sapphireGen = new WorldGenMinableZG(ZGBlocks.netherSapphireOre, NETHERRACK, EnumOreGenZG.SAPPHIRE);
		this.zincGen = new WorldGenMinableZG(ZGBlocks.netherZincOre, NETHERRACK, EnumOreGenZG.ZINC);
		this.amaranthGen = new WorldGenMinableZG(ZGBlocks.netherAmaranthOre, NETHERRACK, EnumOreGenZG.AMARANTH);
		this.superChargedCoalGen = new WorldGenMinableZG(ZGBlocks.netherSuperChargedCoalOre, NETHERRACK, EnumOreGenZG.SUPER_CHARGED_COAL);
	}
	
	@Override
	protected void generate(Biome biome, World world, Random rand) {
		int x = rand.nextInt(16) + 8;
		int z = rand.nextInt(16) + 8;
		int y = rand.nextInt(120) + 8;
		
		ChunkPrimer chunkPrimer = new ChunkPrimer();
		ChunkPos forgeChunkPos = new ChunkPos(chunkPos);
		
		Block BLOCK_TOP = biome.topBlock.getBlock();
		Block BLOCK_FILL = biome.fillerBlock.getBlock();
		
		//
		
		this.generateOre(this.dirtGen, EnumOreGenZG.DIRT, world, rand);
		this.generateOre(this.sandGen, EnumOreGenZG.SAND, world, rand);
		this.generateOre(this.coalGen, EnumOreGenZG.COAL, world, rand);
		this.generateOre(this.fueltoniumGen, EnumOreGenZG.FUELTONIUM, world, rand);
		this.generateOre(this.ironGen, EnumOreGenZG.IRON, world, rand);
		this.generateOre(this.shiniumGen, EnumOreGenZG.SHINIUM, world, rand);
		this.generateOre(this.silverGen, EnumOreGenZG.SILVER, world, rand);
		this.generateOre(this.nickleGen, EnumOreGenZG.NICKEL, world, rand);
		this.generateOre(this.leadGen, EnumOreGenZG.LEAD, world, rand);
		this.generateOre(this.tinGen, EnumOreGenZG.TIN, world, rand);
		this.generateOre(this.copperGen, EnumOreGenZG.COPPER, world, rand);
		this.generateOre(this.lapisGen, EnumOreGenZG.LAPIS, world, rand);
		this.generateOre(this.diamondGen, EnumOreGenZG.DIAMOND, world, rand);
		this.generateOre(this.emeraldGen, EnumOreGenZG.EMERALD, world, rand);
		this.generateOre(this.redstoneGen, EnumOreGenZG.REDSTONE, world, rand);
		this.generateOre(this.goldGen, EnumOreGenZG.GOLD, world, rand);
		this.generateOre(this.steelGen, EnumOreGenZG.STEEL, world, rand);
		this.generateOre(this.rubyGen, EnumOreGenZG.RUBY, world, rand);
		this.generateOre(this.sapphireGen, EnumOreGenZG.SAPPHIRE, world, rand);
		this.generateOre(this.zincGen, EnumOreGenZG.ZINC, world, rand);
		this.generateOre(this.amaranthGen, EnumOreGenZG.AMARANTH, world, rand);
		this.generateOre(this.superChargedCoalGen, EnumOreGenZG.SUPER_CHARGED_COAL, world, rand);
		
		int genY = y;
		
		if (biome instanceof BiomeSpace) {
			BiomeSpace spaceBiome = (BiomeSpace) biome;
			genY = spaceBiome.getBiomeHeight();
		}
		
		// Lava Lakes
		if (this.generateLakes && this.lavaLakesPerChunk > 0) {
			for (int i = 0; i < this.lavaLakesPerChunk + 4; ++i) {
				y = rand.nextInt(rand.nextInt(genY) + 8);
				
				if (rand.nextInt((this.enableExtremeMode) ? 75 : 100) <= 50) {
					(new WorldGenLakesZG(Blocks.LAVA, NETHERRACK)).generate(world, rand, this.chunkPos.add(x, y, z));
				}
			}
		}
		
		// Mushrooms (Small)
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.SHROOM)) {
			if (this.generateMushrooms) {
				for (int l3 = 0; l3 < this.mushroomsPerChunk; ++l3) {
					if (rand.nextInt(4) == 0) {
						int i8 = rand.nextInt(16) + 8;
						int l11 = rand.nextInt(16) + 8;
						BlockPos blockpos2 = world.getHeight(this.chunkPos.add(i8, 0, l11));
						this.mushroomBrownGen.generate(world, rand, blockpos2);
					}
					
					if (rand.nextInt(8) == 0) {
						int j8 = rand.nextInt(16) + 8;
						int i12 = rand.nextInt(16) + 8;
						int j15 = world.getHeight(this.chunkPos.add(j8, 0, i12)).getY() * 2;
						
						if (j15 > 0) {
							int k18 = rand.nextInt(j15);
							BlockPos blockpos5 = this.chunkPos.add(j8, k18, i12);
							this.mushroomRedGen.generate(world, rand, blockpos5);
						}
					}
				}
				
				if (rand.nextInt(4) == 0) {
					int i4 = rand.nextInt(16) + 8;
					int k8 = rand.nextInt(16) + 8;
					int j12 = world.getHeight(this.chunkPos.add(i4, 0, k8)).getY() * 2;
					
					if (j12 > 0) {
						int k15 = rand.nextInt(j12);
						this.mushroomBrownGen.generate(world, rand, this.chunkPos.add(i4, k15, k8));
					}
				}
				
				if (rand.nextInt(8) == 0) {
					int j4 = rand.nextInt(16) + 8;
					int l8 = rand.nextInt(16) + 8;
					int k12 = world.getHeight(this.chunkPos.add(j4, 0, l8)).getY() * 2;
					
					if (k12 > 0) {
						int l15 = rand.nextInt(k12);
						this.mushroomRedGen.generate(world, rand, this.chunkPos.add(j4, l15, l8));
					}
				}
			}
		}
		
		// Sand
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.SAND)) {
			for (int i = 0; i < this.sandPatchesPerChunk; ++i) {
				int j = rand.nextInt(16) + 8;
				int k = rand.nextInt(16) + 8;
				this.sandGen.generate(world, rand, world.getTopSolidOrLiquidBlock(this.chunkPos.add(j, 0, k)));
			}
		}
		
		// Outposts
		if (this.generateOutposts && this.outpostsPerChunk > 0) {
			if (biome instanceof BiomeSpace) {
				BiomeSpace spaceBiome = (BiomeSpace) biome;
				if (!BiomeUtils.isOceanBiome(spaceBiome)) {
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