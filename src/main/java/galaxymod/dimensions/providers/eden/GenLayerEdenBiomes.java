/*******************************************************************************
 * Copyright 2016 Zollern Wolf
 * - Zollern Galaxy
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 * Steve Kung's "More Planets" mod was a big help.
 *******************************************************************************/

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
			BiomeList.biomeEdenGoldenMeadow };
	protected BiomeGenBase[] rareBiomes = { BiomeList.biomeEdenSnowyPlains,
			BiomeList.biomeEdenSwamp };
	
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