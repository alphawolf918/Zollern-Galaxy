/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
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
		
		if (ModHelperBase.useTinkerConstruct) {
			TinkersConstructCompatibility.init();
		}
	}
}