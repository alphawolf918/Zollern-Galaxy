/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.biomes;

import galaxymod.core.PlanetNova;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeSpace extends BiomeGenBase {
	
	protected PlanetNova planetForBiome = null;
	public static int grassFoilageColorMultiplier = 0x00ff00;
	public static int chunkHeightModifier = 12;
	public static int biomeHeightBaseModifier = 232;
	
	public BiomeSpace(int par1) {
		super(par1);
		this.setColor(BiomeList.biomeColor);
	}
	
	public BiomeSpace setPlanetForBiome(PlanetNova planet) {
		this.planetForBiome = planet;
		return this;
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
}