/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.celestial.starsystems;

import micdoodle8.mods.galacticraft.api.galaxies.SolarSystem;
import zollerngalaxy.celestial.Galaxy;
import zollerngalaxy.celestial.GalaxyListZG;

public class ZGStarSystem extends SolarSystem {
	
	public ZGStarSystem(String solarSystem) {
		super(solarSystem, GalaxyListZG.MILKY_WAY.getGalaxyName());
	}
	
	public ZGStarSystem(String solarSystem, String galaxyName) {
		super(solarSystem, galaxyName);
	}
	
	public ZGStarSystem(String solarSystem, Galaxy galaxy) {
		super(solarSystem, galaxy.getGalaxyName());
	}
	
	public void setGalaxy(Galaxy galaxy) {
		this.unlocalizedGalaxyName = galaxy.getGalaxyName();
	}
	
	public void setGalaxyName(String galaxyName) {
		this.unlocalizedGalaxyName = galaxyName;
	}
}