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

package galaxymod.dimensions.providers.purgot;

import galaxymod.biomes.BiomeList;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerPurgotBiomes extends GenLayer {
	
	protected BiomeGenBase[] commonBiomes = { BiomeList.biomePurgatory };
	protected BiomeGenBase[] rareBiomes = { BiomeList.biomePurgotLimbo };
	
	public GenLayerPurgotBiomes(long seed, GenLayer genlayer) {
		super(seed);
		this.parent = genlayer;
	}
	
	public GenLayerPurgotBiomes(long seed) {
		super(seed);
	}
	
	@Override
	public int[] getInts(int x, int z, int width, int depth) {
		int[] dest = IntCache.getIntCache(width * depth);
		
		for (int dz = 0; dz < depth; dz++) {
			for (int dx = 0; dx < width; dx++) {
				this.initChunkSeed(dx + x, dz + z);
				
				if (this.nextInt(20) == 0) {
					dest[dx + dz * width] = this.rareBiomes[this
							.nextInt(this.rareBiomes.length)].biomeID;
				} else {
					dest[dx + dz * width] = this.commonBiomes[this
							.nextInt(this.commonBiomes.length)].biomeID;
				}
			}
		}
		return dest;
	}
}