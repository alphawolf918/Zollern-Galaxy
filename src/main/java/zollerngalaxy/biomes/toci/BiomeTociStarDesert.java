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

public class BiomeTociStarDesert extends BiomeTociBase {
	
	public BiomeTociStarDesert(BiomeProperties props) {
		super("toci_star_desert", props);
		props.setRainDisabled();
		props.setTemperature(7.8F);
		this.setBiomeHeight(15);
		this.setBiomeType(EnumBiomeTypeZG.DESERT);
		this.setTemp(21.54F);
		this.enableSnow = false;
		this.topBlock = ZGBlocks.tociStarSand.getDefaultState();
		this.fillerBlock = ZGBlocks.tociSand.getDefaultState();
		this.stoneBlock = ZGBlocks.tociStone;
		this.setPlanetForBiome(ZGPlanets.planetToci);
	}
}