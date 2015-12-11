package galaxymod.biomes;

import galaxymod.biomes.eden.BiomeEden;
import galaxymod.biomes.eden.BiomeEdenBloodDesert;
import galaxymod.biomes.eden.BiomeEdenForest;
import galaxymod.biomes.eden.BiomeEdenGarden;
import galaxymod.biomes.eden.BiomeEdenMagmaLands;
import galaxymod.biomes.eden.BiomeEdenRockMountains;
import galaxymod.biomes.eden.BiomeEdenSnowyPlains;
import galaxymod.biomes.eden.BiomeEdenTerranValley;
import galaxymod.biomes.kriffus.BiomeKriffus;
import galaxymod.biomes.zollus.BiomeZollus;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class BiomeList {
	
	public static int biomeColor = 1404852;
	
	public static BiomeGenBase biomeZollus = new BiomeZollus(179);
	public static BiomeGenBase biomeEden = new BiomeEden(178);
	public static BiomeGenBase biomeEdenRockMountains = new BiomeEdenRockMountains(
			177);
	public static BiomeGenBase biomeEdenTerranValley = new BiomeEdenTerranValley(
			176);
	public static BiomeGenBase biomeEdenBloodDesert = new BiomeEdenBloodDesert(
			175);
	public static BiomeGenBase biomeEdenGarden = new BiomeEdenGarden(174);
	public static BiomeGenBase biomeEdenForest = new BiomeEdenForest(173);
	public static BiomeGenBase biomeEdenMagmaLands = new BiomeEdenMagmaLands(
			172);
	public static BiomeGenBase biomeEdenSnowyPlains = new BiomeEdenSnowyPlains(
			171);
	public static BiomeGenBase biomeKriffus = new BiomeKriffus(170);
	
	public static void init() {
		// ZOLLUS
		addBiome(biomeZollus, BiomeType.COOL, BiomeDictionary.Type.COLD, 0);
		
		// EDEN
		addBiome(biomeEden, BiomeType.WARM, BiomeDictionary.Type.PLAINS, 0);
		addBiome(biomeEdenRockMountains, BiomeType.WARM,
				BiomeDictionary.Type.MOUNTAIN, 0);
		addBiome(biomeEdenTerranValley, BiomeType.COOL,
				BiomeDictionary.Type.SAVANNA, 0);
		addBiome(biomeEdenBloodDesert, BiomeType.DESERT,
				BiomeDictionary.Type.SANDY, 0);
		addBiome(biomeEdenGarden, BiomeType.WARM, BiomeDictionary.Type.SWAMP, 0);
		addBiome(biomeEdenForest, BiomeType.WARM, BiomeDictionary.Type.OCEAN, 0);
		addBiome(biomeEdenMagmaLands, BiomeType.WARM,
				BiomeDictionary.Type.WASTELAND, 0);
		addBiome(biomeEdenSnowyPlains, BiomeType.ICY,
				BiomeDictionary.Type.COLD, 0);
		
		// KRIFFUS
		addBiome(biomeKriffus, BiomeType.DESERT,
				BiomeDictionary.Type.WASTELAND, 0);
	}
	
	public static void addBiome(BiomeGenBase biome, BiomeType biomeType,
			BiomeDictionary.Type biomeType2, int biomeWeight) {
		BiomeManager.addBiome(biomeType, new BiomeEntry(biome, biomeWeight));
		BiomeManager.addSpawnBiome(biome);
		BiomeManager.addVillageBiome(biome, true);
		BiomeManager.addStrongholdBiome(biome);
	}
}