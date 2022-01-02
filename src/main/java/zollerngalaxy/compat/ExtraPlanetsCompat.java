/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.compat;

import zollerngalaxy.config.ConfigManagerZG;

public class ExtraPlanetsCompat {
	
	public static void init() {
		if (!ConfigManagerZG.enableExtraPlanetsCompat) {
			return;
		}
	}
}