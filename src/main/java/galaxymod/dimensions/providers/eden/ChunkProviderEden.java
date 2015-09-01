package galaxymod.dimensions.providers.eden;

import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.DUNGEON;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.ICE;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.LAKE;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.LAVA;
import galaxymod.biomes.BiomeList;
import galaxymod.biomes.decorators.BiomeDecoratorEden;
import galaxymod.blocks.BlockList;
import galaxymod.worldgen.eden.MapGenCavesEden;
import galaxymod.worldgen.eden.WorldGenEdenDungeons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.MapGenBaseMeta;
import micdoodle8.mods.galacticraft.core.entities.EntityAlienVillager;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedCreeper;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSkeleton;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import micdoodle8.mods.galacticraft.core.perlin.NoiseModule;
import micdoodle8.mods.galacticraft.core.perlin.generator.Gradient;
import micdoodle8.mods.galacticraft.core.world.gen.EnumCraterSize;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenRavine;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.structure.MapGenMineshaft;
import net.minecraft.world.gen.structure.MapGenScatteredFeature;
import net.minecraft.world.gen.structure.MapGenVillage;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

public class ChunkProviderEden extends ChunkProviderGenerate {

	public static MapGenBaseMeta caveGen = new MapGenCavesEden();
	private MapGenVillage villageGenerator = new MapGenVillage();
	private MapGenMineshaft mineshaftGenerator = new MapGenMineshaft();
	private MapGenBase ravineGenerator = new MapGenRavine();

	public static BiomeDecoratorEden biomeDecoratorPlanet = new BiomeDecoratorEden(
			BiomeList.biomeEden);
	private BiomeGenBase[] biomesForGeneration = { BiomeList.biomeEden };
	private final Random rand;

	final Block topBlockID = Blocks.grass;
	final byte topBlockMeta = 0;
	final Block fillBlockID = Blocks.dirt;
	final byte fillBlockMeta = 0;
	final Block lowerBlockID = BlockList.edenRock;
	final byte lowerBlockMeta = 0;

	private final NoiseModule noiseGen1;
	private final NoiseModule noiseGen2;
	private final NoiseModule noiseGen3;
	private final NoiseModule noiseGen4;
	private World worldObj;

	private static final int CRATER_PROB = 300;

	private static final int MID_HEIGHT = 63;
	private static final int CHUNK_SIZE_X = 16;
	private static final int CHUNK_SIZE_Y = 128;
	private static final int CHUNK_SIZE_Z = 16;

	public ChunkProviderEden(World par1World, long seed,
			boolean mapFeaturesEnabled) {
		super(par1World, seed, mapFeaturesEnabled);
		this.worldObj = par1World;
		this.rand = new Random(seed);
		this.noiseGen1 = new Gradient(this.rand.nextLong(), 4, 0.25F);
		this.noiseGen2 = new Gradient(this.rand.nextLong(), 4, 0.25F);
		this.noiseGen3 = new Gradient(this.rand.nextLong(), 1, 0.25F);
		this.noiseGen4 = new Gradient(this.rand.nextLong(), 1, 0.25F);
	}

	public void generateTerrain(int chunkX, int chunkZ, Block[] idArray,
			byte[] metaArray) {
		this.noiseGen1.setFrequency(0.0125F);
		this.noiseGen2.setFrequency(0.015F);
		this.noiseGen3.setFrequency(0.01F);
		this.noiseGen4.setFrequency(0.02F);

		for (int x = 0; x < ChunkProviderEden.CHUNK_SIZE_X; x++) {
			for (int z = 0; z < ChunkProviderEden.CHUNK_SIZE_Z; z++) {
				final double d = this.noiseGen1.getNoise(x + chunkX * 16, z
						+ chunkZ * 16) * 8;
				final double d2 = this.noiseGen2.getNoise(x + chunkX * 16, z
						+ chunkZ * 16) * 24;
				double d3 = this.noiseGen3.getNoise(x + chunkX * 16, z + chunkZ
						* 16) - 0.1;
				d3 *= 4;

				double yDev = 0;

				if (d3 < 0.0D) {
					yDev = d;
				} else if (d3 > 1.0D) {
					yDev = d2;
				} else {
					yDev = d + (d2 - d) * d3;
				}

				for (int y = 0; y < ChunkProviderEden.CHUNK_SIZE_Y; y++) {
					if (y < ChunkProviderEden.MID_HEIGHT + yDev) {
						idArray[this.getIndex(x, y, z)] = this.lowerBlockID;
						metaArray[this.getIndex(x, y, z)] = this.lowerBlockMeta;
					}
				}
			}
		}
	}

	private int getIndex(int x, int y, int z) {
		return (x * 16 + z) * 256 + y;
	}

	@Override
	public void replaceBlocksForBiome(int par1, int par2, Block[] arrayOfIDs,
			byte[] arrayOfMeta, BiomeGenBase[] par4ArrayOfBiomeGenBase) {
		final int var5 = 20;
		for (int var8 = 0; var8 < 16; ++var8) {
			for (int var9 = 0; var9 < 16; ++var9) {
				final int var12 = (int) (this.noiseGen4.getNoise(var8 + par1
						* 16, var9 * par2 * 16) / 3.0D + 3.0D + this.rand
						.nextDouble() * 0.25D);
				int var13 = -1;
				Block var14 = this.topBlockID;
				byte var14m = this.topBlockMeta;
				Block var15 = this.fillBlockID;
				byte var15m = this.fillBlockMeta;

				for (int var16 = 127; var16 >= 0; --var16) {
					final int index = this.getIndex(var8, var16, var9);
					arrayOfMeta[index] = 0;

					if (var16 <= 0 + this.rand.nextInt(5)) {
						arrayOfIDs[index] = Blocks.bedrock;
					} else {
						final Block var18 = arrayOfIDs[index];
						if (Blocks.air == var18) {
							var13 = -1;
						} else if (var18 == this.lowerBlockID) {
							arrayOfMeta[index] = this.lowerBlockMeta;

							if (var13 == -1) {
								if (var12 <= 0) {
									var14 = Blocks.air;
									var14m = 0;
									var15 = this.lowerBlockID;
									var15m = this.lowerBlockMeta;
								} else if (var16 >= var5 - -16
										&& var16 <= var5 + 1) {
									var14 = this.topBlockID;
									var14m = this.topBlockMeta;
									var14 = this.fillBlockID;
									var14m = this.fillBlockMeta;
								}

								var13 = var12;

								if (var16 >= var5 - 1) {
									arrayOfIDs[index] = var14;
									arrayOfMeta[index] = var14m;
								} else if (var16 < var5 - 1
										&& var16 >= var5 - 2) {
									arrayOfIDs[index] = var15;
									arrayOfMeta[index] = var15m;
								}
							} else if (var13 > 0) {
								--var13;
								arrayOfIDs[index] = var15;
								arrayOfMeta[index] = var15m;
							}
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
	public void populate(IChunkProvider par1IChunkProvider, int par2, int par3) {
		BlockFalling.fallInstantly = true;
		final int var4 = par2 * 16;
		final int var5 = par3 * 16;
		this.worldObj.getBiomeGenForCoords(var4 + 16, var5 + 16);
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
		flag = this.villageGenerator.generateStructuresInChunk(this.worldObj,
				this.rand, par2, par3);
		int k1;
		int l1;
		int i2;

		if (this.rand.nextInt(4) == 0
				&& TerrainGen.populate(par1IChunkProvider, worldObj, rand,
						par2, par3, flag, LAKE)) {
			k1 = var4 + this.rand.nextInt(16) + 8;
			l1 = this.rand.nextInt(256);
			i2 = var5 + this.rand.nextInt(16) + 8;
			new WorldGenLakes(Blocks.water).generate(this.worldObj, this.rand,
					k1, l1, i2);
		}

		if (TerrainGen.populate(par1IChunkProvider, worldObj, rand, par2, par3,
				flag, LAVA) && !flag && this.rand.nextInt(8) == 0) {
			k1 = k + this.rand.nextInt(16) + 8;
			l1 = this.rand.nextInt(this.rand.nextInt(248) + 8);
			i2 = l + this.rand.nextInt(16) + 8;
		}

		boolean doGen = TerrainGen.populate(par1IChunkProvider, worldObj, rand,
				par2, par3, flag, DUNGEON);
		for (k1 = 0; doGen && k1 < 8; ++k1) {
			l1 = k + this.rand.nextInt(16) + 8;
			i2 = this.rand.nextInt(256);
			int j2 = l + this.rand.nextInt(16) + 8;
			new WorldGenEdenDungeons().generate(this.worldObj, this.rand, l1,
					i2, j2);
		}

		BiomeGenBase biomegenbase = BiomeList.biomeEden;
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

	public void decoratePlanet(World par1World, Random par2Random, int par3,
			int par4) {
		this.biomeDecoratorPlanet.decorate(par1World, par2Random, par3, par4);
	}

	public void createCraters(int chunkX, int chunkZ, Block[] chunkArray,
			byte[] metaArray) {
		for (int cx = chunkX - 2; cx <= chunkX + 2; cx++) {
			for (int cz = chunkZ - 2; cz <= chunkZ + 2; cz++) {
				for (int x = 0; x < ChunkProviderEden.CHUNK_SIZE_X; x++) {
					for (int z = 0; z < ChunkProviderEden.CHUNK_SIZE_Z; z++) {
						if (Math.abs(this.randFromPoint(cx * 16 + x,
								(cz * 16 + z) * 1000)) < this.noiseGen4
								.getNoise(x * ChunkProviderEden.CHUNK_SIZE_X
										+ x, cz
										* ChunkProviderEden.CHUNK_SIZE_Z + z)
								/ ChunkProviderEden.CRATER_PROB) {
							final Random random = new Random(cx * 16 + x
									+ (cz * 16 + z) * 5000);
							final EnumCraterSize cSize = EnumCraterSize.sizeArray[random
									.nextInt(EnumCraterSize.sizeArray.length)];
							final int size = random.nextInt(cSize.MAX_SIZE
									- cSize.MIN_SIZE)
									+ cSize.MIN_SIZE;
							this.makeCrater(cx * 16 + x, cz * 16 + z,
									chunkX * 16, chunkZ * 16, size, chunkArray,
									metaArray);
						}
					}
				}
			}
		}
	}

	@Override
	public Chunk provideChunk(int par1, int par2) {
		this.rand.setSeed(par1 * 341873128712L + par2 * 132897987541L);
		final Block[] ids = new Block[16 * 16 * 256];
		final byte[] meta = new byte[16 * 16 * 256];
		Arrays.fill(ids, Blocks.air);
		this.generateTerrain(par1, par2, ids, meta);
		this.biomesForGeneration = this.worldObj.getWorldChunkManager()
				.loadBlockGeneratorData(this.biomesForGeneration, par1 * 16,
						par2 * 16, 16, 16);
		this.createCraters(par1, par2, ids, meta);
		this.replaceBlocksForBiome(par1, par2, ids, meta,
				this.biomesForGeneration);
		this.caveGen.generate(this, this.worldObj, par1, par2, ids, meta);
		final Chunk var4 = new Chunk(this.worldObj, ids, meta, par1, par2);
		var4.generateSkylightMap();
		return var4;
	}

	public void makeCrater(int craterX, int craterZ, int chunkX, int chunkZ,
			int size, Block[] chunkArray, byte[] metaArray) {
		for (int x = 0; x < ChunkProviderEden.CHUNK_SIZE_X; x++) {
			for (int z = 0; z < ChunkProviderEden.CHUNK_SIZE_Z; z++) {
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
						if (Blocks.air != chunkArray[this.getIndex(x, y, z)]
								&& helper <= yDev) {
							chunkArray[this.getIndex(x, y, z)] = Blocks.air;
							metaArray[this.getIndex(x, y, z)] = 0;
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

	@Override
	public boolean chunkExists(int par1, int par2) {
		return true;
	}

	@Override
	public boolean unloadQueuedChunks() {
		return false;
	}

	@Override
	public int getLoadedChunkCount() {
		return 0;
	}

	@Override
	public boolean saveChunks(boolean par1, IProgressUpdate par2IProgressUpdate) {
		return true;
	}

	@Override
	public boolean canSave() {
		return true;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List getPossibleCreatures(EnumCreatureType par1EnumCreatureType,
			int i, int j, int k) {
		if (par1EnumCreatureType == EnumCreatureType.monster) {
			final List monsters = new ArrayList();
			monsters.add(new SpawnListEntry(EntityEvolvedZombie.class, 2, 2, 3));
			monsters.add(new SpawnListEntry(EntityEvolvedSpider.class, 2, 2, 3));
			monsters.add(new SpawnListEntry(EntityEvolvedSkeleton.class, 2, 2,
					3));
			monsters.add(new SpawnListEntry(EntityEvolvedCreeper.class, 2, 2, 3));
			return monsters;
		} else if (par1EnumCreatureType == EnumCreatureType.creature) {
			final List creatures = new ArrayList();
			creatures
					.add(new SpawnListEntry(EntityAlienVillager.class, 1, 0, 1));
			return creatures;
		} else {
			return null;
		}
	}

	@Override
	public String makeString() {
		return "EdenLevelSource";
	}

	@Override
	public void recreateStructures(int par1, int par2) {
		Block[] abyte = { BlockList.edenRock };
		this.villageGenerator.func_151539_a(this, this.worldObj, par1, par2,
				(Block[]) null);
		this.mineshaftGenerator.func_151539_a(this, this.worldObj, par1, par2,
				abyte);
	}
}