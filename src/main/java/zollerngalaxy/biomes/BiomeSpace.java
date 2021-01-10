/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes;

import java.util.List;
import java.util.Random;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedCreeper;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedEnderman;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSkeleton;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedWitch;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import net.minecraft.block.Block;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderZG;
import zollerngalaxy.planets.ZGPlanet;

public class BiomeSpace extends ZGBiomeBase {
	
	protected ZGPlanet planetForBiome = null;
	protected WorldProviderZG spaceProvider = null;
	protected boolean enableExtremeMode = ConfigManagerZG.enableExtremeMode;
	public static int grassFoliageColor = 0x00ff00;
	
	protected static BiomeSpace INSTANCE;
	
	public BiomeSpace(BiomeProperties properties) {
		super(properties);
		INSTANCE = this;
		this.init();
	}
	
	public BiomeSpace(String biomeName) {
		super(new BiomeProperties(biomeName));
		INSTANCE = this;
		this.init();
	}
	
	public BiomeSpace(String singleName, BiomeProperties props) {
		super(singleName, props);
		INSTANCE = this;
		this.init();
	}
	
	private void init() {
		int numSpawn = 4;
		numSpawn *= (this.enableExtremeMode) ? 2 : 1;
		this.clearAllSpawning();
		List<SpawnListEntry> monsterList = this.spawnableMonsterList;
		monsterList.add(new SpawnListEntry(EntityEvolvedZombie.class, 100, numSpawn, numSpawn));
		monsterList.add(new SpawnListEntry(EntityEvolvedSpider.class, 100, numSpawn, numSpawn));
		monsterList.add(new SpawnListEntry(EntityEvolvedSkeleton.class, 100, numSpawn, numSpawn));
		monsterList.add(new SpawnListEntry(EntityEvolvedCreeper.class, 100, numSpawn, numSpawn));
		monsterList.add(new SpawnListEntry(EntityEvolvedEnderman.class, 100, numSpawn, numSpawn));
		monsterList.add(new SpawnListEntry(EntityEvolvedWitch.class, 100, numSpawn, numSpawn));
	}
	
	public static BiomeSpace instance() {
		return INSTANCE;
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
	
	public BiomeSpace setSpaceProvider(WorldProviderZG provider) {
		this.spaceProvider = provider;
		return this;
	}
	
	public WorldProviderZG getSpaceProvider() {
		return this.spaceProvider;
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
		
		int tempChangeBy = (this.enableExtremeMode) ? 50 : 25;
		
		float maxTemp = planetTemp + tempChangeBy;
		float minTemp = planetTemp - tempChangeBy;
		
		if (planet.getIsColdPlanet()) {
			flucTemp -= biomeTemp;
		} else if (planet.getIsHotPlanet()) {
			flucTemp += biomeTemp;
		} else {
			flucTemp = planetTemp + biomeTemp;
		}
		
		if (planetTemp < minTemp) {
			planetTemp = minTemp;
		}
		
		if (planetTemp > maxTemp) {
			planetTemp = maxTemp;
		}
		
		return flucTemp;
	}
}