/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.config;

import java.io.File;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigManagerZG {
	
	public static Configuration config;
	
	// Categories
	public static final String CTG_DIMS = "Dimensions";
	public static final String CTG_MOONS = "Moons";
	public static final String CTG_SATS = "Space_Stations";
	public static final String CTG_MISC = "Miscallenous";
	public static final String CTG_COMPAT = "Compatibility";
	public static final String CTG_COORDS = "Coordinates";
	public static final String CTG_CUSTOMS = "Customizations";
	public static final String CTG_TIERS = "Planet Tiers";
	
	// Planets (Psios)
	public static int planetEdenDimensionId;
	public static int planetZollusDimensionId;
	public static int planetKriffonDimensionId;
	public static int planetPurgotDimensionId;
	public static int moonAstrosDimensionId;
	
	// Planets (Praedyth)
	public static int planetXathiusDimensionId;
	public static int planetOasisDimensionId;
	public static int planetXantheonDimensionId;
	public static int planetCandoraDimensionId;
	public static int planetAtheonDimensionId;
	
	// Planets (Sol-2)
	public static int planetExodusDimensionId;
	public static int planetPerditaDimensionId;
	public static int planetAltumDimensionId;
	public static int planetCaligroDimensionId;
	
	// Planets (Pantheon)
	public static int planetVortexDimensionId;
	public static int planetMetztliDimensionId;
	public static int planetCentotlDimensionId;
	public static int planetTociDimensionId;
	public static int planetTlalocDimensionId;
	
	// Planets (Olympus)
	public static int planetAresDimensionId;
	public static int planetPrometheusDimensionId;
	public static int planetIcarusDimensionId;
	public static int planetKronosDimensionId;
	
	// Planets (Asgard)
	public static int planetAsgardDimensionId;
	public static int planetMavethDimensionId;
	
	// Planets (Vega)
	public static int planetReachDimensionId;
	public static int planetMeridianDimensionId;
	public static int planetRequiemDimensionId;
	
	// Planets (Nova)
	public static int planetPrimorDimensionId;
	
	// Number of Space Stations to generate
	public static int spaceStationGenAmount;
	
	// Whether or not Lore Blocks can spawn extra
	public static boolean canExtraLoreSpawn;
	
	// Space Station IDs
	public static int spaceStationZollusId;
	public static int spaceStationZollusStaticId;
	
	public static int spaceStationKriffonId;
	public static int spaceStationKriffonStaticId;
	
	public static int spaceStationPurgotId;
	public static int spaceStationPurgotStaticId;
	
	public static int spaceStationEdenId;
	public static int spaceStationEdenStaticId;
	
	public static int spaceStationXathiusId;
	public static int spaceStationXathiusStaticId;
	
	public static int spaceStationOasisId;
	public static int spaceStationOasisStaticId;
	
	public static int spaceStationXantheonId;
	public static int spaceStationXantheonStaticId;
	
	public static int spaceStationCandoraId;
	public static int spaceStationCandoraStaticId;
	
	public static int spaceStationAtheonId;
	public static int spaceStationAtheonStaticId;
	
	public static int spaceStationPerditaId;
	public static int spaceStationPerditaStaticId;
	
	public static int spaceStationAltumId;
	public static int spaceStationAltumStaticId;
	
	public static int spaceStationCaligroId;
	public static int spaceStationCaligroStaticId;
	
	public static int spaceStationExodusId;
	public static int spaceStationExodusStaticId;
	
	public static int spaceStationVortexId;
	public static int spaceStationVortexStaticId;
	
	public static int spaceStationMetztliId;
	public static int spaceStationMetztliStaticId;
	
	public static int spaceStationCentotlId;
	public static int spaceStationCentotlStaticId;
	
	public static int spaceStationTociId;
	public static int spaceStationTociStaticId;
	
	public static int spaceStationTlalocId;
	public static int spaceStationTlalocStaticId;
	
	public static int spaceStationKronosId;
	public static int spaceStationKronosStaticId;
	
	public static int spaceStationMavethId;
	public static int spaceStationMavethStaticId;
	
	// Misc
	public static boolean canEarthAnimalsSpawnOnEden;
	public static boolean disableStarGates;
	public static boolean temperatureType;
	public static boolean hideUnusedStarSystems;
	public static boolean enableMegaCreeperGriefing;
	public static boolean changeContributorNames;
	public static boolean enableChestValidation;
	public static boolean spawnGalaxyKnight;
	public static boolean enableExtremeMode;
	public static boolean enableQuietVillagers;
	public static boolean enableMutantNameTags;
	public static boolean enableStackChanges;
	public static boolean enableArmorEffects;
	public static boolean enableSweetFoodPotionEffects;
	
	// Compat
	public static boolean shouldOasisUseLiquidRedstone;
	public static boolean enableExtraPulverizerOutput;
	public static boolean fueltoniumIsUranium;
	public static boolean registerCobaltOreDict;
	public static boolean registerZincOreDict;
	public static boolean enablePlanetProgressionsCompat;
	public static boolean useTConRadium;
	public static boolean useTConCorruption;
	public static boolean enableRadianceFlying;
	public static boolean enableStepHeight;
	public static boolean enableExtraPlanetsCompat;
	public static boolean enableExtremeReactorsCompat;
	
	// Customizations
	public static int kriffonLavaLakesPerChunk;
	public static int kriffonLavaLakesGenChance;
	public static int zollusIceSpikesPerChunk;
	public static int zollusIceSpikesGenChance;
	public static boolean planetUnreachableAll;
	public static boolean shouldExplosiveBlocksExplodeOtherBlocks;
	public static int outpostGenChance;
	public static int windBlowChance;
	public static boolean enableWindBlowEvent;
	public static boolean enableAlienVillagerSpawn;
	public static int alienVillagerMinSpawnRate;
	public static int alienVillagerMaxSpawnRate;
	public static boolean enableAlienVillagerMutation;
	public static int alienVillagerSpawnChance;
	public static boolean enableChargiumLakesOnVortex;
	public static boolean enableWandererSpawn;
	public static boolean enableWandererHouses;
	public static boolean disableVexbotRadiolaria;
	public static boolean enableExplosiveOres;
	public static boolean enablePotionEffectOres;
	public static boolean enableOilLakes;
	public static boolean showCompanionNameTags;
	public static boolean enableMineshaftsOnKronos;
	
	/////////////////////////////////////////////////
	public static double meteorGenZollus;
	public static double meteorGenKriffon;
	public static double meteorGenPurgot;
	public static double meteorGenEden;
	public static double meteorGenXathius;
	public static double meteorGenOasis;
	public static double meteorGenXantheon;
	public static double meteorGenCandora;
	public static double meteorGenAtheon;
	public static double meteorGenExodus;
	public static double meteorGenPerdita;
	public static double meteorGenAltum;
	public static double meteorGenCaligro;
	public static double meteorGenVortex;
	public static double meteorGenMetztli;
	public static double meteorGenCentotl;
	public static double meteorGenToci;
	public static double meteorGenTlaloc;
	public static double meteorGenKronos;
	public static double meteorGenMaveth;
	////////////////////////////////////////////////
	
	// Set as unreachable with rockets by planet
	public static boolean planetUnreachableZollus;
	public static boolean planetUnreachableKriffon;
	public static boolean planetUnreachablePurgot;
	public static boolean planetUnreachableEden;
	public static boolean planetUnreachableXathius;
	public static boolean planetUnreachableOasis;
	public static boolean planetUnreachableXantheon;
	public static boolean planetUnreachableCandora;
	public static boolean planetUnreachableAtheon;
	public static boolean planetUnreachablePerdita;
	public static boolean planetUnreachableAltum;
	public static boolean planetUnreachableCaligro;
	public static boolean planetUnreachableExodus;
	public static boolean planetUnreachableVortex;
	public static boolean planetUnreachableMetztli;
	public static boolean planetUnreachableCentotl;
	public static boolean planetUnreachableToci;
	public static boolean planetUnreachableTlaloc;
	public static boolean planetUnreachableKronos;
	public static boolean planetUnreachableMaveth;
	////////////////////////////////////////////////
	
	// Max Health Customization
	public static double maxHealthAllowed;
	public static double maxHealthIncreasedBy;
	
	// Set crater spawn chance for affected worlds
	public static int craterSpawnChance;
	
	// Coords (Psios)
	public static float psiosXOffset;
	public static float psiosYOffset;
	public static float psiosZOffset;
	
	// Coords (Praedyth)
	public static float praedythXOffset;
	public static float praedythYOffset;
	public static float praedythZOffset;
	
	// Coords (Sol-2)
	public static float sol2XOffset;
	public static float sol2YOffset;
	public static float sol2ZOffset;
	
	// Coords (Pantheon)
	public static float pantheonXOffset;
	public static float pantheonYOffset;
	public static float pantheonZOffset;
	
	// Coords (Olympus)
	public static float olympusXOffset;
	public static float olympusYOffset;
	public static float olympusZOffset;
	
	// Coords (Asgard)
	public static float asgardXOffset;
	public static float asgardYOffset;
	public static float asgardZOffset;
	
	// Coords (Vega)
	public static float vegaXOffset;
	public static float vegaYOffset;
	public static float vegaZOffset;
	
	// Coords (Nova)
	public static float novaXOffset;
	public static float novaYOffset;
	public static float novaZOffset;
	
	// Planet Tiers (Psios-6)
	public static int planetZollusTier;
	public static int planetKriffonTier;
	public static int planetPurgotTier;
	public static int planetEdenTier;
	
	// Planet Tiers (Praedyth)
	public static int planetXathiusTier;
	public static int planetOasisTier;
	public static int planetXantheonTier;
	public static int planetCandoraTier;
	public static int planetAtheonTier;
	
	// Planet Tiers (Sol-2)
	public static int planetPerditaTier;
	public static int planetAltumTier;
	public static int planetCaligroTier;
	public static int planetExodusTier;
	
	// Planet Tiers (Pantheon)
	public static int planetVortexTier;
	public static int planetMetztliTier;
	public static int planetCentotlTier;
	public static int planetTociTier;
	public static int planetTlalocTier;
	
	// Planet Tiers (Olympus)
	public static int planetKronosTier;
	// TODO
	
	// Planet Tiers (Asgard)
	public static int planetMavethTier;
	// TODO
	
	public static void init(FMLPreInitializationEvent event) {
		config = new Configuration(new File(event.getModConfigurationDirectory().getAbsolutePath() + "/ZollernGalaxy/core.cfg"));
		config.load();
		
		// Planets (Psios)
		planetEdenDimensionId = config.get(CTG_DIMS, "Planet Eden Dimension ID", -7996, "Dimension ID for planet Eden. (default: -7996)").getInt();
		planetZollusDimensionId = config.get(CTG_DIMS, "Planet Zollus Dimension ID", -7982, "Dimension ID for planet Zollus. (default: -7982)").getInt();
		planetKriffonDimensionId = config.get(CTG_DIMS, "Planet Kriffon Dimension ID", -7994, "Dimension ID for planet Kriffon. (default: -7994)").getInt();
		planetPurgotDimensionId = config.get(CTG_DIMS, "Planet Purgot Dimension ID", -7988, "Dimension ID for planet Purgot. (default: -7988)").getInt();
		
		// Moons (Psios -> Eden -> Astros)
		moonAstrosDimensionId = config.get(CTG_MOONS, "Moon Astros Dimension ID", -7981, "Dimension ID for Eden's moon, Astros. (default: -7981)").getInt();
		
		// Planets (Praedyth)
		planetXathiusDimensionId = config.get(CTG_DIMS, "Planet Xathius Dimension ID", -7983, "Dimension ID for planet Xathius. (default: -7983)").getInt();
		planetOasisDimensionId = config.get(CTG_DIMS, "Planet Oasis Dimension ID", -7990, "Dimension ID for planet Oasis. (default: -7990)").getInt();
		planetXantheonDimensionId = config.get(CTG_DIMS, "Planet Xantheon Dimension ID", -7984, "Dimension ID for planet Xantheon. (default: -7984)").getInt();
		planetCandoraDimensionId = config.get(CTG_DIMS, "Planet Candora Dimension ID", -7777, "Dimension ID for planet Candora. (default: -7777)").getInt();
		planetAtheonDimensionId = config.get(CTG_DIMS, "Planet Atheon Dimension ID", -7998, "Dimension ID for planet Atheon. (default: -7998)").getInt();
		
		// Planets (Sol-2)
		planetExodusDimensionId = config.get(CTG_DIMS, "Planet Exodus Dimension ID", -7980, "Dimension ID for planet Exodus. (default: -7980)").getInt();
		planetPerditaDimensionId = config.get(CTG_DIMS, "Planet Perdita Dimension ID", -7979, "Dimension ID for planet Perdita. (default: -7979)").getInt();
		planetAltumDimensionId = config.get(CTG_DIMS, "Planet Altum Dimension ID", -7878, "Dimension ID for planet Altum. (default: -7878)").getInt();
		planetCaligroDimensionId = config.get(CTG_DIMS, "Planet Caligro Dimension ID", -7877, "Dimension ID for planet Caligro. (default: -7877)").getInt();
		
		// Planets (Pantheon)
		planetVortexDimensionId = config.get(CTG_DIMS, "Planet Vortex Dimension ID", -7675, "Dimension ID for planet Vortex. (default: -7675)").getInt();
		planetMetztliDimensionId = config.get(CTG_DIMS, "Planet Metztli Dimension ID", -7991, "Dimension ID for planet Metztli. (default: -7991)").getInt();
		planetCentotlDimensionId = config.get(CTG_DIMS, "Planet Centotl Dimension ID", -5214, "Dimension ID for planet Centotl. (default: -5214)").getInt();
		planetTociDimensionId = config.get(CTG_DIMS, "Planet Toci Dimension ID", -7985, "Dimension ID for planet Toci. (default: -7985)").getInt();
		planetTlalocDimensionId = config.get(CTG_DIMS, "Planet Tlaloc Dimension ID", -7986, "Dimension ID for planet Tlaloc. (default: -7986)").getInt();
		
		// Planets (Olympus)
		planetAresDimensionId = config.get(CTG_DIMS, "Planet Ares Dimension ID", -8000, "Dimension ID for planet Ares. (default: -8000)").getInt();
		planetPrometheusDimensionId = config.get(CTG_DIMS, "Planet Prometheus Dimension ID", -7281, "Dimension ID for planet Prometheus. (default: -7281)").getInt();
		planetIcarusDimensionId = config.get(CTG_DIMS, "Planet Icarus Dimension ID", -7995, "Dimension ID for planet Icarus. (default: -7995)").getInt();
		planetKronosDimensionId = config.get(CTG_DIMS, "Planet Kronos Dimension ID", -7993, "Dimension ID for planet Kronos. (default: -7993)").getInt();
		
		// Planets (Asgard)
		planetAsgardDimensionId = config.get(CTG_DIMS, "Planet Asgard Dimension ID", -7999, "Dimension ID for planet Asgard. (default: -7999)").getInt();
		planetMavethDimensionId = config.get(CTG_DIMS, "Planet Maveth Dimension ID", -4552, "Dimension ID for planet Maveth. (default: -4552)").getInt();
		
		// Planets (Vega)
		planetMeridianDimensionId = config.get(CTG_DIMS, "Planet Meridian Dimension ID", -7992, "Dimension ID for planet Meridian. (default: -7992)").getInt();
		planetReachDimensionId = config.get(CTG_DIMS, "Planet Reach Dimension ID", -2552, "Dimension ID for planet Reach. (default: -2552)").getInt();
		planetRequiemDimensionId = config.get(CTG_DIMS, "Planet Requiem Dimension ID", -7987, "Dimension ID for planet Requiem. (default: -7987)").getInt();
		
		// Planets (Nova)
		planetPrimorDimensionId = config.get(CTG_DIMS, "Planet Primor Dimension ID", -7989, "Dimension ID for planet Primor. (default: -7989)").getInt();
		
		// Number of space stations to generate
		spaceStationGenAmount = config.get(CTG_SATS, "Space Station Generation Count", 1, "How many Space Stations should generate in orbit (between 1 to 5)? (default: 1)").getInt();
		spaceStationGenAmount = (spaceStationGenAmount <= 5) ? spaceStationGenAmount : 5;
		spaceStationGenAmount = (spaceStationGenAmount >= 1) ? spaceStationGenAmount : 1;
		
		// Whether or not Lore Blocks can spawn extra
		canExtraLoreSpawn = config.get(CTG_SATS, "Spawn Extra Lore Blocks", true, "Can additional Lore Blocks spawn? (default: true)").getBoolean();
		
		// Space Stations (Psios-6)
		
		// Zollus
		spaceStationZollusId = config.get(CTG_SATS, "Zollus Space Station ID", -6000, "Dimension ID for Zollus Space Station. (default: -6000)").getInt();
		spaceStationZollusStaticId = config.get(CTG_SATS, "Zollus Space Station Static ID", -6001, "Dimension static ID for Zollus Space Station. (default: -6001)").getInt();
		
		// Kriffon
		spaceStationKriffonId = config.get(CTG_SATS, "Kriffon Space Station ID", -6002, "Dimension ID for Kriffon Space Station. (default: -6002)").getInt();
		spaceStationKriffonStaticId = config.get(CTG_SATS, "Kriffon Space Station Static ID", -6003, "Dimension static ID for Kriffon Space Station. (default: -6003)").getInt();
		
		// Purgot
		spaceStationPurgotId = config.get(CTG_SATS, "Purgot Space Station ID", -6004, "Dimension ID for Purgot Space Station. (default: -6004)").getInt();
		spaceStationPurgotStaticId = config.get(CTG_SATS, "Purgot Space Station Static ID", -6005, "Dimension static ID for Purgot Space Station. (default: -6005)").getInt();
		
		// Eden
		spaceStationEdenId = config.get(CTG_SATS, "Eden Space Station ID", -6006, "Dimension ID for Eden Space Station. (default: -6006)").getInt();
		spaceStationEdenStaticId = config.get(CTG_SATS, "Eden Space Station Static ID", -6007, "Dimension static ID for Eden Space Station. (default: -6007)").getInt();
		
		// Space Stations (Praedyth)
		// Xathius
		spaceStationXathiusId = config.get(CTG_SATS, "Xathius Space Station ID", -6008, "Dimension ID for Xathius Space Station. (default: -6008)").getInt();
		spaceStationXathiusStaticId = config.get(CTG_SATS, "Xathius Space Station Static ID", -6009, "Dimension static ID for Xathius Space Station. (default: -6009)").getInt();
		
		// Oasis
		spaceStationOasisId = config.get(CTG_SATS, "Oasis Space Station ID", -6010, "Dimension ID for Oasis Space Station. (default: -6010)").getInt();
		spaceStationOasisStaticId = config.get(CTG_SATS, "Oasis Space Station Static ID", -6011, "Dimension static ID for Oasis Space Station. (default: -6011)").getInt();
		
		// Xantheon
		spaceStationXantheonId = config.get(CTG_SATS, "Xantheon Space Station ID", -6012, "Dimension ID for Xantheon Space Station. (default: -6012)").getInt();
		spaceStationXantheonStaticId = config.get(CTG_SATS, "Xantheon Space Station Static Id", -6013, "Dimension static ID for Xantheon Space Station. (default: -6013)").getInt();
		
		// Candora
		spaceStationCandoraId = config.get(CTG_SATS, "Candora Space Station ID", -6014, "Dimension ID for Candora Space Station. (default: -6014)").getInt();
		spaceStationCandoraStaticId = config.get(CTG_SATS, "Candora Space Station Static Id", -6015, "Dimension static ID for Candora Space Station. (default: -6015)").getInt();
		
		// Atheon
		spaceStationAtheonId = config.get(CTG_SATS, "Atheon Space Station ID", -6016, "Dimension ID for Atheon Space Station. (default: -6016)").getInt();
		spaceStationAtheonStaticId = config.get(CTG_SATS, "Atheon Space Station Static ID", -6017, "Dimension static ID for Atheon Space Station. (default: -6017)").getInt();
		
		// Space Stations (Sol-2)
		// Perdita
		spaceStationPerditaId = config.get(CTG_SATS, "Perdita Space Station ID", -6018, "Dimension ID for Perdita Space Station. (default: -6018)").getInt();
		spaceStationPerditaStaticId = config.get(CTG_SATS, "Perdita Space Station Static ID", -6019, "Dimension static ID for Perdita Space Station. (default: -6019)").getInt();
		
		// Altum
		spaceStationAltumId = config.get(CTG_SATS, "Altum Space Station ID", -6020, "Dimension ID for Altum Space Station. (default: -6020)").getInt();
		spaceStationAltumStaticId = config.get(CTG_SATS, "Altum Space Station Static ID", -6021, "Dimension static ID for Altum Space Station. (default: -6021)").getInt();
		
		// Caligro
		spaceStationCaligroId = config.get(CTG_SATS, "Caligro Space Station ID", -6022, "Dimension ID for Caligro Space Station. (default: -6022)").getInt();
		spaceStationCaligroStaticId = config.get(CTG_SATS, "Caligro Space Station Static ID", -6023, "Dimension static ID for Caligro Space Station. (default: -6023)").getInt();
		
		// Exodus
		spaceStationExodusId = config.get(CTG_SATS, "Exodus Space Station ID", -6024, "Dimension ID for Exodus Space Station. (default: -6024)").getInt();
		spaceStationExodusStaticId = config.get(CTG_SATS, "Exodus Space Station Static ID", -6025, "Dimension static ID for Exodus Space Station. (default: -6025)").getInt();
		
		// Space Stations (Pantheon)
		// Vortex
		spaceStationVortexId = config.get(CTG_SATS, "Vortex Space Station ID", -6026, "Dimension ID for Vortex Space Station. (default: -6026)").getInt();
		spaceStationVortexStaticId = config.get(CTG_SATS, "Vortex Space Station Static ID", -6027, "Dimension static ID for Vortex Space Station. (default: -6027)").getInt();
		
		// Metztli
		spaceStationMetztliId = config.get(CTG_SATS, "Metztli Space Station ID", -6028, "Dimension ID for Metztli Space Station. (default: -6028)").getInt();
		spaceStationMetztliStaticId = config.get(CTG_SATS, "Metztli Space Station Static ID", -6029, "Dimension static ID for Metztli Space Station. (default: -6029)").getInt();
		
		// Centotl
		spaceStationCentotlId = config.get(CTG_SATS, "Centotl Space Station ID", -6030, "Dimension ID for Centotl Space Station. (default: -6030)").getInt();
		spaceStationCentotlStaticId = config.get(CTG_SATS, "Centotl Space Station Static ID", -6031, "Dimension static ID for Centotl Space Station. (default: -6031)").getInt();
		
		// Toci
		spaceStationTociId = config.get(CTG_SATS, "Toci Space Station ID", -6032, "Dimension ID for Toci Space Station. (default: -6032)").getInt();
		spaceStationTociStaticId = config.get(CTG_SATS, "Toci Space Station Static ID", -6033, "Dimension static ID for Toci Space Station. (default: -6033)").getInt();
		
		// Tlaloc
		spaceStationTlalocId = config.get(CTG_SATS, "Tlaloc Space Station ID", -6034, "Dimension ID for Tlaloc Space Station. (default: -6034)").getInt();
		spaceStationTlalocStaticId = config.get(CTG_SATS, "Tlaloc Space Station Static ID", -6035, "Dimension static ID for Tlaloc Space Station. (default: -6035)").getInt();
		
		// Kronos
		spaceStationKronosId = config.get(CTG_SATS, "Kronos Space Station ID", -6036, "Dimension ID for Kronos Space Station. (default: -6036)").getInt();
		spaceStationKronosStaticId = config.get(CTG_SATS, "Kronos Space Station Static ID", -6037, "Dimension static ID for Kronos Space Station. (default: -6037)").getInt();
		
		// Maveth
		spaceStationMavethId = config.get(CTG_SATS, "Maveth Space Station ID", -6038, "Dimension ID for Maveth Space Station. (default: -6038)").getInt();
		spaceStationMavethStaticId = config.get(CTG_SATS, "Maveth Space Station Static ID", -6039, "Dimension static ID for Maveth Space Station. (default: -6039)").getInt();
		
		// Misc (Can Earth animals spawn on Eden?)
		canEarthAnimalsSpawnOnEden = config.get(CTG_MISC, "Earth Animals Spawn On Eden", true, "Should Earth animals spawn on Eden? (default: true)").getBoolean();
		
		// Misc (Should Star Gates be disabled?)
		disableStarGates = config.get(CTG_MISC, "Disable use of Star Gates", false, "Set this to true if you want to ONLY access Zollern Galaxy planets using rockets. " + "WARNING: will not work without another add-on this way! (default: false)").getBoolean();
		
		hideUnusedStarSystems = config.get(CTG_MISC, "Hide Stars with no Planets", true, "Enable to see Stars that have no Planets yet. (default: true)").getBoolean();
		
		// Misc (Should Mega Creeper explosions harm terrain?)
		enableMegaCreeperGriefing = config.get(CTG_MISC, "Enable Mega Creeper Griefing", true, "Set to false if you don't want Mega Creepers to destroy terrain. (default: true)").getBoolean();
		
		// Misc (Tempratures shown in fahrenheit or celsius?)
		temperatureType = config.get(CTG_MISC, "[HUD DISPLAY] Temperature Type: Use Celsius instead of Fahrenheit", false, "Set this to true to show temperature in Celsius (default: false).").getBoolean();
		
		// Whether or not to change contributor's in-game names
		changeContributorNames = config.get(CTG_MISC, "Contributor name change", true, "Whether or not to change contributor in-game names to more recognized formats (default: true)").getBoolean();
		
		// Whether or not to allow Spawning of Galaxy Knights.
		spawnGalaxyKnight = config.get(CTG_MISC, "Spawn Galaxy Knight", true, "Whether or not to allow Grey Aliens to summon Galaxy Knights when attacked (default: true)").getBoolean();
		
		// Make sure chests are on the ground or not. (ExistingEevee)
		enableChestValidation = config.get(CTG_MISC, "Chest Validation", true, "Whether or not to validate chest spawns. " + "Disable if chest generation is causing a crash. (default: true)").getBoolean();
		
		// Should Extreme Mode be enabled? Significantly increases the mod's difficulty.
		enableExtremeMode = config.get(CTG_MISC, "Enable Extreme Mode", false, "Toggle Extreme mode. " + "WARNING: This will SIGNIFICANTLY increase the mod's difficulty. (default: false)").getBoolean();
		
		// Make ZG's Alien Villagers stop going "HNNGH!!"
		enableQuietVillagers = config.get(CTG_MISC, "Enable Quiet Alien Villagers", false, "Enable to shut up at least the Zollern Galaxy Alien Villagers. NOTE: Does NOT affect Galacticraft's Alien Villagers. (default: false)").getBoolean();
		
		// Enable/Disable showing of mutant name tags
		enableMutantNameTags = config.get(CTG_MISC, "Enable Mutant Name Tags", true, "Should Mutant Zombies show their name tags? (default: true)").getBoolean();
		
		// Enable stack increase changes
		enableStackChanges = config.get(CTG_MISC, "Enable Item Stack Increase Changes", true, "Increases stack height from 16 to 64 for some items when activated. (default: true)").getBoolean();
		
		// Enable armor to give effects when a full set is worn
		enableArmorEffects = config.get(CTG_MISC, "Enable Armor Effects", true, "Enable armor sets giving effects when a full set is worn. (default: true)").getBoolean();
		
		// Enable Sweet Food potion effects
		enableSweetFoodPotionEffects = config.get(CTG_MISC, "Enable Sweet Food Potion Effects", true, "Enable sweet foods from this mod to give Potion Effects. (default: true)").getBoolean();
		
		// Compat (Whether or not to use Thermal Foundation's Detabilized Redstone for the Red Sea
		// in Oasis)
		shouldOasisUseLiquidRedstone = config.get(CTG_COMPAT, "Oasis uses Thermal Foundation's Destabilized Redstone", true, "Whether or not Oasis should use Detabilized Redstone for its Red Sea biome. (default: true)").getBoolean();
		
		// Compat (Whether or not Thermal Foundation Pulverizers should give extra (4) instead of
		// normal (2))
		enableExtraPulverizerOutput = config.get(CTG_COMPAT, "Enable extra Pulverizer Output", true, "Whether or not Zollern Galaxy ores give extra dust from Thermal Foundation's Pulverizers. " + "Disable if it causes compatibility issues (default: true).").getBoolean();
		
		// Compat (Should Fueltonium register as Uranium?)
		fueltoniumIsUranium = config.get(CTG_COMPAT, "Fueltonium counts as Uranium", true, "Should Fueltonium register as Uranium? (default: true)").getBoolean();
		
		// Compat (Should Cobalt register in the Ore Dictionary?)
		registerCobaltOreDict = config.get(CTG_COMPAT, "Register Cobalt in Ore Dictionary", true, "Set this to false if there are any problems " + " with mods like Tinker's Construct. (default: true)").getBoolean();
		
		// Compat (Should Zinc register in the Ore Dictionary?)
		registerZincOreDict = config.get(CTG_COMPAT, "Register Zinc in Ore Dictionary", true, "Set this to false if there are any problems " + " with other mods. (default: true)").getBoolean();
		
		// Compat (Should intergration with Planet Progressions be enabled?
		enablePlanetProgressionsCompat = config.get(CTG_COMPAT, "Enable Planet Progressions compatibility", true, "If Planet Progressions is installed, you will need to discover the Planet or Moon " + " before you can travel to it via Star Gates. Set this to false to disable that. (default: true)").getBoolean();
		
		// Compat (Enable Radium Material for Tinker's Construct
		useTConRadium = config.get(CTG_COMPAT, "[TCONSTRUCT] Enable Radium Material", true, "Set to false to disable (will cause issues with More TCon if true). (default: true)").getBoolean();
		
		// Compat (Enable Corruption Material for Tinker's Construct
		useTConCorruption = config.get(CTG_COMPAT, "[TCONSTRUCT] Enable Corruption Material", true, "Set to false to disable. (default: true)").getBoolean();
		
		// Compat (Should flying be enabled and then disabled when applying and unapplying Radiance
		// armor?
		enableRadianceFlying = config.get(CTG_COMPAT, "Enable Radiance Flying In Survival", true, "Toggle whether a full set of Radiance armor allows the Player to fly in Survival. " + "Set to false to disable if this causes mod conflicts, compromises the safety of your server, " + "or if you just hate fun. (default: true)").getBoolean();
		
		// Compat (Should increased step height be enabled when using certain armor?)
		enableStepHeight = config.get(CTG_COMPAT, "Enable Increased Step Height", true, "Toggle whether Zollernium armor increases step height. Disable if there are compatability issues. (default: true)").getBoolean();
		
		// Compat (Extra Planets)
		enableExtraPlanetsCompat = config.get(CTG_COMPAT, "Enable Extra Planets Compatibility", true, "If enabled, these mods will work together. Disable if needed or desired. (default: true)").getBoolean();
		
		// Compat
		enableExtremeReactorsCompat = config.get(CTG_COMPAT, "Enable Extreme Reactors Compatibility", true, "If enabled, some of this mod's metals and fluids can be used in Turbines and Reactors. (default: true)").getBoolean();
		
		// Customization Options
		kriffonLavaLakesPerChunk = config.get(CTG_CUSTOMS, "Kriffon Lava Lakes Per Chunk", 4, "The amount of Lava Lakes to generate per chunk on planet Kriffon. (default: 4)").getInt();
		kriffonLavaLakesGenChance = config.get(CTG_CUSTOMS, "Kriffon Lava Lakes Gen Percentage", 25, "The chance (out of 100) for a lava lake to generate on planet Kriffon. (default: 25)").getInt();
		zollusIceSpikesPerChunk = config.get(CTG_CUSTOMS, "Zollus Ice Spikes Per Chunk", 2, "The amount of Ice Spikes to generate on " + "Zollus per chunk. (default: 2)").getInt();
		zollusIceSpikesGenChance = config.get(CTG_CUSTOMS, "Zollus Ice Spikes Gen Percentage", 42, "The chance (out of 100) for Ice Spikes to generate on planet Zollus. (default: 42)").getInt();
		outpostGenChance = config.get(CTG_CUSTOMS, "Outpost Gen Percentage", 5, "The chance (out of 100) for Outpost buildings to generate on planets. (default: 5)").getInt();
		windBlowChance = config.get(CTG_CUSTOMS, "Wind Blow Chance", 25, "Percentage chance of how often storm wind blows. (default: 25)").getInt();
		enableWindBlowEvent = config.get(CTG_CUSTOMS, "Enable Wind Blowing Event", true, "Allow the wind blowing event to move Players around on Vortex (default: true). ").getBoolean();
		enableAlienVillagerSpawn = config.get(CTG_CUSTOMS, "Enable Alien Villager Spawn", true, "Control whether Alien Villagers can spawn randomly outside of Alien Villages; disable if they're causing lag or being annoying. (default: true). ").getBoolean();
		alienVillagerMinSpawnRate = config.get(CTG_CUSTOMS, "Alien Villager Spawn Rate Min", 0, "Min rate for Alien Villagers to spawn naturally. (default: 0)").getInt();
		alienVillagerMaxSpawnRate = config.get(CTG_CUSTOMS, "Alien Villager Spawn Rate Max", 1, "Max rate for Alien Villagers to spawn naturally. (default: 1)").getInt();
		enableAlienVillagerMutation = config.get(CTG_CUSTOMS, "Enable Alien Villagers To Mutate", true, "Set whether or not Alien Villagers can mutate into Zombies on Metztli (default: true). ").getBoolean();
		alienVillagerSpawnChance = config.get(CTG_CUSTOMS, "Alien Villager Ambient Spawn Chance", 1, "Spawn chance of all Alien Villager types, affects all planets. (default: 1)").getInt();
		enableChargiumLakesOnVortex = config.get(CTG_CUSTOMS, "Enable Chargium Lakes on Vortex", true, "Set to false to make Chargium Lakes not spawn on Vortex (default: true). ").getBoolean();
		enableWandererSpawn = config.get(CTG_CUSTOMS, "Enable Alien Wanderer Spawn", true, "Set to false to disable Wanderer spawn (default: true). ").getBoolean();
		enableWandererHouses = config.get(CTG_CUSTOMS, "Enable Alien Wanderer Houses", false, "Set to true to enable Wanderers to spawn houses (default: false). ").getBoolean();
		disableVexbotRadiolaria = config.get(CTG_CUSTOMS, "Disable Vexbots spawning Radiolaria (White Lava) on death.", false, "Set to true to prevent Vexbots from spawning White Lava blocks on death (default: false). ").getBoolean();
		enableExplosiveOres = config.get(CTG_CUSTOMS, "Enable Explosive Ores", true, "Disable to prevent ores from exploding. (default: true). ").getBoolean();
		enablePotionEffectOres = config.get(CTG_CUSTOMS, "Enable Potion Effect Ores", true, "Disable to prevent ores from giving potion effects. (default: true). ").getBoolean();
		enableOilLakes = config.get(CTG_CUSTOMS, "Enable Oil Lake Generation on ZG Planets", true, "Enables the generation of lakes of Galacticraft's Crude Oil to generate on planets and moons from this mod. (default: true). ").getBoolean();
		showCompanionNameTags = config.get(CTG_CUSTOMS, "Show Companion Name Tags", true, "Shows the name tag of companion mobs. (default: true). ").getBoolean();
		enableMineshaftsOnKronos = config.get(CTG_CUSTOMS, "Enable Kronos Mineshafts", false, "Enable to allow Mineshafts to spawn on Kronos. (default: false). ").getBoolean();
		
		//
		//
		meteorGenZollus = config.get(CTG_CUSTOMS, "Meteor Gen Zollus", 2, "Percentage chance for meteors to fall. (default: 2)").getInt();
		meteorGenKriffon = config.get(CTG_CUSTOMS, "Meteor Gen Kriffon", 8, "Percentage chance for meteors to fall. (default: 8)").getInt();
		meteorGenPurgot = config.get(CTG_CUSTOMS, "Meteor Gen Purgot", 2, "Percentage chance for meteors to fall. (default: 2)").getInt();
		meteorGenEden = config.get(CTG_CUSTOMS, "Meteor Gen Eden", 10, "Percentage chance for meteors to fall. (default: 10)").getInt();
		meteorGenXathius = config.get(CTG_CUSTOMS, "Meteor Gen Xathius", 5, "Percentage chance for meteors to fall. (default: 5)").getInt();
		meteorGenOasis = config.get(CTG_CUSTOMS, "Meteor Gen Oasis", 15, "Percentage chance for meteors to fall. (default: 15)").getInt();
		meteorGenXantheon = config.get(CTG_CUSTOMS, "Meteor Gen Xantheon", 4, "Percentage chance for meteors to fall. (default: 4)").getInt();
		meteorGenCandora = config.get(CTG_CUSTOMS, "Meteor Gen Candora", 0, "Percentage chance for meteors to fall. (default: 0)").getInt();
		meteorGenAtheon = config.get(CTG_CUSTOMS, "Meteor Gen Atheon", 2, "Percentage chance for meteors to fall. (default: 2)").getInt();
		meteorGenExodus = config.get(CTG_CUSTOMS, "Meteor Gen Exodus", 15, "Percentage chance for meteors to fall. (default: 15)").getInt();
		meteorGenPerdita = config.get(CTG_CUSTOMS, "Meteor Gen Perdita", 15, "Percentage chance for meteors to fall. (default: 15)").getInt();
		meteorGenAltum = config.get(CTG_CUSTOMS, "Meteor Gen Altum", 4, "Percentage chance for meteors to fall. (default: 4)").getInt();
		meteorGenCaligro = config.get(CTG_CUSTOMS, "Meteor Gen Caligro", 0, "Percentage chance for meteors to fall. (default: 0)").getInt();
		meteorGenVortex = config.get(CTG_CUSTOMS, "Meteor Gen Vortex", 15, "Percentage chance for meteors to fall. (default: 15)").getInt();
		meteorGenMetztli = config.get(CTG_CUSTOMS, "Meteor Gen Metztli", 15, "Percentage chance for meteors to fall. (default: 15)").getInt();
		meteorGenCentotl = config.get(CTG_CUSTOMS, "Meteor Gen Centotl", 30, "Percentage chance for meteors to fall. (default: 15)").getInt();
		meteorGenToci = config.get(CTG_CUSTOMS, "Meteor Gen Toci", 30, "Percentage chance for meteors to fall. (default: 30)").getInt();
		meteorGenTlaloc = config.get(CTG_CUSTOMS, "Meteor Gen Tlaloc", 0, "Percentage chance for meteors to fall. (default: 0)").getInt();
		meteorGenKronos = config.get(CTG_CUSTOMS, "Meteor Gen Kronos", 0, "Percentage chance co meteors to fall. (default: 0)").getInt();
		meteorGenMaveth = config.get(CTG_CUSTOMS, "Meteor Gen Maveth", 1, "Percentage chance co meteors to fall. (default: 1)").getInt();
		//
		//
		
		// Control unreachable planets (by rockets).
		planetUnreachableAll = config.get(CTG_CUSTOMS, "Disable Rockets For All Planets", false, "Setting this to true disallows rocket travel to all Zollern Galaxy planets. " + "Note that when this is enabled, it will override the planet-by-planet settings, " + "with the exception of Zollus. (default: false)").getBoolean();
		
		// Control whether or not explosive blocks should cause other explosive blocks to explode in
		// a chain reaction
		shouldExplosiveBlocksExplodeOtherBlocks = config.get(CTG_CUSTOMS, "Explosive Blocks Cause Chain Reaction", true, "Disable this to prevent explosive blocks blowing up other explosive blocks when broken, " + "which can cause a chain reaction. (default: true)").getBoolean();
		
		planetUnreachableZollus = config.get(CTG_CUSTOMS, "Disable Rockets For Planet Zollus", false, "Disable rocket travel for this planet. (default: false)").getBoolean();
		planetUnreachableKriffon = config.get(CTG_CUSTOMS, "Disable Rockets For Planet Kriffon", false, "Disable rocket travel for this planet. (default: false)").getBoolean();
		planetUnreachablePurgot = config.get(CTG_CUSTOMS, "Disable Rockets For Planet Purgot", false, "Disable rocket travel for this planet. (default: false)").getBoolean();
		planetUnreachableEden = config.get(CTG_CUSTOMS, "Disable Rockets For Planet Eden", false, "Disable rocket travel for this planet. (default: false)").getBoolean();
		planetUnreachableXathius = config.get(CTG_CUSTOMS, "Disable Rockets For Planet Xathius", false, "Disable rocket travel for this planet. (default: false)").getBoolean();
		planetUnreachableOasis = config.get(CTG_CUSTOMS, "Disable Rockets For Planet Oasis", false, "Disable rocket travel for this planet. (default: false)").getBoolean();
		planetUnreachableXantheon = config.get(CTG_CUSTOMS, "Disable Rockets For Planet Xantheon", false, "Disable rocket travel for this planet. (default: false)").getBoolean();
		planetUnreachableCandora = config.get(CTG_CUSTOMS, "Disable Rockets For Planet Candora", false, "Disable rocket travel for this planet. (default: false)").getBoolean();
		planetUnreachableAtheon = config.get(CTG_CUSTOMS, "Disable Rockets For Planet Atheon", false, "Disable rocket travel for this planet. (default: false)").getBoolean();
		planetUnreachablePerdita = config.get(CTG_CUSTOMS, "Disable Rockets For Planet Perdita", false, "Disable rocket travel for this planet. (default: false)").getBoolean();
		planetUnreachableAltum = config.get(CTG_CUSTOMS, "Disable Rockets For Planet Altum", false, "Disable rocket travel for this planet. (default: false)").getBoolean();
		planetUnreachableCaligro = config.get(CTG_CUSTOMS, "Disable Rockets For Planet Caligro", false, "Disable rocket travel for this planet. (default: false)").getBoolean();
		planetUnreachableExodus = config.get(CTG_CUSTOMS, "Disable Rockets For Planet Exodus", false, "Disable rocket travel for this planet. (default: false)").getBoolean();
		planetUnreachableVortex = config.get(CTG_CUSTOMS, "Disable Rockets For Planet Vortex", false, "Disable rocket travel for this planet. (default: false)").getBoolean();
		planetUnreachableMetztli = config.get(CTG_CUSTOMS, "Disable Rockets For Planet Metztli", false, "Disable rocket travel for this planet. (default: false)").getBoolean();
		planetUnreachableCentotl = config.get(CTG_CUSTOMS, "Disable Rockets For Planet Centotl", false, "Disable rocket travel for this planet. (default: false)").getBoolean();
		planetUnreachableToci = config.get(CTG_CUSTOMS, "Disable Rockets For Planet Toci", false, "Disable rocket travel for this planet. (default: false)").getBoolean();
		planetUnreachableTlaloc = config.get(CTG_CUSTOMS, "Disable Rockets For Planet Tlaloc", false, "Disable rocket travel for this planet. (default: false)").getBoolean();
		planetUnreachableKronos = config.get(CTG_CUSTOMS, "Disable Rockets For Planet Kronos", false, "Disable rocket travel for this planet. (default: false)").getBoolean();
		planetUnreachableMaveth = config.get(CTG_CUSTOMS, "Disable Rockets For Planet Maveth", false, "Disable rocket travel for this planet. (default: false)").getBoolean();
		
		//
		maxHealthAllowed = config.get(CTG_CUSTOMS, "Max Health Allowed", 40, "The max health that Players are allowed to have. (default: 40)").getInt();
		maxHealthIncreasedBy = config.get(CTG_CUSTOMS, "Increase Max Health Amount", 10, "The amount of hearts to add to the Player's health when using a Max Heartforce (default: 10).").getInt();
		//
		
		craterSpawnChance = config.get(CTG_CUSTOMS, "Crater Spawn Chance", 40, "Chance out of 100 that craters spawn on planets. Set to 0 to disable. (default: 40)").getInt();
		
		// Coords (Psios)
		psiosXOffset = (float) config.get(CTG_COORDS, "Psios X Offset", 0.0, "(default: 0.0)").getDouble();
		psiosYOffset = (float) config.get(CTG_COORDS, "Psios Y Offset", 0.0, "(default: 0.0)").getDouble();
		psiosZOffset = (float) config.get(CTG_COORDS, "Psios Z Offset", 0.0, "(default: 0.0)").getDouble();
		
		// Coords (Praedyth)
		praedythXOffset = (float) config.get(CTG_COORDS, "Praedyth X Offset", 0.0, "(default: 0.0)").getDouble();
		praedythYOffset = (float) config.get(CTG_COORDS, "Praedyth Y Offset", 0.0, "(default: 0.0)").getDouble();
		praedythZOffset = (float) config.get(CTG_COORDS, "Praedyth Z Offset", 0.0, "(default: 0.0)").getDouble();
		
		// Coords (Sol-2)
		sol2XOffset = (float) config.get(CTG_COORDS, "Sol-2 X Offset", 0.0, "(default: 0.0)").getDouble();
		sol2YOffset = (float) config.get(CTG_COORDS, "Sol-2 Y Offset", 0.0, "(default: 0.0)").getDouble();
		sol2ZOffset = (float) config.get(CTG_COORDS, "Sol-2 Z Offset", 0.0, "(default: 0.0)").getDouble();
		
		// Coords (Pantheon)
		pantheonXOffset = (float) config.get(CTG_COORDS, "Pantheon X Offset", 0.0, "(default: 0.0)").getDouble();
		pantheonYOffset = (float) config.get(CTG_COORDS, "Pantheon Y Offset", 0.0, "(default: 0.0)").getDouble();
		pantheonZOffset = (float) config.get(CTG_COORDS, "Pantheon Z Offset", 0.0, "(default: 0.0)").getDouble();
		
		// Coords (Olympus)
		olympusXOffset = (float) config.get(CTG_COORDS, "Olympus X Offset", 0.0, "(default: 0.0)").getDouble();
		olympusZOffset = (float) config.get(CTG_COORDS, "Olympus Z Offset", 0.0, "(default: 0.0)").getDouble();
		
		// Coords (Asgard)
		asgardXOffset = (float) config.get(CTG_COORDS, "Asgard X Offset", 0.0, "(default: 0.0)").getDouble();
		asgardYOffset = (float) config.get(CTG_COORDS, "Asgard Y Offset", 0.0, "(default: 0.0)").getDouble();
		asgardZOffset = (float) config.get(CTG_COORDS, "Asgard Z Offset", 0.0, "(default: 0.0)").getDouble();
		
		// Coords (Vega)
		vegaXOffset = (float) config.get(CTG_COORDS, "Vega X Offset", 0.0, "(default: 0.0)").getDouble();
		vegaYOffset = (float) config.get(CTG_COORDS, "Vega Y Offset", 0.0, "(default: 0.0)").getDouble();
		vegaZOffset = (float) config.get(CTG_COORDS, "Vega Z Offset", 0.0, "(default: 0.0)").getDouble();
		
		// Coords (Nova)
		novaXOffset = (float) config.get(CTG_COORDS, "Nova X Offset", 0.0, "(default: 0.0)").getDouble();
		novaYOffset = (float) config.get(CTG_COORDS, "Nova Y Offset", 0.0, "(default: 0.0)").getDouble();
		novaZOffset = (float) config.get(CTG_COORDS, "Nova Z Offset", 0.0, "(default: 0.0)").getDouble();
		
		// Planet Tiers (Psios-6)
		planetZollusTier = config.get(CTG_TIERS, "Planet Zollus Tier", 3, "Zollus Planet Tier. (default: 3)").getInt();
		planetKriffonTier = config.get(CTG_TIERS, "Planet Kriffon Tier", 3, "Kriffon Planet Tier. (default: 3)").getInt();
		planetPurgotTier = config.get(CTG_TIERS, "Planet Purgot Tier", 3, "Purgot Planet Tier. (default: 3)").getInt();
		planetEdenTier = config.get(CTG_TIERS, "Planet Eden Tier", 3, "Eden Planet Tier. (default: 3)").getInt();
		
		// Planet Tiers (Praedyth)
		planetXathiusTier = config.get(CTG_TIERS, "Planet Xathius Tier", 3, "Xathius Planet Tier. (default: 3)").getInt();
		planetOasisTier = config.get(CTG_TIERS, "Planet Oasis Tier", 3, "Oasis Planet Tier. (default: 3)").getInt();
		planetXantheonTier = config.get(CTG_TIERS, "Planet Xantheon Tier", 3, "Xantheon Planet Tier. (default: 3)").getInt();
		planetCandoraTier = config.get(CTG_TIERS, "Planet Candora Tier", 3, "Candora Planet Tier. (default: 3)").getInt();
		planetAtheonTier = config.get(CTG_TIERS, "Planet Atheon Tier", 3, "Atheon Planet Tier. (default: 3)").getInt();
		
		// Planet Tiers (Sol-2)
		planetPerditaTier = config.get(CTG_TIERS, "Planet Perdita Tier", 3, "Perdita Planet Tier. (default: 3)").getInt();
		planetAltumTier = config.get(CTG_TIERS, "Planet Altum Tier", 3, "Altum Planet Tier. (default: 3)").getInt();
		planetCaligroTier = config.get(CTG_TIERS, "Planet Caligro Tier", 3, "Caligro Planet Tier. (default: 3)").getInt();
		planetExodusTier = config.get(CTG_TIERS, "Planet Exodus Tier", 3, "Exodus Planet Tier. (default: 3)").getInt();
		
		// Planet Tiers (Pantheon)
		planetVortexTier = config.get(CTG_TIERS, "Planet Vortex Tier", 3, "Vortex Planet Tier. (default: 3)").getInt();
		planetMetztliTier = config.get(CTG_TIERS, "Planet Metztli Tier", 3, "Metztli Planet Tier. (default: 3)").getInt();
		planetCentotlTier = config.get(CTG_TIERS, "Planet Centotl Tier", 3, "Centotl Planet Tier. (default: 3)").getInt();
		planetTociTier = config.get(CTG_TIERS, "Planet Toci Tier", 3, "Toci Planet Tier. (default: 3)").getInt();
		planetTlalocTier = config.get(CTG_TIERS, "Planet Tlaloc Tier", 3, "Tlaloc Planet Tier. (default: 3)").getInt();
		
		// Planet Tiers (Olympus)
		planetKronosTier = config.get(CTG_TIERS, "Planet Kronos Tier", 3, "Kronos Planet Tier. (default: 3)").getInt();
		// TODO
		
		// Planet Tiers (Asgard)
		planetMavethTier = config.get(CTG_TIERS, "Planet Maveth Tier", 3, "Maveth Planet Tier. (default: 3)").getInt();
		
		config.save();
	}
}