package zollerngalaxy.biomes;

import java.util.Random;
import net.minecraft.block.Block;
import zollerngalaxy.planets.ZGPlanet;

public class BiomeSpace extends ZollernBiome {
	
	protected ZGPlanet planetForBiome = null;
	public static int grassFoilageColorMultiplier = 0x00ff00;
	
	public BiomeSpace(BiomeProperties properties) {
		super(properties);
	}
	
	/**
	 * Sets the Planet to be associated with this biome.
	 * 
	 * @param planet
	 *            The Planet to associate with this biome.
	 * @return The biome for the set Planet.
	 */
	public BiomeSpace setPlanetForBiome(ZGPlanet planet) {
		this.planetForBiome = planet;
		return this;
	}
	
	/**
	 * Gets the Planet associated with this biome.
	 * 
	 * @return The Planet associated with this biome.
	 */
	public ZGPlanet getPlanetForBiome() {
		return this.planetForBiome;
	}
	
	/**
	 * Checks if the biome is a hot biome or not.
	 * 
	 * @return True if the biome temp is >= 8.0f, otherwise false.
	 */
	public boolean getIsHotBiome() {
		return (this.getBiomeTemp() >= 7F);
	}
	
	/**
	 * Checks if the biome is a cold biome or not.
	 * 
	 * @return True if the biome temp is <= 3.0f, otherwise false.
	 */
	public boolean getIsColdBiome() {
		return (this.getBiomeTemp() <= 3F);
	}
	
	@Override
	public BiomeSpace setBlocks(Block topBlock, Block fillerBlock) {
		this.topBlock = topBlock.getDefaultState();
		this.fillerBlock = fillerBlock.getDefaultState();
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
		this.setTemp(biomeTemp);
		return this;
	}
	
	/**
	 * Returns the temperature of the current biome.
	 * 
	 * @return Biome temp.
	 */
	public float getBiomeTemp() {
		return this.getBiomeTemp();
	}
	
	/**
	 * Returns the actual temperature of the Planet, taking biome temp into
	 * account.
	 * 
	 * @return The current temperature of the Planet.
	 */
	public float getPlanetTemp() {
		ZGPlanet planet = this.getPlanetForBiome();
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
			if (rand.nextInt(500) <= 25) {
				planetTemp += biomeTemp;
				// planetTemp = (planetTemp > maxTemp) ? maxTemp :
				// planetTemp;
			} else {
				planetTemp -= biomeTemp;
				// planetTemp = (planetTemp < minTemp) ? minTemp :
				// planetTemp;
			}
		}
		return planetTemp;
	}
}