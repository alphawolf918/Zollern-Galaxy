package zollerngalaxy.core.dimensions.chunkproviders;

import java.util.List;
import java.util.Random;
import micdoodle8.mods.galacticraft.api.world.ChunkProviderBase;
import micdoodle8.mods.galacticraft.core.perlin.NoiseModule;
import micdoodle8.mods.galacticraft.core.perlin.generator.Gradient;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.structure.MapGenMineshaft;
import net.minecraft.world.gen.structure.MapGenVillage;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.biomes.ZGBiomes;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.worldgen.mapgen.MapGenCavesZG;
import zollerngalaxy.worldgen.mapgen.MapGenRavinesZG;

public class ChunkProviderEden extends ChunkProviderBase {
	
	public static IBlockState BLOCK_TOP = ZGBlocks.edenSurfaceRock.getDefaultState();
	public static IBlockState BLOCK_FILL = ZGBlocks.edenDirt.getDefaultState();
	public static IBlockState BLOCK_STONE = ZGBlocks.edenStone.getDefaultState();
	
	private final Random rand;
	
	private final NoiseModule noiseGen1;
	private final NoiseModule noiseGen2;
	private final NoiseModule noiseGen3;
	private final NoiseModule noiseGen4;
	
	private final World world;
	
	private Biome[] biomesForGeneration = { ZGBiomes.EDEN_GREEN_LANDS, ZGBiomes.EDEN_BLOOD_DESERT,
			ZGBiomes.EDEN_ROCK_MOUNTAINS, ZGBiomes.EDEN_TERRAN_VALLEY };
	
	private final MapGenCavesZG caveGenerator = new MapGenCavesZG(ZGBlocks.edenStone, Blocks.LAVA);
	private final MapGenRavinesZG ravineGenerator = new MapGenRavinesZG(ZGBlocks.edenStone);
	private MapGenVillage villageGenerator = new MapGenVillage();
	private MapGenMineshaft mineshaftGenerator = new MapGenMineshaft();
	
	private static int MID_HEIGHT = ZGHelper.rngNumber(63, 120);
	private static final int CHUNK_SIZE_X = 16;
	private static final int CHUNK_SIZE_Y = 128;
	private static final int CHUNK_SIZE_Z = 16;
	
	public ChunkProviderEden(World par1World, long par2, boolean par4) {
		this.world = par1World;
		this.rand = new Random(par2);
		this.noiseGen1 = new Gradient(this.rand.nextLong(), 4, 0.25F);
		this.noiseGen2 = new Gradient(this.rand.nextLong(), 4, 0.25F);
		this.noiseGen3 = new Gradient(this.rand.nextLong(), 1, 0.25F);
		this.noiseGen4 = new Gradient(this.rand.nextLong(), 1, 0.25F);
	}
	
	public void setBlocksInChunk(int chunkX, int chunkZ, ChunkPrimer primer) {
		this.noiseGen1.setFrequency(0.0125F);
		this.noiseGen2.setFrequency(0.015F);
		this.noiseGen3.setFrequency(0.01F);
		this.noiseGen4.setFrequency(0.02F);
		
		for (int x = 0; x < ChunkProviderEden.CHUNK_SIZE_X; x++) {
			for (int z = 0; z < ChunkProviderEden.CHUNK_SIZE_Z; z++) {
				final double d = this.noiseGen1.getNoise(x + chunkX * 16, z + chunkZ * 16) * 8;
				final double d2 = this.noiseGen2.getNoise(x + chunkX * 16, z + chunkZ * 16) * 24;
				double d3 = this.noiseGen3.getNoise(x + chunkX * 16, z + chunkZ * 16) - 0.1;
				d3 *= 4;
				
				double yDev;
				
				if (d3 < 0.0D) {
					yDev = d;
				} else if (d3 > 1.0D) {
					yDev = d2;
				} else {
					yDev = d + (d2 - d) * d3;
				}
				
				int posX = chunkX * 16;
				int posZ = chunkZ * 16;
				int posY = world.getHeight(posX, posZ);
				
				Biome biome = world.getBiome(new BlockPos(posX, posY, posZ));
				
				if (biome instanceof BiomeSpace) {
					BiomeSpace spaceBiome = (BiomeSpace) biome;
					ChunkProviderEden.MID_HEIGHT = spaceBiome.getBiomeHeight();
				}
				
				for (int y = 0; y < ChunkProviderEden.CHUNK_SIZE_Y - 1; y++) {
					if (y < ChunkProviderEden.MID_HEIGHT + yDev) {
						primer.setBlockState(x, y, z, BLOCK_STONE);
					}
				}
			}
		}
	}
	
	public void replaceBlocksForBiome(int par1, int par2, ChunkPrimer primer,
			Biome[] par4ArrayOfBiome) {
		final int var5 = 20;
		for (int var8 = 0; var8 < 16; ++var8) {
			for (int var9 = 0; var9 < 16; ++var9) {
				final int var12 = (int) (this.noiseGen4
						.getNoise(var8 + par1 * 16, var9 * par2 * 16) / 3.0D + 3.0D + this.rand
						.nextDouble() * 0.25D);
				int var13 = -1;
				
				int x = par1 * 16;
				int z = par2 * 16;
				int y = world.getHeight(x, z);
				
				BlockPos posInWorld = new BlockPos(x, y, z);
				
				Biome currentBiome = world.getBiome(posInWorld);
				
				BLOCK_TOP = currentBiome.topBlock;
				BLOCK_FILL = currentBiome.fillerBlock;
				
				if (currentBiome instanceof BiomeSpace) {
					BiomeSpace biomeSpace = (BiomeSpace) currentBiome;
					BLOCK_STONE = biomeSpace.getStoneBlock().getDefaultState();
				}
				
				IBlockState state0 = BLOCK_TOP;
				IBlockState state1 = BLOCK_FILL;
				
				for (int var16 = ChunkProviderEden.CHUNK_SIZE_Y - 1; var16 >= 0; --var16) {
					final int index = this.getIndex(var8, var16, var9);
					
					if (var16 == 0) {
						primer.setBlockState(var8, var16, var9, Blocks.BEDROCK.getDefaultState());
					} else {
						IBlockState var18 = primer.getBlockState(var8, var16, var9);
						if (Blocks.AIR == var18) {
							var13 = -1;
						} else if (var18 == BLOCK_STONE) {
							if (var13 == -1) {
								if (var12 <= 0) {
									state0 = Blocks.AIR.getDefaultState();
									state1 = BLOCK_STONE;
								} else if (var16 >= var5 - -16 && var16 <= var5 + 1) {
									state0 = BLOCK_FILL;
								}
								
								var13 = var12;
								
								if (var16 >= var5 - 1) {
									primer.setBlockState(var8, var16, var9, state0);
								} else if (var16 < var5 - 1 && var16 >= var5 - 2) {
									primer.setBlockState(var8, var16, var9, state1);
								}
							} else if (var13 > 0) {
								--var13;
								primer.setBlockState(var8, var16, var9, state1);
							}
						}
					}
				}
			}
		}
	}
	
	@Override
	public Chunk generateChunk(int x, int z) {
		this.rand.setSeed(x * 341873128712L + z * 132897987541L);
		ChunkPrimer chunkprimer = new ChunkPrimer();
		this.setBlocksInChunk(x, z, chunkprimer);
		this.biomesForGeneration = this.world.getBiomeProvider().getBiomes(
				this.biomesForGeneration, x * 16, z * 16, 16, 16);
		
		this.replaceBlocksForBiome(x, z, chunkprimer, this.biomesForGeneration);
		
		this.caveGenerator.generate(this.world, x, z, chunkprimer);
		this.ravineGenerator.generate(this.world, x, z, chunkprimer);
		
		Chunk chunk = new Chunk(this.world, chunkprimer, x, z);
		byte[] abyte = chunk.getBiomeArray();
		
		for (int i = 0; i < abyte.length; ++i) {
			abyte[i] = (byte) Biome.getIdForBiome(this.biomesForGeneration[i]);
		}
		
		chunk.generateSkylightMap();
		return chunk;
	}
	
	private int getIndex(int x, int y, int z) {
		return (x * 16 + z) * 256 + y;
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
		
		// this.dungeonGeneratorMoon.generateStructure(this.world, this.rand,
		// new ChunkPos(x, z));
		
		biomegenbase.decorate(this.world, this.rand, new BlockPos(i, 0, j));
		BlockFalling.fallInstantly = false;
	}
	
	@Override
	public List<Biome.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType,
			BlockPos pos) {
		Biome biomegenbase = this.world.getBiome(pos);
		return biomegenbase.getSpawnableList(creatureType);
	}
	
	@Override
	public void recreateStructures(Chunk chunk, int x, int z) {
		// this.dungeonGeneratorMoon.generate(this.world, x, z, null);
		
		this.mineshaftGenerator.generate(this.world, x, z, (ChunkPrimer) null);
		this.villageGenerator.generate(this.world, x, z, (ChunkPrimer) null);
	}
}