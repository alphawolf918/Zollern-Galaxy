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
import zollerngalaxy.celestial.IZollernBody;
import zollerngalaxy.celestial.ZGMoon;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderPlanetZG;

public class BiomeSpace extends ZGBiomeBase {
	
	protected IZollernBody planetForBiome = null;
	protected WorldProviderPlanetZG spaceProvider = null;
	protected boolean enableExtremeMode = ConfigManagerZG.enableExtremeMode;
	protected int villagerSpawnRate = ConfigManagerZG.alienVillagerSpawnChance;
	protected int villagerMinSpawnRate = ConfigManagerZG.alienVillagerMinSpawnRate;
	protected int villagerMaxSpawnRate = ConfigManagerZG.alienVillagerMaxSpawnRate;
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
	 * Sets the Body to be associated with this biome.
	 * 
	 * @param planet
	 *            The Body to associate with this biome.
	 * @return The biome for the set Body.
	 */
	public BiomeSpace setPlanetForBiome(IZollernBody planet) {
		this.planetForBiome = planet;
		return this;
	}
	
	public BiomeSpace setBodyForBiome(IZollernBody planet) {
		this.setPlanetForBiome(planet);
		return this;
	}
	
	public BiomeSpace setMoonForBiome(ZGMoon moon) {
		this.setPlanetForBiome(moon);
		return this;
	}
	
	/**
	 * Gets the Body associated with this biome.
	 * 
	 * @return The Body associated with this biome.
	 */
	public IZollernBody getBodyForBiome() {
		return this.planetForBiome;
	}
	
	public BiomeSpace setSpaceProvider(WorldProviderPlanetZG provider) {
		this.spaceProvider = provider;
		return this;
	}
	
	public WorldProviderPlanetZG getSpaceProvider() {
		return this.spaceProvider;
	}
	
	/**
	 * Checks if the biome is a hot biome or not.
	 * 
	 * @return True if the biome temp is >= 7.0f, otherwise false.
	 */
	public boolean getIsHotBiome() {
		return (this.getBiomeTemp() >= 7F) || (this.getBodyForBiome().getIsHotBody());
	}
	
	/**
	 * Checks if the biome is a cold biome or not.
	 * 
	 * @return True if the biome temp is <= 3.0f, otherwise false.
	 */
	public boolean getIsColdBiome() {
		return (this.getBiomeTemp() <= 3F) || (this.getBodyForBiome().getIsColdBody());
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
	 * @return The Body to apply this biome to.
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
	 * Returns the actual temperature of the Body, taking biome temp into
	 * account.
	 * 
	 * @return The current temperature of the Body.
	 */
	public float getBodyTemp() {
		IZollernBody planet = this.getBodyForBiome();
		
		float biomeTemp = this.getBiomeTemp();
		Random rand = new Random();
		
		float planetTemp = planet.getBodyTemperature();
		float flucTemp = planetTemp;
		
		int tempChangeBy = (this.enableExtremeMode) ? 50 : 25;
		
		float maxTemp = planetTemp + tempChangeBy;
		float minTemp = planetTemp - tempChangeBy;
		
		if (planet.getIsColdBody()) {
			flucTemp -= biomeTemp;
		} else if (planet.getIsHotBody()) {
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