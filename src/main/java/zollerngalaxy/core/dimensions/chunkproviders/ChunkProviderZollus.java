package zollerngalaxy.core.dimensions.chunkproviders;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldEntitySpawner;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import zollerngalaxy.biomes.ZGBiomes;
import zollerngalaxy.biomes.decorators.BiomeDecoratorZollus;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.worldgen.caves.MapGenCavesZG;

public class ChunkProviderZollus extends ChunkProviderZG {
	
	private BiomeDecoratorZollus biomeDecorator = new BiomeDecoratorZollus();
	private Biome[] biomesForGeneration = { ZGBiomes.ZOLLUS };
	private MapGenCavesZG caveGenerator = new MapGenCavesZG(ZGBlocks.zolstone,
			Blocks.FROSTED_ICE, this.getBlockMetadata());
	
	// private MapGenDionaMineshaft mineshaftGenerator = new
	// MapGenDionaMineshaft();
	
	public ChunkProviderZollus(World world, long seed) {
		super(world, seed);
	}
	
	@Override
	public Chunk generateChunk(int chunkX, int chunkZ) {
		ChunkPrimer primer = new ChunkPrimer();
		this.rand.setSeed(chunkX * 341873128712L + chunkZ * 132897987541L);
		this.generateTerrain(chunkX, chunkZ, primer);
		this.biomesForGeneration = this.worldObj.getBiomeProvider().getBiomes(
				this.biomesForGeneration, chunkX * 16, chunkZ * 16, 16, 16);
		this.createCraters(chunkX, chunkZ, primer);
		this.replaceBiomeBlocks(chunkX, chunkZ, primer,
				this.biomesForGeneration);
		this.caveGenerator.generate(this.worldObj, chunkX, chunkZ, primer);
		// this.mineshaftGenerator.generate(this.worldObj, chunkX, chunkZ,
		// primer);
		// this.dungeonGenerator.generate(this.worldObj, chunkX, chunkZ,
		// primer);
		Chunk chunk = new Chunk(this.worldObj, primer, chunkX, chunkZ);
		chunk.generateSkylightMap();
		return chunk;
	}
	
	@Override
	public void populate(int chunkX, int chunkZ) {
		BlockFalling.fallInstantly = true;
		int x = chunkX * 16;
		int z = chunkZ * 16;
		BlockPos pos = new BlockPos(x, 0, z);
		Biome biomegenbase = this.worldObj.getBiome(pos.add(16, 0, 16));
		ChunkPos chunkcoordintpair = new ChunkPos(chunkX, chunkZ);
		this.rand.setSeed(this.worldObj.getSeed());
		long k = this.rand.nextLong() / 2L * 2L + 1L;
		long l = this.rand.nextLong() / 2L * 2L + 1L;
		this.rand.setSeed(chunkX * k + chunkZ * l ^ this.worldObj.getSeed());
		WorldEntitySpawner.performWorldGenSpawning(this.worldObj, biomegenbase,
				x + 8, z + 8, 16, 16, this.rand);
		// this.dungeonGenerator.generateStructure(this.worldObj, this.rand,
		// chunkcoordintpair);
		this.biomeDecorator.decorate(this.worldObj, this.rand, biomegenbase,
				pos);
		// this.mineshaftGenerator.generateStructure(this.worldObj, this.rand,
		// chunkcoordintpair);
		int y = this.rand.nextInt(this.rand.nextInt(248) + 8);
		
		BlockFalling.fallInstantly = false;
	}
	
	@Override
	public List<SpawnListEntry> getPossibleCreatures(EnumCreatureType type,
			BlockPos pos) {
		return this.worldObj.getBiome(pos).getSpawnableList(type);
	}
	
	@Override
	protected Block getBaseBlock() {
		return ZGBlocks.zolSurfaceRock;
	}
	
	@Override
	public void recreateStructures(Chunk chunk, int chunkX, int chunkZ) {
		// this.mineshaftGenerator.generate(this.worldObj, chunkX, chunkZ,
		// (ChunkPrimer) null);
		// this.dungeonGenerator.generate(this.worldObj, chunkX, chunkZ, null);
	}
	
	@Override
	protected int[] getBlockMetadata() {
		return new int[] { 0, 0, 0, 0 };
	}
}