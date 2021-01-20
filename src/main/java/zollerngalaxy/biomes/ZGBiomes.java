/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes;

import static net.minecraftforge.common.BiomeDictionary.Type.BEACH;
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
import static net.minecraftforge.common.BiomeDictionary.Type.WASTELAND;
import static net.minecraftforge.common.BiomeDictionary.Type.WET;
import java.util.LinkedList;
import java.util.List;
import micdoodle8.mods.galacticraft.api.world.BiomeGenBaseGC;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraftforge.common.BiomeDictionary;
import zollerngalaxy.biomes.altum.BiomeAltumOcean;
import zollerngalaxy.biomes.altum.BiomeRockyIsles;
import zollerngalaxy.biomes.altum.BiomeRockyShore;
import zollerngalaxy.biomes.altum.BiomeSanctumBeach;
import zollerngalaxy.biomes.atheon.BiomeGoldlands;
import zollerngalaxy.biomes.atheon.BiomeRadiolarianLakes;
import zollerngalaxy.biomes.caligro.BiomeCaligroCorruptedMesa;
import zollerngalaxy.biomes.caligro.BiomeCaligroCreeplands;
import zollerngalaxy.biomes.caligro.BiomeCaligroRockyVeins;
import zollerngalaxy.biomes.caligro.BiomeCaligroUpsideDown;
import zollerngalaxy.biomes.caligro.BiomeCaligroWitherlands;
import zollerngalaxy.biomes.candora.BiomeBlueberryHills;
import zollerngalaxy.biomes.candora.BiomeCandyMountain;
import zollerngalaxy.biomes.candora.BiomeChocolateOcean;
import zollerngalaxy.biomes.candora.BiomeCookieLands;
import zollerngalaxy.biomes.candora.BiomeJollyWatermelonPlains;
import zollerngalaxy.biomes.eden.BiomeAsteroidCraters;
import zollerngalaxy.biomes.eden.BiomeBloodDesert;
import zollerngalaxy.biomes.eden.BiomeEdenOcean;
import zollerngalaxy.biomes.eden.BiomeEdenParadiseWoods;
import zollerngalaxy.biomes.eden.BiomeEdenwoodForest;
import zollerngalaxy.biomes.eden.BiomeFlowerGarden;
import zollerngalaxy.biomes.eden.BiomeGoldenMeadow;
import zollerngalaxy.biomes.eden.BiomeGreenLands;
import zollerngalaxy.biomes.eden.BiomeShroomHills;
import zollerngalaxy.biomes.eden.BiomeSnowyPlains;
import zollerngalaxy.biomes.eden.BiomeStoneMountains;
import zollerngalaxy.biomes.eden.BiomeSwamplands;
import zollerngalaxy.biomes.eden.BiomeTerranValley;
import zollerngalaxy.biomes.exodus.BiomeAzuralPlains;
import zollerngalaxy.biomes.exodus.BiomeExodusRockyHills;
import zollerngalaxy.biomes.kriffon.BiomeKriffon;
import zollerngalaxy.biomes.kriffon.BiomeKriffonLavaOcean;
import zollerngalaxy.biomes.oasis.BiomeOasisPlains;
import zollerngalaxy.biomes.oasis.BiomeOasisRedSea;
import zollerngalaxy.biomes.oasis.BiomeRedlands;
import zollerngalaxy.biomes.perdita.BiomeFueltoniumOcean;
import zollerngalaxy.biomes.perdita.BiomeLostDesert;
import zollerngalaxy.biomes.perdita.BiomeLostHallows;
import zollerngalaxy.biomes.perdita.BiomeLostMountains;
import zollerngalaxy.biomes.perdita.BiomeLostOasis;
import zollerngalaxy.biomes.purgot.BiomeLimbo;
import zollerngalaxy.biomes.purgot.BiomePurgot;
import zollerngalaxy.biomes.xantheon.BiomeXantheon;
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
	public static final Biome KRIFFON_LAVA_OCEAN = new BiomeKriffonLavaOcean(new BiomeProperties("Lake of Fire"));
	
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
	public static final Biome EDEN_PARADISE_WOODS = new BiomeEdenParadiseWoods(new BiomeProperties("Paradise Woods"));
	public static final Biome EDEN_SWAMPLANDS = new BiomeSwamplands(new BiomeProperties("Swamplands"));
	public static final Biome EDENWOOD_FOREST = new BiomeEdenwoodForest(new BiomeProperties("Edenwood Forest"));
	public static final Biome EDEN_FLOWER_GARDEN = new BiomeFlowerGarden(new BiomeProperties("The Garden"));
	public static final Biome EDEN_CRATERS = new BiomeAsteroidCraters(new BiomeProperties("Asteroid Craters"));
	public static final Biome EDEN_SHROOM_HILLS = new BiomeShroomHills(new BiomeProperties("Redshroom Hills"));
	public static final Biome EDEN_OCEAN = new BiomeEdenOcean(new BiomeProperties("Ocean of Eden"));
	
	// Xathius
	public static final Biome XATHIUS_ABSTRACT_PLAINS = new BiomeAbstractPlains(new BiomeProperties("Abstract Plains"));
	public static final Biome XATHIUS_OCEAN = new BiomeXathiusOcean(new BiomeProperties("Xathius Ocean"));
	public static final Biome XATHIUS_BLUELANDS = new BiomeBluelands(new BiomeProperties("Bluelands"));
	public static final Biome XATHIUS_MOUNTAINS = new BiomeXathiusMountains(new BiomeProperties("Xathian Mountains"));
	
	// Oasis
	public static final Biome OASIS_PLAINS = new BiomeOasisPlains(new BiomeProperties("Oasis Plains"));
	public static final Biome OASIS_OCEAN = new BiomeOasisRedSea(new BiomeProperties("Red Sea"));
	public static final Biome OASIS_REDLANDS = new BiomeRedlands(new BiomeProperties("Redlands"));
	
	// Xantheon
	public static final Biome XANTHEON = new BiomeXantheon(new BiomeProperties("Xantheon"));
	
	// Candora
	public static final Biome CANDY_MOUNTAIN = new BiomeCandyMountain(new BiomeProperties("Candy Mountain"));
	public static final Biome CANDY_OCEAN = new BiomeChocolateOcean(new BiomeProperties("Chocolate Ocean"));
	public static final Biome CANDY_JOLLY_MELON_PLAINS = new BiomeJollyWatermelonPlains(new BiomeProperties("Jolly Watermelon Plains"));
	public static final Biome CANDY_BLUEBERRY_HILLS = new BiomeBlueberryHills(new BiomeProperties("Blueberry Hills"));
	public static final Biome CANDY_COOKIE_LANDS = new BiomeCookieLands(new BiomeProperties("Cookie Lands"));
	
	// Atheon
	public static final Biome ATHEON_GOLDLANDS = new BiomeGoldlands(new BiomeProperties("Golden Constructs"));
	public static final Biome ATHEON_LAVA_LAKES = new BiomeRadiolarianLakes(new BiomeProperties("Radiolarian Ocean"));
	
	// Perdita
	public static final Biome PERDITA_DESERT = new BiomeLostDesert(new BiomeProperties("Lost Desert"));
	public static final Biome PERDITA_HALLOWS = new BiomeLostHallows(new BiomeProperties("Lost Hallows"));
	public static final Biome PERDITA_OASIS = new BiomeLostOasis(new BiomeProperties("Lost Oasis"));
	public static final Biome PERDITA_FUELTONIUM_OCEAN = new BiomeFueltoniumOcean(new BiomeProperties("Fueltonium Ocean"));
	public static final Biome PERDITA_LOST_MOUNTAINS = new BiomeLostMountains(new BiomeProperties("Lost Mountains"));
	
	// Altum
	public static final Biome ALTUM_ROCKY_ISLES = new BiomeRockyIsles(new BiomeProperties("Rocky Isles"));
	public static final Biome ALTUM_SANCTUM_BEACH = new BiomeSanctumBeach(new BiomeProperties("Sanctum Beach"));
	public static final Biome ALTUM_OCEAN = new BiomeAltumOcean(new BiomeProperties("The Abyss"));
	public static final Biome ALTUM_ROCKY_SHORE = new BiomeRockyShore(new BiomeProperties("Rocky Shore"));
	
	// Caligro
	public static final Biome CALIGRO_UPSIDE_DOWN = new BiomeCaligroUpsideDown(new BiomeProperties("Upside Down"));
	public static final Biome CALIGRO_CREEPLANDS = new BiomeCaligroCreeplands(new BiomeProperties("Creeplands"));
	public static final Biome CALIGRO_ROCKY_VEINS = new BiomeCaligroRockyVeins(new BiomeProperties("Rocky Veins"));
	public static final Biome CALIGRO_WITHERLANDS = new BiomeCaligroWitherlands(new BiomeProperties("Witherlands"));
	public static final Biome CALIGRO_CORRUPTED_MESA = new BiomeCaligroCorruptedMesa(new BiomeProperties("Corrupted Mesa"));
	
	// Exodus
	public static final Biome EXODUS_AZURE_PLAINS = new BiomeAzuralPlains(new BiomeProperties("Azural Plains"));
	public static final Biome EXODUS_ROCKY_HILLS = new BiomeExodusRockyHills(new BiomeProperties("Rocky Hills"));
	
	public static void init() {
		// Zollus
		ZGBiomes.addBiome(ZGBiomes.ZOLLUS, COLD, DEAD, DRY);
		
		// Kriffon
		ZGBiomes.addBiome(ZGBiomes.KRIFFON, HOT, DEAD, DRY);
		ZGBiomes.addBiome(ZGBiomes.KRIFFON_LAVA_OCEAN, DEAD, SPOOKY, HOT, OCEAN);
		
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
		ZGBiomes.addBiome(ZGBiomes.EDEN_PARADISE_WOODS, LUSH, WET, FOREST);
		ZGBiomes.addBiome(ZGBiomes.EDEN_SWAMPLANDS, LUSH, WET, SWAMP);
		ZGBiomes.addBiome(ZGBiomes.EDENWOOD_FOREST, LUSH, WET, FOREST);
		ZGBiomes.addBiome(ZGBiomes.EDEN_FLOWER_GARDEN, LUSH, WET, PLAINS);
		ZGBiomes.addBiome(ZGBiomes.EDEN_CRATERS, MOUNTAIN, DEAD, SPOOKY);
		ZGBiomes.addBiome(ZGBiomes.EDEN_SHROOM_HILLS, MOUNTAIN, WET);
		ZGBiomes.addBiome(ZGBiomes.EDEN_OCEAN, LUSH, WET, OCEAN);
		
		// Xathius
		ZGBiomes.addBiome(ZGBiomes.XATHIUS_ABSTRACT_PLAINS, LUSH, PLAINS);
		ZGBiomes.addBiome(ZGBiomes.XATHIUS_OCEAN, LUSH, WET, OCEAN);
		ZGBiomes.addBiome(ZGBiomes.XATHIUS_BLUELANDS, LUSH, MOUNTAIN);
		ZGBiomes.addBiome(ZGBiomes.XATHIUS_MOUNTAINS, MOUNTAIN, DEAD);
		
		// Oasis
		ZGBiomes.addBiome(ZGBiomes.OASIS_PLAINS, LUSH, WET, PLAINS);
		ZGBiomes.addBiome(ZGBiomes.OASIS_OCEAN, LUSH, WET, OCEAN);
		ZGBiomes.addBiome(ZGBiomes.OASIS_REDLANDS, LUSH, MOUNTAIN);
		
		// Xantheon
		ZGBiomes.addBiome(ZGBiomes.XANTHEON, DEAD, SPOOKY, COLD, WASTELAND);
		
		// Candora
		ZGBiomes.addBiome(ZGBiomes.CANDY_MOUNTAIN, MOUNTAIN);
		ZGBiomes.addBiome(ZGBiomes.CANDY_OCEAN, OCEAN, WET);
		ZGBiomes.addBiome(ZGBiomes.CANDY_JOLLY_MELON_PLAINS, PLAINS);
		ZGBiomes.addBiome(ZGBiomes.CANDY_BLUEBERRY_HILLS, MOUNTAIN);
		ZGBiomes.addBiome(ZGBiomes.CANDY_COOKIE_LANDS, PLAINS);
		
		// Atheon
		ZGBiomes.addBiome(ZGBiomes.ATHEON_GOLDLANDS, DEAD, SPOOKY, HOT, WASTELAND);
		ZGBiomes.addBiome(ZGBiomes.ATHEON_LAVA_LAKES, DEAD, SPOOKY, HOT, OCEAN);
		
		// Perdita
		ZGBiomes.addBiome(ZGBiomes.PERDITA_DESERT, DEAD, HOT, DRY, MOUNTAIN, WASTELAND);
		ZGBiomes.addBiome(ZGBiomes.PERDITA_HALLOWS, DEAD, HOT, DRY, PLAINS);
		ZGBiomes.addBiome(ZGBiomes.PERDITA_OASIS, LUSH, WET, PLAINS);
		ZGBiomes.addBiome(ZGBiomes.PERDITA_FUELTONIUM_OCEAN, DEAD, SPOOKY, HOT, OCEAN);
		ZGBiomes.addBiome(ZGBiomes.PERDITA_LOST_MOUNTAINS, MOUNTAIN, DEAD);
		
		// Altum
		ZGBiomes.addBiome(ZGBiomes.ALTUM_ROCKY_ISLES, LUSH, WET, BEACH);
		ZGBiomes.addBiome(ZGBiomes.ALTUM_SANCTUM_BEACH, LUSH, WET, BEACH);
		ZGBiomes.addBiome(ZGBiomes.ALTUM_OCEAN, WET, OCEAN);
		ZGBiomes.addBiome(ZGBiomes.ALTUM_ROCKY_SHORE, LUSH, WET, MOUNTAIN);
		
		// Caligro
		ZGBiomes.addBiome(ZGBiomes.CALIGRO_UPSIDE_DOWN, PLAINS, SPOOKY, COLD, DEAD);
		ZGBiomes.addBiome(ZGBiomes.CALIGRO_CREEPLANDS, WASTELAND, SPOOKY, COLD, DEAD);
		ZGBiomes.addBiome(ZGBiomes.CALIGRO_ROCKY_VEINS, MOUNTAIN, SPOOKY, COLD, DEAD);
		ZGBiomes.addBiome(ZGBiomes.CALIGRO_WITHERLANDS, WASTELAND, SPOOKY, COLD, DEAD);
		ZGBiomes.addBiome(ZGBiomes.CALIGRO_CORRUPTED_MESA, MOUNTAIN, SPOOKY, COLD, DEAD);
		
		// Exodus
		ZGBiomes.addBiome(ZGBiomes.EXODUS_AZURE_PLAINS, LUSH, WET, PLAINS);
		ZGBiomes.addBiome(ZGBiomes.EXODUS_ROCKY_HILLS, LUSH, WET, MOUNTAIN);
		
		ZGHelper.Log("Loaded a total of " + totalBiomes + " new biomes.");
	}
	
	private static void addBiome(Biome biome, BiomeDictionary.Type... biomeType) {
		CommonZGRegisterHelper.registerBiome(biome);
		CommonZGRegisterHelper.registerBiomeType(biome, biomeType);
		totalBiomes++;
	}
	
}