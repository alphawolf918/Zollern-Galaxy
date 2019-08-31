package zollerngalaxy.core.dimensions;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.core.util.WorldUtil;
import net.minecraft.world.DimensionType;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.planets.ZGPlanets;

public class ZGDimensions {
	
	// Psion-6
	public static DimensionType ZOLLUS;
	public static DimensionType KRIFFON;
	public static DimensionType EDEN;
	public static DimensionType EDEN_ORBIT;
	public static DimensionType EDEN_ORBIT_STATIC;
	public static DimensionType PURGOT;
	public static DimensionType ASTROS;
	
	// Praedyth
	public static DimensionType XATHIUS;
	public static DimensionType OASIS;
	
	public static void init() {
		// Psion-6
		ZGDimensions.ZOLLUS = ZGDimensions.getDimType(ConfigManagerZG.planetZollusDimensionId);
		ZGDimensions.KRIFFON = ZGDimensions.getDimType(ConfigManagerZG.planetKriffonDimensionId);
		ZGDimensions.PURGOT = ZGDimensions.getDimType(ConfigManagerZG.planetPurgotDimensionId);
		ZGDimensions.EDEN = ZGDimensions.getDimType(ConfigManagerZG.planetEdenDimensionId);
		ZGDimensions.EDEN_ORBIT = ZGDimensions.getDimType(ConfigManagerZG.spaceStationEdenId);
		ZGDimensions.EDEN_ORBIT_STATIC = ZGDimensions.getDimType(ConfigManagerZG.spaceStationEdenStaticId);
		
		// Praedyth
		ZGDimensions.XATHIUS = ZGDimensions.getDimType(ConfigManagerZG.planetXathiusDimensionId);
		ZGDimensions.OASIS = ZGDimensions.getDimType(ConfigManagerZG.planetOasisDimensionId);
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
		}
		if (body == null) {
			ZGHelper.Log("Celestial Body was null.");
		}
		return body;
	}
	
}