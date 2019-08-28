package zollerngalaxy.biomes;

import static net.minecraftforge.common.BiomeDictionary.Type.COLD;
import static net.minecraftforge.common.BiomeDictionary.Type.DEAD;
import static net.minecraftforge.common.BiomeDictionary.Type.DRY;
import static net.minecraftforge.common.BiomeDictionary.Type.FOREST;
import static net.minecraftforge.common.BiomeDictionary.Type.HOT;
import static net.minecraftforge.common.BiomeDictionary.Type.LUSH;
import static net.minecraftforge.common.BiomeDictionary.Type.MOUNTAIN;
import static net.minecraftforge.common.BiomeDictionary.Type.OCEAN;
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
import zollerngalaxy.biomes.eden.BiomeAsteroidCraters;
import zollerngalaxy.biomes.eden.BiomeBloodDesert;
import zollerngalaxy.biomes.eden.BiomeEdenOcean;
import zollerngalaxy.biomes.eden.BiomeEdenwoodForest;
import zollerngalaxy.biomes.eden.BiomeFlowerGarden;
import zollerngalaxy.biomes.eden.BiomeGoldenMeadow;
import zollerngalaxy.biomes.eden.BiomeGreenLands;
import zollerngalaxy.biomes.eden.BiomeSnowyPlains;
import zollerngalaxy.biomes.eden.BiomeStoneMountains;
import zollerngalaxy.biomes.eden.BiomeSwamplands;
import zollerngalaxy.biomes.eden.BiomeTerranValley;
import zollerngalaxy.biomes.kriffon.BiomeKriffon;
import zollerngalaxy.biomes.purgot.BiomeLimbo;
import zollerngalaxy.biomes.purgot.BiomePurgot;
import zollerngalaxy.biomes.xathius.BiomeAbstractPlains;
import zollerngalaxy.biomes.xathius.BiomeBluelands;
import zollerngalaxy.biomes.xathius.BiomeXathiusMountains;
import zollerngalaxy.biomes.xathius.BiomeXathiusOcean;
import zollerngalaxy.biomes.zollus.BiomeZollus;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;
import zollerngalaxy.lib.helpers.ZGHelper;

public class ZGBiomes {
	
	public static final List<BiomeGenBaseGC> biomeList = new LinkedList<>();
	private static int totalBiomes = 0;
	
	// Zollus
	public static final Biome ZOLLUS = new BiomeZollus(new BiomeProperties("Zollus"));
	
	// Kriffon
	public static final Biome KRIFFON = new BiomeKriffon(new BiomeProperties("Kriffon"));
	
	// Purgot
	public static final Biome PURGOT_BASE = new BiomePurgot(new BiomeProperties("Purgotary"));
	public static final Biome PURGOT_LIMBO = new BiomeLimbo(new BiomeProperties("Limbo"));
	
	// Eden
	public static final Biome EDEN_GREEN_LANDS = new BiomeGreenLands(new BiomeProperties("Green Lands"));
	public static final Biome EDEN_BLOOD_DESERT = new BiomeBloodDesert(new BiomeProperties("Blood Desert"));
	public static final Biome EDEN_ROCK_MOUNTAINS = new BiomeStoneMountains(new BiomeProperties("Rock Mountains"));
	public static final Biome EDEN_TERRAN_VALLEY = new BiomeTerranValley(new BiomeProperties("Terran Valley"));
	public static final Biome EDEN_SNOWY_PLAINS = new BiomeSnowyPlains(new BiomeProperties("Snowy Plains"));
	public static final Biome EDEN_GOLDEN_MEADOW = new BiomeGoldenMeadow(new BiomeProperties("Golden Meadow"));
	public static final Biome EDEN_SWAMPLANDS = new BiomeSwamplands(new BiomeProperties("Swamplands"));
	public static final Biome EDENWOOD_FOREST = new BiomeEdenwoodForest(new BiomeProperties("Edenwood Forest"));
	public static final Biome EDEN_FLOWER_GARDEN = new BiomeFlowerGarden(new BiomeProperties("The Garden"));
	public static final Biome EDEN_CRATERS = new BiomeAsteroidCraters(new BiomeProperties("Asteroid Craters"));
	public static final Biome EDEN_OCEAN = new BiomeEdenOcean(new BiomeProperties("Ocean of Eden"));
	
	// Xathius
	public static final Biome XATHIUS_ABSTRACT_PLAINS = new BiomeAbstractPlains(new BiomeProperties("Abstract Plains"));
	public static final Biome XATHIUS_OCEAN = new BiomeXathiusOcean(new BiomeProperties("Xathius Ocean"));
	public static final Biome XATHIUS_BLUELANDS = new BiomeBluelands(new BiomeProperties("Bluelands"));
	public static final Biome XATHIUS_MOUNTAINS = new BiomeXathiusMountains(new BiomeProperties("Xathian Mountains"));
	
	// Oasis
	// TODO
	
	public static void init() {
		// Zollus
		ZGBiomes.addBiome(ZGBiomes.ZOLLUS, COLD, DEAD, DRY);
		
		// Kriffon
		ZGBiomes.addBiome(ZGBiomes.KRIFFON, HOT, DEAD, DRY);
		
		// Purgot
		ZGBiomes.addBiome(ZGBiomes.PURGOT_BASE, DEAD, DRY);
		ZGBiomes.addBiome(ZGBiomes.PURGOT_LIMBO, SPOOKY, DEAD);
		
		// Eden
		ZGBiomes.addBiome(ZGBiomes.EDEN_GREEN_LANDS, LUSH, WET);
		ZGBiomes.addBiome(ZGBiomes.EDEN_BLOOD_DESERT, HOT, DEAD, DRY, MOUNTAIN);
		ZGBiomes.addBiome(ZGBiomes.EDEN_ROCK_MOUNTAINS, MOUNTAIN, DEAD);
		ZGBiomes.addBiome(ZGBiomes.EDEN_TERRAN_VALLEY, LUSH, WET, PLAINS);
		ZGBiomes.addBiome(ZGBiomes.EDEN_SNOWY_PLAINS, PLAINS, COLD, SNOWY);
		ZGBiomes.addBiome(ZGBiomes.EDEN_GOLDEN_MEADOW, LUSH, WET);
		ZGBiomes.addBiome(ZGBiomes.EDEN_SWAMPLANDS, LUSH, WET, SWAMP);
		ZGBiomes.addBiome(ZGBiomes.EDENWOOD_FOREST, LUSH, WET, FOREST);
		ZGBiomes.addBiome(ZGBiomes.EDEN_FLOWER_GARDEN, LUSH, WET, PLAINS);
		ZGBiomes.addBiome(ZGBiomes.EDEN_CRATERS, MOUNTAIN, DEAD, SPOOKY);
		ZGBiomes.addBiome(ZGBiomes.EDEN_OCEAN, LUSH, WET, OCEAN);
		
		// Xathius
		ZGBiomes.addBiome(ZGBiomes.XATHIUS_ABSTRACT_PLAINS, LUSH, PLAINS);
		ZGBiomes.addBiome(ZGBiomes.XATHIUS_OCEAN, LUSH, WET, OCEAN);
		ZGBiomes.addBiome(ZGBiomes.XATHIUS_BLUELANDS, LUSH, MOUNTAIN);
		ZGBiomes.addBiome(ZGBiomes.XATHIUS_MOUNTAINS, MOUNTAIN, DEAD);
		
		// Oasis
		// TODO
		
		ZGHelper.Log("Loaded a total of " + totalBiomes + " new biomes.");
	}
	
	private static void addBiome(Biome biome, BiomeDictionary.Type... biomeType) {
		CommonZGRegisterHelper.registerBiome(biome);
		CommonZGRegisterHelper.registerBiomeType(biome, biomeType);
		totalBiomes++;
	}
	
}