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

public class BiomeTociValley extends BiomeTociBase {
	
	public BiomeTociValley(BiomeProperties props) {
		super("toci_valley", props);
		props.setRainDisabled();
		props.setTemperature(5.0F);
		this.setBiomeHeight(5);
		this.setBiomeType(EnumBiomeTypeZG.DESERT);
		this.setTemp(10.0F);
		this.enableSnow = false;
		this.topBlock = ZGBlocks.tociDirt.getDefaultState();
		this.fillerBlock = ZGBlocks.tociRock.getDefaultState();
		this.stoneBlock = ZGBlocks.tociStone;
		this.setPlanetForBiome(ZGPlanets.planetToci);
	}
}