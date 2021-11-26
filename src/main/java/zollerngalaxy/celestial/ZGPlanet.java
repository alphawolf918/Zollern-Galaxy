/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.celestial;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;

public class ZGPlanet extends ZGPlanetaryBody {
	
	public ZGPlanet(String planetName) {
		super(planetName);
		// this.setPhaseShift(ZGInfo.floatPI);
	}
	
	public CelestialBody setRelativeDistanceFromCenter(float scaledDistance) {
		this.setRelativeDistanceFromCenter(new ScalableDistance(scaledDistance, scaledDistance));
		return this;
	}
	
	public CelestialBody setRelativeDistanceFromCenter(float scaledDistance1, float scaledDistance2) {
		this.setRelativeDistanceFromCenter(new ScalableDistance(scaledDistance1, scaledDistance2));
		return this;
	}
}