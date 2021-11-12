/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.starsystems;

import micdoodle8.mods.galacticraft.api.galaxies.SolarSystem;
import zollerngalaxy.celestial.GalaxyListZG;

public class ZGStarSystem extends SolarSystem {
	
	public ZGStarSystem(String solarSystem) {
		super(solarSystem, GalaxyListZG.MILKY_WAY);
	}
	
	public ZGStarSystem(String solarSystem, String galaxy) {
		super(solarSystem, galaxy);
	}
}