/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.util;

import net.minecraft.world.biome.Biome;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeUtils {
	
	public static boolean isOceanBiome(Biome biome) {
		if (biome instanceof BiomeSpace) {
			BiomeSpace spaceBiome = (BiomeSpace) biome;
			if (spaceBiome.getBiomeType() == EnumBiomeTypeZG.OCEAN) {
				return false;
			}
		}
		return false;
	}
}