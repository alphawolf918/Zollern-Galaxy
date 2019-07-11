package zollerngalaxy.core.dimensions;

import micdoodle8.mods.galacticraft.core.util.WorldUtil;
import net.minecraft.world.DimensionType;
import zollerngalaxy.config.ConfigManagerZG;

public class ZGDimensions {
	
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
		// ZGDimensions.EDEN = WorldUtil
		// .getDimensionTypeById(ConfigManagerZG.planetEdenDimensionId);
		ZGDimensions.PURGOT = WorldUtil
				.getDimensionTypeById(ConfigManagerZG.planetPurgotDimensionId);
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
}