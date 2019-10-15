package zollerngalaxy.planets;

import java.util.HashMap;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.core.dimension.TeleportTypeOrbit;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitEden;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.lib.helpers.ZGRecipeHelper;
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
		EDEN_SPACE_STATION.setDimensionInfo(ConfigManagerZG.spaceStationEdenId, ConfigManagerZG.spaceStationEdenStaticId,
				WorldProviderOrbitEden.class);
		totalSpaceStations++;
	}
	
	private static void registerSpaceStations() {
		GalaxyRegistry.registerSatellite(EDEN_SPACE_STATION);
		GalacticraftRegistry.registerTeleportType(WorldProviderOrbitEden.class, new TeleportTypeOrbit());
		GalacticraftRegistry.registerDimension("Eden Space Station", "_eden_orbit", ConfigManagerZG.spaceStationEdenId,
				WorldProviderOrbitEden.class, false);
		GalacticraftRegistry.registerDimension("Eden Space Station", "_eden_orbit",
				ConfigManagerZG.spaceStationEdenStaticId, WorldProviderOrbitEden.class, true);
	}
	
	public static void registerSpaceStationRecipes() {
		HashMap<Object, Integer> inputMap;
		inputMap = new HashMap<Object, Integer>();
		inputMap.put("ingotTin", 32);
		inputMap.put("waferAdvanced", 1);
		inputMap.put(new ItemStack(ZGItems.ingotVirinium, 1, 0), 24);
		inputMap.put(Items.IRON_INGOT, 24);
		ZGRecipeHelper.addSpaceStationRecipe(ConfigManagerZG.spaceStationEdenId, ConfigManagerZG.planetEdenDimensionId,
				inputMap);
	}
	
}