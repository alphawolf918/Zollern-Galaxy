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
			ExtremeReactorsCompat.init();
		}
		
		if (ModHelperBase.usePlanetProgression) {
			PlanetProgressionCompat.init();
		}
		
		if (ModHelperBase.useThermalFoundation) {
			ThermalFoundationCompat.init();
		}
		
		if (ModHelperBase.useTinkerConstruct) {
			TinkersConstructCompat.init();
		}
		
		if (ModHelperBase.useExtraPlanets) {
			ExtraPlanetsCompat.init();
		}
	}
}