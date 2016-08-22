/*******************************************************************************
 * Copyright 2015 Zollern Wolf
 * - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 *******************************************************************************/

package galaxymod.core;

import micdoodle8.mods.galacticraft.api.galaxies.SolarSystem;
import micdoodle8.mods.galacticraft.api.galaxies.Star;
import micdoodle8.mods.galacticraft.api.vector.Vector3;

public class NovaSystem extends SolarSystem {
	
	public NovaSystem(String solarSystemName) {
		super(solarSystemName, "milkyWay");
	}
	
	public NovaSystem(String solarSystemName, Vector3 mapPosition) {
		super(solarSystemName, "milkyWay");
		this.setMapPosition(mapPosition);
	}
	
	public NovaSystem(String solarSystemName, Star mainStar) {
		super(solarSystemName, "milkyWay");
		this.setMainStar(mainStar);
	}
	
	public NovaSystem(String solarSystemName, Vector3 mapPosition, Star mainStar) {
		super(solarSystemName, "milkyWay");
		this.setMapPosition(mapPosition);
		this.setMainStar(mainStar);
	}
	
}