/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.celestial;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zollerngalaxy.core.enums.EnumBodyClass;

public interface IZollernBody {
	
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
	public float getMoonTemperature();
	
	/**
	 * Determines the base temperature of the planet, affected by biome temps.
	 * 
	 * @param world
	 * @param pos
	 * @return The planet's base temperature, affected by biome temps.
	 */
	public float getMoonTemperature(World world, BlockPos pos);
	
	/**
	 * Determines if planet is breathable.
	 * 
	 * @return True/False
	 */
	public boolean getIsBreathable();
	
	/**
	 * Whether or not a planet has precipitation.
	 * 
	 * @return True/False
	 */
	public boolean getHasRain();
	
	/**
	 * The level of wind on the planet.
	 * 
	 * @return Wind level.
	 */
	public float getWindLevel();
	
	/**
	 * Gets the density of the atmosphere. Affects sound and gravity. 1.0F is
	 * like Overworld.
	 * 
	 * @return Atmospheric density.
	 */
	public float getAtmosphericDensity();
	
	public EnumBodyClass getMoonClass();
	
	public boolean getIsCorrosive();
	
	public String getGasses();
	
	/**
	 * @return
	 */
	public boolean getIsHotMoon();
	
	/**
	 * @return
	 */
	public boolean getIsColdMoon();
	
	/**
	 * @return
	 */
	public String getName();
}