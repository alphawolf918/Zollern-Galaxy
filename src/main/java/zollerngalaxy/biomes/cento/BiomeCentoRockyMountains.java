/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.cento;

import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.celestial.ZGPlanets;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeCentoRockyMountains extends BiomeCentoBase {
	
	public BiomeCentoRockyMountains(BiomeProperties props) {
		super("centotl_rocky_mountains", props);
		props.setRainDisabled();
		this.setBiomeHeight(55);
		this.setBiomeType(EnumBiomeTypeZG.ABANDONED);
		this.setTemp(6.5F);
		this.enableSnow = false;
		this.topBlock = ZGBlocks.centoStone.getDefaultState();
		this.fillerBlock = ZGBlocks.centoCobblestone.getDefaultState();
		this.stoneBlock = ZGBlocks.centoStone;
		this.setPlanetForBiome(ZGPlanets.planetCentotl);
	}
}