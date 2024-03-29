/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.core.dimensions.chunkproviders;

import java.util.List;
import java.util.Random;
import javax.annotation.Nullable;
import micdoodle8.mods.galacticraft.api.world.ChunkProviderBase;
import micdoodle8.mods.galacticraft.core.perlin.generator.Gradient;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import micdoodle8.mods.galacticraft.core.world.gen.EnumCraterSize;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldEntitySpawner;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.NoiseGenerator;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.WorldGenBush;
import net.minecraft.world.gen.feature.WorldGenFire;
import net.minecraft.world.gen.feature.WorldGenGlowStone1;
import net.minecraft.world.gen.feature.WorldGenGlowStone2;
import net.minecraft.world.gen.feature.WorldGenHellLava;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.MapGenMineshaft;
import net.minecraft.world.gen.structure.MapGenNetherBridge;
import net.minecraftforge.common.ForgeModContainer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.InitMapGenEvent;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.biomes.decorators.BiomeDecoratorKronos;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.util.BiomeUtils;
import zollerngalaxy.worldgen.kronos.WorldGenFireZG;
import zollerngalaxy.worldgen.kronos.WorldGenKronosDungeons;
import zollerngalaxy.worldgen.mapgen.MapGenCavesZG;
import zollerngalaxy.worldgen.mapgen.MapGenRavinesZG;
import zollerngalaxy.worldgen.structures.villages.MapGenVillageZG;

public class ChunkProviderKronos extends ChunkProviderBase {
	
	protected static final IBlockState AIR = Blocks.AIR.getDefaultState();
	protected static final IBlockState NETHERRACK = Blocks.NETHERRACK.getDefaultState();
	protected static final IBlockState LAVA = Blocks.LAVA.getDefaultState();
	
	public static final double CHUNK_HEIGHT = 64.0D;
	public static final int SEA_LEVEL = 47;
	
	private static final int CHUNK_SIZE_X = 16;
	private static final int CHUNK_SIZE_Z = 16;
	
	private final BiomeDecoratorKronos biomeDecoratorKronos = new BiomeDecoratorKronos();
	private Random rand;
	private NoiseGeneratorOctaves noiseGen1;
	private NoiseGeneratorOctaves noiseGen2;
	private NoiseGeneratorOctaves noiseGen3;
	private NoiseGeneratorPerlin noiseGen4;
	private NoiseGeneratorOctaves noiseGen5;
	private NoiseGeneratorOctaves noiseGen6;
	private NoiseGeneratorOctaves mobSpawnerNoise;
	private final Gradient noiseGenSmooth1;
	private World world;
	private WorldType worldType;
	private final double[] terrainCalcs;
	private final float[] parabolicField;
	private double[] stoneNoise = new double[256];
	private MapGenCavesZG caveGenerator = new MapGenCavesZG(NETHERRACK.getBlock());
	private MapGenCavesZG caveGenerator2 = new MapGenCavesZG(NETHERRACK.getBlock());
	private MapGenCavesZG caveGenerator3 = new MapGenCavesZG(NETHERRACK.getBlock());
	private final MapGenRavinesZG ravineGenerator = new MapGenRavinesZG(NETHERRACK.getBlock());
	private final MapGenVillageZG villageGenerator = new MapGenVillageZG("Kronos", Blocks.RED_NETHER_BRICK);
	private MapGenMineshaft mineshaftGenerator = new MapGenMineshaft();
	private final WorldGenFire fireFeature = new WorldGenFire();
	private final WorldGenFireZG fireFeatureZG = new WorldGenFireZG();
	private final WorldGenerator quartzGen = new WorldGenMinable(Blocks.QUARTZ_ORE.getDefaultState(), 14, BlockMatcher.forBlock(Blocks.NETHERRACK));
	private final WorldGenerator magmaGen = new WorldGenMinable(Blocks.MAGMA.getDefaultState(), 33, BlockMatcher.forBlock(Blocks.NETHERRACK));
	private final WorldGenGlowStone1 lightGemGen = new WorldGenGlowStone1();
	private final WorldGenGlowStone2 hellPortalGen = new WorldGenGlowStone2();
	private final WorldGenHellLava lavaTrapGen = new WorldGenHellLava(Blocks.FLOWING_LAVA, true);
	private final WorldGenHellLava hellSpringGen = new WorldGenHellLava(Blocks.FLOWING_LAVA, false);
	private final WorldGenBush brownMushroomFeature = new WorldGenBush(Blocks.BROWN_MUSHROOM);
	private final WorldGenBush redMushroomFeature = new WorldGenBush(Blocks.RED_MUSHROOM);
	private MapGenNetherBridge genNetherBridge = new MapGenNetherBridge();
	private Biome[] biomesForGeneration;
	private double[] octaves1;
	private double[] octaves2;
	private double[] octaves3;
	private double[] octaves4;
	
	public static ChunkProviderKronos INSTANCE;
	
	private static final int CRATER_PROB = 100;
	
	public ChunkProviderKronos(World worldIn, long seed, boolean mapFeaturesEnabled) {
		this.world = worldIn;
		this.worldType = worldIn.getWorldInfo().getTerrainType();
		this.rand = new Random(seed);
		this.noiseGen1 = new NoiseGeneratorOctaves(this.rand, 16);
		this.noiseGen2 = new NoiseGeneratorOctaves(this.rand, 16);
		this.noiseGen3 = new NoiseGeneratorOctaves(this.rand, 8);
		this.noiseGen4 = new NoiseGeneratorPerlin(this.rand, 4);
		this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
		this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
		this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);
		this.noiseGenSmooth1 = new Gradient(this.rand.nextLong(), 4, 0.25F);
		this.terrainCalcs = new double[825];
		this.parabolicField = new float[25];
		
		for (int i = -2; i <= 2; ++i) {
			for (int j = -2; j <= 2; ++j) {
				float f = 10.0F / MathHelper.sqrt(i * i + j * j + 0.2F);
				this.parabolicField[i + 2 + (j + 2) * 5] = f;
			}
		}
		
		NoiseGenerator[] noiseGens = { noiseGen1, noiseGen2, noiseGen3, noiseGen4, noiseGen5, noiseGen6, mobSpawnerNoise };
		this.noiseGen1 = (NoiseGeneratorOctaves) noiseGens[0];
		this.noiseGen2 = (NoiseGeneratorOctaves) noiseGens[1];
		this.noiseGen3 = (NoiseGeneratorOctaves) noiseGens[2];
		this.noiseGen4 = (NoiseGeneratorPerlin) noiseGens[3];
		this.noiseGen5 = (NoiseGeneratorOctaves) noiseGens[4];
		this.noiseGen6 = (NoiseGeneratorOctaves) noiseGens[5];
		this.mobSpawnerNoise = (NoiseGeneratorOctaves) noiseGens[6];
		this.genNetherBridge = (MapGenNetherBridge) TerrainGen.getModdedMapGen(this.genNetherBridge, InitMapGenEvent.EventType.NETHER_BRIDGE);
		INSTANCE = this;
	}
	
	private void setBlocksInChunk(int chunkX, int chunkZ, ChunkPrimer primer) {
		this.noiseGenSmooth1.setFrequency(0.035F);
		this.biomesForGeneration = this.world.getBiomeProvider().getBiomesForGeneration(this.biomesForGeneration, chunkX * 4 - 2, chunkZ * 4 - 2, 10, 10);
		this.createLandPerBiome(chunkX * 4, chunkZ * 4);
		
		for (int i = 0; i < 4; ++i) {
			int j = i * 5;
			int k = (i + 1) * 5;
			
			for (int l = 0; l < 4; ++l) {
				int i1 = (j + l) * 33;
				int j1 = (j + l + 1) * 33;
				int k1 = (k + l) * 33;
				int l1 = (k + l + 1) * 33;
				
				for (int i2 = 0; i2 < 32; ++i2) {
					double d0 = 0.125D;
					double d1 = this.terrainCalcs[i1 + i2];
					double d2 = this.terrainCalcs[j1 + i2];
					double d3 = this.terrainCalcs[k1 + i2];
					double d4 = this.terrainCalcs[l1 + i2];
					double d5 = (this.terrainCalcs[i1 + i2 + 1] - d1) * d0;
					double d6 = (this.terrainCalcs[j1 + i2 + 1] - d2) * d0;
					double d7 = (this.terrainCalcs[k1 + i2 + 1] - d3) * d0;
					double d8 = (this.terrainCalcs[l1 + i2 + 1] - d4) * d0;
					
					for (int j2 = 0; j2 < 8; ++j2) {
						double d9 = 0.25D;
						double d10 = d1;
						double d11 = d2;
						double d12 = (d3 - d1) * d9;
						double d13 = (d4 - d2) * d9;
						
						for (int k2 = 0; k2 < 4; ++k2) {
							double d14 = 0.25D;
							double d16 = (d11 - d10) * d14;
							double lvt_45_1_ = d10 - d16;
							
							for (int l2 = 0; l2 < 4; ++l2) {
								int x = i * 4 + k2;
								int y = i2 * 8 + j2;
								int z = l * 4 + l2;
								
								double chunkHeight = CHUNK_HEIGHT;
								
								Biome biome = world.getBiome(new BlockPos(x, y, z));
								
								if (BiomeUtils.isOceanBiome(biome)) {
									chunkHeight = 5D;
								}
								
								double heightMod = 0.0D;
								
								if (biome instanceof BiomeSpace) {
									BiomeSpace spaceBiome = (BiomeSpace) biome;
									heightMod = (spaceBiome.getBiomeHeight());
								}
								
								if (heightMod > 0.0D) {
									chunkHeight = (CHUNK_HEIGHT + heightMod);
								}
								
								if ((lvt_45_1_ += d16) > this.noiseGenSmooth1.getNoise(chunkX * 16 + x, chunkZ * 16 + z) * chunkHeight) {
									primer.setBlockState(x, y, z, NETHERRACK);
								} else if (y < SEA_LEVEL) {
									IBlockState blockToUse = LAVA;
									primer.setBlockState(x, y, z, blockToUse);
								}
							}
							
							d10 += d12;
							d11 += d13;
						}
						
						d1 += d5;
						d2 += d6;
						d3 += d7;
						d4 += d8;
					}
				}
			}
		}
	}
	
	private void replaceBlocksForBiome(int p_180517_1_, int p_180517_2_, ChunkPrimer p_180517_3_, Biome[] p_180517_4_) {
		double d0 = 0.03125D;
		this.stoneNoise = this.noiseGen4.getRegion(this.stoneNoise, p_180517_1_ * 16, p_180517_2_ * 16, 16, 16, d0 * 2.0D, d0 * 2.0D, 1.0D);
		
		for (int i = 0; i < 16; ++i) {
			for (int j = 0; j < 16; ++j) {
				Biome biomegenbase = p_180517_4_[j + i * 16];
				biomegenbase.genTerrainBlocks(this.world, this.rand, p_180517_3_, p_180517_1_ * 16 + i, p_180517_2_ * 16 + j, this.stoneNoise[j + i * 16]);
			}
		}
	}
	
	@Override
	public Chunk generateChunk(int x, int z) {
		this.rand.setSeed(x * 341873128712L + z * 132897987541L);
		ChunkPrimer chunkprimer = new ChunkPrimer();
		this.setBlocksInChunk(x, z, chunkprimer);
		this.biomesForGeneration = this.world.getBiomeProvider().getBiomes(this.biomesForGeneration, x * 16, z * 16, 16, 16);
		
		this.replaceBlocksForBiome(x, z, chunkprimer, this.biomesForGeneration);
		
		this.caveGenerator.generate(this.world, x, z, chunkprimer);
		this.caveGenerator2.generate(this.world, x, z, chunkprimer);
		this.caveGenerator3.generate(this.world, x, z, chunkprimer);
		this.ravineGenerator.generate(this.world, x, z, chunkprimer);
		this.villageGenerator.generate(this.world, x, z, chunkprimer);
		this.mineshaftGenerator.generate(this.world, x, z, chunkprimer);
		this.genNetherBridge.generate(this.world, x, z, chunkprimer);
		
		Chunk chunk = new Chunk(this.world, chunkprimer, x, z);
		byte[] abyte = chunk.getBiomeArray();
		
		for (int i = 0; i < abyte.length; ++i) {
			abyte[i] = (byte) Biome.getIdForBiome(this.biomesForGeneration[i]);
		}
		
		chunk.generateSkylightMap();
		return chunk;
	}
	
	private void createLandPerBiome(int x, int z) {
		this.octaves4 = this.noiseGen6.generateNoiseOctaves(this.octaves4, x, z, 5, 5, 2000.0, 2000.0, 0.5);
		this.octaves1 = this.noiseGen3.generateNoiseOctaves(this.octaves1, x, 0, z, 5, 33, 5, 8.555150000000001D, 4.277575000000001D, 8.555150000000001D);
		this.octaves2 = this.noiseGen1.generateNoiseOctaves(this.octaves2, x, 0, z, 5, 33, 5, 684.412D, 684.412D, 684.412D);
		this.octaves3 = this.noiseGen2.generateNoiseOctaves(this.octaves3, x, 0, z, 5, 33, 5, 684.412D, 684.412D, 684.412D);
		int i = 0;
		int j = 0;
		
		for (int k = 0; k < 5; ++k) {
			for (int l = 0; l < 5; ++l) {
				float f2 = 0.0F;
				float f3 = 0.0F;
				float f4 = 0.0F;
				int i1 = 2;
				Biome biomegenbase = this.biomesForGeneration[k + 2 + (l + 2) * 10];
				
				for (int j1 = -i1; j1 <= i1; ++j1) {
					for (int k1 = -i1; k1 <= i1; ++k1) {
						Biome biomegenbase1 = this.biomesForGeneration[k + j1 + 2 + (l + k1 + 2) * 10];
						float f5 = biomegenbase1.getBaseHeight();
						float f6 = biomegenbase1.getHeightVariation();
						
						if (this.worldType == WorldType.AMPLIFIED && f5 > 0.0F) {
							f5 = 1.0F + f5 * 2.0F;
							f6 = 1.0F + f6 * 4.0F;
						}
						
						float f7 = this.parabolicField[j1 + 2 + (k1 + 2) * 5] / (f5 + 2.0F);
						
						f2 += f6 * f7;
						f3 += f5 * f7;
						f4 += f7;
					}
				}
				
				f2 = f2 / f4;
				f3 = f3 / f4;
				f2 = f2 * 0.9F + 0.1F;
				f3 = (f3 * 4.0F - 1.0F) / 8.0F;
				double d7 = this.octaves4[j] / 4000.0D;
				
				if (d7 < 0.0D) {
					d7 = -d7 * 0.3D;
				}
				
				d7 = d7 * 3.0D - 2.0D;
				
				if (d7 < 0.0D) {
					d7 = d7 / 2.0D;
					
					if (d7 < -1.0D) {
						d7 = -1.0D;
					}
					
					d7 = d7 / 1.4D;
					d7 = d7 / 2.0D;
				} else {
					if (d7 > 1.0D) {
						d7 = 1.0D;
					}
					
					d7 = d7 / 8.0D;
				}
				
				++j;
				double d8 = f3;
				double d9 = f2;
				d8 = d8 + d7 * 0.2D;
				d8 = d8 * 8.5 / 8.0D;
				double d0 = 8.5 + d8 * 4.0D;
				
				for (int l1 = 0; l1 < 33; ++l1) {
					double d1 = (l1 - d0) * 12.0 * 128.0D / 256.0D / d9;
					
					if (d1 < 0.0D) {
						d1 *= 4.0D;
					}
					
					double d2 = this.octaves2[i] / 512.0;
					double d3 = this.octaves3[i] / 1024.0;
					double d4 = (this.octaves1[i] / 10.0D + 1.0D) / 2.0D;
					double d5 = MathHelper.clampedLerp(d2, d3, d4) - d1;
					// double d5 = d3 - d1;
					
					if (l1 > 29) {
						double d6 = (l1 - 29) / 3.0F;
						d5 = d5 * (1.0D - d6) + -10.0D * d6;
					}
					
					this.terrainCalcs[i] = d5;
					++i;
				}
			}
		}
	}
	
	public void createCraters(int chunkX, int chunkZ, ChunkPrimer primer) {
		for (int cx = chunkX - 2; cx <= chunkX + 2; cx++) {
			for (int cz = chunkZ - 2; cz <= chunkZ + 2; cz++) {
				for (int x = 0; x < ChunkProviderKronos.CHUNK_SIZE_X; x++) {
					for (int z = 0; z < ChunkProviderKronos.CHUNK_SIZE_Z; z++) {
						if (Math.abs(this.randFromPoint(cx * 16 + x, (cz * 16 + z) * 1000)) < this.noiseGen4.getValue(x * CHUNK_SIZE_X + x, cz * CHUNK_SIZE_Z + z) / CRATER_PROB) {
							final Random random = new Random(cx * 16 + x + (cz * 16 + z) * 5000);
							final EnumCraterSize cSize = EnumCraterSize.sizeArray[random.nextInt(EnumCraterSize.sizeArray.length)];
							final int size = random.nextInt(cSize.MAX_SIZE - cSize.MIN_SIZE) + cSize.MIN_SIZE;
							this.makeCrater(cx * 16 + x, cz * 16 + z, chunkX * 16, chunkZ * 16, size, primer);
						}
					}
				}
			}
		}
	}
	
	private void makeCrater(int craterX, int craterZ, int chunkX, int chunkZ, int size, ChunkPrimer primer) {
		for (int x = 0; x < CHUNK_SIZE_X; x++) {
			for (int z = 0; z < CHUNK_SIZE_Z; z++) {
				double xDev = craterX - (chunkX + x);
				double zDev = craterZ - (chunkZ + z);
				if (xDev * xDev + zDev * zDev < size * size) {
					xDev /= size;
					zDev /= size;
					final double sqrtY = xDev * xDev + zDev * zDev;
					double yDev = sqrtY * sqrtY * 6;
					yDev = 5 - yDev;
					int helper = 0;
					for (int y = 127; y > 0; y--) {
						if (Blocks.AIR != primer.getBlockState(x, y, z).getBlock() && helper <= yDev) {
							primer.setBlockState(x, y, z, Blocks.AIR.getDefaultState());
							helper++;
						}
						if (helper > yDev) {
							break;
						}
					}
				}
			}
		}
	}
	
	private double randFromPoint(int x, int z) {
		int n;
		n = x + z * 57;
		n = n << 13 ^ n;
		return 1.0 - (n * (n * n * 15731 + 789221) + 1376312589 & 0x7fffffff) / 1073741824.0;
	}
	
	@Override
	public void populate(int x, int z) {
		BlockFalling.fallInstantly = true;
		ForgeEventFactory.onChunkPopulate(true, this, this.world, this.rand, x, z, false);
		int i = x * 16;
		int j = z * 16;
		BlockPos blockpos = new BlockPos(i, 0, j);
		Biome biomegenbase = this.world.getBiome(blockpos.add(16, 0, 16));
		this.rand.setSeed(this.world.getSeed());
		long k = this.rand.nextLong() / 2L * 2L + 1L;
		long l = this.rand.nextLong() / 2L * 2L + 1L;
		this.rand.setSeed(x * k + z * l ^ this.world.getSeed());
		ChunkPos chunkPos = new ChunkPos(x, z);
		
		if (!ConfigManagerCore.disableMoonVillageGen && !BiomeUtils.isOceanBiome(biomegenbase)) {
			this.villageGenerator.generateStructure(this.world, this.rand, chunkPos);
		}
		
		if (ConfigManagerZG.enableMineshaftsOnKronos) {
			this.mineshaftGenerator.generateStructure(this.world, this.rand, new ChunkPos(x, z));
		}
		
		this.genNetherBridge.generateStructure(this.world, this.rand, chunkPos);
		
		// Lava
		if (TerrainGen.populate(this, this.world, this.rand, x, z, false, PopulateChunkEvent.Populate.EventType.NETHER_LAVA)) {
			for (int t = 0; t < 8; ++t) {
				this.hellSpringGen.generate(this.world, this.rand, blockpos.add(this.rand.nextInt(16) + 8, this.rand.nextInt(120) + 4, this.rand.nextInt(16) + 8));
			}
		}
		
		// Fire
		if (TerrainGen.populate(this, this.world, this.rand, x, z, false, PopulateChunkEvent.Populate.EventType.FIRE)) {
			for (int i1 = 0; i1 < this.rand.nextInt(this.rand.nextInt(10) + 1) + 1; ++i1) {
				this.fireFeature.generate(this.world, this.rand, blockpos.add(this.rand.nextInt(16) + 8, this.rand.nextInt(120) + 4, this.rand.nextInt(16) + 8));
			}
			
			for (int i1 = 0; i1 < this.rand.nextInt(this.rand.nextInt(10) + 1) + 1; ++i1) {
				this.fireFeatureZG.generate(this.world, this.rand, blockpos.add(this.rand.nextInt(16) + 8, this.rand.nextInt(120) + 4, this.rand.nextInt(16) + 8));
			}
		}
		
		// Glowstone
		if (TerrainGen.populate(this, this.world, this.rand, x, z, false, PopulateChunkEvent.Populate.EventType.GLOWSTONE)) {
			for (int j1 = 0; j1 < this.rand.nextInt(this.rand.nextInt(10) + 1); ++j1) {
				this.lightGemGen.generate(this.world, this.rand, blockpos.add(this.rand.nextInt(16) + 8, this.rand.nextInt(120) + 4, this.rand.nextInt(16) + 8));
			}
			
			for (int k1 = 0; k1 < 10; ++k1) {
				this.hellPortalGen.generate(this.world, this.rand, blockpos.add(this.rand.nextInt(16) + 8, this.rand.nextInt(128), this.rand.nextInt(16) + 8));
			}
		}
		
		ForgeEventFactory.onChunkPopulate(false, this, this.world, this.rand, x, z, false);
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(this.world, this.rand, new ChunkPos(x, z)));
		
		// Mushrooms
		if (TerrainGen.decorate(this.world, this.rand, chunkPos, DecorateBiomeEvent.Decorate.EventType.SHROOM)) {
			if (this.rand.nextBoolean()) {
				this.brownMushroomFeature.generate(this.world, this.rand, blockpos.add(this.rand.nextInt(16) + 8, this.rand.nextInt(128), this.rand.nextInt(16) + 8));
			}
			
			if (this.rand.nextBoolean()) {
				this.redMushroomFeature.generate(this.world, this.rand, blockpos.add(this.rand.nextInt(16) + 8, this.rand.nextInt(128), this.rand.nextInt(16) + 8));
			}
		}
		
		// Quartz Ore
		if (TerrainGen.generateOre(this.world, this.rand, quartzGen, blockpos, OreGenEvent.GenerateMinable.EventType.QUARTZ)) {
			for (int l1 = 0; l1 < 16; ++l1) {
				this.quartzGen.generate(this.world, this.rand, blockpos.add(this.rand.nextInt(16), this.rand.nextInt(108) + 10, this.rand.nextInt(16)));
			}
		}
		
		int i2 = this.world.getSeaLevel() / 2 + 1;
		
		// Magma Rock
		if (TerrainGen.populate(this, this.world, this.rand, x, z, false, PopulateChunkEvent.Populate.EventType.NETHER_MAGMA)) {
			for (int u = 0; u < 4; ++u) {
				this.magmaGen.generate(this.world, this.rand, blockpos.add(this.rand.nextInt(16), i2 - 5 + this.rand.nextInt(10), this.rand.nextInt(16)));
			}
		}
		
		// Lava
		if (TerrainGen.populate(this, this.world, this.rand, x, z, false, PopulateChunkEvent.Populate.EventType.NETHER_LAVA2)) {
			for (int j2 = 0; j2 < 16; ++j2) {
				int offset = ForgeModContainer.fixVanillaCascading ? 8 : 0; // MC-117810
				this.lavaTrapGen.generate(this.world, this.rand, blockpos.add(this.rand.nextInt(16) + offset, this.rand.nextInt(108) + 10, this.rand.nextInt(16) + offset));
			}
		}
		
		// Dungeons
		if (TerrainGen.populate(this, this.world, this.rand, x, z, false, PopulateChunkEvent.Populate.EventType.DUNGEON)) {
			for (int j2 = 0; j2 < 8; ++j2) {
				int i3 = this.rand.nextInt(16) + 8;
				int l3 = this.rand.nextInt(128);
				int l1 = this.rand.nextInt(16) + 8;
				(new WorldGenKronosDungeons()).generate(this.world, this.rand, blockpos.add(i3, l3, l1));
			}
		}
		
		biomegenbase.decorate(this.world, this.rand, new BlockPos(i, 0, j));
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(this.world, this.rand, blockpos));
		WorldEntitySpawner.performWorldGenSpawning(this.world, biomegenbase, i + 8, j + 8, 16, 16, this.rand);
		BlockFalling.fallInstantly = false;
	}
	
	@Override
	@Nullable
	public BlockPos getNearestStructurePos(World worldIn, String structureName, BlockPos position, boolean findUnexplored) {
		return "Fortress".equals(structureName) && this.genNetherBridge != null ? this.genNetherBridge.getNearestStructurePos(worldIn, position, findUnexplored) : null;
	}
	
	@Override
	public boolean isInsideStructure(World worldIn, String structureName, BlockPos pos) {
		return "Fortress".equals(structureName) && this.genNetherBridge != null ? this.genNetherBridge.isInsideStructure(pos) : false;
	}
	
	@Override
	public List<Biome.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
		Biome biomegenbase = this.world.getBiome(pos);
		return biomegenbase.getSpawnableList(creatureType);
	}
	
	@Override
	public void recreateStructures(Chunk chunk, int x, int z) {
		if (ConfigManagerZG.enableMineshaftsOnKronos) {
			this.mineshaftGenerator.generate(this.world, x, z, null);
		}
		Biome biome = chunk.getWorld().getBiome(new BlockPos(x, 0, z));
		if (!ConfigManagerCore.disableMoonVillageGen && !BiomeUtils.isOceanBiome(biome)) {
			this.villageGenerator.generate(this.world, x, z, null);
		}
		this.genNetherBridge.generate(this.world, x, z, (ChunkPrimer) null);
	}
}