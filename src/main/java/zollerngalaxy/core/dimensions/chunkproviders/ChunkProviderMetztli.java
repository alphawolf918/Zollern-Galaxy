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
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.world.gen.structure.MapGenMineshaft;
import net.minecraft.world.gen.structure.MapGenScatteredFeature;
import net.minecraft.world.gen.structure.MapGenStronghold;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.terraingen.InitMapGenEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.biomes.decorators.BiomeDecoratorMetztli;
import zollerngalaxy.util.BiomeUtils;
import zollerngalaxy.worldgen.ZGWoodlandMansion;
import zollerngalaxy.worldgen.mapgen.MapGenCavesZG;
import zollerngalaxy.worldgen.mapgen.MapGenRavinesZG;
import zollerngalaxy.worldgen.structures.villages.MapGenVillageHarran;
import zollerngalaxy.worldgen.structures.villages.MapGenVillageZG;

public class ChunkProviderMetztli extends ChunkProviderBase {
	
	public static final IBlockState STONE = Blocks.STONE.getDefaultState();
	public static final IBlockState WATER = Blocks.WATER.getDefaultState();
	public static final IBlockState ICE = Blocks.ICE.getDefaultState();
	
	public static final double CHUNK_HEIGHT = 36.0D;
	public static final int SEA_LEVEL = 63;
	
	private static final int CHUNK_SIZE_X = 16;
	private static final int CHUNK_SIZE_Z = 16;
	
	private final BiomeDecoratorMetztli biomeDecoratorMetztli = new BiomeDecoratorMetztli();
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
	private MapGenCavesZG caveGenerator = new MapGenCavesZG(Blocks.STONE);
	private final MapGenRavinesZG ravineGenerator = new MapGenRavinesZG(Blocks.STONE);
	private final MapGenVillageZG planetVillageGenerator = new MapGenVillageZG("Metztli");
	public MapGenVillageHarran villageGenerator = new MapGenVillageHarran();
	private MapGenMineshaft mineshaftGenerator = new MapGenMineshaft();
	private ZGWoodlandMansion woodlandMansionGenerator = new ZGWoodlandMansion(this);
	private MapGenStronghold strongholdGenerator = new MapGenStronghold();
	private MapGenScatteredFeature scatteredFeatureGenerator = new MapGenScatteredFeature();
	private Biome[] biomesForGeneration;
	private double[] octaves1;
	private double[] octaves2;
	private double[] octaves3;
	private double[] octaves4;
	
	public static ChunkProviderMetztli INSTANCE;
	
	private static final int CRATER_PROB = 40;
	
	public ChunkProviderMetztli(World worldIn, long seed, boolean mapFeaturesEnabled) {
		this.world = worldIn;
		this.worldType = worldIn.getWorldInfo().getTerrainType();
		
		{
			this.woodlandMansionGenerator = (ZGWoodlandMansion) TerrainGen.getModdedMapGen(woodlandMansionGenerator, InitMapGenEvent.EventType.WOODLAND_MANSION);
			this.strongholdGenerator = (MapGenStronghold) TerrainGen.getModdedMapGen(strongholdGenerator, InitMapGenEvent.EventType.STRONGHOLD);
			this.villageGenerator = (MapGenVillageHarran) TerrainGen.getModdedMapGen(villageGenerator, InitMapGenEvent.EventType.VILLAGE);
		}
		
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
		this.INSTANCE = this;
	}
	
	public void callSetBlocks(int chunkX, int chunkZ, ChunkPrimer primer) {
		INSTANCE.setBlocksInChunk(chunkZ, chunkZ, primer);
	}
	
	private void setBlocksInChunk(int chunkX, int chunkZ, ChunkPrimer primer) {
		this.noiseGenSmooth1.setFrequency(0.025F);
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
									chunkHeight = 10D;
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
									primer.setBlockState(x, y, z, STONE);
								} else if (y < SEA_LEVEL) {
									// IBlockState state = world.getBlockState(new BlockPos(x, y,
									// z));
									// Block stateBlock = state.getBlock();
									IBlockState blockToUse = (BiomeUtils.isColdBiome(biome)) ? ICE : WATER;
									// int tickRate = blockToUse.getBlock().tickRate(world);
									primer.setBlockState(x, y, z, blockToUse);
									// world.scheduleBlockUpdate(new BlockPos(x, y, z),
									// blockToUse.getBlock(), tickRate, 1);
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
		
		this.woodlandMansionGenerator.generate(this.world, x, z, chunkprimer);
		this.strongholdGenerator.generate(this.world, x, z, chunkprimer);
		this.caveGenerator.generate(this.world, x, z, chunkprimer);
		this.ravineGenerator.generate(this.world, x, z, chunkprimer);
		this.planetVillageGenerator.generate(this.world, x, z, chunkprimer);
		this.mineshaftGenerator.generate(this.world, x, z, chunkprimer);
		this.villageGenerator.generate(this.world, x, z, chunkprimer);
		
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
				for (int x = 0; x < ChunkProviderMetztli.CHUNK_SIZE_X; x++) {
					for (int z = 0; z < ChunkProviderMetztli.CHUNK_SIZE_Z; z++) {
						if (Math.abs(
								this.randFromPoint(cx * 16 + x, (cz * 16 + z) * 1000)) < this.noiseGen4.getValue(x * ChunkProviderMetztli.CHUNK_SIZE_X + x, cz * ChunkProviderMetztli.CHUNK_SIZE_Z + z)
										/ ChunkProviderMetztli.CRATER_PROB) {
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
		for (int x = 0; x < ChunkProviderMetztli.CHUNK_SIZE_X; x++) {
			for (int z = 0; z < ChunkProviderMetztli.CHUNK_SIZE_Z; z++) {
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
		int i = x * 16;
		int j = z * 16;
		BlockPos blockpos = new BlockPos(i, 0, j);
		Biome biomegenbase = this.world.getBiome(blockpos.add(16, 0, 16));
		this.rand.setSeed(this.world.getSeed());
		long k = this.rand.nextLong() / 2L * 2L + 1L;
		long l = this.rand.nextLong() / 2L * 2L + 1L;
		this.rand.setSeed(x * k + z * l ^ this.world.getSeed());
		boolean flag = false;
		
		ForgeEventFactory.onChunkPopulate(true, this, this.world, this.rand, x, z, flag);
		
		if (!ConfigManagerCore.disableMoonVillageGen && !BiomeUtils.isOceanBiome(biomegenbase)) {
			flag = this.planetVillageGenerator.generateStructure(this.world, this.rand, new ChunkPos(x, z));
		}
		
		this.mineshaftGenerator.generateStructure(this.world, this.rand, new ChunkPos(x, z));
		this.woodlandMansionGenerator.generateStructure(this.world, this.rand, new ChunkPos(x, z));
		this.strongholdGenerator.generateStructure(this.world, this.rand, new ChunkPos(x, z));
		flag = this.villageGenerator.generateStructure(this.world, this.rand, new ChunkPos(x, z));
		
		if (TerrainGen.populate(this, this.world, this.rand, x, z, flag, PopulateChunkEvent.Populate.EventType.DUNGEON)) {
			for (int j2 = 0; j2 < 8; ++j2) {
				int i3 = this.rand.nextInt(16) + 8;
				int l3 = this.rand.nextInt(256);
				int l1 = this.rand.nextInt(16) + 8;
				(new WorldGenDungeons()).generate(this.world, this.rand, blockpos.add(i3, l3, l1));
			}
		}
		
		if (TerrainGen.populate(this, this.world, this.rand, x, z, flag, PopulateChunkEvent.Populate.EventType.ICE)) {
			for (int k2 = 0; k2 < 16; ++k2) {
				for (int j3 = 0; j3 < 16; ++j3) {
					BlockPos blockpos1 = this.world.getPrecipitationHeight(blockpos.add(k2, 0, j3));
					BlockPos blockpos2 = blockpos1.down();
					
					if (this.world.canBlockFreezeWater(blockpos2)) {
						this.world.setBlockState(blockpos2, Blocks.ICE.getDefaultState(), 2);
					}
					
					if (this.world.canSnowAt(blockpos1, true)) {
						this.world.setBlockState(blockpos1, Blocks.SNOW_LAYER.getDefaultState(), 2);
					}
				}
			}
		}
		
		biomegenbase.decorate(this.world, this.rand, new BlockPos(i, 0, j));
		WorldEntitySpawner.performWorldGenSpawning(this.world, biomegenbase, i + 8, j + 8, 16, 16, this.rand);
		
		BlockFalling.fallInstantly = false;
	}
	
	@Override
	public List<Biome.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
		Biome biomegenbase = this.world.getBiome(pos);
		return biomegenbase.getSpawnableList(creatureType);
	}
	
	@Override
	public boolean isInsideStructure(World worldIn, String structureName, BlockPos pos) {
		if ("HarranMansion".equals(structureName) && this.woodlandMansionGenerator != null) {
			return this.woodlandMansionGenerator.isInsideStructure(pos);
		} else if ("Stronghold".equals(structureName) && this.strongholdGenerator != null) {
			return this.strongholdGenerator.isInsideStructure(pos);
		} else if ("Mineshaft".equals(structureName) && this.mineshaftGenerator != null) {
			return this.mineshaftGenerator.isInsideStructure(pos);
		} else if ("HarranVillage".equals(structureName) && this.villageGenerator != null) {
			return this.villageGenerator.isInsideStructure(pos);
		}
		
		return false;
	}
	
	@Override
	@Nullable
	public BlockPos getNearestStructurePos(World worldIn, String structureName, BlockPos position, boolean findUnexplored) {
		if ("HarranMansion".equals(structureName) && this.woodlandMansionGenerator != null) {
			return this.woodlandMansionGenerator.getNearestStructurePos(worldIn, position, findUnexplored);
		} else if ("Stronghold".equals(structureName) && this.strongholdGenerator != null) {
			return this.strongholdGenerator.getNearestStructurePos(worldIn, position, findUnexplored);
		} else if ("Mineshaft".equals(structureName) && this.mineshaftGenerator != null) {
			return this.mineshaftGenerator.getNearestStructurePos(worldIn, position, findUnexplored);
		} else if ("HarranVillage".equals(structureName) && this.villageGenerator != null) {
			return this.villageGenerator.getNearestStructurePos(worldIn, position, findUnexplored);
		}
		
		return null;
	}
	
	@Override
	public void recreateStructures(Chunk chunk, int x, int z) {
		this.mineshaftGenerator.generate(this.world, x, z, null);
		Biome biome = chunk.getWorld().getBiome(new BlockPos(x, 0, z));
		
		if (!ConfigManagerCore.disableMoonVillageGen && !BiomeUtils.isOceanBiome(biome)) {
			this.planetVillageGenerator.generate(this.world, x, z, null);
		}
		
		this.woodlandMansionGenerator.generate(this.world, x, z, (ChunkPrimer) null);
		this.strongholdGenerator.generate(this.world, x, z, (ChunkPrimer) null);
		this.villageGenerator.generate(this.world, x, z, (ChunkPrimer) null);
	}
}