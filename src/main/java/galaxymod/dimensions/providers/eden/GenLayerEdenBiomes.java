/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod This work is licensed under a
 * Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International
 * Public License. To view a copy of this license, visit
 * http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package galaxymod.dimensions.providers.eden;

import galaxymod.biomes.BiomeList;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerEdenBiomes extends GenLayer {
	protected BiomeGenBase[] commonBiomes = { BiomeList.biomeEden,
			BiomeList.biomeEdenRockMountains, BiomeList.biomeEdenTerranValley,
			BiomeList.biomeEdenBloodDesert, BiomeList.biomeEdenGarden,
			BiomeList.biomeEdenForest, BiomeList.biomeEdenMagmaLands,
			BiomeList.biomeEdenSnowyPlains };
	protected BiomeGenBase[] rareBiomes = { BiomeList.biomeEdenSnowyPlains };
	
	public GenLayerEdenBiomes(long seed, GenLayer genlayer) {
		super(seed);
		this.parent = genlayer;
	}
	
	public GenLayerEdenBiomes(long seed) {
		super(seed);
	}
	
	@Override
	public int[] getInts(int x, int z, int width, int depth) {
		int[] dest = IntCache.getIntCache(width * depth);
		
		for (int dz = 0; dz < depth; dz++) {
			for (int dx = 0; dx < width; dx++) {
				this.initChunkSeed(dx + x, dz + z);
				
				if (this.nextInt(15) == 0) {
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