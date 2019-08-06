package zollerngalaxy.biomes;

import java.util.Random;
import net.minecraft.block.Block;
import zollerngalaxy.planets.ZGPlanet;

public class BiomeSpace extends ZGBiomeBase {
	
	protected ZGPlanet planetForBiome = null;
	public static int grassFoliageColor = 0x00ff00;
	
	public BiomeSpace(BiomeProperties properties) {
		super(properties);
	}
	
	public BiomeSpace(String singleName, BiomeProperties props) {
		super(singleName, props);
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
	 * @return True if the biome temp is >= 7.0f, otherwise false.
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
		this.temp = biomeTemp;
		return this;
	}
	
	/**
	 * Returns the temperature of the current biome.
	 * 
	 * @return Biome temp.
	 */
	public float getBiomeTemp() {
		return this.temp;
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
		
		float planetTemp = planet.getPlanetTemperature();
		float flucTemp = planetTemp;
		
		float maxTemp = planetTemp + 25;
		float minTemp = planetTemp - 25;
		
		if (planet.getIsColdPlanet()) {
			flucTemp -= biomeTemp;
		} else if (planet.getIsHotPlanet()) {
			flucTemp += biomeTemp;
		} else {
			int rng = rand.nextInt(200);
			if (rng == 25) {
				flucTemp += biomeTemp;
			} else if (rng == 50) {
				flucTemp -= biomeTemp;
			}
			
		}
		return flucTemp;
	}
}