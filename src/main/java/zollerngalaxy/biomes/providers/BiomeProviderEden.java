package zollerngalaxy.biomes.providers;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeProviderSpace;
import net.minecraft.world.biome.Biome;
import zollerngalaxy.biomes.ZGBiomes;

public class BiomeProviderEden extends BiomeProviderSpace {
	
	@Override
	public Biome getBiome() {
		return ZGBiomes.EDEN_GREEN_LANDS;
	}
}