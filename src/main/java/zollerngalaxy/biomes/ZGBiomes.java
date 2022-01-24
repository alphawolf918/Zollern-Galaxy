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
import static net.minecraftforge.common.BiomeDictionary.Type.HILLS;
import static net.minecraftforge.common.BiomeDictionary.Type.HOT;
import static net.minecraftforge.common.BiomeDictionary.Type.JUNGLE;
import static net.minecraftforge.common.BiomeDictionary.Type.LUSH;
import static net.minecraftforge.common.BiomeDictionary.Type.MOUNTAIN;
import static net.minecraftforge.common.BiomeDictionary.Type.NETHER;
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
import zollerngalaxy.biomes.astros.BiomeAstros;
import zollerngalaxy.biomes.astros.BiomeAstrosGlaciers;
import zollerngalaxy.biomes.astros.BiomeAstrosRockies;
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
import zollerngalaxy.biomes.centotl.BiomeCento;
import zollerngalaxy.biomes.centotl.BiomeCentoConstructs;
import zollerngalaxy.biomes.centotl.BiomeCentoEngineeringPlains;
import zollerngalaxy.biomes.centotl.BiomeCentoRockyMountains;
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
import zollerngalaxy.biomes.exodus.BiomeBlackMesa;
import zollerngalaxy.biomes.exodus.BiomeExoForest;
import zollerngalaxy.biomes.exodus.BiomeExodusOcean;
import zollerngalaxy.biomes.exodus.BiomeExodusRockyHills;
import zollerngalaxy.biomes.kriffon.BiomeKriffon;
import zollerngalaxy.biomes.kriffon.BiomeKriffonLavaOcean;
import zollerngalaxy.biomes.kronos.BiomeKronos;
import zollerngalaxy.biomes.kronos.BiomeKronosBlackMountain;
import zollerngalaxy.biomes.kronos.BiomeKronosBlazingHills;
import zollerngalaxy.biomes.kronos.BiomeKronosDeathValley;
import zollerngalaxy.biomes.kronos.BiomeKronosLavaOcean;
import zollerngalaxy.biomes.kronos.BiomeKronosMagmaSlimelands;
import zollerngalaxy.biomes.kronos.BiomeKronosSoulDesert;
import zollerngalaxy.biomes.metztli.BiomeHarranClayMesa;
import zollerngalaxy.biomes.metztli.BiomeHarranDunes;
import zollerngalaxy.biomes.metztli.BiomeHarranForest;
import zollerngalaxy.biomes.metztli.BiomeHarranFruitForest;
import zollerngalaxy.biomes.metztli.BiomeHarranHills;
import zollerngalaxy.biomes.metztli.BiomeHarranMarsh;
import zollerngalaxy.biomes.metztli.BiomeHarranOcean;
import zollerngalaxy.biomes.metztli.BiomeHarranPlains;
import zollerngalaxy.biomes.metztli.BiomeHarranShroomlands;
import zollerngalaxy.biomes.metztli.BiomeHarranSwamp;
import zollerngalaxy.biomes.metztli.BiomeHarranTundra;
import zollerngalaxy.biomes.oasis.BiomeOasisMudSwamp;
import zollerngalaxy.biomes.oasis.BiomeOasisPlains;
import zollerngalaxy.biomes.oasis.BiomeOasisRedSea;
import zollerngalaxy.biomes.oasis.BiomeOasisRedlands;
import zollerngalaxy.biomes.perdita.BiomeFueltoniumOcean;
import zollerngalaxy.biomes.perdita.BiomeLostDesert;
import zollerngalaxy.biomes.perdita.BiomeLostHallows;
import zollerngalaxy.biomes.perdita.BiomeLostMountains;
import zollerngalaxy.biomes.perdita.BiomeLostOasis;
import zollerngalaxy.biomes.purgot.BiomeLimbo;
import zollerngalaxy.biomes.purgot.BiomePurgot;
import zollerngalaxy.biomes.tlaloc.BiomeTlaloc;
import zollerngalaxy.biomes.tlaloc.BiomeTlalocChromeForest;
import zollerngalaxy.biomes.tlaloc.BiomeTlalocConstructs;
import zollerngalaxy.biomes.tlaloc.BiomeTlalocGoldenConstructs;
import zollerngalaxy.biomes.toci.BiomeToci;
import zollerngalaxy.biomes.toci.BiomeTociDesert;
import zollerngalaxy.biomes.toci.BiomeTociMountains;
import zollerngalaxy.biomes.toci.BiomeTociStarDesert;
import zollerngalaxy.biomes.toci.BiomeTociValley;
import zollerngalaxy.biomes.vortex.BiomeVortex;
import zollerngalaxy.biomes.vortex.BiomeVortexChargiumSea;
import zollerngalaxy.biomes.vortex.BiomeVortexMountain;
import zollerngalaxy.biomes.xantheon.BiomeXantheon;
import zollerngalaxy.biomes.xathius.BiomeAbstractPlains;
import zollerngalaxy.biomes.xathius.BiomeBluelands;
import zollerngalaxy.biomes.xathius.BiomeXathiusMountains;
import zollerngalaxy.biomes.xathius.BiomeXathiusOcean;
import zollerngalaxy.biomes.zollus.BiomeZollus;
import zollerngalaxy.biomes.zollus.BiomeZollusIceOcean;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;
import zollerngalaxy.lib.helpers.ZGHelper;

public class ZGBiomes {
	
	public static final List<BiomeGenBaseGC> biomeList = new LinkedList<>();
	private static int totalBiomes = 0;
	
	// Zollus
	public static final Biome ZOLLUS = new BiomeZollus(new BiomeProperties("Zollus"));
	public static final Biome ZOLLUS_OCEAN = new BiomeZollusIceOcean(new BiomeProperties("Zollus Ice Ocean"));
	
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
	public static final Biome OASIS_RED_OCEAN = new BiomeOasisRedSea(new BiomeProperties("Red Sea"));
	public static final Biome OASIS_REDLANDS = new BiomeOasisRedlands(new BiomeProperties("Redlands"));
	public static final Biome OASIS_MUDSWAMP = new BiomeOasisMudSwamp(new BiomeProperties("Muddy Mesa"));
	
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
	public static final Biome EXODUS_OCEAN = new BiomeExodusOcean(new BiomeProperties("Exo Ocean"));
	public static final Biome EXODUS_FOREST = new BiomeExoForest(new BiomeProperties("Exo Forest"));
	public static final Biome EXODUS_BLACK_MESA = new BiomeBlackMesa(new BiomeProperties("Black Mesa"));
	
	// Vortex
	public static final Biome VORTEX_BASE = new BiomeVortex(new BiomeProperties("Vortex"));
	public static final Biome VORTEX_MOUNTAINS = new BiomeVortexMountain(new BiomeProperties("Vortex Mountains"));
	public static final Biome VORTEX_CHARGIUM_SEA = new BiomeVortexChargiumSea(new BiomeProperties("Vortex Chargium Sea"));
	
	// Metztli
	public static final Biome METZTLI_HARRAN_PLAINS = new BiomeHarranPlains(new BiomeProperties("Harran Plains"));
	public static final Biome METZTLI_HARRAN_DUNES = new BiomeHarranDunes(BiomeHarranDunes.Type.NORMAL, new BiomeProperties("Harran Dunes"));
	public static final Biome METZTLI_HARRAN_OCEAN = new BiomeHarranOcean(new BiomeProperties("Harran Ocean"));
	public static final Biome METZTLI_HARRAN_SWAMP = new BiomeHarranSwamp(new BiomeProperties("Harran Swamp"));
	public static final Biome METZTLI_HARRAN_TUNDRA = new BiomeHarranTundra(new BiomeProperties("Harran Tundra"), BiomeHarranTundra.Type.MEGA_SPRUCE);
	public static final Biome METZTLI_HARRAN_SHROOMS = new BiomeHarranShroomlands(new BiomeProperties("Harran Shroomlands"));
	public static final Biome METZTLI_HARRAN_CLAY_MESA = new BiomeHarranClayMesa(new BiomeProperties("Harran Clay Mesa"));
	public static final Biome METZTLI_HARRAN_MARSH = new BiomeHarranMarsh(new BiomeProperties("Harran Marsh"));
	public static final Biome METZTLI_HARRAN_FOREST = new BiomeHarranForest(BiomeHarranForest.Type.BIRCH, new BiomeProperties("Harran Birch Forest"));
	public static final Biome METZTLI_HARRAN_RED_DESERT = new BiomeHarranDunes(BiomeHarranDunes.Type.RED, "harran_heat_desert", new BiomeProperties("Harran Red Desert"));
	public static final Biome METZTLI_HARRAN_HILLS = new BiomeHarranHills(new BiomeProperties("Harran Hills"));
	public static final Biome METZTLI_HARRAN_CHERRY_FOREST = new BiomeHarranForest("harran_forest_cherry", BiomeHarranForest.Type.CHERRY, new BiomeProperties("Harran Cherry Forest"));
	public static final Biome METZTLI_HARRAN_FRUIT_FOREST = new BiomeHarranFruitForest(new BiomeProperties("Harran Fruit Forest"));
	
	// Astros
	public static final Biome ASTROS_BASE = new BiomeAstros(new BiomeProperties("Astros"));
	public static final Biome ASTROS_ROCKIES = new BiomeAstrosRockies(new BiomeProperties("Astros Moonrocks"));
	public static final Biome ASTROS_GLACIERS = new BiomeAstrosGlaciers(new BiomeProperties("Astros Glaciers"));
	
	// Centotl
	public static final Biome CENTOTL_BASE = new BiomeCento(new BiomeProperties("LV-426"));
	public static final Biome CENTOTL_ROCKY_MOUNTAINS = new BiomeCentoRockyMountains(new BiomeProperties("Xeno Mountains"));
	public static final Biome CENTOTL_ENGINEERING_PLAINS = new BiomeCentoEngineeringPlains(new BiomeProperties("Xeno Plains"));
	public static final Biome CENTOTL_CONSTRUCTS = new BiomeCentoConstructs(new BiomeProperties("Xeno Constructs"));
	
	// Toci
	public static final Biome TOCI_BASE = new BiomeToci(new BiomeProperties("Toci"));
	public static final Biome TOCI_DESERT = new BiomeTociDesert(new BiomeProperties("Toci Desert"));
	public static final Biome TOCI_STAR_DESERT = new BiomeTociStarDesert(new BiomeProperties("Toci Star Desert"));
	public static final Biome TOCI_VALLEY = new BiomeTociValley(new BiomeProperties("Toci Valley"));
	public static final Biome TOCI_MOUNTAINS = new BiomeTociMountains(new BiomeProperties("Toci Mountains"));
	
	// Tlaloc
	public static final Biome TLALOC_BASE = new BiomeTlaloc(new BiomeProperties("Tlaloc"));
	public static final Biome TLALOC_CONSTRUCTS = new BiomeTlalocConstructs(new BiomeProperties("Tlaloc Constructs"));
	public static final Biome TLALOC_CHROME_FOREST = new BiomeTlalocChromeForest(new BiomeProperties("Tlaloc Chrome Forest"));
	public static final Biome TLALOC_GOLDEN_CONSTRUCTS = new BiomeTlalocGoldenConstructs(new BiomeProperties("Tlaloc Golden Constructs"));
	
	// Kronos
	public static final Biome KRONOS_BASE = new BiomeKronos(new BiomeProperties("Kronos"));
	public static final Biome KRONOS_SOUL_DESERT = new BiomeKronosSoulDesert(new BiomeProperties("Kronos Desert of Souls"));
	public static final Biome KRONOS_BLACK_MOUNTAIN = new BiomeKronosBlackMountain(new BiomeProperties("Kronos Black Mountain"));
	public static final Biome KRONOS_DEATH_VALLEY = new BiomeKronosDeathValley(new BiomeProperties("Kronos Death Valley"));
	public static final Biome KRONOS_BLAZING_HILLS = new BiomeKronosBlazingHills(new BiomeProperties("Kronos Blazing Hills"));
	public static final Biome KRONOS_LAVA_OCEAN = new BiomeKronosLavaOcean(new BiomeProperties("Kronos Lava Ocean"));
	public static final Biome KRONOS_MAGMA_SLIMELANDS = new BiomeKronosMagmaSlimelands(new BiomeProperties("Kronos Magma Slimelands"));
	
	public static void init() {
		// Zollus
		ZGBiomes.addBiome(ZGBiomes.ZOLLUS, COLD, DEAD, DRY);
		ZGBiomes.addBiome(ZGBiomes.ZOLLUS_OCEAN, COLD, DEAD, WET, OCEAN);
		
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
		ZGBiomes.addBiome(ZGBiomes.OASIS_RED_OCEAN, LUSH, WET, OCEAN);
		ZGBiomes.addBiome(ZGBiomes.OASIS_REDLANDS, LUSH, MOUNTAIN);
		ZGBiomes.addBiome(ZGBiomes.OASIS_MUDSWAMP, LUSH, SWAMP, WET, HILLS);
		
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
		ZGBiomes.addBiome(ZGBiomes.EXODUS_OCEAN, WET, OCEAN);
		ZGBiomes.addBiome(ZGBiomes.EXODUS_FOREST, LUSH, WET, FOREST);
		ZGBiomes.addBiome(ZGBiomes.EXODUS_BLACK_MESA, DEAD, HOT, DRY, MOUNTAIN, WASTELAND);
		
		// Vortex
		ZGBiomes.addBiome(ZGBiomes.VORTEX_BASE, MOUNTAIN, HOT, WET);
		ZGBiomes.addBiome(ZGBiomes.VORTEX_MOUNTAINS, MOUNTAIN, HOT, DEAD, DRY);
		ZGBiomes.addBiome(ZGBiomes.VORTEX_CHARGIUM_SEA, DEAD, SPOOKY, HOT, OCEAN);
		
		// Metztli
		ZGBiomes.addBiome(ZGBiomes.METZTLI_HARRAN_PLAINS, LUSH, WASTELAND, DEAD, WET);
		ZGBiomes.addBiome(ZGBiomes.METZTLI_HARRAN_DUNES, DEAD, HOT, DRY, MOUNTAIN, WASTELAND);
		ZGBiomes.addBiome(ZGBiomes.METZTLI_HARRAN_OCEAN, DEAD, WET, OCEAN);
		ZGBiomes.addBiome(ZGBiomes.METZTLI_HARRAN_SWAMP, DEAD, LUSH, WET, SWAMP);
		ZGBiomes.addBiome(ZGBiomes.METZTLI_HARRAN_TUNDRA, DEAD, PLAINS, COLD, SNOWY);
		ZGBiomes.addBiome(ZGBiomes.METZTLI_HARRAN_SHROOMS, DEAD, LUSH, WET, SWAMP);
		ZGBiomes.addBiome(ZGBiomes.METZTLI_HARRAN_CLAY_MESA, DEAD, WASTELAND, WET, SWAMP);
		ZGBiomes.addBiome(ZGBiomes.METZTLI_HARRAN_MARSH, DEAD, WASTELAND, WET, SWAMP, JUNGLE);
		ZGBiomes.addBiome(ZGBiomes.METZTLI_HARRAN_FOREST, LUSH, PLAINS, WET, FOREST);
		ZGBiomes.addBiome(ZGBiomes.METZTLI_HARRAN_RED_DESERT, DEAD, HOT, DRY, MOUNTAIN, WASTELAND);
		ZGBiomes.addBiome(ZGBiomes.METZTLI_HARRAN_HILLS, LUSH, COLD, DRY, MOUNTAIN);
		ZGBiomes.addBiome(ZGBiomes.METZTLI_HARRAN_CHERRY_FOREST, LUSH, PLAINS, WET, FOREST);
		ZGBiomes.addBiome(ZGBiomes.METZTLI_HARRAN_FRUIT_FOREST, LUSH, PLAINS, WET, FOREST);
		
		// Astros
		ZGBiomes.addBiome(ZGBiomes.ASTROS_BASE, COLD, WET, SNOWY);
		ZGBiomes.addBiome(ZGBiomes.ASTROS_ROCKIES, COLD, WET, SNOWY, MOUNTAIN, DEAD);
		ZGBiomes.addBiome(ZGBiomes.ASTROS_GLACIERS, COLD, WET, SNOWY, MOUNTAIN, DEAD);
		
		// Centotl
		ZGBiomes.addBiome(ZGBiomes.CENTOTL_BASE, HOT, DEAD, SPOOKY, WASTELAND);
		ZGBiomes.addBiome(ZGBiomes.CENTOTL_ROCKY_MOUNTAINS, HOT, DEAD, SPOOKY, MOUNTAIN);
		ZGBiomes.addBiome(ZGBiomes.CENTOTL_ENGINEERING_PLAINS, HOT, DEAD, SPOOKY, PLAINS);
		ZGBiomes.addBiome(ZGBiomes.CENTOTL_CONSTRUCTS, HOT, DEAD, SPOOKY);
		
		// Toci
		ZGBiomes.addBiome(ZGBiomes.TOCI_BASE, HOT, DRY, MOUNTAIN, WASTELAND);
		ZGBiomes.addBiome(ZGBiomes.TOCI_DESERT, HOT, DRY, MOUNTAIN, WASTELAND);
		ZGBiomes.addBiome(ZGBiomes.TOCI_STAR_DESERT, HOT, DRY, MOUNTAIN, WASTELAND);
		ZGBiomes.addBiome(ZGBiomes.TOCI_VALLEY, PLAINS, DRY);
		ZGBiomes.addBiome(ZGBiomes.TOCI_MOUNTAINS, HOT, DRY, MOUNTAIN, WASTELAND);
		
		// Tlaloc
		ZGBiomes.addBiome(ZGBiomes.TLALOC_BASE, MOUNTAIN, COLD, DEAD, SPOOKY);
		ZGBiomes.addBiome(ZGBiomes.TLALOC_CONSTRUCTS, WASTELAND, DEAD, SPOOKY);
		ZGBiomes.addBiome(ZGBiomes.TLALOC_CHROME_FOREST, FOREST, DEAD, SPOOKY);
		ZGBiomes.addBiome(ZGBiomes.TLALOC_GOLDEN_CONSTRUCTS, MOUNTAIN, WASTELAND, DEAD, SPOOKY);
		
		// Kronos
		ZGBiomes.addBiome(ZGBiomes.KRONOS_BASE, NETHER, HOT, DEAD, DRY, SPOOKY, WASTELAND);
		ZGBiomes.addBiome(ZGBiomes.KRONOS_SOUL_DESERT, NETHER, HOT, DEAD, DRY, SPOOKY, WASTELAND);
		ZGBiomes.addBiome(ZGBiomes.KRONOS_BLACK_MOUNTAIN, NETHER, HOT, DEAD, DRY, SPOOKY, WASTELAND, MOUNTAIN);
		ZGBiomes.addBiome(ZGBiomes.KRONOS_DEATH_VALLEY, NETHER, HOT, DEAD, DRY, SPOOKY, WASTELAND);
		ZGBiomes.addBiome(ZGBiomes.KRONOS_BLAZING_HILLS, NETHER, HOT, DEAD, DRY, SPOOKY, WASTELAND);
		ZGBiomes.addBiome(ZGBiomes.KRONOS_LAVA_OCEAN, NETHER, HOT, DEAD, DRY, SPOOKY, WASTELAND, OCEAN);
		ZGBiomes.addBiome(ZGBiomes.KRONOS_MAGMA_SLIMELANDS, NETHER, HOT, DEAD, DRY, SPOOKY, WASTELAND);
		
		ZGHelper.Log("Loaded a total of " + totalBiomes + " new biomes.");
	}
	
	private static void addBiome(Biome biome, BiomeDictionary.Type... biomeType) {
		CommonZGRegisterHelper.registerBiome(biome);
		CommonZGRegisterHelper.registerBiomeType(biome, biomeType);
		totalBiomes++;
	}
	
}