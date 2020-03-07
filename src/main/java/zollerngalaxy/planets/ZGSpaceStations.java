package zollerngalaxy.planets;

import java.util.HashMap;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.core.dimension.TeleportTypeOrbit;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.WorldProvider;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitAtheon;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitCandora;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitEden;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitKriffon;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitOasis;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitPerdita;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitPurgot;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitXantheon;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitXathius;
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
	
	// Sol-2
	public static ZGSpaceStation PERDITA_SPACE_STATION;
	
	public static void init() {
		ZGSpaceStations.initSpaceStations();
		ZGSpaceStations.registerSpaceStations();
		ZGSpaceStations.registerSpaceStationRecipes();
		ZGHelper.Log("Loaded a total of " + totalSpaceStations + " new space stations.");
	}
	
	private static void initSpaceStations() {
		// Psios-6 (Zollus)
		ZOLLUS_SPACE_STATION = new ZGSpaceStation("zollus", ZGPlanets.planetZollus);
		ZOLLUS_SPACE_STATION.setDimensionInfo(ConfigManagerZG.spaceStationZollusId, ConfigManagerZG.spaceStationZollusStaticId,
				WorldProviderOrbitZollus.class);
		totalSpaceStations++;
		
		// Psios-6 (Eden)
		EDEN_SPACE_STATION = new ZGSpaceStation("eden", ZGPlanets.planetEden);
		EDEN_SPACE_STATION.setDimensionInfo(ConfigManagerZG.spaceStationEdenId, ConfigManagerZG.spaceStationEdenStaticId,
				WorldProviderOrbitEden.class);
		totalSpaceStations++;
		
		// Psios-6 (Kriffon)
		KRIFFON_SPACE_STATION = new ZGSpaceStation("kriffon", ZGPlanets.planetKriffon);
		KRIFFON_SPACE_STATION.setDimensionInfo(ConfigManagerZG.spaceStationKriffonId, ConfigManagerZG.spaceStationKriffonStaticId,
				WorldProviderOrbitKriffon.class);
		totalSpaceStations++;
		
		// Psios-6 (Purgot)
		PURGOT_SPACE_STATION = new ZGSpaceStation("purgot", ZGPlanets.planetPurgot);
		PURGOT_SPACE_STATION.setDimensionInfo(ConfigManagerZG.spaceStationPurgotId, ConfigManagerZG.spaceStationPurgotStaticId,
				WorldProviderOrbitPurgot.class);
		totalSpaceStations++;
		
		// Praedyth (Xathius)
		XATHIUS_SPACE_STATION = new ZGSpaceStation("xathius", ZGPlanets.planetXathius);
		XATHIUS_SPACE_STATION.setDimensionInfo(ConfigManagerZG.spaceStationXathiusId, ConfigManagerZG.spaceStationXathiusStaticId,
				WorldProviderOrbitXathius.class);
		totalSpaceStations++;
		
		// Praedyth (Oasis)
		OASIS_SPACE_STATION = new ZGSpaceStation("oasis", ZGPlanets.planetOasis);
		OASIS_SPACE_STATION.setDimensionInfo(ConfigManagerZG.spaceStationOasisId, ConfigManagerZG.spaceStationOasisStaticId,
				WorldProviderOrbitOasis.class);
		totalSpaceStations++;
		
		// Praedyth (Xantheon)
		XANTHEON_SPACE_STATION = new ZGSpaceStation("xantheon", ZGPlanets.planetXantheon);
		XANTHEON_SPACE_STATION.setDimensionInfo(ConfigManagerZG.spaceStationXantheonId, ConfigManagerZG.spaceStationXantheonStaticId,
				WorldProviderOrbitXantheon.class);
		totalSpaceStations++;
		
		// Praedyth (Candora)
		CANDORA_SPACE_STATION = new ZGSpaceStation("candora", ZGPlanets.planetCandora);
		CANDORA_SPACE_STATION.setDimensionInfo(ConfigManagerZG.spaceStationCandoraId, ConfigManagerZG.spaceStationCandoraStaticId,
				WorldProviderOrbitCandora.class);
		totalSpaceStations++;
		
		// Praedyth (Atheon)
		ATHEON_SPACE_STATION = new ZGSpaceStation("atheon", ZGPlanets.planetAtheon);
		ATHEON_SPACE_STATION.setDimensionInfo(ConfigManagerZG.spaceStationAtheonId, ConfigManagerZG.spaceStationAtheonStaticId,
				WorldProviderOrbitAtheon.class);
		totalSpaceStations++;
		
		// Sol-2 (Perdita)
		PERDITA_SPACE_STATION = new ZGSpaceStation("perdita", ZGPlanets.planetPerdita);
		PERDITA_SPACE_STATION.setDimensionInfo(ConfigManagerZG.spaceStationPerditaId, ConfigManagerZG.spaceStationPerditaStaticId,
				WorldProviderOrbitPerdita.class);
		totalSpaceStations++;
	}
	
	private static void registerSpaceStations() {
		// Psios-6 (Zollus)
		ZGSpaceStations.registerSpaceStation(ZOLLUS_SPACE_STATION, "Zollus Space Station", "_zollus_orbit", WorldProviderOrbitZollus.class,
				ConfigManagerZG.spaceStationZollusId, ConfigManagerZG.spaceStationZollusStaticId);
		
		// Psios-6 (Kriffon)
		ZGSpaceStations.registerSpaceStation(KRIFFON_SPACE_STATION, "Kriffon Space Station", "_kriffon_orbit",
				WorldProviderOrbitKriffon.class, ConfigManagerZG.spaceStationKriffonId, ConfigManagerZG.spaceStationKriffonStaticId);
		
		// Psios-6 (Purgot)
		ZGSpaceStations.registerSpaceStation(PURGOT_SPACE_STATION, "Purgot Space Station", "_purgot_orbit", WorldProviderOrbitPurgot.class,
				ConfigManagerZG.spaceStationPurgotId, ConfigManagerZG.spaceStationPurgotStaticId);
		
		// Psios-6 (Eden)
		ZGSpaceStations.registerSpaceStation(EDEN_SPACE_STATION, "Eden Space Station", "_eden_orbit", WorldProviderOrbitEden.class,
				ConfigManagerZG.spaceStationEdenId, ConfigManagerZG.spaceStationEdenStaticId);
		
		// Praedyth (Xathius)
		ZGSpaceStations.registerSpaceStation(XATHIUS_SPACE_STATION, "Xathius Space Station", "_xathius_orbit",
				WorldProviderOrbitXathius.class, ConfigManagerZG.spaceStationXathiusId, ConfigManagerZG.spaceStationXathiusStaticId);
		
		// Praedyth (Oasis)
		ZGSpaceStations.registerSpaceStation(OASIS_SPACE_STATION, "Oasis Space Station", "_oasis_orbit", WorldProviderOrbitOasis.class,
				ConfigManagerZG.spaceStationOasisId, ConfigManagerZG.spaceStationOasisStaticId);
		
		// Praedyth (Xantheon)
		ZGSpaceStations.registerSpaceStation(XANTHEON_SPACE_STATION, "Xantheon Space Station", "_xantheon_orbit",
				WorldProviderOrbitXantheon.class, ConfigManagerZG.spaceStationXantheonId, ConfigManagerZG.spaceStationXantheonStaticId);
		
		// Praedyth (Candora)
		ZGSpaceStations.registerSpaceStation(CANDORA_SPACE_STATION, "Candora Space Station", "_candora_orbit",
				WorldProviderOrbitCandora.class, ConfigManagerZG.spaceStationCandoraId, ConfigManagerZG.spaceStationCandoraStaticId);
		
		// Praedyth (Atheon)
		ZGSpaceStations.registerSpaceStation(ATHEON_SPACE_STATION, "Atheon Space Station", "_atheon_orbit", WorldProviderOrbitAtheon.class,
				ConfigManagerZG.spaceStationAtheonId, ConfigManagerZG.spaceStationAtheonStaticId);
		
		// Praedyth (Perdita)
		ZGSpaceStations.registerSpaceStation(PERDITA_SPACE_STATION, "Perdita Space Station", "_perdita_orbit",
				WorldProviderOrbitPerdita.class, ConfigManagerZG.spaceStationPerditaId, ConfigManagerZG.spaceStationPerditaStaticId);
	}
	
	public static void registerSpaceStationRecipes() {
		HashMap<Object, Integer> inputMap;
		
		// Psios-6 (Zollus)
		inputMap = new HashMap<Object, Integer>();
		inputMap.put("ingotTin", 32);
		inputMap.put("waferAdvanced", 1);
		inputMap.put(new ItemStack(ZGItems.heartium, 1, 0), 24);
		inputMap.put(Items.IRON_INGOT, 24);
		ZGRecipeHelper.addSpaceStationRecipe(ConfigManagerZG.spaceStationZollusId, ConfigManagerZG.planetZollusDimensionId, inputMap);
		
		// Psios-6 (Kriffon)
		inputMap = new HashMap<Object, Integer>();
		inputMap.put("ingotTin", 32);
		inputMap.put("waferAdvanced", 1);
		inputMap.put(new ItemStack(ZGItems.ingotCobalt, 1, 0), 24);
		inputMap.put(Items.IRON_INGOT, 24);
		ZGRecipeHelper.addSpaceStationRecipe(ConfigManagerZG.spaceStationKriffonId, ConfigManagerZG.planetKriffonDimensionId, inputMap);
		
		// Psios-6 (Purgot)
		inputMap = new HashMap<Object, Integer>();
		inputMap.put("ingotTin", 32);
		inputMap.put("waferAdvanced", 1);
		inputMap.put(new ItemStack(ZGItems.ingotEvenium, 1, 0), 24);
		inputMap.put(Items.IRON_INGOT, 24);
		ZGRecipeHelper.addSpaceStationRecipe(ConfigManagerZG.spaceStationPurgotId, ConfigManagerZG.planetPurgotDimensionId, inputMap);
		
		// Psios-6 (Eden)
		inputMap = new HashMap<Object, Integer>();
		inputMap.put("ingotTin", 32);
		inputMap.put("waferAdvanced", 1);
		inputMap.put(new ItemStack(ZGItems.ingotVirinium, 1, 0), 24);
		inputMap.put(Items.IRON_INGOT, 24);
		ZGRecipeHelper.addSpaceStationRecipe(ConfigManagerZG.spaceStationEdenId, ConfigManagerZG.planetEdenDimensionId, inputMap);
		
		// Praedyth (Xathius)
		inputMap = new HashMap<Object, Integer>();
		inputMap.put("ingotLead", 32);
		inputMap.put("waferAdvanced", 1);
		inputMap.put(new ItemStack(ZGItems.prometheanCrystal, 1, 0), 24);
		inputMap.put(Items.GOLD_INGOT, 24);
		ZGRecipeHelper.addSpaceStationRecipe(ConfigManagerZG.spaceStationXathiusId, ConfigManagerZG.planetXathiusDimensionId, inputMap);
		
		// Praedyth (Oasis)
		inputMap = new HashMap<Object, Integer>();
		inputMap.put("ingotLead", 32);
		inputMap.put("waferAdvanced", 1);
		inputMap.put(new ItemStack(ZGItems.superChargedCoal, 1, 0), 24);
		inputMap.put(Items.GOLD_INGOT, 24);
		ZGRecipeHelper.addSpaceStationRecipe(ConfigManagerZG.spaceStationOasisId, ConfigManagerZG.planetOasisDimensionId, inputMap);
		
		// Praedyth (Xantheon)
		inputMap = new HashMap<Object, Integer>();
		inputMap.put("ingotLead", 32);
		inputMap.put("waferAdvanced", 1);
		inputMap.put(new ItemStack(ZGItems.plutoniumCrystal, 1, 0), 24);
		inputMap.put(Items.GOLD_INGOT, 24);
		ZGRecipeHelper.addSpaceStationRecipe(ConfigManagerZG.spaceStationXantheonId, ConfigManagerZG.planetXantheonDimensionId, inputMap);
		
		// Praedyth (Candora)
		inputMap = new HashMap<Object, Integer>();
		inputMap.put("ingotLead", 32);
		inputMap.put("waferAdvanced", 1);
		inputMap.put(new ItemStack(ZGItems.iceCreamSandwich, 1, 0), 24);
		inputMap.put(Items.SUGAR, 24);
		ZGRecipeHelper.addSpaceStationRecipe(ConfigManagerZG.spaceStationCandoraId, ConfigManagerZG.planetCandoraDimensionId, inputMap);
		
		// Praedyth (Atheon)
		inputMap = new HashMap<Object, Integer>();
		inputMap.put("ingotLead", 32);
		inputMap.put("waferAdvanced", 1);
		inputMap.put(new ItemStack(ZGItems.ingotZollernium, 1, 0), 24);
		inputMap.put(ZGItems.ingotAmaranth, 24);
		ZGRecipeHelper.addSpaceStationRecipe(ConfigManagerZG.spaceStationAtheonId, ConfigManagerZG.planetAtheonDimensionId, inputMap);
		
		// Sol-2 (Perdita)
		inputMap = new HashMap<Object, Integer>();
		inputMap.put("ingotZucrite", 32);
		inputMap.put("waferAdvanced", 1);
		inputMap.put(new ItemStack(ZGItems.perdGlowdust, 1, 0), 24);
		inputMap.put(ZGItems.compressedEmerald, 24);
		ZGRecipeHelper.addSpaceStationRecipe(ConfigManagerZG.spaceStationPerditaId, ConfigManagerZG.planetPerditaDimensionId, inputMap);
	}
	
	private static void registerSpaceStation(ZGSpaceStation spaceStation, String stationName, String stationStringId,
			Class<? extends WorldProvider> providerClass, int stationId, int stationStaticId) {
		GalaxyRegistry.registerSatellite(spaceStation);
		GalacticraftRegistry.registerTeleportType(providerClass, new TeleportTypeOrbit());
		GalacticraftRegistry.registerDimension(stationName, stationStringId, stationId, providerClass, false);
		GalacticraftRegistry.registerDimension(stationName, stationStringId, stationStaticId, providerClass, true);
	}
	
}