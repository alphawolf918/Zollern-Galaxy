package galaxymod.biomes;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class BiomeList {

	public static int biomeColor = 1204859;

	public static BiomeGenBase biomeZollus = new BiomeZollus(179);
	public static BiomeGenBase biomeEden = new BiomeEden(178);

	public static void init() {
		addBiome(biomeZollus, BiomeType.COOL, 0);
		addBiome(biomeEden, BiomeType.WARM, 0);
	}

	public static void addBiome(BiomeGenBase biome, BiomeType biomeType,
			int biomeWeight) {
		BiomeManager.addBiome(biomeType, new BiomeEntry(biome, biomeWeight));
		BiomeManager.addSpawnBiome(biome);
		BiomeManager.addVillageBiome(biome, true);
		BiomeManager.addStrongholdBiome(biome);
	}
}