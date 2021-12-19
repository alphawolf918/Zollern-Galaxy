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

public class BiomeToci extends BiomeTociBase {
	
	public BiomeToci(BiomeProperties props) {
		super("toci_base", props);
		props.setRainDisabled();
		props.setTemperature(6.7F);
		this.setBiomeHeight(45);
		this.setBiomeType(EnumBiomeTypeZG.DESERT);
		this.setTemp(25.45F);
		this.enableSnow = false;
		this.topBlock = ZGBlocks.tociRock.getDefaultState();
		this.fillerBlock = ZGBlocks.tociGravel.getDefaultState();
		this.stoneBlock = ZGBlocks.tociStone;
		this.setPlanetForBiome(ZGPlanets.planetToci);
	}
}