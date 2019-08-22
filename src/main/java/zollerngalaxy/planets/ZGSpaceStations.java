package zollerngalaxy.planets;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.core.dimension.TeleportTypeOrbit;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitEden;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.planets.satellites.ZGSpaceStation;

public class ZGSpaceStations {
	
	private static int totalSpaceStations = 0;
	
	public static ZGSpaceStation ZOLLUS_SPACE_STATION;
	public static ZGSpaceStation KRIFFON_SPACE_STATION;
	public static ZGSpaceStation PURGOT_SPACE_STATION;
	public static ZGSpaceStation EDEN_SPACE_STATION;
	
	public static void init() {
		ZGSpaceStations.initSpaceStations();
		ZGSpaceStations.registerSpaceStations();
		ZGHelper.Log("Loaded a total of " + totalSpaceStations + " new space stations.");
	}
	
	private static void initSpaceStations() {
		EDEN_SPACE_STATION = new ZGSpaceStation("eden", ZGPlanets.planetEden);
		EDEN_SPACE_STATION.setDimensionInfo(ConfigManagerZG.spaceStationEdenId,
				ConfigManagerZG.spaceStationEdenStaticId, WorldProviderOrbitEden.class);
		totalSpaceStations++;
	}
	
	private static void registerSpaceStations() {
		GalaxyRegistry.registerSatellite(EDEN_SPACE_STATION);
		GalacticraftRegistry.registerTeleportType(WorldProviderOrbitEden.class,
				new TeleportTypeOrbit());
		GalacticraftRegistry.registerDimension("Eden Space Station", "_eden_orbit",
				ConfigManagerZG.spaceStationEdenId, WorldProviderOrbitEden.class, false);
		GalacticraftRegistry.registerDimension("Eden Space Station", "_eden_orbit",
				ConfigManagerZG.spaceStationEdenStaticId, WorldProviderOrbitEden.class, true);
	}
	
}