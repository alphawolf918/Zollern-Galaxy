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

public class BiomeTlalocConstructs extends BiomeTlalocBase {
	
	public BiomeTlalocConstructs(BiomeProperties props) {
		super("tlaloc_constructs", props);
		props.setRainDisabled();
		props.setTemperature(6.2F);
		this.setBiomeHeight(35);
		this.setBiomeType(EnumBiomeTypeZG.TECHY);
		this.setTemp(6.2F);
		this.enableSnow = false;
		this.topBlock = ZGBlocks.xantheonConstructBlock.getDefaultState();
		this.fillerBlock = ZGBlocks.tlalocMechRock.getDefaultState();
		this.stoneBlock = ZGBlocks.tlalocStone;
		this.setPlanetForBiome(ZGPlanets.planetTlaloc);
	}
}