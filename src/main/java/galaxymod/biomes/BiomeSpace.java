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
import galaxymod.dimensions.providers.WorldProviderNova;
import galaxymod.utils.NovaHelper;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import org.apache.logging.log4j.Level;

public class BiomeSpace extends BiomeGenBase {
	
	protected PlanetNova planetForBiome = null;
	public static int grassFoilageColorMultiplier = 0x00ff00;
	public static int chunkHeightModifier = 12;
	public static int biomeHeightBaseModifier = 232;
	
	public BiomeSpace(int par1) {
		super(par1);
		this.setColor(BiomeList.biomeColor);
	}
	
	public boolean isBreathable() {
		PlanetNova biomePlanet = this.getPlanetForBiome();
		Class<? extends WorldProviderNova> provider = (Class<? extends WorldProviderNova>) biomePlanet
				.getWorldProvider();
		try {
			WorldProviderNova providerNova = provider.newInstance();
			return providerNova.hasBreathableAtmosphere();
		} catch (InstantiationException e) {
			NovaHelper.logMessage(
					"Error in creating new instance of Nova World Provider!",
					Level.FATAL);
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			NovaHelper.logMessage(
					"Nova World Provider was accessed illegally!", Level.FATAL);
			e.printStackTrace();
		}
		return false;
	}
	
	public BiomeSpace setPlanetForBiome(PlanetNova planet) {
		this.planetForBiome = planet;
		return this;
	}
	
	public PlanetNova getPlanetForBiome() {
		return this.planetForBiome;
	}
	
	public boolean getIsHotBiome() {
		return (this.getTemp() >= 7F);
	}
	
	public boolean getIsColdBiome() {
		return (this.getTemp() <= 3F);
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
	
	public BiomeSpace setTemp(float biomeTemp) {
		this.temperature = biomeTemp;
		return this;
	}
	
	public float getTemp() {
		return this.temperature;
	}
}