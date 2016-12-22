/*******************************************************************************
 * Copyright 2016 Zollern Wolf
 * - Zollern Galaxy
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 * Steve Kung's "More Planets" mod was a big help.
 *******************************************************************************/

package galaxymod.core;

public interface IZollernPlanet {
	
	/**
	 * This only applies if the planet is radioactive. It returns the radiation
	 * level.
	 * 
	 * @return Radiation level of the planet.
	 */
	public float getRadiationLevel();
	
	/**
	 * This only applies if the planet is toxic. It returns the toxicity level.
	 * 
	 * @return Toxicity level of the planet.
	 */
	public float getToxicLevel();
	
	/**
	 * Determines the base temperature of the planet.
	 * 
	 * @return The planet's base temperature.
	 */
	public float getPlanetTemperature();
	
}