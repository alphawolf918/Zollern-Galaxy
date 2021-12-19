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

public class BiomeTociDesert extends BiomeTociBase {
	
	public BiomeTociDesert(BiomeProperties props) {
		super("toci_desert", props);
		props.setRainDisabled();
		props.setTemperature(9.8F);
		this.setBiomeHeight(25);
		this.setBiomeType(EnumBiomeTypeZG.DESERT);
		this.setTemp(19.8F);
		this.enableSnow = false;
		this.topBlock = ZGBlocks.tociSand.getDefaultState();
		this.fillerBlock = ZGBlocks.tociStarSand.getDefaultState();
		this.stoneBlock = ZGBlocks.tociStone;
		this.setPlanetForBiome(ZGPlanets.planetToci);
	}
}