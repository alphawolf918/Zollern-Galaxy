/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.dimensions.providers.eden;

import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.ANIMALS;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.ICE;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.LAKE;
import galaxymod.biomes.BiomeList;
import galaxymod.biomes.decorators.ore.BiomeDecoratorEdenOre;
import galaxymod.blocks.BlockList;
import galaxymod.worldgen.eden.MapGenCavernEden;
import galaxymod.worldgen.eden.MapGenCavesEden;
import galaxymod.worldgen.eden.WorldGenEdenDungeons;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import micdoodle8.mods.galacticraft.api.prefab.core.BlockMetaPair;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.ChunkProviderSpace;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.MapGenBaseMeta;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.structure.MapGenMineshaft;
import net.minecraft.world.gen.structure.MapGenScatteredFeature;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import com.google.common.collect.Lists;

public class ChunkProviderEden extends ChunkProviderSpace {
	
	private Random rand;
	private final BiomeDecoratorEdenOre edenBiomeDecorator = new BiomeDecoratorEdenOre();
	private final MapGenCavernEden caveGenerator = new MapGenCavernEden();
	private final MapGenCavesEden cavernGenerator = new MapGenCavesEden();
	private final WorldGenEdenDungeons dungeonGenerator = new WorldGenEdenDungeons();
	private MapGenMineshaft mineshaftGenerator = new MapGenMineshaft();
	private MapGenScatteredFeature scatteredFeatureGenerator = new MapGenScatteredFeature();
	public World worldObj;
	private NoiseGeneratorOctaves noiseGen4;
	public NoiseGeneratorOctaves noiseGen5;
	public NoiseGeneratorOctaves noiseGen6;
	public NoiseGeneratorOctaves mobSpawnerNoise;
	private double[] stoneNoise;
	int i3;
	int j3;
	int k3;
	private BiomeGenBase[] biomesForGeneration;
	double[] noise3;
	double[] noise1;
	double[] noise2;
	double[] noise5;
	double[] noise6;
	float[] squareTable;
	private NoiseGeneratorOctaves field_147431_j;
	private NoiseGeneratorOctaves field_147432_k;
	private NoiseGeneratorOctaves field_147429_l;
	private NoiseGeneratorPerlin field_147430_m;
	private double[] terrainCalcs;
	private float[] parabolicField;
	double[] field_147427_d;
	double[] field_147428_e;
	double[] field_147425_f;
	double[] field_147426_g;
	
	public ChunkProviderEden(World world, long seed, boolean flag) {
		super(world, seed, flag);
		this.stoneNoise = new double[256];
		this.worldObj = world;
		this.rand = new Random(seed);
		this.noiseGen4 = new NoiseGeneratorOctaves(this.rand, 4);
		this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
		this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
		this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);
		this.field_147431_j = new NoiseGeneratorOctaves(this.rand, 16);
		this.field_147432_k = new NoiseGeneratorOctaves(this.rand, 16);
		this.field_147429_l = new NoiseGeneratorOctaves(this.rand, 8);
		this.field_147430_m = new NoiseGeneratorPerlin(this.rand, 4);
		this.terrainCalcs = new double[825];
		this.parabolicField = new float[25];
		
		for (int j = -2; j <= 2; j++) {
			for (int k = -2; k <= 2; k++) {
				float f = 10.0F / MathHelper.sqrt_float(j * j + k * k + 0.2F);
				this.parabolicField[j + 2 + (k + 2) * 5] = f;
			}
		}
	}
	
	@Override
	protected BiomeDecoratorSpace getBiomeGenerator() {
		return this.edenBiomeDecorator;
	}
	
	@Override
	protected BiomeGenBase[] getBiomesForGeneration() {
		return new BiomeGenBase[] { BiomeList.biomeEden,
				BiomeList.biomeEdenRockMountains,
				BiomeList.biomeEdenTerranValley,
				BiomeList.biomeEdenBloodDesert, BiomeList.biomeEdenGarden };
	}
	
	@Override
	protected BlockMetaPair getGrassBlock() {
		return new BlockMetaPair(BlockList.edenSurfaceRock, (byte) 5);
	}
	
	@Override
	protected BlockMetaPair getDirtBlock() {
		return new BlockMetaPair(BlockList.edenSoil, (byte) 6);
	}
	
	@Override
	protected BlockMetaPair getStoneBlock() {
		return new BlockMetaPair(BlockList.edenRock, (byte) 9);
	}
	
	@Override
	protected int getSeaLevel() {
		return 83;
	}
	
	@Override
	protected List<MapGenBaseMeta> getWorldGenerators() {
		List<MapGenBaseMeta> generators = Lists.newArrayList();
		generators.add(this.caveGenerator);
		generators.add(this.cavernGenerator);
		return generators;
	}
	
	@Override
	protected SpawnListEntry[] getMonsters() {
		List<SpawnListEntry> monsters = new ArrayList<SpawnListEntry>();
		// monsters.add(new SpawnListEntry(EntityEvolvedZombie.class, 2, 1, 2));
		// monsters.add(new SpawnListEntry(EntityEvolvedSpider.class, 2, 1, 2));
		// monsters.add(new SpawnListEntry(EntityEvolvedSkeleton.class, 2, 1,
		// 2));
		// monsters.add(new SpawnListEntry(EntityEvolvedCreeper.class, 2, 1,
		// 2));
		return monsters.toArray(new SpawnListEntry[monsters.size()]);
	}
	
	@Override
	protected SpawnListEntry[] getCreatures() {
		List<SpawnListEntry> creatures = new ArrayList<SpawnListEntry>();
		// creatures.add(new SpawnListEntry(EntityMoolus.class, 1, 2, 2));
		return creatures.toArray(new SpawnListEntry[creatures.size()]);
	}
	
	@Override
	public double getHeightModifier() {
		return 4;
	}
	
	@Override
	public double getSmallFeatureHeightModifier() {
		return 4;
	}
	
	@Override
	public double getMountainHeightModifier() {
		return 4;
	}
	
	@Override
	public double getValleyHeightModifier() {
		return 5;
	}
	
	@Override
	public List getPossibleCreatures(EnumCreatureType type, int x, int y, int z) {
		BiomeGenBase currentBiome = worldObj.getBiomeGenForCoords(x, z);
		if (type == EnumCreatureType.monster) {
			List monsters = new ArrayList();
			// monsters.add(new SpawnListEntry(EntityEvolvedZombie.class, 4, 2,
			// 2));
			// monsters.add(new SpawnListEntry(EntityEvolvedSpider.class, 4, 2,
			// 2));
			// monsters.add(new SpawnListEntry(EntityEvolvedSkeleton.class, 4,
			// 2,
			// 3));
			// monsters.add(new SpawnListEntry(EntityEvolvedCreeper.class, 4, 2,
			// 2));
			return monsters;
		} else if (type == EnumCreatureType.creature) {
			List creatures = new ArrayList();
			// creatures.add(new SpawnListEntry(EntityMoolus.class, 2, 2, 2));
			return creatures;
		} else {
			return null;
		}
	}
	
	@Override
	public void populate(IChunkProvider par1IChunkProvider, int par2, int par3) {
		BlockFalling.fallInstantly = true;
		final int var4 = par2 * 16;
		final int var5 = par3 * 16;
		BiomeGenBase currentBiome = this.worldObj.getBiomeGenForCoords(
				var4 + 16, var5 + 16);
		this.rand.setSeed(this.worldObj.getSeed());
		final long var7 = this.rand.nextLong() / 2L * 2L + 1L;
		final long var9 = this.rand.nextLong() / 2L * 2L + 1L;
		this.rand.setSeed(par2 * var7 + par3 * var9 ^ this.worldObj.getSeed());
		boolean flag = false;
		int k = var4;
		int l = var5;
		MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Pre(
				par1IChunkProvider, worldObj, rand, par2, par3, flag));
		
		this.mineshaftGenerator.generateStructuresInChunk(this.worldObj,
				this.rand, par2, par3);
		this.dungeonGenerator.generate(worldObj, rand, var5, k, l);
		this.scatteredFeatureGenerator.generateStructuresInChunk(this.worldObj,
				this.rand, par2, par3);
		int k1;
		int l1;
		int i2;
		
		if (TerrainGen.populate(par1IChunkProvider, worldObj, rand, par2, par3,
				flag, ANIMALS)) {
			SpawnerAnimals.performWorldGenSpawning(this.worldObj, currentBiome,
					k + 8, l + 8, 16, 16, this.rand);
		}
		
		if (this.rand.nextInt(4) == 0
				&& TerrainGen.populate(par1IChunkProvider, worldObj, rand,
						par2, par3, flag, LAKE)) {
			k1 = var4 + this.rand.nextInt(16) + 8;
			l1 = this.rand.nextInt(256);
			i2 = var5 + this.rand.nextInt(16) + 8;
			new WorldGenLakes(Blocks.water).generate(this.worldObj, this.rand,
					k1, l1, i2);
		}
		
		boolean doGen;
		
		BiomeGenBase biomegenbase = currentBiome;
		biomegenbase.decorate(this.worldObj, this.rand, k, l);
		k += 8;
		l += 8;
		
		doGen = TerrainGen.populate(par1IChunkProvider, worldObj, rand, par2,
				par3, flag, ICE);
		for (k1 = 0; doGen && k1 < 16; ++k1) {
			for (l1 = 0; l1 < 16; ++l1) {
				i2 = this.worldObj.getPrecipitationHeight(k + k1, l + l1);
				
				if (this.worldObj.isBlockFreezable(k1 + k, i2 - 1, l1 + l)) {
					this.worldObj.setBlock(k1 + k, i2 - 1, l1 + l, Blocks.ice,
							0, 2);
				}
			}
		}
		MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Post(
				par1IChunkProvider, worldObj, rand, par2, par3, flag));
		this.decoratePlanet(this.worldObj, this.rand, var4, var5);
		BlockFalling.fallInstantly = false;
	}
	
	@Override
	public boolean saveChunks(boolean flag, IProgressUpdate progress) {
		return true;
	}
	
	@Override
	public boolean canSave() {
		return true;
	}
	
	@Override
	public int getCraterProbability() {
		return 2200;
	}
	
	@Override
	public void decoratePlanet(World par1World, Random par2Random, int par3,
			int par4) {
		this.edenBiomeDecorator.decorate(par1World, par2Random, par3, par4);
	}
	
	@Override
	public int getLoadedChunkCount() {
		return 0;
	}
	
	@Override
	public void recreateStructures(int x, int z) {
		this.mineshaftGenerator.func_151539_a(this, this.worldObj, x, z,
				(Block[]) null);
		this.scatteredFeatureGenerator.func_151539_a(this, this.worldObj, x, z,
				(Block[]) null);
	}
	
	@Override
	public void onChunkProvide(int cX, int cZ, Block[] blocks, byte[] metadata) {
	}
	
	@Override
	public void onPopulate(IChunkProvider provider, int cX, int cZ) {
		
	}
	
	@Override
	public Chunk provideChunk(int x, int z) {
		this.rand.setSeed(x * 341873128712L + z * 132897987541L);
		Block[] blockStorage = new Block[256 * 256];
		byte[] metaStorage = new byte[256 * 256];
		this.generateTerrain(x, z, blockStorage);
		this.biomesForGeneration = this.worldObj.getWorldChunkManager()
				.loadBlockGeneratorData(this.biomesForGeneration, x * 16,
						z * 16, 16, 16);
		this.replaceBlocksForBiome(x, z, blockStorage, metaStorage,
				this.biomesForGeneration);
		this.caveGenerator.generate(this, this.worldObj, x, z, blockStorage,
				metaStorage);
		this.cavernGenerator.generate(this, this.worldObj, x, z, blockStorage,
				metaStorage);
		Chunk chunk = new Chunk(this.worldObj, blockStorage, metaStorage, x, z);
		byte[] chunkBiomes = chunk.getBiomeArray();
		
		for (int i = 0; i < chunkBiomes.length; i++) {
			chunkBiomes[i] = (byte) this.biomesForGeneration[i].biomeID;
		}
		chunk.generateSkylightMap();
		return chunk;
	}
	
	@Override
	public void replaceBlocksForBiome(int chunkX, int chunkZ,
			Block[] blockStorage, byte[] metaStorage, BiomeGenBase[] biomes) {
		double d0 = 0.03125D;
		this.stoneNoise = this.field_147430_m.func_151599_a(this.stoneNoise,
				chunkX * 16, chunkZ * 16, 16, 16, d0 * 2.0D, d0 * 2.0D, 1.0D);
		
		for (int z = 0; z < 16; z++) {
			for (int x = 0; x < 16; x++) {
				BiomeGenBase biomegenbase = biomes[x + z * 16];
				biomegenbase.genTerrainBlocks(this.worldObj, this.rand,
						blockStorage, metaStorage, chunkX * 16 + z, chunkZ * 16
								+ x, this.stoneNoise[x + z * 16]);
			}
		}
	}
	
	@Override
	public String makeString() {
		return "EdenLevelSource";
	}
	
	@Override
	public Chunk loadChunk(int x, int z) {
		return this.provideChunk(x, z);
	}
	
	public void generateTerrain(int chunkX, int chunkZ, Block[] blockStorage) {
		byte seaLevel = 63;
		this.biomesForGeneration = this.worldObj.getWorldChunkManager()
				.loadBlockGeneratorData(this.biomesForGeneration,
						chunkX * 4 - 2, chunkZ * 4 - 2, 10, 10);
		this.makeLandPerBiome2(chunkX * 4, 0, chunkZ * 4);
		
		for (int k = 0; k < 4; k++) {
			int l = k * 5;
			int i1 = (k + 1) * 5;
			
			for (int j1 = 0; j1 < 4; j1++) {
				int k1 = (l + j1) * 33;
				int l1 = (l + j1 + 1) * 33;
				int i2 = (i1 + j1) * 33;
				int j2 = (i1 + j1 + 1) * 33;
				
				for (int k2 = 0; k2 < 32; k2++) {
					double d0 = 0.125D;
					double d1 = this.terrainCalcs[k1 + k2];
					double d2 = this.terrainCalcs[l1 + k2];
					double d3 = this.terrainCalcs[i2 + k2];
					double d4 = this.terrainCalcs[j2 + k2];
					double d5 = (this.terrainCalcs[k1 + k2 + 1] - d1) * d0;
					double d6 = (this.terrainCalcs[l1 + k2 + 1] - d2) * d0;
					double d7 = (this.terrainCalcs[i2 + k2 + 1] - d3) * d0;
					double d8 = (this.terrainCalcs[j2 + k2 + 1] - d4) * d0;
					
					for (int l2 = 0; l2 < 8; l2++) {
						double d9 = 0.25D;
						double d10 = d1;
						double d11 = d2;
						double d12 = (d3 - d1) * d9;
						double d13 = (d4 - d2) * d9;
						
						for (int i3 = 0; i3 < 4; ++i3) {
							int j3 = i3 + k * 4 << 12 | 0 + j1 * 4 << 8 | k2
									* 8 + l2;
							short short1 = 256;
							j3 -= short1;
							double d14 = 0.25D;
							double d16 = (d11 - d10) * d14;
							double d15 = d10 - d16;
							
							for (int k3 = 0; k3 < 4; ++k3) {
								if ((d15 += d16) > 0.0D) {
									blockStorage[j3 += short1] = Blocks.stone;
								} else if (k2 * 8 + l2 < seaLevel) {
									blockStorage[j3 += short1] = Blocks.water;
								} else {
									blockStorage[j3 += short1] = null;
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
	
	private void makeLandPerBiome2(int x, int zero, int z) {
		this.field_147426_g = this.noiseGen6.generateNoiseOctaves(
				this.field_147426_g, x, z, 5, 5, 200.0D, 200.0D, 0.5D);
		this.field_147427_d = this.field_147429_l.generateNoiseOctaves(
				this.field_147427_d, x, zero, z, 5, 33, 5, 8.555150000000001D,
				4.277575000000001D, 8.555150000000001D);
		this.field_147428_e = this.field_147431_j.generateNoiseOctaves(
				this.field_147428_e, x, zero, z, 5, 33, 5, 684.41200000000003D,
				684.41200000000003D, 684.41200000000003D);
		this.field_147425_f = this.field_147432_k.generateNoiseOctaves(
				this.field_147425_f, x, zero, z, 5, 33, 5, 684.41200000000003D,
				684.41200000000003D, 684.41200000000003D);
		int terrainIndex = 0;
		int noiseIndex = 0;
		
		for (int ax = 0; ax < 5; ax++) {
			for (int az = 0; az < 5; az++) {
				float totalVariation = 0.0F;
				float totalHeight = 0.0F;
				float totalFactor = 0.0F;
				byte two = 2;
				BiomeGenBase biomegenbase = this.biomesForGeneration[ax + 2
						+ (az + 2) * 10];
				
				for (int ox = -two; ox <= two; ox++) {
					for (int oz = -two; oz <= two; oz++) {
						BiomeGenBase biomegenbase1 = this.biomesForGeneration[ax
								+ ox + 2 + (az + oz + 2) * 10];
						float rootHeight = biomegenbase1.rootHeight;
						float heightVariation = biomegenbase1.heightVariation;
						float heightFactor = this.parabolicField[ox + 2
								+ (oz + 2) * 5]
								/ (rootHeight + 2.0F);
						
						if (biomegenbase1.rootHeight > biomegenbase.rootHeight) {
							heightFactor /= 2.0F;
						}
						totalVariation += heightVariation * heightFactor;
						totalHeight += rootHeight * heightFactor;
						totalFactor += heightFactor;
					}
				}
				totalVariation /= totalFactor;
				totalHeight /= totalFactor;
				totalVariation = totalVariation * 0.9F + 0.1F;
				totalHeight = (totalHeight * 4.0F - 1.0F) / 8.0F;
				double terrainNoise = this.field_147426_g[noiseIndex] / 8000.0D;
				
				if (terrainNoise < 0.0D) {
					terrainNoise = -terrainNoise * 0.3D;
				}
				
				terrainNoise = terrainNoise * 3.0D - 2.0D;
				
				if (terrainNoise < 0.0D) {
					terrainNoise /= 2.0D;
					
					if (terrainNoise < -1.0D) {
						terrainNoise = -1.0D;
					}
					terrainNoise /= 1.4D;
					terrainNoise /= 2.0D;
				} else {
					if (terrainNoise > 1.0D) {
						terrainNoise = 1.0D;
					}
					terrainNoise /= 8.0D;
				}
				noiseIndex++;
				double heightCalc = totalHeight;
				double variationCalc = totalVariation;
				heightCalc += terrainNoise * 0.2D;
				heightCalc = heightCalc * 8.5D / 8.0D;
				double d5 = 8.5D + heightCalc * 4.0D;
				
				for (int ay = 0; ay < 33; ay++) {
					double d6 = (ay - d5) * 12.0D * 128.0D / 256.0D
							/ variationCalc;
					
					if (d6 < 0.0D) {
						d6 *= 4.0D;
					}
					double d7 = this.field_147428_e[terrainIndex] / 512.0D;
					double d8 = this.field_147425_f[terrainIndex] / 512.0D;
					double d9 = (this.field_147427_d[terrainIndex] / 10.0D + 1.0D) / 2.0D;
					double terrainCalc = MathHelper
							.denormalizeClamp(d7, d8, d9) - d6;
					
					if (ay > 29) {
						double d11 = (ay - 29) / 3.0F;
						terrainCalc = terrainCalc * (1.0D - d11) + -10.0D * d11;
					}
					this.terrainCalcs[terrainIndex] = terrainCalc;
					terrainIndex++;
				}
			}
		}
	}
}