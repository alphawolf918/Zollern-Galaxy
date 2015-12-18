/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.core;

import java.util.ArrayList;
import micdoodle8.mods.galacticraft.api.galaxies.Planet;
import micdoodle8.mods.galacticraft.api.world.IAtmosphericGas;

public class PlanetNova extends Planet {
	
	private EnumPlanetClass planetClass;
	
	public PlanetNova(String planetName) {
		super(planetName);
	}
	
	public void setPlanetClass(EnumPlanetClass pClass) {
		this.planetClass = pClass;
	}
	
	public EnumPlanetClass getPlanetClass() {
		return this.planetClass;
	}
	
	public ArrayList<IAtmosphericGas> getGasses() {
		return this.atmosphere;
	}
}