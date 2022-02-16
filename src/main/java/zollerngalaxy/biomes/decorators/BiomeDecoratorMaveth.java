/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.decorators;

import java.util.Random;
import micdoodle8.mods.galacticraft.core.GCBlocks;
import micdoodle8.mods.galacticraft.core.event.EventHandlerGC;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenLiquids;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.dimensions.chunkproviders.ChunkProviderMaveth;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.core.enums.EnumOreGenZG;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.util.BiomeUtils;
import zollerngalaxy.worldgen.WorldGenBattleTower;
import zollerngalaxy.worldgen.WorldGenLakesZG;
import zollerngalaxy.worldgen.WorldGenMinableZG;
import zollerngalaxy.worldgen.WorldGenOutpost;
import zollerngalaxy.worldgen.WorldGenSmallCraterZG;
import zollerngalaxy.worldgen.WorldGenTunnel;

public class BiomeDecoratorMaveth extends BiomeDecoratorZG {
	
	private static final Block STONE = ZGBlocks.mavethStone;
	private static final Block ROCK = ZGBlocks.mavethRock;
	
	private WorldGenerator ironGen;
	private WorldGenerator electrumGen;
	private WorldGenerator amaranthGen;
	private WorldGenerator zollerniumGen;
	private WorldGenerator vibraniumGen;
	
	private WorldGenerator tunnelGen = new WorldGenTunnel();
	private WorldGenerator craterGen = new WorldGenSmallCraterZG();
	private WorldGenerator battleTowerGen = new WorldGenBattleTower(ZGBlocks.mavethCobblestone.getDefaultState(), ZGBlocks.mavethRock.getDefaultState());
	
	public int tunnelsPerChunk = 5;
	public int cratersPerChunk = 2;
	public int battleTowersPerChunk = 1;
	public int waterLakesPerChunk = 1;
	public int lavaLakesPerChunk = 1;
	public int mushroomsPerChunk = 2;
	
	public boolean generateCraters = true;
	public boolean generateTunnels = true;
	public boolean generateBattleTowers = true;
	public boolean generateLakes = true;
	public boolean generateMushrooms = true;
	
	public BiomeDecoratorMaveth() {
		this.ironGen = new WorldGenMinableZG(ZGBlocks.mavethIronOre, STONE, EnumOreGenZG.IRON);
		this.electrumGen = new WorldGenMinableZG(ZGBlocks.mavethElectrumOre, STONE, EnumOreGenZG.ELECTRUM);
		this.amaranthGen = new WorldGenMinableZG(ZGBlocks.mavethAmaranthOre, STONE, EnumOreGenZG.AMARANTH);
		this.zollerniumGen = new WorldGenMinableZG(ZGBlocks.mavethZollerniumOre, STONE, EnumOreGenZG.ZOLLERNIUM);
		this.vibraniumGen = new WorldGenMinableZG(ZGBlocks.mavethVibraniumOre, STONE, EnumOreGenZG.VIBRANIUM);
	}
	
	@Override
	protected void generate(Biome biome, World world, Random rand) {
		int x = rand.nextInt(16) + 8;
		int z = rand.nextInt(16) + 8;
		
		ChunkPrimer chunkPrimer = new ChunkPrimer();
		ChunkPos forgeChunkPos = new ChunkPos(this.chunkPos);
		
		int genY = 248;
		int y = genY;
		
		Block BLOCK_TOP = biome.topBlock.getBlock();
		Block BLOCK_FILL = biome.fillerBlock.getBlock();
		Block BLOCK_STONE = ZGBlocks.mavethStone;
		
		if (biome instanceof BiomeSpace) {
			BiomeSpace spaceBiome = (BiomeSpace) biome;
			genY = spaceBiome.getBiomeHeight();
		}
		
		this.generateOre(this.ironGen, EnumOreGenZG.IRON, world, rand);
		this.generateOre(this.electrumGen, EnumOreGenZG.SHINIUM, world, rand);
		this.generateOre(this.amaranthGen, EnumOreGenZG.FUELTONIUM, world, rand);
		this.generateOre(this.zollerniumGen, EnumOreGenZG.ZOLLERNIUM, world, rand);
		this.generateOre(this.vibraniumGen, EnumOreGenZG.VIBRANIUM, world, rand);
		
		// Lava Lakes
		if (this.generateLakes && this.lavaLakesPerChunk > 0) {
			for (int i = 0; i < this.lavaLakesPerChunk; ++i) {
				y = rand.nextInt(rand.nextInt(genY) + 8);
				
				if (rand.nextInt((this.enableExtremeMode) ? 75 : 100) <= 50) {
					(new WorldGenLakesZG(Blocks.LAVA, BLOCK_STONE)).generate(world, rand, this.chunkPos.add(x, y, z));
				}
			}
		}
		
		// Water Lakes
		if (this.generateLakes && this.waterLakesPerChunk > 0) {
			for (int i = 0; i < this.waterLakesPerChunk; ++i) {
				y = rand.nextInt(rand.nextInt(genY) + 8);
				Block blockToUse = (BiomeUtils.isColdBiome(biome)) ? Blocks.ICE : Blocks.WATER;
				(new WorldGenLakesZG(blockToUse, BLOCK_TOP)).generate(world, rand, this.chunkPos.add(x, y, z));
			}
		}
		
		// Oil Lakes
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.CUSTOM)) {
			if (this.generateOil && this.oilPerChunk > 0 && this.enableOilGen) {
				for (int i = 0; i < this.oilPerChunk; ++i) {
					y = rand.nextInt(rand.nextInt(genY) + 8);
					(new WorldGenLakesZG(GCBlocks.crudeOil, ZGBlocks.edenStone)).generate(world, rand, this.chunkPos.add(x, y, z));
					EventHandlerGC.generateOil(world, rand, x, z, false);
				}
			}
		}
		
		// Mushrooms (Small)
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.SHROOM)) {
			if (this.generateMushrooms && this.mushroomsPerChunk > 0) {
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
		
		// Falls
		if (this.generateFalls) {
			if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.LAKE_WATER)) {
				for (int k5 = 0; k5 < 50; ++k5) {
					int i10 = rand.nextInt(16) + 8;
					int l13 = rand.nextInt(16) + 8;
					int i17 = rand.nextInt(120) + 8;
					
					if (i17 > 0) {
						int k19 = rand.nextInt(i17);
						BlockPos blockpos6 = this.chunkPos.add(i10, k19, l13);
						(new WorldGenLiquids(Blocks.FLOWING_WATER)).generate(world, rand, blockpos6);
					}
				}
			}
			
			if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.LAKE_LAVA)) {
				for (int l5 = 0; l5 < 20; ++l5) {
					int j10 = rand.nextInt(16) + 8;
					int i14 = rand.nextInt(16) + 8;
					int j17 = rand.nextInt(rand.nextInt(rand.nextInt(112) + 8) + 8);
					BlockPos blockpos3 = this.chunkPos.add(j10, j17, i14);
					(new WorldGenLiquids(Blocks.FLOWING_LAVA)).generate(world, rand, blockpos3);
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
		
		// Craters (Small)
		int craterSpawnChance = ConfigManagerZG.craterSpawnChance;
		if (this.generateCraters && this.cratersPerChunk > 0 && craterSpawnChance > 0) {
			ChunkProviderMaveth.INSTANCE.createCraters(x, z, chunkPrimer);
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