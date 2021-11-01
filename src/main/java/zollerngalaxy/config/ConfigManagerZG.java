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
	
	public static Configuration configuration;
	
	// Categories
	public static final String CATEGORY_DIMENSIONS = "Dimensions";
	public static final String CATEGORY_MOONS = "Moons";
	public static final String CATEGORY_SATELLITES = "Space_Stations";
	public static final String CATEGORY_MISC = "Miscallenous";
	public static final String CATEGORY_COMPATIBILITY = "Compatibility";
	public static final String CATEGORY_COORDINATES = "Coordinates";
	public static final String CATEGORY_CUSTOMIZATIONS = "Customizations";
	public static final String CATEGORY_TIERS = "Planet Tiers";
	
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
	
	// Misc
	public static boolean canEarthAnimalsSpawnOnEden;
	public static boolean disableStarGates;
	public static String temperatureType;
	public static boolean hideUnusedStarSystems;
	public static boolean enableMegaCreeperGriefing;
	public static boolean changeContributorNames;
	public static boolean enableChestValidation;
	public static boolean spawnGalaxyKnight;
	public static boolean enableExtremeMode;
	
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
	public static boolean enableAlienVillagerMutation;
	
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
	////////////////////////////////////////////////
	
	// Max Health Customization
	public static double maxHealthAllowed;
	public static double maxHealthIncreasedBy;
	
	// Coords (Psios)
	public static float psiosX;
	public static float psiosY;
	public static float psiosZ;
	
	// Coords (Praedyth)
	public static float praedythX;
	public static float praedythY;
	public static float praedythZ;
	
	// Coords (Sol-2)
	public static float sol2X;
	public static float sol2Y;
	public static float sol2Z;
	
	// Coords (Pantheon)
	public static float pantheonX;
	public static float pantheonY;
	public static float pantheonZ;
	
	// Coords (Olympus)
	public static float olympusX;
	public static float olympusY;
	public static float olympusZ;
	
	// Coords (Asgard)
	public static float asgardX;
	public static float asgardY;
	public static float asgardZ;
	
	// Coords (Vega)
	public static float vegaX;
	public static float vegaY;
	public static float vegaZ;
	
	// Coords (Nova)
	public static float novaX;
	public static float novaY;
	public static float novaZ;
	
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
	
	public static void init(FMLPreInitializationEvent event) {
		configuration = new Configuration(new File(event.getModConfigurationDirectory().getAbsolutePath() + "/ZollernGalaxy/core.cfg"));
		configuration.load();
		
		// Planets (Psios)
		planetEdenDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Eden Dimension ID", -7996).getInt();
		planetZollusDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Zollus Dimension ID", -7982).getInt();
		planetKriffonDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Kriffon Dimension ID", -7994).getInt();
		planetPurgotDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Purgot Dimension ID", -7988).getInt();
		
		// Moons (Psios -> Eden -> Astros)
		moonAstrosDimensionId = configuration.get(CATEGORY_MOONS, "Moon Astros Dimension ID", -7981).getInt();
		
		// Planets (Praedyth)
		planetXathiusDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Xathius Dimension ID", -7983).getInt();
		planetOasisDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Oasis Dimension ID", -7990).getInt();
		planetXantheonDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Xantheon Dimension ID", -7984).getInt();
		planetCandoraDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Candora Dimension ID", -7777).getInt();
		planetAtheonDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Atheon Dimension ID", -7998).getInt();
		
		// Planets (Sol-2)
		planetExodusDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Exodus Dimension ID", -7980).getInt();
		planetPerditaDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Perdita Dimension ID", -7979).getInt();
		planetAltumDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Altum Dimension ID", -7878).getInt();
		planetCaligroDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Caligro Dimension ID", -7877).getInt();
		
		// Planets (Pantheon)
		planetVortexDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Vortex Dimension ID", -7675).getInt();
		planetMetztliDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Metztli Dimension ID", -7991).getInt();
		planetCentotlDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Centotl Dimension ID", -7997).getInt();
		planetTociDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Toci Dimension ID", -7985).getInt();
		planetTlalocDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Tlaloc Dimension ID", -7986).getInt();
		
		// Planets (Olympus)
		planetAresDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Ares Dimension ID", -8000).getInt();
		planetPrometheusDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Prometheus Dimension ID", -7281).getInt();
		planetIcarusDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Icarus Dimension ID", -7995).getInt();
		planetKronosDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Kronos Dimension ID", -7993).getInt();
		
		// Planets (Asgard)
		planetAsgardDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Asgard Dimension ID", -7999).getInt();
		planetMavethDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Maveth Dimension ID", -4552).getInt();
		
		// Planets (Vega)
		planetMeridianDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Meridian Dimension ID", -7992).getInt();
		planetReachDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Reach Dimension ID", -7676).getInt();
		planetRequiemDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Requiem Dimension ID", -7987).getInt();
		
		// Planets (Nova)
		planetPrimorDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Primor Dimension ID", -7989).getInt();
		
		// Number of space stations to generate
		spaceStationGenAmount = configuration
				.get(CATEGORY_SATELLITES, "Space Station Generation Count", 1, "How many Space Stations should generate in orbit (between 1 to 5)? (default: 1)")
				.getInt();
		spaceStationGenAmount = (spaceStationGenAmount <= 5) ? spaceStationGenAmount : 5;
		spaceStationGenAmount = (spaceStationGenAmount >= 1) ? spaceStationGenAmount : 1;
		
		// Whether or not Lore Blocks can spawn extra
		canExtraLoreSpawn = configuration.get(CATEGORY_SATELLITES, "Spawn Extra Lore Blocks", true, "Can additional Lore Blocks spawn? (default: true)").getBoolean();
		
		// Space Stations (Psios-6)
		
		// Zollus
		spaceStationZollusId = configuration.get(CATEGORY_SATELLITES, "Zollus Space Station ID", -6000).getInt();
		spaceStationZollusStaticId = configuration.get(CATEGORY_SATELLITES, "Zollus Space Station Static ID", -6001).getInt();
		
		// Kriffon
		spaceStationKriffonId = configuration.get(CATEGORY_SATELLITES, "Kriffon Space Station ID", -6002).getInt();
		spaceStationKriffonStaticId = configuration.get(CATEGORY_SATELLITES, "Kriffon Space Station Static ID", -6003).getInt();
		
		// Purgot
		spaceStationPurgotId = configuration.get(CATEGORY_SATELLITES, "Purgot Space Station ID", -6004).getInt();
		spaceStationPurgotStaticId = configuration.get(CATEGORY_SATELLITES, "Purgot Space Station Static ID", -6005).getInt();
		
		// Eden
		spaceStationEdenId = configuration.get(CATEGORY_SATELLITES, "Eden Space Station ID", -6006).getInt();
		spaceStationEdenStaticId = configuration.get(CATEGORY_SATELLITES, "Eden Space Station Static ID", -6007).getInt();
		
		// Space Stations (Praedyth)
		// Xathius
		spaceStationXathiusId = configuration.get(CATEGORY_SATELLITES, "Xathius Space Station ID", -6008).getInt();
		spaceStationXathiusStaticId = configuration.get(CATEGORY_SATELLITES, "Xathius Space Station Static ID", -6009).getInt();
		
		// Oasis
		spaceStationOasisId = configuration.get(CATEGORY_SATELLITES, "Oasis Space Station ID", -6010).getInt();
		spaceStationOasisStaticId = configuration.get(CATEGORY_SATELLITES, "Oasis Space Station Static ID", -6011).getInt();
		
		// Xantheon
		spaceStationXantheonId = configuration.get(CATEGORY_SATELLITES, "Xantheon Space Station ID", -6012).getInt();
		spaceStationXantheonStaticId = configuration.get(CATEGORY_SATELLITES, "Xantheon Space Station Static Id", -6013).getInt();
		
		// Candora
		spaceStationCandoraId = configuration.get(CATEGORY_SATELLITES, "Candora Space Station ID", -6014).getInt();
		spaceStationCandoraStaticId = configuration.get(CATEGORY_SATELLITES, "Candora Space Station Static Id", -6015).getInt();
		
		// Atheon
		spaceStationAtheonId = configuration.get(CATEGORY_SATELLITES, "Atheon Space Station ID", -6016).getInt();
		spaceStationAtheonStaticId = configuration.get(CATEGORY_SATELLITES, "Atheon Space Station Static ID", -6017).getInt();
		
		// Space Stations (Sol-2)
		// Perdita
		spaceStationPerditaId = configuration.get(CATEGORY_SATELLITES, "Perdita Space Station ID", -6018).getInt();
		spaceStationPerditaStaticId = configuration.get(CATEGORY_SATELLITES, "Perdita Space Station Static ID", -6019).getInt();
		
		// Altum
		spaceStationAltumId = configuration.get(CATEGORY_SATELLITES, "Altum Space Station ID", -6020).getInt();
		spaceStationAltumStaticId = configuration.get(CATEGORY_SATELLITES, "Altum Space Station Static ID", -6021).getInt();
		
		// Caligro
		spaceStationCaligroId = configuration.get(CATEGORY_SATELLITES, "Caligro Space Station ID", -6022).getInt();
		spaceStationCaligroStaticId = configuration.get(CATEGORY_SATELLITES, "Caligro Space Station Static ID", -6023).getInt();
		
		// Exodus
		spaceStationExodusId = configuration.get(CATEGORY_SATELLITES, "Exodus Space Station ID", -6024).getInt();
		spaceStationExodusStaticId = configuration.get(CATEGORY_SATELLITES, "Exodus Space Station Static ID", -6025).getInt();
		
		// Space Stations (Pantheon)
		// Vortex
		spaceStationVortexId = configuration.get(CATEGORY_SATELLITES, "Vortex Space Station ID", -6026).getInt();
		spaceStationVortexStaticId = configuration.get(CATEGORY_SATELLITES, "Vortex Space Station Static ID", -6027).getInt();
		
		// Metztli
		spaceStationMetztliId = configuration.get(CATEGORY_SATELLITES, "Metztli Space Station ID", -6028).getInt();
		spaceStationMetztliStaticId = configuration.get(CATEGORY_SATELLITES, "Metztli Space Station Static ID", -6029).getInt();
		
		// Misc (Can Earth animals spawn on Eden?)
		canEarthAnimalsSpawnOnEden = configuration.get(CATEGORY_MISC, "Earth Animals Spawn On Eden", true, "Should Earth animals spawn on Eden? (default: true)")
				.getBoolean();
		
		// Misc (Should Star Gates be disabled?)
		disableStarGates = configuration
				.get(CATEGORY_MISC, "Disable use of Star Gates", false, "Set this to true if you want to ONLY access Zollern Galaxy planets using rockets. "
						+ "WARNING: will not work without another add-on this way! (default: false)")
				.getBoolean();
		
		hideUnusedStarSystems = configuration.get(CATEGORY_MISC, "Hide Stars with no Planets", true, "Enable to see Stars that have no Planets yet. (default: true)")
				.getBoolean();
		
		// Misc (Should Mega Creeper explosions harm terrain?)
		enableMegaCreeperGriefing = configuration
				.get(CATEGORY_MISC, "Enable Mega Creeper Griefing", true, "Set to false if you don't want Mega Creepers to destroy terrain. (default: true)")
				.getBoolean();
		
		// Misc (Tempratures shown in fahrenheit or celsius?)
		temperatureType = configuration
				.get(CATEGORY_MISC, "[HUD DISPLAY] Temperature Type (F or C only)", "F", "Should temperatures be shown in Fahrenheit (F) or Celsius (C)? (default: F)")
				.getString();
		
		// Whether or not to change contributor's in-game names
		changeContributorNames = configuration
				.get(CATEGORY_MISC, "Contributor name change", true, "Whether or not to change contributor in-game names to more recognized formats (default: true)")
				.getBoolean();
		
		// Whether or not to allow Spawning of Galaxy Knights.
		spawnGalaxyKnight = configuration
				.get(CATEGORY_MISC, "Spawn Galaxy Knight", true, "Whether or not to allow Grey Aliens to summon Galaxy Knights when attacked (default: true)")
				.getBoolean();
		
		// Make sure chests are on the ground or not. (ExistingEevee)
		enableChestValidation = configuration.get(CATEGORY_MISC, "Chest Validation", true,
				"Whether or not to validate chest spawns. " + "Disable if chest generation is causing a crash. (default: true)").getBoolean();
		
		// Should Extreme Mode be enabled? Significantly increases the mod's difficulty.
		enableExtremeMode = configuration.get(CATEGORY_MISC, "Enable Extreme Mode", false,
				"Toggle Extreme mode. " + "WARNING: This will SIGNIFICANTLY increase the mod's difficulty. (default: false)").getBoolean();
		
		// Compatibility (Whether or not to use Thermal Foundation's Detabilized
		// Redstone
		// for the Red Sea in Oasis)
		shouldOasisUseLiquidRedstone = configuration.get(CATEGORY_COMPATIBILITY, "Oasis uses Thermal Foundation's Destabilized Redstone", true,
				"Whether or not Oasis should use Detabilized Redstone for its Red Sea biome. WARNING: This can use a LOT of your PC's memory! "
						+ "This can lead to severe LAG! Use at your own risk. (default: true)")
				.getBoolean();
		
		// Compatibility (Whether or not Thermal Foundation Pulverizers should
		// give extra
		// (4) instead of normal (2))
		enableExtraPulverizerOutput = configuration.get(CATEGORY_COMPATIBILITY, "Enable extra Pulverizer Output", true,
				"Whether or not Zollern Galaxy ores give extra dust from Thermal Foundation's Pulverizers. "
						+ "Disable if it causes compatibility issues (default: true).")
				.getBoolean();
		
		// Compat (Should Fueltonium register as Uranium?)
		fueltoniumIsUranium = configuration.get(CATEGORY_COMPATIBILITY, "Fueltonium counts as Uranium", true, "Should Fueltonium register as Uranium? (default: true)")
				.getBoolean();
		
		// Compat (Should Cobalt register in the Ore Dictionary?)
		registerCobaltOreDict = configuration.get(CATEGORY_COMPATIBILITY, "Register Cobalt in Ore Dictionary", true,
				"Set this to false if there are any problems " + " with mods like Tinker's Construct. (default: true)").getBoolean();
		
		// Compat (Should Zinc register in the Ore Dictionary?)
		registerZincOreDict = configuration.get(CATEGORY_COMPATIBILITY, "Register Zinc in Ore Dictionary", true,
				"Set this to false if there are any problems " + " with other mods. (default: true)").getBoolean();
		
		// Compat (Should intergration with Planet Progressions be enabled?
		enablePlanetProgressionsCompat = configuration.get(CATEGORY_COMPATIBILITY, "Enable Planet Progressions compatibility", true,
				"If Planet Progressions is installed, you will need to discover the Planet or Moon "
						+ " before you can travel to it via Star Gates. Set this to false to disable that. (default: true)")
				.getBoolean();
		
		// Compat (Enable Radium Material for Tinker's Construct
		useTConRadium = configuration.get(CATEGORY_COMPATIBILITY, "[TCONSTRUCT] Enable Radium Material", true,
				"Set to false to disable (will cause issues with More TCon if true). (default: true)").getBoolean();
		
		// Compat (Enable Corruption Material for Tinker's Construct
		useTConCorruption = configuration.get(CATEGORY_COMPATIBILITY, "[TCONSTRUCT] Enable Corruption Material", true, "Set to false to disable. (default: true)")
				.getBoolean();
		
		// Compat (Should flying be enabled and then disabled when applying and unapplying Radiance
		// armor?
		enableRadianceFlying = configuration.get(CATEGORY_COMPATIBILITY, "Enable Radiance Flying In Survival", true,
				"Toggle whether a full set of Radiance armor allows the Player to fly in Survival. "
						+ "Set to false to disable if this causes mod conflicts, compromises the safety of your server, " + "or if you just hate fun. (default: true)")
				.getBoolean();
		
		// Compat (Should increased step height be enabled when using certain armor?)
		enableStepHeight = configuration.get(CATEGORY_COMPATIBILITY, "Enable Increased Step Height", true,
				"Toggle whether Zollernium armor increases step height. Disable if there are compatability issues. (default: true)").getBoolean();
		
		// Customization Options
		kriffonLavaLakesPerChunk = configuration
				.get(CATEGORY_CUSTOMIZATIONS, "Kriffon Lava Lakes Per Chunk", 4, "The amount of Lava Lakes to generate per chunk on planet Kriffon. (default: 4)")
				.getInt();
		kriffonLavaLakesGenChance = configuration.get(CATEGORY_CUSTOMIZATIONS, "Kriffon Lava Lakes Gen Percentage", 25,
				"The chance (out of 100) for a lava lake to generate on planet Kriffon. (default: 25)").getInt();
		zollusIceSpikesPerChunk = configuration
				.get(CATEGORY_CUSTOMIZATIONS, "Zollus Ice Spikes Per Chunk", 2, "The amount of Ice Spikes to generate on " + "Zollus per chunk. (default: 2)").getInt();
		zollusIceSpikesGenChance = configuration.get(CATEGORY_CUSTOMIZATIONS, "Zollus Ice Spikes Gen Percentage", 42,
				"The chance (out of 100) for Ice Spikes to generate on planet Zollus. (default: 42)").getInt();
		outpostGenChance = configuration
				.get(CATEGORY_CUSTOMIZATIONS, "Outpost Gen Percentage", 5, "The chance (out of 100) for Outpost buildings to generate on planets. (default: 5)").getInt();
		windBlowChance = configuration.get(CATEGORY_CUSTOMIZATIONS, "Wind Blow Chance", 25, "Percentage chance of how often storm wind blows. (default: 25)").getInt();
		enableWindBlowEvent = configuration
				.get(CATEGORY_CUSTOMIZATIONS, "Enable Wind Blowing Event", true, "Allow the wind blowing event to move Players around on Vortex (default: true). ")
				.getBoolean();
		enableAlienVillagerSpawn = configuration
				.get(CATEGORY_CUSTOMIZATIONS, "Enable Alien Villager Spawn", true,
						"Control whether Alien Villagers can spawn randomly outside of Alien Villages; disable if they're causing lag or being annoying. (default: true). ")
				.getBoolean();
		enableAlienVillagerMutation = configuration.get(CATEGORY_CUSTOMIZATIONS, "Enable Alien Villagers To Mutate", true,
				"Set whether or not Alien Villagers can mutate into Zombies on Metztli (default: true). ").getBoolean();
		
		//
		//
		meteorGenZollus = configuration.get(CATEGORY_CUSTOMIZATIONS, "Meteor Gen Zollus", 2, "Percentage chance for meteors to fall. (default: 2)").getInt();
		meteorGenKriffon = configuration.get(CATEGORY_CUSTOMIZATIONS, "Meteor Gen Kriffon", 8, "Percentage chance for meteors to fall. (default: 8)").getInt();
		meteorGenPurgot = configuration.get(CATEGORY_CUSTOMIZATIONS, "Meteor Gen Purgot", 2, "Percentage chance for meteors to fall. (default: 2)").getInt();
		meteorGenEden = configuration.get(CATEGORY_CUSTOMIZATIONS, "Meteor Gen Eden", 10, "Percentage chance for meteors to fall. (default: 10)").getInt();
		meteorGenXathius = configuration.get(CATEGORY_CUSTOMIZATIONS, "Meteor Gen Xathius", 5, "Percentage chance for meteors to fall. (default: 5)").getInt();
		meteorGenOasis = configuration.get(CATEGORY_CUSTOMIZATIONS, "Meteor Gen Oasis", 15, "Percentage chance for meteors to fall. (default: 15)").getInt();
		meteorGenXantheon = configuration.get(CATEGORY_CUSTOMIZATIONS, "Meteor Gen Xantheon", 4, "Percentage chance for meteors to fall. (default: 4)").getInt();
		meteorGenCandora = configuration.get(CATEGORY_CUSTOMIZATIONS, "Meteor Gen Candora", 0, "Percentage chance for meteors to fall. (default: 0)").getInt();
		meteorGenAtheon = configuration.get(CATEGORY_CUSTOMIZATIONS, "Meteor Gen Atheon", 2, "Percentage chance for meteors to fall. (default: 2)").getInt();
		meteorGenExodus = configuration.get(CATEGORY_CUSTOMIZATIONS, "Meteor Gen Exodus", 15, "Percentage chance for meteors to fall. (default: 15)").getInt();
		meteorGenPerdita = configuration.get(CATEGORY_CUSTOMIZATIONS, "Meteor Gen Perdita", 15, "Percentage chance for meteors to fall. (default: 15)").getInt();
		meteorGenAltum = configuration.get(CATEGORY_CUSTOMIZATIONS, "Meteor Gen Altum", 4, "Percentage chance for meteors to fall. (default: 4)").getInt();
		meteorGenCaligro = configuration.get(CATEGORY_CUSTOMIZATIONS, "Meteor Gen Caligro", 0, "Percentage chance for meteors to fall. (default: 0)").getInt();
		meteorGenVortex = configuration.get(CATEGORY_CUSTOMIZATIONS, "Meteor Gen Vortex", 15, "Percentage chance for meteors to fall. (default: 15)").getInt();
		meteorGenMetztli = configuration.get(CATEGORY_CUSTOMIZATIONS, "Meteor Gen Metztli", 15, "Percentage chance for meteors to fall. (default: 15)").getInt();
		//
		//
		
		// Control unreachable planets (by rockets).
		planetUnreachableAll = configuration
				.get(CATEGORY_CUSTOMIZATIONS, "Disable Rockets For All Planets", false,
						"Setting this to true disallows rocket travel to all Zollern Galaxy planets. "
								+ "Note that when this is enabled, it will override the planet-by-planet settings, " + "with the exception of Zollus. (default: false)")
				.getBoolean();
		
		// Control whether or not explosive blocks should cause other explosive blocks to explode in
		// a chain reaction
		shouldExplosiveBlocksExplodeOtherBlocks = configuration
				.get(CATEGORY_CUSTOMIZATIONS, "Explosive Blocks Cause Chain Reaction", true,
						"Disable this to prevent explosive blocks blowing up other explosive blocks when broken, " + "which can cause a chain reaction. (default: true)")
				.getBoolean();
		
		planetUnreachableZollus = configuration
				.get(CATEGORY_CUSTOMIZATIONS, "Disable Rockets For Planet Zollus", false, "Disable rocket travel for this planet. (default: false)").getBoolean();
		planetUnreachableKriffon = configuration
				.get(CATEGORY_CUSTOMIZATIONS, "Disable Rockets For Planet Kriffon", false, "Disable rocket travel for this planet. (default: false)").getBoolean();
		planetUnreachablePurgot = configuration
				.get(CATEGORY_CUSTOMIZATIONS, "Disable Rockets For Planet Purgot", false, "Disable rocket travel for this planet. (default: false)").getBoolean();
		planetUnreachableEden = configuration
				.get(CATEGORY_CUSTOMIZATIONS, "Disable Rockets For Planet Eden", false, "Disable rocket travel for this planet. (default: false)").getBoolean();
		planetUnreachableXathius = configuration
				.get(CATEGORY_CUSTOMIZATIONS, "Disable Rockets For Planet Xathius", false, "Disable rocket travel for this planet. (default: false)").getBoolean();
		planetUnreachableOasis = configuration
				.get(CATEGORY_CUSTOMIZATIONS, "Disable Rockets For Planet Oasis", false, "Disable rocket travel for this planet. (default: false)").getBoolean();
		planetUnreachableXantheon = configuration
				.get(CATEGORY_CUSTOMIZATIONS, "Disable Rockets For Planet Xantheon", false, "Disable rocket travel for this planet. (default: false)").getBoolean();
		planetUnreachableCandora = configuration
				.get(CATEGORY_CUSTOMIZATIONS, "Disable Rockets For Planet Candora", false, "Disable rocket travel for this planet. (default: false)").getBoolean();
		planetUnreachableAtheon = configuration
				.get(CATEGORY_CUSTOMIZATIONS, "Disable Rockets For Planet Atheon", false, "Disable rocket travel for this planet. (default: false)").getBoolean();
		planetUnreachablePerdita = configuration
				.get(CATEGORY_CUSTOMIZATIONS, "Disable Rockets For Planet Perdita", false, "Disable rocket travel for this planet. (default: false)").getBoolean();
		planetUnreachableAltum = configuration
				.get(CATEGORY_CUSTOMIZATIONS, "Disable Rockets For Planet Altum", false, "Disable rocket travel for this planet. (default: false)").getBoolean();
		planetUnreachableCaligro = configuration
				.get(CATEGORY_CUSTOMIZATIONS, "Disable Rockets For Planet Caligro", false, "Disable rocket travel for this planet. (default: false)").getBoolean();
		planetUnreachableExodus = configuration
				.get(CATEGORY_CUSTOMIZATIONS, "Disable Rockets For Planet Exodus", false, "Disable rocket travel for this planet. (default: false)").getBoolean();
		planetUnreachableVortex = configuration
				.get(CATEGORY_CUSTOMIZATIONS, "Disable Rockets For Planet Vortex", false, "Disable rocket travel for this planet. (default: false)").getBoolean();
		planetUnreachableMetztli = configuration
				.get(CATEGORY_CUSTOMIZATIONS, "Disable Rockets For Planet Metztli", false, "Disable rocket travel for this planet. (default: false)").getBoolean();
		
		//
		maxHealthAllowed = configuration.get(CATEGORY_CUSTOMIZATIONS, "Max Health Allowed", 40, "The max health that Players are allowed to have. (default: 40)")
				.getInt();
		maxHealthIncreasedBy = configuration.get(CATEGORY_CUSTOMIZATIONS, "Increase Max Health Amount", 10,
				"The amount of hearts to add to the Player's health when using a Max Heartforce (default: 10).").getInt();
		//
		
		// Coords (Psios)
		psiosX = (float) configuration.get(CATEGORY_COORDINATES, "Psios X", -2.5).getDouble();
		psiosY = (float) configuration.get(CATEGORY_COORDINATES, "Psios Y", 1.2).getDouble();
		psiosZ = (float) configuration.get(CATEGORY_COORDINATES, "Psios Z", 0.0).getDouble();
		
		// Coords (Praedyth)
		praedythX = (float) configuration.get(CATEGORY_COORDINATES, "Praedyth X", -1.2).getDouble();
		praedythY = (float) configuration.get(CATEGORY_COORDINATES, "Praedyth Y", 1.4).getDouble();
		praedythZ = (float) configuration.get(CATEGORY_COORDINATES, "Praedyth Z", 0.0).getDouble();
		
		// Coords (Sol-2)
		sol2X = (float) configuration.get(CATEGORY_COORDINATES, "Sol-2 X", 1.2).getDouble();
		sol2Y = (float) configuration.get(CATEGORY_COORDINATES, "Sol-2 Y", -1.2).getDouble();
		sol2Z = (float) configuration.get(CATEGORY_COORDINATES, "Sol-2 Z", 0.0).getDouble();
		
		// Coords (Pantheon)
		pantheonX = (float) configuration.get(CATEGORY_COORDINATES, "Pantheon X", 2.0).getDouble();
		pantheonY = (float) configuration.get(CATEGORY_COORDINATES, "Pantheon Y", 1.2).getDouble();
		pantheonZ = (float) configuration.get(CATEGORY_COORDINATES, "Pantheon Z", 0.0).getDouble();
		
		// Coords (Olympus)
		olympusX = (float) configuration.get(CATEGORY_COORDINATES, "Olympus X", 1.5).getDouble();
		olympusY = (float) configuration.get(CATEGORY_COORDINATES, "Olympus Y", 1.5).getDouble();
		olympusZ = (float) configuration.get(CATEGORY_COORDINATES, "Olympus Z", 0.0).getDouble();
		
		// Coords (Asgard)
		asgardX = (float) configuration.get(CATEGORY_COORDINATES, "Asgard X", 3.0).getDouble();
		asgardY = (float) configuration.get(CATEGORY_COORDINATES, "Asgard Y", 1.2).getDouble();
		asgardZ = (float) configuration.get(CATEGORY_COORDINATES, "Asgard Z", 0.0).getDouble();
		
		// Coords (Vega)
		vegaX = (float) configuration.get(CATEGORY_COORDINATES, "Vega X", -1.0).getDouble();
		vegaY = (float) configuration.get(CATEGORY_COORDINATES, "Vega Y", 2.5).getDouble();
		vegaZ = (float) configuration.get(CATEGORY_COORDINATES, "Vega Z", 0.0).getDouble();
		
		// Coords (Nova)
		novaX = (float) configuration.get(CATEGORY_COORDINATES, "Nova X", 1.5).getDouble();
		novaY = (float) configuration.get(CATEGORY_COORDINATES, "Nova Y", 1.2).getDouble();
		novaZ = (float) configuration.get(CATEGORY_COORDINATES, "Nova Z", 0.0).getDouble();
		
		// Planet Tiers (Psios-6)
		planetZollusTier = configuration.get(CATEGORY_TIERS, "Planet Zollus Tier", 3).getInt();
		planetKriffonTier = configuration.get(CATEGORY_TIERS, "Planet Kriffon Tier", 4).getInt();
		planetPurgotTier = configuration.get(CATEGORY_TIERS, "Planet Purgot Tier", 5).getInt();
		planetEdenTier = configuration.get(CATEGORY_TIERS, "Planet Eden Tier", 5).getInt();
		
		// Planet Tiers (Praedyth)
		planetXathiusTier = configuration.get(CATEGORY_TIERS, "Planet Xathius Tier", 6).getInt();
		planetOasisTier = configuration.get(CATEGORY_TIERS, "Planet Oasis Tier", 6).getInt();
		planetXantheonTier = configuration.get(CATEGORY_TIERS, "Planet Xantheon Tier", 7).getInt();
		planetCandoraTier = configuration.get(CATEGORY_TIERS, "Planet Candora Tier", 8).getInt();
		planetAtheonTier = configuration.get(CATEGORY_TIERS, "Planet Atheon Tier", 8).getInt();
		
		// Planet Tiers (Sol-2)
		planetPerditaTier = configuration.get(CATEGORY_TIERS, "Planet Perdita Tier", 9).getInt();
		planetAltumTier = configuration.get(CATEGORY_TIERS, "Planet Altum Tier", 10).getInt();
		planetCaligroTier = configuration.get(CATEGORY_TIERS, "Planet Caligro Tier", 11).getInt();
		planetExodusTier = configuration.get(CATEGORY_TIERS, "Planet Exodus Tier", 3).getInt();
		
		// Planet Tiers (Pantheon)
		planetVortexTier = configuration.get(CATEGORY_TIERS, "Planet Vortex Tier", 4).getInt();
		planetMetztliTier = configuration.get(CATEGORY_TIERS, "Planet Metztli Tier", 3).getInt();
		
		configuration.save();
	}
}
