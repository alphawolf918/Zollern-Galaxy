/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic
 * Final Frontier
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 ******************************************************************************/

package galaxymod.core.config;

import java.io.File;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ConfigManagerNova {
	
	static Configuration configuration;
	
	public static String CATEGORY_DIMENSIONS = "Dimensions";
	public static String CATEGORY_BIOMES = "Biomes";
	public static String CATEGORY_MOONS = "Moons";
	public static String CATEGORY_MISC = "MISCELLANEOUS";
	
	// Planets (Psios)
	public static int planetEdenDimensionId;
	public static int planetZollusDimensionId;
	public static int planetKriffonDimensionId;
	public static int planetPurgotDimensionId;
	public static int moonAstrosDimensionId;
	
	// Planets (Praedyth)
	public static int planetXathiusDimensionId;
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
	
	// Planets (Vega)
	public static int planetMeridianDimensionId;
	public static int planetRequiemDimensionId;
	
	// Planets (Nova)
	public static int planetPrimorDimensionId;
	
	// Biomes (Eden)
	public static int biomeEdenGreenLandsId;
	public static int biomeEdenRockMountainsId;
	public static int biomeEdenTerranValleyId;
	public static int biomeEdenBloodDesertId;
	public static int biomeEdenGardenId;
	public static int biomeEdenForestId;
	public static int biomeEdenMagmaLandsId;
	public static int biomeEdenSnowyPlainsId;
	public static int biomeEdenSwamplandsId;
	
	// Biomes (Zollus)
	public static int biomeZollusIcyLandsId;
	
	// Biomes (Kriffon)
	public static int biomeKriffonFlamingPlainsId;
	
	// Biomes (Purgot)
	public static int biomePurgatoryId;
	
	// Misc (Can Earth animals generate on Eden?)
	public static boolean canEarthAnimalsSpawnOnEden;
	
	public static void init(FMLPreInitializationEvent event) {
		configuration = new Configuration(new File(event
				.getModConfigurationDirectory().getAbsolutePath()
				+ "/ProjectNova/core.cfg"));
		
		configuration.load();
		
		// Planets (Psios)
		planetEdenDimensionId = configuration.get(CATEGORY_DIMENSIONS,
				"Planet Eden Dimension ID", -32).getInt();
		planetZollusDimensionId = configuration.get(CATEGORY_DIMENSIONS,
				"Planet Zollus Dimension ID", -31).getInt();
		planetKriffonDimensionId = configuration.get(CATEGORY_DIMENSIONS,
				"Planet Kriffon Dimension ID", -33).getInt();
		planetPurgotDimensionId = configuration.get(CATEGORY_DIMENSIONS,
				"Planet Purgot Dimension ID", -34).getInt();
		
		// Moons (Psios -> Purgot -> Astros)
		moonAstrosDimensionId = configuration.get(CATEGORY_MOONS,
				"Moon Astros Dimension ID", -50).getInt();
		
		// Planets (Praedyth)
		planetXathiusDimensionId = configuration.get(CATEGORY_DIMENSIONS,
				"Planet Xathius Dimension ID", -35).getInt();
		planetXantheonDimensionId = configuration.get(CATEGORY_DIMENSIONS,
				"Planet Xantheon Dimension ID", -36).getInt();
		planetAtheonDimensionId = configuration.get(CATEGORY_DIMENSIONS,
				"Planet Atheon Dimension ID", -37).getInt();
		
		// Planets (Pantheon)
		planetMeztliDimensionId = configuration.get(CATEGORY_DIMENSIONS,
				"Planet Meztli Dimension ID", -38).getInt();
		planetCentotlDimensionId = configuration.get(CATEGORY_DIMENSIONS,
				"Planet Centotl Dimension ID", -39).getInt();
		planetTociDimensionId = configuration.get(CATEGORY_DIMENSIONS,
				"Planet Toci Dimension ID", -40).getInt();
		planetTlalocDimensionId = configuration.get(CATEGORY_DIMENSIONS,
				"Planet Tlaloc Dimension ID", -41).getInt();
		
		// Planets (Olympus)
		planetAresDimensionId = configuration.get(CATEGORY_DIMENSIONS,
				"Planet Ares Dimension ID", -42).getInt();
		planetPrometheusDimensionId = configuration.get(CATEGORY_DIMENSIONS,
				"Planet Ares Dimension ID", -43).getInt();
		planetIcarusDimensionId = configuration.get(CATEGORY_DIMENSIONS,
				"Planet Icarus Dimension ID", -44).getInt();
		planetKronosDimensionId = configuration.get(CATEGORY_DIMENSIONS,
				"Planet Kronos Dimension ID", -45).getInt();
		
		// Planets (Asgard)
		planetAsgardDimensionId = configuration.get(CATEGORY_DIMENSIONS,
				"Planet Asgard Dimension ID", -46).getInt();
		
		// Planets (Vega)
		planetMeridianDimensionId = configuration.get(CATEGORY_DIMENSIONS,
				"Planet Meridian Dimension ID", -47).getInt();
		planetRequiemDimensionId = configuration.get(CATEGORY_DIMENSIONS,
				"Planet Requiem Dimension ID", -48).getInt();
		
		// Planets (Nova)
		planetPrimorDimensionId = configuration.get(CATEGORY_DIMENSIONS,
				"Planet Primor Dimension ID", -49).getInt();
		
		// Biomes (Eden)
		biomeEdenGreenLandsId = configuration.get(CATEGORY_BIOMES,
				"Eden Green Lands Biome ID", 178).getInt();
		biomeEdenRockMountainsId = configuration.get(CATEGORY_BIOMES,
				"Eden Rock Mountains Biome ID", 177).getInt();
		biomeEdenTerranValleyId = configuration.get(CATEGORY_BIOMES,
				"Eden Terran Valley Biome ID", 176).getInt();
		biomeEdenBloodDesertId = configuration.get(CATEGORY_BIOMES,
				"Eden Blood Desert Biome ID", 175).getInt();
		biomeEdenGardenId = configuration.get(CATEGORY_BIOMES,
				"Eden Garden Biome ID", 174).getInt();
		biomeEdenForestId = configuration.get(CATEGORY_BIOMES,
				"Eden Forest Biome ID", 173).getInt();
		biomeEdenMagmaLandsId = configuration.get(CATEGORY_BIOMES,
				"Eden Magma Lands Biome ID", 172).getInt();
		biomeEdenSnowyPlainsId = configuration.get(CATEGORY_BIOMES,
				"Eden Snowy Plains Biome ID", 171).getInt();
		biomeEdenSwamplandsId = configuration.get(CATEGORY_BIOMES,
				"Eden Swamplands Biome ID", 170).getInt();
		
		// Biomes (Zollus)
		biomeZollusIcyLandsId = configuration.get(CATEGORY_BIOMES,
				"Zollus Icy Lands Biome ID", 169).getInt();
		
		// Biomes (Kriffon)
		biomeKriffonFlamingPlainsId = configuration.get(CATEGORY_BIOMES,
				"Kriffon Flaming Plains Biome ID", 168).getInt();
		
		// Biomes (Purgot)
		biomePurgatoryId = configuration.get(CATEGORY_BIOMES,
				"Purgot Purgatory Biome ID", 167).getInt();
		
		// Misc (Can Earth animals spawn on Eden?)
		canEarthAnimalsSpawnOnEden = configuration.get(CATEGORY_MISC,
				"Earth Animals Spawn On Eden", false).getBoolean();
		
		configuration.save();
	}
}