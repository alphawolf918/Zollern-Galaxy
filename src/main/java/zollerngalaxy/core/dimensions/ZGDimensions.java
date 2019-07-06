package zollerngalaxy.core.dimensions;

import micdoodle8.mods.galacticraft.core.util.WorldUtil;
import net.minecraft.world.DimensionType;
import zollerngalaxy.config.ConfigManagerZG;

public class ZGDimensions {
	
	public static DimensionType ZOLLUS;
	
	public static void init() {
		ZGDimensions.ZOLLUS = WorldUtil
				.getDimensionTypeById(ConfigManagerZG.biomeZollusIcyLandsId);
	}
}