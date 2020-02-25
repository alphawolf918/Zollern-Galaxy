/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.providers;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeProviderSpace;
import net.minecraft.world.biome.Biome;
import zollerngalaxy.biomes.ZGBiomes;

public class BiomeProviderXantheon extends BiomeProviderSpace {
	
	@Override
	public Biome getBiome() {
		return ZGBiomes.XANTHEON;
	}
}