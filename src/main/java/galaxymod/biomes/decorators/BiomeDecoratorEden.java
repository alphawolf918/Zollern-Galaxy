package galaxymod.biomes.decorators;

import galaxymod.blocks.BlockList;

import java.util.Random;

import micdoodle8.mods.galacticraft.api.event.wgen.GCCoreEventPopulate;
import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;

public class BiomeDecoratorEden extends BiomeDecoratorNova {

	private World worldObj;
	private Random randomGenerator;

	private int chunkX;
	private int chunkZ;

	private WorldGenerator copperGen;
	private WorldGenerator tinGen;
	private WorldGenerator ironGen;
	private WorldGenerator meteoricIronGen;
	private WorldGenerator goldGen;
	private WorldGenerator diamondGen;
	private WorldGenerator emeraldGen;
	private WorldGenerator coalGen;

	public BiomeDecoratorEden(BiomeGenBase par1BiomeGenBase) {
		this.ironGen = new WorldGenMinableMeta(BlockList.edenIronOre, 5, 0,
				false, BlockList.edenRock, 0);
		this.meteoricIronGen = new WorldGenMinableMeta(
				BlockList.edenMeteoricIronOre, 2, 0, false, BlockList.edenRock,
				0);
		this.copperGen = new WorldGenMinableMeta(BlockList.edenCopperOre, 8, 0,
				false, BlockList.edenRock, 0);
		this.tinGen = new WorldGenMinableMeta(BlockList.edenTinOre, 10, 0,
				false, BlockList.edenRock, 0);
		this.diamondGen = new WorldGenMinableMeta(BlockList.edenDiamondOre, 4,
				0, false, BlockList.edenRock, 0);
		this.emeraldGen = new WorldGenMinableMeta(BlockList.edenEmeraldOre, 4,
				0, false, BlockList.edenRock, 0);
		this.goldGen = new WorldGenMinableMeta(BlockList.edenGoldOre, 6, 0,
				false, BlockList.edenRock, 0);
		this.coalGen = new WorldGenMinableMeta(BlockList.edenCoalOre, 15, 0,
				false, BlockList.edenRock, 0);
	}

	@Override
	public void decorate(World worldObj, Random rand, int chunkX, int chunkZ) {
		if (this.worldObj != null) {
			throw new RuntimeException("Already decorating!!");
		} else {
			this.worldObj = worldObj;
			this.randomGenerator = rand;
			this.chunkX = chunkX;
			this.chunkZ = chunkZ;
			this.generateEden();
			this.worldObj = null;
			this.randomGenerator = null;
		}
	}

	void genOre(int amountPerChunk, WorldGenerator worldGenerator, int minY,
			int maxY) {
		for (int var5 = 0; var5 < amountPerChunk; ++var5) {
			final int var6 = this.chunkX + this.randomGenerator.nextInt(16);
			final int var7 = this.randomGenerator.nextInt(maxY - minY) + minY;
			final int var8 = this.chunkZ + this.randomGenerator.nextInt(16);
			worldGenerator.generate(this.worldObj, this.randomGenerator, var6,
					var7, var8);
		}
	}

	void generateEden() {
		MinecraftForge.EVENT_BUS.post(new GCCoreEventPopulate.Pre(
				this.worldObj, this.randomGenerator, this.chunkX, this.chunkZ));
		this.genOre(27, this.ironGen, 4, 50);
		this.genOre(22, this.meteoricIronGen, 10, 20);
		this.genOre(25, this.goldGen, 4, 50);
		this.genOre(24, this.diamondGen, 12, 16);
		this.genOre(24, this.emeraldGen, 12, 14);
		this.genOre(28, this.copperGen, 4, 60);
		this.genOre(28, this.tinGen, 4, 40);
		this.genOre(30, this.coalGen, 2, 60);
		MinecraftForge.EVENT_BUS.post(new GCCoreEventPopulate.Post(
				this.worldObj, this.randomGenerator, this.chunkX, this.chunkZ));
	}

	@Override
	protected void setCurrentWorld(World world) {
		this.worldObj = world;
	}

	@Override
	protected World getCurrentWorld() {
		return this.worldObj;
	}
}
