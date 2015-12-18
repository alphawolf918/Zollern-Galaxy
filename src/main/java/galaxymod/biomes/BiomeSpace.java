/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.biomes;

import galaxymod.core.PlanetNova;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeSpace extends BiomeGenBase {
	
	protected PlanetNova planetForBiome = null;
	public static int grassFoilageColorMultiplier = 0x00ff00;
	public static int chunkHeightModifier = 12;
	public static int biomeHeightBaseModifier = 232;
	
	public BiomeSpace(int par1) {
		super(par1);
	}
	
	public void setPlanetForBiome(PlanetNova planet) {
		this.planetForBiome = planet;
	}
	
	public PlanetNova getPlanetForBiome() {
		return this.planetForBiome;
	}
	
	public boolean getIsHotBiome() {
		return (this.temperature >= 7F);
	}
	
	public boolean getIsColdBiome() {
		return (this.temperature <= 3F);
	}
	
	public void setHeightBaseModifier(int bioHeight) {
		this.biomeHeightBaseModifier = bioHeight;
	}
	
	public int getHeightBaseModifier() {
		return this.biomeHeightBaseModifier;
	}
	
	public static void setChunkHeightModifier(int heightMod) {
		chunkHeightModifier = heightMod;
	}
	
	public static int getChunkHeightModifier() {
		return chunkHeightModifier;
	}
}