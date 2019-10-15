package zollerngalaxy.planets;

import java.util.HashMap;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.world.ITeleportType;
import micdoodle8.mods.galacticraft.core.dimension.TeleportTypeOrbit;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.WorldProvider;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitEden;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitZollus;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.lib.helpers.ZGRecipeHelper;
import zollerngalaxy.planets.satellites.ZGSpaceStation;

public class ZGSpaceStations {
	
	private static int totalSpaceStations = 0;
	
	// Psios-6
	public static ZGSpaceStation ZOLLUS_SPACE_STATION;
	public static ZGSpaceStation KRIFFON_SPACE_STATION;
	public static ZGSpaceStation PURGOT_SPACE_STATION;
	public static ZGSpaceStation EDEN_SPACE_STATION;
	
	// Praedyth
	public static ZGSpaceStation XATHIUS_SPACE_STATION;
	public static ZGSpaceStation OASIS_SPACE_STATION;
	public static ZGSpaceStation CANDORA_SPACE_STATION;
	public static ZGSpaceStation XANTHEON_SPACE_STATION;
	public static ZGSpaceStation ATHEON_SPACE_STATION;
	
	public static void init() {
		ZGSpaceStations.initSpaceStations();
		ZGSpaceStations.registerSpaceStations();
		ZGSpaceStations.registerSpaceStationRecipes();
		ZGHelper.Log("Loaded a total of " + totalSpaceStations + " new space stations.");
	}
	
	private static void initSpaceStations() {
		EDEN_SPACE_STATION = new ZGSpaceStation("eden", ZGPlanets.planetEden);
		EDEN_SPACE_STATION.setDimensionInfo(ConfigManagerZG.spaceStationEdenId, ConfigManagerZG.spaceStationEdenStaticId,
				WorldProviderOrbitEden.class);
		totalSpaceStations++;
		
		ZOLLUS_SPACE_STATION = new ZGSpaceStation("zollus", ZGPlanets.planetZollus);
		ZOLLUS_SPACE_STATION.setDimensionInfo(ConfigManagerZG.spaceStationZollusId,
				ConfigManagerZG.spaceStationZollusStaticId, WorldProviderOrbitZollus.class);
		totalSpaceStations++;
	}
	
	private static void registerSpaceStations() {
		// Psios-6 (Eden)
		GalaxyRegistry.registerSatellite(EDEN_SPACE_STATION);
		GalacticraftRegistry.registerTeleportType(WorldProviderOrbitEden.class, new TeleportTypeOrbit());
		GalacticraftRegistry.registerDimension("Eden Space Station", "_eden_orbit", ConfigManagerZG.spaceStationEdenId,
				WorldProviderOrbitEden.class, false);
		GalacticraftRegistry.registerDimension("Eden Space Station", "_eden_orbit",
				ConfigManagerZG.spaceStationEdenStaticId, WorldProviderOrbitEden.class, true);
		
		// Psios-6 (Zollus)
		GalaxyRegistry.registerSatellite(ZOLLUS_SPACE_STATION);
		GalacticraftRegistry.registerTeleportType(WorldProviderOrbitZollus.class, new TeleportTypeOrbit());
		GalacticraftRegistry.registerDimension("Zollus Space Station", "_zollus_orbit",
				ConfigManagerZG.spaceStationZollusId, WorldProviderOrbitZollus.class, false);
		GalacticraftRegistry.registerDimension("Zollus Space Station", "_zollus_orbit",
				ConfigManagerZG.spaceStationZollusStaticId, WorldProviderOrbitZollus.class, true);
	}
	
	public static void registerSpaceStationRecipes() {
		// Psios-6 (Eden)
		HashMap<Object, Integer> inputMap;
		inputMap = new HashMap<Object, Integer>();
		inputMap.put("ingotTin", 32);
		inputMap.put("waferAdvanced", 1);
		inputMap.put(new ItemStack(ZGItems.ingotVirinium, 1, 0), 24);
		inputMap.put(Items.IRON_INGOT, 24);
		ZGRecipeHelper.addSpaceStationRecipe(ConfigManagerZG.spaceStationEdenId, ConfigManagerZG.planetEdenDimensionId,
				inputMap);
		
		// Psios-6 (Zollus)
		inputMap = new HashMap<Object, Integer>();
		inputMap.put("ingotTin", 32);
		inputMap.put("waferAdvanced", 1);
		inputMap.put(new ItemStack(ZGItems.ingotCobalt, 1, 0), 24);
		inputMap.put(Items.IRON_INGOT, 24);
		ZGRecipeHelper.addSpaceStationRecipe(ConfigManagerZG.spaceStationZollusId, ConfigManagerZG.planetZollusDimensionId,
				inputMap);
		
	}
	
	private static void registerSpaceStation(ZGSpaceStation spaceStation, String stationName, String stationStringId,
			ITeleportType teleType, Class<? extends WorldProvider> providerClass, int stationId, int stationStaticId) {
		GalaxyRegistry.registerSatellite(spaceStation);
		GalacticraftRegistry.registerTeleportType(providerClass, teleType);
		GalacticraftRegistry.registerDimension(stationName, stationStringId, stationId, providerClass, false);
		GalacticraftRegistry.registerDimension(stationName, stationStringId, stationStaticId, providerClass, true);
	}
	
}