/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.toci;

import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.celestial.ZGPlanets;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeTociMountains extends BiomeTociBase {
	
	public BiomeTociMountains(BiomeProperties props) {
		super("toci_mountains", props);
		props.setRainDisabled();
		props.setTemperature(6.7F);
		this.setBiomeHeight(35);
		this.setBiomeType(EnumBiomeTypeZG.DESERT);
		this.setTemp(0.1F);
		this.enableSnow = false;
		this.topBlock = ZGBlocks.tociStone.getDefaultState();
		this.fillerBlock = ZGBlocks.tociCobblestone.getDefaultState();
		this.stoneBlock = ZGBlocks.tociStone;
		this.setPlanetForBiome(ZGPlanets.planetToci);
	}
}