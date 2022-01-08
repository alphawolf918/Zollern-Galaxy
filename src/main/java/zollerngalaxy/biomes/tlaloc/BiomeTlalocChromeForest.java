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

public class BiomeTlalocChromeForest extends BiomeTlalocBase {
	
	public BiomeTlalocChromeForest(BiomeProperties props) {
		super("tlaloc_chrome_forest", props);
		props.setRainDisabled();
		props.setTemperature(8.2F);
		this.biomeDecor.mechTreesPerChunk = 10;
		this.setBiomeHeight(15);
		this.setBiomeType(EnumBiomeTypeZG.TECHY);
		this.setTemp(8.2F);
		this.enableSnow = false;
		this.topBlock = ZGBlocks.tlalocRock.getDefaultState();
		this.fillerBlock = ZGBlocks.tlalocChrome.getDefaultState();
		this.stoneBlock = ZGBlocks.tlalocStone;
		this.setPlanetForBiome(ZGPlanets.planetTlaloc);
	}
}