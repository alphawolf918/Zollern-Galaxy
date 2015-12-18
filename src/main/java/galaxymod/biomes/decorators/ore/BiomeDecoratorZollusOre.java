/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.biomes.decorators.ore;

import galaxymod.biomes.decorators.BiomeDecoratorNova;
import galaxymod.blocks.BlockList;
import java.util.Random;
import micdoodle8.mods.galacticraft.api.event.wgen.GCCoreEventPopulate;
import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;

public class BiomeDecoratorZollusOre extends BiomeDecoratorNova {
	
	private World worldObj;
	private Random randomGenerator;
	
	private int chunkX;
	private int chunkZ;
	
	private WorldGenerator coalGen;
	private WorldGenerator copperGen;
	private WorldGenerator tinGen;
	private WorldGenerator ironGen;
	private WorldGenerator goldGen;
	
	public BiomeDecoratorZollusOre() {
		this.coalGen = new WorldGenMinableMeta(BlockList.zolCoalOre, 10, 0,
				false, BlockList.zolstone, 0);
		this.copperGen = new WorldGenMinableMeta(BlockList.zolCopperOre, 8, 0,
				false, BlockList.zolstone, 0);
		this.ironGen = new WorldGenMinableMeta(BlockList.zolIronOre, 5, 0,
				false, BlockList.zolstone, 0);
		this.goldGen = new WorldGenMinableMeta(BlockList.zolGoldOre, 5, 0,
				false, BlockList.zolstone, 0);
		this.tinGen = new WorldGenMinableMeta(BlockList.zolTinOre, 10, 0,
				false, BlockList.zolstone, 0);
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
		this.genOre(30, this.coalGen, 4, 70);
		this.genOre(28, this.copperGen, 4, 70);
		this.genOre(27, this.ironGen, 4, 60);
		this.genOre(25, this.goldGen, 4, 50);
		this.genOre(28, this.tinGen, 4, 60);
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
