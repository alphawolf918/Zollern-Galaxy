package zollerngalaxy.biomes;

import static net.minecraftforge.common.BiomeDictionary.Type.COLD;
import static net.minecraftforge.common.BiomeDictionary.Type.DEAD;
import static net.minecraftforge.common.BiomeDictionary.Type.DRY;
import static net.minecraftforge.common.BiomeDictionary.Type.FOREST;
import static net.minecraftforge.common.BiomeDictionary.Type.HOT;
import static net.minecraftforge.common.BiomeDictionary.Type.LUSH;
import static net.minecraftforge.common.BiomeDictionary.Type.MOUNTAIN;
import static net.minecraftforge.common.BiomeDictionary.Type.PLAINS;
import static net.minecraftforge.common.BiomeDictionary.Type.SNOWY;
import static net.minecraftforge.common.BiomeDictionary.Type.SPOOKY;
import static net.minecraftforge.common.BiomeDictionary.Type.SWAMP;
import static net.minecraftforge.common.BiomeDictionary.Type.WET;
import java.util.LinkedList;
import java.util.List;
import micdoodle8.mods.galacticraft.api.world.BiomeGenBaseGC;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraftforge.common.BiomeDictionary;
import zollerngalaxy.biomes.eden.BiomeBloodDesert;
import zollerngalaxy.biomes.eden.BiomeEdenwoodForest;
import zollerngalaxy.biomes.eden.BiomeGoldenMeadow;
import zollerngalaxy.biomes.eden.BiomeGreenLands;
import zollerngalaxy.biomes.eden.BiomeSnowyPlains;
import zollerngalaxy.biomes.eden.BiomeStoneMountains;
import zollerngalaxy.biomes.eden.BiomeSwamplands;
import zollerngalaxy.biomes.eden.BiomeTerranValley;
import zollerngalaxy.biomes.kriffon.BiomeKriffon;
import zollerngalaxy.biomes.purgot.BiomeLimbo;
import zollerngalaxy.biomes.purgot.BiomePurgot;
import zollerngalaxy.biomes.zollus.BiomeZollus;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;
import zollerngalaxy.lib.helpers.ZGHelper;

public class ZGBiomes {
	
	public static final List<BiomeGenBaseGC> biomeList = new LinkedList<>();
	private static int totalBiomes = 0;
	
	public static Biome ZOLLUS = new BiomeZollus(new BiomeProperties("Zollus"));
	
	public static Biome KRIFFON = new BiomeKriffon(new BiomeProperties("Kriffon"));
	
	public static Biome PURGOT = new BiomePurgot(new BiomeProperties("Purgotary"));
	public static Biome LIMBO = new BiomeLimbo(new BiomeProperties("Limbo"));
	
	public static Biome EDEN_GREEN_LANDS = new BiomeGreenLands(new BiomeProperties("Green Lands"));
	public static Biome EDEN_BLOOD_DESERT = new BiomeBloodDesert(
			new BiomeProperties("Blood Desert"));
	public static Biome EDEN_ROCK_MOUNTAINS = new BiomeStoneMountains(new BiomeProperties(
			"Rock Mountains"));
	public static Biome EDEN_TERRAN_VALLEY = new BiomeTerranValley(new BiomeProperties(
			"Terran Valley"));
	public static Biome EDEN_SNOWY_PLAINS = new BiomeSnowyPlains(
			new BiomeProperties("Snowy Plains"));
	public static Biome EDEN_GOLDEN_MEADOW = new BiomeGoldenMeadow(new BiomeProperties(
			"Golden Meadow"));
	public static Biome EDEN_SWAMPLANDS = new BiomeSwamplands(new BiomeProperties("Swamplands"));
	public static Biome EDENWOOD_FOREST = new BiomeEdenwoodForest(new BiomeProperties(
			"Edenwood Forest"));
	
	public static void init() {
		// Zollus
		ZGBiomes.addBiome(ZGBiomes.ZOLLUS, COLD, DEAD, DRY);
		
		// Kriffon
		ZGBiomes.addBiome(ZGBiomes.KRIFFON, HOT, DEAD, DRY);
		
		// Purgot
		ZGBiomes.addBiome(ZGBiomes.PURGOT, DEAD, DRY);
		ZGBiomes.addBiome(ZGBiomes.LIMBO, SPOOKY, DEAD);
		
		// Eden
		ZGBiomes.addBiome(ZGBiomes.EDEN_GREEN_LANDS, LUSH, WET);
		ZGBiomes.addBiome(ZGBiomes.EDEN_BLOOD_DESERT, HOT, DEAD, DRY, MOUNTAIN);
		ZGBiomes.addBiome(ZGBiomes.EDEN_ROCK_MOUNTAINS, MOUNTAIN, DEAD);
		ZGBiomes.addBiome(ZGBiomes.EDEN_TERRAN_VALLEY, LUSH, WET);
		ZGBiomes.addBiome(ZGBiomes.EDEN_SNOWY_PLAINS, PLAINS, COLD, SNOWY);
		ZGBiomes.addBiome(ZGBiomes.EDEN_GOLDEN_MEADOW, LUSH, WET);
		ZGBiomes.addBiome(ZGBiomes.EDEN_SWAMPLANDS, LUSH, WET, SWAMP);
		ZGBiomes.addBiome(ZGBiomes.EDENWOOD_FOREST, LUSH, WET, FOREST);
		
		ZGHelper.Log("Loaded a total of " + totalBiomes + " new biomes.");
	}
	
	private static void addBiome(Biome biome, BiomeDictionary.Type... biomeType) {
		CommonZGRegisterHelper.registerBiome(biome);
		CommonZGRegisterHelper.registerBiomeType(biome, biomeType);
		totalBiomes++;
	}
	
}