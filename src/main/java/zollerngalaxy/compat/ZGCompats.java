/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.compat;

import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.lib.helpers.ModHelperBase;

public class ZGCompats {
	
	public static void init() {
		if (ModHelperBase.useExtremeReactors && ConfigManagerZG.enableExtremeReactorsCompat) {
			ExtremeReactorsCompat.init();
		}
		
		if (ModHelperBase.usePlanetProgression && ConfigManagerZG.enablePlanetProgressionsCompat) {
			PlanetProgressionCompat.init();
		}
		
		if (ModHelperBase.useThermalFoundation) {
			ThermalFoundationCompat.init();
		}
		
		if (ModHelperBase.useTinkerConstruct) {
			TinkersConstructCompat.init();
		}
		
		if (ModHelperBase.useExtraPlanets && ConfigManagerZG.enableExtraPlanetsCompat) {
			ExtraPlanetsCompat.init();
		}
		
		if (ModHelperBase.useAppliedEnergistics2) {
			AE2Compat.init();
		}
		
		if (ModHelperBase.useAvP) {
			AvPCompat.init();
		}
	}
}