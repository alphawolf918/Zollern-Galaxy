package zollerngalaxy.compatibility;

import zollerngalaxy.lib.helpers.ModHelperBase;

public class ZGCompats {
	
	public static void init() {
		if (ModHelperBase.useExtremeReactors) {
			ExtremeReactorsCompatibility.init();
		}
		
		if (ModHelperBase.usePlanetProgression) {
			PlanetProgressionCompatibility.init();
		}
		
		if (ModHelperBase.useThermalFoundation) {
			ThermalFoundationCompatibility.init();
		}
	}
	
}