/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.biomes;

import galaxymod.core.PlanetNG;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeSpace extends BiomeGenBase {
	
	protected PlanetNG planetForBiome = null;
	
	public BiomeSpace(int par1) {
		super(par1);
	}
	
	public void setPlanetForBiome(PlanetNG planet) {
		this.planetForBiome = planet;
	}
	
	public PlanetNG getPlanetForBiome() {
		return this.planetForBiome;
	}
}