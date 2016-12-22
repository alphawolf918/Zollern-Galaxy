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

import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerRiver;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;

public abstract class GenLayerEden extends GenLayer {
	public GenLayerEden(long seed) {
		super(seed);
	}
	
	public static GenLayer[] makeTheWorld(long seed) {
		GenLayer biomes = new GenLayerEdenBiomes(1L);
		biomes = new GenLayerZoom(1000L, biomes);
		biomes = new GenLayerZoom(1001L, biomes);
		biomes = new GenLayerZoom(1002L, biomes);
		biomes = new GenLayerZoom(1003L, biomes);
		biomes = new GenLayerZoom(1004L, biomes);
		biomes = new GenLayerZoom(1005L, biomes);
		// biomes = new GenLayerZoom(1006L, biomes);
		// biomes = new GenLayerZoom(1007L, biomes);
		// biomes = new GenLayerZoom(1008L, biomes);
		// biomes = new GenLayerZoom(1009L, biomes);
		// biomes = new GenLayerZoom(1010L, biomes);
		GenLayer genlayervoronoizoom = new GenLayerVoronoiZoom(10L, biomes);
		GenLayerRiver genlayerriver = new GenLayerRiver(1000L, biomes);
		biomes.initWorldGenSeed(seed);
		genlayervoronoizoom.initWorldGenSeed(seed);
		return new GenLayer[] { biomes, genlayervoronoizoom, genlayerriver };
	}
	
	@Override
	public int[] getInts(int x, int z, int width, int depth) {
		return null;
	}
}