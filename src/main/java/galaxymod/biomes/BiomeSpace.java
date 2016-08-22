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
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeSpace extends BiomeGenBase {
	
	protected PlanetNova planetForBiome = null;
	public static int grassFoilageColorMultiplier = 0x00ff00;
	public static int chunkHeightModifier = 12;
	public static int biomeHeightBaseModifier = 232;
	
	// public WorldProviderNova providerNova = this.getNovaWorldProvider();
	
	public BiomeSpace(int par1) {
		super(par1);
		this.setColor(BiomeList.biomeColor);
		this.setChunkHeightModifier(this.chunkHeightModifier);
		this.setHeightBaseModifier(this.biomeHeightBaseModifier);
	}
	
	/**
	 * Checks if it's day time or not.
	 * 
	 * @return Whether or not it's day time.
	 */
	// public boolean isDaytime() {
	// PlanetNova biomePlanet = this.getPlanetForBiome();
	// Class<? extends WorldProviderNova> provider = (Class<? extends
	// WorldProviderNova>) biomePlanet
	// .getWorldProvider();
	// try {
	// WorldProviderNova worldProvider = provider.getDeclaredConstructor()
	// .newInstance();
	//
	// } catch (InstantiationException | IllegalAccessException
	// | IllegalArgumentException | InvocationTargetException
	// | NoSuchMethodException | SecurityException e) {
	// NovaHelper.logMessage("A fatal error was detected.", Level.FATAL);
	// e.printStackTrace();
	// }
	// return false;
	// }
	
	public BiomeSpace setPlanetForBiome(PlanetNova planet) {
		this.planetForBiome = planet;
		return this;
	}
	
	public PlanetNova getPlanetForBiome() {
		return this.planetForBiome;
	}
	
	public boolean getIsHotBiome() {
		return (this.getBiomeTemp() >= 8F);
	}
	
	public boolean getIsColdBiome() {
		return (this.getBiomeTemp() <= 3F);
	}
	
	public BiomeSpace setHeightBaseModifier(int bioHeight) {
		this.biomeHeightBaseModifier = bioHeight;
		return this;
	}
	
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
		float planetTemp = planet.getPlanetTemperature();
		if (planet.getIsColdPlanet()) {
			planetTemp -= biomeTemp;
		} else if (planet.getIsHotPlanet()) {
			planetTemp += biomeTemp;
		} else {
			// planetTemp *= (.01 * biomeTemp);
		}
		// if (!this.isDaytime()) {
		// Random rand = new Random();
		// int divideBy = rand.nextInt(5);
		// divideBy = (divideBy > 1) ? divideBy : 2;
		// planetTemp /= divideBy;
		// }
		return planetTemp;
	}
	
}