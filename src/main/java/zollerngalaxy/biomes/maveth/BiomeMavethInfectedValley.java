/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.maveth;

import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeMavethInfectedValley extends BiomeMavethBase {
	
	public BiomeMavethInfectedValley(BiomeProperties props) {
		super("maveth_infected_valley", props);
		props.setRainDisabled();
		props.setHeightVariation(0.0F);
		props.setTemperature(8.0F);
		props.setBaseHeight(4.0F);
		this.setBiomeHeight(4);
		this.setBiomeType(EnumBiomeTypeZG.INFECTED);
		this.setTemp(54.0F);
		this.biomeDecor.generateTallGrass = true;
		this.biomeDecor.tallGrassPerChunk = 14;
		this.enableSnow = false;
		this.topBlock = ZGBlocks.mavethInfectedGrass.getDefaultState();
		this.fillerBlock = ZGBlocks.mavethInfectedSoil.getDefaultState();
		this.stoneBlock = ZGBlocks.mavethStone;
	}
}