package galaxymod.biomes;

import galaxymod.biomes.eden.BiomeEden;
import galaxymod.biomes.eden.BiomeEdenBloodDesert;
import galaxymod.biomes.eden.BiomeEdenGarden;
import galaxymod.biomes.eden.BiomeEdenRockMountains;
import galaxymod.biomes.eden.BiomeEdenTerranValley;
import galaxymod.biomes.zollus.BiomeZollus;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class BiomeList {
	
	public static int biomeColor = 1204859;
	
	public static BiomeGenBase biomeZollus = new BiomeZollus(179);
	public static BiomeGenBase biomeEden = new BiomeEden(178);
	public static BiomeGenBase biomeEdenRockMountains = new BiomeEdenRockMountains(
			177);
	public static BiomeGenBase biomeEdenTerranValley = new BiomeEdenTerranValley(
			176);
	public static BiomeGenBase biomeEdenBloodDesert = new BiomeEdenBloodDesert(
			175);
	public static BiomeGenBase biomeEdenGarden = new BiomeEdenGarden(174);
	
	public static void init() {
		addBiome(biomeZollus, BiomeType.COOL, BiomeDictionary.Type.COLD, 0);
		addBiome(biomeEden, BiomeType.WARM, BiomeDictionary.Type.PLAINS, 0);
		addBiome(biomeEdenRockMountains, BiomeType.WARM,
				BiomeDictionary.Type.MOUNTAIN, 0);
		addBiome(biomeEdenTerranValley, BiomeType.COOL,
				BiomeDictionary.Type.SAVANNA, 0);
		addBiome(biomeEdenBloodDesert, BiomeType.DESERT,
				BiomeDictionary.Type.SANDY, 0);
		addBiome(biomeEdenGarden, BiomeType.WARM, BiomeDictionary.Type.SWAMP, 0);
	}
	
	public static void addBiome(BiomeGenBase biome, BiomeType biomeType,
			BiomeDictionary.Type biomeType2, int biomeWeight) {
		BiomeManager.addBiome(biomeType, new BiomeEntry(biome, biomeWeight));
		BiomeManager.addSpawnBiome(biome);
		BiomeManager.addVillageBiome(biome, true);
		BiomeManager.addStrongholdBiome(biome);
	}
}