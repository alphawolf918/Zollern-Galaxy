package zollerngalaxy.core.dimensions;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.core.util.WorldUtil;
import net.minecraft.world.DimensionType;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitEden;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitZollus;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.planets.ZGPlanets;

public class ZGDimensions {
	
	// Psion-6
	public static DimensionType ZOLLUS;
	public static DimensionType ZOLLUS_ORBIT;
	public static DimensionType ZOLLUS_ORBIT_STATIC;
	public static DimensionType KRIFFON;
	public static DimensionType KRIFFON_ORBIT;
	public static DimensionType EDEN;
	public static DimensionType EDEN_ORBIT;
	public static DimensionType EDEN_ORBIT_STATIC;
	public static DimensionType PURGOT;
	public static DimensionType PURGOT_ORBIT;
	public static DimensionType PURGOT_ORBIT_STATIC;
	public static DimensionType ASTROS;
	
	// Praedyth
	public static DimensionType XATHIUS;
	public static DimensionType XATHIUS_ORBIT;
	public static DimensionType XATHIUS_ORBIT_STATIC;
	public static DimensionType OASIS;
	public static DimensionType OASIS_ORBIT;
	public static DimensionType OASIS_ORBIT_STATIC;
	public static DimensionType XANTHEON;
	public static DimensionType XANTHEON_ORBIT;
	public static DimensionType XANTHEON_ORBIT_STATIC;
	public static DimensionType CANDORA;
	public static DimensionType CANDORA_ORBIT;
	public static DimensionType CANDORA_ORBIT_STATIC;
	public static DimensionType ATHEON;
	public static DimensionType ATHEON_ORBIT;
	public static DimensionType ATHEON_ORBIT_STATIC;
	
	public static void init() {
		// Psion-6 (Zollus)
		ZGDimensions.ZOLLUS = ZGDimensions.getDimType(ConfigManagerZG.planetZollusDimensionId);
		ZGDimensions.ZOLLUS_ORBIT = DimensionType.register("Zollus Space Station", "_zollus_orbit",
				ConfigManagerZG.spaceStationZollusId, WorldProviderOrbitZollus.class, false);
		ZGDimensions.ZOLLUS_ORBIT_STATIC = DimensionType.register("Zollus Space Station", "_zollus_orbit",
				ConfigManagerZG.spaceStationZollusStaticId, WorldProviderOrbitZollus.class, false);
		
		// Psion-6 (Kriffon)
		ZGDimensions.KRIFFON = ZGDimensions.getDimType(ConfigManagerZG.planetKriffonDimensionId);
		
		// Psion-6 (Purgot)
		ZGDimensions.PURGOT = ZGDimensions.getDimType(ConfigManagerZG.planetPurgotDimensionId);
		
		// Psion-6 (Eden)
		ZGDimensions.EDEN = ZGDimensions.getDimType(ConfigManagerZG.planetEdenDimensionId);
		ZGDimensions.EDEN_ORBIT = DimensionType.register("Eden Space Station", "_eden_orbit",
				ConfigManagerZG.spaceStationEdenId, WorldProviderOrbitEden.class, false);
		ZGDimensions.EDEN_ORBIT_STATIC = DimensionType.register("Eden Space Station", "_eden_orbit",
				ConfigManagerZG.spaceStationEdenStaticId, WorldProviderOrbitEden.class, true);
		
		// Praedyth
		ZGDimensions.XATHIUS = ZGDimensions.getDimType(ConfigManagerZG.planetXathiusDimensionId);
		ZGDimensions.OASIS = ZGDimensions.getDimType(ConfigManagerZG.planetOasisDimensionId);
		ZGDimensions.XANTHEON = ZGDimensions.getDimType(ConfigManagerZG.planetXantheonDimensionId);
		ZGDimensions.CANDORA = ZGDimensions.getDimType(ConfigManagerZG.planetCandoraDimensionId);
		ZGDimensions.ATHEON = ZGDimensions.getDimType(ConfigManagerZG.planetAtheonDimensionId);
	}
	
	public static DimensionType getDimType(int dimId) {
		return WorldUtil.getDimensionTypeById(dimId);
	}
	
	public static CelestialBody getCelestialBodyByID(int dimID) {
		CelestialBody body = null;
		if (dimID == ConfigManagerZG.planetZollusDimensionId) {
			body = ZGPlanets.planetZollus;
		} else if (dimID == ConfigManagerZG.planetKriffonDimensionId) {
			body = ZGPlanets.planetKriffon;
		} else if (dimID == ConfigManagerZG.planetPurgotDimensionId) {
			body = ZGPlanets.planetPurgot;
		} else if (dimID == ConfigManagerZG.planetEdenDimensionId) {
			body = ZGPlanets.planetEden;
		} else if (dimID == ConfigManagerZG.planetXathiusDimensionId) {
			body = ZGPlanets.planetXathius;
		} else if (dimID == ConfigManagerZG.planetOasisDimensionId) {
			body = ZGPlanets.planetOasis;
		} else if (dimID == ConfigManagerZG.planetXantheonDimensionId) {
			body = ZGPlanets.planetXantheon;
		} else if (dimID == ConfigManagerZG.planetCandoraDimensionId) {
			body = ZGPlanets.planetCandora;
		} else if (dimID == ConfigManagerZG.planetAtheonDimensionId) {
			body = ZGPlanets.planetAtheon;
		}
		if (body == null) {
			ZGHelper.Log("Celestial Body was null.");
		}
		return body;
	}
	
}