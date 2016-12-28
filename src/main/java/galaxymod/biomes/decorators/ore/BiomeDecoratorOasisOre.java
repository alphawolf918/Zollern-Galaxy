/*******************************************************************************
 * Copyright 2015 Zollern Wolf
 * - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 *******************************************************************************/

package galaxymod.biomes.decorators.ore;

import galaxymod.biomes.oasis.BiomeGenOasisBase;
import java.util.Random;
import micdoodle8.mods.galacticraft.api.event.wgen.GCCoreEventPopulate;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;

public class BiomeDecoratorOasisOre extends BiomeDecoratorOre {
	
	private World worldObj;
	private Random randomGenerator;
	
	private int chunkX;
	private int chunkZ;
	
	// private WorldGenerator prometheanGen;
	
	public BiomeDecoratorOasisOre() {
		// this.prometheanGen = new WorldGenMinableMeta(
		// BlockList.xathPrometheanOre, 8, 0, false, BlockList.xathStone,
		// 0);
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
			this.generateOasis();
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
	
	void generateOasis() {
		MinecraftForge.EVENT_BUS.post(new GCCoreEventPopulate.Pre(
				this.worldObj, this.randomGenerator, this.chunkX, this.chunkZ));
		BiomeGenBase currentBiome = worldObj.getBiomeGenForCoords(chunkX,
				chunkZ);
		if (currentBiome instanceof BiomeGenOasisBase) {
			// this.genOre(7, this.prometheanGen, 4, 40);
		}
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