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

package galaxymod.biomes;

import galaxymod.core.PlanetNova;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeSpace extends BiomeGenBase {
	
	protected PlanetNova planetForBiome = null;
	public static int grassFoilageColorMultiplier = 0x00ff00;
	public static int chunkHeightModifier = 12;
	public static int biomeHeightBaseModifier = 232;
	protected static World world = null;
	
	public BiomeSpace(int par1) {
		super(par1);
		this.setColor(BiomeList.biomeColor);
		this.setChunkHeightModifier(this.getChunkHeightModifier());
		this.setHeightBaseModifier(this.getHeightBaseModifier());
	}
	
	/**
	 * Gets the World object for this biome using Java Reflection.
	 * 
	 * @param provider
	 *            The WorldProvider class to use.
	 * @return The World object for this biome.
	 */
	// public World getWorldObj(Class<? extends WorldProviderNova> provider) {
	// World worldObj = null;
	// try {
	// worldObj = (World) provider.getMethod("getWorldObj").invoke(null);
	// } catch (IllegalAccessException | IllegalArgumentException
	// | InvocationTargetException | NoSuchMethodException
	// | SecurityException e) {
	// NovaHelper.logMessage(
	// "Encountered a fatal error! Localized message: "
	// + e.getLocalizedMessage(), Level.FATAL);
	// e.printStackTrace();
	// }
	// return worldObj;
	// }
	
	public World getWorld() {
		return this.world;
	}
	
	/**
	 * Gets if it's currently day time or not.
	 * 
	 * @return True if day time, false if not.
	 */
	// public boolean getIsDaytime() {
	// PlanetNova planet = this.getPlanetForBiome();
	// Class<? extends WorldProviderNova> provider = (Class<? extends
	// WorldProviderNova>) planet
	// .getWorldProvider();
	// World worldObj = this.getWorldObj(provider);
	// boolean isDayTime = false;
	// if (worldObj.skylightSubtracted < 4) {
	// isDayTime = true;
	// }
	// return isDayTime;
	// }
	
	/**
	 * Sets the Planet to be associated with this biome.
	 * 
	 * @param planet
	 *            The Planet to associate with this biome.
	 * @return The biome for the set Planet.
	 */
	public BiomeSpace setPlanetForBiome(PlanetNova planet) {
		this.planetForBiome = planet;
		return this;
	}
	
	/**
	 * Gets the Planet associated with this biome.
	 * 
	 * @return The Planet associated with this biome.
	 */
	public PlanetNova getPlanetForBiome() {
		return this.planetForBiome;
	}
	
	/**
	 * Checks if the biome is a hot biome or not.
	 * 
	 * @return True if the biome temp is >= 8.0f, otherwise false.
	 */
	public boolean getIsHotBiome() {
		return (this.getBiomeTemp() >= 8F);
	}
	
	/**
	 * Checks if the biome is a cold biome or not.
	 * 
	 * @return True if the biome temp is <= 3.0f, otherwise false.
	 */
	public boolean getIsColdBiome() {
		return (this.getBiomeTemp() <= 3F);
	}
	
	/**
	 * Sets the base height for the biome to generate at (used in GenBases for
	 * biomes).
	 * 
	 * @param bioHeight
	 *            The min height of the biome to begin generating.
	 * @return The biome for this height modifier.
	 */
	public BiomeSpace setHeightBaseModifier(int bioHeight) {
		this.biomeHeightBaseModifier = bioHeight;
		return this;
	}
	
	/**
	 * Gets the base height for this biome.
	 * 
	 * @return
	 */
	public int getHeightBaseModifier() {
		return this.biomeHeightBaseModifier;
	}
	
	public BiomeSpace setChunkHeightModifier(int heightMod) {
		chunkHeightModifier = heightMod;
		return this;
	}
	
	public static int getChunkHeightModifier() {
		return chunkHeightModifier;
	}
	
	public BiomeSpace setBlocks(Block topBlock, Block fillerBlock) {
		this.topBlock = topBlock;
		this.fillerBlock = fillerBlock;
		return this;
	}
	
	/**
	 * Sets the Biome temperature.
	 * 
	 * @param biomeTemp
	 *            Biome temperature.
	 * @return The Planet to apply this biome to.
	 */
	public BiomeSpace setTemp(float biomeTemp) {
		this.temperature = biomeTemp;
		return this;
	}
	
	/**
	 * Returns the temperature of the current biome.
	 * 
	 * @return Biome temp.
	 */
	public float getBiomeTemp() {
		return this.temperature;
	}
	
	/**
	 * Returns the actual temperature of the Planet, taking biome temp into
	 * account.
	 * 
	 * @return The current temperature of the Planet.
	 */
	public float getPlanetTemp() {
		PlanetNova planet = this.getPlanetForBiome();
		float biomeTemp = this.getBiomeTemp();
		Random rand = new Random();
		float oldPlanetTemp = planet.getPlanetTemperature();
		float planetTemp = oldPlanetTemp;
		float maxTemp = oldPlanetTemp + 50;
		float minTemp = oldPlanetTemp - 50;
		if (planet.getIsColdPlanet()) {
			planetTemp -= biomeTemp;
		} else if (planet.getIsHotPlanet()) {
			planetTemp += biomeTemp;
		} else {
			if (rand.nextInt(50000) <= 2) {
				if (rand.nextInt(50) <= 25) {
					planetTemp += biomeTemp;
					planetTemp = (planetTemp > maxTemp) ? maxTemp : planetTemp;
				} else {
					planetTemp -= biomeTemp;
					planetTemp = (planetTemp < minTemp) ? minTemp : planetTemp;
				}
			}
		}
		// if (this.getIsDaytime()) {
		// planetTemp += (biomeTemp + rand.nextInt(5));
		// planetTemp = (planetTemp > maxTemp) ? maxTemp : planetTemp;
		// } else {
		// planetTemp -= (biomeTemp - rand.nextInt(5));
		// planetTemp = (planetTemp < minTemp) ? minTemp : planetTemp;
		// }
		return planetTemp;
	}
	
}