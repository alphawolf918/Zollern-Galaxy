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

import galaxymod.lib.NovaHelper;
import java.util.ArrayList;
import micdoodle8.mods.galacticraft.api.galaxies.Planet;
import micdoodle8.mods.galacticraft.api.galaxies.Star;
import micdoodle8.mods.galacticraft.api.world.IAtmosphericGas;

public class PlanetNova extends Planet {
	
	private EnumPlanetClass planetClass;
	private Star planetStar;
	
	public PlanetNova(String planetName) {
		super(planetName);
	}
	
	public PlanetNova setPlanetStar(Star systemStar) {
		this.planetStar = systemStar;
		return this;
	}
	
	public Star getPlanetStar() {
		return this.planetStar;
	}
	
	public PlanetNova setPlanetClass(EnumPlanetClass pClass) {
		this.planetClass = pClass;
		return this;
	}
	
	public EnumPlanetClass getPlanetClass() {
		return this.planetClass;
	}
	
	public String getGasses() {
		String gasList = "";
		ArrayList<IAtmosphericGas> planetAtmosphere = this.atmosphere;
		int ch = 0;
		for (IAtmosphericGas planetGas : planetAtmosphere) {
			ch++;
			gasList += NovaHelper.capitalizeFirstLetter(planetGas.toString()
					.substring(0, 1).toLowerCase());
			if (ch <= planetAtmosphere.size()) {
				gasList += ", ";
			}
		}
		return gasList;
	}
}