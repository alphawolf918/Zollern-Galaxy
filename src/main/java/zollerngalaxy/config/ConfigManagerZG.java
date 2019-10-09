package zollerngalaxy.config;

import java.io.File;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigManagerZG {
	
	public static Configuration configuration;
	
	public static String CATEGORY_DIMENSIONS = "Dimensions";
	public static String CATEGORY_MOONS = "Moons";
	public static String CATEGORY_SATELLITES = "Space Stations";
	public static String CATEGORY_MISC = "Miscallenous";
	public static String CATEGORY_COMPATIBILITY = "Compatibility";
	public static String CATEGORY_COORDINATES = "Coordinates";
	
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
	
	// Planets (Pantheon)
	public static int planetMeztliDimensionId;
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
	
	// Space Stations
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
	
	// Misc
	public static boolean canEarthAnimalsSpawnOnEden;
	public static boolean disableStarGates;
	public static String temperatureType;
	
	// Compat
	public static boolean shouldOasisUseLiquidRedstone;
	public static boolean enableExtraPulverizerOutput;
	public static boolean fueltoniumIsUranium;
	public static boolean registerCobaltOreDict;
	public static boolean enablePlanetProgressionsCompat;
	
	// Coords (Psios)
	public static float psiosX;
	public static float psiosY;
	public static float psiosZ;
	
	// Coords (Praedyth)
	public static float praedythX;
	public static float praedythY;
	public static float praedythZ;
	
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
	
	public static void init(FMLPreInitializationEvent event) {
		configuration = new Configuration(new File(event.getModConfigurationDirectory().getAbsolutePath()
				+ "/ZollernGalaxy/core.cfg"));
		configuration.load();
		
		// Planets (Psios)
		planetEdenDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Eden Dimension ID", -7996).getInt();
		planetZollusDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Zollus Dimension ID", -7982).getInt();
		planetKriffonDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Kriffon Dimension ID", -7994).getInt();
		planetPurgotDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Purgot Dimension ID", -7988).getInt();
		
		// Moons (Psios -> Purgot -> Astros)
		moonAstrosDimensionId = configuration.get(CATEGORY_MOONS, "Moon Astros Dimension ID", -7981).getInt();
		
		// Planets (Praedyth)
		planetXathiusDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Xathius Dimension ID", -7983).getInt();
		planetOasisDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Oasis Dimension ID", -7990).getInt();
		planetXantheonDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Xantheon Dimension ID", -7984).getInt();
		planetCandoraDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Candora Dimension ID", -7777).getInt();
		planetAtheonDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Atheon Dimension ID", -7998).getInt();
		
		// Planets (Pantheon)
		planetMeztliDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Meztli Dimension ID", -7991).getInt();
		planetCentotlDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Centotl Dimension ID", -7997).getInt();
		planetTociDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Toci Dimension ID", -7985).getInt();
		planetTlalocDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Tlaloc Dimension ID", -7986).getInt();
		
		// Planets (Olympus)
		planetAresDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Ares Dimension ID", -8000).getInt();
		planetPrometheusDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Prometheus Dimension ID", -7981)
				.getInt();
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
		
		// Space Stations (Psios-6)
		// Zollus
		spaceStationZollusId = configuration.get(CATEGORY_SATELLITES, "Zollus Space Station ID", -6000).getInt();
		spaceStationZollusStaticId = configuration.get(CATEGORY_SATELLITES, "Zollus Space Station Static ID", -6001)
				.getInt();
		
		// Kriffon
		spaceStationKriffonId = configuration.get(CATEGORY_SATELLITES, "Kriffon Space Station ID", -6002).getInt();
		spaceStationKriffonStaticId = configuration.get(CATEGORY_SATELLITES, "Kriffon Space Station Static ID", -6003)
				.getInt();
		
		// Purgot
		spaceStationPurgotId = configuration.get(CATEGORY_SATELLITES, "Purgot Space Station ID", -6004).getInt();
		spaceStationPurgotStaticId = configuration.get(CATEGORY_SATELLITES, "Purgot Space Station Static ID", -6005)
				.getInt();
		
		// Eden
		spaceStationEdenId = configuration.get(CATEGORY_SATELLITES, "Eden Space Station ID", -6006).getInt();
		spaceStationEdenStaticId = configuration.get(CATEGORY_SATELLITES, "Eden Space Station Static ID", -6007).getInt();
		
		// Space Stations (Praedyth)
		// Xathius
		spaceStationXathiusId = configuration.get(CATEGORY_SATELLITES, "Xathius Space Station ID", -6008).getInt();
		spaceStationXathiusStaticId = configuration.get(CATEGORY_SATELLITES, "Xathius Space Station Static ID", -6009)
				.getInt();
		
		// Oasis
		spaceStationOasisId = configuration.get(CATEGORY_SATELLITES, "Oasis Space Station ID", -6010).getInt();
		spaceStationOasisStaticId = configuration.get(CATEGORY_SATELLITES, "Oasis Space Station Static ID", -6011).getInt();
		
		// Misc (Can Earth animals spawn on Eden?)
		canEarthAnimalsSpawnOnEden = configuration.get(CATEGORY_MISC, "Earth Animals Spawn On Eden", true,
				"Should Earth animals spawn on Eden? (default: true)").getBoolean();
		
		// Misc (Should Star Gates be disabled?)
		disableStarGates = configuration.get(
				CATEGORY_MISC,
				"Disable use of Star Gates",
				false,
				"Set this to true if you want to ONLY access Zollern Galaxy " + "planets using rockets. "
						+ "WARNING: will not work without another add-on this way! (default: false)").getBoolean();
		
		// Misc (Temperatures shown in fahrenheit or celsius?)
		temperatureType = configuration.get(CATEGORY_MISC, "[HUD DISPLAY] Temperature Type (F or C only)", "F",
				"Should temperatures be shown in Fahrenheit (F) or Celsius (C)? (default: F)").getString();
		
		// Compatibility (Whether or not to use Thermal Foundation's Detabilized
		// Redstone
		// for the Red Sea in Oasis)
		shouldOasisUseLiquidRedstone = configuration.get(
				CATEGORY_COMPATIBILITY,
				"Oasis uses Thermal Foundation's Destabilized Redstone",
				true,
				"Whether or not Oasis should use Detabilized Redstone for its Red Sea biome. "
						+ "WARNING: This can use a LOT of your PC's memory! "
						+ "This can lead to severe LAG! Use at your own risk. (default: true)").getBoolean();
		
		// Compatibility (Whether or not Thermal Foundation Pulverizers should
		// give extra
		// (4) instead of normal (2))
		enableExtraPulverizerOutput = configuration.get(
				CATEGORY_COMPATIBILITY,
				"Enable extra Pulverizer Output",
				true,
				"Whether or not Zollern Galaxy ores give extra dust from Thermal Foundation's Pulverizers. "
						+ "Disable if it causes compatibility issues (default: true).").getBoolean();
		
		// Compat (Should Fueltonium register as Uranium?)
		fueltoniumIsUranium = configuration.get(CATEGORY_COMPATIBILITY, "Fueltonium counts as Uranium", true,
				"Should Fueltonium register as Uranium? (default: true)").getBoolean();
		
		// Compat (Should Cobalt register in the Ore Dictionary?)
		registerCobaltOreDict = configuration.get(CATEGORY_COMPATIBILITY, "Register Cobalt in Ore Dictionary", true,
				"Set this to false if there are any problems " + " with mods like Tinker's Construct. (default: true)")
				.getBoolean();
		
		// Compat (Should intergration with Planet Progressions be enabled?
		enablePlanetProgressionsCompat = configuration.get(
				CATEGORY_COMPATIBILITY,
				"Enable Planet Progressions compatibility",
				true,
				"If Planet Progressions is installed, " + " you will need to discover the Planet or Moon "
						+ " before you can travel to it via Star Gates."
						+ " Set this to false to disable that. (default: true)").getBoolean();
		
		// Coords (Psios)
		psiosX = (float) configuration.get(CATEGORY_COORDINATES, "Psios X", -2.5).getDouble();
		psiosY = (float) configuration.get(CATEGORY_COORDINATES, "Psios Y", 1.2).getDouble();
		psiosZ = (float) configuration.get(CATEGORY_COORDINATES, "Psios Z", 0.8).getDouble();
		
		// Coords (Praedyth)
		praedythX = (float) configuration.get(CATEGORY_COORDINATES, "Praedyth X", -1.2).getDouble();
		praedythY = (float) configuration.get(CATEGORY_COORDINATES, "Praedyth Y", 1.4).getDouble();
		praedythZ = (float) configuration.get(CATEGORY_COORDINATES, "Praedyth Z", -0.3).getDouble();
		
		// Coords (Pantheon)
		pantheonX = (float) configuration.get(CATEGORY_COORDINATES, "Pantheon X", 2.0).getDouble();
		pantheonY = (float) configuration.get(CATEGORY_COORDINATES, "Pantheon Y", 1.2).getDouble();
		pantheonZ = (float) configuration.get(CATEGORY_COORDINATES, "Pantheon Z", 0.2).getDouble();
		
		// Coords (Olympus)
		olympusX = (float) configuration.get(CATEGORY_COORDINATES, "Olympus X", 1.5).getDouble();
		olympusY = (float) configuration.get(CATEGORY_COORDINATES, "Olympus Y", 1.5).getDouble();
		olympusZ = (float) configuration.get(CATEGORY_COORDINATES, "Olympus Z", 0.1).getDouble();
		
		// Coords (Asgard)
		asgardX = (float) configuration.get(CATEGORY_COORDINATES, "Asgard X", 3.0).getDouble();
		asgardY = (float) configuration.get(CATEGORY_COORDINATES, "Asgard Y", 1.2).getDouble();
		asgardZ = (float) configuration.get(CATEGORY_COORDINATES, "Asgard Z", 0.3).getDouble();
		
		// Coords (Vega)
		vegaX = (float) configuration.get(CATEGORY_COORDINATES, "Vega X", -1.0).getDouble();
		vegaY = (float) configuration.get(CATEGORY_COORDINATES, "Vega Y", 2.5).getDouble();
		vegaZ = (float) configuration.get(CATEGORY_COORDINATES, "Vega Z", -0.6).getDouble();
		
		// Coords (Nova)
		novaX = (float) configuration.get(CATEGORY_COORDINATES, "Nova X", -2.5).getDouble();
		novaY = (float) configuration.get(CATEGORY_COORDINATES, "Nova Y", 1.6).getDouble();
		novaZ = (float) configuration.get(CATEGORY_COORDINATES, "Nova Z", -2.0).getDouble();
		
		configuration.save();
	}
}