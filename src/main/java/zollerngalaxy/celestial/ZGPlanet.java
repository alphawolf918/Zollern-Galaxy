/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.celestial;

import zollerngalaxy.lib.ZGInfo;

public class ZGPlanet extends ZGPlanetaryBody {
	
	public ZGPlanet(String planetName) {
		super(planetName);
		this.setPhaseShift(ZGInfo.floatPI);
	}
}