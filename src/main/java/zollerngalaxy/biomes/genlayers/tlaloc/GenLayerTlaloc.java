/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.genlayers.tlaloc;

import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;

public abstract class GenLayerTlaloc extends GenLayer {
	
	public GenLayerTlaloc(long l) {
		super(l);
	}
	
	public static GenLayer[] createWorld(long l) {
		GenLayer biomes = new GenLayerTlalocBiomes(l);
		biomes = new GenLayerZoom(1000L, biomes);
		biomes = new GenLayerZoom(1001L, biomes);
		biomes = new GenLayerZoom(1002L, biomes);
		biomes = new GenLayerZoom(1003L, biomes);
		biomes = new GenLayerZoom(1004L, biomes);
		biomes = new GenLayerZoom(1005L, biomes);
		GenLayer genLayerVoronoiZoom = new GenLayerVoronoiZoom(10L, biomes);
		biomes.initWorldGenSeed(l);
		genLayerVoronoiZoom.initWorldGenSeed(l);
		
		return new GenLayer[] { biomes, genLayerVoronoiZoom };
	}
}