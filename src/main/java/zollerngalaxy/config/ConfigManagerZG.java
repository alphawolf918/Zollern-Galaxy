package zollerngalaxy.config;

import java.io.File;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigManagerZG {
	
	public static Configuration configuration;
	
	public static String CATEGORY_DIMENSIONS = "Dimensions";
	public static String CATEGORY_MOONS = "Moons";
	public static String CATEGORY_MISC = "Miscallenous";
	
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
	public static int planetMeridianDimensionId;
	public static int planetRequiemDimensionId;
	
	// Planets (Nova)
	public static int planetPrimorDimensionId;
	
	// Misc
	public static boolean canEarthAnimalsSpawnOnEden;
	public static String temperatureType;
	
	public static void init(FMLPreInitializationEvent event) {
		configuration = new Configuration(new File(event.getModConfigurationDirectory()
				.getAbsolutePath() + "/ZollernGalaxy/core.cfg"));
		configuration.load();
		
		// Planets (Psios)
		planetEdenDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Eden Dimension ID",
				-7996).getInt();
		planetZollusDimensionId = configuration.get(CATEGORY_DIMENSIONS,
				"Planet Zollus Dimension ID", -7982).getInt();
		planetKriffonDimensionId = configuration.get(CATEGORY_DIMENSIONS,
				"Planet Kriffon Dimension ID", -7994).getInt();
		planetPurgotDimensionId = configuration.get(CATEGORY_DIMENSIONS,
				"Planet Purgot Dimension ID", -7988).getInt();
		
		// Moons (Psios -> Purgot -> Astros)
		moonAstrosDimensionId = configuration
				.get(CATEGORY_MOONS, "Moon Astros Dimension ID", -7981).getInt();
		
		// Planets (Praedyth)
		planetXathiusDimensionId = configuration.get(CATEGORY_DIMENSIONS,
				"Planet Xathius Dimension ID", -7983).getInt();
		planetOasisDimensionId = configuration.get(CATEGORY_DIMENSIONS,
				"Planet Oasis Dimension ID", -7990).getInt();
		planetXantheonDimensionId = configuration.get(CATEGORY_DIMENSIONS,
				"Planet Xantheon Dimension ID", -7984).getInt();
		planetAtheonDimensionId = configuration.get(CATEGORY_DIMENSIONS,
				"Planet Atheon Dimension ID", -7998).getInt();
		
		// Planets (Pantheon)
		planetMeztliDimensionId = configuration.get(CATEGORY_DIMENSIONS,
				"Planet Meztli Dimension ID", -7991).getInt();
		planetCentotlDimensionId = configuration.get(CATEGORY_DIMENSIONS,
				"Planet Centotl Dimension ID", -7997).getInt();
		planetTociDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Toci Dimension ID",
				-7985).getInt();
		planetTlalocDimensionId = configuration.get(CATEGORY_DIMENSIONS,
				"Planet Tlaloc Dimension ID", -7986).getInt();
		
		// Planets (Olympus)
		planetAresDimensionId = configuration.get(CATEGORY_DIMENSIONS, "Planet Ares Dimension ID",
				-8000).getInt();
		planetPrometheusDimensionId = configuration.get(CATEGORY_DIMENSIONS,
				"Planet Prometheus Dimension ID", -7981).getInt();
		planetIcarusDimensionId = configuration.get(CATEGORY_DIMENSIONS,
				"Planet Icarus Dimension ID", -7995).getInt();
		planetKronosDimensionId = configuration.get(CATEGORY_DIMENSIONS,
				"Planet Kronos Dimension ID", -7993).getInt();
		
		// Planets (Asgard)
		planetAsgardDimensionId = configuration.get(CATEGORY_DIMENSIONS,
				"Planet Asgard Dimension ID", -7999).getInt();
		planetMavethDimensionId = configuration.get(CATEGORY_DIMENSIONS,
				"Planet Asgard Dimension ID", -4552).getInt();
		
		// Planets (Vega)
		planetMeridianDimensionId = configuration.get(CATEGORY_DIMENSIONS,
				"Planet Meridian Dimension ID", -7992).getInt();
		planetRequiemDimensionId = configuration.get(CATEGORY_DIMENSIONS,
				"Planet Requiem Dimension ID", -7987).getInt();
		
		// Planets (Nova)
		planetPrimorDimensionId = configuration.get(CATEGORY_DIMENSIONS,
				"Planet Primor Dimension ID", -7989).getInt();
		
		// Misc (Can Earth animals spawn on Eden?)
		canEarthAnimalsSpawnOnEden = configuration.get(CATEGORY_MISC,
				"Earth Animals Spawn On Eden", true).getBoolean();
		
		// Misc (Temperatures shown in fahrenheit or celsius?)
		temperatureType = configuration.get(CATEGORY_MISC,
				"[HUD DISPLAY] Temperature Type (F or C only)", "F",
				"Should temperatures be shown in Fahrenheit (F) or Celsius (C)?").getString();
		
		configuration.save();
	}
}