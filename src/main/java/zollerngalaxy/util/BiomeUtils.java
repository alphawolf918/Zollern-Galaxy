/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.util;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.TempCategory;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeUtils {
	
	public static boolean isColdBiome(Biome biome) {
		if (BiomeUtils.isSpaceBiome(biome)) {
			BiomeSpace spaceBiome = (BiomeSpace) biome;
			if (spaceBiome.getTempCategory() == TempCategory.COLD || spaceBiome.getIsColdBiome() || spaceBiome.getBiomeType() == EnumBiomeTypeZG.ICY) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isHotBiome(Biome biome) {
		if (BiomeUtils.isSpaceBiome(biome)) {
			BiomeSpace spaceBiome = (BiomeSpace) biome;
			if (spaceBiome.getTempCategory() == TempCategory.WARM || spaceBiome.getIsHotBiome() || spaceBiome.getBiomeType() == EnumBiomeTypeZG.NETHER) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isOceanBiome(Biome biome) {
		if (BiomeUtils.isSpaceBiome(biome)) {
			BiomeSpace spaceBiome = (BiomeSpace) biome;
			if (spaceBiome.getBiomeType() == EnumBiomeTypeZG.OCEAN || spaceBiome.getTempCategory() == TempCategory.OCEAN) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isSpaceBiome(Biome biome) {
		return (biome instanceof BiomeSpace);
	}
}