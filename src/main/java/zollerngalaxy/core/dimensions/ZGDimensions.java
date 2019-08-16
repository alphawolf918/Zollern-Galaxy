package zollerngalaxy.core.dimensions;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.core.util.WorldUtil;
import net.minecraft.world.DimensionType;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.ZollernGalaxyCore;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.planets.ZGPlanets;
import zollerngalaxy.proxy.IProxy;

public class ZGDimensions {
	
	private static IProxy proxy = ZollernGalaxyCore.proxy;
	
	// Psion-6
	public static DimensionType ZOLLUS;
	public static DimensionType KRIFFON;
	public static DimensionType EDEN;
	public static DimensionType PURGOT;
	public static DimensionType ASTROS;
	
	// Praedyth
	public static DimensionType OASIS;
	public static DimensionType XATHIUS;
	
	public static void init() {
		// Psion-6
		ZGDimensions.ZOLLUS = ZGDimensions.getDimType(ConfigManagerZG.planetZollusDimensionId);
		ZGDimensions.KRIFFON = ZGDimensions.getDimType(ConfigManagerZG.planetKriffonDimensionId);
		ZGDimensions.PURGOT = WorldUtil
				.getDimensionTypeById(ConfigManagerZG.planetPurgotDimensionId);
		ZGDimensions.EDEN = WorldUtil.getDimensionTypeById(ConfigManagerZG.planetEdenDimensionId);
		//
		// // Praedyth
		// ZGDimensions.OASIS = WorldUtil
		// .getDimensionTypeById(ConfigManagerZG.planetOasisDimensionId);
		// ZGDimensions.XATHIUS = WorldUtil
		// .getDimensionTypeById(ConfigManagerZG.planetXathiusDimensionId);
		// ZGDimensions.ASTROS = WorldUtil
		// .getDimensionTypeById(ConfigManagerZG.moonAstrosDimensionId);
		
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
		}
		if (body == null) {
			ZGHelper.Log("Celestial Body was null.");
		}
		return body;
	}
	
}