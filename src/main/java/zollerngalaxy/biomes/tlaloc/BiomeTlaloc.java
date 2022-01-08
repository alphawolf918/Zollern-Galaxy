/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.tlaloc;

import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.celestial.ZGPlanets;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeTlaloc extends BiomeTlalocBase {
	
	public BiomeTlaloc(BiomeProperties props) {
		super("tlaloc_base", props);
		props.setRainDisabled();
		props.setTemperature(4.2F);
		this.setBiomeHeight(65);
		this.setBiomeType(EnumBiomeTypeZG.TECHY);
		this.setTemp(5.45F);
		this.enableSnow = false;
		this.topBlock = ZGBlocks.tlalocRock.getDefaultState();
		this.fillerBlock = ZGBlocks.tlalocChrome.getDefaultState();
		this.stoneBlock = ZGBlocks.tlalocStone;
		this.setPlanetForBiome(ZGPlanets.planetTlaloc);
	}
}